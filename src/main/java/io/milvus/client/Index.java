package io.milvus.client;

import javax.annotation.Nonnull;

/**
 * Represents an index containing <code>indexType</code> and <code>nList</code>
 */
public class Index {
    private final IndexType indexType;
    private final int nList;

    /**
     * Builder for <code>Index</code>
     */
    public static class Builder {
        // Optional parameters - initialized to default values
        private IndexType indexType = IndexType.FLAT;
        private int nList = 16384;

        /**
         * Optional. Default to <code>IndexType.FLAT</code>
         * @param indexType a <code>IndexType</code> object
         * @return <code>Builder</code>
         */
        public Builder withIndexType(@Nonnull IndexType indexType) {
            this.indexType = indexType;
            return this;
        }

        /**
         * Optional. Default to 16384.
         * @param nList nList of the index
         * @return <code>Builder</code>
         */
        public Builder withNList(int nList) {
            this.nList = nList;
            return this;
        }

        public Index build() {
            return new Index(this);
        }
    }

    private Index(@Nonnull Builder builder) {
        this.indexType = builder.indexType;
        this.nList = builder.nList;
    }

    public IndexType getIndexType() {
        return indexType;
    }

    public int getNList() {
        return nList;
    }

    @Override
    public String toString() {
        return "Index {" +
                "indexType=" + indexType +
                ", nList=" + nList +
                '}';
    }
}
