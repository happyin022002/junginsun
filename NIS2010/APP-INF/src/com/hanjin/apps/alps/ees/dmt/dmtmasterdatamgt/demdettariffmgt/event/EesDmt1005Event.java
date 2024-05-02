/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1005Event.java
*@FileTitle : Commodity Exception Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.14 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-4014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-4014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-4014HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private DmtTariffTypeVO dmtTariffTypeVO = null;

	private DmtTariffTypeVO[] dmtTariffTypeVOs = null;
	
	private CommodityTariffVO commodityTariffVO = null;
	
	private CommodityTariffVO[] commodityTariffVOs = null;
	
	public EesDmt1005Event() {}

	public DmtTariffTypeVO getDmtTariffTypeVO() {
		return dmtTariffTypeVO;
	}

	public DmtTariffTypeVO[] getDmtTariffTypeVOs() {
		return dmtTariffTypeVOs;
	}

	public CommodityTariffVO getCommodityTariffVO() {
		return commodityTariffVO;
	}

	public CommodityTariffVO[] getCommodityTariffVOs() {
		return commodityTariffVOs;
	}

	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		this.dmtTariffTypeVOs = dmtTariffTypeVOs;
	}

	public void setCommodityTariffVO(CommodityTariffVO commodityTariffVO) {
		this.commodityTariffVO = commodityTariffVO;
	}

	public void setCommodityTariffVOs(CommodityTariffVO[] commodityTariffVOs) {
		this.commodityTariffVOs = commodityTariffVOs;
	}


}
