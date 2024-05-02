/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralARInvoiceMasterDataMgtBC.java
 *@FileTitle : Revenue Lane Inquiry by Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
 * 2010.11.23 이석준 [CHM-201006884] FNS_INV_0114 신규 개발(조회,저장 기능 추가)
 * 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
 * 2011.08.04 오요한 [CHM-201112323] ALPS 코드 속성 작업 결과에 따른 기 메뉴 삭제된 ALPS INV 소스 삭제
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOfcInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.ProcessingVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueProcessParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.ArFincDirConvVO;
import com.hanjin.syscommon.common.table.InvArBankVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;
import com.hanjin.syscommon.common.table.InvRevAcctCdVO;

/**
 * ALPS-Accountreceivableinvoicemasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author saeil kim
 * @see Fns_inv_0077EventResponse 참조
 * @since J2EE 1.4
 */
 
public interface GeneralARInvoiceMasterDataMgtBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Generalarinvoicemasterdatamgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param LaneOrderInPutVO laneOrderInPutVO
	 * @return List<LaneOrderVO>
	 * @exception EventException
	 */
	public List<LaneOrderVO> searchRevenueLaneOrderList(LaneOrderInPutVO laneOrderInPutVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Generalarinvoicemasterdatamgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ArFincDirConvVO arFincDirConvVO
	 * @return List<ArFincDirConvVO>
	 * @exception EventException
	 */

	public List<ArFincDirConvVO> searchRevenueVesselDirectionCodeConversionList(ArFincDirConvVO arFincDirConvVO) throws EventException;

	/**
	 * AR Office별 Invoice 표기 은행계좌번호를 조회한다. <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return List<InvArBankListVO>
	 * @exception EventException
	 */
	public List<InvArBankListVO> searchBankAccountList(String arOfc, String saleOfc) throws EventException;

	/**
	 * Office별 Invoice발행시 표기되는 정보중 하나인 Currency별 은행계좌정보를 등록, 수정한다. <br>
	 * 
	 * @param InvArBankVO[] bAcctVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageBankAccount(InvArBankVO[] bAcctVOs, String userId) throws EventException;

	/**
	 * 입력한 Sales Office code가 AR Office의 소속 Office 인지를 확인한다. <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return String
	 * @exception EventException
	 */
	public String searchSalesOffice(String arOfc, String saleOfc) throws EventException;

	/**
	 * ERP 에서 생성하여 Interface 된 Revenue Account 정보를 조회한다. <br>
	 * 
	 * @param String source
	 * @param String revGroup
	 * @param String del
	 * @return List<InvRevAcctCdVO>
	 * @exception EventException
	 */
	public List<InvRevAcctCdVO> searchRevenueAccountList(String source, String revGroup, String del) throws EventException;

	/**
	 * Local에서 사용하는 Charge code를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @param String locCd
	 * @return List<InvArLoclChgVO>
	 * @exception EventException
	 */
	public List<InvArLoclChgVO> searchLocalChargeList(String ofc, String locCd) throws EventException;

	/**
	 * ofc에 따라 loc_cd 를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchLocalChargeLocationList(String Ofc) throws EventException;
	
	/**
	 * Local에서 사용하는 Charge code를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String acctCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMDMAccount(String acctCd) throws EventException;
	
	/**
	 * 지역별 Local Charge등록, 수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvArLoclChgVO[] invArLoclChgVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageLocalCharge(InvArLoclChgVO[] invArLoclChgVOs, String userId) throws EventException;

	/**
	 * 신규 AR Office 생성 시 구 Office와 구분을 결정하는 기준조회(VVD/Lane 별 office결정 기준일자 관리)한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String oldOfc
	 * @param String newOfc
	 * @return List<InvCutOffLaneVO>
	 * @exception EventException
	 */
	public List<InvCutOffLaneVO> searchCutOffLaneListByAROffice(String oldOfc, String newOfc) throws EventException;

	/**
	 * A/R Office별 Cut Off Lane정보등록, 수정, 삭제한다.<br>
	 * Office 신설 및 변경시 invoice관리 office결정을 등록된 내용의 날짜 기준으로 정한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCutOffLaneVO[] cutLanVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCutOffLaneByAROffice(InvCutOffLaneVO[] cutLanVOs, String userId) throws EventException;

	/**
	 * 입력된 lane code 가 정상적인 lane code인지 체크한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String lane
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcLane(String lane) throws EventException;

	/**
	 * 입력된 port가 정상적인 Location code인지 체크한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String port
	 * @return String
	 * @exception EventException
	 */
	public String searchLocation(String port) throws EventException;

	/**
	 * 입력된 VVD code 가 정상적인 VVD 인지 체크한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVVD(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * Office별 Invoice 발행시 특이사항 및 발행유형을 조회한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @return InvArStupOfcVO
	 * @exception EventException
	 */
	public InvArStupOfcVO searchIssueStandardByOffice(String ofc) throws EventException;

	/**
	 * INV_AR_MISC_BLCK_CHG 테이블에서 해당 Office 내용을 등록, 삭제함. <br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @param String chgCd
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMriChgcdByOffice(String ofc, String chgCd, String userId) throws EventException;

	/**
	 * Office별 Invoice 발행시 특이사항및 발행유형을 등록 수정한다. <br>
	 * author Dong Hoon Han
	 * 
	 * @param InvArStupOfcVO issStnVO
	 * @exception EventException
	 */
	public void manageIssueStandardByOffice(InvArStupOfcVO issStnVO) throws EventException;

	/**
	 * FNS0430001Document XMLparsing. <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return InvRevAcctCdVO[]
	 * @exception EventException
	 */
    public InvRevAcctCdVO[] fns0430001Receive(XmlObject xmlObject) throws EventException;
    
    /**
     * ERP에서 Revenue Type별 Account code를 전송받아 등록한다. <br>
     * 
     * @param InvRevAcctCdVO[] invRevAcctCdVOs
     * @exception EventException
     */
	public void createRevenueAccountList(InvRevAcctCdVO[] invRevAcctCdVOs) throws EventException;

	/**
	 * FNS_INV_0107<br>
	 * MDM 에서 관리하는 Office 정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param MdmOfcInPutVO mdmOfcInPutVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchMDMOfficeList(MdmOfcInPutVO mdmOfcInPutVO) throws EventException;
	
	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofcCd
	 * @param String usrId
	 * @return List<PrinterbyUserIdVO>
	 * @exception EventException
	 */
	public List<PrinterbyUserIdVO> searchINVPrinterbyUserId(String ofcCd, String usrId) throws EventException;
	
	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 수정, 입력한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @param String printerNm
	 * @exception EventException
	 */
	public void manageINVPrinterName(String ofc, String userId, String printerNm) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * User ID 소속의 A/R Office 관련 정보를 조회한다<br>
	 * 
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeList(String ofcCd) throws EventException ;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Glovis EDI Code Conversion 조회<br>
	 * 
	 * @param InvEdiIntgCdVO invEdiIntgCdVO
	 * @return List<InvEdiIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<InvEdiIntgCdDtlVO> searchEDIMappingCodeList(InvEdiIntgCdVO invEdiIntgCdVO) throws EventException ;
	
	/**
	 * FNS_INV_0114<br>
	 * Glovis Code 인력/저장/삭제 function.<br>
	 * 
	 * @author 이석준
	 * @param InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageEDIMappingCodeList(InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs,String userId) throws EventException ;
	
	
	/**
	 * FNS_INV_0121<br>
	 * Revenue VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<RevenueVvdListVO>
	 * @exception EventException
	 */
	public List<RevenueVvdListVO> searchRevenueVvdList(RevenueProcessParamVO paramVO) throws EventException ;
	
	/**
	 * FNS_INV_0121<br>
	 * Processing VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<ProcessingVvdListVO>
	 * @exception EventException
	 */
	public List<ProcessingVvdListVO> searchProcessingVvdList(RevenueProcessParamVO paramVO) throws EventException;
	
	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를 조회한다. <br>
	 * 
	 * @author 9011620
	 * @return
	 * @throws EventException
	 */
	public List<PHILSLocationListVO> searchEdiPHILSLocationList() throws EventException;

	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를  등록, 변경 삭제한다. <br>
	 * 
	 * @author 9011620
	 * @param vos
	 * @throws EventException
	 */
	public void manageEdiPHILSLocationList(List<PHILSLocationListVO> vos) throws EventException;	
	
	/**
	 * FNS_INV_0134 : Retrieve<br>
	 * Surcharge Description 를  조회한다. <br>
	 * 
	 * @author 김준호
	 * @param  String arHdQtrOfcCd
	 * @param  String arOfcCd
	 * @param  String chgCd
	 * @return List<InvChgDescConvVO>
	 * @throws EventException
	 */
	public List<InvChgDescConvVO> searchSurchargeDescriptionList(String arHdQtrOfcCd, String arOfcCd, String chgCd) throws EventException;
	
	/**
	 * FNS_INV_0134 : Retrieve<br>
	 * Surcharge Description 를  등록, 변경 삭제한다. <br>
	 * 
	 * @author 김준호
	 * @param vos
	 * @throws EventException
	 */
	public void manageSurchargeDescriptionList(List<InvChgDescConvVO> vos) throws EventException;
	
	
	/**
	 * LOCAL Charge 에 등록된 Charge 인지 확인한다.
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalChargeExists(String ofcCd, String chgCd) throws EventException ;
	
}