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

import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceRailSplcVO;
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
public class EsdSce3306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String frmSplcCd		= null;
	private String frmSplcVndrNm	= null;
	private String frmYdCd			= null;
	
	private String fmLocCd			= null;
	private String fmYdCd			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceRailSplcVO sceRailSplcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SceRailSplcVO[] sceRailSplcVOs = null;
	
	public SceRailSplcVO getSceRailSplcVO() {
		return sceRailSplcVO;
	}

	public void setSceRailSplcVO(SceRailSplcVO sceRailSplcVO) {
		this.sceRailSplcVO = sceRailSplcVO;
	}

	public SceRailSplcVO[] getSceRailSplcVOs() {
		SceRailSplcVO[] rtnVOs = null;
		if (this.sceRailSplcVOs != null) {
			rtnVOs = Arrays.copyOf(sceRailSplcVOs, sceRailSplcVOs.length);
		}
		return rtnVOs;
	}

	public void setSceRailSplcVOs(SceRailSplcVO[] sceRailSplcVOs) {
		if(sceRailSplcVOs != null){
			SceRailSplcVO[] tmpVOs = Arrays.copyOf(sceRailSplcVOs, sceRailSplcVOs.length);
			this.sceRailSplcVOs = tmpVOs;
		}
	}

	public String getFrmSplcCd() {
		return frmSplcCd;
	}

	public void setFrmSplcCd(String frmSplcCd) {
		this.frmSplcCd = frmSplcCd;
	}

	public String getFrmSplcVndrNm() {
		return frmSplcVndrNm;
	}

	public void setFrmSplcVndrNm(String frmSplcVndrNm) {
		this.frmSplcVndrNm = frmSplcVndrNm;
	}

	public String getFrmYdCd() {
		return frmYdCd;
	}

	public void setFrmYdCd(String frmYdCd) {
		this.frmYdCd = frmYdCd;
	}

	public String getFmLocCd() {
		return fmLocCd;
	}

	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}

	public String getFmYdCd() {
		return fmYdCd;
	}

	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
}