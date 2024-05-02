/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDownloadBackEndBCImpl.java
*@FileTitle : KorManifestListDownloadBackEndBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 23.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 23. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBackEndBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDlContainerVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ManifestDownload Backend Job
 * @author 박상훈
 * @see ManifestListDownloadBackEndBCImpl
 * @since J2EE 1.6
 */
public class KorManifestListDownloadBackEndBCImpl extends ManifestListDownloadBackEndBCImpl {

	private SignOnUserAccount account;
	private String pgmNo;	
	private KorDlContainerVO korDlContainerVO;
	
	/**
	 * BackEndJob 처리 메소드
	 * @param String usrId 
	 * @return String
	 */
	public String startBackEndBC(String usrId) {
		
		KorManifestListDownloadBackEndJob korManifestListDownloadBackEndJob = new KorManifestListDownloadBackEndJob();
		
		korManifestListDownloadBackEndJob.setAccount(this.account);
		korManifestListDownloadBackEndJob.setKorDlContainerVO(this.korDlContainerVO);
		korManifestListDownloadBackEndJob.setPgmNo(this.pgmNo);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		return backEndJobManager.execute(korManifestListDownloadBackEndJob, usrId, "Manifest Download BackEnd Job!");
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
