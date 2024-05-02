/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionBC.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCODMgtConditionVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCodInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodMailSendVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.BkgCodVO;

/**
 * OPUS-Bookingcorrection Business Logic Command Interface<br>
 * - OPUS-Bookingcorrection business logic Interface.<br>
 *
 * @author Choi Yeoung Hee
 * @see Esm_bkg_0157EventResponse reference
 * @since J2EE 1.6
 */

public interface CODCorrectionBC {

	/**
	 * COD status info retrieve<br>
	 * 
	 * @param CodStsInputVO codStsInputVO
	 * @return List<CodStsVO>
	 * @exception EventException
	 */
	public List<CodStsVO> searchCodStsList(CodStsInputVO codStsInputVO) throws EventException;
	
	/**
	 * cod_rqst_seq of bkg_cod retrieve.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO 
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchCodRqstSeq(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * booking status info retrieve for create cod request info.<br>
	 * 
	 * @param  String codRqstSeq
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @return CodVO
	 * @exception EventException
	 */
	public CodVO searchCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO)throws EventException;
	
	/**
	 * cod request history retrieve<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @param  String codRqstSeq
	 * @return List<CodHistoryVO>
	 * @exception EventException
	 */
	public List<CodHistoryVO>searchCodHistory (BkgBlNoVO bkgBlNoVO, String  codRqstSeq) throws EventException;
	
	/**
	 * cod request info create.<br>
     * 
	 * @param  CodVO codVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodRqst(CodVO codVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * cod request history manage.<br>
     * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodHistory(BkgBlNoVO bkgBlNoVO , String codRqstSeq,SignOnUserAccount account) throws EventException;
	
	/**
	 * COD request info modify<br>
     * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * COD request info remove<br>
     * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * COD info in saved OPF request approval.<br>
	 * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodApproval(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * cod request status modify.<br>
     * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param String codStatusCd
	 * @param String codRqstRsnCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodStatus(BkgBlNoVO bkgBlNoVO, String codRqstSeq,String codStatusCd,String codRqstRsnCd,SignOnUserAccount account) throws EventException;
	
	/**
	 *  approve Cod<br>
     *  
	 * @param CodAuthVO codAuthVo
	 * @param BkgCodCostVO[] bkgCodCostVOs
	 * @param String chgRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveCod(CodAuthVO codAuthVO,BkgCodCostVO[] bkgCodCostVOs,String chgRmk, SignOnUserAccount account) throws EventException;
	
	/**
	 * confirm Cod.<br>
     * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmCod (String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cod Rgn modify.<br>
	 *
	 * @param BkgCodVO bkgCodVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRgn(BkgCodVO bkgCodVO,SignOnUserAccount account)throws EventException;

	/**
	 * (ESM_BKG_156) Cod Request rehandling Port retrieve.<br>
	 * @author    Ryu DaeYoung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     CodAuthVO codAuthVO
	 * @param     SignOnUserAccount account
	 * @return    CodVO
	 * @exception EventException
	 */
	public CodVO searchRehandlingPort(BkgBlNoVO bkgBlNoVO, CodAuthVO codAuthVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cod request rehandling vvd retrieve.<br>
	 * 
	 * @param String bkgNo
	 * @param String codRqstSeq
	 * @return CodRehandlingInfoVO
	 * @throws EventException
	 */
	public CodRehandlingInfoVO searchRehandlingInfo(String bkgNo, String codRqstSeq) throws EventException;
	
	/**
	 * Cod request E-mail send .<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account) throws EventException;

	/**
	 * when cod split, dest route info retrieve..<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCodSplitRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws EventException;
	
	/**
	 * In situation g/w mail cod request, mail data retrieve..<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return PrnrCodRqstVO
	 * @throws EventException
	 */
	public PrnrCodRqstVO searchCodRqstEmlCtnt(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account )throws EventException;
	
	/**
	 * Retrieve EMAIL by RSO, LANE <br>
	 * 
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @exception EventException
	 */
	public List<BkgCodInfoVO> searchCODEmailsendList(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws EventException;

	/**
	 * Retrieve NEW,OLD POD CODE of BKG chosen<br>
	 * 
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @exception EventException
	 */
	public List<BkgCodInfoVO> searchCODNewOldPODCd(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws EventException;
	
	/**
	 * Retrieve COD Cntr for Email<br>
	 * 
	 * @param String BkgNo
	 * @param String cod_sts_cd
	 * @param String codRqstSeq
	 * @return CodVO
	 * @exception EventException
	 */
	public CodVO searchCODCntrforMail(String BkgNo, String cod_sts_cd, String codRqstSeq) throws EventException;
	
	/**
	 * Send email for COD<br>
	 * 
	 * @param CodMailSendVO codMailSendVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendCODEmail(CodMailSendVO codMailSendVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Search email for COD<br>
	 * 
	 * @param CodMailSendVO codMailSendVO
	 * @param SignOnUserAccount account
	 * @return CodMailSendVO
	 * @exception EventException
	 */
	public CodMailSendVO searchCODEmailInfo(CodMailSendVO codMailSendVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SCE COP updateBkgForBkgCod 메서드 호출 대상 여부 및 파라미터를 조회 한다.<br>
	 * POD, DEL 국가가 바뀌었을 때 COP 호출한다.
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCopForBkgCodParam(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * POD, DEL이 바뀌는 경우 auto C/A를 생성한다<br> 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @param String typeCd
	 * @throws EventException
	 */
	public void manageAutoCod(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String typeCd) throws EventException;
}

