/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalBCImpl.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration.MisUseApprovalDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * Handling Biz Logic of ContainerLeaseMgt<br>
 *
 * @author 
 * @see EES_LSE_0027EventResponse,MisUseApprovalBC 
 * @since J2EE 1.6
 */
public class MisUseApprovalBCImpl extends BasicCommandSupport implements MisUseApprovalBC {

	// Database Access Object
	private transient MisUseApprovalDBDAO dbDao = null;

	/**
	 * Generating MisUseApprovalBCImpl Object<br>
	 * Generating MisUseApprovalDBDAO<br>
	 */
	public MisUseApprovalBCImpl() {
		dbDao = new MisUseApprovalDBDAO();
	}

	/**
	 * Retrieving Max Miss Use Request No.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseRequestNumberBasic(String ofcCd) throws EventException {
		String rqstNo = null;

		try {
			rqstNo = dbDao.searchNewMisUseRequestNumberData(ofcCd);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseRequestNumber Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseRequestNumber Search"}).getMessage(),ex);
		}

		return rqstNo;
	}

	/**
	 * Checking duplication of request List about inserted Container No.<br>
	 *
	 * @param  String cntrNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchMisUseReqContainerExistBasic(String cntrNo) throws EventException {
		boolean existFlag = false;
		List<MisUseReqContainerVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseReqContainerExistData(cntrNo);
			existFlag = resultVOs.size() > 0 ? true : false;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerExist Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerExist Search"}).getMessage(),ex);
		}

		return existFlag;
	}

	/**
	 * Retrieving Basic information of inserted Container No.<br>
	 *
	 * @param  String cntrNo
	 * @param  SignOnUserAccount account
	 * @return List<MisUseContainerInfoVO>
	 * @exception EventException
	 */
	public List<MisUseContainerInfoVO> searchMisUseRequestContainerBasic(String cntrNo, SignOnUserAccount account) throws EventException {
		List<MisUseContainerInfoVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseRequestContainerData(cntrNo,account);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Saving Miss Use Request List and Equipment List<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseRequestNumberListBasic(MisUseRequestVO misUseRequestVO, MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//Retrieving Max Miss Use Request No.
			//String rqstNo = dbDao.searchNewMisUseRequestNumberData(misUseRequestVO.getRqstOfcCd());
			//if(rqstNo.equals(misUseRequestVO.getRqstNo()) == false) {
			//	throw new EventException(new ErrorHandler("LSE01076",new String[]{"User Information"}).getMessage());
			//}

			misUseRequestVO.setCreUsrId(userAccount.getUsr_id());
			dbDao.addMisUseRequestInfoData(misUseRequestVO);

			List<MisUseReqContainerVO> insertVoList = new ArrayList<MisUseReqContainerVO>();
			for(int i = 0; i < misUseReqContainerVOs.length; i++ ) {
				if(misUseReqContainerVOs[i].getIbflag().equals("I")) {
					misUseReqContainerVOs[i].setCreUsrId(userAccount.getUsr_id());
					insertVoList.add(misUseReqContainerVOs[i]);
				}
			}
			if(insertVoList.size() > 0) {
				dbDao.addMisUseReqContainerInfoListData(insertVoList);
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberList Create"}).getMessage(),ex);
		}
	}

	/**
	 * Retrieving Max Miss Use Approval No.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseApprovalNumberBasic(String ofcCd) throws EventException {
		String aproNo = null;

		try {
			aproNo = dbDao.searchNewMisUseApprovalNumberData(ofcCd);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseApprovalNumber Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseApprovalNumber Search"}).getMessage(),ex);
		}

		return aproNo;
	}

	/**
	 * Retrieving List of Miss Use Request No. subject to approval<br>
	 *
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestNoItemsBasic() throws EventException {
		List<MisUseRequestVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseRequestNoItemsData();
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberItems Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberItems Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving request information of selected Request No.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestInfoBasic(String rqstNo) throws EventException {
		List<MisUseRequestVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseRequestInfoData(rqstNo);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving Equipment List of selected Request No.<br>
	 *
	 * @param  String rqstNo
	 * @param  SignOnUserAccount account
	 * @return List<MisUseReqContainerVO>
	 * @exception EventException
	 */
	public List<MisUseReqContainerVO> searchMisUseReqContainerListBasic(String rqstNo, SignOnUserAccount account) throws EventException {
		List<MisUseReqContainerVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseReqContainerListData(rqstNo, account);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Saving Miss Uss Approval List and Equipment List<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseApprovalVO misUseApprovalVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseApprovalNumberListBasic(MisUseRequestVO misUseRequestVO,MisUseApprovalVO misUseApprovalVO,MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//Retrieving Max Miss Use Approval No.
			String aproNo = dbDao.searchNewMisUseApprovalNumberData(misUseApprovalVO.getAproOfcCd());
			if(aproNo.equals(misUseRequestVO.getAproNo()) == false) {
				throw new EventException(new ErrorHandler("LSE01128",new String[]{"User Information"}).getMessage());
			}
			
			misUseApprovalVO.setCreUsrId(userAccount.getUsr_id());
			dbDao.addMisUseApprovalInfoData(misUseApprovalVO);

			misUseRequestVO.setUpdUsrId(userAccount.getUsr_id());
			dbDao.modifyMisUseRequestInfoData(misUseRequestVO);

			List<MisUseReqContainerVO> updateVoList = new ArrayList<MisUseReqContainerVO>();
			for(int i = 0; i < misUseReqContainerVOs.length; i++ ) {
				if(misUseReqContainerVOs[i].getIbflag().equals("U")) {
					misUseReqContainerVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(misUseReqContainerVOs[i]);
				}
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyMisUseReqContainerInfoListData(updateVoList);
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseApprovalNumberList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseApprovalNumberList Create"}).getMessage(),ex);
		}
	}

	/**
	 * Retrieving current state of Miss Used Equipments of Own and Other Company<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<MisUseInOutInquiryVO>
	 * @exception EventException
	 */
	public List<MisUseInOutInquiryVO> searchMisUseInOutInquiryListBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException {
		List<MisUseInOutInquiryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchMisUseInOutInquiryListData(searchParamVO,account);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseInOutInquiryList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseInOutInquiryList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Cancelling all Miss Use Approval Equipment List.<br>
	 *
	 * @param MisUseInOutInquiryVO[] misUseInOutInquiryVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void modifyMisUseApprovalCancelListBasic(MisUseInOutInquiryVO[] misUseInOutInquiryVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<MisUseInOutInquiryVO> updateVoList = new ArrayList<MisUseInOutInquiryVO>();

			for(int i = 0; i < misUseInOutInquiryVOs.length; i++ ) {
				if(misUseInOutInquiryVOs[i].getIbflag().equals("U")) {
					misUseInOutInquiryVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(misUseInOutInquiryVOs[i]);
				}
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyMisUseApprovalCancelListData(updateVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MisUseApprovalCancelList Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MisUseApprovalCancelList Modify"}).getMessage(),ex);
		}
	}
}