package requisite;

import java.util.List;

public record Course(int id, List<Integer> pre) {
}
