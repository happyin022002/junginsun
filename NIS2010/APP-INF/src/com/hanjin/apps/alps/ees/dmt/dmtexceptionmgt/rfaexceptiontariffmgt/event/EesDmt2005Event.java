/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2005Event.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.30 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_dmt_2005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2005Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EesDmt2005Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */
	
	private RFAProgressVO rFAProgressVO = null;
	
	private BeforeExceptionVersionVO beforeExceptionVersionVO = null;
	
	private BeforeExceptionVO[] beforeExceptionVOS = null;
	
	private RFAExceptionCoverageVO[] rFAExceptionCoverageVOS = null;	
	
	private RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOS = null;
	
	public void setRFAProgressVO(RFAProgressVO rFAProgressVO) {
		this.rFAProgressVO = rFAProgressVO;
	}

	public void setBeforeExceptionVersionVO(BeforeExceptionVersionVO beforeExceptionVersionVO) {
		this.beforeExceptionVersionVO = beforeExceptionVersionVO;
	}
	
	public void setBeforeExceptionVOS(BeforeExceptionVO[] beforeExceptionVOS) {
		this.beforeExceptionVOS = beforeExceptionVOS;
	}
	
	public void setRFAExceptionCoverageVOS(RFAExceptionCoverageVO[] rFAExceptionCoverageVOS) {
		this.rFAExceptionCoverageVOS = rFAExceptionCoverageVOS;
	}
	
	public void setRFAExceptionRateAdjustVOS(RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOS) {
		this.rFAExceptionRateAdjustVOS = rFAExceptionRateAdjustVOS;
	}	

	public RFAProgressVO getRFAProgressVO() {
		return rFAProgressVO;
	}	
	
	public BeforeExceptionVersionVO getBeforeExceptionVersionVO() {
		return beforeExceptionVersionVO;
	}	
	
	public BeforeExceptionVO[] getBeforeExceptionVOS(){
		return beforeExceptionVOS;
	}
	
	public RFAExceptionCoverageVO[] getRFAExceptionCoverageVOS(){
		return rFAExceptionCoverageVOS;
	}	
	
	public RFAExceptionRateAdjustVO[] getRFAExceptionRateAdjustVOS(){
		return rFAExceptionRateAdjustVOS;
	}	
}
