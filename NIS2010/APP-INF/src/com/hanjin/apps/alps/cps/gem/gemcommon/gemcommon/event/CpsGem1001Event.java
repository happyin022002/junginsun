/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem1001Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.event;


import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfCondVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CPS_GEM_0009HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM_1001] 실적관리
 * - CPS_GEM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_1001HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------
	/**
	 * 전표 실적,예산 데이타 정규화
	 */
	private SlipPerfCondVO slipPerfCondVO = null;

	public SlipPerfCondVO getSlipPerfCondVO() {
		return slipPerfCondVO;
	}

	public void setSlipPerfCondVO(SlipPerfCondVO slipPerfCondVO) {
		this.slipPerfCondVO = slipPerfCondVO;
	}
	// ----------------------------------------------------
	
	

}