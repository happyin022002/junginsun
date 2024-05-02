/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableAgentBC.java
 *@FileTitle : AccountReceivableAgentBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.04
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivableagent.AccountReceivableAgentSC;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInfoByOfcAgnVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInquiryListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAnoListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckASAperiodVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckPreASAStausVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ManageAgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.UnreportedOtsReportVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAsaDtlVO;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarAsaNoSeqVO;

/**
 * Agent Business Logic Command implementation<br>
 * 
 * @author
 * @see AccountReceivableAgentSC
 * @since J2EE 1.4
 */
public interface AccountReceivableAgentBC {
	/**
	 * ASA NO Pop up 화면<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_0200
	 * @category searchASAnoList
	 * @param String asa_no
	 * @param String asa_ofc_cd
	 * @param String flag_cd
	 * @return List<ASAnoListVO>
	 * @throws EventException
	 */
	public List<ASAnoListVO> searchASAnoList(String asa_no, String asa_ofc_cd, String flag_cd) throws EventException;

	/**
	 * Agent Collection Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5005
	 * @category searchAgentCollectionListInquiry
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @param SignOnUserAccount account
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	public List<AgentCollectionListVO> searchAgentCollectionList(AgentCollectionListVO agentCollectionListVO,SignOnUserAccount account) throws EventException;

	/**
	 * Agent Collection Entry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5001
	 * @category searchAgentCollectionList
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	public List<AgentCollectionListVO> searchAgentCollectionListFOREntry(AgentCollectionListVO agentCollectionListVO) throws EventException;
		
	/**
	 * Agent Collection Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5005
	 * @category searchAgentCollectionListInquiry
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	public List<AgentCollectionListVO> searchAgentCollectionListInquiry(AgentCollectionListVO agentCollectionListVO) throws EventException;

	/**
	 * Agent Collection Entry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5004
	 * @category manageAgentCollectionList
	 * @param ManageAgentCollectionListVO[] manageAgentCollectionListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAgentCollectionListBasic(ManageAgentCollectionListVO[] manageAgentCollectionListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Unreported OTS Report<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5004
	 * @category searchUnreportedOtsReportList
	 * @param UnreportedOtsReportVO unreportedOtsReportVO
	 * @return List<UnreportedOtsReportVO>
	 * @throws EventException
	 */
	public List<UnreportedOtsReportVO> searchUnreportedOtsReportList(UnreportedOtsReportVO unreportedOtsReportVO) throws EventException;

	/**
	 * Agent Statement of Account Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5003
	 * @category searchASAInquiryList
	 * @param ASAInquiryListVO aSAInquiryListVO
	 * @return List<ASAInquiryListVO>
	 * @throws EventException
	 */
	public List<ASAInquiryListVO> searchASAInquiryList(ASAInquiryListVO aSAInquiryListVO) throws EventException;

	/**
	 * Search ASA init info
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param ASAInfoByOfcAgnVO paramVO
	 * @param String lOfcCd
	 * @return ASAInfoByOfcAgnVO
	 * @throws EventException
	 */
	public ASAInfoByOfcAgnVO searchASAInfoByOfcAgn(ASAInfoByOfcAgnVO paramVO, String lOfcCd) throws EventException;

	/**
	 * Search ASA Master
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	public SarAsaMstVO searchASAMst(SarAsaMstVO paramVO) throws EventException;

	/**
	 * Search ASA Detail
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaDtlVO paramVO
	 * @return List<SarAsaDtlVO>
	 * @throws EventException
	 */
	public List<SarAsaDtlVO> searchASADtl(SarAsaDtlVO paramVO) throws EventException;

	/**
	 * Search ASA No Sequence
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaNoSeqVO paramVO
	 * @return SarAsaNoSeqVO
	 * @throws EventException
	 */
	public SarAsaNoSeqVO searchASASeqNo(SarAsaNoSeqVO paramVO) throws EventException;

	/**
	 * Search ASA No Sequence
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	public SarAsaMstVO createASA(SarAsaMstVO paramVO, String lOfcCd) throws EventException;

	/**
	 * Create & Update ASA Detail
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @throws EventException
	 */
	public void updateASADtl(String asaNo, String userId) throws EventException;

