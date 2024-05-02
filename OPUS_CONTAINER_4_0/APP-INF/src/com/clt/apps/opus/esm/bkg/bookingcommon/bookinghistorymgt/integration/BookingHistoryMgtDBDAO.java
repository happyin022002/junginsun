/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingHistoryMgtDBDAO.java
 *@FileTitle : Booking_History_Mgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.05.11 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgTmlEdiHisVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.TableListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
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
 *  BookingHistoryMgtDBDAO <br>
 * - -BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BookingHistoryMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class BookingHistoryMgtDBDAO extends DBDAOSupport {
    
    /**
     * bkg_his_mst의 booking별 다음 seq를 가져온다<br>
     * 
     * @param  bkgNo String
     * @return String
     * @exception DAOException
     */
    public String searchNextHistSeq (String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			String hisSeq = "";			
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = sqlExe.executeQuery((ISQLTemplate)new BookingHistoryMgtDBDAOsearchNextHistSeqRSQL(), param, velParam);
            if (dbRowset.next()) {
            	hisSeq = dbRowset.getString("his_seq");
            }
            
            return hisSeq;
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

    /**
     * BKG_HIS_DTL 테이블의 특정Ui/특정Bkg_no의 'TMP0000001' 정보를 일괄삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @param  String uiId
     * @exception DAOException
     */
    public void removeHisDtlByUiId(BkgBlNoVO bkgBlNoVO, String uiId) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put   ("ui_id", uiId);
            velParam.put("ui_id", uiId);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAORemoveHisDtlByUiIdDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * BKG_HIS_MST 테이블의 특정Ui/특정Bkg_no의 'TMP0000001' 정보를 일괄삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @param  String uiId
     * @exception DAOException
     */
    public void removeHisMstByUiId(BkgBlNoVO bkgBlNoVO, String uiId) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put   ("ui_id", uiId);
            velParam.put("ui_id", uiId);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAORemoveHisMstByUiIdDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG_HIS_DTL 테이블의 특정Bkg_no의 'TMP0000001' 정보를 일괄삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
    public void removeTmpHisDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAORemoveTmpHisDtlDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * BKG_HIS_MST 테이블의 특정Bkg_no의 'TMP0000001' 정보를 일괄삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
    public void removeTmpHisMst(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAORemoveTmpHisMstDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Booking History Master 를 기록한다.<br>
     * 
     * @param  BkgHisMstVO bkgHisMstVO
     * @exception DAOException
     */
    public void addBkgHisMst(BkgHisMstVO bkgHisMstVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgHisMstVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOaddBkgHisMstCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Booking의 Notice History를 기록한다.<br>
     * 
     * @param  BkgNtcHisVO BkgNtcHisVO
     * @exception DAOException
     */
    public void addBkgNtcHis(BkgNtcHisVO bkgNtcHisVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgNtcHisVO.getColumnValues();
        	
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOaddBkgNtcHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
   
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 * 
	 * @author Lee NamKyung
	 * @param  uiId String
	 * @return List<TableListVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<TableListVO> searchHisTableByUi(String uiId) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TableListVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("ui_id", uiId);
			 velParam.put("ui_id", uiId);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHisTableByUiRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TableListVO.class);
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }    
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgBookingVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public BkgBookingVO searchBkgBooking(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgBookingVO> list = null;
		 BkgBookingVO bkgBookingVO = new BkgBookingVO();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgBookingRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);			 
			 if (list != null && list.size() > 0) {
				 bkgBookingVO = (BkgBookingVO)list.get(0);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return bkgBookingVO;
    }  

	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgCustomerVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgCustomerVO> searchBkgCustomer(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgCustomerVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgCustomerRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCustomerVO.class);	
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
   
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgVvdVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgVvdVO> searchBkgVvd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgVvdVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgQuantityVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgQuantityRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBlNoVO BkgBlNoVO
	 * @return BkgQtyDtlVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgQtyDtlVO> searchBkgQtyDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgQtyDtlVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgQtyDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgCntcPsonVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgCntcPsonVO> searchBkgCntcPson(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgCntcPsonVO> list = null;
//		 BkgCntcPsonVO bkgCntcPsonVO = new BkgCntcPsonVO();
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgCntcPsonRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntcPsonVO.class);			 
//			 if (list != null && list.size() > 0) {
//				 bkgCntcPsonVO = (BkgCntcPsonVO)list.get(0);
//			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgReferenceVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgReferenceVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgReferenceVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgReferenceRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgRefDtlVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgRefDtlVO> searchBkgRefDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgRefDtlVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgRefDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRefDtlVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgContainerVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgContainerVO> searchBkgContainer(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgContainerVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgContainerRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgCntrSealNoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgCntrSealNoVO> searchBkgCntrSealNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgCntrSealNoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgCntrSealNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrSealNoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgCntrMfDescVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgCntrMfDescVO> searchBkgCntrMfDesc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgCntrMfDescVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrMfDescVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgClzTmVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgClzTmVO> searchBkgClzTm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgClzTmVO> list = null;
//		 BkgClzTmVO bkgClzTmVO = new BkgClzTmVO();
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgClzTmRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgClzTmVO.class);			 
//			 if (list != null && list.size() > 0) {
//				 bkgClzTmVO = (BkgClzTmVO)list.get(0);
//			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgBlDocVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public BkgBlDocVO searchBkgBlDoc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgBlDocVO> list = null;
		 BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgBlDocRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlDocVO.class);			 
			 if (list != null && list.size() > 0) {
				 bkgBlDocVO = (BkgBlDocVO)list.get(0);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return bkgBlDocVO;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgBlMkDescVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public BkgBlMkDescVO searchBkgBlMkDesc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgBlMkDescVO> list = null;
		 BkgBlMkDescVO bkgBlMkDescVO = new BkgBlMkDescVO();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgBlMkDescRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlMkDescVO.class);			 
			 if (list != null && list.size() > 0) {
				 bkgBlMkDescVO = (BkgBlMkDescVO)list.get(0);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return bkgBlMkDescVO;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgHblVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgHblVO> searchBkgHbl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgHblVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgHblRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHblVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgHblCustVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgHblCustVO> searchBkgHblCust(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgHblCustVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgHblCustRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHblCustVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgUsaCstmsFileNoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgUsaCstmsFileNoVO> searchBkgUsaCstmsFileNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgUsaCstmsFileNoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgUsaCstmsFileNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsaCstmsFileNoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgXptImpLicVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgXptImpLicVO> searchBkgXptImpLic(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgXptImpLicVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgXptImpLicRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXptImpLicVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgDgCgoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgDgCgoVO> searchBkgDgCgo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgDgCgoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDgCgoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgRfCgoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgRfCgoVO> searchBkgRfCgo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgRfCgoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRfCgoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgAwkCgoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgAwkCgoVO> searchBkgAwkCgo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgAwkCgoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchTempBkgAwkCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgAwkCgoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgAwkDimVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgAwkDimVO> searchBkgAwkDim(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgAwkDimVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgAwkDimRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgAwkDimVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgBbCgoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgBbCgoVO> searchBkgBbCgo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgBbCgoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgBbCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBbCgoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgTroVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgTroVO> searchBkgTro(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgTroVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgTroDtlVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgTroDtlVO> searchBkgTroDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgTroDtlVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroDtlVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgTroSpclCgoSeqVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgTroSpclCgoSeqVO> searchBkgTroSpclCgoSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgTroSpclCgoSeqVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgTroSpclCgoSeqRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroSpclCgoSeqVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgEurTroVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgEurTroVO> searchBkgEurTro(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgEurTroVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgEurTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgEurTroDtlVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgEurTroDtlVO> searchBkgEurTroDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgEurTroDtlVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgEurTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroDtlVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgEurTroDgSeqVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgEurTroDgSeqVO> searchBkgEurTroDgSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgEurTroDgSeqVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgEurTroDgSeqRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroDgSeqVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return BkgRateVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public BkgRateVO searchBkgRate(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgRateVO> list = null;
		 BkgRateVO bkgRateVO = new BkgRateVO();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgRateRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRateVO.class);			 
			 if (list != null && list.size() > 0) {
				 bkgRateVO = (BkgRateVO)list.get(0);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return bkgRateVO;
    }
    
    /**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgChgRtVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgChgRtVO> searchBkgChgRt(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgChgRtVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgChgRtRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgChgRtVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
    /**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return BkgBlIssVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public BkgBlIssVO searchBkgBlIss(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgBlIssVO> list = null;
		 BkgBlIssVO bkgBlIssVO = new BkgBlIssVO();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgBlIssRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlIssVO.class);			 
			 if (list != null && list.size() > 0) {
				 bkgBlIssVO = (BkgBlIssVO)list.get(0);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return bkgBlIssVO;
    }
    
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBookingVO BkgBookingVO
	 * @param  caFlg String
	 * @return HistCtntVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgBooking(BkgBookingVO bkgBookingVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBookingVO.getColumnValues();
			 param.putAll(mapVO);			 
			 velParam.putAll(mapVO);			 
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }  

	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgCustomerVO BkgCustomerVO
     * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgCustomer(BkgCustomerVO bkgCustomerVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgCustomerVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgCustomerRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }

	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgCntrPsonVO BkgCntcPsonVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgCntcPson(BkgCntcPsonVO bkgCntrPsonVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgCntrPsonVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgCntcPsonRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }

	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgReferenceVO BkgReferenceVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgReference(BkgReferenceVO bkgReferenceVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgReferenceVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgReferenceRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgReferenceVOs List<BkgReferenceVO> 
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgReference(List<BkgReferenceVO> bkgReferenceVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList(); 
			 for (int i=0; i<bkgReferenceVOs.size(); i++) {				 
				 String strRefSeqId = "('"+bkgReferenceVOs.get(i).getBkgNo()
				                          +"', '"+bkgReferenceVOs.get(i).getRefSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no",  bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);				 
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgReferenceRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgRefDtlVO BkgRefDtlVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgRefDtl(BkgRefDtlVO bkgRefDtlVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgRefDtlVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgRefDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgRefDtlVOs List<BkgRefDtlVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgRefDtl(List<BkgRefDtlVO> bkgRefDtlVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();
			 for (int i=0; i<bkgRefDtlVOs.size(); i++) {				 
				 String strRefSeqId = "('"+bkgRefDtlVOs.get(i).getBkgNo()
				                          +"', "+bkgRefDtlVOs.get(i).getRefSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgRefDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgQuantityVO BkgQuantityVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgQuantity(BkgQuantityVO bkgQuantityVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgQuantityVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgQuantityRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgQuantityVOs List<BkgQuantityVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgQuantity(List<BkgQuantityVO> bkgQuantityVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList(); 
			 for (int i=0; i<bkgQuantityVOs.size(); i++) {				 
				 String strFieldId = "('"+bkgQuantityVOs.get(i).getBkgNo()
				                         +"', '"+bkgQuantityVOs.get(i).getCntrTpszCd()+"')";
				 arrString.add(strFieldId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }    
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgQtyDtlVO BkgQtyDtlVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgQtyDtl(BkgQtyDtlVO bkgQtyDtlVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgQtyDtlVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgQtyDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgQtyDtlVOs List<BkgQtyDtlVO>
	 * @param  bkgNo String
     * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgQtyDtl(List<BkgQtyDtlVO> bkgQtyDtlVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  
			 for (int i=0; i<bkgQtyDtlVOs.size(); i++) {				 
				 String strRefSeqId = "('"+bkgQtyDtlVOs.get(i).getBkgNo()
				                          +"', '"+bkgQtyDtlVOs.get(i).getCntrTpszCd()
				                          +"', '"+bkgQtyDtlVOs.get(i).getSubstSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgQtyDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }    
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgClzTmVO BkgClzTmVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgClzTm(BkgClzTmVO bkgClzTmVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgClzTmVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgClzTmRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }

	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgVvdVO BkgVvdVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgVvd(BkgVvdVO bkgVvdVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgVvdVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  List<BkgVvdVO> bkgVvdVOs
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgVvd(List<BkgVvdVO> bkgVvdVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  
			 for (int i=0; i<bkgVvdVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgVvdVOs.get(i).getBkgNo()
				                          +"', '"+bkgVvdVOs.get(i).getVslPrePstCd()
				                          +"', '"+bkgVvdVOs.get(i).getVslSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }   
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgUsaCstmsFileNoVO BkgUsaCstmsFileNoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgUsaCstmsFileNo(BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgUsaCstmsFileNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgUsaCstmsFileNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgUsaCstmsFileNoVOs List<BkgUsaCstmsFileNoVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgUsaCstmsFileNo(List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, USA_CSTMS_FILE_NO)
			 for (int i=0; i<bkgUsaCstmsFileNoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgUsaCstmsFileNoVOs.get(i).getBkgNo()
				                          +"', '"+bkgUsaCstmsFileNoVOs.get(i).getUsaCstmsFileNo()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgUsaCstmsFileNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgTroVO BkgTroVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgTro(BkgTroVO bkgTroVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgTroVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgTroVOs List<BkgTroVO>
	 * @param  bkgNo String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgTro(List<BkgTroVO> bkgTroVOs, String bkgNo) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ)
			 for (int i=0; i<bkgTroVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgTroVOs.get(i).getBkgNo()
				                          +"', '"+bkgTroVOs.get(i).getIoBndCd()
				                          +"', '"+bkgTroVOs.get(i).getRtnTroFlg()
				                          +"', '"+bkgTroVOs.get(i).getTroSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgTroDtlVO BkgTroDtlVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgTroDtl(BkgTroDtlVO bkgTroDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgTroDtlVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgTroDtlVOs List<BkgTroDtlVO>
	 * @param  bkgNo String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgTroDtl(List<BkgTroDtlVO> bkgTroDtlVOs, String bkgNo) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, IO_BND_CD, RTN_TRO_FLG, TRO_SEQ, TRO_SUB_SEQ)
			 for (int i=0; i<bkgTroDtlVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgTroDtlVOs.get(i).getBkgNo()
				                          +"', '"+bkgTroDtlVOs.get(i).getIoBndCd()
				                          +"', '"+bkgTroDtlVOs.get(i).getRtnTroFlg()
				                          +"', '"+bkgTroDtlVOs.get(i).getTroSeq()
				                          +"', '"+bkgTroDtlVOs.get(i).getTroSubSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgEurTroVO BkgEurTroVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgEurTro(BkgEurTroVO bkgEurTroVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgEurTroVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgEurTroVOs List<BkgEurTroVO>
	 * @param  bkgNo String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgEurTro(List<BkgEurTroVO> bkgEurTroVOs, String bkgNo) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, IO_BND_CD, TRO_SEQ)
			 for (int i=0; i<bkgEurTroVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgEurTroVOs.get(i).getBkgNo()
				                          +"', '"+bkgEurTroVOs.get(i).getIoBndCd()
				                          +"', '"+bkgEurTroVOs.get(i).getTroSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgEurTroRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgEurTroDtlVO BkgEurTroDtlVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgEurTroDtl(BkgEurTroDtlVO bkgEurTroDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgEurTroDtlVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgEurTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgEurTroDtlVOs List<BkgEurTroDtlVO>
	 * @param  bkgNo String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgEurTroDtl(List<BkgEurTroDtlVO> bkgEurTroDtlVOs, String bkgNo) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ)
			 for (int i=0; i<bkgEurTroDtlVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgEurTroDtlVOs.get(i).getBkgNo()
				                          +"', '"+bkgEurTroDtlVOs.get(i).getIoBndCd()
				                          +"', '"+bkgEurTroDtlVOs.get(i).getTroSeq()
				                          +"', '"+bkgEurTroDtlVOs.get(i).getTroSubSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgEurTroDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgContainerVO bkgContainerVO
	 * @param  String caFlg
	 * @param  String uiId
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgContainer(BkgContainerVO bkgContainerVO, String caFlg, String uiId) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgContainerVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 param.put   ("ui_id", uiId);
			 velParam.put("ca_flg", caFlg);	
			 velParam.put   ("ui_id", uiId);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  List<BkgContainerVO> bkgContainerVOs
	 * @param  String bkgNo
	 * @param  String caFlg
	 * @param  String uiId
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgContainer(List<BkgContainerVO> bkgContainerVOs, String bkgNo, String caFlg, String uiId) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, CNTR_NO)
			 for (int i=0; i<bkgContainerVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgContainerVOs.get(i).getBkgNo()
				                          +"', '"+bkgContainerVOs.get(i).getCntrNo()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 param.put   ("ui_id", uiId); 
			 velParam.put("ui_id", uiId);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgContainerRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgCntrMfDescVO BkgCntrMfDescVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgCntrMfDesc(BkgCntrMfDescVO bkgCntrMfDescVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgCntrMfDescVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgCntrMfDescVOs List<BkgCntrMfDescVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgCntrMfDesc(List<BkgCntrMfDescVO> bkgCntrMfDescVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, CNTR_MF_SEQ)
			 for (int i=0; i<bkgCntrMfDescVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgCntrMfDescVOs.get(i).getBkgNo()
                         				  +"', '"+bkgCntrMfDescVOs.get(i).getCntrNo()
				                          +"', '"+bkgCntrMfDescVOs.get(i).getCntrMfSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgCntrMfDescRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgCntrSealNoVO bkgCntrSealNoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgCntrSealNo(BkgCntrSealNoVO bkgCntrSealNoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgCntrSealNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgCntrSealNoVOs List<BkgCntrSealNoVO>
	 * @param  bkgNo String
	 * @param  cntrNo String
     * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgCntrSealNo(List<BkgCntrSealNoVO> bkgCntrSealNoVOs, String bkgNo, String cntrNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, CNTR_NO)
			 for (int i=0; i<bkgCntrSealNoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgCntrSealNoVOs.get(i).getBkgNo()
                                          +"', '"+bkgCntrSealNoVOs.get(i).getCntrNo()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 param.put   ("cntr_no", cntrNo);
			 velParam.put   ("cntr_no", cntrNo);
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgCntrSealNoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlDocVO bkgBlDocVO
	 * @param  String caFlg
	 * @param  String uiId
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgBlDoc(BkgBlDocVO bkgBlDocVO, String caFlg, String uiId) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlDocVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 param.put   ("ui_id", uiId); 
			 velParam.put("ui_id", uiId);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBlMkDescVO BkgBlMkDescVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgBlMkDesc(BkgBlMkDescVO bkgBlMkDescVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlMkDescVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgBlMkDescRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgRateVO BkgRateVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgRate(BkgRateVO bkgRateVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgRateVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgRateRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgChgRtVO BkgChgRtVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgChgRt(BkgChgRtVO bkgChgRtVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgChgRtVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgChgRtVOs List<BkgChgRtVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgChgRt(List<BkgChgRtVO> bkgChgRtVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, RT_SEQ)
			 for (int i=0; i<bkgChgRtVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgChgRtVOs.get(i).getBkgNo()
				                          +"', '"+bkgChgRtVOs.get(i).getRtSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgChgRtRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgDgCgoVO BkgDgCgoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgDgCgo(BkgDgCgoVO bkgDgCgoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgDgCgoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgDgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgDgCgoVOs List<BkgDgCgoVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgDgCgo(List<BkgDgCgoVO> bkgDgCgoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, DCGO_SEQ)
			 for (int i=0; i<bkgDgCgoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgDgCgoVOs.get(i).getBkgNo()
				                          +"', '"+bkgDgCgoVOs.get(i).getDcgoSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgDgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgRfCgoVO BkgRfCgoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgRfCgo(BkgRfCgoVO bkgRfCgoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgRfCgoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgRfCgoVOs List<BkgRfCgoVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgRfCgo(List<BkgRfCgoVO> bkgRfCgoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, RC_SEQ)
			 for (int i=0; i<bkgRfCgoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgRfCgoVOs.get(i).getBkgNo()
				                          +"', '"+bkgRfCgoVOs.get(i).getRcSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgRfCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgAwkCgoVO BkgAwkCgoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgAwkCgo(BkgAwkCgoVO bkgAwkCgoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgAwkCgoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgAwkCgoVOs List<BkgAwkCgoVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgAwkCgo(List<BkgAwkCgoVO> bkgAwkCgoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, AWK_CGO_SEQ)
			 for (int i=0; i<bkgAwkCgoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgAwkCgoVOs.get(i).getBkgNo()
				                          +"', '"+bkgAwkCgoVOs.get(i).getAwkCgoSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgAwkCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBbCgoVO BkgBbCgoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgBbCgo(BkgBbCgoVO bkgBbCgoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBbCgoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgBbCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBbCgoVOs List<BkgBbCgoVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgBbCgo(List<BkgBbCgoVO> bkgBbCgoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, BB_CGO_SEQ)
			 for (int i=0; i<bkgBbCgoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgBbCgoVOs.get(i).getBkgNo()
				                          +"', '"+bkgBbCgoVOs.get(i).getBbCgoSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgBbCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgXptImpLicVO BkgXptImpLicVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgXptImpLic(BkgXptImpLicVO bkgXptImpLicVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgXptImpLicVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgXptImpLicVOs List<BkgXptImpLicVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgXptImpLic(List<BkgXptImpLicVO> bkgXptImpLicVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, IO_BND_CD, XPT_IMP_SEQ)
			 for (int i=0; i<bkgXptImpLicVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgXptImpLicVOs.get(i).getBkgNo()
				                          +"', '"+bkgXptImpLicVOs.get(i).getIoBndCd()
				                          +"', '"+bkgXptImpLicVOs.get(i).getXptImpSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgXptImpLicRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgHblVO BkgHblVO
	 * @param  String caFlg
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgHbl(BkgHblVO bkgHblVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgHblVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgHblRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgHblVOs List<BkgHblVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgHbl(List<BkgHblVO> bkgHblVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, HBL_SEQ)
			 for (int i=0; i<bkgHblVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgHblVOs.get(i).getBkgNo()
				                          +"', '"+bkgHblVOs.get(i).getHblSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgHblRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgHblCustVO BkgHblCustVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgHblCust(BkgHblCustVO bkgHblCustVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgHblCustVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgHblCustVOs List<BkgHblCustVO>
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgHblCust(List<BkgHblCustVO> bkgHblCustVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, HBL_SEQ, BKG_CUST_TP_CD)
			 for (int i=0; i<bkgHblCustVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgHblCustVOs.get(i).getBkgNo()
				                          +"', '"+bkgHblCustVOs.get(i).getHblSeq()
				                          +"', '"+bkgHblCustVOs.get(i).getBkgCustTpCd()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgHblCustRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param  bkgBlIssVO BkgBlIssVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgBlIss(BkgBlIssVO bkgBlIssVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlIssVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
	        } catch(SQLException ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0649)<br>
	 *
	 * @author Jeon SungJin
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgDocIssRdemVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgDocIssRdemVO> searchBkgDocIssRdem(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgDocIssRdemVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchBkgDocIssRdemRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocIssRdemVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0649)<br>
	 *
	 * @author Jeon SungJin
	 * @param  bkgDocIssRdemVO BkgDocIssRdemVO
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgDocIssRdem(BkgDocIssRdemVO bkgDocIssRdemVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgDocIssRdemVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgDocIssRdemRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
	        } catch(SQLException ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
		 
		 return list;
    }    
    
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0649)<br>
	 *
	 * @author Jeon SungJin
	 * @param  List<BkgDocIssRdemVO> bkgDocIssRdemVOs
	 * @param  bkgNo String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgDocIssRdem(List<BkgDocIssRdemVO> bkgDocIssRdemVOs, String bkgNo) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, CNTR_NO)
			 for (int i=0; i<bkgDocIssRdemVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgDocIssRdemVOs.get(i).getBkgNo()
				                          +"', '"+bkgDocIssRdemVOs.get(i).getHisSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgDocIssRdemRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
    
    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     * Booking History DTL 저장 (ESM_BKG_0566)
     * 
     * @author Lee NamKyung
     * @param  bkgHisDtlVOs List<BkgHisDtlVO>
     * @exception DAOException
     */
    public void addBkgHisDtl(List<BkgHisDtlVO> bkgHisDtlVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(bkgHisDtlVOs.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingHistoryMgtDBDAOAddBkgHisDtlCSQL(), bkgHisDtlVOs, null);
                for(int i = 0; i < insCnt.length; i++) {
                    if(insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     * Booking History DTL 저장 (ESM_BKG_0566)
     * 
     * @author Lee NamKyung
     * @param  bkgDocProcTpCd String
     * @param  bkgNo String
     * @param  account SignOnUserAccount
     * @exception DAOException
     */
    public void cancelBkgDocProcSkd(String bkgDocProcTpCd, String bkgNo, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            param.put   ("bkg_doc_proc_tp_cd", bkgDocProcTpCd);
            param.put   ("bkg_no", bkgNo);
            param.put   ("upd_usr_id", account.getUsr_id());
            
            velParam.put("bkg_doc_proc_tp_cd", bkgDocProcTpCd);
            velParam.put("bkg_no", bkgNo);
            velParam.put("upd_usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 단건의 데이터를 생성한다.<br>
     * Booking Line History : Bkg_DOC_PROC_SKD 저장 (ESM_BKG_0566)
     * 
     * @author Lee NamKyung
     * @param  bkgDocProcSkdVO BkgDocProcSkdVO 
     * @exception DAOException
     */
    public void addBkgDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgDocProcSkdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Booking Line History : Bkg_HIS_DTL 저장 (ESM_BKG_0566)
     * 
     * @author Lee NamKyung
     * @param  bkgHisDtlVO BkgHisDtlVO
     * @exception DAOException
     */
    public void addBkgHisDtlLine(BkgHisDtlVO bkgHisDtlVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgHisDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Booking Line History : BKG_MF_CSTMS_HIS 저장 (ESM_BKG_0566)
     * 
     * @author Lee NamKyung
     * @param  BkgMfCstmsHisVO bkgMfCstmsHisVO
     * @exception DAOException
     */
    public void addCustomsHistory(BkgMfCstmsHisVO bkgMfCstmsHisVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgMfCstmsHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOAddCustomsHistoryCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_0076, ESM_BKG_0099 : last container final confirm Status 조회
     * @author Ryu Dae Young
     * @param  bkgBlNoVO BkgBlNoVO
     * @return String 
     * @exception DAOException
     */
	public String searchCntrFinalConfirm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();		 
		
		 try{
			 param.put   ("bkg_no", bkgBlNoVO.getBkgNo()); 
			
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOsearchCntrFinalConfirmRSQL(), param, velParam);	
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("bkg_doc_proc_tp_cd");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return strReturn;
	}
    
    /**
     * Booking History : C/A No Update<br>
	 * : history에 corr_no = 'TMP0000001'인 row를 새로 지정된 corr_no로 update한다.<br>
     * 
     * @author Lee NamKyung
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
    public void modifyCaCorrNoForHistory(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOModifyCaCorrNoForHistoryUSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 미주 terminal edi 전송시 별도 ack를 받기 위한 table에 insert한다.
     * 
     * @author Ryu DaeYoung
     * @param  bkgTmlEdiHisVO BkgTmlEdiHisVO 
     * @param  String usrId
     * @exception DAOException
     */
	public void addBkgTmlEdiHis(BkgTmlEdiHisVO bkgTmlEdiHisVO, String usrId) throws DAOException {	    
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgTmlEdiHisVO.getColumnValues();
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOaddBkgTmlEdiHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

	/**
	 * BKG_TML_EDI_HIS테이블에 Ack정보 수정.(UBIZ_BKG_USTMNL_ACK)<br>
	 *
	 * @author 	Jun Yong Jin
	 * @param 	bkgTmlEdiHisVO BkgTmlEdiHisVO
	 * @exception 	DAOException
	 */
	public void receiptUsaTmlEdiAck(BkgTmlEdiHisVO bkgTmlEdiHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgTmlEdiHisVO != null){
				Map<String, String> mapVO = bkgTmlEdiHisVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingHistoryMgtDBDAOreceiptUsaTmlEdiAckUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
    /**
     * BKG_HIS_DTL 테이블의 특정Bkg_no의 중복되는 history를 삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
	public void removeCorrDupHistory(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOremoveCorrDupHistoryDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		
	}
	
    /**
     * 미세관 AI 전송 FLAG 판단 정보 조회 <br>
     *  미세관 MI 전송 유무, US FILER, CA FILER
     * @param  bkgNo String
     * @return List<BkgCstmsAdvBlVO>
     * @exception DAOException
     */
    public List<BkgCstmsAdvBlVO> searchAmsAiDecisionInfo (String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        List<BkgCstmsAdvBlVO> list = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOsearchAmsAiDecisionInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
            
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
    }
    	
	
	 /**
     * ai 전송 대상 Flag 를 업데이트 한다.<br>
     * 
     * @param  String mfNo
     * @param  BkgDocProcSkdVO bkgDocProcSkdVO
     * @exception DAOException
     */
    public void updateAIFlagCancelBkgDocProcSkd(String mfNo, BkgDocProcSkdVO bkgDocProcSkdVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	
			 Map<String, String> mapVO = bkgDocProcSkdVO.getColumnValues();
			 param.putAll(mapVO);
             param.put   ("mf_no", mfNo);
             
			 velParam.putAll(mapVO);
             velParam.put("mf_no", mfNo);
        	
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOupdateAIFlagCancelBkgDocProcSkdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * BKG_DOC_PROC_SKD 테이블의 CA ISSUE 생긴 BKG을 삭제한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
    public void removeAIFlagBkgDocProcSkd(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOremoveAIFlagBkgDocProcSkdDSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    
    
    /**
     * BKG_DOC_PROC_SKD 테이블의 CA ISSUE로 생성된 BKG을 CA CONFIRM 상태로 업데이트 한다.<br>
     * 
     * @param  bkgBlNoVO BkgBlNoVO
     * @exception DAOException
     */
    public void modifyCACnfAIFlagBkgDocProcSkd(BkgBlNoVO bkgBlNoVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOmodifyCACnfAIFlagBkgDocProcSkdUSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }         
    
	/**
	 * Split source booking의 history의 correction no를 변경한다<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String lstCorrNo
	 * @throws DAOException
	 */
	public void modifyCorrNo(BkgBlNoVO bkgBlNoVO, String lstCorrNo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
            param.put   ("lst_corr_no", lstCorrNo);
            
			velParam.putAll(mapVO);            
            velParam.put("lst_corr_no", lstCorrNo);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOModifyCorrNoUSQL(), param, velParam);
            
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }		
	}     
	/**
	 * Booking History 저장 : 이전 history 보관 (ESM_BKG_0566)<br>
	 *
	 * @author Lee NamKyung
	 * @param bkgBlNoVO BkgBlNoVO
	 * @return List<BkgStwgCgoVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<BkgStwgCgoVO> searchBkgStwgCgo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<BkgStwgCgoVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchTempBkgStwgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgStwgCgoVO.class);			 
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }
	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0090)<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgStwgCgoVO bkgStwgCgoVO
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistBkgStwgCgo(BkgStwgCgoVO bkgStwgCgoVO, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgStwgCgoVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	
			 
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    }

	/**
	 * Booking History 저장 : 변경사항 체크 조회 (ESM_BKG_0090)<br>
	 *
	 * @author Lee NamKyung
	 * @param  List<BkgStwgCgoVO> bkgStwgCgoVOs
	 * @param  bkgNo String
	 * @param  caFlg String
	 * @return List<HistCtntVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<HistCtntVO> searchHistNewBkgStwgCgo(List<BkgStwgCgoVO> bkgStwgCgoVOs, String bkgNo, String caFlg) throws DAOException {
		 DBRowSet dbRowset = null;		 
		 List<HistCtntVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{			 
			 ArrayList<String> arrString = new ArrayList();  //(BKG_NO, AWK_CGO_SEQ)
			 for (int i=0; i<bkgStwgCgoVOs.size(); i++) {	
				 String strRefSeqId = "('"+bkgStwgCgoVOs.get(i).getBkgNo()
				                          +"', '"+bkgStwgCgoVOs.get(i).getStwgSeq()+"')";
				 arrString.add(strRefSeqId);
			 }
			 param.put   ("bkg_no", bkgNo);
			 velParam.put("field_list", arrString);
			 param.put   ("ca_flg", caFlg); 
			 velParam.put("ca_flg", caFlg);	
			 
			 dbRowset = new SQLExecuter().executeQuery(new BookingHistoryMgtDBDAOSearchHistNewBkgStwgCgoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistCtntVO.class);	

		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
    } 
}
