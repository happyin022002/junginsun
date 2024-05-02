/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDownloadBackEndBCImpl.java
*@FileTitle : Kor24ManifestListDownloadBackEndBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 23.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 23. 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBackEndBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DlContainerVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ManifestDownload Backend Job
 * @author 박상훈
 * @see ManifestListDownloadBackEndBCImpl
 * @since J2EE 1.6
 */
public class Kor24ManifestListDownloadBackEndBCImpl extends ManifestListDownloadBackEndBCImpl {

	private SignOnUserAccount account;
	private String pgmNo;
	private Kor24DlContainerVO kor24DlContainerVO;

	/**
	 * BackEndJob 처리 메소드
	 * @param String usrId
	 * @return String
	 */
	public String startBackEndBC(String usrId) {

		Kor24ManifestListDownloadBackEndJob kor24ManifestListDownloadBackEndJob = new Kor24ManifestListDownloadBackEndJob();

		kor24ManifestListDownloadBackEndJob.setAccount(this.account);
		kor24ManifestListDownloadBackEndJob.setKor24DlContainerVO(this.kor24DlContainerVO);
		kor24ManifestListDownloadBackEndJob.setPgmNo(this.pgmNo);

		BackEndJobManager backEndJobManager = new BackEndJobManager();

		return backEndJobManager.execute(kor24ManifestListDownloadBackEndJob, usrId, "Manifest Download BackEnd Job!");
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
