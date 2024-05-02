package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo;

import java.io.Serializable;

public class InPriQuotationRateAdjustSetVO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private InPriCommodityRouteVO inPriCommodityRouteVO = null;
	private InPriCommodityRouteVO[] inPriCommodityRouteVOS = null;
	
	private InPriLocationViaListVO inPriLocationViaListVO = null;
	private InPriLocationViaListVO[] inPriLocationViaListVOS = null;

	private InPriRateAdjustListVO inPriRateAdjustListVO = null;
	private InPriRateAdjustListVO[] inPriRateAdjustListVOS = null;
	
	public InPriCommodityRouteVO getInPriCommodityRouteVO() {
		return inPriCommodityRouteVO;
	}
	public InPriCommodityRouteVO[] getInPriCommodityRouteVOS() {
		return inPriCommodityRouteVOS;
	}

	
	public void setInPriCommodityRouteVO(InPriCommodityRouteVO inPriCommodityRouteVO) {
		this.inPriCommodityRouteVO = inPriCommodityRouteVO;
	}
	public void setInPriCommodityRouteVOS(InPriCommodityRouteVO[] inPriCommodityRouteVOS) {
		this.inPriCommodityRouteVOS = inPriCommodityRouteVOS;
	}
 
	public InPriLocationViaListVO getInPriLocationViaListVO() {
		return inPriLocationViaListVO;
	}
	public InPriLocationViaListVO[] getInPriLocationViaListVOS() {
		return inPriLocationViaListVOS;
	}

	
	public void setInPriLocationViaListVO(InPriLocationViaListVO inPriLocationViaListVO) {
		this.inPriLocationViaListVO = inPriLocationViaListVO;
	}
	public void setInPriLocationViaListVOS(InPriLocationViaListVO[] inPriLocationViaListVOS) {
		this.inPriLocationViaListVOS = inPriLocationViaListVOS;
	}

	
	public InPriRateAdjustListVO getInPriRateAdjustListVO() {
		return inPriRateAdjustListVO;
	}
	public InPriRateAdjustListVO[] getInPriRateAdjustListVOS() {
		return inPriRateAdjustListVOS;
	}

	
	public void setInPriRateAdjustListVO(InPriRateAdjustListVO inPriRateAdjustListVO) {
		this.inPriRateAdjustListVO = inPriRateAdjustListVO;
	}
	public void setInPriRateAdjustListVOS(InPriRateAdjustListVO[] inPriRateAdjustListVOS) {
		this.inPriRateAdjustListVOS = inPriRateAdjustListVOS;
	}

}
