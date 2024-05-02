/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBC.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

 
import java.util.List;
import java.util.Vector;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgArrNtcCntrVO;
import com.clt.syscommon.common.table.BkgArrNtcDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;
import com.clt.syscommon.common.table.BkgCustTmpltVO;
import com.clt.syscommon.common.table.BkgIbCmdtCntcVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupVO;
import com.clt.syscommon.common.table.BkgIbCustCntcVO;
import com.clt.syscommon.common.table.BkgMdmCrCustVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;

/**
 *   ArrivalNoticeBC
 *   Inboundnoticemgt Business Logic Command Interface<br>
 * - Inboundnoticemgt business logic Interface<br>
 *
 * @author
 * @see EventResponse reference
 * @since J2EE 1.4
 */

public interface ArrivalNoticeBC {
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
     * retrieve Arrival Notice Form 
	 * @param String ofcCd
	 * @param String pod
	 * @param String agent
	 * @return ArrNtcWdVO
	 * @exception EventException
	 */
	public ArrNtcWdVO searchArrNtcForm(String ofcCd , String pod , String agent) throws EventException;
	/**
     * UI-BKG_0375 Arrival Notice Form Setup<br>
     * modify Arrival Notice Form Data
     * Modify the master and detail at the same time.
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param BkgArrNtcWdDtlVO[] arrNtcWdDtls
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String setupArrNtcForm(BkgArrNtcWdVO arrNtcWd, BkgArrNtcWdDtlVO[] arrNtcWdDtls, SignOnUserAccount account) throws EventException;
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * delete Arrival notice Form
	 * @param String ofcCd
	 * @param String podCd
	 * @param String agentCd
	 * @exception EventException
	 */
	public void removeArrNtcForm(String ofcCd, String podCd, String agentCd) throws EventException;
	
	/**
	 * [240-1]ESM_BKG_0240 retrieve event handling about Customer Main (MDM) Master<br>
	 * @param IntgCustSearchVO intgCustSearchVo
	 * @return IbCustCntcVO
	 * @exception EventException
	 */
	public IbCustCntcVO searchIntgCustCntcInfo (IntgCustSearchVO intgCustSearchVo ) throws EventException;
	
	/**
	 * ESM_BKG_0240 Customer Main Detail retrieve event handling<br>
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return List<IbCustCntcVO>
	 * @exception EventException
	 */
	public List<IbCustCntcVO> searchIntgCustCntcInfoByIB  (String custCntCd, String custSeq, String ofcCd) throws EventException;
	
	/**
	 * [0240] Save routines
	 * @param BkgIbCustCntcVO[] custCntc
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIntgCustCntcInfoByIB(BkgIbCustCntcVO[] custCntc, SignOnUserAccount account)
	throws EventException;
	/**
	 *  Integrated Customer Data Management(OB) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BkgCustTmpltVO>
	 * @exception EventException
	 */
	public List<BkgCustTmpltVO> searchIntgCustCntcInfoByOB  (String custCntCd, String custSeq) throws EventException;
	
	/**
	 *  Integrated Customer Data Management(Invoice) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq
	 * @return  List<BkgMdmCrCustVO>
	 * @exception EventException
	 */
	public List<BkgMdmCrCustVO> searchIntgCustCntcInfoByInvoice  (String custCntCd, String custSeq) throws EventException;
	/**
	 *  Integrated Customer Data Management(TRO) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq 
	 * @return List<BkgTroActCustVO> 
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchIntgCustCntcInfoByTRO  (String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Arrival Information [Arrival Date] retrieve
	 * [672-1]
	 * @param anSearch
	 * @return
	 * @exception EventException
	 */
	//public List<ArrNtcInfoListVO> searchArrNtcInfoList (ArrNtcSearchVO anSearch ) throws EventException;
	/**
	 * Arrival Information [Arrival Date] Paging retrieve
	 * [672-1]
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcInfoListVO> 
	 * @exception EventException
	 */
	public List<ArrNtcInfoListVO> searchArrNtcInfoList(ArrNtcSearchVO anSearch,SignOnUserAccount account) throws EventException;
	
	
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * return created Key at Background Job after starting Customer Code Validation
	 * @param ArrNtcSearchVO anSearch
	 * @return String backEndJobKey
	 * @exception EventException
	 */
	public String manageArrNtcCodeValidation(ArrNtcSearchVO anSearch) throws EventException;

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * retrieve  information corresponding to unmatch after Customer Code Validation
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcUnMatchCustList(ArrNtcSearchVO arrNtcSearch, SignOnUserAccount account) throws EventException;

	
	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * retrieve  information corresponding to unmatch after Customer Code Validation
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> 
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchManualValInfo(ArrNtcSearchVO anSearch, SignOnUserAccount account) throws EventException;
	
	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * retrieve  information corresponding to match after Customer Code Validation
	 * @param ArrNtcSearchVO anSearch
	 * @return List<CustCdValidationVO>
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcMatchCustList(ArrNtcSearchVO anSearch) throws EventException;
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * retrieve registered POD list at Arrival Notice Form 
	 * @param String ofcCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormPodList(String ofcCd) throws EventException;
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * retrieve registered Agent list at Arrival Notice Form 
	 * @param String ofcCd
	 * @param String podCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormAgentList(String ofcCd,String podCd) throws EventException;
	
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * update unmatched information after Customer Code Validation
     * create Arrival Notice master and Detail
     * @author
	 * @param CustCdEvaluationVO[] custCdEvaluationVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArrNtcUnMatchCust(CustCdEvaluationVO[] custCdEvaluationVos, SignOnUserAccount account) throws EventException;
	
	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * matched information changes unmatch after Customer Code Validation
     * delete Arrival Notice master and Detail
     * update Match information<br>
	 * @param CustCdEvaluationVO[] custCdEval
	 * @exception EventException
	 */
	public void cancelArrNtcCustCdVal(CustCdEvaluationVO[] custCdEval) throws EventException;
	
