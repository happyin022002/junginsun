/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1101Event.java
*@FileTitle : Copy Basic Tariff
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 1.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 7. 1. 김태균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-1101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1101HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1101Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private DmtTariffTypeVO dmtTariffTypeVO = null;
	
	private DmtTariffTypeVO[] dmtTariffTypeVOs = null;

	private ToDmtTariffTypeVO toDmtTariffTypeVO = null;
	
	private ToDmtTariffTypeVO[] toDmtTariffTypeVOs = null;

	public EesDmt1101Event() {}
	
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
	
	public ToDmtTariffTypeVO getToDmtTariffTypeVO() {
		return toDmtTariffTypeVO;
	}

	public ToDmtTariffTypeVO[] getToDmtTariffTypeVOs() {
		ToDmtTariffTypeVO[] tmpVOs = null;
		if (this.toDmtTariffTypeVOs != null) {
			tmpVOs = new ToDmtTariffTypeVO[toDmtTariffTypeVOs.length];
			System.arraycopy(toDmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
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

	public void setToDmtTariffTypeVO(ToDmtTariffTypeVO toDmtTariffTypeVO) {
		this.toDmtTariffTypeVO = toDmtTariffTypeVO;
	}

	public void setToDmtTariffTypeVOs(ToDmtTariffTypeVO[] toDmtTariffTypeVOs) {
		if (toDmtTariffTypeVOs != null) {
			ToDmtTariffTypeVO[] tmpVOs = new ToDmtTariffTypeVO[toDmtTariffTypeVOs.length];
			System.arraycopy(toDmtTariffTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.toDmtTariffTypeVOs = tmpVOs;
		}
	}
}
