/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingARCreationBCImpl.java
 *@FileTitle : Invoice Update by User ID
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBC;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationBackEndDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationEAIDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ActInvCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAgtMkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcApplDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAttributeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfficeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BKGMainDocVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BLNoBKGStatusVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgChgeListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgOfcPayIndVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CoaVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CustInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MRIRevenueVVDLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFChgeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.RevVVDLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdLanePortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdSaDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ARInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssueVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.util.ScheduleUtil;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoBatHisVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceARIssueTempVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process.<br>
 * 
 * @author Han Dong Hoon
 * @see FNS_INV_0026EventResponse,BookingARCreationBC
 * @since J2EE 1.6
 */
public class BookingARCreationBCImpl extends BasicCommandSupport implements BookingARCreationBC {
   
	// Database Access Object
	private transient BookingARCreationDBDAO dbDao = null;
	//private transient BookingARCreationEAIDAO eaiDao = null;
	/**
	 * BookingARCreationBCImpl object creation.<br>
	 * BookingARCreationDBDAO creation.<br>
	 */
	public BookingARCreationBCImpl() {
		
		dbDao = new BookingARCreationDBDAO();
		//eaiDao = new BookingARCreationEAIDAO();
	}
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearList(SysClearVO sysClearVo) throws EventException {
		int updateCntMn = 0;
		//String otsSmryCd = null;
		
		List<SysClearVO> ifNoList = null;

		try {
			//otsSmryCd = sysClearVo.getOtsSmryCd();			
			
			ifNoList = dbDao.searchInterfaceNumberListForSysClear(sysClearVo);			
			
			for (int i=0; i<ifNoList.size(); i++) {
				ifNoList.get(i).setUpdUsrId(sysClearVo.getUserId());
			}
			
			// INV_AR_MN table update
			updateCntMn = dbDao.modifyMainSysClearList(ifNoList);

			// INV_AR_CHG table update
			dbDao.modifyChgSysClearList(ifNoList);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListByIfNo(SysClearVO sysClearVo) throws EventException {
		int updateCntMn = 0;
		//String otsSmryCd = null;
		
		List<SysClearVO> ifNoList = new ArrayList<SysClearVO>();
		int chgAmt = 9999;
		try {
			//otsSmryCd = sysClearVo.getOtsSmryCd();	
			
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
			
				// INV_AR_MN table update
				updateCntMn = dbDao.modifyMainSysClearList(ifNoList);
	
				// INV_AR_CHG table update
				dbDao.modifyChgSysClearList(ifNoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListBatch(List<SysClearVO> sysClearVos) throws EventException {
		int updateCntMn = 0;
		try {
			// INV_AR_MN table update
			updateCntMn = dbDao.modifyMainSysClearList(sysClearVos);

			// INV_AR_CHG table update
			dbDao.modifyChgSysClearList(sysClearVos);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return updateCntMn;
	}

	/**
	 * Multi event process<br>
	 * In screen multi event process.<br>
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
		com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
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
		//String loclChgAcctCd = "";
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
		
		//int seq = 1;
        
        //int ifSalar = 0;
        //int ifNonre = 0;
        //int ifMriar = 0;
        //int ifOther = 0;
        //int ifVat = 0;
        //int ifWhf = 0;
        //int ifCtt = 0;
        //int if3rd = 0;
        //int ifXxx = 0;
        
        //int erpSalar = 1;
        //int erpNonre = 1;
        //int erpMriar = 1;
        //int erpOther = 1;
        //int erpVat = 1;
        //int erpWhf = 1;
        //int erpCtt = 1;
        //int erp3rd = 1;
        //int erpXxx = 1;
        
        //int erpSalar = 0;
        //int erpNonre = 0;
        //int erpMriar = 0;
        //int erpOther = 0;
        //int erpVat = 0;
        //int erpWhf = 0;
        //int erpCtt = 0;
        //int erp3rd = 0;
        //int erpXxx = 0;
        
        //InvArAmtVO invArAmtVo = null;
        
        //List<CntrTypeSizeVO> list2 = null;
        //List<Fns0120001VO> list3 = null;
        String cntrNos = "";
        StringBuffer cntrNosBuff = new StringBuffer("");
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
			
			if (invCreVo.getRevSrcCd().equals("IC")) {
			
				//bLSumAmount = Float.parseFloat(dbDao.searchBLSumAmount(invCreVo.getOfcCd(), invCreVo.getBlNo()));
				bLSumAmount = new BigDecimal(dbDao.searchBLSumAmount(invCreVo.getOfcCd(), invCreVo.getBlNo()));
				
				for (int idx = 0; idx < invCreVo.getBkgChgeListVOs().size(); idx++) {
					
					acctRate = new BigDecimal(dbDao.searchAcctRate(invCreVo.getBkgChgeListVOs().get(idx).getCurrCd()));
					
					BigDecimal amount = new BigDecimal(invCreVo.getBkgChgeListVOs().get(idx).getTrfRtAmt()).multiply(
		                                new BigDecimal(invCreVo.getBkgChgeListVOs().get(idx).getRatAsCntrQty()));
					
					BigDecimal pcAmt = new BigDecimal("100");
					if (invCreVo.getBkgChgeListVOs().get(idx).getPerTpCd().equals("PC")) {
						amount = amount.divide(pcAmt,6,BigDecimal.ROUND_HALF_UP);
						
					}
					// 소수점 6-> 20 자리로 변경	
					sumAmount = sumAmount.add(amount.divide(acctRate,20,BigDecimal.ROUND_HALF_UP));
									
				}
				
				sumAmount = sumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
				log.debug("bLSumAmount::: "+bLSumAmount);
				log.debug("sumAmount::: "+sumAmount);
				
				if (bLSumAmount.add(sumAmount).compareTo(zero) == -1 ) {
					throw new EventException(new ErrorHandler("INV00103", new String[] {}).getMessage());
				}
			
			}
			
			ofcCd = invCreVo.getOfcCd();
						
			mriMaxSeq = dbDao.searchMRIInterfaceNo(ofcCd);

			if (mriMaxSeq.equals("")) {
				dbDao.addMRIInterfaceNo(ofcCd, userId);
				mriMaxSeq = ofcCd.substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
			} else {
				dbDao.modifyMRIInterfaceNo(ofcCd, mriMaxSeq, userId);
			}			
			
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
			
			} else {				
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt();
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
				
									
			}
			
			laneCd = dbDao.searchLaneCode(invCreVo.getLclVvd());
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CFDR")||
				invCreVo.getLclVvd().substring(0, 4).equals("COMC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				
				zoneIoc = "OO";
			} else {
				zoneIoc = dbDao.searchZoneIOC(invCreVo.getPolCd(), invCreVo.getPodCd());
			}

			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, zoneIoc);
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO"); 
				
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd);
				
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				// rev_src_cd is 'RD' in case, changing 'CNTC' to vsl.
				if (invCreVo.getRevSrcCd().equals("RD")) {
					tVslCd = "CNTC";
				} else {
					tVslCd = invCreVo.getLclVvd().substring(0, 4);
				}
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
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
			} else{
				sailingDt= dbDao.searchSailingDateByBlNo(invCreVo.getBlSrcNo());
			}
			
			// sailing dt is not exist in case, set Pol to VVD.
			if(sailingDt.equals("")) sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
			
			// sailing dt is not exist in case, set Port to VVD.	
			if (sailingDt.equals("")) {
				if (invCreVo.getIoBndCd().equals("I")) {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPodCd());
					
				} else {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
					
				}
			}
			
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
				sailingDt = localTime;
			} 
			
			if (sailingDt.equals("")) {
				throw new EventException(new ErrorHandler("INV00132",new String[]{}).getMessage());
			}
			
			if (invCreVo.getRevSrcCd().equals("TM") || invCreVo.getRevSrcCd().equals("TN") || invCreVo.getRevSrcCd().equals("EQ")) {
					
				effDt = invCreVo.getEffDt().replaceAll("-", "");
				
				clzStsCd = dbDao.searchClosingStatus(invCreVo.getOfcCd(), effDt, "M");
				
				if (!clzStsCd.equals("O")) {
					throw new EventException(new ErrorHandler("INV00015",new String[]{}).getMessage());
				}
								
			} else {
			
				effDt = dbDao.searchEffectiveDate(invCreVo.getOfcCd(), sailingDt, invCreVo.getRevTpCd(), invCreVo.getRevSrcCd());
				
				if (effDt.equals("")) {
					throw new EventException(new ErrorHandler("INV00122",new String[]{}).getMessage());
				}
				
			}
						
			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());

			actInvCustVo = dbDao.searchInvCustomer(invCreVo.getBlNo(), invCreVo.getOfcCd());
			
			trunkVvd = invCreVo.getTrunkVvd();
			
			if (trunkVvd.length() == 9) {

				port = invCreVo.getIoBndCd().equals("O")?invCreVo.getPolCd():invCreVo.getPodCd();
				
				// flight schedule trunk vvd check
				if (dbDao.checkVskVslPortSkd(trunkVvd, port) 
					&& !trunkVvd.substring(0, 4).equals("CFDR") && !trunkVvd.substring(0, 4).equals("USAC")) {
					
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					
				} else {
					
					//trunkVvd = dbDao.searchTrunkVvd();
					invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
					invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
					invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
					
				}			
				
			} else {
				
//				if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
//					
//					invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
//					invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
//					invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
//					
//				} else {
//					
//					trunkVvd = dbDao.searchTrunkVvd();
//					if(trunkVvd.length() < 9) {
//						throw new EventException(new ErrorHandler("INV00171",new String[]{}).getMessage());
//					}
//					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
//					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
//					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));					
//				}
				invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
				invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
				invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));		
			}
			
			if (actInvCustVo == null) {
				invCustCntCd = invCreVo.getCustCntCd();
				invCustSeq = invCreVo.getCustSeq();		
			} else {
				invCustCntCd = actInvCustVo.getInvCustCntCd();
				invCustSeq = actInvCustVo.getInvCustSeq();
			}
						
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
			invMain.setCoStfCtnt(invCreVo.getCoRef());
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
			invMain.setInvSvcScpCd(invCreVo.getSvcScpCd());
			
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
			
			vvdCustomerVo = new VVDCustomerVO();
			
			vvdCustomerVo.setInvCntryCd(invCreVo.getInvCustCntCd());
			vvdCustomerVo.setInvCustCd(invCreVo.getInvCustSeq());
			vvdCustomerVo.setVsl(invCreVo.getLclVvd().substring(0, 4));
			vvdCustomerVo.setVoy(invCreVo.getLclVvd().substring(4, 8));
			vvdCustomerVo.setDep(invCreVo.getLclVvd().substring(8, 9));
			vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());
			vvdCustomerVo.setSvcScp(invMain.getInvSvcScpCd());
			vvdCustomerVo.setBnd(invCreVo.getIoBndCd());
			vvdCustomerVo.setOfcCd(invCreVo.getOfcCd());
			vvdCustomerVo.setBkgNo(invCreVo.getBkgNo());
			vvdCustomerVo.setSaDt(invCreVo.getSailArrDt());
			vvdCustomerVo.setPol(invCreVo.getPolCd());
			vvdCustomerVo.setPod(invCreVo.getPodCd());
			vvdCustomerVo.setBlSrcNo(invCreVo.getBlSrcNo());
			vvdCustomerVo.setCurr("USD");  

			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			invMain.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invMain.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invMain.setXchRtDt(exchangeRateVo.getExRateDate());
			invMain.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : "");
			invMain.setUsdXchRt(exchangeRateVo.getExRate());
			invMain.setInvLoclXchRt(exchangeRateVo.getExRate());
			if (effDt.length() > 6) {
				invMain.setAcctXchRtYrmon(effDt.substring(0, 6));
			}			
			invMain.setBlInvCfmDt(localTime);
			invMain.setInvDeltDivCd("N");
			
			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invCreVo.getLclCurr());  
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invMain.setInvUsdXchRt(exchangeRateVo.getExRate());
			
			dbDao.addInvMain(invMain);
			
			if (invCreVo.getIoBndCd().equals("I")) {
		    	dbDao.modifyInvRefNo(invCreVo.getBlNo(), invCreVo.getOfcCd(), invCreVo.getInvRefNo());
		    }
		
			if (bkgChgeListVOs != null) {
				List<InvArChgVO> addVoList = new ArrayList<InvArChgVO>();
				String chg_cd = "";
				//String curr_cd = "";
				
				String invCoaRgnCd = "";
				String invCoaCtrCd = "";
				String rhq = "";
				String mriMaxYymm = "";
				//String ofcAgentMark = "";
				String erpIfOfcCd = "";
				String repChgCd = "";					
				String chgFullNm = "";
				MdmOrganizationVO mdmOrgVo = null;		
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
		        /*
		        if(svrId.equals("USA") && ofcAgentMark.equals("B") && custCrFlg.equals("Y")){
		        	if(invCreVo.getCustCntCd().equals("US")||invCreVo.getCustCntCd().equals("CA")) {		        	 
		        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 			
		        	}

		        } else if (svrId.equals("KOR") && invCreVo.getCustCntCd().equals("KR")) {
		        	
		        	if(custCrFlg.equals("Y")) {
		        		
		        		erpIfOfcCd = dbDao.searchErpIFOfcCd(invCreVo.getCustCntCd(), invCreVo.getCustSeq()); 						
		        	
		        	}								
		        }
		         */
		        if (erpIfOfcCd.equals("")) {
		        	erpIfOfcCd = invCreVo.getOfcCd();
		        }		
		        
		        BigDecimal chgAmt = new BigDecimal(0);
		        
				for (int i = 0; i < bkgChgeListVOs.size(); i++) {
					InvArChgVO invChges = new InvArChgVO();
					chg_cd = bkgChgeListVOs.get(i).getChgCd();
					repChgCd = dbDao.searchRepCharge(chg_cd); 				
					chgFullNm = dbDao.searchChargeName(chg_cd);
					
					invAcctDivCd = dbDao.searchAccountDivision(invCreVo.getRevTpCd(), invCreVo.getRevSrcCd()); 
					
					if (invAcctDivCd!=null && invAcctDivCd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(bkgChgeListVOs.get(i).getChgCd()); 
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(bkgChgeListVOs.get(i).getChgCd());
					}

					acctCd = dbDao.searchAccountCd( invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd(), invCreVo.getRevSrcCd(), svrId, acctCd);
					
					invChgeVo = dbDao.searchInvRevTpSrcCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo, svrId, acctCd);
					
					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
						
					chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getTrfRtAmt()).multiply(new BigDecimal(bkgChgeListVOs.get(i).getRatAsCntrQty()));
					
					
					BigDecimal pcAmt = new BigDecimal("100");
					if (bkgChgeListVOs.get(i).getPerTpCd().equals("PC")) {
						chgAmt = chgAmt.divide(pcAmt);
					}
					
					
					invChges.setArIfNo(mriMaxSeq);
					invChges.setChgSeq(String.valueOf(i + 1));
					invChges.setChgCd(bkgChgeListVOs.get(i).getChgCd());
					invChges.setCurrCd(bkgChgeListVOs.get(i).getCurrCd().substring(0, 3));
					invChges.setPerTpCd(bkgChgeListVOs.get(i).getPerTpCd());
					invChges.setTrfRtAmt(bkgChgeListVOs.get(i).getTrfRtAmt());
					invChges.setRatAsCntrQty(bkgChgeListVOs.get(i).getRatAsCntrQty());
					invChges.setChgAmt(String.valueOf(chgAmt));
					invChges.setInvXchRt(bkgChgeListVOs.get(i).getInvXchRt());
					invChges.setInvXchRtDt(exchangeRateVo.getExRateDate());
					invChges.setOfcCd(invCreVo.getOfcCd());
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
					tjSrcNm = dbDao.searchTjSrcNm(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd()+invCreVo.getRevSrcCd(), svrId);

					invChges.setTjSrcNm(tjSrcNm);
					
 					if ("VAT".equals(tjSrcNm)) {
						if(!invCreVo.getLclCurr().equals(invChges.getCurrCd())) {
							throw new EventException(new ErrorHandler("INV00192",new String[]{invChges.getChgCd()}).getMessage());							
						}
					}				
					
					
					//invChges.setUsdXchRt(bkgChgeListVOs.get(i).getUsdXchRt());	//2015.03.04
					//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
					vvdCustomerVo.setLclCurr("USD");
					vvdCustomerVo.setCurr(invChges.getCurrCd());  
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
					invChges.setUsdXchRt(exchangeRateVo.getExRate());
					vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());  	//원복
					vvdCustomerVo.setCurr("USD");  						//원복

					addVoList.add(invChges);
					
					/* 2015.04.23 block
					///// AR_IF_SER_NO creation
										
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
					*/
				} // for
				
				
				if (addVoList.size() > 0) {
					dbDao.addInvCharge(addVoList);
				}
								
				/* 2015.04.23 block
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
								
				// INV_AR_AMT table save.	
				dbDao.addInvAmount(svrId, invMain, invArAmtVo);
				*/
				
				// 2015.04.23 add
				List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(mriMaxSeq);
								
				if (invArAmtVOs.size() > 0) {
					for (int i = 0; i < invArAmtVOs.size(); i++) {
						
						invArAmtVOs.get(i).setArInvSrcCd("NISAR");
						invArAmtVOs.get(i).setInvCoaCoCd("01");
						invArAmtVOs.get(i).setInvCoaRgnCd(invCoaRgnCd);
						invArAmtVOs.get(i).setInvCoaCtrCd(invCoaCtrCd);
						invArAmtVOs.get(i).setInvCoaAcctCd(invCoaAcctCd);
						invArAmtVOs.get(i).setInvCoaInterCoCd(subsCoCd);
						invArAmtVOs.get(i).setInvCoaVslCd("0000");
						invArAmtVOs.get(i).setInvCoaVoyNo("0000");
						invArAmtVOs.get(i).setInvCoaSkdDirCd("0");
						invArAmtVOs.get(i).setInvCoaRevDirCd("0");
						invArAmtVOs.get(i).setErpIfGlDt(effDt);
						invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd);	
						invArAmtVOs.get(i).setCreUsrId(userId);
						invArAmtVOs.get(i).setUpdUsrId(userId);	
					}
				}
				
				dbDao.addInvAmount(invArAmtVOs);
				dbDao.modifyInvArChg(mriMaxSeq);
	
			}

			dbDao.modifyInvTotalLocalAmount(mriMaxSeq);

			List<BKGContainerVO> bkgContainerVOs = invCreVo.getBkgContainerVOs();

			if (bkgContainerVOs != null) {
				List<InvArCntrVO> addVoList = new ArrayList<InvArCntrVO>();

				for (int i = 0; i < bkgContainerVOs.size(); i++) {
					InvArCntrVO invCntrs = new InvArCntrVO();

					invCntrs.setArIfNo(mriMaxSeq);
					invCntrs.setCntrSeq(Integer.toString(i + 1));
					invCntrs.setCntrNo(bkgContainerVOs.get(i).getCntrNo());
					invCntrs.setCntrTpszCd(bkgContainerVOs.get(i).getCntrTpszCd());
					invCntrs.setCreUsrId(userId);
					invCntrs.setUpdUsrId(userId);

					addVoList.add(invCntrs);
					
					// ERP send process start.
					cntrNosBuff.append(bkgContainerVOs.get(i).getCntrNo()).append((i != bkgContainerVOs.size() - 1 ? "," : ""));
				}
				
				int lastIdx = 0;
				cntrNos = cntrNosBuff.toString();
				if (cntrNos.length() > 150) {
					
					cntrNos = cntrNos.substring(0, 150);
					
					lastIdx = cntrNos.lastIndexOf(",");		
					
					cntrNos = cntrNos.substring(0, lastIdx);
											
				}
				
				if (addVoList.size() > 0) {
					dbDao.addInvContainer(addVoList, userId);
				}
			}

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
		
		return invMain;
	}

	/**
	 * No Good receivables or good receivables in case and change actual, invoice Customer other items in case update.<br>
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
		com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
		
		INVCommonUtil utilCmd = new INVCommonUtil();
		
		try {
			
			List<InvArMnVO> invArMnList = dbDao.searchARInvoice(invCreVo.getInvArMnVO().getArIfNo());
			InvArMnVO invArMnVO = invArMnList.get(0);
			
			cnt = dbDao.checkAccountRateExist(invCreVo.getInvArMnVO().getGlEffDt());

			if (cnt > 0 && invCreVo.getInvArMnVO().getBlInvCfmDt().equals("")) {
				
				String port = invCreVo.getInvArMnVO().getIoBndCd().equals("O")?invCreVo.getInvArMnVO().getPolCd():invCreVo.getInvArMnVO().getPodCd();
				String vvd = invCreVo.getInvArMnVO().getVslCd()+ invCreVo.getInvArMnVO().getSkdVoyNo()+invCreVo.getInvArMnVO().getSkdDirCd();
				
				String sailArrDt = utilCmd.searchSADate(vvd , port, invCreVo.getInvArMnVO().getIoBndCd());
				
				invCreVo.getInvArMnVO().setSailArrDt(sailArrDt);
				
				String znIocCd = dbDao.searchZoneIOC(invCreVo.getInvArMnVO().getPolCd(), invCreVo.getInvArMnVO().getPodCd());

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
				//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
				
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
					
					//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
					vvdCustomerVo.setLclCurr("USD");
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
					invCreVo.getInvArChgVOs().get(i).setUsdXchRt(exchangeRateVo.getExRate());
					vvdCustomerVo.setLclCurr(invCreVo.getInvArMnVO().getLoclCurrCd());
					
					
				}

				vvdCustomerVo.setCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				invCreVo.getInvArMnVO().setUsdXchRt(exchangeRateVo.getExRate());
				invCreVo.getInvArMnVO().setInvLoclXchRt(exchangeRateVo.getExRate());
				invCreVo.getInvArMnVO().setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				invCreVo.getInvArMnVO().setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				invCreVo.getInvArMnVO().setXchRtDt(exchangeRateVo.getExRateDate());
				invCreVo.getInvArMnVO().setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
				
				vvdCustomerVo.setLclCurr("USD");
				vvdCustomerVo.setCurr(invCreVo.getInvArMnVO().getLoclCurrCd());
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				invCreVo.getInvArMnVO().setInvUsdXchRt(exchangeRateVo.getExRate());			
				
				dbDao.modifyARInvoiceCharge(invCreVo.getInvArChgVOs(), userId);			
				
				List<InvArAmtVO> invArAmtVOs = dbDao.searchARInvoiceAmount(invCreVo.getInvArMnVO().getArIfNo());
				
				String erpIfOfcCd = "";

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

			dbDao.modifyMainUpdUserId(userId, invCreVo.getInvArMnVO().getArOfcCd(), invCreVo.getInvArMnVO().getBlSrcNo());
			
			dbDao.modifyOTSDueDate(invCreVo.getInvArMnVO().getArIfNo(), invCreVo.getInvArMnVO().getDueDt(), userId);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return newIfNo;
	}

	/**
	 * No Good receivables or good receivables in case and change actual, invoice Customer other items in case cancel item creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		INVCommonUtil utilCmd = new INVCommonUtil();
		
		try {

			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			invArChgVOs = dbDao.searchARInvoiceCharge(cancelInvoiceVO.getIfNo());
			invArAmtVOs = dbDao.searchARInvoiceAmount(cancelInvoiceVO.getIfNo());
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());
			
			InvArMnVO invArMnVO = new InvArMnVO();			
			invArMnVO = invArMnVOs.get(0);
			
			
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}
			*/
			
