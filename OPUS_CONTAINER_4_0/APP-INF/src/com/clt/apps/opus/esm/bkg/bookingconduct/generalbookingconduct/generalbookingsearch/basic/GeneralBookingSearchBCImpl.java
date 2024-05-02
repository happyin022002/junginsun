/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchBCImpl.java
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.axis.utils.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgTmlEdiHisVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration.GeneralBookingSearchDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration.GeneralBookingSearchEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgYardCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PropNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301BlVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.YardAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCustCntcPsonVO;
import com.clt.syscommon.common.table.BkgHisMstVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;

/**
 * OPUS-CreateCustBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - OPUS-CreateCustBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */
public class GeneralBookingSearchBCImpl extends BasicCommandSupport implements GeneralBookingSearchBC {

	// Database Access Object
	private transient GeneralBookingSearchDBDAO dbDao = null;
	private transient GeneralBookingSearchEAIDAO eaiDao = null;
	private transient BookingHistoryMgtDBDAO bkgHisrotyDao = null;
	
	/** 
	 * GeneralBookingSearchBCImpl object creation<br>
	 * GeneralBookingSearchDBDAO creation<br>
	 */
	public GeneralBookingSearchBCImpl() {
		dbDao = new GeneralBookingSearchDBDAO();
		eaiDao = new GeneralBookingSearchEAIDAO();
		bkgHisrotyDao = new BookingHistoryMgtDBDAO();
	}

