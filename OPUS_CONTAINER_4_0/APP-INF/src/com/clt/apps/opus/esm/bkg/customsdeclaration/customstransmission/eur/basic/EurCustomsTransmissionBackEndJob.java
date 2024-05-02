/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsTransmissionBackEndJob.java
 *@FileTitle : EurCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.15
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.10.15 경종윤
 * 1.0 Creation
 * --------------------------------------------------
 * History
 * 2011.11.21 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyoung Jong Yun
 * @see EurCustomsTransmissionBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("unused")
public class EurCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO manifestTransmitVO = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;
	private SignOnUserAccount account;


	/**
	 * 다운로드 할 데이터 세팅 0484화면.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
	
	/**
	 * 화면ID세팅<br>
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * session
	 * @param account
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public Object doStart() throws Exception {
		
		EurCustomsTransmissionBC command = new EurCustomsTransmissionBCImpl();
		String rtnVal = "";
		/*
		if (pgmNo.startsWith("ESM_BKG_0484") 
				|| pgmNo.startsWith("ESM_BKG_0257")) {	// Sitpro or CTA
			command = new EurCustomsTransmissionBCImpl();
			command.transmitManifest(manifestTransmitVO);
		}
		*/
		if(pgmNo.startsWith("ESM_BKG_0257")) { // CTA
			command.transmitManifest(manifestTransmitVOs, account);
		} else if(pgmNo.startsWith("ESM_BKG_0484")) {  // SITPRO || EDI Preview
			rtnVal = command.transmitManifest(manifestTransmitVOs);
			EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
			if (!"Y".equals(eurManifestTransmitVOs[0].getEdiPreview())) rtnVal = "";
		}
		
		return rtnVal;
	}

	/**
	 * @return the manifestTransmitVOs
	 */
	public ManifestTransmitVO[] getManifestTransmitVOs() {
		ManifestTransmitVO[] rtnVOs = null;
		if (manifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		return rtnVOs;
	}

	/**
	 * @param manifestTransmitVOs the manifestTransmitVOs to set
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null)
			this.manifestTransmitVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
	}
	

	
}