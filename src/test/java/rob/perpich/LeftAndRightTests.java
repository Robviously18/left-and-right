package rob.perpich;

import org.junit.Assert;
import org.junit.Test;

public class LeftAndRightTests {

    @Test
    public void whenIsTransformableCalledWithEmptyStringsExpectTrue() {
        boolean result = LeftAndRight.isTransformable("", "");

        Assert.assertTrue(result);
    }

    @Test
    public void whenIsTransformableCalledWithDifferentSizedStringsExpectFalse() {
        boolean result = LeftAndRight.isTransformable("R__", "R_");

        Assert.assertFalse(result);
    }

    @Test
    public void whenIsTransformableCalledWithSameSingleCharacterStringsExpectTrue() {
        boolean result = LeftAndRight.isTransformable("R", "R");

        Assert.assertTrue(result);
    }

    @Test
    public void whenIsTransformableCalledWithDifferentSingleCharacterStringsExpectFalse() {
        boolean result = LeftAndRight.isTransformable("L", "R");

        Assert.assertFalse(result);
    }

    @Test
    public void whenIsTransformableCalledWithStringsWhereLeftMustCrossRightExpectFalse() {
        boolean result = LeftAndRight.isTransformable("LR", "RL");

        Assert.assertFalse(result);
    }

    @Test
    public void whenIsTransformableCalledWithValidStringsUsingUnderscoresMovingOnlyLeftExpectTrue() {
        boolean result = LeftAndRight.isTransformable("_LL", "LL_");

        Assert.assertTrue(result);
    }

    @Test
    public void whenIsTransformableCalledWithValidStringsUsingUnderscoresMovingLeftAndRightExpectTrue() {
        boolean result = LeftAndRight.isTransformable("_LR_", "L__R");

        Assert.assertTrue(result);
    }

    @Test
    public void whenIsTransformableCalledWithValidStringsWithMultipleLeftAndRightMovesExpectTrue() {
        boolean result = LeftAndRight.isTransformable("L_L__RR_LLR_", "LL____RRLL_R");

        Assert.assertTrue(result);
    }
}
