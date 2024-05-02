/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueBCImpl.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
* 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
* 2010.11.30 김영철 [CHM-201006575-01] e-BKG & SI TRO 업데이트 로직 변경
* 2011.02.21 이일민 [CHM-201108826] [BKG/DOC] TRO M/H 에 대한 Return / Pick up CY 란에 대해 Validation 추가 요청
* 2011.10.27 윤태승 [CHM-201113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
* 2011.12.09 금병주 [CHM-201114805-01] [BKG] 구주 TRO M/H 상 CNTR 중복 confirm 에 대한 Validation 추가 요청
* 2011.12.14 금병주 [CHM-201115076-01] [BKG] 구주 TRO data 오류 검토요청
* 2012.06.18 조정민 [CHM-201217472] [BKG] BKG/DOC Validation Rule 정리 요청
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2014.02.07 문동선 [CHM-201428756] TROI notice 화면상 CNTR 선택기능 및 글자굵기 수정요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration.TransferOrderIssueDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroXterIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.DgSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.QtyInfoForTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.ValidateInlandRouteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgEurTroDgSeqVO;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmYardVO;





/**
 * ALPS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-GeneralBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0079_02CEventResponse,TransferOrderIssueBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TransferOrderIssueBCImpl extends BasicCommandSupport implements TransferOrderIssueBC {

	// Database Access Object
	private transient TransferOrderIssueDBDAO dbDao = null;

	/**
	 * TransferOrderIssueBCImpl 객체 생성<br>
	 * ${DAO}DAO를 생성한다.<br>
	 */
	public TransferOrderIssueBCImpl() {
		dbDao = new TransferOrderIssueDBDAO();
	}

	/**
	 * (ESM_BKG_0079_02A) 구주 Tro 관련 조회처리<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String rtnTroFlg
	 * @param     SignOnUserAccount account
	 * @return    TroVO
	 * @exception EventException
	 */
	public TroVO searchTro(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, SignOnUserAccount account) throws EventException {
		BookingUtil command = new BookingUtil();
		
		try {
			//ContainerVO
			TroVO troVO = new TroVO();
			String troSeq = "";  //첫번째 troSeq 값

			//----------------------------
			//1) 상단 : Booking 정보
			BkgInfoForTroVO bkgInfoForTroVO = dbDao.searchBkgForTro(bkgBlNoVO, boundCd);
			troVO.setBkgInfoForTroVO(bkgInfoForTroVO);

			//bl_no로 조회시, 조회된 bkg_no를 조회항목으로 setting
			if ("".equals(JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()))) {
				bkgBlNoVO.setBkgNo(bkgInfoForTroVO.getBkgNo());
			}

			// 01. searchBkgBlNoVO
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			BkgBlNoVO schBkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);			
			troVO.setBkgBlNoVO(schBkgBlNoVO);
			
			//----------------------------
			//2) Multi Combo 선택대상 목록
			String dgSeq  = bkgInfoForTroVO.getDcgoFlg();
			String rfSeq  = bkgInfoForTroVO.getRcFlg();
			String awkSeq = bkgInfoForTroVO.getAwkCgoFlg();

			if ("Y".equals(dgSeq)) {
				List<DgSeqVO> dgSeqVOs = dbDao.searchDgSeq(bkgBlNoVO);
		        troVO.setDgSeqVOs(dgSeqVOs);
			}
			if ("Y".equals(rfSeq)) {
				List<RfSeqVO> rfSeqVOs = dbDao.searchRfSeq(bkgBlNoVO);
		        troVO.setRfSeqVOs(rfSeqVOs);
			}
			if ("Y".equals(awkSeq)) {
				List<AwkSeqVO> awkSeqVOs = dbDao.searchAwkSeq(bkgBlNoVO);
		        troVO.setAwkSeqVOs(awkSeqVOs);
			}

			//----------------------------
			//3) Master Grid: TRO 정보
			List<TroMstVO> bkgTroVOs = dbDao.searchTro(bkgBlNoVO, rtnTroFlg, boundCd);
			troVO.setBkgTroVOs(bkgTroVOs);

			//----------------------------
			//예외처리 -2) Tro-master : tro 정보  존재하지 않을 시, 체크메세지 처리
			if (bkgTroVOs.size() > 0) {
				//Tro master 목록의 첫번째 troseq를 얻어서, dtl 조회용 param으로 넘김
				troSeq = bkgTroVOs.get(0).getTroSeq();
			}

			//----------------------------
			//4) Detail Grid: TRODTL 정보
			List<TroDtlVO> troDtlVOs = dbDao.searchTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, account.getUsr_id());
			troVO.setTroDtlVOs(troDtlVOs);

			//----------------------------
			//5) Tro별 선택된 spclCgoSeq 정보
		    List<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs = dbDao.searchTroSpclCgoSeq(bkgBlNoVO, troSeq);
		    troVO.setBkgTroSpclCgoSeqVOs(bkgTroSpclCgoSeqVOs);

			//----------------------------
			//6) 우측상단 : Sum 정보
		    List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, boundCd);
		    troVO.setQtyInfoForTroVOs(qtyInfoForTroVOs);

		    String strPorCd = "";
            if (bkgInfoForTroVO != null) {
            	strPorCd = JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd());
            }            
            if ( strPorCd.length() >= 2 && "KR".equals(strPorCd.substring(0, 2)) ) {
		    	String rtnTroFlgRtn = "Y";  //2차 call

				//----------------------------
				//3-2) Master Grid: TRO 정보
		    	List<TroMstVO> bkgTroVOsrtn = dbDao.searchTro(bkgBlNoVO, rtnTroFlgRtn, boundCd);
				troVO.setBkgTroVOsrtn(bkgTroVOsrtn);

				//----------------------------
				//예외처리 -2) Tro-master : tro 정보  존재하지 않을 시, 체크메세지 처리
				if (bkgTroVOsrtn.size() > 0) {
					//Tro master 목록의 첫번째 troseq를 얻어서, dtl 조회용 param으로 넘김
					troSeq = bkgTroVOsrtn.get(0).getTroSeq();
				}

				//----------------------------
				//4-2) Detail Grid: TRODTL 정보
				List<TroDtlVO> troDtlVOsrtn = dbDao.searchTroDtl(bkgBlNoVO, boundCd, rtnTroFlgRtn, troSeq, account.getUsr_id());
				troVO.setTroDtlVOsrtn(troDtlVOsrtn);
            }
            
            //추가. 
            String[] arrCntr = command.searchCntrListByBkg(bkgBlNoVO);
            troVO.setArrCntr(arrCntr); 

			return troVO; 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0079_02C) 구주 Tro 관련 조회처리<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     SignOnUserAccount account
	 * @return    EurTroVO
	 * @exception EventException
	 */
	public EurTroVO searchEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException {
		BookingUtil command = new BookingUtil();
		
		try {
			//ContainerVO 
			EurTroVO troVO  = new EurTroVO(); 
			String   troSeq = "";  //첫번째 troSeq 값
			
			//----------------------------
			//1) 상단 : Booking 정보 
			BkgInfoForTroVO bkgInfoForTroVO = dbDao.searchBkgForTro(bkgBlNoVO, boundCd);
			troVO.setBkgInfoForTroVO(bkgInfoForTroVO); 

			//bl_no로 조회시, 조회된 bkg_no를 조회항목으로 setting
			if ("".equals(JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()))) {
				bkgBlNoVO.setBkgNo(bkgInfoForTroVO.getBkgNo());
			}
			
			// 01. searchBkgBlNoVO
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			BkgBlNoVO schBkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);			
			troVO.setBkgBlNoVO(schBkgBlNoVO);
			
			
			//----------------------------
			//2) Multi Combo 선택대상 목록 
			String dgSeq  = bkgInfoForTroVO.getDcgoFlg(); 
			String rfSeq  = bkgInfoForTroVO.getRcFlg(); 
			String awkSeq = bkgInfoForTroVO.getAwkCgoFlg(); 
			
			if ("Y".equals(dgSeq)) {
				List<DgSeqVO> dgSeqVOs = dbDao.searchDgSeq(bkgBlNoVO);
		        troVO.setDgSeqVOs(dgSeqVOs);
			}
			if ("Y".equals(rfSeq)) {
				List<RfSeqVO> rfSeqVOs = dbDao.searchRfSeq(bkgBlNoVO);
		        troVO.setRfSeqVOs(rfSeqVOs);
			}
			if ("Y".equals(awkSeq)) {
				List<AwkSeqVO> awkSeqVOs = dbDao.searchAwkSeq(bkgBlNoVO);
		        troVO.setAwkSeqVOs(awkSeqVOs);
			} 

			//----------------------------
			//3) Master Grid: TRO 정보 
			List<EurTroMstVO> eurTroMstVOs = dbDao.searchEurTro(bkgBlNoVO, "", boundCd);  //null : tro_seq
			troVO.setEurTroMstVOs(eurTroMstVOs); 

			//----------------------------
			//예외처리 -2) Tro-master : tro 정보  존재하지 않을 시, 체크메세지 처리 
			if (eurTroMstVOs.size() > 0) {
				//Tro master 목록의 첫번째 troseq를 얻어서, dtl 조회용 param으로 넘김 
				troSeq = eurTroMstVOs.get(0).getTroSeq(); 
			} 

			//----------------------------
			//4) Detail Grid: TRODTL 정보 
			List<EurTroDtlVO> troDtlVOs = dbDao.searchEurTroDtl(bkgBlNoVO, boundCd, troSeq, account.getUsr_id()); 
			troVO.setEurTroDtlVOs(troDtlVOs); 

			//----------------------------
			//5) Tro별 선택된 spclCgoSeq 정보 
		    List<BkgEurTroDgSeqVO> bkgEurTroDgSeqVOs = dbDao.searchEurTroDgSeq(bkgBlNoVO, troSeq, boundCd);  
		    troVO.setBkgEurTroDgSeqVOs(bkgEurTroDgSeqVOs); 

			//----------------------------
			//6) 우측상단 : Sum 정보
		    List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, boundCd);
		    troVO.setQtyInfoForTroVOs(qtyInfoForTroVOs);
		    
			//----------------------------
			//7) container 정보 
		    List<BkgComboVO> bkgComboVOs = dbDao.searchEurTroCntr(bkgBlNoVO);  
		    troVO.setBkgComboVOs(bkgComboVOs); 
		    
			return troVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request 이벤트 처리 : ALPSBKG_UBIZHJS_HJTBKG MQ 호출<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @param     String modCd
	 * @param     String rtnTroFlg
	 * @param     String ownrTrkFlg
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTroEdi(BkgBlNoVO bkgBlNoVO, String troSeq, String modCd, String rtnTroFlg,String ownrTrkFlg, SignOnUserAccount account) throws EventException {
		
		try {
			BookingUtil command = new BookingUtil();

		
			//StringBuffer flatFile1 = new StringBuffer();
			//StringBuffer flatFile2 = new StringBuffer();	
			//String queueName = null;
			//int nSize = 0;
//log.debug("rtnTroFlg:"+rtnTroFlg+"::"+ownrTrkFlg);
			//"Y".equals(rtnTroFlg)


            // by 2010.3.2 신자영 S/TRK 체크 안된경우 둘다 전송 
            if ("N".equals(rtnTroFlg)||("Y".equals(rtnTroFlg)&&"N".equals(ownrTrkFlg))) {
            	StringBuffer flatFile = new StringBuffer();		
    			StringBuffer flatFile1 = new StringBuffer();
    			StringBuffer flatFile2 = new StringBuffer();	
    			String queueName = null;
    			int nSize = 0;
            	if (!"DEL".equals(modCd)) {
            		String strReturn_sts = dbDao.searchTroStatus(bkgBlNoVO, troSeq);
            		if ("X".equals(strReturn_sts)) {
            			modCd = "DEL";
            		} else {
        			    String tStrReturn = dbDao.searchTroIfModify(bkgBlNoVO, troSeq);
        			    if ("".equals(strReturn_sts)) {
        			    	modCd = "ADD";
        			    }
        			    modCd = tStrReturn;
            		}
            	}
 
            	//1) master
            	flatFile1.append(dbDao.searchTroEdiMain(bkgBlNoVO, troSeq, modCd, rtnTroFlg));
            	int size = flatFile1.length();
            	log.debug("\n ################################ + EDI size " + size );
            	if (size < 320){
            		throw new EventException(new ErrorHandler("BKG08175").getMessage());          		
            	}
            	

            	//2) dtl 
            	List<String> list = dbDao.searchTroEdiDtl(bkgBlNoVO, troSeq, rtnTroFlg);
            	nSize = list.size();
            	for(int i=0; i<nSize; i++) {
            	    //flatFile2.append(list.get(1));
            		flatFile2.append(list.get(i));
            	}

	        	//2-2) dtl-Dummy
            	StringBuffer flatFile2Dummy = new StringBuffer();
	        	if (nSize < 9) {
	        		int nDummySize = 9 - nSize;
	        		for (int i=0; i<nDummySize; i++) {
	        			flatFile2Dummy.append("                                          ");  //42자리 blank 추가
	        		}
	        	}

	        	//3) etc
	        	String strReturn3 = dbDao.searchTroEdiEtc(bkgBlNoVO, troSeq, rtnTroFlg);

	        	//*) all concat
	        	String strTail = "            ";  //공백12개
	        	flatFile.append(flatFile1.toString());
	        	flatFile.append(flatFile2.toString());
	        	flatFile.append(flatFile2Dummy.toString());
	        	flatFile.append(strTail);
	        	flatFile.append(strReturn3);
	        	flatFile.append("\r\n");
	        	log.debug("\n#####flatfile[general]-->"+flatFile.toString());
	            queueName = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_HJTBKG.IBMMQ.QUEUE");
	            
	            

    			//2) str_flatfile 전송       
    			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
    			
    			sendFlatFileVO.setQueueNm (queueName);
    			sendFlatFileVO.setFlatFile(flatFile.toString());
    			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
    			
    			if ( "E".equals(flatFileAckVO.getAckStsCd()) ) {
    				throw new EventException(new ErrorHandler("BKG00205").getMessage());
    			}
    			
            }           
            if ("Y".equals(rtnTroFlg)) {
    			StringBuffer flatFile  = new StringBuffer();		
    			StringBuffer flatFile1 = new StringBuffer();
    			StringBuffer flatFile2 = new StringBuffer();	
    			String queueName = null;
    			int nSize = 0;
            	//1) header
            	String sndrId = "SMLMM010";
                String rcvId  = "KTNETPCS";
                String msgId  = "COREOR";
                String strReturnHeader = command.searchEdiHeader(sndrId, rcvId, msgId) + "\n";
                
                //header에 I/F seq에  BKG을'KOR'로 변경 
                strReturnHeader =strReturnHeader.substring(0, 62)+"KOR"+strReturnHeader.substring(65);
            	//2) master
                flatFile1.append(dbDao.searchRtnTroEdiMain(bkgBlNoVO, troSeq, rtnTroFlg));

            	//3) dtl
            	List<String> list = dbDao.searchRtnTroEdiCntr(bkgBlNoVO, troSeq, rtnTroFlg);
            	nSize = list.size();
            	for(int i=0; i<nSize; i++) {
            	    //String strFlatFile = list.get(1);
            	    flatFile2.append(list.get(i));
            	}

            	//*) all concat
            	flatFile.append(strReturnHeader);
            	flatFile.append(flatFile1.toString());
            	flatFile.append(flatFile2.toString());
            	flatFile.append("\r\n");
            	log.debug("\n#####flatfile[rtn]-->"+flatFile.toString());
                queueName = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR.IBMMQ.QUEUE");
                

    			//2) str_flatfile 전송       
    			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
    			
    			sendFlatFileVO.setQueueNm (queueName);
    			sendFlatFileVO.setFlatFile(flatFile.toString());
    			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
    			
    			if ( "E".equals(flatFileAckVO.getAckStsCd()) ) {
    				throw new EventException(new ErrorHandler("BKG00205").getMessage());
    			}
            } 
            

            

			//3) BkgTroRqst 갱신
			dbDao.modifyBkgTroRqst(bkgBlNoVO, troSeq, rtnTroFlg, account);

			//return flatFile.toString();

		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request 완료여부 수정처리<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgTroRqst(BkgBlNoVO bkgBlNoVO, String troSeq, String rtnTroFlg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyBkgTroRqst(bkgBlNoVO, troSeq, rtnTroFlg, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02B) [KR]Tro Request Receive 저장처리<br>
	 * @author    Lee NamKyung
	 * @param     String flatfile
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiptHjtTroEdiAck(String flatfile, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil util = new BookingUtil();
			BkgTroXterIfVO bkgTroXterIfVO = new BkgTroXterIfVO();
/*
			//flatfile.substring(1, 9);     //-> 사용안함 : 1
			String ackStsCd   = flatfile.substring(8, 9);   //-> ack_sts_cd : 68+
			String ifDt       = flatfile.substring(10, 22);   //-> if_dt (yymmddhh24mi) : 85
			String bkgNo      = flatfile.substring(23, 36);   //-> bkg_no :
			String troSeq     = flatfile.substring(36, 38);   //-> tro_seq : 68
			String ordNo      = flatfile.substring(48, 59);   //-> ord_no : 95
			String rqstOrdMsg = flatfile.substring(59, 259);  //-> rqst_ord_msg : 106
 */
/* example
 INTEDITROACK1003241522KORX3245403  01          00324457200OK.. ORDER CREATE                     
 INTEDITRONAK1003251444SEL002354100 01                     NOT CREATE(V.V.D Not Found!!!) 
 */
/* 라이브 현재 edi ack 예시
 * 										   123456789012|3456789012|3456789012345|678901234567890123456789012345678901234567890
inthjs_rcv.log:102/02/05 14:46:17 tonisbuf[INTEDITROACK|0202051445|KOR22050249  |01          02020572400OK.. TRO CREATED...
.
                                                             ]
 */
	
			//flatfile.substring(1, 9);     //-> 사용안함 : 1
			String ackStsCd   = flatfile.substring(9, 10).trim();   //-> 수정 ack_sts_cd : 68+
			String ifDt       = flatfile.substring(12, 22).trim();   //->  수정 if_dt (yymmddhh24mi) : 85
			String bkgNo      = flatfile.substring(22, 35).trim();   //->  수정 bkg_no :
			String troSeq     = flatfile.substring(35, 37).trim();   //-> 수정 tro_seq : 68
			String ordNo      = flatfile.substring(47, 58).trim();   //-> ord_no : 95
			
			if(!util.isNumberChk(troSeq)){
				throw new EventException(new ErrorHandler("BKG06012", new String[]{"TRO SEQ"}).getMessage());
			}
			log.debug("ifDt:"+ifDt+".");
			log.debug("ackStsCd:"+ackStsCd+".");
			log.debug("bkgNo:"+bkgNo+".");
			log.debug("troSeq:"+troSeq+".");
			log.debug("ordNo:"+ordNo+".");
			int length;
			length = flatfile.length();
			
			//if(length < 259){
				length = flatfile.length();
			//}
			//else{
			//	length = 259;
			//}
		    // message길이 만큼 모두 잡도록 변경
			String rqstOrdMsg = flatfile.substring(58, length);  //-> rqst_ord_msg : 106
			log.debug("rqstOrdMsg:"+rqstOrdMsg+".");

			bkgTroXterIfVO.setAckStsCd(ackStsCd);
			bkgTroXterIfVO.setIfDt(ifDt);
			bkgTroXterIfVO.setBkgNo(bkgNo);
			bkgTroXterIfVO.setTroSeq(troSeq);
			bkgTroXterIfVO.setOrdNo(ordNo);
			bkgTroXterIfVO.setRqstOrdMsg(rqstOrdMsg);
			//bkgTroXterIfVO.setCreUsrId(account.getUsr_id());
			//bkgTroXterIfVO.setUpdUsrId(account.getUsr_id());

			dbDao.receiptHjtTroEdiAck(bkgTroXterIfVO);

			if ("A".equals(ackStsCd) && ordNo.length() > 0) {
				//BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				log.debug("bkgNo:"+bkgNo+".");
				log.debug("troSeq:"+troSeq+".");
				dbDao.modifyBkgTroAfterAck(bkgNo, troSeq);
			}
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}



	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0079_02A) 미주 Tro 관련 저장처리<br>
	 * @author    Lee NamKyung
	 * @param     TroVO troVO
	 * @param     account SignOnUserAccount
	 * @return    Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTro(TroVO troVO, SignOnUserAccount account) throws EventException{
		try {
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(troVO.getBkgNo());

			//(containerVO)
			String delFlg = troVO.getDelFlg(); 
			
			TroMstVO[]           arrTroMstVO           = null;
			TroDtlVO[]           arrTroDtlVO           = null;
			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = null;		
			arrTroMstVO           = troVO.getArrTroMstVO();
			arrTroDtlVO           = troVO.getArrTroDtlVO();
			arrBkgTroSpclCgoSeqVO = troVO.getArrBkgTroSpclCgoSeqVO();
			
			//1) general
			if (arrTroMstVO != null) {
				for ( int i=0; i<arrTroMstVO.length; i++ ) {
					arrTroMstVO[i].setCreUsrId(account.getUsr_id());
					arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
					if(arrTroMstVO[i].getTroSeq() == null
							|| arrTroMstVO[i].getTroSeq().length() < 1){
						throw new EventException(new ErrorHandler("BKG06012", new String[]{"tro seq"}).getMessage());
					}
						
					if(dbDao.modifyBkgTro(arrTroMstVO[i]) < 1){
						dbDao.addBkgTro(arrTroMstVO[i]);								
					} else if ("Y".equals(arrTroMstVO[i].getCxlFlg()) 
								&& "N".equals(arrTroMstVO[i].getCxlFlgOld())) {  //신규 cancel된건만 cancel처리.
						String boundCd   = arrTroMstVO[i].getIoBndCd();
						String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
						String troSeq    = arrTroMstVO[i].getTroSeq();
						String updUsrId  = account.getUsr_id();
						dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
					}
				}
			}

			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					String cntrNo = arrTroDtlVO[i].getCntrNo();
					
					//mst check 
					String strCfmFlg_mst    = "";
					String strCfmFlgOld_mst = "";
					if (arrTroMstVO != null) {
						
						for (int p=0; p<arrTroMstVO.length; p++) {
							if (arrTroDtlVO[i].getTroSeq().equals(arrTroMstVO[p].getTroSeq())) {
								strCfmFlg_mst    = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlg(),    "N");
								strCfmFlgOld_mst = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlgOld(), "N");
								break;
							}
						}
					}

					//--------------------------------
					//1) 체크 처리 
					if ( !"Y".equals(arrTroDtlVO[i].getCxlFlg()) &&                    //cancel 된건이 아니면서, 
					     ("Y".equals(strCfmFlg_mst) && "N".equals(strCfmFlgOld_mst))) {  //신규 confirm된 건만 check 수행 
						if (cntrNo.length() == 14) {
							//1-1) Booking Container 존재여부 체크
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}

							//1-2) Return용  메세지구분자  조회
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							} else if ("S".equals(resultMsgFlag)) {
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}
					}

					//--------------------------------
					//2) I/U/Cancel 처리
					arrTroDtlVO[i].setCreUsrId(account.getUsr_id());
					arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
					if(dbDao.modifyBkgTroDtl(arrTroDtlVO[i])<1){
						dbDao.addBkgTroDtl(arrTroDtlVO[i]);
					} else if ("Y".equals(arrTroDtlVO[i].getCxlFlg()) && "N".equals(arrTroDtlVO[i].getCxlFlgOld())){  
						//신규 cancel된건만 cancel처리. 
						String boundCd   = arrTroDtlVO[i].getIoBndCd();
						String rtnTroFlg = arrTroDtlVO[i].getRtnTroFlg();
						String troSeq    = arrTroDtlVO[i].getTroSeq();
						String troSubSeq = arrTroDtlVO[i].getTroSubSeq();
						String updUsrId  = account.getUsr_id();
						dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);
					}
				}
			}

			if (arrBkgTroSpclCgoSeqVO != null){
				String boundCd    = arrBkgTroSpclCgoSeqVO[0].getIoBndCd();
				String rtnTroFlg  = arrBkgTroSpclCgoSeqVO[0].getRtnTroFlg();
				String troSeq     = arrBkgTroSpclCgoSeqVO[0].getTroSeq();
				
				//1) 삭제 처리
				if ("C".equals(delFlg)) {
					dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, boundCd, rtnTroFlg, troSeq);	
				} else {
					dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, boundCd, rtnTroFlg, "");	
				}				

				//--------------------------------
				//1) 저장(I) 처리
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++){
					if ("I".equals(arrBkgTroSpclCgoSeqVO[i].getIbflag())){
						arrBkgTroSpclCgoSeqVO[i].setCreUsrId(account.getUsr_id());
						arrBkgTroSpclCgoSeqVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroSpclCgoSeq(arrBkgTroSpclCgoSeqVO[i]);
					}
				}
			}

			//=============================
			// QTY 조회후, 갱신 처리

			List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, troVO.getIoBndCd());

			BkgQuantityVO[] arrBkgQuantityVO = new BkgQuantityVO[qtyInfoForTroVOs.size()];
			int nCnt = 0;
			for (Iterator<QtyInfoForTroVO> iter = qtyInfoForTroVOs.iterator(); iter.hasNext(); )
			{
				QtyInfoForTroVO qtyInfoForTroVO = iter.next();

				String cntrTpszCd = qtyInfoForTroVO.getCntrTpszCd();
				String troQty     = qtyInfoForTroVO.getTroQty();

				BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
				bkgQuantityVO.setIbflag    ("U");
				bkgQuantityVO.setBkgNo     (bkgBlNoVO.getBkgNo());
				bkgQuantityVO.setCntrTpszCd(cntrTpszCd);
				if ("O".equals(troVO.getIoBndCd())) {
				    bkgQuantityVO.setObTroQty(troQty);
				} else if ("I".equals(troVO.getIoBndCd())) {
					bkgQuantityVO.setIbTroQty(troQty);
				}
				arrBkgQuantityVO[nCnt++] = bkgQuantityVO;
			}
			responseData.put(WebKeys.ER_DBROWSETS, arrBkgQuantityVO);

			return responseData;

		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0079_02B) 한국 Tro 관련 저장처리<br>
	 * @author    Lee NamKyung
	 * @param     TroVO troVO
	 * @param     account SignOnUserAccount
	 * @return    Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageKrTro(TroVO troVO, SignOnUserAccount account) throws EventException{
		try
		{
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			String delFlg = troVO.getDelFlg(); 
			
			TroMstVO[]           arrTroMstVO           = null;
			TroDtlVO[]           arrTroDtlVO           = null;
			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = null;
			TroMstVO[]           arrTroMstVOrtn        = null;
			TroDtlVO[]           arrTroDtlVOrtn        = null;			
			arrTroMstVO           = troVO.getArrTroMstVO();
			arrTroDtlVO           = troVO.getArrTroDtlVO();
			arrBkgTroSpclCgoSeqVO = troVO.getArrBkgTroSpclCgoSeqVO();
			arrTroMstVOrtn        = troVO.getArrTroMstVOrtn();
			arrTroDtlVOrtn        = troVO.getArrTroDtlVOrtn();

			//1) general
			if (arrTroMstVO != null) {
				for ( int i=0; i<arrTroMstVO.length; i++ ) {
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroMstVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

/* 
					if ( !("U".equals(arrTroMstVO[i].getIbflag()) || "I".equals(arrTroMstVO[i].getIbflag())) ) {
						continue; 
					} 
*/ 
					
					//----------------------------------
					//1) (cxl_flag = 'Y' : 취소)/I/U 처리 

					arrTroMstVO[i].setCreUsrId(account.getUsr_id());
					arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
					if ("U".equals(arrTroMstVO[i].getIbflag())){
						if ("Y".equals(arrTroMstVO[i].getCxlFlg()) 
								&& "N".equals(arrTroMstVO[i].getCxlFlgOld())) {  //신규 cancel된건만 cancel처리.
							String boundCd   = arrTroMstVO[i].getIoBndCd();
							String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
							String troSeq    = arrTroMstVO[i].getTroSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
						} else {
							if(dbDao.modifyBkgTro(arrTroMstVO[i]) < 1){
								dbDao.addBkgTro(arrTroMstVO[i]);								
							}
						}
					} else if ("I".equals(arrTroMstVO[i].getIbflag())){
						dbDao.addBkgTro(arrTroMstVO[i]);		
					}
				}
			}

			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					String cntrNo = arrTroDtlVO[i].getCntrNo();
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroDtlVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					if ( !("U".equals(arrTroDtlVO[i].getIbflag()) || "I".equals(arrTroDtlVO[i].getIbflag())) ) {
						continue;
					} 
					
					//mst check 
					String strCfmFlg_mst    = "";
					String strCfmFlgOld_mst = "";
					if (arrTroMstVO != null) {
						
						for (int p=0; p<arrTroMstVO.length; p++) {
							if (arrTroDtlVO[i].getTroSeq().equals(arrTroMstVO[p].getTroSeq())) {
								strCfmFlg_mst    = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlg(),    "N");
								strCfmFlgOld_mst = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlgOld(), "N");
								break;
							}
						}
					}

					//--------------------------------
					//1) 체크 처리 
					if ( !"Y".equals(arrTroDtlVO[i].getCxlFlg()) &&                    //cancel 된건이 아니면서, 
					     ("Y".equals(strCfmFlg_mst) && "N".equals(strCfmFlgOld_mst))) {  //신규 confirm된 건만 check 수행 
						if (cntrNo.length() == 14) {
							//1-1) Booking Container 존재여부 체크
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}

							//1-2) Return용  메세지구분자  조회
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							} else if ("S".equals(resultMsgFlag)) {
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}
					}

					//--------------------------------
					//2) I/U/Cancel 처리
					arrTroDtlVO[i].setCreUsrId(account.getUsr_id());
					arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
					if ("U".equals(arrTroDtlVO[i].getIbflag())) {
						if ("Y".equals(arrTroDtlVO[i].getCxlFlg()) && "N".equals(arrTroDtlVO[i].getCxlFlgOld()))  //신규 cancel된건만 cancel처리. 
						{
							String boundCd   = arrTroDtlVO[i].getIoBndCd();
							String rtnTroFlg = arrTroDtlVO[i].getRtnTroFlg();
							String troSeq    = arrTroDtlVO[i].getTroSeq();
							String troSubSeq = arrTroDtlVO[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);
						} else {
							if(dbDao.modifyBkgTroDtl(arrTroDtlVO[i])<1){
								dbDao.addBkgTroDtl(arrTroDtlVO[i]);
							}
						}
					} else if ("I".equals(arrTroDtlVO[i].getIbflag())) {
						dbDao.addBkgTroDtl(arrTroDtlVO[i]);
					}
				}
			}

			if (arrBkgTroSpclCgoSeqVO != null){
				//=================================>
				//*) BkgBlNoVO setting
				String bkgNo      = arrBkgTroSpclCgoSeqVO[0].getBkgNo();
				String boundCd    = arrBkgTroSpclCgoSeqVO[0].getIoBndCd();
				String rtnTroFlg  = arrBkgTroSpclCgoSeqVO[0].getRtnTroFlg();
				String troSeq     = arrBkgTroSpclCgoSeqVO[0].getTroSeq();
				bkgBlNoVO.setBkgNo(bkgNo);
				//<=================================

				//--------------------------------
				//1) 삭제 처리
				if ("C".equals(delFlg)) {
					dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, boundCd, rtnTroFlg, troSeq);	
				} else {
					dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, boundCd, rtnTroFlg, "");	
				}				

				//--------------------------------
				//1) 저장(I) 처리
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++){
					if ("I".equals(arrBkgTroSpclCgoSeqVO[i].getIbflag())){
						arrBkgTroSpclCgoSeqVO[i].setCreUsrId(account.getUsr_id());
						arrBkgTroSpclCgoSeqVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroSpclCgoSeq(arrBkgTroSpclCgoSeqVO[i]);
					}
				}
			}

			//2) rtn_cago
			if (arrTroMstVOrtn != null)
			{
				for ( int i=0; i<arrTroMstVOrtn.length; i++ )
				{
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo      = arrTroMstVOrtn[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					if ( !("U".equals(arrTroMstVOrtn[i].getIbflag()) || "I".equals(arrTroMstVOrtn[i].getIbflag())) ) {
						continue; 
					}
					
					//----------------------------------
					//1) (cxl_flag = 'Y' : 취소)/I/U 처리
					if ("U".equals(arrTroMstVOrtn[i].getIbflag()))
					{
						if ("Y".equals(arrTroMstVOrtn[i].getCxlFlg()) && "N".equals(arrTroMstVOrtn[i].getCxlFlgOld()))  //신규 cancel된건만 cancel처리.
						{
							String boundCd    = arrTroMstVOrtn[i].getIoBndCd();
							String rtnTroFlg  = "Y";
							String troSeq     = arrTroMstVOrtn[i].getTroSeq();
							String updUsrId   = account.getUsr_id();
							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
						} else {
							arrTroMstVOrtn[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTro(arrTroMstVOrtn[i]);
						}
					}
					else if ("I".equals(arrTroMstVOrtn[i].getIbflag()))
					{
						arrTroMstVOrtn[i].setCreUsrId(account.getUsr_id());
						arrTroMstVOrtn[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTro(arrTroMstVOrtn[i]);
					}
				}
			}

			if (arrTroDtlVOrtn != null)
			{
				for (int i=0; i<arrTroDtlVOrtn.length; i++)
				{
					String cntrNo = JSPUtil.getNullNoTrim(arrTroDtlVOrtn[i].getCntrNo());
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroDtlVOrtn[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					//재처리 않되도록 제거  
					if ( !("U".equals(arrTroDtlVOrtn[i].getIbflag()) || "I".equals(arrTroDtlVOrtn[i].getIbflag())) ) {
						continue;
					} 
										
					//--------------------------------
					//1) 체크 처리
					if ( !"Y".equals(arrTroDtlVOrtn[i].getCxlFlg()) )   //cancel 된건이 아니면, -> rtn은 confirm 이없슴 
					{					
						if (cntrNo.length() == 14) {
							//1-1) Booking Container 존재여부 체크
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}
	
							//1-2) Return용  메세지구분자  조회
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
							else if ("S".equals(resultMsgFlag))
							{
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}
					}

					//--------------------------------
					//2) I/U/Cancel 처리
					if ("U".equals(arrTroDtlVOrtn[i].getIbflag()))
					{
						if ("Y".equals(arrTroDtlVOrtn[i].getCxlFlg()) && "N".equals(arrTroDtlVOrtn[i].getCxlFlgOld()))  //신규 cancel된건만 cancel처리.
						{
							String boundCd   = arrTroDtlVOrtn[i].getIoBndCd();
							String rtnTroFlg = "Y";
							String troSeq    = arrTroDtlVOrtn[i].getTroSeq();
							String troSubSeq = arrTroDtlVOrtn[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);
						} else {
							arrTroDtlVOrtn[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTroDtl(arrTroDtlVOrtn[i]);
						}
					}
					else if ("I".equals(arrTroDtlVOrtn[i].getIbflag()))
					{
						arrTroDtlVOrtn[i].setCreUsrId(account.getUsr_id());
						arrTroDtlVOrtn[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroDtl(arrTroDtlVOrtn[i]);
					}
				}
			}

			//=============================
			// QTY 조회후, 갱신 처리
			String bkgNo   = troVO.getBkgNo();
			String ioBndCd = troVO.getIoBndCd();

			List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, ioBndCd);

			BkgQuantityVO[] arrBkgQuantityVO = new BkgQuantityVO[qtyInfoForTroVOs.size()];
			int nCnt = 0;
			for (Iterator<QtyInfoForTroVO> iter = qtyInfoForTroVOs.iterator(); iter.hasNext(); )
			{
				QtyInfoForTroVO qtyInfoForTroVO = iter.next();

				String cntrTpszCd = qtyInfoForTroVO.getCntrTpszCd();
				String troQty     = qtyInfoForTroVO.getTroQty();

				BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
				bkgQuantityVO.setIbflag    ("U");
				bkgQuantityVO.setBkgNo     (bkgNo);
				bkgQuantityVO.setCntrTpszCd(cntrTpszCd);
				if ("O".equals(ioBndCd)) {
				    bkgQuantityVO.setObTroQty(troQty);
				} else if ("I".equals(ioBndCd)) {
					bkgQuantityVO.setIbTroQty(troQty);
				}
				arrBkgQuantityVO[nCnt++] = bkgQuantityVO;
			}
			responseData.put(WebKeys.ER_DBROWSETS, arrBkgQuantityVO);

			return responseData;

		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0079_01) Booking Full Return CY -> TRO Rerturn cy update<br>
	 * @author Yun TaeSeung
	 * @param  String bkgNo
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyKrTroReturnCy(String bkgNo, SignOnUserAccount account) throws EventException{
		try{
 			dbDao.modifyKrTroReturnCy(bkgNo, account.getUsr_id());
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0079_01) Booking POL:KR, RCV Term CFS -> TRO Create<br>
	 * @author jklim
	 * @param  String bkgNo
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTroKrCfs(String bkgNo, SignOnUserAccount account) throws EventException{
		try{
 			dbDao.manageKrCfsTroCreate(bkgNo, account.getUsr_id());
 			dbDao.manageKrCfsTroDtlCreate(bkgNo, account.getUsr_id());
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0079_02B) Tro TRO/O Tab 의 Remarks에 문구 삽입<br>
	 * @author Yun TaeSeung
	 * @param  TroVO troVO
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> modifyKrTroRmk(TroVO troVO, SignOnUserAccount account) throws EventException{
		try{
			
		Map<String,Object> responseData = new HashMap<String,Object>();
		TroMstVO[] arrTroMstVO = null;
		arrTroMstVO = troVO.getArrTroMstVO();
		
		if (arrTroMstVO != null)
		{
			for ( int i=0; i<arrTroMstVO.length; i++ )
			{
				String bkgNo     = arrTroMstVO[i].getBkgNo();
				String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
				String troSeq    = arrTroMstVO[i].getTroSeq();
				dbDao.modifyKrTroRmk(bkgNo, rtnTroFlg, troSeq);
			}
		}
				
		return responseData;
		
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0079_02C) 구주 Tro 관련 저장처리<br>
	 * @author    Lee NamKyung
	 * @param     EurTroVO eurTroVO
	 * @param     SignOnUserAccount account
	 * @return    Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageEurTro(EurTroVO eurTroVO, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		MdmYardVO mdmYardVO = null;
		List<MdmYardVO> list = null;
		String yardCd = null;
		try
		{
			util = new BookingUtil();
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			String delFlg = eurTroVO.getDelFlg(); 
			
			EurTroMstVO[]        arrEurTroMstVO      = null;
			EurTroDtlVO[]        arrEurTroDtlVO      = null;
			BkgEurTroDgSeqVO[]   arrBkgEurTroDgSeqVO = null;  
			arrEurTroMstVO      = eurTroVO.getArrEurTroMstVO();
			arrEurTroDtlVO      = eurTroVO.getArrEurTroDtlVO();
			arrBkgEurTroDgSeqVO = eurTroVO.getArrBkgEurTroDgSeqVO(); 


			//1) general
			if (arrEurTroMstVO != null)
			{
				for ( int i=0; i<arrEurTroMstVO.length; i++ )
				{
					// Pick up CY, Return CY Validation - start
					list = null;
					yardCd = arrEurTroMstVO[i].getCntrPkupYdCd();
					if (!"".equals(yardCd)) {
						mdmYardVO = new MdmYardVO();
						mdmYardVO.setYdCd(yardCd);
						list = util.searchYardCode(mdmYardVO);
						if (0==list.size()) {
							throw new EventException(new ErrorHandler("BKG01078", new String[]{yardCd}).getMessage());
						}
					}
					list = null;
					yardCd = arrEurTroMstVO[i].getCntrRtnYdCd();
					if (!"".equals(yardCd)) {
						mdmYardVO = new MdmYardVO();
						mdmYardVO.setYdCd(yardCd);
						list = util.searchYardCode(mdmYardVO);
						if (0==list.size()) {
							throw new EventException(new ErrorHandler("BKG01078", new String[]{yardCd}).getMessage());
						}
					}
					// Pick up CY, Return CY Validation - end

					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrEurTroMstVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					if ( !("U".equals(arrEurTroMstVO[i].getIbflag()) || "I".equals(arrEurTroMstVO[i].getIbflag())) ) {
						continue; 
					} 
					
					if(arrEurTroMstVO[i].getHlgTpCd() == null || arrEurTroMstVO[i].getHlgTpCd().length()!=1){
						throw new EventException(new ErrorHandler("BKG00404", new String[]{"Haulage", "Haulage"}).getMessage());
					}

					//----------------------------------
					//1) (cxl_flag = 'Y' : 취소)/I/U 처리
					String cntrNo = JSPUtil.getNullNoTrim(arrEurTroMstVO[i].getCntrNo());

					//--------------------------------
					//1) 체크 처리
					//CF -> cancel Frustrate 처리시
					if ( !"CF".equals(delFlg) && !"Y".equals(arrEurTroMstVO[i].getCxlFlg()) && cntrNo.length() > 0 )  //cancel 된건이 아니면 check  
					{
						//1-1) Booking Container 존재여부 체크
						String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
						if (!"Y".equals(cntExistYn)) {
							strErrCode = "BKG00449";
							throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
						}

						//1-2) Return용  메세지구분자  조회
						String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
						if ("P".equals(resultMsgFlag)) {
							strErrCode = "BKG00453";
							responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
						}
						else if ("S".equals(resultMsgFlag))
						{
							strErrCode = "BKG00451";
							responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
						}
					}
					//CURR_CD가 'CCC'패턴인지 체크한다.
					if (arrEurTroMstVO[i].getCurrCd() != null && arrEurTroMstVO[i].getCurrCd().length() > 0) {
						if (!util.checkStringFormat("CCC", arrEurTroMstVO[i].getCurrCd())){
							throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Currency Code: "+ arrEurTroMstVO[i].getCurrCd()}).getMessage());
						}
					}
					
					if ("U".equals(arrEurTroMstVO[i].getIbflag()))
					{
						arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyEurTro(arrEurTroMstVO[i]);
					}
					else if ("I".equals(arrEurTroMstVO[i].getIbflag()))
					{
						arrEurTroMstVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTro(arrEurTroMstVO[i]);
					}
				}
			}

			if (arrEurTroDtlVO != null)
			{
				for (int i=0; i<arrEurTroDtlVO.length; i++)
				{
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrEurTroDtlVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================
					
					//재처리 않되도록 제거  
					if ( !("U".equals(arrEurTroDtlVO[i].getIbflag()) || 
						   "I".equals(arrEurTroDtlVO[i].getIbflag()) || 
						   "D".equals(arrEurTroDtlVO[i].getIbflag()) ) ) {
						continue;
					}  					
					
    				//--------------------------------
					//1) I/U/D 처리
					if ("D".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						String boundCd   = arrEurTroDtlVO[i].getIoBndCd();
						String troSeq    = arrEurTroDtlVO[i].getTroSeq();
						String troSubSeq = arrEurTroDtlVO[i].getTroSubSeq();
						dbDao.removeEurTroDtl(bkgBlNoVO, boundCd, troSeq, troSubSeq);
					} 
					else if ("U".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyEurTroDtl(arrEurTroDtlVO[i]);
					}
					else if ("I".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						arrEurTroDtlVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTroDtl(arrEurTroDtlVO[i]);
					}
				}
			}

			if (arrBkgEurTroDgSeqVO != null)
			{
				//=================================>
				//*) BkgBlNoVO setting
				String bkgNo      = arrBkgEurTroDgSeqVO[0].getBkgNo();
				String boundCd    = arrBkgEurTroDgSeqVO[0].getIoBndCd();
				String troSeq     = arrBkgEurTroDgSeqVO[0].getTroSeq();
				bkgBlNoVO.setBkgNo(bkgNo);
				//<=================================
				
				//--------------------------------
				//1) 삭제 처리
				if ("C".equals(delFlg)) {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, boundCd, troSeq, "");	
				} else {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, boundCd, "", "");
				}	

				//--------------------------------
				//1) 저장(I) 처리
				for (int i=0; i<arrBkgEurTroDgSeqVO.length; i++)
				{
					if ("I".equals(arrBkgEurTroDgSeqVO[i].getIbflag()))
					{
						arrBkgEurTroDgSeqVO[i].setCreUsrId(account.getUsr_id());
						arrBkgEurTroDgSeqVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTroDgSeq(arrBkgEurTroDgSeqVO[i]);
					}
				}
			}

			//=============================
			// QTY 조회후, 갱신 처리
			String bkgNo   = eurTroVO.getBkgNo();
			String ioBndCd = eurTroVO.getIoBndCd();

			List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, ioBndCd);

			BkgQuantityVO[] arrBkgQuantityVO = new BkgQuantityVO[qtyInfoForTroVOs.size()];
			int nCnt = 0;
			for (Iterator<QtyInfoForTroVO> iter = qtyInfoForTroVOs.iterator(); iter.hasNext(); )
			{
				QtyInfoForTroVO qtyInfoForTroVO = iter.next();

				String cntrTpszCd = qtyInfoForTroVO.getCntrTpszCd();
				String troQty     = qtyInfoForTroVO.getTroQty();

				BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
				bkgQuantityVO.setIbflag    ("U");
				bkgQuantityVO.setBkgNo     (bkgNo);
				bkgQuantityVO.setCntrTpszCd(cntrTpszCd);
				if ("O".equals(ioBndCd)) {
				    bkgQuantityVO.setObTroQty(troQty);
				} else if ("I".equals(ioBndCd)) {
					bkgQuantityVO.setIbTroQty(troQty);
				}
				arrBkgQuantityVO[nCnt++] = bkgQuantityVO;
			}
			responseData.put(WebKeys.ER_DBROWSETS, arrBkgQuantityVO);

			return responseData;

		} catch (EventException ex) {	
			log.error("err " + ex.toString(), ex);
			throw ex;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)
	
	/**
	 * confirm 이벤트 처리<br>
	 * ESM_BKG_0079_02c 화면의 confirm팝업(ESM_BKG_0906)시 confirm 처리<br>
	 * @author    Lee NamKyung
	 * @param     TroCfmVO troCfmVO
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmEurTro(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException {
		try {
			String payerCntCd = "";
			String payerSeq   = "";
			String partialBkgNo;
			//dupCntr 추가 2011.12.09 kbj
			int dupCntr        = 0;
			
			EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
			if (eurPayerVO != null) {
				payerCntCd = eurPayerVO.getPayerCntCd();
				payerSeq   = eurPayerVO.getPayerSeq();
			}
			TroListForCfmVO[] arrTroListForCfmVO = troCfmVO.getArrTroListForCfmVO(); 
			for (int i=0; i<arrTroListForCfmVO.length;i++){
				partialBkgNo = "";
				partialBkgNo = dbDao.searchEurTroPartial(arrTroListForCfmVO[i]);
				log.debug("partialBkgNo:"+partialBkgNo);
				if(partialBkgNo !=null && partialBkgNo.length()>0){
					throw new EventException(new ErrorHandler("BKG02027", new String[]{partialBkgNo, arrTroListForCfmVO[i].getCntrNo()}).getMessage());
				}
				
				//중복컨테이너가 존재 하면 Exception throw 2011.12.09 kbj
                dupCntr = 0;
                dupCntr = dbDao.searchEurTroDupCntr(arrTroListForCfmVO[i]);
                log.debug("dupCntr:"+dupCntr);
                if(dupCntr > 1){
                      throw new EventException(new ErrorHandler("BKG02102").getMessage());
                }
                
				arrTroListForCfmVO[i].setPayerCntCd(payerCntCd);
				arrTroListForCfmVO[i].setPayerSeq  (payerSeq);
				arrTroListForCfmVO[i].setUpdUsrId  (account.getUsr_id());
				
				dbDao.confirmEurTro(arrTroListForCfmVO[i]);
			}
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_02C 화면의 ESM_BKG_0703 popup에서 cancel/Frust 처리<br>
	 * @author    Lee NamKyung
	 * @param     TroMultiCancelFrustVO[] troMultiCancelFrustVOs
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelFrustEurTro(TroMultiCancelFrustVO[] troMultiCancelFrustVOs, SignOnUserAccount account) throws EventException {
		try {
			if (troMultiCancelFrustVOs != null)
			{	
				
				for (int i=0; i<troMultiCancelFrustVOs.length; i++)
				{
					//2011.12.14 validate 추가 kbj
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO(); 
					String ioBndCd = troMultiCancelFrustVOs[i].getIoBndCd();
					bkgBlNoVO.setBkgNo( troMultiCancelFrustVOs[i].getBkgNo() );
					
					List<TroMultiCancelFrustVO> troList = dbDao.searchEurTroForCancelFrust(ioBndCd, bkgBlNoVO);
					
					//chk-value chage
					String cxlFlgChk    = ( "1".equals(troMultiCancelFrustVOs[i].getCxlFlgChk())    )? "Y":"N";
					String frustrateChk = ( "1".equals(troMultiCancelFrustVOs[i].getFrustrateChk()) )? "Y":"N";
					troMultiCancelFrustVOs[i].setCxlFlgChk   (cxlFlgChk);
					troMultiCancelFrustVOs[i].setFrustrateChk(frustrateChk);
					troMultiCancelFrustVOs[i].setCfmUsrId    (account.getUsr_id());
					troMultiCancelFrustVOs[i].setOfcCd       (account.getOfc_cd());
					troMultiCancelFrustVOs[i].setUpdUsrId    (account.getUsr_id());
					

					//1) Cancel
					if ("Y".equals(troMultiCancelFrustVOs[i].getCxlFlgChk()))
					{
						for(TroMultiCancelFrustVO vo : troList ){
							if( vo.getTroSeq().equals(troMultiCancelFrustVOs[i].getTroSeq()) && vo.getSoFlg().equals("Yes") ) {
								throw new EventException (new ErrorHandler("BKG00094").getMessage() );
							}
						}

						dbDao.cancelEurTro(troMultiCancelFrustVOs[i]);
						
						//2011.12.14 상단에서 bkgBlNoVO를 생성한후 bkgNo를 세팅하기에 이부분 주석 처리 kbj
						//BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
						//bkgBlNoVO.setBkgNo(troMultiCancelFrustVOs[i].getBkgNo());
						bkgBlNoVO.setPctlNo("");
						dbDao.modifyEurTroPctlNo(bkgBlNoVO, troMultiCancelFrustVOs[i].getIoBndCd(), troMultiCancelFrustVOs[i].getTroSeq(), account);
					}
					//2) Frustrate
					if ("Y".equals(troMultiCancelFrustVOs[i].getFrustrateChk()))
					{
						dbDao.frustrateEurTro(troMultiCancelFrustVOs[i]);
					}
				}
			}
		} catch (EventException ex ){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0079_02C 화면의 ESM_BKG_0920 popup에서 TroCopy 처리<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO sourceBkg
	 * @param     String boundCd
	 * @param     String sourceTroSeq
	 * @param     BkgBlNoVO[] arrTagetBkgBlNoVO
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyTro(BkgBlNoVO sourceBkg, String boundCd, String sourceTroSeq, BkgBlNoVO[] arrTagetBkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil command = new BookingUtil();

			if (arrTagetBkgBlNoVO != null)
			{
				for (int i=0; i<arrTagetBkgBlNoVO.length; i++)
				{					
					BkgBlNoVO targetBkg = arrTagetBkgBlNoVO[i];					

					//1) booking status check
					String strStatus = command.searchBkgStatusByBkg(targetBkg);
					if (strStatus == null) {
						throw new EventException(new ErrorHandler("BKG00399").getMessage());
					}
					if ("X".equals(strStatus)) {
						throw new EventException(new ErrorHandler("BKG00384").getMessage());
					}
					
					//2) TroSeq 존재여부 check 
					String tBoundCd = "O";
					if (!"".equals(boundCd)) {
						tBoundCd = boundCd; 
					}
					String strExist = dbDao.searchTroExist(tBoundCd, targetBkg);
					strExist = JSPUtil.getNullNoTrim(strExist);
					// 같은 BOUND내에 TRO가 없어야함
					if (!"".equals(strExist)) {
						throw new EventException(new ErrorHandler("BKG02033").getMessage());
					}
					
					//3) tro Copy
					boundCd = JSPUtil.getNullNoTrim(boundCd);

					targetBkg.setPctlNo("");
					// eur tro copy 건수가 있으면 eur tro copy 처리 
					if(dbDao.copyEurTroBySeq(sourceBkg, targetBkg, "", boundCd, account)>0){
						dbDao.copyEurTroDtlBySeq(sourceBkg, targetBkg, "", "", boundCd, account);
						dbDao.modifyEurTroPctlNo(targetBkg, boundCd, "", account);					 
					} else {// 없으면 general copy 처리
						dbDao.copyTroBySeq(sourceBkg, targetBkg, "", account);
						dbDao.copyTroDtlBySeq(sourceBkg, targetBkg, "", "", account); 
						dbDao.modifyTroPctlNo(targetBkg, "", account);		
					}
				}
			}
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

/* : confirm 관련로직시, 수정후 사용예정
	/--**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리 (0079_02C : confirm)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String troSeq
	 * @param     String newTroStsCd
	 * @exception EventException
	 *--/
	public void changeEurTroStatus(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, String newTroStsCd) throws EventException {
		try {
			BookingUtil command = new BookingUtil();
			troSeq = (troSeq==null)? "" : troSeq;

			//1) cntr개수만큼 반복--->
			    String cntrNo = "";  //for..변경할 것!

				//2-1) searchEurTroStatus
				//String strReturn_1 = dbDao.searchEurTroStatus(boundCd, troSeq, bkgBlNoVO);

				//2-1) searchSoStatus
				command.searchSoStatus(troSeq, cntrNo, bkgBlNoVO);

				//2-2) searchPartialCntrMst
				dbDao.searchPartialCntrMst(bkgBlNoVO, boundCd, cntrNo);
			//<------------------

			//2) searchMdmCust
			if ("F".equals(newTroStsCd)) {
				//command.searchMdmCust(custCntCd, custSeq, "Y");
			}

			//3) modifyEurTroStatus
			//dbDao.modifyEurTroStatus(newTroStsCd, troSeq, boundCd, bkgBlNoVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
*/
	
	/**
	 * (ESM_BKG_0907) EurTro의 Cntainer 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    List<BkgEurCntrListVO>
	 * @exception EventException
	 */
	public List<BkgEurCntrListVO> searchEurTroCntrList(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
		try {
			return dbDao.searchEurTroCntrList(bkgBlNoVO, boundCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0704) IFResult 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<BkgTroXterIfVO>
	 * @exception EventException
	 */
	public List<BkgTroXterIfVO> searchTroIfResultList(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchTroIfResultList(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0703) cancel/frust 처리대상 조회<br>
	 * @author Lee NamKyung
	 * @param  String ioBndCd
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroMultiCancelFrustVO>
	 * @exception EventException
	 */
	public List<TroMultiCancelFrustVO> searchEurTroForCancelFrust(String ioBndCd, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEurTroForCancelFrust(ioBndCd, bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0921) Multi 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String cntrNo
	 * @param     String boundCd
	 * @return    List<TroMultiBkgVO>
	 * @exception EventException
	 */
	public List<TroMultiBkgVO> searchMultiBkg(BkgBlNoVO bkgBlNoVO, String cntrNo, String boundCd) throws EventException {
		try {
			return dbDao.searchMultiBkg(bkgBlNoVO, cntrNo, boundCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0079_02c 화면의 confirm팝업(ESM_BKG_0906)시, confirm 대상 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    TroCfmVO
	 * @exception EventException
	 */
	public TroCfmVO searchEurTroListForCfm(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
		try {
			TroCfmVO troCfmVO = new TroCfmVO();

			if ("I".equals(boundCd)) {
				EurPayerVO eurPayerVO = dbDao.searchEurTroPayer(bkgBlNoVO);
				troCfmVO.setEurPayerVO(eurPayerVO);
			}
			List<TroListForCfmVO> list = dbDao.searchEurTroListForCfm(bkgBlNoVO, boundCd);
			troCfmVO.setTroListForCfmVOs(list);

			return troCfmVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0905) TroActCust Dtl I/U/D 처리<br>
	 * @author    Lee NamKyung
	 * @param     TroActCustVO troActCustVO
	 * @param     SignOnUserAccount account
	 * @return    String
	 * @exception EventException
	 */
	public String manageTroActCust(TroActCustVO troActCustVO, SignOnUserAccount account) throws EventException{
		try {
			String strErrCode = "";

			//(containerVO)
			BkgTroActRepVO[]  bkgTroActRepVOs  = null;
			BkgTroActCustVO[] bkgTroActCustVOs = null;

			bkgTroActRepVOs  = troActCustVO.getBkgTroActRepVOs();
			bkgTroActCustVOs = troActCustVO.getBkgTroActCustVOs();


			if (bkgTroActRepVOs != null)
			{
				for ( int i=0; i<bkgTroActRepVOs.length; i++ )
				{
					if ( bkgTroActRepVOs[i].getIbflag().equals("I"))
					{
						bkgTroActRepVOs[i].setCreUsrId(account.getUsr_id());
						dbDao.addBkgTroActRep(bkgTroActRepVOs[i]);
					}
					else if ( bkgTroActRepVOs[i].getIbflag().equals("U"))
					{
						bkgTroActRepVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyBkgTroActRep(bkgTroActRepVOs[i]);
					}
					else if ( bkgTroActRepVOs[i].getIbflag().equals("D"))
					{
						dbDao.removeBkgTroActRep(bkgTroActRepVOs[i]);
					}
				}
			}

			if (bkgTroActCustVOs != null)
			{
			    BookingUtil command = new BookingUtil();
				for ( int i=0; i<bkgTroActCustVOs.length; i++ )
				{
					if ( !bkgTroActCustVOs[i].getIbflag().equals("D") ) 
					{
						//Location 코드존재여부 체크
						String locCd = JSPUtil.getNull(bkgTroActCustVOs[i].getLocCd());
						if (!"".equals(locCd)) {
//						    String existYn_loc = dbDao.selectLocCdExistYn(locCd);
//							if (!"Y".equals(existYn_loc)) {
//								strErrCode = "BKG00441";
//								return strErrCode;
//							}
						    if(!command.validateLoc(locCd)){
								strErrCode = "BKG00441";
								return strErrCode;
							}
						}
						//Zone 코드존재여부 체크
						String zoneCd = JSPUtil.getNull(bkgTroActCustVOs[i].getZnCd());
						if (!"".equals(zoneCd)) {
							zoneCd = bkgTroActCustVOs[i].getLocCd()+bkgTroActCustVOs[i].getZnCd();
							bkgTroActCustVOs[i].setZnCd(zoneCd); //2->7자리 변환
							String existYnZone = dbDao.selectZoneCdExistYn(zoneCd);
							if ("N".equals(existYnZone)) {
								strErrCode = "BKG00441";
								return strErrCode;
							}
						}
					}
					
					if ( bkgTroActCustVOs[i].getIbflag().equals("I"))
					{
						bkgTroActCustVOs[i].setCreUsrId(account.getUsr_id());
						dbDao.addBkgTroActCust(bkgTroActCustVOs[i]);       //CUST와 동일함.
					}
					else if ( bkgTroActCustVOs[i].getIbflag().equals("U"))
					{
						bkgTroActCustVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyBkgTroActCust(bkgTroActCustVOs[i]);    //EQ용 Update 존재함.
					}
					else if ( bkgTroActCustVOs[i].getIbflag().equals("D"))
					{
						dbDao.removeBkgTroActCust(bkgTroActCustVOs[i]);    //CUST와 동일함.
					}
				}
			}

			return strErrCode;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)

	/**
	 * (ESM_BKG_0905) Customer탭 마스터 조회<br>
	 * @author    Lee NamKyung
	 * @param     String custCntCd
	 * @param     String custSeq
	 * @param     String custNm
	 * @return    List<MdmCustomerVO>
	 * @exception EventException
	 */
	public List<MdmCustomerVO> searchMdmCustForTro(String custCntCd, String custSeq, String custNm) throws EventException {
		try {
			return dbDao.searchMdmCustForTro(custCntCd, custSeq, custNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) Customer탭 상세 조회<br>
	 * @author    Lee NamKyung
	 * @param     String ofcCd
	 * @param     String cntCd
	 * @param     String custSeq
	 * @return    List<BkgTroActCustVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchTroActCustByCust(String ofcCd, String cntCd, String custSeq) throws EventException {
		try {
			return dbDao.searchTroActCustByCust(ofcCd, cntCd, custSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0905) ActCustRep Master 조회<br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     String ofcCd
	 * @param     String custNm
	 * @return    List<BkgTroActRepVO>
	 * @exception EventException
	 */
	public List<BkgTroActRepVO> searchActCustRep(String doorLoc, String ofcCd, String custNm) throws EventException {
		try {
			return dbDao.searchActCustRep(doorLoc, ofcCd, custNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) TroActCust Eq Dtl 조회<br>
	 * @author    Lee NamKyung
	 * @param	  String doorLoc
	 * @param     String ofcCd
	 * @param     String troActRepSeq
	 * @return    List<BkgTroActCustExtVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustExtVO> searchTroActCustByEq(String doorLoc, String ofcCd, String troActRepSeq) throws EventException {
		try {
			return dbDao.searchTroActCustByEq(doorLoc, ofcCd, troActRepSeq);  //EQ용 Select 존재함.
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) Vendor Name 조회<br>
	 * @author    Lee NamKyung
	 * @param     String cntCd
	 * @param     String vndrSeq
	 * @return    String
	 * @exception EventException
	 */
	public String searchVndrName(String cntCd, String vndrSeq) throws EventException {
		try {
			return dbDao.searchVndrName(cntCd, vndrSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00095").getUserMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02C) CntrNo별 Cago weight 조회<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String cntrNo
	 * @return    String
	 * @exception EventException
	 */
	public String searchBkgCntrWgt(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.searchBkgCntrWgt(bkgNo, cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/** (ESM_BKG_0317) Search Guideline Revenue<br>
	 * @author    Jeon Sungjin
	 * @param     GlineRevInVO glineRevInVO
	 * @return    GlineRevOutVO
	 * @exception EventException
	 */
	public GlineRevOutVO searchGlineRev(GlineRevInVO glineRevInVO) throws EventException {
		try {
			return dbDao.searchGlineRev(glineRevInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/** (ESM_BKG_0317) Search arbitary Revenue<br>
	 * @author    Kim Jinjoo
	 * @param     GlineRevInVO glineRevInVO
	 * @return    List<GlineRevOutVO>
	 * @exception EventException
	 */
	public List<GlineRevOutVO> searchArbitraryRev(GlineRevInVO glineRevInVO) throws EventException {
		try {
			return dbDao.searchArbitraryRev(glineRevInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/** (ESM_BKG_0317) Search arbitary Revenue Check <br>
	 * @author    Kim Jinjoo
	 * @param     GlineRevInVO glineRevInVO
	 * @return    List<GlineRevOutVO>
	 * @exception EventException
	 */
	public List<GlineRevOutVO> searchArbitraryRevChk(GlineRevInVO glineRevInVO) throws EventException {
		try {
			return dbDao.searchArbitraryRevChk(glineRevInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0905) Open시, Default값 초기화를 위한 정보 조회<br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    TroActCustDefaultVO
	 * @exception EventException
	 */
	public TroActCustDefaultVO searchTroActCustDefault(String doorLoc, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchTroActCustDefault(doorLoc, bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00095").getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 *  BKG_TRO Flag 변경.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmTro(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {
        	dbDao.unconfirmTro(bkgBlNoVO,  account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  BKG_EUR_TRO Flag 변경.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   String boundCd
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException {
        try {
        	dbDao.unconfirmEurTro(bkgBlNoVO,  boundCd, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
    /**
     * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectTroVO> selectTroVO
     * @param String troTp
     * @param SignOnUserAccount account
     * @return List<CombineTroNewSeqVO>
     * @exception EventException
     */
    public List<CombineTroNewSeqVO> copyTroByBkg (String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectTroVO> selectTroVO, String troTp, SignOnUserAccount account) throws EventException{
    	try {
    		if("S".equals(copyModeCd)){	
	    		List<String[]> splitTroSeqs = new ArrayList<String[]>();
	    		for(int i=0;i<targetBkg.length;i++){
					for(int icnt=0;icnt<selectTroVO.size();icnt++){
		    			if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo()) 
		    					&& targetBkg[i].getBkgNo().equals(selectTroVO.get(icnt).getBkg_no())
		    					&& selectTroVO.get(icnt).getTroSeq().length()>0
		    					&& selectTroVO.get(icnt).getSplitNo().length()>0){
		    				String splitTroSeq[] = new String[4];
		    				splitTroSeq[0] = i + ""; //targetBkgNo의 index
	    					splitTroSeq[1] = selectTroVO.get(icnt).getTroSeq();//master의 tro_seq
		    				splitTroSeq[2] = selectTroVO.get(icnt).getTroSeq();//detail의 tro_seq
		    				splitTroSeq[3] = selectTroVO.get(icnt).getTroSubSeq();//detail의 tro_sub_seq
			    			splitTroSeqs.add(splitTroSeq);    				
						}
					}
	    		}
	    		int targetBkgSeq = 0;
	    		String logStr = "\n";
				for(int i=1;i<splitTroSeqs.size();i++){
					for(int j=i-1;j>=0;j--){
		    			if(splitTroSeqs.get(i)[0].equals(splitTroSeqs.get(j)[0])){
		    				if(splitTroSeqs.get(i)[1].equals(splitTroSeqs.get(j)[1])){
		    					splitTroSeqs.get(i)[1] = "X";
		    				}
		    			}						
					}    			
	    		}
				logStr = "\n";
				StringBuffer logStr1 = new StringBuffer("\n");
				for(int i=0;i<splitTroSeqs.size();i++){			 
					targetBkgSeq = Integer.parseInt(splitTroSeqs.get(i)[0]);	
					logStr1.append("bkg_no:").append(targetBkg[targetBkgSeq].getBkgNo()).append(", tro_seq:").append(splitTroSeqs.get(i)[1]).append(", tro_sub_seq:").append(splitTroSeqs.get(i)[2]).append(":").append(splitTroSeqs.get(i)[3]).append("\n");
				}
				logStr = logStr1.toString();
				log.debug("\ntro split order log======================================================================"+logStr);
	    		for(int i=0;i<splitTroSeqs.size();i++){
	    			targetBkgSeq = Integer.parseInt(splitTroSeqs.get(i)[0]);
					if("EUR".equals(troTp)){
						if(!splitTroSeqs.get(i)[1].equals("X")){ // 이어지는 mst seq 제외
							dbDao.copyEurTroBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[1], "O", account);
						}
						dbDao.copyEurTroDtlBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[2], splitTroSeqs.get(i)[3], "O", account);
						//spcl cgo seq는 복사하지 않음
						//dbDao.copyEurTroDgSeqBySeq(sourceBkg, targetBkg[i],selectTroVO.get(icnt).getTroSeq(), "O", account);
					} else {
						if(!splitTroSeqs.get(i)[1].equals("X")){ // 이어지는 mst seq 제외
							dbDao.copyTroBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[1], account);
						}
						dbDao.copyTroDtlBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[2], splitTroSeqs.get(i)[3], account);
						//spcl cgo seq는 복사하지 않음
						//dbDao.copyTroSpclCgoSeqBySeq(sourceBkg, targetBkg[i], selectTroVO.get(icnt).getTroSeq(), account);
					}
	    		}
	    		
				//옮겨진 tro 삭제
	    		for(int icnt=0;icnt<selectTroVO.size();icnt++){
	    			if(selectTroVO.get(icnt).getBkg_no().equals(sourceBkg.getBkgNo())
							&& selectTroVO.get(icnt).getTroSeq().length()>0
							&& selectTroVO.get(icnt).getSplitNo().length()<1){
log.debug(sourceBkg.getBkgNo()+":"+selectTroVO.get(icnt).getTroSeq()+ ":"+selectTroVO.get(icnt).getTroSubSeq()+",DEL:"+ selectTroVO.get(icnt).getSplitDel());
						if("EUR".equals(troTp)){
							dbDao.removeEurTroDtl(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
							if(selectTroVO.get(icnt).getSplitDel().equals("Y")){
								dbDao.removeEurTroDgSeq				(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq(), "");
								dbDao.removeEurTro					(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq());
							}
						} else {    						
							dbDao.removeBkgTroDtlBySplit(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
	    					if(selectTroVO.get(icnt).getSplitDel().equals("Y")){
	        					dbDao.removeBkgTroXterIfBySplit		(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
								dbDao.removeBkgTroSpclCgoSeqBySplit	(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq());
								dbDao.removeBkgTroBySplit			(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
							}
						}
					}
				}

	    		//unconfirm 상태가 되어야 하므로 pctl_no도 null로 되돌림
	    		for(int i=0;i<targetBkg.length;i++){
					if("EUR".equals(troTp)){
						dbDao.modifyEurTroPctlNo(targetBkg[i], "O", "", account);
					} else {
						dbDao.modifyTroPctlNo(targetBkg[i], "", account);
					}
	    		}
	    		return null;
    		} else if("M".equals(copyModeCd)){
    			// combine시 source bkg 수 만큼 반복
//    			BookingUtil util = new BookingUtil();
//    			String troLastSeqStr = dbDao.searchTroLastSeq(sourceBkg);
//    			String[] troLastSeq = util.splitByToken(troLastSeqStr, "|");
    			String targetBkgNoList = "";
    			StringBuffer targetBkgNo = new StringBuffer(targetBkg[0].getBkgNo());
    			for(int i=0;i<targetBkg.length;i++){
    				targetBkgNo.append("|").append(targetBkg[i].getBkgNo());   
    			}
    			targetBkgNoList = targetBkgNo.toString();
    			
    			List<CombineTroNewSeqVO> combineTroNewSeqVOs = dbDao.searchCombineTroNewSeq(sourceBkg.getBkgNo(), targetBkgNoList);
    			BkgBlNoVO[] newTargetBkg = new BkgBlNoVO[combineTroNewSeqVOs.size()];
    			for(int i=0;i<combineTroNewSeqVOs.size();i++){
    				newTargetBkg[i] = new BkgBlNoVO();
    				newTargetBkg[i].setBkgNo(combineTroNewSeqVOs.get(i).getOrgBkgNo());
    			}
//    			if(troLastSeq[0].length()>0 && !"0".equals(troLastSeq[0])){
//    				troTp = "GEN";
//    			} else if(troLastSeq[1].length()>0 && !"0".equals(troLastSeq[1])){
//    				troTp = "EUR";    				
//    			}
	    		for(int i=0;i<newTargetBkg.length;i++){
	    			if("GEN".equals(combineTroNewSeqVOs.get(i).getTroTp())){
	    				dbDao.moveBkgTro(combineTroNewSeqVOs.get(i), account);
	    				dbDao.moveBkgTroDtl(combineTroNewSeqVOs.get(i), account);
	    			} else if("EUR".equals(combineTroNewSeqVOs.get(i).getTroTp())){
	    				dbDao.moveBkgEurTro(combineTroNewSeqVOs.get(i), account);
	    				dbDao.moveBkgEurTroDtl(combineTroNewSeqVOs.get(i), account);
	    			}
	    		}
	    		return combineTroNewSeqVOs;
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return null;
    }


    /**
	 * (ESM_BKG_0229_06) eBooking Tro 관련 저장처리<br>
	 * : Tro/EurTro 포함 
	 * 
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  EurTroVO eurTroVO
	 * @param  String isEurFlg
	 * @param  SignOnUserAccount account
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTroByXter(TroVO troVO, EurTroVO eurTroVO, String isEurFlg, SignOnUserAccount account) throws EventException {
		try{
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			TroMstVO[] arrTroMstVO = null;
			TroDtlVO[] arrTroDtlVO = null;
			arrTroMstVO = troVO.getArrTroMstVO();
			arrTroDtlVO = troVO.getArrTroDtlVO();
			
			//1) EUR
			if ( "Y".equals(isEurFlg) ) {
				EurTroMstVO[] arrEurTroMstVO = null;
				EurTroDtlVO[] arrEurTroDtlVO = null;	
				arrEurTroMstVO = eurTroVO.getArrEurTroMstVO();
				arrEurTroDtlVO = eurTroVO.getArrEurTroDtlVO();				
				
				if (arrEurTroMstVO != null){
					for ( int i=0; i<arrEurTroMstVO.length; i++ ){
						//=================================>
						//*) BkgBlNoVO setting
						if (i == 0) {
							String bkgNo = arrEurTroMstVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}			

						// confirm, cancel시 처리 없음(20100406 류대영)
						if("Y".equals(arrEurTroMstVO[i].getCxlFlg())||"Y".equals(arrEurTroMstVO[i].getCfmFlg())){
							return responseData;							
						} else {
							//e-booking에서 tro에 데이타를 넣을 때,구주 tro의 경우 HLG_TP_CD을 항상 'C'로 setting(20100429 류대영)
							arrEurTroMstVO[i].setHlgTpCd("C");
							if ("U".equals(arrEurTroMstVO[i].getIbflag())){
								arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
								//dbDao.modifyEurTro(arrEurTroMstVO[i]);
								dbDao.modifyEurTroByXter(arrEurTroMstVO[i]);  //modify : eBooking 전용 
							}
							else if ("I".equals(arrEurTroMstVO[i].getIbflag())){
								arrEurTroMstVO[i].setCreUsrId(account.getUsr_id());
								arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
								dbDao.addEurTro(arrEurTroMstVO[i]);
							}
						}
					}
				}

				if (arrEurTroDtlVO != null){
					for (int i=0; i<arrEurTroDtlVO.length; i++){
						if (i == 0) {
							String bkgNo = arrEurTroDtlVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}
						if ("D".equals(arrEurTroDtlVO[i].getIbflag())){
							String boundCd   = arrEurTroDtlVO[i].getIoBndCd();
							String troSeq    = arrEurTroDtlVO[i].getTroSeq();
							String troSubSeq = arrEurTroDtlVO[i].getTroSubSeq();
							dbDao.removeEurTroDtl(bkgBlNoVO, boundCd, troSeq, troSubSeq);
						} else if ("U".equals(arrEurTroDtlVO[i].getIbflag())){
							arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyEurTroDtlByXter(arrEurTroDtlVO[i]);  //modify : eBooking 전용 
						} else if ("I".equals(arrEurTroDtlVO[i].getIbflag())){
							arrEurTroDtlVO[i].setCreUsrId(account.getUsr_id());
							arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
							dbDao.addEurTroDtl(arrEurTroDtlVO[i]);
						}
					}
				}
			} else { //2) general
				if (arrTroMstVO != null){
					for (int i=0; i<arrTroMstVO.length; i++){
						if (i == 0) {
							String bkgNo = arrTroMstVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}
						
// : eBooking에는 mst delete 없음.//1) (cxl_flag = 'Y' : 취소)/I/U 처리
//						if ("Y".equals(arrTroMstVO[i].getCxlFlg())) {
//							String boundCd   = arrTroMstVO[i].getIoBndCd();
//							String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
//							String troSeq    = arrTroMstVO[i].getTroSeq();
//							String updUsrId  = account.getUsr_id();
//							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
//						} else {
						// confirm, cancel시 처리 없음(20100406 류대영)
						if("Y".equals(arrTroMstVO[i].getCfmFlg())||"Y".equals(arrTroMstVO[i].getCxlFlg())){
//							return responseData;
							continue;
						} else {
							arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
							int updCnt = dbDao.modifyBkgTroByXter(arrTroMstVO[i]);  //modify : ebooking용
							if(updCnt==0){
								arrTroMstVO[i].setCreUsrId(account.getUsr_id());
								dbDao.addBkgTro(arrTroMstVO[i]);
							}
						}
					}
				}

				if (arrTroDtlVO != null){
					for (int i=0; i<arrTroDtlVO.length; i++){
						String cntrNo = arrTroDtlVO[i].getCntrNo();
						if (i == 0) {
							String bkgNo = arrTroDtlVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}
						if (cntrNo.length() == 14) {
							//1-1) Booking Container 존재여부 체크
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}

							//1-2) Return용  메세지구분자  조회
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
							else if ("S".equals(resultMsgFlag)) {
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}

						//2) I/U/D 처리
						if ("Y".equals(arrTroDtlVO[i].getCxlFlg())){
							String boundCd   = arrTroDtlVO[i].getIoBndCd();
							String rtnTroFlg = arrTroDtlVO[i].getRtnTroFlg();
							String troSeq    = arrTroDtlVO[i].getTroSeq();
							String troSubSeq = arrTroDtlVO[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);  
						} else {
							if ("U".equals(arrTroDtlVO[i].getIbflag())) {
								arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
								dbDao.modifyBkgTroDtlByXter(arrTroDtlVO[i]);  //modify : ebooking용		
							} else if ("I".equals(arrTroDtlVO[i].getIbflag())) {
								arrTroDtlVO[i].setCreUsrId(account.getUsr_id());
								arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
								dbDao.addBkgTroDtl(arrTroDtlVO[i]);
							}
						}
					}
				}
			}

			return responseData;
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)

	/**
	 * CTM에서 EUR mty release를 했을 때의 처리<br>
	 * @author    RYU DAEYOUNG
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEurTroByEmptyRelease(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws EventException{
		String jobDivCd = eurTroMtyRelByCtmVO.getJobDivCd();
		try {
			if ("RECOVERY".equals(jobDivCd)){
				dbDao.unconfirmEurTroByCtm(eurTroMtyRelByCtmVO, account);	
			}else if("RELEASE".equals(jobDivCd)){
				dbDao.confirmEurTroByCtm(eurTroMtyRelByCtmVO, account);
			}else if("REDELIVERY".equals(jobDivCd)){
				dbDao.redeliveEurTroByCfm(eurTroMtyRelByCtmVO, account);
			}		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
     * inland route Validation<br>
     * 변경하려는 route가 inland route로 등록되어 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String BoundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @exception 	EventException
	 */
	public void validateInlaneRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door,String trspModCd) throws EventException{
		try {
			List<ValidateInlandRouteVO> validateInlandRouteVO = dbDao.validateInlandRoute(bkgBlNoVO, boundCd, fullCy, door, trspModCd);
			
			if(validateInlandRouteVO.size()==0){
				String strErrMsg = "("+fullCy+"-"+door+")";				
				throw new EventException(new ErrorHandler("BKG02032", new String[]{strErrMsg}).getMessage());
			}
			validateInlandRouteVO = dbDao.validateTroConfirm(bkgBlNoVO, boundCd, fullCy, door, trspModCd);
			if(validateInlandRouteVO.size()==0){			
				throw new EventException(new ErrorHandler("BKG08255").getMessage());
			}			
		} catch (EventException eventEx) {
			throw eventEx;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
     * eur tro에 pctl_no를 갱신한다..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyEurTroPctlNo(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyEurTroPctlNo(bkgBlNoVO, boundCd, troSeq, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
     * general tro에 pctl_no를 갱신한다..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyTroPctlNo(BkgBlNoVO bkgBlNoVO, String troSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyTroPctlNo(bkgBlNoVO, troSeq, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void copyTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException {
		try
		{
			if (targetBkgNoList != null)
			{
				for (int i = 0; i < targetBkgNoList.length; i++)
				{
					String targetBkg = targetBkgNoList[i];
					if (!targetBkg.equals(sourceBkg)) {
						dbDao.copyTroBySplit(sourceBkg, targetBkg, account);
						dbDao.copyTroDtlBySplit(sourceBkg, targetBkg, account);
						dbDao.copyTroSpclCgoSeqBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroDtlBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroDgSeqBySplit(sourceBkg, targetBkg, account);
					}
				}
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * sourceBkg을 cancel한다.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void cancelTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException {
		try
		{
			if (targetBkgNoList != null)
			{
				StringBuffer targetBkg = new StringBuffer();
				for (int i = 0; i < targetBkgNoList.length; i++)
				{
					targetBkg.append("'" + targetBkgNoList[i] + "'");
					if (i < targetBkgNoList.length - 1)
						targetBkg.append(",");
				}
//				cancelBkgTroBySplit와 cancelBkgTroDtlBySplit 의 호출 순서 변경 
				dbDao.cancelBkgTroDtlBySplit(sourceBkg, targetBkg.toString(), account);
				dbDao.cancelBkgTroBySplit(sourceBkg, targetBkg.toString(), account);
				dbDao.cancelEurTroBySplit(sourceBkg, targetBkg.toString(), account);
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/** (ESM_BKG_1139) Cntr List 조회한다.<br>
	 * @author    Moon Dongsun
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<BkgEurTroVO>
	 * @exception EventException
	 */
	public List<BkgEurTroVO> searchTroCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchTroCntrListByBkg(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * cop상의 qty와 tro qty일치하는지 check
	 * @param TroDtlVO troDtlVO
	 * @return String 
	 * @throws EventException
	 */
	public String checkCopQty(TroDtlVO troDtlVO) throws EventException{
		try {
			return dbDao.checkCopQty(troDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * inv로 운임이 if되었는지 체크
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 */
	public String checkInvChgIf(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.checkInvChgIf(bkgNo, cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00095").getUserMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**Return CY,pick up cy정보를 업데이트한다.
	 * @param EurTroMstVO vo
	 * @throws EventException
	 */
	public void modifyEurTroCyInfo(EurTroMstVO vo) throws EventException{
		try {
			dbDao.modifyEurTroCyInfo(vo);
			
			SignOnUserAccount account = new SignOnUserAccount();
			account = new SignOnUserAccount(vo.getUpdUsrId() ,"" ,"" ,"" ,""
											,"" ,"" ,"" ,vo.getUpdUsrId() ,""
											,vo.getUpdUsrId() ,"" ,"" ,"" ,""
											,"" ,"" ,"" ,"", "", "" ,""
											);
			
			
			BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
			HistoryLineVO historyLineVO = null;
			historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(vo.getBkgNo());
			historyLineVO.setCaFlg("N");
			historyLineVO.setCrntCtnt("Return CY update: "+vo.getCntrNo()+"/"+vo.getCntrRtnYdCd());
			historyLineVO.setHisCateNm("DOD");
			historyLineVO.setPreCtnt(" ");
			historyLineVO.setUiId(vo.getUpdUsrId());
			histCmd.createBkgHistoryLine(historyLineVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	} 

}