	/**
	 * BL Copy &amp; Customer Info Update<br>
	 * delete Arrival Notice Master and Arrival Notice Detail
	 * @author
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelArrNtcCustCdVal(String bkgNo) throws EventException;

	
	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * retrieve Customer Code Error Report 
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException;
	

	/**
     * UI-BKG-0001 Notice Sent History<br>
     * extract Inbound Arrival Notice information using Bkg Notice History
	 * @param BkgNtcSearchVO bkgNtcSearch
	 * @return List<NoticeVO>
	 * @exception EventException
	 */
	public List<NoticeVO> searchBkgNtcHis (BkgNtcSearchVO bkgNtcSearch) throws EventException;
	

	/**[0052]Arrival Notice Yard information retrieve
	 * @param String vvd
	 * @param String podCd
	 * @return List<MrnRtnYdVO>
	 * @exception EventException 
	 */
	public List<MrnRtnYdVO> searchArrNtcMrnRtnYd(String vvd, String podCd) throws EventException;    
	/**[0052]save MRN & Return yard information
	 * @param MrnRtnYdVO[] mrnRtnYdVOS
	 * @param SignOnUserAccount account 
	 * @exception EventException 
	 */
	public void setupArrNtcMrnRtnYd (MrnRtnYdVO[] mrnRtnYdVOS, SignOnUserAccount account) throws DAOException, Exception;
	/**
	 * [672-02]Customer information retrieve
	 * @param ArrNtcSearchVO search
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcCustListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustListVO> searchArrNtcCustList (ArrNtcSearchVO search, SignOnUserAccount account) throws EventException;
	/**
	 * [672-02]save Customer information
	 * @param ArrNtcCustListVO[] arrNtcCustListVOS
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public void modifyArrNtcCustList  (ArrNtcCustListVO[] arrNtcCustListVOS,SignOnUserAccount account) throws DAOException, Exception;
	
	/**[242] retrieve specific information by customer that receives ARRIVAL NOTICE
	 * @param String bkgNo
	 * @param String custTpCd
	 * @return List<ArrNtcCustRefVO>
	 * @exception EventException 
	 */
	public List<ArrNtcCustRefVO> searchArrNtcCustInfo(String bkgNo,
			String custTpCd) throws EventException;
	
	/**
     * UI-BKG-0764 Customer Data Management Update History<br>
	 * retrieve Inbount Customer information modification status
	 *  @author
	 *  @param  IbCustCntcHisVO ibCustCntcHis
	 *  @return List<IbCustCntcHisVO> ibCustCntcHis
	 *  @exception EventException
	 */
	public List<IbCustCntcHisVO> searchIntgCustCntcInfoHistory (IbCustCntcHisVO ibCustCntcHis) throws EventException;
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * retrieve
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author 
	 */
	public BkgArrNtcWdVO searchArrNtcBankAcct(String ofcCd) throws EventException;
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * modify 
	 * @param BkgArrNtcWdVO arrNtcBankAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void setupArrNtcBankAcct(BkgArrNtcWdVO bkgArrNtcWdVo, SignOnUserAccount account)throws EventException;
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * delete
	 * @param String ofcCd
	 * @exception EventException
	 * @author 
	 */
	public void removeArrNtcBankAcct(String ofcCd)throws EventException;
	
	/**
	 * [672-03]add Customer upload informatio
	 * @param BkgArrNtcDtlVO bkgArrNtcDtlVo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createArrNtcCustListbyUpload(BkgArrNtcDtlVO bkgArrNtcDtlVo, SignOnUserAccount account)
			throws DAOException, Exception;
	/**
	 * [672-03]Customer upload information retrieve
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @return List<ArrNtcCustUploadListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustUploadListVO> searchArrNtcCustListForUpload(ArrNtcSearchVO arrNtcSearchVo)
			throws EventException;
	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * retrieve
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author 
	 */
	public List<BkgArrNtcWdVO> searchArrNtcGrpForm(String ofcCd) throws EventException; 
	
	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * add, delete, modify
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void setupArrNtcGrpForm ( BkgArrNtcWdVO[] arrNtcWd ,SignOnUserAccount account )throws EventException;
	
