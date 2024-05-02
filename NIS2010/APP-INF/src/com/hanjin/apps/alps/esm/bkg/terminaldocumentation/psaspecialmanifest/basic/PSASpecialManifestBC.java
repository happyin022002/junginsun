/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSASpecialManifestBC.java
*@FileTitle : Attorney Search Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.11 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgValidationCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAFeederNameVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-TerminalDocumentation Business Logic Command Interface<br>
 * - NIS2010-TerminalDocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyoung Jong Yun
 * @see
 * @since J2EE 1.4
 */
public interface PSASpecialManifestBC {


    /**
     *  수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
     * 
	 * @param  PSADgListCondVO psaDgListCondVO
     * @return List<PSADgListDetailVO>
     * @throws EventException
     */
	public List<PSADgListDetailVO> searchPsaDgManifestList(PSADgListCondVO psaDgListCondVO) throws EventException;

    /**
     * 위험물 Sent결과를 조회해 온다.<br>
     * 
     * @param  PSASendHistoryCondVO psaSendHistoryCondVO
     * @return List<PSASendHistoryDetailVO>
     * @throws EventException
     */
    public List<PSASendHistoryDetailVO> searchPsaSendHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException; 
    
	/**
	 * 구주위험물 세관신고 위해 FlatFile을 생성 및 전송
	 * 
	 * @param  PSADgEdiVO[] psaDgEdiVOs
	 * @param  account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> sendPsaDgManifestList(PSADgEdiVO[] psaDgEdiVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다. 
	 *  
	 * @param  String rcvMsg
	 * @param  String rcvGubun
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String rcvGubun) throws EventException;
    /**
     * PSA 수신 결과를 조회해 온다.<br>
     * 
     * @param  PSASendHistoryCondVO psaSendHistoryCondVO
     * @return List<PSASendHistoryDetailVO>
     * @throws EventException
     */
    public List<PSASendHistoryDetailVO> searchPsaReceiveHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException; 
    
}