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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgForCargoClosingVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInfoForYardAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgYardCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
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
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVvdVO;
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
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301DgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCustCntcPsonVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;


/**
 * OPUS GeneralBookingSearchDBDAO <br>
 * - OPUS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimByungKyu
 * @see GeneralBookingSearchBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class GeneralBookingSearchDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3577756954302673790L;

	/**
	 * GeneralBookingSearchDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Transhipment Route and VVD 목록을 조회한다.
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return	 		List<TSRouteVO>
	 * @exception 	DAOException
	 */
	 
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
	 	 * @param 		String locCd
	 	 * @param 		String ofcCd
	 	 * @return 		List<BkgCreCustomerVO>
	 	 * @exception 	DAOException
	 	 */
	 	 
	 	public List<BkgCreCustomerVO> searchBkgCreCustomer(	String custCntCd,
	 																					 	String custSeq,
	 																					 	String custNm,
	 																					 	String locCd,
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
	 			param.put("loc_cd", locCd);
	 			param.put("ofc_cd", ofcCd);

	 			velParam.put("cust_cnt_cd", custCntCd);
	 			velParam.put("cust_seq", custSeq);
	 			velParam.put("cust_lgl_eng_nm", custNm);
	 			velParam.put("loc_cd", locCd);
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
	 	 * Customer Inquiry의 선택된 화주의 S.OPC 목록을 조회한다.
	 	 * 
	 	 * @author 		KimByungKyu 
	 	 * @param 		String custCntCd
	 	 * @param 		String custSeq
	 	 * @return 		List<CustSrepVO>
	 	 * @exception 	DAOException
	 	 */
	 	 
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
		 * @return 		BkgBookingVO
		 * @exception 	DAOException
		 */
		 
		public BkgBookingVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			BkgBookingVO bkgBookingVO = null;
			List<BkgBookingVO> list = null;
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
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO .class);
				if(list != null && list.size() > 0){
					bkgBookingVO = list.get(0);
				}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return bkgBookingVO;
		}
		 
		 /**
		  * Black Stowage Flag retrieve<br>
		  * 
		  * @param 		BkgBookingVO bkgBookingVO
		  * @return 	BkgBookingVO
		  * @exception 	DAOException
		  */
		 
		 public BkgBookingVO searchBlckStwgFlg(BkgBookingVO bkgBookingVO) throws DAOException {
			DBRowSet dbRowset = null;
			BkgBookingVO vo = null;
			List<BkgBookingVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgBookingVO != null){
					Map<String, String> mapVO = bkgBookingVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBlckStwgFlgRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO .class);
				if(list != null && list.size() > 0){
					vo = list.get(0);
				}else{
					vo = new BkgBookingVO();
					vo.setBlckStwgFlg("N");
				}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return vo;
		}
		 
		/**
		 *  Black Stowage Code update<br>
		 * @param 		bkgBookingVO   BkgBookingVO
		 * @param		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void manageBlckStwgCd(BkgBookingVO bkgBookingVO, SignOnUserAccount account)throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				Map<String, String> mapVO = bkgBookingVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());			
				velParam.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingSearchDBDAOManageBlckStwgCdUSQL(), param,velParam);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}		
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
			 * Reference Number 정보를 조회한다.
			 * 
		 	 * @author 		KimByungKyu 
			 * @param 		BkgBlNoVO bkgBlNoVO
			 * @return 		List<RefNoVO>
			 * @exception 	DAOException
			 */
			 
			public String searchManualYn(BkgBlNoVO bkgBlNoVO) throws DAOException {
				DBRowSet dbRowset = null;
				String rst = null;
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
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchManualYnRSQL(), param, velParam);
					while (dbRowset.next()) {
						rst = dbRowset.getString("RST_YN");
					}

				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
				return rst;
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
	 * 
	 * @param rfaListInputVO
	 * @param propNoVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @return
	 * @throws DAOException
	 */
	 public List<RfaCmdtListVO> searchCmdtByRfaMulti(RfaListInputVO rfaListInputVO, PropNoVO propNoVO, String cmdtNm, String cmdtCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<RfaCmdtListVO> list = null;
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
				
				if(propNoVO != null){
					param.put("prop_no", propNoVO.getPropNo());
					param.put("amdt_seq", propNoVO.getAmdtSeq());
				}else{
					param.put("prop_no", "");
					param.put("amdt_seq", "");
				}
				
				param.put("cmdt_nm", cmdtNm);
				param.put("cmdt_cd", cmdtCd);
				velParam.put("cmdt_nm", cmdtNm);
				velParam.put("cmdt_cd", cmdtCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCmdtByRfaMultiRSQL(), param, velParam);
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
			
			velParam.put("cmdt_nm", cmdtNm);
			velParam.put("cmdt_cd", cmdtCd);
			if(svcScpCd != null && !svcScpCd.equals("")){
				param.put("svc_scp_cd", svcScpCd);
				velParam.put("svc_scp_cd", svcScpCd);
			}
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
	 * 
	 * @param scListInputVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @param svcScpCd
	 * @param scNo
	 * @param propNoVO
	 * @return
	 * @throws DAOException
	 */
	 public List<ScCmdtListVO> searchCmdtByScMulti(ScListInputVO scListInputVO, String cmdtNm, String cmdtCd, String svcScpCd, String scNo, PropNoVO propNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScCmdtListVO> list = null;
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
			
			if(propNoVO != null){
				param.put("prop_no", propNoVO.getPropNo());
				param.put("amdt_seq", propNoVO.getAmdtSeq());
			}else{
				param.put("prop_no", "");
				param.put("amdt_seq", "");
			}
			
			param.put("cmdt_nm", cmdtNm);
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_nm", cmdtNm);
			velParam.put("cmdt_cd", cmdtCd);
			if(!svcScpCd.equals("")){
				param.put("svc_scp_cd", svcScpCd);
				velParam.put("svc_scp_cd", svcScpCd);
			}
			param.put("sc_no", scNo);
			velParam.put("sc_no", scNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchCmdtByScMultiRSQL(), param, velParam);
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
	 * Empty Booking 정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		RepoBkgVO
	 * @exception 	DAOException
	 */
	 
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
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust301BlMain(BkgBlNoVO bkgBlNoVO, String groupId, String refCode) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnMsg = null;
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
				velParam.put("group_id", groupId);
				velParam.put("ref_code", refCode);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301BlMainRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString("BL_MAIN");
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
	 * Container정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public List<String> searchEdi301CntrInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
//		String rtnStr = null;
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
			if(dbRowset != null) {
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CNTR_INFO"));
				}
			}
//			while (dbRowset.next()) {
//				rtnStr = dbRowset.getString("CNTR_INFO");
//			}
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
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301CntrInfoRSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301NewCntrInfoRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchEdi301DgInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("DG_INFO"));
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
	public List<String> searchCust301BkgCm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rtnStrList = null;