	/**
	 * TS Route information retrieve
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String codRqstSeq
	 * @param 		String opCd
	 * @return 		List<TSRouteVO>
	 * @exception 	EventException
	 */
	public List<TSRouteVO> searchIbTsRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String opCd) throws EventException {
		try {
			if(codRqstSeq != null && codRqstSeq.length() > 0){
				return dbDao.searchCodTsRoute(bkgBlNoVO, codRqstSeq, opCd);
			}else{
				return dbDao.searchIbTsRoute(bkgBlNoVO);
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);         
		}
	}

	/**
	 * Retrieve event handling of Customer Inquiry screen
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @param 		String custNm
	 * @param 		String locCd
	 * @param 		String ofcCd
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchBkgCreCustCntc(	String custCntCd,
			 																String custSeq,
			 																String custNm,
			 																String locCd,
			 																String ofcCd	) throws EventException {
		try {
			BkgCreCustInqVO bkgCreCustInqVO = new BkgCreCustInqVO();

//			String custCntCd1 = "";
//			String custSeq1 = "";
			// Customer list retrieve
			List<BkgCreCustomerVO> searchBkgCreCustomer = dbDao.searchBkgCreCustomer(custCntCd,custSeq,custNm,locCd,ofcCd);
			bkgCreCustInqVO.setBkgCreCustomerr(searchBkgCreCustomer);

//			if(searchBkgCreCustomer != null && searchBkgCreCustomer.size() > 0){
//				BkgCreCustomerVO bkgCreCustCntrVO = searchBkgCreCustomer.get(0);
//				if(bkgCreCustCntrVO != null){
//					custCntCd1 = bkgCreCustCntrVO.getCustCntCd();
//					custSeq1 = bkgCreCustCntrVO.getCustSeq();
//				}
//			}

//			List<CustSrepVO> searchCustSrep = dbDao.searchCustSrep(custCntCd1,custSeq1);
//			bkgCreCustInqVO.setCustSrep(searchCustSrep);
//
//			List<BkgCustCntcPsonVO> searchCustContact = dbDao.searchCustContact(custCntCd1,custSeq1);
//			bkgCreCustInqVO.setBkgCustCntcPson(searchCustContact);

			return bkgCreCustInqVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * event handling in case of clicking Customer list of Customer Inquiry screen
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchCustContact(String custCntCd, String custSeq	) throws EventException {
		try {
			BkgCreCustInqVO bkgCreCustInqVO = new BkgCreCustInqVO();

			// S.OFC list retrieve
			List<CustSrepVO> searchCustSrep = dbDao.searchCustSrep(custCntCd,custSeq);
			bkgCreCustInqVO.setCustSrep(searchCustSrep);
			List<BkgCustCntcPsonVO> searchCustContact = dbDao.searchCustContact(custCntCd,custSeq);
			bkgCreCustInqVO.setBkgCustCntcPson(searchCustContact);

			return bkgCreCustInqVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  Service Mode & Route information retrieve<br>
	 * @param 		bkgBlNoVO   BkgBlNoVO
	 * @return 		BkgBookingVO
	 * @exception 	EventException
	 */
	public BkgBookingVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchSvcRouteMode(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  Black Stowage Flag retrieve<br>
	 * @param 		bkgBookingVO   BkgBookingVO
	 * @return 		BkgBookingVO
	 * @exception 	EventException
	 */
	public BkgBookingVO searchBlckStwgFlg(BkgBookingVO bkgBookingVO) throws EventException {
		try {
			return dbDao.searchBlckStwgFlg(bkgBookingVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 *  Black Stowage Code update<br>
	 * @param 		bkgBookingVO   BkgBookingVO
	 * @param		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBlckStwgCd(BkgBookingVO bkgBookingVO, SignOnUserAccount account) throws EventException {
		try{
			dbDao.manageBlckStwgCd(bkgBookingVO,account);
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	

	/**
	 * Constraint retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<PrdConstraintVO>
	 * @exception 	EventException
	 */
	public List<PrdConstraintVO> searchConstraint(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchConstraint(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Reference Number information retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public List<RefNoVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgReference(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Reference Number information retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public String searchManualYn(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchManualYn(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Node Search retrieve<br>
	 * @param 		NodeListInputVO nodeListInputVO
	 * @return 		List<NodeListVO>
	 * @exception 	EventException
	 */
	public List<NodeListVO> searchNodeCode(NodeListInputVO nodeListInputVO) throws EventException {
		try {
			if("Y".equals(nodeListInputVO.getYzFlag())){
				return dbDao.searchYardCode(nodeListInputVO);
			}else{
				return dbDao.searchZoneCode(nodeListInputVO);
			}
	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Location List retrieve<br>
	 * @param 		LocationListInputVO locationListInputVO
	 * @return 		List<LocationListVO>
	 * @exception 	EventException
	 */
	public List<LocationListVO> searchLocationList(LocationListInputVO locationListInputVO) throws EventException {
		try {
			return dbDao.searchLocationList(locationListInputVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * Direct NVO-AMS File No retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		UsaCstmsFileListVO
	 * @exception 	EventException
	 */
	public UsaCstmsFileListVO searchNVOFileNumberList(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			UsaCstmsFileListVO usaCstmsFileListVO = new UsaCstmsFileListVO();
			List<BkgUsaCstmsFileNoVO> nvoFileNumberList = dbDao.searchNVOFileNumberList(bkgBlNoVO);
			List<HblCountVO> hblCount = dbDao.searchHblCount(bkgBlNoVO);
			usaCstmsFileListVO.setBkgUsaCstmsFileNo(nvoFileNumberList);
			if(hblCount != null && hblCount.size() > 0){
				usaCstmsFileListVO.setHblCountVO(hblCount.get(0));
			}

			return usaCstmsFileListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}



	/**
	 * retrieve cct information of the booking
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return ClzTmListVO
	 * @throws EventException
	 */
	public ClzTmListVO searchCargoClosingTime(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		try {
			ClzTmListVO  clzTmListVO =new ClzTmListVO();

			 clzTmListVO.setClzTmVO(dbDao.searchCargoClosingTime(bkgBlNoVO,account));
			 clzTmListVO.setBkgForCargoClosingVO(dbDao.searchBkgForCargoClosing(bkgBlNoVO));
			 return clzTmListVO;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Customer Code retrieve
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException {
		try {
			return dbDao.searchActualCustomer(searchActualCustomerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * retrieve Container No List belonging to the Empty Repo Bkg(ESM_BKG_9450)
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<CntrInfoForEmptyVO>
	 * @exception EventException
	 */
	public List<CntrInfoForEmptyVO> searchEmptyCntrByBKG(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEmptyCntrByBKG(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * retrieve Code and Name of all Service Scope
	 * @return 		List<MdmSvcScpVO>
	 * @exception 	EventException
	 */
	public List<MdmSvcScpVO> searchSvcScp() throws EventException {
		try {
			return dbDao.searchSvcScp();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * retrieve RFA on shipper's contract(ESM_BKG_0654)
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	EventException
	 */
	public List<RfaListVO> searchRfaList(RfaListInputVO rfaListInputVO) throws EventException {
		try {
			return dbDao.searchRfaList(rfaListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * retrieve S/C on shipper's contract(ESM_BKG_0655)
	 * @param 		ScListInputVO scListInputVO
	 * @return 		List<ScListVO>
	 * @exception 	EventException
	 */
	public List<ScListVO> searchScList(ScListInputVO scListInputVO) throws EventException {
		try {
			return dbDao.searchScList(scListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		


	/**
	 * retrieve TAA on shipper's contract(ESM_BKG_1062)
	 * @param 		TaaListInputVO taaListInputVO
	 * @return 		List<TaaListVO>
	 * @exception 	EventException
	 */
	public List<TaaListVO> searchTaaList(TaaListInputVO taaListInputVO) throws EventException {
		try {
			return dbDao.searchTaaList(taaListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * retrieve Commodity on RFA's contract(ESM_BKG_0656)
	 * @param rfaListInputVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @param uiId
	 * @return
	 * @throws EventException
	 */
	public List<RfaCmdtListVO> searchCmdtByRfa(RfaListInputVO rfaListInputVO, String cmdtNm, String cmdtCd, String uiId) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoByRfa(rfaListInputVO);
			if(uiId.equals("ESM_BKG_0079") || uiId.equals("ESM_BKG_0229") || uiId.equals("ESM_PRI_6001")){
				return dbDao.searchCmdtByRfaMulti(rfaListInputVO, propNoVO, cmdtNm, cmdtCd);
			}else{
				return dbDao.searchCmdtByRfa(propNoVO, cmdtNm, cmdtCd);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * retrieve Commodity on S/C's contract(ESM_BKG_0657)
	 * @param scListInputVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @param svcScpCd
	 * @param uiId
	 * @return
	 * @throws EventException
	 */
	public List<ScCmdtListVO> searchCmdtBySc(ScListInputVO scListInputVO, String cmdtNm, String cmdtCd,String svcScpCd, String uiId) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoBySc(scListInputVO);
			if(uiId.equals("ESM_BKG_0079") || uiId.equals("ESM_BKG_0229") || uiId.equals("ESM_PRI_6001")){
				return dbDao.searchCmdtByScMulti(scListInputVO, cmdtNm, cmdtCd, svcScpCd, scListInputVO.getScNo(), propNoVO);
			}else{
				return dbDao.searchCmdtBySc(propNoVO, cmdtNm, cmdtCd, svcScpCd);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}				
	
	/**
	 * retrieve Commodity on TAA's contract(ESM_BKG_1078)
	 * @param 		TaaListInputVO taaListInputVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @return 		List<TaaCmdtListVO>
	 * @exception 	EventException
	 */
	public List<TaaCmdtListVO> searchCmdtByTaa(TaaListInputVO taaListInputVO, String cmdtNm, String cmdtCd) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoByTaa(taaListInputVO);
			return dbDao.searchCmdtByTaa(propNoVO, cmdtNm, cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * ESM_BKG_0566 : History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return HistMainVO
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {			
			HistMainVO histMainVO = new HistMainVO();
			
			//01. Booking Header
			BkgInforForHistVO bkgInfoForHistVO = dbDao.searchBkgInfoForHist(bkgBlNoVO);
			
			//02. Item Combo
			List<HistUiNmVO> histUiNmVOs = dbDao.searchHistUiNm(bkgBlNoVO);
			
			//03. B/L Data
			List<BlHistVO> blHistVOs = dbDao.searchBlHist(bkgBlNoVO);
			
			histMainVO.setBkgInforForHistVO(bkgInfoForHistVO);
			histMainVO.setHistUiNmVOs(histUiNmVOs);
			histMainVO.setBlHistVOs(blHistVOs);
			
			return histMainVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
		
	/**
	 * ESM_BKG_0566_02 : FAX/EDI History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<NoticeHistVO>
	 * @exception EventException
	 */
	public List<NoticeHistVO> searchNoticeHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchNoticeHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * ESM_BKG_0566_03 : Customs History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<CustomsHistVO>
	 * @exception EventException
	 */
	public List<CustomsHistVO> searchCustomsHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchCustomsHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * ESM_BKG_0566_04 : Documnents History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<DocHistVO>
	 * @exception EventException
	 */
	public List<DocHistVO> searchDocHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchDocHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * transmit 5005RD from Booking list by FAX(ESM_BKG_0098)
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByFax(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException{
		try {
			return eaiDao.sendBkgReceiptByFax(bkgReceiptSendVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * transmit 5005RD from Booking list by mail(ESM_BKG_0098)
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @param String type
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account, String type) throws EventException{
		try {
			bkgReceiptSendVO.setCcEmail((new BookingUtil()).searchCcEmailAddrRSQL("BK", account.getUsr_id()));
			return eaiDao.sendBkgReceiptByEmail(bkgReceiptSendVO, account, type);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * transmit 5005RD from Booking list by Group mail
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException{
		List<BkgNtcHisVO> list = null;
		try {
			
			if(bkgReceiptSendVO.getCustBody() != null){
				list = eaiDao.sendBkgReceiptByCustGroupEmail(bkgReceiptSendVO, account);
			}else{
				bkgReceiptSendVO.setCcEmail((new BookingUtil()).searchCcEmailAddrRSQL("BK", account.getUsr_id()));
				list = eaiDao.sendBkgReceiptByGroupEmail(bkgReceiptSendVO, account);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
		return list;
	}

	/**
	 * retrieve bkg data, cntr data, VL container List of mty bkg update screen
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String bkgMvmtCd
	 * @return 		RepoBkgForUpdateVO
	 * @exception 	EventException
	 */
	public RepoBkgForUpdateVO searchEmptyBooking(BkgBlNoVO bkgBlNoVO, String bkgMvmtCd) throws EventException {
		RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
		try {
			RepoBkgVO repoBkgVO = dbDao.searchEmptyBooking(bkgBlNoVO);		
			repoBkgForUpdateVO.setRepoBkgVO(repoBkgVO);			
			if(repoBkgVO != null){
				BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
				newBkgBlNoVO.setBkgNo(repoBkgForUpdateVO.getRepoBkgVO().getBkgNo());
				
				List<RepoCntrVO> emptyCntrList = dbDao.searchEmptyCntr(newBkgBlNoVO);
				if(emptyCntrList == null || emptyCntrList.size() < 1){
					List<BkgQuantityVO> emptyQtyList = dbDao.searchEmptyQty(newBkgBlNoVO) ;
					repoBkgForUpdateVO.setBkgQuantity(emptyQtyList);
				}

				List<RepoCntrVO> cntrTpszList = dbDao.searchCntrTpszCd();
				
				List<RepoCntrVO> repoCntrTpszList = new ArrayList<RepoCntrVO>();
				for(int i=0;i<cntrTpszList.size();i++){
					if(!cntrTpszList.get(i).getTpszCd().equals("Q2")&&!cntrTpszList.get(i).getTpszCd().equals("Q4")){
						repoCntrTpszList.add(cntrTpszList.get(i));
					}						
				}
				
				repoBkgForUpdateVO.setRepoCntr(emptyCntrList);
				repoBkgForUpdateVO.setCntrTpSz(repoCntrTpszList);		
				
				if("VL".equals(bkgMvmtCd)){
					List<RepoCntrVO> vlCntrList = dbDao.searchVLCntr(repoBkgVO.getBkgTrunkVvd(), repoBkgVO.getOrgYdCd());
					
					repoBkgForUpdateVO.setVlCntr(vlCntrList);			
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00095").getMessage());				
			}

		} catch (EventException ex) {
			throw ex;						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return repoBkgForUpdateVO;
	}	


	/**
	 * Stowage Plan retrieve
	 * @param 		String mvmtOption
	 * @param 		String vvd 
	 * @param 		String ydCd
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchMtyCntrList(String mvmtOption, String vvd, String ydCd) throws EventException {
		try {
			if("V".equals(mvmtOption)){
				return dbDao.searchVLCntr(vvd, ydCd);
			}else{
				return dbDao.searchStwgPlan(vvd, ydCd);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
	/**
	 * Container Digit,TpSz,Status Cd retrieve<br>
	 * @param  		String cntrNo
	 * @return 		CntrChkDigitVO
	 * @exception 	EventException
	 */
	public CntrChkDigitVO searchCntrChkDigit(String cntrNo) throws EventException{
		try {
			return dbDao.searchCntrChkDigit(cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * CreateCustBkgReceiptEdi BackEndJob handling
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createCustBkgReceiptEdiBackEnd(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException {
		CreateCustBkgReceiptEdiBackEndJob createCustBkgReceiptEdi = new CreateCustBkgReceiptEdiBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			createCustBkgReceiptEdi.setBkgBlNoVO(bkgBlNoVO);
			createCustBkgReceiptEdi.setSignOnUserAccount(account);

			return backEndJobManager.execute(createCustBkgReceiptEdi, account.getUsr_id(), "createCustBkgReceiptEdiBackEnd");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	


	
	
	/**
	 * create and transmit EDI information for Customer (ESM_BKG_0702)
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createCustBkgReceiptEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException{
		BookingUtil utilBC = new BookingUtil();
		List<CustTpIdVO> custTpIdVOList = new ArrayList<CustTpIdVO>();
		String hostId = null;
		XterRqstNoVO xterRqstNoVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();

		String ediHeader = null;
		String ediBlMain = null;
		List<String> ediCntrInfos = null;
		String ediTroGen = null;
		String ediTroEur = null;
		String ediDgInfo = null;
		List<String> ediBlCntrs = null;
		List<String> ediBlVvds = null;
		String ediBlPoInfo = null;
		String ediBlDesc = null;
		List<String> ediBkgCms = null;
		String ediXterInfo = null;
		List<String> ediXterCusts = null;
		String ediXterCm = null;
		List<String> ediXterRef = null;
		List<String> ediBkgRoute = null;
		List<String> ediHpswaInfo = null;
		String xterBkgRqstRefNo[] = null;
		String msgId = "301   ";
		List<String> tmlEdiRefNo 		= new ArrayList<String>();
		try {
			
			log.info("\n === createCustBkgReceiptEdi BkgNo : " + bkgBlNoVO.getBkgNo());
			log.info("\n === createCustBkgReceiptEdi autoManualFlg : " + autoManualFlg);
			
			if("Y".equals(autoManualFlg)){
				String autoEdiBlockFlg = dbDao.searchAutoEdiBlockFlg(bkgBlNoVO);
				//if(bkgBlNoVO.getHisUiNm() == null || !bkgBlNoVO.getHisUiNm().equalsIgnoreCase("SCG")){
					log.info("\n === createCustBkgReceiptEdi autoEdiBlockFlg : " + autoEdiBlockFlg);
					if("Y".equals(autoEdiBlockFlg)){
						return bkgNtcHisVOs;
					}
				//}
			}
			
			if ( custTpIdVO == null ) {
				custTpIdVOList = utilBC.searchEdiCustTpId(bkgBlNoVO, "B", autoManualFlg);
			} else {
				custTpIdVOList.add(custTpIdVO);
			}
			if(custTpIdVOList.size()==0){
				return bkgNtcHisVOs;
			}
			
			StringBuffer[] flatFiles = new StringBuffer[custTpIdVOList.size()];
			for (int i=0; i<custTpIdVOList.size(); i++) {
				CustTpIdVO custTpVO = custTpIdVOList.get(i);

				hostId = utilBC.searchEdi301HostId(custTpVO.getRcvId(), "CUST_301");
				xterBkgRqstRefNo = dbDao.searchXterBkgRqstRefNo(bkgBlNoVO.getBkgNo(), custTpVO.getRcvId());
				
				if ("".equals(xterBkgRqstRefNo[0]) && !"".equals(xterBkgRqstRefNo[1])) {
					msgId = "301U   ";
				}else{
					msgId = "301   ";
				}

				ediHeader = utilBC.searchEdiHeader(hostId, custTpVO.getRcvId(), msgId);
				ediBlMain = JSPUtil.getNull(dbDao.searchCust301BlMain(bkgBlNoVO, custTpVO.getGroupId(), custTpVO.getRefCode()));

				String refNo = ediHeader.substring(62);
				tmlEdiRefNo.add(refNo);
				log.debug("createCustBkgReceiptEdi tmlEdiRefNo : " + refNo);
				
				flatFiles[i] = new StringBuffer("");
				flatFiles[i].append(("".equals(ediHeader))?"":ediHeader+"\n");
				flatFiles[i].append(("".equals(ediBlMain))?"":ediBlMain+"\n");
			}

			StringBuffer comFlatFile = new StringBuffer();
			ediCntrInfos = dbDao.searchCust301CntrInfo(bkgBlNoVO);
			ediTroGen = JSPUtil.getNull(dbDao.searchCust301TroGeneralInfo(bkgBlNoVO));
			ediTroEur = JSPUtil.getNull(dbDao.searchCust301TroEurInfo(bkgBlNoVO));
			ediDgInfo = JSPUtil.getNull(dbDao.searchEdi301DgInfo(bkgBlNoVO));
			ediBlCntrs = dbDao.searchEdi301BlCntr(bkgBlNoVO);
			ediBlVvds = dbDao.searchEdi301BlVvd(bkgBlNoVO);
			ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVO));
			ediBlDesc = JSPUtil.getNull(dbDao.searchCust301BlDesc(bkgBlNoVO));
			ediBkgCms = dbDao.searchCust301BkgCm(bkgBlNoVO);

			if(ediCntrInfos != null) {
				int ediCntrInfosMaxSize = ediCntrInfos.size();
				for(int idx = 0 ; idx < ediCntrInfosMaxSize ; idx++) {
					comFlatFile.append(ediCntrInfos.get(idx));
				}
			}			
			
			comFlatFile.append(("".equals(ediTroGen))?"":ediTroGen+"\n");
			comFlatFile.append(("".equals(ediTroEur))?"":ediTroEur+"\n");
			comFlatFile.append(("".equals(ediDgInfo))?"":ediDgInfo+"\n");
			
			if(ediBlCntrs != null)	{
				int ediBlCntrsMaxSize = ediBlCntrs.size();
				for(int idx = 0 ; idx < ediBlCntrsMaxSize ; idx++)	{
					comFlatFile.append(ediBlCntrs.get(idx)).append("\n");
				}
			}
			
			if(ediBlVvds != null) {
				int ediBlVvdsMaxSize = ediBlVvds.size();
				for(int idx = 0; idx <ediBlVvdsMaxSize; idx++) {
					comFlatFile.append(ediBlVvds.get(idx)).append("\n");
				}
			}
			
			comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");
			comFlatFile.append(("".equals(ediBlDesc))?"":ediBlDesc+"\n");

			if(ediBkgCms != null) {
				int ediBkgCmsMaxSize = ediBkgCms.size();
				for(int idx = 0 ; idx < ediBkgCmsMaxSize ; idx++) {
					comFlatFile.append(ediBkgCms.get(idx));
				}
			}			

			xterRqstNoVO = dbDao.searchXterRqstNo(bkgBlNoVO);
			if ( xterRqstNoVO != null ) {
				ediXterInfo = JSPUtil.getNull(dbDao.searchCust301XterInfo(xterRqstNoVO));
				ediXterCusts = dbDao.searchCust301XterCust(xterRqstNoVO);
				ediXterCm = JSPUtil.getNull(dbDao.searchCust301XterCm(xterRqstNoVO));
				ediXterRef = dbDao.searchCust301XterRef(xterRqstNoVO);

				comFlatFile.append(("".equals(ediXterInfo))?"":ediXterInfo+"\n");
				if(ediXterCusts != null){
					int ediXterCustsMaxSize = ediXterCusts.size();
					for(int idx = 0; idx < ediXterCustsMaxSize ; idx++)	{
						comFlatFile.append(ediXterCusts.get(idx)).append("\n");
					}
				}
				comFlatFile.append(("".equals(ediXterCm))?"":ediXterCm+"\n");
				if(ediXterRef != null){
					int ediXterRefMaxSize = ediXterRef.size();
					for(int idx = 0; idx < ediXterRefMaxSize ; idx++){
						comFlatFile.append(ediXterRef.get(idx)).append("\n");
					}
				}
			}

			ediBkgRoute = dbDao.searchCust301BkgRoute(bkgBlNoVO);
			if(ediBkgRoute != null)	{
				int ediBkgRouteMaxSize = ediBkgRoute.size();
				for(int idx = 0; idx < ediBkgRouteMaxSize ; idx++)	{
					comFlatFile.append(ediBkgRoute.get(idx)).append("\n");
				}
			}
			
			ediHpswaInfo = dbDao.searchCust301HpswaInfo(bkgBlNoVO);
			if(ediHpswaInfo != null){
				int ediHpswaMaxSize = ediHpswaInfo.size();
				for(int idx = 0; idx < ediHpswaMaxSize ; idx++)	{
					comFlatFile.append(ediHpswaInfo.get(idx)).append("\n");
				}
			}
			
			for (int j=0;j<flatFiles.length;j++) {
				flatFiles[j].append(comFlatFile.toString());

				// Send
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFiles[j].toString());
				String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER_301.IBMMQ.QUEUE");
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

				log.debug("RESULT:"+flatFiles[j]);

				// History
				CustTpIdVO custTpVO2 = custTpIdVOList.get(j);
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
				bkgNtcHisVO.setNtcViaCd("E");
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setEdiId(custTpVO2.getRcvId());
				bkgNtcHisVO.setSndId(hostId);
				bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
				bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setDiffRmk(tmlEdiRefNo.get(j));
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
		}catch(EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * create and transmit EDI information that will transmit to terminal, BackEndJob Handling
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param List<BkgVvdVO> oldVvdVOs
	 * @param String bracCd
	 * @param String ediKind
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createTmlBkgReceiptEdiBackEnd(BkgBlNoVO bkgBlNoVO, List<BkgVvdVO> oldVvdVOs, String bracCd, String ediKind, String autoManualFlg, SignOnUserAccount account) throws EventException {
		CreateTmlBkgReceiptEdiBackEndJob createTmlBkgReceiptEdiBackEnd = new CreateTmlBkgReceiptEdiBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			createTmlBkgReceiptEdiBackEnd.setBkgBlNoVO(bkgBlNoVO);
			createTmlBkgReceiptEdiBackEnd.setOldVvdVOs(oldVvdVOs);
			createTmlBkgReceiptEdiBackEnd.setBracCd(bracCd);
			createTmlBkgReceiptEdiBackEnd.setEdiKind(ediKind);
			createTmlBkgReceiptEdiBackEnd.setAutoManualFlg(autoManualFlg);
			createTmlBkgReceiptEdiBackEnd.setSignOnUserAccount(account);

			return backEndJobManager.execute(createTmlBkgReceiptEdiBackEnd, account.getUsr_id(), "createTmlBkgReceiptEdiBackEnd");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 *  create and transmit EDI information that will transmit to terminal
	 * 
	 * @author Kim Byung Kyu
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createTmlBkgReceiptEdiBackEnd(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException {
		CreateTmlBkgReceiptEdiBackEndJob createTmlBkgReceiptEdiBackEnd = new CreateTmlBkgReceiptEdiBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			createTmlBkgReceiptEdiBackEnd.setVender301ParamVO(vender301ParamVO);
			createTmlBkgReceiptEdiBackEnd.setSignOnUserAccount(account);
			createTmlBkgReceiptEdiBackEnd.setBkgBlNoVO(new BkgBlNoVO());
			return backEndJobManager.execute(createTmlBkgReceiptEdiBackEnd, account.getUsr_id(), "createTmlBkgReceiptEdiBackEnd");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * create and transmit EDI information that will transmit to terminal(ESM_BKG_0702)
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTmlBkgReceiptEdi(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException{
		BookingUtil utilBC = new BookingUtil();
		BkgVvdVO bkgVvdVO = new BkgVvdVO();
		List<TmnlRcvIdVO> tmnlRcvIdVOs = new ArrayList<TmnlRcvIdVO>();
		List<TmnlRcvIdVO> tmnlNsBracRcvIdVOs = new ArrayList<TmnlRcvIdVO>();
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();

		String ediHeader  		= null;
		String ediBlMain1 		= null;
		String ediBlMain2 		= null;
		String ediCntrInfo 		= null;
		String ediBlCntr		= null;
		String ediBlPoInfo 		= null;
		List<String> tmlEdiRefNo 		= new ArrayList<String>();
		try {

			// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
			BkgBlNoVO bkgBlNoVO = vender301ParamVO.getBkgBlNoVO();
			List<BkgVvdVO> oldVvdVOs = vender301ParamVO.getOldVvdVOs();
			List<BkgQuantityVO> oldQtyVOs = vender301ParamVO.getOldQtyVOs();
			String bracCd = vender301ParamVO.getBracCd();
			String ediKind = vender301ParamVO.getEdiKind();
			String autoManualFlg = vender301ParamVO.getAutoManualFlg();
			String rcvId = vender301ParamVO.getRcvId();
			String eventPage = vender301ParamVO.getEventPage();
			String refCode = vender301ParamVO.getRefCode();
			
			bkgVvdVO = dbDao.searchTmnl301LanePol(bkgBlNoVO);
			StringBuffer[] flatFiles = null;
			String[] ediRefCd = null;
			log.info("\n === createTmlBkgReceiptEdi BkgNo : " + bkgBlNoVO.getBkgNo());
			log.info("\n === createTmlBkgReceiptEdi autoManualFlg : " + autoManualFlg);
			
			if("Y".equals(autoManualFlg)){
				//if(bkgBlNoVO.getHisUiNm() == null || !bkgBlNoVO.getHisUiNm().equalsIgnoreCase("SCG")){
					String autoEdiBlockFlg = dbDao.searchAutoEdiBlockFlg(bkgBlNoVO);
					log.info("\n === createTmlBkgReceiptEdi autoEdiBlockFlg : " + autoEdiBlockFlg);
					if("Y".equals(autoEdiBlockFlg)){
						return bkgNtcHisVOs;
					}
				//}
				
				tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForAutoSend(bkgBlNoVO, bracCd);
				if(tmnlRcvIdVOs.size()==0){
					log.info("\n ===== searchTmnl301RcvIdForAutoSend - tmnlRcvIdVO Size : 0 ");
					return bkgNtcHisVOs;
				}
			} else {	
				if(bkgBlNoVO.getHisUiNm() != null && bkgBlNoVO.getHisUiNm().equalsIgnoreCase("CTM")  ){
					String autoEdiBlockFlg = dbDao.searchAutoEdiBlockFlg(bkgBlNoVO);
					log.info("\n === createTmlBkgReceiptEdi autoEdiBlockFlg : " + autoEdiBlockFlg);
					if("Y".equals(autoEdiBlockFlg)){
						return bkgNtcHisVOs;
					}
				}
				
				if(rcvId==null || rcvId.length() < 1 ){
					if ( "BT".equals(ediKind)){
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForBkgCfm(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "CN".equals(ediKind) ) {
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForMtyRel(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "FC".equals(ediKind) ) {
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForFullRel(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "BM".equals(ediKind) ){
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForManualSend(bkgBlNoVO, bracCd);								
					} else {
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForDefault(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);								
					}
					
				}
				if(rcvId!=null && rcvId.length() > 1 ){
					TmnlRcvIdVO tmnlRcvIdVO = new TmnlRcvIdVO();
					tmnlRcvIdVO.setEdiRcvId(rcvId);					
					tmnlRcvIdVO.setKindCd(ediKind);					
					tmnlRcvIdVO.setEdiRefCd(refCode);					
					tmnlRcvIdVOs.add(tmnlRcvIdVO);
					flatFiles = new StringBuffer[tmnlRcvIdVOs.size()];
					ediRefCd = new String[tmnlRcvIdVOs.size()];
//					flatFiles = new String[tmnlRcvIdVOs.size()];
				} else {
					if(tmnlRcvIdVOs.size()==0){
						return bkgNtcHisVOs;
					}
				}
			}
			
			flatFiles = new StringBuffer[tmnlRcvIdVOs.size()];
			ediRefCd = new String[tmnlRcvIdVOs.size()];
//			flatFiles = new String[tmnlRcvIdVOs.size()];
			for (int i=0;i<tmnlRcvIdVOs.size();i++) {
				TmnlRcvIdVO tmnlRcvIdVO = tmnlRcvIdVOs.get(i);
				ediRefCd[i] = tmnlRcvIdVO.getEdiRefCd();
				
				String hostId = "";
				// New_BkgQuantity와 Old_BkgQuantity를 비교하여 NS_BRAC을 설정한다.
				String nsBracCd = "";
				List<BkgQuantityVO> newBkgQtyVOs = dbDao.searchTmnl301BkgQuantity(bkgBlNoVO.getBkgNo());
				
				/* 1. Old_BkgQuantity가 null 일 경우 (물량변경 없는 화면에서 호출된 경우, 배치에서 호출된 경우) : Update
				   2. BRAC_CD가 R(Booking Cancel)일 경우 : R 
				   3. Old_Quantity가 0건일 경우 : New
				   4. 컨테이너 개수만 변경되는 경우               ex) D2 x 1 -> D2 x 2 (Update)
				   5. 컨테이너 Type만 변경되는 경우            ex) D4 x 1 -> D5 x 1 (New)
				                               ex) D2 x 1 -> D2 x 2 (Update)
				                                   D4 x 1 -> (Delete) : 삭제 대상에 대해서는 기술하지 않음.
				   6. 컨테이너 개수,Type 모두 변경된 경우     ex) D2 x 1-> D2 x 2 (Update)
				                                 -> D4 x 1 (New)
				   7. NS Batch에서 실행한 경우 파라미터의 brac 값을 그대로 사용한다.				                                                                                    
				   * 4~6에 대해서 New_Quantity를 기준으로 Old_Quantity와 비교하여 TypeCd의 유무에 따라 Update, New를 적용한다.
				*/ 
				
				Set<String> nsBracLoopSet = new HashSet<String>();
				
				if("R".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("R");
					
				// BRAC_CD가 N(New) 일 경우 : N
				} else if("N".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("N");
					
				// BRAC_CD가 B 일 경우 : B
				} else if("B".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("B");
					
				// 1. Old_Quantity가 null 일 경우 : Update
				} else if(oldQtyVOs == null) {
					nsBracLoopSet.add("U");
				
				// EDI Receive ID 가 NS가 아닐땐 BRAC_CD를 설정.
				} else if(!"NS".equals(tmnlRcvIdVO.getEdiRcvId())) {
					nsBracLoopSet.add(tmnlRcvIdVO.getBracCd());
					
				} else if("Y".equals(vender301ParamVO.getNsBatchFlag())) {
					nsBracLoopSet.add(vender301ParamVO.getBracCd());
					
				} else {
					String newTpszCd = "";
					String oldTpszCd = "";
					boolean isExist = true;
					
					for(int k=0; k<newBkgQtyVOs.size(); k++){
						newTpszCd = ((BkgQuantityVO)newBkgQtyVOs.get(k)).getCntrTpszCd();

						// Flag 초기화
						isExist = true;

						if(oldQtyVOs.size() > 0) {
							
							for(int l=0; l<oldQtyVOs.size(); l++){
								oldTpszCd = ((BkgQuantityVO)oldQtyVOs.get(l)).getCntrTpszCd();
								
								// New_Qunatity의 TypeCd가 Old_Qunatity에 존재 => NS_BRAC : Update.
								if(newTpszCd.equals(oldTpszCd)){
									nsBracLoopSet.add("U");
									isExist = true;
									break;

								} else {
									isExist = false;
								}
							}

							// New_Qunatity의 TypeCd가 Old_Qunatity에 존재하지 않음 => NS_BRAC : New.
							if(!isExist){
								nsBracLoopSet.add("N");
							}
							
						// 3. Old_Quantity가 0건일 경우
						} else {
							nsBracLoopSet.add("N");
						}
					}
				}				

				if ("".equals(tmnlRcvIdVO.getKindCd()) || tmnlRcvIdVO.getKindCd() == null) {
					tmnlRcvIdVO.setKindCd(ediKind);
				}
				if("Y".equals(autoManualFlg)){
					tmnlRcvIdVO.setKindCd(tmnlRcvIdVO.getKind());
				}				
				if ( ("CN".equals(tmnlRcvIdVO.getKindCd()) || "FC".equals(tmnlRcvIdVO.getKindCd()) || "BT".equals(tmnlRcvIdVO.getKindCd())) && !"".equals(tmnlRcvIdVO.getEdiRefCd()) && tmnlRcvIdVO.getEdiRefCd() != null){
					String msgCd = "";
					if ("CN".equals(tmnlRcvIdVO.getKindCd())) {
						msgCd = "5";
					}else if ("FC".equals(tmnlRcvIdVO.getKindCd())) {
						msgCd = "4";						
					}else if ("BT".equals(tmnlRcvIdVO.getKindCd())) {
						msgCd = "2";
					}

					hostId = utilBC.searchEdi301HostId(tmnlRcvIdVO, msgCd, "TMNL");
					
					if ("".equals(hostId) || hostId == null) {
						hostId = utilBC.searchEdi301HostId(tmnlRcvIdVO.getEdiRcvId(), "TMNL");						
					}
				}else{
					if(tmnlRcvIdVO.getEdiSndrId() != null && !tmnlRcvIdVO.getEdiSndrId().equals("")){
						hostId = tmnlRcvIdVO.getEdiSndrId();
					}else{
						hostId = utilBC.searchEdi301HostId(tmnlRcvIdVO.getEdiRcvId(), "TMNL");
					}
				}
				
				tmnlRcvIdVO.setHostId(hostId);
				// 전송할 flat_file 생성 New_Quantity의 수 만큼 생성
				Iterator<String> it = nsBracLoopSet.iterator();
				while(it.hasNext()) {
					nsBracCd = (String)it.next();
					
					// *****************    Flat File 생성 로직 (Start) *******
					if("Y".equals(autoManualFlg)){
						//auto 전송일때는 kind를 조회 결과에서 가져옴
						ediKind = tmnlRcvIdVO.getKind();
					}
					
					if ("CN".equals(ediKind)){
						ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "301M"));
						bkgBlNoVO.setEdiType("301M");
					} else if ("FC".equals(ediKind)) {//EMPTY RELEASE or FULL RELEASE 
						ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "301F"));
						bkgBlNoVO.setEdiType("301F");
					} else {
						if ("EsmBkg0252Event".equals(eventPage)) {
							ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "301M"));	
							bkgBlNoVO.setEdiType("301M");
						}else{
							ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "301F"));		
							bkgBlNoVO.setEdiType("301F");
						}
					}
					
					String refNo = ediHeader.substring(62);
					tmlEdiRefNo.add(refNo);
					log.debug("createTmlBkgReceiptEdi tmlEdiRefNo : " + refNo);
					
					BkgVvdVO oldVvdVO = null;
//					if(oldVvdVOs != null){
//						for(int j=0 ;j < oldVvdVOs.size(); j++){
//							if(oldVvdVOs.get(j).getVslPrePstCd().equals("T"))
//								oldVvdVO = oldVvdVOs.get(j);
//						}
//					}
					if(oldVvdVOs != null && oldVvdVOs.size() > 0){
						oldVvdVO = oldVvdVOs.get(0);
					}
					bkgBlNoVO.setNtcKndCd(ediKind);
					
					if("Y".equals(autoManualFlg)||"BM".equals(ediKind)){
						if(tmnlRcvIdVO.getBracCd() == null || tmnlRcvIdVO.getBracCd().length()<1){
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, tmnlRcvIdVO.getEdiRcvId());
							tmnlRcvIdVO.setBracCd((tmpBracCd == null) ? "N" : tmpBracCd) ;
						}
						
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setBracCd(tmnlRcvIdVO.getBracCd());
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvIdVO.getEdiRcvId());
						vender301ParamVO.setBracCdNew(tmnlRcvIdVO.getBracCd());

						ediBlMain1 = JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO));
					} else {
						if(!(bracCd != null && bracCd.equals("R"))){	
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, tmnlRcvIdVO.getEdiRcvId());
							bracCd = (tmpBracCd == null) ? "N" : tmpBracCd;
						}
						
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setBracCd(bracCd);
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvIdVO.getEdiRcvId());
						vender301ParamVO.setBracCdNew(bracCd);

						ediBlMain1 = JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO));
					}
					ediBlMain2 = JSPUtil.getNull(dbDao.searchTmnl301BlMain2(bkgBlNoVO));
	
					flatFiles[i] = new StringBuffer("");
					flatFiles[i].append(("".equals(ediHeader))?"":ediHeader+"\n");
					flatFiles[i].append(("".equals(ediBlMain1))?"":ediBlMain1+"\n");
					flatFiles[i].append(("".equals(ediBlMain2))?"":ediBlMain2+"\n");
				
					tmnlNsBracRcvIdVOs.add(tmnlRcvIdVO);
				}
				// *****************    Flat File 생성 로직 (End) *******
			}

			StringBuffer comFlatFile = new StringBuffer();
			
			ediCntrInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrInfo(bkgBlNoVO));
			comFlatFile.append(("".equals(ediCntrInfo))?"":ediCntrInfo+"\n");
			
			ediBlCntr = JSPUtil.getNull(dbDao.searchTmnl301BlCntr(bkgBlNoVO, oldQtyVOs));
			comFlatFile.append(("".equals(ediBlCntr))?"":ediBlCntr+"\n");
			List<Tmnl301BlVvdVO> tmnl301BlVvdVOs = dbDao.searchTmnl301BlVvd(bkgBlNoVO);
			for(int j=0; j<tmnl301BlVvdVOs.size(); j++){
				Tmnl301BlVvdVO tmnl301BlVvdVO = tmnl301BlVvdVOs.get(j);
				
				if(tmnl301BlVvdVO == null){
					tmnl301BlVvdVO = new Tmnl301BlVvdVO();
				}
				
				comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
				
				String oldVvd = "";
				String addOldVddFlag = "N"; 
				if(oldVvdVOs != null){
					for(int k=0; k < oldVvdVOs.size(); k++){
						BkgVvdVO oldVvdVO = oldVvdVOs.get(k);
						if(tmnl301BlVvdVO.getPolCd().equals(oldVvdVO.getPolCd())){
							if(!tmnl301BlVvdVO.getVvdCd().equals(oldVvdVO.getVslCd()+oldVvdVO.getSkdVoyNo()+oldVvdVO.getSkdDirCd())){
								oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd(oldVvdVO.getVslCd(),oldVvdVO.getSkdVoyNo(),oldVvdVO.getSkdDirCd(),oldVvdVO.getPolCd()));
								addOldVddFlag = "Y";
							} else {
								oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
								addOldVddFlag = "Y";
							}
							comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
						}						
					}
					if ("N".equals(addOldVddFlag)) {
						oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
						comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
					}					
				} else {
					oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
					comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
				}
			}
			
			ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVO));			
			
			comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");
			comFlatFile.append("}BKG_INFO\n");

			log.debug(comFlatFile.toString());
			for (int j=0; j<flatFiles.length; j++) {
				flatFiles[j].append(comFlatFile.toString());

				// Send
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFiles[j].toString());
				String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR_301.IBMMQ.QUEUE");
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

				log.debug("RESULT:"+flatFiles[j]);
				log.debug(flatFileAckVO.getSendId());
				
				// History				
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
				bkgNtcHisVO.setNtcViaCd("E");

				if("Y".equals(autoManualFlg)){//auto 전송일때는 kind를 조회 결과에서 가져옴
					ediKind = tmnlNsBracRcvIdVOs.get(j).getKind();
				} else if("BM".equals(ediKind)){//"BM" manual 전송은 BT로 바꿈
					ediKind = "BT";
				}
				
				bkgNtcHisVO.setNtcKndCd(StringUtils.isEmpty(ediKind) ? "BT" : ediKind);
				bkgNtcHisVO.setEdiId(tmnlNsBracRcvIdVOs.get(j).getEdiRcvId());
				bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				bkgNtcHisVO.setSndId(tmnlNsBracRcvIdVOs.get(j).getHostId());
				// Account 정보가 없을 경우에는 Batch에서 호출된것으로 판단하여 User ID, Office CD을 SYSTEM으로 설정한다.
				bkgNtcHisVO.setSndUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setSndOfcCd(account != null ? account.getOfc_cd() : "SYSTEM");
				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
				if("Y".equals(autoManualFlg)||"BM".equals(ediKind)){
					bkgNtcHisVO.setTmlNtcSndStsCd(tmnlNsBracRcvIdVOs.get(j).getBracCd());
				} else {
					bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
				}
				bkgNtcHisVO.setDiffRmk(tmlEdiRefNo.get(j));
				bkgNtcHisVO.setCreUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setUpdUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setPrnrSubLnkCd(ediRefCd[j]);
				/* BookingHistoryMgtDBDAOaddBkgNtcHisCSQL CNTR_SLT_NO_CTNT 필드에 값을 넣기 위해 처리 */
				bkgNtcHisVO.setCntrSltNoCtnt("Y");
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			log.info("####################");
			log.info("bkgNtcHisVOs length : " +bkgNtcHisVOs.size() );
			log.info("####################");
			return bkgNtcHisVOs;
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * create and transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTmlBkgReceiptEdiBatch(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException{
		BookingUtil utilBC = new BookingUtil();
		String hostId = "";

		String ediHeader  		= null;
		StringBuffer ediBlMain1 = new StringBuffer();
		StringBuffer ediBlMain2 = new StringBuffer();
		StringBuffer flatFile = new StringBuffer();
		String ediCntrInfo 		= null;
		String ediBlCntr		= null;
		String ediBlPoInfo 		= null;
		String tmlEdiRefNo 		= null;

		try {
			
			// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
			BkgBlNoVO[] bkgBlNoVOs = vender301ParamVO.getBkgBlNoVOs();
			List<BkgVvdVO> oldVvdVOs = vender301ParamVO.getOldVvdVOs();
			List<BkgQuantityVO> oldQtyVOs = vender301ParamVO.getOldQtyVOs();
			String bracCd = vender301ParamVO.getBracCd();
			String ediKind = vender301ParamVO.getEdiKind();
			String autoManualFlg = vender301ParamVO.getAutoManualFlg();
			String refCode = vender301ParamVO.getRefCode();
			String rcvId = vender301ParamVO.getRcvId();
			int hisCnt = 0;
			
			TmnlRcvIdVO tmnlRcvId = new TmnlRcvIdVO();
			tmnlRcvId.setEdiRcvId(rcvId);					
			tmnlRcvId.setKindCd(ediKind);					
			tmnlRcvId.setEdiRefCd(refCode);					
			StringBuffer comFlatFile = new StringBuffer();
			
			if ( ("CN".equals(tmnlRcvId.getKindCd()) || "FC".equals(tmnlRcvId.getKindCd()) || "BT".equals(tmnlRcvId.getKindCd())) && !"".equals(tmnlRcvId.getEdiRefCd()) && tmnlRcvId.getEdiRefCd() != null){
				String msgCd = "";
				if ("CN".equals(tmnlRcvId.getKindCd())) {
					msgCd = "5";
				}else if ("FC".equals(tmnlRcvId.getKindCd())) {
					msgCd = "4";
				}else if ("BT".equals(tmnlRcvId.getKindCd())) {
					msgCd = "9";
				}

				hostId = utilBC.searchEdi301HostId(tmnlRcvId, msgCd, "TMNL");
				
				if ("".equals(hostId) || hostId == null) {
					hostId = utilBC.searchEdi301HostId(tmnlRcvId.getEdiRcvId(), "TMNL");						
				}
			}else{
				hostId = utilBC.searchEdi301HostId(tmnlRcvId.getEdiRcvId(), "TMNL");
			}
			
			if ("CN".equals(ediKind)||"FC".equals(ediKind)) {//EMPTY RELEASE or FULL RELEASE 
				ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvId.getEdiRcvId(), "301F"));
			} else {
				ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvId.getEdiRcvId(), "301B"));
			}
			flatFile.append(("".equals(ediHeader))?"":ediHeader).append("\n");
			tmlEdiRefNo = ediHeader.substring(62);
			log.debug("tmlEdiRefNo:" + tmlEdiRefNo);
			
			for (int x=0; x < bkgBlNoVOs.length; x++) {
				List<BkgQuantityVO> newBkgQtyVOs = dbDao.searchTmnl301BkgQuantity(bkgBlNoVOs[x].getBkgNo());
				
				/* 1. Old_BkgQuantity가 null 일 경우 (물량변경 없는 화면에서 호출된 경우, 배치에서 호출된 경우) : Update
				   2. BRAC_CD가 R(Booking Cancel)일 경우 : R 
				   3. Old_Quantity가 0건일 경우 : New
				   4. 컨테이너 개수만 변경되는 경우               ex) D2 x 1 -> D2 x 2 (Update)
				   5. 컨테이너 Type만 변경되는 경우            ex) D4 x 1 -> D5 x 1 (New)
				                               ex) D2 x 1 -> D2 x 2 (Update)
				                                   D4 x 1 -> (Delete) : 삭제 대상에 대해서는 기술하지 않음.
				   6. 컨테이너 개수,Type 모두 변경된 경우     ex) D2 x 1-> D2 x 2 (Update)
				                                 -> D4 x 1 (New)
				   7. NS Batch에서 실행한 경우 파라미터의 brac 값을 그대로 사용한다.				                                                                                    
				   * 4~6에 대해서 New_Quantity를 기준으로 Old_Quantity와 비교하여 TypeCd의 유무에 따라 Update, New를 적용한다.
				*/ 
				Set<String> nsBracLoopSet = new HashSet<String>();
					
				// 1. Old_Quantity가 null 일 경우 : Update
				if(oldQtyVOs == null) {
					nsBracLoopSet.add("U");
				} else if("Y".equals(vender301ParamVO.getNsBatchFlag())) {
					nsBracLoopSet.add(vender301ParamVO.getBracCd());
				} else {
					String newTpszCd = "";
					String oldTpszCd = "";
					boolean isExist = true;
					
					for(int k = 0; k < newBkgQtyVOs.size(); k++){
						newTpszCd = ((BkgQuantityVO)newBkgQtyVOs.get(k)).getCntrTpszCd();
						// Flag 초기화
						isExist = true;
						if(oldQtyVOs.size() > 0) {
							for(int l=0; l<oldQtyVOs.size(); l++){
								oldTpszCd = ((BkgQuantityVO)oldQtyVOs.get(l)).getCntrTpszCd();
								// New_Qunatity의 TypeCd가 Old_Qunatity에 존재 => NS_BRAC : Update.
								if(newTpszCd.equals(oldTpszCd)){
									nsBracLoopSet.add("U");
									isExist = true;
									break;
								} else {
									isExist = false;
								}
							}
							// New_Qunatity의 TypeCd가 Old_Qunatity에 존재하지 않음 => NS_BRAC : New.
							if(!isExist){
								nsBracLoopSet.add("N");
							}
						// 3. Old_Quantity가 0건일 경우
						} else {
							nsBracLoopSet.add("N");
						}
					}
				}					
									
				if ( ("CN".equals(ediKind) || "FC".equals(ediKind) || "BT".equals(ediKind)) && !"".equals(refCode) && refCode != null){
					String msgCd = "";
					if ("CN".equals(ediKind)) {
						msgCd = "5";
					}else if ("FC".equals(ediKind)) {
						msgCd = "4";
					}else if ("BT".equals(ediKind)) {
						msgCd = "9";
					}

					hostId = utilBC.searchEdi301HostId(tmnlRcvId, msgCd, "TMNL");
					
					if ("".equals(hostId) || hostId == null) {
						hostId = utilBC.searchEdi301HostId(tmnlRcvId.getEdiRcvId(), "TMNL");						
					}
				}else{
					hostId = utilBC.searchEdi301HostId(tmnlRcvId.getEdiRcvId(), "TMNL");
				}

				// 전송할 flat_file 생성 New_Quantity의 수 만큼 생성
				Iterator<String> it = nsBracLoopSet.iterator();
				while(it.hasNext()) {
					String nsBracCd = (String)it.next();						
					
					BkgVvdVO oldVvdVO = null;
					if(oldVvdVOs != null){
						for(int j=0 ;j < oldVvdVOs.size(); j++){
							if(oldVvdVOs.get(j).getVslPrePstCd().equals("T"))
								oldVvdVO = oldVvdVOs.get(j);
						}
					}
					
					bkgBlNoVOs[x].setNtcKndCd(ediKind);
					
					if("Y".equals(autoManualFlg)||"BM".equals(ediKind)){
						if(tmnlRcvId.getBracCd() == null || tmnlRcvId.getBracCd().length() < 1){
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVOs[x], rcvId);
							tmnlRcvId.setBracCd((tmpBracCd == null) ? "N" : tmpBracCd) ;
						}
						
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVOs[x]);
						vender301ParamVO.setBracCd(tmnlRcvId.getBracCd());
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvId.getEdiRcvId());
						vender301ParamVO.setBracCdNew(tmnlRcvId.getBracCd());

						ediBlMain1.append(JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO)));
					} else {
						if(!(bracCd != null && bracCd.equals("R"))){	
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVOs[x], rcvId);
							bracCd = (tmpBracCd == null) ? "N" : tmpBracCd;
						}	
						
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVOs[x]);
						vender301ParamVO.setBracCd(bracCd);
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvId.getEdiRcvId());
						vender301ParamVO.setBracCdNew(bracCd);
						
						ediBlMain1.append(JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO)));
					}
					ediBlMain2.append(JSPUtil.getNull(dbDao.searchTmnl301BlMain2(bkgBlNoVOs[x])));
				}

				ediCntrInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrInfo(bkgBlNoVOs[x]));
				comFlatFile.append(("".equals(ediCntrInfo))?"":ediCntrInfo+"\n");
				
				ediBlCntr = JSPUtil.getNull(dbDao.searchTmnl301BlCntr(bkgBlNoVOs[x], oldQtyVOs));
				
				if(ediBlCntr != null)
					comFlatFile.append(("".equals(ediBlCntr))?"":ediBlCntr+"\n");
				
				List<Tmnl301BlVvdVO> tmnl301BlVvdVOs = dbDao.searchTmnl301BlVvd(bkgBlNoVOs[x]);
				
				for(int j=0; j<tmnl301BlVvdVOs.size(); j++){
					Tmnl301BlVvdVO tmnl301BlVvdVO = tmnl301BlVvdVOs.get(j);
					comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
					
					String oldVvd = "";
					String addOldVddFlag = "N"; 
					if(oldVvdVOs != null){
						for(int k=0; k < oldVvdVOs.size(); k++){
							BkgVvdVO oldVvdVO = oldVvdVOs.get(k);
							if(tmnl301BlVvdVO.getPolCd().equals(oldVvdVO.getPolCd())){
								if(!tmnl301BlVvdVO.getVvdCd().equals(oldVvdVO.getVslCd()+oldVvdVO.getSkdVoyNo()+oldVvdVO.getSkdDirCd())){
									oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd(oldVvdVO.getVslCd(),oldVvdVO.getSkdVoyNo(),oldVvdVO.getSkdDirCd(),oldVvdVO.getPolCd()));
									addOldVddFlag = "Y";
								} else {
									oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
									addOldVddFlag = "Y";
								}
								comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
							}						
						}
						if ("N".equals(addOldVddFlag)) {
							oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
							comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
						}
					} else {
						oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
						comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
					}
				}

				ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVOs[x]));			
				
				comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");
				comFlatFile.append("}BKG_INFO\n");

				flatFile.append(("".equals(ediBlMain1.toString()))?"":ediBlMain1.toString()).append("\n");
				flatFile.append(("".equals(ediBlMain2.toString()))?"":ediBlMain2.toString()).append("\n");
				flatFile.append(comFlatFile.toString());
				
				comFlatFile.delete(0, comFlatFile.length());
				ediBlMain1.delete(0, ediBlMain1.length());
				ediBlMain2.delete(0, ediBlMain2.length());
				hisCnt++;
			}

			String actStsCd = null;
			// Send
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR_301.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

			actStsCd = flatFileAckVO.getAckStsCd();
			
			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			log.debug("RESULT: \n" + sendFlatFileVO.getFlatFile());
			log.debug(flatFileAckVO.getSendId());
			
			if (hisCnt > 0) {
				for (int j=0; j < bkgBlNoVOs.length; j++) {			
					// History				
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(bkgBlNoVOs[j].getBkgNo());
					bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
					bkgNtcHisVO.setNtcViaCd("E");
	
					if(!"Y".equals(autoManualFlg) && "BM".equals(ediKind)){
						ediKind = "BT";
					}
					
					bkgNtcHisVO.setNtcKndCd(StringUtils.isEmpty(ediKind) ? "BT" : ediKind);
					bkgNtcHisVO.setPrnrSubLnkCd(tmnlRcvId.getEdiRefCd());
					bkgNtcHisVO.setEdiId(tmnlRcvId.getEdiRcvId());
					bkgNtcHisVO.setBkgNtcSndRsltCd(actStsCd);
					bkgNtcHisVO.setSndId(hostId);
					bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
					bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
					bkgNtcHisVO.setDiffRmk(tmlEdiRefNo);
					
					/* 배치에서 실행 */
					if(account == null || account.getUsr_id().equals("")){
						bkgNtcHisVO.setSndUsrId("OPUSADM");
						bkgNtcHisVO.setSndOfcCd("SINHO");
						bkgNtcHisVO.setCreUsrId("OPUSADM");
						bkgNtcHisVO.setUpdUsrId("OPUSADM");
						bkgNtcHisVO.setHisUiNm("BATCH");
					}else{
						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
						bkgNtcHisVO.setHisUiNm("ESM_BKG_0616");
					}
					bkgHisrotyDao.addBkgNtcHis(bkgNtcHisVO); 
					
					if("BT".equals(bkgNtcHisVO.getNtcKndCd())){
						String strHisSeq = bkgHisrotyDao.searchNextHistSeq(bkgNtcHisVO.getBkgNo());						
						//-------------------------
						// add History Master
						//-------------------------
						BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
						bkgHisMstVO.setBkgNo        (bkgNtcHisVO.getBkgNo());
						bkgHisMstVO.setHisSeq       (strHisSeq);
						bkgHisMstVO.setBkgHisIssUiId("");
						bkgHisMstVO.setCreUsrId     (bkgNtcHisVO.getCreUsrId());
						bkgHisMstVO.setUpdUsrId     (bkgNtcHisVO.getUpdUsrId());
						bkgHisrotyDao.addBkgHisMst(bkgHisMstVO);
						if ("E".equals(bkgNtcHisVO.getNtcViaCd())) { 
							BkgTmlEdiHisVO bkgTmlEdiHisVO = new BkgTmlEdiHisVO();
							bkgTmlEdiHisVO.setBkgNo(bkgNtcHisVO.getBkgNo());
							bkgTmlEdiHisVO.setHisSeq(strHisSeq);
							bkgTmlEdiHisVO.setTmlEdiRqstNo(bkgNtcHisVO.getDiffRmk());
							bkgHisrotyDao.addBkgTmlEdiHis(bkgTmlEdiHisVO, bkgNtcHisVO.getCreUsrId());
						}
					}
					
//					bkgNtcHisVOs.add(bkgNtcHisVO);
				}
			}
//			log.info("####################");
//			log.info("bkgNtcHisVOs length : " +bkgNtcHisVOs.size() );
//			log.info("####################");
//			return bkgNtcHisVOs;
			return null;
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}

	}
	
	/**
	 * retrieve T/S Route information of Empty Booking
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<MtyBkgTsRouteVO>
	 * @exception 	EventException
	 */
	public List<MtyBkgTsRouteVO> searchEmptyBkgTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchEmptyBkgTsRoute(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
	/**
	 * retrieve Container List of Empty Status in the Yard
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @param  		String cntrTpsz
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchCntrByYard(String vvd, String ydCd, String cntrTpsz) throws EventException {
		try {
			return dbDao.searchCntrByYard(vvd, ydCd, cntrTpsz);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * retrieve sent Fax/Email list(ESM_BKG_0095)<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<SendBkgFaxEmailVO>
	 * @exception 	EventException
	 */
	public List<SendBkgFaxEmailVO> searchFaxEmailForNotice(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchFaxEmailForNotice(bkgBlNoVO, account.getOfc_cd());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * retrieve sent EDI list(ESM_BKG_0095)<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SendBkgEdiVO>
	 * @exception 	EventException
	 */
	public List<SendBkgEdiVO> searchEdiForNotice(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEdiForNotice(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * Bkg Receipt Type retrieve(ESM_BKG_0095)<br>
	 * @param String usrId
	 * @return String 
	 * @exception 	EventException
	 */
	public String searchBkgReceiptType(String usrId) throws EventException {
		try {
			return dbDao.searchBkgReceiptType(usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * retrieve basis information for classification yard by  type / size when EDI transmits<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param QtyInfoVO qtyInfoVO
	 * @return YardAssignVO
	 * @exception EventException
	 */
	public YardAssignVO searchYardAssign( BkgBlNoVO bkgBlNoVO , QtyInfoVO qtyInfoVO ) throws EventException{
		try {
			YardAssignVO yardAssignVO = new YardAssignVO();
			yardAssignVO.setBkgInfoForYardAssignVO(dbDao.searchBkgInfoForYardAssign(bkgBlNoVO));
			if (qtyInfoVO ==null){
				yardAssignVO.setQtyInfoVOList(dbDao.searchQtyInfoForYardAssign(bkgBlNoVO));
			}			
			
			return yardAssignVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Make sure the entered yard is in the mdm_yard.<br>
	 * @param QtyInfoVO[] qtyInfoVOs
	 * @exception EventException
	 */
	public void validateYardAssign(QtyInfoVO[] qtyInfoVOs) throws EventException{
		try {
			BookingUtil utilBC = new BookingUtil();
			MdmYardVO mdmYardVO = null;
			List<MdmYardVO> mdmYardVOList = null; 
			
			for(int i=0;i<qtyInfoVOs.length;i++){
				mdmYardVO = new MdmYardVO();
				if (JSPUtil.getNull(qtyInfoVOs[i].getYdCd()).length()==7){
					mdmYardVO.setLocCd(qtyInfoVOs[i].getYdCd().substring(0,5));
					mdmYardVO.setYdCd(qtyInfoVOs[i].getYdCd());
				}else if (JSPUtil.getNull(qtyInfoVOs[i].getYdCd()).length()>4){
					mdmYardVO.setLocCd(qtyInfoVOs[i].getYdCd().substring(0,5));
				}
				 
				mdmYardVOList=utilBC.searchYardCode(mdmYardVO);
				if (mdmYardVOList.isEmpty()){
					throw new EventException((String)new ErrorHandler("BKG01078",new String[]{qtyInfoVOs[i].getYdCd()}).getMessage());
				}
			}
			
		} catch (EventException ex) {
			throw ex;			 
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	
	
	/**
	 * retrieve event handling<br>
	 *  retrieve event handling about Route Detail screen
	 * @param bkgNo	
	 * @return awkCgoApplVO
	 * @exception EventException
	 */
	public RouteDtlVO searchRouteDetail(String bkgNo) throws EventException {

		RouteDtlVO routeDtlVO = new RouteDtlVO();		
		
        try {        	
        		log.debug("&&&&&&&&&&&&&&&&&& routeDtlVO : " + routeDtlVO);          
                log.debug(">>>>>>>>> bkgNo      : " + bkgNo);
                
                routeDtlVO.setRouteDtlInfo(dbDao.searchRouteDtlInfoList(bkgNo));                
                routeDtlVO.setRouteDtlVvd(dbDao.searchRouteDtlVvdList(bkgNo));
                
                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return routeDtlVO;
    }

	/**
	 * transmit surrender notice, carrier haulage notice<br>	 
	 * @param String mrdNm
	 * @param String ntcKndCd	 
	 * @param String faxNo	 
	 * @param String param	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByFax(String mrdNm, String ntcKndCd, String faxNo, String param, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		try {
			return eaiDao.sendBkgNoticeByFax(bkgBlNoVO, ntcKndCd, faxNo, mrdNm, param, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}		
	}

	/**
	 * transmit surrender notice, carrier haulage notice<br>	 
	 * @param String mrdNm	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String param
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		String ccEmail = null;
		try {
			util = new BookingUtil();
			ccEmail = util.searchCcEmailAddrRSQL("BK", account.getUsr_id());
			return eaiDao.sendBkgNoticeByEmail(bkgBlNoVO, ntcKndCd, eml, mrdNm, param, ccEmail, bkgEmlEdtVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * retrieve which Tab will show among Booking Creation tab
	 * @param     SignOnUserAccount account
	 * @return    String 
	 * @exception EventException
	 */
	public String searchBkgCreTabByUser(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchBkgCreTabByUser(account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieve name and additional information when customer code changes at booking creation
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustomerVO
	 * @exception 	EventException
	 */
	public BkgCreCustomerVO searchCustNm(	String custCntCd, String custSeq) throws EventException {
		BkgCreCustomerVO bkgCreCustomerVO = null;
		try {
			List<BkgCreCustomerVO> searchBkgCreCustomer = dbDao.searchBkgCreCustomer(custCntCd,custSeq,"","","");

			if(searchBkgCreCustomer != null && searchBkgCreCustomer.size() > 0){
				bkgCreCustomerVO = searchBkgCreCustomer.get(0);
				if(bkgCreCustomerVO != null){
					if("DELETE".equals(bkgCreCustomerVO.getPb())){
						throw new EventException((String)new ErrorHandler("BKG00353",new String[]{custCntCd, custSeq}).getMessage());
//					}else if("BLACK".equals(bkgCreCustomerVO.getPb())){
//						throw new EventException((String)new ErrorHandler("BKG00055").getMessage());
					}else if("NO USE".equals(bkgCreCustomerVO.getPb())){
						throw new EventException((String)new ErrorHandler("BKG02004").getMessage());
					}
				}
			}			
		} catch (EventException ex) {
			throw ex;								
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bkgCreCustomerVO;
	}
	/**
	 * retrieve bkg data for special cargo request again
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String rqstType
	 * @param		SignOnUserAccount account
	 * @return 		ScgAproRqstVO[]
	 * @exception 	EventException
	 */
	public ScgAproRqstVO[] searchBkgForSpclRqst(BkgBlNoVO bkgBlNoVO, String rqstType, SignOnUserAccount account) throws EventException{
		try {
			List<ScgAproRqstVO> aproRqstVO = dbDao.searchBkgForSpclRqst(bkgBlNoVO, rqstType);
			ScgAproRqstVO[] arrAproRqstVO = new ScgAproRqstVO[aproRqstVO.size()];
			for(int i=0;i<aproRqstVO.size();i++){
				arrAproRqstVO[i] = aproRqstVO.get(i); 
        		arrAproRqstVO[i].setIbflag("I");        		
        		arrAproRqstVO[i].setLstRqstDatFlg("N");
        		arrAproRqstVO[i].setRqstUsrId(account.getUsr_id());
        		arrAproRqstVO[i].setRqstOfcCd(account.getOfc_cd());
        		arrAproRqstVO[i].setRqstDt(account.getUpd_dt());
        		arrAproRqstVO[i].setSpclBkgRqstFlg("N");        		
			}
			return arrAproRqstVO;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}
	/**
	 * retrieve spcl cgo seq for special cargo request again
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		SpclReqInVO[]
	 * @exception 	EventException
	 */
	public SpclReqInVO[] searchSpclReqInVO(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			List<SpclReqInVO> spclReqInVOs =  dbDao.searchSpclReqInVO(bkgBlNoVO);
			SpclReqInVO[] rtnSpclReqInVOs = new SpclReqInVO[spclReqInVOs.size()];
			for(int i=0;i<spclReqInVOs.size();i++){
				rtnSpclReqInVOs[i] = spclReqInVOs.get(i);
				rtnSpclReqInVOs[i].setAproCd("R");
			}
			return rtnSpclReqInVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	

	/**
	 * if status is Upload when eBooking Doc Type is B, that is automatically transmission
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param String[] emlAddr
	 * @param String[] remark
	 * @param String mrdNm
	 * @param String[] cct
	 * @param SignOnUserAccount account
	 * @param String title
	 * @param String Contents
	 * @param String vslNm
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendXterReceiptByEmail(BkgBlNoVO[] bkgBlNoVO, String[] emlAddr, String[] remark,String mrdNm, String[] cct, SignOnUserAccount account, String title, String Contents, String vslNm) throws EventException{
		try {
			return eaiDao.sendXterReceiptByEmail(bkgBlNoVO, emlAddr, remark, mrdNm, cct, vslNm, account, title, Contents );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * 해당 booking의 roll over 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return RollOvrInfoVO
	 * @throws EventException
	 */
	public RollOvrInfoVO searchRollOvr(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			RollOvrInfoVO rollOvrInfoVO = new RollOvrInfoVO();
			rollOvrInfoVO.setBkgInforForHistVO(dbDao.searchBkgInfoForHist(bkgBlNoVO));
			rollOvrInfoVO.setRollOvrVO(dbDao.searchRollOvr(bkgBlNoVO));
			
			return rollOvrInfoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}	
	
	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param ediRefCd
	 * @param vvd
	 * @return
	 * @throws EventException
	 */
	public BkgBlNoVO[] searchBkgTmlEdiBatch(String ediRefCd, String vvd) throws EventException {
		try {
			List<BkgBlNoVO> bkgBlNoVOs = dbDao.searchBkgTmlEdiBatch(ediRefCd, vvd);
			BkgBlNoVO[] arrBkgBlNoVO = new BkgBlNoVO[bkgBlNoVOs.size()];
			for(int i=0;i<bkgBlNoVOs.size();i++){
				arrBkgBlNoVO[i] = bkgBlNoVOs.get(i); 
				arrBkgBlNoVO[i].setIbflag("U");        		
			}
			return arrBkgBlNoVO;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param String ediRefCd
	 * @return BkgBlNoVO[]
	 * @throws EventException
	 */
	public BkgBlNoVO[] searchBkgTmlEdiBatch(String ediRefCd) throws EventException{
		return searchBkgTmlEdiBatch(ediRefCd, null);
	}	

	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @return List<BkgYardCdVO>
	 * @throws EventException
	 */
	public List<BkgYardCdVO> searchBkgTmlEdiBatchYardCd() throws EventException{
		try {
			return dbDao.searchBkgTmlEdiBatchYardCd();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 
	 * @param ydCd
	 * @return
	 * @throws EventException
	 */
	public String searchBatchEdiVvdList(String ydCd) throws EventException {
		try {
			return dbDao.searchBatchEdiVvdList(ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param HisUiNm
	 * @param rcvId
	 * @param sndrId
	 * @param refCode
	 * @param ediKind
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public BkgNtcHisVO createTmlBkgReceiptEdi(String bkgNo, String HisUiNm, String rcvId, String sndrId, String refCode, String ediKind, SignOnUserAccount account) throws EventException{
		BookingUtil utilBC = new BookingUtil();

		String ediHeader  		= null;
		String ediBlMain1 		= null;
		String ediBlMain2 		= null;
		String ediCntrInfo 		= null;
		String ediBlCntr		= null;
		String ediBlPoInfo 		= null;
		try {

			// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			
			StringBuffer flatFiles = new StringBuffer();
			log.info("\n === createTmlBkgReceiptEdi BkgNo : " + bkgBlNoVO.getBkgNo());
			if ("CN".equals(ediKind)){
				ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(sndrId, rcvId, "301M"));
				bkgBlNoVO.setEdiType("301M");
			} else if ("FC".equals(ediKind)) {//EMPTY RELEASE or FULL RELEASE 
				ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(sndrId, rcvId, "301F"));
				bkgBlNoVO.setEdiType("301F");
			} else {
					ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(sndrId, rcvId, "301F"));		
					bkgBlNoVO.setEdiType("301F");
			}
			
			String refNo = ediHeader.substring(62);
			log.debug("createTmlBkgReceiptEdi tmlEdiRefNo : " + refNo);
			bkgBlNoVO.setNtcKndCd(ediKind);
			String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, rcvId);
			String bracCd = (tmpBracCd == null) ? "N" : tmpBracCd;
			// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setOldVvdVO(null);
			vender301ParamVO.setBracCd(bracCd);
			vender301ParamVO.setNsBracCd(null);
			vender301ParamVO.setCct("");
			vender301ParamVO.setRcvId(rcvId);
			vender301ParamVO.setBracCdNew(bracCd);

			ediBlMain1 = JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO));
			ediBlMain2 = JSPUtil.getNull(dbDao.searchTmnl301BlMain2(bkgBlNoVO));

			flatFiles.append(("".equals(ediHeader))?"":ediHeader+"\n");
			flatFiles.append(("".equals(ediBlMain1))?"":ediBlMain1+"\n");
			flatFiles.append(("".equals(ediBlMain2))?"":ediBlMain2+"\n");
				
			// *****************    Flat File 생성 로직 (End) *******

			StringBuffer comFlatFile = new StringBuffer();
			
			ediCntrInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrInfo(bkgBlNoVO));
			comFlatFile.append(("".equals(ediCntrInfo))?"":ediCntrInfo+"\n");
			
			ediBlCntr = JSPUtil.getNull(dbDao.searchTmnl301BlCntr(bkgBlNoVO, null));
			comFlatFile.append(("".equals(ediBlCntr))?"":ediBlCntr+"\n");
			List<Tmnl301BlVvdVO> tmnl301BlVvdVOs = dbDao.searchTmnl301BlVvd(bkgBlNoVO);
			for(int j=0; j<tmnl301BlVvdVOs.size(); j++){
				Tmnl301BlVvdVO tmnl301BlVvdVO = tmnl301BlVvdVOs.get(j);
				
				if(tmnl301BlVvdVO == null){
					tmnl301BlVvdVO = new Tmnl301BlVvdVO();
				}
				
				comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
				
				String oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","",""));
				comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
			}
			
			ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVO));			
			
			comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");
			comFlatFile.append("}BKG_INFO\n");

			log.debug(comFlatFile.toString());
//			for (int j=0; j<flatFiles.length; j++) {
				flatFiles.append(comFlatFile.toString());

				// Send
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFiles.toString());
				String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR_301.IBMMQ.QUEUE");
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

				log.debug("RESULT:"+flatFiles);
				log.debug(flatFileAckVO.getSendId());
				
				// History				
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setHisSeq("1");
				bkgNtcHisVO.setNtcViaCd("E");

//				if("Y".equals(autoManualFlg)){//auto 전송일때는 kind를 조회 결과에서 가져옴
//					ediKind = tmnlNsBracRcvIdVOs.get(j).getKind();
//				} else if("BM".equals(ediKind)){//"BM" manual 전송은 BT로 바꿈
//					ediKind = "BT";
//				}
//				
				bkgNtcHisVO.setNtcKndCd(StringUtils.isEmpty(ediKind) ? "BT" : ediKind);
				bkgNtcHisVO.setEdiId(rcvId);
				bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				bkgNtcHisVO.setSndId(sndrId);
				// Account 정보가 없을 경우에는 Batch에서 호출된것으로 판단하여 User ID, Office CD을 SYSTEM으로 설정한다.
				bkgNtcHisVO.setSndUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setSndOfcCd(account != null ? account.getOfc_cd() : "SYSTEM");
				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
				
				bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
				bkgNtcHisVO.setDiffRmk(refNo);
				bkgNtcHisVO.setCreUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setUpdUsrId(account != null ? account.getUsr_id() : "SYSTEM");
				bkgNtcHisVO.setPrnrSubLnkCd(refCode);
				/* BookingHistoryMgtDBDAOaddBkgNtcHisCSQL CNTR_SLT_NO_CTNT 필드에 값을 넣기 위해 처리 */
				bkgNtcHisVO.setCntrSltNoCtnt("Y");
//				bkgNtcHisVOs.add(bkgNtcHisVO);
//			}
//			log.info("####################");
//			log.info("bkgNtcHisVOs length : " +bkgNtcHisVOs.size() );
//			log.info("####################");
			return bkgNtcHisVO;
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 
	 * @param bkgNo
	 * @param rcvId
	 * @param sndrId
	 * @param refCode
	 * @param ediKind
	 * @param cntrNo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public BkgNtcHisVO createVermasBkgReceiptEdi(String bkgNo, String rcvId, String sndrId, String refCode, String ediKind,	String cntrNo, SignOnUserAccount account) throws EventException {
		BookingUtil utilBC = new BookingUtil();
		String ediHeader = null;
		StringBuffer flatFiles = new StringBuffer();
		try {
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCntrNo(cntrNo);
			bkgBlNoVO.setSndId(sndrId);
			bkgBlNoVO.setEdiType("VERMAS");
			bkgBlNoVO.setNtcKndCd(ediKind);
			String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, rcvId);
			String bracCd = (tmpBracCd == null) ? "C" : tmpBracCd;
			
			ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(sndrId, rcvId, "VERMAS"));
			
			String vermasMain = dbDao.searchVermasMain(bkgNo, cntrNo, bracCd, refCode);
			if(vermasMain == null || vermasMain.isEmpty()) return null;

			flatFiles.append(ediHeader).append("\n");
			flatFiles.append(vermasMain).append("\n");
				
			// *****************    Flat File 생성 로직 (End) *******
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFiles.toString());
			String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR_301.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			
			FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
//			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());
			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
//			log.debug("RESULT:"+flatFiles);
//			log.debug(flatFileAckVO.getSendId());
			
			// History				
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setHisSeq("1");
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setCntrNo(cntrNo);
			bkgNtcHisVO.setNtcKndCd(StringUtils.isEmpty(ediKind) ? "BT" : ediKind);
			bkgNtcHisVO.setEdiId(rcvId);
			bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
			bkgNtcHisVO.setSndId(sndrId);
			// Account 정보가 없을 경우에는 Batch에서 호출된것으로 판단하여 User ID, Office CD을 SYSTEM으로 설정한다.
			bkgNtcHisVO.setSndUsrId(account != null ? account.getUsr_id() : "SYSTEM");
			bkgNtcHisVO.setSndOfcCd(account != null ? account.getOfc_cd() : "SYSTEM");
			bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
			
			bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
			bkgNtcHisVO.setDiffRmk(ediHeader.substring(62));
			bkgNtcHisVO.setCreUsrId(account != null ? account.getUsr_id() : "SYSTEM");
			bkgNtcHisVO.setUpdUsrId(account != null ? account.getUsr_id() : "SYSTEM");
			bkgNtcHisVO.setPrnrSubLnkCd(refCode);
			bkgNtcHisVO.setCntrSltNoCtnt("Y");
			
			return bkgNtcHisVO;
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
}