	/**
	 * Create & Update ASA Detail for interface
	 * 
	 * @author myoungsinpark 2015. 5. 22.
	 * @param String asaNo
	 * @param String userId
	 * @throws EventException
	 */
	public void updateASADtlForCall(String asaNo, String userId) throws EventException;
	
	/**
	 * Finish ASA
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	public SarAsaMstVO finishASA(String asaNo, String userId, String lOfcCd) throws EventException;

	/**
	 * true : "total OTS Amount" - "ASA total amount" < office ots limit amount
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkUnreportedAmount(String asaNo) throws EventException;

	/**
	 * reopen ASA
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	public SarAsaMstVO reopenASA(String asaNo, String userId) throws EventException;

	/**
	 * approve ASA 대리점 Collect & Refund를 조정후 하나의 ASA No.로 OTS를 생성한다. Collect &
	 * Refund and one representative of the adjusted ASA No. OTS is created.
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	public SarAsaMstVO approveASA(String asaNo, String userId, String lOfcCd) throws EventException;

	/**
	 * STM_SAR_5002 : checkASAperiod Agent Statement of Account Entry check
	 * period<br>
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
	 * @return CheckASAperiodVO
	 * @throws EventException
	 */
	public CheckASAperiodVO searchASAperiod(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws EventException;

	/**
	 * STM_SAR_5002 : checkASAperiod Agent Statement of Account Entry check pre
	 * asa status<br>
	 * 
	 * @author myoungsin park
	 * @param ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
	 * @return CheckPreASAStausVO
	 * @exception EventException
	 */
	public CheckPreASAStausVO checkPreASAStatus(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws EventException;

	/**
	 * approve ASA 대리점 Collect & Refund를 조정후 하나의 ASA No.로 OTS를 생성한다. Collect &
	 * Refund and one representative of the adjusted ASA No. OTS is created.
	 * 
	 * @param String batSeq
	 * @return String
	 * @throws EventException
	 */
	public String approveASABat(String batSeq) throws EventException;

	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchBatStsCd(String pgmNo) throws EventException;
	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelASABat(String batSeq, SignOnUserAccount account) throws EventException;	
	
	/**
	 * SCO_BAT_HIS 테이블에 데이타를 생성한다.
	 * 
	 * @author myoungsin park
	 * @param String asaNo
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createApproveASABat(String asaNo, SignOnUserAccount account) throws EventException;

	/**
	 * STM_SAR_5002 : searchBatHisStatus
	 * 
	 * @author myoungsin park
	 * @param String batSeq
	 * @return BatHisVO
	 * @exception EventException
	 */
	public BatHisVO searchBatHisStatus(String batSeq) throws EventException;
	
	/**
 	 * [STM_SAR_500] Agent Statement of Account Entry
 	 * searchASAApprovalCheck<br> 
 	 * @author JBLEE
 	 * @param String asaNo
 	 * @return String
 	 * @exception DAOException
      */ 
     public String searchASAApprovalCheck(String asaNo) throws EventException;
     
     /**
 	 * [STM_SAR_5002]
 	 * Search duplicated collection/refund B/L list <br>
 	 *
 	 * @author SYPARK
 	 * @param String asaNo
 	 * @return String
 	 * @exception EventException
 	 */
 	public String searchDuplicateColRfnd(String asaNo) throws EventException;
 	
 	/**
	 * Agent Collection Temp Insert<br>
	 * 
	 * @author Myoung Sin Park
	 * @category addAgentCollectionTempListBasic
	 * @param List<AgentCollectionListVO> agentCollectionListVOs
	 * @throws EventException
	 */
	public void addAgentCollectionTempListBasic(List<AgentCollectionListVO> agentCollectionListVOs) throws EventException;
	
	/**
	 * [STM_SAR_5002] ASA Master Modify<br>
	 * 
	 * @author KIMOKRYE
	 * @category Agent Statement of Account Entry
	 * @param SarAsaMstVO paramVO
	 * @throws EventException
	 */
	public void modifyASAMst (SarAsaMstVO paramVO) throws EventException;	
}
