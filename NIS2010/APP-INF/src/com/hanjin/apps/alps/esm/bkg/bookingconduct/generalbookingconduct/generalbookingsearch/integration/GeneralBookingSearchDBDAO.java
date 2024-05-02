/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAO.java
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.04.30 김병규
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2011.03.21 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.10.14 정선용 [CHM-201113680-01] 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.11.28 금병주 [CHM-201114706-01] [BKG_1139 :U/I제출] EUR TRO Notice 전송 Pop-up
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.08.03 이재위 [CHM-201218218] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
* 2014.01.14 문동선 [CHM-201328181] [BKG] Space allocation 연계 Waiting booking process 개발 Project
* 2014.08.29 문동선 [CHM-201431517] Pre-Caution 반영 Alert 메세지 생성 로직 삽입 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.AlocStandbyReasonVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgChgOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCreCustInqCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgForCargoClosingVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInfoForYardAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EdiFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PropNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RcvrBkgReviseNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SvcRouteModeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301BlVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301DgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301TroMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;


/**
 * ALPS GeneralBookingSearchDBDAO <br>
 * - ALPS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimByungKyu
 * @see GeneralBookingSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralBookingSearchDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5265081842548039417L;

	/**
	 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Transhipment Route and VVD 목록을 조회한다.
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return	 		List<TSRouteVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TSRouteVO> searchIbTsRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOTSRouteVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSRouteVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * Cod VVD 정보를 조회한다.
	 * 
 	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String codRqstSeq
	 * @param 		String opCd 
	 * @return 		List<TSRouteVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TSRouteVO> searchCodTsRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq , String opCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("cod_rqst_seq", codRqstSeq);
			param.put("op_cd", opCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCodTsRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSRouteVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 
	 
	 	/**
	 	 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 	 * Customer Inquiry의 Customer 목록을 조회한다.
	 	 * 
	 	 * @author 		KimByungKyu
	 	 * @param 		String custCntCd
	 	 * @param 		String custSeq
	 	 * @param 		String custNm
	 	 * @param 		String ofcCd
	 	 * @return 		List<BkgCreCustomerVO>
	 	 * @exception 	DAOException
	 	 */
	 	 @SuppressWarnings("unchecked")
	 	public List<BkgCreCustomerVO> searchBkgCreCustomer(	String custCntCd,
	 																					 	String custSeq,
	 																					 	String custNm,
	 																					 	String ofcCd	) throws DAOException {
	 		DBRowSet dbRowset = null;
	 		List<BkgCreCustomerVO> list = null;
	 		//query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		//velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();

	 		try{
	 			param.put("cust_cnt_cd", custCntCd);
	 			param.put("cust_seq", custSeq);
	 			param.put("cust_lgl_eng_nm", custNm);
	 			param.put("ofc_cd", ofcCd);

	 			velParam.put("cust_cnt_cd", custCntCd);
	 			velParam.put("cust_seq", custSeq);
	 			velParam.put("cust_lgl_eng_nm", custNm);
	 			velParam.put("ofc_cd", ofcCd);

	 			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOBkgCreCustomerRSQL(), param, velParam);
	 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCreCustomerVO .class);
	 		}catch(SQLException se){
	 			log.error(se.getMessage(),se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 		}catch(Exception ex){
	 			log.error(ex.getMessage(),ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 		}
	 		return list;
	 	}
	 	 
	 	/**
		 	 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 	 * Customer Inquiry의 Customer 목록을 조회한다.
		 	 * 
		 	 * @author 		KimByungKyu
		 	 * @param 		BkgCreCustInqCondVO bkgCreCustInqCondVO
		 	 * @return 		List<BkgCreCustomerVO>
		 	 * @exception 	DAOException
		 	 */
		 	 @SuppressWarnings("unchecked")
		 	public List<BkgCreCustomerVO> searchBkgCreCustomer(	BkgCreCustInqCondVO bkgCreCustInqCondVO) throws DAOException {
		 		DBRowSet dbRowset = null;
		 		List<BkgCreCustomerVO> list = null;
		 		//query parameter
		 		Map<String, Object> param = new HashMap<String, Object>();
		 		//velocity parameter
		 		Map<String, Object> velParam = new HashMap<String, Object>();

		 		try{
		 			if(bkgCreCustInqCondVO != null){
						Map<String, String> mapVO = bkgCreCustInqCondVO .getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

		 			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOBkgCreCustomerRSQL(), param, velParam);
		 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCreCustomerVO .class);
		 		}catch(SQLException se){
		 			log.error(se.getMessage(),se);
		 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 		}catch(Exception ex){
		 			log.error(ex.getMessage(),ex);
		 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 		}
		 		return list;
		 	}
		 	

	 	/**
	 	 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 	 * Customer Inquiry의 선택된 화주의 S.OPC 목록을 조회한다.
	 	 * 
	 	 * @author 		KimByungKyu 
	 	 * @param 		String custCntCd
	 	 * @param 		String custSeq
	 	 * @return 		List<CustSrepVO>
	 	 * @exception 	DAOException
	 	 */
	 	 @SuppressWarnings("unchecked")
	 	public List<CustSrepVO> searchCustSrep(	String custCntCd,String custSeq	) throws DAOException {
	 		DBRowSet dbRowset = null;
	 		List<CustSrepVO> list = null;
	 		//query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		//velocity parameter
	 		Map<String, Object> velParam = new HashMap<String, Object>();

	 		try{
	 			param.put("cust_cnt_cd", custCntCd);
	 			param.put("cust_seq", custSeq);

	 			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOCustSrepRSQL(), param, velParam);
	 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustSrepVO .class);
	 		}catch(SQLException se){
	 			log.error(se.getMessage(),se);
	 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
	 		}catch(Exception ex){
	 			log.error(ex.getMessage(),ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	 		}
	 		return list;
	 	}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Customer Inquiry의 선택된 화주의 S.OPC 목록을 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
	 	 * @param 		String custCntCd
	 	 * @param 		String custSeq
	 	 * @return 		List<BkgCustCntcPsonVO>
	 	 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgCustCntcPsonVO> searchCustContact(	String custCntCd,String custSeq	) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgCustCntcPsonVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("cust_cnt_cd", custCntCd);
				param.put("cust_seq", custSeq);

				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOBkgCustCntcPsonVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustCntcPsonVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Service Mode & Route 정보를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		SvcRouteModeVO
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public SvcRouteModeVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			SvcRouteModeVO svcRouteModeVO = null;
			List<SvcRouteModeVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOBkgBookingVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SvcRouteModeVO .class);
				if(list != null && list.size() > 0){
					svcRouteModeVO = list.get(0);
				}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return svcRouteModeVO;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Constraints 정보를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		List<PrdConstraintVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PrdConstraintVO> searchConstraint(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PrdConstraintVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchConstraintRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrdConstraintVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Node Search 조회시 Yard 선택시 정보를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		NodeListInputVO nodeListInputVO
		 * @return 		List<NodeListVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<NodeListVO> searchYardCode(NodeListInputVO nodeListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<NodeListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(nodeListInputVO != null){
					Map<String, String> mapVO = nodeListInputVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchYardCodeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, NodeListVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}


			/**
			 * Location 정보를 조회한다.
			 * 
		 	 * @author 		KimByungKyu 
			 * @param 		LocationListInputVO locationListInputVO
			 * @return 		List<LocationListVO>
			 * @exception 	DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<LocationListVO> searchLocationList(LocationListInputVO locationListInputVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<LocationListVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(locationListInputVO != null){
						Map<String, String> mapVO = locationListInputVO .getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchLocationListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationListVO .class);

				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
				return list;
			}		 
		 
		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Node Search 조회시 Zone 선택시 정보를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		NodeListInputVO nodeListInputVO
		 * @return 		List<NodeListVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<NodeListVO> searchZoneCode(NodeListInputVO nodeListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<NodeListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(nodeListInputVO != null){
					Map<String, String> mapVO = nodeListInputVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchZoneCodeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, NodeListVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Reference Number 정보를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		List<RefNoVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RefNoVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RefNoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgReferenceRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RefNoVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Direct NVO-AMS File No를 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		List<BkgUsaCstmsFileNoVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgUsaCstmsFileNoVO> searchNVOFileNumberList(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgUsaCstmsFileNoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchNVOFileNumberListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsaCstmsFileNoVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * Direct NVO-AMS File No 화면내 TTL No. of HB/L 값을 조회한다.
		 * 
	 	 * @author 		KimByungKyu 
		 * @param 		BkgBlNoVO bkgBlNoVO
		 * @return 		List<HblCountVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<HblCountVO> searchHblCount(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<HblCountVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchHblCountRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, HblCountVO .class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		 /**
		  * ESM_BKG_0721 조회 화면
		  * @param bkgBlNoVO
		  * @return
		  * @exception DAOException
		  */
		@SuppressWarnings("unchecked")
		public List<BkgForCargoClosingVO> searchBkgForCargoClosing(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgForCargoClosingVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchBkgForCargoClosingRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgForCargoClosingVO.class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		/**
		 * 해당 booking의 cct 정보를 조회<br>
		 * 
		 * @param BkgBlNoVO bkgBlNoVO
		 * @param SignOnUserAccount account
		 * @return List<ClzTmVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<ClzTmVO> searchCargoClosingTime(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws DAOException {
			DBRowSet dbRowset = null;
			List<ClzTmVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClzTmVO.class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}

		/**
		 * Customer Code 조회
		 * @param SearchActualCustomerVO searchActualCustomerVO
		 * @return List<SearchActualCustomerVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchActualCustomerVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = searchActualCustomerVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchActualCustomerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualCustomerVO.class);

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
	/**
	 * Empty Repo Bkg에 속해 있는 Container No List를 조회한다.(ESM_BKG_9450)
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<CntrInfoForEmptyVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrInfoForEmptyVO> searchEmptyCntrByBKG(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrInfoForEmptyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEmptyCntrByBKGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrInfoForEmptyVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	 
	 
	/**
	 * 모든 Service Scope의 Code와 Name을 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @return 		List<MdmSvcScpVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmSvcScpVO> searchSvcScp() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSvcScpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchSvcScpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmSvcScpVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

		 
	/**
	 * 화주 계약서상의 RFA를 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RfaListVO> searchRfaList(RfaListInputVO rfaListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rfaListInputVO != null){
				Map<String, String> mapVO = rfaListInputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchRfaListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RfaListVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 
	 
	/**
	 * 화주 계약서상의 S/C를 조회한다.(ESM_BKG_0655)
	 * 
	 * @author		KimByungKyu
	 * @param 		ScListInputVO scListInputVO
	 * @return 		List<ScListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScListVO> searchScList(ScListInputVO scListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(scListInputVO != null){
				Map<String, String> mapVO = scListInputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchScListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScListVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 	 
	 
	/**
	 * RFA로 Prop No를 조회한다.(ESM_BKG_0656)
	 * 
	 * @author		KimByungKyu
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		PropNoVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PropNoVO searchPropNoByRfa(RfaListInputVO rfaListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PropNoVO> list = null;
		PropNoVO propNoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rfaListInputVO != null){
				Map<String, String> mapVO = rfaListInputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchPropNoByRfaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PropNoVO.class);	
			if(list != null && list.size() > 0){
				propNoVO = list.get(0);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return propNoVO;
	}	 	 

	 
	/**
	 * RFA 계약 상의 Commodity를 조회한다.(ESM_BKG_0656)
	 * 
	 * @author		KimByungKyu
	 * @param 		PropNoVO propNoVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @return 		List<RfaCmdtListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RfaCmdtListVO> searchCmdtByRfa(PropNoVO propNoVO, String cmdtNm, String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(propNoVO != null){
				Map<String, String> mapVO = propNoVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			param.put("cmdt_nm", cmdtNm);
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_nm", cmdtNm);
			velParam.put("cmdt_cd", cmdtCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RfaCmdtListVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

		/**
		 * 화주 계약서상의 TAA를 조회한다.(ESM_BKG_1062)
		 * 
		 * @author		KimByungKyu
		 * @param 		TaaListInputVO taaListInputVO
		 * @return 		List<TaaListVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<TaaListVO> searchTaaList(TaaListInputVO taaListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TaaListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(taaListInputVO != null){
					Map<String, String> mapVO = taaListInputVO .getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchTaaListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TaaListVO.class);	
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}	 
		 
		/**
		 * TAA로 Prop No를 조회한다.(ESM_BKG_1078)
		 * 
		 * @author		KimByungKyu
		 * @param 		TaaListInputVO taaListInputVO
		 * @return 		PropNoVO
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public PropNoVO searchPropNoByTaa(TaaListInputVO taaListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PropNoVO> list = null;
			PropNoVO propNoVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(taaListInputVO != null){
					Map<String, String> mapVO = taaListInputVO .getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchPropNoByTaaRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PropNoVO.class);	
				if(list != null && list.size() > 0){
					propNoVO = list.get(0);
				}			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return propNoVO;
		}	 	 

		 
		/**
		 * TAA 계약 상의 Commodity를 조회한다.(ESM_BKG_1078)
		 * 
		 * @author		KimByungKyu
		 * @param 		PropNoVO propNoVO
		 * @param 		String cmdtNm
		 * @param 		String cmdtCd
		 * @return 		List<TaaCmdtListVO>
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<TaaCmdtListVO> searchCmdtByTaa(PropNoVO propNoVO, String cmdtNm, String cmdtCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<TaaCmdtListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(propNoVO != null){
					Map<String, String> mapVO = propNoVO .getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}		
				param.put("cmdt_nm", cmdtNm);
				param.put("cmdt_cd", cmdtCd);
				velParam.put("cmdt_nm", cmdtNm);
				velParam.put("cmdt_cd", cmdtCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCmdtByTaaRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TaaCmdtListVO.class);	
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}	
	 
		/**
		 * S/C로 Prop No를 조회한다.(ESM_BKG_0657)
		 * 
		 * @author		KimByungKyu
		 * @param 		ScListInputVO scListInputVO
		 * @return 		PropNoVO
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public PropNoVO searchPropNoBySc(ScListInputVO scListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PropNoVO> list = null;
			PropNoVO propNoVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(scListInputVO != null){
					Map<String, String> mapVO = scListInputVO .getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}					
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchPropNoByScRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PropNoVO.class);	
				if(list != null && list.size() > 0){
					propNoVO = list.get(0);
				}			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return propNoVO;
		}	 
		 
	/**
	 * S/C 계약 상의 Commodity를 조회한다.(ESM_BKG_0657)
	 * 
	 * @author		KimByungKyu
	 * @param 		PropNoVO propNoVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @param		String svcScpCd
	 * @return 		List<ScCmdtListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScCmdtListVO> searchCmdtBySc(PropNoVO propNoVO, String cmdtNm, String cmdtCd, String svcScpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(propNoVO != null){
				Map<String, String> mapVO = propNoVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			param.put("cmdt_nm", cmdtNm);
			param.put("cmdt_cd", cmdtCd);
			param.put("svc_scp_cd", svcScpCd);
			velParam.put("cmdt_nm", cmdtNm);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("svc_scp_cd", svcScpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCmdtByScRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScCmdtListVO.class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Booking History : Header 정보조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return BkgInforForHistVO
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgInforForHistVO searchBkgInfoForHist(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInforForHistVO> list = null;
		BkgInforForHistVO bkgInforForHistVO = new BkgInforForHistVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgInforForHistVO.class);

			if (list != null && list.size() > 0) {
				bkgInforForHistVO = (BkgInforForHistVO)list.get(0);
			}
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgInforForHistVO;
	}

	/**
	 * Booking History : Item 콤보조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<HistUiNmVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HistUiNmVO> searchHistUiNm(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<HistUiNmVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchHistUiNmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistUiNmVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Booking History : B/L Data 목록조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<BlHistVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BlHistVO> searchBlHist(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlHistVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBlHistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlHistVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Booking History : FAX/EDI 목록조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<NoticeHistVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<NoticeHistVO> searchNoticeHist(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NoticeHistVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchNoticeHistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NoticeHistVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Booking History : Customs 목록조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<CustomsHistVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomsHistVO> searchCustomsHist(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomsHistVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCustomsHistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomsHistVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	 
	/**
	 * Booking History : Documnents 목록조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<DocHistVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DocHistVO> searchDocHist(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DocHistVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchDocHistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocHistVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * 해당 booking의 roll over 정보를 조회
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RollOvrVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RollOvrVO> searchRollOvr(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RollOvrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchRollOvrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RollOvrVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	} 

	/**
	 * Empty Booking 정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		RepoBkgVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public RepoBkgVO searchEmptyBooking(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoBkgVO> list = null;
		RepoBkgVO repoBkgVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEmptyBookingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoBkgVO.class);

			if (list != null && list.size() > 0) {
				repoBkgVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return repoBkgVO;
	}	

	/**
	 * Empty Booking의 Container 정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RepoCntrVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RepoCntrVO> searchEmptyCntr(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEmptyCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Empty Booking의 Container 정보가 없을시 Quantity정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<BkgQuantityVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchEmptyQty(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEmptyQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
		 
	/**
	 * VL container List 를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @return 		List<RepoCntrVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RepoCntrVO> searchVLCntr(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchVLCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Stowage Plan List 를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @return 		RepoCntrVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RepoCntrVO> searchStwgPlan(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchStwgPlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Container List 를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @return 		List<RepoCntrVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RepoCntrVO> searchCntrTpszCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCntrTpszCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		 	 

	/**
	 * Container Digit,TpSz,Stauts Cd를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String cntrNo
	 * @return 		CntrChkDigitVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CntrChkDigitVO searchCntrChkDigit(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrChkDigitVO> list = null;
		CntrChkDigitVO cntrChkDigitVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCntrChkDigitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrChkDigitVO.class);

			if (list != null && list.size() > 0) {
				cntrChkDigitVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntrChkDigitVO;
	}			 
		 
	/**
	 * Customer POD_ETA정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301PodEta(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String podEta = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301PodEtaRSQL(), param, velParam);
			while (dbRowset.next()) {
				podEta = dbRowset.getString("POD_ETA");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return podEta;
	}

	/**
	 * Customer DEL_ETA정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301DelEta(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String delEta = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301DelEtaRSQL(), param, velParam);
			while (dbRowset.next()) {
				delEta = dbRowset.getString("DEL_ETA");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return delEta;
	}

	/**
	 * Customer CCT정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301Cct(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cct = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301CctRSQL(), param, velParam);
			while (dbRowset.next()) {
				cct = dbRowset.getString("CCT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cct;
	}

	/**
	 * BL Main 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String groupId
	 * @param String refCode 
	 * @param String rcvId 
	 * @return EdiFlatFileVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public EdiFlatFileVO searchCust301BlMain(BkgBlNoVO bkgBlNoVO, String groupId, String refCode, String rcvId) throws DAOException {
		DBRowSet dbRowset = null;
		EdiFlatFileVO ediFlatFileVO = null;
		List<EdiFlatFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("group_id", groupId);
				param.put("ref_code", refCode);
				param.put("rcv_id", rcvId);
				velParam.put("group_id", groupId);
				velParam.put("ref_code", refCode);
				velParam.put("rcv_id", rcvId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301BlMainRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiFlatFileVO.class);

			if (list != null && list.size() > 0) {
				ediFlatFileVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ediFlatFileVO;
	}

	/**
	 * Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdi301CntrInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301CntrInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("CNTR_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Terminal에 전송할 Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301CntrInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("CNTR_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container Reefer정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchEdi301CntrRfInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301CntrRfInfoRSQL(), param, velParam);
			if(dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CNTR_RF_INFO"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Terminal에 전송할 Container Reefer정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301CntrRfInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301CntrRfInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("CNTR_RF_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container Reefer정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchEdi301CntrAwkInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301CntrAwkInfoRSQL(), param, velParam);
			if ( dbRowset != null )
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CNTR_AWK_INFO"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Terminal에 전송할 Container Awk정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301CntrAwkInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301CntrAwkInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("CNTR_AWK_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container Danger정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchEdi301CntrDgInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301CntrDgInfoRSQL(), param, velParam);
			if( dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CNTR_DG_INFO"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Terminal에 전송할 Container Danger정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param Tmnl301DgInfoVO tmnl301DgInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301CntrDgInfo(Tmnl301DgInfoVO tmnl301DgInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tmnl301DgInfoVO != null){
				Map<String, String> mapVO = tmnl301DgInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301CntrDgInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("CNTR_DG_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container TRO(General)정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301TroGeneralInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301TroGeneralInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("TRO_GEN_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Container TRO(Eur)정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301TroEurInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301TroEurInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("TRO_EUR_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Container TRO(Eur)정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdi301DgInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("DG_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}
	
	/**
	 * Terminal에 전송할 TRO Main정보를 조회한다.(ESM_BKG_0702B)<br>
	 * Receive ID : KTNETPCS 일때
	 * EDI flat_file전송용 데이터
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<TroMstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TroMstVO> searchTroInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroMstVO> list = null;
		
//		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTroInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroMstVO.class);
//			while (dbRowset.next()) {
//				rtnStr.append(dbRowset.getString("TRO_MAIN_INFO"));
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Terminal에 전송할 TRO Main정보를 조회한다.(ESM_BKG_0702B)<br>
	 * Receive ID : KTNETPCS 일때
	 * EDI flat_file전송용 데이터
	 *
	 * @param TroMstVO troMstVO
	 * @return List<Tmnl301TroMainInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Tmnl301TroMainInfoVO> searchTmnl301TroMainInfo(TroMstVO troMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Tmnl301TroMainInfoVO> list = null;
		
//		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(troMstVO != null){
				Map<String, String> mapVO = troMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301TroMainInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Tmnl301TroMainInfoVO.class);
//			while (dbRowset.next()) {
//				rtnStr.append(dbRowset.getString("TRO_MAIN_INFO"));
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Terminal에 전송할 TRO Detail정보를 조회한다.(ESM_BKG_0702B)<br>
	 * Receive ID : KTNETPCS 일때
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param Tmnl301TroMainInfoVO tmnl301TroMainInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301TroDtlInfo(Tmnl301TroMainInfoVO tmnl301TroMainInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tmnl301TroMainInfoVO != null){
				Map<String, String> mapVO = tmnl301TroMainInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301TroDtlInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("TRO_DTL_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Terminal에 전송할 Container Danger 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return 	List<Tmnl301DgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Tmnl301DgInfoVO> searchTmnl301DgInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Tmnl301DgInfoVO> list = null;
		
//		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301DgInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Tmnl301DgInfoVO.class);
//			while (dbRowset.next()) {
//				rtnStr.append(dbRowset.getString("DG_INFO"));
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Container BL Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchEdi301BlCntr(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301BlCntrRSQL(), param, velParam);
			if(dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("BL_CNTR"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Terminal에 전송할 BL Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param List<BkgQuantityVO> oldQtyVOs
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301BlCntr(BkgBlNoVO bkgBlNoVO, List<BkgQuantityVO> oldQtyVOs) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				// vel_param 1 : typeCd List
				ArrayList<String> typeCdList = new ArrayList<String>();
				// vel_param 2 : cnt List
				ArrayList<String> cntList = new ArrayList<String>();
				
				if(oldQtyVOs != null) {
					for(int i=0; i<oldQtyVOs.size(); i++){
						typeCdList.add(((BkgQuantityVO)oldQtyVOs.get(i)).getCntrTpszCd());
						cntList.add(((BkgQuantityVO)oldQtyVOs.get(i)).getOpCntrQty());
					}
				}
				
				velParam.put("typeCd_list", typeCdList);
				velParam.put("cnt_list", cntList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlCntrRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("BL_CNTR"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container BL Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchEdi301BlVvd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301BlVvdRSQL(), param, velParam);
			
			if(dbRowset != null) {
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("BL_VVD"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Terminal에 전송할 BL VVD 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Tmnl301BlVvdVO> searchTmnl301BlVvd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Tmnl301BlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Tmnl301BlVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Container BL PO정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdi301BlPoInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rtnStr = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301BlPoInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("PO_INFO"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr.toString();
	}

	/**
	 * Container BL DESC정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301BlDesc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301BlDescRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("BL_DESC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Container CM DESC정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301BkgCm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("CM_MARK_DESC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Container CM DESC정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return XterRqstNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstNoVO searchXterRqstNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchXterRqstNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO.class);

			if (list != null && list.size() > 0) {
				xterRqstNoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstNoVO;
	}

	/**
	 * Container BKG Info정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301XterInfo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301XterInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("I_BKG_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Container BKG Customer정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchCust301XterCust(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301XterCustRSQL(), param, velParam);
			if(dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("I_BKG_CUST"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStrList;
	}

	/**
	 * Container BKG CM Desc정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301XterCm(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301XterCmRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("I_CM_MARK_DESC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}

	/**
	 * Empty Booking의 T/S Route정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<MtyBkgTsRouteVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBkgTsRouteVO> searchEmptyBkgTsRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBkgTsRouteVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEmptyBkgTsRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBkgTsRouteVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		 
	 

	/**
	 * Yard에 Empty Status로 존재하는 Container List를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @param  		String cntrTpsz
	 * @return 		List<RepoCntrVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RepoCntrVO> searchCntrByYard(String vvd, String ydCd, String cntrTpsz) throws DAOException {
		DBRowSet dbRowset = null;
		List<RepoCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("cntr_tpsz_cd", cntrTpsz);
			velParam.put("cntr_tpsz_cd", cntrTpsz);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCntrByYardRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		 

	/**
	 * VVD의 Lane 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @return 	BkgVvdVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgVvdVO searchTmnl301LanePol(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		BkgVvdVO bkgVvdVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301LanePolRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);

			if (list != null && list.size() > 0) {
				bkgVvdVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgVvdVO;
	}

	/**
	 * BKG_CONFIRM 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param  	String bkgLane
	 * @param  	String polCd
	 * @param   String autoManualFlg
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForBkgCfm(BkgBlNoVO bkgBlNoVO, String bkgLane, String polCd, String autoManualFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("slan_cd", bkgLane);
				param.put("pol_cd", polCd);
				param.put("auto_mnl_flg", autoManualFlg);
				velParam.put("auto_mnl_flg", autoManualFlg);
				velParam.put("slan_cd", bkgLane);
				velParam.put("pol_cd", polCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301RcvIdForBkgCfmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EMPTY_RELEASE 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param  	String bkgLane
	 * @param  	String polCd
	 * @param   String autoManualFlg
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForMtyRel(BkgBlNoVO bkgBlNoVO, String bkgLane, String polCd, String autoManualFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("slan_cd", bkgLane);
				param.put("pol_cd", polCd);
				param.put("auto_mnl_flg", autoManualFlg);
				velParam.put("auto_mnl_flg", autoManualFlg);
				velParam.put("slan_cd", bkgLane);
				velParam.put("pol_cd", polCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301RcvIdForMtyRelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FULL_RELEASE 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param  	String bkgLane
	 * @param  	String polCd
	 * @param   String autoManualFlg
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForFullRel(BkgBlNoVO bkgBlNoVO, String bkgLane, String polCd, String autoManualFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("slan_cd", bkgLane);
				param.put("pol_cd", polCd);
				param.put("auto_mnl_flg", autoManualFlg);
				velParam.put("auto_mnl_flg", autoManualFlg);
				velParam.put("slan_cd", bkgLane);
				velParam.put("pol_cd", polCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301RcvIdForFullRelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * DEFAULT 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param  	String bkgLane
	 * @param  	String polCd
	 * @param   String autoManualFlg
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForDefault(BkgBlNoVO bkgBlNoVO, String bkgLane, String polCd, String autoManualFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("slan_cd", bkgLane);
				param.put("pol_cd", polCd);
				param.put("auto_mnl_flg", autoManualFlg);
				velParam.put("auto_mnl_flg", autoManualFlg);
				velParam.put("slan_cd", bkgLane);
				velParam.put("pol_cd", polCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301RcvIdForDefaultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Customer POD_ETA정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param  	String rcvId
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301Brac(BkgBlNoVO bkgBlNoVO, String rcvId) throws DAOException {
		DBRowSet dbRowset = null;
		String bracCtnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("rcv_id", rcvId);
				velParam.put("rcv_id", rcvId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BracRSQL(), param, velParam);
			while (dbRowset.next()) {
				bracCtnt = dbRowset.getString("BRAC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bracCtnt;
	}

	/**
	 * Customer POD_ETA정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgPor(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String porCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchBkgPorRSQL(), param, velParam);
			while (dbRowset.next()) {
				porCd = dbRowset.getString("POR_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return porCd;
	}

	/**
	 * BL Main1 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param Vender301ParamVO vender301ParamVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301BlMain1(Vender301ParamVO vender301ParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnMsg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		Map<String, String> mapVO2 = null;
		
		BkgBlNoVO bkgBlNoVO = vender301ParamVO.getBkgBlNoVO();
		BkgVvdVO oldVvdVO = vender301ParamVO.getOldVvdVO();
			
		try{
			if(bkgBlNoVO != null){
				mapVO = bkgBlNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(oldVvdVO != null){
				mapVO2 = oldVvdVO .getColumnValues();
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}



				param.put("brac", vender301ParamVO.getBracCd());
				param.put("ns_brac", vender301ParamVO.getNsBracCd());
				param.put("cct", vender301ParamVO.getCct());
				param.put("ec_edircv_id", vender301ParamVO.getRcvId());
				param.put("brac_cd", vender301ParamVO.getBracCdNew());
				param.put("edi_old_rel", vender301ParamVO.getOldMtyPkupYdCd());
				velParam.put("brac", vender301ParamVO.getBracCd());
				velParam.put("cct", vender301ParamVO.getCct());
				velParam.put("ec_edircv_id", vender301ParamVO.getRcvId());
				velParam.put("brac_cd", vender301ParamVO.getBracCdNew());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString("BL_MAIN1");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnMsg;
	}

	/**
	 * BL Main2 정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvId
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301BlMain2(BkgBlNoVO bkgBlNoVO, String rcvId) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnMsg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				
				param.put("rcv_id", rcvId);
				velParam.put("rcv_id", rcvId);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString("BL_MAIN2");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnMsg;
	}

	/**
	 * Fax/Email 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ofcCd
	 * @return List<SendBkgFaxEmailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendBkgFaxEmailVO> searchFaxEmailForNotice(BkgBlNoVO bkgBlNoVO, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendBkgFaxEmailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				param.put("ofc_cd", ofcCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchFaxEmailForNoticeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendBkgFaxEmailVO .class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * EDI 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SendBkgEdiVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendBkgEdiVO> searchEdiForNotice(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendBkgEdiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdiForNoticeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendBkgEdiVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	 }

	/**
	 * Bkg Receipt Type을 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgReceiptType(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String receiptTypeCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usrId != null){
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchBkgReceiptTypeRSQL(), param, velParam);
			while (dbRowset.next()) {
				receiptTypeCd = dbRowset.getString("RECEIPT_TYPE_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return receiptTypeCd;
	}
	
	/**
	 * Booking 테이블에서 bkg_no,mty_pkup_yd_cd,full_rtn_yd_cd,qty_vol를 조회
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgInfoForYardAssignVO
	 * @exception DAOException
	 */
	 public BkgInfoForYardAssignVO searchBkgInfoForYardAssign(BkgBlNoVO bkgBlNoVO) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter 
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			BkgInfoForYardAssignVO bkgInfoForYardAssignVO =new BkgInfoForYardAssignVO();

			try{
				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchBkgInfoForYardAssignRSQL(), param, velParam);
				while (dbRowset.next()) {
					bkgInfoForYardAssignVO.setBkgNo(dbRowset.getString("bkg_no"));
					bkgInfoForYardAssignVO.setMtyPkupYdCd(dbRowset.getString("mty_pkup_yd_cd"));
					bkgInfoForYardAssignVO.setFullRtnYdCd(dbRowset.getString("full_rtn_yd_cd"));
					bkgInfoForYardAssignVO.setQtyVol(dbRowset.getString("qty_vol"));
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return bkgInfoForYardAssignVO;
		} 
	 
	 
	 
	/**
	 * edi 전송시 type/size별 yard 구분을 위해 기초 정보를 조회
	 *  
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<QtyInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<QtyInfoVO> searchQtyInfoForYardAssign(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<QtyInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchQtyInfoForYardAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, QtyInfoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	 } 
	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @return RouteDtlInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public RouteDtlInfoVO searchRouteDtlInfoList(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        RouteDtlInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingSearchDBDAORouteDtlInfoVORSQL template = new GeneralBookingSearchDBDAORouteDtlInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<RouteDtlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, RouteDtlInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }else{
            	rsVO = new RouteDtlInfoVO();
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }
	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgAwkCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RouteDtlVvdVO> searchRouteDtlVvdList(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<RouteDtlVvdVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingSearchDBDAORouteDtlVvdVORSQL template = new GeneralBookingSearchDBDAORouteDtlVvdVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RouteDtlVvdVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * Booking Creation tab중 어떤 Tab을 보여줘야 하는지 조회한다.(ESM_BKG_0079)<br>
	 *
	 * @author Lee NamKyung
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgCreTabByUser(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put   ("ofc_cd", account.getOfc_cd());
			param.put   ("usr_id", account.getUsr_id());
			velParam.put("ofc_cd", account.getOfc_cd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL(), param, velParam);
			while (dbRowset.next()) {
				strReturn = dbRowset.getString("trotab");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return strReturn;
	}

	/**
	 * special cargo 재 request를 위한 bkg data를 조회한다<br>
	 *
	 * @author		Ryu Daeyoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String rqstType 
	 * @return 		List<ScgAproRqstVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScgAproRqstVO> searchBkgForSpclRqst(BkgBlNoVO bkgBlNoVO, String rqstType) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAproRqstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				
				param.putAll(mapVO);
				param.put("rqst_type", rqstType);//추후 필요할 수 있어서 유지함
				velParam.putAll(mapVO);
				velParam.put("rqst_type", rqstType);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgForSpclRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAproRqstVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Container Loading List(Korea) 관련 터미널 Vessel Code를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String polYdCd
	 * @param String podCd
	 * @param String podYdCd
	 * @return String oldVvd
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchTmnl301OldVvd(String vslCd, String skdVoyNo, String skdDirCd, String polCd, String polYdCd, String podCd, String podYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String oldVvd = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("pol_cd", polCd);
			param.put("pol_yd_cd", polYdCd);
			param.put("pod_cd", podCd);
			param.put("pod_yd_cd", podYdCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralBookingSearchDBDAOsearchTmnl301OldVvdRSQL(),
					param, null, true);
			if (dbRowset.next()) {
				oldVvd = dbRowset.getString(1);
			} else {
				oldVvd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return oldVvd;
	}

	/**
	 * spcl cargo 재 request를 위한 spcl cargo seq들을 조회한다..<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SpclReqInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpclReqInVO> searchSpclReqInVO(BkgBlNoVO bkgBlNoVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclReqInVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchSpclReqInVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclReqInVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BKG_CONFIRM 자동 전송시 별도로 rcv_id를 조회한다.조회한다.(ESM_BKG_0079, ESM_BKG_0229)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author  Ryu Daeyoung
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param   String bracCd
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForAutoSend(BkgBlNoVO bkgBlNoVO, String bracCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("brac", bracCd);
				velParam.put("brac", bracCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchTmnl301RcvIdForAutoSendRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 bkg이 edi block 상태인지 조회한다.
	 *
	 * @author  Ryu Daeyoung
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @exception 	DAOException
	 */
	public String searchAutoEdiBlockFlg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAutoEdiBlockFlgRSQL(), param, velParam);
			while (dbRowset.next()) {
				strReturn = dbRowset.getString("EDI_HLD_FLG");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return strReturn;
	}

	/**
	 * BKG_CONFIRM 자동 전송시 별도로 rcv_id를 조회한다.조회한다.(ESM_BKG_0079, ESM_BKG_0229)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author  Ryu Daeyoung
	 * @param  	BkgBlNoVO bkgBlNoVO
	 * @param   String bracCd
	 * @return 	List<TmnlRcvIdVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TmnlRcvIdVO> searchTmnl301RcvIdForManualSend(BkgBlNoVO bkgBlNoVO, String bracCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlRcvIdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("brac", bracCd);
				velParam.put("brac", bracCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchTmnl301RcvIdForManualSendRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * bkgNo로 Sale Rep의 계정의 IAM 메일 주소를 조회한다.(ESM_BKG_0079)<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSlsRepUsrEmlByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String usrEml = null;
		Map<String, Object> param = null;
		Map<String, Object> velParam = null;
		try {
			if (null!=bkgNo) {
				param = new HashMap<String, Object>();
				velParam = new HashMap<String, Object>();
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchSlsRepUsrEmlByBkgNoRSQL(), param, velParam);
				if (dbRowset.next()) {
					usrEml = dbRowset.getString("USR_EML");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usrEml;
	}

	/**
	 * ESM_BKG_0079_01 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgChgOfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChgOfcVO> searchBkgChgOfc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = null;
		List<BkgChgOfcVO> list = null;
		try {
			if (null!=bkgBlNoVO) {
				param = new HashMap<String, Object>();
				param.put("in_bkg_no", bkgBlNoVO.getBkgNo());
				param.put("in_ca_flg", bkgBlNoVO.getCaFlg());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchBkgChgOfcRSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgChgOfcVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전 체크
	 * @param BkgBlNoVO vo
	 * @return String
	 * @throws DAOException
	 */
	public String checkIbByCaIssue(BkgBlNoVO vo)  throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = null;
		String returnVal = "N";
		try {
			if (null!= vo) {
				param = new HashMap<String, Object>();
				param.put("bkg_no", vo.getBkgNo());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOcheckIbByCaIssueRSQL(), param, null);
				if (dbRowset.next()) {
					returnVal = dbRowset.getString("INBOUNTNOTI");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return returnVal;
	}
	
	/**
	 * 동일 BKG No 채번 방지용 duplication check.(ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		
	 * @param 		String bkgNo
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchXterBkg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchXterBkgRSQL(), param, velParam);
			if(dbRowset.next()){
				if("Y".equals(dbRowset.getString("DUP_FLG"))){
					isOk = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}
	
	/**
	 * @param OfcRepInputVO ofcRepInputVO
	 * @return List<OfcRepListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfcRepListVO> searchCtrtRep(OfcRepInputVO ofcRepInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfcRepListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcRepInputVO != null){
				Map<String, String> mapVO = ofcRepInputVO.getColumnValues();
				param.putAll(mapVO);
//				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCtrtRepRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcRepListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Customer Advisory 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return List<BkgCustAvcNtcSndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCustAvcNtcSndVO> searchCustAdvisoryNoticeSendList(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcNtcSndVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try {
			if (null!=bkgCustAvcNtcSchVO) {

            	if (!JSPUtil.getNull(bkgCustAvcNtcSchVO.getBkgNo()).equals("")) {
            		bkgCustAvcNtcSchVO.setBkgNo("'" + bkgCustAvcNtcSchVO.getBkgNo().replaceAll(",", "','") + "'");
				}
            	
            	if (!JSPUtil.getNull(bkgCustAvcNtcSchVO.getCntrNo()).equals("")) {
            		bkgCustAvcNtcSchVO.setCntrNo("'" + bkgCustAvcNtcSchVO.getCntrNo().replaceAll(",", "','") + "'");
				}
            	
				Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcNtcSndVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Customer Advisory Cntr Count를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustAdvisoryNoticeCntrCnt(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cntrCnt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try {
			if (null!=bkgCustAvcNtcSchVO) {
				
				Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeCntrCntRSQL(), param, velParam);
				if(dbRowset.next()){
					cntrCnt = dbRowset.getString("CNTR_CNT");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cntrCnt;
	}

	/**
	 *  기존에 등록된 Customer Advisory Notice Container 정보를 삭제
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @throws DAOException
	 */
	public void removeCustAdvisoryNoticeCntrByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
        	
        	retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeCntrByUploadDSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 *  기존에 등록된 Customer Advisory Notice Detail 정보를 삭제
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @throws DAOException
	 */
	public void removeCustAdvisoryNoticeDetailByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeDetailByUploadDSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 *  기존에 등록된 Customer Advisory Notice 정보를 삭제
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @throws DAOException
	 */
	public void removeCustAdvisoryNoticeByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeByUploadDSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Excel Upload 된 대상을 기준으로 Customer Advisory Notice Container 정보를 Insert<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param BkgCustAvcNtcUploadVO bkgCustAvcNtcUploadVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeCntrByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, BkgCustAvcNtcUploadVO bkgCustAvcNtcUploadVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcUploadVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("vvd", bkgCustAvcNtcSchVO.getVvd());
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			velParam.put("dir_sts_cd", bkgCustAvcNtcSchVO.getDirStsCd());
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByUploadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

	/**
	 * Excel Upload 된 대상을 기준으로 Customer Advisory Notice 정보를 Insert<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());

            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeByUploadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Excel Upload 된 대상을 기준으로 Customer Advisory Notice Detail 정보를 Insert<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeDetailByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByUploadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Customer Advisory Detail 정보를 변경한다.<br>
	 * 
	 * @param BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageCustAdvisoryNoticeList(BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcDtlVO.getColumnValues();
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOmanageCustAdvisoryNoticeListUSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * ESM_BKG_0004: init<br>
	 * Customer Advisory Notice Remark 정보를 조회한다.<br>
	 *
	 * @param BkgCustAvcNtcRmkVO inputVO
	 * @return List<BkgCustAvcNtcRmkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCustAvcNtcRmkVO> searchCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcNtcRmkVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (null!=inputVO) {
				
				Map<String, String> mapVO = inputVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeRemarkRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcNtcRmkVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	

	/**
	 * ESM_BKG_0004: save<br>
	 * Customer Advisory Notice Remark 정보를 수정한다.
	 *  
	 * @param BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void mergeCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
				Map<String, String> mapVO = bkgCustAvcNtcRmkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getCre_usr_id());
				param.put("upd_usr_id", account.getUpd_usr_id());

				
				retInt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL(), param, velParam);
				
				if(retInt == 0) {
					retInt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL(), param, velParam);
				}
				if(retInt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
				if("select".equals(bkgCustAvcNtcRmkVO.getBtnType())
					&& (null != bkgCustAvcNtcRmkVO.getPreEmlSubjCtntSeq() 
					&& !"".equalsIgnoreCase(bkgCustAvcNtcRmkVO.getPreEmlSubjCtntSeq()))){
					
					param.put("eml_subj_ctnt_seq", bkgCustAvcNtcRmkVO.getPreEmlSubjCtntSeq());
					param.put("rmk_use_flg", "N");
					
					retInt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingSearchDBDAOupdateCustAdvisoryNoticeRemarkUSQL(), param, velParam);

					if(retInt == 0) {
						retInt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingSearchDBDAOinsertCustAdvisoryNoticeRemarkCSQL(), param, velParam);
					}
					
					if(retInt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}

	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: init<br>
	 * Customer Advisory Notice 정보를 조회한다.<br>
	 *
	 * @param BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO
	 * @return BkgCustAvcNtcSndCtntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCustAvcNtcSndCtntVO searchCustAdvisoryNoticeSendCtnt(BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcNtcSndCtntVO> list = null;
		BkgCustAvcNtcSndCtntVO retVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = bkgCustAvcNtcSndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL(), param, velParam);

				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcNtcSndCtntVO.class);
				if(list != null && list.size() > 0){
					retVO = list.get(0);
				}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return retVO;
	}
	
	/**
	 * 메일 전송 후, 보낸 이력 정보를 갱신한다.
	 *  
	 * @param BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeHistory(BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeHistoryCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	* Fax 전송 후 Advisory Notice Detail의 연락처 정보를 갱신한다. 
	 * 
	 * @param BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyCustAdvisoryNoticeDetailByFax(BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("snd_ofc_cd", account.getOfc_cd());
			param.put("fax_snd_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOmodifyCustAdvisoryNoticeDetailByFaxUSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	* 메일 전송 후 Advisory Notice Detail의 연락처 정보를 갱신한다. 
	 * 
	 * @param BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyCustAdvisoryNoticeDetailByMail(BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = bkgCustAvcNtcDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("snd_ofc_cd", account.getOfc_cd());
			param.put("eml_snd_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOmodifyCustAdvisoryNoticeDetailByMailUSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Emergemcy Case 가 발생 한 대상 B/L 별로 Fax&Mail 송신 후 전송 Flag 정보를 업데이트 한다.<br>
	 * 
	 * @param bkgCustAvcNtcSndVO
	 * @param account
	 * @throws DAOException
	 */
	public void modifyCustAdvisoryNoticeBySend(BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if (null!=bkgCustAvcNtcSndVO) {
				
				Map<String, String> mapVO = bkgCustAvcNtcSndVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
	            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOmodifyCustAdvisoryNoticeBySendUSQL(), param, velParam);
				if(retInt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
        	}

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Customer Advisory History정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO
	 * @return List<BkgCustAvcNtcSndHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCustAvcNtcSndHisVO> searchCustAdvisoryNoticeSendHistory(BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcNtcSndHisVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try {
			if (null!=bkgCustAvcNtcSndHisSchVO) {
				
				Map<String, String> mapVO = bkgCustAvcNtcSndHisSchVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcNtcSndHisVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * TRO Fax/Email 발송 History를 조회한다.
	 * 
	 * @param bkgBlNoVO
	 * @param ioBndCd
	 * @return List<SendBkgFaxEmailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SendBkgFaxEmailVO> searchEurTroNotice(BkgBlNoVO bkgBlNoVO,String ioBndCd) throws DAOException{
		DBRowSet dbRowset = null;
		List<SendBkgFaxEmailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("io_bnd_cd", ioBndCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEurTroNoticeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendBkgFaxEmailVO .class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Bkg Quantity 정보를 조회한다.
	 * 
	 * @param bkgNo
	 * @return List<BkgQuantityVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchTmnl301BkgQuantity(String bkgNo) throws DAOException{
		List<BkgQuantityVO> list = null;
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BkgQuantityRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * searchSimpleSiBkgInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchSimpleSiBkgInfoList(String bkgNo) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		String mapStr = "";
		
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			
			dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchSimpleSiBkgInfoListRSQL(), param, velParam);
			if(dbRowset1.next()){
				mapStr = dbRowset1.getString("MAP_STR");
			}
			
			param.put("map_str", mapStr);
			dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchSimpleSiBkgMapListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset2, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * searchSimpleSiCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchSimpleSiCntrInfoList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchSimpleSiCntrInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * searchSimpleSiHblCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchSimpleSiHblCntrInfoList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchSimpleSiHblCntrInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * ESM_BKG_0003: BST Download<br>
	 * BST Download에 대한 Customer Advisory Notice 정보를 조회한다.<br>
	 *
	/**
	 * @param bkgCustAvcNtcSchVO
	 * @return
	 * @throws DAOException
	 */
	public int searchCustAdvisoryNoticeCntByBSTUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws DAOException {
		DBRowSet dbRowset = null;
		int retVal = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeCntByBSTDownloadRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				retVal = Integer.parseInt(dbRowset.getString("CNT"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return retVal;
	}
	
	/**
	 * BST Download 된 대상을 기준으로 Customer Advisory Notice 정보를 Insert<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeCntrByBSTDownload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByBSTDownloadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BST Downlaod 된 대상을 기준으로 Customer Advisory Notice Container 정보를 Insert<br>
	 *  
	 * @param bkgCustAvcNtcSchVO
	 * @param account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeBLByBSTDownload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			param.put("vvd", bkgCustAvcNtcSchVO.getVvd());
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			velParam.put("dir_sts_cd", bkgCustAvcNtcSchVO.getDirStsCd());
			
			retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeBLByBSTDownloadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BST Download 된 대상을 기준으로 Customer Advisory Notice Detail 정보를 Insert<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustAdvisoryNoticeDetailByBSTDownload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = bkgCustAvcNtcSchVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingSearchDBDAOaddCustAdvisoryNoticeDetailByBSTDownloadCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Portal EDI를 위한 수신 EDI ID를 조회함
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<CustTpIdVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustTpIdVO> searchEdiPortalTpId(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustTpIdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralBookingSearchDBDAOsearchEdiPortalTpIdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustTpIdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * ESM_BKG_0003: init<br>
	 * Customer Advisory Notice 정보를 조회한다.<br>
	 *
	 * @param BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO
	 * @param String blNo
	 * @return BkgCustAvcNtcSndCtntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCustAvcNtcSndCtntVO searchCustAdvisoryNoticeSendCtntbyDupBlNo(BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcNtcSndCtntVO> list = null;
		BkgCustAvcNtcSndCtntVO retVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			//Map<String, String> mapVO = bkgCustAvcNtcSndVO.getColumnValues();

			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", bkgCustAvcNtcSndVO.getVvd());
			velParam.put("vvd", bkgCustAvcNtcSndVO.getVvd());
			param.put("ofc_cd", bkgCustAvcNtcSndVO.getOfcCd());
			velParam.put("ofc_cd", bkgCustAvcNtcSndVO.getOfcCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendCtntRSQL(), param, velParam);

				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcNtcSndCtntVO.class);
				
				if(list != null && list.size() > 0){
					retVO = list.get(0);
				}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return retVO;
	}
	
	 /**
     * CustomerA의 모든 목록을 가져온다.<br>
	 * @param SearchCustomerInqryCondVO searchCustomerInqryCondVO
	 * @param int iPage
	 * @param String custCd
	 * @param String cust
	 * @return List<SearchCustomerInqryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchCustomerInqryVO> searchCustomerList(SearchCustomerInqryCondVO searchCustomerInqryCondVO, int iPage, String custCd, String cust ) throws DAOException {
    	List<SearchCustomerInqryVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         
        // 페이징 처리
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
//		param.put("include", include);
//		velParam.put("include", include);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart);
		log.debug("endPart: " + endPart);
		
		try {
//			if(!custCd.equals("") || !cust.equals("")) {
//	        	param.put("cust_cnt_cd", custCd + cust);
//	        	velParam.put("cust_cnt_cd", custCd + cust);
//			}
//			if(!custNm.equals("")) {
//				param.put("cust_lgl_eng_nm", custNm);
//	        	velParam.put("cust_lgl_eng_nm", custNm);
//			}		
//			if(!ofcCd.equals("")) {
//				param.put("ofc_cd", ofcCd);
//	        	velParam.put("ofc_cd", ofcCd);
//			}
			if(!cust.equals("")){
				for (int i = cust.length(); i < 6; i++) {
//					cust = "0" + cust;
					StringBuffer cust1 = new StringBuffer("");
					cust1.append("0");
					cust1.append(cust);
					cust = cust1.toString();
				}
			}
			if(!custCd.equals("") || !cust.equals("")) {
	        	param.put("cust_cnt_cd", custCd + cust);
	        	velParam.put("cust_cnt_cd", custCd + cust);
			}
			
			if (searchCustomerInqryCondVO != null) {
				Map<String, String> mapVO = searchCustomerInqryCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchTotalCustomerRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerInqryVO.class);
			if(list.size()>0){
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }


    /**
	 * Booking Vessel Revised Notice 전송 대상 조회<br>
	 * @param List<BkgBlNoVO> bkgBlNoVOs
	 * @return List<RcvrBkgReviseNoticeVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RcvrBkgReviseNoticeVO> searchRcvrBkgReviseNotice(List<BkgBlNoVO> bkgBlNoVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<RcvrBkgReviseNoticeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
            ArrayList<String> bkgNos = new ArrayList<String>();

            if(bkgBlNoVOs != null && bkgBlNoVOs.size() > 0){
            	for(int i = 0; i < bkgBlNoVOs.size(); i++){
            		bkgNos.add(bkgBlNoVOs.get(i).getBkgNo());
            	}
				param.put("bkgNos", bkgNos);
				velParam.put("bkgNos", bkgNos);
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchRcvrBkgReviseNoticeRSQL(), param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RcvrBkgReviseNoticeVO .class);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	
	/**
	 * searchCustAdvisoryFileList
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<BkgCustAvcFileListVO> searchCustAdvisoryFileList(BkgCustAvcNtcRmkVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustAvcFileListVO> list = null;
		String file_sav_id = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				file_sav_id = vo.getFilePathRmk();
				file_sav_id = "'" + file_sav_id.replace(";", "','") + "'";
				velParam.put("file_path_rmk", file_sav_id);
							
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCustAdvisoryFileListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustAvcFileListVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ALOC_STS_CD 를 조회한다.<br>
	 * @param 		String bkgNo
	 * @return 		AlocStandbyReasonVO
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public AlocStandbyReasonVO searchAlocStsCdByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlocStandbyReasonVO> list = null;
		AlocStandbyReasonVO retVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAlocStsCdByBkgNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlocStandbyReasonVO .class);
			if(list != null && list.size() > 0){
				retVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVO;
	}	
	
	/**
	 * Allocation Stand by Reason 의 Truck VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param 		String bkgNo
	 * @return 		List<AlocStandbyReasonVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTruck(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlocStandbyReasonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAlocStandbyReasonTruckRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlocStandbyReasonVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 

	/**
	 * Allocation Stand by Reason 의 T/S VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param 		String bkgNo
	 * @return 		List<AlocStandbyReasonVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTs(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlocStandbyReasonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAlocStandbyReasonTsRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlocStandbyReasonVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
		 
	/**
	 * Allocation Stand by Reason 의 EQ & Commodity Restriction 을 조회한다.<br>
	 * @param 		String bkgNo
	 * @return 		List<AlocStandbyReasonVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonEq(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlocStandbyReasonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAlocStandbyReasonEqRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlocStandbyReasonVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
			 
			 
	/**
	 * Allocation Stand by Reason 의 Customer Constraint 을 조회한다.<br>
	 * @param 		String bkgNo
	 * @return 		List<AlocStandbyReasonVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonCust(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlocStandbyReasonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchAlocStandbyReasonCustRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlocStandbyReasonVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * SLS_REP_CD 로 AS 인 PRNT_OFC_CD 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 
	 * @param String srep_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchPrntOfcCdBySRepCd(String srep_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(srep_cd != null){
				param.put("srep_cd", srep_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchPrntOfcCdBySRepCdRSQL(), param, null);
			while (dbRowset.next()) {
				result = dbRowset.getString("PRNT_OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	} 
	
	/**
	 * MDM_SLS_REP 의 SREP_EML 을 조회 한다.<br>
	 *
	 * @author 
	 * @param  String srepCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSrepEml(String srepCd) throws DAOException {
		DBRowSet dbRowset = null;
		String bracCtnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(srepCd != null){
				param.put("srep_cd", srepCd);
				velParam.put("srep_cd", srepCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchSrepEmlRSQL(), param, velParam);
			while (dbRowset.next()) {
				bracCtnt = dbRowset.getString("SREP_EML");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bracCtnt;
	}		
	
	/**
	 * e-Booking Upload Notice 메일 수신인을 조회한다.<br>
	 * WEB을 통해 자동생성된 BKG 중 Auto Notification에 체크되어있고  
	 * Standby:F, NoRate:F인 Booking에 대해 Upload(Receipt) Notice를 전송해준다.
	 * @author 
	 * @param  String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchEBkgUploadNoticeEml(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bracCtnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchEBkgUploadNoticeEmlRSQL(), param, velParam);
			while (dbRowset.next()) {
				bracCtnt = dbRowset.getString("CNTC_PSON_EML");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bracCtnt;
	}
	
	/**
	 * rfaSpotPricingAvailable 와 같은 내용이나 파라미터를 달리함 <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return ScListInputVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScListInputVO searchScListInput(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		ScListInputVO scVo = null;
		List<ScListInputVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new GeneralBookingSearchDBDAOSearchScListInputRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScListInputVO.class);
			if (list != null && list.size() > 0) {
				scVo = (ScListInputVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return scVo;
	}	
	
	/**
	 * S/C를 유효성을 조회한다.
	 * 
	 * @author		
	 * @param 		ScListInputVO scListInputVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchScAvailableCust(ScListInputVO scListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "N";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(scListInputVO != null){
				Map<String, String> mapVO = scListInputVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchScAvailableCust2RSQL(), param, velParam);
			while (dbRowset.next()) {
				rslt = dbRowset.getString("RSLT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}	
	
	/**
	 * Customer에게 NoRateNotice 를 보내면 안되는 조건인지 조회한다.
	 * 
	 * @author		
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchNoRateNoticeToCustomerBlock(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "N";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchNoRateNoticeToCustomerBlockRSQL(), param, velParam);
			while (dbRowset.next()) {
				strReturn = dbRowset.getString("NTC_BLCK");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return strReturn;
	}
	
	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws DAOException{
		DBRowSet dbRowset = null;
		List<EstimatedCMPBVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOEstimatedCMPBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimatedCMPBVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	 /**
		 * Booking History : B/L Data 목록조회<br>
		 *
		 * @param  SIWebServiceVO vo
		 * @return List<BlHistVO>
		 * @author Lee NamKyung
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BlHistVO> searchBlHistSi(SIWebServiceVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<BlHistVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBlHistSiRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlHistVO.class);
			}catch(SQLException se){
				//log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return list;
		}
		 
		/**
		 * S/I 이후, Awkward Container Weight와 Container Weight의 차이가 20%이상 나는지 여부를 체크
		 * 
		 * @param String bkgNo
		 * @return String
		 * @throws DAOException
		 */
		public String checkAkwardOverWgtFlg(String bkgNo)  throws DAOException {
			DBRowSet dbRowset = null;
			String awkOverWgtFlg = "N";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(bkgNo != null){
						param.put("bkg_no", bkgNo);
						velParam.put("bkg_no", bkgNo);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOcheckAkwardOverWgtFlgRSQL(), param, velParam);
					while (dbRowset.next()) {
						awkOverWgtFlg = dbRowset.getString("AWK_OVER_WGT_FLG");
					}
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(),se);
				} catch (Exception ex) {
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
				}
			return awkOverWgtFlg;
		}
}
