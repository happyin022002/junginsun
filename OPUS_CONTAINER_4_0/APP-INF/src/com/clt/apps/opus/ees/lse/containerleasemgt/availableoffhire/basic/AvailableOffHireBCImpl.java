/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireBCImpl.java
*@FileTitle : Available Off Hire Q'ty
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration.AvailableOffHireDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration.AvailableOffHireEAIDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireRegisterVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Interface of Biz Logic of Containerleasemgt<br>
 *
 * @author 
 * @see Ees_lse_0020EventResponse 
 * @since J2EE 1.6
 */
public class AvailableOffHireBCImpl extends BasicCommandSupport implements AvailableOffHireBC {

	// Database Access Object
	private transient AvailableOffHireDBDAO dbDao = null;
	// EAI Access Object
	private transient AvailableOffHireEAIDAO eaiDao = null;

	/**
	 * Generating AvailableOffHireBCImpl Object<br>
	 * Generating AvailableOffHireDBDAO<br>
	 */
	public AvailableOffHireBCImpl() {
		dbDao = new AvailableOffHireDBDAO();
		eaiDao = new AvailableOffHireEAIDAO();
	}

	/**
	 * Retrieving current state of equipment possible to return by Region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireSummaryVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireSummaryVO> searchAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireSummaryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerSummaryData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Requesting current state of equipment possible to return by Region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerSummary");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerSummary BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * Retrieving details of equipment available to return <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireDetailVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireDetailVO> searchAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireDetailVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerDetailData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Requesting details of equipment available to return<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerDetail");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerDetail BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * Sending details of selected equipment available to return by Email<br>
	 *
	 * @param EmailSendInfoVO emailSendInfoVO
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
    public void sendToEmailAvailableOffHireContainerBasic(EmailSendInfoVO emailSendInfoVO, AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			String resultMsg = eaiDao.sendToEmailAvailableOffHireContainerData(emailSendInfoVO);
			
			if(resultMsg == null || resultMsg.equals("")) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage());
			}

			for(int i = 0; i < availableOffHireDetailVOs.length; i++) {
				availableOffHireDetailVOs[i].setCreUsrId(userAccount.getUsr_id());

				if(availableOffHireDetailVOs[i].getIbflag().equals("U")) {
					dbDao.addAvailableOffHireContainerDetailData(availableOffHireDetailVOs[i]);
				}
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch (MailerAppException me) {
			log.error("err " + me.toString(), me);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage(),me);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage(),ex);
		}
	}
    
    /**
	 * modify status of selected equipment available to return<br>
	 *
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
    public void modifyAvailableOffHireContainerBasic(AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			for(int i = 0; i < availableOffHireDetailVOs.length; i++) {
				availableOffHireDetailVOs[i].setCreUsrId(userAccount.getUsr_id());

				if(availableOffHireDetailVOs[i].getIbflag().equals("U")) {
					dbDao.addAvailableOffHireContainerDetailData(availableOffHireDetailVOs[i]);
				}
			}
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainer Modified"}).getMessage(),ex);
		}
	}

    /**
	 * Retrieving current state of confirmed equipments available to return by region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireConfirmVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireConfirmVO> searchAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireConfirmVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerConfirmData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Requesting current state of confirmed equipments available to return by region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerConfirm");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerConfirm BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * Modifying all details of selected equipment into return fixed data<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerConfirmBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<AvailableOffHireConfirmVO> updateVoList = new ArrayList<AvailableOffHireConfirmVO>();
			List<AvailableOffHireConfirmVO> deleteVoList = new ArrayList<AvailableOffHireConfirmVO>();

			for(int i = 0; i < availableOffHireConfirmVOs.length; i++ ) {
				if(availableOffHireConfirmVOs[i].getIbflag().equals("U")) {
					availableOffHireConfirmVOs[i].setUpdUsrId(userAccount.getUsr_id());

					if(availableOffHireConfirmVOs[i].getOffhStsCd().equals("D")) {//Cancel
						deleteVoList.add(availableOffHireConfirmVOs[i]);
					} else {//Request & Confirm
						updateVoList.add(availableOffHireConfirmVOs[i]);
					}
				}
			}

			if(updateVoList.size() > 0) {
				dbDao.modifyAvailableOffHireContainerConfirmData(updateVoList);
			}
			if(deleteVoList.size() > 0) {
				dbDao.removeAvailableOffHireContainerConfirmData(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage(),ex);
		}
	}


	/**
	 * Retrieving Target Location of registered equipments available to return<br>
	 *
	 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws EventException
	*/ 
	public List<AvailableOffHireRegisterVO> modifyAvailableOffHireContainerTargetBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException {
		List<AvailableOffHireRegisterVO> resultVOs = null; 
		
		try {
			resultVOs = dbDao.addAvailableOffHireContainerTargetData(availableOffHireRegisterVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerTarget Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerTarget Search"}).getMessage(),ex);
		}
		return resultVOs;
	}

	/**
	 * Retrieving current state of registered equipments available to return<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerTargetBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerTarget");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerConfirm BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm BackEndJob"}).getMessage(),ex);
		}
	} 
	
	/**
	 * Modifying return state of selected equipment <br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerStatusBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			for(int i = 0; i < availableOffHireConfirmVOs.length; i++) {
				availableOffHireConfirmVOs[i].setUpdUsrId(userAccount.getUsr_id());
				String offhStsCd = availableOffHireConfirmVOs[i].getOffhStsCd();

				if(offhStsCd.equals("L")) {//Off-Hire Status is 'LSO'
					trxCnt += dbDao.modifyAvailableOffHireContainerStatusData(availableOffHireConfirmVOs[i]);
				} else {//Off-Hire Status is 'Cancel'
					trxCnt += dbDao.removeAvailableOffHireContainerStatusData(availableOffHireConfirmVOs[i]);
				}
			}
/*
			if(trxCnt < availableOffHireConfirmVOs.length) {
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage());
			}
*/			
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage(),ex);
		}
	}

	/**
	 * Retrieving Code List of AvailableOffHire Yard <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireYardCodeVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireYardCodeVO> searchAvailableOffHireYardCodeListBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireYardCodeVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchAvailableOffHireYardCodeListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving state value about result of BackEndJob<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
	 /**
		 * Retrieving current state of registered equipments available to return by region<br>
		 *
		 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
		 * @return List<AvailableOffHireRegisterVO>
		 * @throws EventException
		 */
		public List<AvailableOffHireRegisterVO> searchAvailableTargetLocationBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException {
			List<AvailableOffHireRegisterVO> resultVOs = null; 
			try {
				resultVOs = dbDao.addAvailableOffHireContainerLocationData(availableOffHireRegisterVO);
			} catch(DAOException de) {
				log.error("err " + de.getMessage(), de);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),de);
			} catch (Exception ex) {
				log.error("err " + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),ex);
			}
			return resultVOs;
		}
		
		/**
		 * Retrieving current state of registered equipments available to return by region<br>
		 *
		 * @param  AvailableOffHireRegisterVO[] availableOffHireRegisterVOs
		 * @param SignOnUserAccount userAccount
		 * @throws EventException
		 */
		public void modifyTargetOffHireContainerRegisterBasic(AvailableOffHireRegisterVO[] availableOffHireRegisterVOs, SignOnUserAccount userAccount) throws EventException {
			try {
				List<AvailableOffHireRegisterVO> insertVoList = new ArrayList<AvailableOffHireRegisterVO>();
				List<AvailableOffHireRegisterVO> deleteVoList = new ArrayList<AvailableOffHireRegisterVO>();
				String strLocCd = "";
				String strEqLocTpCd = "";
				
				
				for(int i = 0; i < availableOffHireRegisterVOs.length; i++) {
					deleteVoList.add(availableOffHireRegisterVOs[i]);
					dbDao.deleteTargetOffHireContainerLocationData(deleteVoList);
				}
				
				for(int i = 0; i < availableOffHireRegisterVOs.length; i++) {					
					insertVoList.add(availableOffHireRegisterVOs[i]);
					strLocCd = insertVoList.get(i).getLocCd();
					strEqLocTpCd = insertVoList.get(i).getEqLocTpCd();
					for(int j=0;j<strLocCd.split(",").length;j++) {
						availableOffHireRegisterVOs[i].setLocCd(strLocCd.split(",")[j]);
						availableOffHireRegisterVOs[i].setEqLocTpCd(strEqLocTpCd.split(",")[j]);
						availableOffHireRegisterVOs[i].setUpdUsrId(userAccount.getUsr_id());
						availableOffHireRegisterVOs[i].setCreUsrId(userAccount.getUsr_id());
						dbDao.modifyTargetOffHireContainerLocationData(availableOffHireRegisterVOs[i]);
					}
				}
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("MST00013").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),ex);
			}
		}
		
		 /**
		 * Retrieving agreement information to register target off-hire location<br>
		 *
		 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
		 * @return List<AvailableOffHireRegisterVO>
		 * @throws EventException
		 */
		public List<AvailableOffHireRegisterVO> searchTargetOffHireContainerAgreementBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException {
			List<AvailableOffHireRegisterVO> resultVOs = null; 
			try {
				resultVOs = dbDao.searchTargetOffHireContainerAgreementData(availableOffHireRegisterVO);
			} catch(DAOException de) {
				log.error("err " + de.getMessage(), de);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),de);
			} catch (Exception ex) {
				log.error("err " + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),ex);
			}
			return resultVOs;
		}
}
