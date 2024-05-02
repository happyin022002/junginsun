/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0016Event.java
 *@FileTitle : Slip Inquiry by Performance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.04 박창준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SlipPerformanceVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0016] Slip Inquiry by Performance
 * CPS_GEM_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0016HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0016Event extends EventSupport {

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

	
	private SlipPerformanceVO slipPerformanceVO = null;
	/**
	 * @return the slipPerformanceVO
	 */
	public SlipPerformanceVO getSlipPerformanceVO() {
		return slipPerformanceVO;
	}
	/**
	 * @param slipPerformanceVO the slipPerformanceVO to set
	 */
	public void setSlipPerformanceVO(SlipPerformanceVO slipPerformanceVO) {
		this.slipPerformanceVO = slipPerformanceVO;
	}
	
	private SlipPerformanceVO[] slipPerformanceVOs = null;
	/**
	 * @return the slipPerformanceVOs
	 */
	public SlipPerformanceVO[] getSlipPerformanceVOs() {
		return slipPerformanceVOs;
	}
	/**
	 * @param slipPerformanceVOs the slipPerformanceVOs to set
	 */
	public void setSlipPerformanceVOs(SlipPerformanceVO[] slipPerformanceVOs) {
		this.slipPerformanceVOs = slipPerformanceVOs;
	}

}