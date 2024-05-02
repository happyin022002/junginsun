/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOBunkerRegisterBCImpl.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration.TCharterIOBunkerRegisterDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerConditionVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutAccounting<br>
 *
 * @author 
 * @see TCharterIOBunkerRegisterBC,TCharterIOBunkerRegisterBCImpl each DAO Class
 * @since J2EE 1.5
 */

public class TCharterIOBunkerRegisterBCImpl extends BasicCommandSupport implements TCharterIOBunkerRegisterBC {

	// Database Access Object
	private transient TCharterIOBunkerRegisterDBDAO dbDao = null;

	/**
	 * Generating ITCharterIOBunkerRegisterBCImpl object<br>
	 * Generaging ITCharterIOBunkerRegisterDBDAO<br>
	 */
	public TCharterIOBunkerRegisterBCImpl() {
		dbDao = new TCharterIOBunkerRegisterDBDAO();
	}
	
	/**
	 * Getting Bunker information<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO
	 * @return List<SearchBunkerVO>
	 * @exception EventException
	 */
	public List<SearchBunkerVO> searchBunkerList(SearchBunkerVO searchBunkerVO) throws EventException {
		try {
			//validationCheck(mandatory insert value)
			//validationCheck(searchBunkerVO);
			
			return dbDao.searchBunkerList(searchBunkerVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling Multi-events of Bunker window(Insert/Modify/Delete)<br>
	 * 
	 * @param customBunkerVOs CustomBunkerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageBunker(CustomBunkerVO[] customBunkerVOs, String usrId) throws EventException{
		try {
			List<CustomBunkerVO> addVoList 	  = new ArrayList<CustomBunkerVO>();
			List<CustomBunkerVO> modifyVoList = new ArrayList<CustomBunkerVO>();
			List<CustomBunkerVO> removeVoList = new ArrayList<CustomBunkerVO>();

			for(int i=0; i<customBunkerVOs.length; i++) {
				if(customBunkerVOs[i].getIbflag().equals("I")) {
					customBunkerVOs[i].setCreUsrId(usrId);
					customBunkerVOs[i].setUpdUsrId(usrId);
					addVoList.add(customBunkerVOs[i]);
					
				} else if(customBunkerVOs[i].getIbflag().equals("U")) {
					customBunkerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customBunkerVOs[i]);
					
				} else if(customBunkerVOs[i].getIbflag().equals("D")) {
					removeVoList.add(customBunkerVOs[i]);
				}
			}
			
			if(removeVoList.size() > 0) {
				dbDao.removeBunkers(removeVoList);
			}
			
			if(addVoList.size() > 0) {
				dbDao.addBunkers(addVoList);
			}
			
			if(modifyVoList.size() > 0) {
				dbDao.modifyBunkers(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Getting VslCd relevant to Contract Number
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchIdVslCdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchIdVslCdByBunkerVO> searchIdVslCdListByBunker(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchIdVslCdListByBunker(fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Voyage relevant to vslCd and bnkDt<br>
	 * 
	 * @param vslCd String
	 * @param bunkerDt String
	 * @param fletCtrtNo String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdByBunkerVO> searchVvdListByBunker(String vslCd, String bunkerDt, String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchVvdListByBunker(vslCd, bunkerDt, fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01205",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01205",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Location Code<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCdByBunker(String locCd) throws EventException {
		try {
			return dbDao.searchCheckLocCdByBunker(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01206",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01206",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Data to be updated at Contract table from Bunker table<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param bnkYrmon String 
	 * @return List<ContractByBunkerVO>
	 * @exception EventException
	 */
	public List<ContractByBunkerVO> searchContractByBunker(String fletCtrtNo, String bnkYrmon) throws EventException {
		try {
			//bnkYrmon = JSPUtil.removeCharacter(bnkYrmon,"-");
			
			return dbDao.searchContractByBunker(fletCtrtNo, bnkYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Checking mandatory insert list on Bunker Data Management window<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO 
	 * @exception EventException
	 */
	/*private void validationCheck(SearchBunkerVO searchBunkerVO) throws EventException {
		
		String msgCode = "";
		
		try {
			if(   searchBunkerVO.getBnkYrmon().equals("")
			   || searchBunkerVO.getFletCtrtNo().equals("")
			   || searchBunkerVO.getVslCd().equals("")) {
				
				if(searchBunkerVO.getBnkYrmon().equals("")) {
					msgCode = "FMS01024";
				} else if(searchBunkerVO.getFletCtrtNo().equals("")) {
					msgCode = "FMS01025";
				} else if(searchBunkerVO.getVslCd().equals("")) {
					msgCode = "FMS01097";
				}
				
				throw new EventException(new ErrorHandler(msgCode,new String[]{}).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}*/
	
	
	/**
	 * Updating Invoice table after generating Slip<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipBunkers(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException{
		try {
			List<CustomPamCsulSlpVO> modifyVoList = new ArrayList<CustomPamCsulSlpVO>();

			for(int i=0; i<customPamCsulSlpVOs.length; i++) {
				if(   customPamCsulSlpVOs[i].getIbflag().equals("I")
				   && !customPamCsulSlpVOs[i].getBnkSeq().equals("")
				   && !customPamCsulSlpVOs[i].getFletCtrtNo().equals("")) {
					
					customPamCsulSlpVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
					customPamCsulSlpVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
					customPamCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customPamCsulSlpVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
					
					modifyVoList.add(customPamCsulSlpVOs[i]);
					
				}
			}
			
			
			if(modifyVoList.size() > 0) {
				dbDao.modifyPaymentSlipBunkers(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Modifying related list at Calculation table when Hire Out Slip is generated<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyRevSlips = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(customCsulSlpVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_BUNKER)) { //2015.11.10 Modify Bunker Account 
					//2014.10.01 NYK Modify
					String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setSlpIssDt(tmpSlpIssDt);
					
					modifyRevSlips.add(customCsulSlpVOs[i]);
				}
			}
	
			if ( modifyRevSlips.size() > 0 ) {
				dbDao.modifySubletRevenueSlips(modifyRevSlips);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * In case of AP, AR Hire Out, Slip information of Bunker is updated as Null when Slip is canceled<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyApArSlipApprovalCancelBunker(String csrNo, String usrId) throws EventException{
		try {
			
			if(csrNo.substring(0,3).equals("20T")) {
				//Updating Bunker Slip information about AR Hire Out as Null 
				dbDao.modifyArSlipApprovalCancelBunker( csrNo , usrId );
			} else {
				//Updating Bunker Slip information about AP Hire Out as Null 
				dbDao.modifyApSlipApprovalCancelBunker( csrNo , usrId );
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * In case of Charter, Slip information of Bunker is updated as Null when Slip is canceled <br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelBunker(String csrNo, String usrId) throws EventException{
		try {
			
			dbDao.modifySlipApprovalCancelBunker( csrNo , usrId );
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Retrieving the data which is selected to be handled as payment slip on created BOD / BOR Data / Window<br>
	 * 
	 * NYK Modify 2014.10.22
	 * @param searchBunkerConditionVO SearchBunkerConditionVO
	 * @return List<SearchBunkerListByPaymentSlipVO>
	 * @throws EventException
	 */
	public List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlip(SearchBunkerConditionVO searchBunkerConditionVO) throws EventException {
		try {
			return dbDao.searchBunkerListByPaymentSlip(searchBunkerConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01407",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01407",new String[]{}).getMessage(), ex);
		}
	}
	
}