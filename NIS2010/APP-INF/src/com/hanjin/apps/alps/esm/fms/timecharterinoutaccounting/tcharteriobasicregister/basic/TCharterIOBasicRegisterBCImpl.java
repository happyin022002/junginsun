/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterBCImpl.java
*@FileTitle : searchAccountItemList
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) manageRevenueVvd() 파라미터 추가 String finalizingFlg
* --------------------------------------------------------------
* History
* 2011.07.25 표준희 [CHM-201112501-01] FMS/Fleet Management "VVD CD Creation In FMS"관련기능 변경
* 작업내용 : 1) VVD CD Finalizing From ERP : 현재 로직처럼 처리 (기존 항차가 있고  REV Month 가 다르면 현재  REV Month 로 변경됨(UPDATE 반영)
*          2) VVD CD Creation In FMS : 기존 항차가 있으면 REV Month 가 다르더라도 REV Month  변경하지 않음 (UPDATE 반영 안함)         
======================================================================================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration.TCharterIOBasicRegisterDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration.TCharterIOBasicRegisterEAIDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomEmailAddressVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.ReceiveRevenuePortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - ALPS-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon-Tae, Jung
 * @see Esm_Fms_0076EventResponse,TCharterIOBasicRegisterBC 각 DAO 클래스 참조
 * @since J2EE 1.5 
 */

public class TCharterIOBasicRegisterBCImpl extends BasicCommandSupport implements TCharterIOBasicRegisterBC {

	// Database Access Object
	private transient TCharterIOBasicRegisterDBDAO dbDao = null;

	/**
	 * TCharterIOBasicRegisterBCImpl 객체 생성<br>
	 * TCharterIOBasicRegisterDBDAO를 생성한다.<br>
	 */
	public TCharterIOBasicRegisterBCImpl() {
		dbDao = new TCharterIOBasicRegisterDBDAO();
	}
	
