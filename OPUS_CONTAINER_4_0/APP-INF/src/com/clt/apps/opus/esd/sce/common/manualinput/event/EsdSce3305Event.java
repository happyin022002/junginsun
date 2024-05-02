/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TmpStd0001Event.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.09 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.ESM_BKG_2003HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YoungHeon Lee
 * @see ESM_BKG_2003HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdSce3305Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String fmCntrTpszCd	= null;
	private String fmCntCd			= null;
	private String fmLocCd			= null;
	private String fmRgnCd			= null;
	private String fmYdCd			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SceCopCntrRepoRuleVO[] sceCopCntrRepoRuleVOs = null;
	
	public SceCopCntrRepoRuleVO getSceCopCntrRepoRuleVO() {
		return sceCopCntrRepoRuleVO;
	}

	public void setSceCopCntrRepoRuleVO(SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO) {
		this.sceCopCntrRepoRuleVO = sceCopCntrRepoRuleVO;
	}

	public SceCopCntrRepoRuleVO[] getSceCopCntrRepoRuleVOs() {
		SceCopCntrRepoRuleVO[] rtnVOs = null;
		if (this.sceCopCntrRepoRuleVOs != null) {
			rtnVOs = Arrays.copyOf(sceCopCntrRepoRuleVOs, sceCopCntrRepoRuleVOs.length);
		}
		return rtnVOs;
	}

	public void setSceCopCntrRepoRuleVOs(SceCopCntrRepoRuleVO[] sceCopCntrRepoRuleVOs) {
		if(sceCopCntrRepoRuleVOs != null){
			SceCopCntrRepoRuleVO[] tmpVOs = Arrays.copyOf(sceCopCntrRepoRuleVOs, sceCopCntrRepoRuleVOs.length);
			this.sceCopCntrRepoRuleVOs = tmpVOs;
		}
	}

	public String getFmCntrTpszCd() {
		return fmCntrTpszCd;
	}

	public void setFmCntrTpszCd(String fmCntrTpszCd) {
		this.fmCntrTpszCd = fmCntrTpszCd;
	}

	public String getFmCntCd() {
		return fmCntCd;
	}

	public void setFmCntCd(String fmCntCd) {
		this.fmCntCd = fmCntCd;
	}

	public String getFmLocCd() {
		return fmLocCd;
	}

	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}

	public String getFmRgnCd() {
		return fmRgnCd;
	}

	public void setFmRgnCd(String fmRgnCd) {
		this.fmRgnCd = fmRgnCd;
	}

	public String getFmYdCd() {
		return fmYdCd;
	}

	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
}