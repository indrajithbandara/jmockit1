package mockit.external.asm;

import javax.annotation.*;

import static mockit.external.asm.Item.Type.*;

final class HandleItem extends Item
{
   private Handle handle;

   HandleItem(@Nonnegative int index) {
      super(index);
      type = HANDLE_BASE;
   }

   HandleItem(@Nonnegative int index, @Nonnull HandleItem item) {
      super(index, item);
      handle = item.handle;
   }

   /**
    * Sets the tag and field/method descriptor of this handle item.
    */
   void set(@Nonnull Handle handle) {
      this.handle = handle;
      type = HANDLE_BASE;
      setHashCode(handle.hashCode());
      type = HANDLE_BASE + handle.tag;
   }

   @Override
   boolean isEqualTo(@Nonnull Item item) {
      return ((HandleItem) item).handle.equals(handle);
   }
}
