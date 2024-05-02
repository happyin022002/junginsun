/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBC.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate :
*@LastModifier   :
*@LastVersion    :
* 2009.07.09
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgOutstandingVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBlStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBlStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCgoRlseVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgDoCntrVO;
import com.clt.syscommon.common.table.BkgDoFomVO;
import com.clt.syscommon.common.table.BkgDoHisVO;
import com.clt.syscommon.common.table.BkgDoRefVO;
import com.clt.syscommon.common.table.BkgDoVO;
import com.clt.syscommon.common.table.BkgEdoLogVO;
import com.clt.syscommon.common.table.BkgEuPinNoVO;
import com.clt.syscommon.common.table.BkgFullCntrRemarkVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;


/**
 * CargoReleaseOrderMgt Business Logic Basic Command interface<br>
 * CargoReleaseOrderMgt handling business transaction.<br>
 *
 * @author
 * @see ESM_BKG_1001EventResponse,FullReleaseOrderBC refer to each DAO class
 * @since J2EE 1.4
 */
public interface CargoReleaseOrderBC {

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 *  Handling retrieving event of FullReleaseOrder<br>
	 *
	 * @param usrNm
	 * @param usrRegNo
	 * @return KorDoAttorneyVO[] attorneys
	 * @exception EventException
	 */
	public List<KorDoAttorneyVO> searchKorDoCustList(String usrNm, String usrRegNo) throws EventException;

	/**
	 *  Handling retrieving event of Cargo Release Order<br>
	 *
	 * @param bkgNo
	 * @return EventResponse EsmBkg0711EventResponse
	 * @exception EventException
	 */
	public List<DoHisVO> searchDoHistory(String bkgNo) throws EventException;

	/**
	 *  Handling manage event of Cargo Release Order<br>
	 *
	 * @param KorDoAttorneyVO[] attorneys
	 * @param SignOnUserAccount account
	 * @return response EventResponse
	 * @exception EventException
	 */
	public int manageKorDoCust(KorDoAttorneyVO[] attorneys, SignOnUserAccount account) throws EventException;

	/**
	 *  Handling retrieving event of Cargo Release<br>
	 *
	 * @param String custType
	 * @param String custNm
	 * @param String custBizNo
	 * @return KorDoAttorneyDtlVO
	 * @exception EventException
	 */
	public List<KorDoAttorneyDtlVO> searchKorDoAttorneyList(String custType, String custNm, String custBizNo) throws EventException;


	/**
	 *  Handling manage event of Attorney Register Pop-up<br>
	 *
	 * @param KorDoAttorneyDtlVO[] attorneyDtls
	 * @param SignOnUserAccount account
	 * @return int ;
	 * @exception EventException
	 */
	public int manageKorDoAttorney(KorDoAttorneyDtlVO[] attorneyDtls, SignOnUserAccount account) throws EventException;

	/**
	 *  Handling retrieving event of Attorney Create Pop-up<br>
	 *
	 * @param String fmAttyBizNo
	 * @param String toAttyBizNo
	 * @return EventResponse EsmBkg0999EventResponse
	 * @exception EventException
	 */
	public String searchKorDoAttorneyDtl(String fmAttyBizNo, String toAttyBizNo) throws EventException;

	/**
	 * Target B/L for the D/O Release operations are performed.<br>
	 *
	 * @param KorDoRlseVO korDoRlse
	 * @exception EventException
	 * @author
	 */
	public void releaseKorDo(KorDoRlseVO korDoRlse) throws EventException;

	/**
	 *  Handling retrieving event of Korea D/O.<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return KorDoMstVO korDoMst
	 * @exception EventException
	 */
	public KorDoMstVO searchKorDo(String bkgNo, SignOnUserAccount account) throws EventException;

	/**
	 *  Handling manage event of Korea D/O.<br>
	 *
	 * @param KorDoSaveVO korDoSave
	 * @exception EventException
	 */
	public void manageKorDo(KorDoSaveVO korDoSave) throws EventException;

	/**
	 * D/O No Assign.<br>
	 * @param DoAsignVO doAsign
	 * @return String doNo
	 * @exception EventException
	 */
	public String assignDo(DoAsignVO doAsign) throws EventException;

