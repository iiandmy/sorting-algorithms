package by.budevich.comparator;

import java.util.Comparator;

public interface RepoBasedComparator<T> extends Comparator<T> {
    /**
     * Takes the values from repository, represented in particular order in the list,
     * and compares given objects' indices.<br>
     * Comparing rule is: The less the index, the greater the value.<br>
     * In addition to original rules, listed in Comparator's method,
     * Implementator must ensure that the return value, when unknown value provided, equals:<br>
     * - Positive integer in case, when o1 - unknown value in repo, o2 - known value in repo;<br>
     * - Zero in case, when o1 - unknown value in repo, o2 - unknown value in repo;<br>
     * - Negative integer or less in case, when o1 - known value in repo, o2 - unknown value in repo;
     * @return positive integer - when index of o1's value is greater than index of o2's value;<br>
     *         zero - when index of o1's value equals index of o2's value;<br>
     *         negative integer - when index of o1's value is less than index of o2's value;
     */
    int compare(T o1, T o2);
}
