/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOContractBC.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-TimeCharterInOutAccounting Business Logic Command Interface<br>
 * - OPUS-TimeCharterInOutAccounting Biz Logic Interface<br>
 *
 * @author 
 * @see AgreementCreationEventResponse 
 * @since J2EE 1.5
 */


public interface TCharterIOContractBC {
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out(POPUP)<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on FMS window<br>
	 * 
	 * @param vslCd String
	 * @param fletCtrtNo String
	 * @param ctrtFlag String
	 * @return List<SearchContracNoListByVesselVO>
	 * @throws EventException
	 */
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel(String vslCd, String fletCtrtNo, String ctrtFlag) throws EventException;
	
	/**
	 * Getting Contract Type corresponding to fletCtrtNo<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractTypeCodeVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeCodeVO> searchContractTypeCode(String fletCtrtNo) throws EventException;
	
	/**
	 * Updating inserted data on Bunker window into Contract table<br>
	 * 
	 * @param contractByBunkerVO ContractByBunkerVO
	 * @exception EventException
	 */
	public void modifyContractByBunker(ContractByBunkerVO contractByBunkerVO) throws EventException;
	
	/**
	 * Getting Contract Type/Owner Code/Owner Name corresponding to fletCtrtNo<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractByCharterVO>
	 * @exception EventException
	 */
	public List<SearchContractByCharterVO> searchContractByCharter(String fletCtrtNo) throws EventException;
	
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
	public List<SearchOwnerNameVO> searchOwnerName(String fletCtrtTpCd, String custCntCd, String vndrSeq, String custSeq) throws EventException;
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on Agreement Creation window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContract(String fletCtrtNo) throws EventException;
	
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
	public String createContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String usrId) throws EventException;
	
	/**
	 * Agreement Creation Saving Contract information(Insert / Modify / Delete)<br>
	 * 
	 * @param tCharterIOContractVO TCharterIOContractVO
	 * @param keys List<String>
	 * @param fileCountVO FileCountVO
	 * @param updUsrId String
	 * @exception EventException
	 */
	public void manageContract(TCharterIOContractVO tCharterIOContractVO, List<String> keys, FileCountVO fileCountVO, String updUsrId) throws EventException;
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out on Agreement Inquiry window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchAgreement(String fletCtrtNo) throws EventException;
	
	/**
	 * Deleting Contract information<br>
	 * 
	 * @param fletCtrtNo String
	 * @exception EventException
	 */
	public void removeContract(String fletCtrtNo) throws EventException;
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Owner ship/Charter in/Hire Out information corresponding to the Contract number on Off-Hire Expenses window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByOffHire(String fletCtrtNo) throws EventException;
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information for CtrtNo on Prepayment window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public ContractContainerVO searchContractByPrepayment(String fletCtrtNo) throws EventException;
	
	/**
	 * Retrieving contract information about Owner ship/Charter in/Hire Out<br>
	 * Getting Hire No/Contract Type for CtrtNo on Prepayment window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return ContractContainerVO
	 * @exception EventException
	 */
	public List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNo(String fletCtrtNo) throws EventException;
		
	/**
	 * Event implemented when Contract Retrieve window is opened<br>
	 * Getting Contract Type information for each window <br>
	 * 
	 * @param typeFlag String
	 * @return List<SearchContractTypeListByContractVO>
	 * @exception EventException
	 */
	public List<SearchContractTypeListByContractVO> searchContractTypeListByContract(String typeFlag) throws EventException;
	
}
