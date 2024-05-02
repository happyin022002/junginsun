/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationBCImpl.java
*@FileTitle : FACCommCalculationBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2012.12.11 김봉균 [CHM-201221957] FAC I/F History 보관 요청
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration.FACCommCalculationDBDAO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchACMContractInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchAgnBookingInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchBKGQTYInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchFACAGMTRateInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchRevLanebndInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchSADateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-FACCalculation Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author PARK Sung-Jin
 * @see Esm_Acm_0028EventResponse 참조
 * @since J2EE 1.6
 */
public class FACCommCalculationBCImpl extends BasicCommandSupport implements FACCommCalculationBC {

	// Database Access Object
	private transient FACCommCalculationDBDAO dbDao = null;

	/**
	 * FACCommCalculationBCImpl 객체 생성<br>
	 * FACCommCalculationDBDAO를 생성한다.<br>
	 */
	public FACCommCalculationBCImpl() { 
		dbDao = new FACCommCalculationDBDAO();
	}
	 
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkgNo
	 * @param String userId
	 * @exception EventExceptions
	 */
	public void reCalculateFACComm(String bkgNo, String userId) throws EventException {
		
		List<SearchSADateVO> SADatelist = null;
		SearchSADateVO SADateTSA = new SearchSADateVO();
		String ppdOfcCdChgYn = "N";
		String chgPpdOfcCd = "";
		SearchAgnBookingInfoVO arApOfcCd = new SearchAgnBookingInfoVO();
		SearchFACAGMTRateInfoVO facAGMTRateInfo = new SearchFACAGMTRateInfoVO();
		String fac = "";
		String facDtl = "";
		String facChgCtntDiv = "";

		try {
			
			// add
			dbDao.addFACInterfaceHistory(bkgNo, userId);
						
			//log.debug("\n bkg_no===>"+bkg_no);
			// Booking 정보를 조회한다.
			SearchAgnBookingInfoVO BkgInfolist =  dbDao.searchBookingInfo(bkgNo);
			
			BkgInfolist.setReCalcYn("Y");
			BkgInfolist.setUserId(userId);
			
			if(BkgInfolist == null || BkgInfolist.getBkgNo().length() < 1){
				// Booking 정보가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO 저장하고 다음 Booking으로 넘어간다.
				BkgInfolist.setCommProcRsltRsn( new ErrorHandler("ACM00013").getUserMessage());//Booking Master Information does not exist!
				dbDao.modifyFACMasterErrorMSG( bkgNo, BkgInfolist.getCommProcRsltRsn());
				return;
			}

			if ("X".equals(BkgInfolist.getBkgStsCd()))
			{	// Canceled BKG인 경우
				BkgInfolist.setCommProcRsltRsn("Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!");
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
				//createZeroSumComm( con, bkgMap );
			}
			else if ("B".equals(BkgInfolist.getCoveredCheck()))
			{	// Co-Biz BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00008", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is CO-BIZ BL!
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			else if ("C".equals(BkgInfolist.getCoveredCheck()))
			{	// Covered BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00014", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is Covered BL!
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			//log.debug("\n BkgInfolist.get(0).toString()==>"+BkgInfolist.get(0).toString());
			
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				
				if ("B".equals(BkgInfolist.getCoveredCheck())){
					this.processFacCancel(BkgInfolist);
					return;
				}else if ("C".equals(BkgInfolist.getCoveredCheck())){
					this.processFacCancel(BkgInfolist);
					return;
				}
//				if ("X".equals(BkgInfolist.getBkgStsCd())){
//					this.processFacCancel(BkgInfolist);
//					return;
//				}
				 
			}
			// S/A Date를 구한다.
			SADatelist =  dbDao.searchSADate(bkgNo);
			
			for(int i = 0 ; i < SADatelist.size(); i++){
				//SA_DT_DIV vsl_seq
				if(SADatelist.get(i).getSaDtDiv().equals("OTS")){
					SADatelist.set(i, dbDao.searchSADateOfSU(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq((Integer.parseInt(SADatelist.get(i).getVslSeq())-1)+"");
				}else if(SADatelist.get(i).getSaDtDiv().equals("ITS")){
					SADatelist.set(i, dbDao.searchSADateOfSU(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq((Integer.parseInt(SADatelist.get(i).getVslSeq())+4)+"");
				}else if(SADatelist.get(i).getSaDtDiv().equals("TSA")){
					SADatelist.set(i, dbDao.searchSADateOfTrunkDt(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq("4");
					SADateTSA = SADatelist.get(i);
				}
			}
			
			log.debug("\n SADateTSA.getVpsEtaDt()====>"+ SADateTSA.getVpsEtaDt());
			if("4".equals(SADateTSA.getSaDtSeq())){
				// Trunk의 출항일자가 존재하지 않을 경우 에러처리한다. 
				// 2009-03-23 수정 :  NULL에 대한 처리시 1보다 적으면 오류처리함
				if(SADateTSA.getVpsEtdDt() == null || SADateTSA.getVpsEtdDt().length() < 1) {
					// Trunk의 출항일자가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00015").getUserMessage()); //BKG Trunk VVD ETD Date INFO does not exist!
					dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
					return;
				}
				// Trunk의 도착일자가 존재하지 않을 겨우 에러처리한다.
				if(SADateTSA.getVpsEtaDt() == null || SADateTSA.getVpsEtaDt().length() < 1) {
					// Trunk의 도착일자가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00016").getUserMessage()); //BKG Trunk VVD ETA Date INFO does not exist!
					dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
					return;
				}
			}else{
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00017", new String[]{bkgNo}).getUserMessage());//BKG Trunk VVD Info does not exist! Booking NO[$s]
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return ;
			}
			BkgInfolist.setTrunkEtdDt(SADateTSA.getVpsEtdDt());
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}
			
			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			SearchACMContractInfoVO cntInfo = dbDao.searchACMContractInfo(bkgNo);
			
			//log.debug("cntInfo.toString().length()==>"+ cntInfo.toString().length());
			
			if(cntInfo == null || ("").equals(cntInfo.getCltOfcCd()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00018").getUserMessage());//SC NO, RFA NO, PPD/CCT Office, Cargo Recieve Date does not exist!
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return;
			}
			
			BkgInfolist.setFacOfcCd(cntInfo.getPpdOfcCd());
			
			//log.debug("cntInfo==>"+ cntInfo.toString());
			
			BkgInfolist.setRfaNo(dbDao.checkNull(BkgInfolist.getRfaNo()));
			BkgInfolist.setScNo(dbDao.checkNull(BkgInfolist.getScNo()));
			
			if ((BkgInfolist.getRfaNo().length() > 0 && BkgInfolist.getScNo().length() > 0) || (BkgInfolist.getRfaNo().length() > 0 && BkgInfolist.getScNo().length() == 0))
			{
				BkgInfolist.setSlsOfcCd(BkgInfolist.getCtrtOfcCd());
				BkgInfolist.setScCtrtOfcCd("");
			}
			else if (BkgInfolist.getRfaNo().length() == 0 && BkgInfolist.getScNo().length() > 0)
			{
				BkgInfolist.setSlsOfcCd("");
				BkgInfolist.setScCtrtOfcCd(BkgInfolist.getCtrtOfcCd());
			}
			else
			{
				BkgInfolist.setSlsOfcCd("");
				BkgInfolist.setScCtrtOfcCd("");
			}
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}
			
			// Booking QTY물량을 구한다.	
			SearchBKGQTYInfoVO bkgQtyInfo = dbDao.searchBKGQTYInfo(bkgNo);
			
			if(bkgQtyInfo == null || ("").equals(bkgQtyInfo.getBkgBxQty()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00019").getUserMessage());//BKG QTY Information does not exist!
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return;
			}
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}

			// Revenue Lane과 Revenue VVD를 구한다.	
			SearchRevLanebndInfoVO RevLanebndInfo = dbDao.searchRevLanebndInfo(bkgNo);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}
			
			// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.modifyACMBKGInfo(BkgInfolist, RevLanebndInfo, SADateTSA);
			
			//------------------------------------------------------------------------------------------------------
			// FAC에 기본적으로 셋팅되어야 할 데이타들을 셋팅한다.
			if(BkgInfolist.getFfCustSeq() == null || BkgInfolist.getFfCustSeq().length() == 0 || "*".equals(BkgInfolist.getFfCustSeq())) {
				BkgInfolist.setFfCustSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			if(BkgInfolist.getBkgFfSeq() == null || BkgInfolist.getBkgFfSeq().length() == 0 || "*".equals(BkgInfolist.getBkgFfSeq())) {
				BkgInfolist.setBkgFfSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			if(BkgInfolist.getShprCustSeq() == null || BkgInfolist.getShprCustSeq().length() == 0 || "*".equals(BkgInfolist.getShprCustSeq())) {
				BkgInfolist.setShprCustSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			BkgInfolist.setFacRtBreakYn("N");
			BkgInfolist.setSlsOfcCd(BkgInfolist.getFacOfcCd());
			BkgInfolist.setFacStsCd("CE");
			BkgInfolist.setFacRmk("");

			// FAC Sequence를 구한다.
			String facSeq = dbDao.searchFACSeq(bkgNo);
			
			if("1".equals(facSeq)){
				BkgInfolist.setCancelFac("C");
			}

			BkgInfolist.setFacSeq("1");
			
			// Interface가 안 된 데이타가 존재하는지 조회한다.
			fac = dbDao.searchFACDataCheck(bkgNo, facSeq);
			facDtl = dbDao.searchFACDtlDataCheck(bkgNo, facSeq);
			//log.debug("/n facSeq + fac==>" + facSeq + " / " + fac);
						
			if(fac != null && fac.length() > 0){
				
				dbDao.removeFACChgDetail(bkgNo, facSeq);
				
				dbDao.removeFACDetail(bkgNo, facSeq);
				
				dbDao.removeFACMaster(bkgNo, facSeq);
			}else if(facDtl != null && facDtl.length() > 0){
				
				dbDao.removeFACChgDetail(bkgNo, facSeq);
				
				dbDao.removeFACCancelDetail(bkgNo, facSeq);
			}

			// FAC에 Cancel 여부를 Default='N'로 셋팅한다.
			BkgInfolist.setCancelYn("N");
			
			if("X".equals(BkgInfolist.getBkgStsCd())) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구한다.
				
				// Cancel amt를 구해온다.
				//bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
				BkgInfolist = this.searchFACCancelInfo(BkgInfolist);
				
				this.addFACMasterHistory(bkgNo);
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return;
				}		

			} else {
			
				// PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
				String cnt = dbDao.searchPpdOfcCdCheck(bkgNo, cntInfo.getPpdOfcCd());
				
				if("".equals(cnt) || Integer.parseInt(cnt) < 1){
					chgPpdOfcCd = dbDao.searchN3pdBfrOfcCd(bkgNo);
					
					if(!"".equals(chgPpdOfcCd) && chgPpdOfcCd.length() > 0 ){
						ppdOfcCdChgYn = "Y";
						//chg_ppd_ofc_cd
						arApOfcCd = dbDao.searchChgARAPOfcCd(chgPpdOfcCd);
						
						//AR Office가 null이면 Return 한다. 메시지 처리한다.
						if( arApOfcCd == null || arApOfcCd.getChgArOfcCd().length() < 1 ) {
							// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
							BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{ dbDao.checkNull(arApOfcCd.getChgPpdOfcCd()) }).getUserMessage());//AR Office, AP Office, Agent Office Type for PPD Office[$s] does not exist for FAC!
							modifyFACErrorMSG(BkgInfolist); 
							return;
						}
					}else{
						String aPOfcCnt = dbDao.searchAROfcIsCheck(bkgNo, cntInfo.getPpdOfcCd());
						
						if("".equals(aPOfcCnt) || "0".equals(aPOfcCnt)){
							// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
							BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{ dbDao.checkNull(arApOfcCd.getChgPpdOfcCd()) }).getUserMessage());//AR Office, AP Office, Agent Office Type for PPD Office[$s] does not exist for FAC!
							modifyFACErrorMSG(BkgInfolist); 
							return;
						}
					
					}
				}
				
				BkgInfolist.setPpdOfcCdChgYn(ppdOfcCdChgYn);
				BkgInfolist.setChgPpdOfcCd(chgPpdOfcCd);
				BkgInfolist.setChgArOfcCd(arApOfcCd.getChgArOfcCd());
				BkgInfolist.setChgApOfcCd(arApOfcCd.getChgApOfcCd());
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return;
				}
				
				// FAC Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
				String facCustShprInfo = dbDao.searchFACCustShprInterestInfo(BkgInfolist, cntInfo);
				//log.debug("\n facCustShprInfo ==>"+facCustShprInfo);
				// Freight Forwarder 와 Shipper가 이해관계가 있을 경우 Commission을 지불하지 않는다.
				if(facCustShprInfo != null && facCustShprInfo.length() > 0){
					//Freight Forwarder Customer has interests with Shipper. Freight Forwarder[$s] Shipper[$s]
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00021", new String[]{ BkgInfolist.getFfCntCd()+BkgInfolist.getFfCustSeq(),BkgInfolist.getShprCntCd()+BkgInfolist.getShprCustSeq()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return;
				}
				
				// ppd Office가 null이면 Return 한다. 메시지 처리한다.
				if( cntInfo.getPpdOfcCd() == null || cntInfo.getPpdOfcCd().length() < 1 ) {
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00022").getUserMessage()); //PPD Office Code for FAC does not exist in Booking Rate Head Info.
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				
				if("1".equals(BkgInfolist.getFfCheck())){
					//Freight Forwarder Customer Code does not exist in Booking Customer Info. Freight Forwarder[$s]
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00023", new String[]{ BkgInfolist.getFfCntCd()+BkgInfolist.getFfCustSeq()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				// svc_scp_check가 1이면 Return 한다. 메시지 처리한다. 즉 svc scp가 존재하지 않으면 메시지 처리한다.
				if("1".equals(BkgInfolist.getSvcScpCheck())) {
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00024").getUserMessage());//Serivce Scope Info does not exist!
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				
				if(BkgInfolist.getBlNo() != null && BkgInfolist.getBlNo().length() > 0){
					// BL no가 있으면 MEMO BL를 check한다.
					String memoCheck = dbDao.searchMemoCheck(bkgNo);
					//log.debug("\n memoCheck ==>"+memoCheck);
					
					// memo_check = 1이면 Commission 안 준다.
					if("1".equals(memoCheck)) {
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00025", new String[]{ BkgInfolist.getBlNo()}).getUserMessage());//BL No[$s] is Memo BL!
						modifyFACErrorMSG(BkgInfolist); 
						return;
					}
				}
				
				arApOfcCd = dbDao.searchARAPOfcCd(cntInfo.getPpdOfcCd()); 
				
				log.debug("\n arApOfcCd.getArOfcCd()===>"+arApOfcCd.getArOfcCd());
				BkgInfolist.setAgnDivFlg(dbDao.searchAgnDivFlg(arApOfcCd.getArOfcCd()));
				BkgInfolist.setCalAgnDivFlg(BkgInfolist.getAgnDivFlg());
				BkgInfolist.setBkgArOfcCd(arApOfcCd.getArOfcCd());
				BkgInfolist.setApOfcCd(arApOfcCd.getApOfcCd());
				// BkgInfolist.setPpdOfcCd(cntInfo.getPpdOfcCd());
				
				
				// AR Office가 null이면 Return 한다. 메시지 처리한다.
				if( arApOfcCd.getArOfcCd() == null || arApOfcCd.getArOfcCd().length() < 1 ) {
					//AR Office, AP Office, Agent Office Type for PPD Office[$s] does not exist for FAC!
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{cntInfo.getPpdOfcCd()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				
				//log.debug("\n BkgInfolist.getAgnDivFlg() ==>"+BkgInfolist.getAgnDivFlg());
				
				if(BkgInfolist.getAgnDivFlg().equals("Y")){
					if(arApOfcCd.getVndrCntSeq() != null && arApOfcCd.getVndrCntSeq().length() > 0) {
						BkgInfolist.setVndrCntCd(arApOfcCd.getVndrCntSeq().substring(0,2));
						BkgInfolist.setVndrSeq(arApOfcCd.getVndrCntSeq().substring(2));
					}
				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return;
				}
				
				
				// 먼저 PPD_OFC_CD로 요율정보를 조회한다.
				// PPD_OFC_CD로 요율 정보가 존재하지 않을 경우 AR_OFC_CD로 조회한다.
				// FAC Agrement 요율 정보를 조회한다. 1번째
				// FAC Agrement 요율 정보가 존재하지 않을 경우 ff_cust_seq=999999로 다시 조회한다.
				String bkgChgCdRtCnt = dbDao.searchBkgChgCdRtCnt(bkgNo);
				String bkgChgRtCnt = dbDao.searchBkgChgRtCnt(bkgNo);

				List<SearchFACAGMTRateInfoVO> facAGMTRateInfos = dbDao.searchFACAGMTRateInfo(BkgInfolist, cntInfo, BkgInfolist.getFacOfcCd());
				
				if(facAGMTRateInfos.size() > 0){
					facAGMTRateInfo = facAGMTRateInfos.get(0);
					//log.debug("facAGMTRateInfo===>"+facAGMTRateInfo.size());
					
					if(bkgChgCdRtCnt.equals(bkgChgRtCnt)){
						facAGMTRateInfo.setGrsNetDivCd("Y");
					}else{
						facAGMTRateInfo.setGrsNetDivCd("N");
					}
					facAGMTRateInfo.setFacRtOfcCd(cntInfo.getPpdOfcCd());
				}
				if( facAGMTRateInfos.size() < 1 ) {
//					if(facAGMTRateInfos.size() > 2) { // 요율정보가 3개 이상일 경우 Error Message처리
//						//Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
//						BkgInfolist.setFacRmk(new ErrorHandler("ACM00026", new String[]{"["+cntInfo.getPpdOfcCd()+"] [" + BkgInfolist.getFfCntCd() + "] [" + BkgInfolist.getFfCustSeq() + "]"}).getUserMessage()); // Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
//					} else { // 요율정보가 존재하지 않을 경우 Error Message처리
						//FAC Agreement Rate Info does not exist!  Office[$s] Freight Forwarder[$s]
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00027", new String[]{cntInfo.getPpdOfcCd(),BkgInfolist.getFfCntCd() + BkgInfolist.getFfCustSeq()}).getUserMessage()); // FAC Agreement Rate Info does not exist!  Office[$s] Freight Forwarder[$s]
//					}
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
				
				/*
				 * 조회된 Rate가 한 건일 경우 해당 Rate로 계산하도록 한다.
				 * 조회된 Rate가 두건 이상일 경우 SingleFactor 여부를 체크하여 계산에 사용할 Rate를 구한다.
				 */
				if( facAGMTRateInfos.size() == 1 ) {
					BkgInfolist.setFacRtBreakYn("Y");
				}
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return;
				}
				
				//Contaner type/size에 따라서 FAC Commission을 계산한다.
				if(facAGMTRateInfo.getFacDivCd().endsWith("BA")){
					arApOfcCd = dbDao.searchCalcFACCommBAInfo(BkgInfolist, SADateTSA, facAGMTRateInfo);
					// amt가 '0'일 경우 Error Message 처리한다.
					if (!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0))
					
					if("0".equals(arApOfcCd.getFacCalcAmt())) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00028").getUserMessage());// 'BA' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return;
					} 
					
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BF")){
					arApOfcCd = dbDao.searchCalcFACCommBFInfo(BkgInfolist, SADateTSA, facAGMTRateInfo);
					// amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00029").getUserMessage());// 'BF' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return;
					}
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BS")){
					facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
					arApOfcCd = dbDao.searchCalcFACCommBSInfo(BkgInfolist, SADateTSA, facAGMTRateInfo, facChgCtntDiv);
					// amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00030").getUserMessage());// // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return;
					}
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BL")){
					arApOfcCd.setActCommAmt(facAGMTRateInfo.getFacBkgAmt());
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("CA")){
					arApOfcCd.setActCommAmt(Double.parseDouble(facAGMTRateInfo.getFacBxAmt()) * Double.parseDouble(bkgQtyInfo.getBkgBxQty()) + "");
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("CS")){
					
					double facTeuQty = Double.parseDouble(bkgQtyInfo.getBkgDryTeuQty());
					double facRtTeuQty = Double.parseDouble(bkgQtyInfo.getBkgRfTeuQty());
					if (facRtTeuQty != 0) {
						facTeuQty = 0;
					}
					double facFeuQty = Double.parseDouble(bkgQtyInfo.getBkgDryFeuQty());
					double facRtFeuQty = Double.parseDouble(bkgQtyInfo.getBkgRfFeuQty());
					if (facRtFeuQty != 0) {
						facFeuQty = 0;
					}
					
					arApOfcCd.setActCommAmt(Double.parseDouble(facAGMTRateInfo.getFacBxAmt()) * Double.parseDouble(bkgQtyInfo.getBkgBxQty()) +
							Double.parseDouble(facAGMTRateInfo.getFacDryTeuAmt()) * facTeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacDryFeuAmt()) * facFeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacRfTeuAmt()) * facRtTeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacRfFeuAmt()) * facRtFeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacSpclTeuAmt()) * Double.parseDouble(bkgQtyInfo.getBkgSpclTeuQty()) +
							Double.parseDouble(facAGMTRateInfo.getFacSpclFeuAmt()) * Double.parseDouble(bkgQtyInfo.getBkgSpclFeuQty()) +
						"");
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("DR")){
					facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
					arApOfcCd = dbDao.searchCalcFACCommDRInfo(BkgInfolist, SADateTSA, facAGMTRateInfo, facChgCtntDiv);
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
					// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00030").getUserMessage());// BS BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return;
					}
				}

