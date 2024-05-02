/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0109Event.java
 *@FileTitle : Office code history
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.13 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfcHisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0109HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
/*
	private String ofc_cd = null;

	public String getOfc_cd() {
		return ofc_cd;
	}

	public void setOfc_cd(String ofc_cd) {
		this.ofc_cd = ofc_cd;
	}
*/
	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemOfcHisVO gemOfcHisVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemOfcHisVO[] gemOfcHisVOs = null;

	public CpsGem0109Event() {
	}

	public GemOfcHisVO getGemOfcHisVO() {
		return gemOfcHisVO;
	}

	public void setGemOfcHisVO(GemOfcHisVO gemOfcHisVO) {
		this.gemOfcHisVO = gemOfcHisVO;
	}

	public GemOfcHisVO[] getGemOfcHisVOs() {
		return gemOfcHisVOs;
	}

	public void setGemOfcHisVOs(GemOfcHisVO[] gemOfcHisVOs) {
		this.gemOfcHisVOs = gemOfcHisVOs;
	}

}