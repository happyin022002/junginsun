/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdiSendJapDorBackEndJob.java
 *@FileTitle : EdiSendJapDorBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
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
public class EdiSendJapDorBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private JapDorEdiTransVO[] japDorEdiTransVOs = null;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 0127화면.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 */
	public void setManifestTransmitVOs(JapDorEdiTransVO[] japDorEdiTransVOs) {
		this.japDorEdiTransVOs = japDorEdiTransVOs;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}



	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public String doStart() throws Exception {
		
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        if(japDorEdiTransVOs != null && japDorEdiTransVOs.length > 0){
        	
        	int size = japDorEdiTransVOs.length;
        	for (int i = 0; i < size; i++) {
        		command.transmitEdiByJapDor(japDorEdiTransVOs[i]);
			}
        	
        }		
		
		return "Y";
	}

	public JapDorEdiTransVO[] getJapDorEdiTransVOs() {
		return japDorEdiTransVOs;
	}

	public void setJapDorEdiTransVOs(JapDorEdiTransVO[] japDorEdiTransVOs) {
		this.japDorEdiTransVOs = japDorEdiTransVOs;
	}
	
	
}
