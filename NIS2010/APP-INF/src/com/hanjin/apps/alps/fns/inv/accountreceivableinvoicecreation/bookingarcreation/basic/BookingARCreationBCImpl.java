/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingARCreationBCImpl.java
 *@FileTitle : Invoice Update by User ID
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 한동훈
 *@LastVersion : 1.0
 * 2009.06.01 한동훈
 * 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2010.09.01 최도순 [] createARCancelInvoice(),createARCancelSplitInvoice(),createCancelIssueARInvoice(),createMaxIFCancel()
 * 					  FLOAT형을 정확한 계산을 위해 BigDecimal로 변경
 * 2010.09.09 최도순 [] FAC 계산 함수 try catch 구문 적용
 * 2010.09.13 최도순 [] 주간 소스결함 관리대장내 "결함검토요청" 관련 INV 예외처리부분 협의요청 ( 회의요청날짜 : 2010.09.13(월)) 
 * 2010.09.15 최도순 [CHM-201005887] DEM/DET, MRI의 환율적용일자 로직 보완 요청
 * 2010.11.24 최도순 [CHM-201006704] 한국지역 WHF DEC CANCEL 정보 유관 시스템 I/F 기능 추가
 * 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
 * 2011.02.17 최도순 [CHM-201108773] ALPS INVOICE, 두바이 지역 MRI 발행시 INVOICE CUSTOMER 조건 보완 요청
 * 2011.04.06 최도순 [CHM-201109252-01] Collection Office 설정 Logic 변경
 * 2011.04.06 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2011.04.06 최도순 [CHM-201109882-01] ALPS INVOICE 내 Other Revenue Invoice Creation 로직 변경 요청
 * 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
 * 2011.09.15 오요한 [CHM-201113333] APLS INV내 INTERFACE로직 보완 요청
 * 2011.10.17 오요한 [CHM-201113332] 허수데이터 정리 로직 보완 요청
 * 2011.10.17 오요한 [CHM-201113779] BKG&DOC to AR INV 인터페이스 로직 보완 요청
 * 2011.10.26 오요한 [] BKG INV I/F 누락 건 해결방안을 위한 로그 삽입
 * 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
 * 2012.02.09 권   민 [CHM-201216076] [INV] INTER COMPANY COA 값 재계산
 * 2012.09.11 오요한 [CHM-201219996] BKG I/F시 PAYMENT DATE 적용 - DUE DATE  (BL 단위 관리 지역)
 * 2014.12.05 최도순 [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청
 * 2016.08.18 김현화 [CHM-201642838] DUE DATE 산정 로직 보완-Other Rev(payment weekday 적용)
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationEAIDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCustPayDayVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ActInvCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArMainRecoveryDataVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAgtMkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcApplDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAttributeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BKGMainDocVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BLNoBKGStatusVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgChgeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgOfcPayIndVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ChinaVATInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CntrTypeSizeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CoaVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CustInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ERPIfReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.INDGstTypeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvSubAgnCustInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MRIRevenueVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFChgeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.RevVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdLanePortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdSaDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssueVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration.INVCommonDBDAO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.FlatFileAckVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.SendFlatFileVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.FNS012R001Document;
import com.hanjin.irep.erp.FNS012R001Document.FNS012R001;
import com.hanjin.irep.erp.FNS012R001Document.FNS012R001.DataArea;
import com.hanjin.irep.erp.FNS012R001Document.FNS012R001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS012R001Document.FNS012R001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.util.MessageUtil;
import com.hanjin.syscommon.management.alps.user.basic.UserBC;
import com.hanjin.syscommon.management.alps.user.basic.UserBCImpl;
import com.hanjin.syscommon.management.alps.user.vo.ComUserInfoVO;
/**
 * ALPS-AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Han Dong Hoon
 * @see FNS_INV_0026EventResponse,BookingARCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BookingARCreationBCImpl extends BasicCommandSupport implements BookingARCreationBC {

	// Database Access Object
	private transient BookingARCreationDBDAO dbDao = null;
	//private transient ManualARCreationDBDAO dbDao2 = null;
	private transient BookingARCreationEAIDAO eaiDao = null;
	//private transient ManualARCreationDBDAO dbDao2 = null;
	private transient INVCommonDBDAO commonDao = null;
	/**
	 * BookingARCreationBCImpl 객체 생성<br>
	 * BookingARCreationDBDAO를 생성한다.<br>
	 */
	public BookingARCreationBCImpl() {
		
		dbDao = new BookingARCreationDBDAO();
		//dbDao2 = new ManualARCreationDBDAO();
		eaiDao = new BookingARCreationEAIDAO();
		commonDao = new INVCommonDBDAO();
	}
	
	/**
	 * BookingARCreationBCImpl 객체 생성<br>
	 * BookingARCreationDBDAO를 생성한다.<br>
	 * @param String dataSource
	 */
	public BookingARCreationBCImpl(String dataSource) {
		dbDao = new BookingARCreationDBDAO(dataSource);
		eaiDao = new BookingARCreationEAIDAO();
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * InterfaceNo 에 해당되는 UserId 변경합니다.<br>
	 * 
	 * @param String ifNo
	 * @param String userID
	 * @exception EventException
	 */
	public void modifyInvoiceUserID(String ifNo, String userID) throws EventException {
		try {
			// List<InvArMnVO> insertVoList = new ArrayList<InvArMnVO>();
			// List<InvArMnVO> updateVoList = new ArrayList<InvArMnVO>();
			// List<InvArMnVO> deleteVoList = new ArrayList<InvArMnVO>();
			// for ( int i=0; i<invArMnVO .length; i++ ) {
			//				
			// invArMnVO[i].setUpdUsrId(account.getUsr_id());
			// updateVoList.add(invArMnVO[i]);
			//				
			// }

			dbDao.modifyInvoiceUserID(ifNo, userID);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearList(SysClearVO sysClearVo) throws EventException {
		int updateCntMn = 0;
		String otsSmryCd = null;
		
		List<SysClearVO> ifNoList = null;

		try {
			otsSmryCd = sysClearVo.getOtsSmryCd();			
			
			ifNoList = dbDao.searchInterfaceNumberListForSysClear(sysClearVo);			
			
			for (int i=0; i<ifNoList.size(); i++) {
				ifNoList.get(i).setUpdUsrId(sysClearVo.getUserId());
			}
			
			// INV_AR_MN 테이블에 Update
			updateCntMn = dbDao.modifyMainSysClearList(ifNoList);

			// INV_AR_CHG 테이블에 Update
			dbDao.modifyChgSysClearList(ifNoList);
			
			// ERP 처리 (INV 인 경우에만 처리한다.)
			if (otsSmryCd.equals("INV")) {
				for (int i=0; i<ifNoList.size(); i++) {
					
					List<Fns0120001VO> list2 = dbDao.searchARInvoiceForERP(ifNoList.get(i).getArIfNo(), "U");
					
					eaiDao.interfaceARInvoiceToERPAR(list2);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListByIfNo(SysClearVO sysClearVo) throws EventException {
		int updateCntMn = 0;
		String otsSmryCd = null;
		
		List<SysClearVO> ifNoList = new ArrayList<SysClearVO>();
		int chgAmt = 9999;
		try {
			otsSmryCd = sysClearVo.getOtsSmryCd();	
			
			chgAmt = dbDao.checkInterfaceNoForSysClear(sysClearVo);	
			
			if(chgAmt==0){
				if(!sysClearVo.getIfNo1().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo1());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
				if(!sysClearVo.getIfNo2().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo2());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
				if(!sysClearVo.getIfNo3().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo3());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
				if(!sysClearVo.getIfNo4().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo4());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
				if(!sysClearVo.getIfNo5().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo5());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
				if(!sysClearVo.getIfNo6().equals("")){
					SysClearVO sysClearVO = new SysClearVO();
					sysClearVO.setArIfNo(sysClearVo.getIfNo6());
					sysClearVO.setUpdUsrId(sysClearVo.getUserId());
					
					ifNoList.add(sysClearVO);
				}
			
				// INV_AR_MN 테이블에 Update
				updateCntMn = dbDao.modifyMainSysClearList(ifNoList);
	
				// INV_AR_CHG 테이블에 Update
				dbDao.modifyChgSysClearList(ifNoList);
				
				// ERP 처리 (INV 인 경우에만 처리한다.)
				if (otsSmryCd.equals("INV")) {
					for (int i=0; i<ifNoList.size(); i++) {
						
						List<Fns0120001VO> list2 = dbDao.searchARInvoiceForERP(ifNoList.get(i).getArIfNo(), "U");
						
						eaiDao.interfaceARInvoiceToERPAR(list2);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListBatch(List<SysClearVO> sysClearVos) throws EventException {
		int updateCntMn = 0;
		try {
			// INV_AR_MN 테이블에 Update
			updateCntMn = dbDao.modifyMainSysClearList(sysClearVos);

			// INV_AR_CHG 테이블에 Update
			dbDao.modifyChgSysClearList(sysClearVos);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO createMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException {
		MRIRevenueVVDLaneVO mriRevenueVVDLane = null;
		InvArMnVO invMain = new InvArMnVO();
		InvArChgVO invChgeVo = new InvArChgVO();
		INVCommonUtil utilCmd = new INVCommonUtil();
		VVDCustomerVO vvdCustomerVo = null;
		com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
		ActInvCustVO actInvCustVo = null;

		String mriMaxSeq = "";
		String laneCd = "";
		String zoneIoc = "";
		String cityCd = "";
		//String blObrdDt = "";
		String sailingDt = "";
		String effDt = "";
		String subsCoCd = "";
		//String acctDivCd = "";
		String tjSrcNm = "";
		String invAcctDivCd = "";
		String acctCd = "";
		//String loclChgFlg = "";
		String loclChgAcctCd = "";
		String invCoaAcctCd = "";
		String localTime = "";
		
		String invCustCntCd = "";
		String invCustSeq = "";
		
        String dueDt = "";
        String crTermDys = "0";
        String custCrFlg = "N";
        
        String trunkVvd = "";
        String port = "";
        
        String tVslCd = "";
        
        String ofcCd = "";
		
		int seq = 1;
        
        int ifSalar = 0;
        int ifNonre = 0;
        int ifMriar = 0;
        int ifOther = 0;
        int ifVat = 0;
        int ifWhf = 0;
        int ifCtt = 0;
        int if3rd = 0;
        int ifXxx = 0;
        
        //int erpSalar = 1;
        //int erpNonre = 1;
        //int erpMriar = 1;
        //int erpOther = 1;
        //int erpVat = 1;
        //int erpWhf = 1;
        //int erpCtt = 1;
        //int erp3rd = 1;
        //int erpXxx = 1;
        
        int erpSalar = 0;
        int erpNonre = 0;
        int erpMriar = 0;
        int erpOther = 0;
        int erpVat = 0;
        int erpWhf = 0;
        int erpCtt = 0;
        int erp3rd = 0;
        int erpXxx = 0;
        
        int oftCnt = 0;
        
        InvArAmtVO invArAmtVo = null;
        
        //List<CntrTypeSizeVO> list2 = null;
        //List<Fns0120001VO> list3 = null;
        String cntrNos = "";
		//String cntrTpSzs = "";
		BigDecimal bLSumAmount = new BigDecimal("0");
		BigDecimal sumAmount = new BigDecimal("0");
		BigDecimal acctRate = new BigDecimal("0");
		BigDecimal zero =  new BigDecimal("0");

        String otsSmryCd = "";
        List<ArOfcAttributeVO> arOfcAttributeVOs = null;
        ARCreditVO aRCreditVO = new ARCreditVO();
        ARCreditInputVO arCrdtVo = new ARCreditInputVO();
        
        String clzStsCd = "";
        String svrId = invCreVo.getSvrId();
		
		try {
			
			log.info("\n########## invCreVo.getRevSrcCd() : "+invCreVo.getRevSrcCd());
			log.info("\n########## invCreVo.getEffDt() : "+invCreVo.getEffDt().replaceAll("-", ""));
			
			//2017.06.29 OFT 가 있는 경우 MIC 단독 생성 가능하도록 보완
			for (int p = 0; p < invCreVo.getBkgChgeListVOs().size(); p++) {
				if(("OFT").equals(invCreVo.getBkgChgeListVOs().get(p).getChgCd())){
					oftCnt++;
				}
			}
			
			if (invCreVo.getRevSrcCd().equals("IC") && oftCnt == 0) {
			
				//bLSumAmount = Float.parseFloat(dbDao.searchBLSumAmount(invCreVo.getOfcCd(), invCreVo.getBlNo()));
				bLSumAmount = new BigDecimal(dbDao.searchBLSumAmount(invCreVo.getOfcCd(), invCreVo.getBlNo()));
				
				for (int idx = 0; idx < invCreVo.getBkgChgeListVOs().size(); idx++) {
					
					acctRate = new BigDecimal(dbDao.searchAcctRate(invCreVo.getBkgChgeListVOs().get(idx).getCurrCd()));
					log.info("\n########## acctRate : "+acctRate);
					
					BigDecimal amount = new BigDecimal(invCreVo.getBkgChgeListVOs().get(idx).getTrfRtAmt()).multiply(
		                                new BigDecimal(invCreVo.getBkgChgeListVOs().get(idx).getRatAsCntrQty()));
					
					BigDecimal pcAmt = new BigDecimal("100");
					if (invCreVo.getBkgChgeListVOs().get(idx).getPerTpCd().equals("PC")) {
						amount = amount.divide(pcAmt,6,BigDecimal.ROUND_HALF_UP);
						
					}
					
					log.debug("\n########## amount : "+amount);
					try{	
						sumAmount = sumAmount.add(amount.divide(acctRate,6,BigDecimal.ROUND_HALF_UP));
					}catch (Exception ex) {
						throw new EventException(new ErrorHandler("INV00001", new String[] {}).getMessage());
					}
					
					log.debug("\n########## sumAmount : "+sumAmount);
									
				}
				
				sumAmount = sumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
				
				log.debug("\n########## bLSumAmount : "+bLSumAmount);
				log.debug("\n########## sumAmount : "+sumAmount);
				log.debug("\n########## bLSumAmount + sumAmount : "+ bLSumAmount.add(sumAmount));
				
				//2010-04-07 
				if (bLSumAmount.add(sumAmount).compareTo(zero) == -1 ) {
					//log.info("\n########## amt is larger than BL's amt");
					throw new EventException(new ErrorHandler("INV00103", new String[] {}).getMessage());
				}
			
			}
			
			if (invCreVo.getOfcCd().equals("FXTSC")) {
				ofcCd = "LONBB";
			}else if (invCreVo.getOfcCd().equals("GDYSC")) {
				ofcCd = "WRPSC";
			} else {
				ofcCd = invCreVo.getOfcCd();
			}
						
			mriMaxSeq = dbDao.searchMRIInterfaceNo(ofcCd);

			if (mriMaxSeq.equals("")) {
				dbDao.addMRIInterfaceNo(ofcCd, userId);
				mriMaxSeq = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
			} else {
				dbDao.modifyMRIInterfaceNo(ofcCd, mriMaxSeq, userId);
			}			
			
			log.info("\n########## invCreVo.getDueDt() : "+invCreVo.getDueDt());
			
			arCrdtVo.setActCustCntCd(invCreVo.getCustCntCd());
			arCrdtVo.setActCustSeq(invCreVo.getCustSeq());
			arCrdtVo.setArOfcCd(invCreVo.getOfcCd());
			arCrdtVo.setSailArrDt(invCreVo.getSailArrDt());
			arCrdtVo.setIoBndCd(invCreVo.getIoBndCd());
			arCrdtVo.setLocCd(invCreVo.getLocCd());
			arCrdtVo.setDelCd(invCreVo.getDelCd());
			arCrdtVo.setBlSrcNo(invCreVo.getBlSrcNo());
			arCrdtVo.setRevSrcCd(invCreVo.getRevSrcCd());
			
			aRCreditVO = searchARCredit(arCrdtVo);
						
			if (!invCreVo.getDueDt().replace("-", "").equals("")) {
				
				dueDt = invCreVo.getDueDt().replace("-", "");
				if(aRCreditVO != null){
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
				
				log.info("\n########## dueDt1 : "+dueDt);
			
			} else {				
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt();
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
				
				log.info("\n########## dueDt2 : "+dueDt);
									
			}
			
			log.info("\n########## dueDt3 : "+dueDt);
			
			laneCd = dbDao.searchLaneCode(invCreVo.getLclVvd());
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CFDR")||
				invCreVo.getLclVvd().substring(0, 4).equals("COMC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				
				zoneIoc = "OO";
			} else {
				zoneIoc = dbDao.searchZoneIOC(invCreVo.getPolCd(), invCreVo.getPodCd());
			}

			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, zoneIoc , invCreVo.getPodCd());
			log.info("\n########## mriRevenueVVDLane1");
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO" , invCreVo.getPodCd());
				log.info("\n########## mriRevenueVVDLane2");
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd , invCreVo.getPodCd());
				log.info("\n########## mriRevenueVVDLane3");
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				//rev_src_cd가 'RD'인 경우 vsl을 'CNTC'로 변경하고
				if (invCreVo.getRevSrcCd().equals("RD")) {
					tVslCd = "CNTC";
				} else {
					tVslCd = invCreVo.getLclVvd().substring(0, 4);
				}
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
				log.info("\n########## mriRevenueVVDLane4");
			}
						
			if (mriRevenueVVDLane.getRevVvd().equals("") || mriRevenueVVDLane.getRevLane().equals("")) {
				throw new EventException(new ErrorHandler("INV00119",new String[]{}).getMessage());
			}
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
				laneCd = mriRevenueVVDLane.getSlaneCd();
			}
						
			cityCd = dbDao.searchCityCd(invCreVo.getOfcCd());

			localTime = dbDao.searchLocalTime(invCreVo.getOfcCd());
			
			if (invCreVo.getBkgNo() != null && !invCreVo.getBkgNo().equals("")) {
				sailingDt = dbDao.searchSailingDateByBkgNo(invCreVo.getBkgNo());
				log.info("\n########## sailingDt1 : "+sailingDt);
			} else{
				sailingDt= dbDao.searchSailingDateByBlNo(invCreVo.getBlSrcNo());
			}
			
			//sailing dt 없으면 VVD Pol로	
			if(sailingDt.equals("")) sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
			
			//sailing dt 없으면 VVD 해당 Port로	
			if (sailingDt.equals("")) {
				if (invCreVo.getIoBndCd().equals("I")) {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPodCd());
					log.info("\n########## sailingDt2 : "+sailingDt);
				} else {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
					log.info("\n########## sailingDt3 : "+sailingDt);
				}
			}
			
			log.info("\n########## sailingDt4 : "+sailingDt);			
			// requested on 20120117 CNTC added
			if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC") || invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				
				if (invCreVo.getLclVvd().substring(4, 8).equals(localTime.substring(2, 6))){
					sailingDt = localTime;					
				}else{
					sailingDt = localTime.substring(0, 2)+invCreVo.getLclVvd().substring(4, 8)+"01";
				}

				log.info("\n########## sailingDt : "+sailingDt);
			} 
			
			if (sailingDt.equals("")) {
				throw new EventException(new ErrorHandler("INV00132",new String[]{}).getMessage());
			}
			
			if (invCreVo.getRevSrcCd().equals("TM") || invCreVo.getRevSrcCd().equals("TN") || invCreVo.getRevSrcCd().equals("EQ")) {
					
				effDt = invCreVo.getEffDt().replaceAll("-", "");
				log.info("\n########## effDt111 : "+effDt);
				
				clzStsCd = dbDao.searchClosingStatus(invCreVo.getOfcCd(), effDt, "M");
				
				if (!clzStsCd.equals("O")) {
					throw new EventException(new ErrorHandler("INV00015",new String[]{}).getMessage());
				}
								
			} else {
			
				effDt = dbDao.searchEffectiveDate(invCreVo.getOfcCd(), sailingDt, invCreVo.getRevTpCd(), invCreVo.getRevSrcCd());
				log.info("\n########## effDt222 : "+effDt);
				
				if (effDt.equals("")) {
					throw new EventException(new ErrorHandler("INV00122",new String[]{}).getMessage());
				}
				
			}
						
			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());

			//acctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd() + invCreVo.getRevSrcCd());
						
			actInvCustVo = dbDao.searchInvCustomer(invCreVo.getBlNo(), invCreVo.getOfcCd());
			
			trunkVvd = invCreVo.getTrunkVvd();
			
 
			if (trunkVvd.length() == 9) {

				port = invCreVo.getIoBndCd().equals("O")?invCreVo.getPolCd():invCreVo.getPodCd();
				
				// 운항 스케줄에서 trunk vvd 체크
				if (dbDao.checkVskVslPortSkd(trunkVvd, port) 
					&& !trunkVvd.substring(0, 4).equals("CFDR") && !trunkVvd.substring(0, 4).equals("USAC")	&& !trunkVvd.substring(0, 4).equals("CNTC")){			
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));					
					log.info("\n########## trunkVvd1 : "+trunkVvd);				
				} else {
					if (trunkVvd.substring(0, 4).equals("CFDR") || trunkVvd.substring(0, 4).equals("USAC") || trunkVvd.substring(0, 4).equals("CNTC")){
						invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
						invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
						invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					}else {
						// [2013.09.12] Trunk VVD를 입력했는데 존재하지 않는경우 기존에는 CFDR로 처리했으나, Error 로 처리함. 
//						throw new EventException(new ErrorHandler("INV00171",new String[]{}).getMessage());
						trunkVvd = dbDao.searchTrunkVvd();
						invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
						invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
						invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
//						log.info("\n########## trunkVvd2 : "+trunkVvd);
					}
				}			
				
			} else {
				
				if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC") ||
					invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {				
					invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
					invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
					invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));				
				} else {					
					trunkVvd = dbDao.searchTrunkVvd();
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					log.info("\n########## trunkVvd3 : "+trunkVvd);				
				}
			}
			
			log.info("\n########## trunkVvd4 : "+trunkVvd);
			
			if (actInvCustVo == null) {
				invCustCntCd = invCreVo.getCustCntCd();
				invCustSeq = invCreVo.getCustSeq();		
			} else {
				if (invCreVo.getOfcCd().equals("DXBSC")) {
					invCustCntCd = invCreVo.getCustCntCd();
					invCustSeq = invCreVo.getCustSeq();	
				}else{
					invCustCntCd = actInvCustVo.getInvCustCntCd();
					invCustSeq = actInvCustVo.getInvCustSeq();
				}
			}
						
			//////////////////////////////////////////////////////////////////////////////////////

			List<BkgChgeListVO> bkgChgeListVOs = invCreVo.getBkgChgeListVOs();
			String rev_types_mn = invCreVo.getRevTpCd() + invCreVo.getRevSrcCd();

			if (rev_types_mn.equals("MCT")) {
				invCoaAcctCd = "110811";
			} else if (rev_types_mn.equals("MTP") || rev_types_mn.equals("MRD")) {
				invCoaAcctCd = "111091";
			} else {
				invCoaAcctCd = "110611";
			}
			
			otsSmryCd  = dbDao.searchOtsSmryCd(invCreVo.getOfcCd());
			
			log.info("\n########## otsSmryCd : "+otsSmryCd);
			
			if (otsSmryCd.equals("INV")) {
				
				arOfcAttributeVOs = dbDao.searchRepCustCdByArOfcCd(invCreVo.getOfcCd());
				
				for (int i = 0; i < arOfcAttributeVOs.size(); i++) {
					if (invCreVo.getCustCntCd().equals(arOfcAttributeVOs.get(i).getRepCustCntCd()) 
						&& Integer.parseInt(invCreVo.getCustSeq()) == Integer.parseInt(arOfcAttributeVOs.get(i).getRepCustSeq())) {
						throw new EventException(new ErrorHandler("INV00123",new String[]{}).getMessage());
					}
				
				}
								
			}			
			
			invMain.setArIfNo(mriMaxSeq);
			invMain.setBlNo(invCreVo.getBlNo());
//			if (!invCreVo.getDueDt().replace("-", "").equals("")) {
//				if (invCreVo.getBkgNo().equals("")) {
//					invMain.setBkgNo(invCreVo.getBlNo());
//				} else {
//					invMain.setBkgNo(invCreVo.getBkgNo());
//				}				
//			}			
			invMain.setBkgNo(invCreVo.getBkgNo());
			invMain.setBlSrcNo(invCreVo.getBlNo());
			invMain.setActCustCntCd(invCreVo.getCustCntCd());
			invMain.setActCustSeq(invCreVo.getCustSeq());
			invMain.setArOfcCd(invCreVo.getOfcCd());
			invMain.setRevTpCd(invCreVo.getRevTpCd());
			invMain.setRevSrcCd(invCreVo.getRevSrcCd());
			invMain.setVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setLoclCurrCd(invCreVo.getLclCurr());
			invMain.setSvcScpCd(invCreVo.getSvcScpCd());
			invMain.setSailDt(sailingDt);
			invMain.setSailArrDt(invCreVo.getSailArrDt());
			invMain.setSlanCd(laneCd);
			invMain.setIoBndCd(invCreVo.getIoBndCd());
//			if (invCreVo.getTrunkVvd().length() == 9) {
//				invMain.setTrnkVslCd(invCreVo.getTrunkVvd().substring(0, 4));
//				invMain.setTrnkSkdVoyNo(invCreVo.getTrunkVvd().substring(4, 8));
//				invMain.setTrnkSkdDirCd(invCreVo.getTrunkVvd().substring(8, 9));
//			}
			invMain.setPorCd(invCreVo.getPorCd());
			invMain.setPolCd(invCreVo.getPolCd());
			invMain.setPodCd(invCreVo.getPodCd());
			invMain.setDelCd(invCreVo.getDelCd());
			invMain.setCustCrFlg(custCrFlg);
			invMain.setInvCustCntCd(invCustCntCd); 
			invMain.setInvCustSeq(invCustSeq);
			invMain.setDueDt(dueDt);
			invMain.setGlEffDt(effDt);
			invMain.setBkgRefNo(invCreVo.getBkgRefNo());
			invMain.setInvRefNo(invCreVo.getInvRefNo());
			invMain.setSiRefNo(invCreVo.getSiRefNo());
			invMain.setHjsStfCtnt(invCreVo.getHjsRef());
			//invMain.setUsdXchRt(usdXchRt);
			//invMain.setXchRtUsdTpCd(invCreVo.getUsdExrateType());
			//invMain.setXchRtN3rdTpCd(invCreVo.getThirdExrateType());
			//invMain.setXchRtDt(invCreVo.getExRateDate());
			//invMain.setObrdDt(blObrdDt);
			//invMain.setInvTtlLoclAmt(String.valueOf(totalLocalAmt));
			//log.info("\n########## mriRevenueVVDLane.getRevVvd() : "+mriRevenueVVDLane.getRevVvd());
			if (mriRevenueVVDLane.getRevVvd().length() == 9) {
				invMain.setRevVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
				invMain.setRevSkdVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
				invMain.setRevSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
				invMain.setRevDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
			} else if (mriRevenueVVDLane.getRevVvd().length() == 10) {
				invMain.setRevVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
				invMain.setRevSkdVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
				invMain.setRevSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
				invMain.setRevDirCd(mriRevenueVVDLane.getRevVvd().substring(9,10));        
			}
			invMain.setRlaneCd(mriRevenueVVDLane.getRevLane());			
			invMain.setZnIocCd(zoneIoc);
			invMain.setCrTermDys(crTermDys); 
			invMain.setArCtyCd(cityCd);
			invMain.setSlsOfcCd(invCreVo.getOfcCd());
			invMain.setArInvSrcCd("NISAR");
			invMain.setInvCoaAcctCd(invCoaAcctCd);
			invMain.setInvCoaInterCoCd(subsCoCd);
			invMain.setCreUsrId(userId);
			invMain.setUpdUsrId(userId);
			invMain.setInvRmk(invCreVo.getInvRmk());
			invMain.setCgoWgt("0");
			invMain.setCgoMeasQty("0");			
			invMain.setBkgTeuQty(invCreVo.getBkgTeuQty());
			invMain.setBkgFeuQty(invCreVo.getBkgFeuQty());
			invMain.setMstBlNo(invCreVo.getMasterInv());
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			if (svrId.equals("EUR") || svrId.equals("KOR")
					|| (svrId.equals("JPN") && invCreVo.getIoBndCd().equals("O"))) {
				invMain.setInvSvcScpCd("OTH");
			} else {
				invMain.setInvSvcScpCd(invCreVo.getSvcScpCd());
			}
			
			//----------------HAN 2010-04-06 START
			if (svrId.equals("KOR") || svrId.equals("ENT")) {
				String chg_chk = "0";
				for (int i = 0; i < bkgChgeListVOs.size(); i++) {
					String chg_cd2 = bkgChgeListVOs.get(i).getChgCd();
					if(chg_cd2 != null && chg_cd2.equals("TVA")){
						chg_chk = "10";
					}
				}
				invMain.setArTaxIndCd(chg_chk);
			}
			//----------------HAN 2010-04-06 END
			
			vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(invCustCntCd);
			vvdCustomerVo.setInvCustCd(invCustSeq);
			vvdCustomerVo.setVsl(invCreVo.getLclVvd().substring(0, 4));
			vvdCustomerVo.setVoy(invCreVo.getLclVvd().substring(4, 8));
			vvdCustomerVo.setDep(invCreVo.getLclVvd().substring(8, 9));
			vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());
			//vvdCustomerVo.setSvcScp(invCreVo.getSvcScpCd());
			vvdCustomerVo.setSvcScp(invMain.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invCreVo.getIoBndCd());
			vvdCustomerVo.setOfcCd(invCreVo.getOfcCd());
			vvdCustomerVo.setBkgNo(invCreVo.getBkgNo());
			vvdCustomerVo.setSaDt(invCreVo.getSailArrDt());
			vvdCustomerVo.setPol(invCreVo.getPolCd());
			vvdCustomerVo.setPod(invCreVo.getPodCd());
			//2010-04-27 blNo 추가
			vvdCustomerVo.setBlSrcNo(invCreVo.getBlSrcNo());
			vvdCustomerVo.setCurr("USD");  

			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			invMain.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invMain.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			//2010.09.15 최도순 [CHM-201005887] DEM/DET, MRI의 환율적용일자 로직 보완 요청
			invMain.setXchRtDt(exchangeRateVo.getExRateDate());
			invMain.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : "");
			//invMain.setAcctXchRtYrmon(exchangeRateVo.getExRateDate());
			invMain.setUsdXchRt(exchangeRateVo.getExRate());			
			if (effDt.length() > 6) {
				invMain.setAcctXchRtYrmon(effDt.substring(0, 6));
			}			
			invMain.setBlInvCfmDt(localTime);
			invMain.setInvDeltDivCd("N");
			
			invMain.setRvsChgFlg(invCreVo.getRvsChgFlg());
			
			//log.info("\n########## exchangeRateVo.getExRate() : "+exchangeRateVo.getExRate());
			
			dbDao.addInvMain(invMain);
			
			log.info("\n########## invCreVo.getIoBndCd() : "+invCreVo.getIoBndCd());
		    if (invCreVo.getIoBndCd().equals("I")) {
		    	dbDao.modifyInvRefNo(invCreVo.getBlNo(), invCreVo.getOfcCd(), invCreVo.getInvRefNo());
		    }
		
			if (bkgChgeListVOs != null) {
				List<InvArChgVO> addVoList = new ArrayList<InvArChgVO>();
				//String rev_types = invCreVo.getRevType() + invCreVo.getRevTpCd();
				//String svrId = invCreVo.getSvrId();
				String chg_cd = "";
				String curr_cd = "";
				
				String invCoaRgnCd = "";
				String invCoaCtrCd = "";
				//String localTime = "";	
				String rhq = "";
				String mriMaxYymm = "";
				//String glEffDt = "";
				String ofcAgentMark = "";
				String erpIfOfcCd = "";
				//String custCrFlg = "";
				String repChgCd = "";					
				String chgFullNm = "";
				MdmOrganizationVO mdmOrgVo = null;		
				DueDateVO dueDateVo = null;
				
				mdmOrgVo = dbDao.searchOfficeAttributeMri(invCreVo.getOfcCd());
				invCoaRgnCd = mdmOrgVo.getFincRgnCd();
		        invCoaCtrCd = mdmOrgVo.getArCtrCd();
		        rhq = mdmOrgVo.getArHdQtrOfcCd();
		        ofcAgentMark = mdmOrgVo.getArAgnStlCd();
		        
		        mriMaxYymm = dbDao.searchMriMaxYymm(invCreVo.getOfcCd());
				
				if (mriMaxYymm.equals("")) {
					mriMaxYymm = dbDao.searchMriMaxYymm(rhq);
				}
		        
		        dueDateVo = dbDao.searchDueDtForMaxINVInterface(invCreVo.getBlNo(), invCreVo.getOfcCd()); 
				
				if (dueDateVo != null) {
					custCrFlg = dueDateVo.getCustCrFlg(); 
				}
		        
		        if(svrId.equals("USA") && ofcAgentMark.equals("B") && custCrFlg.equals("Y")){
		        	//2010-06-08 CA 추가
		        	if(invCreVo.getCustCntCd().equals("US")||invCreVo.getCustCntCd().equals("CA")) {		        	 
		        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 			
		        	}

		        } else if (svrId.equals("KOR") && invCreVo.getCustCntCd().equals("KR")) {
		        	
		        	if(custCrFlg.equals("Y")) {
		        		
		        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 						
		        	
		        	}								
		        }

		        if (erpIfOfcCd.equals("")) {
		        	erpIfOfcCd = invCreVo.getOfcCd();
		        }		
		        
		        BigDecimal chgAmt = new BigDecimal(0);
		        
				for (int i = 0; i < bkgChgeListVOs.size(); i++) {
					InvArChgVO invChges = new InvArChgVO();
					chg_cd = bkgChgeListVOs.get(i).getChgCd();
					repChgCd = dbDao.searchRepCharge(chg_cd); 				
					chgFullNm = dbDao.searchChargeName(chg_cd, invMain.getArOfcCd());
					
					invAcctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd(), invCreVo.getRevSrcCd()); 
					
					if (invAcctDivCd!=null && invAcctDivCd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(bkgChgeListVOs.get(i).getChgCd()); 
						log.info("   \n########## acctCd1 : "+acctCd);
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(bkgChgeListVOs.get(i).getChgCd());
						log.info("   \n########## acctCd2 : "+acctCd);
					}

					acctCd = dbDao.searchAccountCd( invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd(), invCreVo.getRevSrcCd(), svrId, acctCd);
					log.info("   \n########## acctCd3 : "+acctCd);
					
					invChgeVo = dbDao.searchInvRevTpSrcCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo, svrId, acctCd);
					
					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
					
//					if (invCreVo.getOfcCd().equals("VLCSC")) {
//						
//						loclChgFlg = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
//						
//						if (!loclChgFlg.equals("") || bkgChgeListVOs.get(i).getChgCd().equals("IVA")) {
//							
//							invChges.setRevCoaAcctCd("954117"); 
//							
//							dbDao.modifyArOffstNo(mriMaxSeq, "VLC LCL CHRG");
//							
//						}
//												
//					} else if (invCreVo.getOfcCd().equals("CMBSC")) {
//						
//						loclChgFlg = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
//						
//						if (!loclChgFlg.equals("")) {
//							
//							invChges.setRevCoaAcctCd("954117"); 
//							
//							dbDao.modifyArOffstNo(mriMaxSeq, "CMB LCL CHRG");
//							
//						}						
//												
//					}
					
					loclChgAcctCd = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
					
					//2010-06-09
					if (!loclChgAcctCd.equals("")) {
						
						invChges.setRevCoaAcctCd(loclChgAcctCd); 
						
						if (loclChgAcctCd.equals("954117")) {
							dbDao.modifyArOffstNo(mriMaxSeq, invCreVo.getOfcCd().substring(0, 3)+" LCL CHRG");
						}
						
					} 
					
					log.info("   \n########## loclChgAcctCd : "+loclChgAcctCd);
					log.info("   \n########## loclChgAcctCd2 : "+invCreVo.getOfcCd().substring(0, 3)+" LCL CHRG");
					
					chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getTrfRtAmt()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getRatAsCntrQty()));
					
					
					BigDecimal pcAmt = new BigDecimal("100");
					if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
						chgAmt = chgAmt.divide(pcAmt);
					}
					
					log.info("   \n########## chgAmt1 : "+bkgChgeListVOs.get(i).getTrfRtAmt());
					log.info("   \n########## chgAmt2 : "+bkgChgeListVOs.get(i).getRatAsCntrQty());
					log.info("   \n########## chgAmt3 : "+bkgChgeListVOs.get(i).getInvXchRt());
					log.info("   \n########## chgAmt4 : "+chgAmt);

					invChges.setArIfNo(mriMaxSeq);
					//invChges.setArIfSerNo(String.valueOf(i + 1));
					invChges.setChgSeq(String.valueOf(i + 1));
					invChges.setChgCd(bkgChgeListVOs.get(i).getChgCd());
					invChges.setCurrCd(bkgChgeListVOs.get(i).getCurrCd().substring(0, 3));
					invChges.setPerTpCd(bkgChgeListVOs.get(i).getPerTpCd());
					invChges.setTrfRtAmt(bkgChgeListVOs.get(i).getTrfRtAmt());
					invChges.setRatAsCntrQty(bkgChgeListVOs.get(i).getRatAsCntrQty());
					invChges.setChgAmt(String.valueOf(chgAmt));
					
					// 2011.06.20 오요한[CHM-201111084] MRI환율적용로직보 INS<S>
					vvdCustomerVo.setCurr(invChges.getCurrCd());
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
					// 2011.06.20 오요한[CHM-201111084] MRI환율적용로직보 INS<E>
					
					// 2011.06.20 오요한[CHM-201111084] MRI환율적용로직보 UPD<S>
					//invChges.setInvXchRt(bkgChgeListVOs.get(i).getInvXchRt());
					invChges.setInvXchRt(exchangeRateVo.getExRate());
					// 2011.06.20 오요한[CHM-201111084] MRI환율적용로직보 UPD<E>
					
					//2010.09.15 최도순 [CHM-201005887] DEM/DET, MRI의 환율적용일자 로직 보완 요청
					invChges.setInvXchRtDt(exchangeRateVo.getExRateDate());
					//invChges.setInvRevTpSrcCd(invCreVo.getRevType() + invCreVo.getRevTpCd()); 
					invChges.setOfcCd(invCreVo.getOfcCd());
					//invChges.setRevCoaAcctCd(acctCd); 
					invChges.setRevCoaInterCoCd(subsCoCd);
					if (mriRevenueVVDLane.getRevVvd().length() == 9) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
					} else if (mriRevenueVVDLane.getRevVvd().length() == 10) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(9,10));        
					}
					invChges.setAcctCd(acctCd);
					invChges.setTvaFlg(bkgChgeListVOs.get(i).getTvaFlg().equals("1") ? "Y" : "N");
					invChges.setChgRmk(bkgChgeListVOs.get(i).getChgRmk());
					invChges.setCreUsrId(userId);
					invChges.setUpdUsrId(userId);
					invChges.setRepChgCd(repChgCd);
					invChges.setChgFullNm(chgFullNm);
					
					invChges.setInvRevTpSrcCd(invChgeVo.getInvRevTpSrcCd()); 
					invChges.setRevCoaCoCd(invChgeVo.getRevCoaCoCd());
					invChges.setRevCoaRgnCd(invChgeVo.getRevCoaRgnCd());
					invChges.setRevCoaCtrCd(invChgeVo.getRevCoaCtrCd());
//					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd()); 
					
					tjSrcNm = dbDao.searchTjSrcNm(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd()+invCreVo.getRevSrcCd(), svrId);

					log.info("\n########## tjSrcNm : "+tjSrcNm);
					
					invChges.setTjSrcNm(tjSrcNm);

					addVoList.add(invChges);
					
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////
					///// AR_IF_SER_NO 생성
										
					if (tjSrcNm.equals("SALAR")) {
						if (ifSalar == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifSalar = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifSalar));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpSalar++;
						} else {
							erpSalar = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpSalar));
					} else if (tjSrcNm.equals("NONRE")) {
						if (ifNonre == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
					        ifNonre = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifNonre));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpNonre++;
						} else {
							erpNonre = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpNonre));
					} else if (tjSrcNm.equals("MRIAR")) {
						if (ifMriar == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifMriar = seq++;							
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifMriar));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpMriar++;
						} else {
							erpMriar = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpMriar));						
					} else if (tjSrcNm.equals("OTHER")) {
						if (ifOther == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifOther = seq++;
						} 	
						addVoList.get(i).setArIfSerNo(String.valueOf(ifOther));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpOther++;
						} else {
							erpOther = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpOther));
					} else if (tjSrcNm.equals("VAT")) {
						if (ifVat == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifVat = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifVat));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpVat++;
						} else {
							erpVat = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpVat));
					} else if (tjSrcNm.equals("WHF")) {
						if (ifWhf == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifWhf = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifWhf));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpWhf++;
						} else {
							erpWhf = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpWhf));
					} else if (tjSrcNm.equals("CTT")) {
						if (ifCtt == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifCtt = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifCtt));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpCtt++;
						} else {
							erpCtt = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpCtt));
					} else if (tjSrcNm.equals("3RD")) {
						if (if3rd == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							if3rd = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(if3rd));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erp3rd++;
						} else {
							erp3rd = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erp3rd));
					} else if (tjSrcNm.equals("XXX")) {
						if (ifXxx == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifXxx = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifXxx));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpXxx++;
						} else {
							erpXxx = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpXxx));
					}						
					
					curr_cd = bkgChgeListVOs.get(i).getCurrCd();
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////

				} // for
				
				
				if (addVoList.size() > 0) {
					dbDao.addInvCharge(addVoList);
				}
								
				invArAmtVo = new InvArAmtVO();
				
				invArAmtVo.setArIfNo(mriMaxSeq);
				invArAmtVo.setArInvSrcCd("NISAR");
				invArAmtVo.setInvCoaCoCd("01");
				invArAmtVo.setInvCoaRgnCd(invCoaRgnCd);
				invArAmtVo.setInvCoaCtrCd(invCoaCtrCd);
				invArAmtVo.setInvCoaInterCoCd(subsCoCd);
				invArAmtVo.setInvCoaVslCd("0000");
				invArAmtVo.setInvCoaVoyNo("0000");
				invArAmtVo.setInvCoaSkdDirCd("0");
				invArAmtVo.setInvCoaRevDirCd("0");
				invArAmtVo.setErpIfGlDt(effDt);   
				invArAmtVo.setErpIfOfcCd(erpIfOfcCd);
								
				// INV_AR_AMT table 에 저장	
				dbDao.addInvAmount(svrId, invMain, invArAmtVo);

			}

			dbDao.modifyInvTotalLocalAmount(mriMaxSeq);

			List<BKGContainerVO> bkgContainerVOs = invCreVo.getBkgContainerVOs();

			if (bkgContainerVOs != null) {
				List<InvArCntrVO> addVoList = new ArrayList<InvArCntrVO>();
				StringBuffer cntrNosBuff = new StringBuffer();
				
				for (int i = 0; i < bkgContainerVOs.size(); i++) {
					InvArCntrVO invCntrs = new InvArCntrVO();

					invCntrs.setArIfNo(mriMaxSeq);
					invCntrs.setCntrSeq(Integer.toString(i + 1));
					invCntrs.setCntrNo(bkgContainerVOs.get(i).getCntrNo());
					invCntrs.setCntrTpszCd(bkgContainerVOs.get(i).getCntrTpszCd());
					invCntrs.setCreUsrId(userId);
					invCntrs.setUpdUsrId(userId);

					addVoList.add(invCntrs);
					
					// ERP 전송 처리 시작
					cntrNosBuff.append(bkgContainerVOs.get(i).getCntrNo() + (i != bkgContainerVOs.size() - 1 ? "," : ""));
					//cntrNos = cntrNos + bkgContainerVOs.get(i).getCntrNo() + (i != bkgContainerVOs.size() - 1 ? "," : "");
					
				}
				
				cntrNos = cntrNosBuff.toString();
			
				int lastIdx = 0;
				if (cntrNos.length() > 150) {
					
					cntrNos = cntrNos.substring(0, 150);
					//log.info("\n########## cntrNos2 : " + cntrNos);
					
					lastIdx = cntrNos.lastIndexOf(",");						
					//log.info("\n########## lastIdx : " + lastIdx);
					
					cntrNos = cntrNos.substring(0, lastIdx);						
					//log.info("\n########## cntrNos3 : " + cntrNos);
											
				}
				
				if (addVoList.size() > 0) {
					dbDao.addInvContainer(addVoList, userId);
				}
			}
			
			// 2010-05-28 ERP 전송 SC로 뺌
			/*
			list2 = dbDao.searchCntrTpSzForERP(mriMaxSeq);

			for (int i = 0; i < list2.size(); i++) {
				cntrTpSzs = cntrTpSzs + list2.get(i).getCntrTpszCd() + "X" + list2.get(i).getCntrTpszCnt() + (i != list2.size() - 1 ? "," : "");
			}
			log.info("########## cntrTpSzs : " + cntrTpSzs);
			
			list3 = dbDao.searchARInvoiceForERP(mriMaxSeq, "C");

			for (int i = 0; i < list3.size(); i++) {
				list3.get(i).setCntrNo(cntrNos);
				list3.get(i).setCntrTpSz(cntrTpSzs);
			}

			eaiDao.interfaceARInvoiceToERPAR(list3);
			*/
			// ERP 전송 처리 끝
			
			//2010-05-27 RevSrcCd BN일 경우 delete 추가
			if(invCreVo.getRevSrcCd().equals("BN")){
				dbDao.modifyDelCode(mriMaxSeq, userId);
			}
			
		} catch (EventException ex) {	
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		}
		
		//return mriMaxSeq;
		return invMain;
	}

	/**
	 * No Good 매출채권 또는 Good 매출채권이면서 Actual 및 Invoice Customer 이외 항목 변경한 경우 업데이트<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		
		VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
		com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
		
		INVCommonUtil utilCmd = new INVCommonUtil();
		
		try {
			
			List<InvArMnVO> invArMnList = dbDao.searchARInvoice(invCreVo.getInvArMnVO().getArIfNo());
			InvArMnVO invArMnVO = invArMnList.get(0);
			
			cnt = dbDao.checkAccountRateExist(invCreVo.getInvArMnVO().getGlEffDt());

			if (cnt > 0 && invCreVo.getInvArMnVO().getBlInvCfmDt().equals("")) {
				// [경리환율 존재하는 경우]+[No Good 을 Good 시키는 경우]
				
				String port = invCreVo.getInvArMnVO().getIoBndCd().equals("O")?invCreVo.getInvArMnVO().getPolCd():invCreVo.getInvArMnVO().getPodCd();
				String vvd = invCreVo.getInvArMnVO().getVslCd()+ invCreVo.getInvArMnVO().getSkdVoyNo()+invCreVo.getInvArMnVO().getSkdDirCd();
				
				String sailArrDt = utilCmd.searchSADate(vvd , port, invCreVo.getInvArMnVO().getIoBndCd());
				
				invCreVo.getInvArMnVO().setSailArrDt(sailArrDt);
				
				String znIocCd = dbDao.searchZoneIOC(invCreVo.getInvArMnVO().getPolCd(), invCreVo.getInvArMnVO().getPodCd());
				
								
				//2010-04-20 업데이트 대상 IFNO 에 RevVVD 가 없을경우
				if(invArMnVO.getRevVslCd().equals("")||invArMnVO.getRevSkdVoyNo().equals("")||invArMnVO.getRevSkdDirCd().equals("")||invArMnVO.getRevDirCd().equals("")){
					RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(invCreVo.getInvArMnVO().getBkgNo());
					
					String revVvd = "";
					String rlaneCd = "";
					
					if(revVVDLaneVO != null){
						revVvd = revVVDLaneVO.getRevVvd();
						rlaneCd = revVVDLaneVO.getRlaneCd();				
					}
					
					if(revVvd.equals("X")){
						revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
						if(revVVDLaneVO != null){
							revVvd = revVVDLaneVO.getRevVvd();
							rlaneCd = revVVDLaneVO.getRlaneCd();
							znIocCd = znIocCd.equals("")?"OO":znIocCd;
						}
					}
					
					invCreVo.getInvArMnVO().setRlaneCd(rlaneCd);
					invCreVo.getInvArMnVO().setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
					invCreVo.getInvArMnVO().setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
					invCreVo.getInvArMnVO().setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
					invCreVo.getInvArMnVO().setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
				
				}else{
					invCreVo.getInvArMnVO().setRevVslCd(invArMnVO.getRevVslCd());
					invCreVo.getInvArMnVO().setRevSkdVoyNo(invArMnVO.getRevSkdVoyNo());
					invCreVo.getInvArMnVO().setRevSkdDirCd(invArMnVO.getRevSkdDirCd());
					invCreVo.getInvArMnVO().setRevDirCd(invArMnVO.getRevDirCd());
				}
				
				invCreVo.getInvArMnVO().setZnIocCd(znIocCd);				
				
				ARCreditInputVO arCrdtVo = new ARCreditInputVO();
				arCrdtVo.setActCustCntCd(invCreVo.getInvArMnVO().getActCustCntCd());
				arCrdtVo.setActCustSeq(invCreVo.getInvArMnVO().getActCustSeq());
				arCrdtVo.setSailArrDt(invCreVo.getInvArMnVO().getSailArrDt());
				arCrdtVo.setIoBndCd(invCreVo.getInvArMnVO().getIoBndCd());
				arCrdtVo.setDestTrnsSvcModCd(invCreVo.getInvArMnVO().getDestTrnsSvcModCd());
				arCrdtVo.setArOfcCd(invCreVo.getInvArMnVO().getArOfcCd());
				arCrdtVo.setDelCd(invCreVo.getInvArMnVO().getDelCd());
				
				String locCd ="";
				String arAgnStlCd ="";
				ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invCreVo.getInvArMnVO().getArOfcCd());
				
				if(arOfcAttributeVO!=null){
					locCd = arOfcAttributeVO.getLocCd();
					arCrdtVo.setLocCd(locCd.substring(0,2));
				}
							
				ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
				
				if(aRCreditVO != null){
					invCreVo.getInvArMnVO().setDueDt(aRCreditVO.getDueDt());
					invCreVo.getInvArMnVO().setCrTermDys(aRCreditVO.getCrTerm());
					invCreVo.getInvArMnVO().setCustCrFlg(aRCreditVO.getCrFlg());
				}		
				
				String revTpCd = invCreVo.getInvArMnVO().getRevTpCd();
				String revSrcCd = invCreVo.getInvArMnVO().getRevSrcCd();
				String revTpSrcCd = invCreVo.getInvArMnVO().getRevTpCd()+invCreVo.getInvArMnVO().getRevSrcCd();
				String svrId = dbDao.searchServerID(invCreVo.getInvArMnVO().getArOfcCd());
				String acct_div_cd = dbDao.searchAccountDivision(revTpSrcCd);
				
				String invCoaInterCoCd =  dbDao.searchInterCompany(invCreVo.getInvArMnVO().getActCustCntCd(),invCreVo.getInvArMnVO().getActCustSeq());	
				
				if(arOfcAttributeVO!=null){
					arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
				}
				
				CoaVO coaVO = dbDao.searchCOA(invCreVo.getInvArMnVO().getArOfcCd());
				
				String invCoaCoCd = "";
				String invCoaCtrCd = "";
				String invCoaRgnCd = "";
				
				if(coaVO!=null){
					invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
					invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
					invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
				}	
				
				String revCoaAcctCd ="";
				String revCoaVslCd = "";
				String revCoaVoyNo = "";
				String revCoaSkdDirCd = "";
				String revCoaDirCd = "";
				String acctCd = "";
				
				vvdCustomerVo.setInvCntryCd(invCreVo.getInvArMnVO().getInvCustCntCd());
				vvdCustomerVo.setInvCustCd(invCreVo.getInvArMnVO().getInvCustSeq());
				vvdCustomerVo.setVsl(invCreVo.getInvArMnVO().getVslCd());
				vvdCustomerVo.setVoy(invCreVo.getInvArMnVO().getSkdVoyNo());
				vvdCustomerVo.setDep(invCreVo.getInvArMnVO().getSkdDirCd());
				vvdCustomerVo.setLclCurr(invCreVo.getInvArMnVO().getLoclCurrCd());
				vvdCustomerVo.setSvcScp(invCreVo.getInvArMnVO().getInvSvcScpCd());
				vvdCustomerVo.setBnd(invCreVo.getInvArMnVO().getIoBndCd());
				vvdCustomerVo.setOfcCd(invCreVo.getInvArMnVO().getArOfcCd());
				vvdCustomerVo.setBkgNo(invCreVo.getInvArMnVO().getBkgNo());
				vvdCustomerVo.setSaDt(invCreVo.getInvArMnVO().getSailArrDt());
				vvdCustomerVo.setPol(invCreVo.getInvArMnVO().getPolCd());
				vvdCustomerVo.setPod(invCreVo.getInvArMnVO().getPodCd());

				for (int i = 0; i < invCreVo.getInvArChgVOs().size(); i++) {
					invCreVo.getInvArChgVOs().get(i).setUpdUsrId(userId);
					vvdCustomerVo.setCurr(invCreVo.getInvArChgVOs().get(i).getCurrCd());

					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);					
					
					invCreVo.getInvArChgVOs().get(i).setInvXchRt(exchangeRateVo.getExRate());
					invCreVo.getInvArChgVOs().get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
					
					//2010-01-04
					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invCreVo.getInvArChgVOs().get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invCreVo.getInvArChgVOs().get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArChgVOs().get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArChgVOs().get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					//2010-04-20 업데이트 대상 IFNO 에 RevVVD 가 없을경우
					if(invArMnVO.getRevVslCd().equals("")||invArMnVO.getRevSkdVoyNo().equals("")||invArMnVO.getRevSkdDirCd().equals("")||invArMnVO.getRevDirCd().equals("")){
						revCoaVslCd = invCreVo.getInvArMnVO().getRevVslCd().equals("")?"":invCreVo.getInvArMnVO().getRevVslCd();
						revCoaVoyNo = invCreVo.getInvArMnVO().getRevSkdVoyNo().equals("")?"":invCreVo.getInvArMnVO().getRevSkdVoyNo();
						revCoaSkdDirCd = invCreVo.getInvArMnVO().getRevSkdDirCd().equals("")?"":invCreVo.getInvArMnVO().getRevSkdDirCd();
						revCoaDirCd = invCreVo.getInvArMnVO().getRevDirCd().equals("")?"":invCreVo.getInvArMnVO().getRevDirCd();
						
						invCreVo.getInvArChgVOs().get(i).setRevCoaVslCd(revCoaVslCd);
						invCreVo.getInvArChgVOs().get(i).setRevCoaVoyNo(revCoaVoyNo);
						invCreVo.getInvArChgVOs().get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
						invCreVo.getInvArChgVOs().get(i).setRevCoaDirCd(revCoaDirCd);		
					}else{
						invCreVo.getInvArChgVOs().get(i).setRevCoaVslCd(invArMnVO.getRevVslCd());
						invCreVo.getInvArChgVOs().get(i).setRevCoaVoyNo(invArMnVO.getRevSkdVoyNo());
						invCreVo.getInvArChgVOs().get(i).setRevCoaSkdDirCd(invArMnVO.getRevSkdDirCd());
						invCreVo.getInvArChgVOs().get(i).setRevCoaDirCd(invArMnVO.getRevDirCd());
					}
					
					invCreVo.getInvArChgVOs().get(i).setAcctCd(acctCd);	
					invCreVo.getInvArChgVOs().get(i).setRevCoaInterCoCd(invCoaInterCoCd);
					invCreVo.getInvArChgVOs().get(i).setRevCoaCoCd(invCoaCoCd);
					invCreVo.getInvArChgVOs().get(i).setRevCoaCtrCd(invCoaCtrCd);
					invCreVo.getInvArChgVOs().get(i).setRevCoaRgnCd(invCoaRgnCd);
					invCreVo.getInvArChgVOs().get(i).setRevCoaAcctCd(revCoaAcctCd);

					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START					
					if("M".equals(revTpCd)||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
						String loclChgAcctCd = "";
						loclChgAcctCd = dbDao.searchLocalChgFlg(invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArChgVOs().get(i).getChgCd());
	
						if (!loclChgAcctCd.equals("")) {
	
							invCreVo.getInvArChgVOs().get(i).setRevCoaAcctCd(loclChgAcctCd); 					    
						    if (loclChgAcctCd.equals("954117")) {					        
						       dbDao.modifyArOffstNo(invCreVo.getInvArMnVO().getArIfNo(), invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
						    }
						}
					}
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청  END
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END

				}

				vvdCustomerVo.setCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				invCreVo.getInvArMnVO().setUsdXchRt(exchangeRateVo.getExRate());
				invCreVo.getInvArMnVO().setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				invCreVo.getInvArMnVO().setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				invCreVo.getInvArMnVO().setXchRtDt(exchangeRateVo.getExRateDate());
				invCreVo.getInvArMnVO().setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
				
				dbDao.modifyARInvoiceCharge(invCreVo.getInvArChgVOs(), userId);			
				
				List<InvArAmtVO> invArAmtVOs = dbDao.searchARInvoiceAmount(invCreVo.getInvArMnVO().getArIfNo());
				
				String erpIfOfcCd = "";
				
				if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invCreVo.getInvArMnVO().getCustCrFlg().equals("Y")){
					
					//2010-05-13 이상희 과장 CA 도 추가
					if(invCreVo.getInvArMnVO().getActCustCntCd().equals("US")||invCreVo.getInvArMnVO().getActCustCntCd().equals("CA")){				
						erpIfOfcCd = dbDao.searchCrCltOffice(invCreVo.getInvArMnVO().getActCustCntCd(), invCreVo.getInvArMnVO().getActCustSeq());
					}
					
				}else if(svrId.equals("KOR")&&invCreVo.getInvArMnVO().getActCustCntCd().equals("KR")){
					if(invCreVo.getInvArMnVO().getCustCrFlg().equals("Y")){
						erpIfOfcCd = dbDao.searchCrCltOffice(invCreVo.getInvArMnVO().getActCustCntCd(), invCreVo.getInvArMnVO().getActCustSeq());
					//비신용으로 변경 2009-12-16 김현화 수석
					}else if(invCreVo.getInvArMnVO().getIoBndCd().equals("I")&&invCreVo.getInvArMnVO().getCustCrFlg().equals("N")){
						erpIfOfcCd = dbDao.searchKrIbOffice(invCreVo.getInvArMnVO().getActCustCntCd(), invCreVo.getInvArMnVO().getActCustSeq());
					}
				}
				
				String invCoaAcctCd = "";
				
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invCreVo.getInvArMnVO().getRevTpCd(), invCreVo.getInvArMnVO().getRevSrcCd(), invCreVo.getInvArMnVO().getAcctCd());
					
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					
					invArAmtVOs.get(i).setErpIfGlDt(invCreVo.getInvArMnVO().getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invCreVo.getInvArMnVO().getArOfcCd());	
					invArAmtVOs.get(i).setUpdUsrId(userId);
				}
				
				dbDao.modifyARInvoiceAmount(invArAmtVOs);
				
				dbDao.modifyARInvoiceMain(invCreVo.getInvArMnVO(), userId);		
				
				dbDao.modifyInvTotalLocalAmount(invCreVo.getInvArMnVO().getArIfNo());
				
				
				//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
				//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
				String revVslCd2 		 =	invCreVo.getInvArMnVO().getRevVslCd();
				String revSkdDirCd2      =	invCreVo.getInvArMnVO().getRevSkdDirCd();
				String revSkdVoyNo2      =	invCreVo.getInvArMnVO().getRevSkdVoyNo();
				String sailArrDt2        =	invCreVo.getInvArMnVO().getSailArrDt();
				String sailDt2           =	invCreVo.getInvArMnVO().getSailDt();
				String dueDt2            =	invCreVo.getInvArMnVO().getDueDt();
				String xchRtN3rdTpCd2    =	invCreVo.getInvArMnVO().getXchRtN3rdTpCd();
				String xchRtUsdTpCd2     =	invCreVo.getInvArMnVO().getXchRtUsdTpCd();
				String glEffDt2          =	invCreVo.getInvArMnVO().getGlEffDt();
				String actCustSeq2       =	invCreVo.getInvArMnVO().getActCustSeq();
				
				if(revVslCd2 == null) revVslCd2 = "";
				if(revSkdDirCd2 == null) revSkdDirCd2 = "";
				if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
				if(sailArrDt2 == null) sailArrDt2 = "";
				if(sailDt2 == null) sailDt2 = "";
				if(dueDt2 == null) dueDt2 = "";
				if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
				if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
				if(glEffDt2 == null) glEffDt2 = "";
				if(actCustSeq2 == null) actCustSeq2 = "";
				
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invCreVo.getInvArMnVO().getArIfNo(), "", invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArMnVO().getBlSrcNo());		
				}else{
					dbDao.modifyCFMDate(invCreVo.getInvArMnVO().getArIfNo(), "good", invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArMnVO().getBlSrcNo());		
					newIfNo = invCreVo.getInvArMnVO().getArIfNo();
				}					
				
			}else{
				dbDao.modifyARInvoiceMain(invCreVo.getInvArMnVO(), userId);
				
				dbDao.modifyARInvoiceCharge(invCreVo.getInvArChgVOs(), userId);			
			}		
			
			dbDao.removeARInvoiceContainer(invCreVo.getInvArMnVO().getArIfNo());
			dbDao.addInvContainer(invCreVo.getInvArCntrVOs(), userId);
			
			//item Correction 시 UserId Update 2010-04-11
			dbDao.modifyMainUpdUserId(userId, invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArMnVO().getBlSrcNo());
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 *  No Good 매출채권 또는 Good 매출채권이면서 Actual 및 Invoice Customer 이외 항목 변경한 경우 Cancel 항목 생성 <br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		String newArIfNo = "";
		INVCommonUtil utilCmd = new INVCommonUtil();
		
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			invArChgVOs = dbDao.searchARInvoiceCharge(cancelInvoiceVO.getIfNo());
			invArAmtVOs = dbDao.searchARInvoiceAmount(cancelInvoiceVO.getIfNo());
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());
			
			InvArMnVO invArMnVO = new InvArMnVO();			
			invArMnVO = invArMnVOs.get(0);
			
			/*
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}
			*/
			
			//2010-04-23 deadlock 에러 때문에 프로시져로 변경
			
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			
			//2010-02-18 FXTSC IFNO는 LON prefix사용
//			String newArIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
			
			if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
				newArIfNo = "LON"+ maxSeq ;
			}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
				newArIfNo = "WRP"+ maxSeq ;
			}else{
				newArIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			BigDecimal invTtlLoclAmt = new BigDecimal(invArMnVO.getInvTtlLoclAmt()).multiply(new BigDecimal(-1));
			
			//invArMnVO.setInvTtlLoclAmt(Float.toString(Float.parseFloat(invArMnVO.getInvTtlLoclAmt()) * -1));
			
			invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			
			invArMnVO.setArIfNo(newArIfNo);
			invArMnVO.setOldArIfNo("");
			
			String revTpCd = "";
			String revSrcCd = "";
			String invCustFlg = cancelInvoiceVO.getInvCustFlg()!=null&&!cancelInvoiceVO.getInvCustFlg().equals("")?cancelInvoiceVO.getInvCustFlg():"N";
			
			log.debug("invCustFlg =" + invCustFlg);
			
			if(invCustFlg.equals("Y")){
				vvdCustomerVo.setInvCntryCd(cancelInvoiceVO.getInvCustCntCd());
				vvdCustomerVo.setInvCustCd(cancelInvoiceVO.getInvCustSeq());
				vvdCustomerVo.setVsl(invArMnVO.getVslCd());
				vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
				vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
				vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
				vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
				vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
				vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
				vvdCustomerVo.setPol(invArMnVO.getPolCd());
				vvdCustomerVo.setPod(invArMnVO.getPodCd());
				vvdCustomerVo.setCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				if(exchangeRateVo.getUsdExrateType().equals("I")||exchangeRateVo.getThirdExrateType().equals("I")){
					invCustFlg = "Y";
				}else if(invArMnVO.getXchRtUsdTpCd().equals("I")||invArMnVO.getXchRtN3rdTpCd().equals("I")){
					if(invArMnVO.getRevSrcCd().equals("CC")){
						invCustFlg = "Y";
					}
				}else{
					invCustFlg = "N";
				}
			}
			
			log.debug("invCustFlg2 =" + invCustFlg);
			
			ARCorrectionCkReturnVO arCkRtVo = dbDao.searchRevTypeSrc(invArMnVO.getBkgNo(), invCustFlg);
			
			revTpCd = arCkRtVo.getRevTpCd();
			revSrcCd = arCkRtVo.getRevSrcCd();
			
			if (revTpCd.equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					revTpCd = "B";
					revSrcCd = "CS";
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					revTpCd = "C";
					revSrcCd = "CA";
				}
			}
			
			log.debug("revTpCd =" + revTpCd);
			log.debug("revSrcCd =" + revSrcCd);
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String glEffDt = utilCmd.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt());
			
			invArMnVO.setGlEffDt(glEffDt);
			
			//invArMnVO.setGlEffDt(cancelInvoiceVO.getEffDt());
			invArMnVO.setBlInvCfmDt("");
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setInvSplitCd("X");
			invArMnVO.setInvDeltDivCd("X");
			//Main Table SYS CLEAR 20091229
			//if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
			//	invArMnVO.setInvIssFlg("Y");
			//	invArMnVO.setInvClrFlg("Y");
			//} else {
				invArMnVO.setInvIssFlg("N");
				invArMnVO.setInvClrFlg("N");
			//}
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2010-12-06 Cancel시 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산
			// INV_AR_MN 에서 ifNo 로 구해온 act_cust_cnt_cd 와 act_cust_seq 로 inv_coa_inter_co_cd 를 가져와 setting
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String invRevTpSrcCd = "";
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				//invArChgVOs.get(i).setChgAmt(Float.toString(Float.parseFloat(invArChgVOs.get(i).getChgAmt()) * -1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());				
				
				invArChgVOs.get(i).setArIfNo(newArIfNo);
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
				//if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
				//	invArChgVOs.get(i).setInvIssFlg("Y");
				//	invArChgVOs.get(i).setInvClrFlg("Y");
				//} else {
					invArChgVOs.get(i).setInvIssFlg("N");
					invArChgVOs.get(i).setInvClrFlg("N");
				//}
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
			}

			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				BigDecimal invAmt= new BigDecimal(invArAmtVOs.get(i).getInvAmt()).multiply(new BigDecimal(-1));
				
				//invArAmtVOs.get(i).setInvAmt(Float.toString(Float.parseFloat(invArAmtVOs.get(i).getInvAmt()) * -1));
				
				invArAmtVOs.get(i).setInvAmt(invAmt.toString());				
				
				invArAmtVOs.get(i).setArIfNo(newArIfNo);
				invArAmtVOs.get(i).setErpIfGlDt(glEffDt);
				invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
			}

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newArIfNo);
					invArCntrVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				}
			}

			dbDao.addInvMain(invArMnVO);
			dbDao.addInvAmount(invArAmtVOs);
			dbDao.addInvCharge(invArChgVOs);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}
			
			if (cancelInvoiceVO.getUiType()!=null && cancelInvoiceVO.getUiType().equals("E")) {
				log.info("########## UiType : " + cancelInvoiceVO.getUiType());
			}else{
				dbDao.modifySplitCode(cancelInvoiceVO.getIfNo(), "M", cancelInvoiceVO.getUserId());
			}
			
			if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
				//dbDao.modifySysClear(cancelInvoiceVO.getIfNo(), cancelInvoiceVO.getUserId());
				dbDao.modifySysClearFlag(cancelInvoiceVO.getIfNo(),invArMnVO.getArIfNo(), cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(glEffDt);
			
			
			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					newIfNo = invArMnVO.getArIfNo();
				}
				
			} else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		return newIfNo;
	}

	/**
	 * Good 매출채권이면서 Actual 및 Invoice Customer 를 변경한 경우 새로운 IF 생성<br>
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createNewCustomerARInvoice(InvNewCustVO invNewCustVO, String userId) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		String newArIfNo = "";
		INVCommonUtil utilCmd = new INVCommonUtil();

		try {
			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

			invArMnVOs = dbDao.searchARInvoice(invNewCustVO.getArIfNo());
			invArChgVOs = dbDao.searchARInvoiceCharge(invNewCustVO.getArIfNo());
			invArAmtVOs = dbDao.searchARInvoiceAmount(invNewCustVO.getArIfNo());
			invArCntrVOs = dbDao.searchARInvoiceContainer(invNewCustVO.getArIfNo());
			
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			/*
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());

			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), userId);
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, userId);
			}
			*/
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), userId);	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
//			String newArIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
 			
			if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
				newArIfNo = "LON"+ maxSeq ;
			}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
				newArIfNo = "WRP"+ maxSeq ;
			}else{
				newArIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			// No Good 항목 inv_delt_div_cd 'Y' 처리
			
			if(invNewCustVO.getBlInvCfmDt()!=null && invNewCustVO.getBlInvCfmDt().equals("")){
				dbDao.modifyDelCode(invNewCustVO.getArIfNo(), userId);
				invArMnVO.setInvSplitCd("");
				if(!invArMnVO.getOldArIfNo().equals("")){
					invArMnVO.setOldArIfNo(newArIfNo);
				}else{
					invArMnVO.setOldArIfNo("");
				}
			} else {
				invArMnVO.setInvSplitCd(invNewCustVO.getSplitFlag());
				invArMnVO.setOldArIfNo("");
			}
			
			//Customer Correction By Date
			if (invNewCustVO.getUiType().equals("C")) {
				invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
				invArMnVO.setInvCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setInvCustSeq(invNewCustVO.getActCustSeq());
				invArMnVO.setInvRmk(invNewCustVO.getInvRmk());
				//invArMnVO.setDueDt(invNewCustVO.getDueDt());
				//invArMnVO.setCustCrFlg(invNewCustVO.getCustCrFlg());
				//invArMnVO.setCrTermDys(invNewCustVO.getCrTermDys());
			
			// Item Correction MaxIf
			} else if (invNewCustVO.getUiType().equals("I")) {
				invArMnVO.setActCustCntCd(invNewCustVO.getInvArMnVO().getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getInvArMnVO().getActCustSeq());
				invArMnVO.setInvCustCntCd(invNewCustVO.getInvArMnVO().getInvCustCntCd());
				invArMnVO.setInvCustSeq(invNewCustVO.getInvArMnVO().getInvCustSeq());
				invArMnVO.setInvRmk(invNewCustVO.getInvArMnVO().getInvRmk());
				//invArMnVO.setDueDt(invNewCustVO.getInvArMnVO().getDueDt());
				//invArMnVO.setCustCrFlg(invNewCustVO.getInvArMnVO().getCustCrFlg());
				//invArMnVO.setCrTermDys(invNewCustVO.getInvArMnVO().getCrTermDys());
				invArMnVO.setInvRefNo(invNewCustVO.getInvArMnVO().getInvRefNo());
				invArMnVO.setMstBlNo(invNewCustVO.getInvArMnVO().getMstBlNo());
				invArMnVO.setRfaNo(invNewCustVO.getInvArMnVO().getRfaNo());
				invArMnVO.setScNo(invNewCustVO.getInvArMnVO().getScNo());
				invArMnVO.setSrepCd(invNewCustVO.getInvArMnVO().getSrepCd());
				invArMnVO.setCgoWgt(invNewCustVO.getInvArMnVO().getCgoWgt());
				invArMnVO.setCgoMeasQty(invNewCustVO.getInvArMnVO().getCgoMeasQty());
				invArMnVO.setBkgTeuQty(invNewCustVO.getInvArMnVO().getBkgTeuQty());
				invArMnVO.setBkgFeuQty(invNewCustVO.getInvArMnVO().getBkgFeuQty());
				invArMnVO.setFrtFwrdCntCd(invNewCustVO.getInvArMnVO().getFrtFwrdCntCd());
				invArMnVO.setFrtFwrdCustSeq(invNewCustVO.getInvArMnVO().getFrtFwrdCustSeq());
				invArMnVO.setVslCd(invNewCustVO.getInvArMnVO().getVslCd());
				invArMnVO.setSkdVoyNo(invNewCustVO.getInvArMnVO().getSkdVoyNo());
				invArMnVO.setSkdDirCd(invNewCustVO.getInvArMnVO().getSkdDirCd());
				invArMnVO.setPolCd(invNewCustVO.getInvArMnVO().getPolCd());
				invArMnVO.setPodCd(invNewCustVO.getInvArMnVO().getPodCd());
				invArMnVO.setTrnkVslCd(invNewCustVO.getInvArMnVO().getTrnkVslCd());
				invArMnVO.setTrnkSkdVoyNo(invNewCustVO.getInvArMnVO().getTrnkSkdVoyNo());
				invArMnVO.setTrnkSkdDirCd(invNewCustVO.getInvArMnVO().getTrnkSkdDirCd());
				//invArMnVO.setSailArrDt(invNewCustVO.getInvArMnVO().getSailArrDt());
				//invArMnVO.setUsdXchRt(invNewCustVO.getInvArMnVO().getUsdXchRt());
				//invArMnVO.setXchRtUsdTpCd(invNewCustVO.getInvArMnVO().getXchRtUsdTpCd());
				//invArMnVO.setXchRtN3rdTpCd(invNewCustVO.getInvArMnVO().getXchRtN3rdTpCd());
				//invArMnVO.setXchRtDt(invNewCustVO.getInvArMnVO().getXchRtDt());
				//invArMnVO.setObrdDt(invNewCustVO.getInvArMnVO().getObrdCd().equals("B") ? invNewCustVO.getInvArMnVO().getXchRtDt() : "");
				//invArMnVO.setInvTtlLoclAmt(invNewCustVO.getInvArMnVO().getInvTtlLoclAmt());
			
			// Item Correction Max 외 IfNo
			} else if (invNewCustVO.getUiType().equals("F")) {
				invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
				invArMnVO.setInvCustCntCd(invNewCustVO.getInvCustCntCd());
				invArMnVO.setInvCustSeq(invNewCustVO.getInvCustSeq());
				invArMnVO.setVslCd(invNewCustVO.getVslCd());
				invArMnVO.setSkdVoyNo(invNewCustVO.getSkdVoyNo());
				invArMnVO.setSkdDirCd(invNewCustVO.getSkdDirCd());
				invArMnVO.setPolCd(invNewCustVO.getPolCd());
				invArMnVO.setPodCd(invNewCustVO.getPodCd());
				//invArMnVO.setDueDt(invNewCustVO.getDueDt());
				//invArMnVO.setCustCrFlg(invNewCustVO.getCustCrFlg());
				//invArMnVO.setCrTermDys(invNewCustVO.getCrTermDys());
				//invArMnVO.setZnIocCd(invNewCustVO.getZnIocCd());	
				//invArMnVO.setSailArrDt(invNewCustVO.getSailArrDt());
			} //else if (invNewCustVO.getUiType().equals("E")){
				//invArMnVO.setDueDt(invNewCustVO.getDueDt());
				//invArMnVO.setCustCrFlg(invNewCustVO.getCustCrFlg());
				//invArMnVO.setCrTermDys(invNewCustVO.getCrTermDys());
			//}
			else {
				invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
				//invArMnVO.setDueDt(invNewCustVO.getDueDt());
				//invArMnVO.setCustCrFlg(invNewCustVO.getCustCrFlg());
				//invArMnVO.setCrTermDys(invNewCustVO.getCrTermDys());
			} 
			
			//2010-04-14 Cust 체크로직 보완
			int actCustCnt = dbDao.checkCustomer(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
			
			int invCustCnt =dbDao.checkCustomer(invArMnVO.getInvCustCntCd(), invArMnVO.getInvCustSeq());
			
			if (actCustCnt==0||invCustCnt==0){					
				throw new EventException(new ErrorHandler("INV00008", new String[] {}).getMessage());
			}	
			
			String port = invArMnVO.getIoBndCd().equals("O")?invArMnVO.getPolCd():invArMnVO.getPodCd();
			String vvd = invArMnVO.getVslCd()+ invArMnVO.getSkdVoyNo()+invArMnVO.getSkdDirCd();
			
			String sailArrDt = utilCmd.searchSADate(vvd , port, invArMnVO.getIoBndCd());
			
			invArMnVO.setSailArrDt(sailArrDt);
			
			String znIocCd = dbDao.searchZoneIOC(invArMnVO.getPolCd(), invArMnVO.getPodCd());		
			
			//2010-04-20 REV VVD 구하는 로직 제거
			//RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(invArMnVO.getBkgNo());
			
			/*
			String revVvd = "";
			String rlaneCd = "";
			
			if(revVVDLaneVO != null){
				revVvd = revVVDLaneVO.getRevVvd();
				rlaneCd = revVVDLaneVO.getRlaneCd();				
			}
			
			if(revVvd.equals("X")){
				revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
				if(revVVDLaneVO != null){
					revVvd = revVVDLaneVO.getRevVvd();
					rlaneCd = revVVDLaneVO.getRlaneCd();
					znIocCd = znIocCd.equals("")?"OO":znIocCd;
				}
			}
			
			invArMnVO.setRlaneCd(rlaneCd);
			invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
			invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
			invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
			invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
			*/
			invArMnVO.setZnIocCd(znIocCd);
			
			//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());	
			
			String locCd ="";
			String arAgnStlCd ="";
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				locCd = arOfcAttributeVO.getLocCd();
				arCrdtVo.setLocCd(locCd.substring(0,2));
			}
						
			ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
			
			if(aRCreditVO != null){
				invArMnVO.setDueDt(aRCreditVO.getDueDt());
				invArMnVO.setCrTermDys(aRCreditVO.getCrTerm());
				invArMnVO.setCustCrFlg(aRCreditVO.getCrFlg());
			}

			invArMnVO.setArIfNo(newArIfNo);
			invArMnVO.setInvDeltDivCd("N");	
			
			String glEffDt = utilCmd.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt());
			
			invArMnVO.setGlEffDt(glEffDt);
			
			invArMnVO.setGlEffDt(invNewCustVO.getGlEffDt());
			invArMnVO.setBlInvCfmDt("");			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");	
			
			
			//2010-01-07 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START - LO CHG 관련 항목 초기화
			invArMnVO.setApArOffstNo("");
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			//2010.03.15 김현화수석
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			invArMnVO.setInvSvcScpCd(svrId.equals("EUR")||svrId.equals("KOR")||(svrId.equals("JPN")&&invArMnVO.getIoBndCd().equals("O"))?"OTH":invArMnVO.getInvSvcScpCd());

			//float invTtlLoclAmt = 0;
			//BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			
			String revTpCd = "";
			String revSrcCd = "";
			String invCustFlg = invNewCustVO.getInvCustFlg()!=null&&!invNewCustVO.getInvCustFlg().equals("")?invNewCustVO.getInvCustFlg():"N";
			
			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			
			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			log.debug("invCustFlg =" + invCustFlg);
			
			if(invCustFlg.equals("Y")){
				if(exchangeRateVo.getUsdExrateType().equals("I")||exchangeRateVo.getThirdExrateType().equals("I")){
					invCustFlg = "Y";
				}else if(invArMnVO.getXchRtUsdTpCd().equals("I")||invArMnVO.getXchRtN3rdTpCd().equals("I")){
					if(invArMnVO.getRevSrcCd().equals("CC")){
						invCustFlg = "Y";
					}
				}else{
					invCustFlg = "N";
				}				
			}				
			
			log.debug("invCustFlg2 =" + invCustFlg);
			
			ARCorrectionCkReturnVO arCkRtVo = dbDao.searchRevTypeSrc(invArMnVO.getBkgNo(), invCustFlg);
			
			revTpCd = arCkRtVo.getRevTpCd();
			revSrcCd = arCkRtVo.getRevSrcCd();
			
			if (revTpCd.equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					revTpCd = "B";
					revSrcCd = "CS";
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					revTpCd = "C";
					revSrcCd = "CA";
				}
			}
			
			log.debug("revTpCd =" + revTpCd);
			log.debug("revSrcCd =" + revSrcCd);
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String acct_div_cd = dbDao.searchAccountDivision(revTpSrcCd);
			
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			//ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			if(arOfcAttributeVO!=null){
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			}
			
			/*
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String arOfcCd = erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd();
			
			log.debug("arOfcCd====="+arOfcCd);
			log.debug("arOfcCd====="+arOfcCd);
			
			String maxSeq = dbDao.searchNewInterfaceNo(arOfcCd);

			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(arOfcCd, userId);
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(arOfcCd, maxSeq, userId);
			}
			
			String newArIfNo = arOfcCd.substring(0, 3).equals("FXT")?"LON"+ maxSeq:arOfcCd.substring(0, 3) + maxSeq;
			
			if(invNewCustVO.getBlInvCfmDt()!=null && invNewCustVO.getBlInvCfmDt().equals("")){
				dbDao.modifyDelCode(invNewCustVO.getArIfNo(), userId);
				invArMnVO.setInvSplitCd("");
				if(!invArMnVO.getOldArIfNo().equals("")){
					invArMnVO.setOldArIfNo(newArIfNo);
				}else{
					invArMnVO.setOldArIfNo("");
				}
			} else {
				invArMnVO.setInvSplitCd(invNewCustVO.getSplitFlag());
				invArMnVO.setOldArIfNo("");
			}
			
			invArMnVO.setArOfcCd(arOfcCd);		
			invArMnVO.setArIfNo(newArIfNo);		
			
			String glEffDt = utilCmd.searchEffectiveDate(arOfcCd, invArMnVO.getSailDt());			
			
			invArMnVO.setGlEffDt(glEffDt);
			*/
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}			
			
			
			String revCoaAcctCd ="";
			String acctCd = "";
			String invRevTpSrcCd = "";
			
			if (invNewCustVO.getUiType().equals("C")||invNewCustVO.getUiType().equals("F")||invNewCustVO.getUiType().equals("I")) {				
				
				invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
				invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
				invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
				
				for (int i = 0; i < invArChgVOs.size(); i++) {
					
					invArChgVOs.get(i).setArIfNo(newArIfNo);
					invArChgVOs.get(i).setCreUsrId(userId);
					invArChgVOs.get(i).setUpdUsrId(userId);
					invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
					
					invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
					
					invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
					
					vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());

					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
					
					//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
					
					//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
					//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());	
					//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
					
					invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
					invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
					invArChgVOs.get(i).setInvIssFlg("N");
					invArChgVOs.get(i).setInvClrFlg("N");
					
					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					//revCoaVslCd = invArMnVO.getRevVslCd().equals("")?"":invArMnVO.getRevVslCd();
					//revCoaVoyNo = invArMnVO.getRevSkdVoyNo().equals("")?"":invArMnVO.getRevSkdVoyNo();
					//revCoaSkdDirCd = invArMnVO.getRevSkdDirCd().equals("")?"":invArMnVO.getRevSkdDirCd();
					//revCoaDirCd = invArMnVO.getRevDirCd().equals("")?"":invArMnVO.getRevDirCd();
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
					invArChgVOs.get(i).setRevCoaCoCd(invCoaCoCd);
					invArChgVOs.get(i).setRevCoaCtrCd(invCoaCtrCd);
					invArChgVOs.get(i).setRevCoaRgnCd(invCoaRgnCd);
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
					//invArChgVOs.get(i).setRevCoaVslCd(revCoaVslCd);
					//invArChgVOs.get(i).setRevCoaVoyNo(revCoaVoyNo);
					//invArChgVOs.get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
					//invArChgVOs.get(i).setRevCoaDirCd(revCoaDirCd);		
					
					
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START					
					if("M".equals(revTpCd)||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
						String loclChgAcctCd = "";
						loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());
						if (!loclChgAcctCd.equals("")) {
						    invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd);     
						    if (loclChgAcctCd.equals("954117")) {        
						        //dbDao.modifyArOffstNo(invArMnVO.getArIfNo(), invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
						        invArMnVO.setApArOffstNo(invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
						    }
						}
					}
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 END		
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
					
				}
				
				//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
				//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());

			}
			/* else if (invNewCustVO.getUiType().equals("I")) {
				for (int i = 0; i < invArChgVOs.size(); i++) {
					invArChgVOs.get(i).setArIfNo(invArMnVO.getArOfcCd().substring(0, 3) + maxSeq);
					invArChgVOs.get(i).setCreUsrId(userId);
					invArChgVOs.get(i).setUpdUsrId(userId);
					invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
					invArChgVOs.get(i).setInvIssFlg("N");
					invArChgVOs.get(i).setInvClrFlg("N");
					for (int j = 0; j < invNewCustVO.getInvArChgVOs().size(); j++) {
						if (invArChgVOs.get(i).getArIfSerNo().equals(invNewCustVO.getInvArChgVOs().get(j).getArIfSerNo())
								&& invArChgVOs.get(i).getChgSeq().equals(invNewCustVO.getInvArChgVOs().get(j).getChgSeq())) {
							invArChgVOs.get(i).setInvXchRt(invNewCustVO.getInvArChgVOs().get(j).getInvXchRt());
							invArChgVOs.get(i).setInvXchRtDt(invNewCustVO.getInvArChgVOs().get(j).getInvXchRtDt());
						}
					}
				}
			}*/
			else {
				for (int i = 0; i < invArChgVOs.size(); i++) {
					invArChgVOs.get(i).setArIfNo(newArIfNo);
					
					invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
					
					invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
					invArChgVOs.get(i).setCreUsrId(userId);
					invArChgVOs.get(i).setUpdUsrId(userId);
					invArChgVOs.get(i).setInvIssFlg("N");
					invArChgVOs.get(i).setInvClrFlg("N");
					invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				}
			}
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
			
			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
				
				invArAmtVOs.get(i).setArInvSrcCd("NISAR");
				invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
				invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
				invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
				invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
				invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
				invArAmtVOs.get(i).setInvCoaVslCd("0000");
				invArAmtVOs.get(i).setInvCoaVoyNo("0000");
				invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
				invArAmtVOs.get(i).setInvCoaRevDirCd("0");
				
				invArAmtVOs.get(i).setArIfNo(newArIfNo);
				invArAmtVOs.get(i).setErpIfGlDt(glEffDt);
				invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
				invArAmtVOs.get(i).setCreUsrId(userId);
				invArAmtVOs.get(i).setUpdUsrId(userId);
			}

			dbDao.addInvMain(invArMnVO);
			dbDao.addInvAmount(invArAmtVOs);
			dbDao.addInvCharge(invArChgVOs);
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			
			if (invNewCustVO.getUiType().equals("I")) {
				if (invNewCustVO.getInvArCntrVOs().size() > 0) {
					for (int i = 0; i < invNewCustVO.getInvArCntrVOs().size(); i++) {
						invNewCustVO.getInvArCntrVOs().get(i).setArIfNo(newArIfNo);
						invNewCustVO.getInvArCntrVOs().get(i).setCreUsrId(userId);
						invNewCustVO.getInvArCntrVOs().get(i).setUpdUsrId(userId);
					}
					dbDao.addInvContainer(invNewCustVO.getInvArCntrVOs(), userId);
				}
			} else {
				if (invArCntrVOs.size() > 0) {
					for (int i = 0; i < invArCntrVOs.size(); i++) {
						invArCntrVOs.get(i).setArIfNo(newArIfNo);
						invArCntrVOs.get(i).setCreUsrId(userId);
						invArCntrVOs.get(i).setUpdUsrId(userId);
					}

					dbDao.addInvContainer(invArCntrVOs, userId);
				}
			}

			cnt = dbDao.checkAccountRateExist(glEffDt);
			
			
			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					newIfNo = invArMnVO.getArIfNo();
				}
				
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}	
			
			//item Correction 시 UserId Update 2010-04-11
			dbDao.modifyMainUpdUserId(userId, invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * 비해운 운임수입으로 발생한 매출채권 정보를 신규 생성한다.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return OtherRevReturnVO
	 * @exception EventException
	 */
	public OtherRevReturnVO createOtherRevenueARInvoice(ARInvoiceCreationVO invCreVo) throws EventException {
		OtherRevReturnVO otherRevReturnVO = new OtherRevReturnVO();
		MRIRevenueVVDLaneVO mriRevenueVVDLane = new MRIRevenueVVDLaneVO();
		ARCreditVO arCrdtVo = new ARCreditVO();
		InvArMnVO invMain = new InvArMnVO();
		ARCreditInputVO arCrdtInVo = new ARCreditInputVO();
		CoaVO coaVO = new CoaVO();

		List<InvArAmtVO> invArAmtVOs = invCreVo.getInvArAmtVOs();
		List<InvArChgVO> invArChgVOs = invCreVo.getInvArChgVOs();

		String mriMaxSeq = "";  // ar_if_no
		String subsCoCd = "";
		//String dueDate = "";
		
		String dueDt = "";
		String crTermDys = "";
		String custCrFlg = "";
		
		String svrId = "";
		String ttlLssCfmFlg ="";

		try {
			// 오피스 코드가 "FXTSC"인 경우에는 기존의 "LONBB"으로 처리하도록 한다.
			if ("FXTSC".equals(invCreVo.getOfcCd())) {
				mriMaxSeq = dbDao.searchMRIInterfaceNo("LONBB");
				
				if (mriMaxSeq.equals("")) {
					dbDao.addMRIInterfaceNo("LONBB", invCreVo.getUserId());
					mriMaxSeq = "LON" + "M" + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
				} else {
					dbDao.modifyMRIInterfaceNo("LONBB", mriMaxSeq, invCreVo.getUserId());
				}
			}
			else if ("GDYSC".equals(invCreVo.getOfcCd())) {
				mriMaxSeq = dbDao.searchMRIInterfaceNo("WRPSC");
				
				if (mriMaxSeq.equals("")) {
					dbDao.addMRIInterfaceNo("WRPSC", invCreVo.getUserId());
					mriMaxSeq = "WRP" + "M" + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
				} else {
					dbDao.modifyMRIInterfaceNo("WRPSC", mriMaxSeq, invCreVo.getUserId());
				}
			}
			else {
				mriMaxSeq = dbDao.searchMRIInterfaceNo(invCreVo.getOfcCd());
	
				if (mriMaxSeq.equals("")) {
					dbDao.addMRIInterfaceNo(invCreVo.getOfcCd(), invCreVo.getUserId());
					mriMaxSeq = invCreVo.getOfcCd().substring(0, 3) + "M" + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
				} else {
					dbDao.modifyMRIInterfaceNo(invCreVo.getOfcCd(), mriMaxSeq, invCreVo.getUserId());
				}
			}
			
			invCreVo.setDueDt("X");
			invCreVo.setSailArrDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invCreVo.setIoBndCd("O");
			

			
//due date 로직 다른 기능과 일치 되도록 수정함. 2016.08.08			
//			arCrdtVo = dbDao.searchCreditCustomerForCredit(invCreVo);
//			if (arCrdtVo != null) {
//		        dueDt = arCrdtVo.getDueDt();
//		        crTermDys = arCrdtVo.getCrTerm();
//		        custCrFlg = arCrdtVo.getCrFlg();
//			}
//			log.info("============>>>>>>>>>dueDt"+dueDt);
//			log.info("============>>>>>>>>>crTermDys"+crTermDys);
//			if(dueDt == null) dueDt = "";
//			if(crTermDys == null) crTermDys = "0";
//			if (dueDt.equals("") || crTermDys.equals("0")) {
//	    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
//				arCrdtVo = dbDao.searchOfficeForCredit(invCreVo);
//				
//				if (arCrdtVo != null) {
//			        dueDt = arCrdtVo.getDueDt();
//			        crTermDys = arCrdtVo.getCrTerm();
//			        custCrFlg = arCrdtVo.getCrFlg();					
//				}
//	    	}
			arCrdtInVo.setActCustCntCd(invCreVo.getCustCntCd());
			arCrdtInVo.setActCustSeq(invCreVo.getCustSeq());
			arCrdtInVo.setArOfcCd(invCreVo.getOfcCd());
			arCrdtInVo.setSailArrDt(invCreVo.getSailArrDt());
			arCrdtInVo.setIoBndCd(invCreVo.getIoBndCd());
			arCrdtInVo.setLocCd(invCreVo.getLocCd());
			arCrdtInVo.setDelCd(invCreVo.getDelCd());
			arCrdtInVo.setBlSrcNo("");
			arCrdtInVo.setRevSrcCd("");
			
			arCrdtVo = searchARCredit(arCrdtInVo);
			    dueDt = arCrdtVo.getDueDt();
		        crTermDys = arCrdtVo.getCrTerm();
		        custCrFlg = arCrdtVo.getCrFlg();	
			
			String laneCd = "RBC";
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("LW1C")||invCreVo.getLclVvd().substring(0, 4).equals("LW2C")) {
				laneCd = invCreVo.getLclVvd().substring(0, 3);
			}else if(invCreVo.getLclVvd().substring(0, 4).equals("WL1C")||invCreVo.getLclVvd().substring(0, 4).equals("WL2C")) {
				laneCd = invCreVo.getLclVvd().substring(0, 3);
			}
			
			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO" , invCreVo.getPodCd());
			
//			dueDate = DateTime.addDays(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""), Integer
//					.parseInt(arCrdtVo.getCrTerm()));
			
			log.info("\n########## dueDt : "+dueDt);

			// 계열사 코드 조회
			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());

			// center, customer 테이블에서 select
			coaVO = dbDao.searchCOA(invCreVo.getOfcCd());
			
			svrId = invCreVo.getSvrId();

			invMain.setArIfNo(mriMaxSeq);
			invMain.setBlNo("");
			invMain.setBlTpCd("");
			invMain.setBlSrcNo(invCreVo.getBlSrcNo());
			invMain.setInvSrcNo("");
			invMain.setBkgNo("");
			invMain.setBkgCorrNo("");
			invMain.setBkgCorrDt("");
			invMain.setVvdTrnsFlg("");
			invMain.setActCustCntCd(invCreVo.getCustCntCd());
			invMain.setActCustSeq(invCreVo.getCustSeq());
			invMain.setArOfcCd(invCreVo.getOfcCd());
			invMain.setRevTpCd("M");
			invMain.setRevSrcCd("TH");
			invMain.setVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setLoclCurrCd(invCreVo.getLclCurr());
			invMain.setSvcScpCd("OTH");
			invMain.setInvSvcScpCd("OTH");
			invMain.setSailDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setSailArrDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			
			//2009-12-08 추가
			String slanCd = "";
			if (invCreVo.getLclVvd().substring(0, 4).equals("COMC")) {
				slanCd = "COM";
			}
			else if (invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				slanCd = "CNT";
			}
			else if (invCreVo.getLclVvd().substring(0, 4).equals("LW1C")||invCreVo.getLclVvd().substring(0, 4).equals("LW2C")) {
				slanCd = laneCd;
			}
			else {
				slanCd = "RBC";
			}
			invMain.setSlanCd(slanCd);
			invMain.setIoBndCd("O");
			invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setPorCd(invCreVo.getPolCd());
			invMain.setPolCd(invCreVo.getPolCd());
			invMain.setPodCd(invCreVo.getPolCd());
			invMain.setDelCd(invCreVo.getPolCd());
			invMain.setCustCrFlg(custCrFlg);
			invMain.setInvCustCntCd(invCreVo.getCustCntCd());
			invMain.setInvCustSeq(invCreVo.getCustSeq());
			invMain.setFrtFwrdCntCd(invCreVo.getCustCntCd());
			invMain.setFrtFwrdCustSeq(invCreVo.getCustSeq());
			invMain.setCgoWgt("0");
			invMain.setCgoMeasQty("0");
			invMain.setBkgTeuQty("0");
			invMain.setBkgFeuQty("0");
			invMain.setScNo("");
			invMain.setRfaNo("");
			invMain.setSrepCd("");
			invMain.setMstBlNo("");
			invMain.setCxlFlg("N");
			invMain.setDueDt(dueDt);
			invMain.setBlInvIfDt(String.valueOf(DateTime.getDateString()).replace(".", "").replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setBlInvCfmDt(String.valueOf(DateTime.getDateString()).replace(".", "").replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setGlEffDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setInvRmk(invCreVo.getInvRmk());
			invMain.setInvDeltDivCd("N");
			invMain.setBkgRefNo("");
			invMain.setInvRefNo("");
			invMain.setSiRefNo("");
			invMain.setHjsStfCtnt("");
			invMain.setInvSplitCd("");
			invMain.setInvVvdCxlCd("");
			invMain.setDestTrnsSvcModCd("");
			invMain.setAcctXchRtYrmon(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").substring(0, 6));
			invMain.setWhfDeclNo("");
			invMain.setWhfDeclCfmDt("");
			invMain.setWhfDeclVslCd("");
			invMain.setWhfDeclVoyNo("");
			invMain.setWhfDeclDirCd("");
			invMain.setWhfDeclOfcCd("");
			invMain.setWhfDeclApIfDt("");
			invMain.setWhfMrnNo("");
			invMain.setUsdXchRt(invCreVo.getUsdXchRt());
			invMain.setXchRtUsdTpCd("A");
			invMain.setXchRtN3rdTpCd("A");
			invMain.setXchRtDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setObrdDt("");
			invMain.setInvTtlLoclAmt(invCreVo.getTotalLocalAmt().replaceAll(",", ""));
			invMain.setTrspRqstOrdFlg("");
			invMain.setEdiSndDt("");
			invMain.setRevVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setRevSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setRevSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setRevDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setRlaneCd(mriRevenueVVDLane.getRevLane());
			invMain.setZnIocCd("OO");
			invMain.setCrTermDys(crTermDys);
			invMain.setArTaxIndCd(invCreVo.getArTaxIndCd());
			invMain.setArCtyCd(invCreVo.getPolCd());
			invMain.setSlsOfcCd(invCreVo.getOfcCd());
			invMain.setInvOrgOfcCd(invCreVo.getOfcCd());
			invMain.setSlpNo(invCreVo.getSlpNo());
			invMain.setApArOffstNo("");
			invMain.setClrStsFlg("N");
			invMain.setClrDt("");
			invMain.setAcctCd("111091");
			invMain.setArInvSrcCd("NISAR");
			String taxXchRt = "";
			if (invCreVo.getArTaxIndCd() != "") {
				taxXchRt = invCreVo.getUsdXchRt();
			} else {
				taxXchRt = "0";
			}
			invMain.setTaxXchRt(taxXchRt);
			invMain.setErpIfGlDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			invMain.setErpIfOfcCd(invCreVo.getOfcCd());
			invMain.setCreUsrId(invCreVo.getUserId());
			invMain.setUpdUsrId(invCreVo.getUserId());
			//Main Table Iss Flg 세팅 20091229
			invMain.setInvIssFlg("N");
			invMain.setInvClrFlg("N");

			dbDao.addInvMain(invMain);

			if (invArAmtVOs != null && invArChgVOs != null) {
				List<InvArAmtVO> addAmtVoList = new ArrayList<InvArAmtVO>();
				List<InvArChgVO> addChgVoList = new ArrayList<InvArChgVO>();

				String arIfSerNo = "";
				int chgSeq = 0;
				String chgCd = "";
				String currCd = "";
				String arAgnStlCd = "";
				//String erpIfOfcCd = "";
				ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invCreVo.getOfcCd());
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
				
				if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&custCrFlg.equals("Y")){
					//2010-06-08 CA 추가
					if(invCreVo.getCustCntCd().equals("US")||invCreVo.getCustCntCd().equals("CA")) {
						//erpIfOfcCd = dbDao.searchCrCltOffice(invCreVo.getCustCntCd(), invCreVo.getCustSeq());
						dbDao.searchCrCltOffice(invCreVo.getCustCntCd(), invCreVo.getCustSeq());
					}
				}
				else if(svrId.equals("KOR")&&custCrFlg.equals("Y")&&invCreVo.getCustCntCd().equals("KR")){
					//erpIfOfcCd = dbDao.searchCrCltOffice(invCreVo.getCustCntCd(), invCreVo.getCustSeq());
					dbDao.searchCrCltOffice(invCreVo.getCustCntCd(), invCreVo.getCustSeq());
				}

				// INV_AR_AMT
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					InvArAmtVO invAmts = invArAmtVOs.get(i);
					arIfSerNo = String.valueOf(i + 1);

					invAmts.setArIfNo(mriMaxSeq);
					invAmts.setArIfSerNo(arIfSerNo);
					invAmts.setTjSrcNm(invArAmtVOs.get(i).getTjSrcNm());
					invAmts.setCurrCd(invArAmtVOs.get(i).getCurrCd());
					invAmts.setInvAmt(invArAmtVOs.get(i).getInvAmt().replaceAll(",", ""));
					invAmts.setCreUsrId(invCreVo.getUserId());
					invAmts.setUpdUsrId(invCreVo.getUserId());
					invAmts.setArInvSrcCd("NISAR");
					invAmts.setInvCoaCoCd(coaVO.getInvCoaCoCd());
					invAmts.setInvCoaRgnCd(coaVO.getInvCoaRgnCd());
					invAmts.setInvCoaCtrCd(coaVO.getInvCoaCtrCd());
					invAmts.setInvCoaAcctCd("111091");
					invAmts.setInvCoaInterCoCd(subsCoCd);
					invAmts.setInvCoaVslCd("0000");
					invAmts.setInvCoaVoyNo("0000");
					invAmts.setInvCoaSkdDirCd("0");
					invAmts.setInvCoaRevDirCd("0");
					invAmts.setErpIfGlDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
					
					//-----------------HAN 2010-04-09
					//ERP 보낼때 화면에서 받은 AR_OFC_CD 를 그대로 전송하도록 변경함. - ERP 조회해서 보낼때, INV_AR_AMT에서 조회해서 보내므로 invAmts.setErpIfOfcCd 을 변경함
					/*
					if (erpIfOfcCd.equals("")) {
						invAmts.setErpIfOfcCd(invCreVo.getOfcCd());
					}
					else {
						invAmts.setErpIfOfcCd(erpIfOfcCd);						
					}*/
					invAmts.setErpIfOfcCd(invCreVo.getOfcCd());
					
					addAmtVoList.add(invAmts);
					
					String invVatChgCd = "";
					invVatChgCd = dbDao.searchInvVatChgCd(invCreVo.getOfcCd());
					invVatChgCd = invVatChgCd!=null&&!invVatChgCd.equals("")?invVatChgCd:"TVA"; 
					
					// INV_AR_CHG
					chgSeq = 0;
					for (int j = 0; j < invArChgVOs.size(); j++) {
						InvArChgVO invChges = new InvArChgVO();

						chgCd = invArChgVOs.get(j).getChgCd();
						currCd = invArChgVOs.get(j).getCurrCd();
						
						log.debug("invVatChgCd===="+invVatChgCd);
						log.debug("chgCd===="+chgCd);
						log.debug("currCd===="+currCd);
						
						if (invArAmtVOs.get(i).getTjSrcNm().equals("VAT") && (chgCd.equals(invVatChgCd)||chgCd.equals("TVA"))) {
							if (invArAmtVOs.get(i).getCurrCd().equals(currCd)) {
								chgSeq = chgSeq + 1;

								invChges.setArIfNo(mriMaxSeq);
								invChges.setArIfSerNo(arIfSerNo);
								invChges.setArIfChgSeq(String.valueOf(chgSeq));
								invChges.setChgSeq(String.valueOf(j+1));
								invChges.setTjSrcNm(invArAmtVOs.get(i).getTjSrcNm());
								invChges.setChgCd(invArChgVOs.get(j).getChgCd());
								invChges.setCurrCd(invArChgVOs.get(j).getCurrCd());
								invChges.setPerTpCd("BL");
								invChges.setTrfRtAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setRatAsCntrQty("1");
								invChges.setChgAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setInvXchRt(invArChgVOs.get(j).getInvXchRt());
								invChges.setInvXchRtDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
								invChges.setInvRevTpSrcCd(invArChgVOs.get(j).getInvRevTpSrcCd());
								invChges.setOfcCd(invCreVo.getOfcCd());
								invChges.setRevCoaAcctCd(invArChgVOs.get(j).getAcctCd());
								invChges.setRevCoaInterCoCd(subsCoCd);
								invChges.setRevCoaVslCd(invCreVo.getLclVvd().substring(0, 4));
								invChges.setRevCoaVoyNo(invCreVo.getLclVvd().substring(4, 8));
								invChges.setRevCoaSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
								invChges.setRevCoaDirCd("M");
								invChges.setAcctCd(invArChgVOs.get(j).getAcctCd());
								if ("1".equals(invArChgVOs.get(j).getTvaFlg())) {
									invChges.setTvaFlg("Y");
								}
								else {
									invChges.setTvaFlg("N");
								}
								invChges.setChgRmk(invArChgVOs.get(j).getChgRmk());
								invChges.setCreUsrId(invCreVo.getUserId());
								invChges.setUpdUsrId(invCreVo.getUserId());
								invChges.setRepChgCd(invArChgVOs.get(j).getRepChgCd());
								invChges.setChgFullNm(invArChgVOs.get(j).getChgFullNm());
								invChges.setMnlFlg(invArChgVOs.get(j).getMnlFlg());
								invChges.setMfDivCd("N");
								ttlLssCfmFlg = invArChgVOs.get(j).getTtlLssCfmFlg();
								if(ttlLssCfmFlg.equals("1")){
									invChges.setTtlLssCfmFlg("Y");
								}else{
									invChges.setTtlLssCfmFlg("");
								}

								addChgVoList.add(invChges);
							}
						} else if (invArAmtVOs.get(i).getTjSrcNm().equals("NONRE") && chgCd.equals("XXX")) {
							if (invArAmtVOs.get(i).getCurrCd().equals(currCd)) {
								chgSeq = chgSeq + 1;

								invChges.setArIfNo(mriMaxSeq);
								invChges.setArIfSerNo(arIfSerNo);
								invChges.setArIfChgSeq(String.valueOf(chgSeq));
								invChges.setChgSeq(String.valueOf(j+1));
								invChges.setTjSrcNm(invArAmtVOs.get(i).getTjSrcNm());
								invChges.setChgCd(invArChgVOs.get(j).getChgCd());
								invChges.setCurrCd(invArChgVOs.get(j).getCurrCd());
								invChges.setPerTpCd("BL");
								invChges.setTrfRtAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setRatAsCntrQty("1");
								invChges.setChgAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setInvXchRt(invArChgVOs.get(j).getInvXchRt());
								invChges.setInvXchRtDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
								invChges.setInvRevTpSrcCd(invArChgVOs.get(j).getInvRevTpSrcCd());
								invChges.setOfcCd(invCreVo.getOfcCd());
								invChges.setRevCoaAcctCd(invArChgVOs.get(j).getAcctCd());
								invChges.setRevCoaInterCoCd(subsCoCd);
								invChges.setRevCoaVslCd(invCreVo.getLclVvd().substring(0, 4));
								invChges.setRevCoaVoyNo(invCreVo.getLclVvd().substring(4, 8));
								invChges.setRevCoaSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
								invChges.setRevCoaDirCd("M");
								invChges.setAcctCd(invArChgVOs.get(j).getAcctCd());
								if ("1".equals(invArChgVOs.get(j).getTvaFlg())) {
									invChges.setTvaFlg("Y");
								}
								else {
									invChges.setTvaFlg("N");
								}
								invChges.setChgRmk(invArChgVOs.get(j).getChgRmk());
								invChges.setCreUsrId(invCreVo.getUserId());
								invChges.setUpdUsrId(invCreVo.getUserId());
								invChges.setRepChgCd(invArChgVOs.get(j).getRepChgCd());
								invChges.setChgFullNm(invArChgVOs.get(j).getChgFullNm());
								invChges.setMnlFlg(invArChgVOs.get(j).getMnlFlg());
								invChges.setMfDivCd("N");
								ttlLssCfmFlg = invArChgVOs.get(j).getTtlLssCfmFlg();
								if(ttlLssCfmFlg.equals("1")){
									invChges.setTtlLssCfmFlg("Y");
								}else{
									invChges.setTtlLssCfmFlg("");
								}

								addChgVoList.add(invChges);
							}
						} else if (invArAmtVOs.get(i).getTjSrcNm().equals("OTHER") && !chgCd.equals("XXX") && !chgCd.equals(invVatChgCd) && !chgCd.equals("TVA")) {
							if (invArAmtVOs.get(i).getCurrCd().equals(currCd)) {
								chgSeq = chgSeq + 1;

								invChges.setArIfNo(mriMaxSeq);
								invChges.setArIfSerNo(arIfSerNo);
								invChges.setArIfChgSeq(String.valueOf(chgSeq));
								invChges.setChgSeq(String.valueOf(j+1));
								invChges.setTjSrcNm(invArAmtVOs.get(i).getTjSrcNm());
								invChges.setChgCd(invArChgVOs.get(j).getChgCd());
								invChges.setCurrCd(invArChgVOs.get(j).getCurrCd());
								invChges.setPerTpCd("BL");
								invChges.setTrfRtAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setRatAsCntrQty("1");
								invChges.setChgAmt(invArChgVOs.get(j).getChgAmt().replaceAll(",", ""));
								invChges.setInvXchRt(invArChgVOs.get(j).getInvXchRt());
								invChges.setInvXchRtDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
								invChges.setInvRevTpSrcCd(invArChgVOs.get(j).getInvRevTpSrcCd());
								invChges.setOfcCd(invCreVo.getOfcCd());
								invChges.setRevCoaAcctCd(invArChgVOs.get(j).getAcctCd());
								invChges.setRevCoaInterCoCd(subsCoCd);
								invChges.setRevCoaVslCd(invCreVo.getLclVvd().substring(0, 4));
								invChges.setRevCoaVoyNo(invCreVo.getLclVvd().substring(4, 8));
								invChges.setRevCoaSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
								invChges.setRevCoaDirCd("M");
								invChges.setAcctCd(invArChgVOs.get(j).getAcctCd());
								if ("1".equals(invArChgVOs.get(j).getTvaFlg())) {
									invChges.setTvaFlg("Y");
								}
								else {
									invChges.setTvaFlg("N");
								}
								invChges.setChgRmk(invArChgVOs.get(j).getChgRmk());
								invChges.setCreUsrId(invCreVo.getUserId());
								invChges.setUpdUsrId(invCreVo.getUserId());
								invChges.setRepChgCd(invArChgVOs.get(j).getRepChgCd());
								invChges.setChgFullNm(invArChgVOs.get(j).getChgFullNm());
								invChges.setMnlFlg(invArChgVOs.get(j).getMnlFlg());
								invChges.setMfDivCd("N");
								ttlLssCfmFlg = invArChgVOs.get(j).getTtlLssCfmFlg();
								if(ttlLssCfmFlg.equals("1")){
									invChges.setTtlLssCfmFlg("Y");
								}else{
									invChges.setTtlLssCfmFlg("");
								}

								addChgVoList.add(invChges);
							}
						}
					}
				}

				if (addAmtVoList.size() > 0) {
					dbDao.addInvAmount(addAmtVoList);
				}

				if (addChgVoList.size() > 0) {
					dbDao.addInvCharge(addChgVoList);
				}

				// 
				List<Fns0120001VO> list3 = null;
				list3 = dbDao.searchARInvoiceForERP(mriMaxSeq, "C");

				eaiDao.interfaceARInvoiceToERPAR(list3);
				
				otherRevReturnVO.setArIfNo(mriMaxSeq);
				otherRevReturnVO.setSlipNo(invCreVo.getSlpNo());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}

		return otherRevReturnVO;
	}

	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date, No Good 일때 Customer Code 변경
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyCustomerCode(InvNewCustVO invNewCustVO, String userId) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		INVCommonUtil command = new INVCommonUtil();
		try {

			List<InvArMnVO> invArMnList = null;
			List<InvArChgVO> invArChgList = null;
			List<InvArAmtVO> invArAmtList = null;

			InvArMnVO invArMnVO = new InvArMnVO();
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;

			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

			invArMnList = dbDao.searchARInvoice(invNewCustVO.getArIfNo());
			invArChgList = dbDao.searchARInvoiceCharge(invNewCustVO.getArIfNo());
			invArAmtList = dbDao.searchARInvoiceAmount(invNewCustVO.getArIfNo());
			
			invArMnVO = invArMnList.get(0);
			invArChgVOs = invArChgList;
			invArAmtVOs = invArAmtList;

			invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
			invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
			invArMnVO.setInvCustCntCd(invNewCustVO.getActCustCntCd());
			invArMnVO.setInvCustSeq(invNewCustVO.getActCustSeq());
			invArMnVO.setInvRmk(invNewCustVO.getInvRmk());
			invArMnVO.setGlEffDt(invNewCustVO.getGlEffDt());
			invArMnVO.setUpdUsrId(userId);
			
			//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			String arAgnStlCd = "";
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				locCd = arOfcAttributeVO.getLocCd();
				arCrdtVo.setLocCd(locCd.substring(0,2));
			}
						
			ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
			
			if(aRCreditVO != null){
				invArMnVO.setDueDt(aRCreditVO.getDueDt());
				invArMnVO.setCrTermDys(aRCreditVO.getCrTerm());
				invArMnVO.setCustCrFlg(aRCreditVO.getCrFlg());
			}

			//int invTtlLoclAmt = 0;

			vvdCustomerVo.setInvCntryCd(invNewCustVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invNewCustVO.getInvCustSeq());
			vvdCustomerVo.setVoy(invArMnList.get(0).getSkdVoyNo());
			vvdCustomerVo.setLclCurr(invArMnList.get(0).getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnList.get(0).getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnList.get(0).getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnList.get(0).getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnList.get(0).getBkgNo());
			vvdCustomerVo.setSaDt(invArMnList.get(0).getSailArrDt());
			vvdCustomerVo.setVsl(invArMnList.get(0).getVslCd());
			vvdCustomerVo.setPol(invArMnList.get(0).getPolCd());
			vvdCustomerVo.setDep(invArMnList.get(0).getSkdDirCd());
			vvdCustomerVo.setPod(invArMnList.get(0).getPodCd());
			
			//BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				invArChgVOs.get(i).setUpdUsrId(userId);

				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());
				exchangeRateVo = command.searchExchangeRate(vvdCustomerVo);
				
				//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
				
				//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
				//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());	
				//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
				
				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
			}

			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = command.searchExchangeRate(vvdCustomerVo);

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());

			dbDao.modifyCustomerCode(invArMnVO);
			dbDao.modifyInvCharge(invArChgList);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			}
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			for (int i = 0; i < invArAmtVOs.size(); i++) {
				invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
				invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
				invArAmtVOs.get(i).setUpdUsrId(userId);
			}
			
			dbDao.modifyARInvoiceAmount(invArAmtVOs);
			
			cnt = dbDao.checkAccountRateExist(invNewCustVO.getGlEffDt());

			if (cnt > 0) {
				// [경리환율 존재하는 경우]
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
				newIfNo = invArMnVO.getArIfNo();
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 * FNS_INV_0007,0008,0100,0101 BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param ExchangeRateVO[] exchangeRateVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String manageARInvoiceExRateList(ExchangeRateVO[] exchangeRateVOs, String userId) throws EventException {
		BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			bookingARCreationBackEndJob.setExchangeRateVOs(exchangeRateVOs);
			bookingARCreationBackEndJob.setUserId(userId);
			bookingARCreationBackEndJob.setUiType("C");

			return backEndJobManager.execute(bookingARCreationBackEndJob, userId, "manageARInvoiceExRateList");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 환율 Update BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyExchangeRateList(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt ,String userId) throws EventException {
		BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			bookingARCreationBackEndJob.setExrateInputVOs(exrateInputVOs);
			bookingARCreationBackEndJob.setExrateInputVO(exrateInputVO);
			bookingARCreationBackEndJob.setRunOpt(runOpt);
			bookingARCreationBackEndJob.setUserId(userId);
			bookingARCreationBackEndJob.setUiType("U");

			return backEndJobManager.execute(bookingARCreationBackEndJob, userId, "modifyExchangeRateList");
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 환율 Update 하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws EventException {
		try {
			//BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutModifyExchangeRateList(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
	
	/**
	 * FNS_INV_0062 VLCSC의 EDI 다운로드 받은 해당 데이터에 대해서 EDI_SND_DT에 SYSDATE를 반영한다.
	 * 
	 * @author Jung Jin Park
	 * @param String ofcCd
	 * @param String issDate
	 * @exception EventException
	 */
	public void modifyEDISendDate(String ofcCd, String issDate) throws EventException {
		try {
			dbDao.modifyEDISendDate(ofcCd, issDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), e);
		}
	}
	
	/**
	 * FNS_INV_0062 VLCSC의 EDI 다운로드 했던 데이터에 대해서 INV_AR_MN의 EDI_SND_DT 값을 Null 를 update 한다.
	 * 
	 * @author	Kwon Min
	 * @param	String fmInvNo
	 * @param	String toInvNo
	 * @exception EventException
	 */
	public void modifyEDISendDataRelease(String fmInvNo, String toInvNo) throws EventException {
		try {
			dbDao.modifyEDISendDataRelease(fmInvNo, toInvNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String invNo
	 * @param String issFlg
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyIssueFlag(String invNo, String issFlg, String userId) throws EventException {
		try {
			dbDao.modifyIssueFlag(invNo, issFlg, userId);
			dbDao.modifyIssueFlagMain(invNo, issFlg, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String ifNo
	 * @param String dueDt
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyDueDate(String ifNo, String dueDt, String userId) throws EventException {
		try {
			dbDao.modifyDueDate(ifNo, dueDt, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String ifNo
	 * @param String bkgNo
	 * @param String invRmk
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyTeuFeuInvRefNumber(String ifNo, String bkgNo, String invRmk, String userId) throws EventException {
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArCntrVO> list = null;
		String invRefNo = "";

		try {
			invArMnVO = dbDao.searchTeuFeu(bkgNo);

			invRefNo = dbDao.searchInvRefNumber(bkgNo);

			// dbDao.modifyTeuFeuInvRefNumber(ifNo, invArMnVO.getBkgTeuQty(), invArMnVO.getBkgFeuQty(), invRefNo, userId);
			invArMnVO.setArIfNo(ifNo);
			invArMnVO.setInvRefNo(invRefNo);

			dbDao.modifyTeuFeuInvRefNumber(invArMnVO, userId);

			dbDao.modifyInvoiceRemark(ifNo, invRmk, userId);

			dbDao.removeARInvoiceContainer(ifNo);

			list = dbDao.searchBKGContainerList(bkgNo);

			for (int i = 0; i < list.size(); i++) {
				list.get(i).setArIfNo(ifNo);
				list.get(i).setCntrSeq(String.valueOf(i + 1));
			}

			dbDao.addInvContainer(list, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * INVOICE ISSUE시 ISSUE FLAG , DUE DATE, TEU, FEU, REF NUMBER를 UPDATE 한다. <br>
	 * 
	 * @param InvIssueVO invIssueVO
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssue(InvIssueVO invIssueVO, String otsSmryCd, String userId) throws EventException {
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArCntrVO> list = null;
		List<CntrTypeSizeVO> list2 = null;
		List<Fns0120001VO> list3 = null;
		String invRefNo = "";
		String cntrNos = "";
		String cntrTpSzs = "";
		log.info("\n########## otsSmryCd2 : "+otsSmryCd);
		try {
			dbDao.modifyIssueFlag(invIssueVO.getInvno(), invIssueVO.getIssflg(), userId);

			dbDao.modifyDueDate(invIssueVO.getIfno(), invIssueVO.getDuedt(), userId);

			if (invIssueVO.getBkgno() != null && !invIssueVO.getBkgno().equals("")) {

				invArMnVO = dbDao.searchTeuFeu(invIssueVO.getBkgno());

				invRefNo = dbDao.searchInvRefNumber(invIssueVO.getBkgno());

				invArMnVO.setArIfNo(invIssueVO.getIfno());
				invArMnVO.setInvRefNo(invRefNo);

				dbDao.modifyTeuFeuInvRefNumber(invArMnVO, userId);

				// dbDao.modifyInvoiceRemark(invIssueVO.getIfno(), invIssueVO.getInvrmk(), userId);

				dbDao.removeARInvoiceContainer(invIssueVO.getIfno());

				list = dbDao.searchBKGContainerList(invIssueVO.getBkgno());

				for (int i = 0; i < list.size(); i++) {
					list.get(i).setArIfNo(invIssueVO.getIfno());
					list.get(i).setCntrSeq(String.valueOf(i + 1));
				}

				dbDao.addInvContainer(list, userId);

				// ERP 전송 처리 시작

				if (otsSmryCd.equals("INV")) {	
					
					StringBuffer cntrNosBuff = new StringBuffer();					
					for (int i = 0; i < list.size(); i++) {
						cntrNosBuff.append(list.get(i).getCntrNo() + (i != list.size() - 1 ? "," : ""));
						//cntrNos = cntrNos + list.get(i).getCntrNo() + (i != list.size() - 1 ? "," : "");
					}
					cntrNos = cntrNosBuff.toString();
					log.info("########## cntrNos : " + cntrNos);
	
					list2 = dbDao.searchCntrTpSzForERP(invArMnVO.getArIfNo());
	
					StringBuffer cntrTpSzsBuff = new StringBuffer();
					for (int i = 0; i < list2.size(); i++) {
						cntrTpSzsBuff.append(list2.get(i).getCntrTpszCd() + "X" + list2.get(i).getCntrTpszCnt() + (i != list2.size() - 1 ? "," : ""));
						//cntrTpSzs = cntrTpSzs + list2.get(i).getCntrTpszCd() + "X" + list2.get(i).getCntrTpszCnt() + (i != list2.size() - 1 ? "," : "");
					}
					cntrTpSzs = cntrTpSzsBuff.toString();
					log.info("########## cntrTpSzs : " + cntrTpSzs);
					
					int lastIdx = 0;
					if (cntrNos.length() > 150) {
						
						cntrNos = cntrNos.substring(0, 150);
						//log.info("\n########## cntrNos2 : " + cntrNos);
						
						lastIdx = cntrNos.lastIndexOf(",");						
						//log.info("\n########## lastIdx : " + lastIdx);
						
						cntrNos = cntrNos.substring(0, lastIdx);						
						//log.info("\n########## cntrNos3 : " + cntrNos);
												
					}
				}
			}

			if (otsSmryCd.equals("INV")) {	
				
				log.info("\n########## otsSmryCd3 : "+otsSmryCd);
				
				list3 = dbDao.searchARInvoiceForERP(invIssueVO.getIfno(), "U");
	
				for (int i = 0; i < list3.size(); i++) {
					list3.get(i).setCntrNo(cntrNos);
					list3.get(i).setCntrTpSz(cntrTpSzs);
				}
	
				eaiDao.interfaceARInvoiceToERPAR(list3);
			}
			
			// ERP 전송 처리 끝

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * INVOICE RE-ISSUE시 TEU, FEU, REF NUMBER를 UPDATE 한다. <br>
	 * 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyInvoiceReIssue(String invNo, String otsSmryCd, String userId, String ofcCd) throws EventException {
		InvArMnVO invArMnVO = null;
		List<InvArMnVO> invArMnVOs = null;
		List<InvArCntrVO> list = null;
		List<CntrTypeSizeVO> list2 = null;
		List<Fns0120001VO> list3 = null;
		String invRefNo = "";
		String cntrNos = "";
		String cntrTpSzs = "";
		
		log.info("\n########## otsSmryCd4 : "+otsSmryCd);
		log.info("\n########## invNo : "+invNo);
		log.info("\n########## ofcCd : "+ofcCd);

		try {
			invArMnVOs = dbDao.searchMaxIFNoBKGNoByINVNo(invNo);
			
			for (int idx = 0; idx < invArMnVOs.size(); idx++) {				
				
				if (invArMnVOs.get(idx).getBkgNo() != null && !invArMnVOs.get(idx).getBkgNo().equals("")) {
	
					invArMnVO = dbDao.searchTeuFeu(invArMnVOs.get(idx).getBkgNo());
	
					if (invArMnVOs.get(idx).getIoBndCd().equals("I")) {
						invRefNo = invArMnVOs.get(idx).getInvRefNo();
					} else {
						invRefNo = dbDao.searchInvRefNumberRe(invArMnVOs.get(idx).getBkgNo(), invNo, ofcCd);
					}
					
					invArMnVO.setArIfNo(invArMnVOs.get(idx).getArIfNo());
					invArMnVO.setInvRefNo(invRefNo);
	
					dbDao.modifyTeuFeuInvRefNumber(invArMnVO, userId);
	
					dbDao.removeARInvoiceContainer(invArMnVOs.get(idx).getArIfNo());
	
					list = dbDao.searchBKGContainerList(invArMnVOs.get(idx).getBkgNo());
	
					for (int i = 0; i < list.size(); i++) {
						list.get(i).setArIfNo(invArMnVOs.get(idx).getArIfNo());
						list.get(i).setCntrSeq(String.valueOf(i + 1));
	
					}
	
					dbDao.addInvContainer(list, userId);
	
					// ERP 전송 처리 시작
	
					if (otsSmryCd.equals("INV") || ofcCd.equals("DXBSC")) {
						
						cntrNos = "";
						cntrTpSzs = "";
					
						StringBuffer cntrNosBuff = new StringBuffer();
						for (int i = 0; i < list.size(); i++) {
							cntrNosBuff.append(list.get(i).getCntrNo() + (i != list.size() - 1 ? "," : ""));
//							cntrNos = cntrNos + list.get(i).getCntrNo() + (i != list.size() - 1 ? "," : "");
						}
						cntrNos = cntrNosBuff.toString();
						
						int lastIdx = 0;
						if (cntrNos.length() > 150) {
							
							cntrNos = cntrNos.substring(0, 150);
							
							lastIdx = cntrNos.lastIndexOf(",");						
							
							cntrNos = cntrNos.substring(0, lastIdx);						
													
						}
		
						list2 = dbDao.searchCntrTpSzForERP(invArMnVOs.get(idx).getArIfNo());
		
						StringBuffer cntrTpSzsBuff = new StringBuffer();
						for (int i = 0; i < list2.size(); i++) {
							cntrTpSzsBuff.append(list2.get(i).getCntrTpszCd() + "X" + list2.get(i).getCntrTpszCnt() + (i != list2.size() - 1 ? "," : ""));
//							cntrTpSzs = cntrTpSzs + list2.get(i).getCntrTpszCd() + "X" + list2.get(i).getCntrTpszCnt() + (i != list2.size() - 1 ? "," : "");
						}
						cntrTpSzs = cntrTpSzsBuff.toString();
					}
				}
	
				if (otsSmryCd.equals("INV") || ofcCd.equals("DXBSC")) {
					
					list3 = dbDao.searchARInvoiceForERP(invArMnVOs.get(idx).getArIfNo(), "U");
					
					log.debug("cntrNos = "+cntrNos);
					log.debug("cntrTpSzs = "+cntrTpSzs);
					for (int i = 0; i < list3.size(); i++) {
						list3.get(i).setCntrNo(cntrNos);
						list3.get(i).setCntrTpSz(cntrTpSzs);
					}
		
					eaiDao.interfaceARInvoiceToERPAR(list3);
					
				}
				// ERP 전송 처리 끝
			
			}
			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 적용<br>
	 * 
	 * @param ExrateMainVO exrateMainVO
	 * @return String
	 * @exception EventException
	 */
	public String modifyInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException {
		String effDt = "";
		String newIfNo = "";
		String sailDt ="";
		int cnt = 0;
		
		List<InvArMnVO> invArMnList = null;
		InvArMnVO invArMnVO = new InvArMnVO();
		
		try {
			if (exrateMainVO != null) {
				
				invArMnList = dbDao.searchARInvoice(exrateMainVO.getArIfNo());
				invArMnVO = invArMnList.get(0);
				
				//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
				ARCreditInputVO arCrdtVo = new ARCreditInputVO();
				arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
				arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
				arCrdtVo.setSailArrDt(exrateMainVO.getSailArrDt());
				arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
				arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
				arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
				arCrdtVo.setDelCd(invArMnVO.getDelCd());
				
				String locCd ="";
				String arAgnStlCd = "";
				ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
				
				if(arOfcAttributeVO!=null){
					locCd = arOfcAttributeVO.getLocCd();
					arCrdtVo.setLocCd(locCd.substring(0,2));
				}
							
				ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
				
				if(aRCreditVO != null){
					exrateMainVO.setDueDt(aRCreditVO.getDueDt());
					exrateMainVO.setCrTermDys(aRCreditVO.getCrTerm());
					exrateMainVO.setCustCrFlg(aRCreditVO.getCrFlg());
				}
				
				sailDt = dbDao.searchSailingDate(exrateMainVO.getBkgNo());
				if(sailDt.equals("")) sailDt = dbDao.searchSailingDateByVvd(invArMnVO.getVslCd(),invArMnVO.getSkdVoyNo(),invArMnVO.getSkdDirCd(), invArMnVO.getPolCd());
				
				effDt = dbDao.searchEffectiveDate(exrateMainVO.getArOfcCd(), sailDt,exrateMainVO.getRevTpCd(),exrateMainVO.getRevSrcCd());
				
				exrateMainVO.setSailDt(sailDt);				
				exrateMainVO.setGlEffDt(effDt);
				dbDao.modifyInvoiceExrateMain(exrateMainVO);
				
				cnt = dbDao.checkAccountRateExist(effDt);

				if ((invArMnVO.getBlInvCfmDt()==null || invArMnVO.getBlInvCfmDt().equals("")) && cnt > 0) {
					//2010-03-29 환율 업데이트 Good 시키는 경우 Amt 에 erp_if_ofc_cd 구함
					List<InvArAmtVO> invArAmtVOs = dbDao.searchARInvoiceAmount(invArMnVO.getArIfNo());
					
					String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
					
					if(arOfcAttributeVO!=null){
						arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
					}
					
					String erpIfOfcCd = "";
					
					if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
						
						//2010-05-13 이상희 과장 CA 도 추가
						if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
							erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
						}
												
					}else if(svrId.equals("KOR") && invArMnVO.getActCustCntCd().equals("KR")){
						if(invArMnVO.getCustCrFlg().equals("Y")){
							erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
						}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
							erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
						}
					}
					
					for (int i = 0; i < invArAmtVOs.size(); i++) {
						invArAmtVOs.get(i).setErpIfGlDt(effDt);
						invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
						invArAmtVOs.get(i).setUpdUsrId(exrateMainVO.getUpdUsrId());
					}
					
					dbDao.modifyARInvoiceAmount(invArAmtVOs);
					
					
					//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
					//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
					String sailArrDt2        =	exrateMainVO.getSailArrDt();
					String sailDt2           =	exrateMainVO.getSailDt();
					String dueDt2            =	exrateMainVO.getDueDt();
					String xchRtN3rdTpCd2    =	exrateMainVO.getXchRtN3rdTpCd();
					String xchRtUsdTpCd2     =	exrateMainVO.getXchRtUsdTpCd();
					String glEffDt2          =	exrateMainVO.getGlEffDt();
					
					if(sailArrDt2 == null) sailArrDt2 = "";
					if(sailDt2 == null) sailDt2 = "";
					if(dueDt2 == null) dueDt2 = "";
					if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
					if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
					if(glEffDt2 == null) glEffDt2 = "";					
					
					if(!sailArrDt2.equals("") && !sailDt2.equals("") && !dueDt2.equals("")
							&& !xchRtN3rdTpCd2.equals("") && !xchRtUsdTpCd2.equals("") && !glEffDt2.equals("")){
					
						// [경리환율 존재하는 경우]
						dbDao.modifyCFMDate(exrateMainVO.getArIfNo(), "good", exrateMainVO.getArOfcCd(), invArMnVO.getBlSrcNo());
						newIfNo = exrateMainVO.getArIfNo();
					}
				}				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 Chg 테이블에 적용<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateChgVO exrateChgVO
	 * @exception EventException
	 * 
	 */
	public void modifyInvoiceExrateChg(ExrateChgVO exrateChgVO) throws EventException {
		try {
			if (exrateChgVO != null) {
				dbDao.modifyInvoiceExrateChg(exrateChgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * INVOICE EMAIL-ISSUE시 TEU, FEU, REF NUMBER, INV RMK를 UPDATE 한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param String ofcCd
	 * @param String issueGubn
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssueEmail(InvIssMainVO[] issMainVOs, String ofcCd, String issueGubn, String userId) throws EventException {
		InvArMnVO invArMnVO = new InvArMnVO();
		//InvArMnVO invArMnVO2 = new InvArMnVO();
		List<InvArMnVO> invArMnVOs = null;
		List<InvArCntrVO> list = null;
		List<CntrTypeSizeVO> list2 = null;
		List<Fns0120001VO> list3 = null;
		String invRefNo = "";
		String cntrNos = "";
		String cntrTpSzs = "";
		String otsSmryCd = "";

		try {
			
			otsSmryCd = dbDao.searchOtsSmryCd(ofcCd);
			
			log.info("\n########## otsSmryCd5 : "+otsSmryCd);
			log.info("\n########## issueGubn5 : "+issueGubn);
			
			for (int i = 0; i < issMainVOs.length; i++) {				
				
				invArMnVOs = dbDao.searchMaxIFNoBKGNoByINVNo(issMainVOs[i].getInvNo());
				
				for (int idx = 0; idx < invArMnVOs.size(); idx++) {
				
					dbDao.modifyInvoiceRemark(invArMnVOs.get(idx).getArIfNo(), issMainVOs[i].getInvIssRmk(), userId);
					
					if (invArMnVOs.get(idx).getBkgNo() != null && !invArMnVOs.get(idx).getBkgNo().equals("")) {
	
						invArMnVO = dbDao.searchTeuFeu(invArMnVOs.get(idx).getBkgNo());
						
						if (invArMnVOs.get(idx).getIoBndCd().equals("I")) {
							invRefNo = invArMnVOs.get(idx).getInvRefNo();
						} else {
							invRefNo = dbDao.searchInvRefNumberRe(invArMnVOs.get(idx).getBkgNo(), issMainVOs[i].getInvNo(),ofcCd);
						}
	
						invArMnVO.setArIfNo(invArMnVOs.get(idx).getArIfNo());
						invArMnVO.setInvRefNo(invRefNo);
	
						dbDao.modifyTeuFeuInvRefNumber(invArMnVO, userId);
	
						dbDao.removeARInvoiceContainer(invArMnVOs.get(idx).getArIfNo());
	
						list = dbDao.searchBKGContainerList(invArMnVOs.get(idx).getBkgNo());
	
						for (int j = 0; j < list.size(); j++) {
							list.get(j).setArIfNo(invArMnVOs.get(idx).getArIfNo());
							list.get(j).setCntrSeq(String.valueOf(j + 1));
						}
	
						dbDao.addInvContainer(list, userId);
	
						// ERP 전송 처리 시작
	
						if (otsSmryCd.equals("INV") && issueGubn.equals("R") || ofcCd.equals("DXBSC")) {
							
							cntrNos = "";
							cntrTpSzs = "";
							StringBuffer cntrNosBuff = new StringBuffer();
							
							for (int k = 0; k < list.size(); k++) {
								cntrNosBuff.append(list.get(k).getCntrNo() + (k != list.size() - 1 ? "," : ""));
//								cntrNos = cntrNos + list.get(k).getCntrNo() + (k != list.size() - 1 ? "," : "");
							}
							cntrNos = cntrNosBuff.toString();
							
							int lastIdx = 0;
							if (cntrNos.length() > 150) {
								
								cntrNos = cntrNos.substring(0, 150);
								log.info("\n########## cntrNos2 : " + cntrNos);
								
								lastIdx = cntrNos.lastIndexOf(",");						
								log.info("\n########## lastIdx : " + lastIdx);
								
								cntrNos = cntrNos.substring(0, lastIdx);						
								log.info("\n########## cntrNos3 : " + cntrNos);
														
							}
							log.info("########## cntrNos : " + cntrNos);
		
							list2 = dbDao.searchCntrTpSzForERP(invArMnVOs.get(idx).getArIfNo());
							
							StringBuffer cntrTpSzsBuff = new StringBuffer();
							for (int k = 0; k < list2.size(); k++) {
								cntrTpSzsBuff.append(list2.get(k).getCntrTpszCd() + "X" + list2.get(k).getCntrTpszCnt() + (k != list2.size() - 1 ? "," : ""));
//								cntrTpSzs = cntrTpSzs + list2.get(k).getCntrTpszCd() + "X" + list2.get(k).getCntrTpszCnt() + (k != list2.size() - 1 ? "," : "");
							}
							cntrTpSzs = cntrTpSzsBuff.toString();
							log.info("########## cntrTpSzs : " + cntrTpSzs);
						}
					}					
	
					if (otsSmryCd.equals("INV") && issueGubn.equals("R") || ofcCd.equals("DXBSC")) {
						list3 = dbDao.searchARInvoiceForERP(invArMnVOs.get(idx).getArIfNo(), "U");
		
						for (int k = 0; k < list3.size(); k++) {
							list3.get(k).setCntrNo(cntrNos);
							list3.get(k).setCntrTpSz(cntrTpSzs);
						}
		
						eaiDao.interfaceARInvoiceToERPAR(list3);
					}
					// ERP 전송 처리 끝
				}
				
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00025", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00025", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Split 시 사용할 사용가능한 IF NO 의 Max Seq 를 INV_AR_BKG_IF_NO 에 update 한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String maxSeq
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyNewInterfaceNo(String ofcCd, String maxSeq, String userId) throws EventException {
		try {
			dbDao.modifyNewInterfaceNo(ofcCd, maxSeq, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * INV_AR_MN 테이블에 Update Master가 되는 대상 데이터에 Split ind를 'M'으로 update 함. <br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCd
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySplitCode(String ifNo, String splitCd, String otsSmryCd, String userId) throws EventException {
		try {
			dbDao.modifySplitCode(ifNo, splitCd, userId);
			if (otsSmryCd.equals("INV")||otsSmryCd.equals("CLR")) {
				dbDao.modifySysClear(ifNo, userId);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_MN 테이블에 InvNo 로 Update Master가 되는 대상을 찾아서 Split ind를 'M'으로 update 함. <br>
	 * 
	 * @author Choi Do Soon
	 * @param String invNo
	 * @param String ofcCd
	 * @param String splitCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySplitCodebyInvNo(String invNo, String ofcCd, String splitCd, String userId) throws EventException {
		try {
			dbDao.modifySplitCodeByInvNo(invNo, ofcCd, splitCd, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * FNS012R001Document XMLparsing <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return ERPIfReturnVO[]
	 * @exception EventException
	 */
	public ERPIfReturnVO[] fns012R001Receive(XmlObject xmlObject) throws EventException {
		log.debug("======================================");
		log.debug("xmlObject : " + xmlObject);
		log.debug("======================================");

		FNS012R001Document doc = (FNS012R001Document) xmlObject;
		FNS012R001 sync = doc.getFNS012R001();
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();

		ERPIfReturnVO[] models = new ERPIfReturnVO[row.length];

		try {
			for (int i = 0; row != null && i < row.length; i++) {
				models[i] = new ERPIfReturnVO();

				models[i].setLifid(row[i].getLIFID());
				models[i].setSeq(row[i].getSEQ());
				models[i].setTotalCount(row[i].getTOTALCOUNT());
				models[i].setRowCount(row[i].getROWCOUNT());
				models[i].setFlag(row[i].getFLAG());
				models[i].setIfNo(row[i].getIFNO());
				models[i].setIfSer(row[i].getIFSER());
				models[i].setIfResult(row[i].getIFRESULT());
				models[i].setErrorMsg(row[i].getERRORMSG());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}

		return models;
	}

	/**
	 * FNS012-R001에서 Return받는 정보를 INV_AR_AMT에 update 함. <br>
	 * 
	 * @param ERPIfReturnVO[] erpIfReturnVOs
	 * @exception EventException
	 */
	public void modifyARInvoiceERPReturn(ERPIfReturnVO[] erpIfReturnVOs) throws EventException {
		try {
			List<ERPIfReturnVO> updateVoList = new ArrayList<ERPIfReturnVO>();

			for (int i = 0; i < erpIfReturnVOs.length; i++) {
				// Update 항목에 추가
				updateVoList.add(erpIfReturnVOs[i]);
				
//				log.error(" FNS012-0001 Return : ifNo = " + erpIfReturnVOs[i].getIfNo()+": ifSer = "+erpIfReturnVOs[i].getIfSer());
	            
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyARInvoiceERPReturn(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelSplitInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;

			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			invArChgVOs = dbDao.searchARInvoiceCharge(cancelInvoiceVO.getIfNo());
			invArAmtVOs = dbDao.searchARInvoiceAmount(cancelInvoiceVO.getIfNo());
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());

			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);

			invArMnVO.setInvTtlLoclAmt(Float.toString(Float.parseFloat(invArMnVO.getInvTtlLoclAmt()) * -1));
			invArMnVO.setArIfNo(cancelInvoiceVO.getNewIfNo());
			if (cancelInvoiceVO.getRevTpCd().equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					invArMnVO.setRevTpCd("B");
					invArMnVO.setRevSrcCd("CS");
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					invArMnVO.setRevTpCd("C");
					invArMnVO.setRevSrcCd("CA");
				}
			} else {
				invArMnVO.setRevTpCd(cancelInvoiceVO.getRevTpCd());
				invArMnVO.setRevSrcCd(cancelInvoiceVO.getRevSrcCd());
			}
			invArMnVO.setGlEffDt(cancelInvoiceVO.getEffDt());
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setInvSplitCd("X");
			invArMnVO.setInvDeltDivCd("X");
			invArMnVO.setBlInvCfmDt("");
			invArMnVO.setOldArIfNo("");
			
			//Main Table SYS CLEAR 20091229
			if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
				invArMnVO.setInvIssFlg("Y");
				invArMnVO.setInvClrFlg("Y");
			} else {
				invArMnVO.setInvIssFlg("N");
				invArMnVO.setInvClrFlg("N");
			}
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2010-12-06 Cancel시 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산
			// INV_AR_MN 에서 ifNo 로 구해온 act_cust_cnt_cd 와 act_cust_seq 로 inv_coa_inter_co_cd 를 가져와 setting
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				String invRevTpSrcCd = "";
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				//invArChgVOs.get(i).setChgAmt(Float.toString(Float.parseFloat(invArChgVOs.get(i).getChgAmt()) * -1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());
				
				invArChgVOs.get(i).setArIfNo(cancelInvoiceVO.getNewIfNo());
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
				
				if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
					invArChgVOs.get(i).setInvIssFlg("Y");
					invArChgVOs.get(i).setInvClrFlg("Y");
				} else {
					invArChgVOs.get(i).setInvIssFlg("N");
					invArChgVOs.get(i).setInvClrFlg("N");
				}
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
			}

			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				BigDecimal invAmt= new BigDecimal(invArAmtVOs.get(i).getInvAmt()).multiply(new BigDecimal(-1));
				
				//invArAmtVOs.get(i).setInvAmt(Float.toString(Float.parseFloat(invArAmtVOs.get(i).getInvAmt()) * -1));
				
				invArAmtVOs.get(i).setInvAmt(invAmt.toString());	
				
				invArAmtVOs.get(i).setArIfNo(cancelInvoiceVO.getNewIfNo());
				invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
				invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
			}

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(cancelInvoiceVO.getNewIfNo());
					invArCntrVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				}
			}

			dbDao.addInvMain(invArMnVO);
			dbDao.addInvAmount(invArAmtVOs);
			dbDao.addInvCharge(invArChgVOs);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(cancelInvoiceVO.getEffDt());
			
			

			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					newIfNo = invArMnVO.getArIfNo();
				}
				
			} else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}	
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}
	
	/**
	 * Invoice Issue Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createCancelIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			//List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;			
				
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			invArChgVOs = dbDao.searchIssueInvoiceCharge ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			//invArAmtVOs = dbDao.searchIssueInvoiceAmount ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			//String invTtlLoclAmt  = dbDao.searchARInvoiceLocalAmountByInvoiceNo( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd() );
			
			newIfNo = cancelInvoiceVO.getNewIfNo()!=null?cancelInvoiceVO.getNewIfNo():"";
			
			if(newIfNo.equals("")||newIfNo==null){
				/*
				String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
				if (maxSeq == null) {
					dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
					maxSeq = "00000001";
				} else {
					dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
				}
				*/
				
				//2010-04-23 deadlock 에러 때문에 프로시져로 변경
				String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());	
				
				if (maxSeq.equals("")){
					throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
				}	
				
				
				//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
				//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
//				newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
				
				if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
					newIfNo = "LON"+ maxSeq ;
				}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
					newIfNo = "WRP"+ maxSeq ;
				}else{
					newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
				}
			}
			
			//log.info("invTtlLoclAmt = "+invTtlLoclAmt);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			//invArMnVO.setInvTtlLoclAmt(Float.toString(Float.parseFloat(invTtlLoclAmt) * -1));
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			
			String revTpCd = "";
			String revSrcCd = "";
			
			if (cancelInvoiceVO.getRevTpCd().equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					revTpCd = "B";
					revSrcCd = "CS";
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					revTpCd = "C";
					revSrcCd = "CA";
				}
			} else {
				if(cancelInvoiceVO.getRevTpCd().equals("M")){
					revTpCd = invArMnVO.getRevTpCd();
					revSrcCd = invArMnVO.getRevSrcCd();					
				}else{
					revTpCd = cancelInvoiceVO.getRevTpCd();
					revSrcCd = cancelInvoiceVO.getRevSrcCd();
				}
			}
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String glEffDt = dbDao.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt(), revTpCd, revSrcCd);
			
			invArMnVO.setGlEffDt(glEffDt);
			
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			
			//환율에서 넘길때는 Split Code 넣지 않음 2009-11-27 김현화수석
			//환율에서 넘길때도  Split Code 넣음 2010-04-28 김현화수석
			//if(!cancelInvoiceVO.getUiType().equals("E")){
				invArMnVO.setInvSplitCd("X");				
			//}else{
			//	invArMnVO.setInvSplitCd("");	
			//}
			invArMnVO.setInvDeltDivCd("X");
			invArMnVO.setBlInvCfmDt("");			
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2010-12-06 Cancel시 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			dbDao.addInvMain(invArMnVO);
			
			String acct_div_cd = dbDao.searchAccountDivision(revTpCd + revSrcCd);			
			
			//String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			String revCoaVslCd = "";
			String revCoaVoyNo = "";
			String revCoaSkdDirCd = "";
			String revCoaDirCd = "";
			
			// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산
			// INV_AR_MN 에서 ifNo 로 구해온 act_cust_cnt_cd 와 act_cust_seq 로 inv_coa_inter_co_cd 를 가져와 setting
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());
			
			for (int i = 0; i < invArChgVOs.size(); i++) {	
				
				String invRevTpSrcCd = "";
				String tjSrcNm = "";
				String acctCd = "";
				String revCoaAcctCd = "";
				String loclChgAcctCd = "";
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				//invArChgVOs.get(i).setChgAmt(Float.toString(Float.parseFloat(invArChgVOs.get(i).getChgAmt()) * -1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());	
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);		
				
				if(revTpCd.equals("M")&&revSrcCd.equals("RD")){
					invArChgVOs.get(i).setAcctCd(invArChgVOs.get(i).getAcctCd());	
					invArChgVOs.get(i).setRevCoaAcctCd(invArChgVOs.get(i).getRevCoaAcctCd()); 	
				}else{
				
					//2010-05-03 김현화 수석
					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
					
					
					//2010-05-04 MRI 로직 추가 localcharge에서  RevCoaAcctCd 구하기 
					
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
					//if(revTpCd.equals("M")){
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START		
					
					String locCd ="";
					
					ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
					
					if(arOfcAttributeVO!=null){
						locCd = arOfcAttributeVO.getLocCd();
					}
					
					if("M".equals(revTpCd)||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
						loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());				
						
						//2010-06-09
						if (!loclChgAcctCd.equals("")) {
						
							invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd); 	
							if (loclChgAcctCd.equals("954117")) {			
								dbDao.modifyArOffstNo(newIfNo, invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
							}
						} 
					}
					//}
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
				
				}
				
				revCoaVslCd = invArMnVO.getRevVslCd().equals("")?"":invArMnVO.getRevVslCd();
				revCoaVoyNo = invArMnVO.getRevSkdVoyNo().equals("")?"":invArMnVO.getRevSkdVoyNo();
				revCoaSkdDirCd = invArMnVO.getRevSkdDirCd().equals("")?"":invArMnVO.getRevSkdDirCd();
				revCoaDirCd = invArMnVO.getRevDirCd().equals("")?"":invArMnVO.getRevDirCd();
				
				
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setArIfSerNo("1");
				invArChgVOs.get(i).setChgSeq(Integer.toString(i+1));
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");
				invArChgVOs.get(i).setRevCoaVslCd(revCoaVslCd);
				invArChgVOs.get(i).setRevCoaVoyNo(revCoaVoyNo);
				invArChgVOs.get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
				invArChgVOs.get(i).setRevCoaDirCd(revCoaDirCd);		
				
				tjSrcNm = dbDao.searchTjSrcNm(invArMnVO.getArOfcCd(),invArChgVOs.get(i).getChgCd(), revTpCd+revSrcCd, svrId);
				invArChgVOs.get(i).setTjSrcNm(tjSrcNm);

				
				if(invArChgVOs.get(i).getChgCd().equals("FAC")){
					invArChgVOs.get(i).setMfDivCd("N");
				}else{
					invArChgVOs.get(i).setMfDivCd("M");
				}
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
			}
			
			dbDao.addInvCharge(invArChgVOs);
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			//2012.02.09 기존에 있는 것을 invArChgVOs에도 set 하기 위해 위로 옮김 line 4281
			//String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());
			
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArIfNo(newIfNo);
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting -> 이 부분은 기존에 있었음 2012.02.09
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(newIfNo);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				}
			}

			
			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(glEffDt);
			

			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = "";
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					newIfNo = invArMnVO.getArIfNo();
				}
				
			} else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
				newIfNo = "";
			}	
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}
	
	/**
	 * Invoice Issue Interface Data  에 대한 New Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";		
		INVCommonUtil utilCmd = new INVCommonUtil();
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			//List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			/*
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}
			*/
			
			//2010-04-23 deadlock 에러 때문에 프로시져로 변경
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
//			newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
//			newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
				newIfNo = "LON"+ maxSeq ;
			}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
				newIfNo = "WRP"+ maxSeq ;
			}else{
				newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			
			invArChgVOs = dbDao.searchIssueInvoiceCharge ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			//invArAmtVOs = dbDao.searchIssueInvoiceAmount ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());			
			invArCntrVOs = dbDao.searchBKGContainerList(invArMnVO.getBkgNo());
			
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			
			//2010-04-02 Invoice Cust도 변경 0094
			if(cancelInvoiceVO.getUiType()!=null&&cancelInvoiceVO.getUiType().equals("C")){
				
				if(!cancelInvoiceVO.getActCustCntCd().equals("")&&!cancelInvoiceVO.getActCustSeq().equals("")){
					invArMnVO.setActCustCntCd(cancelInvoiceVO.getActCustCntCd());
					invArMnVO.setActCustSeq(cancelInvoiceVO.getActCustSeq());
				}
				
				if(!cancelInvoiceVO.getInvCustCntCd().equals("")&&!cancelInvoiceVO.getInvCustSeq().equals("")){
					invArMnVO.setInvCustCntCd(cancelInvoiceVO.getInvCustCntCd());
					invArMnVO.setInvCustSeq(cancelInvoiceVO.getInvCustSeq());
				}
			}
		
			String port = invArMnVO.getIoBndCd().equals("O")?invArMnVO.getPolCd():invArMnVO.getPodCd();
			String vvd = invArMnVO.getVslCd()+ invArMnVO.getSkdVoyNo()+invArMnVO.getSkdDirCd();
			
			String sailDt  = dbDao.searchSailingDate(invArMnVO.getBkgNo());
			if(sailDt.equals("")) sailDt = dbDao.searchSailingDateByVvd(invArMnVO.getVslCd(),invArMnVO.getSkdVoyNo(),invArMnVO.getSkdDirCd(), invArMnVO.getPolCd());
			invArMnVO.setSailDt(sailDt);
			
			String sailArrDt = utilCmd.searchSADate(vvd , port, invArMnVO.getIoBndCd());
						
			invArMnVO.setSailArrDt(sailArrDt);
			
			String znIocCd = dbDao.searchZoneIOC(invArMnVO.getPolCd(), invArMnVO.getPodCd());			
			
			//2010-04-20 REV VVD 구하는 로직 제거
			//RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(invArMnVO.getBkgNo());
			
			/*
			String revVvd = "";
			String rlaneCd = "";
			
			if(revVVDLaneVO != null){
				revVvd = revVVDLaneVO.getRevVvd();
				rlaneCd = revVVDLaneVO.getRlaneCd();				
			}
			
			if(revVvd.equals("X")){
				revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
				if(revVVDLaneVO != null){
					revVvd = revVVDLaneVO.getRevVvd();
					rlaneCd = revVVDLaneVO.getRlaneCd();
					znIocCd = znIocCd.equals("")?"OO":znIocCd;
				}
			}
			
			invArMnVO.setRlaneCd(rlaneCd);
			invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
			invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
			invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
			invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
			*/
			
			invArMnVO.setZnIocCd(znIocCd);
			
			String invRefNo = dbDao.searchInvRefNumber(invArMnVO.getBkgNo());
			
			invArMnVO.setInvRefNo(invRefNo);
			
			String revTpCd = "";
			String revSrcCd = "";
			
			if (cancelInvoiceVO.getRevTpCd().equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					revTpCd = "B";
					revSrcCd = "CS";
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					revTpCd = "C";
					revSrcCd = "CA";
				}
			} else {
				revTpCd = cancelInvoiceVO.getRevTpCd();
				revSrcCd = cancelInvoiceVO.getRevSrcCd();
			}
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			
			String glEffDt = dbDao.searchEffectiveDate(invArMnVO.getArOfcCd(), sailDt, revTpCd, revSrcCd);
			
			invArMnVO.setGlEffDt(glEffDt);
			
			/*
			DueDateInputVO dueDateInputVO = new DueDateInputVO();

			dueDateInputVO.setBnd(invArMnVO.getIoBndCd());
			dueDateInputVO.setCustCntCd(invArMnVO.getActCustCntCd());
			dueDateInputVO.setSaDt(sailArrDt);
			dueDateInputVO.setCustSeq(invArMnVO.getActCustSeq());
			dueDateInputVO.setOfcCd(invArMnVO.getArOfcCd());
			
			List<DueDateVO> dueDateVOs = dbDao.searchDueDate(dueDateInputVO);
			
			log.info("dueDateVOs.size()="+dueDateVOs.size());
			if (dueDateVOs.size() > 0) {
				log.info("dueDateVOs.getDueDt()="+dueDateVOs.get(0).getDueDt());
				log.info("dueDateVOs.getCustCrFlg()="+dueDateVOs.get(0).getCustCrFlg());
				log.info("dueDateVOs.getCrTermDys()="+dueDateVOs.get(0).getCrTermDys());
				invArMnVO.setDueDt(dueDateVOs.get(0).getDueDt());
				invArMnVO.setCustCrFlg(dueDateVOs.get(0).getCustCrFlg());
				invArMnVO.setCrTermDys(dueDateVOs.get(0).getCrTermDys());
			}
			*/
			
			//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			String arAgnStlCd ="";
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				locCd = arOfcAttributeVO.getLocCd();
				arCrdtVo.setLocCd(locCd.substring(0,2));
			}
						
			ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
			
			if(aRCreditVO != null){
				invArMnVO.setDueDt(aRCreditVO.getDueDt());
				invArMnVO.setCrTermDys(aRCreditVO.getCrTerm());
				invArMnVO.setCustCrFlg(aRCreditVO.getCrFlg());
			}
			
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START - LO CHG 관련 항목 초기화
			invArMnVO.setApArOffstNo("");
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
			
			//환율에서 넘길때는 Split Code 넣지 않음 2009-11-27 김현화수석
			//환율에서 넘길때도  Split Code 넣음 2010-04-28 김현화수석
			if(!cancelInvoiceVO.getUiType().equals("E")){
				invArMnVO.setInvSplitCd("C");
			}else{
				invArMnVO.setInvSplitCd("E");
			}
			invArMnVO.setInvDeltDivCd("N");	
			invArMnVO.setBlInvCfmDt("");
			
			//String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			String acct_div_cd = dbDao.searchAccountDivision(revTpCd + revSrcCd);
			
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			//ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			}
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			
			//2010.03.15 김현화수석
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			invArMnVO.setInvSvcScpCd(svrId.equals("EUR")||svrId.equals("KOR")||(svrId.equals("JPN")&&invArMnVO.getIoBndCd().equals("O"))?"OTH":invArMnVO.getInvSvcScpCd());
			
			//float invTtlLoclAmt = 0;
			
			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			
			//BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;

			String revCoaVslCd = "";
			String revCoaVoyNo = "";
			String revCoaSkdDirCd = "";
			String revCoaDirCd = "";
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String revCoaAcctCd ="";
				String acctCd = "";
				String invRevTpSrcCd = "";
				String tjSrcNm = "";
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);				
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setArIfSerNo("1");
				invArChgVOs.get(i).setChgSeq(Integer.toString(i+1));
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				
				tjSrcNm = dbDao.searchTjSrcNm(invArMnVO.getArOfcCd(),invArChgVOs.get(i).getChgCd(), revTpCd+revSrcCd, svrId);
				invArChgVOs.get(i).setTjSrcNm(tjSrcNm);

				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());

				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
				
				//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
				//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());
				//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

				//float chgAmt = Float.parseFloat(invArChgVOs.get(i).getChgAmt());
				//float exRate = Float.parseFloat(exchangeRateVo.getExRate());
				//invTtlLoclAmt += chgAmt * exRate;

				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");
				//2009-12-17 
				
				if(!revTpCd.equals("M")){
					if(invArChgVOs.get(i).getChgCd().equals("FAC")){
						invArChgVOs.get(i).setMfDivCd("N");
					}else{
						invArChgVOs.get(i).setMfDivCd("M");
					}	
				}
				//2010-01-04
				if (acct_div_cd.equals("P")) {
					acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
				} else {
					acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
				}
				
				acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
				
				revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
				
				revCoaVslCd = invArMnVO.getRevVslCd().equals("")?"":invArMnVO.getRevVslCd();
				revCoaVoyNo = invArMnVO.getRevSkdVoyNo().equals("")?"":invArMnVO.getRevSkdVoyNo();
				revCoaSkdDirCd = invArMnVO.getRevSkdDirCd().equals("")?"":invArMnVO.getRevSkdDirCd();
				revCoaDirCd = invArMnVO.getRevDirCd().equals("")?"":invArMnVO.getRevDirCd();
				
				invArChgVOs.get(i).setAcctCd(acctCd);	
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
				invArChgVOs.get(i).setRevCoaCoCd(invCoaCoCd);
				invArChgVOs.get(i).setRevCoaCtrCd(invCoaCtrCd);
				invArChgVOs.get(i).setRevCoaRgnCd(invCoaRgnCd);
				invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
				invArChgVOs.get(i).setRevCoaVslCd(revCoaVslCd);
				invArChgVOs.get(i).setRevCoaVoyNo(revCoaVoyNo);
				invArChgVOs.get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
				invArChgVOs.get(i).setRevCoaDirCd(revCoaDirCd);		
				
				//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
				// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START					
				if("M".equals(revTpCd)||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
					String loclChgAcctCd = "";
					loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());
					if (!loclChgAcctCd.equals("")) {
					    invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd);     
					    if (loclChgAcctCd.equals("954117")) {        
					        //dbDao.modifyArOffstNo(newIfNo, invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
					        invArMnVO.setApArOffstNo(invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
					    }
					}
				}
				//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
				
			}

			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			dbDao.addInvMain(invArMnVO);
			
			dbDao.addInvCharge(invArChgVOs);
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArIfNo(newIfNo);
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(newIfNo);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCntrSeq(Integer.toString(i+1));					
					invArCntrVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				}
			}
			
			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(glEffDt);

			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = "";
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					newIfNo = invArMnVO.getArIfNo();
				}				
				
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());	
				newIfNo = "";
			}	
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}
	
	/**
	 * Invoice Issue Interface Data  에 대한 New Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewMIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";		
		INVCommonUtil utilCmd = new INVCommonUtil();
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			/*
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}	
			*/
			
			//2010-04-23 deadlock 에러 때문에 프로시져로 변경
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
//			newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
//			newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
				newIfNo = "LON"+ maxSeq ;
			}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
				newIfNo = "WRP"+ maxSeq ;
			}else{
				newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			
			invArChgVOs = dbDao.searchIssueInvoiceCharge ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			invArAmtVOs = dbDao.searchIssueInvoiceAmount ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());	
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());
			
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			
			if(cancelInvoiceVO.getUiType()!=null&&cancelInvoiceVO.getUiType().equals("C")){
				invArMnVO.setActCustCntCd(cancelInvoiceVO.getActCustCntCd());
				invArMnVO.setActCustSeq(cancelInvoiceVO.getActCustSeq());
			}
			
			String glEffDt = dbDao.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd());
			
			invArMnVO.setGlEffDt(glEffDt);
			
			
			//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			arCrdtVo.setBlSrcNo(invArMnVO.getBlSrcNo());
			arCrdtVo.setRevSrcCd(invArMnVO.getRevSrcCd());
			
			String locCd ="";
			String arAgnStlCd ="";
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				locCd = arOfcAttributeVO.getLocCd();
				arCrdtVo.setLocCd(locCd.substring(0,2));
			}
						
			ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
			
			if(aRCreditVO != null){
				invArMnVO.setDueDt(aRCreditVO.getDueDt());
				invArMnVO.setCrTermDys(aRCreditVO.getCrTerm());
				invArMnVO.setCustCrFlg(aRCreditVO.getCrFlg());
			}
			
			String port = invArMnVO.getIoBndCd().equals("O")?invArMnVO.getPolCd():invArMnVO.getPodCd();
			String vvd = invArMnVO.getVslCd()+ invArMnVO.getSkdVoyNo()+invArMnVO.getSkdDirCd();
			
			String localTime = dbDao.searchLocalTime(invArMnVO.getArOfcCd());
			
			if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
					invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
				invArMnVO.setSailDt(invArMnVO.getSailDt());
				invArMnVO.setSailArrDt(invArMnVO.getSailArrDt());
			}else{
				//sailing dt BKGNo로
				String sailDt  = dbDao.searchSailingDate(invArMnVO.getBkgNo());
				
				//sailing dt 없으면 BlNo로			
				if(sailDt.equals("")) sailDt= dbDao.searchSailingDateByBlNo(invArMnVO.getBlSrcNo());
				
				//sailing dt 없으면 VVD Pol로		
				if(sailDt.equals("")) sailDt = dbDao.searchSailingDateByVvd(invArMnVO.getVslCd(),invArMnVO.getSkdVoyNo(),invArMnVO.getSkdDirCd(), invArMnVO.getPolCd());
				
				//sailing dt 없으면 VVD 해당 Port로		
				if(sailDt.equals("")) sailDt = dbDao.searchSailingDateByVvd(invArMnVO.getVslCd(),invArMnVO.getSkdVoyNo(),invArMnVO.getSkdDirCd(), port);
										
				if (invArMnVO.getVslCd().equals("CFDR") || invArMnVO.getVslCd().substring(0, 4).equals("USAC")) {
					sailDt = localTime;
				} 
				
				invArMnVO.setSailDt(sailDt.equals("")?invArMnVO.getSailDt():sailDt);
				
				String sailArrDt = utilCmd.searchSADate(vvd , port, invArMnVO.getIoBndCd());
				
				if (invArMnVO.getVslCd().equals("CFDR") || invArMnVO.getVslCd().substring(0, 4).equals("USAC")) {
					sailArrDt = localTime;
				} 
							
				invArMnVO.setSailArrDt(sailArrDt);
			}
			
			String znIocCd = dbDao.searchZoneIOC(invArMnVO.getPolCd(), invArMnVO.getPodCd());			
			
			//2010-04-20 REV VVD 구하는 로직 제거
			
			/*
			String tVslCd = "";
			
			MRIRevenueVVDLaneVO mriRevenueVVDLane = new MRIRevenueVVDLaneVO();
			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(vvd, invArMnVO.getPolCd(), invArMnVO.getSlanCd(), znIocCd);
			
			if (mriRevenueVVDLane!=null&&mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(vvd, invArMnVO.getPolCd(), invArMnVO.getSlanCd(), "OO"); 
			}
			
			if (mriRevenueVVDLane!=null&&mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(vvd, invArMnVO.getPolCd(), invArMnVO.getSlanCd());
			}
			
			if (mriRevenueVVDLane!=null&&mriRevenueVVDLane.getRevVvd().equals("")) {
				if (invArMnVO.getRevSrcCd().equals("RD")) {
					tVslCd = "CNTC";
				} else {
					tVslCd = vvd.substring(0, 4);
				}
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd);
			}
			
			String revVvd = mriRevenueVVDLane.getRevVvd();
			String rlaneCd = mriRevenueVVDLane.getRevLane();	
			
			invArMnVO.setRlaneCd(rlaneCd);
			invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
			invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
			invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
			invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");			
			*/
			
			invArMnVO.setZnIocCd(znIocCd);
			
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");			
			invArMnVO.setInvSplitCd("C");
			invArMnVO.setBlInvCfmDt("");
			invArMnVO.setInvDeltDivCd("N");	
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			}
			
			String acct_div_cd = dbDao.searchAccountDivision(revTpSrcCd);
			
			//2010.03.15 김현화수석
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			invArMnVO.setInvSvcScpCd(svrId.equals("EUR")||svrId.equals("KOR")||(svrId.equals("JPN")&&invArMnVO.getIoBndCd().equals("O"))?"OTH":invArMnVO.getInvSvcScpCd());
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
						
			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			//2010-04-27 blNo 추가
			vvdCustomerVo.setBlSrcNo(invArMnVO.getBlSrcNo());
			
			//BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			String revCoaVslCd = "";
			String revCoaVoyNo = "";
			String revCoaSkdDirCd = "";
			String revCoaDirCd = "";
			
			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			
			if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
					invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
				invArMnVO.setXchRtUsdTpCd("A");
				invArMnVO.setXchRtN3rdTpCd("A");
				
				String invXchRt = utilCmd.searchAccountRate("USD", invArMnVO.getLoclCurrCd(), localTime.length()==8?localTime.substring(0,6):"");
				invArMnVO.setUsdXchRt(invXchRt);
				invArMnVO.setXchRtDt("");
				invArMnVO.setObrdDt("");
			}
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			dbDao.addInvMain(invArMnVO);
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String revCoaAcctCd ="";
				String loclChgAcctCd = "";
				String acctCd = "";
				String invRevTpSrcCd = "";
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);				
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setArIfSerNo("1");
				invArChgVOs.get(i).setChgSeq(Integer.toString(i+1));
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());

				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());

				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
				
				//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
				//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());
				//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
				
				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				
				if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
						invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
					String invXchRt = utilCmd.searchAccountRate(invArChgVOs.get(i).getCurrCd(), invArMnVO.getLoclCurrCd(), localTime.length()==8?localTime.substring(0,6):"");
					invArChgVOs.get(i).setInvXchRt(invXchRt);
					invArChgVOs.get(i).setInvXchRtDt("");
				}
				
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");
				
				if(!invArMnVO.getRevTpCd().equals("M")){
					if(invArChgVOs.get(i).getChgCd().equals("FAC")){
						invArChgVOs.get(i).setMfDivCd("N");
					}else{
						invArChgVOs.get(i).setMfDivCd("M");
					}
				}
				
				if(!invArMnVO.getRevSrcCd().equals("RD")){
					//2010-01-04
					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd() , invArMnVO.getRevSrcCd(), svrId,  acctCd);
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd() , invArMnVO.getRevSrcCd(), svrId,  acctCd);
					
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
					
					//2010-04-23 MRI 로직 추가 localcharge에서  RevCoaAcctCd 구하기 
					loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());				
					
					//2010-06-09
					if (!loclChgAcctCd.equals("")) {			
						
						invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd); 
						if (loclChgAcctCd.equals("954117")) {			
							dbDao.modifyArOffstNo(newIfNo, invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
						}
					} 
				}else{
					invArChgVOs.get(i).setAcctCd(invArChgVOs.get(i).getAcctCd());	
					invArChgVOs.get(i).setRevCoaAcctCd(invArChgVOs.get(i).getRevCoaAcctCd()); 	
				}
				
				revCoaVslCd = invArMnVO.getRevVslCd().equals("")?"":invArMnVO.getRevVslCd();
				revCoaVoyNo = invArMnVO.getRevSkdVoyNo().equals("")?"":invArMnVO.getRevSkdVoyNo();
				revCoaSkdDirCd = invArMnVO.getRevSkdDirCd().equals("")?"":invArMnVO.getRevSkdDirCd();
				revCoaDirCd = invArMnVO.getRevDirCd().equals("")?"":invArMnVO.getRevDirCd();
				
//				log.debug("AcctCd===>"+invArChgVOs.get(i).getAcctCd());
//				log.debug("RevCoaAcctCd===>"+invArChgVOs.get(i).getRevCoaAcctCd());
//				log.debug("revCoaVslCd===>"+revCoaVslCd);
//				log.debug("revCoaVoyNo===>"+revCoaVoyNo);
//				log.debug("revCoaSkdDirCd===>"+revCoaSkdDirCd);
//				log.debug("revCoaDirCd===>"+revCoaDirCd);
				
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
				invArChgVOs.get(i).setRevCoaCoCd(invCoaCoCd);
				invArChgVOs.get(i).setRevCoaCtrCd(invCoaCtrCd);
				invArChgVOs.get(i).setRevCoaRgnCd(invCoaRgnCd);
				invArChgVOs.get(i).setRevCoaVslCd(revCoaVslCd);
				invArChgVOs.get(i).setRevCoaVoyNo(revCoaVoyNo);
				invArChgVOs.get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
				invArChgVOs.get(i).setRevCoaDirCd(revCoaDirCd);	
			}
			
			dbDao.addInvCharge(invArChgVOs);
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArIfNo(newIfNo);
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(newIfNo);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);	
					invArCntrVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				}
			}
			
			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(glEffDt);

			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
						
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = "";
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = invArMnVO.getArIfNo();
				}
				
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());	
				newIfNo = "";
			}	
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Invoice 의 Split 정보를 생성한다.<br>
	 * 
	 * @param ARInvoiceSplitVO invSplitVo
	 * @return String
	 * @exception EventException
	 */
	public String createSplitInvoice(ARInvoiceSplitVO invSplitVo) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		INVCommonUtil utilCmd = new INVCommonUtil();

		try {
			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			//List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;

			invArMnVOs = dbDao.searchARInvoice(invSplitVo.getIfNo());

			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			invArChgVOs = invSplitVo.getInvArChgVOs();
			//invArAmtVOs = invSplitVo.getInvArAmtVOs();
			invArCntrVOs = invSplitVo.getInvArCntrVOs();			
			
			invArMnVO.setOldArIfNo("");
			invArMnVO.setActCustCntCd(invSplitVo.getInvArMnVO().getActCustCntCd());
			invArMnVO.setActCustSeq(invSplitVo.getInvArMnVO().getActCustSeq());
			invArMnVO.setInvRmk(invSplitVo.getInvArMnVO().getInvRmk());
			//invArMnVO.setDueDt(invSplitVo.getInvArMnVO().getDueDt());
			//invArMnVO.setCustCrFlg(invSplitVo.getInvArMnVO().getCustCrFlg());
			//invArMnVO.setCrTermDys(invSplitVo.getInvArMnVO().getCrTermDys());
			invArMnVO.setInvRefNo(invSplitVo.getInvArMnVO().getInvRefNo());
			invArMnVO.setHjsStfCtnt(invSplitVo.getInvArMnVO().getHjsStfCtnt());
			invArMnVO.setBkgTeuQty(invSplitVo.getInvArMnVO().getBkgTeuQty());
			invArMnVO.setBkgFeuQty(invSplitVo.getInvArMnVO().getBkgFeuQty());
			invArMnVO.setArIfNo(invSplitVo.getInvArMnVO().getArIfNo());
			invArMnVO.setInvSplitCd("S");
			invArMnVO.setBlInvCfmDt("");			
			invArMnVO.setInvDeltDivCd("N");	
			
			if (invSplitVo.getInvArMnVO().getRevTpCd().equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					invArMnVO.setRevTpCd("B");
					invArMnVO.setRevSrcCd("CS");
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					invArMnVO.setRevTpCd("C");
					invArMnVO.setRevSrcCd("CA");
				}
			} else {
				
				if(invSplitVo.getInvArMnVO().getRevTpCd().equals("M")){
					invArMnVO.setRevTpCd(invArMnVO.getRevTpCd());
					invArMnVO.setRevSrcCd(invArMnVO.getRevSrcCd());
				}else{
					invArMnVO.setRevTpCd(invSplitVo.getInvArMnVO().getRevTpCd());
					invArMnVO.setRevSrcCd(invSplitVo.getInvArMnVO().getRevSrcCd());
				}
			}

			invArMnVO.setGlEffDt(invSplitVo.getInvArMnVO().getGlEffDt());
			invArMnVO.setCreUsrId(invSplitVo.getUserId());
			invArMnVO.setUpdUsrId(invSplitVo.getUserId());
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2010-01-07 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START - LO CHG 관련 항목 초기화
			invArMnVO.setApArOffstNo("");
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
			
			String localTime = dbDao.searchLocalTime(invArMnVO.getArOfcCd());
			
			//2009-11-30  Due Dt 구하는 로직 BKG IF 방식으로 변경
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			String arAgnStlCd ="";
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			
			if(arOfcAttributeVO!=null){
				locCd = arOfcAttributeVO.getLocCd();
				arCrdtVo.setLocCd(locCd.substring(0,2));
			}
						
			ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
			
			if(aRCreditVO != null){
				invArMnVO.setDueDt(aRCreditVO.getDueDt());
				invArMnVO.setCrTermDys(aRCreditVO.getCrTerm());
				invArMnVO.setCustCrFlg(aRCreditVO.getCrFlg());
			}
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			String acct_div_cd = dbDao.searchAccountDivision( invArMnVO.getRevTpCd() + invArMnVO.getRevSrcCd());
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			if(arOfcAttributeVO!=null){
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			}
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			
			//2010.03.15 김현화수석
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			invArMnVO.setInvSvcScpCd(svrId.equals("EUR")||svrId.equals("KOR")||(svrId.equals("JPN")&&invArMnVO.getIoBndCd().equals("O"))?"OTH":invArMnVO.getInvSvcScpCd());

			//float invTtlLoclAmt = 0;

			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			
			//BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			
			String revCoaVslCd = "";
			String revCoaVoyNo = "";
			String revCoaSkdDirCd = "";
			String revCoaDirCd = "";
			
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String invRevTpSrcCd = "";
				String tjSrcNm = "";
				String acctCd = "";
				String revCoaAcctCd = "";
				String loclChgAcctCd ="";				
				
				invArChgVOs.get(i).setCreUsrId(invSplitVo.getUserId());
				invArChgVOs.get(i).setUpdUsrId(invSplitVo.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);

				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());

				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
				
				//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
				//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());
				//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				
				if(invArMnVO.getRevTpCd().equals("M")){
					if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
							invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
						String invXchRt = utilCmd.searchAccountRate(invArChgVOs.get(i).getCurrCd(), invArMnVO.getLoclCurrCd(), localTime.length()==8?localTime.substring(0,6):"");
						invArChgVOs.get(i).setInvXchRt(invXchRt);
						invArChgVOs.get(i).setInvXchRtDt("");
					}
				}
				
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");
				
				if(invArChgVOs.get(i).getChgCd().equals("FAC")){
					invArChgVOs.get(i).setMfDivCd("N");
				}else{
					invArChgVOs.get(i).setMfDivCd("M");
				}	
				
				tjSrcNm = dbDao.searchTjSrcNm(invArMnVO.getArOfcCd(),invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd(), svrId);
				invArChgVOs.get(i).setTjSrcNm(tjSrcNm);
				
				if(invArMnVO.getRevTpCd().equals("M")&&invArMnVO.getRevSrcCd().equals("RD")){
					invArChgVOs.get(i).setAcctCd(invArChgVOs.get(i).getAcctCd());	
					invArChgVOs.get(i).setRevCoaAcctCd(invArChgVOs.get(i).getRevCoaAcctCd()); 	
				}else{
				
					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd() , invArMnVO.getRevSrcCd(), svrId,  acctCd);
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd() , invArMnVO.getRevSrcCd(), svrId,  acctCd);					
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
					
					//2010-05-04 MRI 로직 추가 localcharge에서  RevCoaAcctCd 구하기 
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
					//if(invArMnVO.getRevTpCd().equals("M")){
					// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START					
					if("M".equals(invArMnVO.getRevTpCd())||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
						loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());				
						
						if (!loclChgAcctCd.equals("")) {					
							invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd); 		
							
							if (loclChgAcctCd.equals("954117")) {			
								invArMnVO.setApArOffstNo(invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
							}
						} 	
					}
					//}
					//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
					
				}
				
				revCoaVslCd = invArMnVO.getRevVslCd().equals("")?"":invArMnVO.getRevVslCd();
				revCoaVoyNo = invArMnVO.getRevSkdVoyNo().equals("")?"":invArMnVO.getRevSkdVoyNo();
				revCoaSkdDirCd = invArMnVO.getRevSkdDirCd().equals("")?"":invArMnVO.getRevSkdDirCd();
				revCoaDirCd = invArMnVO.getRevDirCd().equals("")?"":invArMnVO.getRevDirCd();
				
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
				invArChgVOs.get(i).setRevCoaCoCd(invCoaCoCd);
				invArChgVOs.get(i).setRevCoaCtrCd(invCoaCtrCd);
				invArChgVOs.get(i).setRevCoaRgnCd(invCoaRgnCd);
				
				invArChgVOs.get(i).setRevCoaVslCd(revCoaVslCd);
				invArChgVOs.get(i).setRevCoaVoyNo(revCoaVoyNo);
				invArChgVOs.get(i).setRevCoaSkdDirCd(revCoaSkdDirCd);
				invArChgVOs.get(i).setRevCoaDirCd(revCoaDirCd);		
			}

			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			if(invArMnVO.getRevTpCd().equals("M")){
				if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
						invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
					invArMnVO.setXchRtUsdTpCd("A");
					invArMnVO.setXchRtN3rdTpCd("A");
					
					String invXchRt = utilCmd.searchAccountRate("USD", invArMnVO.getLoclCurrCd(), localTime.length()==8?localTime.substring(0,6):"");
					invArMnVO.setUsdXchRt(invXchRt);
					invArMnVO.setXchRtDt("");
					invArMnVO.setObrdDt("");
				}
			}
			
			dbDao.addInvCharge(invArChgVOs);
			
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(invArMnVO.getArIfNo());
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(invSplitVo.getUserId());
					invArAmtVOs.get(i).setUpdUsrId(invSplitVo.getUserId());	
				}
			}

			dbDao.addInvMain(invArMnVO);
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(invArMnVO.getArIfNo());
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setCreUsrId(invSplitVo.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(invSplitVo.getUserId());
				}
				dbDao.addInvContainer(invArCntrVOs, invSplitVo.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(invSplitVo.getInvArMnVO().getGlEffDt());
			
			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = invArMnVO.getArIfNo();
				}
				
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}	
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 하는 BackEndJob 호출 <br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException{
		//BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		//BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		String bkgNo = bkgIfVo.getBkgNo();
		String bkgSeq = "";
		String userId = bkgIfVo.getUserId();
		String bkgCorrNo = bkgIfVo.getBkgCorrNo()==null?"":bkgIfVo.getBkgCorrNo();
		String backEndJobKey = "";
		try {
			
			//2009-12-03 변경 Booking,Invoice 협의(17:30) 후 변경
			//Booking,SCG 에서 콜한 경우 2010-03-25 SCG추가
			if(bkgIfVo.getManDivInd().equals("B")||bkgIfVo.getManDivInd().equals("S")){	
				/*
				AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
				
				int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
				
				if(cntPpdOfc > 0){
					try{
						agtCalcToInvBC.createFACComm(bkgNo);
					} catch (Exception ex) {
						log.error("err " + ex.toString(), ex);
					}
				}				
				*/
				
				// 2011-10-26 BKG INTERFACE 시 누락되는 문제를 해결하기 위해 BKG PROCEDURE 를 CALL 해서 BKG_FUNC_PROC_LOG 테이블에 LOG 를 각각 남기도록 함
				dbDao.addBkgInvHis(bkgNo, "1");
				bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo, userId);
				dbDao.addBkgInvHis(bkgNo, "2");
				
				// Interface Table Insert 실패 시
				if (bkgSeq==null){
					
					if(bkgIfVo.getManDivInd().equals("B")){
						throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
					}else{						
						UserBC user= new UserBCImpl();
						
						String docUsrId = dbDao.searchBkgDocUsrId(bkgNo);
						List<ComUserInfoVO> rcvUserInfos = user.comUsrInfo(docUsrId);
						
						MessageUtil msess = new MessageUtil();                        

						String content = "Invoice interface error. Please retrieve booking '" + bkgNo + "' and click save.";
						String rcvUsrId = docUsrId; 
						String rcvUsrNm = rcvUserInfos.get(0).getUsrNm();
						String senderId = "SYSTEM";
						String senderNm = "SYSTEM";

						msess.messageInsert(senderNm, senderId, rcvUsrNm, rcvUsrId, content);						
					}
					
				//  Interface Table Insert 성공시 Backend job 실행
				}
				//2010-05-10 Batch 로 전환
				/*
				else{
					bkgIfVo.setBkgSeq(bkgSeq);
					
					bookingARCreationBackEndJob.setARBkgInterfaceCreationVO(bkgIfVo);
					bookingARCreationBackEndJob.setUiType("B");
					
					backEndJobKey = backEndJobManager.execute(bookingARCreationBackEndJob, bkgIfVo.getUserId(), "interfaceBKGARInvoiceToINV");
					
					//dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "", backEndJobKey, bkgIfVo.getUserId());
				}
				*/
			}
			
			return backEndJobKey;
		
		} catch (EventException ex) {			
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Kor Wharfage에서 발생한 매출채권 정보를 Interface  <br>
	 * 
	 * @param String vvdCd
	 * @param String whfBndCd
	 * @param String portCd
	 * @param String userId
	 * @param String whfDeclCxlFlg
	 * @exception EventException
	 */
	public void interfaceWHFARInvoiceToINV( String vvdCd, String whfBndCd, String portCd, String userId , String whfDeclCxlFlg) throws EventException{
		String result = "";
		try {
			result = dbDao.addInvBkgWhfIf( vvdCd, whfBndCd, portCd, userId, whfDeclCxlFlg);
			// Interface Table Insert 실패 시
			if (result.equals("")||result.equals("F")){					
				throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());					
			}	
		
		} catch (EventException ex) {			
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 하는 BackEndJob List 호출 <br>
	 * 
	 * @param List<ARBkgInterfaceCreationVO> bkgIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(List<ARBkgInterfaceCreationVO> bkgIfVos) throws EventException{
		//BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		//BackEndJobManager backEndJobManager = new BackEndJobManager();
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		
		String bkgNo = "";
		//String bkgSeq = "";
		String userId = "";
		String bkgCorrNo = "";
		String backEndJobKey = "";
		try {
			
			//2009-12-03 변경 Booking,Invoice 협의(17:30) 후 변경
			//Booking 에서 콜한 경우 또는 BkgNo로만  콜한 경우	(unmatch revenue)		
			//List<ARBkgInterfaceCreationVO> bkgInterfaceVos = new ArrayList<ARBkgInterfaceCreationVO>();
			List<ARBkgInterfaceCreationVO> uniqueARBkgIfVOs = new ArrayList<ARBkgInterfaceCreationVO>();
			
			List<String> listBkgNoUnique = new ArrayList<String>(); 
			
			// IF 대상 리스트의 중복을 제거한다.
			if (bkgIfVos != null && bkgIfVos.size() > 0) {
				for (int l=0; l<bkgIfVos.size(); l++) {
					//log.error("listBkgNoUnique.contains(String.valueOf(bkgIfVos.get(l).getBkgNo()))="+listBkgNoUnique.contains(String.valueOf(bkgIfVos.get(l).getBkgNo())));			
					
					if (!listBkgNoUnique.contains(String.valueOf(bkgIfVos.get(l).getBkgNo())) && !bkgIfVos.get(l).getBkgNo().equals("")) {						
						listBkgNoUnique.add(bkgIfVos.get(l).getBkgNo());						
						uniqueARBkgIfVOs.add(bkgIfVos.get(l));
					}
				}
			}
			
			//log.error("UniqueARBkgIfVOs.size()="+UniqueARBkgIfVOs.size());			
			
			
			for (int i = 0; i< uniqueARBkgIfVOs.size(); i++ ){
				bkgNo = uniqueARBkgIfVOs.get(i).getBkgNo();	
				userId = uniqueARBkgIfVOs.get(i).getUserId();	
				bkgCorrNo = uniqueARBkgIfVOs.get(i).getBkgCorrNo()==null?"":uniqueARBkgIfVOs.get(i).getBkgCorrNo();	
				if(uniqueARBkgIfVOs.get(i).getManDivInd().equals("B")||uniqueARBkgIfVOs.get(i).getManDivInd().equals("M")){
					/*
					AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
					
					int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
					
					if(cntPpdOfc > 0){
						try{
							agtCalcToInvBC.createFACComm(bkgNo);
						} catch (Exception ex) {
							log.error("err " + ex.toString(), ex);
						}
					}		
					*/
					
					// 2011-10-26 BKG INTERFACE 시 누락되는 문제를 해결하기 위해 BKG PROCEDURE 를 CALL 해서 BKG_FUNC_PROC_LOG 테이블에 LOG 를 각각 남기도록 함
					dbDao.addBkgInvHis(bkgNo, "3");
					//bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo ,userId);
					dbDao.addInvBkgIf(bkgNo, bkgCorrNo ,userId);
					dbDao.addBkgInvHis(bkgNo, "4");
					
					//2010-05-10 Batch 로 전환
					/*
					if (bkgSeq!=null){
						ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();	
						
						bkgIfVo.setBkgNo(bkgNo);
						bkgIfVo.setBkgSeq(bkgSeq);
						bkgIfVo.setUserId(userId);
						bkgIfVo.setManDivInd(uniqueARBkgIfVOs.get(i).getManDivInd());
						bkgIfVo.setBkgDiv(uniqueARBkgIfVOs.get(i).getBkgDiv()!=null?uniqueARBkgIfVOs.get(i).getBkgDiv():null);
						
						bkgInterfaceVos.add(bkgIfVo);
					}
					*/
					
					//Unmatch Rev 관련 2009-12-02
					if(uniqueARBkgIfVOs.get(i).getBkgDiv()!=null&&uniqueARBkgIfVOs.get(i).getBkgDiv().equals("U")){
						command.modifyBKGInterfaceFlag(uniqueARBkgIfVOs.get(i).getBkgNo());
					}
				}
				
			}
			
			//2010-05-10 Batch 로 전환
			/*
			bookingARCreationBackEndJob.setARBkgInterfaceCreationVOs(bkgInterfaceVos);
			bookingARCreationBackEndJob.setUiType("L");
			
			if(bkgInterfaceVos!=null && bkgInterfaceVos.size()>0){
				backEndJobKey =  backEndJobManager.execute(bookingARCreationBackEndJob, userId, "interfaceBKGARInvoiceToINVList");
			}
			*/
			
			//2010.03.10 JobId Update
			/*
			for (int i = 0; i< bkgInterfaceVos.size(); i++ ){
				dbDao.modifyInvArIfStatus(bkgInterfaceVos.get(i).getBkgNo(), bkgInterfaceVos.get(i).getBkgSeq(), "", backEndJobKey, bkgInterfaceVos.get(i).getUserId());
			}
			*/
			
			return backEndJobKey;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 받고, ERP AR 에 필요한 속성들을 생성한다.<br>
	 * B/L 의 매출채권 정보를 Bound 별로 각각의 AR Office 에 따라 History 방식으로 생성하고<br>
	 * ERP AR 에서 필요한 COA 등의 정보를 생성한다. <br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException{
		
		//AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		
		try {
			String bkgNo = bkgIfVo.getBkgNo();
			String bkgSeq = "";
			String bkgUserId = bkgIfVo.getUserId();
			String userId = "BKG I/F"; // 2009.12.22 이상희과장 userid 일괄 통일
			String bkgCorrNo = "";
			int updCnt = 0;
			
			// BkgNo로만  콜한 경우(Manual Interface 화면)
			if(bkgIfVo.getManDivInd().equals("M")&&bkgIfVo.getBkgSeq().equals("")){
				/*
				int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
				
				if(cntPpdOfc > 0){
					createFACComm(bkgNo);			
				}	
				*/
				
				//IF Table Insert			
				bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo, bkgUserId);
				if (bkgSeq==null){					
					throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
				}	
				 
				return null;
			
			//Manual Interface 화면 BKG 에서 넘어온 경우 넘겨준 BKG_SEQ 세팅
			}else{
				bkgSeq = bkgIfVo.getBkgSeq();
			}
			
			
			int oldBkgCnt = Integer.parseInt(dbDao.searchOldBkgCnt(bkgNo));

			if(oldBkgCnt > 0) {
			    dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "OLD BOOKING", bkgUserId);
			    return null;
			}


			
			//2010-05-07 프로시져 로직 java에서 수행 FAC 생성
			//AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
			
			int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
			
			if(cntPpdOfc > 0){
				createFACComm(bkgNo);
				
				BkgOfcPayIndVO bkgOfcPayIndVO = dbDao.searchEurPpdOfc( bkgNo );
				
				dbDao.addInvBkgIfFacChg( bkgNo, bkgSeq, bkgOfcPayIndVO.getOfcCd(), bkgOfcPayIndVO.getCustCntCd(), bkgOfcPayIndVO.getCustSeq() );
			}
				
			//FAC 생성 End
			
			BLNoBKGStatusVO bLNoBKGStatusVO = dbDao.searchBLNoByBKGNo(bkgNo,bkgSeq);
			
			if( bLNoBKGStatusVO == null){
				dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "There is no data for BKG I/F", bkgUserId);
			} else {			
				if(bLNoBKGStatusVO.getBlSrcNo().equals("")||bLNoBKGStatusVO.getCxlFlg().equals("")||bLNoBKGStatusVO.getBkgStsCd().equals("")){				
					if(bLNoBKGStatusVO.getBlSrcNo().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "Mandatory field is missing (BL_SRC_NO)", bkgUserId);
					} else if (bLNoBKGStatusVO.getCxlFlg().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "Mandatory field is missing (BKG CANCEL FLAG)", bkgUserId);
					} else if (bLNoBKGStatusVO.getBkgStsCd().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "Mandatory field is missing (BKG STATUS CODE)", bkgUserId);
					}
					//throw new EventException(new ErrorHandler("INV00013", new String[] {}).getMessage());
				} else {
					
					List<InvArIfNoVO> mainIfNos = new ArrayList<InvArIfNoVO>();
					
					String blSrcNo = bLNoBKGStatusVO.getBlSrcNo();
					String autoMnlDivCd = bLNoBKGStatusVO.getAutoMnlDivCd();
					String chnAgnCd = bLNoBKGStatusVO.getChnAgnCd();					
					
					dbDao.searchMaxInterfaceForUpdate(bLNoBKGStatusVO.getBlSrcNo());
					
					//Inv 쪽 비교 대상인 Max IF Main data
					List<MaxIFMainVO> maxIFMainVOs = dbDao.searchMaxInterfaceList(bLNoBKGStatusVO.getBlSrcNo());
					
					// 2011.10.14 [CHM-201113333] INV_BKG_IF_CHG에서 BKG OFC 를 MDM 의 A/R OFC 로 1:1 로 구한다
					List<BkgOfcPayIndVO> bkgOfcPayIndVOsTmp = dbDao.searchBKGOfficeList(bkgNo,bkgSeq);
					
					// 2011.10.14 [CHM-201113333] APLS INV내 INTERFACE로직 보완 요청 
					if (bkgOfcPayIndVOsTmp != null && bkgOfcPayIndVOsTmp.size() != 0) {
						for (int i = 0; i < bkgOfcPayIndVOsTmp.size(); i++) {
							
							// CutOffLane의 파라미터로 MDM OfcCD를 가져온다
							String arOfcCode = bkgOfcPayIndVOsTmp.get(i).getMArOfcCd();
							String ioBndCode = bkgOfcPayIndVOsTmp.get(i).getIoBndCd();
							String chgSeq = bkgOfcPayIndVOsTmp.get(i).getChgSeq();
							
							// CUT OFF LANE 정보를 구하기 위해 필요한 VVD, PORT, S/A DT 를 구한다
							VvdLanePortVO vvdLanePortVO = searchVVDForNewInterface( bkgNo, bkgSeq, ioBndCode, bkgOfcPayIndVOsTmp.get(i).getOfcCd());
							
							String vvdCode = "";
							String portCode = "";
							String saDate ="";
							
							if(vvdLanePortVO != null) {
								vvdCode = vvdLanePortVO.getVvd();
								portCode = vvdLanePortVO.getPortCd();
								saDate =  vvdLanePortVO.getSailArrDt();
							}
							
						    // BKG OFC 로 MDM 의 A/R OFC 를 구한 다음 CUT OFF LANE 정보를 찾아서 최종 INV 에 생성할 A/R OFC 를 결정한다
						    // CUT OFF LANE 정보에 해당 A/R OFC 가 있으면 CUT OFF LANE 의 A/R OFC 가 INV 의 A/R OFC 로 되고
						    // CUT OFF LANE 정보에 해당 A/R OFC 가 없으면 MDM 의 A/R OFC 가 INV 의 A/R OFC 로 된다
							ArOfcApplDtVO arOfcApplDtVO =  dbDao.searchCutOffLaneOffice(arOfcCode, vvdCode, ioBndCode, portCode, saDate);
							
							//[2013.03.18]
							//MDM에 삭제된 Office의 경우 searchCutOffLaneOffice 에서 구하지 못함.
							//CUT OFF LANE에 등록되어있는지 한번 더 체크하여, A/R Office를 구한다.
							//CUT OFF LANE에 등록되어 있으면 등록된 Office를 A/R Office로 한다.
							String checkedCutOffArOfcCd = dbDao.searchCheckCutOffLaneOffice(arOfcCode,ioBndCode);
							if(!checkedCutOffArOfcCd.equals("") && checkedCutOffArOfcCd !=null){
								arOfcApplDtVO.setArOfcCd(checkedCutOffArOfcCd);
							}
							
							// CutOffLane을 통한 ArOfcCd가 존재하면 CutOffLane의 ArOfcCd를, 존재하지 않으면 MDM OfcCd로 BKG테이블의 AR_OFC_CD를 update한다.
							String cutOffArOfcCd = arOfcApplDtVO.getArOfcCd()!=null&&!arOfcApplDtVO.getArOfcCd().equals("")?arOfcApplDtVO.getArOfcCd():arOfcCode; 
							//log.debug("cutOffArOfcCd = "+cutOffArOfcCd );
							
							
							//[2013.01.16]
							//DBXXX Office의 경우 이전에 CutOff Lane에 등록되어 AR Office가 DOHBA로 결정되었으나, CutOff Lane이 삭제됨에 따라서 
							//DOHBA가 아닌 DXBSC로 AR Office가 결정됨. 따라서 CutOff Lane이 삭제된 이후에는 DBXXX로 결정됨.
							//그러나 삭제 이전에 발생한 BL에 대해서 CA가 발생하면,  삭제이전의 AR Office를 따라야 하기때문에,
							//DXBSC의 경우 최근 I/F 된 AR Office가 DXBSC 인지 DOHBA 인지 Check가 필요함.
							//아래 로직은 가장 최근 I/F 된 AR Office가 DXBSC 인지 DOHBA 인지 Check 하는 Query임. 
							if("DXBSC".equals(cutOffArOfcCd)){
								String oldCutOffArOfc = dbDao.searchOldCutOffLaneOffice(bLNoBKGStatusVO.getBlSrcNo());							
							    
								if(!oldCutOffArOfc.equals("")){
									cutOffArOfcCd = oldCutOffArOfc;
								}
							}
							
						    // INV_BKG_IF_CHG 테이블의  AR_OFC_CD 컬럼을 업데이트한다
						    // BKG OFC MERGE 를 위해서 INV_BKG_IF_CHG 테이블에 AR_OFC_CD 컬럼을 추가함 (2011.10.14)
							dbDao.modifyBKGChgOffice(cutOffArOfcCd,bkgNo,bkgSeq,chgSeq);
						}
					} 			
					// CutOffLane을 통한 ArOfcCd가 존재하면 CutOffLane의 ArOfcCd를, 존재하지 않으면 MDM OfcCd로 BKG데이타를 취득한다.
				    // 기존에는 BKG OFC 로 SELECT 하던것을 위에서 최종 반영된 INV_BKG_IF_CHG 의 AR_OFC_CD 로 SELECT 한다
				    // (주의) 변수명은 OFC_CD 이지만 실제 값은 AR_OFC_CD 임
					List<BkgOfcPayIndVO> bkgOfcPayIndVOs = dbDao.searchBKGOfficeAsCutOffList(bkgNo,bkgSeq);
					//log.debug("bkgOfcPayIndVOs = "+bkgOfcPayIndVOs.size() );
					
					//Booking Cancel Flag = 'Y'
					if(bLNoBKGStatusVO.getCxlFlg().equals("Y")||bkgOfcPayIndVOs.size()==0){
						for(int i=0;i< maxIFMainVOs.size();i++){
							
							//Booking Cancel Flag = 'Y' 일때 이행 데이터 처리 (최근 이행 날짜 2010-01-09 이전 데이터, 새로 이행시 날짜 수정필요)
							//int ifDt = Integer.parseInt(maxIFMainVOs.get(i).getBlInvIfDt());
							//이행데이터 기준 오피스별 로컬타임 때문에 old_ar_if_no 있는걸로 변경 2010-03-21
							String oldArIfNo = maxIFMainVOs.get(i).getOldArIfNo();
							
							//Migration Data Cancel Start ==============================================================================================						
							if(!oldArIfNo.equals("")&&!maxIFMainVOs.get(i).getArOfcCd().equals("LEHSC")){
								
								List<MaxIFMainVO> migIFVOs = dbDao.searchMigInterfaceList(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd());
								
								for(int j=0;j< migIFVOs.size();j++){
									//Delete Division Code = 'N'  
									if(!migIFVOs.get(j).getInvDeltDivCd().equals("Y")){
										
										//Good Date IS NOT NULL
										if(!migIFVOs.get(j).getBlInvCfmDt().equals("")){
											String cancelIfNo = "";
											
											//A/R Office 가 한국지역인 경우
											if(migIFVOs.get(j).getLocCd().equals("KR")){
												int cnt = dbDao.checkDecWHF(migIFVOs.get(j).getArIfNo());
												
												//Dec WHF 존재하는 경우
												if(cnt>0){
													cancelIfNo = createMaxIFCancel(migIFVOs.get(j).getArIfNo(),"Y", userId,"N");
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												
												//Dec WHF 존재하지 않는 경우
												}else{
													cancelIfNo = createMaxIFCancel(migIFVOs.get(j).getArIfNo(),"N", userId,"N");
													
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												}								
												
											//A/R Office 가 한국이외 지역인 경우	
											}else{
												cancelIfNo = createMaxIFCancel(migIFVOs.get(j).getArIfNo(),"N",userId,"N");
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											}
											
											updCnt = dbDao.modifySysClearFlag(migIFVOs.get(j).getArIfNo(),cancelIfNo, userId);
											
											//SysClear 된 대상 ifNo 도 ERP전송
											if(updCnt==2){
												InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
												mainIfNoVo.setIfNo(migIFVOs.get(j).getArIfNo());
												mainIfNos.add(mainIfNoVo);
											}
											
											// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
											// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
											// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
											// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
											dbDao.modifySysClearFlagForBLType(migIFVOs.get(j).getArIfNo(),cancelIfNo, userId);
													
										//Good Date IS NULL	
										}else if(migIFVOs.get(j).getBlInvCfmDt().equals("")){
											dbDao.modifyDelCode(migIFVOs.get(j).getArIfNo(), userId);
										}
									}
								}
								
							//Migration Data Cancel End ===============================================================================================	
								
							} else {

								//Delete Division Code = 'N'  
								if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
									
									//Good Date IS NOT NULL
									if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
										String cancelIfNo = "";
										
										//A/R Office 가 한국지역인 경우
										if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
											int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
											
											//Dec WHF 존재하는 경우
											if(cnt>0){
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", userId,"N");
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											
											//Dec WHF 존재하지 않는 경우
											}else{
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", userId,"N");
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											}								
											
										//A/R Office 가 한국이외 지역인 경우	
										}else{
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N",userId,"N");
											
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										}
										//2009-12-01 IF후 한꺼번에 처리하는 로직으로 변경 김현화 수석
										updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
										
										//2009-12-28 SysClear 된 대상 ifNo 도 ERP전송
										if(updCnt==2){
											InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
											mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
											mainIfNos.add(mainIfNoVo);
										}
										
										// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
										// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
										// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
										// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
										dbDao.modifySysClearFlagForBLType(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
										
										//2009-12-04 다시 원복 이상희  과장
										/*
										SysClearVO sysClearVo = new SysClearVO();
										
										sysClearVo.setOfcCd(maxIFMainVOs.get(i).getArOfcCd());
										sysClearVo.setBlNo(blSrcNo);							
										sysClearVo.setUserId(userId);
										sysClearVo.setVvdCd("");
										sysClearVo.setCustCd("");
		
										modifySysClearList(sysClearVo);
										*/
									//Good Date IS NULL	
									}else if(maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
										dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
									}
								}
							}
						}
						
						if(bLNoBKGStatusVO.getCxlFlg().equals("Y")){
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", "Cancel Success", bkgUserId);
						}else{
							if(maxIFMainVOs.size()>0){
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", "Cancel Success", bkgUserId);
							}else{
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", "charge data is missing", bkgUserId);
							}
						}
						
					//Booking Cancel Flag = 'N'	
					}else{
						
						List<ARInvoiceCreationVO> invCreVos = new ArrayList<ARInvoiceCreationVO>();				
						//List<BkgOfcPayIndVO> bkgOfcPayIndVOs = dbDao.searchBKGOfficeList(bkgNo,bkgSeq);
						
						String arCtrlOfcCd = "";
						String arOfcCd = "";
						String subAgnFlg = "";
						String vvd = "";
						String portCd = "";
						String sailArrDt = "";
						String actCustCntCd = "";
						String actCustSeq = "";
						String invCustCntCd = "";
						String invCustSeq= "";
						String slanCd = "";
						String svcScpCd = "";
						String revVvd = "";
						String rlaneCd ="";
						String sailDt = "";
						String arCurrCd = "";
						String polCd = "";
						String podCd = "";
						String porCd = "";
						String delCd = "";
						String locCd = "";
						String arHdQtrOfcCd = "";
						String arAgnStlCd = "";
						String znIocCd = "";
						
						if(bkgOfcPayIndVOs.size()==0){
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", "charge data is missing", bkgUserId);
							return null;
						}
						
						// INV_BKG_IF_CHG 의 A/R OFC 갯수만큼 LOOPING
						for(int i=0; i <bkgOfcPayIndVOs.size();i++){
							ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
							InvArMnVO invArMnVO = new InvArMnVO();
							
							VvdLanePortVO vvdLanePortVO = searchVVDForNewInterface( bkgNo, bkgSeq, bkgOfcPayIndVOs.get(i).getIoBndCd(), bkgOfcPayIndVOs.get(i).getOfcCd());
							
							vvd = vvdLanePortVO.getVvd();
							portCd = vvdLanePortVO.getPortCd();
							sailArrDt = vvdLanePortVO.getSailArrDt();
							slanCd = vvdLanePortVO.getSlanCd();
							svcScpCd = vvdLanePortVO.getSvcScpCd();
							revVvd = vvdLanePortVO.getRevVvd();
							rlaneCd = vvdLanePortVO.getRlaneCd();
							sailDt = vvdLanePortVO.getSailDt();
							polCd = vvdLanePortVO.getPolCd();
							podCd = vvdLanePortVO.getPodCd();
							porCd = vvdLanePortVO.getPorCd();
							delCd = vvdLanePortVO.getDelCd();
							znIocCd = vvdLanePortVO.getZnIocCd();
							
							if((slanCd!=null&&slanCd.equals("")) || slanCd==null ){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "slan_cd is missing", bkgUserId);
								return null;
							}
							
							if((svcScpCd!=null&&svcScpCd.equals("")) || svcScpCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "svc_scp_cd is missing", bkgUserId);
								return null;
							}
							
							if((vvd!=null&&vvd.equals("")) || vvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "vvd is missing", bkgUserId);
								return null;
							}
							
							if((polCd!=null&&polCd.equals("")) || polCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "pol_cd is missing", bkgUserId);
								return null;
							}
							
							if((podCd!=null&&podCd.equals("")) || podCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "pod_cd is missing", bkgUserId);
								return null;
							}
							
							
							
							//2009-11-26 김현화 수석 rev vvd , rlane cd 없으면 에러 처리
							if((revVvd!=null&&revVvd.equals("")) || revVvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "rev_vvd is missing", bkgUserId);
								return null;
							}
							
							if((rlaneCd!=null&&rlaneCd.equals("")) || rlaneCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "rlane_cd is missing", bkgUserId);
								return null;
							}
							
							
							CutOffLaneVO cutOffLaneVO = new CutOffLaneVO();
							cutOffLaneVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							cutOffLaneVO.setOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							cutOffLaneVO.setPortCd(portCd);
							cutOffLaneVO.setVvd(vvd);
							cutOffLaneVO.setSailArrDt(sailArrDt);
							
							ArOfficeVO arOfficeVO = searchAROfficeList(cutOffLaneVO);					
							arCtrlOfcCd = arOfficeVO.getArCtrlOfcCd();
							arOfcCd = arOfficeVO.getArOfcCd();
							subAgnFlg = arOfficeVO.getSubAgnFlg();
							arCurrCd = arOfficeVO.getArCurrCd();
							locCd =  arOfficeVO.getLocCd();
							arHdQtrOfcCd = arOfficeVO.getArHdQtrOfcCd();
							arAgnStlCd = arOfficeVO.getArAgnStlCd();//ofc_agent_mark						
							
							if((arOfcCd!=null&&arOfcCd.equals("")) || arOfcCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", bkgOfcPayIndVOs.get(i).getOfcCd() + "'s ar_ofc_cd is missing", bkgUserId);
								return null;
							}
							
							if((arCurrCd!=null&&arCurrCd.equals("")) || arCurrCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "arCurrCd is missing", bkgUserId);
								return null;
							}
								
							CustInputVO custInputVO = new CustInputVO();
							custInputVO.setBkgNo(bkgNo);
							custInputVO.setBkgSeq(bkgSeq);
							custInputVO.setBlSrcNo(blSrcNo);
							custInputVO.setCustCntCd(bkgOfcPayIndVOs.get(i).getCustCntCd());
							custInputVO.setCustSeq(bkgOfcPayIndVOs.get(i).getCustSeq());
							custInputVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							custInputVO.setArCtrlOfcCd(arCtrlOfcCd);
							custInputVO.setAutoMnlDivCd(autoMnlDivCd);
							custInputVO.setN3rdFlg(bkgOfcPayIndVOs.get(i).getN3rdFlg());
							custInputVO.setArOfcCd(arOfcCd);
							custInputVO.setVvd(vvd);
							custInputVO.setPortCd(portCd);
							custInputVO.setSubAgnFlg(subAgnFlg);
							custInputVO.setChnAgnCd(chnAgnCd);
							custInputVO.setOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							custInputVO.setPolCd(polCd);
							custInputVO.setPodCd(podCd);
							custInputVO.setPorCd(porCd);
							custInputVO.setDelCd(delCd);
							
							ActInvCustVO actInvCustVO = searchCustomerCode(custInputVO);
							
							actCustCntCd = actInvCustVO.getActCustCntCd();
							actCustSeq = actInvCustVO.getActCustSeq();
							invCustCntCd = actInvCustVO.getInvCustCntCd();
							invCustSeq= actInvCustVO.getInvCustSeq();
							
							int actCustCnt = dbDao.checkCustomer(actCustCntCd, actCustSeq);
							
							int invCustCnt = dbDao.checkCustomer(invCustCntCd, invCustSeq);
							
							if(actCustCnt == 0 ){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "Invalid Customer = "+actCustCntCd+actCustSeq, bkgUserId);
								// return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if(invCustCnt == 0 ){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", "Invalid Customer = "+invCustCntCd+invCustSeq, bkgUserId);
								// return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							if((actCustCntCd!=null&&actCustCntCd.equals("")) || actCustCntCd==null){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq() + "'s act_cust_cnt_cd is missing", bkgUserId);
								// return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((actCustSeq!=null&&actCustSeq.equals("")) || actCustSeq==null){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq() + "'s act_cust_seq is missing", bkgUserId);
								// return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((invCustCntCd!=null&&invCustCntCd.equals("")) || invCustCntCd==null){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", bkgNo + "'s inv_cust_cnt_cd is missing", bkgUserId);
								// return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							if((invCustSeq!=null&&invCustSeq.equals("")) || invCustSeq==null){
								// dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", bkgNo + "'s inv_cust_seq is missing", bkgUserId);
								// return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							
							String svrId = dbDao.searchServerID(arOfcCd);
							
							//20110401 [CHM-201109252] Collection Office 설정 Logic 변경 START
							/*
							ARCreditInputVO arCrdtVo = new ARCreditInputVO();
							arCrdtVo.setActCustCntCd(actCustCntCd);
							arCrdtVo.setActCustSeq(actCustSeq);
							arCrdtVo.setSailArrDt(sailArrDt);
							arCrdtVo.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							arCrdtVo.setDestTrnsSvcModCd("");
							arCrdtVo.setArOfcCd(arOfcCd);
							arCrdtVo.setLocCd(locCd);
							arCrdtVo.setDelCd(delCd);
							
							ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
							
							String custCrFlg = "";
							String erpIfOfcCd = "";
							
							if(aRCreditVO != null) {
								custCrFlg = aRCreditVO.getCrFlg();
							}
							
							if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&custCrFlg.equals("Y")){								
								if(actCustCntCd.equals("US")||actCustCntCd.equals("CA")){				
									erpIfOfcCd = dbDao.searchCrCltOffice(actCustCntCd, actCustSeq);
								}								
							}else if(svrId.equals("KOR")&&actCustCntCd.equals("KR")){
								if(custCrFlg.equals("Y")){
									erpIfOfcCd = dbDao.searchCrCltOffice(actCustCntCd, actCustSeq);
								}else if(bkgOfcPayIndVOs.get(i).getIoBndCd().equals("I")&&custCrFlg.equals("N")){
									erpIfOfcCd = dbDao.searchKrIbOffice(actCustCntCd, actCustSeq);
								}
							}
							*/
							//20110401 [CHM-201109252] Collection Office 설정 Logic 변경 END
							
							//2010-01-13 CHG 별로 GROUP BY 한 SUM 금액을 가져오지 않고 BKG에서 넘어온 그대로 사용. 이상희 과장
							List<InvBkgIfChgVO> invBkgIfChgVOs = dbDao.searchInvoiceChargeList(bkgNo, bkgSeq, bkgOfcPayIndVOs.get(i).getOfcCd(), bkgOfcPayIndVOs.get(i).getIoBndCd(), bkgOfcPayIndVOs.get(i).getN3rdFlg());
							
							
							List<InvArChgVO> invArChgVOs = new ArrayList<InvArChgVO>();					
							
							for(int j=0; j< invBkgIfChgVOs.size();j++){	
								
								InvArChgVO  invArChgVO = new InvArChgVO();
								String tvaFlg = "N";								
								
								//2010.01.05 TVA_FLG 관련 로직 추가
								// BOMSC 의 경우  O/B - OTH, OIH, CFR, ITR, CYR  I/B - DTH, DIH, CFD, ITR, CLN, CLC 는 TVA_FLG = Y
								//2011.07.11 박성진 [CHM-201112159] 요청으로 BOMSC 의 O/B CHG CD = 'SLF' 추가
								//2012.7.31 BOMSC 바운드 조건 삭제 
								//2016.06.30  MVC 추가
								//2016.07.06  MUC 추가
								
								if(arOfcCd.equals("BOMSC")){
//									if (bkgOfcPayIndVOs.get(i).getIoBndCd().equals("O") && (
//											invBkgIfChgVOs.get(j).getChgCd().equals("BCC")||invBkgIfChgVOs.get(j).getChgCd().equals("BLR")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMC")||invBkgIfChgVOs.get(j).getChgCd().equals("CMS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CSR")||invBkgIfChgVOs.get(j).getChgCd().equals("CTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DAR")||invBkgIfChgVOs.get(j).getChgCd().equals("DHF")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DDF")||invBkgIfChgVOs.get(j).getChgCd().equals("DIV")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DMR")||invBkgIfChgVOs.get(j).getChgCd().equals("DRC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DTC")||invBkgIfChgVOs.get(j).getChgCd().equals("DTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DVC")||invBkgIfChgVOs.get(j).getChgCd().equals("EIS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("EMS")||invBkgIfChgVOs.get(j).getChgCd().equals("ENS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("EPS")||invBkgIfChgVOs.get(j).getChgCd().equals("ETC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("ICS")||invBkgIfChgVOs.get(j).getChgCd().equals("IHC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("MCF")||invBkgIfChgVOs.get(j).getChgCd().equals("MIS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("NFC")||invBkgIfChgVOs.get(j).getChgCd().equals("NMS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OAR")||invBkgIfChgVOs.get(j).getChgCd().equals("OBS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OTR")||invBkgIfChgVOs.get(j).getChgCd().equals("OTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("PCS")||invBkgIfChgVOs.get(j).getChgCd().equals("SMC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("SOC")||invBkgIfChgVOs.get(j).getChgCd().equals("TSC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("WHF")||invBkgIfChgVOs.get(j).getChgCd().equals("OTH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OIH")||invBkgIfChgVOs.get(j).getChgCd().equals("CFR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("ITR")||invBkgIfChgVOs.get(j).getChgCd().equals("CYR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("SLF")||invBkgIfChgVOs.get(j).getChgCd().equals("INF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DTH")||invBkgIfChgVOs.get(j).getChgCd().equals("DIH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CFD")||invBkgIfChgVOs.get(j).getChgCd().equals("ITR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CLN")||invBkgIfChgVOs.get(j).getChgCd().equals("CLC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("PIF")||invBkgIfChgVOs.get(j).getChgCd().equals("INF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMR")||invBkgIfChgVOs.get(j).getChgCd().equals("OCH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DCH")||invBkgIfChgVOs.get(j).getChgCd().equals("CCL")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMF")||invBkgIfChgVOs.get(j).getChgCd().equals("NMC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CHC")||invBkgIfChgVOs.get(j).getChgCd().equals("CAM")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("MDA")||invBkgIfChgVOs.get(j).getChgCd().equals("LBP")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("IDS")||invBkgIfChgVOs.get(j).getChgCd().equals("TAD")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CIF")||invBkgIfChgVOs.get(j).getChgCd().equals("MCF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("AFR")||invBkgIfChgVOs.get(j).getChgCd().equals("OCR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("NST")||invBkgIfChgVOs.get(j).getChgCd().equals("DHC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("APS")||invBkgIfChgVOs.get(j).getChgCd().equals("GOH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("MVC")||invBkgIfChgVOs.get(j).getChgCd().equals("IFR"))){	
//									        tvaFlg = "Y";
//									 }else if (bkgOfcPayIndVOs.get(i).getIoBndCd().equals("I") && (
//											invBkgIfChgVOs.get(j).getChgCd().equals("BCC")||invBkgIfChgVOs.get(j).getChgCd().equals("BLR")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMC")||invBkgIfChgVOs.get(j).getChgCd().equals("CMS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CSR")||invBkgIfChgVOs.get(j).getChgCd().equals("CTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DAR")||invBkgIfChgVOs.get(j).getChgCd().equals("DHF")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DDF")||invBkgIfChgVOs.get(j).getChgCd().equals("DIV")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DMR")||invBkgIfChgVOs.get(j).getChgCd().equals("DRC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DTC")||invBkgIfChgVOs.get(j).getChgCd().equals("DTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DVC")||invBkgIfChgVOs.get(j).getChgCd().equals("EIS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("EMS")||invBkgIfChgVOs.get(j).getChgCd().equals("ENS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("EPS")||invBkgIfChgVOs.get(j).getChgCd().equals("ETC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("ICS")||invBkgIfChgVOs.get(j).getChgCd().equals("IHC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("MCF")||invBkgIfChgVOs.get(j).getChgCd().equals("MIS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("NFC")||invBkgIfChgVOs.get(j).getChgCd().equals("NMS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OAR")||invBkgIfChgVOs.get(j).getChgCd().equals("OBS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OTR")||invBkgIfChgVOs.get(j).getChgCd().equals("OTS")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("PCS")||invBkgIfChgVOs.get(j).getChgCd().equals("SMC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("SOC")||invBkgIfChgVOs.get(j).getChgCd().equals("TSC")||	
//									        invBkgIfChgVOs.get(j).getChgCd().equals("WHF")||invBkgIfChgVOs.get(j).getChgCd().equals("OTH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OIH")||invBkgIfChgVOs.get(j).getChgCd().equals("CFR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("ITR")||invBkgIfChgVOs.get(j).getChgCd().equals("CYR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("SLF")||invBkgIfChgVOs.get(j).getChgCd().equals("INF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DTH")||invBkgIfChgVOs.get(j).getChgCd().equals("DIH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CFD")||invBkgIfChgVOs.get(j).getChgCd().equals("ITR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CLN")||invBkgIfChgVOs.get(j).getChgCd().equals("CLC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("PIF")||invBkgIfChgVOs.get(j).getChgCd().equals("INF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMR")||invBkgIfChgVOs.get(j).getChgCd().equals("OCH")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("DCH")||invBkgIfChgVOs.get(j).getChgCd().equals("CCL")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CMF")||invBkgIfChgVOs.get(j).getChgCd().equals("NMC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CHC")||invBkgIfChgVOs.get(j).getChgCd().equals("CAM")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("MDA")||invBkgIfChgVOs.get(j).getChgCd().equals("LBP")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("IDS")||invBkgIfChgVOs.get(j).getChgCd().equals("TAD")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("CIF")||invBkgIfChgVOs.get(j).getChgCd().equals("MCF")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("AFR")||invBkgIfChgVOs.get(j).getChgCd().equals("OCR")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("NST")||invBkgIfChgVOs.get(j).getChgCd().equals("DHC")||
//									        invBkgIfChgVOs.get(j).getChgCd().equals("OFT")||invBkgIfChgVOs.get(j).getChgCd().equals("BUC")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("LSF")||invBkgIfChgVOs.get(j).getChgCd().equals("CAF")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("BAF")||invBkgIfChgVOs.get(j).getChgCd().equals("WSC")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("ACT")||invBkgIfChgVOs.get(j).getChgCd().equals("FRC")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("FRS")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("PSC")||invBkgIfChgVOs.get(j).getChgCd().equals("EFS")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("FAF")||invBkgIfChgVOs.get(j).getChgCd().equals("GRI")||
//											invBkgIfChgVOs.get(j).getChgCd().equals("TXS")||invBkgIfChgVOs.get(j).getChgCd().equals("DIS"))){	
//									 		tvaFlg = "Y";
//								 		}
									String ioBnd_t = bkgOfcPayIndVOs.get(i).getIoBndCd();
									String chgCd_t = invBkgIfChgVOs.get(j).getChgCd();
									tvaFlg = dbDao.searchTvaFlg(arOfcCd, ioBnd_t,chgCd_t );
									
								}
								
								//LEHSC 2010.01.14
								if(arOfcCd.equals("LEHSC")){
									if(bkgOfcPayIndVOs.get(i).getIoBndCd().equals("O")){
										if(invBkgIfChgVOs.get(j).getChgCd().equals("SRC")){
											tvaFlg = "Y";
										}
									}else if(bkgOfcPayIndVOs.get(i).getIoBndCd().equals("I")){
										if(invBkgIfChgVOs.get(j).getChgCd().equals("DIH")&&invBkgIfChgVOs.get(j).getDeTermCd().equals("H")&&invBkgIfChgVOs.get(j).getAutoRatCd().equals("I")){
											tvaFlg = "Y";
										}
									}
								}							
								
								invArChgVO.setTvaFlg(tvaFlg);      
								
								invArChgVO.setChgCd(invBkgIfChgVOs.get(j).getChgCd());
								invArChgVO.setCurrCd(invBkgIfChgVOs.get(j).getCurrCd());
								invArChgVO.setPerTpCd(invBkgIfChgVOs.get(j).getPerTpCd());
								invArChgVO.setTrfRtAmt(invBkgIfChgVOs.get(j).getTrfRtAmt());
								invArChgVO.setRatAsCntrQty(invBkgIfChgVOs.get(j).getRatAsCntrQty());
								invArChgVO.setChgAmt(invBkgIfChgVOs.get(j).getChgAmt());
								invArChgVO.setInvXchRt(invBkgIfChgVOs.get(j).getInvXchRt());
								invArChgVO.setTrfNo(invBkgIfChgVOs.get(j).getTrfNo());
								
								if(invBkgIfChgVOs.get(j).getChgCd().equals("FAC")){
									invArChgVO.setMfDivCd("N");
								}else{
									invArChgVO.setMfDivCd("M");
								}						
								
								invArChgVO.setWhfFlg(invBkgIfChgVOs.get(j).getWhfFlg());
								
								invArChgVOs.add(invArChgVO);
							}
							invArMnVO.setArOfcCd(arOfcCd);
							invArMnVO.setIoBndCd(bkgOfcPayIndVOs.get(i).getIoBndCd());
							invArMnVO.setLoclCurrCd(arCurrCd);
							invArMnVO.setVslCd(vvd.substring(0,4));
							invArMnVO.setSkdVoyNo(vvd.substring(4,8));
							invArMnVO.setSkdDirCd(vvd.substring(8,9));
							invArMnVO.setActCustCntCd(actCustCntCd);
							invArMnVO.setActCustSeq(actCustSeq);
							invArMnVO.setInvCustCntCd(invCustCntCd);
							invArMnVO.setInvCustSeq(invCustSeq);
							invArMnVO.setPolCd(polCd);
							invArMnVO.setPodCd(podCd);
							invArMnVO.setBkgNo(bkgNo);
							invArMnVO.setBlSrcNo(blSrcNo);
							invArMnVO.setSlanCd(slanCd);
							invArMnVO.setSvcScpCd(svcScpCd);
							// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
							invArMnVO.setInvSvcScpCd(svrId.equals("EUR")||svrId.equals("KOR")||(svrId.equals("JPN")&&bkgOfcPayIndVOs.get(i).getIoBndCd().equals("O"))?"OTH":svcScpCd);
							invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
							invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
							invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
							invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
							invArMnVO.setRlaneCd(rlaneCd);
							invArMnVO.setSailDt(sailDt);
							invArMnVO.setSailArrDt(sailArrDt);
							invArMnVO.setZnIocCd(znIocCd);
							//Rose의 searchSalesOffice ( bkgNo , bnd )를 빼고, Booking 에서 넘겨준 Ofc를 세팅
							invArMnVO.setSlsOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							invArMnVO.setInvOrgOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							
							InvArMnVO teuFeu = dbDao.searchBkgIfTeuFeu(bkgNo,bkgSeq);
							
							invArMnVO.setBkgTeuQty(teuFeu.getBkgTeuQty());
							invArMnVO.setBkgFeuQty(teuFeu.getBkgFeuQty());	
							invArMnVO.setBkgCorrNo(teuFeu.getBkgCorrNo());	
							
							invCreVo.setInvArMnVO(invArMnVO);
							invCreVo.setInvArChgVOs(invArChgVOs);
							invCreVo.setLocCd(locCd);
							invCreVo.setArHdQtrOfcCd(arHdQtrOfcCd);
							invCreVo.setArAgnStlCd(arAgnStlCd);
							invCreVos.add(invCreVo);
						}				
						
						int invCreFlgCnt = 0;
						String cntrDiv = "N";
						
						//[Max I/F 1...n] For
						for( int i = 0; i< maxIFMainVOs.size(); i++ ){
							int divCnt = 0;				
							int ofcDivCnt = 0;	
							String vvdTrnsFlg = "N";	
							
							//[신규 I/F 1...n] For
							for( int j = 0; j < invCreVos.size(); j++ ){
								
								//Max I/F 의 A/R Office 와 신규 I/F 의 A/R Office 가 같은 경우
								if(maxIFMainVOs.get(i).getArOfcCd().equals(invCreVos.get(j).getInvArMnVO().getArOfcCd())){
									ofcDivCnt = ofcDivCnt + 1;
									
									invCreVos.get(j).getInvArMnVO().setRvsChgFlg(maxIFMainVOs.get(i).getRvsChgFlg());								
									
									
									//Max I/F 의 A/R Office 와 신규 I/F 의 A/R Office 가 같은 경우 이행 데이터 처리 (최근 이행 날짜 2010-01-09 이전 데이터, 새로 이행시 날짜 수정필요)
									//int ifDt = Integer.parseInt(maxIFMainVOs.get(i).getBlInvIfDt());
									//이행데이터 기준 오피스별 로컬타임 때문에 old_ar_if_no 있는걸로 변경 2010-03-21
									String oldArIfNo = maxIFMainVOs.get(i).getOldArIfNo();
									
									//Migration Data Cancel Start ==============================================================================================						
									if(!oldArIfNo.equals("")&&!maxIFMainVOs.get(i).getArOfcCd().equals("LEHSC")){
										
										//Max I/F 의 Delete Division Code = 'N' 인 경우
										if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
											
											//Max I/F 의 Good Date IS NOT NULL 인 경우
											if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
												
												// VVD, Service Scope, Lane, POL(POD), Revenue VVD, Revenue Lane, Charge Type, Per Type, Currency, Rate, Rated As, Amount, Exchange Rate
												if(!maxIFMainVOs.get(i).getVvdCd().equals(invCreVos.get(j).getInvArMnVO().getVslCd()+invCreVos.get(j).getInvArMnVO().getSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getSkdDirCd())){
													vvdTrnsFlg = "Y";
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getActCustCntCd().equals(invCreVos.get(j).getInvArMnVO().getActCustCntCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getActCustSeq().equals(invCreVos.get(j).getInvArMnVO().getActCustSeq())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getSvcScpCd().equals(invCreVos.get(j).getInvArMnVO().getSvcScpCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getSlanCd().equals(invCreVos.get(j).getInvArMnVO().getSlanCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getPolCd().equals(invCreVos.get(j).getInvArMnVO().getPolCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getPodCd().equals(invCreVos.get(j).getInvArMnVO().getPodCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getRevVvdCd().equals(invCreVos.get(j).getInvArMnVO().getRevVslCd()+invCreVos.get(j).getInvArMnVO().getRevSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getRevSkdDirCd()+invCreVos.get(j).getInvArMnVO().getRevDirCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getRlaneCd().equals(invCreVos.get(j).getInvArMnVO().getRlaneCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getIoBndCd().equals(invCreVos.get(j).getInvArMnVO().getIoBndCd())){
													divCnt = divCnt+1;
												}								
												
												int whfDeclNoCnt = 0;
												String whfChk = "";
												
												if(invCreVos.get(j).getLocCd().substring(0,2).equals("KR")){
													//BKG에서 넘어온 같은 Whf Decl No 가 있는지 체크
													whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(bLNoBKGStatusVO.getBlSrcNo(), maxIFMainVOs.get(i).getArOfcCd(),bLNoBKGStatusVO.getWhfDeclNo());
													
													whfChk = whfDeclNoCnt>0?"Y":"N";												
													
													//비교항목 추가 2010-03-19
													if(!bLNoBKGStatusVO.getWhfDeclNo().equals("")&&whfChk.equals("N")){
														divCnt = divCnt+1;
													}
												}	
												
												//Charge 비교로직 추가 2010-04-14
												List<MaxIFChgeVO> compIFChgeVOs = dbDao.compareBkgIFMigChargeList(bkgNo, bkgSeq, invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk, maxIFMainVOs.get(i).getArOfcCd());
												
												log.debug("compIFChgeVOs.size() = "+compIFChgeVOs.size());
												
												if(compIFChgeVOs.size()>0){
													divCnt = divCnt+1;
												}
												
												//Inv 쪽 비교 대상인 Chg Sum Data
												List<MaxIFChgeVO> maxIFChgeVOs = dbDao.searchChargeListForMigInterface(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd(), whfChk); 
												
												//BKG 쪽 비교 대상인 Chg data
												List<InvBkgIfChgVO> bkgIFChgeVOs = dbDao.searchInvoiceIfMigChargeList(bkgNo,bkgSeq,invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk);
												
												//String svrId = dbDao.searchServerID(invCreVos.get(j).getInvArMnVO().getArOfcCd());
												
												/*2010-03-15
												//[Server ID = 'EUR', Charge Indicator = 'P']
												if(svrId.equals("EUR")&&invCreVos.get(j).getInvArMnVO().getIoBndCd().equals("O")){
													   
													List<InvBkgIfChgVO> invFACChgVOs = dbDao.searchInvoiceFACCharge(bkgNo,invCreVos.get(j).getInvArMnVO().getSlsOfcCd());
													if(invFACChgVOs.size()>0){
														bkgIFChgeVOs.addAll(invFACChgVOs);
													}
												}			
												*/
												int chgDivCnt = 0;	
												
												//Charge 항목 비교
												for(int k=0;k< maxIFChgeVOs.size();k++){
													for(int l=0;l< bkgIFChgeVOs.size();l++){
														
														if(maxIFChgeVOs.get(k).getChgCd().equals(bkgIFChgeVOs.get(l).getChgCd())&&
																maxIFChgeVOs.get(k).getCurrCd().equals(bkgIFChgeVOs.get(l).getCurrCd())&&
																		maxIFChgeVOs.get(k).getPerTpCd().equals(bkgIFChgeVOs.get(l).getPerTpCd())&&
																			maxIFChgeVOs.get(k).getTrfRtAmt().equals(bkgIFChgeVOs.get(l).getTrfRtAmt())&&
																				maxIFChgeVOs.get(k).getRatAsCntrQty().equals(bkgIFChgeVOs.get(l).getRatAsCntrQty())){
															
															chgDivCnt = chgDivCnt + 1;
															
															log.debug("chgMigDivCnt1 = "+chgDivCnt +" : " +maxIFChgeVOs.get(k).getChgCd());
															
															
															if(!maxIFChgeVOs.get(k).getChgAmt().equals(bkgIFChgeVOs.get(l).getChgAmt())){
																divCnt = divCnt+1;
															}
														}
													}
												}
												
												if(chgDivCnt==0&&maxIFChgeVOs.size()>0){
													divCnt = divCnt+1;
												}
												
												// [2012.09.24]-Charge 항목비교시 동일 chage가 들어 있을경우에 Dup Check 한 Count(chgDivCnt)가 maxIFChgeVOs.size 보다 클수 있다.
												// 따라서 Dup Check Count가 maxIFChgeVOs.size 보다 작을경우에만 Invoice로 I/F 가능하도록 한다.												
												if(chgDivCnt<maxIFChgeVOs.size()){
													divCnt = divCnt+1;
												}										
												
												if(maxIFChgeVOs.size()!=bkgIFChgeVOs.size()){
													divCnt = divCnt+1;
												}
												
												log.debug("maxIFMigChgeVOs.size() = "+maxIFChgeVOs.size());
												log.debug("bkgIFMigChgeVOs.size() = "+bkgIFChgeVOs.size());	
												log.debug("chgMigDivCnt = "+chgDivCnt);
												
												//Max I/F 와 New I/F 의 VVD, Charge 항목들을 비교하여 하나라도 다른경우									
												if(divCnt>0){											
													invCreVos.get(j).setInvCreFlg("Y");
													invCreFlgCnt = invCreFlgCnt + 1;
												
												//[다른 항목 없으면]
												}else{
													invCreVos.get(j).setInvCreFlg("N");
												}
												
											//Max I/F 의 Good Date IS NULL 인 경우	
											}else{
												divCnt = divCnt+1;
												invCreVos.get(j).setInvCreFlg("Y");
												invCreFlgCnt = invCreFlgCnt + 1;
											}
										
										//Max I/F 의 Delete Division Code = 'X' 인 경우
										}else if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("X")){
											divCnt = divCnt+1;
											invCreVos.get(j).setInvCreFlg("Y");
											invCreFlgCnt = invCreFlgCnt + 1;
										}
										
										log.debug("divCnt = "+divCnt);
										
										if(divCnt>0){	
											List<MaxIFMainVO> migIFVOs = dbDao.searchMigInterfaceList(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd());
											
											for(int k=0;k< migIFVOs.size();k++){
												//Delete Division Code = 'N','X' 인 경우 이행데이터는 다 Cancel 처리
												if(migIFVOs.get(k).getInvDeltDivCd().equals("N")||migIFVOs.get(k).getInvDeltDivCd().equals("X")){
													
													// Good Date IS NOT NULL 인 경우
													if(!migIFVOs.get(k).getBlInvCfmDt().equals("")){
														String cancelIfNo = "";
														
														//A/R Office 가 한국지역인 경우
														if(migIFVOs.get(k).getLocCd().equals("KR")){
															int cnt = dbDao.checkDecWHF(migIFVOs.get(k).getArIfNo());
															
															
															//Dec WHF 존재하는 경우
															if(cnt>0){
																cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"Y", userId, vvdTrnsFlg);
																
																if(!cancelIfNo.equals("")){
																	InvArIfNoVO ifNo = new InvArIfNoVO();
																	ifNo.setIfNo(cancelIfNo);
																	ifNos.add(ifNo);
																}
															
															//Dec WHF 존재하지 않는 경우
															}else{
																cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"N", userId, vvdTrnsFlg);
																
																if(!cancelIfNo.equals("")){
																	InvArIfNoVO ifNo = new InvArIfNoVO();
																	ifNo.setIfNo(cancelIfNo);
																	ifNos.add(ifNo);
																}
															}											
														
														//A/R Office 가 한국이외 지역인 경우
														}else{
															cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"N", userId, vvdTrnsFlg);
															
															if(!cancelIfNo.equals("")){
																InvArIfNoVO ifNo = new InvArIfNoVO();
																ifNo.setIfNo(cancelIfNo);
																ifNos.add(ifNo);
															}
														}
														//2009-12-01 IF후 한꺼번에 처리하는 로직으로 변경 김현화 수석
														updCnt = dbDao.modifySysClearFlag(migIFVOs.get(k).getArIfNo(),cancelIfNo, userId);
														
														//2009-12-28 SysClear 된 대상 ifNo 도 ERP전송
														if(updCnt==2){
															InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
															mainIfNoVo.setIfNo(migIFVOs.get(k).getArIfNo());
															mainIfNos.add(mainIfNoVo);
														}
													
														// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
														// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
														// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
														// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
														dbDao.modifySysClearFlagForBLType(migIFVOs.get(k).getArIfNo(),cancelIfNo, userId);
															
													// Good Date IS NULL 인 경우	
													} else {
														dbDao.modifyDelCode(migIFVOs.get(k).getArIfNo(), userId);
													}
												}
											}
										}
										
									//Migration Data Cancel End ==============================================================================================
									} else {
									
										//Max I/F 의 Delete Division Code = 'N' 인 경우
										if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
											
											//Max I/F 의 Good Date IS NOT NULL 인 경우
											if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
												
												// VVD, Service Scope, Lane, POL(POD), Revenue VVD, Revenue Lane, Charge Type, Per Type, Currency, Rate, Rated As, Amount, Exchange Rate
												if(!maxIFMainVOs.get(i).getVvdCd().equals(invCreVos.get(j).getInvArMnVO().getVslCd()+invCreVos.get(j).getInvArMnVO().getSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getSkdDirCd())){
													vvdTrnsFlg = "Y";
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getActCustCntCd().equals(invCreVos.get(j).getInvArMnVO().getActCustCntCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getActCustSeq().equals(invCreVos.get(j).getInvArMnVO().getActCustSeq())){
													divCnt = divCnt+1;
												}												
												if(!maxIFMainVOs.get(i).getSvcScpCd().equals(invCreVos.get(j).getInvArMnVO().getSvcScpCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getSlanCd().equals(invCreVos.get(j).getInvArMnVO().getSlanCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getPolCd().equals(invCreVos.get(j).getInvArMnVO().getPolCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getPodCd().equals(invCreVos.get(j).getInvArMnVO().getPodCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getRevVvdCd().equals(invCreVos.get(j).getInvArMnVO().getRevVslCd()+invCreVos.get(j).getInvArMnVO().getRevSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getRevSkdDirCd()+invCreVos.get(j).getInvArMnVO().getRevDirCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getRlaneCd().equals(invCreVos.get(j).getInvArMnVO().getRlaneCd())){
													divCnt = divCnt+1;
												}
												if(!maxIFMainVOs.get(i).getIoBndCd().equals(invCreVos.get(j).getInvArMnVO().getIoBndCd())){
													divCnt = divCnt+1;
												}										
												if(!maxIFMainVOs.get(i).getBkgTeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgTeuQty())||!maxIFMainVOs.get(i).getBkgFeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgFeuQty())){
													cntrDiv = "Y";
												}		
												
												int whfDeclNoCnt = 0;
												String whfChk = "";
												
												log.debug("invCreVos.get(j).getLocCd().substring(0,2)="+invCreVos.get(j).getLocCd().substring(0,2));
												
												if(invCreVos.get(j).getLocCd().substring(0,2).equals("KR")){
													//BKG에서 넘어온 같은 Whf Decl No 가 있는지 체크
													whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(bLNoBKGStatusVO.getBlSrcNo(), maxIFMainVOs.get(i).getArOfcCd(),bLNoBKGStatusVO.getWhfDeclNo());
													
													log.debug("whfDeclNoCnt="+whfDeclNoCnt);
													
													whfChk = whfDeclNoCnt>0?"Y":"N";
													
													log.debug("whfChk="+whfChk);		
													
													//비교항목 추가 2010-03-19
													if(!bLNoBKGStatusVO.getWhfDeclNo().equals("")&&whfChk.equals("N")){
														divCnt = divCnt+1;
													}
													
													//2010-12-06 WHF CANCEL 되었을때 
													if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
														divCnt = divCnt+1;
													}
												}
												
												//Charge 비교로직 추가 2010-04-14
												List<MaxIFChgeVO> compIFChgeVOs = dbDao.compareBkgIFChargeList(bkgNo, bkgSeq, invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk, maxIFMainVOs.get(i).getArOfcCd());
												
												log.debug("compIFChgeVOs.size() = "+compIFChgeVOs.size());
												
												if(compIFChgeVOs.size()>0){
													divCnt = divCnt+1;
												}
												
												//Inv 쪽 비교 대상인 Max IF Chg data
												List<MaxIFChgeVO> maxIFChgeVOs = dbDao.searchChargeListForMaxInterface(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd(), whfChk); 
												
												//2009.12.31 FAC금액 때문에 비교대상 변경 2010-01-13 이상희 과장
												//BKG 쪽 비교 대상인 Chg data
												List<InvBkgIfChgVO> bkgIFChgeVOs = dbDao.searchInvoiceIfChargeList(bkgNo,bkgSeq,invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk);
												
												//String svrId = dbDao.searchServerID(invCreVos.get(j).getInvArMnVO().getArOfcCd());
												
												/*2010-03-15
												//[Server ID = 'EUR', Charge Indicator = 'P']
												if(svrId.equals("EUR")&&invCreVos.get(j).getInvArMnVO().getIoBndCd().equals("O")){
													   
													List<InvBkgIfChgVO> invFACChgVOs = dbDao.searchInvoiceFACCharge(bkgNo,invCreVos.get(j).getInvArMnVO().getSlsOfcCd());
													if(invFACChgVOs.size()>0){
														bkgIFChgeVOs.addAll(invFACChgVOs);
													}
												}	
												*/		
												
												int chgDivCnt = 0;	
												
												//Charge 항목 비교
												for(int k=0;k< maxIFChgeVOs.size();k++){
													for(int l=0;l< bkgIFChgeVOs.size();l++){														

														
														if(maxIFChgeVOs.get(k).getChgCd().equals(bkgIFChgeVOs.get(l).getChgCd())&&
																maxIFChgeVOs.get(k).getCurrCd().equals(bkgIFChgeVOs.get(l).getCurrCd())&&
																		maxIFChgeVOs.get(k).getPerTpCd().equals(bkgIFChgeVOs.get(l).getPerTpCd())&&
																			maxIFChgeVOs.get(k).getTrfRtAmt().equals(bkgIFChgeVOs.get(l).getTrfRtAmt())&&
																				maxIFChgeVOs.get(k).getRatAsCntrQty().equals(bkgIFChgeVOs.get(l).getRatAsCntrQty())){
															
															chgDivCnt = chgDivCnt + 1;
															
//															log.debug("maxChgAmt ==>"+maxIFChgeVOs.get(k).getChgAmt()+":bkgChgAmt==>"+bkgIFChgeVOs.get(l).getChgAmt()+"]");
															
															if(!maxIFChgeVOs.get(k).getChgAmt().equals(bkgIFChgeVOs.get(l).getChgAmt())){
																divCnt = divCnt+1;
															}
//															log.debug("divCnt==>"+divCnt);
														}
													}
												}
												
												if(chgDivCnt==0&&maxIFChgeVOs.size()>0){
													divCnt = divCnt+1;
												}
												
												// [2012.09.24]-Charge 항목비교시 동일 chage가 들어 있을경우에 Dup Check 한 Count(chgDivCnt)가 maxIFChgeVOs.size 보다 클수 있다.
												// 따라서 Dup Check Count가 maxIFChgeVOs.size 보다 작을경우에만 Invoice로 I/F 가능하도록 한다.			
												if(chgDivCnt<maxIFChgeVOs.size()){
													divCnt = divCnt+1;
												}								
												
												if(maxIFChgeVOs.size()!=bkgIFChgeVOs.size()){
													divCnt = divCnt+1;
												}
												
												//Max I/F 와 New I/F 의 VVD, Charge 항목들을 비교하여 하나라도 다른경우									
												if(divCnt>0){
													
													String cancelIfNo = "";
													
													//A/R Office 가 한국지역인 경우
													if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
														int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
														
														
														//Dec WHF 존재하는 경우
														if(cnt>0){
															cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", userId, vvdTrnsFlg);
															
															if(!cancelIfNo.equals("")){
																InvArIfNoVO ifNo = new InvArIfNoVO();
																ifNo.setIfNo(cancelIfNo);
																ifNos.add(ifNo);
															}
														
														//Dec WHF 존재하지 않는 경우
														}else{
															cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", userId, vvdTrnsFlg);
															
															if(!cancelIfNo.equals("")){
																InvArIfNoVO ifNo = new InvArIfNoVO();
																ifNo.setIfNo(cancelIfNo);
																ifNos.add(ifNo);
															}
														}											
													
													//A/R Office 가 한국이외 지역인 경우
													}else{
														cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", userId, vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													}
													//2009-12-01 IF후 한꺼번에 처리하는 로직으로 변경 김현화 수석
													updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
													
													//2009-12-28 SysClear 된 대상 ifNo 도 ERP전송
													if(updCnt==2){
														InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
														mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
														mainIfNos.add(mainIfNoVo);
													}
													
													// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
													// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
													// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
													// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
													dbDao.modifySysClearFlagForBLType(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
													
													//2009-12-04 다시 원복 이상희  과장
													/*
													SysClearVO sysClearVo = new SysClearVO();
													
													sysClearVo.setOfcCd(maxIFMainVOs.get(i).getArOfcCd());
													sysClearVo.setBlNo(blSrcNo);							
													sysClearVo.setUserId(userId);
													sysClearVo.setVvdCd("");
													sysClearVo.setCustCd("");
		
													modifySysClearList(sysClearVo);
													*/
													invCreVos.get(j).setInvCreFlg("Y");
													invCreFlgCnt = invCreFlgCnt + 1;
												
												//[다른 항목 없으면]
												}else{
													invCreVos.get(j).setInvCreFlg("N");
												}
												
											//Max I/F 의 Good Date IS NULL 인 경우	
											}else{
												dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
												invCreVos.get(j).setInvCreFlg("Y");
												invCreFlgCnt = invCreFlgCnt + 1;
											}
										
										//Max I/F 의 Delete Division Code = 'X' 인 경우
										}else if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("X")){
											invCreVos.get(j).setInvCreFlg("Y");
											invCreFlgCnt = invCreFlgCnt + 1;
										}
										
										//Container만 변경시 Max IF에만 업데이트
										if(invCreVos.get(j).getInvCreFlg().equals("N")&&cntrDiv.equals("Y")){
											
											List<InvBkgIfCntrVO> invBkgIfCntrVOs= dbDao.searchBkgIfContainerList(bkgNo,bkgSeq);
											List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
											
											String troFlg = "";							
											troFlg = dbDao.searchTroFlag(bkgNo,bkgSeq)==null?"":dbDao.searchTroFlag(bkgNo,bkgSeq);
											String svrId = dbDao.searchServerID(invCreVos.get(j).getInvArMnVO().getArOfcCd());
											
											for(int k = 0 ; k< invBkgIfCntrVOs.size(); k++){
												InvArCntrVO invArCntrVO = new InvArCntrVO();
												String cntrSeq = invBkgIfCntrVOs.get(k).getCntrSeq();
												String cntrNo = invBkgIfCntrVOs.get(k).getCntrNo();
												String cntrTpszCd = invBkgIfCntrVOs.get(k).getCntrTpszCd();
												
												if(svrId.equals("EUR")&&troFlg.equals("Y")&&!invCreVos.get(j).getInvArMnVO().getBkgCorrNo().equals("")&&invCreVos.get(j).getInvArMnVO().getBkgCorrNo().length()==10){
													cntrNo = invBkgIfCntrVOs.get(k).getTroCntrNo();
													cntrTpszCd = invBkgIfCntrVOs.get(k).getTroCntrTpszCd();
												}
												
												invArCntrVO.setCntrSeq(cntrSeq);
												invArCntrVO.setCntrNo(cntrNo);
												invArCntrVO.setCntrTpszCd(cntrTpszCd);
												invArCntrVO.setArIfNo(maxIFMainVOs.get(i).getArIfNo());
												invArCntrVO.setCreUsrId(userId);
												invArCntrVO.setUpdUsrId(userId);
												
												invArCntrVOs.add(invArCntrVO);
											}									
											
											if(invArCntrVOs.size()>0){
												dbDao.removeARInvoiceContainer(maxIFMainVOs.get(i).getArIfNo());										
												dbDao.addInvContainer(invArCntrVOs, userId);
											}
										}
									}
									
								}								
							}
							
							log.debug("invCreFlgCnt1 = "+invCreFlgCnt);					
							log.debug("ofcDivCnt = "+ofcDivCnt);
							log.debug("cntrDiv = "+cntrDiv);
							log.debug("invCreVos.size() = "+invCreVos.size());
							
							//Max I/F 의 A/R Office 와 같은 신규 I/F 의 A/R Office 가 없고
							if(ofcDivCnt==0){
								
								//Max I/F 의 A/R Office 와 신규 I/F 의 A/R Office 가 없는 경우 이행 데이터 처리 (최근 이행 날짜 2010-01-09 이전 데이터, 새로 이행시 날짜 수정필요)
								//int ifDt = Integer.parseInt(maxIFMainVOs.get(i).getBlInvIfDt());
								//이행데이터 기준 오피스별 로컬타임 때문에 old_ar_if_no 있는걸로 변경 2010-03-21
								String oldArIfNo = maxIFMainVOs.get(i).getOldArIfNo();
								
								//Migration Data Cancel Start ==============================================================================================						
								if(!oldArIfNo.equals("")&&!maxIFMainVOs.get(i).getArOfcCd().equals("LEHSC")){
									
									List<MaxIFMainVO> migIFVOs = dbDao.searchMigInterfaceList(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd());
									List<MaxIFChgeVO> migIFChgeVOs = dbDao.searchChargeListForMigInterface(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd(), "N"); 
									
									//2010-04-27 Mig 데이터인 경우 Max delt_flg 가 N이고 Curr별 Sum 이 0이 아닐때만 Cancel 한다.
									if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N") && migIFChgeVOs != null && migIFChgeVOs.size() > 0) {
										for(int k=0;k< migIFVOs.size();k++){
											// Delete Division Code = 'N' 인 경우
											if(migIFVOs.get(k).getInvDeltDivCd().equals("N")||migIFVOs.get(k).getInvDeltDivCd().equals("X")){
												String cancelIfNo = "";
												
												//Good Date IS NOT NULL 인 경우
												if(!migIFVOs.get(k).getBlInvCfmDt().equals("")){
												
													//A/R Office 가 한국지역인 경우
													if(migIFVOs.get(k).getLocCd().equals("KR")){
														int cnt = dbDao.checkDecWHF(migIFVOs.get(k).getArIfNo());														
														
														//Dec WHF 존재하는 경우
														if(cnt>0){
															cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"Y", userId,vvdTrnsFlg);
															
															if(!cancelIfNo.equals("")){
																InvArIfNoVO ifNo = new InvArIfNoVO();
																ifNo.setIfNo(cancelIfNo);
																ifNos.add(ifNo);
															}
														
														//Dec WHF 존재하지 않는 경우
														}else{
															cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"N", userId,vvdTrnsFlg);
															
															if(!cancelIfNo.equals("")){
																InvArIfNoVO ifNo = new InvArIfNoVO();
																ifNo.setIfNo(cancelIfNo);
																ifNos.add(ifNo);
															}
														}
														
													//A/R Office 가 한국이외 지역인 경우
													}else{
														cancelIfNo = createMaxIFCancel(migIFVOs.get(k).getArIfNo(),"N", userId,vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													}
													//IF후 한꺼번에 처리하는 로직으로 변경
													updCnt = dbDao.modifySysClearFlag(migIFVOs.get(k).getArIfNo(),cancelIfNo, userId);
													
													//SysClear 된 대상 ifNo 도 ERP전송
													if(updCnt==2){
														InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
														mainIfNoVo.setIfNo(migIFVOs.get(k).getArIfNo());
														mainIfNos.add(mainIfNoVo);
													}
												
													// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
													// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
													// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
													// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
													dbDao.modifySysClearFlagForBLType(migIFVOs.get(k).getArIfNo(),cancelIfNo, userId);
													
												// No Good 이면 delt_div_cd 만 업데이트
												}else{
													dbDao.modifyDelCode(migIFVOs.get(k).getArIfNo(), userId);
												}
											}
										}
									}
								
								//Migration Data Cancel End ==============================================================================================	
								} else { 
									// Max I/F 의 Delete Division Code = 'N' 인 경우
									if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
										String cancelIfNo = "";
										
										//Max I/F 의 Good Date IS NOT NULL 인 경우 2010.01.04
										if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
										
											//A/R Office 가 한국지역인 경우
											if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
												int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
												
												
												//Dec WHF 존재하는 경우
												if(cnt>0){
													cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", userId,vvdTrnsFlg);
													
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												
												//Dec WHF 존재하지 않는 경우
												}else{
													cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", userId,vvdTrnsFlg);
													
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												}
												
											//A/R Office 가 한국이외 지역인 경우
											}else{
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", userId,vvdTrnsFlg);
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											}
											//2009-12-01 IF후 한꺼번에 처리하는 로직으로 변경 김현화 수석
											updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
											
											//2009-12-28 SysClear 된 대상 ifNo 도 ERP전송
											if(updCnt==2){
												InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
												mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
												mainIfNos.add(mainIfNoVo);
											}
											
											// 2011.09.27 [CHM-201113332]ALPS AR INVOICE - 허수데이터 정리 로직 보완 요청
											// 2011.11.24 환율이 0 인 것만 대상으로 하던것 삭제
											// 처음엔 환율이 0 이어서 SYS CLEAR 처리가 되었으나 이후 환율 일괄 업데이트를 하면서 환율이 생성되다보니 
											// 중간 중간 SYS CLEAR 된것이 있어서 오히려 혼동이 되어 김희경 과장님과 확인하고 환율이 0 인것만을 SYS CLEAR 처리하던것을 삭제하기로 함
											dbDao.modifySysClearFlagForBLType(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
										
										//2010.01.04 같은 오피스 없을때 No Good 이면 delt_div_cd 만 업데이트
										}else{
											dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
										}
										
										//2009-12-04 다시 원복 이상희  과장
										/*
										SysClearVO sysClearVo = new SysClearVO();
										
										sysClearVo.setOfcCd(maxIFMainVOs.get(i).getArOfcCd());
										sysClearVo.setBlNo(blSrcNo);							
										sysClearVo.setUserId(userId);
										sysClearVo.setVvdCd("");
										sysClearVo.setCustCd("");
										
										modifySysClearList(sysClearVo);
										*/
									}
								}
							}
							
						}
						
						
						//[신규 I/F 1...n] For 
						for( int i = 0; i < invCreVos.size(); i++ ){					
							//Invoice Create Flag 의 값이 없는 경우 Y 로 입력
							if(invCreVos.get(i).getInvCreFlg()==null){
								invCreVos.get(i).setInvCreFlg("Y");
								invCreFlgCnt = invCreFlgCnt + 1;
							}
						}
						
						log.debug("invCreFlgCnt2 = "+invCreFlgCnt);
						
						//New I/F 중에 INV 에 생성해야 할 data 가 있는 경우
						if(invCreFlgCnt>0){
							
							//[New I/F 1...n] For
							for( int i = 0; i < invCreVos.size(); i++ ){
								BKGMainDocVO bKGMainDocVO = dbDao.searchBKGInterface( bkgNo, bkgSeq ,invCreVos.get(i).getInvArMnVO().getSlsOfcCd());								
								
								//INV 생성 대상인 경우
								if(invCreVos.get(i).getInvCreFlg().equals("Y")){
									invCreVos.get(i).getInvArMnVO().setTrnkVslCd(bKGMainDocVO.getTrnkVslCd());
									invCreVos.get(i).getInvArMnVO().setTrnkSkdVoyNo(bKGMainDocVO.getTrnkSkdVoyNo());
									invCreVos.get(i).getInvArMnVO().setTrnkSkdDirCd(bKGMainDocVO.getTrnkSkdDirCd());
									invCreVos.get(i).getInvArMnVO().setPorCd(bKGMainDocVO.getPorCd());
									invCreVos.get(i).getInvArMnVO().setDelCd(bKGMainDocVO.getDelCd());
									invCreVos.get(i).getInvArMnVO().setCgoWgt(bKGMainDocVO.getCgoWgt());
									invCreVos.get(i).getInvArMnVO().setCgoMeasQty(bKGMainDocVO.getCgoMeasQty());
									invCreVos.get(i).getInvArMnVO().setSrepCd(bKGMainDocVO.getSrepCd());
									invCreVos.get(i).getInvArMnVO().setDestTrnsSvcModCd(bKGMainDocVO.getDestSvcModCd());
									invCreVos.get(i).getInvArMnVO().setMstBlNo(bKGMainDocVO.getMstBlNo());
									invCreVos.get(i).getInvArMnVO().setBkgRefNo(bKGMainDocVO.getBkgRefNo());
									invCreVos.get(i).getInvArMnVO().setInvRefNo(bKGMainDocVO.getInvRefNo());
									invCreVos.get(i).getInvArMnVO().setSiRefNo(bKGMainDocVO.getSiRefNo());
									invCreVos.get(i).getInvArMnVO().setFrtFwrdCntCd(bKGMainDocVO.getFrtFwrdCntCd());
									invCreVos.get(i).getInvArMnVO().setFrtFwrdCustSeq(bKGMainDocVO.getFrtFwrdCustSeq());
									invCreVos.get(i).getInvArMnVO().setScNo(bKGMainDocVO.getScNo());
									invCreVos.get(i).getInvArMnVO().setRfaNo(bKGMainDocVO.getRfaNo());
									invCreVos.get(i).getInvArMnVO().setBkgTeuQty(bKGMainDocVO.getBkgTeuQty());
									invCreVos.get(i).getInvArMnVO().setBkgFeuQty(bKGMainDocVO.getBkgFeuQty());
									invCreVos.get(i).getInvArMnVO().setBkgCorrNo(bKGMainDocVO.getBkgCorrNo());
									invCreVos.get(i).getInvArMnVO().setBkgCorrDt(bKGMainDocVO.getBkgCorrDt());
									invCreVos.get(i).getInvArMnVO().setCxlFlg(bKGMainDocVO.getCxlFlg());
									invCreVos.get(i).getInvArMnVO().setBkgSeq(bkgSeq);
									//2010-05-26 추가
									invCreVos.get(i).getInvArMnVO().setObrdDt(bKGMainDocVO.getObrdDt());
									
									//2010-01-18 김동진 수석 
									//invCreVos.get(i).getInvArMnVO().setCsrNo(bKGMainDocVO.getCsrNo());
									//invCreVos.get(i).getInvArMnVO().setWhfFlg(bKGMainDocVO.getWhfFlg());
									
									//2010-01-29 김동진 수석 
									invCreVos.get(i).getInvArMnVO().setCtrtOfcCd(bKGMainDocVO.getCtrtOfcCd());
									
									
									log.debug("invCreVos.get(i).getInvArChgVOs().size()="+invCreVos.get(i).getInvArChgVOs().size());
									
									//A/R Office 가 한국지역인 경우
									if(invCreVos.get(i).getLocCd().substring(0,2).equals("KR")){
										
										//2010-12-06 WHF CANCEL일 때
										if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
											
											//BKG에서 넘어온 같은 Whf Decl No 가 있는지 체크
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());
											
											if(whfDeclNoCnt > 0 && bKGMainDocVO.getWhfFlg().equals("Y")){
												dbDao.modifyWhfDeclNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfDeclNo(), bkgUserId);
																								
												invCreVos.get(i).getInvArMnVO().setWhfFlg("C");
												invCreVos.get(i).getInvArMnVO().setInvRmk(bKGMainDocVO.getWhfDeclNo());
												
												//WHF_FLG 'Y'인 WHF CHG만 담는다.
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													} else {
														if(invCreVos.get(i).getInvArChgVOs().get(j).getWhfFlg().equals("Y")){
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));			
														}
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											} else { 
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													//Charge 항목에서 WHF 포함된 row 는 삭제
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														//invCreVos.get(i).getInvArChgVOs().remove(invCreVos.get(i).getInvArChgVOs().get(j));
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											}
											
										} else {									
										
											//BKG에서 넘어온 같은 Whf Decl No 가 있는지 체크
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());
											
											//같은 Whf Decl No가 없을때만 WHF 속성들 세팅, 김동진 수석 2010-02-22
											if(whfDeclNoCnt==0&&bKGMainDocVO.getWhfFlg().equals("Y")){
												//A/R Office 가 한국지역인 경우만 세팅 2010-02-19 
												invCreVos.get(i).getInvArMnVO().setWhfDeclNo(bKGMainDocVO.getWhfDeclNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclCfmDt(bKGMainDocVO.getWhfDeclCfmDt());
												invCreVos.get(i).getInvArMnVO().setWhfDeclOfcCd(bKGMainDocVO.getWhfDeclOfcCd());
												invCreVos.get(i).getInvArMnVO().setWhfMrnNo(bKGMainDocVO.getWhfMrnNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclVslCd(bKGMainDocVO.getWhfDeclVslCd());
												invCreVos.get(i).getInvArMnVO().setWhfDeclVoyNo(bKGMainDocVO.getWhfDeclVoyNo());
												invCreVos.get(i).getInvArMnVO().setWhfDeclDirCd(bKGMainDocVO.getWhfDeclDirCd());
												invCreVos.get(i).getInvArMnVO().setWhfNtcNo(bKGMainDocVO.getWhfNtcNo());
												invCreVos.get(i).getInvArMnVO().setWhfFlg(bKGMainDocVO.getWhfFlg());
												invCreVos.get(i).getInvArMnVO().setCsrNo(bKGMainDocVO.getCsrNo());	
												
												//2010-04-29 WHF_FLG 'Y'인 WHF CHG만 담는다.
												List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
												
												for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){	
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													} else {
														if(invCreVos.get(i).getInvArChgVOs().get(j).getWhfFlg().equals("Y")){
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));			
														}
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											}
											
											int whfCnt = dbDao.checkDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd());
											
											//Dec WHF 존재하는 경우
											if(whfCnt>0){	
												//2009-11-26 WHF 허가번호 업데이트 김동진 수석
												dbDao.modifyWhfNtcNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfNtcNo(), bKGMainDocVO.getWhfDeclNo());
																						
												//2010-02-19 BKG IF된 DeclNo 없을때 WHF 삭제, 동일 Whf Decl No 가 있을때도 삭제(2010-02-22 추가) 
												if(bKGMainDocVO.getWhfDeclNo().equals("")||whfDeclNoCnt>0){
													List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
													
													for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
														//Charge 항목에서 WHF 포함된 row 는 삭제
														if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){	
															//invCreVos.get(i).getInvArChgVOs().remove(invCreVos.get(i).getInvArChgVOs().get(j));
															invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
														}
													}
													
													invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
												}																				
											}
										
										}
									}
									
									log.debug("invCreVos.get(i).getInvArWHFChgVOs().size()="+invCreVos.get(i).getInvArChgVOs().size());
																
									ARCreditInputVO arCrdtVo = new ARCreditInputVO();
									arCrdtVo.setActCustCntCd(invCreVos.get(i).getInvArMnVO().getActCustCntCd());
									arCrdtVo.setActCustSeq(invCreVos.get(i).getInvArMnVO().getActCustSeq());
									arCrdtVo.setSailArrDt(invCreVos.get(i).getInvArMnVO().getSailArrDt());
									arCrdtVo.setIoBndCd(invCreVos.get(i).getInvArMnVO().getIoBndCd());
									arCrdtVo.setDestTrnsSvcModCd(invCreVos.get(i).getInvArMnVO().getDestTrnsSvcModCd());
									arCrdtVo.setArOfcCd(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									arCrdtVo.setLocCd(invCreVos.get(i).getLocCd().substring(0,2));
									arCrdtVo.setDelCd(invCreVos.get(i).getInvArMnVO().getDelCd());
									arCrdtVo.setSvcScpCd(invCreVos.get(i).getInvArMnVO().getSvcScpCd());
									
									ARCreditVO aRCreditVO = searchARCredit(arCrdtVo);
									
									if(aRCreditVO != null){
										invCreVos.get(i).getInvArMnVO().setDueDt(aRCreditVO.getDueDt());
										invCreVos.get(i).getInvArMnVO().setCrTermDys(aRCreditVO.getCrTerm());
										invCreVos.get(i).getInvArMnVO().setCustCrFlg(aRCreditVO.getCrFlg());
									}
									
									if(!bKGMainDocVO.getBkgCorrNo().equals("")){
										if(bKGMainDocVO.getCaRsnCd().equals("E")||bKGMainDocVO.getCaRsnCd().equals("F")){
											invCreVos.get(i).getInvArMnVO().setTrspRqstOrdFlg("Y");
										}
									}
									
									String zoneIOC = dbDao.searchZoneIOC(invCreVos.get(i).getInvArMnVO().getPolCd(), invCreVos.get(i).getInvArMnVO().getPodCd());
									invCreVos.get(i).getInvArMnVO().setZnIocCd(!zoneIOC.equals("")?zoneIOC:invCreVos.get(i).getInvArMnVO().getZnIocCd().equals("OO")?"OO":zoneIOC);
									
									String cityCd = dbDao.searchCityCd(invCreVos.get(i).getInvArMnVO().getArOfcCd()); 
									invCreVos.get(i).getInvArMnVO().setArCtyCd(cityCd);
									
									String bdrIndFlg = bKGMainDocVO.getBdrIndFlg();	
									String revTpCd = "";
									String revSrcCd = "";
									
									//기존 데이터 중 DELT FLG 가 Y가 아닌 IFNO가 있는지 체크
									int fisrtFlg = dbDao.checkFirstInterface(invCreVos.get(i).getInvArMnVO().getBlSrcNo(), invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									if(fisrtFlg==0){
										if(bKGMainDocVO.getBkgCorrNo().equals("")){
											revTpCd = bdrIndFlg.equals("N")?"B":"C";
											revSrcCd = bdrIndFlg.equals("N")?"BL":"CA";
										}else{
											revTpCd = bdrIndFlg.equals("N")?"B":"C";
											revSrcCd = bdrIndFlg.equals("N")?"CS":"CA";
										}
									}else{
										revTpCd = bdrIndFlg.equals("N")?"B":"C";
										revSrcCd = bdrIndFlg.equals("N")?"CS":"CA";
									}
									
									invCreVos.get(i).getInvArMnVO().setRevTpCd(revTpCd);
									invCreVos.get(i).getInvArMnVO().setRevSrcCd(revSrcCd);
									
									String glEffDt = dbDao.searchEffectiveDate(invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArMnVO().getSailDt(), revTpCd, revSrcCd);
									invCreVos.get(i).getInvArMnVO().setGlEffDt(glEffDt);
									invCreVos.get(i).getInvArMnVO().setAcctXchRtYrmon(glEffDt.length()==8?glEffDt.substring(0,6):"");
									
									
									String troFlg = "";
									
									troFlg = dbDao.searchTroFlag(bkgNo,bkgSeq)==null?"":dbDao.searchTroFlag(bkgNo,bkgSeq);	
									
									String invCoaInterCoCd =  dbDao.searchInterCompany(invCreVos.get(i).getInvArMnVO().getActCustCntCd(),invCreVos.get(i).getInvArMnVO().getActCustSeq());	
									
									CoaVO coaVO = dbDao.searchCOA(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									String invCoaCoCd = "";
									String invCoaCtrCd = "";
									String invCoaRgnCd = "";
									
									if(coaVO!=null){
										invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
										invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
										invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
									}
									
									String svrId = dbDao.searchServerID(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									
									String acct_div_cd = dbDao.searchAccountDivision(revTpCd + revSrcCd);
									String revCoaAcctCd ="";
									String revCoaVslCd = "";
									String revCoaVoyNo = "";
									String revCoaSkdDirCd = "";
									String revCoaDirCd = "";
									String acctCd = "";
									
									String arTaxIndCd = dbDao.searchArTaxInd( bkgNo,  bkgSeq, invCreVos.get(i).getInvArMnVO().getSlsOfcCd());
									
									invCreVos.get(i).getInvArMnVO().setArTaxIndCd(arTaxIndCd==null?"0":"10");
									
									String eurFlg = "N";
									//20110331 EU VAT
									if(svrId.equals("EUR") && invCreVos.get(i).getArAgnStlCd().equals("B")){
										if(!invCreVos.get(i).getInvArMnVO().getArOfcCd().equals("GOASC")&&!invCreVos.get(i).getInvArMnVO().getArOfcCd().equals("VLCSC")){
											//POR_CD,DEL_CD 앞자리 2자리 EU국가 여부 체크
											if(dbDao.checkEurCountry(invCreVos.get(i).getInvArMnVO().getPorCd().substring(0,2)) > 0){
												if(dbDao.checkEurCountry(invCreVos.get(i).getInvArMnVO().getDelCd().substring(0,2)) > 0){
													// Actual Customer EU 국가 여부 체크
													if(dbDao.checkEurCountry(invCreVos.get(i).getInvArMnVO().getActCustCntCd()) > 0){
													
														String cntCd = dbDao.checkEurOffice(invCreVos.get(i).getInvArMnVO().getArOfcCd(),invCreVos.get(i).getInvArMnVO().getSailArrDt());
														//Ar Office 가 EU 국가 여부 체크
														if(!cntCd.equals("")){
															//Ar Office 의 국가 코드와 Actual Customer의 국가코드가 같으면 VAT적용
															if(cntCd.equals(invCreVos.get(i).getInvArMnVO().getActCustCntCd())){
																
																eurFlg = "Y";
																
																log.debug("eurFlg=="+eurFlg);
																log.debug("eurFlg=="+eurFlg);
																
																InvArChgVO invArChgVO = new InvArChgVO();
																
																invArChgVO.setChgCd("IEV");
																invArChgVO.setCurrCd(invCreVos.get(i).getInvArMnVO().getLoclCurrCd());
																invArChgVO.setPerTpCd("BL");
																invArChgVO.setTrfRtAmt("0");
																invArChgVO.setRatAsCntrQty("1");
																invArChgVO.setChgAmt("0");
																invArChgVO.setInvXchRt("1");
																invArChgVO.setMfDivCd("M");
																
																invCreVos.get(i).getInvArChgVOs().add(invArChgVO);
															}else{
																if(fisrtFlg==0){
																	invCreVos.get(i).getInvArMnVO().setRvsChgFlg("Y");
																}
															}
														}													
													}
												}
											}
										}
									}
									
									
									for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
										String repChgCd = dbDao.searchRepCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										
										invCreVos.get(i).getInvArChgVOs().get(j).setRepChgCd(repChgCd==null?"XXX":repChgCd);
										
										String chgFullNm= dbDao.searchChargeName(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), arCrdtVo.getArOfcCd());
										invCreVos.get(i).getInvArChgVOs().get(j).setChgFullNm(chgFullNm);								
										
										//Account Division Code = 'P' 인 경우
										if (acct_div_cd.equals("P")) {
											acctCd = dbDao.searchAccountCdFromCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										} else {
											acctCd = dbDao.searchAccountCdFromRevAcct(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										}
										
										//2009-11-26 Acct Cd 구하는 쿼리 추가	김현화 수석						
										acctCd = dbDao.searchAccountCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
										
										revCoaAcctCd = dbDao.searchRevCoaAcctCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
										
										//rev_vvd 없으면 0이 아니라 null로 수정 2009-11-20  심유경 수석
										revCoaVslCd = invCreVos.get(i).getInvArMnVO().getRevVslCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevVslCd();
										revCoaVoyNo = invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo();
										revCoaSkdDirCd = invCreVos.get(i).getInvArMnVO().getRevSkdDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdDirCd();
										revCoaDirCd = invCreVos.get(i).getInvArMnVO().getRevDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevDirCd();
										
										//2009-11-19  심유경 수석 revCoaAcctCd 가 4,51,7 로 시작하는 거 외에는 0으로 rev vvd 세팅
										/* Insert 쿼리에 직접 로직 구현 2009.11.28 박정진 수석
										if(revCoaAcctCd!=null){
											if(!revCoaAcctCd.substring(0,1).equals("4") && !revCoaAcctCd.substring(0,2).equals("51") && !revCoaAcctCd.substring(0,1).equals("7")){
												revCoaVslCd ="0000";
												revCoaVoyNo = "0000";
												revCoaSkdDirCd = "0";
												revCoaDirCd = "0";
											}
										}
										*/
										
										invCreVos.get(i).getInvArChgVOs().get(j).setAcctCd(acctCd);	
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaInterCoCd(invCoaInterCoCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaCoCd(invCoaCoCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaCtrCd(invCoaCtrCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaRgnCd(invCoaRgnCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaAcctCd(revCoaAcctCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaVslCd(revCoaVslCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaVoyNo(revCoaVoyNo);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaSkdDirCd(revCoaSkdDirCd);
										invCreVos.get(i).getInvArChgVOs().get(j).setRevCoaDirCd(revCoaDirCd);								
									}
									
									List<InvBkgIfCntrVO> invBkgIfCntrVOs= dbDao.searchBkgIfContainerList(bkgNo,bkgSeq);
									List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
									for(int j = 0 ; j < invBkgIfCntrVOs.size(); j++){
										InvArCntrVO invArCntrVO = new InvArCntrVO();
										String cntrSeq = invBkgIfCntrVOs.get(j).getCntrSeq();
										String cntrNo = invBkgIfCntrVOs.get(j).getCntrNo();
										String cntrTpszCd = invBkgIfCntrVOs.get(j).getCntrTpszCd();
										
										if(svrId.equals("EUR")&&troFlg.equals("Y")&&!bKGMainDocVO.getBkgCorrNo().equals("")&&bKGMainDocVO.getBkgCorrNo().length()==10){
											cntrNo = invBkgIfCntrVOs.get(j).getTroCntrNo();
											cntrTpszCd = invBkgIfCntrVOs.get(j).getTroCntrTpszCd();
										}
										
										invArCntrVO.setCntrSeq(cntrSeq);
										invArCntrVO.setCntrNo(cntrNo);
										invArCntrVO.setCntrTpszCd(cntrTpszCd);
										
										invArCntrVOs.add(invArCntrVO);
									}
									
									invCreVos.get(i).setInvArCntrVOs(invArCntrVOs);
									
									String newIfNo = createBKGInvoice(invCreVos.get(i), eurFlg, userId);
	
									if(!newIfNo.equals("")){
										InvArIfNoVO ifNo = new InvArIfNoVO();
										ifNo.setIfNo(newIfNo);
										ifNos.add(ifNo);
									}
									
									dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", "Success", bkgUserId);
								}					
							}
						}else{
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "X", "No items changed", bkgUserId);
						}
					}
					
					//Sys Clear 된 대상 IfNo 가 Good Data인 IfNo 모아서 ERP전송
					log.debug("mainIfNos.size() = "+mainIfNos.size());
					if(mainIfNos!= null && mainIfNos.size()>0){
						interfaceARInvoiceToERPAR(mainIfNos, "U");
					}
					
					/*
					//Good Data인 IfNo 모아서 ERP전송 2009-12-04 BKG IF 끝난 후 모아서 전송
					log.debug("ifNos.size() = "+ifNos.size());
					if(ifNos!= null && ifNos.size()>0){
						interfaceARInvoiceToERPAR(ifNos, "C");
					}
					*/
				}
			}
			
			return ifNos;
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * AGENT COMMISSION 모듈 BC를 실행시킨다<br>
	 * 
	 * @param bkgNo
	 */
	private void createFACComm(String bkgNo) {
		
		// [CHM-201216347] AGENT COMMISSION 변경으로 인한 로직 변경
		//AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
		FACCommCalculationBC facCalcBC = new FACCommCalculationBCImpl();							

		try{
			//agtCalcToInvBC.createFACComm(bkgNo);
			facCalcBC.createFACCommInv(bkgNo);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}
	
	/**
	 * 특정 Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param String maxIfNo
	 * @param String whfFlg
	 * @param String userId
	 * @param String vvdTrnsFlg
	 * @return String
	 * @exception EventException
	 */
	public String createMaxIFCancel (String maxIfNo, String whfFlg, String userId, String vvdTrnsFlg) throws EventException{
		String rtIfNo = "";
		try {
			
			List<InvArMnVO> invArMnList = null;
			
			String newIfNo = "";
			
			InvArMnVO invArMnVO = new InvArMnVO();
			List<InvArChgVO> invArChgVOs = null;
			List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArAmtVO> invArWhfAmtVOs = new ArrayList<InvArAmtVO>();
			List<InvArCntrVO> invArCntrVOs = null;			
			ActInvCustVO actInvCustVO = new ActInvCustVO();

			invArMnList = dbDao.searchARInvoice(maxIfNo);
			invArChgVOs = dbDao.searchARInvoiceCharge(maxIfNo);			
			invArAmtVOs = dbDao.searchARInvoiceAmount(maxIfNo);
			invArCntrVOs = dbDao.searchARInvoiceContainer(maxIfNo);
			
			/*
			String maxSeq = dbDao.searchBKGInterfaceNo(invArMnList.get(0).getArOfcCd());			
			
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnList.get(0).getArOfcCd(), userId);
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnList.get(0).getArOfcCd(), maxSeq, userId);
			}
			*/
			
			//2010-03-22 deadlock 에러 때문에 프로시져로 변경
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnList.get(0).getArOfcCd(), userId);	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
//			String newIfNo = invArMnList.get(0).getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq: invArMnList.get(0).getArOfcCd().substring(0, 3) + maxSeq;			
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
//			newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			if(invArMnList.get(0).getArOfcCd().substring(0, 3).equals("FXT")){
				newIfNo = "LON"+ maxSeq ;
			}else if(invArMnList.get(0).getArOfcCd().substring(0, 3).equals("GDY")){
				newIfNo = "WRP"+ maxSeq ;
			}else{
				newIfNo = invArMnList.get(0).getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			invArMnVO = invArMnList.get(0);			
			//Cancel시에도 Max If의 Act Cust 사용 2010-03-03 이상희과장
			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(invArMnVO.getArOfcCd(),invArMnVO.getBlSrcNo());
			
			if(actInvCustVO != null&&actInvCustVO.getActCustCntCd()!=null){				
				invArMnVO.setActCustCntCd(actInvCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(actInvCustVO.getActCustSeq());
				invArMnVO.setDueDt(actInvCustVO.getDueDt());
				invArMnVO.setCustCrFlg(actInvCustVO.getCustCrFlg());
				invArMnVO.setCrTermDys(actInvCustVO.getCrTermDys());
			}
			
			BigDecimal invTtlLoclAmt = new BigDecimal(invArMnVO.getInvTtlLoclAmt()).multiply(new BigDecimal(-1));
			
			//invArMnVO.setInvTtlLoclAmt(Float.toString(Float.parseFloat(invArMnVO.getInvTtlLoclAmt()) * -1));

			invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());


			ARCorrectionCkReturnVO arCkRtVo = dbDao.searchRevTypeSrc(invArMnVO.getBkgNo(), "");
			
			String revTpCd = "";
			String revSrcCd = "";
			
			if (arCkRtVo.getRevTpCd().equals("")) {
				if (invArMnVO.getRevTpCd().equals("B")) {
					revTpCd = "B";
					revSrcCd = "CS";
				} else if (invArMnVO.getRevTpCd().equals("C")) {
					revTpCd = "C";
					revSrcCd = "CA";
				}
			} else {
				revTpCd = arCkRtVo.getRevTpCd();
				revSrcCd = arCkRtVo.getRevSrcCd();
			}
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String glEffDt = dbDao.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt(), revTpCd, revSrcCd);
			invArMnVO.setGlEffDt(glEffDt);
			invArMnVO.setBlInvCfmDt("");
			
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			invArMnVO.setInvDeltDivCd("X");
			//Bkg Interface는 Split Flag null 로 세팅. 2009.11.24 이상희 과장
			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd(vvdTrnsFlg);
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2010-12-06 Cancel시 WHF 관련항목 초기화
			invArMnVO.setWhfDeclNo("");
			invArMnVO.setWhfDeclCfmDt("");
			invArMnVO.setWhfDeclOfcCd("");
			invArMnVO.setWhfMrnNo("");
			invArMnVO.setWhfDeclVslCd("");
			invArMnVO.setWhfDeclVoyNo("");
			invArMnVO.setWhfDeclDirCd("");
			invArMnVO.setWhfNtcNo("");
			invArMnVO.setWhfFlg("");
			invArMnVO.setCsrNo("");	
			
			
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			int chgSize = invArChgVOs.size();
			
			// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산
			// INV_AR_MN 에서 ifNo 로 구해온 act_cust_cnt_cd 와 act_cust_seq 로 inv_coa_inter_co_cd 를 가져와 setting
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());
			
			for (int i = 0; i < chgSize; i++) {
				String invRevTpSrcCd = "";
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				//invArChgVOs.get(i).setChgAmt(Float.toString(Float.parseFloat(invArChgVOs.get(i).getChgAmt()) * -1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());
				
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setCreUsrId(userId);
				invArChgVOs.get(i).setUpdUsrId(userId);
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());		
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);				
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");	
				//Whf Flag = 'Y' 인 경우 invChges 정보에서 WHF 가 있는 row 를 삭제	
				

				if(whfFlg.equals("Y")){
					if(!invArChgVOs.get(i).getChgCd().equals("WHF")){			
						
						log.debug("invArChgVOs.get(i).getChgCd()="+invArChgVOs.get(i).getChgCd());	
						//invArChgVOs.remove(i);
						invArWhfChgVOs.add(invArChgVOs.get(i));
					}
				}	
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
				
				log.debug("i="+i);
			}
			
			log.debug("invArChgVOs.size()2="+invArChgVOs.size());
			log.debug("invArWhfChgVOs="+invArWhfChgVOs.size());
			
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			String erpIfOfcCd = "";
			
			
			if(svrId.equals("USA")&&arAgnStlCd.equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				BigDecimal invAmt= new BigDecimal(invArAmtVOs.get(i).getInvAmt()).multiply(new BigDecimal(-1));
				
				//invArAmtVOs.get(i).setInvAmt(Float.toString(Float.parseFloat(invArAmtVOs.get(i).getInvAmt()) * -1));
				
				invArAmtVOs.get(i).setInvAmt(invAmt.toString());
				
				invArAmtVOs.get(i).setArIfNo(newIfNo);
				invArAmtVOs.get(i).setCreUsrId(userId);
				invArAmtVOs.get(i).setUpdUsrId(userId);
				invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
				invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
				
				
				//Whf Flag = 'Y' 인 경우 invAmts 정보에서 WHF 가 있는 row 를 삭제				
				if(whfFlg.equals("Y")){
					if(!invArAmtVOs.get(i).getTjSrcNm().equals("WHF")){
						//invArAmtVOs.remove(invArAmtVOs.get(i));
						invArWhfAmtVOs.add(invArAmtVOs.get(i));
					}
				}		
				
				// [CHM-201216076] [INV] INTER COMPANY COA 값 재계산을 위한 invCoaInterCoCd setting
				invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
			}

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(userId);
					invArCntrVOs.get(i).setUpdUsrId(userId);
				}
			}
			
			//2010-03-02 DeclNo가 있고 CHG가 테이블에 WHF만 있는 경우 Cancel할 CHG가 없으므로 Cancel 정보를 아예 생성하지 않는다.
			String creFlg = "";
			
			if(whfFlg.equals("Y")){
				if(invArWhfChgVOs.size()>0){
					creFlg = "Y";
				}
			}else{
				if(invArChgVOs.size()>0){
					creFlg = "Y";
				}
			}
			
			if(creFlg.equals("Y")){
			
				dbDao.addInvMain(invArMnVO);
				dbDao.addInvAmount(whfFlg.equals("Y")?invArWhfAmtVOs:invArAmtVOs);
				dbDao.addInvCharge(whfFlg.equals("Y")?invArWhfChgVOs:invArChgVOs);
				if (invArCntrVOs.size() > 0) {
					dbDao.addInvContainer(invArCntrVOs, userId);
				}
				
				//2014-08-28 COA Center Code ERP_IF_OFC_CD 기준으로 Update
				dbDao.modifyInvCoaCtrCd(newIfNo);
				dbDao.modifyInvCoaCtrCdToAmt(newIfNo);
				
				//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
				dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
				
				/*
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO ifNo = new InvArIfNoVO();
				ifNo.setIfNo(newIfNo);
				ifNos.add(ifNo);
				*/
				
				int cnt = dbDao.checkAccountRateExist(invArMnVO.getGlEffDt());
				
				//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
				//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
				String revVslCd2 		 =	invArMnVO.getRevVslCd();
				String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
				String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
				String sailArrDt2        =	invArMnVO.getSailArrDt();
				String sailDt2           =	invArMnVO.getSailDt();
				String dueDt2            =	invArMnVO.getDueDt();
				String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
				String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
				String arCtyCd2          =	invArMnVO.getArCtyCd();
				String glEffDt2          =	invArMnVO.getGlEffDt();
				String actCustSeq2       =	invArMnVO.getActCustSeq();
				
				if(revVslCd2 == null) revVslCd2 = "";
				if(revSkdDirCd2 == null) revSkdDirCd2 = "";
				if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
				if(sailArrDt2 == null) sailArrDt2 = "";
				if(sailDt2 == null) sailDt2 = "";
				if(dueDt2 == null) dueDt2 = "";
				if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
				if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
				if(arCtyCd2 == null) arCtyCd2 = "";
				if(glEffDt2 == null) glEffDt2 = "";
				if(actCustSeq2 == null) actCustSeq2 = "";
								
				if (cnt > 0) {
					if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
							|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")){
						dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
						
					}else{
						// [경리환율 존재하는 경우] ERP I/F 처리
						dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
						//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
						rtIfNo = newIfNo;
					}
					
				} else{
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());	
				}		
				
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		return rtIfNo;
	}
	
	
	/**
	 * 신규 I/F 매출채권 data 의 VVD, Lane, Scope, Port, S/A Date, <br>
	 * Sailing Date, Revenue VVD, Revenue Lane 등의 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ioBndCd
	 * @param String ofcCd
	 * @return VvdLanePortVO
	 * @exception EventException
	 */
	public VvdLanePortVO searchVVDForNewInterface(String bkgNo, String bkgSeq, String ioBndCd, String ofcCd) throws EventException{
		VvdLanePortVO vvdLanePortVO = new VvdLanePortVO();
		String portCd = "";
		String vvd = "";
		String sailArrDt = "";
		String slanCd = "";
		String svcScpCd = "";
		String revVvd = "";
		String rlaneCd ="";
		String sailDt = "";
		String polCd = "";
		String podCd = "";
		String porCd = "";
		String delCd = "";
		String znIocCd = "";
		try {
			
			VvdPortVO vvdPortVO = new VvdPortVO();
			vvdPortVO = dbDao.searchPort(bkgNo, bkgSeq, ioBndCd);
			
			portCd = vvdPortVO.getPortCd();
			polCd = vvdPortVO.getPolCd();
			podCd = vvdPortVO.getPodCd();
			porCd = vvdPortVO.getPorCd();
			delCd = vvdPortVO.getDelCd();
			
			VvdSaDtVO vvdSaDtVO = dbDao.searchVVDSaDt(bkgNo, bkgSeq, portCd, ioBndCd);
			if(vvdSaDtVO != null){
				vvd = vvdSaDtVO.getVvd();
				sailArrDt =  vvdSaDtVO.getSailArrDt();
			}
			
			String svrId = dbDao.searchServerID(ofcCd);
			
			//VVD, S/A Date 가 없거나 구주지역인 경우			
			if((vvd==null||sailArrDt==null)||svrId.equals("EUR")){
				vvdPortVO = dbDao.searchTvvdPort(bkgNo, bkgSeq, ioBndCd);
				if(vvdPortVO != null){
					vvd = vvdPortVO.getVvd()!=null&&!vvdPortVO.getVvd().equals("")?vvdPortVO.getVvd():"";
					portCd = vvdPortVO.getPortCd()!=null&&!vvdPortVO.getPortCd().equals("")?vvdPortVO.getPortCd():"";
				}
				
				sailArrDt = dbDao.searchTrunkSaDt( vvd, portCd, ioBndCd );
			}
			
			slanCd = dbDao.searchLane( bkgNo, bkgSeq );
			svcScpCd = dbDao.searchServiceScope( bkgNo, bkgSeq );
			
			RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(bkgNo);
			
			if(revVVDLaneVO != null){
				revVvd = revVVDLaneVO.getRevVvd();
				rlaneCd = revVVDLaneVO.getRlaneCd();				
			}
			
			log.debug("revVvd1 ="+ revVvd);			
			
			if(revVvd.equals("X")){
				revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
				if(revVVDLaneVO != null){
					revVvd = revVVDLaneVO.getRevVvd();
					rlaneCd = revVVDLaneVO.getRlaneCd();
					znIocCd = "OO";
				}
			}
			
			log.debug("revVvd2 ="+ revVvd);			
			
			sailDt = dbDao.searchSailingDate(bkgNo);
			
			vvdLanePortVO.setPortCd(portCd);
			vvdLanePortVO.setVvd(vvd);
			vvdLanePortVO.setSailArrDt(sailArrDt==null?"":sailArrDt);
			vvdLanePortVO.setSlanCd(slanCd);
			vvdLanePortVO.setSvcScpCd(svcScpCd);
			vvdLanePortVO.setRevVvd(revVvd.equals("X")?"":revVvd);
			vvdLanePortVO.setRlaneCd(rlaneCd.equals("X")?"":rlaneCd);
			vvdLanePortVO.setSailDt(sailDt);
			vvdLanePortVO.setPolCd(ioBndCd.equals("O")?portCd:polCd);
			vvdLanePortVO.setPodCd(ioBndCd.equals("I")?portCd:podCd);
			vvdLanePortVO.setZnIocCd(znIocCd);
			vvdLanePortVO.setPorCd(porCd);
			vvdLanePortVO.setDelCd(delCd);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return vvdLanePortVO;
	}
	
	/**
	 * Booking Office 에 해당하는 A/R Office 정보를 조회한다.<br>
	 * 
	 * @param CutOffLaneVO cutOffLaneVO
	 * @return ArOfficeVO
	 * @exception EventException
	 */
	public ArOfficeVO searchAROfficeList(CutOffLaneVO cutOffLaneVO) throws EventException{
		ArOfficeVO arOfficeVO = new ArOfficeVO();
		String arOfcCd = "";
		String cutOffAplyDtTpCd = "";
		String aplyDt = "";
		String arCurrCd = "";
		String arCtrCd = "";
		String arHdQtrOfcCd = "";
		String locCd = "";
		String rgnCd = "";
		String soIfCd = "";
		String arAgnStlCd = "";
		String arCtrlOfcCd = "";
		String repCustCntCd = "";
		String repCustSeq = "";
		String subAgnFlg = "";
		try{
			//A/R Office,Sub Agent Mark
			ArOfcAgtMkVO arOfcAgtMkVO = dbDao.searchAROfficeAgtMk ( cutOffLaneVO.getOfcCd() );
			
			arOfcCd = arOfcAgtMkVO.getArOfcCd()!=null&&!arOfcAgtMkVO.getArOfcCd().equals("")?arOfcAgtMkVO.getArOfcCd():"";
			arAgnStlCd = arOfcAgtMkVO.getArAgnStlCd()!=null&&!arOfcAgtMkVO.getArAgnStlCd().equals("")?arOfcAgtMkVO.getArAgnStlCd():"";
			
			//cut_off_aply_dt_tp_cd, aply_dt, new_ar_ofc_cd
			ArOfcApplDtVO arOfcApplDtVO =  dbDao.searchCutOffLaneOffice(arOfcCd.equals("")?cutOffLaneVO.getOfcCd():arOfcCd, cutOffLaneVO.getVvd(), cutOffLaneVO.getIoBndCd(), cutOffLaneVO.getPortCd(), cutOffLaneVO.getSailArrDt());
			
			arOfcCd = arOfcApplDtVO.getArOfcCd()!=null&&!arOfcApplDtVO.getArOfcCd().equals("")?arOfcApplDtVO.getArOfcCd():arOfcCd; 
			cutOffAplyDtTpCd = arOfcApplDtVO.getCutOffAplyDtTpCd()!=null&&!arOfcApplDtVO.getCutOffAplyDtTpCd().equals("")?arOfcApplDtVO.getCutOffAplyDtTpCd():"";
			aplyDt = arOfcApplDtVO.getAplyDt()!=null&&!arOfcApplDtVO.getAplyDt().equals("")?arOfcApplDtVO.getAplyDt():"";

			//A/R Office, Local Currency, Center Code, Region Code, Office Euro Mark, Office Agent Mark, Sub Agent Mark, 대표 customer code
			ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(arOfcCd);
			if(arOfcAttributeVO!=null){
				arCurrCd = arOfcAttributeVO.getArCurrCd();
				arCtrCd = arOfcAttributeVO.getArCtrCd();
				arHdQtrOfcCd = arOfcAttributeVO.getArHdQtrOfcCd();
				locCd = arOfcAttributeVO.getLocCd();
				rgnCd = arOfcAttributeVO.getRgnCd();
				soIfCd = arOfcAttributeVO.getSoIfCd();
				arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
				arCtrlOfcCd = arOfcAttributeVO.getArCtrlOfcCd();
				repCustCntCd = arOfcAttributeVO.getRepCustCntCd();
				repCustSeq = arOfcAttributeVO.getRepCustSeq();
				subAgnFlg = arOfcAttributeVO.getSubAgnFlg();
			}			
			
			arOfficeVO.setArOfcCd(arOfcCd);
			arOfficeVO.setCutOffAplyDtTpCd(cutOffAplyDtTpCd);
			arOfficeVO.setAplyDt(aplyDt);
			arOfficeVO.setArCurrCd(arCurrCd);
			arOfficeVO.setArCtrCd(arCtrCd);
			arOfficeVO.setArHdQtrOfcCd(arHdQtrOfcCd);
			arOfficeVO.setLocCd(locCd);
			arOfficeVO.setRgnCd(rgnCd);
			arOfficeVO.setSoIfCd(soIfCd);
			arOfficeVO.setArAgnStlCd(arAgnStlCd);
			arOfficeVO.setArCtrlOfcCd(arCtrlOfcCd);
			arOfficeVO.setRepCustCntCd(repCustCntCd);
			arOfficeVO.setRepCustSeq(repCustSeq);
			arOfficeVO.setSubAgnFlg(subAgnFlg);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return arOfficeVO;
	}
	
	/**
	 * Actual / Invoice Customer Code 를 조회한다<br>
	 * 
	 * @param CustInputVO custInputVO 
	 * @return ActInvCustVO
	 * @exception EventException
	 */
	public ActInvCustVO searchCustomerCode(CustInputVO custInputVO) throws EventException{
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		String actCustCntCd = "";
		String actCustSeq = "";
		String invCustCntCd = "";
		String invCustSeq = "";
		String chkCorrectFlg = "N";		
		try{
			invCustCntCd = custInputVO.getCustCntCd();
			invCustSeq = custInputVO.getCustSeq();
			
			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(custInputVO.getArOfcCd(),custInputVO.getBlSrcNo());
			chkCorrectFlg  = dbDao.searchCheckCorrectionInvoice(custInputVO.getArOfcCd(),custInputVO.getBlSrcNo());
				
			log.error("chkCorrectFlg= "+chkCorrectFlg);		
//			[CHM-201533751] BKG-AR Invoice Customer 정보 I/F 변경 관련 요청 - 2015.02.09
//			-Auto-Invoice를 위해서 실 지불화주의 정보를 최대한 정확히 하기 위해서 BKG에서 Cust. 정보가 변경되는 경우, 
//			메뉴얼로 AR Invoice에서 화주정보가 업데이트 된 것이 없는 상황에서 BKG에 업데이트 되면 
//			해당 화주정보를 받을 수 있도록 시스템 수정 - 즉 과거 I/F 된 화주정보를 이용하지 않고, 새로 BKG으로부터 I/F 받음.
			if(actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")&&chkCorrectFlg.equals("Y")){
					actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():invCustCntCd;
					actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():invCustSeq;
					invCustCntCd = actInvCustVO.getInvCustCntCd()!=null&&!actInvCustVO.getInvCustCntCd().equals("")?actInvCustVO.getInvCustCntCd():invCustCntCd;
					invCustSeq   = actInvCustVO.getInvCustSeq()!=null&&!actInvCustVO.getInvCustSeq().equals("")?actInvCustVO.getInvCustSeq():invCustSeq;
					
					log.error("cust code 1= "+actCustCntCd+actCustSeq);		
				
			}else{			
				
				//Charge Indicator = 'P' 또는 'C'
				if(custInputVO.getIoBndCd().equals("I")||custInputVO.getIoBndCd().equals("O")){
					
					//Office Euro Mark = 'C' 이고 Charge Indicator = 'P' 이고 Manual Booking 인 경우
					//if(custInputVO.getArCtrlOfcCd().equals("C")&&custInputVO.getIoBndCd().equals("O")&&custInputVO.getAutoMnlDivCd().equals("M")){
					//2009.11.17 Man Div 구분자 사용안하고, chn_agn_cd 로 구분. 오명석 수석님
					if(custInputVO.getArCtrlOfcCd().equals("C")&&custInputVO.getIoBndCd().equals("O")&&!custInputVO.getChnAgnCd().equals("")){
								
						//DLCSC 지역이고 Manual Booking Prefix = 'DB' 또는 TAOSC 지역이고 Manual Booking Prefix = 'TH' 또는 TSNSC 지역이고 Manual Booking Prefix = 'XB' 인 경우
						if((custInputVO.getArOfcCd().equals("DLCSC")&&custInputVO.getChnAgnCd().equals("DB"))||
								(custInputVO.getArOfcCd().equals("TAOSC")&&custInputVO.getChnAgnCd().equals("TH"))||
								(custInputVO.getArOfcCd().equals("TSNSC")&&custInputVO.getChnAgnCd().equals("XB"))){
							actCustCntCd = custInputVO.getCustCntCd();
							actCustSeq = custInputVO.getCustSeq();
						}else{
							//2010-05-19 AR_OFC 로 변경 이상희과장
							//actInvCustVO = dbDao.searchBKGAgentCustomer(custInputVO.getChnAgnCd(), custInputVO.getOfcCd());
							actInvCustVO = dbDao.searchBKGAgentCustomer(custInputVO.getChnAgnCd(), custInputVO.getArOfcCd());
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():"";
							actCustSeq = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():"";							
						}
					}
					
					//Bound Indicator = 'C' 이고 Office Euro Mark = 'C' 인 경우 
					//심유경 수석 2009.11.18 XMNSC일때  추가
					if((custInputVO.getIoBndCd().equals("I")&&custInputVO.getArCtrlOfcCd().equals("C"))||custInputVO.getArOfcCd().equals("XMNSC")){
						
						//AR Office 가 NKGSC 또는 XMNSC 인 경우
						if(custInputVO.getArOfcCd().equals("NKGSC")||custInputVO.getArOfcCd().equals("XMNSC")){
							actInvCustVO = dbDao.searchChinaCustomerCodeByVessel(custInputVO.getVvd().substring(0,4), custInputVO.getArOfcCd());
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():"";
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():"";							
						}
						
						//AR Office 가 NKGSC, XMNSC, SHARC 가 아닌 경우
						if(!custInputVO.getArOfcCd().equals("NKGSC")&&!custInputVO.getArOfcCd().equals("XMNSC")&&!custInputVO.getArOfcCd().equals("SHARC")){
							actInvCustVO = dbDao.searchChinaCustomerCodeByPort(custInputVO.getVvd(),custInputVO.getPortCd());
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():"";
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():"";					
						}
					}					
					
					//Charge Indicator = 'T' 인 경우
					if(custInputVO.getN3rdFlg().equals("Y")){
						actCustCntCd = custInputVO.getCustCntCd();
						actCustSeq = custInputVO.getCustSeq();
					}
					
					//2010.01.14 LEHSC일 때 
					if(custInputVO.getArOfcCd().equals("LEHSC")){
						actInvCustVO = dbDao.searchTroCustomerCode(custInputVO.getBkgNo(), custInputVO.getBkgSeq(), custInputVO.getOfcCd(), custInputVO.getIoBndCd());
						actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():"";
						actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():"";
					}
					
					//2010.03.05 SAOSC,DXXBB일 때
					if(custInputVO.getArOfcCd().equals("SAOSC")||custInputVO.getArOfcCd().equals("DXBSC")){
						InvSubAgnCustInputVO invSubAgnCustInputVO = new InvSubAgnCustInputVO();
						
						invSubAgnCustInputVO.setArOfcCd(custInputVO.getArOfcCd());
						invSubAgnCustInputVO.setIoBndCd(custInputVO.getIoBndCd());
						invSubAgnCustInputVO.setPolCd(custInputVO.getPolCd());
						invSubAgnCustInputVO.setPodCd(custInputVO.getPodCd());
						invSubAgnCustInputVO.setPorCd(custInputVO.getPorCd());
						invSubAgnCustInputVO.setDelCd(custInputVO.getDelCd());
						
						actInvCustVO  = dbDao.searchInvSubAgnCustomer(invSubAgnCustInputVO);
						actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():"";
						actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():"";
						
						//2010-04-05 DXBSC일때 invoice Cust도 변경
						if(custInputVO.getArOfcCd().equals("DXBSC")){
							invCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():invCustCntCd;
							invCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():invCustSeq;
						}
					}
					
					// 위 모든 해당 사항이 없을때 : 심유경 수석 2009.11.18(기존에는 마지막에 그냥 타게 되 있었음)
					if(actCustCntCd.equals("")||actCustSeq.equals("")){
						
						// Sub Agent Mark는 Booking Office로 구해서 세팅 (Customer Code 구할때 사용) 2010.01.04 이상희 과장
						ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(custInputVO.getOfcCd());
						String subAgnFlg = "";
						if(arOfcAttributeVO!=null){
							subAgnFlg = arOfcAttributeVO.getSubAgnFlg();
						}
						
						//Sub Agent Mark = 'N' 				
						if(subAgnFlg.equals("N")){
							actInvCustVO = dbDao.searchActualCustomerCode(invCustCntCd,invCustSeq);
							
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():custInputVO.getCustCntCd();
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():custInputVO.getCustSeq();							
						
						//Sub Agent Mark = 'Y' 일 때 Bkg Office의 대표 Customer	가져온다. 2010.01.04 이상희 과장
						}else if(subAgnFlg.equals("Y")){
							actInvCustVO = dbDao.searchRepCustomerCode(custInputVO.getOfcCd());
							
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():custInputVO.getCustCntCd();
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():custInputVO.getCustSeq();
							
						}else{							
							actCustCntCd = custInputVO.getCustCntCd();
							actCustSeq = custInputVO.getCustSeq();							
						}
					}
					
					log.debug("cust code 2= "+actCustCntCd+actCustSeq);
				}  
			}
			
			log.debug("cust code 3= "+actCustCntCd+actCustSeq);
			
			actInvCustVO.setActCustCntCd(actCustCntCd);
			actInvCustVO.setActCustSeq(actCustSeq);
			actInvCustVO.setInvCustCntCd(invCustCntCd);
			actInvCustVO.setInvCustSeq(invCustSeq);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return actInvCustVO;
	}
	
	/**
	 * Actual Customer 의 Credit Flag, Credit Term, Due Date 정보를 조회한다.<br>
	 * 
	 * @param ARCreditInputVO arCrdtVo
	 * @return ARCreditVO
	 * @exception EventException
	 */
	public ARCreditVO searchARCredit(ARCreditInputVO arCrdtVo) throws EventException{
		ARCreditVO aRCreditVO = new ARCreditVO();
		ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
		String dueDt = "";
		String crTermDys = "";
		String custCrFlg = "";
		String otsSmryCd = "";
		String svrId = "";
		int ifCnt = 0;
		
		try{
			invCreVo.setCustCntCd(arCrdtVo.getActCustCntCd());
			invCreVo.setCustSeq(arCrdtVo.getActCustSeq());
			invCreVo.setOfcCd(arCrdtVo.getArOfcCd());
			invCreVo.setSailArrDt(arCrdtVo.getSailArrDt().replace("-", ""));
			invCreVo.setIoBndCd(arCrdtVo.getIoBndCd());
			invCreVo.setDueDt("X");
			
			//2010-05-26 구주, INV 가 아닐 경우 단독 MRI일 때 TM,TN 인 경우  SailarrDt 가 아닌 CFMDT를 기준으로 가져오게 세팅한다.
			otsSmryCd = dbDao.searchOtsSmryCd(arCrdtVo.getArOfcCd());
			svrId = dbDao.searchServerID(arCrdtVo.getArOfcCd());
			
			if( arCrdtVo.getRevSrcCd() != null ){
				if( arCrdtVo.getRevSrcCd().equals("TM")||arCrdtVo.getRevSrcCd().equals("TN") ){
					if( !svrId.equals("EUR") && !otsSmryCd.equals("INV") ){
						if( arCrdtVo.getBlSrcNo() != null ){
							ifCnt = dbDao.checkMRIBlNoForDueDt(arCrdtVo.getBlSrcNo(), arCrdtVo.getArOfcCd());
							
							if( ifCnt == 0 ){
								invCreVo.setDueDt("");
							}
							log.debug("ifCnt = "+ifCnt);
						}
					}
				}
			}
			
			invCreVo.setLocCd(arCrdtVo.getLocCd());
			aRCreditVO = dbDao.searchCreditCustomerForCredit(invCreVo); 
			
			if(aRCreditVO != null){
				dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
				crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
				custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
			}
			//Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
			if(dueDt.equals("")||crTermDys.equals("0")){
				aRCreditVO = dbDao.searchOfficeForCredit(invCreVo);
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
					crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
					custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
				}
				
				//SZPSC, HKGSC 지역 Scope 이 IAA인 비신용화주의 경우 7일로 계산 2017.05.17
				if((arCrdtVo.getArOfcCd().equals("SZPSC") || arCrdtVo.getArOfcCd().equals("HKGSC")) && ("IAA").equals(arCrdtVo.getSvcScpCd())){
					dueDt = DateTime.addDays(arCrdtVo.getSailArrDt().replace("-", ""), 7);
					crTermDys = "7";
				}
			}
			
			
			// [CHM-201219996] BKG I/F시 PAYMENT DATE 적용  - DUE DATE  (BL 단위 관리 지역) - 2012.09.11
		    // Credit Customer에 Payment Day가 존재할 경우 이전에 구한 Due_dt에 신용화주별 Payment Day를 적용하여 새로 Due_dt를 구함.
	        // Paymet Day가 존재하지 않거나 신용화주가 아닐경우 입력받은 Due_dt를 유지함
			
			// 2016.04.21 백승일 MDM_CR_CUST 테이블의 PAY_TP_CD가 'W' 인경우 요일 을 이용하여 날짜를 가져와 DUE DATE 재 계산 
			String payTpCd = "";
			String tmpdueDt = "";
			ARCustPayDayVO aRCustPayDayVO = new ARCustPayDayVO();
			payTpCd = dbDao.searchPayTpCd(arCrdtVo.getActCustCntCd(), arCrdtVo.getActCustSeq());

			if(payTpCd != null && payTpCd.equals("W")){
				aRCustPayDayVO = dbDao.searchCustPayDay(dueDt, arCrdtVo.getActCustCntCd(), arCrdtVo.getActCustSeq());

				if(aRCustPayDayVO != null){
					String colPay1 = aRCustPayDayVO.getColPay1();
					String colPay2 = aRCustPayDayVO.getColPay2();
					String colPay3 = aRCustPayDayVO.getColPay3();
					String colPay4 = aRCustPayDayVO.getColPay4();
					String colPay5 = aRCustPayDayVO.getColPay5();
					String payWkDyCd = aRCustPayDayVO.getPayWkDyCd();

					tmpdueDt = 	dbDao.searchDueDateByWeekCustPayDay(dueDt, colPay1,colPay2,colPay3,colPay4,colPay5,payWkDyCd, arCrdtVo.getActCustCntCd(), arCrdtVo.getActCustSeq());
					if (!tmpdueDt.equals("")) {
						dueDt = tmpdueDt;
					}
				}
			}else{
			
				tmpdueDt = 	dbDao.searchDueDateByCustPayDay(dueDt, arCrdtVo.getActCustCntCd(), arCrdtVo.getActCustSeq());
				if (!tmpdueDt.equals("")) {
					dueDt = tmpdueDt;
				}
			}
			
			//[Office 가 미주지역이고 bnd = 'I' 인 경우] 비신용일때 추가(2009-12-07 이상희 과장)
			//2010-05-31 캐나다 추가
			//Dest Service Mode 가 'CIP', 'CML', 'NIP', 'MLB', 'IPI' 인 경우에 대해 위에서 구한 Due Date 에 8일을 더한다.
			if(arCrdtVo.getLocCd().equals("US")||arCrdtVo.getLocCd().equals("CA")){
				if(custCrFlg.equals("N")&&arCrdtVo.getIoBndCd().equals("I")&&!dueDt.equals("")){
					if(arCrdtVo.getDestTrnsSvcModCd().equals("CIP")||arCrdtVo.getDestTrnsSvcModCd().equals("CML")||
							arCrdtVo.getDestTrnsSvcModCd().equals("NIP")||arCrdtVo.getDestTrnsSvcModCd().equals("MLB")||
							arCrdtVo.getDestTrnsSvcModCd().equals("IPI")){
						if(!dueDt.equals("")){
							dueDt = DateTime.addDays(dueDt, 8);
						}
					}
				}
			}
			
			//2010-03-16 정영한 비신용화주이고 BOMSC 로 I/F 되는 BKG 중 DEL 이 INDEL, INLDH 인 것은 I/B Credit term 을 25일로 적용. 
			if(custCrFlg.equals("N")&&arCrdtVo.getIoBndCd().equals("I")&&arCrdtVo.getArOfcCd().equals("BOMSC")){
				if(arCrdtVo.getDelCd().equals("INDEL")||arCrdtVo.getDelCd().equals("INLDH")){
					if(!arCrdtVo.getSailArrDt().equals("")){
						crTermDys = "25";
						dueDt = DateTime.addDays(arCrdtVo.getSailArrDt().replace("-", ""), 25);
					}
				}				
			}
			
			//[Office 가 미주지역이고 bnd = 'I' 인 경우] 신용일때 추가(2015-06-17 문지영 대리 요청)

			//Dest Service Mode 가 'CIP', 'CML', 'NIP', 'MLB', 'IPI' 인 경우에 대해 위에서 구한 Due Date 에 8일을 더한다.
			if(arCrdtVo.getLocCd().equals("US")){
				if(custCrFlg.equals("Y")&&arCrdtVo.getIoBndCd().equals("I")&&!dueDt.equals("")){
					if(arCrdtVo.getDestTrnsSvcModCd().equals("CIP")||arCrdtVo.getDestTrnsSvcModCd().equals("CML")||
							arCrdtVo.getDestTrnsSvcModCd().equals("NIP")||arCrdtVo.getDestTrnsSvcModCd().equals("MLB")||
							arCrdtVo.getDestTrnsSvcModCd().equals("IPI")){
						if(!dueDt.equals("")){
							dueDt = DateTime.addDays(dueDt, 8);
						}
					}
				}
			}
			
 
			if(aRCreditVO != null){
				aRCreditVO.setDueDt(dueDt);
				aRCreditVO.setCrTerm(crTermDys);
				aRCreditVO.setCrFlg(custCrFlg);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return aRCreditVO;
	}
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성한다.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String eurFlg
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createBKGInvoice (ARInvoiceCreationVO invCreVo, String eurFlg, String userId) throws EventException{
		INVCommonUtil utilCmd = new INVCommonUtil();
		VVDExrateInputVO vvdExrateVo = new VVDExrateInputVO();
		String rtIfNo = "";
		String newIfNo = "";
		try {
			
			InvArMnVO invArMnVO = invCreVo.getInvArMnVO();
			List<InvArChgVO> invArChgVOs = invCreVo.getInvArChgVOs();
			List<InvArCntrVO> invArCntrVOs = invCreVo.getInvArCntrVOs();
			/*
			String maxSeq = dbDao.searchBKGInterfaceNo(invArMnVO.getArOfcCd());			
			
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), userId);
				maxSeq = "00000001";				
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, userId);
			}
			*/
			String maxSeq = dbDao.addInvArBkgIfNoTbl(invArMnVO.getArOfcCd(), userId);	
			
			if (maxSeq.equals("")){
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
			}	
			
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
//			String newIfNo = invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")?"LON"+ maxSeq:invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			//2010-02-18 김현화수석 FXTSC IFNO는 LON prefix사용
			//2015-12-29 백승일수석 GDYSC IFNO는 WRP prefix사용
			
			if(invArMnVO.getArOfcCd().substring(0, 3).equals("FXT")){
				newIfNo = "LON"+ maxSeq ;
			}else if(invArMnVO.getArOfcCd().substring(0, 3).equals("GDY")){
				newIfNo = "WRP"+ maxSeq ;
			}else{
				newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}
			
			invArMnVO.setArIfNo(newIfNo);			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			invArMnVO.setInvDeltDivCd("N");
			//Bkg Interface는 Split Flag null 로 세팅. 2009.11.24
			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd("N");			
			invArMnVO.setBlInvCfmDt("");
			//Main Table Iss Flg 세팅 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			
			//2010-02-11 칼럼추가
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START - LO CHG 관련 항목 초기화
			invArMnVO.setApArOffstNo("");
			//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			// 2014-08-06 [CHM-201431412] 미주지역 산하 Sales Rep I/F 로직 변경 요청
			// NYCRA 산하 중 하기 7개의 OFC에 대해서는, Contract Sales Rep을 기준으로 ERP에 I/F
			// ATLSC/CHISC/HOUSC/LGBSC/NYCSC/SEASC/TORSC
			String ctrtSrepCd = dbDao.searchContracSrepCd(invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
			
			if(!ctrtSrepCd.equals("")){
				invArMnVO.setSrepCd(ctrtSrepCd);
			}
			
			com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(invArMnVO.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invArMnVO.getInvCustSeq());
			vvdCustomerVo.setVsl(invArMnVO.getVslCd());
			vvdCustomerVo.setVoy(invArMnVO.getSkdVoyNo());
			vvdCustomerVo.setDep(invArMnVO.getSkdDirCd());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setSvcScp(invArMnVO.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invArMnVO.getIoBndCd());
			vvdCustomerVo.setOfcCd(invArMnVO.getArOfcCd());
			vvdCustomerVo.setBkgNo(invArMnVO.getBkgNo());
			vvdCustomerVo.setSaDt(invArMnVO.getSailArrDt());
			vvdCustomerVo.setPol(invArMnVO.getPolCd());
			vvdCustomerVo.setPod(invArMnVO.getPodCd());
			
			vvdExrateVo.setVsl(invArMnVO.getVslCd());
            vvdExrateVo.setVoy(invArMnVO.getSkdVoyNo());
            vvdExrateVo.setDep(invArMnVO.getSkdDirCd());
            vvdExrateVo.setBnd(invArMnVO.getIoBndCd());
            vvdExrateVo.setPol(invArMnVO.getPolCd());
            vvdExrateVo.setPod(invArMnVO.getPodCd());
            vvdExrateVo.setLclCurr(invArMnVO.getLoclCurrCd());
            vvdExrateVo.setSvcScp(invArMnVO.getInvSvcScpCd());
            vvdExrateVo.setOfcCd(invArMnVO.getArOfcCd());
			
            //BigDecimal invTtlLoclAmt = new BigDecimal("0");
			//int currPoint = 0;
			int exRateCnt = 0;
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String tjSrcNm = "";
				String invRevTpSrcCd = "";
				
				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());
				
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				
				//currPoint = dbDao.searchCurrencyPoint(invArChgVOs.get(i).getCurrCd());
				
				//BigDecimal chgAmt = new BigDecimal(invArChgVOs.get(i).getChgAmt());
				//BigDecimal exRate = new BigDecimal(exchangeRateVo.getExRate());	
				//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
				
				//log.debug("invTtlLoclAmt =" + invTtlLoclAmt);
				log.debug("createBKGInvoice :: getExRate =" + exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				
				if(exchangeRateVo.getExRate().equals("")||exchangeRateVo.getExRate().equals("0")){
					exRateCnt = exRateCnt + 1;
				}
				
				tjSrcNm = dbDao.searchTjSrcNm(invArMnVO.getArOfcCd(),invArChgVOs.get(i).getChgCd(), revTpSrcCd, svrId);
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
				
				invArChgVOs.get(i).setTjSrcNm(tjSrcNm);
				invArChgVOs.get(i).setArIfNo(newIfNo);
				invArChgVOs.get(i).setArIfSerNo("1");
				invArChgVOs.get(i).setSobId("1");				                                                                                                                           
				invArChgVOs.get(i).setMnlFlg("N");  
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");					
				invArChgVOs.get(i).setChgSeq(Integer.toString(i+1));
				invArChgVOs.get(i).setCreUsrId(userId);
				invArChgVOs.get(i).setUpdUsrId(userId);	
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());		
				
				
				//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 START
				// [CHM-201433108] ALPS > AR INVOICE > BKG DATA 인터페이스 로직 변경 요청 START		
				
				String locCd ="";
				
				ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
				
				if(arOfcAttributeVO!=null){
					locCd = arOfcAttributeVO.getLocCd();
				}
				
				if("M".equals(invArMnVO.getRevTpCd())||"US".equals(locCd.substring(0,2))||"CA".equals(locCd.substring(0,2))){
					String loclChgAcctCd = "";
					loclChgAcctCd = dbDao.searchLocalChgFlg(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd());
					if (!loclChgAcctCd.equals("")) {
					    invArChgVOs.get(i).setRevCoaAcctCd(loclChgAcctCd); 				    
					    if (loclChgAcctCd.equals("954117")) {
					        //dbDao.modifyArOffstNo(newIfNo, invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
					        invArMnVO.setApArOffstNo(invArMnVO.getArOfcCd().substring(0, 3)+" LCL CHRG");
					    }
					}
				}
				//2012-06-11 [CHM-201218102] AR INV 인터페이스 로직 보완 요청 END
				
				//VVD환율 0일때 VVD 환율 테이블에 Insert
				if((exchangeRateVo.getUsdExrateType().equals("V") && invArChgVOs.get(i).getCurrCd().equals("USD")) || (exchangeRateVo.getThirdExrateType().equals("V") && !invArChgVOs.get(i).getCurrCd().equals("USD"))){
					vvdExrateVo.setCurr(invArChgVOs.get(i).getCurrCd());
					if(!invArMnVO.getLoclCurrCd().equals(invArChgVOs.get(i).getCurrCd())){
						dbDao.addVVDExRate(vvdExrateVo,userId);
					}
				}
			}
			
			log.debug("exRateCnt==="+ exRateCnt);
			log.debug("exRateCnt==="+ exRateCnt);
			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			//VVD환율 0일때 VVD 환율 테이블에 Insert
			if(exchangeRateVo.getUsdExrateType().equals("V")){
				vvdExrateVo.setCurr("USD");	
				if(!invArMnVO.getLoclCurrCd().equals("USD")){
					dbDao.addVVDExRate(vvdExrateVo,userId);
				}
			}

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			//20100526 BKG 에서 넘겨준 ObrdDt 사용
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			
			//2010-02-11 쿼리에서 업데이트 하는걸로 수정
			//invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			dbDao.addInvMain(invArMnVO);			
			dbDao.addInvCharge(invArChgVOs);
			
			String euroExrateFlag = "N";
			////20110331 EU VAT 
			if(eurFlg.equals("Y")){
				if(exRateCnt > 0){
					dbDao.removeEuroCharge(newIfNo);
					euroExrateFlag = "Y";
				}else{
					dbDao.modifyEuroCharge(newIfNo, invArMnVO.getActCustCntCd(), invArMnVO.getSailArrDt());
				}
			}			
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}
			
			String erpIfOfcCd = "";
			
			if(svrId.equals("USA")&&invCreVo.getArAgnStlCd().equals("B")&&invArMnVO.getCustCrFlg().equals("Y")){
				
				//2010-05-13 이상희 과장 CA 도 추가
				if(invArMnVO.getActCustCntCd().equals("US")||invArMnVO.getActCustCntCd().equals("CA")){				
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
				
			}else if(svrId.equals("KOR")&&invArMnVO.getActCustCntCd().equals("KR")){
				if(invArMnVO.getCustCrFlg().equals("Y")){
					erpIfOfcCd = dbDao.searchCrCltOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				//비신용으로 변경 2009-12-16 김현화 수석
				}else if(invArMnVO.getIoBndCd().equals("I")&&invArMnVO.getCustCrFlg().equals("N")){
					erpIfOfcCd = dbDao.searchKrIbOffice(invArMnVO.getActCustCntCd(), invArMnVO.getActCustSeq());
				}
			}
			
			String invCoaAcctCd = "";
						
			if (invArAmtVOs.size() > 0) {
				for (int i = 0; i < invArAmtVOs.size(); i++) {
					
					invCoaAcctCd = dbDao.searchInvCoaAccount( invArAmtVOs.get(i).getTjSrcNm(), svrId , invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), invArMnVO.getAcctCd());
					
					invArAmtVOs.get(i).setArInvSrcCd("NISAR");
					invArAmtVOs.get(i).setInvCoaCoCd(invCoaCoCd);
					invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
					invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
					invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
					invArAmtVOs.get(i).setInvCoaInterCoCd(invCoaInterCoCd);
					invArAmtVOs.get(i).setInvCoaVslCd("0000");
					invArAmtVOs.get(i).setInvCoaVoyNo("0000");
					invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
					invArAmtVOs.get(i).setInvCoaRevDirCd("0");
					invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
					invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
					invArAmtVOs.get(i).setCreUsrId(userId);
					invArAmtVOs.get(i).setUpdUsrId(userId);	
				}
			}
			
			dbDao.addInvAmount(invArAmtVOs);
			
			dbDao.modifyInvArChg(newIfNo);	
			
			//2014-08-28 COA Center Code ERP_IF_OFC_CD 기준으로 Update
			dbDao.modifyInvCoaCtrCd(newIfNo);
			dbDao.modifyInvCoaCtrCdToAmt(newIfNo);
			
			//2010-02-11 추가 쿼리에서 업데이트 하는걸로 수정
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(userId);
					invArCntrVOs.get(i).setUpdUsrId(userId);
				}
			}

			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, userId);
			}
			
			/*
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO ifNo = new InvArIfNoVO();
			ifNo.setIfNo(newIfNo);
			ifNos.add(ifNo);
			*/
			
			int cnt = dbDao.checkAccountRateExist(invArMnVO.getGlEffDt());
			
			//----------------HAN 2010-04-07 revVslCd, revSkdDirCd, revSkdVoyNo, sailArrDt, sailDt, dueDt, xchRtN3rdTpCd, xchRtUsdTpCd, arCtyCd, glEffDt, actCustSeq
			//----------------이 없을 경우 , 아래 메소드 호출하도록 수정함.(bl_inv_cfm_dt)
			String revVslCd2 		 =	invArMnVO.getRevVslCd();
			String revSkdDirCd2      =	invArMnVO.getRevSkdDirCd();
			String revSkdVoyNo2      =	invArMnVO.getRevSkdVoyNo();
			String sailArrDt2        =	invArMnVO.getSailArrDt();
			String sailDt2           =	invArMnVO.getSailDt();
			String dueDt2            =	invArMnVO.getDueDt();
			String xchRtN3rdTpCd2    =	invArMnVO.getXchRtN3rdTpCd();
			String xchRtUsdTpCd2     =	invArMnVO.getXchRtUsdTpCd();
			String arCtyCd2          =	invArMnVO.getArCtyCd();
			String glEffDt2          =	invArMnVO.getGlEffDt();
			String actCustSeq2       =	invArMnVO.getActCustSeq();
			
			if(revVslCd2 == null) revVslCd2 = "";
			if(revSkdDirCd2 == null) revSkdDirCd2 = "";
			if(revSkdVoyNo2 == null) revSkdVoyNo2 = "";
			if(sailArrDt2 == null) sailArrDt2 = "";
			if(sailDt2 == null) sailDt2 = "";
			if(dueDt2 == null) dueDt2 = "";
			if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
			if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
			if(arCtyCd2 == null) arCtyCd2 = "";
			if(glEffDt2 == null) glEffDt2 = "";
			if(actCustSeq2 == null) actCustSeq2 = "";
			
			if (cnt > 0) {
				if(revVslCd2.equals("") || revSkdDirCd2.equals("") || revSkdVoyNo2.equals("") || sailArrDt2.equals("") || sailDt2.equals("") || dueDt2.equals("")
						|| xchRtN3rdTpCd2.equals("") || xchRtUsdTpCd2.equals("") || arCtyCd2.equals("") || glEffDt2.equals("") || actCustSeq2.equals("")
						|| euroExrateFlag.equals("Y")){
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
				}else{
					// [경리환율 존재하는 경우] ERP I/F 처리
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					//2009-12-04 Bkg IF 끝난 후 한꺼번에 전송하는 방식 으로 변경
					rtIfNo = newIfNo;
				}
				//interfaceARInvoiceToERPAR(ifNos, "C"); 
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return rtIfNo;
	}
	
	/**
	 * INV 에서 발생한 매출채권 정보를 EAI를 통해(FNS012-0001) ERP AR로 전송다 한<br> 
	 * Session에서 다수 I/F NO발생시 를 배열로 받아 한번에 처리해야 함.<br>
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @param String flag
	 * @exception EventException
	 */
	public void interfaceARInvoiceToERPAR(List<InvArIfNoVO> ifNos, String flag) throws EventException{
		
		List<Fns0120001VO> fns0120001VOs =  new ArrayList<Fns0120001VO>();;
		
		try {
			if(ifNos.size()>0){
				
				for (int i = 0; i <ifNos.size(); i++) {
					List<Fns0120001VO> list1= null;					
					List<CntrTypeSizeVO> cntrTypeSizeVOs = null;
					List<InvArCntrVO> invArCntrVOs = null;
					
					String cntrNos = "";
					String cntrTpSzs = "";
					
					
					list1 = dbDao.searchARInvoiceForERP(ifNos.get(i).getIfNo(), flag);
					
					invArCntrVOs = dbDao.searchARInvoiceContainer(ifNos.get(i).getIfNo());
					
					// ERP 전송 처리 시작
					if (invArCntrVOs.size() > 0) {
						StringBuffer cntrNosBuff = new StringBuffer();
						for (int j = 0; j < invArCntrVOs.size(); j++) {
							cntrNosBuff.append(invArCntrVOs.get(j).getCntrNo() + (j != invArCntrVOs.size() - 1 ? "," : ""));
//							cntrNos = cntrNos + invArCntrVOs.get(j).getCntrNo() + (j != invArCntrVOs.size() - 1 ? "," : "");
						}
						cntrNos = cntrNosBuff.toString();
						
						int lastIdx = 0;
						if (cntrNos.length() > 150) {
							
							cntrNos = cntrNos.substring(0, 150);
							//log.debug("\n########## cntrNos2 : " + cntrNos);
							
							lastIdx = cntrNos.lastIndexOf(",");						
							//log.debug("\n########## lastIdx : " + lastIdx);
							
							cntrNos = cntrNos.substring(0, lastIdx);						
							//log.debug("\n########## cntrNos3 : " + cntrNos);
													
						}
						log.debug("########## cntrNos : " + cntrNos);
	
						cntrTypeSizeVOs = dbDao.searchCntrTpSzForERP(ifNos.get(i).getIfNo());
	
						StringBuffer cntrTpSzsBuff = new StringBuffer();
						for (int k = 0; k < cntrTypeSizeVOs.size(); k++) {
							cntrTpSzsBuff.append(cntrTypeSizeVOs.get(k).getCntrTpszCd() + "X" + cntrTypeSizeVOs.get(k).getCntrTpszCnt() + (k != cntrTypeSizeVOs.size() - 1 ? "," : ""));
//							cntrTpSzs = cntrTpSzs + cntrTypeSizeVOs.get(k).getCntrTpszCd() + "X" + cntrTypeSizeVOs.get(k).getCntrTpszCnt() + (k != cntrTypeSizeVOs.size() - 1 ? "," : "");
						}
						cntrTpSzs = cntrTpSzsBuff.toString();
						log.debug("########## cntrTpSzs : " + cntrTpSzs);
					}					
	
					for (int l = 0; l < list1.size(); l++) {
						list1.get(l).setCntrNo(cntrNos);
						list1.get(l).setCntrTpSz(cntrTpSzs);
					}
					
					fns0120001VOs.addAll(list1);					
				}
				
				eaiDao.interfaceARInvoiceToERPAR(fns0120001VOs);
			}
		
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String arIfNo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO modifyMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String arIfNo, String userId) throws EventException {
		ARCreditVO aRCreditVO = new ARCreditVO();
        ARCreditInputVO arCrdtVo = new ARCreditInputVO();				
		MRIRevenueVVDLaneVO mriRevenueVVDLane = new MRIRevenueVVDLaneVO();
		InvArMnVO invMain = new InvArMnVO();
		InvArChgVO invChgeVo = new InvArChgVO();
		INVCommonUtil utilCmd = new INVCommonUtil();
		VVDCustomerVO vvdCustomerVo = null;
		com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
		ActInvCustVO actInvCustVo = null;

		String laneCd = "";
		String zoneIoc = "";
		String cityCd = "";
		String blObrdDt = "";
		String sailingDt = "";
		String effDt = "";
		String subsCoCd = "";
		//String acctDivCd = "";
		String tjSrcNm = "";
		String invAcctDivCd = "";
		String acctCd = "";
		String invCoaAcctCd = "";
		String localTime = "";
		
		String invCustCntCd = "";
		String invCustSeq = "";
		
		String dueDt = "";
        String crTermDys = "0";
        String custCrFlg = "N";
		
		String trunkVvd = "";
        String port = "";
        
        String tVslCd = "";
		
		//List<Fns0120001VO> list3 = null;
		
		//log.info("\n########## arIfNo : "+arIfNo);
		
        String otsSmryCd = "";
        List<ArOfcAttributeVO> arOfcAttributeVOs = null;
        
        String clzStsCd = "";
        
        String svrId = invCreVo.getSvrId();
        
        String loclChgAcctCd = "";
        
        //String ofcAgentMark = "";
        String erpIfOfcCd = "";
        MdmOrganizationVO mdmOrgVo = null;
		
		try {
			
//			arCrdtVo = dbDao.searchCreditCustomerForCredit(invCreVo);
//
//			if (arCrdtVo == null) {
//				arCrdtVo = dbDao.searchOfficeForCredit(invCreVo);
//			}
//			
//			if (arCrdtVo != null) {
//		        dueDt = arCrdtVo.getDueDt();
//		        crTermDys = arCrdtVo.getCrTerm();
//		        custCrFlg = arCrdtVo.getCrFlg();
//			}
//			
//			log.info("\n########## dueDt : "+dueDt);
//			log.info("\n########## crTermDys : "+crTermDys);
//			log.info("\n########## custCrFlg : "+custCrFlg);
//			
//			if (dueDt.equals("") || crTermDys.equals("0")) {
//	    		// Credit Customer 에 data 가 존재하지 않거나 Credit term = 0 인 경우
//				arCrdtVo = dbDao.searchOfficeForCredit(invCreVo);
//				if (arCrdtVo != null) {
//			        dueDt = arCrdtVo.getDueDt();
//			        crTermDys = arCrdtVo.getCrTerm();
//			        custCrFlg = arCrdtVo.getCrFlg();					
//				}
//	    	}
			
			arCrdtVo.setActCustCntCd(invCreVo.getCustCntCd());
			arCrdtVo.setActCustSeq(invCreVo.getCustSeq());
			arCrdtVo.setArOfcCd(invCreVo.getOfcCd());
			arCrdtVo.setSailArrDt(invCreVo.getSailArrDt());
			arCrdtVo.setIoBndCd(invCreVo.getIoBndCd());
			arCrdtVo.setLocCd(invCreVo.getLocCd());
			arCrdtVo.setDelCd(invCreVo.getDelCd());
			arCrdtVo.setBlSrcNo(invCreVo.getBlNo());
			arCrdtVo.setRevSrcCd(invCreVo.getRevSrcCd());
			
			aRCreditVO = searchARCredit(arCrdtVo);
						
			if (!invCreVo.getDueDt().replace("-", "").equals("")) {
				
				dueDt = invCreVo.getDueDt().replace("-", "");
				if(aRCreditVO != null){
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
				
				log.info("\n########## dueDt1 : "+dueDt);
			
			} else {				
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt();
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
				
				log.info("\n########## dueDt2 : "+dueDt);
									
			}
			
			log.info("\n########## dueDt : "+dueDt);
			log.info("\n########## crTermDys : "+crTermDys);
			log.info("\n########## custCrFlg : "+custCrFlg);	
			
			laneCd = dbDao.searchLaneCode(invCreVo.getLclVvd());

			zoneIoc = dbDao.searchZoneIOC(invCreVo.getPolCd(), invCreVo.getPodCd());

			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, zoneIoc,invCreVo.getPodCd());
			log.info("\n########## mriRevenueVVDLane1");
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO",invCreVo.getPodCd()); 
				log.info("\n########## mriRevenueVVDLane2");
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd,invCreVo.getPodCd());
				log.info("\n########## mriRevenueVVDLane3");
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				//rev_src_cd가 'RD'인 경우 vsl을 'CNTC'로 변경하고
				if (invCreVo.getRevSrcCd().equals("RD")) {
					tVslCd = "CNTC";
				} else {
					tVslCd = invCreVo.getLclVvd().substring(0, 4);
				}
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
				log.info("\n########## mriRevenueVVDLane4");
			}
					
			if (mriRevenueVVDLane.getRevVvd().equals("") || mriRevenueVVDLane.getRevLane().equals("")) {
				throw new EventException(new ErrorHandler("INV00119",new String[]{}).getMessage());
			}
			
			cityCd = dbDao.searchCityCd(invCreVo.getOfcCd());
			
			localTime = dbDao.searchLocalTime(invCreVo.getOfcCd());
						
			if (invCreVo.getBkgNo() != null && !invCreVo.getBkgNo().equals("")) {
				sailingDt = dbDao.searchSailingDateByBkgNo(invCreVo.getBkgNo());
				log.info("\n########## sailingDt1 : "+sailingDt);
			} else{
				sailingDt= dbDao.searchSailingDateByBlNo(invCreVo.getBlSrcNo());
			}
			
			//sailing dt 없으면 VVD Pol로	
			if(sailingDt.equals("")) sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
			
			if (sailingDt.equals("")) {
				//sailing dt 없으면 VVD 해당 Port로	 			
				if (invCreVo.getIoBndCd().equals("I")) {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPodCd());
				} else {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
				}
			}
			log.info("\n########## sailingDt2 : "+sailingDt);			
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
				sailingDt = localTime;
			} 
			
			if (sailingDt.equals("")) {
				throw new EventException(new ErrorHandler("INV00132",new String[]{}).getMessage());
			}

//			effDt = dbDao.searchEffectiveDate(invCreVo.getOfcCd(), sailingDt,invCreVo.getRevTpCd(),invCreVo.getRevSrcCd());
//			log.info("\n########## effDt2 : "+effDt);
//			
//			if (effDt.equals("")) {
//				throw new EventException(new ErrorHandler("INV00122",new String[]{}).getMessage());
//			}	
			
			effDt = invCreVo.getEffDt().replaceAll("-", "");
			log.info("\n########## effDt333 : "+effDt);
			
			clzStsCd = dbDao.searchClosingStatus(invCreVo.getOfcCd(), effDt, "M");
			
			if (!clzStsCd.equals("O")) {
				throw new EventException(new ErrorHandler("INV00015",new String[]{}).getMessage());
			}

			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());

			//acctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd() + invCreVo.getRevSrcCd());
			
			actInvCustVo = dbDao.searchInvCustomer(invCreVo.getBlNo(), invCreVo.getOfcCd());
			
			trunkVvd = invCreVo.getTrunkVvd();
			
			if (trunkVvd.length() == 9) {

				port = invCreVo.getIoBndCd().equals("O")?invCreVo.getPolCd():invCreVo.getPodCd();
				
				// 운항 스케줄에서 trunk vvd 체크
				if (dbDao.checkVskVslPortSkd(trunkVvd, port) 
					&& !trunkVvd.substring(0, 4).equals("CFDR") && !trunkVvd.substring(0, 4).equals("USAC")) {
					
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					
					log.info("\n########## trunkVvd1 : "+trunkVvd);
					
				} else {
					
					trunkVvd = dbDao.searchTrunkVvd();
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					log.info("\n########## trunkVvd2 : "+trunkVvd);
					
				}			
				
			} else {
				
				if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
					
					invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
					invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
					invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
					
				} else {
					
					trunkVvd = dbDao.searchTrunkVvd();
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					log.info("\n########## trunkVvd3 : "+trunkVvd);
					
				}
				
			}
			
			log.info("\n########## trunkVvd4 : "+trunkVvd);
			
			if (actInvCustVo == null) {
				invCustCntCd = invCreVo.getCustCntCd();
				invCustSeq = invCreVo.getCustSeq();		
			} else {
				invCustCntCd = actInvCustVo.getInvCustCntCd();
				invCustSeq = actInvCustVo.getInvCustSeq();
			}

			///////////////////////////////////////////////////////////////////////////////////////

			List<BkgChgeListVO> bkgChgeListVOs = invCreVo.getBkgChgeListVOs();
			String rev_types_mn = invCreVo.getRevTpCd() + invCreVo.getRevSrcCd();

			if (rev_types_mn.equals("MCT")) {
				invCoaAcctCd = "110811";
			} else if (rev_types_mn.equals("MTP") || rev_types_mn.equals("MRD")) {
				invCoaAcctCd = "111091";
			} else {
				invCoaAcctCd = "110611";
			}
			
			BigDecimal totalLocalAmt = new BigDecimal(0);
			BigDecimal sum = new BigDecimal(0);
			int currPoint = 0;
			
			for (int i = 0; i < bkgChgeListVOs.size(); i++) {
				currPoint = dbDao.searchCurrencyPoint(bkgChgeListVOs.get(i).getCurrCd());

				sum = new BigDecimal(bkgChgeListVOs.get(i).getTrfRtAmt()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getRatAsCntrQty()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getInvXchRt())));
				
				//if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
				//	sum = new BigDecimal(sum.floatValue() / 100);
				//}
				
				BigDecimal pcAmt = new BigDecimal("100");
				if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
					sum = sum.divide(pcAmt);
				}
				
				totalLocalAmt = totalLocalAmt.add(sum.setScale(currPoint,BigDecimal.ROUND_HALF_UP));

			}
			
			log.info("\n########## totalLocalAmt : "+totalLocalAmt);

			invMain.setArIfNo(arIfNo);
			invMain.setBlNo(invCreVo.getBlNo());
			if (invCreVo.getBkgNo().equals("")) {
				invMain.setBkgNo(invCreVo.getBlNo());
			} else {
				invMain.setBkgNo(invCreVo.getBkgNo());
			}
			invMain.setBlSrcNo(invCreVo.getBlNo());
			invMain.setActCustCntCd(invCreVo.getCustCntCd());
			invMain.setActCustSeq(invCreVo.getCustSeq());
			invMain.setArOfcCd(invCreVo.getOfcCd());
			invMain.setRevTpCd(invCreVo.getRevTpCd());
			invMain.setRevSrcCd(invCreVo.getRevSrcCd());
			invMain.setVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setLoclCurrCd(invCreVo.getLclCurr());
			invMain.setSvcScpCd(invCreVo.getSvcScpCd());
			// 2011.07.11 박성진 [CHM-201111849] 요청으로 일본지역 O/B 에 대해서도 OTH 적용
			if (svrId.equals("EUR") || svrId.equals("KOR") || (svrId.equals("JPN")&&invCreVo.getIoBndCd().equals("O"))) {
				invMain.setInvSvcScpCd("OTH");
			} else {
				invMain.setInvSvcScpCd(invCreVo.getSvcScpCd());
			}
			invMain.setSailDt(sailingDt);
			invMain.setSailArrDt(invCreVo.getSailArrDt());
			invMain.setSlanCd(laneCd);
			invMain.setIoBndCd(invCreVo.getIoBndCd());
			
			//----------------HAN 2010-04-06 START
			if (svrId.equals("KOR") || svrId.equals("ENT")) {
				invMain.setArTaxIndCd("KOR");
			}
			//----------------HAN 2010-04-06 END
			
//			if (invCreVo.getTrunkVvd().length() == 9) {
//				invMain.setTrnkVslCd(invCreVo.getTrunkVvd().substring(0, 4));
//				invMain.setTrnkSkdVoyNo(invCreVo.getTrunkVvd().substring(4, 8));
//				invMain.setTrnkSkdDirCd(invCreVo.getTrunkVvd().substring(8, 9));
//			}
			invMain.setPorCd(invCreVo.getPorCd());
			invMain.setPolCd(invCreVo.getPolCd());
			invMain.setPodCd(invCreVo.getPodCd());
			invMain.setDelCd(invCreVo.getDelCd());
			invMain.setCustCrFlg(custCrFlg);
			invMain.setInvCustCntCd(invCustCntCd);
			invMain.setInvCustSeq(invCustSeq);
			invMain.setDueDt(dueDt);
			invMain.setGlEffDt(effDt);
			invMain.setBkgRefNo(invCreVo.getBkgRefNo());
			invMain.setInvRefNo(invCreVo.getInvRefNo());
			invMain.setSiRefNo(invCreVo.getSiRefNo());
			invMain.setHjsStfCtnt(invCreVo.getHjsRef());
			//invMain.setUsdXchRt(usdXchRt);
			invMain.setXchRtUsdTpCd(invCreVo.getUsdExrateType());
			invMain.setXchRtN3rdTpCd(invCreVo.getThirdExrateType());
			invMain.setXchRtDt(invCreVo.getExRateDate());
			invMain.setObrdDt(blObrdDt);
			invMain.setInvTtlLoclAmt(String.valueOf(totalLocalAmt));
			if (mriRevenueVVDLane.getRevVvd().length() == 9) {
				invMain.setRevVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
				invMain.setRevSkdVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
				invMain.setRevSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
				invMain.setRevDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
			} else if (mriRevenueVVDLane.getRevVvd().length() == 10) {
				invMain.setRevVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
				invMain.setRevSkdVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
				invMain.setRevSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
				invMain.setRevDirCd(mriRevenueVVDLane.getRevVvd().substring(9,10));        
			}
			invMain.setRlaneCd(mriRevenueVVDLane.getRevLane());
			invMain.setZnIocCd(zoneIoc);
			invMain.setCrTermDys(crTermDys);
			invMain.setArCtyCd(cityCd);
			invMain.setSlsOfcCd(invCreVo.getOfcCd());
			invMain.setArInvSrcCd("NISAR");
			invMain.setInvCoaAcctCd(invCoaAcctCd);
			invMain.setInvCoaInterCoCd(subsCoCd);
			invMain.setCreUsrId(userId);
			invMain.setUpdUsrId(userId);
			invMain.setInvRmk(invCreVo.getInvRmk());
			invMain.setCgoWgt("0");
			invMain.setCgoMeasQty("0");			
			invMain.setBkgTeuQty(invCreVo.getBkgTeuQty());
			invMain.setBkgFeuQty(invCreVo.getBkgFeuQty());
			invMain.setMstBlNo(invCreVo.getMasterInv());
			
			vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(invCreVo.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invCreVo.getInvCustSeq());
			vvdCustomerVo.setVsl(invCreVo.getLclVvd().substring(0, 4));
			vvdCustomerVo.setVoy(invCreVo.getLclVvd().substring(4, 8));
			vvdCustomerVo.setDep(invCreVo.getLclVvd().substring(8, 9));
			vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());
			//vvdCustomerVo.setSvcScp(invCreVo.getSvcScpCd());
			vvdCustomerVo.setSvcScp(invMain.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invCreVo.getIoBndCd());
			vvdCustomerVo.setOfcCd(invCreVo.getOfcCd());
			vvdCustomerVo.setBkgNo(invCreVo.getBkgNo());
			vvdCustomerVo.setSaDt(invCreVo.getSailArrDt());
			vvdCustomerVo.setPol(invCreVo.getPolCd());
			vvdCustomerVo.setPod(invCreVo.getPodCd());
			vvdCustomerVo.setCurr("USD");  
			//2010-04-27 blNo 추가
			vvdCustomerVo.setBlSrcNo(invCreVo.getBlSrcNo());
			
			
			log.info("\n########## invCreVo.getCustCntCd() : "+invCreVo.getCustCntCd());
			log.info("\n########## invCreVo.getCustSeq() : "+invCreVo.getCustSeq());

			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			invMain.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invMain.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			//invMain.setAcctXchRtYrmon(exchangeRateVo.getExRateDate());
			invMain.setUsdXchRt(exchangeRateVo.getExRate());			
			if (effDt.length() > 6) {
				invMain.setAcctXchRtYrmon(effDt.substring(0, 6));
			}			
			//invMain.setBlInvCfmDt(localTime);
			invMain.setInvDeltDivCd("N");
			
			otsSmryCd  = dbDao.searchOtsSmryCd(invCreVo.getOfcCd());
			
			log.info("\n########## otsSmryCd : "+otsSmryCd);
			
			if (otsSmryCd.equals("INV")) {
				
				arOfcAttributeVOs = dbDao.searchRepCustCdByArOfcCd(invCreVo.getOfcCd());
				
				for (int i = 0; i < arOfcAttributeVOs.size(); i++) {
					if (invCreVo.getCustCntCd().equals(arOfcAttributeVOs.get(i).getRepCustCntCd()) 
						&& Integer.parseInt(invCreVo.getCustSeq()) == Integer.parseInt(arOfcAttributeVOs.get(i).getRepCustSeq())) {
						throw new EventException(new ErrorHandler("INV00123",new String[]{}).getMessage());
					}
				
				}
								
			}	
			
			//dbDao.modifyARInvoiceMain(invMain, userId);
			
			//2010-04-23
			/*
			if (bkgChgeListVOs != null) {
				List<InvArChgVO> addVoList = new ArrayList<InvArChgVO>();
				//String rev_types = invCreVo.getRevType() + invCreVo.getRevTpCd();
				//String svrId = invCreVo.getSvrId();
				String chg_cd = "";
				String repChgCd = "";					
				String chgFullNm = "";
				
				BigDecimal chgAmt = new BigDecimal(0);
				
				for (int i = 0; i < bkgChgeListVOs.size(); i++) {
					InvArChgVO invChges = new InvArChgVO();
					chg_cd = bkgChgeListVOs.get(i).getChgCd();
					repChgCd = dbDao.searchRepCharge(chg_cd); 				
					chgFullNm = dbDao.searchChargeName(chg_cd);
					
					invAcctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd(), invCreVo.getRevSrcCd()); 
					
					if (invAcctDivCd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(bkgChgeListVOs.get(i).getChgCd()); 
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(bkgChgeListVOs.get(i).getChgCd()); 
					}

					acctCd = dbDao.searchAccountCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd(), invCreVo.getRevSrcCd(), svrId, acctCd);
					
					invChgeVo = dbDao.searchInvRevTpSrcCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo, svrId, acctCd);
										
					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
					
					loclChgAcctCd = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
					
					if (!loclChgAcctCd.equals("")) {
						
						invChges.setRevCoaAcctCd(loclChgAcctCd); 
						
						dbDao.modifyArOffstNo(arIfNo, invCreVo.getOfcCd().substring(0, 3)+" LCL CHRG");
						
					}
					
					//2010-04-16 rate*rate as 안하고 그냥 chgamt 사용 음수를 양수로 변환시키는거 방지
					//chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getTrfRtAmt()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getRatAsCntrQty()));
					chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getChgAmt().replace(",",""));
					
					//if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
					//	chgAmt = new BigDecimal(chgAmt.floatValue() / 100);
					//}
					
					BigDecimal pcAmt = new BigDecimal("100");
					if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
						chgAmt = chgAmt.divide(pcAmt);
					}
					
					log.info("\n########## chgAmt["+i+"] : "+chgAmt);
										
					invChges.setArIfNo(arIfNo);
					invChges.setArIfSerNo(bkgChgeListVOs.get(i).getArIfSerNo());
					invChges.setChgSeq(bkgChgeListVOs.get(i).getChgSeq());
					invChges.setChgCd(bkgChgeListVOs.get(i).getChgCd());
					invChges.setCurrCd(bkgChgeListVOs.get(i).getCurrCd().substring(0, 3));
					invChges.setPerTpCd(bkgChgeListVOs.get(i).getPerTpCd());
					invChges.setTrfRtAmt(bkgChgeListVOs.get(i).getTrfRtAmt());
					invChges.setRatAsCntrQty(bkgChgeListVOs.get(i).getRatAsCntrQty());
					invChges.setChgAmt(String.valueOf(chgAmt));
					invChges.setInvXchRt(bkgChgeListVOs.get(i).getInvXchRt());
					//invChges.setInvRevTpSrcCd(invCreVo.getRevType() + invCreVo.getRevTpCd());
					invChges.setOfcCd(invCreVo.getOfcCd());
					//invChges.setRevCoaAcctCd(acctCd);
					invChges.setRevCoaInterCoCd(subsCoCd);
					if (mriRevenueVVDLane.getRevVvd().length() == 9) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
					} else if (mriRevenueVVDLane.getRevVvd().length() == 10) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(9,10));        
					}
					invChges.setAcctCd(acctCd);
					invChges.setTvaFlg(bkgChgeListVOs.get(i).getTvaFlg().equals("1") ? "Y" : "N");
					invChges.setChgRmk(bkgChgeListVOs.get(i).getChgRmk());
					invChges.setCreUsrId(userId);
					invChges.setUpdUsrId(userId);
					invChges.setRepChgCd(repChgCd);
					invChges.setChgFullNm(chgFullNm);
					
					invChges.setInvRevTpSrcCd(invChgeVo.getInvRevTpSrcCd()); 
					invChges.setRevCoaCoCd(invChgeVo.getRevCoaCoCd());
					invChges.setRevCoaRgnCd(invChgeVo.getRevCoaRgnCd());
					invChges.setRevCoaCtrCd(invChgeVo.getRevCoaCtrCd());
					//invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd()); 
					
					tjSrcNm = dbDao.searchTjSrcNm(bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd()+invCreVo.getRevSrcCd(), svrId);

					//log.info("   \n########## tjSrcNm : "+tjSrcNm);
					
					invChges.setTjSrcNm(tjSrcNm);

					addVoList.add(invChges);

				}				
				
				if (addVoList.size() > 0) {
					dbDao.modifyARInvoiceCharge(addVoList, userId);
				}
												
			}
			
			
			mdmOrgVo = dbDao.searchOfficeAttributeMri(invCreVo.getOfcCd());
	        ofcAgentMark = mdmOrgVo.getArAgnStlCd();
	        			
	        if(svrId.equals("USA") && ofcAgentMark.equals("B") && custCrFlg.equals("Y") && invCreVo.getCustCntCd().equals("US")) {
	        	 
	        	erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 					

	        } else if (svrId.equals("KOR") && invCreVo.getCustCntCd().equals("KR")) {
	        	
	        	if(custCrFlg.equals("Y")) {
	        		
	        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 						
	        	
	        	}								
	        }

	        if (erpIfOfcCd.equals("")) {
	        	erpIfOfcCd = invCreVo.getOfcCd();
	        }
			
			dbDao.modifyInvCoaInterCoCd(arIfNo, subsCoCd, effDt, erpIfOfcCd, userId);
			*/
			
			int seq = 1;
	        
	        int ifSalar = 0;
	        int ifNonre = 0;
	        int ifMriar = 0;
	        int ifOther = 0;
	        int ifVat = 0;
	        int ifWhf = 0;
	        int ifCtt = 0;
	        int if3rd = 0;
	        int ifXxx = 0;
	        
	        //int erpSalar = 1;
	        //int erpNonre = 1;
	        //int erpMriar = 1;
	        //int erpOther = 1;
	        //int erpVat = 1;
	        //int erpWhf = 1;
	        //int erpCtt = 1;
	        //int erp3rd = 1;
	        //int erpXxx = 1;
	        
	        int erpSalar = 0;
	        int erpNonre = 0;
	        int erpMriar = 0;
	        int erpOther = 0;
	        int erpVat = 0;
	        int erpWhf = 0;
	        int erpCtt = 0;
	        int erp3rd = 0;
	        int erpXxx = 0;
			
	        InvArAmtVO invArAmtVo = null;
	        
			if (bkgChgeListVOs != null) {
				List<InvArChgVO> addVoList = new ArrayList<InvArChgVO>();
				//String rev_types = invCreVo.getRevType() + invCreVo.getRevTpCd();
				//String svrId = invCreVo.getSvrId();
				String chg_cd = "";
				String curr_cd = "";
				
				String invCoaRgnCd = "";
				String invCoaCtrCd = "";
				//String localTime = "";	
				String rhq = "";
				String mriMaxYymm = "";
				//String glEffDt = "";
				//String ofcAgentMark = "";
				//String erpIfOfcCd = "";
				//String custCrFlg = "";
				String repChgCd = "";					
				String chgFullNm = "";
				//MdmOrganizationVO mdmOrgVo = null;		
				DueDateVO dueDateVo = null;
				
				mdmOrgVo = dbDao.searchOfficeAttributeMri(invCreVo.getOfcCd());
				invCoaRgnCd = mdmOrgVo.getFincRgnCd();
		        invCoaCtrCd = mdmOrgVo.getArCtrCd();
		        rhq = mdmOrgVo.getArHdQtrOfcCd();
		        //ofcAgentMark = mdmOrgVo.getArAgnStlCd();
		        
		        mriMaxYymm = dbDao.searchMriMaxYymm(invCreVo.getOfcCd());
				
				if (mriMaxYymm.equals("")) {
					mriMaxYymm = dbDao.searchMriMaxYymm(rhq);
				}
		        
		        dueDateVo = dbDao.searchDueDtForMaxINVInterface(invCreVo.getBlNo(), invCreVo.getOfcCd()); 
				
				if (dueDateVo != null) {
					custCrFlg = dueDateVo.getCustCrFlg(); 
				}
		        
				//2010-04-30 김현화수석
				/*
		        if(svrId.equals("USA") && ofcAgentMark.equals("B") && custCrFlg.equals("Y") && invCreVo.getCustCntCd().equals("US")) {
		        	 
		        	erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 					

		        } else if (svrId.equals("KOR") && invCreVo.getCustCntCd().equals("KR")) {
		        	
		        	if(custCrFlg.equals("Y")) {
		        		
		        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 						
		        	
		        	}								
		        }
				*/
		        //if (erpIfOfcCd.equals("")) {
		        	erpIfOfcCd = invCreVo.getOfcCd();
		        //}		
		        
		        BigDecimal chgAmt = new BigDecimal(0);
		        
				for (int i = 0; i < bkgChgeListVOs.size(); i++) {
					InvArChgVO invChges = new InvArChgVO();
					chg_cd = bkgChgeListVOs.get(i).getChgCd();
					repChgCd = dbDao.searchRepCharge(chg_cd); 				
					chgFullNm = dbDao.searchChargeName(chg_cd, arCrdtVo.getArOfcCd());
					
					invAcctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd(), invCreVo.getRevSrcCd()); 
					
					if (invAcctDivCd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(bkgChgeListVOs.get(i).getChgCd()); 
						log.info("   \n########## acctCd1 : "+acctCd);
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(bkgChgeListVOs.get(i).getChgCd());
						log.info("   \n########## acctCd2 : "+acctCd);
					}

					acctCd = dbDao.searchAccountCd(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd(), invCreVo.getRevSrcCd(), svrId, acctCd);
					log.info("   \n########## acctCd3 : "+acctCd);
					
					invChgeVo = dbDao.searchInvRevTpSrcCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo, svrId, acctCd);
					
					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
					
//					if (invCreVo.getOfcCd().equals("VLCSC")) {
//						
//						loclChgFlg = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
//						
//						if (!loclChgFlg.equals("") || bkgChgeListVOs.get(i).getChgCd().equals("IVA")) {
//							
//							invChges.setRevCoaAcctCd("954117"); 
//							
//							dbDao.modifyArOffstNo(mriMaxSeq, "VLC LCL CHRG");
//							
//						}
//												
//					} else if (invCreVo.getOfcCd().equals("CMBSC")) {
//						
//						loclChgFlg = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
//						
//						if (!loclChgFlg.equals("")) {
//							
//							invChges.setRevCoaAcctCd("954117"); 
//							
//							dbDao.modifyArOffstNo(mriMaxSeq, "CMB LCL CHRG");
//							
//						}						
//												
//					}
					
					loclChgAcctCd = dbDao.searchLocalChgFlg(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd());
					
					//2010-06-09
					if (!loclChgAcctCd.equals("")) {					
						
						invChges.setRevCoaAcctCd(loclChgAcctCd); 
						
						if (loclChgAcctCd.equals("954117")) {
							dbDao.modifyArOffstNo(arIfNo, invCreVo.getOfcCd().substring(0, 3)+" LCL CHRG");
						}
						
					} 
					
					log.info("   \n########## loclChgAcctCd : "+loclChgAcctCd);
					log.info("   \n########## loclChgAcctCd2 : "+invCreVo.getOfcCd().substring(0, 3)+" LCL CHRG");
					
					//chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getTrfRtAmt()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getRatAsCntrQty()));
					chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getChgAmt().replace(",",""));
					
					//BigDecimal pcAmt = new BigDecimal("100");
					//if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
					//	chgAmt = chgAmt.divide(pcAmt);
					//}
					
					//log.info("   \n########## chgAmt1 : "+bkgChgeListVOs.get(i).getTrfRtAmt());
					//log.info("   \n########## chgAmt2 : "+bkgChgeListVOs.get(i).getRatAsCntrQty());
					//log.info("   \n########## chgAmt3 : "+bkgChgeListVOs.get(i).getInvXchRt());
					//log.info("   \n########## chgAmt4 : "+chgAmt);

					invChges.setArIfNo(arIfNo);
					//invChges.setArIfSerNo(String.valueOf(i + 1));
					invChges.setChgSeq(String.valueOf(i + 1));
					invChges.setChgCd(bkgChgeListVOs.get(i).getChgCd());
					invChges.setCurrCd(bkgChgeListVOs.get(i).getCurrCd().substring(0, 3));
					invChges.setPerTpCd(bkgChgeListVOs.get(i).getPerTpCd());
					invChges.setTrfRtAmt(bkgChgeListVOs.get(i).getTrfRtAmt());
					invChges.setRatAsCntrQty(bkgChgeListVOs.get(i).getRatAsCntrQty());
					invChges.setChgAmt(String.valueOf(chgAmt));
					invChges.setInvXchRt(bkgChgeListVOs.get(i).getInvXchRt());
					//invChges.setInvRevTpSrcCd(invCreVo.getRevType() + invCreVo.getRevTpCd()); 
					invChges.setOfcCd(invCreVo.getOfcCd());
					//invChges.setRevCoaAcctCd(acctCd); 
					invChges.setRevCoaInterCoCd(subsCoCd);
					if (mriRevenueVVDLane.getRevVvd().length() == 9) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
					} else if (mriRevenueVVDLane.getRevVvd().length() == 10) {
						invChges.setRevCoaVslCd(mriRevenueVVDLane.getRevVvd().substring(0,4)); 
						invChges.setRevCoaVoyNo(mriRevenueVVDLane.getRevVvd().substring(4,8));        
						invChges.setRevCoaSkdDirCd(mriRevenueVVDLane.getRevVvd().substring(8,9));        
						invChges.setRevCoaDirCd(mriRevenueVVDLane.getRevVvd().substring(9,10));        
					}
					invChges.setAcctCd(acctCd);
					invChges.setTvaFlg(bkgChgeListVOs.get(i).getTvaFlg().equals("1") ? "Y" : "N");
					invChges.setChgRmk(bkgChgeListVOs.get(i).getChgRmk());
					invChges.setCreUsrId(userId);
					invChges.setUpdUsrId(userId);
					invChges.setRepChgCd(repChgCd);
					invChges.setChgFullNm(chgFullNm);
					
					invChges.setInvRevTpSrcCd(invChgeVo.getInvRevTpSrcCd()); 
					invChges.setRevCoaCoCd(invChgeVo.getRevCoaCoCd());
					invChges.setRevCoaRgnCd(invChgeVo.getRevCoaRgnCd());
					invChges.setRevCoaCtrCd(invChgeVo.getRevCoaCtrCd());
//					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd()); 
					
					tjSrcNm = dbDao.searchTjSrcNm(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd()+invCreVo.getRevSrcCd(), svrId);

					log.info("\n########## tjSrcNm : "+tjSrcNm);
					
					invChges.setTjSrcNm(tjSrcNm);

					addVoList.add(invChges);
					
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////
					///// AR_IF_SER_NO 생성
										
					if (tjSrcNm.equals("SALAR")) {
						if (ifSalar == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifSalar = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifSalar));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpSalar++;
						} else {
							erpSalar = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpSalar));
					} else if (tjSrcNm.equals("NONRE")) {
						if (ifNonre == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
					        ifNonre = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifNonre));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpNonre++;
						} else {
							erpNonre = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpNonre));
					} else if (tjSrcNm.equals("MRIAR")) {
						if (ifMriar == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifMriar = seq++;							
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifMriar));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpMriar++;
						} else {
							erpMriar = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpMriar));						
					} else if (tjSrcNm.equals("OTHER")) {
						if (ifOther == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifOther = seq++;
						} 	
						addVoList.get(i).setArIfSerNo(String.valueOf(ifOther));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpOther++;
						} else {
							erpOther = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpOther));
					} else if (tjSrcNm.equals("VAT")) {
						if (ifVat == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifVat = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifVat));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpVat++;
						} else {
							erpVat = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpVat));
					} else if (tjSrcNm.equals("WHF")) {
						if (ifWhf == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifWhf = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifWhf));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpWhf++;
						} else {
							erpWhf = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpWhf));
					} else if (tjSrcNm.equals("CTT")) {
						if (ifCtt == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifCtt = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifCtt));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpCtt++;
						} else {
							erpCtt = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpCtt));
					} else if (tjSrcNm.equals("3RD")) {
						if (if3rd == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							if3rd = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(if3rd));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erp3rd++;
						} else {
							erp3rd = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erp3rd));
					} else if (tjSrcNm.equals("XXX")) {
						if (ifXxx == 0 || !curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							ifXxx = seq++;
						}
						addVoList.get(i).setArIfSerNo(String.valueOf(ifXxx));
						if (curr_cd.equals(bkgChgeListVOs.get(i).getCurrCd())) {
							erpXxx++;
						} else {
							erpXxx = 1;
						}						
						addVoList.get(i).setArIfChgSeq(String.valueOf(erpXxx));
					}						
					
					curr_cd = bkgChgeListVOs.get(i).getCurrCd();
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////

				} // for
				
				
				if (addVoList.size() > 0) {
					dbDao.removeARInvoiceCharge(arIfNo);
					dbDao.addInvCharge(addVoList);
				}
								
				invArAmtVo = new InvArAmtVO();
				
				invArAmtVo.setArIfNo(arIfNo);
				invArAmtVo.setArInvSrcCd("NISAR");
				invArAmtVo.setInvCoaCoCd("01");
				invArAmtVo.setInvCoaRgnCd(invCoaRgnCd);
				invArAmtVo.setInvCoaCtrCd(invCoaCtrCd);
				invArAmtVo.setInvCoaInterCoCd(subsCoCd);
				invArAmtVo.setInvCoaVslCd("0000");
				invArAmtVo.setInvCoaVoyNo("0000");
				invArAmtVo.setInvCoaSkdDirCd("0");
				invArAmtVo.setInvCoaRevDirCd("0");
				invArAmtVo.setErpIfGlDt(effDt);   
				invArAmtVo.setErpIfOfcCd(erpIfOfcCd);
								
				// INV_AR_AMT table 에 저장	
				dbDao.removeARInvoiceAmount(arIfNo);
				dbDao.addInvAmount(svrId, invMain, invArAmtVo);

			}
			
			//----------------HAN 2010-04-06 START
			if (svrId.equals("KOR") || svrId.equals("ENT")) {
				invMain.setArTaxIndCd("KOR");
			}
			//----------------HAN 2010-04-06 END
			
			dbDao.modifyARInvoiceMain(invMain, userId);
			
			
			dbDao.modifyInvTotalLocalAmount(arIfNo);
			
			
			// MQ 인터페이스 전송로직 시작 ////////////////////////
			
			if (invCreVo.getRevSrcCd().equals("TM")) {

				InvArMnVO invMainTml = dbDao.searchTerminalInvoice(arIfNo);
	
				if (invMainTml.getArIfNo().substring(0, 3).equals("KCT") || invMainTml.getArIfNo().substring(0, 3).equals("KMT")
						|| invMainTml.getArIfNo().substring(0, 3).equals("KAN") || invMainTml.getArIfNo().substring(0, 3).equals("GPT")) {
	
					StringBuffer flatFile = new StringBuffer();
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					String header = "";
					String recvId = "";
	
					if (invMainTml.getArIfNo().substring(0, 3).equals("KCT")) {
						recvId = "HJKAC010            ";
					} else if (invMainTml.getArIfNo().substring(0, 3).equals("KMT")) {
						recvId = "HJKAM010            ";
					} else if (invMainTml.getArIfNo().substring(0, 3).equals("KAN")) {
						recvId = "HJKAY010            ";
					} else if (invMainTml.getArIfNo().substring(0, 3).equals("GPT")) {
						recvId = "HJKAK010            ";
					}
	
//					header = "$$$MSGSTART:HJS                 " + recvId + "APERAK    REFNO     ";
					header = "$$$MSGSTART:SML                 " + recvId + "APERAK    REFNO     ";
	
					flatFile.append(header).append("\n");
					flatFile.append("INV_NO:" + invMainTml.getBlSrcNo()).append("\n");
					flatFile.append("SERIAL_NO:" + invMainTml.getFrtFwrdCustSeq()).append("\n");
					flatFile.append("IF_NO:" + invMainTml.getArIfNo()).append("\n");
					flatFile.append("EFF_DATE:" + invMainTml.getGlEffDt()).append("\n");
	
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_APERAK.IBMMQ.QUEUE"));
					//sendFlatFileVO.setQueueNm("ALPSINV_T_UDEVHJS_APERAK");
	
					FlatFileAckVO flatFileAckVO = eaiDao.sendTerminalInvoice(sendFlatFileVO);
	
					if (flatFileAckVO.getAckStsCd().equals("E")) {
						throw new EventException("Data Transmitted Un-successufully!");
					}
	
				}
			
			}
			
			// MQ 인터페이스 전송로직 끝 ////////////////////////
			
			// ERP 전송 처리 시작
			
			dbDao.modifyCFMDate(invMain.getArIfNo(), "good", invMain.getArOfcCd(), invMain.getBlSrcNo());
			
			//20100528 ERP 전송 SC로 뺌
			/*
			list3 = dbDao.searchARInvoiceForERP(arIfNo, "C");
			
			
			eaiDao.interfaceARInvoiceToERPAR(list3);
			*/
	
			// ERP 전송 처리 끝

		} catch (EventException ex) {	
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		}
		
		return invMain;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Ex.Rate Update by Date or VVD의 환율적용대상 data 를 Main 테이블 Update<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param ExrateMainVO exrateMainVO
	 * @exception EventException
	 */
	public void modifyVIEInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException {
		try {
			dbDao.modifyVIEInvoiceExrateMain(exrateMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResultCreateBKGInvoice(String key) throws EventException {
		try {
			//BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutCreateBKGInvoice(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
	
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception EventException
	 */
	public void addOtherInvCharge(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO> invChges ) throws EventException {
		try {
			dbDao.addOtherInvCharge(invChges);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_MN table 에 저장 <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception EventException
	 */
	public void addOtherInvMain(com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invMain ) throws EventException {
		try {
			dbDao.addOtherInvMain(invMain);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_AMT table 저장 <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception EventException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invArMnVo, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO invArAmtVo) throws EventException {
		try {
			dbDao.addOtherInvAmount(arIfNo, svrId, invArMnVo, invArAmtVo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * INV_AR_CNTR table 에 저장 <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @exception EventException
     */
    public void addOtherInvContainer(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO> invCntrs) throws EventException {
		try {
			dbDao.addOtherInvContainer(invCntrs);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * MDM_CURRENCY 테이블에서 소숫점 자리수 select<br>
	 * 
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchCurrencyPoint(String currCd) throws EventException {
		try {
			return dbDao.searchCurrencyPoint(currCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * INV_AR_CHG 테이블 UPDATE 저장한다. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceCharge(InvIssVO invIssVO) throws EventException {
		try {
			
			dbDao.modifyInvoiceCharge(invIssVO);
			
			//2017.07.20 인도 GST 세법 변경 관련 보완
			if(("BOMSC").equals(invIssVO.getOfcCd())) {
				List<INDGstTypeVO> iNDGstTypeVOs = dbDao.searchINDGstTpCd(invIssVO.getLoginOfcCd(), invIssVO.getWrkNo());
				
				for(int i = 0; i < iNDGstTypeVOs.size(); i++) {
					dbDao.modifyINDGstTpCd(iNDGstTypeVOs.get(i).getIndGstTpCd(), invIssVO.getIndIssTpCd(), invIssVO.getLoginOfcCd(), invIssVO.getUserId(), iNDGstTypeVOs.get(i).getArIfNo());
					dbDao.modifyINDGstRto(iNDGstTypeVOs.get(i).getIndGstTpCd(), invIssVO.getUserId(), iNDGstTypeVOs.get(i).getArIfNo());
					dbDao.modifyINDGstAmt(iNDGstTypeVOs.get(i).getDpPrcsKnt(), invIssVO.getUserId(), iNDGstTypeVOs.get(i).getArIfNo());
				}
				
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
     * INV_AR_MN 테이블 UPDATE 저장한다. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceMain(InvIssVO invIssVO) throws EventException {
		
    	List<ArMainRecoveryDataVO> arMainBackUpDataVOs = new ArrayList<ArMainRecoveryDataVO>();
    	List<ArMainRecoveryDataVO> arMainRecoveryDataVOs = new ArrayList<ArMainRecoveryDataVO>();
    	try {
    	
    		//issue작업과 sysClear작업의 불일치 문제를 해결하기위해 신규 추가
			//issue작업중 sysClear가 발생한 데이타를 원복하기 위해 설계됨
			arMainBackUpDataVOs = dbDao.searchRecoveryDataForSysClear(invIssVO);
			
			dbDao.modifyInvoiceMainByBkgNo(invIssVO);
			dbDao.modifyDuedateInvoiceMainByIfNo(invIssVO);
			dbDao.modifyDuedateInvoiceMainByIfNoDueDt(invIssVO);
			dbDao.removeInvoiceContainer(invIssVO);
			dbDao.addInvoiceContainer(invIssVO);
			
			List<ArMainRecoveryDataVO> arMainChangedDataVOs = dbDao.searchChangedDataForSysClear(invIssVO); 
			
			if ( arMainChangedDataVOs != null && arMainChangedDataVOs.size() > 0) {
				
				for (  int i = 0; i < arMainChangedDataVOs.size(); i++){
					
					String changedIfNo = arMainChangedDataVOs.get(i).getArIfNo();
					
					for ( int j = 0; j < arMainBackUpDataVOs.size(); j++) {
						
						if ( changedIfNo != null && changedIfNo.equals(arMainBackUpDataVOs.get(j).getArIfNo())) {
							arMainRecoveryDataVOs.add(arMainBackUpDataVOs.get(j));
							break;
						}						
					}
				}
			}
			String otsSmryCd = invIssVO.getOtsSmryCd();
			
			if(otsSmryCd.equals("INV")){
			
				dbDao.modifyEffDate(invIssVO);
				if (arMainRecoveryDataVOs.size() > 0){
					dbDao.modifyRecoveryAmountForSysClear(invIssVO, arMainRecoveryDataVOs); 
				}
			}
			if (arMainRecoveryDataVOs.size() > 0){
				dbDao.modifyRecoveryMainForSysClear(invIssVO, arMainRecoveryDataVOs); 
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
     * INV_AR_MN, INV_AR_CHG에 Invoice 발행여부를 반영한다.하고  ERP 전송함.
     * 
     * @param invNo
     * @param ifNo
     * @param userId
     * @throws EventException
     */
    public void modifyOtherRevIssueFlag (String invNo, String ifNo, String userId) throws EventException {
    	try {
			dbDao.modifyIssueFlag(invNo, "Y", userId);
			dbDao.modifyIssueFlagMain(invNo, "Y", userId);
			
			List<Fns0120001VO> list2 = dbDao.searchARInvoiceForERP(ifNo, "U");
			
			eaiDao.interfaceARInvoiceToERPAR(list2);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
    /**
	 * IINV_AR_MN 테이블에 AP_AR_OFFST_NO Update<br>
	 * 
	 * @param String arIfNo
	 * @param String apArOffstNo
	 * @exception DAOException
	 */
    public void modifyArOffstNo(String arIfNo, String apArOffstNo) throws EventException {
		try {
			dbDao.modifyArOffstNo(arIfNo, apArOffstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param DueDateInputVO[] dueDateInputVOs
	 * @param InvoiceCustomerChangeVO invoiceCustomerChangeVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createCustomerChangeInvoiceList(DueDateInputVO[] dueDateInputVOs,InvoiceCustomerChangeVO invoiceCustomerChangeVO ,String userId) throws EventException {
		BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			
			bookingARCreationBackEndJob.setDueDateInputVOs(dueDateInputVOs);
			bookingARCreationBackEndJob.setActCustCntCd(invoiceCustomerChangeVO.getActCustCntCd());
			bookingARCreationBackEndJob.setActCustSeq(invoiceCustomerChangeVO.getActCustSeq());
			bookingARCreationBackEndJob.setInvCustCntCd(invoiceCustomerChangeVO.getInvCustCntCd());
			bookingARCreationBackEndJob.setInvCustSeq(invoiceCustomerChangeVO.getInvCustSeq());
			bookingARCreationBackEndJob.setUserId(userId);
			bookingARCreationBackEndJob.setUiType("I");

			return backEndJobManager.execute(bookingARCreationBackEndJob, userId, "createCustomerChangeInvoiceList");
			
		 	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutCreateCustomerChangeInvoiceList(String key) throws EventException {
		try {
			//BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutModifyExchangeRateList(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
	
	/**
     *  I/F No 에 의거 “Reverse Charge” Mark 를 수정
     * 
     * @param List<MarkingReverseChargeVO> markingReverseChargeVOs
     * @param userId
     * @throws EventException
     */
    public void modifyMarkingReverseChargeByIfNo (List<MarkingReverseChargeVO> markingReverseChargeVOs, String userId) throws EventException {
    	try {
    		for(int i = 0; i < markingReverseChargeVOs.size(); i++){
    			dbDao.modifyReverseChargeFlag(markingReverseChargeVOs.get(i).getRvsChgFlg(), markingReverseChargeVOs.get(i).getArIfNo(), userId);
    		}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
 
	/**
	 * Validation 이벤트 처리<br>
	 * Credit, GL, 환율등 필수정보 조회<br>
	 * 
	 * @param ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs
	 * @return List<ChinaVATInvoiceCreationVO>
	 * @exception EventException
	 */ 

    public List<ChinaVATInvoiceCreationVO> searchChinaVATMiscellaneousARInvoiceData(ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs) throws EventException{
		
//		InvArMnVO invMain = new InvArMnVO();
		InvArChgVO invChgeVo = new InvArChgVO();
		INVCommonUtil utilCmd = new INVCommonUtil();

        ARCreditVO aRCreditVO = new ARCreditVO();
        ARCreditInputVO arCrdtVo = new ARCreditInputVO();
        ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
//        VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
               
		try {
//log.debug("\nsearchChinaVATMiscellaneousARInvoiceData 1: ");
			for(int i = 0; i < chinaVATInvCreVOs.length; i++){
//log.debug("\nfor i= " +  i);		
//				MRIRevenueVVDLaneVO mriRevenueVVDLane = null;
				VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
				com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
//				ActInvCustVO actInvCustVo = null;
//		        InvArAmtVO invArAmtVo = null;
		        List<ArOfcAttributeVO> arOfcAttributeVOs = null;
		       
		        String arOfcCd = commonDao.searchAROfficeCodeByOfcCd(chinaVATInvCreVOs[i].getArOfcCd());	
		        String cityCd = dbDao.searchCityCd(arOfcCd);   // cityCd == office의 Location Code.
				String localTime = dbDao.searchLocalTime(arOfcCd);
				String svrId = dbDao.searchServerID(arOfcCd);
				
				String effMonth = dbDao.searchMRIEffectiveDate(arOfcCd);
				
				String tmpLclVvd = "";
				
				if(effMonth.equals("")){
					tmpLclVvd = "CNTC" + localTime.substring(2, 6) + "M"; // 기본 VVD	
				} else {
					tmpLclVvd = "CNTC" + effMonth.substring(2, 6) + "M"; // MRI - GL Date중 가장 최근 Open되어 있는 월
				}
				
				String oldLclVvd = chinaVATInvCreVOs[i].getLclVvd();  // User 입력 VVD
				if(oldLclVvd.equals("")){
					chinaVATInvCreVOs[i].setLclVvd(tmpLclVvd);
				}
//log.debug("\nSET ITEM");	

//log.debug("\n\n\nCustomer code = " +chinaVATInvCreVOs[i].getCustCode());

				//SET ITEM
				chinaVATInvCreVOs[i].setPolCd(cityCd);
				chinaVATInvCreVOs[i].setPodCd(cityCd);
				chinaVATInvCreVOs[i].setCityCd(cityCd);
				chinaVATInvCreVOs[i].setLocalTime(localTime);
				chinaVATInvCreVOs[i].setSvrId(svrId);
				
				if(arOfcCd.equals("")||cityCd.equals("")||localTime.equals("")||svrId.equals("")){
					chinaVATInvCreVOs[i].setErrorMsg("Invalid AR Office");
					continue;
				}
				
//log.debug("\n1. Due Date, Credit Term Days, Credit Flg 구하기 - Customer Credit Term 조회하여 Due Date 계산 ");	
				// 1. Due Date, Credit Term Days, Credit Flg 구하기 - Customer Credit Term 조회하여 Due Date 계산 
				arCrdtVo.setActCustCntCd(chinaVATInvCreVOs[i].getCustCntCd());
				arCrdtVo.setActCustSeq(chinaVATInvCreVOs[i].getCustSeq());
				arCrdtVo.setArOfcCd(arOfcCd);
				// MRI의 경우 Due Date 산정시 Sailing Arrival Date로 계산하지 않고, I/F Date 기준으로 계산한다. 따라서 SailArrDt 자리에 LocalTime을 넣는다.
				arCrdtVo.setSailArrDt(localTime);
				arCrdtVo.setIoBndCd(chinaVATInvCreVOs[i].getIoBndCd());  
				arCrdtVo.setBlSrcNo(chinaVATInvCreVOs[i].getBlNo());
				arCrdtVo.setRevSrcCd(chinaVATInvCreVOs[i].getRevSrcCd());
				arCrdtVo.setLocCd(cityCd);
				arCrdtVo.setDelCd(cityCd); 
				
				aRCreditVO = searchARCredit(arCrdtVo);
				
				String dueDt = "";
				String crTermDys = "";
				String custCrFlg = "";
				String sailArrDt = "";
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt();
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}
				
				if(dueDt.equals("")){
					chinaVATInvCreVOs[i].setErrorMsg("Invalid Due Date");
				}
//				log.info("\n########## dueDt : "+dueDt);
//				log.info("\n########## crTermDys : "+crTermDys);
//				log.info("\n########## custCrFlg : "+custCrFlg);

				sailArrDt = localTime.substring(0,2)+chinaVATInvCreVOs[i].getLclVvd().substring(4,8)+"01";
				
				if(sailArrDt.equals("")){
					chinaVATInvCreVOs[i].setErrorMsg("Invalid Sailing Arrival Date");
					continue;
				}
				//SET ITEM
				chinaVATInvCreVOs[i].setDueDt(dueDt);
				chinaVATInvCreVOs[i].setCrTermDys(crTermDys);
				chinaVATInvCreVOs[i].setCustCrFlg(custCrFlg);
				chinaVATInvCreVOs[i].setSailArrDt(sailArrDt);
				
				
				//2. sailing Date는 LocalVVD가 공통항차로 입력되기때문에 Local Time과 비교하여, 월이 바뀌면 공통항차 해당월의 1일로 한다.
				String sailingDt = "";
				if (chinaVATInvCreVOs[i].getLclVvd().substring(4, 8).equals(localTime.substring(2, 6))){
					sailingDt = localTime;					
				}else{
					sailingDt = localTime.substring(0, 2)+chinaVATInvCreVOs[i].getLclVvd().substring(4, 8)+"01";
				}
				
				if(sailingDt.equals("")){
					chinaVATInvCreVOs[i].setErrorMsg("Invalid Sailing Date");
					continue;
				}
				
				//SET ITEM
				chinaVATInvCreVOs[i].setSailingDt(sailingDt);
				
	            //3. GL eff Date
				String effDt = "";
				String subsCoCd = "";
				
				effDt = dbDao.searchEffectiveDate(chinaVATInvCreVOs[i].getArOfcCd(), sailingDt, chinaVATInvCreVOs[i].getRevTpCd(), chinaVATInvCreVOs[i].getRevSrcCd());
//				log.info("\n########## effDt222 : "+effDt);
				
				if(effDt.equals("")){
					chinaVATInvCreVOs[i].setErrorMsg("Invalid GL effective Date");
					continue;
				}
			
				subsCoCd = dbDao.searchInterCompany(chinaVATInvCreVOs[i].getCustCntCd(), chinaVATInvCreVOs[i].getCustSeq());				
//				actInvCustVo = dbDao.searchInvCustomer(chinaVATInvCreVOs[i].getBlNo(), chinaVATInvCreVOs[i].getArOfcCd());
				
//				String invCustCntCd = actInvCustVo.getInvCustCntCd();
//				String invCustSeq = actInvCustVo.getInvCustSeq();
				
				String otsSmryCd  = "";
				otsSmryCd  = dbDao.searchOtsSmryCd(chinaVATInvCreVOs[i].getArOfcCd());			
//				log.info("\n########## otsSmryCd : "+otsSmryCd);
				
				if (otsSmryCd.equals("INV")) {					
					arOfcAttributeVOs = dbDao.searchRepCustCdByArOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
					
					for (int j= 0; j < arOfcAttributeVOs.size(); j++) {
						if (chinaVATInvCreVOs[i].getCustCntCd().equals(arOfcAttributeVOs.get(i).getRepCustCntCd()) 
							&& Integer.parseInt(chinaVATInvCreVOs[i].getCustSeq()) == Integer.parseInt(arOfcAttributeVOs.get(i).getRepCustSeq())) {
							throw new EventException(new ErrorHandler("INV00123",new String[]{}).getMessage());
						}
					}									
				}

//log.debug("\n\nafter INV1");					
				//SET ITEM
				chinaVATInvCreVOs[i].setEffDt(effDt);
				chinaVATInvCreVOs[i].setInvCustCntCd( chinaVATInvCreVOs[i].getCustCntCd());
				chinaVATInvCreVOs[i].setInvCustSeq( chinaVATInvCreVOs[i].getCustSeq());
				chinaVATInvCreVOs[i].setSubsCoCd(subsCoCd);
//log.debug("\n\nafter INV 2"+ subsCoCd);				
	

//log.debug("\n\nafter INV 3 = "+ chinaVATInvCreVOs[i].getCustCntCd());
	            //4. Exchange Rate	
				vvdCustomerVo.setInvCntryCd(chinaVATInvCreVOs[i].getCustCntCd());
//log.debug("4");	
				vvdCustomerVo.setInvCustCd(chinaVATInvCreVOs[i].getCustSeq());
				vvdCustomerVo.setVsl(chinaVATInvCreVOs[i].getLclVvd().substring(0, 4));
				vvdCustomerVo.setVoy(chinaVATInvCreVOs[i].getLclVvd().substring(4, 8));
				vvdCustomerVo.setDep(chinaVATInvCreVOs[i].getLclVvd().substring(8, 9));
				vvdCustomerVo.setLclCurr(chinaVATInvCreVOs[i].getLclCurr());
				vvdCustomerVo.setSvcScp("IAA");
//log.debug("\n\nafter INV 5");	
				vvdCustomerVo.setBnd(chinaVATInvCreVOs[i].getIoBndCd());
				vvdCustomerVo.setOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
				vvdCustomerVo.setBkgNo(chinaVATInvCreVOs[i].getBlNo());
				vvdCustomerVo.setSaDt(chinaVATInvCreVOs[i].getSailArrDt());
				vvdCustomerVo.setPol(chinaVATInvCreVOs[i].getPolCd());
				vvdCustomerVo.setPod(chinaVATInvCreVOs[i].getPodCd());
				vvdCustomerVo.setBlSrcNo(chinaVATInvCreVOs[i].getBlNo());
				vvdCustomerVo.setCurr("USD");  // USD 환산용 exchangeRate 구함
//log.debug("\n\nbefore exchangeRateVo =");		
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
//log.debug("\n\nafter exchangeRateVo =");							
//				String xchRtN3rdTpCd = "";
//				String xchRtUsdTpCd = "";
				
				//SET ITEM
				chinaVATInvCreVOs[i].setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				chinaVATInvCreVOs[i].setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				chinaVATInvCreVOs[i].setXchRtDt(exchangeRateVo.getExRateDate());
				chinaVATInvCreVOs[i].setUsdXchRt(exchangeRateVo.getExRate());
				
				String localCurr = chinaVATInvCreVOs[i].getLclCurr();
//log.debug("\n\nafter localCurr =" + localCurr);
				if(localCurr.equals("CNY")){
//log.debug("\n\nCNY");
					chinaVATInvCreVOs[i].setInvXchRt("1");
					log.debug("\n\n rt = " + chinaVATInvCreVOs[i].getInvXchRt());				
					chinaVATInvCreVOs[i].setInvXchRtDt(exchangeRateVo.getExRateDate());
				}else{
//log.debug("\n\nELSE");
					vvdCustomerVo.setCurr(chinaVATInvCreVOs[i].getLclCurr()); // Local Currency 환산용 exchangeRate 구함
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
					
					chinaVATInvCreVOs[i].setInvXchRt(exchangeRateVo.getExRate());
					chinaVATInvCreVOs[i].setInvXchRtDt(exchangeRateVo.getExRateDate());
				}
				
				if (effDt.length() > 6) {
					chinaVATInvCreVOs[i].setAcctXchRtYrmon(effDt.substring(0, 6));
				}
		
		
				String invCoaRgnCd = "";
				String invCoaCtrCd = "";
				String rhq = "";
//				String repChgCd = "";					
//				String chgFullNm = "";
	 
				MdmOrganizationVO mdmOrgVo = null;		
//				DueDateVO dueDateVo = null;
					
				mdmOrgVo = dbDao.searchOfficeAttributeMri(chinaVATInvCreVOs[i].getArOfcCd());
				invCoaRgnCd = mdmOrgVo.getFincRgnCd();
		        invCoaCtrCd = mdmOrgVo.getArCtrCd();
		        rhq = mdmOrgVo.getArHdQtrOfcCd();
//log.debug("\n\nmdmOrgVo.getFincRgnCd()=" + mdmOrgVo.getFincRgnCd());
//log.debug("\nmdmOrgVo.getArHdQtrOfcCd()=" + mdmOrgVo.getArHdQtrOfcCd());
				//SET ITEM 
				chinaVATInvCreVOs[i].setInvCoaRgnCd(invCoaRgnCd);
				chinaVATInvCreVOs[i].setInvCoaCtrCd(invCoaCtrCd);
				chinaVATInvCreVOs[i].setXchRtDt(exchangeRateVo.getExRateDate());
				chinaVATInvCreVOs[i].setUsdXchRt(exchangeRateVo.getExRate());
				
//log.debug("\nchinaVATInvCreVOs.getInvCoaRgnCd()=" + chinaVATInvCreVOs[i].getInvCoaRgnCd());
//log.debug("\nchinaVATInvCreVOs.getInvCoaCtrCd()=" + chinaVATInvCreVOs[i].getInvCoaCtrCd());
				//InPut : chg_cd, rev_tp_cd, rev_src_cd, ofc_cd, svr_id, acct_cd
				//OutPut : INV_REV_TP_SRC_CD, REV_COA_CO_CD, REV_COA_RGN_CD, REV_COA_CTR_CD, REV_COA_ACCT_CD
				invCreVo.setRevTpCd("M");
				invCreVo.setRevSrcCd(chinaVATInvCreVOs[i].getRevSrcCd());
				invCreVo.setOfcCd(arOfcCd);
				invChgeVo = dbDao.searchInvRevTpSrcCd("TVA", invCreVo, svrId, "212111");
				
				//SET ITEM
				chinaVATInvCreVOs[i].setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
			
			}//---- FOR END

		} catch (EventException ex) {	
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		}
		
		//List 리턴 Arrays.asList(Object[])

		return Arrays.asList(chinaVATInvCreVOs);
	}


    
	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */

  	public List<InvArIfNoVO> createChinaVATMiscellaneousARInvoice(ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs) throws EventException{

		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		
  		try {
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
			for(int i = 0; i < chinaVATInvCreVOs.length; i++){

				String svrId = "";
				String ofcCd = "";
				String userId = "";
				
				svrId = chinaVATInvCreVOs[i].getSvrId();
				if(svrId.equals("")){
					svrId = "CHN";
				}
				ofcCd = chinaVATInvCreVOs[i].getArOfcCd();
				userId = chinaVATInvCreVOs[i].getUserId();  
				
				
				// 1. MRI AR_IF_NO 채번
				String mriMaxSeq = "";
				mriMaxSeq = dbDao.searchMRIInterfaceNo(ofcCd);
	
				if (mriMaxSeq.equals("")) {
					dbDao.addMRIInterfaceNo(ofcCd, userId);
					mriMaxSeq = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
				} else {
					dbDao.modifyMRIInterfaceNo(ofcCd, mriMaxSeq, userId);
				}
				
				
				//2. INV_AR_MN Setting
				InvArMnVO invMain = new InvArMnVO();
				
				invMain.setArIfNo(mriMaxSeq);
				invMain.setBlNo(chinaVATInvCreVOs[i].getBlNo());
				invMain.setBlSrcNo(chinaVATInvCreVOs[i].getBlNo());
				invMain.setActCustCntCd(chinaVATInvCreVOs[i].getCustCntCd());
				invMain.setActCustSeq(chinaVATInvCreVOs[i].getCustSeq());
				invMain.setArOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
				invMain.setRevTpCd("M");
				invMain.setRevSrcCd(chinaVATInvCreVOs[i].getRevSrcCd());
				invMain.setVslCd(chinaVATInvCreVOs[i].getLclVvd().substring(0, 4));  
				invMain.setSkdVoyNo(chinaVATInvCreVOs[i].getLclVvd().substring(4, 8));  
				invMain.setSkdDirCd(chinaVATInvCreVOs[i].getLclVvd().substring(8, 9));  
				invMain.setLoclCurrCd(chinaVATInvCreVOs[i].getLclCurr());  
				invMain.setSvcScpCd("IAA");
				invMain.setInvSvcScpCd("IAA");
				invMain.setSailDt(chinaVATInvCreVOs[i].getSailingDt());  
				invMain.setSailArrDt(chinaVATInvCreVOs[i].getSailArrDt());  
				invMain.setSlanCd("");
				invMain.setIoBndCd("O");
				//중국 증치세의 경우 Trunk VVD == Local VVD 임
				invMain.setTrnkVslCd(chinaVATInvCreVOs[i].getLclVvd().substring(0, 4));
				invMain.setTrnkSkdVoyNo(chinaVATInvCreVOs[i].getLclVvd().substring(4, 8));
				invMain.setTrnkSkdDirCd(chinaVATInvCreVOs[i].getLclVvd().substring(8, 9));	
				invMain.setPorCd("");
				invMain.setPolCd(chinaVATInvCreVOs[i].getPolCd());   // AR Office 의 Location
				invMain.setPodCd(chinaVATInvCreVOs[i].getPodCd());   // AR Office 의 Location
				invMain.setDelCd("");				
				invMain.setCustCrFlg(chinaVATInvCreVOs[i].getCustCrFlg());
				invMain.setInvCustCntCd(chinaVATInvCreVOs[i].getCustCntCd()); 
				invMain.setInvCustSeq(chinaVATInvCreVOs[i].getCustSeq());
				invMain.setCgoWgt("0");
				invMain.setCgoMeasQty("0");			
				invMain.setBkgTeuQty("0");
				invMain.setBkgFeuQty("0");
				
				invMain.setDueDt(chinaVATInvCreVOs[i].getDueDt());
				invMain.setGlEffDt(chinaVATInvCreVOs[i].getEffDt());
				invMain.setBlInvCfmDt(chinaVATInvCreVOs[i].getLocalTime());
				invMain.setInvDeltDivCd("N");
				invMain.setHjsStfCtnt(chinaVATInvCreVOs[i].getUserNm());  //사용자 이름
				invMain.setAcctXchRtYrmon(chinaVATInvCreVOs[i].getEffDt().substring(0,6));
				invMain.setUsdXchRt(chinaVATInvCreVOs[i].getUsdXchRt());  
				invMain.setXchRtUsdTpCd(chinaVATInvCreVOs[i].getXchRtUsdTpCd());
				invMain.setXchRtN3rdTpCd(chinaVATInvCreVOs[i].getXchRtN3rdTpCd());
				invMain.setXchRtDt(chinaVATInvCreVOs[i].getXchRtDt());
				invMain.setRevVslCd(chinaVATInvCreVOs[i].getLclVvd().substring(0,4)); 
				invMain.setRevSkdVoyNo(chinaVATInvCreVOs[i].getLclVvd().substring(4,8));        
				invMain.setRevSkdDirCd(chinaVATInvCreVOs[i].getLclVvd().substring(8,9));        
				invMain.setRevDirCd(chinaVATInvCreVOs[i].getLclVvd().substring(8,9));  
				invMain.setRlaneCd("CNTCO");			
				invMain.setZnIocCd("OO");  //중국 증치세는 공통항차 입력이기 때문에 slan_cd 없고, zoneIoc는 "OO" 임
				invMain.setCrTermDys(chinaVATInvCreVOs[i].getCrTermDys()); 
				invMain.setArTaxIndCd("0");
				invMain.setArCtyCd(chinaVATInvCreVOs[i].getCityCd());
				invMain.setSlsOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
				invMain.setArInvSrcCd("NISAR");
				invMain.setInvCoaAcctCd("110611");
				invMain.setInvCoaInterCoCd(chinaVATInvCreVOs[i].getSubsCoCd());
				invMain.setCreUsrId(userId);
				invMain.setUpdUsrId(userId);
				invMain.setInvRmk("");
				invMain.setMstBlNo("");
				invMain.setBkgRefNo("");
				invMain.setInvRefNo("");
				invMain.setSiRefNo("");

				dbDao.addInvMain(invMain);
				
				if(!invMain.getArIfNo().equals("")){	
					invArIfNoVO = new InvArIfNoVO();	
					invArIfNoVO.setIfNo(invMain.getArIfNo());
					ifNos.add(invArIfNoVO);
				}	

				//3. INV_AR_CHG Setting
				InvArChgVO invChge = new InvArChgVO();
				List<InvArChgVO> addVoList = new ArrayList<InvArChgVO>();
				
				invChge.setArIfNo(mriMaxSeq);
				invChge.setChgSeq("1");
				invChge.setArIfSerNo("1");
				invChge.setArIfChgSeq("1");
				invChge.setChgCd("TVA");
				invChge.setCurrCd(chinaVATInvCreVOs[i].getLclCurr().substring(0, 3));
				invChge.setPerTpCd("BL");
				invChge.setTrfRtAmt(chinaVATInvCreVOs[i].getTrfRtAmt());
				invChge.setRatAsCntrQty("1");
				invChge.setChgAmt(chinaVATInvCreVOs[i].getChgAmt());
				invChge.setInvXchRt(chinaVATInvCreVOs[i].getInvXchRt());
				invChge.setInvXchRtDt(chinaVATInvCreVOs[i].getInvXchRtDt());
				invChge.setRepChgCd("CST");
				invChge.setChgFullNm("TAX VALUE ADDED");
				invChge.setSobId("1");
				invChge.setInvRevTpSrcCd("XXX");
				invChge.setTjSrcNm("VAT");
				invChge.setRevCoaCoCd("01");
				invChge.setOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
				invChge.setRevCoaRgnCd(chinaVATInvCreVOs[i].getInvCoaRgnCd());
				invChge.setRevCoaCtrCd(chinaVATInvCreVOs[i].getInvCoaCtrCd());
				invChge.setRevCoaAcctCd("212111");
				invChge.setRevCoaInterCoCd(chinaVATInvCreVOs[i].getSubsCoCd()); 
				invChge.setRevCoaVslCd("0000"); 
				invChge.setRevCoaVoyNo("0000");        
				invChge.setRevCoaSkdDirCd("0");        
				invChge.setRevCoaDirCd("0");
				invChge.setAcctCd("212111");
				invChge.setTvaFlg("N");
				invChge.setChgRmk("");
				invChge.setCreUsrId(chinaVATInvCreVOs[i].getUserId());
				invChge.setUpdUsrId(chinaVATInvCreVOs[i].getUserId());

				addVoList.add(invChge);
				
				dbDao.addInvCharge(addVoList);

				
				//4. INV_AR_AMT Setting
				InvArAmtVO invArAmtVo = new InvArAmtVO();
				
				invArAmtVo.setArIfNo(mriMaxSeq);
				invArAmtVo.setArIfSerNo("1");
				invArAmtVo.setTjSrcNm("VAT");
//				invArAmtVo.setCurrCd(chinaVATInvCreVOs[i].getCurrCd().substring(0, 3));
				invArAmtVo.setCurrCd(chinaVATInvCreVOs[i].getLclCurr().substring(0, 3));
				invArAmtVo.setInvAmt(chinaVATInvCreVOs[i].getChgAmt());
				invArAmtVo.setArInvSrcCd("NISAR");
				invArAmtVo.setInvCoaCoCd("01");
				invArAmtVo.setInvCoaRgnCd(chinaVATInvCreVOs[i].getInvCoaRgnCd());
				invArAmtVo.setInvCoaCtrCd(chinaVATInvCreVOs[i].getInvCoaCtrCd());
				invArAmtVo.setInvCoaAcctCd("110611"); //MIV, MIC --> TVA 면 110611
				invArAmtVo.setInvCoaInterCoCd(chinaVATInvCreVOs[i].getSubsCoCd()); 
				invArAmtVo.setInvCoaVslCd("0000");
				invArAmtVo.setInvCoaVoyNo("0000");
				invArAmtVo.setInvCoaSkdDirCd("0");
				invArAmtVo.setInvCoaRevDirCd("0");
				invArAmtVo.setErpIfGlDt(chinaVATInvCreVOs[i].getEffDt());   
				invArAmtVo.setErpIfOfcCd(chinaVATInvCreVOs[i].getArOfcCd());
				
				// INV_AR_AMT table 에 저장	
				dbDao.addInvAmount(svrId, invMain, invArAmtVo);
				
                // Total Local Amount 저장
				dbDao.modifyInvTotalLocalAmount(mriMaxSeq);
			} // END FOR
			
		} catch (EventException ex) {	
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage());
		}
	  	return ifNos;	
	}
	
	  	
	/**
	 * Batch(FNS_INV_B003)에서 호출<br>
	 * WHF 금액 INV와 BKG 비교<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
  	public String searchWhfDiffCheck(String bkgNo) throws EventException{
		try {
			return dbDao.searchWhfDiffCheck(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	} 
    
  	/**
     * No INDIA 지역 Taxable charge 정보 update 한다. <br>
     * 
     * @param InvoiceIssueSndToErpVO invoiceIssueSndToErpVO
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyNoINDTaxableChg(InvoiceIssueSndToErpVO invoiceIssueSndToErpVO, InvIssVO invIssVO) throws EventException {
		try {
			
			String invNo = "";
			
			for(int i = 0; i < invoiceIssueSndToErpVO.getInvnos().size(); i++) {
				invNo = invoiceIssueSndToErpVO.getInvnos().get(i);
				
				List<INDGstTypeVO> NoIndChgList = dbDao.searchNoINDTaxableChg(invNo);
				
				for(int j = 0; j < NoIndChgList.size(); j++) {
					dbDao.modifyNoINDInvNo(invNo, invIssVO.getUserId(), NoIndChgList.get(j).getArIfNo());
				    dbDao.modifyNoINDSacCd(invIssVO.getUserId(), NoIndChgList.get(j).getArIfNo());
				    dbDao.modifyINDGstRto(NoIndChgList.get(j).getIndGstTpCd(), invIssVO.getUserId(), NoIndChgList.get(j).getArIfNo());
					dbDao.modifyNoINDGstAmt(NoIndChgList.get(j).getDpPrcsKnt(), invIssVO.getUserId(), NoIndChgList.get(j).getArIfNo(), NoIndChgList.get(j).getUsdXchRt());
				}
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
}