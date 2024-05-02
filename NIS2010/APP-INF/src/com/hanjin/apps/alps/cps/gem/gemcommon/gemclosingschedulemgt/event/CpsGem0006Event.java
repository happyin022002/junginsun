/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0006Event.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo.GemMonClzVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo.MonClzVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0006HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemMonClzVO gemMonClzVO = null;
	private MonClzVO monClzVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemMonClzVO[] gemMonClzVOs = null;
	private MonClzVO[] monClzVOs = null;

	public CpsGem0006Event() {
	}

	public GemMonClzVO getGemMonClzVO() {
		return gemMonClzVO;
	}

	public void setGemMonClzVO(GemMonClzVO gemMonClzVO) {
		this.gemMonClzVO = gemMonClzVO;
	}

	public MonClzVO getMonClzVO() {
		return monClzVO;
	}

	public void setMonClzVO(MonClzVO monClzVO) {
		this.monClzVO = monClzVO;
	}

	public GemMonClzVO[] getGemMonClzVOs() {
		return gemMonClzVOs;
	}

	public void setGemMonClzVOs(GemMonClzVO[] gemMonClzVOs) {
		this.gemMonClzVOs = gemMonClzVOs;
	}

	public MonClzVO[] getMonClzVOs() {
		return monClzVOs;
	}

	public void setMonClzVOs(MonClzVO[] monClzVOs) {
		this.monClzVOs = monClzVOs;
	}

}