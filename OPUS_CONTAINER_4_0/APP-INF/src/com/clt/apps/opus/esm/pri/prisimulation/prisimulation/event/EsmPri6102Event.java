/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6102Event.java
*@FileTitle : Apply Rate Info Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_PRI_6002HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri6102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 */
	private AplyRtInVO aplyRtInVO = null;
	String key = null;
	
	public EsmPri6102Event(){}

	public AplyRtInVO getAplyRtInVO() {
		return aplyRtInVO;
	}

	public void setAplyRtInVO(AplyRtInVO aplyRtInVO) {
		this.aplyRtInVO = aplyRtInVO;
	}
	
}
