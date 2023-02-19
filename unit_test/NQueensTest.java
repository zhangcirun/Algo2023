import Go2023.NQueens;
import org.junit.Assert;
import org.junit.Test;

public class NQueensTest {
    NQueens nQueens = new NQueens();

    @Test
    public void totalNQueensFour() {
        Assert.assertEquals(2, nQueens.totalNQueens(4));
    }

    @Test
    public void totalNQueensFive() {
        Assert.assertEquals(10, nQueens.totalNQueens(5));
    }

    @Test
    public void totalNQueensTen() {
        Assert.assertEquals(724, nQueens.totalNQueens(10));
    }
}
