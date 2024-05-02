/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentCanalTransitFeeBCImpl.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration.AgentCanalTransitFeeBCDBDAO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.PsoCanalInvAttachFileVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.clt.syscommon.common.table.PsoCnlTzFeeVO;
import com.clt.syscommon.common.table.PsoMsaDtlVO;
import com.clt.syscommon.common.table.PsoMsaVO;
import com.clt.syscommon.common.table.PsoTgtVvdVO;

/**
 * ALPS-AgentCanalTransitFee Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-AgentCanalTransitFee<br>
 *
 * @author
 * @see EXP_SPP_0001 EventResponse,AgentCanalTransitFeeBC, refers each DAO classes
 * @since J2EE 1.6
 */
public class AgentCanalTransitFeeBCImpl extends BasicCommandSupport implements AgentCanalTransitFeeBC {

	// Database Access Object
	private transient AgentCanalTransitFeeBCDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating AgentCanalTransitFeeBCDBDAO<br>
	 */
	public AgentCanalTransitFeeBCImpl() {
		dbDao = new AgentCanalTransitFeeBCDBDAO();
	}

	/**
	 * Retrieving Canal Invoice<br>
	 * 
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 * @exception EventException
	 */	
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(
			CanalTzFeeSumVO canalTzFeeSumVO) throws EventException {
		try {
			return dbDao.searchCanalTzFeeSumRpt(canalTzFeeSumVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitList Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitList Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving VVD <br>
	 * 
	 * @param CanalTzVVDListVO canalTzVVDListVO
	 * @return List<CanalTzVVDListVO>
	 * @exception EventException
	 */	
	public List<CanalTzVVDListVO> searchCanalTzVVDList(
			CanalTzVVDListVO canalTzVVDListVO) throws EventException {
		try {
			return dbDao.searchCanalTzVVDList(canalTzVVDListVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitList Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitList Search"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Requested Advanced Payment windows_open<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 * @exception EventException
	 */
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		try {
			return dbDao.searchCanalTzFeeEstDtlByVvd(canalTzFeeEstDtlByVvdCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"AdvanceVVD Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"AdvanceVVD Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving Advanced Payment windows_open allowance TEU<br>
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzAllowanceTEUVO
	 * @exception EventException
	 */
	public CanalTzAllowanceTEUVO searchCanalTzAllowanceTEU(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		try {
			return dbDao.searchCanalTzAllowanceTEU(canalTzFeeEstDtlByVvdCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"AdvanceVVD Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"AdvanceVVD Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Saving or requesting CanalTzFee by VVD<br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @param PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	public void manageCanalTzFeeByVvd(PsoCnlTzFeeVO psoCnlTzFeeVO, PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs, SignOnUserAccount account) throws EventException {
		try {
			if(psoCnlTzFeeVO!=null && psoCnlTzFeeVO.getCnlTzProcStsCd()!=null && psoCnlTzFeeVO.getCnlTzBztpCd()!=null){
				
				if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("R")){
					saveCanalTzFeeByVvd(psoCnlTzFeeVO, psoCnlTzFeeDtlVOs, account);
				}else if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("Q")){
					requestCanalTzFeeByVvd(psoCnlTzFeeVO, account);
				}
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitFee Save"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Saving CanalTzFee by VVD<br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @param PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	
	private void saveCanalTzFeeByVvd(PsoCnlTzFeeVO psoCnlTzFeeVO, PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs, SignOnUserAccount account) throws EventException {
		
		try {
			
			int checkMsa = dbDao.searchMsaCnt(psoCnlTzFeeVO);
			
			if(checkMsa > 0){
				throw new EventException(new ErrorHandler("SPP01017", new String[]{"MSA Status is not Ready."}).getMessage());
			}else{
				//Inserting PSO_CNL_TZ_FEE 			
	    		if(psoCnlTzFeeVO !=null) {
	    			
	    			psoCnlTzFeeVO.setCreUsrId(account.getUsr_id());
	    			psoCnlTzFeeVO.setUpdUsrId(account.getUsr_id());
	    			
	    			if(psoCnlTzFeeVO.getDiffRmk()!=null && psoCnlTzFeeVO.getDiffRmk().toLowerCase().trim().equals("rejected")){
	    				psoCnlTzFeeVO.setDiffRmk("");
	    			}
	    			
	    			log.info("##### psoCnlTzFeeVO : "+psoCnlTzFeeVO.getColumnValues());
	    			
	        		int checkPso = dbDao.searchCanalTzFeeCnt(psoCnlTzFeeVO);
	    			
	    			if(checkPso > 0){
	    				dbDao.modifyPsoCnlTzFee(psoCnlTzFeeVO); 
	    			}else{
	    				dbDao.addPsoCnlTzFee(psoCnlTzFeeVO);  
	    			}
	    			
	    		}	
				
				//Inserting PSO_CNL_TZ_FEE_DTL
	    		if(psoCnlTzFeeDtlVOs != null){
	    			
	    			for (int i = 0; i < psoCnlTzFeeDtlVOs.length; i++) {
	    				
	    				//Not saving the invoice data if the length of LGS_COST_CD is 4(lgs_cost_cd_clss_lvl is 'D')
						if(psoCnlTzFeeVO.getCnlTzBztpCd().equals("I") && psoCnlTzFeeDtlVOs[i].getLgsCostCd().length()==4) continue;
						PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO = null;
						
						psoCnlTzFeeDtlVO = psoCnlTzFeeDtlVOs[i];
						psoCnlTzFeeDtlVO.setPsoBztpCd("5");
						psoCnlTzFeeDtlVO.setVslCd(psoCnlTzFeeVO.getVslCd());
						psoCnlTzFeeDtlVO.setSkdVoyNo(psoCnlTzFeeVO.getSkdVoyNo());
						psoCnlTzFeeDtlVO.setSkdDirCd(psoCnlTzFeeVO.getSkdDirCd());
						psoCnlTzFeeDtlVO.setYdCd(psoCnlTzFeeVO.getYdCd());
						psoCnlTzFeeDtlVO.setCallSeq(psoCnlTzFeeVO.getCallSeq());
						psoCnlTzFeeDtlVO.setCreUsrId(account.getUsr_id());
						psoCnlTzFeeDtlVO.setUpdUsrId(account.getUsr_id());
						
						
						if(!psoCnlTzFeeDtlVOs[i].getRqstAmt().equals("")){
							
							if(psoCnlTzFeeDtlVOs[i].getRqstAmt().equals("0")){
								//Deleting PSO_CNL_TZ_FEE_DTL
				        		dbDao.deletePsoCnlTzFeeDtl(psoCnlTzFeeDtlVO);
							}else{
								//Deleting PSO_CNL_TZ_FEE_DTL
				        		dbDao.deletePsoCnlTzFeeDtl(psoCnlTzFeeDtlVO);
				    			dbDao.addPsoCnlTzFeeDtl(psoCnlTzFeeDtlVO);
							}
						}else{
							//Deleting PSO_CNL_TZ_FEE_DTL
			        		dbDao.deletePsoCnlTzFeeDtl(psoCnlTzFeeDtlVO);
						}
					}
	    		}
			}
		} catch(EventException ex) {
			log.error(ex.getMessage());
			throw ex;	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler("ORA00001").getUserMessage());
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitFee Save"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitFee Save"}).getMessage(),ex);
		}
	}	

	/**
	 * Requesting CanalTzFee by VVD<br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	
	private void requestCanalTzFeeByVvd(PsoCnlTzFeeVO psoCnlTzFeeVO, SignOnUserAccount account)  throws EventException {
		try {
			
			//Inserting PSO_CNL_TZ_FEE			
    		if(   !psoCnlTzFeeVO.getVslCd().equals("")
      		   && !psoCnlTzFeeVO.getSkdVoyNo().equals("")
      		   && !psoCnlTzFeeVO.getSkdDirCd().equals("")
      		   && !psoCnlTzFeeVO.getYdCd().equals("")
      		   && !psoCnlTzFeeVO.getCallSeq().equals("")
          	  ) {
    			
    			psoCnlTzFeeVO.setRqstUsrId(account.getUsr_id());
    			psoCnlTzFeeVO.setUpdUsrId(account.getUsr_id());

   				dbDao.modifyPsoCnlTzFee(psoCnlTzFeeVO);  //Modifying
    			
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitFee Request"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalTransitFee Request"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieving Request Actual Invoice by VVD<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeInvDtlByVvdVO>
	 * @exception EventException
	 */
	public List<CanalTzFeeInvDtlByVvdVO> searchCanalTzFeeInvDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		try {
			return dbDao.searchCanalTzFeeInvDtlByVvd(canalTzFeeEstDtlByVvdCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"InvoiceVVD Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"InvoiceVVD Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving Request Actual Invoice allowance TEU<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzInvAllowanceTEUVO
	 * @exception EventException
	 */
	public CanalTzInvAllowanceTEUVO searchCanalTzInvAllowanceTEU(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		try {
			return dbDao.searchCanalTzInvAllowanceTEU(canalTzFeeEstDtlByVvdCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"InvoiceVVD Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"InvoiceVVD Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving MSA Balance<br>
	 * 
	 * @param MsaBalVO msaBalVO
	 * @return List<MsaBalVO>
	 * @exception EventException
	 */	
	public List<MsaBalVO> searchMsaBal(MsaBalVO msaBalVO) throws EventException {
		try {
			return dbDao.searchMsaBal(msaBalVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Saving or requesting MSA Balance<br>
	 * 
	 * @param PsoMsaVO psoMsaVO
	 * @param MsaBalVO[] msaBalVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	public void manageMsaBal(PsoMsaVO psoMsaVO, MsaBalVO[] msaBalVOs, SignOnUserAccount account) throws EventException {
		try {
			if(psoMsaVO!=null && psoMsaVO.getRevYrmon()!=null && psoMsaVO.getVndrSeq()!=null){
				
				if(psoMsaVO.getPsoMsaStsCd().equals("R")){
					saveMsaBal(psoMsaVO, msaBalVOs, account);
				}else if(psoMsaVO.getPsoMsaStsCd().equals("Q")){
					requestMsaBal(psoMsaVO, account);
				}
			}

		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Save"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Saving MSA<br>
	 * 
	 * @param PsoMsaVO psoMsaVO
	 * @param MsaBalVO[] msaBalVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	private void saveMsaBal(PsoMsaVO psoMsaVO, MsaBalVO[] msaBalVOs, SignOnUserAccount account) throws EventException {
		try {
			
			//Inserting PSO_MSA			
    		if( !psoMsaVO.getRevYrmon().equals("") && !psoMsaVO.getVndrSeq().equals("")){
    			
    			psoMsaVO.setRqstUsrId("");
    			psoMsaVO.setCreUsrId(account.getUsr_id());
    			psoMsaVO.setUpdUsrId(account.getUsr_id());

    			log.info("##### psoMsaVO : "+psoMsaVO.getColumnValues());
    			PsoCnlTzFeeVO psoCnlTzFeeVO = new PsoCnlTzFeeVO();
    			
    			psoCnlTzFeeVO.setRevYrmon(psoMsaVO.getRevYrmon());
    			psoCnlTzFeeVO.setVndrSeq(psoMsaVO.getVndrSeq());
    			
    			int checkMsa = dbDao.searchMsaCnt(psoCnlTzFeeVO);
    			
    			if(checkMsa > 0){
    				dbDao.modifyPsoMsa(psoMsaVO);
    			}else{
    				dbDao.addPsoMsa(psoMsaVO);
    			}
    		}		
			
			//Inserting PSO_MSA_DTL
    		if(msaBalVOs != null){
				for (int i = 0; i < msaBalVOs.length; i++) {
					PsoMsaDtlVO psoMsaDtlVO = new PsoMsaDtlVO();
	
					if(   !msaBalVOs[i].getRevYrmon().equals("")
					   && !msaBalVOs[i].getVndrSeq().equals("")
					   && !msaBalVOs[i].getMsaSeq().equals("")
					  ){
						psoMsaDtlVO.setRevYrmon(msaBalVOs[i].getRevYrmon());
						psoMsaDtlVO.setVndrSeq(msaBalVOs[i].getVndrSeq());
						psoMsaDtlVO.setMsaSeq(msaBalVOs[i].getMsaSeq());
						psoMsaDtlVO.setPsoMsaAmtTpCd(msaBalVOs[i].getPsoMsaAmtTpCd());
						//Getting the value of ttl_amt
						String tmpAmountCredit = msaBalVOs[i].getAmountCredit();
						String tmpAmountDebit = msaBalVOs[i].getAmountDebit();
						String tmpTtlAmt = "0";
						if(tmpAmountCredit==null || tmpAmountCredit.equals("")) { tmpAmountCredit="0"; } 
						if(tmpAmountDebit==null || tmpAmountDebit.equals("")) { tmpAmountDebit="0"; } 
						tmpTtlAmt = String.valueOf(Float.parseFloat(tmpAmountCredit)-Float.parseFloat(tmpAmountDebit));
						if(msaBalVOs[i].getPsoMsaAmtTpCd().equals("B") || msaBalVOs[i].getPsoMsaAmtTpCd().equals("C")){
							tmpTtlAmt = String.valueOf(Math.abs(Float.parseFloat(tmpTtlAmt)));
						}
						
						psoMsaDtlVO.setTtlAmt(tmpTtlAmt);
						psoMsaDtlVO.setDiffRmk(msaBalVOs[i].getDiffRmk());
						psoMsaDtlVO.setCreUsrId(account.getUsr_id());
						psoMsaDtlVO.setUpdUsrId(account.getUsr_id());
		    			
		    			log.info("##### psoMsaDtlVO["+i+"] : "+psoMsaDtlVO.getColumnValues());
		        		
		        		dbDao.deletePsoMsaDtl(psoMsaDtlVO);
		    			dbDao.addPsoMsaDtl(psoMsaDtlVO);
		    			
					}
				}
    		}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Save"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Save"}).getMessage(),ex);
		}
	}
	
	/**
	 * Requesting Msa<br>
	 * 
	 * @param PsoMsaVO psoMsaVO
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */	
	private void requestMsaBal(PsoMsaVO psoMsaVO, SignOnUserAccount account) throws EventException {
		try {
			//Updating PSO_MSA			
    		if(!psoMsaVO.getRevYrmon().equals("") && !psoMsaVO.getVndrSeq().equals("")){
    			
    			psoMsaVO.setRqstUsrId(account.getUsr_id());
    			psoMsaVO.setUpdUsrId(account.getUsr_id());

    			log.info("##### psoMsaVO : "+psoMsaVO.getColumnValues());
   				dbDao.modifyPsoMsa(psoMsaVO);  //Updating
    		}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Request"}).getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSA Request"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving MSA Remittance<br>
	 *
	 * @param MsaRemVO msaRemVO
	 * @return List<MsaRemVO>
	 * @exception EventException
	 */	
	public List<MsaRemVO> searchMsaRem(MsaRemVO msaRemVO) throws EventException {
		try {
			return dbDao.searchMsaRem(msaRemVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSARemittance Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSARemittance Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving MSA Disbursement<br>
	 *
	 * @param MsaDisbVO msaDisbVO
	 * @return List<MsaDisbVO>
	 * @exception EventException
	 */	
	public List<MsaDisbVO> searchMsaDisb(MsaDisbVO msaDisbVO) throws EventException {
		try {
			return dbDao.searchMsaDisb(msaDisbVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSADisbursement Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"MSADisbursement Search"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieving Canal booking status for Panama<br>
	 * 
	 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
	 * @return List<CanalTzBkgVvdVO>
	 * @exception EventException
	 */	
	public List<CanalTzBkgVvdVO> searchCanalTzBkgVvd(CanalTzBkgVvdVO canalTzBkgVvdVO) throws EventException {
		int cnt = 0;  // The variable for the total count of data
		List<CanalTzBkgVvdVO> resultVOs = null;
		try {
			if(canalTzBkgVvdVO.getIPage()==null || canalTzBkgVvdVO.getIPage().equals("")){
				canalTzBkgVvdVO.setIPage("1");
			}
			if(canalTzBkgVvdVO.getPagerows()==null || canalTzBkgVvdVO.getPagerows().equals("")){
				canalTzBkgVvdVO.setPagerows(String.valueOf(Constants.PAGE_SIZE_100));
			}			
			
			cnt       = dbDao.searchCanalTzBkgVvdCountData(canalTzBkgVvdVO);
			resultVOs = dbDao.searchCanalTzBkgVvd(canalTzBkgVvdVO); 
			
			if ( resultVOs.size() > 0 ) {
				resultVOs.get(0).setMaxRows(cnt);
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalBooking Search"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalBooking Search"}).getMessage(),ex);
		}
		
		return resultVOs;		
	}
	
	/**
	 * Saving Canal booking status for Panama<br>
	 * 
	 * @param CanalTzBkgVvdVO[] canalTzBkgVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageCanalTzBkgList(CanalTzBkgVvdVO[] canalTzBkgVvdVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PsoTgtVvdVO> insertVoList = new ArrayList<PsoTgtVvdVO>();

			for (int i = 0; i < canalTzBkgVvdVOs.length; i++) {				
				PsoTgtVvdVO psoTgtVvdVO = new PsoTgtVvdVO();

        		if(   !canalTzBkgVvdVOs[i].getVslCd().equals("")
        		   && !canalTzBkgVvdVOs[i].getSkdVoyNo().equals("")
        		   && !canalTzBkgVvdVOs[i].getSkdDirCd().equals("")
        		   && !canalTzBkgVvdVOs[i].getPsoBztpCd().equals("")
        		  ) {
        			psoTgtVvdVO.setPsoBztpCd(canalTzBkgVvdVOs[i].getPsoBztpCd());
        			psoTgtVvdVO.setVslCd(canalTzBkgVvdVOs[i].getVslCd());
        			psoTgtVvdVO.setSkdVoyNo(canalTzBkgVvdVOs[i].getSkdVoyNo());
        			psoTgtVvdVO.setSkdDirCd(canalTzBkgVvdVOs[i].getSkdDirCd());

        			//Calculating the value of cnl_tz_bkg_sts_cd
        			if(canalTzBkgVvdVOs[i].getBStsCd().equals("1")){
        				psoTgtVvdVO.setCnlTzBkgStsCd("B");
        			}else if(canalTzBkgVvdVOs[i].getCStsCd().equals("1")){
        				psoTgtVvdVO.setCnlTzBkgStsCd("C");
        			}else if(canalTzBkgVvdVOs[i].getAStsCd().equals("1")){
        				psoTgtVvdVO.setCnlTzBkgStsCd("A");
        			}else{
        				psoTgtVvdVO.setCnlTzBkgStsCd("");
        			}
        			
        			psoTgtVvdVO.setUpdUsrId(account.getUsr_id());
        			
        			log.info("##### canalTzListVO["+i+"] : "+psoTgtVvdVO.getColumnValues());

	        		insertVoList.add(psoTgtVvdVO);
        		}

			}
			
			log.info("##### insertVoList.size() : "+insertVoList.size());
			
			if (insertVoList.size() > 0) {
				dbDao.modifyPsoTgtVvd(insertVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler("ORA00001").getUserMessage());
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalBooking Save"}).getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"CanalBooking Save"}).getMessage(),ex);
		}
	}	
	/**
	 * Canal Transit schedule 조회<br>
	 * 
	 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
	 * @return List<CanalTzBkgVvdVO>
	 * @exception EventException
	 */	
	public List<CanalTransitScheduleVO> searchCanalTransitSchedule(CanalTransitScheduleVO canalTransitScheduleVO) throws EventException {
		int cnt = 0;  // 조회 데이터 총카운트
		List<CanalTransitScheduleVO> resultVOs = null;
		try {
			if(canalTransitScheduleVO.getIPage()==null || canalTransitScheduleVO.getIPage().equals("")){
				canalTransitScheduleVO.setIPage("1");
			}
			if(canalTransitScheduleVO.getPagerows()==null || canalTransitScheduleVO.getPagerows().equals("")){
				canalTransitScheduleVO.setPagerows(String.valueOf(Constants.PAGE_SIZE_100));
			}			
			
			cnt       = dbDao.searchCanalTransitScheduleCountData(canalTransitScheduleVO);
			resultVOs = dbDao.searchCanalTransitSchedule(canalTransitScheduleVO); 
			log.debug("resultVOs.size : "+resultVOs.size());
			if ( resultVOs.size() > 0 ) {
				resultVOs.get(0).setMaxRows(cnt);
			}			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"Canal transit schedule Inquiry"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"Canal transit schedule Inquiry"}).getMessage(),ex);
		}
		
		return resultVOs;		
	}
	
	/**
	 * Requested Advanced Payment windows_open<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<PsoCanalInvAttachFileVO>
	 * @exception EventException
	 */
	public List<PsoCanalInvAttachFileVO> searchPsoCanalInvAttachFileList(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		try {
			return dbDao.searchPsoCanalInvAttachFileList(canalTzFeeEstDtlByVvdCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"Canal transit Attach File Inquiry"}).getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("SPP10005", new String[]{"Canal transit Attach File Inquiry"}).getMessage(),ex);
		}
	}
	
}