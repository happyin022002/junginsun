/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationBC.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.DropOffDiscountDetailVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Doddropoff Business Logic Command Interface<br>
 * - ALPS-Doddropoff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6
 */

public interface DropOffCreationBC {

	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;

	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList2(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;
	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 면제 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOExptList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;

	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 면제 대상]을  DOD_DRP_OFF_CHG 테이블에 저장]합니다.<br>
	 * 
	 * @param List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOs
	 * @param String usrId
	 * @exception EventException
	 */

	public void manageDodDrpOffChgVOExptList(List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOs, String usrId) throws EventException;
	
	/**
	 * EES_DOD_0001 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @retutn List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId) throws EventException;
	
	/**
	 * EES_DOD_0002 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchMnlDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;

	/**
	 * EES_DOD_0002 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @param String spclCdSeq
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY(String bkgNo, String cntrNo, String cntrRtnYdCd, String spclCdSeq) throws EventException;
	
	/**
	 * EES_DOD_0002 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String
	 * @param ofcCd String  
	 * @retutn List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageMnlArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId, String ofcCd) throws EventException;

	/**
	 * EES_DOD_0013 : [SEARCH]<br>
	 * [EES_DOD_0001에서 호출하여 AR INV 보내기전 RTN CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;
	
	/**
	 * EES_DOD_0013 : [SEARCH01]<br>
	 * [EES_DOD_0004에서 호출하여 AR INV 보내고 난 후 CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;
	
	/**
	 * EES_DOD_0013 : [SEARCH02]<br>
	 * [Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInvErpIfStsCd(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;
	
	/**
	 * EES_DOD_0013 : [SEARCH08]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY1(String bkgNo, String cntrNo, String cntrRtnYdCd) throws EventException;

	/**
	 * EES_DOD_0013 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY2(String bkgNo, String cntrNo, String cntrRtnYdCd) throws EventException;

	/**
	 * EES_DOD_0013 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @param opener String
	 * @param ofcCd String  
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageCrrArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId, String opener, String ofcCd) throws EventException;

    /**
     * [AR Interface]에 전달할 내용을 [조회]한다.
     * 
     * @param SearchDodDrpOffChgVO searchDodDrpOffChgVO
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
	public ARInterfaceCreationVO searchARInterfaceInvoice(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException;
	
    /**
     * [AR Interface No]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String arIfNo
	 * @param String invSrcNo
     * @throws EventException
     */
	public void modifyARInterface(String bkgNo, String cntrNo, String drpOffChgSeq, String arIfNo, String invSrcNo) throws EventException;

    /**
     * [AUTH_APRO_RQST_NO]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String authAproRqstNo
     * @throws EventException
     */
	public void modifyARInterfaceAuth(String bkgNo, String cntrNo, String drpOffChgSeq, String authAproRqstNo) throws EventException;

	
    /**
     * [AR Interface 전송 실패한 대상]을 [DOD_DRP_OFF_CHG 테이블에서 Delete]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @throws EventException
     */
	public void deleteDodDrpOffChg(String bkgNo, String cntrNo, String drpOffChgSeq) throws EventException;

	
    /**
 	 * 해당 Back End Job을 실행시킨다.
 	 * 
 	 * @param SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs
 	 * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    //public String doBackEndJob(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * 해당 Back End Job의 상태를 리턴한다.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
    //public String[] checkBackEndJob(String key) throws EventException;
    
    /**
     * [Booking TRO에서 Cancel하면 기 발행한 Invoice에 TTL_AMT를 -하고 TRO_IB_CXL_FLG컬럼을 Y로 업데이트 ]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String usrId
     * @throws EventException
     */
    public void manageDodDrpOffChgByBookingTRO(String bkgNo, String cntrNo, String usrId) throws EventException;
    
	/**
	 * DropOff Discount Detail
	 * 
	 * @category EES_DOD_0012
	 * @param String 
	 * @return List<DropOffDiscountDetailVO>
	 * @throws EventException
	 */
	public List<DropOffDiscountDetailVO> searchDropOffDiscountDetail(String authAproRqstNo) throws EventException;

	/**
	 * EES_DOD_0001 : [MULTI01]<br>
	 * [Drop Off Charge대상]을 [AR로 보내지 않고 GOASC 오피스만 저장한다]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @retutn List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageRemarkList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId) throws EventException;
	
}