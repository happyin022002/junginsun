/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
**@LastVersion : 1.0
* 2009.07.10 김승민
* * 1.0 Creation
* -------------------------------------------------------
* History
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
* 2012.10.30 채창호 [CHM-201220810][BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
* 2015.07.06 이한나 :: 소스보안 [CWE-496, 766]으로 수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TerminalCllVO;
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

public class CLLCDLManifestBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	private KorCllCdlCondVO korCllCdlCondVO;
	private CllCdlTransmitVO[] cllCdlTransmitVOs;
	private TerminalCllVO[] terminalCllVOs;
	private String pgmNo = "";
	private SignOnUserAccount account;
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setKorCllCdlCondVO(KorCllCdlCondVO korCllCdlCondVO) {
		this.korCllCdlCondVO = korCllCdlCondVO;
	}
	
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setCllCdlTransmitVOs(CllCdlTransmitVO[] cllCdlTransmitVOs){
		if(cllCdlTransmitVOs != null){
			CllCdlTransmitVO[] tmpVOs = Arrays.copyOf(cllCdlTransmitVOs, cllCdlTransmitVOs.length);
			this.cllCdlTransmitVOs = tmpVOs;
		}
	}	
	
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setTerminalCllVOs(TerminalCllVO[] terminalCllVOs){
		if(terminalCllVOs != null){
			TerminalCllVO[] tmpVOs = Arrays.copyOf(terminalCllVOs, terminalCllVOs.length);
			this.terminalCllVOs = tmpVOs;
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
	 * @return KorCllCdlDetailContainerVO
	 * @throws Exception
	 */
	public KorCllCdlDetailContainerVO doStart() throws Exception {
		KorCllCdlDetailContainerVO korCllCdlDetailContainerVO = new KorCllCdlDetailContainerVO();
		String resultMessage = "";
		try {

			
			if (pgmNo.equals("ESM_BKG_0159"))
			{
				CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
				command.manageCllForDownload(terminalCllVOs, account);
			} else if (pgmNo.equals("ESM_BKG_0723"))
			{
				CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
//				command.transmitCllCdl(cllCdlTransmitVOs, account);
				resultMessage = command.transmitCllCdlGate(cllCdlTransmitVOs, account);
				korCllCdlDetailContainerVO.setReturnMessage(resultMessage);
			} else if (pgmNo.equals("ESM_BKG_0159_SEARCH"))
			{
				CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
				korCllCdlDetailContainerVO = command.searchKorCllCdl(korCllCdlCondVO);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return korCllCdlDetailContainerVO;	
	}
}
