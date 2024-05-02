/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : Eur24CustomsTransmissionBackEndJob.java
 *@FileTitle : Eur24CustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.01.26
 *@LastModifier : 박성진
 *@LastVersion : 1.0
 * 2011.01.26 박성진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecCondVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sung Jin
 * @see 
 * @since J2EE 1.4
 */
public class KrWharfageDecMgtBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private WhfDecCondVO whfDecCondVO = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 .<br>
	 * 
	 * @param WhfDecCondVO whfDecCondVO
	 */
	public void setWhfDecCondVO(WhfDecCondVO whfDecCondVO) {
		this.whfDecCondVO = whfDecCondVO;
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
	 * 화면ID세팅<br>
	 * 
	 * @param SignOnUserAccount account
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
		
		KrWharfageDecMgtBCImpl command = null;
		if (pgmNo.startsWith("ESM_BKG_0557") ) {	// KOR
			command = new KrWharfageDecMgtBCImpl();
			return command.interfaceWhfDec(whfDecCondVO, account);
		}
		
		return "Y";
	}
	
	
}
