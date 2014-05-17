package robomuss.rc.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTransitionTrack extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Side_1;
    ModelRenderer Side_2;
    ModelRenderer Side_3;
    ModelRenderer Side_4;
    ModelRenderer Part_4;
    ModelRenderer Part_3;
    ModelRenderer Part_2;
    ModelRenderer Part_1;
    ModelRenderer Top_1;
    ModelRenderer Top_2;
    ModelRenderer Side_5;
    ModelRenderer Part_5;
    ModelRenderer Part_6;
    ModelRenderer Part_7;
    ModelRenderer Part_8;
    ModelRenderer Side_6;
    ModelRenderer Side_7;
    ModelRenderer Side_8;
    ModelRenderer Base_Slope;
    ModelRenderer Side_Slope_1;
    ModelRenderer Side_Slope_2;
  
  public ModelTransitionTrack()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 12, 3, 4);
      Base.setRotationPoint(-4F, 21F, -2F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Side_1 = new ModelRenderer(this, 0, 0);
      Side_1.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_1.setRotationPoint(-7F, 18.5F, -5F);
      Side_1.setTextureSize(64, 32);
      Side_1.mirror = true;
      setRotation(Side_1, 0F, 0F, 0F);
      Side_2 = new ModelRenderer(this, 0, 0);
      Side_2.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_2.setRotationPoint(-3F, 19.5F, -5F);
      Side_2.setTextureSize(64, 32);
      Side_2.mirror = true;
      setRotation(Side_2, 0F, 0F, 0F);
      Side_3 = new ModelRenderer(this, 0, 0);
      Side_3.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_3.setRotationPoint(1F, 19.5F, -5F);
      Side_3.setTextureSize(64, 32);
      Side_3.mirror = true;
      setRotation(Side_3, 0F, 0F, 0F);
      Side_4 = new ModelRenderer(this, 0, 0);
      Side_4.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_4.setRotationPoint(5F, 19.5F, -5F);
      Side_4.setTextureSize(64, 32);
      Side_4.mirror = true;
      setRotation(Side_4, 0F, 0F, 0F);
      Part_4 = new ModelRenderer(this, 0, 0);
      Part_4.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_4.setRotationPoint(5F, 21.5F, -4F);
      Part_4.setTextureSize(64, 32);
      Part_4.mirror = true;
      setRotation(Part_4, 0F, 0F, 0F);
      Part_3 = new ModelRenderer(this, 0, 0);
      Part_3.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_3.setRotationPoint(1F, 21.5F, -4F);
      Part_3.setTextureSize(64, 32);
      Part_3.mirror = true;
      setRotation(Part_3, 0F, 0F, 0F);
      Part_2 = new ModelRenderer(this, 0, 0);
      Part_2.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_2.setRotationPoint(-3F, 21.5F, -4F);
      Part_2.setTextureSize(64, 32);
      Part_2.mirror = true;
      setRotation(Part_2, 0F, 0F, 0F);
      Part_1 = new ModelRenderer(this, 0, 0);
      Part_1.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_1.setRotationPoint(-7F, 20.5F, -4F);
      Part_1.setTextureSize(64, 32);
      Part_1.mirror = true;
      setRotation(Part_1, 0F, 0F, 0F);
      Top_1 = new ModelRenderer(this, 0, 0);
      Top_1.addBox(0F, 0F, 0F, 12, 2, 3);
      Top_1.setRotationPoint(-4F, 17.5F, -6.5F);
      Top_1.setTextureSize(64, 32);
      Top_1.mirror = true;
      setRotation(Top_1, 0F, 0F, 0F);
      Top_2 = new ModelRenderer(this, 0, 0);
      Top_2.addBox(0F, 0F, 0F, 12, 2, 3);
      Top_2.setRotationPoint(-4F, 17.5F, 3.5F);
      Top_2.setTextureSize(64, 32);
      Top_2.mirror = true;
      setRotation(Top_2, 0F, 0F, 0F);
      Side_5 = new ModelRenderer(this, 0, 0);
      Side_5.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_5.setRotationPoint(-7F, 18.5F, 4F);
      Side_5.setTextureSize(64, 32);
      Side_5.mirror = true;
      setRotation(Side_5, 0F, 0F, 0F);
      Part_5 = new ModelRenderer(this, 0, 0);
      Part_5.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_5.setRotationPoint(-7F, 20.5F, 2F);
      Part_5.setTextureSize(64, 32);
      Part_5.mirror = true;
      setRotation(Part_5, 0F, 0F, 0F);
      Part_6 = new ModelRenderer(this, 0, 0);
      Part_6.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_6.setRotationPoint(-3F, 21.5F, 2F);
      Part_6.setTextureSize(64, 32);
      Part_6.mirror = true;
      setRotation(Part_6, 0F, 0F, 0F);
      Part_7 = new ModelRenderer(this, 0, 0);
      Part_7.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_7.setRotationPoint(1F, 21.5F, 2F);
      Part_7.setTextureSize(64, 32);
      Part_7.mirror = true;
      setRotation(Part_7, 0F, 0F, 0F);
      Part_8 = new ModelRenderer(this, 0, 0);
      Part_8.addBox(0F, 0F, 0F, 1, 1, 2);
      Part_8.setRotationPoint(5F, 21.5F, 2F);
      Part_8.setTextureSize(64, 32);
      Part_8.mirror = true;
      setRotation(Part_8, 0F, 0F, 0F);
      Side_6 = new ModelRenderer(this, 0, 0);
      Side_6.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_6.setRotationPoint(-3F, 19.5F, 4F);
      Side_6.setTextureSize(64, 32);
      Side_6.mirror = true;
      setRotation(Side_6, 0F, 0F, 0F);
      Side_7 = new ModelRenderer(this, 0, 0);
      Side_7.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_7.setRotationPoint(1F, 19.5F, 4F);
      Side_7.setTextureSize(64, 32);
      Side_7.mirror = true;
      setRotation(Side_7, 0F, 0F, 0F);
      Side_8 = new ModelRenderer(this, 0, 0);
      Side_8.addBox(0F, 0F, 0F, 1, 3, 1);
      Side_8.setRotationPoint(5F, 19.5F, 4F);
      Side_8.setTextureSize(64, 32);
      Side_8.mirror = true;
      setRotation(Side_8, 0F, 0F, 0F);
      Base_Slope = new ModelRenderer(this, 0, 0);
      Base_Slope.addBox(0F, 0F, 0F, 6, 3, 4);
      Base_Slope.setRotationPoint(-8F, 19F, -2F);
      Base_Slope.setTextureSize(64, 32);
      Base_Slope.mirror = true;
      setRotation(Base_Slope, 0F, 0F, 0.5235988F);
      Side_Slope_1 = new ModelRenderer(this, 0, 0);
      Side_Slope_1.addBox(0F, 0F, 0F, 6, 2, 3);
      Side_Slope_1.setRotationPoint(-8F, 15.5F, -6.5F);
      Side_Slope_1.setTextureSize(64, 32);
      Side_Slope_1.mirror = true;
      setRotation(Side_Slope_1, 0F, 0F, 0.5235988F);
      Side_Slope_2 = new ModelRenderer(this, 0, 0);
      Side_Slope_2.addBox(0F, 0F, 0F, 6, 2, 3);
      Side_Slope_2.setRotationPoint(-8F, 15.5F, 3.5F);
      Side_Slope_2.setTextureSize(64, 32);
      Side_Slope_2.mirror = true;
      setRotation(Side_Slope_2, 0F, 0F, 0.5235988F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Side_1.render(f5);
    Side_2.render(f5);
    Side_3.render(f5);
    Side_4.render(f5);
    Part_4.render(f5);
    Part_3.render(f5);
    Part_2.render(f5);
    Part_1.render(f5);
    Top_1.render(f5);
    Top_2.render(f5);
    Side_5.render(f5);
    Part_5.render(f5);
    Part_6.render(f5);
    Part_7.render(f5);
    Part_8.render(f5);
    Side_6.render(f5);
    Side_7.render(f5);
    Side_8.render(f5);
    Base_Slope.render(f5);
    Side_Slope_1.render(f5);
    Side_Slope_2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
