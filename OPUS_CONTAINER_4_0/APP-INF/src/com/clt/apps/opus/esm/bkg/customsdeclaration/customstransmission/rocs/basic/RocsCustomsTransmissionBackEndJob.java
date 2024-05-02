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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestListTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBCImpl;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RocsCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private SignOnUserAccount account;
	private RocsManifestTransmitVO[] detailVOs;
	private String pgmNo;

	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setRocsManifestTransmitVO(RocsManifestTransmitVO[] detailVOs) {
		if (detailVOs != null)
			this.detailVOs = Arrays.copyOf(detailVOs, detailVOs.length);
	}

	/**
	 * 다운로드 할 데이터 세팅 0613화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
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
	 * BackEndCommand Start
	 * @return DBRowSet
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		if (pgmNo.startsWith("ESM_BKG_0061")) 
		{
			RocsCustomsTransmissionBC command = new RocsCustomsTransmissionBCImpl();
			RocsManifestListTransmitDetailVO rocsManifestListTransmitDetailVO = (RocsManifestListTransmitDetailVO)command.transmitManifestList((ManifestTransmitVO[])detailVOs, account);
			RocsManifestListDownloadBC maniCommand = new RocsManifestListDownloadBCImpl();
			maniCommand.modifyBlSndSts(rocsManifestListTransmitDetailVO.getRocsManifestTransmitVOs(), account);
		}
		return null;
	}
}