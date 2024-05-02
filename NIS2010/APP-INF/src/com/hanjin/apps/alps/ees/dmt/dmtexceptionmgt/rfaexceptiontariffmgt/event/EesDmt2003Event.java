/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2003Event.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFACopyMstToBzcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_dmt_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */
	
	private RFAProgressVO rFAProgressVO = null;
	
	private BeforeExceptionDeleteVO beforeExceptionDeleteVO = null;
	
	private BeforeExceptionVersionVO beforeExceptionVersionVO = null;
	
	private BeforeExceptionVO[] beforeExceptionVOS = null;
	
	private RFAExceptionCoverageVO[] rFAExceptionCoverageVOS = null;	
	
	private RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOS = null;
	
	// 2017.06.07 Master RFA 의 유효한 상위버전 정보를 Basic RFA 에 Copy 하기 위해 사용됨.
	private RFACopyMstToBzcVO rFACopyMstToBzcVO = null;
	
	public EesDmt2003Event(){}
	
	public void setRFAProgressVO(RFAProgressVO rFAProgressVO) {
		this.rFAProgressVO = rFAProgressVO;
	}

	public void setBeforeExceptionDeleteVO(BeforeExceptionDeleteVO beforeExceptionDeleteVO) {
		this.beforeExceptionDeleteVO = beforeExceptionDeleteVO;
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
	
	public void setRFACopyMstToBzcVO(RFACopyMstToBzcVO rFACopyMstToBzcVO) {
		this.rFACopyMstToBzcVO = rFACopyMstToBzcVO;
	}	

	public RFAProgressVO getRFAProgressVO() {
		return rFAProgressVO;
	}	
	
	public BeforeExceptionDeleteVO getBeforeExceptionDeleteVO() {
		return beforeExceptionDeleteVO;
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
	
	public RFACopyMstToBzcVO getRFACopyMstToBzcVO(){
		return rFACopyMstToBzcVO;
	}	
}
