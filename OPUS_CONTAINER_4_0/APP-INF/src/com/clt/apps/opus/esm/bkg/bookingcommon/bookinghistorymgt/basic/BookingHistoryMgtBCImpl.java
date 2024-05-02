/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingHistoryMgtBCImpl.java
 *@FileTitle : Booking_History_Mgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgTmlEdiHisVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.TableListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgAwkCgoVO;
import com.clt.syscommon.common.table.BkgAwkDimVO;
import com.clt.syscommon.common.table.BkgBbCgoVO;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgBlMkDescVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgChgRtVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgCstmsAdvBlVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.BkgDocIssRdemVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;
import com.clt.syscommon.common.table.BkgEurTroDtlVO;
import com.clt.syscommon.common.table.BkgEurTroVO;
import com.clt.syscommon.common.table.BkgHblCustVO;
import com.clt.syscommon.common.table.BkgHblVO;
import com.clt.syscommon.common.table.BkgHisDtlVO;
import com.clt.syscommon.common.table.BkgHisMstVO;
import com.clt.syscommon.common.table.BkgMfCstmsHisVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRateVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRfCgoVO;
import com.clt.syscommon.common.table.BkgStwgCgoVO;
import com.clt.syscommon.common.table.BkgTroDtlVO;
import com.clt.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.BkgXptImpLicVO;

/**
 * -BookingCommon Business Logic Basic Command implementation<br>
 * - BookingCommon handling business logic<br>
 * 
 * @author CLT
 * @see Booking_History_MgtEventResponse,BookingHistoryMgtBC Related DAO class
 * @since J2EE 1.4
 */

public class BookingHistoryMgtBCImpl extends BasicCommandSupport implements BookingHistoryMgtBC {

    // Database Access Object
    private transient BookingHistoryMgtDBDAO dbDao = null;

