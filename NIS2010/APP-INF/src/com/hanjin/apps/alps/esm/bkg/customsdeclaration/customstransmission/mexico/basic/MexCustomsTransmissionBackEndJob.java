/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaCustomsTransmissionBackEndJob.java
 *@FileTitle : UsaCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.08.17 김도완
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.basic;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MexCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private MxManifestListByVvdDetailVO[] mxManifestListByVvdDetailVO;
	private String pgmNo;
	
	private SignOnUserAccount account = null;


	/**
	 * 다운로드 할 데이터 세팅 0613화면.
	 * 
	 * @param MxManifestListByVvdDetailVO[] mxManifestListByVvdDetailVO
	 */
	public void setManifestTransmitVO(MxManifestListByVvdDetailVO[] mxManifestListByVvdDetailVO){
		if(mxManifestListByVvdDetailVO != null){
			MxManifestListByVvdDetailVO[] tmpVOs = Arrays.copyOf(mxManifestListByVvdDetailVO, mxManifestListByVvdDetailVO.length);
			this.mxManifestListByVvdDetailVO = tmpVOs;
		}
	}
	
	/**
	 * 화면ID세팅
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
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
	 * BackEndCommand Start
	 * 
	 * @return DBRowSet
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		if (pgmNo.startsWith("ESM_BKG_0370"))
		{
			MexCustomsTransmissionBCImpl command = new MexCustomsTransmissionBCImpl();
			command.transmitManifest(mxManifestListByVvdDetailVO, account);
		}
		return null;
	}
}