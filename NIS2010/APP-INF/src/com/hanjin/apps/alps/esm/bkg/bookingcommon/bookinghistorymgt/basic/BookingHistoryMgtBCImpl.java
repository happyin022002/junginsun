/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingHistoryMgtBCImpl.java
 *@FileTitle : Booking_History_Mgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.05.11 김영출
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.12.06 김종호 [CHM-201114075] [Homepage Renewal] EAI-Webservice I/F 개발 (AES NO Input)
 * 2012.05.15 조정민 [CHM-201217619] [BKG] createBkgNtcHis 변경
 * 2012.11.20 이준근 [CHM-201221319-01] M&D C/A Inquiry 및 BKG History 보완 (M&D-공통C/A항목 전환CSR과 연관)
 * 2013.04.23 김보배 [CHM-201324188] [BKG] "Not updated container" Clear 버튼 생성
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgEtcHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgTmlEdiHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.TableListVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgInetBlPrnAuthVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgAwkCgoVO;
import com.hanjin.syscommon.common.table.BkgAwkDimVO;
import com.hanjin.syscommon.common.table.BkgBbCgoVO;
import com.hanjin.syscommon.common.table.BkgBlDocVO;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgBlMkDescVO;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgChgRtVO;
import com.hanjin.syscommon.common.table.BkgClzTmVO;
import com.hanjin.syscommon.common.table.BkgCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCustomerVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.BkgDocIssRdemVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgEurTroDgSeqVO;
import com.hanjin.syscommon.common.table.BkgEurTroDtlVO;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgHblCustVO;
import com.hanjin.syscommon.common.table.BkgHblVO;
import com.hanjin.syscommon.common.table.BkgHisDtlVO;
import com.hanjin.syscommon.common.table.BkgHisMstVO;
import com.hanjin.syscommon.common.table.BkgMfCstmsHisVO;
import com.hanjin.syscommon.common.table.BkgNonDgCgoTgtIfVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRateVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgRfCgoVO;
import com.hanjin.syscommon.common.table.BkgTroDtlVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgTroVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.BkgXptImpLicVO;