	/**
	 * [0381] retrieve completed A/N History information
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo 
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException 
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendList(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * retrieve
	 * @param String ofcCd 
     * @param String custCd 
     * @param String custSeq
     * @param String custTpCd
     * @return List<BkgIbCmdtCntcVO>
	 * @exception EventException
	 * @author 
	 */
	public List<BkgIbCmdtCntcVO> searchCustCmdtCntcInfo( String ofcCd , String custCd , String custSeq, String custTpCd ) throws EventException;
	
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * add, delete, modify
	 * @param BkgIbCmdtCntcVO[] ibCmdtCntcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void manageCustCmdtCntcInfo( BkgIbCmdtCntcVO[] ibCmdtCntcs , SignOnUserAccount account ) throws EventException;
	
	/**
	 * [0381] Fax transmission
	 * @param ArrNtcSendListVO[] listVOS
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception DAOException 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByFax(ArrNtcSendListVO[] listVOS, SignOnUserAccount account)
			throws DAOException, Exception;

	/**
	 * [0381] E-Mail transmission
	 * @param ArrNtcSendListVO arrNtcSendListVo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByEmail(ArrNtcSendListVO arrNtcSendListVo, SignOnUserAccount account)
			throws DAOException, Exception;
	/**
	 * UI_BKG-0672-1
	 * save Arrival Notice (Arrival Information)
	 * @param BkgArrNtcVO[] vos
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void setupArrNtcInfoList(ArrNtcInfoListVO[] vos, SignOnUserAccount account)throws EventException;
	
	/** [0956] Hold Remark retrieve<br>
	 * @param String bkgNo
	 * @return List<BkgArrNtcCntrVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcCntrVO> searchArrNtcHldRmk(String bkgNo) throws EventException;
	/**
	 * [0956] save Hold Remark<br>
	 * @param BkgArrNtcCntrVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void setupArrNtcHldRmk(BkgArrNtcCntrVO[] bkgArrNtcCntrVos, SignOnUserAccount account)
			throws EventException;
	/** [0946] Group A/N Merge Pop-up retrieve
	 * Group A/N Merge Pop-up
	 * @param ArrNtcGrpSendListVO vo
	 * @return List<ArrNtcGrpSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcGrpSendListVO> searchArrNtcGrpSendList(ArrNtcGrpSendListVO vo) throws EventException;
	/**
	 * [243] AN Setup Screen_Arrival Info.
	 * retrieve entered letter and information by Grouped VVD / POD at Setup
	 * @param String ofcCd
	 * @param String podCd
	 * @param String formCd
	 * @param String agent
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception EventException 
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtl(String ofcCd, String podCd, String formCd,
			String agent) throws EventException;

	/**
	 * [0946] EMail Group Arrival Notice transmission
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vEmail
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpEml(ArrNtcGrpSendVO grpSendVO
			,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			, SignOnUserAccount account
			, Vector vEmail)
			throws EventException;
	/**
	 * [0946] fax Group Arrival Notice transmission
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vFaxNo
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpFax(ArrNtcGrpSendVO grpSendVO
			, ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			, SignOnUserAccount account
			, Vector vFaxNo)
			throws EventException;
	/**
	 * search MRD ID
	 * @param ArrNtcMrdSearchVO arrNtcMrdSearch
	 * @return ArrNtcMrdVO
	 * @exception DAOException
	 */
	public ArrNtcMrdVO searchArrNtcMrdId(ArrNtcMrdSearchVO arrNtcMrdSearch) throws EventException;

	/**
	 * 1099   Integrated Customer Data Update Setup retrieve
	 * @param String ofcCd
	 * @return BkgIbCustCntcStupVO
	 * @exception EventException
	 * @author 
	 */
	public BkgIbCustCntcStupVO searchIntgCustCntcUpdtStupInfoByOfc(String ofcCd) throws EventException;
	
	/**
	 * 1099   save Integrated Customer Data Update Setup 
	 * @param BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void manageIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo, SignOnUserAccount account)throws EventException;
		
	/**
     * save MDM Customer data for Customer Code Validation
	 * @param List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> mdmCustomerVOs)throws EventException;
	/**
	 * Back End Job 공통 - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;
	/**
	 * [ESM_BKG_0381] : 
	 *  Transmit - Back End Job 결과<br>
	 * Arrival Notice email 전송
	 *
	 * @param String backEndJobKey
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> resultBackEndJobSendArrivalNoticeEmail(String backEndJobKey) throws EventException;
	/**
	 * [ESM_BKG_0381] : A/N
	 *  Transmit - Back End Job 시작<br>
	 * Arrival Notice email 전송
	 *
	 * @param ArrNtcSendListVO[] listVOS
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 */
	public String startBackEndJobArrivalNoticeSendEmail(ArrNtcSendListVO[] listVOs, SignOnUserAccount signOnUserAccount) throws EventException;

}