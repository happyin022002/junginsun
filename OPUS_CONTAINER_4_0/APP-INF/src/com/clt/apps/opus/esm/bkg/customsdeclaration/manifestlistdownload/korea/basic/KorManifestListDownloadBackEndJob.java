/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDownloadBackEndJob.java
*@FileTitle : KorManifestListDownloadBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 23.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 23. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDlContainerVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * 한국세관 Manifest Download BackEndJob 처리
 *
 * @author 박상훈
 * @see
 * @since J2EE 1.4
 */
public class KorManifestListDownloadBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -7883158620336264244L;

	private SignOnUserAccount account;
	private String pgmNo;
	private KorDlContainerVO korDlContainerVO;

	/**
	 * BackEnd Job 처리 ( ManifestDownload )
	 *
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {

		// BL DOWNLOAD 처리
		if (this.pgmNo.equals("ESM_BKG_0329")) {
			// BC Impl 생성
			KorManifestListDownloadBC downBC = new KorManifestListDownloadBCImpl();
			// BC에 작업 요청
			downBC.downloadCstmsBlList(this.korDlContainerVO, this.account);
		}
		return null;
	}

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * @return the pgmNo
	 */
	public String getPgmNo() {
		return pgmNo;
	}

	/**
	 * @param pgmNo the pgmNo to set
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * @return the korDlContainerVO
	 */
	public KorDlContainerVO getKorDlContainerVO() {
		return korDlContainerVO;
	}

	/**
	 * @param korDlContainerVO the korDlContainerVO to set
	 */
	public void setKorDlContainerVO(KorDlContainerVO korDlContainerVO) {
		this.korDlContainerVO = korDlContainerVO;
	}

}
