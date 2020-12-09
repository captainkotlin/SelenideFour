package util.asserts;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EqualityAssert<T>
{
    private final T a;
    private final T b;
    private Integer actuaDifference = null;
    private Integer expectedDifference = null;

    public EqualityAssert(T a, T b)
    {
        this.a = a;
        this.b = b;
    }

    public EqualityAssert(T a, T b, Integer actualDifference)
    {
        this(a, b);
        this.actuaDifference = actualDifference;
    }

    public EqualityAssert(T a, T b, Integer actualDifference, Integer expectedDifference)
    {
        this(a, b);
        this.actuaDifference = actualDifference;
        this.expectedDifference = expectedDifference;
    }

    public <M> EqualityAssert<M> withMapper(Function<T, M> mapper)
    {
        return new EqualityAssert<>(mapper.apply(a), mapper.apply(b));
    }

    public EqualityAssert<T> withSubtractor(BiFunction<T, T, Integer> mapper)
    {
        var difference = Math.abs(mapper.apply(a, b));
        return new EqualityAssert<T>(a, b, difference);
    }

    public EqualityAssert<T> withExpectedDifference(Integer expectedDifference)
    {
        return new EqualityAssert<>(a, b, actuaDifference, expectedDifference);
    }

    public void check()
    {
        if (actuaDifference > expectedDifference)
        {
            throw new AssertionError("Difference = " + actuaDifference +
                    " between " + a + " and " + b +
                    " should be no more than " + expectedDifference);
        }
    }
}
