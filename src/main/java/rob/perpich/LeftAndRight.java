package rob.perpich;

public class LeftAndRight {

    public static boolean isTransformable(String source, String destination) {
        if (source.length() != destination.length()) {
            return false;
        }

        int sourceIndex = 0;

        for (int destIndex = 0; destIndex < destination.length(); destIndex++) {
            char destChar = destination.charAt(destIndex);

            if (destChar == 'L') {
                int nextIndexOfL = findNextIndexOfL(source, sourceIndex);

                if (nextIndexOfL == -1) {
                    return false;
                }

                sourceIndex = nextIndexOfL + 1;
            } else if (destChar == 'R') {
                int leftMostIndexOfR = findLeftMostIndexOfR(source, sourceIndex, destIndex);

                if (leftMostIndexOfR == -1) {
                    return false;
                }

                sourceIndex = leftMostIndexOfR + 1;
            }
        }

        return true;
    }

    /*
    *  Find the next index of L in the source string starting from the given index. Return -1 if there are no
    *  more Ls in the source string or if we encounter an R
    */
    private static int findNextIndexOfL(String source, int startIndex) {
        for (int i = startIndex; i < source.length(); ++i) {
            char sourceChar = source.charAt(i);

            if (sourceChar == 'R') {
                return -1;
            } else if (sourceChar == 'L') {
                return i;
            }
        }

        return -1;
    }

    /*
    *  Search through the source String from startIndex (inclusive) to endIndex (inclusive) and return
    *  the smallest index (leftmost) of R characters encountered. Returns -1 if no Rs exist in the given
    *  range or if an L is encountered at any point in the given range
    */
    private static int findLeftMostIndexOfR(String source, int startIndex, int endIndex) {
        int leftMostIndexOfR = -1;

        for (int i = startIndex; i <= endIndex; ++i) {
            char sourceChar = source.charAt(i);

            if (sourceChar == 'L') {
                return -1;
            } else if (sourceChar == 'R' && leftMostIndexOfR == -1) {
                leftMostIndexOfR = i;
            }
        }

        return leftMostIndexOfR;
    }
}
