package util.operation;

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

    public static <T> void ifException(RunnableEx supplier, Runnable handler)
    {
        try
        {
            supplier.run();
        }
        catch (Exception ex)
        {
            handler.run();
        }
    }
}