				if(arApOfcCd.getActCommAmt().length() > 0){
					BkgInfolist.setActCommAmt(arApOfcCd.getActCommAmt());
					BkgInfolist.setFacCalcAmt(arApOfcCd.getFacCalcAmt());
					BkgInfolist.setCrntAmt(arApOfcCd.getActCommAmt());
				}else{
					BkgInfolist.setActCommAmt("0");
				}
				if(facAGMTRateInfo.getFacDivCd().length() > 0){
					BkgInfolist.setFacDivCd1(facAGMTRateInfo.getFacDivCd().substring(0, 1));	
				}
				BkgInfolist.setFacRtOfcCd(facAGMTRateInfo.getFacOfcCd());
				
				if(checkFACError( BkgInfolist )) {
					return;
				}
				
				//log.debug("arApOfcCd===>"+ arApOfcCd.toString());
				
				// Booking 의 Status가 'F'이면서 BL No 가 존재하고 Commission이 0이 아닌 Booking에 대해서면 AR로 Interface 한다.
				if( "F".equals(BkgInfolist.getBkgStsCd()) && BkgInfolist.getBlNo().length() > 0 && Double.parseDouble(BkgInfolist.getActCommAmt()) != 0 ) {
					if("Y".equals(BkgInfolist.getReCalcYn())){
						BkgInfolist.setIfUsrId(BkgInfolist.getUserId());
					}else{
						BkgInfolist.setIfUsrId("FAC System");
					}
					BkgInfolist.setIfDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Timestamp(Calendar.getInstance().getTimeInMillis())));
				}
				// FAC Commission을 저장한다.
				//log.debug("\n cntInfo.getPpdOfcCd()==>"+cntInfo.getPpdOfcCd());

				dbDao.addFACMaster(BkgInfolist, RevLanebndInfo, SADateTSA, cntInfo, facAGMTRateInfo, bkgQtyInfo);
			
				//테스트용
				//dbDao.searchFACMasterTest(BkgInfolist, RevLanebndInfo, SADateTSA, cntInfo, facAGMTRateInfo, bkgQtyInfo);
			}
			// FAC Commission Detail을 저장한다.
			if("B".equals(BkgInfolist.getFacDivCd1())){
				int insCnt = dbDao.addFACDetailB(BkgInfolist, RevLanebndInfo, SADateTSA);
				if(insCnt == 0) {//fac_div_cd_1
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00031").getUserMessage());// FAC Type Size Distribution from B/L Commission Error!
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
			}else{
				int insCnt = dbDao.addFACDetailC(BkgInfolist, RevLanebndInfo, SADateTSA);
				if(insCnt == 0) {//fac_div_cd_1
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00032").getUserMessage());// 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					modifyFACErrorMSG(BkgInfolist); 
					return;
				}
			}
			
			facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
			
			if(facAGMTRateInfo.getFacDivCd().endsWith("BA")){
				dbDao.addFACChgDetailBA(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}else if(facAGMTRateInfo.getFacDivCd().endsWith("BF")){
				dbDao.addFACChgDetailBF(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}else if(facAGMTRateInfo.getFacDivCd().endsWith("BS") || facAGMTRateInfo.getFacDivCd().endsWith("DR")){
				dbDao.addFACChgDetailBS(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}

			if(checkFACError( BkgInfolist )) {
				return;
			}
			
			// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
			dbDao.modifyFACDetailComp(bkgNo);
			
			this.addFACMasterHistory(bkgNo);
			
			return;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FAC Master 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return SearchAgnBookingInfoVO
	 * @exception EventException
	 */
	public SearchAgnBookingInfoVO searchFACMaster(String bkgNo) throws EventException{

		try {
			
			return dbDao.searchFACMaster(bkgNo);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice FAC Master 정보 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return SearchAgnBookingInfoVO
	 * @exception EventException
	 */
	public SearchAgnBookingInfoVO searchInvFACMaster(String bkgNo) throws EventException{
		
		try {
			
			return dbDao.searchInvFACMaster(bkgNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param String bkg_no
	 * @exception EventException
	 */
	public void addFACMasterHistory(String bkg_no) throws EventException{
		String facCnt =""; 
		try {
			
				facCnt = dbDao.searchFACDataCheck(bkg_no, "1");
			    if(facCnt != null && facCnt.length() > 0){
			    	dbDao.addFACMasterHistory(bkg_no);
			    }
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param SearchAgnBookingInfoVO BkgInfolist
	 * @exception EventException
	 */
	public void modifyFACErrorMSG(SearchAgnBookingInfoVO BkgInfolist) throws EventException{

		try {
			
				dbDao.modifyFACMasterEMSG(BkgInfolist);
				
				dbDao.modifyFACMasterEMSGU(BkgInfolist);
				
				dbDao.modifyFACDetailEMSG(BkgInfolist);
				
				this.addFACMasterHistory(BkgInfolist.getBkgNo());
				

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param SearchAgnBookingInfoVO BkgInfolist
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkError(SearchAgnBookingInfoVO BkgInfolist ) {
		
		if(BkgInfolist.getCommProcRsltRsn() != null 
				&& !"".equals(BkgInfolist.getCommProcRsltRsn()) ) {
			return true;
		}	
		
		return false;
	}
	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 * 
	 * @param SearchAgnBookingInfoVO BkgInfolist
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkFACError(SearchAgnBookingInfoVO BkgInfolist ) {
		
		if(BkgInfolist.getFacRmk() != null 
				&& !"".equals(BkgInfolist.getFacRmk()) ) {
			return true;
		}	
		
		return false;
	}
	/**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param SearchAgnBookingInfoVO BkgInfolist
	 * @return SearchAgnBookingInfoVO
	 * @exception EventException
	 */
	public SearchAgnBookingInfoVO processFacCancel(SearchAgnBookingInfoVO BkgInfolist) throws EventException{
		String errMsg = "";
		String fac = "";
		String bkgNo = BkgInfolist.getBkgNo();
		try {
			// FAC Sequence를 구한다.
			String facSeq = dbDao.searchFACSeq(bkgNo);
			
			if("1".equals(facSeq)){
				BkgInfolist.setCancelFac("C");
			}
			BkgInfolist.setFacSeq("1");
			
			// Interface가 안 된 데이타가 존재하는지 조회한다.
			fac = dbDao.searchFACDataCheck(bkgNo, facSeq);
			//log.debug("/n facSeq + fac==>" + facSeq + " / " + fac);
			if(fac != null && fac.length() > 0){
				
				dbDao.removeFACChgDetail(bkgNo, facSeq);
				
				dbDao.removeFACDetail(bkgNo, facSeq);
				
				dbDao.removeFACMaster(bkgNo, facSeq);
				
			}
			BkgInfolist.setCancelYn("N");
			errMsg = dbDao.checkNull(BkgInfolist.getCancelFac());
			if(!errMsg.equals("")){
				return BkgInfolist;
			}
				
			//Cancel amt를 구해온다.
			BkgInfolist = this.searchFACCancelInfo(BkgInfolist);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return BkgInfolist;
	}
	/**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param SearchAgnBookingInfoVO BkgInfolist
	 * @return SearchAgnBookingInfoVO
	 * @exception EventException
	 */
	public SearchAgnBookingInfoVO searchFACCancelInfo(SearchAgnBookingInfoVO BkgInfolist) throws EventException{
		SearchAgnBookingInfoVO BkgInfolistTmp = new SearchAgnBookingInfoVO();
		String fac = "";
		String bkgNo = BkgInfolist.getBkgNo();
		BkgInfolist.setCancelAmt("0");
		String facCancelSeq = (Integer.parseInt(BkgInfolist.getFacSeq())-1)+"";
		BkgInfolist.setFacRmk("Booking No has cancelled!");
		try {
			
			if ("B".equals(BkgInfolist.getCoveredCheck())){
				BkgInfolist.setFacRmk("Co-Biz B/L! Interfaced commission amount will be duddcted.");
			}else if ("C".equals(BkgInfolist.getCoveredCheck())){
				BkgInfolist.setFacRmk("Covered B/L! Interfaced commission amount will be duddcted.");
			}
			fac = dbDao.searchFACCancelDataCheck(bkgNo, facCancelSeq); 
			
			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다. -------start-------
			// cancel된 데이타가 존재하지 않으면 ACM_FAC_COMM_REV, ACM_FAC_COMM_DTL, ACM_FAC_COMM를 삭제한다.
			if(fac != null && fac.length() > 0){
				
				BkgInfolistTmp = dbDao.searchFACCancelAmt(bkgNo);
				BkgInfolist.setCancelAmt(BkgInfolistTmp.getCancelAmt());
				BkgInfolist.setCancelAmtFacSeq(BkgInfolistTmp.getFacSeq());
				facCancelSeq = BkgInfolistTmp.getFacSeq();
				
				if(BkgInfolistTmp.getCancelAmt() != null && BkgInfolistTmp.getCancelAmt().length() > 0){
					if(Double.parseDouble(BkgInfolistTmp.getCancelAmt()) != 0){
						dbDao.addFACMasterCancel(BkgInfolist);
					}
				}
				
			} else {
				dbDao.removeFACChgDetail(bkgNo, facCancelSeq);
				
				dbDao.removeFACCancelDetail(bkgNo, facCancelSeq);
				
				dbDao.removeFACDetail(bkgNo, facCancelSeq);
				
				dbDao.removeFACMaster(bkgNo, facCancelSeq);
				
			}
			
			// cancel_amt == 0 이면 다음 Booking으로 넘어간다.
			if(BkgInfolistTmp.getCancelAmt() == null || BkgInfolistTmp.getCancelAmt().length() < 1){
				if(!(Double.parseDouble(BkgInfolist.getCancelAmt()) != 0)) {
					BkgInfolist.setFacRmk("CANCEL_AMT"); // cancel_amt is 0!
					return BkgInfolist;
				}
			}
			//------------------------------------------------------------
//			BkgInfolistTmp = dbDao.searchFacDivCd(bkgNo, facCancelSeq);
//			
//			// FAC Map에 FAC div cd의 첫번째 자리값을 넣는다.
//			BkgInfolist.setFacDivCd1(BkgInfolistTmp.getFacDivCd1());
//			// FAC Map에 Cancel 여부를 'Y'로 셋팅한다.
//			BkgInfolist.setCancelYn("Y");

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return BkgInfolist;
	}
	
	/**
	 * [INV]
	 * FAC Re Calculate<br>
	 *
	 * @param String bkgNo
	 * @return int
	 * @exception EventException
	 */
	public int createFACCommInv(String bkgNo) throws EventException {
		List<SearchSADateVO> SADatelist = null;
		SearchSADateVO SADateTSA = new SearchSADateVO();
		String ppdOfcCdChgYn = "N";
		String chgPpdOfcCd = "";
		SearchAgnBookingInfoVO arApOfcCd = new SearchAgnBookingInfoVO();
		SearchFACAGMTRateInfoVO facAGMTRateInfo = new SearchFACAGMTRateInfoVO();
		String fac = "";
		String facDtl = "";
		String facChgCtntDiv = "";
		String facOfcCd = "";
		int cnt = -1;
		
		try {

			SearchAgnBookingInfoVO BkgInfolist =  dbDao.searchBookingInfo(bkgNo);

			BkgInfolist.setReCalcYn("N");
			BkgInfolist.setUserId("FAC SYSTEM");
			
			if(BkgInfolist == null || BkgInfolist.getBkgNo().length() < 1){
				// Booking 정보가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO 저장하고 다음 Booking으로 넘어간다.
				BkgInfolist.setCommProcRsltRsn( new ErrorHandler("ACM00013").getUserMessage());//Booking Master Information does not exist!
				dbDao.modifyFACMasterErrorMSG( bkgNo, BkgInfolist.getCommProcRsltRsn());
				return 0;
			}

			if ("X".equals(BkgInfolist.getBkgStsCd()))
			{	// Canceled BKG인 경우
				BkgInfolist.setCommProcRsltRsn("Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!");
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
				//createZeroSumComm( con, bkgMap );
			}
			else  if ("B".equals(BkgInfolist.getCoveredCheck()))
			{	// Co-Biz BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00008", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is CO-BIZ BL!
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			else if ("C".equals(BkgInfolist.getCoveredCheck()))
			{	// Covered BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00014", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is Covered BL!
				dbDao.modifyFACAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			//log.debug("\n BkgInfolist.get(0).toString()==>"+BkgInfolist.get(0).toString());
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				
				if ("B".equals(BkgInfolist.getCoveredCheck())){
					this.processFacCancel(BkgInfolist);
					return 0;
				}else if ("C".equals(BkgInfolist.getCoveredCheck())){
					this.processFacCancel(BkgInfolist);
					return 0;
				}
//				if ("X".equals(BkgInfolist.getBkgStsCd())){
//					this.processFacCancel(BkgInfolist);
//					return 0;
//				}
				 
			}
			// S/A Date를 구한다.
			SADatelist =  dbDao.searchSADate(bkgNo);
			
			for(int i = 0 ; i < SADatelist.size(); i++){
				//SA_DT_DIV vsl_seq
				if(SADatelist.get(i).getSaDtDiv().equals("OTS")){
					SADatelist.set(i, dbDao.searchSADateOfSU(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq((Integer.parseInt(SADatelist.get(i).getVslSeq())-1)+"");
				}else if(SADatelist.get(i).getSaDtDiv().equals("ITS")){
					SADatelist.set(i, dbDao.searchSADateOfSU(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq((Integer.parseInt(SADatelist.get(i).getVslSeq())+4)+"");
				}else if(SADatelist.get(i).getSaDtDiv().equals("TSA")){
					SADatelist.set(i, dbDao.searchSADateOfTrunkDt(SADatelist.get(i)));
					SADatelist.get(i).setSaDtSeq("4");
					SADateTSA = SADatelist.get(i);
					
				}
			}

			if("4".equals(SADateTSA.getSaDtSeq())){
				// Trunk의 출항일자가 존재하지 않을 경우 에러처리한다. 
				// 2009-03-23 수정 :  NULL에 대한 처리시 1보다 적으면 오류처리함
				if(SADateTSA.getVpsEtdDt() == null || SADateTSA.getVpsEtdDt().length() < 1) {
					// Trunk의 출항일자가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00015").getUserMessage()); // BKG Trunk VVD ETD Date INFO does not exist!
					dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
					return 0;
				}
				// Trunk의 도착일자가 존재하지 않을 겨우 에러처리한다.
				if(SADateTSA.getVpsEtaDt() == null || SADateTSA.getVpsEtaDt().length() < 1) {
					// Trunk의 도착일자가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00016").getUserMessage()); // BKG Trunk VVD ETA Date INFO does not exist!
					dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
					return 0;
				}
			}else{
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00017", new String[]{bkgNo}).getUserMessage()); //BKG Trunk VVD Info does not exist! Booking NO[$s]
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return 0;
			}
			BkgInfolist.setTrunkEtdDt(SADateTSA.getVpsEtdDt());
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return 0;
			}
			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.	
			SearchACMContractInfoVO cntInfo = dbDao.searchACMContractInfo(bkgNo);
			
			if(cntInfo == null || ("").equals(cntInfo.getCltOfcCd()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00018").getUserMessage());
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return 0;
			}
			
			BkgInfolist.setFacOfcCd(cntInfo.getPpdOfcCd());
			
			//log.debug("cntInfo==>"+ cntInfo.toString());
			
			BkgInfolist.setRfaNo(dbDao.checkNull(BkgInfolist.getRfaNo()));
			BkgInfolist.setScNo(dbDao.checkNull(BkgInfolist.getScNo()));
			
			if ((BkgInfolist.getRfaNo().length() > 0 && BkgInfolist.getScNo().length() > 0) || (BkgInfolist.getRfaNo().length() > 0 && BkgInfolist.getScNo().length() == 0))
			{
				BkgInfolist.setSlsOfcCd(BkgInfolist.getCtrtOfcCd());
				BkgInfolist.setScCtrtOfcCd("");
			}
			else if (BkgInfolist.getRfaNo().length() == 0 && BkgInfolist.getScNo().length() > 0)
			{
				BkgInfolist.setSlsOfcCd("");
				BkgInfolist.setScCtrtOfcCd(BkgInfolist.getCtrtOfcCd());
			}
			else
			{
				BkgInfolist.setSlsOfcCd("");
				BkgInfolist.setScCtrtOfcCd("");
			}
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return 0;
			}
		
			// Booking QTY물량을 구한다.	
			SearchBKGQTYInfoVO bkgQtyInfo = dbDao.searchBKGQTYInfo(bkgNo);
			
			if(bkgQtyInfo == null || ("").equals(bkgQtyInfo.getBkgBxQty()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00019").getUserMessage());
				dbDao.modifyFACMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn()); 
				return 0;
			}
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return 0;
			}
			
			// Revenue Lane과 Revenue VVD를 구한다.	
			SearchRevLanebndInfoVO RevLanebndInfo = dbDao.searchRevLanebndInfo(bkgNo);
			
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return 0;
			}	
			// FAC 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.modifyACMBKGInfo(BkgInfolist, RevLanebndInfo, SADateTSA);
			
			// FAC비 계산 --------------------------------------------------------------------
			if(BkgInfolist.getFfCustSeq() == null || BkgInfolist.getFfCustSeq().length() == 0 || "*".equals(BkgInfolist.getFfCustSeq())) {
				BkgInfolist.setFfCustSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			if(BkgInfolist.getShprCustSeq() == null || BkgInfolist.getShprCustSeq().length() == 0 || "*".equals(BkgInfolist.getShprCustSeq())) {
				BkgInfolist.setShprCustSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			BkgInfolist.setFacRtBreakYn("N");
			BkgInfolist.setFfCustSeqTmp("999999");
			BkgInfolist.setFacStsCd("CE");	
			BkgInfolist.setCommProcRsltRsn("");
			BkgInfolist.setSlsOfcCd(BkgInfolist.getFacOfcCd());
			
			// FAC Sequence를 구한다.
			String facSeq = dbDao.searchFACSeq(bkgNo);
			
			if("1".equals(facSeq)){
				BkgInfolist.setCancelFac("C");
			}

			BkgInfolist.setFacSeq("1");
			
			// Interface가 안 된 데이타가 존재하는지 조회한다.
			fac = dbDao.searchFACDataCheck(bkgNo, facSeq);
			facDtl = dbDao.searchFACDtlDataCheck(bkgNo, facSeq);
			//log.debug("/n facSeq + fac==>" + facSeq + " / " + fac);
						
			if(fac != null && fac.length() > 0){
				
				dbDao.removeFACChgDetail(bkgNo, facSeq);
				
				dbDao.removeFACDetail(bkgNo, facSeq);
				
				dbDao.removeFACMaster(bkgNo, facSeq);
			}else if(facDtl != null && facDtl.length() > 0){
				
				dbDao.removeFACChgDetail(bkgNo, facSeq);
				
				dbDao.removeFACCancelDetail(bkgNo, facSeq);
			}

			BkgInfolist.setCancelYn("N");
			
			if("X".equals(BkgInfolist.getBkgStsCd())) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구한다.
				
				// Cancel amt를 구해온다.
				//bkgMap = dbDao.searchFACBKGCancelInfo(bkgMap);
				BkgInfolist = this.searchFACCancelInfo(BkgInfolist);
				this.addFACMasterHistory(bkgNo);
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return 0;
				}		

			} else {
			
				// PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
				String chkCnt = dbDao.searchPpdOfcCdCheck(bkgNo, cntInfo.getPpdOfcCd());
				
				if("".equals(chkCnt) || Integer.parseInt(chkCnt) < 1){
					chgPpdOfcCd = dbDao.searchN3pdBfrOfcCd(bkgNo);
					
					if(!"".equals(chgPpdOfcCd) && chgPpdOfcCd.length() > 0 ){
						ppdOfcCdChgYn = "Y";
						//chg_ppd_ofc_cd
						arApOfcCd = dbDao.searchChgARAPOfcCd(chgPpdOfcCd);
						
						//AR Office가 null이면 Return 한다. 메시지 처리한다.
						if( arApOfcCd == null || arApOfcCd.getChgArOfcCd().length() < 1 ) {
							// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
							BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{ arApOfcCd.getChgPpdOfcCd() }).getUserMessage());
							modifyFACErrorMSG(BkgInfolist); 
							return 0;
						}
					}else{
						String aPOfcCnt = dbDao.searchAROfcIsCheck(bkgNo, cntInfo.getPpdOfcCd());
						
						if("".equals(aPOfcCnt) || "0".equals(aPOfcCnt)){
							// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
							BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{ arApOfcCd.getChgPpdOfcCd() }).getUserMessage());
							modifyFACErrorMSG(BkgInfolist); 
							return 0;
						}
					
					}
				}
				
				BkgInfolist.setPpdOfcCdChgYn(ppdOfcCdChgYn);
				BkgInfolist.setChgPpdOfcCd(chgPpdOfcCd);
				BkgInfolist.setChgArOfcCd(arApOfcCd.getChgArOfcCd());
				BkgInfolist.setChgApOfcCd(arApOfcCd.getChgApOfcCd());
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return 0;
				}
				
				// FAC Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
				String facCustShprInfo = dbDao.searchFACCustShprInterestInfo(BkgInfolist, cntInfo);
				//log.debug("\n facCustShprInfo ==>"+facCustShprInfo);
				// Freight Forwarder 와 Shipper가 이해관계가 있을 경우 Commission을 지불하지 않는다.
				if(facCustShprInfo != null && facCustShprInfo.length() > 0){
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00021", new String[]{ BkgInfolist.getFfCntCd()+BkgInfolist.getFfCustSeq(),BkgInfolist.getShprCntCd()+BkgInfolist.getShprCustSeq()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return 0;
				}
				
				// ppd Office가 null이면 Return 한다. 메시지 처리한다.
				if( cntInfo.getPpdOfcCd() == null || cntInfo.getPpdOfcCd().length() < 1 ) {
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00022").getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				
				if("1".equals(BkgInfolist.getFfCheck())){
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00023", new String[]{ BkgInfolist.getFfCntCd()+BkgInfolist.getFfCustSeq()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				// svc_scp_check가 1이면 Return 한다. 메시지 처리한다. 즉 svc scp가 존재하지 않으면 메시지 처리한다.
				if("1".equals(BkgInfolist.getSvcScpCheck())) {
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00024").getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				
				if(BkgInfolist.getBlNo() != null && BkgInfolist.getBlNo().length() > 0){
					// BL no가 있으면 MEMO BL를 check한다.
					String memoCheck = dbDao.searchMemoCheck(bkgNo);
					//log.debug("\n memoCheck ==>"+memoCheck);
					
					// memo_check = 1이면 Commission 안 준다.
					if("1".equals(memoCheck)) {
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00025", new String[]{ BkgInfolist.getBlNo()}).getUserMessage());
						modifyFACErrorMSG(BkgInfolist); 
						return 0;
					}
				}
				
				arApOfcCd = dbDao.searchARAPOfcCd(cntInfo.getPpdOfcCd()); 
				
				
				//log.debug("\n arApOfcCd ==>"+arApOfcCd);
				BkgInfolist.setAgnDivFlg(dbDao.searchAgnDivFlg(arApOfcCd.getArOfcCd()));
				BkgInfolist.setCalAgnDivFlg(BkgInfolist.getAgnDivFlg());
				BkgInfolist.setBkgArOfcCd(arApOfcCd.getArOfcCd());
				/////////////////////////////////////////////////////// 확인요
				BkgInfolist.setArOfcCd(arApOfcCd.getArOfcCd());
				BkgInfolist.setApOfcCd(arApOfcCd.getApOfcCd());
				// BkgInfolist.setPpdOfcCd(cntInfo.getPpdOfcCd());
				
				
				// AR Office가 null이면 Return 한다. 메시지 처리한다.
				if( arApOfcCd.getArOfcCd() == null || arApOfcCd.getArOfcCd().length() < 1 ) {
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00020", new String[]{cntInfo.getPpdOfcCd()}).getUserMessage());
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				
				//log.debug("\n BkgInfolist.getAgnDivFlg() ==>"+BkgInfolist.getAgnDivFlg());
				
				if(BkgInfolist.getAgnDivFlg().equals("Y")){
					if(arApOfcCd.getVndrCntSeq() != null && arApOfcCd.getVndrCntSeq().length() > 0) {
						BkgInfolist.setVndrCntCd(arApOfcCd.getVndrCntSeq().substring(0,2));
						BkgInfolist.setVndrSeq(arApOfcCd.getVndrCntSeq().substring(2));
					}
				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return 0;
				}
				
				
				// 먼저 PPD_OFC_CD로 요율정보를 조회한다.
				// PPD_OFC_CD로 요율 정보가 존재하지 않을 경우 AR_OFC_CD로 조회한다.
				// FAC Agrement 요율 정보를 조회한다. 1번째
				// FAC Agrement 요율 정보가 존재하지 않을 경우 ff_cust_seq=999999로 다시 조회한다.
				String bkgChgCdRtCnt = dbDao.searchBkgChgCdRtCnt(bkgNo);
				String bkgChgRtCnt = dbDao.searchBkgChgRtCnt(bkgNo);

				List<SearchFACAGMTRateInfoVO> facAGMTRateInfos = dbDao.searchFACAGMTRateInfo(BkgInfolist, cntInfo, BkgInfolist.getFacOfcCd());
				
				if(facAGMTRateInfos.size() > 0){
					facAGMTRateInfo = facAGMTRateInfos.get(0);
					//log.debug("facAGMTRateInfo===>"+facAGMTRateInfo.size());
					
					if(bkgChgCdRtCnt.equals(bkgChgRtCnt)){
						facAGMTRateInfo.setGrsNetDivCd("Y");
					}else{
						facAGMTRateInfo.setGrsNetDivCd("N");
					}
					facAGMTRateInfo.setFacRtOfcCd(cntInfo.getPpdOfcCd());
				}
				
				if( facAGMTRateInfos.size() < 1 ) { //facAGMTRateInfos.size() > 2 ||
//					if(facAGMTRateInfos.size() > 2) { // 요율정보가 3개 이상일 경우 Error Message처리
//						BkgInfolist.setFacRmk(new ErrorHandler("ACM00026", new String[]{"["+cntInfo.getPpdOfcCd()+"] [" + BkgInfolist.getFfCntCd() + "] [" + BkgInfolist.getFfCustSeq() + "]"}).getUserMessage()); // Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
//					} else { // 요율정보가 존재하지 않을 경우 Error Message처리
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00027", new String[]{cntInfo.getPpdOfcCd(),BkgInfolist.getFfCntCd() + BkgInfolist.getFfCustSeq()}).getUserMessage()); // FAC Agreement Rate Info does not exist!  Office[$s] Freight Forwarder[$s]
//					}
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
				/*
				 * 조회된 Rate가 한 건일 경우 해당 Rate로 계산하도록 한다.
				 * 조회된 Rate가 두건 이상일 경우 SingleFactor 여부를 체크하여 계산에 사용할 Rate를 구한다.
				 */
				if( facAGMTRateInfos.size() == 1 ) {
					BkgInfolist.setFacRtBreakYn("Y");
				}
				
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFACError( BkgInfolist )) {
					return 0;
				}
				facOfcCd = dbDao.checkNull(BkgInfolist.getFacOfcCd());
				//log.info("Rete 존재 유무 1:"+facRtBreakYN);
				if( "N".equals(BkgInfolist.getFacRtBreakYn()) ) { // Rate가 존재하지 않을 경우

						// FAC Agrement 요율 정보를 조회한다. 2번째
						facAGMTRateInfos = dbDao.searchFACAGMTRateInfo(BkgInfolist, cntInfo,facOfcCd);
						//log.info("3번째 :"+bkgMap);
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(facAGMTRateInfos.size() > 0){
							facAGMTRateInfo = facAGMTRateInfos.get(0);
							//log.debug("facAGMTRateInfo===>"+facAGMTRateInfo.size());
							
							if(bkgChgCdRtCnt.equals(bkgChgRtCnt)){
								facAGMTRateInfo.setGrsNetDivCd("Y");
							}else{
								facAGMTRateInfo.setGrsNetDivCd("N");
							}
							facAGMTRateInfo.setFacRtOfcCd(cntInfo.getPpdOfcCd());
						}
						
						if(  facAGMTRateInfos.size() < 1 ) { //facAGMTRateInfos.size() > 2 ||
//							if(facAGMTRateInfos.size() > 2) { // 요율정보가 3개 이상일 경우 Error Message처리
//								BkgInfolist.setFacRmk(new ErrorHandler("ACM00026", new String[]{"["+cntInfo.getPpdOfcCd()+"] [" + BkgInfolist.getFfCntCd() + "] [" + BkgInfolist.getFfCustSeq() + "]"}).getUserMessage()); // Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
//							} else { // 요율정보가 존재하지 않을 경우 Error Message처리
								BkgInfolist.setFacRmk(new ErrorHandler("ACM00027", new String[]{cntInfo.getPpdOfcCd(),BkgInfolist.getFfCntCd() + BkgInfolist.getFfCustSeq()}).getUserMessage()); // FAC Agreement Rate Info does not exist!  Office[$s] Freight Forwarder[$s]
//							}
							modifyFACErrorMSG(BkgInfolist); 
							return 0;
						}
						/*
						 * 조회된 Rate가 한 건일 경우 해당 Rate로 계산하도록 한다.
						 * 조회된 Rate가 두건 이상일 경우 SingleFactor 여부를 체크하여 계산에 사용할 Rate를 구한다.
						 */
						if( facAGMTRateInfos.size() == 1 ) {
							BkgInfolist.setFacRtBreakYn("Y");
						}
						
						// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
						if(checkFACError( BkgInfolist )) {
							return 0;
						}
					}
				BkgInfolist.setFacRtOfcCd(facOfcCd);
				
				//Contaner type/size에 따라서 FAC Commission을 계산한다.
				if(facAGMTRateInfo.getFacDivCd().endsWith("BA")){
					arApOfcCd = dbDao.searchCalcFACCommBAInfo(BkgInfolist, SADateTSA, facAGMTRateInfo);
					
					// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00028").getUserMessage());// 'BA' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return 0;
					}
					
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BF")){
					arApOfcCd = dbDao.searchCalcFACCommBFInfo(BkgInfolist, SADateTSA, facAGMTRateInfo);
					
					// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00029").getUserMessage());// 'BF' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return 0;
					}
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BS")){
					facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
					arApOfcCd = dbDao.searchCalcFACCommBSInfo(BkgInfolist, SADateTSA, facAGMTRateInfo, facChgCtntDiv);
					
					// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00030").getUserMessage());// // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
						modifyFACErrorMSG(BkgInfolist); 
						return 0;
					}
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("BL")){
					arApOfcCd.setActCommAmt(facAGMTRateInfo.getFacBkgAmt());
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("CA")){
					arApOfcCd.setActCommAmt(Double.parseDouble(facAGMTRateInfo.getFacBxAmt()) * Double.parseDouble(bkgQtyInfo.getBkgBxQty()) + "");
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("CS")){
					
					double facTeuQty = Double.parseDouble(bkgQtyInfo.getBkgDryTeuQty());
					double facRtTeuQty = Double.parseDouble(bkgQtyInfo.getBkgRfTeuQty());
					if (facRtTeuQty != 0) {
						facTeuQty = 0;
					}
					double facFeuQty = Double.parseDouble(bkgQtyInfo.getBkgDryFeuQty());
					double facRtFeuQty = Double.parseDouble(bkgQtyInfo.getBkgRfFeuQty());
					if (facRtFeuQty != 0) {
						facFeuQty = 0;
					}
					
					arApOfcCd.setActCommAmt(Double.parseDouble(facAGMTRateInfo.getFacBxAmt()) * Double.parseDouble(bkgQtyInfo.getBkgBxQty()) +
							Double.parseDouble(facAGMTRateInfo.getFacDryTeuAmt()) * facTeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacDryFeuAmt()) * facFeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacRfTeuAmt()) * facRtTeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacRfFeuAmt()) * facRtFeuQty +
							Double.parseDouble(facAGMTRateInfo.getFacSpclTeuAmt()) * Double.parseDouble(bkgQtyInfo.getBkgSpclTeuQty()) +
							Double.parseDouble(facAGMTRateInfo.getFacSpclFeuAmt()) * Double.parseDouble(bkgQtyInfo.getBkgSpclFeuQty()) +
						"");
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
				}else if(facAGMTRateInfo.getFacDivCd().endsWith("DR")){
					facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
					arApOfcCd = dbDao.searchCalcFACCommDRInfo(BkgInfolist, SADateTSA, facAGMTRateInfo, facChgCtntDiv);
					
					// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
					if(!(Double.parseDouble(arApOfcCd.getActCommAmt()) != 0)) { // 부동 소수점의 == 연산은 지양한다.
						BkgInfolist.setFacRmk(new ErrorHandler("ACM00030").getUserMessage());// 
						modifyFACErrorMSG(BkgInfolist); 
						return 0;
					}
					arApOfcCd.setActCommAmt(dbDao.searchRoundValue(Double.parseDouble(arApOfcCd.getActCommAmt()))+"");
				}

				if(arApOfcCd.getActCommAmt().length() > 0){
					BkgInfolist.setActCommAmt(arApOfcCd.getActCommAmt());
					BkgInfolist.setFacCalcAmt(arApOfcCd.getFacCalcAmt());
					BkgInfolist.setCrntAmt(arApOfcCd.getActCommAmt());
				}else{
					BkgInfolist.setActCommAmt("0");
				}
				if(facAGMTRateInfo.getFacDivCd().length() > 0){
					BkgInfolist.setFacDivCd1(facAGMTRateInfo.getFacDivCd().substring(0, 1));	
				}
				BkgInfolist.setFacRtOfcCd(facAGMTRateInfo.getFacOfcCd());
				
				if(checkFACError( BkgInfolist )) {
					return 0;
				}
				
				//log.debug("arApOfcCd===>"+ arApOfcCd.toString());
				
				// Booking 의 Status가 'F'이면서 BL No 가 존재하고 Commission이 0이 아닌 Booking에 대해서면 AR로 Interface 한다.
				if( "F".equals(BkgInfolist.getBkgStsCd()) && BkgInfolist.getBlNo().length() > 0 && Double.parseDouble(BkgInfolist.getActCommAmt()) != 0 ) {
					if("Y".equals(BkgInfolist.getReCalcYn())){
						BkgInfolist.setIfUsrId(BkgInfolist.getUserId());
					}else{
						BkgInfolist.setIfUsrId("FAC System");
					}
					BkgInfolist.setIfDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Timestamp(Calendar.getInstance().getTimeInMillis())));
				}
				// FAC Commission을 저장한다.
				dbDao.addFACMaster(BkgInfolist, RevLanebndInfo, SADateTSA, cntInfo, facAGMTRateInfo, bkgQtyInfo);
			
				//테스트용
				//dbDao.searchFACMasterTest(BkgInfolist, RevLanebndInfo, SADateTSA, cntInfo, facAGMTRateInfo, bkgQtyInfo);
			}
			// FAC Commission Detail을 저장한다.
			if("B".equals(BkgInfolist.getFacDivCd1())){
				int insCnt = dbDao.addFACDetailB(BkgInfolist, RevLanebndInfo, SADateTSA);
				if(insCnt == 0) {//fac_div_cd_1
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00031").getUserMessage());// FAC Type Size Distribution from B/L Commission Error!
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
			}else{
				int insCnt = dbDao.addFACDetailC(BkgInfolist, RevLanebndInfo, SADateTSA);
				if(insCnt == 0) {//fac_div_cd_1
					BkgInfolist.setFacRmk(new ErrorHandler("ACM00032").getUserMessage());// // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					modifyFACErrorMSG(BkgInfolist); 
					return 0;
				}
			}
			
			facChgCtntDiv = "'" + facAGMTRateInfo.getFacChgCtnt().replaceAll(",", "','") + "'";
			if(facAGMTRateInfo.getFacDivCd().endsWith("BA")){
				dbDao.addFACChgDetailBA(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}else if(facAGMTRateInfo.getFacDivCd().endsWith("BF")){
				dbDao.addFACChgDetailBF(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}else if(facAGMTRateInfo.getFacDivCd().endsWith("BS") || facAGMTRateInfo.getFacDivCd().endsWith("DR")){
				dbDao.addFACChgDetailBS(BkgInfolist, RevLanebndInfo, SADateTSA, facChgCtntDiv);
			}

			if(checkFACError( BkgInfolist )) {
				return 0;
			}
			
			// 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.
			dbDao.modifyFACDetailComp(bkgNo);
			
			this.addFACMasterHistory(bkgNo);

			cnt = 1;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
			return cnt;
	}
}