	/**
	 * Account Item list Pop-up(Account Item 정보를 조회한다)<br>
	 * 
	 * @param fletAcctCateCd String
	 * @param acctItmNm String
	 * @return List<SearchAccountItemListVO>
	 * @exception EventException
	 */
	public List<SearchAccountItemListVO> searchAccountItemList(String fletAcctCateCd, String acctItmNm) throws EventException {
		try {
			return dbDao.searchAccountItemList(fletAcctCateCd, acctItmNm);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01309",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01309",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FMS Owner 조회<br>
	 * 
	 * @return List<CustomOwnerVO>
	 * @exception EventException
	 */
	public List<CustomOwnerVO> searchOwnerList() throws EventException {
		try {
			return dbDao.searchOwnerList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01305",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01305",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FMS Owner 저장<br>
	 * 
	 * @param customOwnerVOs CustomOwnerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOwner(CustomOwnerVO[] customOwnerVOs, String usrId) throws EventException{
		try {
			List<CustomOwnerVO> addVoList = new ArrayList<CustomOwnerVO>();
			List<CustomOwnerVO> modifyVoList = new ArrayList<CustomOwnerVO>();
			List<CustomOwnerVO> removeVoList = new ArrayList<CustomOwnerVO>();
			
			for ( int i=0; i<customOwnerVOs.length; i++ ) {
				if ( customOwnerVOs[i].getIbflag().equals("I")){
					customOwnerVOs[i].setCreUsrId(usrId);
					addVoList.add(customOwnerVOs[i]);
				} else if ( customOwnerVOs[i].getIbflag().equals("U")){
					customOwnerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customOwnerVOs[i]);
				} else if ( customOwnerVOs[i].getIbflag().equals("D")){
					customOwnerVOs[i].setUpdUsrId(usrId);
					removeVoList.add(customOwnerVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addOwners(addVoList);
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyOwners(modifyVoList);
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.modifyOwnersDeleteFlags(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Currency Code 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param currency String
	 * @return String
	 * @exception EventException
	 */
    public String checkCurrencyCode(String currency) throws EventException {
		try {
			return dbDao.searchCheckCurrencyCode(currency);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01314",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01314",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Vendor Code List 정보를 가져온다<br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCodeList() throws EventException {
		try {
			return dbDao.searchVendorCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01300",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01300",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Vendor별 Owner 정보 저장<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageVendorCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException{
		try {
			List<SearchVendorCustomerVO> addVoList = new ArrayList<SearchVendorCustomerVO>();
			List<SearchVendorCustomerVO> modifyVoList = new ArrayList<SearchVendorCustomerVO>();
			List<SearchVendorCustomerVO> removeVoList = new ArrayList<SearchVendorCustomerVO>();
			
			for ( int i=0; i<searchVendorCustomerVOs.length; i++ ) {
				if ( searchVendorCustomerVOs[i].getIbflag().equals("I")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					addVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("U")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("D")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					removeVoList.add(searchVendorCustomerVOs[i]);
				} 
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.modifyVendorCodes(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				 
				//Vendor가    Contract에 사용되었는지 체크
				//checkContractByVendorCustomerCode("Vendor", modifyVoList);
				
				dbDao.modifyVendorCodes(modifyVoList);
			}

			if ( removeVoList.size() > 0 ) {

				//Customer가    Contract에 사용되었는지 체크
				checkContractByVendorCustomerCode("Vendor", removeVoList);
				
				dbDao.modifyVendorCodeDeleteFlags(removeVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01301",new String[]{}).getMessage(), de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01301",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Customer별 Owner 정보 조회<br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchCustomerCodeList() throws EventException {
		try {
			return dbDao.searchCustomerCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01302",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01302",new String[]{}).getMessage(), ex);
		}
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
			List<SearchVendorCustomerVO> removeVoList = new ArrayList<SearchVendorCustomerVO>();
			
			for ( int i=0; i<searchVendorCustomerVOs.length; i++ ) {
				if ( searchVendorCustomerVOs[i].getIbflag().equals("I")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					addVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("U")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(searchVendorCustomerVOs[i]);
				} else if ( searchVendorCustomerVOs[i].getIbflag().equals("D")){
					searchVendorCustomerVOs[i].setUpdUsrId(usrId);
					removeVoList.add(searchVendorCustomerVOs[i]);
				} 
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.modifyCustomerCodes(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {				
				//Customer가    Contract에 사용되었는지 체크
				//checkContractByVendorCustomerCode("Customer", modifyVoList);

				dbDao.modifyCustomerCodes(modifyVoList);
			}

			if ( removeVoList.size() > 0 ) {
				
				//Customer가    Contract에 사용되었는지 체크
				checkContractByVendorCustomerCode("Customer", removeVoList);
				
				dbDao.modifyCustomerCodeDeleteFlags(removeVoList);
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
	 * Vendor/Customer Code List 정보를 가져온다<br>
	 * 
	 * @param condFlag String
	 * @param vendorCustomerList List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void checkContractByVendorCustomerCode(String condFlag, List<SearchVendorCustomerVO> vendorCustomerList) throws EventException {
		try {

			List<SearchVendorCustomerVO> contractList = new ArrayList<SearchVendorCustomerVO>();
			
			Iterator iterator = vendorCustomerList.iterator();
			SearchVendorCustomerVO searchVendorCustomerVO = null;

			if (iterator.hasNext()) {
				searchVendorCustomerVO = (SearchVendorCustomerVO) iterator.next();
				
				if (condFlag.equals("Vendor")) {
					contractList = dbDao.searchCheckContractByVendorCode(searchVendorCustomerVO);
	
					if (contractList.size() > 0 ) {
						throw new EventException(new ErrorHandler("FMS01337",new String[]{}).getMessage());
					}
				} else {
					contractList = dbDao.searchCheckContractByCustomerCode(searchVendorCustomerVO);
					
					if (contractList.size() > 0 ) {
						throw new EventException(new ErrorHandler("FMS01338",new String[]{}).getMessage());
					}
				}
					
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01338",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01338",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Vendor/Customer 정보를 Popup 을 통하하여 조회한다<br>
	 * 
	 * @param String agmtFlag
	 * @param String condFlag
	 * @param String vendorCustomerName
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerList(String agmtFlag, String condFlag, String vendorCustomerName) throws EventException {
		try {
			return dbDao.searchVendorCustomerList(agmtFlag, condFlag, vendorCustomerName);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01304",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01304",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FMS Owner Pop-up 조회<br>
	 * 
	 * @return List<SearchOwnerNameListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerNameListVO> searchOwnerNameList() throws EventException {
		try {
			return dbDao.searchOwnerNameList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01020",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01020",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Vendor/Customer Name 정보를 조회한다<br>
	 * 
	 * @param String condFlag
	 * @param String cdCnt
	 * @param String cdSeq
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerName(String condFlag, String cdCnt, String cdSeq) throws EventException {
		try {
			return dbDao.searchVendorCustomerName(condFlag, cdCnt, cdSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01304",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01304",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Combo Box에 사용될 공통 코드 정보를 가져온다<br>
	 * 
	 * @param cdId String[]
	 * @param sortKey int[]
	 * @return codeInfoList List<Collection<CodeInfo>>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Collection<CodeInfo>> getStandardCommonCode(String[] cdId, int[] sortKey) throws EventException {
		
		try {
			Collection<CodeInfo> codeInfoVO = null;
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			for(int i = 0; i < cdId.length; i++) {
				codeInfoVO = CodeUtil.getInstance().getCodeSelect(cdId[i], sortKey[i]);
				codeInfoList.add(i, codeInfoVO);
			}
			
			return codeInfoList;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00005",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Item Management 조회<br>
	 * 
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> searchAccountItemDetailList() throws EventException {
		try {
			return dbDao.searchAccountItemDetailList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01332",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01332",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Item Management 저장<br>
	 * 
	 * @param customAcctItmVOs CustomAcctItmVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void manageAccountItemName(CustomAcctItmVO[] customAcctItmVOs, String usrId) throws EventException{
		try {
			List<CustomAcctItmVO> addVoList = new ArrayList<CustomAcctItmVO>();
			List<CustomAcctItmVO> modifyVoList = new ArrayList<CustomAcctItmVO>();
			List<CustomAcctItmVO> removeVoList = new ArrayList<CustomAcctItmVO>();
			
			for ( int i=0; i<customAcctItmVOs.length; i++ ) {
				if ( customAcctItmVOs[i].getIbflag().equals("I")){
					customAcctItmVOs[i].setCreUsrId(usrId);
					addVoList.add(customAcctItmVOs[i]);
				} else if ( customAcctItmVOs[i].getIbflag().equals("U")){
					customAcctItmVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customAcctItmVOs[i]);
				} else if ( customAcctItmVOs[i].getIbflag().equals("D")){
					customAcctItmVOs[i].setUpdUsrId(usrId);
					removeVoList.add(customAcctItmVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addAcctItms(addVoList);
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyAcctItms(modifyVoList);
			}
			
			if ( removeVoList.size() > 0 ) {

				//삭제시 해당 Account code, Item seq가 사용중인지 체크
				List<CustomAcctItmVO> acctList = new ArrayList<CustomAcctItmVO>();
				
				Iterator iterator = removeVoList.iterator();
				CustomAcctItmVO removeCustomAcctItmVO = null;

				if (iterator.hasNext()) {
					removeCustomAcctItmVO = (CustomAcctItmVO) iterator.next();
					acctList = dbDao.searchCheckAccountUse(removeCustomAcctItmVO);

					if (acctList.size() > 0 ) {
						throw new EventException(new ErrorHandler("FMS01339",new String[]{}).getMessage());
					}
				}
				
				dbDao.removeAcctItmCates(removeVoList);
				dbDao.removeAcctItms(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01317",new String[]{}).getMessage(), de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01317",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Item Detail Management에서 Account Code 입력시 해당 Account Code정보를 가져온다<br>
	 * 
	 * @param acctCd String
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> checkAccountCode(String acctCd) throws EventException {
		try {
			return dbDao.searchCheckAccountCode(acctCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01316",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01316",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Account Code정보를 가져온다<br>
	 * 
	 * @param acctCd String
	 * @param acctItmSeq String
	 * @param chkFletAcctCateCd String
	 * @param prevFletAcctCateCd String
	 * @param usrId String
	 * @return CustomAcctCateVO
	 * @exception EventException
	 */
	private CustomAcctCateVO setAccountCate(String acctCd, String acctItmSeq, String chkFletAcctCateCd, String prevFletAcctCateCd, String usrId) throws EventException {
		try {
			
			CustomAcctCateVO customAcctCateVO = new CustomAcctCateVO();
			
			customAcctCateVO.setIbflag("");
			if (chkFletAcctCateCd.equals("1")) {//Check and not exist
				if (prevFletAcctCateCd.substring(2).equals("N")) {
					customAcctCateVO.setIbflag("I");
					customAcctCateVO.setAcctCd(acctCd);
					customAcctCateVO.setAcctItmSeq(acctItmSeq);
					customAcctCateVO.setFletAcctCateCd(prevFletAcctCateCd.substring(0,2));
					customAcctCateVO.setCreUsrId(usrId);
				}	
			} else {//Uncheck and exist
				if (prevFletAcctCateCd.toString().substring(2).equals("Y")) {
					customAcctCateVO.setIbflag("D");
					customAcctCateVO.setAcctCd(acctCd);
					customAcctCateVO.setAcctItmSeq(acctItmSeq);
					customAcctCateVO.setFletAcctCateCd(prevFletAcctCateCd.substring(0,2));
					customAcctCateVO.setCreUsrId(usrId);
				}
			}
			
			return customAcctCateVO;
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01308",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Account Category 저장<br>
	 * 
	 * @param customAcctCateVOs CustomAcctCateVO[]
	 * @param usrId String
	 * @exception EventException 
	 */
	public void manageAccountCate(CustomAcctCateVO[] customAcctCateVOs, String usrId) throws EventException{
		try {
			List<CustomAcctCateVO> addVoList = new ArrayList<CustomAcctCateVO>();
			List<CustomAcctCateVO> removeVoList = new ArrayList<CustomAcctCateVO>();
			
			for ( int i=0; i<customAcctCateVOs.length; i++ ) {
				
				CustomAcctCateVO customAcctCateVO = new CustomAcctCateVO();
				if ( customAcctCateVOs[i].getIbflag().equals("U")){
					
					//Other Expense
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
										customAcctCateVOs[i].getChkOtherExp(), customAcctCateVOs[i].getPrevOtherExp(),usrId);
					
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}

					//Charterer
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
										customAcctCateVOs[i].getChkCharterer(), customAcctCateVOs[i].getPrevCharterer(),usrId);
					
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//Owner
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkOwner(), customAcctCateVOs[i].getPrevOwner(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//Prepayment P-Type
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkPrepaymentp(), customAcctCateVOs[i].getPrevPrepaymentp(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//Prepayment S-Type
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkPrepayments(), customAcctCateVOs[i].getPrevPrepayments(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//Manual Slip
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkManualSlip(), customAcctCateVOs[i].getPrevManualSlip(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//Off Hire
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkOffHire(), customAcctCateVOs[i].getPrevOffHire(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//VVD Required
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkVvdRequired(), customAcctCateVOs[i].getPrevVvdRequired(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}
					
					//BOD BOR Interface
					customAcctCateVO = setAccountCate(customAcctCateVOs[i].getAcctCd(), customAcctCateVOs[i].getAcctItmSeq(),
							customAcctCateVOs[i].getChkBodborIf(), customAcctCateVOs[i].getPrevBodborIf(),usrId);
		
					if (customAcctCateVO.getIbflag().equals("I")) {
						addVoList.add(customAcctCateVO);
					} else if (customAcctCateVO.getIbflag().equals("D")) {
						removeVoList.add(customAcctCateVO);
					}

				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addAcctCates(addVoList);
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.removeAcctCates(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01308",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01308",new String[]{}).getMessage(), de);
		}
	}

	/**
	 *  Account Category 조회<br>
	 * 
	 * @return List<CustomAcctCateVO>
	 * @exception EventException
	 */
	public List<CustomAcctCateVO> searchAccountCateList() throws EventException {
		try {
			return dbDao.searchAccountCateList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01307",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01307",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Revenue VVD Creation 화면에서 Vvd정보를 가져온다<br>
	 * 
	 * @param revYrmon String
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchRevenueVvdListVO> searchRevenueVvdList(String revYrmon, String slanCd, String rlaneCd) throws EventException  {
		try {
			return dbDao.searchRevenueVvdList(revYrmon, slanCd, rlaneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01321",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01321",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Revenue VVD 생성<br>
	 * 
	 * @param customVvdVOs CustomVvdVO[]
	 * @param usrId String
	 * @param String finalizingFlg
	 * @exception EventException
	 */
	public void manageRevenueVvd(CustomVvdVO[] customVvdVOs, String usrId, String finalizingFlg) throws EventException{
		try {
			List<CustomVvdVO> addVoList = new ArrayList<CustomVvdVO>();
			List<CustomVvdVO> modifyVoList = new ArrayList<CustomVvdVO>();
			List<CustomVvdVO> removeVoList = new ArrayList<CustomVvdVO>();
		
			for ( int i=0; i<customVvdVOs.length; i++ ) {
				if ( customVvdVOs[i].getIbflag().equals("I")){
					customVvdVOs[i].setCreUsrId(usrId);
					customVvdVOs[i].setUpdUsrId(usrId);
					addVoList.add(customVvdVOs[i]);
				} else if ( customVvdVOs[i].getIbflag().equals("U")){
					customVvdVOs[i].setCreUsrId(usrId);
					customVvdVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customVvdVOs[i]);
				} else if ( customVvdVOs[i].getIbflag().equals("D")){
					removeVoList.add(customVvdVOs[i]);
				} 
			}
						
			if ( addVoList.size() > 0 ) {
				
				if (finalizingFlg.equals("Y")) {
					String revYrmon = customVvdVOs[0].getRevYrmon();
					dbDao.removeRevenueVvdAll(revYrmon);
					dbDao.addRevenueVvds(addVoList);
				} else {
					dbDao.addRevenueVvdAdds(addVoList);
				}	
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyRevenueVvds(modifyVoList);
			}

			if ( removeVoList.size() > 0 ) {
				dbDao.removeRevenueVvds(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01323",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01323",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Final Revenue Vvd List 조회<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchFinalRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdList(String revYrmon) throws EventException  {
		try {
			return dbDao.searchFinalRevenueVvdList(revYrmon);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01324",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01324",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Final Revenue Vvd List 조회<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchFinalRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchFinalRevenueVvdListVO> searchProcessRevenueVvdList(String revYrmon) throws EventException  {
		try {
			return dbDao.searchProcessRevenueVvdList(revYrmon);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01324",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01324",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Revenue VVD Creation 정보를 조회한다<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchVvdCreationListVO>
	 * @exception EventException
	 */
	public List<SearchVvdCreationListVO> searchVvdCreationList(String revYrmon) throws EventException  {
		try {
			return dbDao.searchVvdCreationList(revYrmon);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01342",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01342",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 *  Revenue Vvd Inquiry List 조회<br>
	 * 
	 * @param revYrmonFrom String
	 * @param revYrmonTo String
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenueVvdInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryList(String revYrmonFrom, String revYrmonTo, String slanCd, String rlaneCd) throws EventException  {
		try {
			return dbDao.searchRevenueVvdInquiryList(revYrmonFrom, revYrmonTo, slanCd, rlaneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01341",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01341",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 용/대선 선박 관련 Created된 Revenue Port를 조회<br>
	 * 
	 * @param slanCd String
	 * @param rLaneCd String
	 * @return List<SearchRevenuePortListVO>
	 * @exception EventException
	 */
	public List<SearchRevenuePortListVO> searchRevenuePortList(String slanCd, String rLaneCd) throws EventException  {
		try {
			return dbDao.searchRevenuePortList(slanCd, rLaneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01325",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01325",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Revenue Port를 전체를 삭제한다<br>
	 * 
	 * @exception EventException
	 */
	public void removeAllRevenuePort() throws EventException  {
		try {
			dbDao.removeAllRevenuePort();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01326",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01326",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Revenue Port를 저장 한다<br>
	 * 
	 * @param customBsePortVOs CustomBsePortVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRevenuePort(CustomBsePortVO[] customBsePortVOs, String usrId) throws EventException {
		try {
			List<CustomBsePortVO> addVoList = new ArrayList<CustomBsePortVO>();
			List<CustomBsePortVO> modifyVoList = new ArrayList<CustomBsePortVO>();
			List<CustomBsePortVO> removeVoList = new ArrayList<CustomBsePortVO>();
			
			for ( int i=0; i<customBsePortVOs.length; i++ ) {
				if ( customBsePortVOs[i].getIbflag().equals("I")){
					customBsePortVOs[i].setCreUsrId(usrId);
					customBsePortVOs[i].setUpdUsrId(usrId);
					addVoList.add(customBsePortVOs[i]);
				} else if (customBsePortVOs[i].getIbflag().equals("U")){
					customBsePortVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customBsePortVOs[i]);
				} else if (customBsePortVOs[i].getIbflag().equals("D")){
					removeVoList.add(customBsePortVOs[i]);
				} 
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.removeRevenuePorts(removeVoList);
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addRevenuePorts(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyRevenuePorts(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01326",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01326",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Revenue Port 자료를 ERP에서 가지고 온다<br>
	 * 
	 * @return List<ReceiveRevenuePortVO>
	 * @exception EventException
	 */
	public List<ReceiveRevenuePortVO> receiveRevenuePort() throws EventException  {
		try {
			TCharterIOBasicRegisterEAIDAO eaiDbDao = new TCharterIOBasicRegisterEAIDAO();
			return eaiDbDao.receiveRevenuePort();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01328",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01328",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * E-mail Address 자료 조회한다<br>
	 * 
	 * @return List<SearchEmailAddressListVO>
	 * @exception EventException
	 */
	public List<SearchEmailAddressListVO> searchEmailAddressList() throws EventException  {
		try {
			return dbDao.searchEmailAddressList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01347",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01347",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * E-Mail Address 자료를 변경한다<br>
	 * 
	 * @param customEmailAddressVOs CustomEmailAddressVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageEmailAddress(CustomEmailAddressVO[] customEmailAddressVOs, String usrId) throws EventException{
		try {
			List<CustomEmailAddressVO> addVoList = new ArrayList<CustomEmailAddressVO>();
			List<CustomEmailAddressVO> modifyVoList = new ArrayList<CustomEmailAddressVO>();
			List<CustomEmailAddressVO> removeVoList = new ArrayList<CustomEmailAddressVO>();

			for ( int i=0; i<customEmailAddressVOs.length; i++ ) {
				if ( customEmailAddressVOs[i].getIbflag().equals("I")){
					customEmailAddressVOs[i].setCreUsrId(usrId);
					customEmailAddressVOs[i].setUpdUsrId(usrId);
					addVoList.add(customEmailAddressVOs[i]);
				} else if ( customEmailAddressVOs[i].getIbflag().equals("U")){
					customEmailAddressVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customEmailAddressVOs[i]);
				} else if ( customEmailAddressVOs[i].getIbflag().equals("D")){
					customEmailAddressVOs[i].setUpdUsrId(usrId);
					removeVoList.add(customEmailAddressVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addEmailAddresss(addVoList);
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyEmailAddresss(modifyVoList);
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.removeEmailAddresss(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01348",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01348",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * SDMS FinanVvdList 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param direction String
	 * @param revYrmon String
	 * @return List<SearchFinanVvdListByChaterSdmsVO>
	 * @exception EventException
	 */
    public List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdms(String vslCd, String direction, String revYrmon) throws EventException {
		try {
			return dbDao.searchFinanVvdListByChaterSdms(vslCd, direction, revYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01313",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01313",new String[]{}).getMessage(), ex);
		}
	}
}