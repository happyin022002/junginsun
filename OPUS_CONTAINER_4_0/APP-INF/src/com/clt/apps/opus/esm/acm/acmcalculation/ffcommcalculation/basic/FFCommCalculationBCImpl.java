/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationBCImpl.java
*@FileTitle : FFCommCalculationBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration.FFCommCalculationDBDAO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchACMFFContractInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFAGMTRateInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFBKGQTYInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFBookingInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFRevLanebndInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFSADateVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-FFCalculation Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author PARK Sung-Jin
 * @see Esm_Acm_0027EventResponse 참조
 * @since J2EE 1.6
 */
public class FFCommCalculationBCImpl extends BasicCommandSupport implements FFCommCalculationBC {

	// Database Access Object
	private transient FFCommCalculationDBDAO dbDao = null;

	/**
	 * FFCommCalculationBCImpl 객체 생성<br>
	 * FFCommCalculationDBDAO를 생성한다.<br>
	 */
	public FFCommCalculationBCImpl() {
		dbDao = new FFCommCalculationDBDAO();
	}

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkgNo
	 * @param String userId
	 * @exception EventExceptions
	 */
	public void reCalculateFFComm(String bkgNo, String userId) throws EventException {

		List<SearchFFSADateVO> SADatelist = null;
		SearchFFSADateVO SADateTSA = new SearchFFSADateVO();
		SearchFFBookingInfoVO BkgInfoTmp = new SearchFFBookingInfoVO();
		SearchFFAGMTRateInfoVO ffAGMTRateInfo = new SearchFFAGMTRateInfoVO();
		String ffCalcAmt = "";
//		String ffChgCtntDiv = "";
		String ff = "";
		//String bkgCreDt = "";
		String bkgStsCd = "";
		double actCommAmt = 0;
		int iCount = 0;


		try {
			log.debug("\n bkg_no===>"+bkgNo);
			// Booking 정보를 조회한다.
			SearchFFBookingInfoVO BkgInfolist =  dbDao.searchBookingInfo(bkgNo);

			//BkgInfolist.setReCalcYn("Y");
			BkgInfolist.setUserId(userId);

			if(BkgInfolist.getBkgNo().length() < 1){
				// Booking 정보가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO 저장하고 다음 Booking으로 넘어간다.
				BkgInfolist.setCommProcRsltRsn( new ErrorHandler("ACM00013").getUserMessage());//Booking Master Information does not exist!
				dbDao.modifyFFMasterErrorMSG( bkgNo, BkgInfolist.getCommProcRsltRsn());
				return;
			}

			if ("X".equals(BkgInfolist.getBkgStsCd()))
			{	// Canceled BKG인 경우
				BkgInfolist.setCommProcRsltRsn("Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!");
				dbDao.modifyFFAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
			}
			else if ("B".equals(BkgInfolist.getCoveredCheck()))
			{	// Co-Biz BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00008", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is CO-BIZ BL!
				dbDao.modifyFFAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			else if ("C".equals(BkgInfolist.getCoveredCheck()))
			{	// Covered BL인 경우
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00014", new String[]{BkgInfolist.getBlNo()}).getUserMessage()); // BL No[$s] is Covered BL!
				dbDao.modifyFFAGNBKGInfo( bkgNo, BkgInfolist.getCommProcRsltRsn() );
//				createZeroSumComm( con, bkgMap );
			}
			//log.debug("\n BkgInfolist.get(0).toString()==>"+BkgInfolist.get(0).toString());
			BkgInfolist.getBkgCreDt();
			//bkgCreDt = dbDao.checkNull(BkgInfolist.getBkgCreDt());
			bkgStsCd = dbDao.checkNull(BkgInfolist.getBkgStsCd());
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				if ("B".equals(BkgInfolist.getCoveredCheck())){
					this.processFFCancel(BkgInfolist);
					return;
				}else if ("C".equals(BkgInfolist.getCoveredCheck())){
					this.processFFCancel(BkgInfolist);
					return;
				}
				if(bkgStsCd.equals("X")){
					this.processFFCancel(BkgInfolist);
					return;
				}

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
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00015").getUserMessage());
					dbDao.modifyFFMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
					return;
				}
				// Trunk의 도착일자가 존재하지 않을 겨우 에러처리한다.
				if(SADateTSA.getVpsEtaDt() == null || SADateTSA.getVpsEtaDt().length() < 1) {
					// Trunk의 도착일자가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00016").getUserMessage());
					dbDao.modifyFFMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
					return;
				}
			}else{
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00017", new String[]{bkgNo}).getUserMessage());
				dbDao.modifyFFMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
				return ;
			}
			//TRUNK_ETD_DT
			BkgInfolist.setTrunkEtdDt(SADateTSA.getVpsEtdDt());

			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}

			// SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.
			SearchACMFFContractInfoVO cntInfo = dbDao.searchACMContractInfo(bkgNo);

			if(cntInfo == null || ("").equals(cntInfo.getCltOfcCd()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00018").getUserMessage());
				dbDao.modifyFFMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
				return;
			}

			BkgInfolist.setFfOfcCd(cntInfo.getPpdOfcCd());
			BkgInfolist.setRfaNo(dbDao.checkNull(BkgInfolist.getRfaNo()));
			BkgInfolist.setScNo(dbDao.checkNull(BkgInfolist.getScNo()));

			//log.debug("cntInfo==>"+ cntInfo.toString());
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
			//log.debug("\n BkgInfolist.toString()==>"+BkgInfolist.toString());

			// Booking QTY물량을 구한다.
			SearchFFBKGQTYInfoVO bkgQtyInfo = dbDao.searchBKGQTYInfo(bkgNo);

			if(bkgQtyInfo == null || ("").equals(bkgQtyInfo.getBkgBxQty()) ){
				// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
				BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00019").getUserMessage());
				dbDao.modifyFFMasterErrorMSG( bkgNo,BkgInfolist.getCommProcRsltRsn());
				return;
			}

			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}

			//log.debug("bkgQtyInfo==>"+ bkgQtyInfo.toString());

			// Revenue Lane과 Revenue VVD를 구한다.
			SearchFFRevLanebndInfoVO RevLanebndInfo = dbDao.searchRevLanebndInfo(bkgNo);

