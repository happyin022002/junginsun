/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDownloadBackEndJob.java
*@FileTitle : Kor24ManifestListDownloadBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 23.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 23. 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DlContainerVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * 한국세관 Manifest Download BackEndJob 처리
 *
 * @author 박상훈
 * @see
 * @since J2EE 1.4
 */
public class Kor24ManifestListDownloadBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -7883158620336264244L;

	private SignOnUserAccount account;
	private String pgmNo;
	private Kor24DlContainerVO kor24DlContainerVO;

	/**
	 * BackEnd Job 처리 ( ManifestDownload )
	 *
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {

		// BL DOWNLOAD 처리
		if (this.pgmNo.equals("ESM_BKG_1329")) {
			// BC Impl 생성
			Kor24ManifestListDownloadBC downBC = new Kor24ManifestListDownloadBCImpl();
			// BC에 작업 요청
			downBC.downloadCstmsBlList(this.kor24DlContainerVO, this.account);
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
	 * @return the kor24DlContainerVO
	 */
	public Kor24DlContainerVO getKor24DlContainerVO() {
		return kor24DlContainerVO;
	}


	/**
	 * @param kor24DlContainerVO the kor24DlContainerVO to set
	 */
	public void setKor24DlContainerVO(Kor24DlContainerVO kor24DlContainerVO) {
		this.kor24DlContainerVO = kor24DlContainerVO;
	}

}
