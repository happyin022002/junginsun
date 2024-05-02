/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestBackEndJob.java.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier : 이신원
**@LastVersion : 1.0
* 2013.11.15 이신원
* 1.0 Creation
* 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Terminaldocumentation Business Logic Command Interface<br>
 * - ALPS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse 참조
 * @since J2EE 1.6
 */ 
 
public class PSAManifestBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	private PsaImpStsVO[] psaImpStsVOs;
	private String pgmNo = "";
	private SignOnUserAccount account;
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param austrailiaManifestTransmitVOs
	 * @param account
	 */
	public void setPsaImpStsVOs(PsaImpStsVO[] psaImpStsVOs){
		if(psaImpStsVOs != null){
			PsaImpStsVO[] tmpVOs = Arrays.copyOf(psaImpStsVOs, psaImpStsVOs.length);
			this.psaImpStsVOs = tmpVOs;
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
	 * 다운로드 할 데이터 세팅 0613화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}		

	/**
	 * BackEndCommand Start
	 * @return Null
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		try {
			if (pgmNo.startsWith("ESM_BKG_0420"))
			{
				PSAManifestBC command = new PSAManifestBCImpl();
				command.managePSAImpSts(psaImpStsVOs);
			} 
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;	
	}
}

