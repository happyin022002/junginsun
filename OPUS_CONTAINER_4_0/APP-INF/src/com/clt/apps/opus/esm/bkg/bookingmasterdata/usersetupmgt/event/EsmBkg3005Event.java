/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0320Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.25 김경섭
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlESignatureVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0320 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0320HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0320HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg3005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String blEsigSeq;
	private String countryCode;
	private String eSignatureLastNm;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BlESignatureVO blESignatureVO = null;

	/** Table Value Object Multi Data 처리 */
	private BlESignatureVO[] blESignatureListVOs = null;

	public String getBlEsigSeq() {
		return blEsigSeq;
	}

	public void setBlEsigSeq(String blEsigSeq) {
		this.blEsigSeq = blEsigSeq;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void seteSignatureLastNm(String eSignatureLastNm) {
		this.eSignatureLastNm = eSignatureLastNm;
	}

	public BlESignatureVO getBlESignatureVO() {
		return blESignatureVO;
	}

	public String getESignatureLastNm() {
		return eSignatureLastNm;
	}

	public void setESignatureLastNm(String eSignatureLastNm) {
		this.eSignatureLastNm = eSignatureLastNm;
	}

	public String geteSignatureLastNm() {
		return eSignatureLastNm;
	}

	public void setBlESignatureVO(BlESignatureVO blESignatureVO) {
		this.blESignatureVO = blESignatureVO;
	}

//	public BlESignatureVO[] getBlESignatureListVOs() {
//		return blESignatureListVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BlESignatureVO[] getBlESignatureListVOs() {
		BlESignatureVO[] tmpVOs = null;
		if (this.blESignatureListVOs != null) {
			tmpVOs = new BlESignatureVO[blESignatureListVOs.length];
			System.arraycopy(blESignatureListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		

//	public void setBlESignatureListVOs(BlESignatureVO[] blESignatureListVOs) {
//		this.blESignatureListVOs = blESignatureListVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBlESignatureListVOs(BlESignatureVO[] blESignatureListVOs) {
		if (blESignatureListVOs != null) {
			BlESignatureVO[] tmpVOs = new BlESignatureVO[blESignatureListVOs.length];
			System.arraycopy(blESignatureListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blESignatureListVOs = tmpVOs;
		}		
	}		
}