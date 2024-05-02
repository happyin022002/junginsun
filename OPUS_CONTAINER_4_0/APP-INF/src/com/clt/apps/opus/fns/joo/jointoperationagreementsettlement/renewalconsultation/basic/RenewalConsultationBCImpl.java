/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBCImpl.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.basic;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import monfox.toolkit.snmp.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration.RenewalConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ActualDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-RenewalMasterDataMgtSC Business Logic Basic Command implementation<br>
 * - OPUS-RenewalMasterDataMgtSC: handling business logic<br>
 *
 * @author
 * @see UI_JOO_0028EventResponse,RenewalMasterDataMgtBC DAO class
 * @since J2EE 1.4
 */

public class RenewalConsultationBCImpl extends BasicCommandSupport implements RenewalConsultationBC {

	// Database Access Object
	private transient RenewalConsultationDBDAO dbDao = null;
	private transient JointOperationConsultationDBDAO cslDao = null;

	/**
	 * RenewalMasterDataMgtBCImpl object creation<br>
	 * RenewalMasterDataMgtDBDAO creation<br>
	 */
	public RenewalConsultationBCImpl() {
		dbDao = new RenewalConsultationDBDAO();
		cslDao = new JointOperationConsultationDBDAO();
	}
	

    /**
	 * Retrieve/Create (Back End Job) : Select Target VVD For Settlement Creation화면 조회/생성. 
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
     * @param String jobFlg
     * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
     */
    public String searchSettlementTargetBackEndJobList(SettlementTargetVO settlementTargetVO, String jobFlg, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	RenewalConsultationBackEndJob backEndResult = new RenewalConsultationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg(jobFlg);
    		backEndResult.setSettlementTargetVO(settlementTargetVO);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "Select Target VVD For Settlement Creation Retrieve/Create!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD For Settlement Creation", "Retrieve/Create"}).getMessage(), ex);
        }
    }
	

    /**
	 * Save (Back End Job) : Select Target VVD For Settlement Creation 저장. 
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO[] settlementTargetVOS
     * @param String jobFlg
     * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
     */
    public String manageSettlementTargetBackEndJobList(SettlementTargetVO[] settlementTargetVOS, String jobFlg, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	RenewalConsultationBackEndJob backEndResult = new RenewalConsultationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg(jobFlg);
    		backEndResult.setSettlementTargetVOS(settlementTargetVOS);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "Select Target VVD For Settlement Creation Save!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD For Settlement Creation", "Save"}).getMessage(), ex);
        }
    }
    
    /**
     * Retrieve Common BackEndJob Status
     * 
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchComBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		}
	} 
	


	/**
	 * Retrieve : Select actual payer/receiver for slip 조회.
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchActualPayerReceiverList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchActualPayerReceiverList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select actual payer/receiver for slip", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select actual payer/receiver for slip", "Retrieve"}).getMessage(), ex);

		}
	}
	

    /**
	 * Save : Select actual payer/receiver for slip 저장. 
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @param InvoiceVO[] invoiceVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageActualPayerReceiverList(ConsultationConditionVO consultationConditionVO, InvoiceVO[] invoiceVOS, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	log.debug("\n manageActualPayerReceiverList START ===================================================");
        	//new Invoice NO을 미리 채번한다.
        	Map<String, String> newInvNoMap 		= new HashMap<String, String>();
        	
        	//Actual Payer/Receiver 목록 만큼 Loop 를 돌면서 Invoice, Invoice Detail, settlement target update
        	for(InvoiceVO vo : invoiceVOS){        		
        		String tmpAcctgCrrCds = vo.getAcctgCrrCd();
        		
        		//Actual Carrier & partner ref no : Acctg_crr_cd^cust_cd^vndr_seq : APL^AE100865^100226
    			String[] tmpAcctgCrrCdArr = StringUtil.split(tmpAcctgCrrCds, JooConstants.SPLIT_DATA_STRING);
				
    			vo.setAcctgCrrCd(tmpAcctgCrrCdArr[0]); //acctg_crr_cd
    			vo.setCustCd	(tmpAcctgCrrCdArr[1]); //customer
    			vo.setVndrSeq	(tmpAcctgCrrCdArr[2]); //service provider
        		
    			//keyMap Data를 넣는다.
    			if(!newInvNoMap.containsKey(tmpAcctgCrrCds)){            		
        			
    				//Invoice No를 생성해서 Map 담아 놓는다.
    				InvoiceVO newInvNoVo = new InvoiceVO();
    				newInvNoVo.setAcctYrmon		(vo.getAcctYrmon());
    				newInvNoVo.setJoCrrCd		(vo.getJoCrrCd());
    				newInvNoVo.setAcctgCrrCd	(vo.getAcctgCrrCd());
    				
    	        	//신규 Invoice no 을 구한다. : INV_DTL 에서 재사용한다.
    				String newInvNo = dbDao.searchNewInvoiceNo(newInvNoVo);
    				
    				newInvNoMap.put(tmpAcctgCrrCds, newInvNo);
    			}
    			
    			//위에서 자기 자신의 InvNo을 이미 Map에 담았기때문에 찾아서 Setting 한다.
    			
    			String tmpNewInvNo = newInvNoMap.get(tmpAcctgCrrCds);
    			vo.setInvNo		(tmpNewInvNo);
    			vo.setCreUsrId	(signOnUserAccount.getUsr_id());
    			vo.setUpdUsrId	(signOnUserAccount.getUsr_id());
    			vo.setRvsCmbFlg	("N");
    			vo.setRjctCmbFlg("N");
    			
    			//조건 정보를 갱신
    			consultationConditionVO.setJoCrrCd		(vo.getJoCrrCd());
    			consultationConditionVO.setLoclCurrCd	(vo.getLoclCurrCd());
    			
    			//Revenue 금액 체크
        		String tmpStlRevActAmt = StringUtils.isEmpty(vo.getStlRevActAmt()) ? null : vo.getStlRevActAmt();
        		
        		BigDecimal bdStlRevActAmt = NumberUtils.createBigDecimal(tmpStlRevActAmt);
        		
        		log.debug("\n manageActualPayerReceiverList Before Revenue Amount ["+tmpStlRevActAmt+"] / BigDecimal=["+bdStlRevActAmt+"]");
        		//Revenue Invoice 및 Invoice Detail 생성.
        		if(!StringUtils.isEmpty(tmpStlRevActAmt) && bdStlRevActAmt.signum() != 0){
        			vo.setReDivrCd(JooConstants.KEY_RE_DIVR_CD_REVENUE);
        			vo.setPrnrRefNo		(vo.getCustCd());
        			vo.setActAmt		(vo.getStlRevActAmt());
        			
        			consultationConditionVO.setReDivrCd(vo.getReDivrCd());
        			
        			//JOO_INVOCE, JOO_INV_DTL Insert, JOO_STL_TGT Update
        			this.manageAutoActualPayerReceiverList(consultationConditionVO, vo, signOnUserAccount);
        		}
        		
        		//Expense 금액 체크
        		String tmpStlExpActAmt = StringUtils.isEmpty(vo.getStlExpActAmt()) ? null : vo.getStlExpActAmt();
        		
        		BigDecimal bdStlExpActAmt = NumberUtils.createBigDecimal(tmpStlExpActAmt);
        		
        		log.debug("\n manageActualPayerReceiverList Before Revenue Amount ["+tmpStlRevActAmt+"] / BigDecimal=["+bdStlRevActAmt+"]");
        		//Expense Invoice 및 Invoice Detail 생성.
        		if(!StringUtils.isEmpty(tmpStlExpActAmt) && bdStlExpActAmt.signum() != 0){
        			vo.setReDivrCd		(JooConstants.KEY_RE_DIVR_CD_EXPENSE);
        			vo.setPrnrRefNo		(vo.getVndrSeq());
        			vo.setActAmt		(vo.getStlExpActAmt());

        			consultationConditionVO.setReDivrCd(vo.getReDivrCd());
        			
        			//JOO_INVOCE, JOO_INV_DTL Insert, JOO_STL_TGT Update
        			this.manageAutoActualPayerReceiverList(consultationConditionVO, vo, signOnUserAccount);
        		}
    			
        	}
        	log.debug("\n manageActualPayerReceiverList E N D ===================================================");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select actual payer/receiver for slip", "Save"}).getMessage(), ex);
        }
    }
    
    /**
     * Save : Auto Select actual payer/receiver for slip 저장.
     *  JOO_INVOCE, JOO_INV_DTL Insert
     *  JOO_STL_TGT Update 
     * 
     * @param ConsultationConditionVO consultationConditionVO
     * @param InvoiceVO invoiceVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    private void manageAutoActualPayerReceiverList(ConsultationConditionVO consultationConditionVO, InvoiceVO invoiceVO, SignOnUserAccount signOnUserAccount) throws EventException {
    	try{
    		/*
    		 * 1건의 Invoice 저장
        	 * 2. settlementTargetVO(조건) + invoiceVOS의 Row 단위로 JOO_STL_TGT에서 대상을 조회
        	 * - settlementTargetVO : rev_yrmon, re_divr_cd, jo_crr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, rev_vvd
        	 * - invoiceVOS : jo_crr_cd, locl_curr_cd, acctg_crr_cd
        	 * 3. 위 목록을 기준대상으로 JOO_INV_DTL 생성.(위에서 리턴한 INV_NO)
        	 * 4. 위 목록으로 JOO_STL_TGT의 ACT_AMT = NULL 로 Update. 
        	 */			
	    	List<InvoiceDetailVO> autoInvoiceList = dbDao.calculateActualPayerReceiverList(consultationConditionVO);
			
	    	if(autoInvoiceList != null && autoInvoiceList.size() > 0){
	    		//1건의 Invoice 저장
				dbDao.addInvoice(invoiceVO);
	    	
		    	//3. 위 목록을 기준대상으로 JOO_INV_DTL 생성.(위에서 리턴한 INV_NO)
				for(InvoiceDetailVO dtlVo : autoInvoiceList){
					//3.1. Invoice Detail VO를 생성한다.
					InvoiceDetailVO invDtlVo = new InvoiceDetailVO();
	
					invDtlVo.setAcctYrmon	(invoiceVO.getAcctYrmon());
					invDtlVo.setJoCrrCd		(invoiceVO.getJoCrrCd());
					invDtlVo.setReDivrCd	(invoiceVO.getReDivrCd());
					invDtlVo.setInvNo		(invoiceVO.getInvNo());
					
					invDtlVo.setVslCd		(dtlVo.getVslCd());
					invDtlVo.setSkdVoyNo	(dtlVo.getSkdVoyNo());
					invDtlVo.setSkdDirCd	(dtlVo.getSkdDirCd());
					invDtlVo.setRevDirCd	(dtlVo.getRevDirCd());
					invDtlVo.setRevYrmon	(dtlVo.getRevYrmon());
					invDtlVo.setStlVvdSeq	(dtlVo.getStlVvdSeq());
					invDtlVo.setActAmt		(dtlVo.getActAmt());
					invDtlVo.setStlRmk		(dtlVo.getStlRmk());
					invDtlVo.setCreUsrId	(signOnUserAccount.getUsr_id());
					invDtlVo.setUpdUsrId	(signOnUserAccount.getUsr_id());
					
					//3.2. Invoice Detail Insert
					dbDao.addInvoiceDetail(invDtlVo);
					
					//3.2. Settlement Target STL_TGT_FLG = N, ACT_AMT = null Update.
					SettlementTargetVO stlTgtVo = new SettlementTargetVO();
					stlTgtVo.setVslCd		(dtlVo.getVslCd());
					stlTgtVo.setSkdVoyNo	(dtlVo.getSkdVoyNo());
					stlTgtVo.setSkdDirCd	(dtlVo.getSkdDirCd());
					stlTgtVo.setRevDirCd	(dtlVo.getRevDirCd());
					stlTgtVo.setRevYrmon	(dtlVo.getRevYrmon());
					stlTgtVo.setStlVvdSeq	(dtlVo.getStlVvdSeq());
					stlTgtVo.setCreUsrId	(signOnUserAccount.getUsr_id());
					dbDao.modifySettlementTargetActAmt(stlTgtVo);
				}
	    	}
	    	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Auto actual payer/receiver for slip", "Save"}).getMessage(), ex);
        }
    }
    
	/**
	 * Retrieve : Actual Detail Invoice No Combo Item 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws Exception
	 */
	public List<ActualDetailVO> searchInvoiceNoList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceNoList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Actual Deatil", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Actual Deatil", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Retrieve : Actual Detail Invoice 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws Exception
	 */
	public List<ActualDetailVO> searchActualDetailList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchActualDetailList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Actual Deatil", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Actual Deatil", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Retrieve : Invoice Creation 대상 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceTargetList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceTargetList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Creation Target", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Creation Target", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Retrieve : Invoice Creation 대상 Detail 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws Exception
	 */
	public List<InvoiceDetailVO> searchInvoiceTargetDetailList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceTargetDetailList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Creation Target Detail", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Creation Target Detail", "Retrieve"}).getMessage(), ex);

		}
	}	

    /**
	 * Save : Invoice/Slip Creation. : Manual
	 * 
	 * @category FNS_JOO_0102
	 * @param InvoiceVO[] invoiceVOS
	 * @param InvoiceDetailVO[] invoiceDetailVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageInvoiceList(InvoiceVO[] invoiceVOS, InvoiceDetailVO[] invoiceDetailVOS, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	//invoiceVOs Loop 를 돌면서 Invoice, Invoice Detail, settlement target update
        	//Manual Invoice 시에는 동일 invoice no 를 가진다.
        	List<InvoiceVO> newInvoiceList = new ArrayList<InvoiceVO>();
        	//Map<String, String> newGrpKeyMap 		= new HashMap<String, String>();
        	Map<String, String> newInvNoMap 		= new HashMap<String, String>();
        	for(InvoiceVO vo : invoiceVOS){
        		if(!StringUtils.isEmpty(vo.getChkCmbFlg()) && vo.getChkCmbFlg().equals("1")){
        			
        			//Actual Carrier & partner ref no : Acctg_crr_cd^cust_cd^vndr_seq : APL^AE100865^100226
        			String tmpAcctgCds		= vo.getAcctgCrrCd();
        			String[] tmpAcctgCdArr 	= StringUtil.split(tmpAcctgCds, JooConstants.SPLIT_DATA_STRING);
        			
        			vo.setAcctgCrrCd(tmpAcctgCdArr[0]);
        			vo.setCustCd	(tmpAcctgCdArr[1]);
        			vo.setVndrSeq	(tmpAcctgCdArr[2]);
        			
        			//keyMap Data를 넣는다.
        			if(!newInvNoMap.containsKey(tmpAcctgCds)){
        				//Invoice No를 생성해서 Map 담아 놓는다.
        				InvoiceVO newKeyVo = new InvoiceVO();
        				newKeyVo.setAcctYrmon	(vo.getAcctYrmon());
        	        	newKeyVo.setJoCrrCd		(vo.getJoCrrCd());
        	        	newKeyVo.setAcctgCrrCd	(vo.getAcctgCrrCd());
        				
        	        	//신규 Invoice no 을 구한다. : INV_DTL 에서 재사용한다.
        				String newInvNo = dbDao.searchNewInvoiceNo(newKeyVo);
        				
        				newInvNoMap.put(tmpAcctgCds, newInvNo);
        			}
        			
        			//new Key를 Setting
        			String tmpNewInvNo = newInvNoMap.get(tmpAcctgCds);
        			vo.setInvNo		(tmpNewInvNo);
        			vo.setCreUsrId	(signOnUserAccount.getUsr_id());
        			vo.setUpdUsrId	(signOnUserAccount.getUsr_id());
        			vo.setRvsCmbFlg	("N");
        			vo.setRjctCmbFlg("N");
        			        			
        			/*//Group Key에 연결된 new invoice no Data를 넣는다.
        			String tmpGrpKey = vo.getDtlGrpKey();
        			if(!newGrpKeyMap.containsKey(tmpGrpKey)){
        				//key로 저장된 신규 key를 찾는다.
        				String newGrpInvKey =  newKeyTgtMap.get(tmpAcctgCds);   
        				
        				newGrpKeyMap.put(tmpGrpKey, newGrpInvKey);
        			} */       			
        			
        			newInvoiceList.add(vo);
        		}
        	}
        	
        	//위에서 Combined 체크된 Invoice를 
        	for(InvoiceVO invVo : newInvoiceList){
        		
        		//Revenue 금액 체크
        		String tmpStlRevActAmt = StringUtils.isEmpty(invVo.getStlRevActAmt()) ? null : invVo.getStlRevActAmt();
        		
        		BigDecimal bdStlRevActAmt = NumberUtils.createBigDecimal(tmpStlRevActAmt);
        		
        		log.debug("\n manageInvoiceList Before Revenue Amount ["+tmpStlRevActAmt+"] / BigDecimal=["+bdStlRevActAmt+"]");
        		//Revenue Invoice 및 Invoice Detail 생성.
        		if(!StringUtils.isEmpty(tmpStlRevActAmt) && bdStlRevActAmt.signum() != 0){
        			invVo.setReDivrCd	(JooConstants.KEY_RE_DIVR_CD_REVENUE);
    				invVo.setPrnrRefNo	(invVo.getCustCd());
    				invVo.setActAmt		(invVo.getStlRevActAmt());
    				
    				log.debug("\n manageInvoiceList Revenue(AR) Call.");
    				this.manageInvoiceList(invVo, invoiceDetailVOS, signOnUserAccount);
        		}
        		
        		//Expense 금액 체크
        		//String tmpStlExpActAmt = invVo.getStlExpActAmt();
        		String tmpStlExpActAmt = StringUtils.isEmpty(invVo.getStlExpActAmt()) ? null : invVo.getStlExpActAmt();

        		BigDecimal bdStlExpActAmt = NumberUtils.createBigDecimal(tmpStlExpActAmt);
        		
        		log.debug("\n manageInvoiceList Before Revenue Amount ["+tmpStlExpActAmt+"] / BigDecimal=["+bdStlExpActAmt+"]");
        		//Expense Invoice 및 Invoice Detail 생성.
        		if(!StringUtils.isEmpty(tmpStlExpActAmt) && bdStlExpActAmt.signum() != 0){
        			invVo.setReDivrCd	(JooConstants.KEY_RE_DIVR_CD_EXPENSE);
    				invVo.setPrnrRefNo	(invVo.getVndrSeq());
    				invVo.setActAmt		(invVo.getStlExpActAmt());
        			
    				log.debug("\n manageInvoiceList Expense(AP) Call.");
    				this.manageInvoiceList(invVo, invoiceDetailVOS, signOnUserAccount);
        		}
				
        	}
        	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice/Slip Creation", "Save"}).getMessage(), ex);
        }
    }

    
    /**
     *  Save : Invoice/Slip Creation 저장.
     *  JOO_INVOCE, JOO_INV_DTL Insert
     *  JOO_STL_TGT Update 
     * 
     * @param InvoiceVO invoiceVO
     * @param InvoiceDetailVO[] invoiceDetailVOS
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    private void manageInvoiceList(InvoiceVO invoiceVO, InvoiceDetailVO[] invoiceDetailVOS, SignOnUserAccount signOnUserAccount) throws EventException {
    	try{
    		if(invoiceDetailVOS != null && invoiceDetailVOS.length > 0){
	    		//1건의 Invoice 저장
				dbDao.addInvoice(invoiceVO);    		
			
				//GroupKey + Rev/Exp 구분값으로 비교해서 처리해야 한다.
				String tmpReDivrCd 	= invoiceVO.getReDivrCd();
				String tmpDtlGrpKey = invoiceVO.getDtlGrpKey();
				//String tmpInvNo		= invoiceVO.getInvNo();
				//String tmpAcctYrmon	= invoiceVO.getAcctYrmon();
				
				for(InvoiceDetailVO dtlVo : invoiceDetailVOS ){
					String dtlGrpKey 	= dtlVo.getDtlGrpKey();
					String dtlReDivrCd 	= dtlVo.getReDivrCd();
					
					if(!StringUtils.isEmpty(dtlGrpKey) && tmpDtlGrpKey.equals(dtlGrpKey) && !StringUtils.isEmpty(dtlReDivrCd) && tmpReDivrCd.equals(dtlReDivrCd)){
						//Invoice Detail Setting 및 Insert.
						dtlVo.setAcctYrmon	(invoiceVO.getAcctYrmon());
						dtlVo.setJoCrrCd	(invoiceVO.getJoCrrCd());
						dtlVo.setInvNo		(invoiceVO.getInvNo());
						dtlVo.setReDivrCd	(invoiceVO.getReDivrCd());
						
						if(dtlReDivrCd.equals(JooConstants.KEY_RE_DIVR_CD_REVENUE)){
							dtlVo.setActAmt	(dtlVo.getRevActAmt());
						}else if(dtlReDivrCd.equals(JooConstants.KEY_RE_DIVR_CD_EXPENSE)){
							dtlVo.setActAmt	(dtlVo.getExpActAmt());
						}
						dtlVo.setCreUsrId	(signOnUserAccount.getUsr_id());
						dtlVo.setUpdUsrId	(signOnUserAccount.getUsr_id());
						
						//3.2. Invoice Detail Insert
						dbDao.addInvoiceDetail(dtlVo);
						
						//3.2. Settlement Target STL_TGT_FLG = N, ACT_AMT = null Update.
						SettlementTargetVO stlTgtVo = new SettlementTargetVO();
						stlTgtVo.setVslCd		(dtlVo.getVslCd());
						stlTgtVo.setSkdVoyNo	(dtlVo.getSkdVoyNo());
						stlTgtVo.setSkdDirCd	(dtlVo.getSkdDirCd());
						stlTgtVo.setRevDirCd	(dtlVo.getRevDirCd());
						stlTgtVo.setRevYrmon	(dtlVo.getRevYrmon());
						stlTgtVo.setStlVvdSeq	(dtlVo.getStlVvdSeq());
						stlTgtVo.setCreUsrId	(signOnUserAccount.getUsr_id());
						dbDao.modifySettlementTargetActAmt(stlTgtVo);
						
					}
				}
    		}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Auto actual payer/receiver for slip", "Save"}).getMessage(), ex);
        }
    }

	/**
	 * Retrieve : CSR Creation 조회.
	 * 
	 * @category FNS_JOO_0103
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<SlipProcessVO>
	 * @throws Exception
	 */
	public List<SlipProcessVO> searchCsrCreationList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchCsrCreationList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Creation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Creation", "Retrieve"}).getMessage(), ex);

		}
	}

    /**
	 * SAVE- CSR Creation List : AP/AR 생성.<br>
	 * 
	 * @category FNS_JOO_0103
	 * @param SlipProcessVO[] slipProcessVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageConsultationList(SlipProcessVO[] slipProcessVOS, SignOnUserAccount signOnUserAccount) throws EventException {
		 try {
    		 log.debug("\n manageConsultationList START =======================================================");
    		 //1. slipProcessVOS Data는 JOO_CSR 1:1로 Insert 한다.
    		 //1.1. 화면에서 이미 SLP_TP_CD, SLP_FUNC_CD, SLP_OFC_CD, SLP_ISS_DT 까지는 생성되어 있음. SLP_SER_NO 생성한다.
    		 for(SlipProcessVO slipProcessVO : slipProcessVOS){
    			 //화면에서 Check 된 데이타만 CSR을 만든다.
    			 if(!StringUtils.isEmpty(slipProcessVO.getChkCsrFlg()) && slipProcessVO.getChkCsrFlg().equals("1")){
	    			 String newSlpSerNo = cslDao.searchNextSlpSerNo(slipProcessVO);
	    			 log.debug("\n manageConsultationList newSlpSerNo["+newSlpSerNo+"]");
	    			 
	    			 slipProcessVO.setSlpSerNo	(newSlpSerNo);
	    			 slipProcessVO.setOfcCd		(signOnUserAccount.getOfc_cd());
	    			 slipProcessVO.setIssuerId 	(signOnUserAccount.getUsr_id());
	    			 
	    			 //1.2. JOO_SLP_SEQ Table Insert/Update 처리.
	    			 this.manageCsulSlpSeq(slipProcessVO);
	    			 
	    			 log.debug("\n manageConsultationList JOO_CSR Insert Call.");
	    			 //1.4. JOO_CSR Insert.
	    			 cslDao.addJooCsr(slipProcessVO);
	    			 
	    			 log.debug("\n manageConsultationList JOO_INVOICE Update Call.");
	    			 //1.3. JOO_INVOICE 전표 번호 Update 함.
	    			 dbDao.modifyInvoiceForCsr(slipProcessVO);
	    			 
	    			 //1.5. AP/AR 구분하여 하위 데이타를 생성한다.(JOO_SLIP)
	    			 if(JooConstants.KEY_RE_DIVR_CD_EXPENSE.equals(slipProcessVO.getReDivrCd())){
	    				 //AP
	    				 log.debug("\n manageConsultationList AP createAPConsultation Call.");
	    				 this.createAPConsultation(slipProcessVO, signOnUserAccount);
	    			 }else if(JooConstants.KEY_RE_DIVR_CD_REVENUE.equals(slipProcessVO.getReDivrCd())){
	    				 //AR
	    				 log.debug("\n manageConsultationList AR createARConsultation Call.");
	    				 this.createARConsultation(slipProcessVO, signOnUserAccount);
	    			 }else{
	    				 //Exception 발생시킨다.
	    				 throw new EventException("AP/AR 외의 데이타가 존재함.");
	    			 }
    			 }
    		 }
    		 log.debug("\n manageConsultationList E N D =======================================================");
    	 } catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR(AP/AR) Creation", "Save"}).getMessage(), ex);
         }
    }
    
    /**
     * Create AP Consultation
     * 
	 * @category FNS_JOO_0103
     * @param SlipProcessVO slipProcessVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	private void createAPConsultation(SlipProcessVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException{
    	try {
    		log.debug("\n createAPConsultation START =======================================================");
    		List<SlipProcessVO> list = dbDao.calculateSlipTargetList(slipProcessVO);
    		int iCnt = 0;
    		for(SlipProcessVO drVo : list){
    			drVo.setSlpTpCd		(slipProcessVO.getSlpTpCd());
    			drVo.setSlpFuncCd	(slipProcessVO.getSlpFuncCd());
    			drVo.setSlpOfcCd	(slipProcessVO.getSlpOfcCd());
    			drVo.setSlpIssDt	(slipProcessVO.getSlpIssDt());
    			drVo.setSlpSerNo	(slipProcessVO.getSlpSerNo());
    			
    			drVo.setEffDt		(slipProcessVO.getEffDt());
    			drVo.setIssuerId	(signOnUserAccount.getUsr_id());
    			log.debug("\n createAPConsultation JOO_SLIP DR Insert Call.");
    			cslDao.addJooSlp(drVo); //JOO_SLIP Insert
    			iCnt++;
    		}
    		
    		//1건 이상의 SLIP 데이타 저장시 CR 데이타를 저장한다.
    		if(iCnt > 0){
    			SlipProcessVO crVo = (SlipProcessVO) list.get(0);
    			String 	tmpCsrNo	=  slipProcessVO.getSlpTpCd() + slipProcessVO.getSlpFuncCd() + slipProcessVO.getSlpOfcCd();
    					tmpCsrNo	+= slipProcessVO.getSlpIssDt() + slipProcessVO.getSlpSerNo();
    					
    					crVo.setDrCrCd  	(JooConstants.KEY_DR_CR_TP_CD_CR);//CR
    					crVo.setKeyNo   	(tmpCsrNo);
    					crVo.setCrLocCd 	("");
    					crVo.setRlaneCd 	("");
    					crVo.setVslCd   	("");
    					crVo.setSkdVoyNo	("");
    					crVo.setSkdDirCd	("");
    					crVo.setRevDirCd	("");
    					crVo.setStlVvdSeq	("0");
    					crVo.setStlSeq   	("0");
    					crVo.setSlpDesc 	(crVo.getJoCrrCd()+"/"+slipProcessVO.getCsrDesc());
    					
    					crVo.setEffDt		(slipProcessVO.getEffDt());
    					crVo.setIssuerId	(signOnUserAccount.getUsr_id());
    					//AP CR 1건 저장.
    					log.debug("\n createAPConsultation JOO_SLIP CR Insert Call.");
    					cslDao.addJooSlp(crVo);
    			
    			//TODO Tax 관련 부분 : 현재는 사용하지 않음.    			
    		}
    		
    		//Approval Process Call
			log.debug("\n createAPConsultation createCSREPApproval Call.");
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		command.createCSREPApproval(slipProcessVO, signOnUserAccount);
    		
    		log.debug("\n createAPConsultation E N D =======================================================");
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Cretaion - AP Consultation", "Save"}).getMessage(), ex);
        }
    }
    
    /**
     * Create AR Consultation
     * 
	 * @category FNS_JOO_0103
     * @param SlipProcessVO slipProcessVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    private void createARConsultation(SlipProcessVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException{
    	try {
    		log.debug("\n createARConsultation START =======================================================");
    		List<SlipProcessVO> list = dbDao.calculateSlipTargetList(slipProcessVO);
    		int iCnt = 0;
    		for(SlipProcessVO drVo : list){
    			drVo.setSlpTpCd		(slipProcessVO.getSlpTpCd());
    			drVo.setSlpFuncCd	(slipProcessVO.getSlpFuncCd());
    			drVo.setSlpOfcCd	(slipProcessVO.getSlpOfcCd());
    			drVo.setSlpIssDt	(slipProcessVO.getSlpIssDt());
    			drVo.setSlpSerNo	(slipProcessVO.getSlpSerNo());
    			
    			drVo.setEffDt		(slipProcessVO.getEffDt());    			    	
    			drVo.setIssuerId	(signOnUserAccount.getUsr_id());
    			log.debug("\n createARConsultation JOO_SLIP DR Insert Call.");
    			cslDao.addJooSlp(drVo);//JOO_SLIP Insert
    			iCnt++;
    		}
    		
    		if(iCnt > 0){
    			for(SlipProcessVO crVo : list){
    				crVo.setDrCrCd  (JooConstants.KEY_DR_CR_TP_CD_CR);//CR
    				crVo.setSlpDesc (crVo.getJoCrrCd()+"/"+slipProcessVO.getCsrDesc());
    				
    				crVo.setEffDt		(slipProcessVO.getEffDt());
    				crVo.setIssuerId(signOnUserAccount.getUsr_id());
    				
    				//AR CR n건 저장 ( 상단에 구한 DR 카운터 만큼 저장한다.)
    				log.debug("\n createARConsultation JOO_SLIP CR Insert Call.");
    				cslDao.addJooSlp(crVo);//JOO_SLIP Insert
    			}
    		}
    		
    		int iMaxRow = list != null ? list.size() : 0;
    		
    		slipProcessVO.setMaxRows(iMaxRow); 
    		
    		//Approval Process Call
			log.debug("\n createAPConsultation createCSREPApproval Call.");
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		command.createCSREPApproval(slipProcessVO, signOnUserAccount);
    		
    		log.debug("\n createARConsultation E N D =======================================================");
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Cretaion - AR Consultation", "Save"}).getMessage(), ex);
        }
    }

	

	/**
	 * JOO_SLP_SEQ Table Insert/Update.
	 * 
	 * @param slipProcessVO SlipProcessVO
	 * @throws EventException
	 */
	private void manageCsulSlpSeq(SlipProcessVO slipProcessVO) throws EventException {
		try {
			//0001
			if (JooConstants.DEFAULT_VALUE_SLP_SER_NO.equals(slipProcessVO.getSlpSerNo())){
				cslDao.addJooSlpSeq(slipProcessVO);			
			}else{
				cslDao.modifyJooSlpSeq(slipProcessVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Number", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Number", "Create"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve : Invoice Delete 대상 조회.
	 * 
	 * @category FNS_JOO_0106
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceDeleteList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceDeleteList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Delete Target", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Delete Target", "Retrieve"}).getMessage(), ex);

		}
	}	
	
    /**
	 * Save : Invoice Delete 대상삭제
	 * 
	 * @category FNS_JOO_0106
	 * @param InvoiceVO[] invoiceVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageInvoiceDeleteList(InvoiceVO[] invoiceVOS, SignOnUserAccount signOnUserAccount) throws EventException {
    	try{
    		for(InvoiceVO delVo: invoiceVOS){
    			if(!StringUtils.isEmpty(delVo.getChkDelFlg()) && delVo.getChkDelFlg().equals("1")){
    				ConsultationConditionVO condVo = new ConsultationConditionVO();
    				condVo.setInvNo			(delVo.getInvNo());
    				condVo.setAcctYrmon		(delVo.getAcctYrmon());
    				condVo.setAcctgCrrCd	(delVo.getAcctgCrrCd());
    				condVo.setReDivrCd		(delVo.getReDivrCd());
    				condVo.setLoclCurrCd	(delVo.getLoclCurrCd());
    				condVo.setPrnrRefNo		(delVo.getPrnrRefNo());
    				
    				//전표 번호 존재하는지 체크.
    				String chkExistFlg = dbDao.checkExistInvoiceSlipForInvoiceNo(condVo);
    				if(chkExistFlg.equals("N")){
	    				//삭제 대상의 JOO_INVOICE 목록조회
    					List<InvoiceVO> delInvList = dbDao.searchInvoiceListForDelInvoiceNo(condVo);
	    				for(InvoiceVO delInvVo : delInvList){
	    					delInvVo.setCreUsrId		(signOnUserAccount.getUsr_id()); //Login User Id Setting
	    					
	    					InvoiceDetailVO delInvDtlVo = new InvoiceDetailVO();
	    					delInvDtlVo.setAcctYrmon	(delInvVo.getAcctYrmon());
	    					delInvDtlVo.setJoCrrCd		(delInvVo.getJoCrrCd());
	    					delInvDtlVo.setInvNo		(delInvVo.getInvNo());
	    					delInvDtlVo.setReDivrCd		(delInvVo.getReDivrCd());
	    					delInvDtlVo.setCreUsrId		(delInvVo.getCreUsrId());//Login User Id Setting
	    					
	    					//JOO_STL_TGT 에 SUM(ACT_AMT) , STL_RMK 에 INV_NO : SUM(ACT_AMT), .... Update.
		    				List<SettlementTargetVO> upStlList = dbDao.searchSettlementTargetListForDelInvoiceNo(delInvDtlVo);
		    				for(SettlementTargetVO upStlVo : upStlList){
		    					upStlVo.setCreUsrId		(delInvDtlVo.getCreUsrId());//Login User Id Setting
		    					dbDao.modifySettlementTargetForDelInvoiceNo(upStlVo);
	    					}
		    				
		    				//JOO_INV_DTL 삭제
	    					dbDao.removeInvoiceDetail(delInvDtlVo);
	    					
		    				//JOO_INVOICE 삭제.
	    					dbDao.removeInvoice(delInvVo);
	    				}
    				}
    			}
    		}
    	} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Delete", "Save"}).getMessage(), ex);
         }
    }	


	/**
	 * Retrieve : Invoice Inquiry : Summary 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceReportSummaryList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceReportSummaryList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Inquiry Summary", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Inquiry Summary", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Retrieve : Invoice Inquiry : Detail 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws Exception
	 */
	public List<InvoiceDetailVO> searchInvoiceReportDetailList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchInvoiceReportDetailList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Inquiry Detail", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Inquiry Detail", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Retrieve : Settlement Target Summary 조회.
	 * 
	 * @category FNS_JOO_0108
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchSettlementTargetSummaryList(ConsultationConditionVO consultationConditionVO) throws EventException {
		try {
			return dbDao.searchSettlementTargetSummaryList(consultationConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Target Summary", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Target Summary", "Retrieve"}).getMessage(), ex);

		}
	}
}