	/**
	 * D/O Cancel <br>
	 *
	 * @param KorDoCancelVO korDoCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelKorDo(KorDoCancelVO korDoCancel) throws EventException;

	/**
	 * D/O Cancel <br>
	 *
	 * @param DoCancelVO doCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelDo(DoCancelVO doCancel) throws EventException;

	/**
	 * Cargo Release Order raised by the Event History for historical information should be recorded.<br>
	 *
	 * @param BkgDoHisVO bkgDoHis
	 * @exception EventException
	 */
	public void createDoHistory(BkgDoHisVO bkgDoHis) throws EventException;

	/**
	 * DO target B/L units to HOLD.<br>
	 * @param DoHoldVO doHold
	 * @exception EventException
	 */
	public void holdDo(DoHoldVO doHold) throws EventException;

	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoEdiTransVO[] edoEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByEdo(EdoEdiTransVO[] edoEdiTrans) throws EventException;

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param String rqstNo
	 * @param String ackInd
	 * @exception EventException
	 */
	public void receiptEdoRqstAck(String rqstNo, String ackInd) throws EventException;

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param EdoRqstVO edoRqst
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiptEdo(EdoRqstVO edoRqst, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param BkgEdoLogVO edoLog
	 * @exception EventException
	 */
	public void receiptEdoLog(BkgEdoLogVO edoLog) throws EventException;

	/**
	 * handling Cancel event<br>
	 *
	 * @param KorDoEdiTransVO korDoEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByKorDo(KorDoEdiTransVO korDoEdiTrans) throws EventException;

	/**
	 *  Retrieving Japan D/O <br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return JapDoMstVO japDoMst
	 * @exception EventException
	 */
	public JapDoMstVO searchJapDo(String bkgNo, SignOnUserAccount account) throws EventException;

	/**
	 * saving D/O information.
	 *
	 * @param JapDoSaveVO japDoSave
	 * @exception EventException
	 */
	public void manageJapDo(JapDoSaveVO japDoSave) throws EventException;

	/**
	 * Japan D/O target B/L for the D/O Assign & Issue task is performed.
	 *
	 * @param JapDoIssueVO japDoIssue
	 * @exception EventException
	 */
	public void issueJapDo(JapDoIssueVO japDoIssue) throws EventException;

	/**
	 *  D/O ID and its Detail information is transmitted to EDI.
	 *
	 * @param JapDorEdiTransVO japDorEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByJapDor(JapDorEdiTransVO japDorEdiTrans) throws EventException;

	/**
	 * cancel Japan Dor I/F
	 *
	 * @param JapDorEdiTransVO japDorEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByJapDorCancel(JapDorEdiTransVO japDorEdiTrans) throws EventException;

	/**
	 * update Japan Do Id<br>
	 *
	 * @param JapDorStatusVO japDorStatus
	 * @exception EventException
	 * @author
	 */
	public void modifyJapDoId(JapDorStatusVO japDorStatus)  throws EventException;

	/**
	 *  Handling retrieving event of Cargo Release Order<br>
	 *
	 * @param String office
	 * @return List<BkgDoFomVO>
	 * @exception EventException
	 */
	public List<BkgDoFomVO> searchDoForm(String office) throws EventException;

	/**
	 * delete event<br>
	 *
	 * @param String office
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDoForm(String office, SignOnUserAccount account  ) throws EventException;

	/**
	 *  Handling retrieving event of Cargo Release Order Office Default From Setup<br>
	 *
	 * @param BkgDoFomVO[] bkgDoFomVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account  ) throws EventException;

	/**
	 *  Handling retrieving event of Cargo Release Order_E-D/O inquiry _Main<br>
	 *
	 * @param EdoSearchVO edoSearch
	 * @return List<EdoRqstsVO>
	 * @exception EventException
	 */
	public List<EdoRqstsVO> searchEdoRqstList(EdoSearchVO edoSearch) throws EventException;

	/**
	 * delete event<br>
	 *
	 * @param EdoRqstsVO[] edoRqstsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeEdoErrData(EdoRqstsVO[] edoRqstsVO, SignOnUserAccount account  ) throws EventException;

	/**
	 *  Handling retrieving event of K-DO Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoByDoRqst(String rqstNo, String tpCd) throws EventException;

	/**
	 *  Handling retrieving event of D/O EDI Transmit Log List Inquiry<br>
	 *
	 * @param String rcvToDt
	 * @param String rcvFmDt
	 * @param String blNo
	 * @return List<BkgEdoLogVO>
	 * @exception EventException
	 */
	public List<BkgEdoLogVO> searchEdoTransLog(String rcvToDt, String rcvFmDt, String blNo) throws EventException;

	/**
	 *  Handling retrieving event of In-bond Transportation Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoByIbdTrspRqst(String rqstNo, String tpCd) throws EventException;

	/**
	 *  Handling retrieving event of Merchant Haulage Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoBySelfTrspRqst(String rqstNo, String tpCd) throws EventException;

	/**
	 *  Handling retrieving event of EU_Cargo Release Order의 D/O Receiver Setting<br>
	 *
	 * @param String doNo
	 * @param String doNoSplit
	 * @return EuDoRcvrVO euDoRcvrVO
	 * @exception EventException
	 */
	public EuDoRcvrVO searchEuDoRcvrInfo(String doNo, String doNoSplit) throws EventException;


	/**
	 *  Handling retrieving event of EU_Cargo Release Order의 D/O Receiver Setting <br>
	 *
	 * @param BkgDoVO[] bkgDoVO
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg0937EventResponse
	 * @exception EventException
	 */
	public void setupEuDoRcvrInfo(BkgDoVO[] bkgDoVO, SignOnUserAccount account  ) throws EventException;

	/**
	 *  Handling retrieving event of EU_Cargo Release Order D/O Receiver Setting<br>
	 *
	 * @param BkgDoCntrVO[] bkgDoCntrVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg0937EventResponse
	 * @exception EventException
	 */
	public void setupEuDoTruckerInfo(BkgDoCntrVO[] bkgDoCntrVOs, SignOnUserAccount account) throws EventException;

	/**
	 * send mail event<br>
	 *
	 * @param BkgDoVO[] bkgDo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> bkgNtcHisVOs
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendEuDoByEmail(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException;

	/**
	 * FAX send event<br>
	 *
	 * @param BkgDoVO[] bkgDo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> bkgNtcHisVOs
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendEuDoByFax(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException;

	/**
	 * 0938 retrieve event<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return EuDoMstVO euDoMst
	 * @exception EventException
	 */
	public EuDoMstVO searchEuDo(String bkgNo, SignOnUserAccount account) throws EventException;

	/**
	 * save D/O info.
	 *
	 * @param EuDoSaveVO euDoSave
	 * @exception EventException
	 */
	public void manageEuDo(EuDoSaveVO euDoSave) throws EventException;

	/**
	 * D/O Release<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntr
	 * @exception EventException
	 */
	public void releaseEuDo(EuDoRlseVO euDoRlse, DoCntrVO doCntr) throws EventException;

	/**
	 * cancel 0938 EU D/O<br>
	 *
	 * @param DoCancelVO doCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelEuDo(DoCancelVO doCancel) throws EventException;

	/**
	 * retrieving 1035 CY Delivery <br>
	 *
	 * @param String bkgNo
	 * @return BkgDoVO
	 * @exception EventException
	 * @author
	 */
	public BkgDoVO searchVetnamPrnCd(String bkgNo) throws EventException;

	/**
	 *  Handling manage event of CY Delivery <br>
	 *
	 * @param String doNo
	 * @param String doNoSplit
	 * @param String vnCgoDeCd
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg1035EventResponse
	 * @exception EventException
	 */
	public void setupVetnamPrnCd(String bkgNo, String rlseSeq, String vnCgoDeCd, String usrId) throws EventException;


	/**
	 *  Handling retrieving event of 0128<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return DoMstVO doMst
	 * @exception EventException
	 */
	public DoMstVO searchGenDo(String bkgNo, SignOnUserAccount account) throws EventException;

	/**
	 * saving 0128 D/O infomation.
	 *
	 * @param DoSaveVO doSave
	 * @exception EventException
	 */
	public void manageGenDo(DoSaveVO doSave) throws EventException;

	/**
	 * Target B / L for the D/O Release operations are performed.<br>
	 *
	 * @param DoRlseVO doRlse
	 * @param DoCntrVO doCntr
	 * @exception EventException
	 */
	public void releaseGenDo(DoRlseVO doRlse, DoCntrVO doCntr) throws EventException;

	/**
	 *  Handling retrieving event of 0292 <br>
	 *
	 * @param String bkgNo
	 * @return EventResponse EsmBkg0292EventResponse
	 * @exception EventException
	 */
	public DoMstVO searchDo(String bkgNo) throws EventException;

	/**
	 * 0292 Cargo Release Remark save event<br>
	 *
	 * @param BkgDoRefVO bkgDoRef
	 * @exception EventException
	 */
	public void manageDoHldRmk(BkgDoRefVO bkgDoRef) throws EventException;

	/**
	 * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * @param String doNo
	 * @param String doNoSplit
	 * @return DoRcvrVO
	 * @exception EventException
	 * @author
	 */
	public DoRcvrVO searchIdaDoRcvrInfo(String doNo, String doNoSplit) throws EventException;

	/**
	 * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * @param DoRcvrVO doRcvr
	 * @param SignOnUserAccount acount
	 * @exception EventException
	 * @author
	 */
	public void setupIdaDoRcvrInfo(DoRcvrVO doRcvr, SignOnUserAccount acount) throws EventException;

	/**
	 * UI-BKG-0694 - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
	 * @param JapDoHisSearchVO japDoHisSearch
	 * @return List<JapDoHisListVO>
	 * @exception EventException
	 * @author
	 */
	public List<JapDoHisListVO> searchJapDoHistory(JapDoHisSearchVO japDoHisSearch) throws EventException;

	/**
	 * UI-BKG-0131 Cargo Release Order List Check Report<br>
	 * @param DoCheckListSearchVO checkListSearch
	 * @return List<DoCheckListVO>
	 * @exception EventException
	 * @author
	 */
	public List<DoCheckListVO> searchDoCheckReport (DoCheckListSearchVO checkListSearch) throws EventException;

	/**
	 * UI-BKG-0939 India Cargo Release Order list Inquery<br>
	 * @param IdaDoRlseSearchVO idaDoRlseSearch
	 * @return IdaDoRlseReportVO
	 * @exception EventException
	 * @author
	 */
	public IdaDoRlseReportVO searchIdaDoRlseReport (IdaDoRlseSearchVO idaDoRlseSearch) throws EventException;

	/**
	 *  Handling retrieving event of India D/O<br>
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return IdaDoMstVO
	 * @exception EventException
	 * @author
	 */
	public IdaDoMstVO searchIdaDo(String bkgNo, SignOnUserAccount account) throws EventException;


	/**
	 * UI-BKG-0680 India Cargo Releass<br>
	 * @param IdaDoSaveVO idaDoSave
	 * @exception EventException
	 * @author
	 */
	public void manageIdaDo(IdaDoSaveVO idaDoSave) throws EventException;

	/**
	 * UI-BKG-0680 DO Release event<br>
	 * @param IdaDoRlseVO idaDoRlse
	 * @param DoCntrVO doCntrs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void releaseIdaDo(IdaDoRlseVO idaDoRlse, DoCntrVO doCntrs, SignOnUserAccount account) throws EventException;

	/**
	 * UI-BKG-0923 Inbound Cargo Release for POD Office_Popup History<br>
	 * @param String blNo
	 * @return List<UsCgoRlseHisVO>
	 * @exception EventException
	 * @author
	 */
	public List<UsCgoRlseHisVO> searchUsCgoRlseHis(String blNo) throws EventException;

	/**
	 * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	 * @param String doNo
	 * @param SignOnUserAccount account
	 * @return DoPrnRmkVO
	 * @exception EventException
	 * @author
	 */
	public List<DoPrnRmkVO> searchDoPrnRmk(String doNo, SignOnUserAccount account) throws EventException;

	/**
	 * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	 * @param DoPrnRmkVO doPrnRmkVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void modifyDoPrnRmk(DoPrnRmkVO doPrnRmkVO, SignOnUserAccount account) throws EventException;

	/**
	 * UI-BKG-0272 Full CNTR Release Order<br>
	 * @param FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch
	 * @return List<FullCntrRlseOrdVO>
	 * @exception EventException
	 * @author
	 */
	public List<FullCntrRlseOrdVO> searchFullCntrRlseOrderList(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch ) throws EventException;



	/**
	 * SendEmail<br>
	 * Full Container Order send mail<br>
	 * @param FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs
	 * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVOs
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendEmailFullCntrRlseOrder(FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs, FullCntrRlseOrdVO[] fullCntrRlseOrdVOs, BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account) throws EventException;


	/**
	 * Full Cargo Release Order EDI Transmit
	 * MQ Name
	 * [ESM_BKG_0272]
	 * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void transmitEdiFullCntrRlseOrder(FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs, BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Full Cargo Release Order Pin No Save
	 * MQ Name
	 * [ESM_BKG_0272]
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgEuPinNo(BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account) throws EventException;


	/**
	 * 1052 - Remark Save<br>
	 * @param BkgFullCntrRemarkVO bkgFullCntrRemarkVO
	 * @param SignOnUserAccount account
	 * @return int updateCount
	 * @exception EventException
	 */
	public int modifyFullCntrRlseRmk(BkgFullCntrRemarkVO bkgFullCntrRemarkVO, SignOnUserAccount account) throws EventException;

	/**
	 * Full Continer Release Order History<br>
	 * [ESM_BKG_0273]
	 * @param FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO
	 * @return List<FullCntrRlseOrderHisVO>
	 * @exception EventException
	 */
	public List<FullCntrRlseOrderHisVO> searchFullCntrRlseOrderHis(FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO) throws EventException;

	/**
	 * Retrieve - Pin Number History<br>
	 * [ESM_BKG_0271]
	 * @param BkgEuPinNoVO bkgEuPinNoSearchVO
	 * @return List<BkgEuPinNoVO>
	 * @exception EventException
	 */
	public List<BkgEuPinNoVO> searchBkgEuPinNoHis(BkgEuPinNoVO bkgEuPinNoSearchVO) throws EventException;


	/**
	 * [0130] : Retrieving Receiver Info <br>
	 * [ESM_BKG_0130]
	 * @param String doNo
	 * @return DoRcvrInfoVO
	 * @exception EventException
	 */
	public DoRcvrInfoVO searchDoRcvrInfo(String doNo) throws EventException;

	/**
	 * [0130] : Saving Receiver Info <br>
	 * [ESM_BKG_0130]
	 * @param DoRcvrInfoVO doRcvrInfoVO
	 * @param SignOnUserAccount account
	 * @return int Update Count
	 * @exception EventException
	 */
	public int setupDoRcvrInfo(DoRcvrInfoVO doRcvrInfoVO, SignOnUserAccount account) throws EventException;

	/**
	 * [0909] retrieving Inbound Cargo Release List
	 *
	 * @param UsCgoRlseSearchVO searchvo
	 * @return List<UsCgoRlseListVO>
	 * @exception EventException
	 */
	public List<UsCgoRlseListVO> searchUsCgoRlseList(UsCgoRlseSearchVO searchvo) throws EventException;

	/**
	 * [0909] retrieving B/L cntr No.
	 *
	 * @param String bkgNo
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchUsCgoRlseFoc(String bkgNo) throws EventException;


	/**
	 * [0909] handling Hold
	 *
	 * @param DoRefVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUsCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * [0909] save btn event
	 *
	 * @param BkgCgoRlseVO bkgCgoRlseVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUsCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException;

	/**
	 * [0909] handling Cargo Release
	 *
	 * @param OblRdemVO oblRdem
	 * @exception Exception
	 */
	public void setupFocByObl(OblRdemVO oblRdem) throws Exception;

	/**
	 * [0909]handling Cargo Release
	 *
	 * @param FrtCltLstVO frtCltLst
	 * @exception Exception
	 */
	public void setupFocByFreight(FrtCltLstVO frtCltLst) throws Exception;

	/**
	 * [0909] handling Cargo Release
	 * @param CstmsClrVO cstmsClr
	 * @exception Exception
	 */
	public void setupFocByCstms(CstmsClrVO cstmsClr) throws Exception;

	/**
	 * [0909] ERP I / F EAIDAO calls for
	 *
	 * @param String blNo
	 * @return OtsRcvInfoVO
	 * @exception EventException
	 */
	public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException;


	/**
	 * retrieving cntr by bkg_no
	 *
	 * @param String bkgNo
	 * @return String[] Container No List
	 * @exception EventException
	 */
	public String[] searchDemDetCntrList(String bkgNo) throws EventException;

	/**
	 * Original Bill of Lading Status
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return List<UsCgoRlseBlStatusVO>
	 * @throws EventException
	 */
	public List<UsCgoRlseBlStatusVO> searchUsCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException;


	/**
	 * [0909] handling Cargo Release
	 * @param OblRdemVO[] oblRdems
	 * @throws Exception
	 */
	public void setupFocByOblAutoBdr(OblRdemVO[] oblRdems) throws Exception;

	/**
	 * [0909] Partial
	 *
	 * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
	 * @return  UsCgoRlseBkbcBlVO
	 * @exception EventException
	 */
	public UsCgoRlseBkbcBlVO searchPrtlBl(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws EventException;

	/**
	 * [0128] dubai<br>
	 *
	 * @param DubaiCstmsVO[] dubaiCstms
	 * @exception EventException
	 */
	public void modifyDubaiCstmsRefNo(DubaiCstmsVO[] dubaiCstms) throws EventException;


	/**
	 * UI-BKG-0272 Full CNTR Release Order<br>
	 * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
	 * @param SignOnUserAccount account
	 * @return FullCntrRlseOrderMailVO
	 * @exception EventException
	 * @author
	 */
	public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtnt(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account ) throws EventException;

	/**
	 * Retrieve event handling<br>
	 * Cargo Release Order_E-D / O inquiry _Main viewed on-screen event handling by the shipping<br>
	 *
	 * @param EdoSearchVO edoSearch
	 * @return List<EdoRqstsVO>
	 * @exception EventException
	 */
	public List<EdoCntrRqstsVO> searchEdoCntrRqstList(EdoSearchVO edoSearch) throws EventException;

	/**
	 * IDA D / O Release handles to delete history
	 *
	 * @param IdaDoCancelVO idaDoCancelVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelIdaDo(IdaDoCancelVO  idaDoCancelVo, SignOnUserAccount account) throws EventException;

	 /**
		* US cargo release배치로 돌아 freight 상태 업데이트 쳐주는 함수
		*
		* @param BkgOutstandingVO ots
		* @exception Exception
		*/
	public void searchOtsUsCgo(BkgOutstandingVO ots) throws Exception;

	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 시작]<br>
	 * transmit Customer information Flat File as EDI
	 * 
	 * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	 * @param SignOnUserAccount account
	 * @return 
	 * @throws EventException
	 */
	public String startBackEndJobSendBlTdc315EdiMulti(BkgCgoRlseVO[] bkgCgoRlseVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 결과]<br>
	 * transmit Customer information Flat File as EDI
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobSendBlTdc315EdiMulti(String backEndJobKey) throws EventException;

	/**
	 * [1167] Canada Cargo Release에 대한 List를 Item별로 조회한다.
	 * @param searchvo
	 * @return
	 * @exception EventException
	 */
	public List<CaCgoRlseListVO> searchCaCgoRlseList(CaCgoRlseSearchVO searchvo) throws EventException;

	/**
	 * ESM_BKG_1167 FOC 정보를조회한다.
	 * @param bkgNo
	 * @return
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchCaCgoRlseFoc(String bkgNo) throws EventException;


	/**
	 * ESM_BKG_1167 Partial 정보가져오기
	 *
	 * @param CaCgoRlseBkbcBlVO caCgoRlseBkbc
	 * @return  CaCgoRlseBkbcBlVO
	 * @exception EventException
	 */
	public CaCgoRlseBkbcBlVO searchCaPrtlBl(CaCgoRlseBkbcBlVO caCgoRlseBkbc) throws EventException;

	/**
	 * ESM_BKG_1167 BL Status 조회
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return List<CaCgoRlseBlStatusVO>
	 * @throws EventException
	 */
	public List<CaCgoRlseBlStatusVO> searchCaCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_1167 F.O.C 변경 내역 저장
	 * @param BkgCgoRlseVO bkgCgoRlseVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCaCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_1167 상태 수정
	 * @param DoRefVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCaCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_1167 : Multi TDC315 - Complete IVC click [Back End Job 시작]<br>
	 * transmit Customer information Flat File as EDI (For Canada)
	 * 
	 * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobSendCaBlTdc315EdiMulti(BkgCgoRlseVO[] bkgCgoRlseVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_1167 : Multi TDC315 - Complete IVC click [Back End Job 결과]<br>
	 * transmit Customer information Flat File as EDI (For Canada)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobSendCaBlTdc315EdiMulti(String backEndJobKey) throws EventException;
	/**
	 * ESM_BKG_0938 Container 단위로 hold<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntr
	 * @exception EventException
	 */
	public void holdbyCntr(EuDoRlseVO euDoRlse, DoCntrVO doCntr) throws EventException;
	/**
	 * ESM_BKG_0938 Container 단위로 hold remove<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntr
	 * @exception EventException
	 */
	public void holdRemovalbyCntr(EuDoRlseVO euDoRlse, DoCntrVO doCntr) throws EventException;

}