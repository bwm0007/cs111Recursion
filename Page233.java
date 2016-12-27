public class Page233
{

    public static int sumArray(final in a[], int stPoint)
    {
	if (stPoint == a.length)
	    return 0;
	else return a[stPoint]+ sumArray(a,stPoint+1);
    }

    public static int sumArray2 (final int a[],int stPoint)
    {	if (stPoint == 0)
	    return a[0];
	else return a[stPoint]+ sumArray(a,stPoint-1);
    }
}