			String newArIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			BigDecimal invTtlLoclAmt = new BigDecimal(invArMnVO.getInvTtlLoclAmt()).multiply(new BigDecimal(-1));

			invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
			
			
			invArMnVO.setArIfNo(newArIfNo);
			invArMnVO.setOldArIfNo("");
			
			String revTpCd = "";
			String revSrcCd = "";
			String invCustFlg = cancelInvoiceVO.getInvCustFlg()!=null&&!cancelInvoiceVO.getInvCustFlg().equals("")?cancelInvoiceVO.getInvCustFlg():"N";
			
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
			
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String glEffDt = utilCmd.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt());
			
			invArMnVO.setGlEffDt(glEffDt);
			
			invArMnVO.setBlInvCfmDt("");
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setInvSplitCd("X");
			invArMnVO.setInvDeltDivCd("X");
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");

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
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String invRevTpSrcCd = "";
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());				
				
				invArChgVOs.get(i).setArIfNo(newArIfNo);
				invArChgVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
				invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
				invArChgVOs.get(i).setInvIssFlg("N");
				invArChgVOs.get(i).setInvClrFlg("N");
			}

			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				BigDecimal invAmt= new BigDecimal(invArAmtVOs.get(i).getInvAmt()).multiply(new BigDecimal(-1));
				
				invArAmtVOs.get(i).setInvAmt(invAmt.toString());				
				
				invArAmtVOs.get(i).setArIfNo(newArIfNo);
				invArAmtVOs.get(i).setErpIfGlDt(glEffDt);
				invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
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
			
			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}
			
			/*if (cancelInvoiceVO.getUiType()!=null && cancelInvoiceVO.getUiType().equals("E")) {
			}else{
				dbDao.modifySplitCode(cancelInvoiceVO.getIfNo(), "M", cancelInvoiceVO.getUserId());
			}*/
			
			if (cancelInvoiceVO.getUiType()==null || !cancelInvoiceVO.getUiType().equals("E")) {
				dbDao.modifySplitCode(cancelInvoiceVO.getIfNo(), "M", cancelInvoiceVO.getUserId());
			}
			
			//if (cancelInvoiceVO.getOtsSmryCd().equals("INV")||cancelInvoiceVO.getOtsSmryCd().equals("CLR")) {
				dbDao.modifySysClearFlag(cancelInvoiceVO.getIfNo(),invArMnVO.getArIfNo(), cancelInvoiceVO.getUserId());
			//}

			cnt = dbDao.checkAccountRateExist(glEffDt);

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
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
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
	 * Good receivables in case and change actual, invoice customer in case new condition creation.<br>
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createNewCustomerARInvoice(InvNewCustVO invNewCustVO, String userId) throws EventException {
		int cnt = 0;
		String newIfNo = "";
		INVCommonUtil utilCmd = new INVCommonUtil();

		try {
			List<InvArMnVO> invArMnVOs = null;
			List<InvArChgVO> invArChgVOs = null;
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArCntrVO> invArCntrVOs = null;
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

			invArMnVOs = dbDao.searchARInvoice(invNewCustVO.getArIfNo());
			invArChgVOs = dbDao.searchARInvoiceCharge(invNewCustVO.getArIfNo());
			invArAmtVOs = dbDao.searchARInvoiceAmount(invNewCustVO.getArIfNo());
			invArCntrVOs = dbDao.searchARInvoiceContainer(invNewCustVO.getArIfNo());
			
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());

			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), userId);
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, userId);
			}
			*/
			
			String newArIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			// No Good item inv_delt_div_cd 'Y' process
			
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
			
			if (invNewCustVO.getUiType().equals("C")) {
				invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
				invArMnVO.setInvCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setInvCustSeq(invNewCustVO.getActCustSeq());
				invArMnVO.setInvRmk(invNewCustVO.getInvRmk());
			
			// Item Correction MaxIf
			} else if (invNewCustVO.getUiType().equals("I")) {
				invArMnVO.setActCustCntCd(invNewCustVO.getInvArMnVO().getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getInvArMnVO().getActCustSeq());
				invArMnVO.setInvCustCntCd(invNewCustVO.getInvArMnVO().getInvCustCntCd());
				invArMnVO.setInvCustSeq(invNewCustVO.getInvArMnVO().getInvCustSeq());
				invArMnVO.setInvRmk(invNewCustVO.getInvArMnVO().getInvRmk());
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
			//} else if (invNewCustVO.getUiType().equals("E")) {			//2015.03.17 add UI Type "E"
			} else {
				invArMnVO.setActCustCntCd(invNewCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(invNewCustVO.getActCustSeq());
			} 

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
			
			invArMnVO.setZnIocCd(znIocCd);

			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());	
			
			String locCd ="";
			
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

			invArMnVO.setBlInvCfmDt("");			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");
			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");	
			invArMnVO.setBfrInvCurrCd("");
			
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
			
			invArMnVO.setInvSvcScpCd(invArMnVO.getInvSvcScpCd());
			
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
			
			invArMnVO.setRevTpCd(revTpCd);
			invArMnVO.setRevSrcCd(revSrcCd);
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String acct_div_cd = dbDao.searchAccountDivision(revTpSrcCd);
			
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
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
			
			//2015.03.17 add UI Type "E"
			if (invNewCustVO.getUiType().equals("C")||invNewCustVO.getUiType().equals("F")||invNewCustVO.getUiType().equals("I")||invNewCustVO.getUiType().equals("E")) {				
				
				invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
				invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
				invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
				invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
				invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
				invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
				
				vvdCustomerVo.setLclCurr("USD");
				vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				
				for (int i = 0; i < invArChgVOs.size(); i++) {
					
					invArChgVOs.get(i).setArIfNo(newArIfNo);
					invArChgVOs.get(i).setCreUsrId(userId);
					invArChgVOs.get(i).setUpdUsrId(userId);
					invArChgVOs.get(i).setOfcCd(invArMnVO.getArOfcCd());
					
					invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
					
					invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);
					
					vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());

					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
					
					
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
					
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					invArChgVOs.get(i).setRevCoaInterCoCd(invCoaInterCoCd);
					invArChgVOs.get(i).setRevCoaCoCd(invCoaCoCd);
					invArChgVOs.get(i).setRevCoaCtrCd(invCoaCtrCd);
					invArChgVOs.get(i).setRevCoaRgnCd(invCoaRgnCd);
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
					
					//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
					vvdCustomerVo.setLclCurr("USD");
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
					invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
					vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				}

			}
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
			/*
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
			*/
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
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());
					newIfNo = invArMnVO.getArIfNo();
				}
				
			}else{
				dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());		
			}	
			
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
	 * Multi event process<br>
	 * Receivables information creation.<br>
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
		CoaVO coaVO = new CoaVO();
		ActInvCustVO actInvCustVo = null;
		//VVDCustomerVO vvdCustomerVo = null;
		//INVCommonUtil utilCmd = new INVCommonUtil();
		//com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

		List<InvArAmtVO> invArAmtVOs = invCreVo.getInvArAmtVOs();
		List<InvArChgVO> invArChgVOs = invCreVo.getInvArChgVOs();

		String mriMaxSeq = "";  // ar_if_no
		String subsCoCd = "";
		
		String dueDt = "";
		String crTermDys = "";
		String custCrFlg = "";
		
		String laneCd = "";
		String zoneIoc = "";
		String tVslCd = "";
		String cityCd = "";
		//String localTime = "";
		String sailingDt = "";
		String invCustCntCd = "";
		String invCustSeq = "";
		
		//String svrId = "";
		
		INVCommonUtil invUtil = new INVCommonUtil();
		//VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
		//com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

		try {
			
			mriMaxSeq = dbDao.searchMRIInterfaceNo(invCreVo.getOfcCd());

			if (mriMaxSeq.equals("")) {
				dbDao.addMRIInterfaceNo(invCreVo.getOfcCd(), invCreVo.getUserId());
				mriMaxSeq = invCreVo.getOfcCd().substring(0, 3) + "M" + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
			} else {
				dbDao.modifyMRIInterfaceNo(invCreVo.getOfcCd(), mriMaxSeq, invCreVo.getUserId());
			}
			
			invCreVo.setDueDt("X");
			//invCreVo.setSailArrDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			//invCreVo.setIoBndCd("O");
			log.info("SailArrDt:"+invCreVo.getSailArrDt());	
			log.info("IoBndCd:"+invCreVo.getIoBndCd());
			
			arCrdtVo = dbDao.searchCreditCustomerForCredit(invCreVo);
			if (arCrdtVo != null) {
		        dueDt = arCrdtVo.getDueDt();
		        crTermDys = arCrdtVo.getCrTerm();
		        custCrFlg = arCrdtVo.getCrFlg();
			}
			
			if(dueDt == null) dueDt = "";
			if(crTermDys == null) crTermDys = "0";
			if (dueDt.equals("") || crTermDys.equals("0")) {
	    		// If credit customer is not exist data or credit term is 0,
				arCrdtVo = dbDao.searchOfficeForCredit(invCreVo);
				
				if (arCrdtVo != null) {
			        dueDt = arCrdtVo.getDueDt();
			        crTermDys = arCrdtVo.getCrTerm();
			        custCrFlg = arCrdtVo.getCrFlg();					
				}
	    	}
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CFDR")||
				invCreVo.getLclVvd().substring(0, 4).equals("COMC")||
				invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				zoneIoc = "OO";
				if (invCreVo.getLclVvd().substring(0, 4).equals("COMC")) {
					laneCd = "COM";
				}
				else if (invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
					laneCd = "CNT";
				}
				else {
					laneCd = "RBC";
				}
				
			} else {
				laneCd = dbDao.searchLaneCode(invCreVo.getLclVvd());
				zoneIoc = dbDao.searchZoneIOC(invCreVo.getPolCd(), invCreVo.getPolCd());
			}
			
			if (!invCreVo.getLclVvd().substring(0, 4).equals("USAC") && !invCreVo.getLclVvd().substring(0, 4).equals("CFDR") &&
			    !invCreVo.getLclVvd().substring(0, 4).equals("COMC") && !invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, zoneIoc);
				
				if (mriRevenueVVDLane.getRevVvd().equals("")) {
					mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO"); 
				}
				
				if (mriRevenueVVDLane.getRevVvd().equals("")) {
					mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd);
				}
				
				if (mriRevenueVVDLane.getRevVvd().equals("")) {
					// rev_src_cd is 'RD' in case, changing 'CNTC' to vsl.
					if (invCreVo.getRevSrcCd().equals("RD")) {
						tVslCd = "CNTC";
					} else {
						tVslCd = invCreVo.getLclVvd().substring(0, 4);
					}
					mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
				}
							
				if (mriRevenueVVDLane.getRevVvd().equals("") || mriRevenueVVDLane.getRevLane().equals("")) {
					throw new EventException(new ErrorHandler("INV00119",new String[]{}).getMessage());
				}
				
				if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
					laneCd = mriRevenueVVDLane.getSlaneCd();
				}
			}
			
			cityCd = dbDao.searchCityCd(invCreVo.getOfcCd());
			
			//localTime = dbDao.searchLocalTime(invCreVo.getOfcCd());
			if (invCreVo.getBkgNo() != null && !invCreVo.getBkgNo().equals("")) {
				sailingDt = dbDao.searchSailingDateByBkgNo(invCreVo.getBkgNo());
			} else{
				sailingDt= dbDao.searchSailingDateByBlNo(invCreVo.getBlSrcNo());
			}
			
			// sailing dt is not exist in case, set Pol to VVD.
			if(sailingDt.equals("")) sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
			
			// sailing dt is not exist in case, set Port to VVD.	
			if (sailingDt.equals("")) {
				if (invCreVo.getIoBndCd().equals("I")) {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
				} else {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
				}
			}
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC") || invCreVo.getLclVvd().substring(0, 4).equals("CNTC") || invCreVo.getLclVvd().substring(0, 4).equals("COMC")) {
				sailingDt = invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			} 
			
			if (sailingDt.equals("")) {
				throw new EventException(new ErrorHandler("INV00132",new String[]{}).getMessage());
			}
	
			// Code retrieve
			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());
			
			actInvCustVo = dbDao.searchInvCustomer(invCreVo.getBlSrcNo(), invCreVo.getOfcCd());
			
			if (actInvCustVo == null) {
				invCustCntCd = invCreVo.getCustCntCd();
				invCustSeq = invCreVo.getCustSeq();		
			} else {
				invCustCntCd = actInvCustVo.getInvCustCntCd();
				invCustSeq = actInvCustVo.getInvCustSeq();
			}

			// center, customer table select
			coaVO = dbDao.searchCOA(invCreVo.getOfcCd());
			
			//svrId = invCreVo.getSvrId();

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
			invMain.setSvcScpCd(invCreVo.getSvcScpCd());
			invMain.setInvSvcScpCd(invCreVo.getSvcScpCd());
			invMain.setSailDt(sailingDt);
			invMain.setSailArrDt(invCreVo.getSailArrDt());
			String slanCd = "";
			if (invCreVo.getLclVvd().substring(0, 4).equals("COMC")) {
				slanCd = "COM";
			}
			else if (invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				slanCd = "CNT";
			}
			else {
				slanCd = laneCd;
			}
			invMain.setSlanCd(slanCd);
			invMain.setIoBndCd(invCreVo.getIoBndCd());
			invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
			invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
			invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
			invMain.setPorCd(invCreVo.getPolCd());
			invMain.setPolCd(invCreVo.getPolCd());
			invMain.setPodCd(invCreVo.getPolCd());
			invMain.setDelCd(invCreVo.getPolCd());
			invMain.setCustCrFlg(custCrFlg);
			invMain.setInvCustCntCd(invCustCntCd);
			invMain.setInvCustSeq(invCustSeq);
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
			invMain.setCoStfCtnt("");
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
			//use Cooperate Rate of screen  2016.07.14
			//if (invCreVo.getLclVvd().substring(0, 4).equals("USAC") || invCreVo.getLclVvd().substring(0, 4).equals("CFDR") ||
			//	invCreVo.getLclVvd().substring(0, 4).equals("COMC") || invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				invMain.setUsdXchRt(invCreVo.getUsdXchRt());
				invMain.setInvLoclXchRt(invCreVo.getUsdXchRt());
				if(("").equals(invCreVo.getUsdXchRt()) || ("0").equals(invCreVo.getUsdXchRt())) invMain.setInvUsdXchRt("0");
				else invMain.setInvUsdXchRt(new BigDecimal("1").divide(new BigDecimal(invCreVo.getUsdXchRt()), 6, BigDecimal.ROUND_HALF_UP).toString());
				invMain.setXchRtUsdTpCd("A");
				invMain.setXchRtN3rdTpCd("A");
				invMain.setXchRtDt(invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
			//} else {
			//	vvdCustomerVo = new VVDCustomerVO();
			//	vvdCustomerVo.setInvCntryCd(invCustCntCd);
			//	vvdCustomerVo.setInvCustCd(invCustSeq);
			//	vvdCustomerVo.setVsl(invCreVo.getLclVvd().substring(0, 4));
			//	vvdCustomerVo.setVoy(invCreVo.getLclVvd().substring(4, 8));
			//	vvdCustomerVo.setDep(invCreVo.getLclVvd().substring(8, 9));
			//	vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());
			//	vvdCustomerVo.setSvcScp(invMain.getSvcScpCd());
			//	vvdCustomerVo.setBnd(invCreVo.getIoBndCd());
			//	vvdCustomerVo.setOfcCd(invCreVo.getOfcCd());
			//	vvdCustomerVo.setBkgNo(invCreVo.getBlSrcNo());
			//	vvdCustomerVo.setSaDt(invCreVo.getSailArrDt());
			//	vvdCustomerVo.setPol(invCreVo.getPolCd());
			//	vvdCustomerVo.setPod(invCreVo.getPolCd());
			//	vvdCustomerVo.setBlSrcNo(invCreVo.getBlSrcNo());
			//	vvdCustomerVo.setCurr("USD");  

			//	exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
			//	invMain.setUsdXchRt(exchangeRateVo.getExRate());
			//	invMain.setInvLoclXchRt(exchangeRateVo.getExRate());
			//	invMain.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			//	invMain.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			//	invMain.setXchRtDt(exchangeRateVo.getExRateDate());
				
			//	vvdCustomerVo.setLclCurr("USD");
			//	vvdCustomerVo.setCurr(invCreVo.getLclCurr());  
			//	exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
			//	invMain.setInvUsdXchRt(exchangeRateVo.getExRate());
			//}
			
			invMain.setObrdDt("");
			invMain.setInvTtlLoclAmt(invCreVo.getTotalLocalAmt().replaceAll(",", ""));
			invMain.setTrspRqstOrdFlg("");
			invMain.setEdiSndDt("");
			if (invCreVo.getLclVvd().substring(0, 4).equals("USAC") || invCreVo.getLclVvd().substring(0, 4).equals("CFDR") ||
				invCreVo.getLclVvd().substring(0, 4).equals("COMC") || invCreVo.getLclVvd().substring(0, 4).equals("CNTC")) {
				invMain.setRevVslCd(invCreVo.getLclVvd().substring(0, 4));
				invMain.setRevSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
				invMain.setRevSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
				invMain.setRevDirCd(invCreVo.getLclVvd().substring(8, 9));
				invMain.setRlaneCd(mriRevenueVVDLane.getRevLane());
				invMain.setZnIocCd("OO");
			} else {
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
			}
			invMain.setCrTermDys(crTermDys);
			invMain.setArTaxIndCd(invCreVo.getArTaxIndCd());
			invMain.setArCtyCd(cityCd);
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
			// Main Table iss flg setting.
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
				
				//String erpIfOfcCd = "";
				//ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invCreVo.getOfcCd());
				//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();

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

					invAmts.setErpIfOfcCd(invCreVo.getOfcCd());
					
					addAmtVoList.add(invAmts);

					// INV_AR_CHG
					chgSeq = 0;
					for (int j = 0; j < invArChgVOs.size(); j++) {
						InvArChgVO invChges = new InvArChgVO();

						chgCd = invArChgVOs.get(j).getChgCd();
						currCd = invArChgVOs.get(j).getCurrCd();

						if (invArAmtVOs.get(i).getTjSrcNm().equals("VAT") && !invArChgVOs.get(j).getTaxYn().equals("N")) {
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
								//invChges.setUsdXchRt(invArChgVOs.get(j).getUsdXchRt());	//2015.03.04

								String effDt = invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
								invChges.setUsdXchRt(invUtil.searchAccountRate(invArChgVOs.get(j).getCurrCd(), "USD",effDt.length() == 8 ? effDt.substring(0, 6) : "" ));

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
								//invChges.setUsdXchRt(invArChgVOs.get(j).getUsdXchRt());	//2015.03.04
								
								String effDt = invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
								invChges.setUsdXchRt(invUtil.searchAccountRate(invArChgVOs.get(j).getCurrCd(), "USD",effDt.length() == 8 ? effDt.substring(0, 6) : "" ));


								addChgVoList.add(invChges);
							}
						} else if (invArAmtVOs.get(i).getTjSrcNm().equals("OTHER") && invArChgVOs.get(j).getTaxYn().equals("N")) {
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
								
								//invChges.setUsdXchRt(invArChgVOs.get(j).getUsdXchRt());	//2015.03.04
								
								String effDt = invCreVo.getEffDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
								invChges.setUsdXchRt(invUtil.searchAccountRate(invArChgVOs.get(j).getCurrCd(), "USD",effDt.length() == 8 ? effDt.substring(0, 6) : "" ));
							
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
				//List<Fns0120001VO> list3 = null;
				//list3 = dbDao.searchARInvoiceForERP(mriMaxSeq, "C");

				//eaiDao.interfaceARInvoiceToERPAR(list3);
				
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
	 * FNS_INV_0017 Invoice Customer Correction by Date, No Good in case changing Customer Code.
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
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

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

			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			
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
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = command.searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
				vvdCustomerVo.setLclCurr(invArMnList.get(0).getLoclCurrCd());
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

			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());
			
			
			//String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			String erpIfOfcCd = "";

			for (int i = 0; i < invArAmtVOs.size(); i++) {
				invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
				invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
				invArAmtVOs.get(i).setUpdUsrId(userId);
			}
			
			dbDao.modifyARInvoiceAmount(invArAmtVOs);
			
			cnt = dbDao.checkAccountRateExist(invNewCustVO.getGlEffDt());

			if (cnt > 0) {
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
	 * FNS_INV_0007,0008,0100,0101 BackEndJob process
	 * 
	 * @author Choi Do Soon
	 * @param ExchangeRateVO[] exchangeRateVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String manageARInvoiceExRateList(ExchangeRateVO[] exchangeRateVOs, String userId) throws EventException {
			
		
		/*BookingARCreationBackEndJob bookingARCreationBackEndJob = new BookingARCreationBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			bookingARCreationBackEndJob.setExchangeRateVOs(exchangeRateVOs);
			bookingARCreationBackEndJob.setUserId(userId);
			bookingARCreationBackEndJob.setUiType("C");

			return backEndJobManager.execute(bookingARCreationBackEndJob, userId, "manageARInvoiceExRateList");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}*/
		
		
		
		// 1.기존BackEndJob 호출하던것은 주석처리
		// 2. 대상을 Temp Table 에 넣기위한 Sequence 값 구하기
		// 3. 대상을 Temp Table 에 Insert
		// 4. Batch Call (위에서 구한 sequence파라미터로 던지기)
		// 5. 호출된 Batch 에서는 1. 전달받은 seq로 대상 exRateVO[] 구하기 2. modifyBLExchangeRate 호출  3. 전달받은 Seq 로 Temp 테이블 삭제  
		
		String batResult = "";
		
		if ( exchangeRateVOs != null && exchangeRateVOs.length > 0 ) {
		
			List<ExchangeRateVO> addList = new ArrayList<ExchangeRateVO>();
	    	try{  
	    		
	    		// get xchRtTmpSeq
	    		String xchRtTmpSeq = dbDao.searchExchangeRateTempSeq();
	    		
	    		
	    		// make targetList for add
    			for(int i=0; i < exchangeRateVOs.length; i++) {
    				exchangeRateVOs[i].setXchRtTmpSeq(xchRtTmpSeq);
    				exchangeRateVOs[i].setUsrId(userId);    				
    				addList.add(exchangeRateVOs[i]);
    			}
	    		
    			// insert temp table
    			dbDao.addExchangeRateTemp(addList);
	    		
    			
    			
    			// call batch
    			String batParam = xchRtTmpSeq + "#" + userId;
		        ScheduleUtil su = new ScheduleUtil();
		        batResult = su.directExecuteJob("FNS_INV_B003",batParam);
		      
    			
    			/*
    			
				//아래 소스는 위의 Batch 에서 작업하는 것들입니다.	
				
    			//1.Search TargetList
    			List<ExchangeRateVO> list = searchExchangeRateTempList(xchRtTmpSeq);
    			ExchangeRateVO[] exchangeRateVos = new ExchangeRateVO[list.size()];
    			for(int j = 0; j < list.size(); j++){
    				exchangeRateVos[j] = list.get(j);
    			}
    			
    			// 2.Update Ex.Rate to BL 
    			modifyBLExchangeRate(exchangeRateVos, userId);	
    			
    			//3. Delete Temp Table
    			removeExchangeRateTempSeq(xchRtTmpSeq);
    			*/
    			
    			
    			
			} catch (DAOException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"modifyBLExchangeRateCallBatch"}).getMessage(),e);
			} catch (Exception e){
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"modifyBLExchangeRateCallBatch"}).getMessage(),e);
			} 
			
		}
		return batResult;
		
	}
	
	/**
	 * FNS_INV_0027 rates Update BackEndJob process
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
	 * FNS_INV_0027 rates update result retrieve.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws EventException {
		
		List<ExRateCountVO> exRateCountVOs = new ArrayList<ExRateCountVO>(); 
		
		try {
			
			InvoiceIssueBC issCommand = new InvoiceIssueBCImpl();
			List<InvoiceARIssueTempVO> issTmpList = issCommand.searchInvoiceIssueTempList(key);
			
			String tot_cnt = "0";
			String good_cnt = "0";
			String no_good_cnt = "0";
			
			List<InvArIfNoVO> exceclIfNos = new ArrayList<InvArIfNoVO>();
			for(int i=0; i < issTmpList.size(); i++ ) {
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(issTmpList.get(i).getAttrCtnt1());
				exceclIfNos.add(invArIfNoVO);
				if(i == 0) {
					tot_cnt = issTmpList.get(i).getAttrCtnt2();
					good_cnt = issTmpList.get(i).getAttrCtnt3();
					no_good_cnt = issTmpList.get(i).getAttrCtnt4();
				}
			}
			
			exRateCountVOs = dbDao.searchInvoiceExrateMain(exceclIfNos);
			
			if(exRateCountVOs.size()>0){			
				exRateCountVOs.get(0).setCount1(String.valueOf(tot_cnt));
				exRateCountVOs.get(0).setCount2(String.valueOf(good_cnt));
				exRateCountVOs.get(0).setCount3(String.valueOf(no_good_cnt));
			}else{
				ExRateCountVO exRateCountVO = new ExRateCountVO();
				exRateCountVO.setCount1(String.valueOf(tot_cnt));
				exRateCountVO.setCount2(String.valueOf(good_cnt));
				exRateCountVO.setCount3(String.valueOf(no_good_cnt));
				exRateCountVOs.add(exRateCountVO);
			}
			
			return exRateCountVOs;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		
		
		/*try {
			BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutModifyExchangeRateList(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}*/
	}
	
	/**
	 * Invoice Issue (Main) event Issue event process<br>
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
	 * Invoice Issue (Main) event Issue event process<br>
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
	 * Invoice Issue (Main) event issue event process<br>
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
	 * ISSUE FLAG , DUE DATE, TEU, FEU, REF NUMBER UPDATE.<br>
	 * 
	 * @param InvIssueVO invIssueVO
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssue(InvIssueVO invIssueVO, String otsSmryCd, String userId) throws EventException {
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArCntrVO> list = null;
		String invRefNo = "";
		try {
			dbDao.modifyIssueFlag(invIssueVO.getInvno(), invIssueVO.getIssflg(), userId);

			dbDao.modifyDueDate(invIssueVO.getIfno(), invIssueVO.getDuedt(), userId);

			if (invIssueVO.getBkgno() != null && !invIssueVO.getBkgno().equals("")) {

				invArMnVO = dbDao.searchTeuFeu(invIssueVO.getBkgno());

				invRefNo = dbDao.searchInvRefNumber(invIssueVO.getBkgno());

				invArMnVO.setArIfNo(invIssueVO.getIfno());
				invArMnVO.setInvRefNo(invRefNo);

				dbDao.modifyTeuFeuInvRefNumber(invArMnVO, userId);

				dbDao.removeARInvoiceContainer(invIssueVO.getIfno());

				list = dbDao.searchBKGContainerList(invIssueVO.getBkgno());

				for (int i = 0; i < list.size(); i++) {
					list.get(i).setArIfNo(invIssueVO.getIfno());
					list.get(i).setCntrSeq(String.valueOf(i + 1));
				}

				dbDao.addInvContainer(list, userId);

				
			}
			
			
			// ERP send process end

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * TEU, FEU, REF NUMBER UPDATE<br>
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
		String invRefNo = "";
		
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
	
				}
			
			}
			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * FNS_INV_0027 Valid rates apply.<br>
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

				ARCreditInputVO arCrdtVo = new ARCreditInputVO();
				arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
				arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
				arCrdtVo.setSailArrDt(exrateMainVO.getSailArrDt());
				arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
				arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
				arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
				arCrdtVo.setDelCd(invArMnVO.getDelCd());
				
				String locCd ="";
				
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

				if ((invArMnVO.getBlInvCfmDt()!=null&&invArMnVO.getBlInvCfmDt().equals("")) && cnt > 0) {
					List<InvArAmtVO> invArAmtVOs = dbDao.searchARInvoiceAmount(invArMnVO.getArIfNo());
					
					//String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
					//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
					
					String erpIfOfcCd = "";

					for (int i = 0; i < invArAmtVOs.size(); i++) {
						invArAmtVOs.get(i).setErpIfGlDt(effDt);
						invArAmtVOs.get(i).setErpIfOfcCd(erpIfOfcCd!=null&&!erpIfOfcCd.equals("")?erpIfOfcCd:invArMnVO.getArOfcCd());	
						invArAmtVOs.get(i).setUpdUsrId(exrateMainVO.getUpdUsrId());
					}
					
					dbDao.modifyARInvoiceAmount(invArAmtVOs);

					String sailArrDt2        =	exrateMainVO.getSailArrDt();
					String sailDt2           =	exrateMainVO.getSailDt();
					String dueDt2            =	exrateMainVO.getDueDt();
					String xchRtN3rdTpCd2    =	exrateMainVO.getXchRtN3rdTpCd();
					String xchRtUsdTpCd2     =	exrateMainVO.getXchRtUsdTpCd();
					String glEffDt2          =	exrateMainVO.getGlEffDt();
					String actCustSeq2		 =  invArMnVO.getActCustSeq();
					
					if(sailArrDt2 == null) sailArrDt2 = "";
					if(sailDt2 == null) sailDt2 = "";
					if(dueDt2 == null) dueDt2 = "";
					if(xchRtN3rdTpCd2 == null) xchRtN3rdTpCd2 = "";
					if(xchRtUsdTpCd2 == null) xchRtUsdTpCd2 = "";
					if(glEffDt2 == null) glEffDt2 = "";
					if(actCustSeq2 == null) actCustSeq2 = "";
					
					if(!sailArrDt2.equals("") && !sailDt2.equals("") && !dueDt2.equals("")
							&& !xchRtN3rdTpCd2.equals("") && !xchRtUsdTpCd2.equals("") && !glEffDt2.equals("") && !actCustSeq2.equals("")){

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
	 * Valid rates chg table apply.<br>
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
	 * TEU, FEU, REF NUMBER, INV RMK UPDATE.<br>
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
		String invRefNo = "";
		try {
			
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
	
					
					}	
				}
				
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00025", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00025", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Max Seq INV_AR_BKG_IF_NO update.<br>
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
	 * INV_AR_MN table Update<br>
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
	 * INV_AR_MN table InvNo Update.<br>
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
	/*
	public ERPIfReturnVO[] fns012R001Receive(XmlObject xmlObject) throws EventException {
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
	*/

	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Interface Data Cancel Interface data creation.<br>
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
			//invArMnVO.setInvCurrCd(cancelInvoiceVO.getInvCurrCd());
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

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");

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
			}

			for (int i = 0; i < invArAmtVOs.size(); i++) {
				
				BigDecimal invAmt= new BigDecimal(invArAmtVOs.get(i).getInvAmt()).multiply(new BigDecimal(-1));
				
				//invArAmtVOs.get(i).setInvAmt(Float.toString(Float.parseFloat(invArAmtVOs.get(i).getInvAmt()) * -1));
				
				invArAmtVOs.get(i).setInvAmt(invAmt.toString());	
				
				invArAmtVOs.get(i).setArIfNo(cancelInvoiceVO.getNewIfNo());
				invArAmtVOs.get(i).setErpIfGlDt(invArMnVO.getGlEffDt());
				invArAmtVOs.get(i).setCreUsrId(cancelInvoiceVO.getUserId());
				invArAmtVOs.get(i).setUpdUsrId(cancelInvoiceVO.getUserId());
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

			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				dbDao.addInvContainer(invArCntrVOs, cancelInvoiceVO.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(cancelInvoiceVO.getEffDt());

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
					// ERP I/F process
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

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
	 * Invoice Issue Interface Data Cancel Interface data creation.<br>
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

			newIfNo = cancelInvoiceVO.getNewIfNo()!=null?cancelInvoiceVO.getNewIfNo():"";
			
			if(newIfNo.equals("")||newIfNo==null){
				
				String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
				
				/*
				if (maxSeq == null) {
					dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
					maxSeq = "00000001";
				} else {
					dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
				}
				*/
				
				newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			}

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
			invArMnVO.setInvCurrCd("");  // 2015.01.09

			invArMnVO.setInvSplitCd("X");				

			invArMnVO.setInvDeltDivCd("X");
			invArMnVO.setBlInvCfmDt("");			
			//Main Table Iss Flg setting 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			// WHF items init.
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
			
			
			for (int i = 0; i < invArChgVOs.size(); i++) {	
				
				String invRevTpSrcCd = "";
				String tjSrcNm = "";
				String acctCd = "";
				String revCoaAcctCd = "";
				
				BigDecimal chgAmt= new BigDecimal(invArChgVOs.get(i).getChgAmt()).multiply(new BigDecimal(-1));
				
				//invArChgVOs.get(i).setChgAmt(Float.toString(Float.parseFloat(invArChgVOs.get(i).getChgAmt()) * -1));
				
				invArChgVOs.get(i).setChgAmt(chgAmt.toString());	
				
				invRevTpSrcCd = dbDao.searchArInvRevTpSrcCd(invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd(), svrId);
				
				invArChgVOs.get(i).setInvRevTpSrcCd(invRevTpSrcCd);		
				
				if(revTpCd.equals("M")&&revSrcCd.equals("RD")){
					invArChgVOs.get(i).setAcctCd(invArChgVOs.get(i).getAcctCd());	
					invArChgVOs.get(i).setRevCoaAcctCd(invArChgVOs.get(i).getRevCoaAcctCd()); 	
				}else{

					if (acct_div_cd.equals("P")) {
						acctCd = dbDao.searchAccountCdFromCharge(invArChgVOs.get(i).getChgCd());
					} else {
						acctCd = dbDao.searchAccountCdFromRevAcct(invArChgVOs.get(i).getChgCd());
					}
					
					acctCd = dbDao.searchAccountCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					invArChgVOs.get(i).setAcctCd(acctCd);	
					
					revCoaAcctCd = dbDao.searchRevCoaAcctCd( invArMnVO.getArOfcCd(), invArChgVOs.get(i).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
					
					invArChgVOs.get(i).setRevCoaAcctCd(revCoaAcctCd);
				
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
			}
			
			dbDao.addInvCharge(invArChgVOs);
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			String invCoaInterCoCd =  dbDao.searchInterCompany(invArMnVO.getActCustCntCd(),invArMnVO.getActCustSeq());	
			//ArOfcAttributeVO arOfcAttributeVO =  dbDao.searchOfficeAttribute(invArMnVO.getArOfcCd());
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
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
					// ERP I/F process
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

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
	 * Invoice Issue Interface Data New Interface data creation.<br>
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
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}
			*/
			
			newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
				
			invArChgVOs = dbDao.searchIssueInvoiceCharge ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			//invArAmtVOs = dbDao.searchIssueInvoiceAmount ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());			
			invArCntrVOs = dbDao.searchBKGContainerList(invArMnVO.getBkgNo());
			
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			invArMnVO.setInvCurrCd("");	//2015.01.09
			invArMnVO.setBfrInvCurrCd("");

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

			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			
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
			// Main Table Iss Flg setting 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");

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
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}

			invArMnVO.setInvSvcScpCd(invArMnVO.getInvSvcScpCd());
			
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
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			}

			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());

			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
			
			dbDao.addInvMain(invArMnVO);
			
			dbDao.addInvCharge(invArChgVOs);
			
			List<InvArAmtVO> invArAmtVOs = dbDao.searchInvArAmount(newIfNo);
			
			String erpIfOfcCd = "";

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
					// ERP I/F process.
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
	 * Invoice Issue Interface Data New Interface data creation.<br>
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
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
			invArMnVOs = dbDao.searchARInvoice(cancelInvoiceVO.getIfNo());
			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			
			String maxSeq = dbDao.searchNewInterfaceNo(invArMnVO.getArOfcCd());
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), cancelInvoiceVO.getUserId());
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, cancelInvoiceVO.getUserId());
			}	
			*/
			
			newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
				
			invArChgVOs = dbDao.searchIssueInvoiceCharge ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());
			invArAmtVOs = dbDao.searchIssueInvoiceAmount ( cancelInvoiceVO.getInvNo(), invArMnVO.getArOfcCd());	
			invArCntrVOs = dbDao.searchARInvoiceContainer(cancelInvoiceVO.getIfNo());
			
			invArMnVO.setArIfNo(newIfNo);
			invArMnVO.setOldArIfNo("");
			invArMnVO.setInvCurrCd("");  //2015.01.09
			invArMnVO.setBfrInvCurrCd("");
			
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
			
			String glEffDt = dbDao.searchEffectiveDate(invArMnVO.getArOfcCd(), invArMnVO.getSailDt(), invArMnVO.getRevTpCd(), invArMnVO.getRevSrcCd());
			
			invArMnVO.setGlEffDt(glEffDt);

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
				// sailing dt BKGNo
				String sailDt  = dbDao.searchSailingDate(invArMnVO.getBkgNo());
				
				// sailing dt is not exist in case, BlNo			
				if(sailDt.equals("")) sailDt= dbDao.searchSailingDateByBlNo(invArMnVO.getBlSrcNo());
				
				//sailing dt is not exist in case, VVD Pol		
				if(sailDt.equals("")) sailDt = dbDao.searchSailingDateByVvd(invArMnVO.getVslCd(),invArMnVO.getSkdVoyNo(),invArMnVO.getSkdDirCd(), invArMnVO.getPolCd());
				
				//sailing dt is not exist in case, VVD Port		
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

			invArMnVO.setZnIocCd(znIocCd);
			
			invArMnVO.setCreUsrId(cancelInvoiceVO.getUserId());
			invArMnVO.setUpdUsrId(cancelInvoiceVO.getUserId());
			//Main Table Iss Flg setting 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");			
			invArMnVO.setInvSplitCd("C");
			invArMnVO.setBlInvCfmDt("");
			invArMnVO.setInvDeltDivCd("N");	

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			String acct_div_cd = dbDao.searchAccountDivision(revTpSrcCd);
			

			invArMnVO.setInvSvcScpCd(invArMnVO.getInvSvcScpCd());
			
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
			invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());
			
			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			
			if(invArMnVO.getRevSrcCd().equals("RD")||invArMnVO.getRevSrcCd().equals("TP")||invArMnVO.getRevSrcCd().equals("LS")||
					invArMnVO.getRevSrcCd().equals("DO")||invArMnVO.getRevSrcCd().equals("TM")){
				invArMnVO.setXchRtUsdTpCd("A");
				invArMnVO.setXchRtN3rdTpCd("A");
				
				String invXchRt = utilCmd.searchAccountRate("USD", invArMnVO.getLoclCurrCd(), localTime.length()==8?localTime.substring(0,6):"");
				invArMnVO.setUsdXchRt(invXchRt);
				invArMnVO.setXchRtDt("");
				invArMnVO.setObrdDt("");
			}

			dbDao.addInvMain(invArMnVO);
			
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String revCoaAcctCd ="";
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
					
				}else{
					invArChgVOs.get(i).setAcctCd(invArChgVOs.get(i).getAcctCd());	
					invArChgVOs.get(i).setRevCoaAcctCd(invArChgVOs.get(i).getRevCoaAcctCd()); 	
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
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			}
			
			dbDao.addInvCharge(invArChgVOs);
			
			String erpIfOfcCd = "";

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
					// ERP I/F process
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
	 * FNS_INV_0018 invoice Split Before Invoice Issue Invoice Split information creation.<br>
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
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;

			InvArMnVO invArMnVO = new InvArMnVO();
			invArMnVO = invArMnVOs.get(0);
			
			invArChgVOs = invSplitVo.getInvArChgVOs();
			//invArAmtVOs = invSplitVo.getInvArAmtVOs();
			invArCntrVOs = invSplitVo.getInvArCntrVOs();			
			
			invArMnVO.setOldArIfNo(invSplitVo.getIfNo());
			invArMnVO.setActCustCntCd(invSplitVo.getInvArMnVO().getActCustCntCd());
			invArMnVO.setActCustSeq(invSplitVo.getInvArMnVO().getActCustSeq());
			invArMnVO.setInvRmk(invSplitVo.getInvArMnVO().getInvRmk());
			//invArMnVO.setDueDt(invSplitVo.getInvArMnVO().getDueDt());
			//invArMnVO.setCustCrFlg(invSplitVo.getInvArMnVO().getCustCrFlg());
			//invArMnVO.setCrTermDys(invSplitVo.getInvArMnVO().getCrTermDys());
			invArMnVO.setInvRefNo(invSplitVo.getInvArMnVO().getInvRefNo());
			invArMnVO.setCoStfCtnt(invSplitVo.getInvArMnVO().getCoStfCtnt());
			invArMnVO.setBkgTeuQty(invSplitVo.getInvArMnVO().getBkgTeuQty());
			invArMnVO.setBkgFeuQty(invSplitVo.getInvArMnVO().getBkgFeuQty());
			invArMnVO.setArIfNo(invSplitVo.getInvArMnVO().getArIfNo());
			invArMnVO.setInvSplitCd("S");
			invArMnVO.setBlInvCfmDt("");			
			invArMnVO.setInvDeltDivCd("N");	
			//invArMnVO.setInvCurrCd(invSplitVo.getInvCurrCd());
			invArMnVO.setBfrInvCurrCd(invSplitVo.getInvArMnVO().getBfrInvCurrCd());
			
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
			//Main Table Iss Flg setting 20091229
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			// WHF items init.
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
			
			String localTime = dbDao.searchLocalTime(invArMnVO.getArOfcCd());

			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(invArMnVO.getActCustCntCd());
			arCrdtVo.setActCustSeq(invArMnVO.getActCustSeq());
			arCrdtVo.setSailArrDt(invArMnVO.getSailArrDt());
			arCrdtVo.setIoBndCd(invArMnVO.getIoBndCd());
			arCrdtVo.setDestTrnsSvcModCd(invArMnVO.getDestTrnsSvcModCd());
			arCrdtVo.setArOfcCd(invArMnVO.getArOfcCd());
			arCrdtVo.setDelCd(invArMnVO.getDelCd());
			
			String locCd ="";
			
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
			//String arAgnStlCd = arOfcAttributeVO.getArAgnStlCd();
			
			CoaVO coaVO = dbDao.searchCOA(invArMnVO.getArOfcCd());
			
			String invCoaCoCd = "";
			String invCoaCtrCd = "";
			String invCoaRgnCd = "";
			
			if(coaVO!=null){
				invCoaCoCd = coaVO.getInvCoaCoCd()!=null?coaVO.getInvCoaCoCd():"";
				invCoaCtrCd = coaVO.getInvCoaCtrCd()!=null?coaVO.getInvCoaCtrCd():"";
				invCoaRgnCd = coaVO.getInvCoaRgnCd()!=null?coaVO.getInvCoaRgnCd():"";
			}

			invArMnVO.setInvSvcScpCd(invArMnVO.getInvSvcScpCd());

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
				
				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				
			}

			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());
			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());

			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
			
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

			dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setCreUsrId(invSplitVo.getUserId());
					invArCntrVOs.get(i).setUpdUsrId(invSplitVo.getUserId());
				}
				dbDao.addInvContainer(invArCntrVOs, invSplitVo.getUserId());
			}

			cnt = dbDao.checkAccountRateExist(invSplitVo.getInvArMnVO().getGlEffDt());

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
					// ERP I/F process
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
	 * Booking, Wharfage issue receivables information Interface BackEndJob call.<br>
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
			
			if(bkgIfVo.getManDivInd().equals("B")||bkgIfVo.getManDivInd().equals("S")){	
				bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo, userId);
				// Interface Table Insert fail
				if (bkgSeq==null){
					
					throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
					
				}
				
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
	 * Kor Wharfage issue receivables information interface  <br>
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
			// Interface Table Insert fail.
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
	 * Booking, Wharfage issue receivables information Interface BackEndJob List call.<br>
	 * 
	 * @param List<ARBkgInterfaceCreationVO> bkgIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(List<ARBkgInterfaceCreationVO> bkgIfVos) throws EventException{
		
		String bkgNo = "";
		//String bkgSeq = "";
		String userId = "";
		String bkgCorrNo = "";
		String backEndJobKey = "";
		try {
			List<ARBkgInterfaceCreationVO> uniqueARBkgIfVOs = new ArrayList<ARBkgInterfaceCreationVO>();
			
			List<String> listBkgNoUnique = new ArrayList<String>(); 

			if (bkgIfVos != null && bkgIfVos.size() > 0) {
				for (int l=0; l<bkgIfVos.size(); l++) {
					
					if (!listBkgNoUnique.contains(String.valueOf(bkgIfVos.get(l).getBkgNo())) && !bkgIfVos.get(l).getBkgNo().equals("")) {						
						listBkgNoUnique.add(bkgIfVos.get(l).getBkgNo());						
						uniqueARBkgIfVOs.add(bkgIfVos.get(l));
					}
				}
			}
			
			
			for (int i = 0; i< uniqueARBkgIfVOs.size(); i++ ){
				bkgNo = uniqueARBkgIfVOs.get(i).getBkgNo();	
				userId = uniqueARBkgIfVOs.get(i).getUserId();	
				bkgCorrNo = uniqueARBkgIfVOs.get(i).getBkgCorrNo()==null?"":uniqueARBkgIfVOs.get(i).getBkgCorrNo();	
				if(uniqueARBkgIfVOs.get(i).getManDivInd().equals("B")||uniqueARBkgIfVOs.get(i).getManDivInd().equals("M")){
					dbDao.addInvBkgIf(bkgNo, bkgCorrNo ,userId);
				}
				
			}
			
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
	 * Booking, Wharfage issue receivables information interface, ERP AR attribute creation.<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException{
		
		INVCommonUtil utilCmd = new INVCommonUtil();
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		ARInvoiceCorrectionBC acommand = new ARInvoiceCorrectionBCImpl();
		//AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		
		try {
			String bkgNo = bkgIfVo.getBkgNo();
			String bkgSeq = "";
			String bkgUserId = bkgIfVo.getUserId();
			String userId = "BKG I/F";
			String bkgCorrNo = "";
			int updCnt = 0;
			
			// BkgNo call in case(Manual Interface screen)
			if(bkgIfVo.getManDivInd().equals("M")&&bkgIfVo.getBkgSeq().equals("")){
				
				//IF Table Insert			
				bkgSeq = dbDao.addInvBkgIf(bkgNo, bkgCorrNo, bkgUserId);
				if (bkgSeq==null){					
					throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
				}	
				
				return null;
			
			// Manual Interface screen BKG is BKG_SEQ setting
			}else{
				bkgSeq = bkgIfVo.getBkgSeq();
			}

			int cntPpdOfc = dbDao.checkEurPpdOfc(bkgNo);
			
			if(cntPpdOfc > 0){
				createFACComm(bkgNo);
				
				BkgOfcPayIndVO bkgOfcPayIndVO = dbDao.searchEurPpdOfc( bkgNo );
				
				dbDao.addInvBkgIfFacChg( bkgNo, bkgSeq, bkgOfcPayIndVO.getOfcCd(), bkgOfcPayIndVO.getCustCntCd(), bkgOfcPayIndVO.getCustSeq() );
			}	
			// FAC creation End
			
			BLNoBKGStatusVO bLNoBKGStatusVO = dbDao.searchBLNoByBKGNo(bkgNo,bkgSeq);
			
			if( bLNoBKGStatusVO == null){
				dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00172", new String[] {}).getUserMessage(), bkgUserId);
			} else {			
				if(bLNoBKGStatusVO.getBlSrcNo().equals("")||bLNoBKGStatusVO.getCxlFlg().equals("")||bLNoBKGStatusVO.getBkgStsCd().equals("")){				
					if(bLNoBKGStatusVO.getBlSrcNo().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00173", new String[] {}).getUserMessage(), bkgUserId);
					} else if (bLNoBKGStatusVO.getCxlFlg().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00174", new String[] {}).getUserMessage(), bkgUserId);
					} else if (bLNoBKGStatusVO.getBkgStsCd().equals("")){
						dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00175", new String[] {}).getUserMessage(), bkgUserId);
					}
				} else {
					
					List<InvArIfNoVO> mainIfNos = new ArrayList<InvArIfNoVO>();
					
					String blSrcNo = bLNoBKGStatusVO.getBlSrcNo();
					String autoMnlDivCd = bLNoBKGStatusVO.getAutoMnlDivCd();
					String chnAgnCd = bLNoBKGStatusVO.getChnAgnCd();					
					
					dbDao.searchMaxInterfaceForUpdate(bLNoBKGStatusVO.getBlSrcNo());
					
					// Max IF Main data
					List<MaxIFMainVO> maxIFMainVOs = dbDao.searchMaxInterfaceList(bLNoBKGStatusVO.getBlSrcNo());
					
					
					List<BkgOfcPayIndVO> bkgOfcPayIndVOs = dbDao.searchBKGOfficeList(bkgNo,bkgSeq);
					
					
					// Booking Cancel Flag = 'Y'
					if(bLNoBKGStatusVO.getCxlFlg().equals("Y")||bkgOfcPayIndVOs.size()==0){
						for(int i=0;i< maxIFMainVOs.size();i++){
							
							// Delete Division Code = 'N'  
							if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
								
								// Good Date IS NOT NULL
								if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									String cancelIfNo = "";
									
									// A/R Office is korean in case
									if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
										int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
										
										//Dec WHF is exist in case
										if(cnt>0){
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(),"N");
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										
										//Dec WHF is not exist in case
										}else{
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),"N");
											
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										}								
										
									//A/R Office is not korean in case	
									}else{
										cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N",maxIFMainVOs.get(i).getCreUsrId(),"N");
										
										if(!cancelIfNo.equals("")){
											InvArIfNoVO ifNo = new InvArIfNoVO();
											ifNo.setIfNo(cancelIfNo);
											ifNos.add(ifNo);
										}
									}

									updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
									
									// SysClear ifNo ERP send
									if(updCnt==2){
										InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
										mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
										mainIfNos.add(mainIfNoVo);
									}									
									
								//Good Date IS NULL	
								}else if(maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
								}
							}
						}
						
						if(bLNoBKGStatusVO.getCxlFlg().equals("Y")){
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00176", new String[] {}).getUserMessage(), bkgUserId);
						}else{
							if(maxIFMainVOs.size()>0){
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00176", new String[] {}).getUserMessage(), bkgUserId);
							}else{
								dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", new ErrorHandler("INV00177", new String[] {}).getUserMessage(), bkgUserId);
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
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "C", new ErrorHandler("INV00177", new String[] {}).getUserMessage(), bkgUserId);
							return null;
						}

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
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00178", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((svcScpCd!=null&&svcScpCd.equals("")) || svcScpCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00179", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((vvd!=null&&vvd.equals("")) || vvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00180", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((polCd!=null&&polCd.equals("")) || polCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00181", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((podCd!=null&&podCd.equals("")) || podCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00182", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}

							// rev vvd , rlane cd is not exist in case, error
							if((revVvd!=null&&revVvd.equals("")) || revVvd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00183", new String[] {}).getUserMessage(), bkgUserId);
								return null;
							}
							
							if((rlaneCd!=null&&rlaneCd.equals("")) || rlaneCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00184", new String[] {}).getUserMessage(), bkgUserId);
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
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00185", new String[] {bkgOfcPayIndVOs.get(i).getOfcCd()}).getUserMessage() , bkgUserId);
								return null;
							}
							
							if((arCurrCd!=null&&arCurrCd.equals("")) || arCurrCd==null){
								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00186", new String[] {}).getUserMessage(), bkgUserId);
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
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00149", new String[] {actCustCntCd+actCustSeq}).getUserMessage(), bkgUserId);
//								return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if(invCustCnt == 0 ){
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00149", new String[] {actCustCntCd+actCustSeq}).getUserMessage(), bkgUserId);
//								return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							if((actCustCntCd!=null&&actCustCntCd.equals("")) || actCustCntCd==null){
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00150", new String[] {bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq()}).getUserMessage(), bkgUserId);
//								return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((actCustSeq!=null&&actCustSeq.equals("")) || actCustSeq==null){
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00151", new String[] {bkgOfcPayIndVOs.get(i).getCustCntCd()+ bkgOfcPayIndVOs.get(i).getCustSeq()}).getUserMessage(), bkgUserId);
//								return null;
								actCustCntCd = arOfficeVO.getRepCustCntCd();
								actCustSeq = arOfficeVO.getRepCustSeq();
							}
							
							if((invCustCntCd!=null&&invCustCntCd.equals("")) || invCustCntCd==null){
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00152", new String[] {bkgNo}).getUserMessage(), bkgUserId);
//								return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							if((invCustSeq!=null&&invCustSeq.equals("")) || invCustSeq==null){
//								dbDao.modifyInvArIfStatus(bkgNo, bkgSeq, "E", new ErrorHandler("INV00153", new String[] {bkgNo}).getUserMessage(), bkgUserId);
//								return null;
								invCustCntCd =  arOfficeVO.getRepCustCntCd();
								invCustSeq= arOfficeVO.getRepCustSeq();
							}
							
							
							//String svrId = dbDao.searchServerID(arOfcCd);

							List<InvBkgIfChgVO> invBkgIfChgVOs = dbDao.searchInvoiceChargeList(bkgNo, bkgSeq, bkgOfcPayIndVOs.get(i).getOfcCd(), bkgOfcPayIndVOs.get(i).getIoBndCd(), bkgOfcPayIndVOs.get(i).getN3rdFlg());
														
							List<InvArChgVO> invArChgVOs = new ArrayList<InvArChgVO>();					
							
							for(int j=0; j< invBkgIfChgVOs.size();j++){	
								
								InvArChgVO  invArChgVO = new InvArChgVO();
								String tvaFlg = "N";								

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
							invArMnVO.setInvSvcScpCd(svcScpCd);
							invArMnVO.setRevVslCd(revVvd.length() == 10?revVvd.substring(0,4):"");
							invArMnVO.setRevSkdVoyNo(revVvd.length() == 10?revVvd.substring(4,8):"");
							invArMnVO.setRevSkdDirCd(revVvd.length() == 10?revVvd.substring(8,9):"");
							invArMnVO.setRevDirCd(revVvd.length() == 10?revVvd.substring(9,10):"");
							invArMnVO.setRlaneCd(rlaneCd);
							invArMnVO.setSailDt(sailDt);
							invArMnVO.setSailArrDt(sailArrDt);
							invArMnVO.setZnIocCd(znIocCd);

							invArMnVO.setSlsOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							invArMnVO.setInvOrgOfcCd(bkgOfcPayIndVOs.get(i).getOfcCd());
							
							InvArMnVO teuFeu = dbDao.searchBkgIfTeuFeu(bkgNo,bkgSeq);
							
							invArMnVO.setBkgTeuQty(teuFeu.getBkgTeuQty());
							invArMnVO.setBkgFeuQty(teuFeu.getBkgFeuQty());	
							invArMnVO.setBkgCorrNo(teuFeu.getBkgCorrNo());	
							
							invArMnVO.setN3rdFlg(bkgOfcPayIndVOs.get(i).getN3rdFlg());
							
							invCreVo.setInvArMnVO(invArMnVO);
							invCreVo.setInvArChgVOs(invArChgVOs);
							invCreVo.setLocCd(locCd);
							invCreVo.setArHdQtrOfcCd(arHdQtrOfcCd);
							invCreVo.setArAgnStlCd(arAgnStlCd);
							invCreVos.add(invCreVo);
							
							
							com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
							
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
				            
							//add for third office's exchange rate date assigning 2016.04.26
				            if(("Y").equals(invArMnVO.getN3rdFlg())){
								vvdCustomerVo.setCurr("USD");
								exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
								
								if(("V").equals(exchangeRateVo.getUsdExrateType()) || ("V").equals(exchangeRateVo.getThirdExrateType())){
									
									int cnt = dbDao.searchVVDExrateCount(vvdCustomerVo);
									
									if(cnt == 0){
										String ibFlag = "";
										String xchRtDt = dbDao.searchVVDExrateDateForAROffice(vvdCustomerVo);
										
										if(xchRtDt == null || (xchRtDt != null && ("").equals(xchRtDt))){
											if(xchRtDt == null) ibFlag = "I";
											else if(xchRtDt != null && ("").equals(xchRtDt)) ibFlag = "U";
											
											xchRtDt = dbDao.searchVVDExrateDateForThirdOffice(vvdCustomerVo);
											
											if(xchRtDt == null) xchRtDt = "";
											
											if(("I").equals(ibFlag) || (("U").equals(ibFlag) && !("").equals(xchRtDt))){
												VVDExrateVO vvdXchVo = new VVDExrateVO();
												
												vvdXchVo.setIbflag(ibFlag);
												vvdXchVo.setVvdCd(vvd);
												vvdXchVo.setSvcScpCd(invArMnVO.getInvSvcScpCd());
												vvdXchVo.setPortCd(("O").equals(invArMnVO.getIoBndCd()) ? invArMnVO.getPolCd() : invArMnVO.getPodCd());
												vvdXchVo.setIoBndCd(invArMnVO.getIoBndCd());
												vvdXchVo.setArOfcCd(invArMnVO.getArOfcCd());
												vvdXchVo.setXchRtDt(xchRtDt);
												vvdXchVo.setCngRmk("Created by system automatically");
												
												if(vvdXchVo != null) {
													VVDExrateVO[] vvdXchVos = new VVDExrateVO[1];
													vvdXchVos[0] = vvdXchVo;
													List<VVDExrateVO> targetVoList = command.manageVVDExchangeRateDate(vvdXchVos, bkgUserId, "N");
													
													List<ExchangeRateVO> allList = new ArrayList<ExchangeRateVO>();
													
													for(int p = 0; p < targetVoList.size(); p++){
														List<ExchangeRateVO> list = command.searchVVDExRate(targetVoList.get(p));
														allList.addAll(list);
													}
													
													if(allList.size() > 0){
														List<BkgInvTaxIfVO> bkgTaxAllList = new ArrayList<BkgInvTaxIfVO>();
														
														for(int m = 0; m < allList.size(); m++){
															ExchangeRateVO[] exchangeRateVos = new ExchangeRateVO[1];
															exchangeRateVos[0] = allList.get(m);
															
															List<BkgInvTaxIfVO> bkgInvTaxIfList = modifyBLExchangeRate(exchangeRateVos, bkgUserId);
															
															if (bkgInvTaxIfList != null && bkgInvTaxIfList.size() > 0 ) { 
																bkgTaxAllList.addAll(bkgInvTaxIfList);
															}
														}
														
														if (bkgTaxAllList != null && bkgTaxAllList.size() > 0 ) { 
															//Make Tax Exchange Rate for Booking - Dup booking no 제거 
															List<BkgInvTaxIfVO> bkgNoTempList = new ArrayList<BkgInvTaxIfVO>();
															List<String> emptyBkgNo = new ArrayList<String>();
															for(BkgInvTaxIfVO temp : bkgTaxAllList) {
																if(!emptyBkgNo.contains(temp.getBkgNo())) {
																	bkgNoTempList.add(temp);
																	emptyBkgNo.add(temp.getBkgNo());
																}
															}				
															if (bkgNoTempList != null && bkgNoTempList.size() > 0 ) { 
																BlRatingBC blRateCmd = new BlRatingBCImpl();
																blRateCmd.addInvTaxIf(bkgNoTempList);		
															}
														}
													}
												}
											}	
										}
									}
								}
							}  
						}				
						
						int invCreFlgCnt = 0;
						String cntrDiv = "N";
						
						//[Max I/F 1...n] For
						for( int i = 0; i< maxIFMainVOs.size(); i++ ){
							int divCnt = 0;				
							int ofcDivCnt = 0;	
							String vvdTrnsFlg = "N";	
							
							//[New I/F 1...n] For
							for( int j = 0; j < invCreVos.size(); j++ ){
								
								//Max I/F's A/R Office and new I/F's A/R Office is same in case
								if(maxIFMainVOs.get(i).getArOfcCd().equals(invCreVos.get(j).getInvArMnVO().getArOfcCd())){
									ofcDivCnt = ofcDivCnt + 1;									
									
									//Max I/F's Delete Division Code = 'N' in case
									if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
										
										//Max I/F's Good Date IS NOT NULL in case
										if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
											
											// VVD, Service Scope, Lane, POL(POD), Revenue VVD, Revenue Lane, Charge Type, Per Type, Currency, Rate, Rated As, Amount, Exchange Rate
											if(!maxIFMainVOs.get(i).getVvdCd().equals(invCreVos.get(j).getInvArMnVO().getVslCd()+invCreVos.get(j).getInvArMnVO().getSkdVoyNo()+invCreVos.get(j).getInvArMnVO().getSkdDirCd())){
												vvdTrnsFlg = "Y";
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
											//ADD LOCAL CURRENCY CONDITION 2016.05.23
											if(!maxIFMainVOs.get(i).getLoclCurrCd().equals(invCreVos.get(j).getInvArMnVO().getLoclCurrCd())){
												divCnt = divCnt+1;
											}	
											if(!maxIFMainVOs.get(i).getBkgTeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgTeuQty())||!maxIFMainVOs.get(i).getBkgFeuQty().equals(invCreVos.get(j).getInvArMnVO().getBkgFeuQty())){
												cntrDiv = "Y";
											}		
											
											int whfDeclNoCnt = 0;
											String whfChk = "";
											
											if(invCreVos.get(j).getLocCd().substring(0,2).equals("KR")){
												// chacking exist Whf Decl No from BKG.
												whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(bLNoBKGStatusVO.getBlSrcNo(), maxIFMainVOs.get(i).getArOfcCd(),bLNoBKGStatusVO.getWhfDeclNo());
												
												whfChk = whfDeclNoCnt>0?"Y":"N";

												if(!bLNoBKGStatusVO.getWhfDeclNo().equals("")&&whfChk.equals("N")){
													divCnt = divCnt+1;
												}
												
												// WHF CANCEL in case. 
												if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
													divCnt = divCnt+1;
												}
											}

											List<MaxIFChgeVO> compIFChgeVOs = dbDao.compareBkgIFChargeList(bkgNo, bkgSeq, invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk, maxIFMainVOs.get(i).getArOfcCd());
											
											if(compIFChgeVOs.size()>0){
												divCnt = divCnt+1;
											}
											
											// Max IF Chg data
											List<MaxIFChgeVO> maxIFChgeVOs = dbDao.searchChargeListForMaxInterface(bLNoBKGStatusVO.getBlSrcNo(),maxIFMainVOs.get(i).getArOfcCd(), whfChk); 
											
											// Chg data
											List<InvBkgIfChgVO> bkgIFChgeVOs = dbDao.searchInvoiceIfChargeList(bkgNo,bkgSeq,invCreVos.get(j).getInvArMnVO().getSlsOfcCd(), whfChk);
											
											int chgDivCnt = 0;	
											
											//Charge item comparison
											for(int k=0;k< maxIFChgeVOs.size();k++){
												for(int l=0;l< bkgIFChgeVOs.size();l++){														
													
													if(maxIFChgeVOs.get(k).getChgCd().equals(bkgIFChgeVOs.get(l).getChgCd())&&
															maxIFChgeVOs.get(k).getCurrCd().equals(bkgIFChgeVOs.get(l).getCurrCd())&&
																	maxIFChgeVOs.get(k).getPerTpCd().equals(bkgIFChgeVOs.get(l).getPerTpCd())&&
																		maxIFChgeVOs.get(k).getTrfRtAmt().equals(bkgIFChgeVOs.get(l).getTrfRtAmt())&&
																			maxIFChgeVOs.get(k).getRatAsCntrQty().equals(bkgIFChgeVOs.get(l).getRatAsCntrQty())){
														
														chgDivCnt = chgDivCnt + 1;
														
														if(!maxIFChgeVOs.get(k).getChgAmt().equals(bkgIFChgeVOs.get(l).getChgAmt())){
															divCnt = divCnt+1;
														}
													}
												}
											}
											
											if(chgDivCnt==0&&maxIFChgeVOs.size()>0){
												divCnt = divCnt+1;
											}
											
											if(chgDivCnt!=maxIFChgeVOs.size()){
												divCnt = divCnt+1;
											}										
											
											if(maxIFChgeVOs.size()!=bkgIFChgeVOs.size()){
												divCnt = divCnt+1;
											}
											
											// Max I/F and New I/F's VVD, Charge items comparison									
											if(divCnt>0){
												
												String cancelIfNo = "";
												
												//A/R Office is korean in case
												if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
													int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
													
													
													//Dec WHF is exist in case
													if(cnt>0){
														cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													
													//Dec WHF is not exist in case
													}else{
														cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
														
														if(!cancelIfNo.equals("")){
															InvArIfNoVO ifNo = new InvArIfNoVO();
															ifNo.setIfNo(cancelIfNo);
															ifNos.add(ifNo);
														}
													}											
												
												//A/R Office is not korean in case.
												}else{
													cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(), vvdTrnsFlg);
													
													if(!cancelIfNo.equals("")){
														InvArIfNoVO ifNo = new InvArIfNoVO();
														ifNo.setIfNo(cancelIfNo);
														ifNos.add(ifNo);
													}
												}

												updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
												
												// SysClear ifNo ERP send
												if(updCnt==2){
													InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
													mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
													mainIfNos.add(mainIfNoVo);
												}
												
												invCreVos.get(j).setInvCreFlg("Y");
												invCreFlgCnt = invCreFlgCnt + 1;

											}else{
												invCreVos.get(j).setInvCreFlg("N");
											}
											
										//Max I/F's Good Date IS NULL in case	
										}else{
											dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
											invCreVos.get(j).setInvCreFlg("Y");
											invCreFlgCnt = invCreFlgCnt + 1;
										}
									
									//Max I/F's Delete Division Code = 'X' in case
									}else if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("X")){
										invCreVos.get(j).setInvCreFlg("Y");
										invCreFlgCnt = invCreFlgCnt + 1;
									}
									
									// Change Container in case, Max IF update.
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
							
							//Max I/F's A/R Office and new I/F's A/R Office is not in case
							if(ofcDivCnt==0){								
								
								// Max I/F's Delete Division Code = 'N' in case
								if(maxIFMainVOs.get(i).getInvDeltDivCd().equals("N")){
									String cancelIfNo = "";
									
									//Max I/F's Good Date IS NOT NULL in case
									if(!maxIFMainVOs.get(i).getBlInvCfmDt().equals("")){
									
										//A/R Office is korean in case
										if(maxIFMainVOs.get(i).getLocCd().equals("KR")){
											int cnt = dbDao.checkDecWHF(maxIFMainVOs.get(i).getArIfNo());
											
											
											//Dec WHF is exist in case.
											if(cnt>0){
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"Y", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											
											//Dec WHF is not exist in case
											}else{
												cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
												
												if(!cancelIfNo.equals("")){
													InvArIfNoVO ifNo = new InvArIfNoVO();
													ifNo.setIfNo(cancelIfNo);
													ifNos.add(ifNo);
												}
											}
											
										//A/R Office is not korean in case
										}else{
											cancelIfNo = createMaxIFCancel(maxIFMainVOs.get(i).getArIfNo(),"N", maxIFMainVOs.get(i).getCreUsrId(),vvdTrnsFlg);
											
											if(!cancelIfNo.equals("")){
												InvArIfNoVO ifNo = new InvArIfNoVO();
												ifNo.setIfNo(cancelIfNo);
												ifNos.add(ifNo);
											}
										}

										updCnt = dbDao.modifySysClearFlag(maxIFMainVOs.get(i).getArIfNo(),cancelIfNo, userId);
										
										// SysClear ifNo ERP send
										if(updCnt==2){
											InvArIfNoVO mainIfNoVo = new InvArIfNoVO();
											mainIfNoVo.setIfNo(maxIFMainVOs.get(i).getArIfNo());
											mainIfNos.add(mainIfNoVo);
										}
									
									// Same office is not exist and no good in case, delt_div_cd update.
									}else{
										dbDao.modifyDelCode(maxIFMainVOs.get(i).getArIfNo(), userId);
									}
									
								}
							}
							
						}
						
						
						//[New I/F 1...n] For 
						for( int i = 0; i < invCreVos.size(); i++ ){					
							//Invoice Create Flag is null in case, input 'Y'
							if(invCreVos.get(i).getInvCreFlg()==null){
								invCreVos.get(i).setInvCreFlg("Y");
								invCreFlgCnt = invCreFlgCnt + 1;
							}
						}

						// If data will creation on INV in new I/F.
						if(invCreFlgCnt>0){
							
							//[New I/F 1...n] For
							for( int i = 0; i < invCreVos.size(); i++ ){
								BKGMainDocVO bKGMainDocVO = dbDao.searchBKGInterface( bkgNo, bkgSeq ,invCreVos.get(i).getInvArMnVO().getSlsOfcCd());								
								
								// If INV target for creation
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

									invCreVos.get(i).getInvArMnVO().setObrdDt(bKGMainDocVO.getObrdDt());
 
									invCreVos.get(i).getInvArMnVO().setCtrtOfcCd(bKGMainDocVO.getCtrtOfcCd());
									
									// If A/R Office is korean
									if(invCreVos.get(i).getLocCd().substring(0,2).equals("KR")){
										
										// If WHF CANCEL
										if(bLNoBKGStatusVO.getWhfDeclCxlFlg().equals("Y")){
											
											// Same Whf Decl No on BKG checking
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());
											
											if(whfDeclNoCnt > 0 && bKGMainDocVO.getWhfFlg().equals("Y")){
												dbDao.modifyWhfDeclNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfDeclNo(), bkgUserId);
																								
												invCreVos.get(i).getInvArMnVO().setWhfFlg("C");
												invCreVos.get(i).getInvArMnVO().setInvRmk(bKGMainDocVO.getWhfDeclNo());
												
												//WHF_FLG 'Y' in case WHF CHG
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
													//Charge item WHF include row delete
													if(!invCreVos.get(i).getInvArChgVOs().get(j).getChgCd().equals("WHF")){												
														//invCreVos.get(i).getInvArChgVOs().remove(invCreVos.get(i).getInvArChgVOs().get(j));
														invArWhfChgVOs.add(invCreVos.get(i).getInvArChgVOs().get(j));												
													}
												}
												
												invCreVos.get(i).setInvArChgVOs(invArWhfChgVOs);
											}
											
										} else {									
										
											// Same Whf Decl No checking
											int whfDeclNoCnt = dbDao.checkExistsDecWHFByBL(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(),bKGMainDocVO.getWhfDeclNo());

											if(whfDeclNoCnt==0&&bKGMainDocVO.getWhfFlg().equals("Y")){
												//A/R Office is korean 
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
												
												// WHF_FLG 'Y' WHF CHG
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
											
											// If Dec WHF is exist
											if(whfCnt>0){	
												//2009-11-26 WHF update.
												dbDao.modifyWhfNtcNo(blSrcNo, invCreVos.get(i).getInvArMnVO().getArOfcCd(), bKGMainDocVO.getWhfNtcNo(), bKGMainDocVO.getWhfDeclNo());
																						

												if(bKGMainDocVO.getWhfDeclNo().equals("")||whfDeclNoCnt>0){
													List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();		
													
													for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
														// Charge item WHF include row delete
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
									
									ARCreditInputVO arCrdtVo = new ARCreditInputVO();
									arCrdtVo.setActCustCntCd(invCreVos.get(i).getInvArMnVO().getActCustCntCd());
									arCrdtVo.setActCustSeq(invCreVos.get(i).getInvArMnVO().getActCustSeq());
									arCrdtVo.setSailArrDt(invCreVos.get(i).getInvArMnVO().getSailArrDt());
									arCrdtVo.setIoBndCd(invCreVos.get(i).getInvArMnVO().getIoBndCd());
									arCrdtVo.setDestTrnsSvcModCd(invCreVos.get(i).getInvArMnVO().getDestTrnsSvcModCd());
									arCrdtVo.setArOfcCd(invCreVos.get(i).getInvArMnVO().getArOfcCd());
									arCrdtVo.setLocCd(invCreVos.get(i).getLocCd().substring(0,2));
									arCrdtVo.setDelCd(invCreVos.get(i).getInvArMnVO().getDelCd());
									
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
									
									// DELT FLG is not 'Y' in case chechking IFNO
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
									
									for(int j = 0 ; j < invCreVos.get(i).getInvArChgVOs().size(); j++){
										String repChgCd = dbDao.searchRepCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										
										invCreVos.get(i).getInvArChgVOs().get(j).setRepChgCd(repChgCd==null?"XXX":repChgCd);
										
										String chgFullNm= dbDao.searchChargeName(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										invCreVos.get(i).getInvArChgVOs().get(j).setChgFullNm(chgFullNm);								
										
										// If Account Division Code = 'P'
										if (acct_div_cd.equals("P")) {
											acctCd = dbDao.searchAccountCdFromCharge(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										} else {
											acctCd = dbDao.searchAccountCdFromRevAcct(invCreVos.get(i).getInvArChgVOs().get(j).getChgCd());
										}

										acctCd = dbDao.searchAccountCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);
										
										revCoaAcctCd = dbDao.searchRevCoaAcctCd( invCreVos.get(i).getInvArMnVO().getArOfcCd(), invCreVos.get(i).getInvArChgVOs().get(j).getChgCd(), revTpCd , revSrcCd, svrId,  acctCd);

										revCoaVslCd = invCreVos.get(i).getInvArMnVO().getRevVslCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevVslCd();
										revCoaVoyNo = invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdVoyNo();
										revCoaSkdDirCd = invCreVos.get(i).getInvArMnVO().getRevSkdDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevSkdDirCd();
										revCoaDirCd = invCreVos.get(i).getInvArMnVO().getRevDirCd().equals("")?"":invCreVos.get(i).getInvArMnVO().getRevDirCd();
																				
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
									
									String newIfNo = createBKGInvoice(invCreVos.get(i), bkgUserId);
	
									if(!newIfNo.equals("")){
										InvArIfNoVO ifNo = new InvArIfNoVO();
										ifNo.setIfNo(newIfNo);
										ifNos.add(ifNo);
									}
									
									dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "Y", new ErrorHandler("INV00187", new String[] {}).getUserMessage(), bkgUserId);
								}					
							}
						}else{
							dbDao.modifyInvArIfStatus(bkgNo,bkgSeq, "X", new ErrorHandler("INV00188", new String[] {}).getUserMessage(), bkgUserId);
						}
					}

					//Add sys clear by i/f no 2016.06.17
					if(maxIFMainVOs != null){
					    for(int i=0;i< maxIFMainVOs.size();i++){
					        SysClearVO ifNoSysClearVo = new SysClearVO();
								
					        ifNoSysClearVo.setOfcCd(maxIFMainVOs.get(i).getArOfcCd());
					        ifNoSysClearVo.setBlNo(bLNoBKGStatusVO.getBlSrcNo());
					        ifNoSysClearVo.setUserId(bkgUserId);
					        ifNoSysClearVo.setVvdCd("");
					        ifNoSysClearVo.setCustCd("");
					        
					        acommand.modifySysClearByIFNo(ifNoSysClearVo);
					    }
					}
					
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

	private void createFACComm(String bkgNo) {
//		AGTCalcToInvBC agtCalcToInvBC = new AGTCalcToInvBCImpl();
		FACCommCalculationBC facCalcBC = new FACCommCalculationBCImpl();
		
		try{
//			agtCalcToInvBC.createFACComm(bkgNo);
			facCalcBC.createFACCommInv(bkgNo);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}
	
	/**
	 * Cancel Interface data creation.<br>
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

			InvArMnVO invArMnVO = new InvArMnVO();
			List<InvArChgVO> invArChgVOs = null;
			List<InvArChgVO> invArWhfChgVOs = new ArrayList<InvArChgVO>();
			List<InvArAmtVO> invArAmtVOs = null;
			List<InvArAmtVO> invArWhfAmtVOs = new ArrayList<InvArAmtVO>();
			List<InvArCntrVO> invArCntrVOs = null;			
			ActInvCustVO actInvCustVO = new ActInvCustVO();
			List<InvArChgVO> xchList = null;

			invArMnList = dbDao.searchARInvoice(maxIfNo);
			invArChgVOs = dbDao.searchARInvoiceCharge(maxIfNo);			
			invArAmtVOs = dbDao.searchARInvoiceAmount(maxIfNo);
			invArCntrVOs = dbDao.searchARInvoiceContainer(maxIfNo);
			
			
			String maxSeq = dbDao.searchBKGInterfaceNo(invArMnList.get(0).getArOfcCd());			
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnList.get(0).getArOfcCd(), userId);
				maxSeq = "00000001";
			} else {
				dbDao.modifyNewInterfaceNo(invArMnList.get(0).getArOfcCd(), maxSeq, userId);
			}
			*/
			
			String newIfNo = invArMnList.get(0).getArOfcCd().substring(0, 3) + maxSeq;			

			invArMnVO = invArMnList.get(0);			

			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(invArMnVO.getArOfcCd(),invArMnVO.getBlSrcNo());
			
			if(actInvCustVO != null){
				invArMnVO.setActCustCntCd(actInvCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(actInvCustVO.getActCustSeq());
				invArMnVO.setDueDt(actInvCustVO.getDueDt());
				invArMnVO.setCustCrFlg(actInvCustVO.getCustCrFlg());
				invArMnVO.setCrTermDys(actInvCustVO.getCrTermDys());
				invArMnVO.setBfrInvCurrCd(actInvCustVO.getBfrInvCurrCd());		//2015.09.08 add
				
				//2016.10.17 add
				invArMnVO.setInvCustCntCd(actInvCustVO.getInvCustCntCd());
				invArMnVO.setInvCustSeq(actInvCustVO.getInvCustSeq());
				invArMnVO.setUsdXchRt(actInvCustVO.getUsdXchRt());
				invArMnVO.setXchRtUsdTpCd(actInvCustVO.getXchRtUsdTpCd());
				invArMnVO.setXchRtN3rdTpCd(actInvCustVO.getXchRtN3rdTpCd());
				invArMnVO.setXchRtDt(actInvCustVO.getXchRtDt());
				invArMnVO.setInvLoclXchRt(actInvCustVO.getInvLoclXchRt());
				invArMnVO.setInvUsdXchRt(actInvCustVO.getInvUsdXchRt());
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

			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd(vvdTrnsFlg);
			// Main Table Iss Flg setting
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			// Cancel WHF item init.
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
			
			//2016.10.17 add
			if(actInvCustVO != null){
				xchList = dbDao.searchExrateByIfNo(actInvCustVO.getArIfNo());
			}
			
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
				// If Whf Flag = 'Y', invChges information WHF row delete	
				
				//2016.10.17 add
				if(xchList != null){
					for (int j = 0; j < xchList.size(); j++) {
						if((invArChgVOs.get(i).getCurrCd()).equals(xchList.get(j).getCurrCd())){
							invArChgVOs.get(i).setInvXchRt(xchList.get(j).getInvXchRt());
							invArChgVOs.get(i).setUsdXchRt(xchList.get(j).getUsdXchRt());
							invArChgVOs.get(i).setInvXchRtDt(xchList.get(j).getInvXchRtDt());
						}
					}
				}
				
				if(whfFlg.equals("Y")){
					if(!invArChgVOs.get(i).getChgCd().equals("WHF")){	
						//invArChgVOs.remove(i);
						invArWhfChgVOs.add(invArChgVOs.get(i));
					}
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
				
				// If Whf Flag = 'Y', invAmts information WHF row delete				
				if(whfFlg.equals("Y")){
					if(!invArAmtVOs.get(i).getTjSrcNm().equals("WHF")){
						//invArAmtVOs.remove(invArAmtVOs.get(i));
						invArWhfAmtVOs.add(invArAmtVOs.get(i));
					}
				}		
			}

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(userId);
					invArCntrVOs.get(i).setUpdUsrId(userId);
				}
			}

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

				dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

				int cnt = dbDao.checkAccountRateExist(invArMnVO.getGlEffDt());

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
						// ERP I/F process
						dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

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
	 * Cancel Interface data creation.<br>
	 * 
	 * @param String maxIfNo
	 * @param String whfFlg
	 * @param String userId
	 * @param String vvdTrnsFlg
	 * @return String
	 * @exception EventException
	 */
	public String createMaxIFCancelForInv (String maxIfNo, String whfFlg, String userId, String vvdTrnsFlg) throws EventException{
		String rtIfNo = "";
		try {
			
			List<InvArMnVO> invArMnList = null;

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
			
			
			String maxSeq = "";
			String newIfNo = "";
			
			if (invArMnList.get(0).getRevTpCd().equals("M")) {
				maxSeq = dbDao.searchMRIInterfaceNo(invArMnList.get(0).getArOfcCd());
	
				if (maxSeq.equals("")) {
					dbDao.addMRIInterfaceNo(invArMnList.get(0).getArOfcCd(), userId);
					maxSeq = invArMnList.get(0).getArOfcCd().substring(0, 3) + 'M' + String.valueOf(DateTime.getYear()).substring(2, 4) + "00001";
				} else {
					dbDao.modifyMRIInterfaceNo(invArMnList.get(0).getArOfcCd(), maxSeq, userId);
				}	
				
				newIfNo = maxSeq;
			} else {
				maxSeq = dbDao.searchBKGInterfaceNo(invArMnList.get(0).getArOfcCd());			
				
				/*
				if (maxSeq == null) {
					dbDao.addNewInterfaceNo(invArMnList.get(0).getArOfcCd(), userId);
					maxSeq = "00000001";
				} else {
					dbDao.modifyNewInterfaceNo(invArMnList.get(0).getArOfcCd(), maxSeq, userId);
				}
				*/
				
				newIfNo = invArMnList.get(0).getArOfcCd().substring(0, 3) + maxSeq;		
			}
				

			invArMnVO = invArMnList.get(0);			

			
			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(invArMnVO.getArOfcCd(),invArMnVO.getBlSrcNo());
			
			if(actInvCustVO != null && !(invArMnList.get(0).getRevTpCd().equals("M")) ){
				invArMnVO.setActCustCntCd(actInvCustVO.getActCustCntCd());
				invArMnVO.setActCustSeq(actInvCustVO.getActCustSeq());
				invArMnVO.setDueDt(actInvCustVO.getDueDt());
				invArMnVO.setCustCrFlg(actInvCustVO.getCustCrFlg());
				invArMnVO.setCrTermDys(actInvCustVO.getCrTermDys());
				invArMnVO.setBfrInvCurrCd(actInvCustVO.getBfrInvCurrCd());		//2015.09.08 add
			}
			
			BigDecimal invTtlLoclAmt = new BigDecimal(invArMnVO.getInvTtlLoclAmt()).multiply(new BigDecimal(-1));
			
			//invArMnVO.setInvTtlLoclAmt(Float.toString(Float.parseFloat(invArMnVO.getInvTtlLoclAmt()) * -1));

			invArMnVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());

			
			String revTpCd = "";
			String revSrcCd = "";
			
			if (invArMnList.get(0).getRevTpCd().equals("M")) {
				revTpCd = "M";
				if(invArMnList.get(0).getRevSrcCd().equals("IV")) {
					revSrcCd = "IC";
				} else if(invArMnList.get(0).getRevSrcCd().equals("IC")) {
					revSrcCd = "IV";
				}
			} else {
				ARCorrectionCkReturnVO arCkRtVo = dbDao.searchRevTypeSrc(invArMnVO.getBkgNo(), "");
				
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
			if (invArMnList.get(0).getRevTpCd().equals("M")) {
				invArMnVO.setInvDeltDivCd("N");
			} else {
				invArMnVO.setInvDeltDivCd("X");
			}

			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd(vvdTrnsFlg);
			// Main Table Iss Flg setting
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			// Cancel WHF item init.
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
				// If Whf Flag = 'Y', invChges information WHF row delete	
				

				if(whfFlg.equals("Y")){
					if(!invArChgVOs.get(i).getChgCd().equals("WHF")){	
						//invArChgVOs.remove(i);
						invArWhfChgVOs.add(invArChgVOs.get(i));
					}
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
				
				// If Whf Flag = 'Y', invAmts information WHF row delete				
				if(whfFlg.equals("Y")){
					if(!invArAmtVOs.get(i).getTjSrcNm().equals("WHF")){
						//invArAmtVOs.remove(invArAmtVOs.get(i));
						invArWhfAmtVOs.add(invArAmtVOs.get(i));
					}
				}		
			}

			if (invArCntrVOs.size() > 0) {
				for (int i = 0; i < invArCntrVOs.size(); i++) {
					invArCntrVOs.get(i).setArIfNo(newIfNo);
					invArCntrVOs.get(i).setCreUsrId(userId);
					invArCntrVOs.get(i).setUpdUsrId(userId);
				}
			}

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

				dbDao.modifyInvTotalLocalAmount(invArMnVO.getArIfNo());

				int cnt = dbDao.checkAccountRateExist(invArMnVO.getGlEffDt());

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
						// ERP I/F process
						dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

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
	 * New I/F receivables data's VVD, Lane, Scope, Port, S/A Date, <br>
	 * Sailing Date, Revenue VVD, Revenue Lane information retrieve<br>
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
			
			//String svrId = dbDao.searchServerID(ofcCd);
			
			// If VVD, S/A Date is not exist or Europe			
			//2015.03.24	if((vvd==null||sailArrDt==null)||svrId.equals("EUR")){
			if(vvd==null||sailArrDt==null){	
				vvdPortVO = dbDao.searchTvvdPort(bkgNo, bkgSeq, ioBndCd);
				if(vvdPortVO != null){
					vvd = vvdPortVO.getVvd()!=null&&!vvdPortVO.getVvd().equals("")?vvdPortVO.getVvd():"";
					portCd = vvdPortVO.getPortCd()!=null&&!vvdPortVO.getPortCd().equals("")?vvdPortVO.getPortCd():"";
				}
				
				if(vvd != null){
					sailArrDt = dbDao.searchTrunkSaDt( vvd, portCd, ioBndCd );
				} else {
					sailArrDt = dbDao.searchTrunkSaDt( null, portCd, ioBndCd );
				}
			}
			
			slanCd = dbDao.searchLane( bkgNo, bkgSeq );
			svcScpCd = dbDao.searchServiceScope( bkgNo, bkgSeq );
			
			RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(bkgNo);
			
			if(revVVDLaneVO != null){
				revVvd = revVVDLaneVO.getRevVvd();
				rlaneCd = revVVDLaneVO.getRlaneCd();				
			}
			
			if(revVvd.equals("X")){
				revVVDLaneVO = dbDao.searchRevenueVVDLaneRd(vvd);
				if(revVVDLaneVO != null){
					revVvd = revVVDLaneVO.getRevVvd();
					rlaneCd = revVVDLaneVO.getRlaneCd();
					znIocCd = "OO";
				}
			}
						
			sailDt = dbDao.searchSailingDate(bkgNo);
			
			vvdLanePortVO.setPortCd(portCd);
			if(vvd != null){
				vvdLanePortVO.setVvd(vvd);
			} else {
				vvdLanePortVO.setVvd(null);
			}
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
	 * A/R Office information retrieve.<br>
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
			
			//A/R Office, Local Currency, Center Code, Region Code, Office Euro Mark, Office Agent Mark, Sub Agent Mark, customer code
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
	 * Actual / Invoice Customer Code retrieve<br>
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
		
		try{
			invCustCntCd = custInputVO.getCustCntCd();
			invCustSeq = custInputVO.getCustSeq();
			
			actInvCustVO = dbDao.searchMaxInterfaceCustomerCode(custInputVO.getArOfcCd(),custInputVO.getBlSrcNo());
			
			if(actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")){
					actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():invCustCntCd;
					actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():invCustSeq;
					invCustCntCd = actInvCustVO.getInvCustCntCd()!=null&&!actInvCustVO.getInvCustCntCd().equals("")?actInvCustVO.getInvCustCntCd():invCustCntCd;
					invCustSeq   = actInvCustVO.getInvCustSeq()!=null&&!actInvCustVO.getInvCustSeq().equals("")?actInvCustVO.getInvCustSeq():invCustSeq;
					
			}else{			
				
				//Charge Indicator = 'P' or 'C'
				if(custInputVO.getIoBndCd().equals("I")||custInputVO.getIoBndCd().equals("O")){
					
					// If Charge Indicator = 'T'
					if(custInputVO.getN3rdFlg().equals("Y")){
						actCustCntCd = custInputVO.getCustCntCd();
						actCustSeq = custInputVO.getCustSeq();
					}
					
					if(actCustCntCd.equals("")||actCustSeq.equals("")){
						
						// Sub Agent Mark Booking Office setting
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
						
						//Sub Agent Mark = 'Y' in case Bkg Office's Customer
						}else if(subAgnFlg.equals("Y")){
							actInvCustVO = dbDao.searchRepCustomerCode(custInputVO.getOfcCd());
							
							actCustCntCd = actInvCustVO.getActCustCntCd()!=null&&!actInvCustVO.getActCustCntCd().equals("")?actInvCustVO.getActCustCntCd():custInputVO.getCustCntCd();
							actCustSeq   = actInvCustVO.getActCustSeq()!=null&&!actInvCustVO.getActCustSeq().equals("")?actInvCustVO.getActCustSeq():custInputVO.getCustSeq();
							
						}else{							
							actCustCntCd = custInputVO.getCustCntCd();
							actCustSeq = custInputVO.getCustSeq();							
						}
					}
					
				}  
			}
			
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
	 * Actual Customer's Credit Flag, Credit Term, Due Date information retrieve.<br>
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
		//String otsSmryCd = "";
		//String svrId = "";
		//int ifCnt = 0;
		
		try{
			invCreVo.setCustCntCd(arCrdtVo.getActCustCntCd());
			invCreVo.setCustSeq(arCrdtVo.getActCustSeq());
			invCreVo.setOfcCd(arCrdtVo.getArOfcCd());
			invCreVo.setSailArrDt(arCrdtVo.getSailArrDt().replace("-", ""));
			invCreVo.setIoBndCd(arCrdtVo.getIoBndCd());
			invCreVo.setDueDt("X");

			invCreVo.setLocCd(arCrdtVo.getLocCd());
			aRCreditVO = dbDao.searchCreditCustomerForCredit(invCreVo); 
			
			if(aRCreditVO != null){
				dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
				crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
				custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
			}
			// If Credit Customer data is not exist or Credit term = 0
			if(dueDt.equals("")||crTermDys.equals("0")){
				aRCreditVO = dbDao.searchOfficeForCredit(invCreVo);
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt()!=null?aRCreditVO.getDueDt():"";
					crTermDys = aRCreditVO.getCrTerm()!=null?aRCreditVO.getCrTerm():"0";
					custCrFlg = aRCreditVO.getCrFlg()!=null?aRCreditVO.getCrFlg():"";
				}
			}
			
			if(aRCreditVO != null){
				if(dueDt != null){
					aRCreditVO.setDueDt(dueDt);
				} else {
					aRCreditVO.setDueDt(null);
				}
				if(crTermDys != null){
					aRCreditVO.setCrTerm(crTermDys);
				} else {
					aRCreditVO.setCrTerm(null);
				}
				if(custCrFlg != null){
					aRCreditVO.setCrFlg(custCrFlg);
				} else {
					aRCreditVO.setCrFlg(null);
				}
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
	 * Booking Interface data creation.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createBKGInvoice (ARInvoiceCreationVO invCreVo, String userId) throws EventException{
		INVCommonUtil utilCmd = new INVCommonUtil();
		//ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		VVDExrateInputVO vvdExrateVo = new VVDExrateInputVO();
		String rtIfNo = "";
		try {
			
			InvArMnVO invArMnVO = invCreVo.getInvArMnVO();
			List<InvArChgVO> invArChgVOs = invCreVo.getInvArChgVOs();
			List<InvArCntrVO> invArCntrVOs = invCreVo.getInvArCntrVOs();
			
			String maxSeq = dbDao.searchBKGInterfaceNo(invArMnVO.getArOfcCd());			
			
			/*
			if (maxSeq == null) {
				dbDao.addNewInterfaceNo(invArMnVO.getArOfcCd(), userId);
				maxSeq = "00000001";				
			} else {
				dbDao.modifyNewInterfaceNo(invArMnVO.getArOfcCd(), maxSeq, userId);
			}
			*/
			
			String newIfNo = invArMnVO.getArOfcCd().substring(0, 3) + maxSeq;
			
			invArMnVO.setArIfNo(newIfNo);			
			invArMnVO.setCreUsrId(userId);
			invArMnVO.setUpdUsrId(userId);
			invArMnVO.setInvDeltDivCd("N");
			//Bkg Interface Split Flag null setting.
			invArMnVO.setInvSplitCd("");
			invArMnVO.setInvVvdCxlCd("N");			
			invArMnVO.setBlInvCfmDt("");
			//Main Table Iss Flg setting
			invArMnVO.setInvIssFlg("N");
			invArMnVO.setInvClrFlg("N");

			invArMnVO.setInvNo("");
			invArMnVO.setIssDt("");
			
			String revTpSrcCd = invArMnVO.getRevTpCd()+invArMnVO.getRevSrcCd();
			String svrId = dbDao.searchServerID(invArMnVO.getArOfcCd());
			
			com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
			
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
			
            //2015.04.24 in case of 3rd office, create VVD exrate automatically
            //2016.01.11 add when ppd/cct office is different from finance control office 
            /*
            String fincCtrlOfcCd = dbDao.searchFincCtrlOffice(vvdCustomerVo);
            
            if(("Y").equals(invArMnVO.getN3rdFlg())){ // || (("N").equals(invArMnVO.getN3rdFlg()) && !(fincCtrlOfcCd).equals(invArMnVO.getArOfcCd()))){
            	vvdCustomerVo.setN3rdFlg(invArMnVO.getN3rdFlg());
            	vvdCustomerVo.setFincCtrlOfcCd(fincCtrlOfcCd);
				vvdCustomerVo.setCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
				
				if(("V").equals(exchangeRateVo.getUsdExrateType()) || ("V").equals(exchangeRateVo.getThirdExrateType())){
					
					VVDExrateVO[] vvdXchVos = new VVDExrateVO[1];
					VVDExrateVO vvdXchVo = dbDao.searchVVDExrateDateForThirdOffice(vvdCustomerVo);
					
					if(vvdXchVo != null) {
						vvdXchVos[0] = vvdXchVo;
						command.manageVVDExchangeRateDate(vvdXchVos, userId, "N");
					}
				}
			}
            */
            
			for (int i = 0; i < invArChgVOs.size(); i++) {
				
				String tjSrcNm = "";
				String invRevTpSrcCd = "";
				
				vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
				vvdCustomerVo.setCurr(invArChgVOs.get(i).getCurrCd());
				
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				
				invArChgVOs.get(i).setInvXchRt(exchangeRateVo.getExRate());
				invArChgVOs.get(i).setInvXchRtDt(exchangeRateVo.getExRateDate());
				
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
				
				// VVD rates is 0 in case VVD rates table Insert
				if((exchangeRateVo.getUsdExrateType().equals("V") && invArChgVOs.get(i).getCurrCd().equals("USD")) || (exchangeRateVo.getThirdExrateType().equals("V") && !invArChgVOs.get(i).getCurrCd().equals("USD"))){
					vvdExrateVo.setCurr(invArChgVOs.get(i).getCurrCd());
					if(!invArMnVO.getLoclCurrCd().equals(invArChgVOs.get(i).getCurrCd())){
						dbDao.addVVDExRate(vvdExrateVo,userId);
					}
				}
				
				//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
				vvdCustomerVo.setLclCurr("USD");
				exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
				invArChgVOs.get(i).setUsdXchRt(exchangeRateVo.getExRate());
			}
			
			vvdCustomerVo.setLclCurr(invArMnVO.getLoclCurrCd());
			vvdCustomerVo.setCurr("USD");
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			//VVD rates is 0 in case VVD rates table Insert
			if(exchangeRateVo.getUsdExrateType().equals("V")){
				vvdExrateVo.setCurr("USD");	
				if(!invArMnVO.getLoclCurrCd().equals("USD")){
					dbDao.addVVDExRate(vvdExrateVo,userId);
				}
			}

			invArMnVO.setUsdXchRt(exchangeRateVo.getExRate());
			invArMnVO.setInvLoclXchRt(exchangeRateVo.getExRate());
			invArMnVO.setXchRtUsdTpCd(exchangeRateVo.getUsdExrateType());
			invArMnVO.setXchRtN3rdTpCd(exchangeRateVo.getThirdExrateType());
			invArMnVO.setXchRtDt(exchangeRateVo.getExRateDate());

			invArMnVO.setObrdDt(exchangeRateVo.getCngIndivCd().equals("B") ? exchangeRateVo.getExRateDate() : invArMnVO.getObrdDt());

			vvdCustomerVo.setLclCurr("USD");
			vvdCustomerVo.setCurr(invArMnVO.getLoclCurrCd());
			exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);
			
			invArMnVO.setInvUsdXchRt(exchangeRateVo.getExRate());
			
			dbDao.addInvMain(invArMnVO);			
			dbDao.addInvCharge(invArChgVOs);	
			
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

			//Add to update TVA Flag 2015.05.12
			dbDao.modifyTVAFlag(invArMnVO.getArOfcCd(), invArMnVO.getBkgNo(), newIfNo);
			
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
					// ERP I/F process
					dbDao.modifyCFMDate(invArMnVO.getArIfNo(), "good", invArMnVO.getArOfcCd(), invArMnVO.getBlSrcNo());

					rtIfNo = newIfNo;
				}
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
	 * Multi event process<br>
	 * In screen multi event process<br>
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
		com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVo = null;
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
        
        String otsSmryCd = "";
        List<ArOfcAttributeVO> arOfcAttributeVOs = null;
        
        String clzStsCd = "";
        
        String svrId = invCreVo.getSvrId();
        
        //String ofcAgentMark = "";
        String erpIfOfcCd = "";
        MdmOrganizationVO mdmOrgVo = null;
		
		try {
			
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
			
			} else {				
				
				if(aRCreditVO != null){
					dueDt = aRCreditVO.getDueDt();
					crTermDys = aRCreditVO.getCrTerm();
					custCrFlg = aRCreditVO.getCrFlg();					
				}	
									
			}
			
			laneCd = dbDao.searchLaneCode(invCreVo.getLclVvd());

			zoneIoc = dbDao.searchZoneIOC(invCreVo.getPolCd(), invCreVo.getPodCd());

			mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, zoneIoc);
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLane(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd, "OO"); 
				
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRowNum(invCreVo.getLclVvd(), invCreVo.getPolCd(), laneCd);
				
			}
			
			if (mriRevenueVVDLane.getRevVvd().equals("")) {
				//rev_src_cd is 'RD' in case, set 'CNTC' to vsl
				if (invCreVo.getRevSrcCd().equals("RD")) {
					tVslCd = "CNTC";
				} else {
					tVslCd = invCreVo.getLclVvd().substring(0, 4);
				}
				mriRevenueVVDLane = dbDao.searchMRIRevenueVVDLaneRd(tVslCd); 
			}
					
			if (mriRevenueVVDLane.getRevVvd().equals("") || mriRevenueVVDLane.getRevLane().equals("")) {
				throw new EventException(new ErrorHandler("INV00119",new String[]{}).getMessage());
			}
			
			cityCd = dbDao.searchCityCd(invCreVo.getOfcCd());
			
			localTime = dbDao.searchLocalTime(invCreVo.getOfcCd());
						
			if (invCreVo.getBkgNo() != null && !invCreVo.getBkgNo().equals("")) {
				sailingDt = dbDao.searchSailingDateByBkgNo(invCreVo.getBkgNo());
			} else{
				sailingDt= dbDao.searchSailingDateByBlNo(invCreVo.getBlSrcNo());
			}
			
			// sailing dt is null in case, set Pol to VVD	
			if(sailingDt.equals("")) sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
			
			if (sailingDt.equals("")) {
				//sailing dt in null in case, set port to VVD	 			
				if (invCreVo.getIoBndCd().equals("I")) {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPodCd());
				} else {
					sailingDt = dbDao.searchSailingDateByVvd(invCreVo.getLclVvd().substring(0, 4), invCreVo.getLclVvd().substring(4, 8), invCreVo.getLclVvd().substring(8, 9), invCreVo.getPolCd());
				}
			}
			
			if (invCreVo.getLclVvd().substring(0, 4).equals("CFDR") || invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
				sailingDt = localTime;
			} 
			
			if (sailingDt.equals("")) {
				throw new EventException(new ErrorHandler("INV00132",new String[]{}).getMessage());
			}

			
			effDt = invCreVo.getEffDt().replaceAll("-", "");
			
			clzStsCd = dbDao.searchClosingStatus(invCreVo.getOfcCd(), effDt, "M");
			
			if (!clzStsCd.equals("O")) {
				throw new EventException(new ErrorHandler("INV00015",new String[]{}).getMessage());
			}

			subsCoCd = dbDao.searchInterCompany(invCreVo.getCustCntCd(), invCreVo.getCustSeq());

			actInvCustVo = dbDao.searchInvCustomer(invCreVo.getBlNo(), invCreVo.getOfcCd());
			
			trunkVvd = invCreVo.getTrunkVvd();
			
			if (trunkVvd.length() == 9) {

				port = invCreVo.getIoBndCd().equals("O")?invCreVo.getPolCd():invCreVo.getPodCd();
				
				// Flight schedule trunk vvd check
				if (dbDao.checkVskVslPortSkd(trunkVvd, port) 
					&& !trunkVvd.substring(0, 4).equals("CFDR") && !trunkVvd.substring(0, 4).equals("USAC")) {
					
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
					
				} else {
					
					trunkVvd = dbDao.searchTrunkVvd();
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
				}			
				
			} else {
				
				if (invCreVo.getLclVvd().substring(0, 4).equals("USAC")) {
					
					invMain.setTrnkVslCd(invCreVo.getLclVvd().substring(0, 4));
					invMain.setTrnkSkdVoyNo(invCreVo.getLclVvd().substring(4, 8));
					invMain.setTrnkSkdDirCd(invCreVo.getLclVvd().substring(8, 9));
					
				} else {
					
					trunkVvd = dbDao.searchTrunkVvd();
					if(trunkVvd.length() < 9) {
						throw new EventException(new ErrorHandler("INV00171",new String[]{}).getMessage());
					}
					invMain.setTrnkVslCd(trunkVvd.substring(0, 4));
					invMain.setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
					invMain.setTrnkSkdDirCd(trunkVvd.substring(8, 9));
				}
				
			}
			
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
			invMain.setInvSvcScpCd(invCreVo.getSvcScpCd());
			invMain.setSailDt(sailingDt);
			invMain.setSailArrDt(invCreVo.getSailArrDt());
			invMain.setSlanCd(laneCd);
			invMain.setIoBndCd(invCreVo.getIoBndCd());
			
			//----------------HAN 2010-04-06 START
			if (svrId.equals("KOR") || svrId.equals("ENT")) {
				invMain.setArTaxIndCd("KOR");
			}
			
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
			invMain.setCoStfCtnt(invCreVo.getCoRef());
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

			vvdCustomerVo.setBlSrcNo(invCreVo.getBlSrcNo());			
			
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
			
			if (otsSmryCd.equals("INV")) {
				
				arOfcAttributeVOs = dbDao.searchRepCustCdByArOfcCd(invCreVo.getOfcCd());
				
				for (int i = 0; i < arOfcAttributeVOs.size(); i++) {
					if (invCreVo.getCustCntCd().equals(arOfcAttributeVOs.get(i).getRepCustCntCd()) 
						&& Integer.parseInt(invCreVo.getCustSeq()) == Integer.parseInt(arOfcAttributeVOs.get(i).getRepCustSeq())) {
						throw new EventException(new ErrorHandler("INV00123",new String[]{}).getMessage());
					}
				
				}
								
			}	
			
			
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
				String chg_cd = "";
				String curr_cd = "";
				
				String invCoaRgnCd = "";
				String invCoaCtrCd = "";
				String rhq = "";
				String mriMaxYymm = "";
				String repChgCd = "";					
				String chgFullNm = "";		
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
		        
		        erpIfOfcCd = invCreVo.getOfcCd();
		        
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
						acctCd = dbDao.searchAccountCdFromRevAcct(bkgChgeListVOs.get(i).getChgCd());					}

					acctCd = dbDao.searchAccountCd(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd(), invCreVo.getRevSrcCd(), svrId, acctCd);
					
					invChgeVo = dbDao.searchInvRevTpSrcCd(bkgChgeListVOs.get(i).getChgCd(), invCreVo, svrId, acctCd);
					
					invChges.setRevCoaAcctCd(invChgeVo.getRevCoaAcctCd());
					
					
					chgAmt = new BigDecimal(bkgChgeListVOs.get(i).getChgAmt().replace(",",""));
					
					invChges.setArIfNo(arIfNo);
					invChges.setChgSeq(String.valueOf(i + 1));
					invChges.setChgCd(bkgChgeListVOs.get(i).getChgCd());
					invChges.setCurrCd(bkgChgeListVOs.get(i).getCurrCd().substring(0, 3));
					invChges.setPerTpCd(bkgChgeListVOs.get(i).getPerTpCd());
					invChges.setTrfRtAmt(bkgChgeListVOs.get(i).getTrfRtAmt());
					invChges.setRatAsCntrQty(bkgChgeListVOs.get(i).getRatAsCntrQty());
					invChges.setChgAmt(String.valueOf(chgAmt));
					invChges.setInvXchRt(bkgChgeListVOs.get(i).getInvXchRt());
					invChges.setOfcCd(invCreVo.getOfcCd());
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
					tjSrcNm = dbDao.searchTjSrcNm(invCreVo.getOfcCd(), bkgChgeListVOs.get(i).getChgCd(), invCreVo.getRevTpCd()+invCreVo.getRevSrcCd(), svrId);

					invChges.setTjSrcNm(tjSrcNm);
					
					//invChges.setUsdXchRt(bkgChgeListVOs.get(i).getUsdXchRt());  //2015.03.04
					//Add USD_XCH_RT in INV_AR_CHG table - 2015.03.04
					vvdCustomerVo.setLclCurr("USD");
					vvdCustomerVo.setCurr(invChges.getCurrCd());  
					exchangeRateVo = utilCmd.searchExchangeRate(vvdCustomerVo);	
					invChges.setUsdXchRt(exchangeRateVo.getExRate());
					vvdCustomerVo.setLclCurr(invCreVo.getLclCurr());  	//원복
					vvdCustomerVo.setCurr("USD");  						//원복

					addVoList.add(invChges);
					
					////////////////////////////////////////////////////////////////////////
					////////////////////////////////////////////////////////////////////////
					///// AR_IF_SER_NO creation
										
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
								
				// INV_AR_AMT table save	
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
			
			
			
			
			// ERP send start
			
			dbDao.modifyCFMDate(invMain.getArIfNo(), "good", invMain.getArOfcCd(), invMain.getBlSrcNo());

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
	 * Retrieve event process<br>
	 * Ex.Rate Update by Date or VVD data Main table Update<br>
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
	 * Retrieve data by BackEndJob LoadFile function<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResultCreateBKGInvoice(String key) throws EventException {
		try {
			BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutCreateBKGInvoice(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
	
	/**
	 * INV_AR_CHG table save<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception EventException
	 */
	public void addOtherInvCharge(List<com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO> invChges ) throws EventException {
		try {
			dbDao.addOtherInvCharge(invChges);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_MN table save <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception EventException
	 */
	public void addOtherInvMain(com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invMain ) throws EventException {
		try {
			dbDao.addOtherInvMain(invMain);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_AMT table save <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception EventException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invArMnVo, com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO invArAmtVo) throws EventException {
		try {
			dbDao.addOtherInvAmount(arIfNo, svrId, invArMnVo, invArAmtVo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * INV_AR_CNTR table save <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @exception EventException
     */
    public void addOtherInvContainer(List<com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO> invCntrs) throws EventException {
		try {
			dbDao.addOtherInvContainer(invCntrs);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * MDM_CURRENCY table float point select<br>
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
     * INV_AR_CHG table UPDATE. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceCharge(InvIssVO invIssVO) throws EventException {
		try {
			dbDao.modifyInvoiceCharge(invIssVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
     * INV_AR_MN table UPDATE. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceMain(InvIssVO invIssVO) throws EventException {
		try {
			dbDao.modifyInvoiceMainByBkgNo(invIssVO);
			dbDao.modifyDuedateInvoiceMainByIfNo(invIssVO);
			dbDao.modifyDuedateInvoiceMainByIfNoDueDt(invIssVO);
			dbDao.removeInvoiceContainer(invIssVO);
			dbDao.addInvoiceContainer(invIssVO);
			
			String otsSmryCd = invIssVO.getOtsSmryCd();
			if(otsSmryCd.equals("INV")){
				dbDao.modifyEffDate(invIssVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
     * INV_AR_MN, INV_AR_CHG Invoice update
     * 
     * @param String invNo
     * @param String ifNo
     * @param String userId
     * @throws EventException
     */
    public void modifyOtherRevIssueFlag (String invNo, String ifNo, String userId) throws EventException {
    	try {
			dbDao.modifyIssueFlag(invNo, "Y", userId);
			dbDao.modifyIssueFlagMain(invNo, "Y", userId);
			
			dbDao.modifyIssueXchRt(invNo, userId);
			dbDao.modifyIssueCurrCd(invNo, userId);
			
			//List<Fns0120001VO> list2 = dbDao.searchARInvoiceForERP(ifNo, "U");
			
			//eaiDao.interfaceARInvoiceToERPAR(list2);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
    /**
	 * IINV_AR_MN table AP_AR_OFFST_NO Update<br>
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
	 * FNS_INV_0094 Invoice Customer Change BackEndJob process
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
	 * FNS_INV_0094 Invoice Customer Change BackEndJob LoadFile<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutCreateCustomerChangeInvoiceList(String key) throws EventException {
		try {
			BookingARCreationEAIDAO eaiDao = new BookingARCreationEAIDAO();
			return eaiDao.getBackEndJobResutModifyExchangeRateList(key);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
    
	/**
	 * Sys clear Update<br>
	 * 
	 * @param String ifNo
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySysClear(String ifNo, String userId) throws EventException {
		try {
			dbDao.modifySysClear(ifNo, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Modify BL Exchange Rate<br>
	 * 
	 * @param ExchangeRateVO[] exRateVOs
	 * @param String userId
	 * @return List<BkgInvTaxIfVO>
	 * @exception EventException
	 * 
	 */
	public List<BkgInvTaxIfVO> modifyBLExchangeRate(ExchangeRateVO[] exRateVOs, String userId) throws EventException {
		try {
			
			ExchangeRateVO exRateVo = new ExchangeRateVO();
			ARInvoiceVO invoiceVO = new ARInvoiceVO();
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			
			BookingARCreationBackEndDBDAO beDbDao = new BookingARCreationBackEndDBDAO();
			
			DBRowSet rowSet = null;
			
			log.info("exRateVOs .length:"+exRateVOs.length);
			
			//HashSet bkgTaxHs = new HashSet();
			List<BkgInvTaxIfVO> bkgInvTaxIfList = null;
			//List<String> bkgNoList = new ArrayList<String>();
			//List<BkgInvTaxIfVO> bkgTaxAllList = new ArrayList<BkgInvTaxIfVO>();

			for ( int i=0; i<exRateVOs.length; i++ ) {						
				
				if ( exRateVOs[i].getIbflag().equals("I")||exRateVOs[i].getIbflag().equals("U")){
					exRateVo.setVslCd(exRateVOs[i].getVslCd());
					exRateVo.setSkdVoyNo(exRateVOs[i].getSkdVoyNo());
					exRateVo.setSkdDirCd(exRateVOs[i].getSkdDirCd());
					exRateVo.setIoBndCd(exRateVOs[i].getIoBndCd());
					exRateVo.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
					exRateVo.setPortCd(exRateVOs[i].getPortCd());
					exRateVo.setSvcScpCd(exRateVOs[i].getSvcScpCd());
					exRateVo.setChgCurrCd(exRateVOs[i].getChgCurrCd());
					
					exRateVo.setXchRtTpCd(exRateVOs[i].getXchRtTpCd());
					exRateVo.setCustCntCd(exRateVOs[i].getCustCntCd());
					exRateVo.setCustSeq(exRateVOs[i].getCustSeq());
					exRateVo.setFmDt(exRateVOs[i].getFmDt());
					exRateVo.setToDt(exRateVOs[i].getToDt());
					
					//2014.08.12 add inv/ivs_xch_rt
					exRateVo.setInvXchRt(exRateVOs[i].getInvXchRt());
					exRateVo.setIvsXchRt(exRateVOs[i].getIvsXchRt());
					exRateVo.setArOfcCd(exRateVOs[i].getArOfcCd());
					
					log.info("exRateVOs[i].getInvXchRt():"+exRateVOs[i].getInvXchRt());						
					
					if(!exRateVo.getLoclCurrCd().equals(exRateVo.getChgCurrCd())){
						
						String altnCd = beDbDao.searchALTNCurrCd(exRateVo.getArOfcCd());
						
						rowSet = beDbDao.searchARInvoiceExchangeRateList(exRateVo);				
						log.info("rowSet.getRowCount():"+rowSet.getRowCount());
						
						if(rowSet.getRowCount()>0 ){
							while(rowSet.next()){
				            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
								invoiceVO.setArIfSerNo(rowSet.getString("ar_if_ser_no"));
								invoiceVO.setChgSeq(rowSet.getString("chg_seq"));
								invoiceVO.setInvXchRtDt(rowSet.getString("xch_rt_dt"));
								invoiceVO.setInvXchRt(exRateVOs[i].getInvXchRt());
								invoiceVO.setUpdUsrId(userId);
								//2014.08.12 add locl_curr_cd
								invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
								invoiceVO.setChgCurrCd(exRateVOs[i].getChgCurrCd());
								
								count1 = beDbDao.modifyARInvoiceExRate(invoiceVO);
								count2 = beDbDao.modifyARInvoiceExRateMain(invoiceVO);
								
								//2014.08.12 add OTS local exrate update
								beDbDao.modifyOTSLocalExrate(invoiceVO);
								beDbDao.modifyOTSHisLocalExrate(invoiceVO);
								beDbDao.modifyOTSRateFlgByIfNo(invoiceVO);
								
								//invArIfNoVO = new InvArIfNoVO();
								//invArIfNoVO.setIfNo(rowSet.getString("ar_if_no") + rowSet.getString("ar_if_ser_no"));
								//ifNos.add(invArIfNoVO);
				            }
						}
						
						if(("LCL").equals(altnCd) && !("USD").equals(exRateVOs[i].getLoclCurrCd())){
							String usdXchRt = beDbDao.searchUSDExchangeRate(exRateVo);
							
							exRateVo.setChgCurrCd(("USD").equals(exRateVOs[i].getChgCurrCd()) ? exRateVOs[i].getLoclCurrCd() : exRateVOs[i].getChgCurrCd());
							rowSet = beDbDao.searchARInvoiceUSDExchangeRateList(exRateVo);				
							
							if(rowSet.getRowCount()>0 ){
								while(rowSet.next()){
					            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
									invoiceVO.setArIfSerNo(rowSet.getString("ar_if_ser_no"));
									invoiceVO.setChgSeq(rowSet.getString("chg_seq"));
									invoiceVO.setInvXchRtDt(rowSet.getString("xch_rt_dt"));
									invoiceVO.setInvXchRt(usdXchRt);
									invoiceVO.setUpdUsrId(userId);
									invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
									invoiceVO.setChgCurrCd(("USD").equals(exRateVOs[i].getChgCurrCd()) ? exRateVOs[i].getLoclCurrCd() : exRateVOs[i].getChgCurrCd());
									
									beDbDao.modifyARInvoiceUSDExRate(invoiceVO);
									
									beDbDao.modifyOTSUSDExrate(invoiceVO);
									beDbDao.modifyOTSHisUSDExrate(invoiceVO);
									beDbDao.modifyOTSRateFlgByIfNo(invoiceVO);
					            }
							}
							
							if(exRateVOs[i].getChgCurrCd().equals("USD")){
								rowSet = beDbDao.searchUSDExchangeRateList(exRateVo);	
								if(rowSet.getRowCount()>0 ){
									while(rowSet.next()){
						            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
										invoiceVO.setUsdXchRt(usdXchRt);		
										invoiceVO.setUpdUsrId(userId);
										invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
										
										beDbDao.modifyINVUSDExrateMain(invoiceVO);
										beDbDao.modifyOTSHdrINVUSDExrate(invoiceVO);
										beDbDao.modifyOTSHisINVUSDExrate(invoiceVO);
						            }
								}
							}
						} else {
							//2015.03.12 add USD exrate
							if(("USD").equals(exRateVOs[i].getLoclCurrCd())){
								rowSet = beDbDao.searchARInvoiceUSDExchangeRateList(exRateVo);				
								
								if(rowSet.getRowCount()>0 ){
									while(rowSet.next()){
						            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
										invoiceVO.setArIfSerNo(rowSet.getString("ar_if_ser_no"));
										invoiceVO.setChgSeq(rowSet.getString("chg_seq"));
										invoiceVO.setInvXchRtDt(rowSet.getString("xch_rt_dt"));
										invoiceVO.setInvXchRt(exRateVOs[i].getInvXchRt());
										invoiceVO.setUpdUsrId(userId);
										invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
										invoiceVO.setChgCurrCd(exRateVOs[i].getChgCurrCd());
										
										beDbDao.modifyARInvoiceUSDExRate(invoiceVO);
										
										beDbDao.modifyOTSUSDExrate(invoiceVO);
										beDbDao.modifyOTSHisUSDExrate(invoiceVO);
										beDbDao.modifyOTSRateFlgByIfNo(invoiceVO);
						            }
								}
								
								rowSet = beDbDao.searchUSDExchangeRateList(exRateVo);	
								if(rowSet.getRowCount()>0 ){
									while(rowSet.next()){
						            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
										invoiceVO.setUsdXchRt(exRateVOs[i].getInvXchRt());		
										invoiceVO.setUpdUsrId(userId);
										invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
										
										beDbDao.modifyINVUSDExrateMain(invoiceVO);
										beDbDao.modifyOTSHdrINVUSDExrate(invoiceVO);
										beDbDao.modifyOTSHisINVUSDExrate(invoiceVO);
						            }
								}
							}
						}
						
						if(exRateVOs[i].getChgCurrCd().equals("USD")){		
							exRateVo.setChgCurrCd(exRateVOs[i].getChgCurrCd());
							
							rowSet = beDbDao.searchUSDExchangeRateList(exRateVo);	
							if(rowSet.getRowCount()>0 ){
								while(rowSet.next()){
					            	invoiceVO.setArIfNo(rowSet.getString("ar_if_no"));
									invoiceVO.setUsdXchRt(exRateVOs[i].getInvXchRt());		
									invoiceVO.setUpdUsrId(userId);
									invoiceVO.setLoclCurrCd(exRateVOs[i].getLoclCurrCd());
									
									count3 = beDbDao.modifyUSDExrateMain(invoiceVO);
									
									beDbDao.modifyINVLCLExrateMain(invoiceVO);
									beDbDao.modifyOTSHdrINVExrate(invoiceVO);
									beDbDao.modifyOTSHisINVExrate(invoiceVO);
					            }
							}
						}
						
						//Search Tax Exchange Rate for Booking
						bkgInvTaxIfList = beDbDao.searchARInvExRtForBkgTaxRt(exRateVo, userId);				
						
					}
				}	//end of if 
				
			} // end of for
			
			log.info("result:"+count1);
			log.info("result2:"+count2);
			log.info("result3:"+count3);
			
			return bkgInvTaxIfList;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Exchange Rate Temp <br>
	 * 
	 * @param String tmpSeq
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchExchangeRateTempList(String tmpSeq) throws EventException {
		try {
			return dbDao.searchExchangeRateTempList(tmpSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Remove Exchange Rate Temp<br>
	 * 
	 * @param String tmpSeq
	 * @exception EventException
	 * 
	 */
	public void removeExchangeRateTempSeq(String tmpSeq) throws EventException {
		try {
			dbDao.removeExchangeRateTempSeq(tmpSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	

	
	/**
	 * FNS_INV_0027 createScoBatHisByExRate process
	 * 
	 * @author KIMOKRYE
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createScoBatHisByExRate(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt , String ofcCd, String userId) throws EventException {
		
		try {
			ScoBatHisVO batHisVO = new ScoBatHisVO();
			StatementCommonBC scoCommand = new StatementCommonBCImpl();
			
			//1.Make Batch Param
			String delim = "#";
			StringBuffer batParaCtnt = new StringBuffer();
			batParaCtnt.append(runOpt).append(delim)		// runOpt
			           .append(ofcCd).append(delim)         // ofcCd
			           .append(userId).append(delim);		// userId
			
			if(runOpt.equals("N")) {	//No Good
				batParaCtnt.append(exrateInputVO.getFmIfDt()).append(delim)		// fm_if_dt
				           .append(exrateInputVO.getToIfDt());					// to_if_dt	
			} else if(runOpt.equals("C")) {	//Customer
				batParaCtnt.append(exrateInputVO.getFmIfDt()).append(delim)				// fm_if_dt
		                   .append(exrateInputVO.getToIfDt()).append(delim)	  			// to_if_dt	
		                   .append(exrateInputVO.getInvCustCntCd()).append(delim)		// inv_cust_cnt_cd
		                   .append(exrateInputVO.getInvCustSeq());						// inv_cust_seq
			} else if(runOpt.equals("V")) {	//VVD
				batParaCtnt.append(exrateInputVOs.get(0).getIoBndCd()).append(delim);	// in_out_bnd
				for(int i=0; i < exrateInputVOs.size(); i++) {
					batParaCtnt.append(exrateInputVOs.get(i).getVvd()).append(delim);	// vvd
				}				
			} else if(runOpt.equals("B")) {	//BL
				for(int i=0; i < exrateInputVOs.size(); i++) {
					batParaCtnt.append(exrateInputVOs.get(i).getBlSrcNo()).append(delim);	//blsrcNo
				}				
			}
			
			log.debug("batParaCtnt::" + batParaCtnt.toString());
			
			
			//2.Insert SCO_BAT_HIS
			String batSeq = scoCommand.searchScoBatHisNextSeq();
			batHisVO.setBatSeq(batSeq);
			batHisVO.setPgmSubSysCd("INV");
			batHisVO.setBatPgmNo("FNS_INV_B005");
			batHisVO.setApplPgmNo("FNS_INV_B005");
			batHisVO.setBatRsltCd("W");
			batHisVO.setBatParaCtnt( batParaCtnt.toString());
			batHisVO.setCreUsrId(userId);
			batHisVO.setUpdUsrId(userId);
			scoCommand.addScoBatHis(batHisVO);
			
			log.debug("createScoBatHisByExRate's batSeq::" +batSeq);
			
			return batSeq;
			
		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 callModifyExchangeRateListBat process
	 * 
	 * @author KIMOKRYE
	 * @param String batSeq
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String callModifyExchangeRateListBat(String batSeq, String usrId) throws EventException {
		try {
			ScheduleUtil su = new ScheduleUtil();
			su.directExecuteJob("FNS_INV_B005", batSeq+"#"+usrId);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "FNS_INV_B005(UI FNS_INV_0027) Batch" }).getMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "FNS_INV_B005(UI FNS_INV_0027) Batch" }).getMessage(), e);
		}
		return batSeq;
	}	
	

	/**
	 * FNS_INV_0027 readyModifyExchangeRateListByBatSeq process
	 * 
	 * @author KIMOKRYE
	 * @param String batSeq
	 * @return String
	 * @exception EventException
	 */
	public String readyModifyExchangeRateListByBatSeq(String batSeq) throws EventException {
		try {
			StatementCommonBC scoCommand = new StatementCommonBCImpl();
			
			String runOpt = "";
			String userId = "";
			String ofcCd = "";
			List<ExrateInputVO> exrateInputVOs = new ArrayList<ExrateInputVO>();
			ExrateInputVO exrateInputVO = new ExrateInputVO();
			
			
			ScoBatHisVO batHisVO = scoCommand.searchScoBatHis(batSeq);
			
			
			if (batHisVO != null) {
				String orgParamCtnt = batHisVO.getBatParaCtnt();
				String[] arrPgmParms = orgParamCtnt.split("#");
								
				log.info("::: >>> param.length :" +  arrPgmParms.length);
				
				
				runOpt = arrPgmParms[0];
				ofcCd  = arrPgmParms[1];
				userId = arrPgmParms[2];
				
				if(runOpt.equals("N")) {	//No Good
					exrateInputVO.setOfcCd(ofcCd);
					exrateInputVO.setRunOpt(runOpt);
					exrateInputVO.setFmIfDt(arrPgmParms[3]);
					exrateInputVO.setToIfDt(arrPgmParms[4]);
				} else if(runOpt.equals("C")) {	//Customer
					exrateInputVO.setOfcCd(ofcCd);
					exrateInputVO.setRunOpt(runOpt);
					exrateInputVO.setFmIfDt(arrPgmParms[3]);
					exrateInputVO.setToIfDt(arrPgmParms[4]);
					exrateInputVO.setInvCustCntCd(arrPgmParms[5]);
					exrateInputVO.setInvCustSeq(arrPgmParms[6]);
				} else if(runOpt.equals("V")) {	//VVD
										
					for(int i=4; i<arrPgmParms.length; i++) {	//Bound 조건때문에 4부터 시작
						ExrateInputVO tempVO = new ExrateInputVO();
						tempVO.setOfcCd(ofcCd);
						tempVO.setRunOpt(runOpt);
						tempVO.setIoBndCd(arrPgmParms[3]);
						tempVO.setVvd(arrPgmParms[i]);	
						
						exrateInputVOs.add(tempVO);
					}
					
				} else if(runOpt.equals("B")) {	//BL
					for(int i=3; i<arrPgmParms.length; i++) {
						ExrateInputVO tempVO = new ExrateInputVO();
						tempVO.setOfcCd(ofcCd);
						tempVO.setRunOpt(runOpt);
						tempVO.setBlSrcNo(arrPgmParms[i]);	
						
						exrateInputVOs.add(tempVO);
					}				
				}
				
				
				modifyBLExchangeRateBy0027(exrateInputVOs, exrateInputVO, runOpt, userId, batSeq);			
				
			}
			
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		return batSeq;
	}	
	
	/**
	 * BookingARCreationBackEndJob 에서 uiType = 'U' 일때의 로직 <br>
	 * 
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String userId
	 * @param String batSeq
	 * @exception EventException
	 * 
	 */
	public void modifyBLExchangeRateBy0027(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt ,String userId, String batSeq) throws EventException {
		try {
			
			ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
			BookingARCreationBC bCommand = new BookingARCreationBCImpl();
			AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();
			//AccountReceivableOutstandingIFBC command3 = new AccountReceivableOutstandingIFBCImpl();
			INVCommonUtil utilCmd = new INVCommonUtil();
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			List<InvArIfNoVO> exceclIfNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
			String newIfNo="";	
			String vvd = "";
			String port = "";
			String saDate = "";
			String sailDt = "";
			
			List<ExrateTargetMainVO> exrateTargetMainVOs = null;

			int good_cnt = 0;
			int no_good_cnt = 0;
			int tot_cnt = 0;
			
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			
			BookingARCreationBackEndDBDAO beDbDao = new BookingARCreationBackEndDBDAO();

			// NoGood조건인 경우(runOption='N')
			if (runOpt.equals("N")) {  // No Good

				exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateInputVO);

				VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
				com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
				ExrateMainVO exrateMainVO = new ExrateMainVO();
				ExrateChgVO exrateChgVO = new ExrateChgVO();

				String usd_xch_rt = "";
				

				if (exrateTargetMainVOs != null) {

					tot_cnt = exrateTargetMainVOs.size();

					for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
						
						usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");
						vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
						port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
						
						sailDt = utilCmd.searchSailingDate(exrateTargetMainVOs.get(i).getBkgNo());
						saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
						
						RevVVDLaneVO revVVDLaneVO = dbDao.searchRevenueVVDLane(exrateTargetMainVOs.get(i).getBkgNo());
						
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
							}
						}
						
						if (usd_xch_rt.equals("")||sailDt.equals("")||saDate.equals("")||revVvd.length() != 10) {
							// 경리 환율이 없는 경우 No Good Count 증가
							no_good_cnt = no_good_cnt + 1;
						} else {
							// 경리환율이 있는 경우 Good Count 증가
							//good_cnt = good_cnt + 1;	//2016.07.18 comment 

							List<ExrateTargetChgVO> exrateTargetChgVOs = null;
							exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

							//BigDecimal invTtlLoclAmt = new BigDecimal("0");
							//int currPoint = 0;

							vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
							vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
							vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
							vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
							vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
							vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
							vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
							vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
							vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
							vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
							vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
							vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
							vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

							if (exrateTargetChgVOs != null) {
								for (int j = 0; j < exrateTargetChgVOs.size(); j++) {									
									
									vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
									
									exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

									exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
									exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
									exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
									exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
									exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
									exrateChgVO.setRevVvd(revVvd);
									exrateChgVO.setUpdUsrId(userId);
									exrateChgVO.setNoGoodFlg("Y");

									bCommand.modifyInvoiceExrateChg(exrateChgVO);
									
									//currPoint = dbDao.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
									
									//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
									//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
									//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

								}
							}
							
							//2015.03.16 add USD exrate //////////////////////////////////////// START
							vVDCustomerVO.setLclCurr("USD");
							
							if (exrateTargetChgVOs != null) {
								for (int j = 0; j < exrateTargetChgVOs.size(); j++) {									
									
									vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
									
									exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

									exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
									exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
									exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
									exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
									exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
									exrateChgVO.setRevVvd(revVvd);
									exrateChgVO.setUpdUsrId(userId);
									exrateChgVO.setNoGoodFlg("Y");

									beDbDao.modifyInvoiceUSDExrateChg(exrateChgVO);

								}
							}
							//2015.03.16 add USD exrate //////////////////////////////////////// END
							
							vVDCustomerVO.setLclCurr("USD");
							vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
							exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
							
							if (exrateTargetChgVOs != null) {
								for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

									exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
									exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
									exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
									exrateChgVO.setUpdUsrId(userId);
									exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
									
									beDbDao.modifyINVMainINVUSDExrate(exrateChgVO);				
						
								}
							}
							
							vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
							vVDCustomerVO.setCurr("USD");
							exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
							
							if (exrateTargetChgVOs != null) {
								for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

									exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
									exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
									exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
									exrateChgVO.setUpdUsrId(userId);
									exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
									
									beDbDao.modifyINVMainINVLCLExrate(exrateChgVO);					
						
								}
							}
							
							exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
							exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
							exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
							exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
							exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
							//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
							
							//vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
							//port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
							//saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
							
							//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
							/*
							DueDateInputVO dueDateInputVO = new DueDateInputVO();

							dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
							dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
							dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
							dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
							dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
							// Due Date 조회
							List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
							
							if (list.size() > 0) {
								// Due Date 세팅
								exrateMainVO.setDueDt(list.get(0).getDueDate());
								exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
								exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
							}
							*/
							exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
							exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);								
							exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
							exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
							exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
							exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
							exrateMainVO.setUpdUsrId(userId);
							exrateMainVO.setVvd(vvd);
							exrateMainVO.setPort(port);
							//2010-01-20 추가
							log.debug("revVvd = "+revVvd);
							log.debug("rlaneCd = "+rlaneCd);
							
							exrateMainVO.setRevVvd(revVvd);
							exrateMainVO.setRlaneCd(rlaneCd);

							newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
							
							if(!newIfNo.equals("")){
								invArIfNoVO = new InvArIfNoVO();
								invArIfNoVO.setIfNo(newIfNo);
								ifNos.add(invArIfNoVO);
								exceclIfNos.add(invArIfNoVO);
								good_cnt++;
							} else {
								no_good_cnt++;
							}
							
							
						}
					}
				}

				// Cusomer조건인 경우(runOption='C')
			} else if (runOpt.equals("C")) {

				exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateInputVO);

				VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
				com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
				ExrateMainVO exrateMainVO = new ExrateMainVO();
				ExrateChgVO exrateChgVO = new ExrateChgVO();

				//String usd_xch_rt = "";

				if (exrateTargetMainVOs != null) {

					tot_cnt = exrateTargetMainVOs.size();

					for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
						//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");
						
						log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
						log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
						log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
						log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
						
						if (
								(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
									(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
										// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
										exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
									)
								) 
								|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
							){
							
						
							//if (!usd_xch_rt.equals("")) {
								// 경리환율이 있는 경우 Good Count 증가
								//good_cnt = good_cnt + 1;

								List<ExrateTargetChgVO> exrateTargetChgVOs = null;
								exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

								//BigDecimal invTtlLoclAmt = new BigDecimal("0");
								//int currPoint = 0;
								
								vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
								port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
								saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

								vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
								vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
								vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
								vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
								vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
								vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
								vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
								vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
								vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
								vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
										
										
										vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
										exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
										exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
										exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
										exrateChgVO.setNoGoodFlg("N");

										bCommand.modifyInvoiceExrateChg(exrateChgVO);
										
										//Update OTS local exchange rate and flag - 2015.02.27
										beDbDao.modifyOTSDetailLoclExrate(exrateChgVO);
										beDbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
										beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);
										
										//currPoint = dbDao.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
										
										//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
										//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
										//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
							
									}
									
									vVDCustomerVO.setLclCurr("USD");
									
									//Update OTS USD exchange rate and flag - 2015.02.27
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																					
										vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
										exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
										exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
										exrateChgVO.setNoGoodFlg("N");
										
										beDbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
										
										beDbDao.modifyOTSDetailUSDExrate(exrateChgVO);
										beDbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
										beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
							
									}
								}
								
								vVDCustomerVO.setLclCurr("USD");
								vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
								
								//Update OTS invoice exchange rate - 2015.02.27
								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
										
										beDbDao.modifyINVMainINVUSDExrate(exrateChgVO);
										beDbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
										beDbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
							
									}
								}
								
								vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
								vVDCustomerVO.setCurr("USD");
								exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
								
								//Update OTS invoice exchange rate - 2015.02.27
								if (exrateTargetChgVOs != null) {
									for (int j = 0; j < exrateTargetChgVOs.size(); j++) {

										exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
										exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
										exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
										exrateChgVO.setUpdUsrId(userId);
										exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
										
										beDbDao.modifyINVMainINVLCLExrate(exrateChgVO);
										beDbDao.modifyOTSHeaderINVExrate(exrateChgVO);
										beDbDao.modifyOTSHistoryINVExrate(exrateChgVO);						
							
									}
								}
								
								//Process sakura I/F - 2015.02.27
								//if (exrateTargetChgVOs != null) {
								//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
								//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
								//	}
								//}
								
								exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
								exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
								exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
								exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
								exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
								//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
								
								
								vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
								port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
								saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
								
								//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
								/*
								DueDateInputVO dueDateInputVO = new DueDateInputVO();

								dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
								dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
								dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
								dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
								dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								// Due Date 조회
								List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
								
								if (list.size() > 0) {
									// Due Date 세팅
									exrateMainVO.setDueDt(list.get(0).getDueDate());
									exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
									exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
								exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);									
								exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
								exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
								exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
								exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
								exrateMainVO.setUpdUsrId(userId);
								exrateMainVO.setVvd(vvd);
								exrateMainVO.setPort(port);

								newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
								
								if(!newIfNo.equals("")){
									//good_cnt = good_cnt + 1;
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
									exceclIfNos.add(invArIfNoVO);
								}else{
									//no_good_cnt = no_good_cnt + 1;
									good_cnt = good_cnt + 1;
								}
							/*
							} else {
								// 경리 환율이 없는 경우 No Good Count 증가
								no_good_cnt = no_good_cnt + 1;
							}
							*/
							// Issue Data 인 경우
						} else {
							
							String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
							
							// BL No 로 Max IF No 조회
							String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
							
							// Max IF No 와 같으면 Cancel->Create
							if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
								//good_cnt = good_cnt + 1;									
								
								ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

								CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

								cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
								cancelInvoiceVO.setOtsSmryCd("");
								cancelInvoiceVO.setUserId(userId);
								cancelInvoiceVO.setInvNo(invNo);
								cancelInvoiceVO.setUiType("E");
								cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
								cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

								newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
								}									
								
								CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

								newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
								newInvoiceVO.setInvNo(invNo);
								newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
								newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
								newInvoiceVO.setUiType("E");
								newInvoiceVO.setUserId(userId);

								// New Data 생성
								newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
								
								//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
								
								if(!newIfNo.equals("")){
									good_cnt = good_cnt + 1;
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
									exceclIfNos.add(invArIfNoVO);
								}else{
									no_good_cnt = no_good_cnt + 1;
								}
								
								// Max IF No 와 다르면 Skip
							} else {
								good_cnt = good_cnt + 1;
							}
							
						}
					}
				}
				// VVD 조건인 경우
			} else if (runOpt.equals("V")) {
				if (exrateInputVOs != null) {
					// VVD 갯수
					for (int k = 0; k < exrateInputVOs.size(); k++) {
						ExrateInputVO exrateLocalInputVO = new ExrateInputVO();

						exrateLocalInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
						exrateLocalInputVO.setVvd(exrateInputVOs.get(k).getVvd());
						exrateLocalInputVO.setIoBndCd(exrateInputVOs.get(k).getIoBndCd());
						exrateLocalInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
						//exrateInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

						exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateLocalInputVO);

						VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
						com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
						ExrateMainVO exrateMainVO = new ExrateMainVO();
						ExrateChgVO exrateChgVO = new ExrateChgVO();

						//String usd_xch_rt = "";

						if (exrateTargetMainVOs != null) {

							tot_cnt = tot_cnt + exrateTargetMainVOs.size();

							for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
								//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

								log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
								log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
								log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
								log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
								
								if (
										(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
											(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
												// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N"))||
												exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
											)
										) 
										|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
									){
									
									//if (!usd_xch_rt.equals("")) {
										// 경리환율이 있는 경우 Good Count 증가
										//good_cnt = good_cnt + 1;

										List<ExrateTargetChgVO> exrateTargetChgVOs = null;
										exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());

										//BigDecimal invTtlLoclAmt = new BigDecimal("0");
										//int currPoint = 0;
										
										vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
										port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
										saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

										vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
										vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
										vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
										vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
										vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
										vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
										vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
										vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
										vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
										vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
										vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
										vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
												
												vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());

												exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
												exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
												exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
												exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
												exrateChgVO.setNoGoodFlg("N");

												bCommand.modifyInvoiceExrateChg(exrateChgVO);
												
												//Update OTS local exchange rate and flag - 2015.02.27
												beDbDao.modifyOTSDetailLoclExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);

												//currPoint = dbDao.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
												
												//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
												//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
												//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));
											}
											
											vVDCustomerVO.setLclCurr("USD");
											
											//Update OTS USD exchange rate and flag - 2015.02.27
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																							
												vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
												exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
												exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
												exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
												exrateChgVO.setNoGoodFlg("N");
												
												beDbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
												
												beDbDao.modifyOTSDetailUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
									
											}
										}
										
										vVDCustomerVO.setLclCurr("USD");
										vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
										
										//Update OTS invoice exchange rate - 2015.02.27
										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
		
												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
												
												beDbDao.modifyINVMainINVUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
									
											}
										}
										
										vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										vVDCustomerVO.setCurr("USD");
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
										
										//Update OTS invoice exchange rate - 2015.02.27
										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
		
												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
												
												beDbDao.modifyINVMainINVLCLExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderINVExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryINVExrate(exrateChgVO);	
												
											}
										}
										
										//Process sakura I/F - 2015.02.27
										//if (exrateTargetChgVOs != null) {
										//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
										//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
										//	}
										//}
										
										exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
										exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
										exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
										exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
										exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
										//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
										
										vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
										port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
										saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());
										
										//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
										/*
										DueDateInputVO dueDateInputVO = new DueDateInputVO();

										dueDateInputVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
										dueDateInputVO.setCustCntCd(exrateTargetMainVOs.get(i).getActCustCntCd());
										dueDateInputVO.setCustSeq(exrateTargetMainVOs.get(i).getActCustSeq());
										dueDateInputVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
										dueDateInputVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
										// Due Date 조회
										List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
										
										if (list.size() > 0) {
											// Due Date 세팅
											exrateMainVO.setDueDt(list.get(0).getDueDate());
											exrateMainVO.setCustCrFlg(list.get(0).getCrFlg());
											exrateMainVO.setCrTermDys(list.get(0).getCrTermDys());
										}
										*/
										exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
										exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);											
										exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
										exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
										exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
										exrateMainVO.setUpdUsrId(userId);
										exrateMainVO.setVvd(vvd);
										exrateMainVO.setPort(port);

										newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
										
										if(!newIfNo.equals("")){
											//good_cnt = good_cnt + 1;
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
											exceclIfNos.add(invArIfNoVO);
										}else{
											//no_good_cnt = no_good_cnt + 1;
											good_cnt = good_cnt + 1;
										}
									/*
									} else {
										// 경리 환율이 없는 경우 No Good Count 증가
										no_good_cnt = no_good_cnt + 1;
									}
									*/
									// Issue Data 인 경우
								} else {
									
									String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
									
									// BL No 로 Max IF No 조회
									String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
									
									// Max IF No 와 같으면 Cancel->Create
									if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
										//good_cnt = good_cnt + 1;									
										
										ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

										CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

										cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										cancelInvoiceVO.setOtsSmryCd("");
										cancelInvoiceVO.setUserId(userId);
										cancelInvoiceVO.setInvNo(invNo);
										cancelInvoiceVO.setUiType("E");
										cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
										cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

										newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
										
										if(!newIfNo.equals("")){
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
										}									
										
										CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

										newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										newInvoiceVO.setInvNo(invNo);
										newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
										newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
										newInvoiceVO.setUiType("E");
										newInvoiceVO.setUserId(userId);

										// New Data 생성
										newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
										
										//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
										
										if(!newIfNo.equals("")){
											good_cnt = good_cnt + 1;
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
											exceclIfNos.add(invArIfNoVO);
										}else{
											no_good_cnt = no_good_cnt + 1;
										}
										
										// Max IF No 와 다르면 Skip
									} else {
										good_cnt = good_cnt + 1;
									}
								}
							}
						}
					}
				}
				// B/L 조건인 경우
			} else if (runOpt.equals("B")) {
				if (exrateInputVOs != null) {
					// B/L  갯수
					for (int k = 0; k < exrateInputVOs.size(); k++) {
						ExrateInputVO exrateLocalInputVO = new ExrateInputVO();

						exrateLocalInputVO.setOfcCd(exrateInputVOs.get(k).getOfcCd());
						exrateLocalInputVO.setRunOpt(exrateInputVOs.get(k).getRunOpt());
						exrateLocalInputVO.setBlSrcNo(exrateInputVOs.get(k).getBlSrcNo());

						exrateTargetMainVOs = command.searchInvoiceForExrateList(exrateLocalInputVO);

						VVDCustomerVO vVDCustomerVO = new VVDCustomerVO();
						com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO exchangeRateVO = null;
						ExrateMainVO exrateMainVO = new ExrateMainVO();
						ExrateChgVO exrateChgVO = new ExrateChgVO();

						//String usd_xch_rt = "";

						if (exrateTargetMainVOs != null) {

							tot_cnt = tot_cnt + exrateTargetMainVOs.size();

							for (int i = 0; i < exrateTargetMainVOs.size(); i++) {
								//usd_xch_rt = utilCmd.searchAccountRate("USD", exrateTargetMainVOs.get(i).getLoclCurrCd(), !exrateTargetMainVOs.get(i).getSailDt().equals("")?exrateTargetMainVOs.get(i).getSailDt().substring(0, 6):"");

								log.debug("issFlg = "+exrateTargetMainVOs.get(i).getIssFlg());
								log.debug("clrFlg = "+exrateTargetMainVOs.get(i).getInvClrFlg());
								log.debug("otsSmryCd = "+exrateTargetMainVOs.get(i).getOtsSmryCd());
								log.debug("dmdtArInvIssFlg = "+exrateTargetMainVOs.get(i).getDmdtArInvIssFlg());
								
								// Not Issue Data이거나  OtsSmryCD가 BL이 아니고 DmdtArInvIssFlg가 N인 경우
								if (
										(!exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL") && 
											(exrateTargetMainVOs.get(i).getIssFlg().equals("N") || 
												// ((exrateTargetMainVOs.get(i).getRevSrcCd().equals("DM")||exrateTargetMainVOs.get(i).getRevSrcCd().equals("DT")) && exrateTargetMainVOs.get(i).getDmdtArInvIssFlg().equals("N")) ||
												exrateTargetMainVOs.get(i).getInvClrFlg().equals("Y")
											)
										) 
										|| exrateTargetMainVOs.get(i).getOtsSmryCd().equals("BL")
									){
									
									//if (!usd_xch_rt.equals("")) {
										// 경리환율이 있는 경우 Good Count 증가
										//good_cnt = good_cnt + 1;

										List<ExrateTargetChgVO> exrateTargetChgVOs = null;
										exrateTargetChgVOs = command.searchInvoiceChgForExrateList(exrateTargetMainVOs.get(i).getArIfNo());
										
										//BigDecimal invTtlLoclAmt = new BigDecimal("0");
										//int currPoint = 0;
										
										vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
										port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
										saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());

										vVDCustomerVO.setInvCntryCd(exrateTargetMainVOs.get(i).getInvCustCntCd());
										vVDCustomerVO.setInvCustCd(exrateTargetMainVOs.get(i).getInvCustSeq());
										vVDCustomerVO.setOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
										vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										vVDCustomerVO.setBnd(exrateTargetMainVOs.get(i).getIoBndCd());
										vVDCustomerVO.setVsl(exrateTargetMainVOs.get(i).getVslCd());
										vVDCustomerVO.setVoy(exrateTargetMainVOs.get(i).getSkdVoyNo());
										vVDCustomerVO.setDep(exrateTargetMainVOs.get(i).getSkdDirCd());
										vVDCustomerVO.setPol(exrateTargetMainVOs.get(i).getPolCd());
										vVDCustomerVO.setPod(exrateTargetMainVOs.get(i).getPodCd());
										vVDCustomerVO.setSaDt(!saDate.equals("")?saDate.replace("-", ""):saDate);
										vVDCustomerVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
										vVDCustomerVO.setSvcScp(exrateTargetMainVOs.get(i).getSvcScpCd());

										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
												
												vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());

												exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
												exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
												exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());
												exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
												exrateChgVO.setNoGoodFlg("N");

												bCommand.modifyInvoiceExrateChg(exrateChgVO);
												
												//Update OTS local exchange rate and flag - 2015.02.27
												beDbDao.modifyOTSDetailLoclExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryLoclExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);
												//currPoint = dbDao.searchCurrencyPoint(exrateTargetChgVOs.get(j).getCurrCd());
												
												//BigDecimal chgAmt = new BigDecimal(exrateTargetChgVOs.get(j).getChgAmt());
												//BigDecimal exRate = new BigDecimal(exchangeRateVO.getExRate());	
												//invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(currPoint,BigDecimal.ROUND_HALF_UP));

											}
											
											vVDCustomerVO.setLclCurr("USD");
											
											//Update OTS USD exchange rate and flag - 2015.02.27
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
																							
												vVDCustomerVO.setCurr(exrateTargetChgVOs.get(j).getCurrCd());
												exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);

												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());
												exrateChgVO.setChgSeq(exrateTargetChgVOs.get(j).getChgSeq());
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());
												exrateChgVO.setInvXchRtDt(exchangeRateVO.getExRateDate());
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setCurrCd(exrateTargetChgVOs.get(j).getCurrCd());
												exrateChgVO.setNoGoodFlg("N");
												
												beDbDao.modifyInvoiceUSDExrateChg(exrateChgVO);
												
												beDbDao.modifyOTSDetailUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderRateFlg(exrateChgVO);								
									
											}
										}
										
										vVDCustomerVO.setLclCurr("USD");
										vVDCustomerVO.setCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
										
										//Update OTS invoice exchange rate - 2015.02.27
										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
		
												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
												
												beDbDao.modifyINVMainINVUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderINVUSDExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryINVUSDExrate(exrateChgVO);						
									
											}
										}
										
										vVDCustomerVO.setLclCurr(exrateTargetMainVOs.get(i).getLoclCurrCd());
										vVDCustomerVO.setCurr("USD");
										exchangeRateVO = utilCmd.searchExchangeRate(vVDCustomerVO);
										
										//Update OTS invoice exchange rate - 2015.02.27
										if (exrateTargetChgVOs != null) {
											for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
		
												exrateChgVO.setArIfNo(exrateTargetChgVOs.get(j).getArIfNo());
												exrateChgVO.setArIfSerNo(exrateTargetChgVOs.get(j).getArIfSerNo());											
												exrateChgVO.setInvXchRt(exchangeRateVO.getExRate());										
												exrateChgVO.setUpdUsrId(userId);
												exrateChgVO.setLoclCurrCd(exrateTargetMainVOs.get(i).getLoclCurrCd());											
												
												beDbDao.modifyINVMainINVLCLExrate(exrateChgVO);
												beDbDao.modifyOTSHeaderINVExrate(exrateChgVO);
												beDbDao.modifyOTSHistoryINVExrate(exrateChgVO);						
									
											}
										}
										
										//Process sakura I/F - 2015.02.27
										//if (exrateTargetChgVOs != null) {
										//	for (int j = 0; j < exrateTargetChgVOs.size(); j++) {
										//		command3.createSakuraOTSIFdata(exrateTargetChgVOs.get(j).getArIfNo()+exrateTargetChgVOs.get(j).getArIfSerNo(), "E");
										//	}
										//}
										
										exrateMainVO.setXchRtDt(exchangeRateVO.getExRateDate());
										exrateMainVO.setXchRtUsdTpCd(exchangeRateVO.getUsdExrateType());
										exrateMainVO.setXchRtN3rdTpCd(exchangeRateVO.getThirdExrateType());
										exrateMainVO.setObrdDt(exchangeRateVO.getCngIndivCd().equals("B") ? exchangeRateVO.getExRateDate() : "");
										exrateMainVO.setUsdXchRt(exchangeRateVO.getExRate());
										//exrateMainVO.setInvTtlLoclAmt(invTtlLoclAmt.toString());
										
										vvd = exrateTargetMainVOs.get(i).getVslCd()+ exrateTargetMainVOs.get(i).getSkdVoyNo()+exrateTargetMainVOs.get(i).getSkdDirCd();
										port = 	exrateTargetMainVOs.get(i).getIoBndCd().equals("O")?exrateTargetMainVOs.get(i).getPolCd():exrateTargetMainVOs.get(i).getPodCd();
										saDate = utilCmd.searchSADate(vvd , port, exrateTargetMainVOs.get(i).getIoBndCd());											
										
										exrateMainVO.setArOfcCd(exrateTargetMainVOs.get(i).getArOfcCd());
										exrateMainVO.setSailArrDt(!saDate.equals("")?saDate.replace("-", ""):saDate);											
										exrateMainVO.setArIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										exrateMainVO.setRevTpCd(exrateTargetMainVOs.get(i).getRevTpCd());
										exrateMainVO.setRevSrcCd(exrateTargetMainVOs.get(i).getRevSrcCd());
										exrateMainVO.setBkgNo(exrateTargetMainVOs.get(i).getBkgNo());
										exrateMainVO.setUpdUsrId(userId);
										exrateMainVO.setVvd(vvd);
										exrateMainVO.setPort(port);

										newIfNo = bCommand.modifyInvoiceExrateMain(exrateMainVO);
										
										if(!newIfNo.equals("")){
											//good_cnt = good_cnt + 1;
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
											exceclIfNos.add(invArIfNoVO);
										}else{
											//no_good_cnt = no_good_cnt + 1;
											good_cnt = good_cnt + 1;
										}
									/*
									} else {
										// 경리 환율이 없는 경우 No Good Count 증가
										no_good_cnt = no_good_cnt + 1;
									}
									*/
									// Issue Data 인 경우
								} else {
									
									String invNo = command.searchInvoiceNoByIfNo(exrateTargetMainVOs.get(i).getArIfNo());
									
									// BL No 로 Max IF No 조회
									String maxIfNo = command.searchMaxInterfaceForExrate(exrateTargetMainVOs.get(i).getArOfcCd(), exrateTargetMainVOs.get(i).getBlSrcNo(), invNo);
									
									// Max IF No 와 같으면 Cancel->Create
									if (exrateTargetMainVOs.get(i).getArIfNo().equals(maxIfNo)) {									
										//good_cnt = good_cnt + 1;									
										
										ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(exrateTargetMainVOs.get(i).getBkgNo(), "C");

										CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

										cancelInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										cancelInvoiceVO.setOtsSmryCd("");
										cancelInvoiceVO.setUserId(userId);
										cancelInvoiceVO.setInvNo(invNo);
										cancelInvoiceVO.setUiType("E");
										cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
										cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());

										newIfNo = bCommand.createCancelIssueARInvoice(cancelInvoiceVO);
										
										if(!newIfNo.equals("")){
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
										}									
										
										CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

										newInvoiceVO.setIfNo(exrateTargetMainVOs.get(i).getArIfNo());
										newInvoiceVO.setInvNo(invNo);
										newInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
										newInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
										newInvoiceVO.setUiType("E");
										newInvoiceVO.setUserId(userId);

										// New Data 생성
										newIfNo = bCommand.createNewIssueARInvoice(newInvoiceVO);
										
										//bCommand.modifySplitCodebyInvNo(invNo, exrateTargetMainVOs.get(i).getArOfcCd(),"M", userId);									
										
										if(!newIfNo.equals("")){
											good_cnt = good_cnt + 1;
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
											exceclIfNos.add(invArIfNoVO);
										}else{
											no_good_cnt = no_good_cnt + 1;
										}
										
										// Max IF No 와 다르면 Skip
									} else {
										good_cnt = good_cnt + 1;
									}
								}
							}
						}
					}
				}
			}
			
			
			count1 = tot_cnt;
			count2 = good_cnt;
			count3 = no_good_cnt;
			
			log.debug("tot_cnt:"+tot_cnt);
			log.debug("good_cnt:"+good_cnt);
			log.debug("no_good_cnt:"+no_good_cnt);
			log.debug("exceclIfNos.size():"+exceclIfNos.size());
			
			InvoiceIssueBC issCommand = new InvoiceIssueBCImpl();
			INVCommonUtil invUtil = new INVCommonUtil();
			List<InvoiceARIssueTempVO> issTemps = new ArrayList<InvoiceARIssueTempVO>();
			
			if(exceclIfNos.size()>0){
				//exRateCountVOs = dbDao.searchInvoiceExrateMain(exceclIfNos);
				for(int i=0; i< exceclIfNos.size(); i++) {
					InvoiceARIssueTempVO tmpVO = new InvoiceARIssueTempVO();
					tmpVO.setInvIssTmpSeq("999" + invUtil.lPad(batSeq, 12, "0"));
					tmpVO.setInvLineNo(i+1+"");		
					tmpVO.setAttrCtnt1(exceclIfNos.get(i).getIfNo());
					
					tmpVO.setAttrCtnt2(String.valueOf(count1));
					tmpVO.setAttrCtnt3(String.valueOf(count2));
					tmpVO.setAttrCtnt4(String.valueOf(count3));
					
					tmpVO.setUsrId(userId);
					issTemps.add(tmpVO);
				}
			} else {
				InvoiceARIssueTempVO tmpVO = new InvoiceARIssueTempVO();
				tmpVO.setInvIssTmpSeq("999" + invUtil.lPad(batSeq, 12, "0"));
				tmpVO.setInvLineNo("1");		
				tmpVO.setAttrCtnt1("");
				
				tmpVO.setAttrCtnt2(String.valueOf(count1));
				tmpVO.setAttrCtnt3(String.valueOf(count2));
				tmpVO.setAttrCtnt4(String.valueOf(count3));
				
				tmpVO.setUsrId(userId);
				issTemps.add(tmpVO);
			}
			
			issCommand.addInvoiceIssueTemp(issTemps);
			
			
			
			// 2015.02.26 AR OTS creation
			if(ifNos!= null && ifNos.size()>0){
				command2.createOutstandingInfo(ifNos);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}		
	
	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchExchangeRateBatStsCd(String pgmNo) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		boolean isRunningStatus = false;
		
		try {
			isRunningStatus = su.isRunning(pgmNo);			
			log.error("Ex.Rate Batch Running:::"+isRunningStatus+"\n");
			if(isRunningStatus){
				return "R"; // Running
			}else{
				return "S"; // Start 
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * batch running 일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelExchangeRateBat(String batSeq, SignOnUserAccount account) throws EventException {
		try {
			
			dbDao.manageCancelExchangeRateBat(batSeq); // 'E'로 update
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
}