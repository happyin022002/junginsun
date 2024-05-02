/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongCustomsTransmissionBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
**@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* 
* 2011.11.28 민정호 [CLT-111121274-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.basic;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
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
  
public class HongKongCustomsTransmissionBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	private HongKongManifestTransmitVO[] hongKongManifestTransmitVOs;
	private String pgmNo = "";
	private SignOnUserAccount account;
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param austrailiaManifestTransmitVOs
	 * @param account
	 */
	public void setHongKongManifestTransmitVOs(HongKongManifestTransmitVO[] hongKongManifestTransmitVOs){
		if(hongKongManifestTransmitVOs != null){
			HongKongManifestTransmitVO[] tmpVOs = Arrays.copyOf(hongKongManifestTransmitVOs, hongKongManifestTransmitVOs.length);
			this.hongKongManifestTransmitVOs = tmpVOs;
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
			if (pgmNo.startsWith("ESM_BKG_0282"))
			{
				CustomsTransmissionBC command = new HongKongCustomsTransmissionBCImpl();
				command.transmitManifest(hongKongManifestTransmitVOs, account);
			} 
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;	
	}
}

