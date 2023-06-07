package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  동시성 문제가 고려되지 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static으로 생성 되었기 때문에 MemberRepository가 아무리 많이 생성되도 하나만 사용됨.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤 : 왜냐면 지금 스프링 안쓰기 때문에 지금은 싱글톤
    private static final MemberRepository instance = new MemberRepository();

    // 얘로만 객체를 불러올수 있음.
    public static MemberRepository getInstance() {
        return instance;
    }

    // private로 생성자를 만들어서 객체 생성을 막음
    private MemberRepository(){
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void cleareStore() {
        store.clear();
    }

}
