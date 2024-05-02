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

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
		return dmtTariffTypeVOs;
	}
	
	public ToDmtTariffTypeVO getToDmtTariffTypeVO() {
		return toDmtTariffTypeVO;
	}

	public ToDmtTariffTypeVO[] getToDmtTariffTypeVOs() {
		return toDmtTariffTypeVOs;
	}
	
	public void setDmtTariffTypeVO(DmtTariffTypeVO dmtTariffTypeVO) {
		this.dmtTariffTypeVO = dmtTariffTypeVO;
	}

	public void setDmtTariffTypeVOs(DmtTariffTypeVO[] dmtTariffTypeVOs) {
		this.dmtTariffTypeVOs = dmtTariffTypeVOs;
	}

	public void setToDmtTariffTypeVO(ToDmtTariffTypeVO toDmtTariffTypeVO) {
		this.toDmtTariffTypeVO = toDmtTariffTypeVO;
	}

	public void setToDmtTariffTypeVOs(ToDmtTariffTypeVO[] toDmtTariffTypeVOs) {
		this.toDmtTariffTypeVOs = toDmtTariffTypeVOs;
	}
}
