/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : VietnamCustomsTransmissionBackEndJob.java
 *@FileTitle : VietnamCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.24
 *@LastModifier : 조원주
 *@LastVersion : 1.0
 * 2012.08.24 조원주
 * 1.0 Creation
 * 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.basic;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see 
 * @since J2EE 1.4
 */
public class VietnamCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/** 
	 * 다운로드 할 데이터 세팅 1149화면.<br>
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs){
		if(manifestTransmitVOs != null){
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}
	
	/**
	 * @param SignOnUserAccount account
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
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
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public String doStart() throws Exception {
		CustomsTransmissionBC command = null;
		
		if (pgmNo.startsWith("ESM_BKG_1149") ) {
			command = new VietnamCustomsTransmissionBCImpl();
			return command.transmitManifest(manifestTransmitVOs, account);
		}
		
		return "Y";
	}
	
	
}
