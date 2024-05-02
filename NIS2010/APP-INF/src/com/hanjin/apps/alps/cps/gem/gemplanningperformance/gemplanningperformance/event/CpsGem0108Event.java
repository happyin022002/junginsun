/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0108Event.java
 *@FileTitle : Performance Inquiry_Additional
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.24 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerfInqVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0108] Performance Inquiry_Additional
 * CPS_GEM_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0108HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PerfInqVO perfInqVO = null;

	/**
	 * @return the perfInqVO
	 */
	public PerfInqVO getPerfInqVO() {
		return perfInqVO;
	}

	/**
	 * @param perfInqVO the perfInqVO to set
	 */
	public void setPerfInqVO(PerfInqVO perfInqVO) {
		this.perfInqVO = perfInqVO;
	}



}