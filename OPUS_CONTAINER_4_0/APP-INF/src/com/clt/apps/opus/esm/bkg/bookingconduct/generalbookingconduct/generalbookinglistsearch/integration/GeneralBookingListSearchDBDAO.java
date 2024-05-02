/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAO.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptCntVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyCntrSumVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS GeneralBookingListSearchDBDAO <br>
 * - OPUS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingListSearchBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralBookingListSearchDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -967552364859477192L;

	/**
	 * Compulsory Firm 대상 Booking 정보를 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param BkgListForCompFirmInputVO bkgListForCompFirmInputVO
	 * @return List<BkgListForCompFirmVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgListForCompFirmVO> searchBkgListForCompFirm(BkgListForCompFirmInputVO bkgListForCompFirmInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForCompFirmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgListForCompFirmInputVO != null){
				Map<String, String> mapVO = bkgListForCompFirmInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOSearchBkgListForCompFirmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForCompFirmVO .class);
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
	 * Booking close / reopen하기 위한 list를 조회한다.<br>
	 *
	 * @param BkgListForBayPlanInputVO bkgListForBayPlanInputVO
	 * @return List<BkgCoffTmListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCoffTmListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgListForBayPlanInputVO != null){
				Map<String, String> mapVO = bkgListForBayPlanInputVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgCoffTmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCoffTmListVO .class);
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
	  * Booking Close 화면에 drop down으로 보여질 Booking Office를 조회<br>
	  * 
	  * @param String sPol
	  * @param String sVvd
	  * @return List<BkgComboVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
		public List<BkgComboVO> searchBkgOfcListForBkgClz(String sPol , String sVvd) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgComboVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(sPol != null || sVvd !=null){
					Map<String, String> mapVO  = new HashMap();

					mapVO.put("pol_cd", sPol);
					mapVO.put("vsl_cd", sVvd);
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgOfcListForBkgClzRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO .class);
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
	     * 작업을 진행할 Booking 리스트를 조회한다.(ESM_BKG_0614)<br>
	     *
	     * @author Jun Yong Jin
	     * @param BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO
	     * @return List<BkgListForWorkWithBkgVO>
	     * @exception DAOException
	     */
	     @SuppressWarnings("unchecked")
	    public List<BkgListForWorkWithBkgVO> searchBkgListForWorkWithBkg(BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<BkgListForWorkWithBkgVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	            if(bkgListForWorkWithBkgInputVO != null){
	                Map<String, String> mapVO = bkgListForWorkWithBkgInputVO .getColumnValues();

	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	                String bkgViaCd = "";
	                ArrayList<String> bkgViaCdList = new ArrayList<String>();
	                String siViaCd = "";
	                ArrayList<String> siViaCdList = new ArrayList<String>();
	                String eqTpSzCd = "";
	                ArrayList<String> eqTpSzCdList = new ArrayList<String>();
	                String multiBkgNo = "";
	                ArrayList<String> multiBkgNoList = new ArrayList<String>();
	                
	                bkgViaCd = bkgListForWorkWithBkgInputVO.getBkgViaCd();
	                siViaCd = bkgListForWorkWithBkgInputVO.getSiViaCd();
	                eqTpSzCd = bkgListForWorkWithBkgInputVO.getEqTpSzCd();
	                multiBkgNo = bkgListForWorkWithBkgInputVO.getMultBkgNo();
	                
	                if(siViaCd!=null && !"".equals(siViaCd)){
		                StringTokenizer siViaCdToken = new StringTokenizer(siViaCd, "|");
		                while(siViaCdToken.hasMoreTokens()){
		                	String siVia = siViaCdToken.nextToken();
		                	siViaCdList.add(siVia);
		                }
	                }
	                if(bkgViaCd != null){
		                StringTokenizer bkgViaCdToken = new StringTokenizer(bkgViaCd, "|");
		                while(bkgViaCdToken.hasMoreTokens()){
		                	String bkgVia = bkgViaCdToken.nextToken();
		                	bkgViaCdList.add(bkgVia);
		                }
	                }
	                if(eqTpSzCd!=null){
		                StringTokenizer eqTpSzCdToken = new StringTokenizer(eqTpSzCd, "|");
		                while(eqTpSzCdToken.hasMoreTokens()){
		                	String eqTpSz = eqTpSzCdToken.nextToken();
		                	eqTpSzCdList.add(eqTpSz);
		                }
	                }
	                if(multiBkgNo != null){
	                	StringTokenizer multiBkgNoToken = new StringTokenizer(multiBkgNo.toUpperCase(), "\n");
	                	 while(multiBkgNoToken.hasMoreTokens()){
		                	String bkgNo = multiBkgNoToken.nextToken();
		                	multiBkgNoList.add(bkgNo);
		                }
	                }
	                
	                if(bkgViaCdList != null && bkgViaCdList.size() > 0) {
	                    velParam.put("bkgViaCd", bkgViaCdList);
	                }
	                if(siViaCdList != null && siViaCdList.size() > 0) {
	                    velParam.put("siViaCd", siViaCdList);
	                }
	                if(eqTpSzCdList != null && eqTpSzCdList.size() > 0) {
	                    velParam.put("eqTpSzCd", eqTpSzCdList);
	                }
	                if(multiBkgNoList != null && multiBkgNoList.size() > 0) {
	                    velParam.put("multiBkgNo", multiBkgNoList);
	                }else{
	                	velParam.put("multiBkgNo", "");
	                }
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListForWorkWithBkgRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForWorkWithBkgVO .class);
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
		 * booking receipt notice를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0098)<br>
		 *
		 * @author Jun Yong Jin
		 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
		 * @return List<BkgListForBkgReceiptVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgListForBkgReceiptVO> searchBkgListForBkgReceiptNtc(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgListForBkgReceiptVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgListForBkgReceiptInputVO != null){
					Map<String, String> mapVO = bkgListForBkgReceiptInputVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					String multiBkgNo = "";
					ArrayList<String> multiBkgNoList = new ArrayList<String>();
					multiBkgNo = bkgListForBkgReceiptInputVO.getMultBkgNo();
					
					if(multiBkgNo != null){
	                	StringTokenizer multiBkgNoToken = new StringTokenizer(multiBkgNo.toUpperCase(), "\n");
	                	 while(multiBkgNoToken.hasMoreTokens()){
		                	String bkgNo = multiBkgNoToken.nextToken();
		                	multiBkgNoList.add(bkgNo);
		                }
	                }
					
					if(multiBkgNoList != null && multiBkgNoList.size() > 0) {
	                    velParam.put("multiBkgNo", multiBkgNoList);
	                }
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForBkgReceiptVO .class);
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
		 * booking receipt notice를 보낼 Booking 리스트의 통계 정보를 조회한다.(ESM_BKG_0098)<br>
		 *
		 * @author Jun Yong Jin
		 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
		 * @return List<BkgListForBkgReceiptCntVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgListForBkgReceiptCntVO> searchBkgListForBkgReceiptNtcCnt(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgListForBkgReceiptCntVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(bkgListForBkgReceiptInputVO != null){
					Map<String, String> mapVO = bkgListForBkgReceiptInputVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					String multiBkgNo = "";
					ArrayList<String> multiBkgNoList = new ArrayList<String>();
					multiBkgNo = bkgListForBkgReceiptInputVO.getMultBkgNo();
					
					if(multiBkgNo != null){
	                	StringTokenizer multiBkgNoToken = new StringTokenizer(multiBkgNo.toUpperCase(), "\n");
	                	 while(multiBkgNoToken.hasMoreTokens()){
		                	String bkgNo = multiBkgNoToken.nextToken();
		                	multiBkgNoList.add(bkgNo);
		                }
	                }
					
					if(multiBkgNoList != null && multiBkgNoList.size() > 0) {
	                    velParam.put("multiBkgNo", multiBkgNoList);
	                }
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcCntRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForBkgReceiptCntVO .class);
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
		 * 301, 310 EDI를 전송할 Booking 리스트를 조회한다.(ESM_BKG_0702)<br>
		 *
		 * @author Jun Yong Jin
		 * @param BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO
		 * @param String msgTypeCd
		 * @return List<BkgListFor301310EdiVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgListFor301310EdiVO> searchBkgListFor301310Edi(BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO, String msgTypeCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgListFor301310EdiVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			String multiBkgNo = "";
			ArrayList<String> multiBkgNoList = new ArrayList();
			
			
			try{
				if(bkgListFor301310EdiInputVO != null){
					Map<String, String> mapVO = bkgListFor301310EdiInputVO .getColumnValues();

					multiBkgNo = bkgListFor301310EdiInputVO.getMultBkgNo();
					
					if(multiBkgNo != null){
						StringTokenizer multiBkgNoToken = new StringTokenizer(multiBkgNo.toUpperCase(), "\n");
						while(multiBkgNoToken.hasMoreTokens()){
							String bkgNo = multiBkgNoToken.nextToken();
							multiBkgNoList.add(bkgNo);
						}
					}
					if (multiBkgNoList != null && multiBkgNoList.size() > 0) {
						velParam.put("multiBkgNo", multiBkgNoList);
					}
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				velParam.put("msg_type_cd", msgTypeCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListFor301310EdiRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListFor301310EdiVO .class);
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
	 * Empty REPO BKG Inquiry 조회<br>
	 *
	 * @author 	KimByungKyu
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	List<EmptyBkgListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EmptyBkgListVO> searchEmptyBkgList(EmptyBkgListInputVO emptyBkgListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyBkgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(emptyBkgListInputVO != null){
				Map<String, String> mapVO = emptyBkgListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmptyBkgListVO .class);
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
	 * Empty REPO BKG Container별 합계 조회<br>
	 *
	 * @author 	KimByungKyu
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	EmptyCntrSumVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public EmptyCntrSumVO searchEmptyCntrSum(EmptyBkgListInputVO emptyBkgListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCntrSumVO> list = null;
		EmptyCntrSumVO emptyCntrSumVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(emptyBkgListInputVO != null){
				Map<String, String> mapVO = emptyBkgListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmptyCntrSumVO .class);
			if(list != null && list.size() > 0){
				emptyCntrSumVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return emptyCntrSumVO;
	}		 

	/**
	 * 미주외 지역의 terminal edi를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForGeneralTmlEdiVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgListForGeneralTmlEdiVO> searchBkgListForGeneralTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForGeneralTmlEdiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgListForTmlEdiInputVO != null){
				Map<String, String> mapVO = bkgListForTmlEdiInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListForGeneralTmlEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForGeneralTmlEdiVO .class);
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
	 * 미주 지역에서 terminal edi에 대한 송수신 이력과 전송대상 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForUsaTmlEdiVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgListForUsaTmlEdiVO> searchBkgListForUsaTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForUsaTmlEdiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgListForTmlEdiInputVO != null){
				Map<String, String> mapVO = bkgListForTmlEdiInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgListForUsaTmlEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForUsaTmlEdiVO .class);
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
	 * 로그인 사용자의 Id로 Location Code를 조회한다.(ESM_BKG_0616)<br>
	 *
	 * @author Jun Yong Jin
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsrCntCd(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		String cntCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(account != null){
				param.put("usr_id", account.getUsr_id());
				velParam.put("usr_id", account.getUsr_id());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchUsrCntCdRSQL(), param, velParam);
			while (dbRowset.next()) {
				cntCd = dbRowset.getString("CNT_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cntCd;
	}
	
	/**
	 * Booking remark and content insert TRS_INTER_RMK (ESM_BKG_0098)<br>
	 * @param String bkgNo
	 * @param String btnTp
	 * @param SignOnUserAccount account
	 * @param String interRmkCtnt
	 * @throws DAOException
	 */
	public void addInternalRemark(String bkgNo, String btnTp, SignOnUserAccount account, String interRmkCtnt) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;

		try{
			param.put("bkg_no", bkgNo);
			param.put("btnTp", btnTp);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("login_user_ofc_cd", account.getOfc_cd());
			param.put("inter_rmk_ctnt", interRmkCtnt);				
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingListSearchDBDAOAddRemarkCSQL(), param,velParam);

			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}	

}