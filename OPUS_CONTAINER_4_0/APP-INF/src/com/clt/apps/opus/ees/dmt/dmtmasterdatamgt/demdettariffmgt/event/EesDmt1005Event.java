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
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		DmtTariffTypeVO[] tmpVOs = null;
		if (this.dmtTariffTypeVOs != null) {
			tmpVOs = new DmtTariffTypeVO[dmtTariffTypeVOs.length];
			System.arraycopy(dmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CommodityTariffVO getCommodityTariffVO() {
		return commodityTariffVO;
	}

	public CommodityTariffVO[] getCommodityTariffVOs() {
		CommodityTariffVO[] tmpVOs = null;
		if (this.commodityTariffVOs != null) {
			tmpVOs = new CommodityTariffVO[commodityTariffVOs.length];
			System.arraycopy(commodityTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		if (dmtTariffTypeVOs != null) {
			DmtTariffTypeVO[] tmpVOs = new DmtTariffTypeVO[dmtTariffTypeVOs.length];
			System.arraycopy(dmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtTariffTypeVOs = tmpVOs;
		}
	}

	public void setCommodityTariffVO(CommodityTariffVO commodityTariffVO) {
		this.commodityTariffVO = commodityTariffVO;
	}

	public void setCommodityTariffVOs(CommodityTariffVO[] commodityTariffVOs) {
		if (commodityTariffVOs != null) {
			CommodityTariffVO[] tmpVOs = new CommodityTariffVO[commodityTariffVOs.length];
			System.arraycopy(commodityTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.commodityTariffVOs = tmpVOs;
		}
	}


}
