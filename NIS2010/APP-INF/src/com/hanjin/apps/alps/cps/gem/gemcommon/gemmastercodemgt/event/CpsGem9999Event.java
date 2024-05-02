/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem9999Event.java
 *@FileTitle : Log in Office Change Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.08
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.07 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemCngOfcVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_9999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_9999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_9999HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem9999Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemCngOfcVO gemCngOfcVO = null;
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemCngOfcVO[] gemCngOfcVOs = null;
	private OfficeMgtVO[] officeMgtVOs = null;

	public CpsGem9999Event() {
	}

	public GemCngOfcVO getGemCngOfcVO() {
		return gemCngOfcVO;
	}

	public void setGemCngOfcVO(GemCngOfcVO gemCngOfcVO) {
		this.gemCngOfcVO = gemCngOfcVO;
	}

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public GemCngOfcVO[] getGemCngOfcVOs() {
		return gemCngOfcVOs;
	}

	public void setGemCngOfcVOs(GemCngOfcVO[] gemCngOfcVOs) {
		this.gemCngOfcVOs = gemCngOfcVOs;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}

}