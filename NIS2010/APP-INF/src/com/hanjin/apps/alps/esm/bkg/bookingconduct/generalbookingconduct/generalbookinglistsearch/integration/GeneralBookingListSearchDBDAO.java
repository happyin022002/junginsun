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
* 2013.04.15 김태경 [CHM-201323872] ALPS > Draft B/L &Freight Invoice EDI 화면 보완 요청 드립니다
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptCntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgHangerListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyCntrSumVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
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
import com.hanjin.syscommon.common.table.BkgCoffTmVO;


/**
 * ALPS GeneralBookingListSearchDBDAO <br>
 * - ALPS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingListSearchBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class GeneralBookingListSearchDBDAO extends DBDAOSupport {

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
	 * @param String subChk
	 * @return List<BkgCoffTmListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO, String subChk) throws DAOException {
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
			velParam.put("sub_chk", subChk);
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
		 * Booking Close 화면에 Yard 및 drop down으로 보여질 calling seq 를 조회<br>
		 *
		 * @author	
		 * @param 	BkgCoffTmVO bkgCoffTmVO
		 * @return 	VslSkdVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public VslSkdVO searchBkgCoffTmYd(BkgCoffTmVO bkgCoffTmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<VslSkdVO> list = null;
			VslSkdVO vslSkdVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try{
				if(bkgCoffTmVO != null){
					Map<String, String> mapVO = bkgCoffTmVO.getColumnValues();
	
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOSearchBkgCoffTmYdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);
				if(list != null && list.size() > 0){
					vslSkdVO = list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return vslSkdVO;
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
	            	if (!JSPUtil.getNull(bkgListForWorkWithBkgInputVO.getBkgNo()).equals("")) {
	            		bkgListForWorkWithBkgInputVO.setBkgNo("'" + bkgListForWorkWithBkgInputVO.getBkgNo().replaceAll(",", "','") + "'");
					}
	            	
	            	Map<String, String> mapVO = bkgListForWorkWithBkgInputVO .getColumnValues();
	                
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	                String bkgViaCd = "";
	                ArrayList<String> bkgViaCdList = new ArrayList();
	                String siViaCd = "";
	                ArrayList<String> siViaCdList = new ArrayList();
	                String eqTpSzCd = "";
	                ArrayList<String> eqTpSzCdList = new ArrayList();
	                String rtroKndCd = "";
	                ArrayList<String> rtroKndCdList = new ArrayList();
	                

	                bkgViaCd = bkgListForWorkWithBkgInputVO.getBkgViaCd();
	                siViaCd = bkgListForWorkWithBkgInputVO.getSiViaCd();
	                eqTpSzCd = bkgListForWorkWithBkgInputVO.getEqTpSzCd();
	                rtroKndCd = bkgListForWorkWithBkgInputVO.getRtroKndCd();
	                if(siViaCd!=null){
		                StringTokenizer bkgViaCdToken = new StringTokenizer(bkgViaCd, "|");
		                while(bkgViaCdToken.hasMoreTokens()){
		                	String bkgVia = bkgViaCdToken.nextToken();
		                	if("OFF".equals(bkgVia)||"APS".equals(bkgVia)){
		                		bkgViaCdList.add("NIS");
		                	} else {
		                		bkgViaCdList.add(bkgVia);
		                	}
		                }
	                }
	                if(bkgViaCd!=null){
		                StringTokenizer siViaCdToken = new StringTokenizer((siViaCd!=null)?siViaCd:"", "|");
		                while(siViaCdToken.hasMoreTokens()){
		                	String siVia = siViaCdToken.nextToken();
		                	if("OFF".equals(siVia)||"APS".equals(siVia)){
		                		siViaCdList.add("NIS");
		                	} else {
		                		siViaCdList.add(siVia);
		                	}
		                }
	                }
	                if(eqTpSzCd!=null){
		                StringTokenizer eqTpSzCdToken = new StringTokenizer(eqTpSzCd, "|");
		                while(eqTpSzCdToken.hasMoreTokens()){
		                	String eqTpSz = eqTpSzCdToken.nextToken();
		                	eqTpSzCdList.add(eqTpSz);
		                }
	                }
	                if(rtroKndCd!=null){//rtroKndCd
		                StringTokenizer rtroKndCdToken = new StringTokenizer(rtroKndCd, "|");
		                while(rtroKndCdToken.hasMoreTokens()){
		                	String rtroKnd = rtroKndCdToken.nextToken();
		                	rtroKndCdList.add(rtroKnd);
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
	                if(rtroKndCdList != null && rtroKndCdList.size() > 0) {
	                    velParam.put("rtroKndCd", rtroKndCdList);
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

//		/**
//		 * 로그인 사용자의 오피스코드가 중국지역 오피스코드인지를 확인한다.(ESM_BKG_0098)<br>
//		 * 0098화면의 RD 종류 선택용도<br>
//		 *
//		 * @param String usrOfcCd
//		 * @return String
//		 * @exception DAOException
//		 */
//		public String searchBkgReceiptType(String usrOfcCd) throws DAOException {
//			DBRowSet dbRowset = null;
//			String rtnOfcCd = null;
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//
//			try{
//				if(usrOfcCd != null){
//					param.put("usr_ofc_cd", usrOfcCd);
//					velParam.put("usr_ofc_cd", usrOfcCd);
//				}
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchBkgReceiptTypeRSQL(), param, velParam);
//				while (dbRowset.next()) {
//					rtnOfcCd = dbRowset.getString("OFC_CD");
//				}
//			} catch (SQLException se) {
//				log.error(se.getMessage(),se);
//				throw new DAOException(new ErrorHandler(se).getMessage(),se);
//			} catch (Exception ex) {
//				log.error(ex.getMessage(),ex);
//				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//			}
//			return rtnOfcCd;
//		}

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

				try{
					if(bkgListFor301310EdiInputVO != null){
						if (!JSPUtil.getNull(bkgListFor301310EdiInputVO.getBkgNo()).equals("")) {
							bkgListFor301310EdiInputVO.setBkgNo("'" + bkgListFor301310EdiInputVO.getBkgNo().replaceAll(",", "','") + "'");
						}
						if (!JSPUtil.getNull(bkgListFor301310EdiInputVO.getXterRqstViaCd()).equals("")) {
							bkgListFor301310EdiInputVO.setXterRqstViaCd("'" + bkgListFor301310EdiInputVO.getXterRqstViaCd().replaceAll(",", "','") + "'");
						}
						Map<String, String> mapVO = bkgListFor301310EdiInputVO .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
					}
					param.put("msg_type_cd", msgTypeCd);
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

				String tpszTypeText	= Utils.convertStr(emptyBkgListInputVO.getTpsztype(), true);							

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszTypeText",   tpszTypeText);
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
	 * Empty REPO BKG Hanger Inquiry 조회<br>
	 * 
	 * @author 	DYRYU
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	List<EmptyBkgHangerListVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EmptyBkgHangerListVO> searchEmptyBkgHangerList(EmptyBkgListInputVO emptyBkgListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyBkgHangerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(emptyBkgListInputVO != null){
				Map<String, String> mapVO = emptyBkgListInputVO .getColumnValues();

				String tpszTypeText	= Utils.convertStr(emptyBkgListInputVO.getTpsztype(), true);							

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszTypeText",   tpszTypeText);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchEmptyBkgHangerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmptyBkgHangerListVO .class);
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

				String tpszTypeText	= Utils.convertStr(emptyBkgListInputVO.getTpsztype(), true);							

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszTypeText",   tpszTypeText);
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
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @author DaeYoung Ryu
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustCdValidationVO> searchPreCheckForCodeAccuracyMatch(
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCdValidationVO> result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arrNtcSearchVO != null){
				Map<String, String> mapVO = arrNtcSearchVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyMatchRSQL(), param, velParam);
			result = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdValidationVO .class);
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
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @author DaeYoung Ryu
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustCdValidationVO> searchPreCheckForCodeAccuracyUnmatch(
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCdValidationVO> result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arrNtcSearchVO != null){
				Map<String, String> mapVO = arrNtcSearchVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyUnmatchRSQL(), param, velParam);
			result = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdValidationVO.class);
            if (result != null && result.size() > 0 ) {
            	CustCdValidationVO custCdValidationVO = result.get(result.size() -1);
            	result.get(0).setRowCount(custCdValidationVO.getGrpSeq());
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
}