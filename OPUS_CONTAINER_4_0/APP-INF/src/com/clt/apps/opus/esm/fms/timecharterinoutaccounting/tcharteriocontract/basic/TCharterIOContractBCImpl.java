/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractBCImpl.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration.TCharterIOContractDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyCfFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomIdVslVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomOtrExpnVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomPayTermVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchCharterPtyFileListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByPrepaymentVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchFileCertificationListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchIdVslListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchPayTermListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling OPUS-TimeCharterInOutAccounting Business Logic<br>
 *
 * @author Yoon-Tae, Jung
 * @see GeneralEventResponse,TCharterIOContractBC 각 DBDAO 클래스 참조
 * @since J2EE 1.5
 */
 
public class TCharterIOContractBCImpl extends BasicCommandSupport implements TCharterIOContractBC {

	// Database Access Object
	private transient TCharterIOContractDBDAO dbDao = null;

	/**
	 * Generating $TCharterIOContractBCImpl Object<br>
	 * Generating TCharterIOContractDBDAO<br>
	 */
	public TCharterIOContractBCImpl() {
		dbDao = new TCharterIOContractDBDAO();
	}	
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out(POPUP)<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on FMS window<br>
	 * 
	 * @param vslCd String 
	 * @param fletCtrtTpCd String
	 * @param ctrtFlag String
	 * @return List<SearchContracNoListByVesselVO>
	 * @exception EventException
	 */
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel(String vslCd, String fletCtrtTpCd, String ctrtFlag) throws EventException {			
		try {
			return dbDao.searchContracNoListByVessel(vslCd, fletCtrtTpCd, ctrtFlag);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01009",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01009",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Contract Type corresponding to fletCtrtNo<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractTypeCodeVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeCodeVO> searchContractTypeCode(String fletCtrtNo) throws EventException {			
		try {
			return dbDao.searchContractTypeCode(fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01022",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01022",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Updating inserted data on Bunker window into Contract table<br>
	 * 
	 * @param contractByBunkerVO ContractByBunkerVO
	 * @exception EventException
	 */
	public void modifyContractByBunker(ContractByBunkerVO contractByBunkerVO) throws EventException {
		try {
			dbDao.modifyContractByBunker(contractByBunkerVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Getting Contract Type/Owner Code/Owner Name corresponding to fletCtrtNo<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractByCharterVO>
	 * @exception EventException
	 */
	public List<SearchContractByCharterVO> searchContractByCharter(String fletCtrtNo) throws EventException {			
		try {
			return dbDao.searchContractByCharter(fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01018",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01018",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Name information corresponding to Owner Code<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param custCntCd String
	 * @param vndrSeq String
	 * @param custSeq String
	 * @return List<SearchOwnerNameVO>
	 * @exception EventException
	 */
	public List<SearchOwnerNameVO> searchOwnerName(String fletCtrtTpCd, String custCntCd, String vndrSeq, String custSeq) throws EventException {			
		try {
			if(fletCtrtTpCd.equals("TO")) {
				return dbDao.searchOwnerByCustomer(custCntCd, custSeq);
			} else {
				return dbDao.searchOwnerByVendor(vndrSeq);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01008",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01008",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on Agreement Creation window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContract(String fletCtrtNo) throws EventException {	
		
		ContractContainerVO contractContainerVO = new ContractContainerVO();	
		
		try {
			SearchContractVO searchContractVO = dbDao.searchContract(fletCtrtNo);
			List<SearchHireListVO> searchHireListVOs= dbDao.searchHireList(fletCtrtNo);
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = dbDao.searchOtrExpnList(fletCtrtNo);
			List<SearchPayTermListVO> searchPayTermListVOs = dbDao.searchPayTermList(fletCtrtNo);
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = dbDao.searchFileCharterPartyList(fletCtrtNo);
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = dbDao.searchFileCertificationList(fletCtrtNo);
			List<SearchIdVslListVO> searchIdVslListVOs = dbDao.searchIdVslList(fletCtrtNo);
			SearchHireSysDateVO searchHireSysDateVO = dbDao.searchHireSysDate(fletCtrtNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = dbDao.searchOtrExpnSysDateList(fletCtrtNo);
	
			contractContainerVO.setSearchHireListVOs(searchHireListVOs);
			contractContainerVO.setSearchOtrExpnListVOs(searchOtrExpnListVOs);
			contractContainerVO.setSearchPayTermListVOs(searchPayTermListVOs);
			contractContainerVO.setSearchContractVO(searchContractVO);
			contractContainerVO.setSearchCharterPtyFileListVOs(searchCharterPtyFileListVOs);
			contractContainerVO.setSearchFileCertificationListVOs(searchFileCertificationListVOs);
			contractContainerVO.setSearchIdVslListVOs(searchIdVslListVOs);
			contractContainerVO.setSearchOtrExpnSysDateListVOs(searchOtrExpnSysDateListVOs);
			contractContainerVO.setSearchHireSysDateVO(searchHireSysDateVO);
			
			return contractContainerVO;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01004",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01004",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling Owner ship/Charter in/Hire Out information<br>
	 * Generating Contract information<br>
	 * 
	 * @param tCharterIOContractVO TCharterIOContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String createContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String usrId) throws EventException {

		try {	
			CustomContractVO  		customContractVO       = tCharterIOContractVO.getCustomContract();
			CustomHireVO[]    		customHireVOs          = tCharterIOContractVO.getCustomHires();
			CustomPayTermVO[] 		customPayTermVOs       = tCharterIOContractVO.getCustomPayTerms();
			CustomOtrExpnVO[] 		customOtrExpnVOs       = tCharterIOContractVO.getCustomOtrExpns();
			CustomIdVslVO[]   		customIdVslVOs 		   = tCharterIOContractVO.getCustomIdVsls();
			CustomChtrPtyFileVO[]   customChtrPtyFileVOs   = tCharterIOContractVO.getCustomChtrPtyFiles();
			CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs = tCharterIOContractVO.getCustomChtrPtyCfFiles();
			
			//validationCheck(Mandatory value)
			validateContract(customContractVO);
			
			String fletCtrtNo = generateContractNo(customContractVO.getFletCtrtTpCd(), customContractVO.getVslCd());
			
			customContractVO.setFletCtrtNo(fletCtrtNo);
			customContractVO.setCreUsrId(usrId);
			customContractVO.setUpdUsrId(usrId);
			
			customContractVO = getParamFormatString(customContractVO, null);
			
			//Contract table INSERT
			dbDao.addContract(customContractVO);
			
			//FILE UPLOAD KEY value SETTING
			if(keys != null) {
				setFileUploadKeysVo(customChtrPtyFileVOs, customChtrPtyCfFileVOs, keys, fileCountVO);
			}
			
			//Hire table INSERT
			if(customHireVOs != null && customHireVOs.length !=0 ) {
				List<CustomHireVO> insModel = new ArrayList<CustomHireVO>();
				
				for ( int i=0; i<customHireVOs.length; i++ ) {
					customHireVOs[i].setFletCtrtNo(fletCtrtNo);
					customHireVOs[i].setCreUsrId(usrId);
					customHireVOs[i].setUpdUsrId(usrId);
					insModel.add(customHireVOs[i]);
				}
				dbDao.addHires(insModel);
			}
			
			//PayTerm table INSERT
			if(customPayTermVOs != null && customPayTermVOs.length !=0 ) {
				List<CustomPayTermVO> insModel = new ArrayList<CustomPayTermVO>();
				
				for ( int i=0; i<customPayTermVOs.length; i++ ) {
					customPayTermVOs[i].setFletCtrtNo(fletCtrtNo);
					customPayTermVOs[i].setCreUsrId(usrId);
					customPayTermVOs[i].setUpdUsrId(usrId);
					insModel.add(customPayTermVOs[i]);
				}
				dbDao.addPayTerms(insModel);
			}
			
			//OtrExpn table INSERT
			if(customOtrExpnVOs != null && customOtrExpnVOs.length !=0 ) {
				List<CustomOtrExpnVO> insModel = new ArrayList<CustomOtrExpnVO>();
				
				for ( int i=0; i<customOtrExpnVOs.length; i++ ) {
					customOtrExpnVOs[i].setFletCtrtNo(fletCtrtNo);
					customOtrExpnVOs[i].setCreUsrId(usrId);
					customOtrExpnVOs[i].setUpdUsrId(usrId);
					insModel.add(customOtrExpnVOs[i]);
				}
				dbDao.addOtrExpns(insModel);
			}
			
			//IdVsl table INSERT
			if(customIdVslVOs != null && customIdVslVOs.length !=0 ) {
				List<CustomIdVslVO> insModel = new ArrayList<CustomIdVslVO>();
				
				for ( int i=0; i<customIdVslVOs.length; i++ ) {
					customIdVslVOs[i].setFletCtrtNo(fletCtrtNo);
					customIdVslVOs[i].setCreUsrId(usrId);
					customIdVslVOs[i].setUpdUsrId(usrId);
					insModel.add(customIdVslVOs[i]);
				}
				dbDao.addIdVsls(insModel);
			}
			
			//ChtrPtyFile table INSERT(CP)
			if(customChtrPtyFileVOs != null && customChtrPtyFileVOs.length !=0 ) {
				List<CustomChtrPtyFileVO> insModel = new ArrayList<CustomChtrPtyFileVO>();
				
				for ( int i=0; i<customChtrPtyFileVOs.length; i++ ) {
					customChtrPtyFileVOs[i].setFletCtrtNo(fletCtrtNo);
					customChtrPtyFileVOs[i].setCreUsrId(usrId);
					customChtrPtyFileVOs[i].setUpdUsrId(usrId);
					insModel.add(customChtrPtyFileVOs[i]);
				}
				dbDao.addFileCharterPartys(insModel);
			}
			
			//ChtrPtyFile table INSERT(CF)
			if(customChtrPtyCfFileVOs != null && customChtrPtyCfFileVOs.length !=0 ) {
				List<CustomChtrPtyCfFileVO> insModel = new ArrayList<CustomChtrPtyCfFileVO>();
				
				for ( int i=0; i<customChtrPtyCfFileVOs.length; i++ ) {
					customChtrPtyCfFileVOs[i].setFletCtrtNo(fletCtrtNo);
					customChtrPtyCfFileVOs[i].setCreUsrId(usrId);
					customChtrPtyCfFileVOs[i].setUpdUsrId(usrId);
					insModel.add(customChtrPtyCfFileVOs[i]);
				}
				dbDao.addFileCertifications(insModel);
			}
			
			return fletCtrtNo;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01001",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01001",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Agreement Creation Saving Contract information(Insert / Modify / Delete)<br>
	 * 
	 * @param tCharterIOContractVO TCharterIOContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	public void manageContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String updUsrId) throws EventException {

		try {	
			CustomContractVO  		customContractVO       = tCharterIOContractVO.getCustomContract();
			CustomHireVO[]    		customHireVOs          = tCharterIOContractVO.getCustomHires();
			CustomPayTermVO[] 		customPayTermVOs       = tCharterIOContractVO.getCustomPayTerms();
			CustomOtrExpnVO[] 		customOtrExpnVOs       = tCharterIOContractVO.getCustomOtrExpns();
			CustomIdVslVO[]   		customIdVslVOs 		   = tCharterIOContractVO.getCustomIdVsls();
			CustomChtrPtyFileVO[]   customChtrPtyFileVOs   = tCharterIOContractVO.getCustomChtrPtyFiles();
			CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs = tCharterIOContractVO.getCustomChtrPtyCfFiles();
			
			//validationCheck(Mandatory)
			validateContract(customContractVO);

			customContractVO = getParamFormatString(customContractVO, null);
			
			//Contract table UPDATE
			customContractVO.setUpdUsrId(updUsrId);
			dbDao.modifyContract(customContractVO);
			
			//FILE UPLOAD KEY value SETTING
			//if(keys != null) {
				//setFileUploadKeysVo(customChtrPtyFileVOs, customChtrPtyCfFileVOs, keys, fileCountVO);
			//}
			
			//Hire table (C,U,D)
			if(customHireVOs != null && customHireVOs.length !=0 ) {
				manageHire(customHireVOs, customContractVO, updUsrId);
			}
			
			//PayTerm table (C,U,D)
			if(customPayTermVOs != null && customPayTermVOs.length !=0 ) {
				managePayTerm(customPayTermVOs, customContractVO, updUsrId);
			}
			
			//OtrExpn table (C,U,D)
			if(customOtrExpnVOs != null && customOtrExpnVOs.length !=0 ) {
				manageOtrExpn(customOtrExpnVOs, customContractVO, updUsrId);
			}
			
			//IdVsl table (C,U,D)
			if(customIdVslVOs != null && customIdVslVOs.length !=0 ) {
				manageIdVsl(customIdVslVOs, customContractVO, updUsrId);
			}
			
			//ChtrPtyFile table INSERT(CP-C,U,D)
			if(customChtrPtyFileVOs != null && customChtrPtyFileVOs.length !=0 ) {
				manageFileCharterParty(customChtrPtyFileVOs, customContractVO, keys, updUsrId);
			}
			
			//ChtrPtyFile table INSERT(CF-C,U,D) keys
			if(customChtrPtyCfFileVOs != null && customChtrPtyCfFileVOs.length !=0 ) {
				manageFileCertification(customChtrPtyCfFileVOs, customContractVO, keys, fileCountVO, updUsrId);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Contract information - Saving Hire information(Insert / Modify / Delete)<br>
	 * 
	 * @param customHireVOs CustomHireVO[]
	 * @param customContractVO CustomContractVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void manageHire(CustomHireVO[] customHireVOs, CustomContractVO customContractVO, String updUsrId) throws EventException {

		List<CustomHireVO> addVoList    = new ArrayList<CustomHireVO>();
		List<CustomHireVO> modifyVoList = new ArrayList<CustomHireVO>();
		List<CustomHireVO> removeVoList = new ArrayList<CustomHireVO>();
		
		try {
			for(int i=0; i<customHireVOs.length; i++) {
				if(customHireVOs[i].getIbflag().equals("I")) {
					customHireVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customHireVOs[i].setCreUsrId(updUsrId);
					customHireVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customHireVOs[i]);
					
				} else if(customHireVOs[i].getIbflag().equals("U")) {
					customHireVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customHireVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customHireVOs[i]);
					
				} else if(customHireVOs[i].getIbflag().equals("D")) {
					customHireVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customHireVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addHires(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyHires(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeHires(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}	
	
	/**
	 * Contract Information - Saving PayTerm information(Insert / Modify / Delete)<br>
	 * 
	 * @param customPayTermVOs CustomPayTermVO[]
	 * @param customContractVO CustomContractVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void managePayTerm(CustomPayTermVO[] customPayTermVOs, CustomContractVO customContractVO, String updUsrId) throws EventException {

		List<CustomPayTermVO> addVoList    = new ArrayList<CustomPayTermVO>();
		List<CustomPayTermVO> modifyVoList = new ArrayList<CustomPayTermVO>();
		List<CustomPayTermVO> removeVoList = new ArrayList<CustomPayTermVO>();
		
		try {
			for(int i=0; i<customPayTermVOs.length; i++) {
				if(customPayTermVOs[i].getIbflag().equals("I")) {
					customPayTermVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customPayTermVOs[i].setCreUsrId(updUsrId);
					customPayTermVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customPayTermVOs[i]);
					
				} else if(customPayTermVOs[i].getIbflag().equals("U")) {
					customPayTermVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customPayTermVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customPayTermVOs[i]);
					
				} else if(customPayTermVOs[i].getIbflag().equals("D")) {
					customPayTermVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customPayTermVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addPayTerms(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyPayTerms(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removePayTerms(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Contract information - Saving OtrExpn information(Insert / Modify / Delete)<br>
	 * 
	 * @param customOtrExpnVOs CustomOtrExpnVO[]
	 * @param customContractVO CustomContractVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void manageOtrExpn(CustomOtrExpnVO[] customOtrExpnVOs, CustomContractVO customContractVO, String updUsrId) throws EventException {

		List<CustomOtrExpnVO> addVoList    = new ArrayList<CustomOtrExpnVO>();
		List<CustomOtrExpnVO> modifyVoList = new ArrayList<CustomOtrExpnVO>();
		List<CustomOtrExpnVO> removeVoList = new ArrayList<CustomOtrExpnVO>();
		
		try {
			for(int i=0; i<customOtrExpnVOs.length; i++) {
				if(customOtrExpnVOs[i].getIbflag().equals("I")) {
					customOtrExpnVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customOtrExpnVOs[i].setCreUsrId(updUsrId);
					customOtrExpnVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customOtrExpnVOs[i]);
					
				} else if(customOtrExpnVOs[i].getIbflag().equals("U")) {
					customOtrExpnVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customOtrExpnVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customOtrExpnVOs[i]);
					
				} else if(customOtrExpnVOs[i].getIbflag().equals("D")) {
					customOtrExpnVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customOtrExpnVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addOtrExpns(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyOtrExpns(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeOtrExpns(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Contract information - Saving IdVsl information(Insert  / Modify / Delete)<br>
	 * 
	 * @param customIdVslVOs CustomIdVslVO[]
	 * @param customContractVO CustomContractVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void manageIdVsl(CustomIdVslVO[] customIdVslVOs, CustomContractVO customContractVO, String updUsrId) throws EventException {

		List<CustomIdVslVO> addVoList    = new ArrayList<CustomIdVslVO>();
		List<CustomIdVslVO> modifyVoList = new ArrayList<CustomIdVslVO>();
		List<CustomIdVslVO> removeVoList = new ArrayList<CustomIdVslVO>();
		
		try {
			for(int i=0; i<customIdVslVOs.length; i++) {
				if(customIdVslVOs[i].getIbflag().equals("I")) {
					customIdVslVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customIdVslVOs[i].setCreUsrId(updUsrId);
					customIdVslVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customIdVslVOs[i]);
					
				} else if(customIdVslVOs[i].getIbflag().equals("U")) {
					customIdVslVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customIdVslVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customIdVslVOs[i]);
					
				} else if(customIdVslVOs[i].getIbflag().equals("D")) {
					customIdVslVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customIdVslVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addIdVsls(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyIdVsls(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeIdVsls(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Contract information - Saving FileCharterParty information(Insert / Modify / Delete)<br>
	 * 
	 * @param customChtrPtyFileVOs CustomChtrPtyFileVO[]
	 * @param customContractVO CustomContractVO
	 * @param keys List<String>
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void manageFileCharterParty(CustomChtrPtyFileVO[] customChtrPtyFileVOs, CustomContractVO customContractVO, List<String> keys, String updUsrId) throws EventException {
		
		List<CustomChtrPtyFileVO> addVoList    = new ArrayList<CustomChtrPtyFileVO>();
		List<CustomChtrPtyFileVO> modifyVoList = new ArrayList<CustomChtrPtyFileVO>();
		List<CustomChtrPtyFileVO> removeVoList = new ArrayList<CustomChtrPtyFileVO>();
		
		try {
			int idx = 1;
			int cnt = keys == null ? 0 : keys.size();
			
			for(int i=0; i<customChtrPtyFileVOs.length; i++) {
				if(customChtrPtyFileVOs[i].getIbflag().equals("I")) {
					//Setting attached file key value
					if(!"".equals(customChtrPtyFileVOs[i].getFileNm()) && null != keys) {
						customChtrPtyFileVOs[i].setFileSavId(keys.get(cnt - idx++));
					}
					
					customChtrPtyFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customChtrPtyFileVOs[i].setCreUsrId(updUsrId);
					customChtrPtyFileVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customChtrPtyFileVOs[i]);
					
				} else if(customChtrPtyFileVOs[i].getIbflag().equals("U")) {
					customChtrPtyFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customChtrPtyFileVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customChtrPtyFileVOs[i]);
					
				} else if(customChtrPtyFileVOs[i].getIbflag().equals("D")) {
					customChtrPtyFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customChtrPtyFileVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addFileCharterPartys(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyFileCharterPartys(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeFileCharterPartys(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Contract information - Saving FileCertification information(Insert / Modify / Delete)<br>
	 * 
	 * @param customChtrPtyCfFileVOs CustomChtrPtyCfFileVO[]
	 * @param customContractVO CustomContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	private void manageFileCertification(CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs, CustomContractVO customContractVO, List<String> keys, FileCountVO fileCountVO, String updUsrId) throws EventException {

		List<CustomChtrPtyCfFileVO> addVoList    = new ArrayList<CustomChtrPtyCfFileVO>();
		List<CustomChtrPtyCfFileVO> modifyVoList = new ArrayList<CustomChtrPtyCfFileVO>();
		List<CustomChtrPtyCfFileVO> removeVoList = new ArrayList<CustomChtrPtyCfFileVO>();
		
		try {
			int idx = 1;
			int cnt = keys == null ? 0 : (keys.size() - Integer.parseInt(fileCountVO.getCpfFileCnt()));
			//int cnt = keys == null ? 0 : keys.size();
			
			for(int i=0; i<customChtrPtyCfFileVOs.length; i++) {
				if(customChtrPtyCfFileVOs[i].getIbflag().equals("I")) {
					//Setting attached file key value
					if(!"".equals(customChtrPtyCfFileVOs[i].getFileNm()) && null != keys) {
						customChtrPtyCfFileVOs[i].setFileSavId(keys.get(cnt - idx++));
						//customChtrPtyCfFileVOs[i].setFileSavId(keys.get((cnt - Integer.parseInt(fileCountVO.getCpfFileCnt())) - idx++));
					}
					customChtrPtyCfFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customChtrPtyCfFileVOs[i].setCreUsrId(updUsrId);
					customChtrPtyCfFileVOs[i].setUpdUsrId(updUsrId);
					addVoList.add(customChtrPtyCfFileVOs[i]);
					
				} else if(customChtrPtyCfFileVOs[i].getIbflag().equals("U")) {
					customChtrPtyCfFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					customChtrPtyCfFileVOs[i].setUpdUsrId(updUsrId);
					modifyVoList.add(customChtrPtyCfFileVOs[i]);
					
				} else if(customChtrPtyCfFileVOs[i].getIbflag().equals("D")) {
					customChtrPtyCfFileVOs[i].setFletCtrtNo(customContractVO.getFletCtrtNo());
					removeVoList.add(customChtrPtyCfFileVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.addFileCertifications(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.modifyFileCertifications(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeFileCertifications(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Deleting Contract information<br>
	 * 
	 * @param fletCtrtNo String
	 * @exception EventException
	 */
	public void removeContract(String fletCtrtNo) throws EventException {

		try {				
			//Getting Contract Fact information
			String ctrtFactCd = dbDao.searchContractFact(fletCtrtNo);
			
			if(ctrtFactCd.trim().equals("ACT")) {
				//Modifying Contract table information
				dbDao.modifyDeleteFlag(fletCtrtNo);
				
			} else {
				//Delete all Contract related table
				
				//Delete FMS_HIRE information
				dbDao.removeHireAll(fletCtrtNo);
				
				//Delete FMS_PAY_TERM information
				dbDao.removePayTermAll(fletCtrtNo);
				
				//Delete FMS_OTR_EXPN information
				dbDao.removeOtrExpnAll(fletCtrtNo);
				
				//Delete FMS_ID_VSL information
				dbDao.removeIdVslAll(fletCtrtNo);
				
				//Delete FMS_CHTR_PTY_FILE information
				dbDao.removeChtrPtyFileAll(fletCtrtNo);
				
				//Delete FMS_CONTRACT information
				dbDao.removeContract(fletCtrtNo);

			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01003",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01003",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Generating Contract number<br>
	 * Generating new Contract number by getting max sequence value corresponding to vessel Code<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param vslCd String
	 * @return String
	 * @exception EventException
	 */
	private String generateContractNo(String fletCtrtTpCd, String vslCd) throws EventException {
		
		String strLastSeq = "";
		int lastSeq = 0;
		
		try{
			
			lastSeq = dbDao.searchLastContractSeq(vslCd);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if(lastSeq == 0)  {
			lastSeq = 1;
		} else {
			lastSeq = lastSeq + 1;
		}
		
		//Making seq into three-digit '0' character sequence
		strLastSeq = JSPUtil.customString(lastSeq, 3);
		
		//present date(YYYYMM)
		String currDate= DateTime.getShortDateString().substring(0,6);
		
		//Generated Contract number
		String fletCtrtNo = vslCd + fletCtrtTpCd + currDate + strLastSeq;
		
		return fletCtrtNo;
	}
	
	/**
	 * Re-Setting FILE UPLOAD KEYS information into VO object<br>
	 * 
	 * @param customChtrPtyFileVOs CustomChtrPtyFileVO[]
	 * @param customChtrPtyCfFileVOs CustomChtrPtyCfFileVO[]
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @exception EventException
	 */
	private void setFileUploadKeysVo(CustomChtrPtyFileVO[] customChtrPtyFileVOs, CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs, List<String> keys, FileCountVO fileCountVO) throws EventException {
		
		int i = Integer.parseInt(fileCountVO.getCefFileCnt()) == 0 ? Integer.parseInt(fileCountVO.getCpfFileCnt())-1 : Integer.parseInt(fileCountVO.getCefFileCnt())-1;
		int j = Integer.parseInt(fileCountVO.getCefFileCnt()) == 0 ? 1 : 0;
		int k = 0;
		
		Iterator<String> iter = keys.iterator();
		
		while(iter.hasNext()) {
			if(Integer.parseInt(fileCountVO.getCefFileCnt()) != 0 && j != 1) {
				k = i--;

				customChtrPtyCfFileVOs[k].setFileSavId(iter.next());
				
			} else if(Integer.parseInt(fileCountVO.getCpfFileCnt()) != 0 && j==1) {
				k = i--;

				customChtrPtyFileVOs[k].setFileSavId(iter.next());
			}
			
			if(k == 0) {
				i = Integer.parseInt(fileCountVO.getCpfFileCnt())-1;
				j = 1;
			}
		}
		
	}
	
	/**
	 * Formatting Parameter information in certain form <br>
	 * Handling Parameter Formatting about Agreement Creation window<br>
	 * 
	 * @param customContractVO CustomContractVO
	 * @param fletCtrtNo String
	 * @return customContractVO
	 * @exception EventException
	 */
	private CustomContractVO getParamFormatString(CustomContractVO customContractVO, String fletCtrtNo) throws EventException{
		
		try{
			//Re-setting Parameter after deleting specific separator("-",":",",")
			String cpDt  			= JSPUtil.removeCharacter(customContractVO.getCpDt(),"-");
			String vslBldDt 		= JSPUtil.removeCharacter(customContractVO.getVslBldDt(),"-");
			String acmmRtAmt 		= JSPUtil.removeCharacter(customContractVO.getAcmmRtAmt(),",");
			String fletOlayCommRtAmt= JSPUtil.removeCharacter(customContractVO.getFletOlayCommRtAmt(),",");
			String fletBrogRtAmt 	= JSPUtil.removeCharacter(customContractVO.getFletBrogRtAmt(),",");
			String oaRsvAmt 		= JSPUtil.removeCharacter(customContractVO.getOaRsvAmt(),",");
			String actFoilBodQty 	= JSPUtil.removeCharacter(customContractVO.getActFoilBodQty(),",");
			String actDoilBodQty 	= JSPUtil.removeCharacter(customContractVO.getActDoilBodQty(),",");
			String foilBodOutPrc 	= JSPUtil.removeCharacter(customContractVO.getFoilBodOutPrc(),",");
			String doilBodOutPrc 	= JSPUtil.removeCharacter(customContractVO.getDoilBodOutPrc(),",");
			String actFoilBorQty 	= JSPUtil.removeCharacter(customContractVO.getActFoilBorQty(),",");
			String actDoilBorQty 	= JSPUtil.removeCharacter(customContractVO.getActDoilBorQty(),",");
			String foilBorOutPrc 	= JSPUtil.removeCharacter(customContractVO.getFoilBorOutPrc(),",");
			String doilBorOutPrc 	= JSPUtil.removeCharacter(customContractVO.getDoilBorOutPrc(),",");
			String shpSpdQty 		= JSPUtil.removeCharacter(customContractVO.getShpSpdQty(),",");
			String vslDzndCapa 		= JSPUtil.removeCharacter(customContractVO.getVslDzndCapa(),",");
			String bse14tonVslCapa 	= JSPUtil.removeCharacter(customContractVO.getBse14tonVslCapa(),",");
			String rfCntrPlgQty 	= JSPUtil.removeCharacter(customContractVO.getRfCntrPlgQty(),",");
			String ddwtCgoCapaQty 	= JSPUtil.removeCharacter(customContractVO.getDdwtCgoCapaQty(),",");
			String grsWgt 			= JSPUtil.removeCharacter(customContractVO.getGrsWgt(),",");
			String nrtWgt 			= JSPUtil.removeCharacter(customContractVO.getNrtWgt(),",");
			
			if(fletCtrtNo != null && !fletCtrtNo.equals("")) {
				customContractVO.setUpdUsrId(customContractVO.getCreUsrId());
			}
			
			customContractVO.setCpDt(cpDt);
			customContractVO.setVslBldDt(vslBldDt);
			customContractVO.setAcmmRtAmt(acmmRtAmt);
			customContractVO.setFletOlayCommRtAmt(fletOlayCommRtAmt);
			customContractVO.setFletBrogRtAmt(fletBrogRtAmt);
			customContractVO.setOaRsvAmt(oaRsvAmt);
			customContractVO.setActFoilBodQty(actFoilBodQty);
			customContractVO.setActDoilBodQty(actDoilBodQty);
			customContractVO.setFoilBodOutPrc(foilBodOutPrc);
			customContractVO.setDoilBodOutPrc(doilBodOutPrc);
			customContractVO.setActFoilBorQty(actFoilBorQty);
			customContractVO.setActDoilBorQty(actDoilBorQty);
			customContractVO.setFoilBorOutPrc(foilBorOutPrc);
			customContractVO.setDoilBorOutPrc(doilBorOutPrc);
			customContractVO.setShpSpdQty(shpSpdQty);
			customContractVO.setVslDzndCapa(vslDzndCapa);
			customContractVO.setBse14tonVslCapa(bse14tonVslCapa);
			customContractVO.setRfCntrPlgQty(rfCntrPlgQty);
			customContractVO.setDdwtCgoCapaQty(ddwtCgoCapaQty);
			customContractVO.setGrsWgt(grsWgt);
			customContractVO.setNrtWgt(nrtWgt);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return customContractVO;
	}
	
	/**
	 * Checking mandatory insert value on Agreement Creation window<br>
	 * 
	 * @param customContractVO CustomContractVO
	 * @exception EventException
	 */
	private void validateContract(CustomContractVO customContractVO) throws EventException {
		
		String msgCode = "";
		
		try {
			if(customContractVO.getFletCtrtFactCd().equals("PSE")) {
				if(   customContractVO.getVslCd().equals("")
				   || customContractVO.getEffDt().equals("")) {
					
					if(customContractVO.getVslCd().equals("")) {
						msgCode = "FMS01097";
					} else if(customContractVO.getEffDt().equals("")) {
						msgCode = "FMS01098";
					}
					
					throw new EventException(new ErrorHandler(msgCode,new String[]{}).getMessage());
				}
			} else {
				if(   customContractVO.getVslCd().equals("")
				   || customContractVO.getEffDt().equals("")
				   || customContractVO.getCustSeq().equals("")) {
					
					if(customContractVO.getVslCd().equals("")) {
						msgCode = "FMS01097";
					} else if(customContractVO.getEffDt().equals("")) {
						msgCode = "FMS01098";
					} else if(customContractVO.getCustSeq().equals("")) {
						msgCode = "FMS01099";
					}
					
					throw new EventException(new ErrorHandler(msgCode,new String[]{}).getMessage());
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out on Agreement Inquiry window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchAgreement(String fletCtrtNo) throws EventException {	
		
		ContractContainerVO contractContainerVO = new ContractContainerVO();	
		
		try {
			SearchContractVO searchContractVO = dbDao.searchAgreement(fletCtrtNo);
			List<SearchHireListVO> searchHireListVOs= dbDao.searchHireList(fletCtrtNo);
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = dbDao.searchOtrExpnList(fletCtrtNo);
			List<SearchPayTermListVO> searchPayTermListVOs = dbDao.searchAgreementPayTermList(fletCtrtNo);
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = dbDao.searchFileCharterPartyList(fletCtrtNo);
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = dbDao.searchFileCertificationList(fletCtrtNo);
			List<SearchIdVslListVO> searchIdVslListVOs = dbDao.searchIdVslList(fletCtrtNo);
			SearchHireSysDateVO searchHireSysDateVO = dbDao.searchHireSysDate(fletCtrtNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = dbDao.searchOtrExpnSysDateList(fletCtrtNo);
	
			contractContainerVO.setSearchHireListVOs(searchHireListVOs);
			contractContainerVO.setSearchOtrExpnListVOs(searchOtrExpnListVOs);
			contractContainerVO.setSearchPayTermListVOs(searchPayTermListVOs);
			contractContainerVO.setSearchContractVO(searchContractVO);
			contractContainerVO.setSearchCharterPtyFileListVOs(searchCharterPtyFileListVOs);
			contractContainerVO.setSearchFileCertificationListVOs(searchFileCertificationListVOs);
			contractContainerVO.setSearchIdVslListVOs(searchIdVslListVOs);
			contractContainerVO.setSearchOtrExpnSysDateListVOs(searchOtrExpnSysDateListVOs);
			contractContainerVO.setSearchHireSysDateVO(searchHireSysDateVO);
			
			return contractContainerVO;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01004",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01004",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on Off-Hire Expenses window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByOffHire(String fletCtrtNo) throws EventException {	
		
		ContractContainerVO contractContainerVO = new ContractContainerVO();	
		
		try {
			SearchContractByInvoiceVO searchContractByInvoiceVO = dbDao.searchContractByInvoice(fletCtrtNo);
			SearchHireSysDateVO searchHireSysDateVO = dbDao.searchHireSysDate(fletCtrtNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = dbDao.searchOtrExpnSysDateList(fletCtrtNo);
	
			contractContainerVO.setSearchContractByInvoiceVO(searchContractByInvoiceVO);
			contractContainerVO.setSearchOtrExpnSysDateListVOs(searchOtrExpnSysDateListVOs);
			contractContainerVO.setSearchHireSysDateVO(searchHireSysDateVO);
			
			return contractContainerVO;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information for CtrtNo on Prepayment window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByPrepayment(String fletCtrtNo) throws EventException {	
		
		ContractContainerVO contractContainerVO = new ContractContainerVO();	
		
		try {
			SearchContractByPrepaymentVO searchContractByPrepaymentVO = dbDao.searchContractByPrepayment(fletCtrtNo);
			SearchHireSysDateVO searchHireSysDateVO = dbDao.searchHireSysDate(fletCtrtNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = dbDao.searchOtrExpnSysDateList(fletCtrtNo);
	
			contractContainerVO.setSearchContractByPrepaymentVO(searchContractByPrepaymentVO);
			contractContainerVO.setSearchOtrExpnSysDateListVOs(searchOtrExpnSysDateListVOs);
			contractContainerVO.setSearchHireSysDateVO(searchHireSysDateVO);
			
			return contractContainerVO;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Hire No/Contract Type for CtrtNo on Prepayment window <br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNo(String fletCtrtNo) throws EventException {	
		
		try {
			List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = dbDao.searchContractListByPrepaymentHireNo(fletCtrtNo);
			
			return searchContractListByPrepaymentHireNoVOs;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01017",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Event implemented when Contract Retrieve window is opened<br>
	 * Getting Contract Type information for each window <br>
	 * 
	 * @param typeFlag String
	 * @return List<SearchContractTypeListByContractVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeListByContractVO> searchContractTypeListByContract(String typeFlag) throws EventException {			
		try {
			List<String> lstTypeFlag = new ArrayList<String>();
			
			if(!StringUtils.isBlank(typeFlag)) {
				lstTypeFlag = seperationParameter(typeFlag, "|");
			}else{
				typeFlag = "";
			}
			
			return dbDao.searchContractTypeListByContract(typeFlag, lstTypeFlag);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01145",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01145",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Method separating several parameters 
	 * Detail ContractNo Popup<br>
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	private List<String> seperationParameter(String sparameter, String sSeperate) {
		List<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
}
