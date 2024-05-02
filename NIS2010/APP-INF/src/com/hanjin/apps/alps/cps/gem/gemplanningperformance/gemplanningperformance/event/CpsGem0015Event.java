/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0015Event.java
 *@FileTitle : Expense Vs Performance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.09 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RatioReasonVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0015] Expense Vs Performance
 * CPS_GEM_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0015HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RqstInfoVO rqstInfoVO = null;
	/**
	 * @return the rqstInfoVO
	 */
	public RqstInfoVO getRqstInfoVO() {
		return rqstInfoVO;
	}
	/**
	 * @param rqstInfoVO the rqstInfoVO to set
	 */
	public void setRqstInfoVO(RqstInfoVO rqstInfoVO) {
		this.rqstInfoVO = rqstInfoVO;
	}

	/**
	 * @return the rqstInfoVO
	 */
	
	
	private RqstInfoVO[] rqstInfoVOs = null;
	/**
	 * @return the rqstInfoVOs
	 */
	public RqstInfoVO[] getRqstInfoVOs() {
		return rqstInfoVOs;
	}
	/**
	 * @param rqstInfoVOs the rqstInfoVOs to set
	 */
	public void setRqstInfoVOs(RqstInfoVO[] rqstInfoVOs) {
		this.rqstInfoVOs = rqstInfoVOs;
	}

	/**
	 * @return the rqstInfoVOs
	 */
	
	private RatioReasonVO ratioReasonVO = null;
	/**
	 * @return the ratioReasonVO
	 */
	public RatioReasonVO getRatioReasonVO() {
		return ratioReasonVO;
	}
	/**
	 * @param ratioReasonVO the ratioReasonVO to set
	 */
	public void setRatioReasonVO(RatioReasonVO ratioReasonVO) {
		this.ratioReasonVO = ratioReasonVO;
	}
	
	private RatioReasonVO[] ratioReasonVOs = null;
	/**
	 * @return the ratioReasonVOs
	 */
	public RatioReasonVO[] getRatioReasonVOs() {
		return ratioReasonVOs;
	}
	/**
	 * @param ratioReasonVOs the ratioReasonVOs to set
	 */
	public void setRatioReasonVOs(RatioReasonVO[] ratioReasonVOs) {
		this.ratioReasonVOs = ratioReasonVOs;
	}

}