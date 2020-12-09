package utils.matchers;

import java.util.function.Supplier;

public class OperationUtils
{
    public static <T> boolean completesWithoutException(Supplier<T> supplier)
    {
        try
        {
            supplier.get();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