//		String rtnStr = null;
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
			if(dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CM_MARK_DESC"));
				}
			}
//			while (dbRowset.next()) {
//				rtnStr = dbRowset.getString("CM_MARK_DESC");
//			}
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
	 * Container CM DESC정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return XterRqstNoVO
	 * @exception DAOException
	 */
	
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
			param.put("pol_nod_cd", vender301ParamVO.getPolNodCd());
			velParam.put("brac", vender301ParamVO.getBracCd());
			velParam.put("cct", vender301ParamVO.getCct());
			velParam.put("ec_edircv_id", vender301ParamVO.getRcvId());
			velParam.put("brac_cd", vender301ParamVO.getBracCdNew());
			velParam.put("pol_nod_cd", vender301ParamVO.getPolNodCd());
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlMain1RSQL(), param, velParam);
			
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString("BL_MAIN1");
			}
			
			log.error("\nBL_MAIN1 = " + rtnMsg);
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
	 * @return String
	 * @exception DAOException
	 */
	public String searchTmnl301BlMain2(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnMsg = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString("BL_MAIN2");
			}
			log.error("\nBL_MAIN2 = " + rtnMsg);
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
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param polCd
	 * @return
	 * @throws DAOException
	 */
	public String searchTmnl301OldVvd(String vslCd, String skdVoyNo, String skdDirCd, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		String oldVvd = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("pol_cd", polCd);
			// param.put("bkg_no_split", bkgNoSplit);

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
	 * Container BKG Customer정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List
	 * @exception DAOException
	 */
	public List<String> searchCust301XterRef(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301XterRefRSQL(), param, velParam);
			if(dbRowset != null)
			{
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("I_BKG_REF"));
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
	 * BKG Route정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchCust301BkgRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301BkgRouteRSQL(), param, velParam);
			
			if(dbRowset != null) {
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("I_BKG_ROUTE"));
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
	 * Bkg Quantity 정보를 조회한다.
	 * 
	 * @param bkgNo
	 * @return List<BkgQuantityVO>
	 * @throws DAOException
	 */
	
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
	 * XTER_BKG_RQST_REF_NO 정보를 조회한다.<br>
	 *
	 * @author Jun Yong Jin
	 * @param String bkgNo
	 * @param String rcvId
	 * @return String
	 * @exception DAOException
	 */
	public String[] searchXterBkgRqstRefNo(String bkgNo, String rcvId) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnMsg = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null && !"".equals(bkgNo)){
				param.put("bkg_no", bkgNo);
				param.put("rcv_id", rcvId);
				velParam.put("bkg_no", bkgNo);
				velParam.put("rcv_id", rcvId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchXterBkgRqstRefNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnMsg[0] = JSPUtil.getNull(dbRowset.getString("XTER_BKG_RQST_REF_NO"));
				rtnMsg[1] = JSPUtil.getNull(dbRowset.getString("FLAG"));
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
	 * 해당 booking의 roll over 정보를 조회
	 * 
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RollOvrVO>
	 * @exception 	DAOException
	 */
	
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
	 * Booking EDI Transmit Batch 대상 조회<br>
	 * @param ediRefCd
	 * @return
	 * @throws DAOException
	 */
	public List<BkgBlNoVO> searchBkgTmlEdiBatch(String ediRefCd)  throws DAOException {
		return searchBkgTmlEdiBatch(ediRefCd, null);
	}
	
	/**
	 * Booking EDI Transmit Batch 대상 조회<br>
	 * @param ediRefCd
	 * @param vvd
	 * @return
	 * @throws DAOException
	 */
	public List<BkgBlNoVO> searchBkgTmlEdiBatch(String ediRefCd, String vvd)  throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ediRefCd != null && !"".equals(ediRefCd)){
				param.put("edi_ref_cd", ediRefCd);
				velParam.put("edi_ref_cd", ediRefCd);
			}
			
			if(vvd != null && !"".equals(vvd)){
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Booking EDI Transmit Batch 대상 조회<br>
	 * 
	 * @return List<BkgBlNoVO>
	 * @throws DAOException
	 */ 
	
	public List<BkgYardCdVO> searchBkgTmlEdiBatchYardCd()  throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgYardCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchYardCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgYardCdVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 
	 * @param bkgBlNoVO
	 * @return
	 * @throws DAOException
	 */
	public List<String> searchCust301CntrInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301CntrInfoRSQL(), param, velParam);
			if(dbRowset != null) {
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("CNTR_INFO"));
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
	 * BKG HPSWA정보를 조회한다.(ESM_BKG_0702)<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchCust301HpswaInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchCust301HpswaInfoRSQL(), param, velParam);
			
			if(dbRowset != null) {
				rtnStrList = new ArrayList<String>();
				while (dbRowset.next()) {
					rtnStrList.add(dbRowset.getString("HPSWA_INFO"));
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
	 * 
	 * @param ydCd
	 * @return
	 * @throws DAOException
	 */
	public String searchBatchEdiVvdList(String ydCd)  throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer vvd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("yd_cd", ydCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOSearchBatchEdiVvdListRSQL(), param, null);
			while(dbRowset.next()){
				vvd.append(dbRowset.getString("FIRST_VVD")).append(",");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvd.toString();
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param cntrNo
	 * @param bracCd
	 * @param refCode
	 * @return
	 * @throws DAOException
	 */
	public String searchVermasMain(String bkgNo, String cntrNo, String bracCd, String refCode) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnMsg = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("brac_cd", bracCd);
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			param.put("ref_cd", refCode);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSearchDBDAOsearchVermasMainRSQL(), param, param);
			while (dbRowset.next()) {
				rtnMsg = dbRowset.getString(1);
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
	
}
