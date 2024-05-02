/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1006Event.java
*@FileTitle : Commodity Exception Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.14 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-1006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1006HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CommodityTariffRegionParamVO commodityTariffRegionParamVO = null;

	private CommodityTariffRegionParamVO[] commodityTariffRegionParamVOs = null;
	
	private CommodityTariffRegionVO commodityTariffRegionVO = null;
	
	private CommodityTariffRegionVO[] commodityTariffRegionVOs = null;
	
	public EesDmt1006Event() {}

	public CommodityTariffRegionParamVO getCommodityTariffRegionParamVO() {
		return commodityTariffRegionParamVO;
	}

	public CommodityTariffRegionParamVO[] getCommodityTariffRegionParamVOs() {
		return commodityTariffRegionParamVOs;
	}

	public CommodityTariffRegionVO getCommodityTariffRegionVO() {
		return commodityTariffRegionVO;
	}

	public CommodityTariffRegionVO[] getCommodityTariffRegionVOs() {
		return commodityTariffRegionVOs;
	}

	public void setCommodityTariffRegionParamVO(CommodityTariffRegionParamVO commodityTariffRegionParamVO) {
		this.commodityTariffRegionParamVO = commodityTariffRegionParamVO;
	}

	public void setCommodityTariffRegionParamVOs(CommodityTariffRegionParamVO[] commodityTariffRegionParamVOs) {
		this.commodityTariffRegionParamVOs = commodityTariffRegionParamVOs;
	}

	public void setCommodityTariffRegionVO(CommodityTariffRegionVO commodityTariffRegionVO) {
		this.commodityTariffRegionVO = commodityTariffRegionVO;
	}

	public void setCommodityTariffRegionVOs(CommodityTariffRegionVO[] commodityTariffRegionVOs) {
		this.commodityTariffRegionVOs = commodityTariffRegionVOs;
	}

}
