/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. */

package pt.webdetails.cdf.dd.render.layout;

import org.apache.commons.jxpath.JXPathContext;
import pt.webdetails.cdf.dd.util.XPathUtils;

public class CarouselItemRender extends DivRender
{

  public CarouselItemRender(JXPathContext context)
  {
    super(context);
  }

  public String renderClose()
  {
    return "</div></li>";
  }

  @Override
  public void processProperties()
  {

    super.processProperties();
    getPropertyBag().addId(getId());
    getPropertyBag().addClass("cdfCarouselItemContent");
  }

  @Override
  public String renderStart()
  {

    StringBuilder div = new StringBuilder();
    div.append("<li class='cdfCarouselItem'><div class='cdfCarouselItemTitle'>");
    div.append(getPropertyString("title"));
    div.append("</div><div  ");
    div.append(getPropertyBagString());
    div.append(">");

    return div.toString();
  }

  protected String getId()
  {
    String id = getPropertyString("name");
    return id.length() > 0 ? id : XPathUtils.getStringValue(getNode(), "id");
  }
}
