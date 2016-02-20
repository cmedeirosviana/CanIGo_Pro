package swape.canigo_application.Login_screen;

public class Singleton
{
    private static Singleton instance;

    public String customVar;

    public static void initInstance()
    {
        if (instance == null)
        {
            // Create the instance
            instance = new Singleton();
        }
    }

    public static Singleton getInstance()
    {
        // Return the instance
        return instance;
    }

    private Singleton()
    {
        // Constructor hidden because this is a singleton
    }

    public void customSingletonMethod()
    {
        // Custom method
    }
}