/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem001401Event.java
 *@FileTitle : Requested expense Vs Approved expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.15 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0014_01] Requested expense Vs Approved expense
 * CPS_GEM_0014_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0014_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0014_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem001401Event extends EventSupport {

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


}