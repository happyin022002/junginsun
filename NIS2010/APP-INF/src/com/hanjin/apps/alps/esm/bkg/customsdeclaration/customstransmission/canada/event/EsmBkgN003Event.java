/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : EsmBkgN003Event.java
 *@FileTitle : Canada Export: Amendment Transmit (AI) Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see ESM_BKG_N003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkgN003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO = null;
	private CstmsManifestAmendmentVO cstmsManifestAmendmentVO = null;
	private CstmsManifestAmendmentVO[] cstmsManifestAmendmentVOs = null;
	/** Transmit AI Value Object */
	private UsaManifestSearchDetailVO[] usaManifestSearchDetailVOS = null;	
	private String cntCd = null;
	private String aiDiv = "";
	
	public EsmBkgN003Event() {}

	public void setCstmsManifestAmendmentCondVO(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO) {
		this.cstmsManifestAmendmentCondVO = cstmsManifestAmendmentCondVO;
	}
	
	public void setCstmsManifestAmendmentVO(CstmsManifestAmendmentVO cstmsManifestAmendmentVO) {
		this.cstmsManifestAmendmentVO = cstmsManifestAmendmentVO;
	}
	public void setCstmsManifestAmendmentVOs(CstmsManifestAmendmentVO[] cstmsManifestAmendmentVOs){
		if(cstmsManifestAmendmentVOs != null){
			CstmsManifestAmendmentVO[] tmpVOs = Arrays.copyOf(cstmsManifestAmendmentVOs, cstmsManifestAmendmentVOs.length);
			this.cstmsManifestAmendmentVOs = tmpVOs;
		}
	}
	public CstmsManifestAmendmentCondVO getCstmsManifestAmendmentCondVO() {
		return cstmsManifestAmendmentCondVO;
	}

	public CstmsManifestAmendmentVO getCstmsManifestAmendmentVO() {
		return cstmsManifestAmendmentVO;
	}

	public CstmsManifestAmendmentVO[] getCstmsManifestAmendmentVOs() {
		CstmsManifestAmendmentVO[] rtnVOs = null;
		if (this.cstmsManifestAmendmentVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsManifestAmendmentVOs, cstmsManifestAmendmentVOs.length);
		}
		return rtnVOs;
	}

	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOS() {
		UsaManifestSearchDetailVO[] rtnVOs = null;
		if (this.usaManifestSearchDetailVOS != null) {
			rtnVOs = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
		}
		return rtnVOs;
	}
	public void setUsaManifestSearchDetailVOS(UsaManifestSearchDetailVO[] usaManifestSearchDetailVOS){
		if(usaManifestSearchDetailVOS != null){
			UsaManifestSearchDetailVO[] tmpVOs = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
			this.usaManifestSearchDetailVOS = tmpVOs;
		}
	}
	
	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getAiDiv() {
		return aiDiv;
	}

	public void setAiDiv(String aiDiv) {
		this.aiDiv = aiDiv;
	}
}