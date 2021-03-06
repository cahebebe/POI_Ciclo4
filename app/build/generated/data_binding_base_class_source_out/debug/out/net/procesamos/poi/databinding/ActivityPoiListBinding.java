// Generated by view binder compiler. Do not edit!
package net.procesamos.poi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.procesamos.poi.R;

public final class ActivityPoiListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView poiDescription;

  @NonNull
  public final ImageView poiLogoLocation;

  @NonNull
  public final TextView poiName;

  @NonNull
  public final ImageView poiPicture;

  @NonNull
  public final TextView poiRate;

  @NonNull
  public final TextView poiTemperature;

  private ActivityPoiListBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView poiDescription, @NonNull ImageView poiLogoLocation,
      @NonNull TextView poiName, @NonNull ImageView poiPicture, @NonNull TextView poiRate,
      @NonNull TextView poiTemperature) {
    this.rootView = rootView;
    this.poiDescription = poiDescription;
    this.poiLogoLocation = poiLogoLocation;
    this.poiName = poiName;
    this.poiPicture = poiPicture;
    this.poiRate = poiRate;
    this.poiTemperature = poiTemperature;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPoiListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPoiListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_poi_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPoiListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.poiDescription;
      TextView poiDescription = ViewBindings.findChildViewById(rootView, id);
      if (poiDescription == null) {
        break missingId;
      }

      id = R.id.poiLogoLocation;
      ImageView poiLogoLocation = ViewBindings.findChildViewById(rootView, id);
      if (poiLogoLocation == null) {
        break missingId;
      }

      id = R.id.poiName;
      TextView poiName = ViewBindings.findChildViewById(rootView, id);
      if (poiName == null) {
        break missingId;
      }

      id = R.id.poiPicture;
      ImageView poiPicture = ViewBindings.findChildViewById(rootView, id);
      if (poiPicture == null) {
        break missingId;
      }

      id = R.id.poiRate;
      TextView poiRate = ViewBindings.findChildViewById(rootView, id);
      if (poiRate == null) {
        break missingId;
      }

      id = R.id.poiTemperature;
      TextView poiTemperature = ViewBindings.findChildViewById(rootView, id);
      if (poiTemperature == null) {
        break missingId;
      }

      return new ActivityPoiListBinding((ConstraintLayout) rootView, poiDescription,
          poiLogoLocation, poiName, poiPicture, poiRate, poiTemperature);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
