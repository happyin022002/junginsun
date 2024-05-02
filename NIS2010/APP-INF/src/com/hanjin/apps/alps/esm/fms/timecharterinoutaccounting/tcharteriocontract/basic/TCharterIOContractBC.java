/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOContractBC.java
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

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-TimeCharterInOutAccounting Business Logic Command Interface<br>
 * - ALPS-TimeCharterInOutAccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon-Tae, Jung
 * @see AgreementCreationEventResponse 참조
 * @since J2EE 1.5
 */


public interface TCharterIOContractBC {
	
	/**
	 * 사선/용선/대선에 대한 계약정보 조회(POPUP)<br>
	 * FMS 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param vslCd String 
	 * @param fletCtrtNo String
	 * @param ctrtFlag String
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel(String vslCd, String fletCtrtNo, String ctrtFlag) throws EventException;
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractTypeCodeVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeCodeVO> searchContractTypeCode(String fletCtrtNo) throws EventException;
	
	/**
	 * Bunker 화면에서 입력한 데이터를 계약 테이블에 UPDATE한다 <br>
	 * 
	 * @param contractByBunkerVO ContractByBunkerVO
	 * @param userId String
	 * @exception EventException
	 */
	public void modifyContractByBunker(ContractByBunkerVO contractByBunkerVO, String userId) throws EventException;
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type/Owner Code/Owner Name 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractByCharterVO>
	 * @exception EventException
	 */
	public List<SearchContractByCharterVO> searchContractByCharter(String fletCtrtNo) throws EventException;
	
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
	public List<SearchOwnerNameVO> searchOwnerName(String fletCtrtTpCd, String custCntCd, String vndrSeq, String custSeq) throws EventException;
	
	/**
	 * Agreement Creation 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContract(String fletCtrtNo) throws EventException;
	
	/**
	 * Agreement Creation 화면에 대한 계약정보를 생성한다<br>
	 * 
	 * @param tCharterIOContractVO TCharterIOContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String createContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String usrId) throws EventException;
	
	/**
	 * Agreement Creation 화면에 대한 계약정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param tCharterIOContractVO TCharterIOContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param updUsrId String 
	 * @exception EventException
	 */
	public void manageContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String updUsrId) throws EventException;

	/**
	 * Agreement Creation 화면에 GW문서를 저장한다( 수정)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param updUsrId String 
	 * @exception EventException
	 */
	public void manageGW(String fletCtrtNo, String updUsrId) throws EventException;
	
	
	/**
	 * Agreement Inquiry 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchAgreement(String fletCtrtNo) throws EventException;
	
	/**
	 * Agreement Creation 계약정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @exception EventException
	 */
	public void removeContract(String fletCtrtNo) throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByOffHire(String fletCtrtNo) throws EventException;
	
	/**
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayment 화면에서 CtrtNo에 해당하는 Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByPrepayment(String fletCtrtNo) throws EventException;
	
	/**
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayment 화면에서 CtrtNo에 해당하는 Hire No/Contract Type 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractListByPrepaymentHireNoVO>
	 * @exception EventException
	 */
	public List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNo(String fletCtrtNo) throws EventException;
		
	/**
	 * 계약조회 화면 OPEN시 발생하는 이벤트<br>
	 * 각 화면에 맞는 Contract Type 정보를 가져온다<br>
	 * 
	 * @param typeFlag String
	 * @return List<SearchContractTypeListByContractVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeListByContractVO> searchContractTypeListByContract(String typeFlag) throws EventException;
	
	/**
	 * Customer Code 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCustomerCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;
	
	/**
	 * Vendor Code 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageVendorCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;
	

	/** 
	 * 사선/용선/대선에 대한 계약정보 조회(POPUP)<br>
	 * FMS 화면에서 계약번호에 해당하는 사선/용선/대선 정보 가져오기<br>
	 * 
	 * @param vslCd String 
	 * @param fletCtrtNo String
	 * @param ctrtFlag String
	 * @return List<SearchContracNoListByVesselVO>
	 * @exception EventException
	 */
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel2(String vslCd, String fletCtrtNo, String ctrtFlag) throws EventException;
	
}