    /**
     * BookingHistoryMgtBCImpl objects creation<br>
     * BookingHistoryMgtDBDAO creation<br>
     */
    public BookingHistoryMgtBCImpl() {
        dbDao = new BookingHistoryMgtDBDAO();
    }
	/**
	 * Booking Cancel <br> 
	 *
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
     * Creating the History of the Notice
     * 
     * @param  List<BkgNtcHisVO> ntcHis
     * @param  String uiId
     * @exception EventException
     */
    public void createBkgNtcHis(List<BkgNtcHisVO> ntcHis, String uiId) throws EventException {    	
		try {
			BkgNtcHisVO bkgNtcHisVO = null;
			
			for (int i=0; ntcHis != null && i<ntcHis.size(); i++) {
				bkgNtcHisVO = ntcHis.get(i);
				
				dbDao.addBkgNtcHis(bkgNtcHisVO); 
				

				if("BT".equals(bkgNtcHisVO.getNtcKndCd())){
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
						bkgTmlEdiHisVO.setHisUiNm(bkgNtcHisVO.getHisUiNm());
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
	 *
	 * @param  String uiId
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return HistoryTableVO
	 * @exception EventException
	 */
	public HistoryTableVO searchOldBkgForHistory(String uiId, BkgBlNoVO bkgBlNoVO) throws EventException{
		try
		{
			HistoryTableVO historyTableVO = new HistoryTableVO();

			historyTableVO.setBkgBlNoVO(bkgBlNoVO);
			
			//01. 
			List<TableListVO> tableListVOs = dbDao.searchHisTableByUi(uiId);
			historyTableVO.setTableListVOs(tableListVOs);
			for(int i=0; i<tableListVOs.size(); i++) {
				String tableNm = tableListVOs.get(i).getTableNm();
				
				//02. 
				if ("BKG_BOOKING".equals(tableNm)) {
					BkgBookingVO              bkgBookingVO         = dbDao.searchBkgBooking(bkgBlNoVO);
					bkgBookingVO.setUiId(uiId);
					historyTableVO.setBkgBookingVO(bkgBookingVO);
				}
				//03. 
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
				//07. 
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
				//13. 
				else if ("BKG_CLZ_TM".equals(tableNm)) {
					List<BkgClzTmVO>          bkgClzTmVOs           = dbDao.searchBkgClzTm(bkgBlNoVO);
					historyTableVO.setBkgClzTmVOs(bkgClzTmVOs);
				}
				//14. 
				else if ("BKG_BL_DOC".equals(tableNm)) {
					BkgBlDocVO                bkgBlDocVO           = dbDao.searchBkgBlDoc(bkgBlNoVO);
					historyTableVO.setBkgBlDocVO(bkgBlDocVO);
				}
				//15. 
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
					List<BkgXptImpLicVO>      bkgXptImpLicVOs      = dbDao.searchBkgXptImpLic(bkgBlNoVO);
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
				//31. 
				else if ("BKG_RATE".equals(tableNm)) {
					BkgRateVO                 bkgRateVO            = dbDao.searchBkgRate(bkgBlNoVO);
					historyTableVO.setBkgRateVO(bkgRateVO);
				}
				//32.
				else if ("BKG_CHG_RT".equals(tableNm)) {
					List<BkgChgRtVO>          bkgChgRtVOs          = dbDao.searchBkgChgRt(bkgBlNoVO);
					historyTableVO.setBkgChgRtVOs(bkgChgRtVOs);
				}
				//33. 
				else if ("BKG_BL_ISS".equals(tableNm)) {
					BkgBlIssVO                bkgBlIssVO           = dbDao.searchBkgBlIss(bkgBlNoVO);
					historyTableVO.setBkgBlIssVO(bkgBlIssVO);
				}
				//34. 
				else if ("BKG_DOC_ISS_RDEM".equals(tableNm)) {
					List<BkgDocIssRdemVO>     bkgDocIssRdemVOs     = dbDao.searchBkgDocIssRdem(bkgBlNoVO);
					historyTableVO.setBkgDocIssRdemVOs(bkgDocIssRdemVOs);
				}
				//35.
				else if ("BKG_STWG_CGO".equals(tableNm)) {
					List<BkgStwgCgoVO>         bkgStwgCgoVOs         = dbDao.searchBkgStwgCgo(bkgBlNoVO);
					historyTableVO.setBkgStwgCgoVOs(bkgStwgCgoVOs);
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
	 *
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingHistory(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException {
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
			
			if (!"Y".equals(strCaFlg) && !"N".equals(strCaFlg)) { 	
				strCaFlg = "N";  				
			}
			
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
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
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
				//08. 
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
				//11. 
				else if ("N".equals(strCaFlg) && "BKG_TRO".equals(tableNm)) {
					List<BkgTroVO> vos = historyTableVO.getBkgTroVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgTro(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}	
					
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgTro(vos, bkgNo); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//12. 
				else if ("N".equals(strCaFlg) && "BKG_TRO_DTL".equals(tableNm)) {
					List<BkgTroDtlVO> vos = historyTableVO.getBkgTroDtlVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgTroDtl(vos.get(j));
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
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
				//14. 
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
				//15. 
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
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgContainer(vos.get(j), strCaFlg, uiId);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgContainer(vos, bkgNo, strCaFlg, uiId); 
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
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgCntrMfDesc(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
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
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgCntrSealNo(vos, bkgNo, null, strCaFlg);
					log.debug("seal update:"+histCtntVOs.size()); 
					if (tHistCtntVOs.size() > 0) {
						histCtntVOs.addAll(tHistCtntVOs);
					}
				}
				//20. 
				else if ("BKG_BL_DOC".equals(tableNm)) {
					historyTableVO.getBkgBlDocVO().setBkgNo(bkgNo);
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgBlDoc(historyTableVO.getBkgBlDocVO(), strCaFlg, uiId);
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
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
				//32. Checking when CA Starts!!!!!! 
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
				//34. 
				else if ("BKG_STWG_CGO".equals(tableNm)) {
					List<BkgStwgCgoVO> vos = historyTableVO.getBkgStwgCgoVOs();
					for (int j=0; j<vos.size(); j++) {
						List<HistCtntVO> tHistCtntVOs = dbDao.searchHistBkgStwgCgo(vos.get(j), strCaFlg);
						if (tHistCtntVOs.size() > 0) {
						    histCtntVOs.addAll(tHistCtntVOs);
						}
					}
					List<HistCtntVO> tHistCtntVOs = dbDao.searchHistNewBkgStwgCgo(vos, bkgNo, strCaFlg); 
					if (tHistCtntVOs.size() > 0) {
					    histCtntVOs.addAll(tHistCtntVOs);
					}
				}
			}
			
			String strHisSeq = ""; 
			if(histCtntVOs.size()>0){
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
            
            boolean amsAiFlagMasterBL = false;
            boolean amsAiFlagMasterHBL = false;
            boolean amsAiFlagHblMaster = false;
            String cntrMfNo ="";
            
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
			}
			if (bkgHisDtlVOs.size() > 0) {
			    dbDao.addBkgHisDtl(bkgHisDtlVOs);
			}

			// 미국, 캐나다 세관 history
			List<BkgCstmsAdvBlVO> listBl = dbDao.searchAmsAiDecisionInfo(bkgNo);
			for (int i = 0; i < listBl.size(); i++) {
				BkgCstmsAdvBlVO blVO = listBl.get(i);
				
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				if ("US".equals(blVO.getCntCd()))
					bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");
				else if ("CA".equals(blVO.getCntCd()))
					bkgDocProcSkdVO.setBkgDocProcTpCd("CA_SND");
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
			}
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
					|| histCtntVO.getHisCateNm().startsWith("SEAL No.")) {
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
	
	/**
	 * Creating the Booking Line History
	 * @param historyLineVO
	 * @param title
	 * @param message
	 * @param account
	 * @throws EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, String title, String message, SignOnUserAccount account) throws EventException {
		try {
			if ("Y".equals(historyLineVO.getCaFlg())) {
				return;
			}
			String strHisSeq = dbDao.searchNextHistSeq(historyLineVO.getBkgNo());
			
			//-------------------------
			// add History Master
			//-------------------------
			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
			bkgHisMstVO.setBkgNo(historyLineVO.getBkgNo());
			bkgHisMstVO.setHisSeq(strHisSeq);			
			bkgHisMstVO.setBkgHisIssUiId(historyLineVO.getUiId());
			bkgHisMstVO.setCorrNo(historyLineVO.getCorrNo());
			
			String usrId = "";
			if(account==null){
				usrId = "SYSTEM";
			}else{
				usrId = account.getUsr_id();
			}
			
			bkgHisMstVO.setCreUsrId(usrId);
			bkgHisMstVO.setUpdUsrId(usrId);
			
			dbDao.addBkgHisMst(bkgHisMstVO);
						
			//-------------------------
			// add History Dtl Line
			//-------------------------		
			BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
			bkgHisDtlVO.setBkgNo    (historyLineVO.getBkgNo());
			bkgHisDtlVO.setHisSeq   (strHisSeq);
			bkgHisDtlVO.setPreCtnt  (historyLineVO.getPreCtnt());
			bkgHisDtlVO.setCreUsrId (usrId);
			bkgHisDtlVO.setUpdUsrId (usrId);
			
			if(title != null && message != null){
				bkgHisDtlVO.setHisCateNm(title);
				bkgHisDtlVO.setCrntCtnt (message); 
				dbDao.addBkgHisDtlLine(bkgHisDtlVO);  
			}
			
			bkgHisDtlVO.setCrntCtnt (historyLineVO.getCrntCtnt()); 
			bkgHisDtlVO.setHisCateNm(historyLineVO.getHisCateNm());	
			dbDao.addBkgHisDtlLine(bkgHisDtlVO);  
			
			String bkgDocProcTpCd = JSPUtil.getNullNoTrim(historyLineVO.getBkgDocProcTpCd());
			if (!"".equals(bkgDocProcTpCd)) {
				//-------------------------
				// update 
				//-------------------------	
			    dbDao.cancelBkgDocProcSkd(bkgDocProcTpCd, historyLineVO.getBkgNo(), account);
			 
				//-------------------------
				// add : Bkg_Doc_Proc_Skd
				//-------------------------	
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(historyLineVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd(historyLineVO.getBkgDocProcTpCd());
				bkgDocProcSkdVO.setEvntUsrId(usrId);
				bkgDocProcSkdVO.setCreUsrId(usrId);
				bkgDocProcSkdVO.setUpdUsrId(usrId);
				dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Creating the Booking Line History<br> 
	 *
	 * @param  HistoryLineVO historyLineVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException {
		createBkgHistoryLine(historyLineVO, null, null, account);
	}
	
	/**
	 * Creating the Customs Manifest History<br>
	 *
	 * @param  BkgMfCstmsHisVO bkgMfCstmsHisVO
	 * @exception EventException
	 */
	public void createCustomsHistory(BkgMfCstmsHisVO bkgMfCstmsHisVO) throws EventException {
		try
		{
			String strHisSeq = dbDao.searchNextHistSeq(bkgMfCstmsHisVO.getBkgNo());
			
			//-------------------------
			// add History Master
			//-------------------------
			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
			bkgHisMstVO.setBkgNo(bkgMfCstmsHisVO.getBkgNo());
			bkgHisMstVO.setHisSeq(strHisSeq);
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
	 *
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocProcess(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException {
		try
		{
			//-------------------------
			// update 
			//-------------------------	
			dbDao.cancelBkgDocProcSkd(bkgDocProcSkdVO.getBkgDocProcTpCd(), bkgDocProcSkdVO.getBkgNo(), account);
			
			//-------------------------
			// add : Bkg_Doc_Proc_Skd
			//-------------------------	
			bkgDocProcSkdVO.setEvntUsrId(account.getUsr_id());
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
	 * Booking History : Temp History Data Remove all <br>  
	 *
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
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking History : releaseCntrFinalConfirm<br>  
	 *
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void releaseCntrFinalConfirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try
		{
			//-------------------------
			// container final confirm
			//-------------------------	
			String finalConfirm = dbDao.searchCntrFinalConfirm(bkgBlNoVO);
			
			//-------------------------			
			// If already Confirm
			//-------------------------			
			if ("CNTCFM".equals(finalConfirm)){
				//Container final confirm cancel
				dbDao.cancelBkgDocProcSkd(finalConfirm, bkgBlNoVO.getBkgNo(), account);
				
				//Container final confirm release insert
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
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyCaCorrNoForHistory(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {	
			dbDao.removeCorrDupHistory(bkgBlNoVO);
			dbDao.modifyCaCorrNoForHistory(bkgBlNoVO);

			dbDao.modifyCACnfAIFlagBkgDocProcSkd(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	/**
	 * MQ Interworking (UBIZ_BKG_USTMNL_ACK)<br>
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
			/*ORG_MSG_RCV:
				ORG_MSG_KEY:
				ORG_MSG_TP :
				MSG_UDT_FLG:
				ORG_MSG_NM:
				MSG_ACK_TP:
				MSG_ACK_RSLT:ok
				MSG_ACK_LDT:ok  
				MSG_ACK_GDT:?  
				MSG_R_CD:?
				MSG_R_REASON:ok
				MSG_ACCEPT_REF:ok
				*/
			
			
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

					/*if ( "TML_STS_CD".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlRspnStsCd(columnVal);
					} else if ( "TML_ERR_MESG".equals(columnNm) ) {
						bkgTmlEdiHisVO.setErrMsg(columnVal);
					} else if ( "TML_RSPN_DT".equals(columnNm) ) {
						bkgTmlEdiHisVO.setRspnDt(columnVal);
					} else if ( "EDI_REF_NO".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlEdiRqstNo(columnVal);
					}*/
			        if ( "MSG_ACK_RSLT".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlRspnStsCd(columnVal);
					} else if ( "MSG_R_REASON".equals(columnNm) ) {
						bkgTmlEdiHisVO.setErrMsg(columnVal);
					} else if ( "MSG_ACK_LDT".equals(columnNm) ) {
						bkgTmlEdiHisVO.setRspnDt(columnVal);
					} else if ( "MSG_ACCEPT_REF".equals(columnNm) ) {
						bkgTmlEdiHisVO.setTmlEdiRqstNo(columnVal);
					} else if ( "MSG_ACK_GDT".equals(columnNm) ) {
						bkgTmlEdiHisVO.setRspnGdt(columnVal);
					} else if ( "MSG_R_CD".equals(columnNm) ) {
						bkgTmlEdiHisVO.setMsgRjctRsn(columnVal);
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
	 * Creating the KOREA BOOKING HISTORY<br>
	 * 
	 * @param BkgHisMstVO bkgHisMstVO
	 * @param BkgHisDtlVO bkgHisDtlVO
	 * @throws EventException
	 */
	public void createBkgHisMst(BkgHisMstVO bkgHisMstVO, BkgHisDtlVO bkgHisDtlVO) throws EventException {
		try {
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
	 * Booking History : search VVD change data<br> 
	 * VVD 변경 전/후 값을 비교하여 실제 보여질 data를 조회한다.<br>
	 * @param HistoryTableVO oldHistoryTableVO
	 * @return List<HistCtntVO>
	 * @exception EventException
	 */
	public List<HistCtntVO> searchChangeVVDHistory(HistoryTableVO oldHistoryTableVO) throws EventException{
		List<HistCtntVO> histCtntVOs = new ArrayList<HistCtntVO>();
		try
		{
			String bkgNo    = oldHistoryTableVO.getBkgBlNoVO().getBkgNo();  //bkg_no, ca_flag 필수 setting 					
			String strCaFlg = JSPUtil.getNullNoTrim(oldHistoryTableVO.getBkgBlNoVO().getCaFlg());
			if (!"Y".equals(strCaFlg) && !"N".equals(strCaFlg)) { 	
				strCaFlg = "N";  				
			}
			if(strCaFlg.equals("Y"))			return null;
			
			List<TableListVO> tableListVOs = oldHistoryTableVO.getTableListVOs();
			
			for(int i=0; i<tableListVOs.size(); i++) 
			{
				String tableNm = tableListVOs.get(i).getTableNm();
				
				//01.
				if ("BKG_VVD".equals(tableNm)) {
					List<BkgVvdVO> vos = oldHistoryTableVO.getBkgVvdVOs();
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
			}
			return histCtntVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	}
	
	
	/**
	 * 
	 * @param bkgNo
	 * @throws EventException
	 */
	public void createdAmsAi(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException {
		String cntrMfNo ="";
		String bkgNo = historyLineVO.getBkgNo();
		List<BkgCstmsAdvBlVO> listBl = null;
		try {
			listBl = dbDao.searchAmsAiDecisionInfo(bkgNo);
			for (int i = 0; i < listBl.size(); i++) {
				BkgCstmsAdvBlVO blVO = listBl.get(i);
				
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				if ("US".equals(blVO.getCntCd()))
					bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");
				else if ("CA".equals(blVO.getCntCd()))
					bkgDocProcSkdVO.setBkgDocProcTpCd("CA_SND");
				bkgDocProcSkdVO.setEvntUsrId(("Y".equals(historyLineVO.getCaFlg()) ? "CA" : account.getUsr_id()));
				bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setUpdUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setDiffRmk("Amendment Transmit (AI) SEND");

				if ("".equals(blVO.getMfNo())) {
					dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
				} else if (blVO.getBlNo().equals(cntrMfNo)) {
					// Master BL의 House BL 등록
					bkgDocProcSkdVO.setDiffRmk(cntrMfNo);
					dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
}