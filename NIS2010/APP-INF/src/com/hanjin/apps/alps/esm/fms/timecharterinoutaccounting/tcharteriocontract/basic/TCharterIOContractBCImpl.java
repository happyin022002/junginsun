/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractBCImpl.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 최초 생성
* --------------------------------------------------------------
* History
* 2011.02.14 이병훈 [CHM-201108730-01] FMS  Bunker 생성 및 수정 시에 계약 BOD/BOR 날짜 수정 보완
* 2011.05.18 Ticket ID : [CHM-201110910-01] 
* 개발자 : 이준범
* 제목 : Bunker Data Management 화면의 BUNKER 관련 Data가 계약에 변경되게 처리 요청
* 내용 : Live 에서만 오류 발생하여, 기존 유지보수[CHM-201108730-01] 시 변경된 파일 재 적용 ( 설계자 의견 )
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration.TCharterIOContractDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyCfFileVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyFileVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomHireVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomIdVslVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomOtrExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomPayTermVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchCharterPtyFileListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByPrepaymentVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchFileCertificationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchIdVslListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchPayTermListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - ALPS-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon-Tae, Jung
 * @see GeneralEventResponse,TCharterIOContractBC 각 DBDAO 클래스 참조
 * @since J2EE 1.5
 */
 
public class TCharterIOContractBCImpl extends BasicCommandSupport implements TCharterIOContractBC {

	// Database Access Object
	private transient TCharterIOContractDBDAO dbDao = null;

	/**
	 * $TCharterIOContractBCImpl 객체 생성<br>
	 * TCharterIOContractDBDAO를 생성한다.<br>
	 */
	public TCharterIOContractBCImpl() {
		dbDao = new TCharterIOContractDBDAO();
	}	
	
