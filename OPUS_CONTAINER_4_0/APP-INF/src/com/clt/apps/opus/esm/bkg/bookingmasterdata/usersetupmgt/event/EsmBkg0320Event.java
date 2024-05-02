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

import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0320 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0320HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0320HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0320Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgInternetAuthorityVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgInternetAuthorityVO[] infoVOs = null;
	
	
	public EsmBkg0320Event(){}
	
	public BkgInternetAuthorityVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BkgInternetAuthorityVO infoVO) {
		this.infoVO = infoVO;
	}

//	public BkgInternetAuthorityVO[] getInfoVOs() {
//		return infoVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgInternetAuthorityVO[] getInfoVOs() {
		BkgInternetAuthorityVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new BkgInternetAuthorityVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

//	public void setInfoVOs(BkgInternetAuthorityVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setInfoVOs(BkgInternetAuthorityVO[] infoVOs) {
		if (infoVOs != null) {
			BkgInternetAuthorityVO[] tmpVOs = new BkgInternetAuthorityVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}	

	private static final long serialVersionUID = 1L;
	
	
}