/**
 * NIS2010-BookingCommon Business Logic Basic Command implementation<br>
 * - NIS2010-BookingCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Youngchul
 * @see Booking_History_MgtEventResponse,BookingHistoryMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BookingHistoryMgtBCImpl extends BasicCommandSupport implements BookingHistoryMgtBC {

    // Database Access Object
    private transient BookingHistoryMgtDBDAO dbDao = null;

    /**
     * BookingHistoryMgtBCImpl 객체 생성<br>
     * BookingHistoryMgtDBDAO를 생성한다.<br>
     */
    public BookingHistoryMgtBCImpl() {
        dbDao = new BookingHistoryMgtDBDAO();
    }
	/**
	 * Booking Cancel <br> 
	 * 취소에 관련된 정보를 처리한다<br>
	 *
	 * @author Lee NamKyung
	 * @param  String bkgDocProcTpCd
	 * @param  String bkgNo
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBkgDocProcSkd(String bkgDocProcTpCd, String bkgNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.cancelBkgDocProcSkd(bkgDocProcTpCd, bkgNo, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * Booking의 Notice 관련 생성/변경에 대해 History를 기록한다.
     * 
     * @param  List<BkgNtcHisVO> ntcHis
     * @param  String uiId
     * @exception EventException
     */
    public void createBkgNtcHis(List<BkgNtcHisVO> ntcHis, String uiId) throws EventException {    	
		try {
//			BkgHisMstVO bkgHisMstVO = null;
			BkgNtcHisVO bkgNtcHisVO = null;
			//String hisSeq = "";
			String rmk = "";
			int rmkleng = 0;

			for (int i=0; ntcHis != null && i<ntcHis.size(); i++) {
				bkgNtcHisVO = ntcHis.get(i);

//				//hisSeq = dbDao.searchNextHistSeq(bkgNtcHisVO.getBkgNo());
//				//bkgNtcHisVO.setHisSeq(hisSeq);
//				
//				bkgHisMstVO = new BkgHisMstVO();
//				bkgHisMstVO.setBkgNo(bkgNtcHisVO.getBkgNo());
//				//bkgHisMstVO.setHisSeq(bkgNtcHisVO.getHisSeq());
//				bkgHisMstVO.setBkgHisIssUiId(uiId);
//				bkgHisMstVO.setCreUsrId(bkgNtcHisVO.getCreUsrId());
//				bkgHisMstVO.setUpdUsrId(bkgNtcHisVO.getUpdUsrId());				
//				//dbDao.addBkgHisMst(bkgHisMstVO); 	
				if(null != bkgNtcHisVO.getDiffRmk()){
					rmk = java.net.URLDecoder.decode(bkgNtcHisVO.getDiffRmk(),"UTF-8");
					if(rmk != null){
						rmkleng = rmk.length();
						
						if (rmkleng > 0){
							if (rmkleng < 900){
								bkgNtcHisVO.setDiffRmk(rmk.substring(0,rmkleng));
							} else {
								bkgNtcHisVO.setDiffRmk(rmk.substring(0, 900));
							}
						}
					}
				}
				dbDao.addBkgNtcHis(bkgNtcHisVO); 
				
				if ("BL".equals(bkgNtcHisVO.getNtcKndCd())){
					dbDao.modifyDpcsFaxResult(bkgNtcHisVO); 
				}else if("BT".equals(bkgNtcHisVO.getNtcKndCd())){
					String strHisSeq = dbDao.searchNextHistSeq(bkgNtcHisVO.getBkgNo());	
					
					//-------------------------
					// add History Master
					//-------------------------
					BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
					bkgHisMstVO.setBkgNo        (bkgNtcHisVO.getBkgNo());
					bkgHisMstVO.setHisSeq       (strHisSeq);
					bkgHisMstVO.setBkgHisIssUiId(uiId);
					bkgHisMstVO.setCreUsrId     (bkgNtcHisVO.getCreUsrId());
					bkgHisMstVO.setUpdUsrId     (bkgNtcHisVO.getUpdUsrId());
					dbDao.addBkgHisMst(bkgHisMstVO);
					if ("E".equals(bkgNtcHisVO.getNtcViaCd())) { 
						BkgTmlEdiHisVO bkgTmlEdiHisVO = new BkgTmlEdiHisVO();
						bkgTmlEdiHisVO.setBkgNo(bkgNtcHisVO.getBkgNo());
						bkgTmlEdiHisVO.setHisSeq(strHisSeq);
						bkgTmlEdiHisVO.setTmlEdiRqstNo(bkgNtcHisVO.getDiffRmk());
						dbDao.addBkgTmlEdiHis(bkgTmlEdiHisVO, bkgNtcHisVO.getCreUsrId());
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
	/**
	 * Booking History : Old Data Search<br> 
	 * 변견 전 data를 조회한다<br>
	 * 조회결과가 manageBookingHistory()에 전달된다.<br>
	 *
	 * @author Lee NamKyung
	 * @param  String uiId
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return HistoryTableVO
	 * @exception EventException
	 */
	public HistoryTableVO searchOldBkgForHistory(String uiId, BkgBlNoVO bkgBlNoVO) throws EventException{
		try
		{
			HistoryTableVO historyTableVO = new HistoryTableVO();
			
/* : ESM_BKG_CA 사용않함으로 변경.
			if (!"ESM_BKG_CA".equals(uiId) && "Y".equals(bkgBlNoVO.getCaFlg())) {
				return historyTableVO; 
			}
*/
log.debug("@@@@@@BCImpl : historyTableVO.setBkgBlNoVO(bkgBlNoVO);");
			historyTableVO.setBkgBlNoVO(bkgBlNoVO);
			
			//01. UI ID 별로 history를 남길 항목의 table 조회
			log.debug("@@@@@@BCImpl : dbDao.searchHisTableByUi(uiId);");
			List<TableListVO> tableListVOs = dbDao.searchHisTableByUi(uiId);
			historyTableVO.setTableListVOs(tableListVOs);
			for(int i=0; i<tableListVOs.size(); i++) {
				String tableNm = tableListVOs.get(i).getTableNm();
				
				//02. 단건 VO
				if ("BKG_BOOKING".equals(tableNm)) {
					BkgBookingVO              bkgBookingVO         = dbDao.searchBkgBooking(bkgBlNoVO);
					historyTableVO.setBkgBookingVO(bkgBookingVO);
				}
				//03. 단건 VO
				else if ("BKG_CUSTOMER".equals(tableNm)) {
					List<BkgCustomerVO>       bkgCustomerVOs       = dbDao.searchBkgCustomer(bkgBlNoVO); 
					historyTableVO.setBkgCustomerVOs(bkgCustomerVOs);
				}
				//04.
				else if ("BKG_VVD".equals(tableNm)) {
					List<BkgVvdVO>            bkgVvdVOs            = dbDao.searchBkgVvd(bkgBlNoVO);
					historyTableVO.setBkgVvdVOs(bkgVvdVOs);
				}
				//05.
				else if ("BKG_QUANTITY".equals(tableNm)) {
					List<BkgQuantityVO>       bkgQuantityVOs       = dbDao.searchBkgQuantity(bkgBlNoVO);
					historyTableVO.setBkgQuantityVOs(bkgQuantityVOs);
				}
				//06.
				else if ("BKG_QTY_DTL".equals(tableNm)) {
					List<BkgQtyDtlVO>         bkgQtyDtlVOs         = dbDao.searchBkgQtyDtl(bkgBlNoVO);
					historyTableVO.setBkgQtyDtlVOs(bkgQtyDtlVOs);
				}
				//07. 단건 VO
				else if ("BKG_CNTC_PSON".equals(tableNm)) {
					List<BkgCntcPsonVO>       bkgCntcPsonVOs       = dbDao.searchBkgCntcPson(bkgBlNoVO);
					historyTableVO.setBkgCntcPsonVOs(bkgCntcPsonVOs);
				}
				//08.
				else if ("BKG_REFERENCE".equals(tableNm)) {
					List<BkgReferenceVO>      bkgReferenceVOs      = dbDao.searchBkgReference(bkgBlNoVO);
					historyTableVO.setBkgReferenceVOs(bkgReferenceVOs);
				}
				//09.
				else if ("BKG_REF_DTL".equals(tableNm)) {
					List<BkgRefDtlVO>         bkgRefDtlVOs         = dbDao.searchBkgRefDtl(bkgBlNoVO);
					historyTableVO.setBkgRefDtlVOs(bkgRefDtlVOs);
				}
				//10.
				else if ("BKG_CONTAINER".equals(tableNm)) {
					List<BkgContainerVO>      bkgContainerVOs      = dbDao.searchBkgContainer(bkgBlNoVO);
					historyTableVO.setBkgContainerVOs(bkgContainerVOs);
				}
				//11.
				else if ("BKG_CNTR_SEAL_NO".equals(tableNm)) {
					List<BkgCntrSealNoVO>     bkgCntrSealNoVOs     = dbDao.searchBkgCntrSealNo(bkgBlNoVO);
					historyTableVO.setBkgCntrSealNoVOs(bkgCntrSealNoVOs);
				}
				//12.
				else if ("BKG_CNTR_MF_DESC".equals(tableNm)) {
					List<BkgCntrMfDescVO>     bkgCntrMfDescVOs     = dbDao.searchBkgCntrMfDesc(bkgBlNoVO);
					historyTableVO.setBkgCntrMfDescVOs(bkgCntrMfDescVOs);
				}
				//13. 단건 VO
				else if ("BKG_CLZ_TM".equals(tableNm)) {
					List<BkgClzTmVO>          bkgClzTmVOs           = dbDao.searchBkgClzTm(bkgBlNoVO);
					historyTableVO.setBkgClzTmVOs(bkgClzTmVOs);
				}
				//14. 단건 VO
				else if ("BKG_BL_DOC".equals(tableNm)) {
					BkgBlDocVO                bkgBlDocVO           = dbDao.searchBkgBlDoc(bkgBlNoVO);
					historyTableVO.setBkgBlDocVO(bkgBlDocVO);
				}
				//15. 단건 VO
				else if ("BKG_BL_MK_DESC".equals(tableNm)) {
					BkgBlMkDescVO             bkgBlMkDescVO        = dbDao.searchBkgBlMkDesc(bkgBlNoVO);
					historyTableVO.setBkgBlMkDescVO(bkgBlMkDescVO);
				}
				//16.
				else if ("BKG_HBL".equals(tableNm)) {
					List<BkgHblVO>            bkgHblVOs            = dbDao.searchBkgHbl(bkgBlNoVO);
					historyTableVO.setBkgHblVOs(bkgHblVOs);
				}
				//17.
				else if ("BKG_HBL_CUST".equals(tableNm)) {
					List<BkgHblCustVO>        bkgHblCustVOs        = dbDao.searchBkgHblCust(bkgBlNoVO);
					historyTableVO.setBkgHblCustVOs(bkgHblCustVOs);
				}
				//18.
				else if ("BKG_USA_CSTMS_FILE_NO".equals(tableNm)) {
					List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVOs = dbDao.searchBkgUsaCstmsFileNo(bkgBlNoVO);
					historyTableVO.setBkgUsaCstmsFileNoVOs(bkgUsaCstmsFileNoVOs);
				}
				//19.
				else if ("BKG_XPT_IMP_LIC".equals(tableNm)) {
					log.debug("@@@@@@BCImpl : dbDao.searchBkgXptImpLic(bkgBlNoVO)");
					List<BkgXptImpLicVO>      bkgXptImpLicVOs      = dbDao.searchBkgXptImpLic(bkgBlNoVO);
					log.debug("@@@@@@BCImpl : historyTableVO.setBkgXptImpLicVOs(bkgXptImpLicVOs)");
					historyTableVO.setBkgXptImpLicVOs(bkgXptImpLicVOs);
				}
				//20.
				else if ("BKG_DG_CGO".equals(tableNm)) {
					List<BkgDgCgoVO>          bkgDgCgoVOs          = dbDao.searchBkgDgCgo(bkgBlNoVO);
					historyTableVO.setBkgDgCgoVOs(bkgDgCgoVOs);
				}
                //21.
				else if ("BKG_RF_CGO".equals(tableNm)) {
					List<BkgRfCgoVO>          bkgRfCgoVOs          = dbDao.searchBkgRfCgo(bkgBlNoVO);
					historyTableVO.setBkgRfCgoVOs(bkgRfCgoVOs);
				}
				//22.
				else if ("BKG_AWK_CGO".equals(tableNm)) {
					List<BkgAwkCgoVO>         bkgAwkCgoVOs         = dbDao.searchBkgAwkCgo(bkgBlNoVO);
					historyTableVO.setBkgAwkCgoVOs(bkgAwkCgoVOs);
				}
				//23.
				else if ("BKG_AWK_DIM".equals(tableNm)) {
					List<BkgAwkDimVO>         bkgAwkDimVOs         = dbDao.searchBkgAwkDim(bkgBlNoVO);
					historyTableVO.setBkgAwkDimVOs(bkgAwkDimVOs); 
				}
				//24.
				else if ("BKG_BB_CGO".equals(tableNm)) {
					List<BkgBbCgoVO>          bkgBbCgoVOs          = dbDao.searchBkgBbCgo(bkgBlNoVO);
					historyTableVO.setBkgBbCgoVOs(bkgBbCgoVOs);
				}
				//25.  
				else if ("BKG_TRO".equals(tableNm)) {
					List<BkgTroVO>            bkgTroVOs            = dbDao.searchBkgTro(bkgBlNoVO);
					historyTableVO.setBkgTroVOs(bkgTroVOs);
				}
				//26.
				else if ("BKG_TRO_DTL".equals(tableNm)) {
					List<BkgTroDtlVO>         bkgTroDtlVOs         = dbDao.searchBkgTroDtl(bkgBlNoVO);
					historyTableVO.setBkgTroDtlVOs(bkgTroDtlVOs);
				}
				//27.
				else if ("BKG_TRO_SPCL_CGO_SEQ".equals(tableNm)) {
					List<BkgTroSpclCgoSeqVO>  bkgTroSpclCgoSeqVOs  = dbDao.searchBkgTroSpclCgoSeq(bkgBlNoVO);
					historyTableVO.setBkgTroSpclCgoSeqVOs(bkgTroSpclCgoSeqVOs);
				}
				//28.
				else if ("BKG_EUR_TRO".equals(tableNm)) {
					List<BkgEurTroVO>         bkgEurTroVOs         = dbDao.searchBkgEurTro(bkgBlNoVO);
					historyTableVO.setBkgEurTroVOs(bkgEurTroVOs);
				}
				//29.
				else if ("BKG_EUR_TRO_DTL".equals(tableNm)) {
					List<BkgEurTroDtlVO>      bkgEurTroDtlVOs      = dbDao.searchBkgEurTroDtl(bkgBlNoVO);
					historyTableVO.setBkgEurTroDtlVOs(bkgEurTroDtlVOs);
				}
				//30.
				else if ("BKG_EUR_TRO_DG_SEQ".equals(tableNm)) {
					List<BkgEurTroDgSeqVO>    bkgEurTroDgSeqVOs    = dbDao.searchBkgEurTroDgSeq(bkgBlNoVO);
					historyTableVO.setBkgEurTroDgSeqVOs(bkgEurTroDgSeqVOs);
				}
				//31. 단건 VO
				else if ("BKG_RATE".equals(tableNm)) {
					BkgRateVO                 bkgRateVO            = dbDao.searchBkgRate(bkgBlNoVO);
					historyTableVO.setBkgRateVO(bkgRateVO);
				}
				//32.
				else if ("BKG_CHG_RT".equals(tableNm)) {
					List<BkgChgRtVO>          bkgChgRtVOs          = dbDao.searchBkgChgRt(bkgBlNoVO);
					historyTableVO.setBkgChgRtVOs(bkgChgRtVOs);
				}
				//33. 단건 VO
				else if ("BKG_BL_ISS".equals(tableNm)) {
					BkgBlIssVO                bkgBlIssVO           = dbDao.searchBkgBlIss(bkgBlNoVO);
					historyTableVO.setBkgBlIssVO(bkgBlIssVO);
				}
				//34. 
				else if ("BKG_DOC_ISS_RDEM".equals(tableNm)) {
					List<BkgDocIssRdemVO>     bkgDocIssRdemVOs     = dbDao.searchBkgDocIssRdem(bkgBlNoVO);
					historyTableVO.setBkgDocIssRdemVOs(bkgDocIssRdemVOs);
				}
			}
			
			return historyTableVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}    

	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history를 만든다<br>
	 *
	 * @author Lee NamKyung
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingHistory(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException {
		try
		{
			List<HistCtntVO> histCtntVOs = new ArrayList<HistCtntVO>();
			List<BkgNonDgCgoTgtIfVO> bkgNonDgCgoTgtIfVOs = new ArrayList<BkgNonDgCgoTgtIfVO>();
			
			String bkgNo    = historyTableVO.getBkgBlNoVO().getBkgNo();  //bkg_no, ca_flag 필수 setting 					
			String strCaFlg = JSPUtil.getNullNoTrim(historyTableVO.getBkgBlNoVO().getCaFlg());
			String strCaNo  = JSPUtil.getNullNoTrim(historyTableVO.getBkgBlNoVO().getCaNo());
			if ("Y".equals(strCaFlg)) {
				strCaNo = "TMP0000001";
				historyTableVO.getBkgBlNoVO().setCaNo(strCaNo); 
			}
			
			//historyTableVO.getBkgBlNoVO().getCaNo() 값이 않넘어 왔을 경우, 메세지(or default) 처리 
			if (!"Y".equals(strCaFlg) && !"N".equals(strCaFlg)) { 	
				strCaFlg = "N";  				
//				//한줄history 로 caFlg 값 입력오류 남김 
//				String hisCateNm = "ManageBookingHistory"; 
//				String crntCtnt  = "caFlg 입력값 오류발생 (BkgNo:"+bkgNo+", uiID:"+uiId+")"; 
//				HistoryLineVO historyLineVO = new HistoryLineVO();
//				historyLineVO.setBkgNo         (bkgNo);
//				historyLineVO.setUiId          (uiId);
//				historyLineVO.setCrntCtnt      (crntCtnt);
//				historyLineVO.setHisCateNm     (hisCateNm);
//				createBkgHistoryLine(historyLineVO, account);
			}
			
			//caFlg='Y'이면, TempHistory 삭제 후, 재생성 
			if ("Y".equals(strCaFlg)) {
				//01. 
				dbDao.removeHisDtlByUiId(historyTableVO.getBkgBlNoVO(), uiId);
				//02. 
				dbDao.removeHisMstByUiId(historyTableVO.getBkgBlNoVO(), uiId);
			}
			
			List<TableListVO> tableListVOs = historyTableVO.getTableListVOs();
			
			for(int i=0; i<tableListVOs.size(); i++) 
			{
				String tableNm = tableListVOs.get(i).getTableNm();
				
				//01.
				if ("BKG_BOOKING".equals(tableNm)) {
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBooking(historyTableVO.getBkgBookingVO(), strCaFlg);
					List<BkgNonDgCgoTgtIfVO> ifVOs = dbDao.searchRmkHis(historyTableVO.getBkgBookingVO(), strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
					if (ifVOs.size() > 0) {
						bkgNonDgCgoTgtIfVOs.addAll(ifVOs);
					}
				}
				//02.
				else if ("BKG_CUSTOMER".equals(tableNm)) {
					List<BkgCustomerVO> vos = historyTableVO.getBkgCustomerVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgCustomer(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
				}
				//03.
				else if ("BKG_CNTC_PSON".equals(tableNm)) {
					List<BkgCntcPsonVO> vos = historyTableVO.getBkgCntcPsonVOs();
					for(int j=0; j<vos.size();j++){
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgCntcPson(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
				}
				//04.
				else if ("BKG_REFERENCE".equals(tableNm)) {
					List<BkgReferenceVO> vos = historyTableVO.getBkgReferenceVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgReference(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgReference(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//05.
				else if ("BKG_REF_DTL".equals(tableNm)) {
					List<BkgRefDtlVO> vos = historyTableVO.getBkgRefDtlVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgRefDtl(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgRefDtl(vos, bkgNo, strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}				
				//06.
				else if ("BKG_QUANTITY".equals(tableNm)) {
					List<BkgQuantityVO> vos = historyTableVO.getBkgQuantityVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgQuantity(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgQuantity(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//07.
				else if ("BKG_QTY_DTL".equals(tableNm)) {
					List<BkgQtyDtlVO> vos = historyTableVO.getBkgQtyDtlVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgQtyDtl(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgQtyDtl(vos, bkgNo, strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//08. caFlg = 'N' 일때만,  처리되도록 수정 
				else if ("N".equals(strCaFlg) && "BKG_CLZ_TM".equals(tableNm)) {
					List<BkgClzTmVO> vos = historyTableVO.getBkgClzTmVOs();		
					for (int j=0; j<vos.size(); j++) {				
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgClzTm(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
				}
				//09.
				else if ("BKG_VVD".equals(tableNm)) {
					List<BkgVvdVO> vos = historyTableVO.getBkgVvdVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgVvd(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgVvd(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//10.
				else if ("BKG_USA_CSTMS_FILE_NO".equals(tableNm)) {
					List<BkgUsaCstmsFileNoVO> vos = historyTableVO.getBkgUsaCstmsFileNoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgUsaCstmsFileNo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgUsaCstmsFileNo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//11. caFlg = 'N' 일때만,  처리되도록 수정 
				else if ("N".equals(strCaFlg) && "BKG_TRO".equals(tableNm)) {
					List<BkgTroVO> vos = null;
					if(historyTableVO.getOldBkgTroVOs() == null){
						vos = historyTableVO.getBkgTroVOs();
					} else {
						vos = historyTableVO.getOldBkgTroVOs();
					}
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgTro(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}	
					vos = historyTableVO.getBkgTroVOs();
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgTro(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//12. caFlg = 'N' 일때만,  처리되도록 수정 
				else if ("N".equals(strCaFlg) && "BKG_TRO_DTL".equals(tableNm)) {
					List<BkgTroDtlVO> vos = null;
					if(historyTableVO.getOldBkgTroVOs() == null){
						vos = historyTableVO.getBkgTroDtlVOs();
					} else {
						vos = historyTableVO.getOldBkgTroDtlVOs();
					}
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgTroDtl(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					vos = historyTableVO.getBkgTroDtlVOs();
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgTroDtl(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//13. 
/*				
				else if ("BKG_TRO_SPCL_CGO_SEQ".equals(tableNm)) {
					List<BkgTroSpclCgoSeqVO> vos = historyTableVO.getBkgTroSpclCgoSeqVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgTroSpclCgoSeq(vos.get(j), strCaFlg);
						histCtntVOs.addAll(tHistCtntVOs);
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgTroSpclCgoSeq(vos, bkgNo, strCaFlg); 
					histCtntVOs.addAll(tHistCtntVOs);
				}
*/ 
				//14. caFlg = 'N' 일때만,  처리되도록 수정 
				else if ("N".equals(strCaFlg) && "BKG_EUR_TRO".equals(tableNm)) {
					List<BkgEurTroVO> vos = historyTableVO.getBkgEurTroVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgEurTro(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgEurTro(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//15. caFlg = 'N' 일때만,  처리되도록 수정 
				else if ("N".equals(strCaFlg) && "BKG_EUR_TRO_DTL".equals(tableNm)) {
					List<BkgEurTroDtlVO> vos = historyTableVO.getBkgEurTroDtlVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgEurTroDtl(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgEurTroDtl(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//16. 
/* 
				else if ("BKG_EUR_TRO_DG_SEQ".equals(tableNm)) {
					List<BkgEurTroDgSeqVO> vos = historyTableVO.getBkgEurTroDgSeqVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgEurTroDtl(vos.get(j), strCaFlg);
						histCtntVOs.addAll(tHistCtntVOs);
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgEurTroDtl(vos, bkgNo, strCaFlg); 
					histCtntVOs.addAll(tHistCtntVOs);
				}
*/
				//17. 
				else if ("BKG_CONTAINER".equals(tableNm)) {
					List<BkgContainerVO> vos = historyTableVO.getBkgContainerVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgContainer(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgContainer(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//18. 
				else if ("BKG_CNTR_MF_DESC".equals(tableNm)) {
					List<BkgCntrMfDescVO> vos = historyTableVO.getBkgCntrMfDescVOs();
					
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgCntrMfDesc(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
						
						List<BkgNonDgCgoTgtIfVO> ifVOs = dbDao.searchCntrMfDescChgHis(vos.get(j), strCaFlg);
						if (ifVOs.size() > 0) { 
							bkgNonDgCgoTgtIfVOs.addAll(ifVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgCntrMfDesc(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					    
					    List<BkgNonDgCgoTgtIfVO> ifVOs = dbDao.searchNewCntrMfDescChgHis(vos, bkgNo, strCaFlg);
						if (ifVOs.size() > 0) {
							bkgNonDgCgoTgtIfVOs.addAll(ifVOs); 
						}
					}
				}
				//19. 
				else if ("BKG_CNTR_SEAL_NO".equals(tableNm)) {					
					List<BkgCntrSealNoVO> vos = historyTableVO.getBkgCntrSealNoVOs();
					log.debug("seal size:"+vos.size());
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgCntrSealNo(vos.get(j), strCaFlg);
						log.debug("seal update:"+histCtntVOs.size());
						if (tHistCtntVOs.size() > 0) {
							histCtntVOs.addAll(tHistCtntVOs);
						}
					}
//					if(vos.size()==0){
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgCntrSealNo(vos, bkgNo, null, strCaFlg);
						log.debug("seal update:"+histCtntVOs.size()); 
						if (tHistCtntVOs.size() > 0) {
							histCtntVOs.addAll(tHistCtntVOs);
						}
//					}
				}
				//20. 
				else if ("BKG_BL_DOC".equals(tableNm)) {
					historyTableVO.getBkgBlDocVO().setBkgNo(bkgNo);
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBlDoc(historyTableVO.getBkgBlDocVO(), strCaFlg);
					List<BkgNonDgCgoTgtIfVO> ifVOs = dbDao.searchCstmDescChgHis(historyTableVO.getBkgBlDocVO(), strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
					if (ifVOs.size() > 0) {
						bkgNonDgCgoTgtIfVOs.addAll(ifVOs);
					}
				}
				//21. 
				else if ("BKG_BL_MK_DESC".equals(tableNm)) {
					// 이전값
					BkgBlMkDescVO  oldDescVo = historyTableVO.getBkgBlMkDescVO();
					
					String oldMkDesc = "";
					String oldCmdtDesc = "";
					if(oldDescVo != null) {
						if(oldDescVo.getMkDesc() != null) oldMkDesc = oldDescVo.getMkDesc().replaceAll(" ", "");;
						if(oldDescVo.getCmdtDesc() != null) oldCmdtDesc = oldDescVo.getCmdtDesc().replaceAll(" ", "");;
					}		

					
					historyTableVO.getBkgBlMkDescVO().setBkgNo(bkgNo);
					
					//BKG_BL_MK_DESC에서 clob값들을 조회
					List<HistCtntVO> tHistCtntVOs = dbDao.searchBkgBlMkDescHis(historyTableVO.getBkgBlMkDescVO(), strCaFlg);
					List<HistCtntVO> nHistCtntVOs = new ArrayList<HistCtntVO>();
					// 새로운값
					String newMkDesc = "";
					String newCmdtDesc = "";
					
					for(HistCtntVO vo : tHistCtntVOs) {
						if("MARKS".equals(vo.getHisCateNm()))
							newMkDesc = vo.getCrntCtnt().replaceAll(" ", "");
						if("DESCRIPTION OF GOODS".equals(vo.getHisCateNm()))
							newCmdtDesc = vo.getCrntCtnt().replaceAll(" ", "");
					} 
					
					//BKG_BL_MK_DESC에서 clob이 아닌값들을 조회
					List<HistCtntVO> t1HistCtntVOs = dbDao.searchBkgBlMkDescHisForVar(historyTableVO.getBkgBlMkDescVO(), strCaFlg);
					
                    //Auto clause display대상일 경우 자동문구 제거 후 M&D히스토리 비교
                    if (t1HistCtntVOs.size() > 0) {
                           histCtntVOs.addAll(t1HistCtntVOs);
                           oldCmdtDesc = oldCmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY.replaceAll(" ", ""), "");
                           oldCmdtDesc = oldCmdtDesc.replace(Constants.CMDT_DESC_ATTD_SA.replaceAll(" ", ""), "");
                           oldCmdtDesc = oldCmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ.replaceAll(" ", ""), "");
                           log.debug(newCmdtDesc);
                           newCmdtDesc = newCmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY.replaceAll(" ", ""), "");   
                           newCmdtDesc = newCmdtDesc.replace(Constants.CMDT_DESC_ATTD_SA.replaceAll(" ", ""), "");     
                           newCmdtDesc = newCmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ.replaceAll(" ", ""), "");
                           log.debug(Constants.CMDT_DESC_ATTD_UY.replaceAll(" ", ""));
                    }


					//mkDesc 비교.
					if(oldMkDesc.compareTo(newMkDesc) != 0) {
						for(HistCtntVO vo : tHistCtntVOs) {
							if("MARKS".equals(vo.getHisCateNm())) {
//								vo.setPreCtnt(oldMkDesc);
								vo.setPreCtnt("");
								vo.setCrntCtnt("(Text Amended)");
								nHistCtntVOs.add(vo);
							}
						}
					}
					
					if(oldCmdtDesc.compareTo(newCmdtDesc) != 0) {
						for(HistCtntVO vo : tHistCtntVOs) {
							if("DESCRIPTION OF GOODS".equals(vo.getHisCateNm())) {
//								vo.setPreCtnt(oldCmdtDesc);
								vo.setPreCtnt("");
								vo.setCrntCtnt("(Text Amended)");
								nHistCtntVOs.add(vo);
							}
						}
						List<BkgNonDgCgoTgtIfVO> ifVOs = new ArrayList<BkgNonDgCgoTgtIfVO>();	
						BkgNonDgCgoTgtIfVO ifVO = new BkgNonDgCgoTgtIfVO();
						ifVO.setBkgNo(historyTableVO.getBkgBlMkDescVO().getBkgNo());
						ifVO.setBkgDescCngItmCd("5");
						ifVOs.add(ifVO);
						bkgNonDgCgoTgtIfVOs.addAll(ifVOs);
					}
					
					histCtntVOs.addAll(nHistCtntVOs);
					
					
				}
				//21. 
				//else if ("BKG_BL_MK_DESC".equals(tableNm)) {
					//20100406 clob 비교시 에러 문제로 주석처리함(류대영)
//					historyTableVO.getBkgBlMkDescVO().setBkgNo(bkgNo);
//					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBlMkDesc(historyTableVO.getBkgBlMkDescVO(), strCaFlg);
//					if (tHistCtntVOs.size() > 0) {
//					    histCtntVOs.addAll(tHistCtntVOs);
//					}
				//}
				//22. 
				else if ("BKG_RATE".equals(tableNm)) {
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgRate(historyTableVO.getBkgRateVO(), strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//23. 
				else if ("BKG_CHG_RT".equals(tableNm)) {
					List<BkgChgRtVO> vos = historyTableVO.getBkgChgRtVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgChgRt(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgChgRt(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//24. 
				else if ("BKG_DG_CGO".equals(tableNm)) {
					List<BkgDgCgoVO> vos = historyTableVO.getBkgDgCgoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgDgCgo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgDgCgo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//25. 
				else if ("BKG_RF_CGO".equals(tableNm)) {
					List<BkgRfCgoVO> vos = historyTableVO.getBkgRfCgoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgRfCgo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgRfCgo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//26. 
				else if ("BKG_AWK_CGO".equals(tableNm)) {
					List<BkgAwkCgoVO> vos = historyTableVO.getBkgAwkCgoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgAwkCgo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgAwkCgo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//27.
/* 				
				else if ("BKG_AWK_DIM".equals(tableNm)) {
				}
*/
				//28. 
				else if ("BKG_BB_CGO".equals(tableNm)) {
					List<BkgBbCgoVO> vos = historyTableVO.getBkgBbCgoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBbCgo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgBbCgo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//29. 
				else if ("BKG_XPT_IMP_LIC".equals(tableNm)) {
					List<BkgXptImpLicVO> vos = historyTableVO.getBkgXptImpLicVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgXptImpLic(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgXptImpLic(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//30. 
				else if ("BKG_HBL".equals(tableNm)) {
					List<BkgHblVO> vos = historyTableVO.getBkgHblVOs();
					
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgHbl(vos.get(j), strCaFlg);
						histCtntVOs.addAll(tHistCtntVOs);
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgHbl(vos, bkgNo, strCaFlg); 
					histCtntVOs.addAll(tHistCtntVOs);
				}
				//31. 
				else if ("BKG_HBL_CUST".equals(tableNm)) {
					List<BkgHblCustVO> vos = historyTableVO.getBkgHblCustVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgHblCust(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgHblCust(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//32. CA Start시, 처리되고 있는지 확인 할 것!!!!!!!!! 
				else if ("BKG_BL_ISS".equals(tableNm)) {
					historyTableVO.getBkgBlIssVO().setBkgNo(bkgNo);
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBlIss(historyTableVO.getBkgBlIssVO(), strCaFlg);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//33. BKG B/L Redemption 
				else if ("BKG_DOC_ISS_RDEM".equals(tableNm)) {
					List<BkgDocIssRdemVO> vos = historyTableVO.getBkgDocIssRdemVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgDocIssRdem(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgDocIssRdem(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				
			}
			
			String strHisSeq = ""; 
			//남길 history가 있을 때만 실행
			if(histCtntVOs.size()>0){
				//UI ID 별로 history를 남길 항목의 table 조회
				strHisSeq = dbDao.searchNextHistSeq(bkgNo);
				
				//-------------------------
				// add History Master
				//-------------------------
				BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
				bkgHisMstVO.setBkgNo        (bkgNo);
				bkgHisMstVO.setCorrNo       (strCaNo);
				bkgHisMstVO.setHisSeq       (strHisSeq);
				bkgHisMstVO.setBkgHisIssUiId(uiId);
				bkgHisMstVO.setCreUsrId     (account.getUsr_id());
				bkgHisMstVO.setUpdUsrId     (account.getUsr_id());
				dbDao.addBkgHisMst(bkgHisMstVO);
			}
			//-------------------------
			// add History Dtl
			//-------------------------
			List<BkgHisDtlVO> bkgHisDtlVOs = new ArrayList<BkgHisDtlVO>();			
            double nCnt = 0;
            String preCtnt = "";
            String crntCtnt = "";
            String cntrMfNo ="";
            
            boolean amsAiFlagMasterBL = false;
            boolean amsAiFlagMasterHBL = false;
            boolean amsAiFlagHblMaster = false;
            //@ US,CANADA 동시 적용으로 로직 수정 2017.12.12
//            boolean amsMISndFlag = false;
            
//            String amsAiDecInfo = dbDao.searchAmsAiDecisionInfo(bkgNo);
//            String amsAiDecInfos[] = null; // [0] : mi_snd_dt, [1] : USA_CSTMS_FILE_CD, [2] : CND_CSTMS_FILE_CD
//            String miSndDt = "";
//            String usaCstmsFileCd = "";
//            String cndCstmsFileCd = "";
            
//            if(!"".equals(amsAiDecInfo) ) {
//            	amsAiDecInfos = amsAiDecInfo.split(",");
//            	
//            	miSndDt = amsAiDecInfos[0];
//            	usaCstmsFileCd = amsAiDecInfos[1];
//            	cndCstmsFileCd = amsAiDecInfos[2];
//            	
//            }
//            
//            // 미세관 MI 전송 유무 판단 (master bl, house bl)
//        	if(!"".equals(miSndDt) ) {
//        		amsMISndFlag = true;
//        	}
            
            
			for (Iterator<HistCtntVO> iter = histCtntVOs.iterator(); iter.hasNext(); ) 
			{
				HistCtntVO histCtntVO = iter.next();
				
				BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
				bkgHisDtlVO.setBkgNo    (bkgNo);
				bkgHisDtlVO.setHisSeq   (strHisSeq);
				bkgHisDtlVO.setHisDtlSeq(Double.toString(++nCnt));				
				preCtnt = histCtntVO.getPreCtnt();
				
				//Content String Max 4000
				if(preCtnt.length() >= 4000) preCtnt = preCtnt.substring(0, 3999);
				crntCtnt = histCtntVO.getCrntCtnt();
				if(crntCtnt.length() >= 4000) crntCtnt = crntCtnt.substring(0, 3999);
				
				bkgHisDtlVO.setPreCtnt  (preCtnt);
				bkgHisDtlVO.setCrntCtnt (crntCtnt);
				bkgHisDtlVO.setHisCateNm(histCtntVO.getHisCateNm());
				bkgHisDtlVO.setCreUsrId (account.getUsr_id());
				bkgHisDtlVO.setUpdUsrId (account.getUsr_id());
				bkgHisDtlVOs.add(bkgHisDtlVO);
				
				
				if (!amsAiFlagMasterBL) {
					// MASTER BL
					amsAiFlagMasterBL = checkAmsAiMasterBl(histCtntVO, uiId);
				}
				if (!amsAiFlagMasterHBL) {
					amsAiFlagMasterHBL = checkAmsAiMasterHbl(histCtntVO, uiId);
					cntrMfNo = histCtntVO.getColumn1();
					if (amsAiFlagMasterHBL) {
						// HOUSE BL의 MASTER BL HISTORY 등록 여부
						amsAiFlagHblMaster = checkAmsAiMasterBl(histCtntVO);
					}
				}
				
				//@ US,CANADA 동시 적용으로 로직 수정 2017.12.12
//				if(amsMISndFlag) {
//					// 미세관 AI 전송 대상 유무 판단 (Master BL)
//					if(!amsAiFlagMasterBL) {
//						amsAiFlagMasterBL = checkAmsAiMasterBl(histCtntVO, usaCstmsFileCd, cndCstmsFileCd, uiId);
//						cntrMfNo = histCtntVO.getColumn1(); // cntr_mf_no (미세관 hbl no)
//					}
//					// 미세관 AI 전송 대상 유무 판단 (House BL)
//					amsAiFlagMasterHBL = false;
//					amsAiFlagMasterHBL = checkAmsAiMasterHbl(histCtntVO, usaCstmsFileCd, cndCstmsFileCd, uiId);
//					
//					if(amsAiFlagMasterHBL) {
//						
//						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
//						bkgDocProcSkdVO.setBkgNo(bkgNo); // bkg no
//						bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");// Amendment Transmit (AI) SEND
//						bkgDocProcSkdVO.setDiffRmk(histCtntVO.getColumn1()); // cntr_mf_no (미세관 hbl no)
//						bkgDocProcSkdVO.setEvntUsrId(("Y".equals(strCaFlg) ? "CA" : account.getUsr_id()));
//						bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
//						bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());					
//						
//						dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
//						
//						if( "Container No.(CNTR)".equals(histCtntVO.getHisCateNm()) 
//								|| "PKG/Weight/Measure(CNTR)".equals(histCtntVO.getHisCateNm())
//								|| "CNTR/VGM/Signature/Method".equals(histCtntVO.getHisCateNm())
//								|| "Container No.(CM)".equals(histCtntVO.getHisCateNm()) 
//								|| "PKG/Weight/Measure(CM)".equals(histCtntVO.getHisCateNm())
//								|| "M&D".equals(histCtntVO.getHisCateNm())
//								|| "HTS / HS".equals(histCtntVO.getHisCateNm())
//								
//								) {
//							// if문 만족시 master bl 히스토리도 등록
//							bkgDocProcSkdVO.setDiffRmk("Amendment Transmit (AI) SEND");
//							dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
//						}
//						
//					}
//					
//				}
			} // for (Iterator<HistCtntVO> end
			
			if (bkgHisDtlVOs.size() > 0) {
			    dbDao.addBkgHisDtl(bkgHisDtlVOs);
			}
			
			if (bkgNonDgCgoTgtIfVOs.size() > 0) {
			    dbDao.addNonDgCgoTgt(bkgNonDgCgoTgtIfVOs, strCaFlg); 
			}
			
//			// 미세관 AI 전송 히스토리 등록 (Master BL)
//			if(amsMISndFlag && amsAiFlagMasterBL) {
//				// BKG_DOC_PROC_SKD 테이블에 history 기록
//				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
//				bkgDocProcSkdVO.setBkgNo(bkgNo);
//				bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");// Amendment Transmit (AI) SEND
//				bkgDocProcSkdVO.setDiffRmk("Amendment Transmit (AI) SEND"); 
//				bkgDocProcSkdVO.setEvntUsrId(("Y".equals(strCaFlg) ? "CA" : account.getUsr_id()));
//				bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
//				bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());					
//				
//				dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
//				
//				// hbl no 가 있으면 hbl 히스토리도 등록
//				if(cntrMfNo != null && !"".equals(cntrMfNo) ) {
//					bkgDocProcSkdVO.setDiffRmk(cntrMfNo); // cntr_mf_no (미세관 hbl no)
//					dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
//				}
//			}
			
			//@ 변경 내용을 체크하여 US, CANADA 세관 업데이트 여부를 표시하고, 세관 전송 후 아래 입력되었던 부분들을 삭제 처리 한다.
			if (amsAiFlagMasterBL || amsAiFlagMasterHBL){
				// 미국, 캐나다 세관 history
				List<BkgCstmsAdvBlVO> listBl = dbDao.searchAmsAiDecisionInfoList(bkgNo);
				for (int i = 0; i < listBl.size(); i++) {
					BkgCstmsAdvBlVO blVO = listBl.get(i);
					
					BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo(bkgNo);
					bkgDocProcSkdVO.setBkgDocProcTpCd(blVO.getBkgDocProcTpCd());
					bkgDocProcSkdVO.setEvntUsrId(("Y".equals(strCaFlg) ? "CA" : account.getUsr_id()));
					bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
					bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
	
					// House BL체크
					if (amsAiFlagMasterHBL && "1".equals(blVO.getCstmsFileTpCd())) {
						bkgDocProcSkdVO.setDiffRmk(cntrMfNo); // cntr_mf_no (미세관 hbl no)
	
						if (blVO.getBlNo().equals(cntrMfNo)) {
							dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
						} else if ("".equals(blVO.getMfNo()) && amsAiFlagHblMaster) {
							// Master BL 정보 등록
							bkgDocProcSkdVO.setDiffRmk("Amendment Transmit (AI) SEND");
							dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
						}
						
					} else if (amsAiFlagMasterBL) {
						
						bkgDocProcSkdVO.setDiffRmk("Amendment Transmit (AI) SEND");
	
						if ("".equals(blVO.getMfNo())) {
							dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
						} else if (blVO.getBlNo().equals(cntrMfNo)) {
							// Master BL의 House BL 등록
							bkgDocProcSkdVO.setDiffRmk(cntrMfNo);
							dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
						}
					}
				}// for end		
			}// if(amsAiFlagMasterBL || amsAiFlagMasterHBL)  End
			
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 미세관 AI 대상 유무 판단 (Master BL)
	 * HistCtntVO histCtntVO
	 * @param HistCtntVO histCtntVO
	 * @param String usaCstmsFileCd
	 * @param String cndCstmsFileCd
	 */
	private boolean checkAmsAiMasterBl(HistCtntVO histCtntVO, String usaCstmsFileCd, String cndCstmsFileCd, String uiId) {
		
		boolean amsAiFlag = false;

		
		if(!"ESM_BKG_0366".equals(uiId) && ("ROUTE".equals(histCtntVO.getHisCateNm()) 
					|| "VVD".equals(histCtntVO.getHisCateNm())
					|| "PACKAGE".equals(histCtntVO.getHisCateNm()) 
					|| histCtntVO.getHisCateNm().endsWith("NM") 
					|| histCtntVO.getHisCateNm().endsWith("ADDR") 
					|| histCtntVO.getHisCateNm().endsWith("CT/ST/CN/ZIP") 
					|| "Container No.(CNTR)".equals(histCtntVO.getHisCateNm()) 
					|| "PKG/Weight/Measure(CNTR)".equals(histCtntVO.getHisCateNm())
					|| "CNTR/VGM/Signature/Method".equals(histCtntVO.getHisCateNm())
					|| "Container No.(CM)".equals(histCtntVO.getHisCateNm()) 
					|| "PKG/Weight/Measure(CM)".equals(histCtntVO.getHisCateNm())
					|| "M&D".equals(histCtntVO.getHisCateNm())
					|| "HTS / HS".equals(histCtntVO.getHisCateNm())
					|| "Manifest File No.".equals(histCtntVO.getHisCateNm())
					|| "SEAL No.".equals(histCtntVO.getHisCateNm()) )
				) {
			amsAiFlag = true;
			
		}
		
		return amsAiFlag;
	}
	
	/**
	 * 미세관 AI 대상 유무 판단 (House BL)
	 * HistCtntVO histCtntVO
	 * @param HistCtntVO histCtntVO
	 * @param String usaCstmsFileCd
	 * @param String cndCstmsFileCd
	 */
	private boolean checkAmsAiMasterHbl(HistCtntVO histCtntVO, String usaCstmsFileCd, String cndCstmsFileCd, String uiId) {
		
		boolean amsAiFlag = false;

		if("ESM_BKG_0366".equals(uiId) && ("1".equals(usaCstmsFileCd) || "1".equals(cndCstmsFileCd)) ) {
			if(histCtntVO.getHisCateNm().startsWith("HOUSE B/L") 
					|| "Container No.(CNTR)".equals(histCtntVO.getHisCateNm()) 
					|| "PKG/Weight/Measure(CNTR)".equals(histCtntVO.getHisCateNm())
					|| "CNTR/VGM/Signature/Method".equals(histCtntVO.getHisCateNm())
					|| "Container No.(CM)".equals(histCtntVO.getHisCateNm()) 
					|| "PKG/Weight/Measure(CM)".equals(histCtntVO.getHisCateNm())
					|| "M&D".equals(histCtntVO.getHisCateNm())
					|| "HTS / HS".equals(histCtntVO.getHisCateNm())
					
					) {
				amsAiFlag = true;
			}
		}
		
		return amsAiFlag;
	}
	
	
	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history를 만든다<br>
	 * EAI I/F WEB006 용 메소드 (account정보가 없기 때문에 복제 생성)<br>
	 * @author Kim Jong ho
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  String webId
	 * @param  String porCd
	 * @exception EventException
	 */
	public void eaiManageBookingHistory(String uiId, HistoryTableVO historyTableVO, String webId, String porCd) throws EventException {
		try
		{
			List<HistCtntVO> histCtntVOs = new ArrayList<HistCtntVO>();
			
			String bkgNo    = historyTableVO.getBkgBlNoVO().getBkgNo();  //bkg_no, ca_flag 필수 setting 					
			String strCaFlg = JSPUtil.getNullNoTrim(historyTableVO.getBkgBlNoVO().getCaFlg());
			String strCaNo  = JSPUtil.getNullNoTrim(historyTableVO.getBkgBlNoVO().getCaNo());
			if ("Y".equals(strCaFlg)) {
				strCaNo = "TMP0000001";
				historyTableVO.getBkgBlNoVO().setCaNo(strCaNo); 
			}
			
			//historyTableVO.getBkgBlNoVO().getCaNo() 값이 안 넘어 왔을 경우, 메세지(or default) 처리 
			if (!"Y".equals(strCaFlg) && !"N".equals(strCaFlg)) { 	
				strCaFlg = "N";  				
			}
log.debug("@@@@@@BCImpl : Checking TempHistory.");			
			//caFlg='Y'이면, TempHistory 삭제 후, 재생성 
			if ("Y".equals(strCaFlg)) {
				//01. 
				dbDao.removeHisDtlByUiId(historyTableVO.getBkgBlNoVO(), uiId);
				//02. 
				dbDao.removeHisMstByUiId(historyTableVO.getBkgBlNoVO(), uiId);
log.debug("@@@@@@BCImpl : Removing previous TempHistory."); 
			}
			
			List<TableListVO> tableListVOs = historyTableVO.getTableListVOs();
			
			for(int i=0; i<tableListVOs.size(); i++) 
			{
				String tableNm = tableListVOs.get(i).getTableNm();
				
		
				if ("BKG_XPT_IMP_LIC".equals(tableNm)) {
					List<BkgXptImpLicVO> vos = historyTableVO.getBkgXptImpLicVOs();
					for (int j=0; j<vos.size(); j++) {
log.debug("@@@@@@BCImpl : dbDao.searchHistBkgXptImpLic(vos.get(j), strCaFlg)");
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgXptImpLic(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
log.debug("@@@@@@BCImpl : dbDao.searchHistNewBkgXptImpLic(vos, bkgNo, strCaFlg)");
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgXptImpLic(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}else {
log.debug("@@@@@@BCImpl : tableNm is not BKG_XPT_IMP_LIC");
				}
			}
			
			String strHisSeq = ""; 
log.debug("@@@@@@BCImpl : checking bkgHisDtlVOs.size() : MASTER");
			//남길 history가 있을 때만 실행
			if(histCtntVOs.size()>0){
				//UI ID 별로 history를 남길 항목의 table 조회
log.debug("@@@@@@BCImpl : dbDao.searchNextHistSeq(bkgNo)");
				strHisSeq = dbDao.searchNextHistSeq(bkgNo);
				
				//-------------------------
				// add History Master
				//-------------------------
				BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
				bkgHisMstVO.setBkgNo        (bkgNo);
				bkgHisMstVO.setCorrNo       (strCaNo);
				bkgHisMstVO.setHisSeq       (strHisSeq);
				bkgHisMstVO.setBkgHisIssUiId(uiId);
				bkgHisMstVO.setCreUsrId     ("WEB");//EAI I/F의 경우 
				bkgHisMstVO.setUpdUsrId     (webId);//EAI I/F의 경우
				bkgHisMstVO.setPorCd		(porCd);//EAI I/F의 경우
				
log.debug("@@@@@@BCImpl : dbDao.addBkgHisMst(bkgHisMstVO)");
				dbDao.addBkgHisMst(bkgHisMstVO);
			}
			//-------------------------
			// add History Dtl
			//-------------------------
			List<BkgHisDtlVO> bkgHisDtlVOs = new ArrayList<BkgHisDtlVO>();			
            double nCnt = 0;
            String preCtnt = "";
            String crntCtnt = "";
			for (Iterator<HistCtntVO> iter = histCtntVOs.iterator(); iter.hasNext(); ) 
			{
				HistCtntVO histCtntVO = iter.next();
				
				BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
				bkgHisDtlVO.setBkgNo    (bkgNo);
				bkgHisDtlVO.setHisSeq   (strHisSeq);
				bkgHisDtlVO.setHisDtlSeq(Double.toString(++nCnt));				
				preCtnt = histCtntVO.getPreCtnt();
				
				//Content String Max 4000
				if(preCtnt.length() >= 4000) preCtnt = preCtnt.substring(0, 3999);
				crntCtnt = histCtntVO.getCrntCtnt();
				if(crntCtnt.length() >= 4000) crntCtnt = crntCtnt.substring(0, 3999);
				
				bkgHisDtlVO.setPreCtnt  (preCtnt);
				bkgHisDtlVO.setCrntCtnt (crntCtnt);
				bkgHisDtlVO.setHisCateNm(histCtntVO.getHisCateNm());
				bkgHisDtlVO.setCreUsrId ("WEB");//EAI I/F의 경우 
				bkgHisDtlVO.setUpdUsrId (webId);//EAI I/F의 경우 
				bkgHisDtlVOs.add(bkgHisDtlVO);
			}
log.debug("@@@@@@BCImpl : checking bkgHisDtlVOs.size() : DETAIL");
			if (bkgHisDtlVOs.size() > 0) {
log.debug("@@@@@@BCImpl : dbDao.addBkgHisDtl(bkgHisDtlVOs)");
			    dbDao.addBkgHisDtl(bkgHisDtlVOs);
			}
			
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking Line History를 생성한다<br> 
	 *
	 * @author Lee NamKyung
	 * @param  HistoryLineVO historyLineVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException {
		try
		{
			if ("Y".equals(historyLineVO.getCaFlg())) {
				return;
			}
			// bkg_his_mst의 다음 seq 조회
			String strHisSeq = dbDao.searchNextHistSeq(historyLineVO.getBkgNo());
			
			//-------------------------
			// add History Master
			//-------------------------
			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
			bkgHisMstVO.setBkgNo(historyLineVO.getBkgNo());
			bkgHisMstVO.setHisSeq(strHisSeq);			
			bkgHisMstVO.setBkgHisIssUiId(historyLineVO.getUiId());
			bkgHisMstVO.setCorrNo(historyLineVO.getCorrNo());
			
			if(account==null){
				bkgHisMstVO.setCreUsrId("SYSTEM");
				bkgHisMstVO.setUpdUsrId("SYSTEM");
			} else {
				bkgHisMstVO.setCreUsrId(account.getUsr_id());
				bkgHisMstVO.setUpdUsrId(account.getUsr_id());
			}
			dbDao.addBkgHisMst(bkgHisMstVO);
						
			//-------------------------
			// add History Dtl Line
			//-------------------------		
			BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
			bkgHisDtlVO.setBkgNo    (historyLineVO.getBkgNo());
			bkgHisDtlVO.setHisSeq   (strHisSeq);
			//bkgHisDtlVO.setHisDtlSeq();  //query에서 계산
			//bkgHisDtlVO.setPreCtnt  ();  //사용않함 
			bkgHisDtlVO.setCrntCtnt (historyLineVO.getCrntCtnt()); 
			bkgHisDtlVO.setPreCtnt  (historyLineVO.getPreCtnt());
			bkgHisDtlVO.setHisCateNm(historyLineVO.getHisCateNm());	

			if(account==null){
				bkgHisDtlVO.setCreUsrId("SYSTEM");
				bkgHisDtlVO.setUpdUsrId("SYSTEM");
			} else {
				bkgHisDtlVO.setCreUsrId (account.getUsr_id());
				bkgHisDtlVO.setUpdUsrId (account.getUsr_id());
			}
			dbDao.addBkgHisDtlLine(bkgHisDtlVO);  
			
			String bkgDocProcTpCd = JSPUtil.getNullNoTrim(historyLineVO.getBkgDocProcTpCd());
			if (!"".equals(bkgDocProcTpCd)) {
				//-------------------------
				// update : 기존동일type delete 처리 
				//-------------------------	
			    dbDao.cancelBkgDocProcSkd(bkgDocProcTpCd, historyLineVO.getBkgNo(), account);
			 
				//-------------------------
				// add : Bkg_Doc_Proc_Skd
				//-------------------------	
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(historyLineVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd(historyLineVO.getBkgDocProcTpCd());
				if(account==null){
					bkgDocProcSkdVO.setEvntUsrId("SYSTEM");
					//DiffRmk : query
					//bkgDocProcSkdVO.setBkgEvntCd1();  //사용않함 
					//bkgDocProcSkdVO.setBkgEvntCd2();  //사용않함 
					bkgDocProcSkdVO.setCreUsrId("SYSTEM");
					bkgDocProcSkdVO.setUpdUsrId("SYSTEM");
				} else {
					bkgDocProcSkdVO.setEvntUsrId(account.getUsr_id());
					//DiffRmk : query
					//bkgDocProcSkdVO.setBkgEvntCd1();  //사용않함 
					//bkgDocProcSkdVO.setBkgEvntCd2();  //사용않함 
					bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
					bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
				}
				dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 이력을 생성한다.<br> 
	 *
	 * @author Lee NamKyung
	 * @param  BkgMfCstmsHisVO bkgMfCstmsHisVO
	 * @exception EventException
	 */
	public void createCustomsHistory(BkgMfCstmsHisVO bkgMfCstmsHisVO) throws EventException {
		try
		{
			//UI ID 별로 history를 남길 항목의 table 조회
			String strHisSeq = dbDao.searchNextHistSeq(bkgMfCstmsHisVO.getBkgNo());
			
			//-------------------------
			// add History Master
			//-------------------------
			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
			bkgHisMstVO.setBkgNo(bkgMfCstmsHisVO.getBkgNo());
			bkgHisMstVO.setHisSeq(strHisSeq);
			//bkgHisMstVO.setBkgHisIssUiId();  //사용않함:customs master
			bkgHisMstVO.setCreUsrId(bkgMfCstmsHisVO.getCreUsrId());
			bkgHisMstVO.setUpdUsrId(bkgMfCstmsHisVO.getUpdUsrId());
			dbDao.addBkgHisMst(bkgHisMstVO);
						
			//-------------------------
			// add History Customs
			//-------------------------	
			bkgMfCstmsHisVO.setHisSeq  (strHisSeq);
			bkgMfCstmsHisVO.setCreUsrId(bkgMfCstmsHisVO.getCreUsrId());
			bkgMfCstmsHisVO.setUpdUsrId(bkgMfCstmsHisVO.getUpdUsrId());
			dbDao.addCustomsHistory(bkgMfCstmsHisVO); 

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking History : manageDocProcess<br> 
	 * bkg별 주요 event에 대한 history를 생성한다<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocProcess(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException {
		try {
			//-------------------------
			// update : 기존동일type delete 처리 
			//-------------------------	
			if(!"N".equals(bkgDocProcSkdVO.getPairFlg())){
				dbDao.cancelBkgDocProcSkd(bkgDocProcSkdVO.getBkgDocProcTpCd(), bkgDocProcSkdVO.getBkgNo(), account);
			}
			
			
			//-------------------------
			// add : Bkg_Doc_Proc_Skd
			//-------------------------	
			bkgDocProcSkdVO.setEvntUsrId(account.getUsr_id());
			//DiffRmk : query
			//bkgDocProcSkdVO.setBkgEvntCd1();  //사용않함 
			//bkgDocProcSkdVO.setBkgEvntCd2();  //사용않함 
			bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
			bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
			dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking History : manageDocProcFlag<br> 
	 * bkg별 주요 event에 대한 Flag를 관리한다<br> 
	 *
	 * @author Ryu Dae Young
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocProcFlag(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException{
		try {
			bkgDocProcSkdVO.setEvntUsrId(account.getUsr_id());
			bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
			bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
			if(bkgDocProcSkdVO.getDocPerfDeltFlg().equals("Y")){				
				dbDao.cancelBkgDocProcSkd(bkgDocProcSkdVO.getBkgDocProcTpCd(), bkgDocProcSkdVO.getBkgNo(), account);
			} else { 			
				dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
	 * Booking History : Temp History Data 일괄삭제 <br>  
	 * c/a cancel시 실행됨<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception EventException
	 */
	public void removeTmpHistory(BkgBlNoVO vo) throws EventException {
		try {
			//01. 
			dbDao.removeTmpHisDtl(vo);	
			//02. 
			dbDao.removeTmpHisMst(vo);
			//03. 
			dbDao.removeAIFlagBkgDocProcSkd(vo);
			//04.
			dbDao.modifyNonDgCgoTgt(vo.getBkgNo(), null, "C", "A");

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking History : releaseCntrFinalConfirm<br>  
	 * container confirm 이력을 생성한다.<br>
	 *
	 * @author Ryu Dae Young
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void releaseCntrFinalConfirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try
		{
			//-------------------------
			// 마지막 container final confirm 상태를 조회함
			//-------------------------	
			String finalConfirm = dbDao.searchCntrFinalConfirm(bkgBlNoVO);
			
			//-------------------------			
			// 기존 상태가 Confirm 상태인 경우
			//-------------------------			
			if ("CNTCFM".equals(finalConfirm)){
				//기존 Container final confirm cancel
				dbDao.cancelBkgDocProcSkd(finalConfirm, bkgBlNoVO.getBkgNo(), account);
				
				//Container final confirm release로 insert
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setEvntUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setBkgDocProcTpCd("CNTRLS");
				
				dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking History : C/A No Update<br>
	 * c/a confirm시 실행됨<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyCaCorrNoForHistory(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {	
			dbDao.removeCorrDupHistory(bkgBlNoVO);
			dbDao.modifyCaCorrNoForHistory(bkgBlNoVO);
			dbDao.modifyNonDgCgoTgt(bkgBlNoVO.getBkgNo(), null, "C", "N");
			dbDao.modifyCACnfAIFlagBkgDocProcSkd(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	/**
	 * MQ 연동 처리(UBIZHJS_ALPSBKG_USTMNL_ACK)<br>
	 * 미주 terminal edi 수신 이력<br>
	 *
	 * @param String rcvMsg
	 * @exception EventException
	 */
	public void receiptUsaTmlEdiAck(String rcvMsg) throws EventException {
		try {
			BkgTmlEdiHisVO bkgTmlEdiHisVO = new BkgTmlEdiHisVO();
			String columnNm = null;
			String columnVal = null;
	        String[] rcvMsgS = rcvMsg.split("\n");
			log.debug("rcvMsg :" + rcvMsgS.length + " lines");
			
			//sample
//			"$$$MSGSTART\n" + 
//			"EDI_REF_NO:BKG091029002019\n" + 
//			"BKG_NO:PHXY9010014\n" +
//			"BKG_NO_SPLIT:\n" +
//			"TML_STS_CD:A\n" +
//			"TML_ERR_MESG:error\n" +
//			"TML_RSPN_DT:200910292000\n";
			
			for(int i=1;i<rcvMsgS.length;i++) {
				rcvMsgS[i] = JSPUtil.removeCharacter(rcvMsgS[i], "\n");
				rcvMsgS[i] = JSPUtil.removeCharacter(rcvMsgS[i], "\r");
				if (rcvMsgS[i].indexOf(":") > 0) {
					log.debug("rcvMsgS:"+rcvMsgS[i]);
					String[] valueStr = new String[2];
			        valueStr[0] = rcvMsgS[i].substring(0, rcvMsgS[i].indexOf(":"));
			        valueStr[1] = rcvMsgS[i].substring(rcvMsgS[i].indexOf(":")+1, rcvMsgS[i].length());
			        columnNm = ("".equals(JSPUtil.getNullNoTrim(valueStr[0])))?"":valueStr[0];
			        columnVal = ("".equals(JSPUtil.getNullNoTrim(valueStr[1])))?"":valueStr[1];

					if ( "TML_STS_CD".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlRspnStsCd(columnVal);
					} else if ( "TML_ERR_MESG".equals(columnNm) ) {
						bkgTmlEdiHisVO.setErrMsg(columnVal);
					} else if ( "TML_RSPN_DT".equals(columnNm) ) {
						bkgTmlEdiHisVO.setRspnDt(columnVal);
					} else if ( "EDI_REF_NO".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlEdiRqstNo(columnVal);
					} else if ( "BKG_NO".equals(columnNm) ) {
						bkgTmlEdiHisVO.setBkgNo(columnVal);
					}
				}
			}

			if ( bkgTmlEdiHisVO != null ) {
				dbDao.receiptUsaTmlEdiAck(bkgTmlEdiHisVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 한국세관 BOOKING HISTORY 추가<br>
	 * 범용으로 사용가능<br>
	 * 
	 * @param BkgHisMstVO bkgHisMstVO
	 * @param BkgHisDtlVO bkgHisDtlVO
	 * @throws EventException
	 */
	public void createBkgHisMst(BkgHisMstVO bkgHisMstVO, BkgHisDtlVO bkgHisDtlVO) throws EventException {
		try {
			// 파라메터로 넘기기위한 list 객체
			List<BkgHisDtlVO> bkgHisDtlVOs = new ArrayList<BkgHisDtlVO>();
			bkgHisDtlVOs.add(bkgHisDtlVO);
			
			// Master Insert
			dbDao.addBkgHisMst(bkgHisMstVO);
			
			// Detail Insert
			dbDao.addBkgHisDtl(bkgHisDtlVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Split source booking의 history의 correction no를 변경한다<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String lstCorrNo
	 * @throws EventException
	 */
	public void modifyCorrNo(BkgBlNoVO bkgBlNoVO, String lstCorrNo) throws EventException{
		try {
			dbDao.modifyCorrNo(bkgBlNoVO, lstCorrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history 를 만든다<br>
	 *
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCtmMvmtIrrFlg(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException {
		try
		{
			// ESM_BKG_0901 팝업에서 clear 한 History 기록
			List<BkgEtcHisVO> tHistCtntVOs = historyTableVO.getBkgEtcHisVOs(); 
			BkgEtcHisVO bkgEtcHisVO = null;
			String strHisSeq = "";
			
			boolean oneFlag = true;
			
			if (tHistCtntVOs.size() > 0) {
				
				if(oneFlag) {
					
					bkgEtcHisVO = tHistCtntVOs.get(0);
					//UI ID 별로 history를 남길 항목의 table 조회
					strHisSeq = dbDao.searchNextHistSeq(bkgEtcHisVO.getBkgNo());
					
					//-------------------------
					// add History Master
					//-------------------------
					BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
					bkgHisMstVO.setBkgNo        (bkgEtcHisVO.getBkgNo());
					bkgHisMstVO.setCorrNo       (bkgEtcHisVO.getCorrNo());
					bkgHisMstVO.setHisSeq       (strHisSeq);
					bkgHisMstVO.setBkgHisIssUiId(uiId);
					bkgHisMstVO.setCreUsrId     (account.getUsr_id());
					bkgHisMstVO.setUpdUsrId     (account.getUsr_id());
					dbDao.addBkgHisMst(bkgHisMstVO);
					
					oneFlag = false;
				}

				//-------------------------
				// add History Dtl
				//-------------------------
				List<BkgHisDtlVO> bkgHisDtlVOs = new ArrayList<BkgHisDtlVO>();			
	            double nCnt = 0;
	            
	            BkgEtcHisVO vo = null;
	        	for (Iterator<BkgEtcHisVO> iter = tHistCtntVOs.iterator(); iter.hasNext(); ) {
	        		vo = iter.next();
	            
					BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
					bkgHisDtlVO.setBkgNo    (vo.getBkgNo());
					bkgHisDtlVO.setHisSeq   (strHisSeq);
					bkgHisDtlVO.setHisDtlSeq(Double.toString(++nCnt));				
					bkgHisDtlVO.setPreCtnt  (vo.getPreCtnt());
					bkgHisDtlVO.setCrntCtnt (vo.getCrntCtnt());
					bkgHisDtlVO.setHisCateNm(vo.getHisCateNm());
					bkgHisDtlVO.setCreUsrId (account.getUsr_id());
					bkgHisDtlVO.setUpdUsrId (account.getUsr_id());
					bkgHisDtlVOs.add(bkgHisDtlVO);
				}

	        	if (bkgHisDtlVOs.size() > 0) {
				    dbDao.addBkgHisDtl(bkgHisDtlVOs);
				}
			}
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * bkg별 주요 AI event에 대한 Flag를 관리한다<br> 
	 *
	 * @author Jong Yun Kyoung
	 * @param  String mfNo
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @exception EventException
	 */
	public void manageDocProcAIFlag(String mfNo, BkgDocProcSkdVO bkgDocProcSkdVO) throws EventException{
		try {
			dbDao.updateAIFlagCancelBkgDocProcSkd(mfNo, bkgDocProcSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * BKG_NON_DG_CGO_TGT_IF 에 BKG정보를 등록한다.
	 * @param bkgNonDgCgoTgtIfVO
	 * @throws EventException
	 */
	public void createNonDgCgoTgt(BkgNonDgCgoTgtIfVO bkgNonDgCgoTgtIfVO) throws EventException {
		try
		{
			List<BkgNonDgCgoTgtIfVO> vos = new ArrayList<BkgNonDgCgoTgtIfVO>();
			vos.add(bkgNonDgCgoTgtIfVO);
			if (vos.size() > 0) {
			    dbDao.addNonDgCgoTgt(vos,"N");
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * SCG인터페이스 푸 인터페이스 플래그를 Y로 변경
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String asFlg
	 * @param String toFlg
	 * @throws EventException
	 */
	public void modifyNonDgCgoTgt(String bkgNo, String cntrNo, String asFlg, String toFlg) throws EventException {
		try {
			dbDao.modifyNonDgCgoTgt(bkgNo, cntrNo, asFlg, toFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * container 화면에서 container a가 b로 바로변경 되었을 때 BKG_DOC_PROC_SKD테이블에서 업데이트
	 * @param BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBkgDocProcSkdForCntatc(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException {
		try {	
			bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyBkgDocProcSkdForCntatc(bkgDocProcSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	
	/**
	 * C/A를 위해 해당 bkg의 table들을 복사한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String copyTypeCd
	 * @throws EventException
	 */
	public void createHisCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				// 01.
				dbDao.removeDocProcSkdCA(bkgBlNoVO, copyTypeCd);
			}

			// 01.
			dbDao.createDocProcSkdCA(bkgBlNoVO, copyTypeCd);


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * C/A를 위해 HIS 관련 table을 삭제한다.
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			//01. 
			dbDao.removeDocProcSkdCA(bkgBlNoVO, copyTypeCd);
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}  
	
	
	
    /**
     * BKG history유무를 조회한다.
     * @param BkgBlNoVO bkgBlNoVO
     * @param String uiId
     * @return String
     * @throws EventException
     */
	public String searchBkgHistory(BkgBlNoVO bkgBlNoVO, String uiId) throws EventException{
		try {
			return dbDao.searchBkgHistory(bkgBlNoVO, uiId);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
		
    }
	
	/**
	 * OB/L history 생성
	 * @param oldBl
	 * @throws EventException
	 */
	public void bkgInetBlOblSerNoHistory(List<BkgInetBlPrnAuthVO> oldBl, String bkgNo, String uiId, SignOnUserAccount account) throws EventException {
		List<HistCtntVO> histCtntVOs = new ArrayList<HistCtntVO>();
		try {
			for (int i = 0; i < oldBl.size(); i++) {
				List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgInetBlPrnAuth(oldBl.get(i));
				if (tHistCtntVOs.size() > 0) {
				    histCtntVOs.addAll(tHistCtntVOs);
				}
			}
			String strHisSeq = ""; 
			//남길 history가 있을 때만 실행
			
			if(histCtntVOs.size()>0){
				//UI ID 별로 history를 남길 항목의 table 조회
				strHisSeq = dbDao.searchNextHistSeq(bkgNo);
				
				//-------------------------
				// add History Master
				//-------------------------
				BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
				bkgHisMstVO.setBkgNo        (bkgNo);
				bkgHisMstVO.setCorrNo       ("");
				bkgHisMstVO.setHisSeq       (strHisSeq);
				bkgHisMstVO.setBkgHisIssUiId(uiId);
				bkgHisMstVO.setCreUsrId     (account.getUsr_id());
				bkgHisMstVO.setUpdUsrId     (account.getUsr_id());
				dbDao.addBkgHisMst(bkgHisMstVO);
			}
			
			// add History Dtl
			List<BkgHisDtlVO> bkgHisDtlVOs = new ArrayList<BkgHisDtlVO>();
			double nCnt = 0;
			String preCtnt = "";
			String crntCtnt = "";
			for (int i = 0; i < histCtntVOs.size(); i++) {
				BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
				HistCtntVO histCtntVO = histCtntVOs.get(i);
				bkgHisDtlVO.setBkgNo(bkgNo);
				bkgHisDtlVO.setHisSeq(strHisSeq);
				bkgHisDtlVO.setHisDtlSeq(Double.toString(++nCnt));
				preCtnt = histCtntVO.getPreCtnt();
				crntCtnt = histCtntVO.getCrntCtnt();
				bkgHisDtlVO.setPreCtnt(preCtnt);
				bkgHisDtlVO.setCrntCtnt(crntCtnt);
				bkgHisDtlVO.setHisCateNm(histCtntVO.getHisCateNm());
				bkgHisDtlVO.setCreUsrId(account.getUsr_id());
				bkgHisDtlVO.setUpdUsrId(account.getUsr_id());
				bkgHisDtlVOs.add(bkgHisDtlVO);
			}
			
			if (bkgHisDtlVOs.size() > 0) {
				dbDao.addBkgHisDtl(bkgHisDtlVOs);
			}
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}
	
	/**
	 * 2017.04.10 ADD FILER Add
	 * 미세관 AI 대상 유무 판단 (Master BL)
	 * HistCtntVO histCtntVO
	 * @param HistCtntVO histCtntVO
	 * @param String uiId
	 */
	private boolean checkAmsAiMasterBl(HistCtntVO histCtntVO, String uiId) {
		boolean amsAiFlag = false;
		if(!"ESM_BKG_0366".equals(uiId)) {
			if (histCtntVO.getHisCateNm().startsWith("ROUTE") 
					|| histCtntVO.getHisCateNm().startsWith("VVD")
					|| histCtntVO.getHisCateNm().startsWith("PACKAGE") 
					|| histCtntVO.getHisCateNm().endsWith("NM") 
					|| histCtntVO.getHisCateNm().endsWith("ADDR") 
					|| histCtntVO.getHisCateNm().endsWith("CT/ST/CN/ZIP") 
					|| histCtntVO.getHisCateNm().startsWith("Container No.")
					|| histCtntVO.getHisCateNm().startsWith("PKG/Weight/Measure")
					|| histCtntVO.getHisCateNm().startsWith("M&D")
					|| histCtntVO.getHisCateNm().startsWith("HTS / HS / NCM")
					|| histCtntVO.getHisCateNm().startsWith("Manifest File No.")
					|| histCtntVO.getHisCateNm().startsWith("SEAL No.")
					|| histCtntVO.getHisCateNm().startsWith("FILER")) {
				amsAiFlag = true;
			}
		}
		return amsAiFlag;
	}
	
	/**
	 * 미세관 AI 대상 유무 판단 (House BL)
	 * HistCtntVO histCtntVO
	 * @param HistCtntVO histCtntVO
	 * @param String uiId
	 * @return boolean
	 */
	private boolean checkAmsAiMasterHbl(HistCtntVO histCtntVO, String uiId) {
		boolean amsAiFlag = false;
		if("ESM_BKG_0366".equals(uiId)) {
			if(histCtntVO.getHisCateNm().startsWith("HOUSE B/L") 
					|| histCtntVO.getHisCateNm().startsWith("Container No.")
					|| histCtntVO.getHisCateNm().startsWith("PKG/Weight/Measure")
					|| histCtntVO.getHisCateNm().startsWith("M&D")
					|| histCtntVO.getHisCateNm().startsWith("HTS / HS / NCM")) {
				amsAiFlag = true;
			}
		}
		return amsAiFlag;
	}

	/**
	 * 미세관 AI 대상 유무 판단 (House BL)
	 * @param histCtntVO
	 * @return boolean
	 */
	private boolean checkAmsAiMasterBl(HistCtntVO histCtntVO) {
		boolean amsAiFlag = false;

		if(histCtntVO.getHisCateNm().startsWith("Container No.")
				|| histCtntVO.getHisCateNm().startsWith("PKG/Weight/Measure")
				|| histCtntVO.getHisCateNm().startsWith("M&D")
				|| histCtntVO.getHisCateNm().startsWith("HTS / HS")) {
				amsAiFlag = true;
		}
		return amsAiFlag;
	}
}