			//log.debug("\n RevLanebndInfo.toString()==>"+RevLanebndInfo.toString());
			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				return;
			}
			BkgInfolist.setFmcNo(BkgInfolist.getFmcNo().replaceAll("'", "''"));
			// FF 계산전에 Booking Commission 정보 테이블에 저장한다.
			dbDao.modifyACMBKGInfo(BkgInfolist, RevLanebndInfo, SADateTSA);
			// Brokerage 체크
			if(!dbDao.createActualFFCommCheck(BkgInfolist)) {
				return;
			}

			//---------------------------------------------------------------------------
			if(BkgInfolist.getBkgFfSeq() == null || BkgInfolist.getBkgFfSeq().length() == 0 || "*".equals(BkgInfolist.getBkgFfSeq())) {
				BkgInfolist.setBkgFfSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			if(BkgInfolist.getFfSeq() == null || BkgInfolist.getFfSeq().length() == 0 || "*".equals(BkgInfolist.getFfSeq())) {
				BkgInfolist.setFfSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}
			if(BkgInfolist.getShprCustSeq() == null || BkgInfolist.getShprCustSeq().length() == 0 || "*".equals(BkgInfolist.getShprCustSeq())) {
				BkgInfolist.setShprCustSeq("000000");// 6자리 맞춰서 세팅(데이타가 없을 경우 000000으로)
			}

			BkgInfolist.setFfCmpnStsCd("CE");
			BkgInfolist.setCommProcRsltRsn("");

			// FF CMPN Sequence를 구한다.
			BkgInfolist.setFfCmpnSeq(dbDao.searchFFSeq(bkgNo));

//			if(brog_seq == 1){
//				bkgMap.put("CANCEL_BRO", "C");
//			}
//
			// Interface가 안 된 데이타가 존재하는지 조회한다.
			ff = dbDao.searchFFDataCheck(bkgNo, BkgInfolist.getFfCmpnSeq());
			//log.debug("/n ffSeq + ff==>" + BkgInfolist.getFfCmpnSeq() + " / " + ff);

			if(!"".equals(ff)){

				dbDao.removeFFChgDetail(bkgNo, BkgInfolist.getFfCmpnSeq());

				dbDao.removeFFDetail(bkgNo, BkgInfolist.getFfCmpnSeq());

				dbDao.removeFFMaster(bkgNo, BkgInfolist.getFfCmpnSeq());

			}
			// Type Size 저장시 필요
			//brogMap.put("CANCEL_YN", "N");
			if("X".equals(BkgInfolist.getBkgStsCd())) {	// Interface 했는데 status가 cancel인 경우 Cancel amt를 구해온다.

				// Cancel amt를 구해온다.
				searchFFBKGCancelInfo(BkgInfolist);

				return;

			} else {
				// FF Code가 없으면 Error처리하고 Return한다.
				if("1".equals(BkgInfolist.getFfCheck())) {
					// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
					BkgInfolist.setCommProcRsltRsn(new ErrorHandler("ACM00023").getUserMessage());
					return;
				}
				// Vendor에 matching 되는 Freight Forwarder Code를 구한 후 MDM Vendor에 존재하는지 체크한다.
				if("1".equals(BkgInfolist.getShFfCheckFlag())){
					String canadaChk = dbDao.searchCanadaCheck(BkgInfolist);
					//@[ff_cmpn_rmk]
					if("0".equals(canadaChk)) {
						// 데이타가 존재하지 않을 경우 Error를 ACM_AGN_BKG_INFO에 저장한다.
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00047", new String[]{ BkgInfolist.getFfCntCd() + BkgInfolist.getFfSeq(), BkgInfolist.getShprCntCd() + BkgInfolist.getShprCustSeq()}).getUserMessage());
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
					// 이중 check 제거
//					String customerChk = dbDao.searchCustomerCheck(bkgNo);
//					if("1".equals(customerChk)){
//						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00033").getUserMessage());
//						modifyFFErrorMSG(BkgInfolist);
//						return;
//					}

					//log.debug("/n canadaChk + customerChk==>" + canadaChk + " / " + customerChk);

				}

				String vndrCntSeq = dbDao.searchFFCode(BkgInfolist);

				if(vndrCntSeq != null && vndrCntSeq.length() > 0){
					BkgInfolist.setVndrCntCd(vndrCntSeq.substring(0, 2));
					BkgInfolist.setVndrSeq(vndrCntSeq.substring(2));
				}else{
					BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00045").getUserMessage());
					modifyFFErrorMSG(BkgInfolist);
					return;
				}
				//BkgInfolist.getVndrCntSeq()
				String vendor = dbDao.searchVndrSeqCheck(BkgInfolist);

				//log.debug("\n vendor==>" + vendor);
				if(vendor == null || vendor.length() < 1){
					BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00034", new String[]{ BkgInfolist.getVndrCntCd() + BkgInfolist.getVndrCntSeq() }).getUserMessage());
					modifyFFErrorMSG(BkgInfolist);
					return;
				}

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}

				// FF Freight Forwarder 와 Shipper의 관계 여부를 체크한다.
				String ffCustShprInfo = dbDao.searchFFCustShprInterestInfo(BkgInfolist);
				//log.debug("\n ffCustShprInfo ==>"+ffCustShprInfo);
				if(ffCustShprInfo != null && ffCustShprInfo.length() > 0){
					BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00035", new String[]{ BkgInfolist.getFfCntCd() + BkgInfolist.getFfSeq(), BkgInfolist.getShprCntCd() + BkgInfolist.getShprCustSeq()}).getUserMessage());// Freight Forwarder Customer has interests with Shipper. Freight Forwarder[$s] Shipper[$s]
					modifyFFErrorMSG(BkgInfolist);
					return;
				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}

				if(BkgInfolist.getBlNo().length() > 0){
					// BL no가 있으면 MEMO BL를 check한다.
					String memoCheck = dbDao.searchMemoCheck(bkgNo);
					//log.debug("\n memoCheck ==>"+memoCheck);

					// memo_check = 1이면 Commission 안 준다.
					if("1".equals(memoCheck)) {
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00025", new String[]{ BkgInfolist.getBlNo()}).getUserMessage());// BL No[$s] is Memo BL!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
				}

				if ("US".equals(BkgInfolist.getFfCntCd()) && ("*".equals(BkgInfolist.getFmcNo()) || "".equals(BkgInfolist.getFmcNo())))
				{
					if("B".equals(BkgInfolist.getMdmCustTpCd())){
						BkgInfolist.setFfCmpnRmk("Freight Forwarder type is BCO.");
					}else{					
						//데이타가 존재하지 않을 경우 Error를 저장한다.
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00043", new String[]{ BkgInfolist.getFfCntCd()+BkgInfolist.getFfSeq() }).getUserMessage()); // Freight Forwarder does not have FMC No! Freight Forwarder[$s]
					}
					modifyFFErrorMSG(BkgInfolist);
					return;
				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}


				List<SearchFFAGMTRateInfoVO> ffAGMTRateInfoList = dbDao.searchFFAGMTRateInfo(BkgInfolist, SADateTSA);

				if(ffAGMTRateInfoList == null || ffAGMTRateInfoList.size() < 1) {
					BkgInfolist.setFfCustSeqTmp("999999");
					ffAGMTRateInfoList = dbDao.searchFFAGMTRateInfo(BkgInfolist, SADateTSA);
					
					if(ffAGMTRateInfoList == null || ffAGMTRateInfoList.size() < 1) {
						//데이타가 존재하지 않을 경우 Error를 저장한다.
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00049").getUserMessage());
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
				}

				ffAGMTRateInfo = ffAGMTRateInfoList.get(0);
				BkgInfolist.setFfSeq(ffAGMTRateInfo.getFfSeq());

				boolean errorFlag = false;
				double totalAmt = Double.parseDouble(ffAGMTRateInfo.getFfBkgRt()) + Double.parseDouble(ffAGMTRateInfo.getFfBxAmt()) +
						Double.parseDouble(ffAGMTRateInfo.getFfTeuAmt()) + Double.parseDouble(ffAGMTRateInfo.getFfFeuAmt()) +
						Double.parseDouble(ffAGMTRateInfo.getFfRfAmt());
				if( "999999".equals(BkgInfolist.getFfCustSeqTmp())) {
					if( ffAGMTRateInfoList.size() != 1 ) {
						errorFlag = true;
					} else {
						// 요율값이 0일경우 Error 메시지 처리한 후 다음 부킹으으로..
						if(!(totalAmt != 0)) { // 부동소수점의 == 사용은 지양한다.
							errorFlag = true;
						}
					}
				} else {
					if( ffAGMTRateInfoList.size() > 1 ) {
						errorFlag = true;
					} else {
						// 요율값이 0일경우 Error 메시지 처리한 후 다음 부킹으로..
						if(!(totalAmt != 0)) { // 부동소수점의 == 사용은 지양한다.
							ffAGMTRateInfo = new SearchFFAGMTRateInfoVO(); // Brokerage Rate List를 clear 한다.
						}
					}
				}

				if( errorFlag ) {
					if(ffAGMTRateInfoList.size() > 1) {
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00026", new String[]{ "["+BkgInfolist.getBkgOfcCd()+"] ["  + BkgInfolist.getFfCntCd()+ "] [" + BkgInfolist.getFfSeq()+ "]"}).getUserMessage()); // Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
						modifyFFErrorMSG(BkgInfolist);
					} else {
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00036", new String[]{ BkgInfolist.getBkgOfcCd(), BkgInfolist.getFfCntCd() + BkgInfolist.getFfSeq()}).getUserMessage()); // Brokerage Agreement Rate Info does not exist! Office[$s] Freight Forwarder[$s]
					}
					return;
				}
				//log.debug("ffAGMTRateInfo===>"+ffAGMTRateInfo.toString());

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}

				//if (ffAGMTRateInfo != null) {
				// Contaner type/size에 따라서 Brokerage Commission을 계산한다.
//				ffChgCtntDiv = ffAGMTRateInfo.getFfChgCtnt().replaceAll(",", "','");
				
				if(ffAGMTRateInfo.getFfDivCd().endsWith("BA")){
					BkgInfoTmp = dbDao.searchCalcFFCommBAInfo(bkgNo, ffAGMTRateInfo.getFfBkgRt());
					ffCalcAmt = BkgInfoTmp.getFfCalcAmt();
					// ffCalcAmt '0'일 경우 Error Message 처리한다.
					if(!( Double.parseDouble(ffCalcAmt) != 0)) { // 부동소수점의 == 사용은 지양한다.
//						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00028").getUserMessage()); // BA' BL Menifested Rate Amount in Brokerage/FF is '0' error!
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00005", new String[]{ "BKG Rate info"}).getUserMessage()); // $s does not exist!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
					actCommAmt = Double.parseDouble(BkgInfoTmp.getActCommAmt());
					BkgInfolist.setFfChgAmt(ffCalcAmt);

				}else if(ffAGMTRateInfo.getFfDivCd().endsWith("BF")){
					BkgInfoTmp = dbDao.searchCalcFFCommBFInfo(bkgNo, ffAGMTRateInfo.getFfBkgRt());
					ffCalcAmt = BkgInfoTmp.getFfCalcAmt();
					// ffCalcAmt '0'일 경우 Error Message 처리한다.
					if(!( Double.parseDouble(ffCalcAmt) != 0)) { // 부동소수점의 == 사용은 지양한다.
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00005", new String[]{ "BKG Rate info"}).getUserMessage()); // $s does not exist!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
					actCommAmt = Double.parseDouble(BkgInfoTmp.getActCommAmt());
					BkgInfolist.setFfChgAmt(ffCalcAmt);

				}else if(ffAGMTRateInfo.getFfDivCd().endsWith("BS")){
//					BkgInfoTmp = dbDao.searchCalcFFCommBSInfo(bkgNo, ffAGMTRateInfo.getFfBkgRt(), ffChgCtntDiv);
					BkgInfoTmp = dbDao.searchCalcFFCommBSInfo(bkgNo, ffAGMTRateInfo.getFfBkgRt(), ffAGMTRateInfo);
					ffCalcAmt = BkgInfoTmp.getFfCalcAmt();
					// ffCalcAmt '0'일 경우 Error Message 처리한다.
					if(!( Double.parseDouble(ffCalcAmt) != 0)) { // 부동소수점의 == 사용은 지양한다.
//						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00030").getUserMessage()); //BS' BL Menifested Rate Amount in Brokerage/FF is '0' error!
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00005", new String[]{ "BKG Rate info"}).getUserMessage()); // $s does not exist!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
					actCommAmt = Double.parseDouble(BkgInfoTmp.getActCommAmt());
					BkgInfolist.setFfChgAmt(ffCalcAmt);
				}else if(ffAGMTRateInfo.getFfDivCd().endsWith("CA")){
					//act_comm_amt = brog_box_qty * brog_box_rt;
					actCommAmt = (Double.parseDouble(bkgQtyInfo.getBkgBxQty()) * Double.parseDouble(ffAGMTRateInfo.getFfBxAmt()));
					actCommAmt = dbDao.searchRoundValue(actCommAmt);
				}else if(ffAGMTRateInfo.getFfDivCd().endsWith("CS")){
					/*
					 * CS인 이면서 contaner type/size가 Refer(R2, R4 등) 인 경우
					 * 1. reu rate가 존재하지 않을 경우 teu/feu 가 존재하면 해당 요율로 계산한다.
					 * 2. reu rate가 존재하고 teu rate, feu rate 가 존재하면 reu rate 요율로만 계산한다.
					 * 이때 teu/feu 의 물량을 0으로 처리해서 계산해도 0값이 나오도록 한다.
					 */
					//if( Double.parseDouble(ffAGMTRateInfo.getFfRfAmt()) != 0 ) { // reu rate가 존재할 경우
						//BkgInfolist.setFfTeuQty(bkgQtyInfo.getBkgTeuQty());
						//BkgInfolist.setFfFeuQty(bkgQtyInfo.getBkgFeuQty());
					//} else
						if (Double.parseDouble(ffAGMTRateInfo.getFfTeuAmt()) != 0 || Double.parseDouble(ffAGMTRateInfo.getFfFeuAmt()) != 0) { // 부동소수점의 == 사용은 지양한다.
						BkgInfoTmp = dbDao.searchCalcFFCommCSInfo(bkgNo);
						bkgQtyInfo.setBkgTeuQty(BkgInfoTmp.getFfTeuQty());
						bkgQtyInfo.setBkgFeuQty(BkgInfoTmp.getFfFeuQty());
					}
					// ffCalcAmt = brog_box_rt*brog_box_qty + brog_teu_rt*brog_teu_qty + brog_feu_rt*brog_feu_qty + brog_rf_rt*brog_reu_qty;
					actCommAmt = (Double.parseDouble(bkgQtyInfo.getBkgBxQty()) * Double.parseDouble(ffAGMTRateInfo.getFfBxAmt()) +
							Double.parseDouble(bkgQtyInfo.getBkgTeuQty()) * Double.parseDouble(ffAGMTRateInfo.getFfTeuAmt()) +
							Double.parseDouble(bkgQtyInfo.getBkgFeuQty()) * Double.parseDouble(ffAGMTRateInfo.getFfFeuAmt()) +
							Double.parseDouble(bkgQtyInfo.getBkgRfQty()) * Double.parseDouble(ffAGMTRateInfo.getFfRfAmt()));
					actCommAmt = dbDao.searchRoundValue(actCommAmt);
				}

				if(ffAGMTRateInfo.getFfDivCd().length() > 0){
					BkgInfolist.setFfDivCd1(ffAGMTRateInfo.getFfDivCd().substring(0, 1));
				}
				// 계산된 값을 넣는다.
				BkgInfolist.setActCommAmt(actCommAmt+"");

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
//				if(checkFFError( BkgInfolist )) {
//					return;
//				}

				// 안지워진 것 대비... ACM_FF_CMPN_REV,	ACM_FF_CMPN_DTL, ACM_FF_CMPN
				this.removeFFCommNotIF(BkgInfolist);

				// F/F Code 가 IF 후 변경 시 상계 위한 로직 CHM-201114163 brokerage 시스템 로직 보완
				BkgInfoTmp = dbDao.searchOldIfCommFFCode(BkgInfolist);

				// 현재와 다른 FF code 로 I/F 된 내역이 있다면 ...
				if(BkgInfoTmp.getOldFfCntCd() != null && BkgInfoTmp.getOldFfSeq() != null && BkgInfoTmp.getOldSumIfAmt() != null){
					//1. seq 구하기
					BkgInfolist.setNewFfCmpnSeq(dbDao.searchNewFFSeq(bkgNo));
					//2. insert 하기.
					dbDao.addFFCommIF(BkgInfolist);
					// FF Commission Detail을 저장한다.
					if("B".equals(BkgInfolist.getFfDivCd1())) { // BL인 경우
						iCount = dbDao.addFFCommDtailIFB(BkgInfolist);

						// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
						if(iCount < 1) {
							BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00037").getUserMessage()); // Brokerage Type Size Distribution from B/L Commission Error!
							modifyFFErrorMSG(BkgInfolist);
							return;
						}

					}else{
						iCount = dbDao.addFFCommDtailIFC(BkgInfolist);

						// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
						if(iCount < 1) {
							BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00038").getUserMessage()); // Brokerage Type Size Distribution from Container Commission Error!
							modifyFFErrorMSG(BkgInfolist);
							return;
						}
					}
					if("BA".equals(ffAGMTRateInfo.getFfDivCd())) {
						dbDao.addFFCommChgDetailIFBA(BkgInfolist);
					}else if("BF".equals(ffAGMTRateInfo.getFfDivCd())) {
						dbDao.addFFCommChgDetailIFBF(BkgInfolist);
					}else if("BS".equals(ffAGMTRateInfo.getFfDivCd())) {
//						dbDao.addFFCommChgDetailIFBS(BkgInfolist, ffChgCtntDiv);
						dbDao.addFFCommChgDetailIFBS(BkgInfolist, ffAGMTRateInfo);
					} 
				}
			////------------////----------------------------------------------------------------------------------
				BkgInfolist.setNewFfCmpnSeq(dbDao.searchNewFFSeq(bkgNo));
				if(Integer.parseInt(BkgInfolist.getFfCmpnSeq()) < Integer.parseInt(BkgInfolist.getNewFfCmpnSeq())){
					BkgInfolist.setFfCmpnSeq(BkgInfolist.getNewFfCmpnSeq());
				}

				// 로직 상 현재 F/F 의 IF 금액 만이 act_pre_comm_amt 로 구해 진다. ( 과거 F/F 는 앞 단에서 상계 완료 한다. )
				String ppdAmt = dbDao.searchFFMasterPPDAmt(bkgNo);

				// dAct_if_comm_amt == 0이면 return한다.
				if(!(Double.parseDouble(BkgInfolist.getActCommAmt()) - Double.parseDouble(ppdAmt) != 0)) { // 부동소수점의 == 사용은 지양한다.
					BkgInfolist.setFfCmpnRmk("ACT_IF_COMM_AMT");
					return ;
				}

				//setActCommAmt
				// FF Commission을 저장한다.
				ffAGMTRateInfo.setFfCntCd(BkgInfolist.getFfCntCd());
				//ffAGMTRateInfo.setFfSeq(BkgInfolist..getFfCntCd());
				dbDao.addFFCommMaster(BkgInfolist, RevLanebndInfo, SADateTSA, cntInfo, ffAGMTRateInfo, bkgQtyInfo);

				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}
			}

				// FF Commission Detail을 저장한다.
				if("B".equals(BkgInfolist.getFfDivCd1())) { // BL인 경우
					iCount = dbDao.addFFCommDtailB(BkgInfolist);
					// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
					if(iCount == 0) {
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00037").getUserMessage()); // Brokerage Type Size Distribution from B/L Commission Error!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
				}else{
					iCount = dbDao.addFFCommDtailC(BkgInfolist);
					// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
					if(iCount == 0) {
						BkgInfolist.setFfCmpnRmk(new ErrorHandler("ACM00038").getUserMessage()); // Brokerage Type Size Distribution from Container Commission Error!
						modifyFFErrorMSG(BkgInfolist);
						return;
					}
				}
				if("BA".equals(ffAGMTRateInfo.getFfDivCd())) {
					dbDao.addFFCommChgDetailBA(BkgInfolist);
				}else if("BF".equals(ffAGMTRateInfo.getFfDivCd())) {
					dbDao.addFFCommChgDetailBF(BkgInfolist);
				}else if("BS".equals(ffAGMTRateInfo.getFfDivCd())) {
//					dbDao.addFFCommChgDetailBS(BkgInfolist, ffChgCtntDiv);
					dbDao.addFFCommChgDetailBS(BkgInfolist, ffAGMTRateInfo);
				}
				// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
				if(checkFFError( BkgInfolist )) {
					return;
				}
				// cust_nm을 bkg_bkg_cust의 cust_nm과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
				String custNm = dbDao.searchFFCustNameCheck(BkgInfolist);
				if(custNm == null || ("").equals(custNm)){
					dbDao.modifyFFCommDetail(BkgInfolist);
				}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return boolean
	 */
	public boolean checkError(SearchFFBookingInfoVO searchFFBookingInfoVO) {

		if(searchFFBookingInfoVO.getCommProcRsltRsn() != null && !"".equals(searchFFBookingInfoVO.getCommProcRsltRsn()) ) {
			return true;
		}
		return false;
	}

	/**
	 * Error 유무를 체크하여 리턴한다.<br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return boolean
	 */
	public boolean checkFFError(SearchFFBookingInfoVO searchFFBookingInfoVO) {

		if (searchFFBookingInfoVO.getFfCmpnRmk() != null && !"".equals(searchFFBookingInfoVO.getFfCmpnRmk())) {
			return true;
		}
		return false;
	}

	/**
	 * FF Cancel 처리한다.<br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception EventException
	 */
	public void processFFCancel(SearchFFBookingInfoVO searchFFBookingInfoVO) throws EventException{
		String cancelFF = "";
		String errMsg = "";
		String ff = "";
		String bkgNo = searchFFBookingInfoVO.getBkgNo();
		try {
			// FF Sequence를 구한다.
			String ffSeq = dbDao.searchFFSeq(bkgNo);

			if("1".equals(ffSeq)){
				cancelFF = "C";
			}
			searchFFBookingInfoVO.setFfCmpnSeq(ffSeq);

			// Interface가 안 된 데이타가 존재하는지 조회한다.
			ff = dbDao.searchFFDataCheck(bkgNo, ffSeq);
			//log.debug("/n ffSeq + ff==>" + BkgInfolist.getFfCmpnSeq() + " / " + ff);

			if(!"".equals(ff)){

				dbDao.removeFFChgDetail(bkgNo, ffSeq);

				dbDao.removeFFDetail(bkgNo, ffSeq);

				dbDao.removeFFMaster(bkgNo, ffSeq);

			}
			errMsg = dbDao.checkNull(cancelFF);
			if(!errMsg.equals("")){
				return;
			}

			//Cancel amt를 구해온다.
			searchFFBKGCancelInfo(searchFFBookingInfoVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FF Cancel 처리한다.<br>
	 *
	 * @param SearchFFBookingInfoVO BkgInfolist
	 * @exception EventException
	 */
	public void searchFFBKGCancelInfo(SearchFFBookingInfoVO BkgInfolist) throws EventException{
		String ff = "";
		String bkgNo = BkgInfolist.getBkgNo();
		//String ffCmpnSeq = BkgInfolist.getFfCmpnSeq();
		String ffCmpnCancelSeq = (Integer.parseInt(BkgInfolist.getFfCmpnSeq())-1)+"";

		try {

			// Error Message를 체크하여 Error Message가 존재할 경우 return 한다.
			if(checkError( BkgInfolist )) {
				if ("B".equals(BkgInfolist.getCoveredCheck())){
					BkgInfolist.setCommProcRsltRsn("Co-Biz B/L! Interfaced commission amount will be duddcted.");
				}else if ("C".equals(BkgInfolist.getCoveredCheck())){
					BkgInfolist.setCommProcRsltRsn("Covered B/L! Interfaced commission amount will be duddcted.");
				}else{
					BkgInfolist.setCommProcRsltRsn("Booking No has cancelled!");// 확인
				}
				return;
			}
			ff = dbDao.searchFFCancelDataCheck(bkgNo, ffCmpnCancelSeq);

			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다. -------start-------
			// cancel된 데이타가 존재하지 않으면 ACM_FF_CMPN_REV,	ACM_FF_CMPN_DTL, ACM_FF_CMPN를 삭제한다.
			if(!"".equals(ff)){
				dbDao.addFFCommMasterCancelIF(bkgNo, ffCmpnCancelSeq, BkgInfolist.getCommProcRsltRsn());

			} else {
				dbDao.removeFFChgDetail(bkgNo, ffCmpnCancelSeq);

				dbDao.removeFFDetail(bkgNo, ffCmpnCancelSeq);

				dbDao.removeFFMaster(bkgNo, ffCmpnCancelSeq);

			}
			return;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * FF Cancel 처리한다.<br>
	 *
	 * @param SearchFFBookingInfoVO BkgInfolist
	 * @exception EventException
	 */
	public void modifyFFErrorMSG(SearchFFBookingInfoVO BkgInfolist) throws EventException{

		try {

				dbDao.modifyFFMasterEMSG(BkgInfolist);

				dbDao.modifyFFMasterEMSGU(BkgInfolist);

				dbDao.modifyFFDetailEMSG(BkgInfolist);


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * FF Cancel 처리한다.<br>
	 *
	 * @param SearchFFBookingInfoVO BkgInfolist
	 * @exception EventException
	 */
	public void removeFFCommNotIF(SearchFFBookingInfoVO BkgInfolist) throws EventException{

		try {

			dbDao.removeFFChgDetailNotIF(BkgInfolist.getBkgNo());

			dbDao.removeFFDetailNotIF(BkgInfolist.getBkgNo());

			dbDao.removeFFMasterNotIF(BkgInfolist.getBkgNo());

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}