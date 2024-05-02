/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalBCImpl.java
*@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration.RFATransportationAdditionalChargeProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * RFAProposal Business Logic Basic Command implementation<br>
 * - handling biz logic about RFAProposal <br>
 *
 * @author 
 * @see ESM_PRI_2003_04EventResponse,RFATransportationAdditionalChargeProposalBC reference each DAO class
 * @since J2EE 1.4
 */
public class RFATransportationAdditionalChargeProposalBCImpl extends BasicCommandSupport implements RFATransportationAdditionalChargeProposalBC {

	// Database Access Object
	private transient RFATransportationAdditionalChargeProposalDBDAO dbDao = null;

	/**
	 * SCTransportationAdditionalChargeProposalBCImpl object creation<br>
	 * creating SCTransportationAdditionalChargeProposalDBDAO <br>
	 */
	public RFATransportationAdditionalChargeProposalBCImpl() {
		dbDao = new RFATransportationAdditionalChargeProposalDBDAO();
	}
	
	/**
	 * retrieving Arbitrary List <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeList(priRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}  catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * modifying Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpTrspAddChgVO> insertVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			List<PriRpScpTrspAddChgVO> deleteVoList = new ArrayList<PriRpScpTrspAddChgVO>();
		
			for ( int i=0; i<priRpScpTrspAddChgVOs .length; i++ ) {
				if ( priRpScpTrspAddChgVOs[i].getIbflag().equals("I")){
					priRpScpTrspAddChgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpScpTrspAddChgVOs[i]);
				} else if ( priRpScpTrspAddChgVOs[i].getIbflag().equals("U")){
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				} else if ( priRpScpTrspAddChgVOs[i].getIbflag().equals("D")){
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryCharge(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyArbitraryCharge(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeArbitraryCharge(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * accepting Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			
			for(int i=0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if(priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priRpScpTrspAddChgVOs[i].setAcptDt(currentDate);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * accept canceling Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			
			for(int i=0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if(priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setFnlFrtRtAmt(null);
					priRpScpTrspAddChgVOs[i].setAcptUsrId("");
					priRpScpTrspAddChgVOs[i].setAcptOfcCd("");			
					priRpScpTrspAddChgVOs[i].setAcptDt(null);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * accepting all Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			
			for(int i=0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if(priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priRpScpTrspAddChgVOs[i].setAcptDt(currentDate);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * accept canceling Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			
			for(int i=0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if(priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setFnlFrtRtAmt(null);
					priRpScpTrspAddChgVOs[i].setAcptUsrId("");
					priRpScpTrspAddChgVOs[i].setAcptOfcCd("");			
					priRpScpTrspAddChgVOs[i].setAcptDt(null);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Copying Arbitrary's Guideline <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriRpScpTrspAddChgVO.setCreUsrId(account.getUsr_id());
			cstPriRpScpTrspAddChgVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addCopyGuidelineArbitraryCharge(cstPriRpScpTrspAddChgVO, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * creating Amend Data<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);

			dbDao.addArbitraryChargeAmend (insertVoList);
				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	

	/**
     * Copying RFA Proposal Scope Transportation Additional Charge<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_TRSP_ADD_CHG COPY
            dbDao.addCopyProposalScopeTransport(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Guideline Origin/Destination Arbitrary to Proposal <br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rpScpGlineCopyVO.setCreUsrId(account.getUsr_id());
        	rpScpGlineCopyVO.setUpdUsrId(account.getUsr_id());
            // PRI_SP_SCP_TRSP_ADD_CHG COPY
            dbDao.addCopyScopeGuidelineArbitrary(rpScpGlineCopyVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    

	
    /**
     * checking existence of data to Guideline Copy <br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeExist(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * checking existence of GROUP LOCATION to Guideline Copy<br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeGroupLocationExist(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * when Request Cancel, setting Main Duration's Accepted data with Init<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancel(updateVoList);
			}
		} catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * when main's init state cancel, deleting this Amend Seq NO. all data<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposal(priRpScpMnVO);
		} catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * uploading excel file<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposal(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpTrspAddChgVO> insertVoList = new ArrayList<PriRpScpTrspAddChgVO>();
								
			for ( int i=0; i<priRpScpTrspAddChgVOs .length; i++ ) {
				if ( priRpScpTrspAddChgVOs[i].getIbflag().equals("I")){
					priRpScpTrspAddChgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpScpTrspAddChgVOs[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryExcel(insertVoList);
			}			
			
		} catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 * cheking excel file
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResult(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException{
		try {
			List<RsltPriRpScpTrspAddChgVO> checkVoList = new ArrayList<RsltPriRpScpTrspAddChgVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			//String custDefCd = "";
			
			for ( int i=0; i<rsltPriRpScpTrspAddChgVOs.length; i++ ) {
				//Point
				vo.setCd(rsltPriRpScpTrspAddChgVOs[i].getRoutPntLocDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if(cdList != null && cdList.size()>0) {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(rsltPriRpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setSvcScpCd(rsltPriRpScpTrspAddChgVOs[i].getSvcScpCd());
				vo.setPropNo(rsltPriRpScpTrspAddChgVOs[i].getPropNo());
				vo.setAmdtSeq(rsltPriRpScpTrspAddChgVOs[i].getAmdtSeq());
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchExcelCodeList(vo, "GRP");
				} else {
					cdList = dbDao.searchExcelCodeList(vo, "LOC");
				}
				
				if(cdList != null && cdList.size()>0) {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}
				/*
				//Actual Customer
				custDefCd = rsltPriRpScpTrspAddChgVOs[i].getCustDefCd();
				System.out.println("-------------------------->"+custDefCd);
				if(custDefCd.length() == 8) {
					vo.setPropNo(rsltPriRpScpTrspAddChgVOs[i].getPropNo());
					vo.setAmdtSeq(rsltPriRpScpTrspAddChgVOs[i].getAmdtSeq());
					vo.setSvcScpCd(rsltPriRpScpTrspAddChgVOs[i].getSvcScpCd());
					vo.setCd(custDefCd.substring(0, 2));
					vo.setEtc1(custDefCd.substring(2));
					cdList = dbDao.searchExcelCodeList(vo, "CUST");
										
					if(cdList != null && cdList.size()>0) {
						rsltPriRpScpTrspAddChgVOs[i].setCustDefCd("1");
					} else {
						rsltPriRpScpTrspAddChgVOs[i].setCustDefCd("0");
					}
				} else if(custDefCd.length() == 0) {
					rsltPriRpScpTrspAddChgVOs[i].setCustDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setCustDefCd("0");
				}
				*/				
				checkVoList.add(rsltPriRpScpTrspAddChgVOs[i]);
			} 
			
			return checkVoList;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Arbitrary's ORIGIN and DESTINATION's FONT STYLE <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary Amend History List retrieving <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeHistoryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Arbitrary's ORIGIN and DESTINATION's FONT STYLE <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchHistoryFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary Inquiry List retrieving <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeInquiryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeInquiryList(priRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Arbitrary note and content distinctly in curret amendment<br>
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCurrentNoteSeqContent(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException {
        try {
        	return dbDao.searchCurrentNoteSeqContent(rsltPriRpScpTrspAddChgVOs);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
}