	/**
	 * 사선/용선/대선에 대한 계약정보 죄회(POPUP)<br>
	 * FMS 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
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
	 * fletCtrtNo에 해당하는 Contract Type 을 가져온다<br>
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
	 * Bunker 화면에서 입력한 데이터를 계약 테이블에 UPDATE한다 <br>
	 * 
	 * @param contractByBunkerVO ContractByBunkerVO
	 * @param userId String
	 * @exception EventException
	 */
	public void modifyContractByBunker(ContractByBunkerVO contractByBunkerVO, String userId) throws EventException {
		try {
			dbDao.modifyContractByBunker(contractByBunkerVO, userId);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type/Owner Code/Owner Name 을 가져온다<br>
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
	 * Owner Code에 해당하는 Name 정보 조회<br>
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
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Agreement Creation 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
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
	 * 사선/용선/대선 정보 처리<br>
	 * 계약정보를 생성한다<br>
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
			
			//validationCheck(화면 필수 입력 값)
			validateContract(customContractVO);
			
			String fletCtrtNo = generateContractNo(customContractVO.getFletCtrtTpCd(), customContractVO.getVslCd());
			
			customContractVO.setFletCtrtNo(fletCtrtNo);
			customContractVO.setCreUsrId(usrId);
			customContractVO.setUpdUsrId(usrId);
			
			customContractVO = getParamFormatString(customContractVO, null);
			
			//계약 테이블 INSERT
			dbDao.addContract(customContractVO);
			
			//FILE UPLOAD KEY값 SETTING하기
			if(keys != null) {
				setFileUploadKeysVo(customChtrPtyFileVOs, customChtrPtyCfFileVOs, keys, fileCountVO);
			}
			
			//Hire 테이블 INSERT
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
			
			//PayTerm 테이블 INSERT
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
			
			//OtrExpn 테이블 INSERT
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
			
			//IdVsl 테이블 INSERT
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
			
			//ChtrPtyFile 테이블 INSERT(CP용)
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
			
			//ChtrPtyFile 테이블 INSERT(CF용)
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
			
			//2018.02.26 계약정보 생성 및 변경시 Bunker 정보에 반영
			//2018.05.08 block
			//dbDao.createBunkerInfo(fletCtrtNo, usrId);
			
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
	 * Agreement Creation 계약정보를 저장한다(입력 / 수정 / 삭제)<br>
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
			
			//validationCheck(화면 필수 입력 값)
			validateContract(customContractVO);

			customContractVO = getParamFormatString(customContractVO, null);
			
			//Contract 테이블 UPDATE
			customContractVO.setUpdUsrId(updUsrId);
			dbDao.modifyContract(customContractVO);
			
			//FILE UPLOAD KEY값 SETTING하기
			//if(keys != null) {
				//setFileUploadKeysVo(customChtrPtyFileVOs, customChtrPtyCfFileVOs, keys, fileCountVO);
			//}
			
			//Hire 테이블 (C,U,D)
			if(customHireVOs != null && customHireVOs.length !=0 ) {
				manageHire(customHireVOs, customContractVO, updUsrId);
			}
			
			//PayTerm 테이블 (C,U,D)
			if(customPayTermVOs != null && customPayTermVOs.length !=0 ) {
				managePayTerm(customPayTermVOs, customContractVO, updUsrId);
			}
			
			//OtrExpn 테이블 (C,U,D)
			if(customOtrExpnVOs != null && customOtrExpnVOs.length !=0 ) {
				manageOtrExpn(customOtrExpnVOs, customContractVO, updUsrId);
			}
			
			//IdVsl 테이블 (C,U,D)
			if(customIdVslVOs != null && customIdVslVOs.length !=0 ) {
				manageIdVsl(customIdVslVOs, customContractVO, updUsrId);
			}
			
			//ChtrPtyFile 테이블 INSERT(CP용-C,U,D)
			if(customChtrPtyFileVOs != null && customChtrPtyFileVOs.length !=0 ) {
				manageFileCharterParty(customChtrPtyFileVOs, customContractVO, keys, updUsrId);
			}
			
			//ChtrPtyFile 테이블 INSERT(CF용-C,U,D) keys
			if(customChtrPtyCfFileVOs != null && customChtrPtyCfFileVOs.length !=0 ) {
				manageFileCertification(customChtrPtyCfFileVOs, customContractVO, keys, fileCountVO, updUsrId);
			}
			
			//2018.02.26 계약정보 생성 및 변경시 Bunker 정보에 반영
			//2018.05.08 block
			//dbDao.createBunkerInfo(customContractVO.getFletCtrtNo(), updUsrId);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Agreement Creation 화면에 GW문서를 저장한다( 수정)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param updUsrId String 
	 * @exception EventException
	 */
	public void manageGW(String fletCtrtNo, String updUsrId) throws EventException {

		try {	
			
			CustomContractVO  customContractVO = new  CustomContractVO();
			customContractVO.setFletCtrtNo(fletCtrtNo);
			customContractVO.setUpdUsrId(updUsrId);
			dbDao.manageGW(customContractVO);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01002",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * 계약정보 - Hire 정보를 저장한다(입력 / 수정 / 삭제)<br>
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addHires(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyHires(modifyVoList);
			}
			
			//데이타 삭제
			if(removeVoList.size() > 0) {
				dbDao.removeHires(removeVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
	}	
	
	/**
	 * 계약정보 - PayTerm정보를 저장한다(입력 / 수정 / 삭제)<br>
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addPayTerms(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyPayTerms(modifyVoList);
			}
			
			//데이타 삭제
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
	 * 계약정보 - OtrExpn정보를 저장한다(입력 / 수정 / 삭제)<br>
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addOtrExpns(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyOtrExpns(modifyVoList);
			}
			
			//데이타 삭제
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
	 * 계약정보 - IdVsl정보를 저장한다(입력 / 수정 / 삭제)<br>
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addIdVsls(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyIdVsls(modifyVoList);
			}
			
			//데이타 삭제
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
	 * 계약정보 - FileCharterParty 정보를 저장한다(입력 / 수정 / 삭제)<br>
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
					//첨부파일 Key 값 세팅
					if(!customChtrPtyFileVOs[i].getFileNm().equals("")) {
						if (keys != null){
							customChtrPtyFileVOs[i].setFileSavId(keys.get(cnt - idx++));
						}
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addFileCharterPartys(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyFileCharterPartys(modifyVoList);
			}
			
			//데이타 삭제
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
	 * 계약정보 - FileCertification 정보를 저장한다(입력 / 수정 / 삭제)<br>
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
					//첨부파일 Key 값 세팅
					if(!customChtrPtyCfFileVOs[i].getFileNm().equals("")) {
						if (keys != null){
							customChtrPtyCfFileVOs[i].setFileSavId(keys.get(cnt - idx++));
						}	
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
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addFileCertifications(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyFileCertifications(modifyVoList);
			}
			
			//데이타 삭제
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
	 * 계약정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @exception EventException
	 */
	public void removeContract(String fletCtrtNo) throws EventException {

		try {				
			//Contract Fact 정보 가져오기
			String ctrtFactCd = dbDao.searchContractFact(fletCtrtNo);
			
			if(ctrtFactCd.trim().equals("ACT")) {
				//계약  테이블 정보 변경
				dbDao.modifyDeleteFlag(fletCtrtNo);
				
			} else {
				//계약 관련 테이블 모두 DELETE
				
				//FMS_HIRE 정보 삭제
				dbDao.removeHireAll(fletCtrtNo);
				
				//FMS_PAY_TERM 정보 삭제
				dbDao.removePayTermAll(fletCtrtNo);
				
				//FMS_OTR_EXPN 정보 삭제
				dbDao.removeOtrExpnAll(fletCtrtNo);
				
				//FMS_ID_VSL 정보 삭제
				dbDao.removeIdVslAll(fletCtrtNo);
				
				//FMS_CHTR_PTY_FILE 정보 삭제
				dbDao.removeChtrPtyFileAll(fletCtrtNo);
				
				//FMS_CONTRACT 정보 삭제
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
	 * Creation 시 계약번호를 생성한다.<br>
	 * vessel Code 에 해당하는 최대seq값을 얻어와서 신규 계약번호를 생성한다<br>
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
		
		//seq를 '0' 문자열로 3자리 만들기
		strLastSeq = JSPUtil.customString(lastSeq, 3);
		
		//현재일자(YYYYMM)
		String currDate= DateTime.getShortDateString().substring(0,6);
		
		//계약 번호 생성번호
		String fletCtrtNo = vslCd + fletCtrtTpCd + currDate + strLastSeq;
		
		return fletCtrtNo;
	}
	
	/**
	 * FILE UPLOAD KEYS의 정보를 VO객체에 재 세팅한다.<br>
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
	 * Parameter정보를 일정한 형식에 맞게 포맷팅한다<br>
	 * Agreement Creation 화면에 대한 Parameter 포멧팅 처리<br>
	 * 
	 * @param customContractVO CustomContractVO
	 * @param fletCtrtNo String
	 * @return customContractVO
	 * @exception EventException
	 */
	private CustomContractVO getParamFormatString(CustomContractVO customContractVO, String fletCtrtNo) throws EventException{
		
		try{
			//Parameter에서 특정 구분자값을 제거하고 다시 SET한다("-",":",",")
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
			
			String actLowSulpFoilBodQty 	= JSPUtil.removeCharacter(customContractVO.getActLowSulpFoilBodQty(),",");
			String actLowSulpGasOilBodQty 	= JSPUtil.removeCharacter(customContractVO.getActLowSulpGasOilBodQty(),",");
			String lowSulpFoilBodOutPrc 	= JSPUtil.removeCharacter(customContractVO.getLowSulpFoilBodOutPrc(),",");
			String lowSulpGasOilBodOutPrc 	= JSPUtil.removeCharacter(customContractVO.getLowSulpGasOilBodOutPrc(),",");
			String actLowSulpFoilBorQty 	= JSPUtil.removeCharacter(customContractVO.getActLowSulpFoilBorQty(),",");
			String actLowSulpGasOilBorQty 	= JSPUtil.removeCharacter(customContractVO.getActLowSulpGasOilBorQty(),",");
			String lowSulpFoilBorOutPrc 	= JSPUtil.removeCharacter(customContractVO.getLowSulpFoilBorOutPrc(),",");
			String lowSulpGasOilBorOutPrc 	= JSPUtil.removeCharacter(customContractVO.getLowSulpGasOilBorOutPrc(),",");
			
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
			
			customContractVO.setActLowSulpFoilBodQty(actLowSulpFoilBodQty);
			customContractVO.setActLowSulpGasOilBodQty(actLowSulpGasOilBodQty);
			customContractVO.setLowSulpFoilBodOutPrc(lowSulpFoilBodOutPrc);
			customContractVO.setLowSulpGasOilBodOutPrc(lowSulpGasOilBodOutPrc);
			customContractVO.setActLowSulpFoilBorQty(actLowSulpFoilBorQty);
			customContractVO.setActLowSulpGasOilBorQty(actLowSulpGasOilBorQty);
			customContractVO.setLowSulpFoilBorOutPrc(lowSulpFoilBorOutPrc);
			customContractVO.setLowSulpGasOilBorOutPrc(lowSulpGasOilBorOutPrc);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return customContractVO;
	}
	
	/**
	 * Agreement Creation 화면에서 필수입력 값을 체크한다<br>
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
	 * Agreement Inquiry 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
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
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Off-Hire Expenses 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
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
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayment 화면에서 CtrtNo에 해당하는 Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information 가져오기<br>
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
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayment 화면에서 CtrtNo에 해당하는 Hire No/Contract Type 가져오기<br>
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
	 * 계약조회 화면 OPEN시 발생하는 이벤트<br>
	 * 각 화면에 맞는 Contract Type 정보를 가져온다<br>
	 * 
	 * @param typeFlag String
	 * @return List<SearchContractTypeListByContractVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeListByContractVO> searchContractTypeListByContract(String typeFlag) throws EventException {			
		try {
			List<String> lstTypeFlag = new ArrayList<String>();
			
			if(typeFlag != null && !typeFlag.equals("")) {
				lstTypeFlag = seperationParameter(typeFlag, "|");
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
	 * 여러개의 parameter 를 나누어주는 메소드
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
	
	/**
	 * Customer별 Owner 정보 저장<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCustomerCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException{
		try {
			List<SearchVendorCustomerVO> addVoList = new ArrayList<SearchVendorCustomerVO>();
			List<SearchVendorCustomerVO> modifyVoList = new ArrayList<SearchVendorCustomerVO>();
			
			for ( int i=0; i<searchVendorCustomerVOs.length; i++ ) {
				if ( searchVendorCustomerVOs[i].getIbflag().equals("I")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					addVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("U")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(searchVendorCustomerVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.modifyCustomerCodes(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {	
				dbDao.modifyCustomerCodes(modifyVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01303",new String[]{}).getMessage(), de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01303",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Vendor 별 Customer 정보 저장<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageVendorCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException{
		try {
			List<SearchVendorCustomerVO> addVoList = new ArrayList<SearchVendorCustomerVO>();
			List<SearchVendorCustomerVO> modifyVoList = new ArrayList<SearchVendorCustomerVO>();
			
			for ( int i=0; i<searchVendorCustomerVOs.length; i++ ) {
				if ( searchVendorCustomerVOs[i].getIbflag().equals("I")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					addVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("U")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(searchVendorCustomerVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.modifyVendorCodes(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {	
				dbDao.modifyVendorCodes(modifyVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01303",new String[]{}).getMessage(), de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01303",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 사선/용선/대선에 대한 계약정보 죄회(POPUP)<br> 
	 * FMS 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param vslCd String 
	 * @param fletCtrtTpCd String
	 * @param ctrtFlag String
	 * @return List<SearchContracNoListByVesselVO>
	 * @exception EventException
	 */
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel2(String vslCd, String fletCtrtTpCd, String ctrtFlag) throws EventException {			
		try {
			return dbDao.searchContracNoListByVessel2(vslCd, fletCtrtTpCd, ctrtFlag);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01009",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01009",new String[]{}).getMessage(), ex);
		}
	}
}
