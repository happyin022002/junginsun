/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBCDBDAO.java
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogDtlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogHdrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.FtpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBKgVvdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBkgRootVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelCMVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelDGVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelRFVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS EmptyReleaseOrderBCDBDAO <br>
 * - OPUS-OutboundBLMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Jin Seo
 * @see EmptyReleaseOrderBCBCImpl 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseOrderDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -967202402232355851L;

	/**
	 * EmptyReleaseOrderBCDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */

	/**
	 * Simple 조회 이벤트 처리 ESM_BKG_0252<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Simple type으로 조회한다.
	 * 
	 * @param MtyRlseOrdInVO mtyRlseOrdIn
	 * @author Choi Do Soon
	 * @return List<MtyRlseOrdSimpleOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdSimpleOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL();
	      	dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdSimpleOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

	 /**
	  * Detail 조회 이벤트 처리 ESM_BKG_0252<br>
	  * 
	  * Empty Release Order를 내기 위해 booking list를 Detail(s) type으로 조회한다.
	  * 
	  * @param MtyRlseOrdInVO mtyRlseOrdIn
	  * @author Choi Do Soon
	  * @return List<MtyRlseOrdDetailOutVO>
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdDetailOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL();
	        dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdDetailOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

	/**
	 * Detail(USA) 조회 이벤트 처리 ESM_BKG_0252<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Detail(s) USA type으로 조회한다.
	 * 
	 * @param MtyRlseOrdInVO mtyRlseOrdIn
	 * @author Choi Do Soon
	 * @return List<MtyRlseOrdUsaOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdUsaOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL();
	        dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdUsaOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

	/**
	 * Empty Container Release Order Excel Download
	 * @param mtyRlseOrdInVO
	 * @return
	 * @throws DAOException
	 */
	public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO) throws DAOException {
		DBRowSet dbRowset = null;
	    List<?> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
	        Map<String, String> mapVO =  mtyRlseOrdInVO.getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        /* BKG_ROOT */
	        if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 1){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBkgRootVO.class);
	        }
	        /* BKG_QTY */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 2){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBkgQtyVO.class);
	        }
	        /* CNTR */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 3){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelCntrVO.class);
	        }
	        /* BKG_VVD */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 4){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBKgVvdVO.class);
	        }
	        /* DG */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 5){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdDGRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelDGVO.class);
	        }
	        /* CM */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 6){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdCMRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelCMVO.class);
	        }
	        /* RF_OOG */
	        else if(Integer.parseInt(mtyRlseOrdInVO.getExcelSeq()) == 7){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdRfOogRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelRFVO.class);
	        }
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param mtyRlseOrdInVO
	 * @param int excelNumber
	 * @return List<?>
	 * @throws DAOException
	 */
	public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO, int excelNumber) throws DAOException {
		DBRowSet dbRowset = null;
	    List<?> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
	        Map<String, String> mapVO =  mtyRlseOrdInVO.getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        /* BKG_ROOT */
	        if(excelNumber == 1){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBkgRootVO.class);
	        }
	        /* BKG_QTY */
	        else if(excelNumber == 2){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBkgQtyVO.class);
	        }
	        /* CNTR */
	        else if(excelNumber == 3){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelCntrVO.class);
	        }
	        /* BKG_VVD */
	        else if(excelNumber == 4){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelBKgVvdVO.class);
	        }
	        /* DG */
	        else if(excelNumber == 5){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdDGRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelDGVO.class);
	        }
	        /* CM */
	        else if(excelNumber == 6){
	        	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOMtyRlseOrdCMRSQL(), param, velParam);
	        	 list = (List<?>) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdExcelCMVO.class);
	        }
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param String hrdCdgId
	 * @return List<FtpInfoVO>
	 * @throws DAOException
	 */
	public List<FtpInfoVO> sendMtyRlseOrdByFTP(String hrdCdgId) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<FtpInfoVO> list = null;
	    String ftpSeq = "";
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  new HashMap<String, String>();

            mapVO.put("hrd_cdg_id", hrdCdgId);
	        
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

			dbRowset = exec.executeQuery((ISQLTemplate) new EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) ftpSeq = dbRowset.getString(1);
	        
	      	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOsearchFtpInfoRSQL(), param, velParam);
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, FtpInfoVO.class);
	        
	        for (int i=0; i < list.size(); i++) {
		        list.get(i).setFileSeq(ftpSeq);
	        }

	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    
        return list;
	}		
	
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param String sendDate
	 * @param FtpInfoVO ftpInfoVO
	 * @param String fileName
	 * @param String ftpYn
     * @param String usrId
	 * @throws DAOException
	 */
	public void createLodFctrDlLogHdr(String sendDate, FtpInfoVO ftpInfoVO, String fileName, String ftpYn, String usrId) throws DAOException {
        int result = 0;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  new HashMap<String, String>();

            mapVO.put("ldf_dl_dt", sendDate);
            mapVO.put("bkg_ofc_cd", ftpInfoVO.getOfcCd());
            mapVO.put("bkg_fm_dt", ftpInfoVO.getFromDt());
            mapVO.put("bkg_to_dt", ftpInfoVO.getEndDt());
            mapVO.put("file_dl_nm", fileName);
            mapVO.put("file_dl_flg", ftpYn);
            mapVO.put("usr_id", usrId);
	        
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        
	        SQLExecuter exec = new SQLExecuter("DEFAULT");
	        result = exec.executeUpdate((ISQLTemplate) new EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

	    }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}			
	
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param String sendDate
	 * @param String ofcCd
	 * @param String bkgNo
     * @param String usrId
	 * @throws DAOException
	 */
	public void createLodFctrDlLogDtl(String sendDate, String ofcCd, String bkgNo, String usrId) throws DAOException {
        int result = 0;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  new HashMap<String, String>();

            mapVO.put("ldf_dl_dt", sendDate);
            mapVO.put("bkg_ofc_cd", ofcCd);
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("usr_id", usrId);
	        
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter exec = new SQLExecuter("DEFAULT");
	        result = exec.executeUpdate((ISQLTemplate) new EmptyReleaseOrderDBDAOcreateLodFctrDlLogDtlCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}			
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param BkgLodFctrDlLogHdrVO logHdrVO
	 * @return List<BkgLodFctrDlLogHdrVO>
	 * @throws DAOException
	 */
	public List<BkgLodFctrDlLogHdrVO> searchBkgLodFctrDlLogHdr(BkgLodFctrDlLogHdrVO logHdrVO) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<BkgLodFctrDlLogHdrVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  logHdrVO.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	      	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL(), param, velParam);
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgLodFctrDlLogHdrVO.class);
	        
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    
        return list;
	}

	/**
	 * Empty Container Release Order Excel Download
	 * @param BkgLodFctrDlLogHdrVO logHdrVO
	 * @return List<BkgLodFctrDlLogDtlVO>
	 * @throws DAOException
	 */
	public List<BkgLodFctrDlLogDtlVO> searchBkgLodFctrDlLogDtl(BkgLodFctrDlLogHdrVO logHdrVO) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<BkgLodFctrDlLogDtlVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  logHdrVO.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	      	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL(), param, velParam);
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgLodFctrDlLogDtlVO.class);
	        
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    
        return list;
	}

	/**
	 * Empty Container Release Order Excel Download
     * @param String hrdCdgId
	 * @return List<FtpInfoVO>
	 * @throws DAOException
	 */
	public List<FtpInfoVO> sendMtyRlseOrdByFTPRetry(String hrdCdgId) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<FtpInfoVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  new HashMap<String, String>();

            mapVO.put("hrd_cdg_id", hrdCdgId);

            param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	      	dbRowset = exec.executeQuery(new EmptyReleaseOrderDBDAOsearchFtpInfoRetryRSQL(), param, velParam);
	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, FtpInfoVO.class);
	        
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    
        return list;
	}		
	
	/**
	 * Empty Container Release Order Excel Download
	 * @param String ldfDlDt
	 * @param String bkgOfcCd
	 * @param String ftpYn
     * @param String usrId
	 * @throws DAOException
	 */
	public void modifyLodFctrDlLog(String ldfDlDt, String bkgOfcCd, String ftpYn, String usrId) throws DAOException {
        int result = 0;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	        Map<String, String> mapVO =  new HashMap<String, String>();

            mapVO.put("ldf_dl_dt", ldfDlDt);
            mapVO.put("bkg_ofc_cd", bkgOfcCd);
            mapVO.put("file_dl_flg", ftpYn);
            mapVO.put("usr_id", usrId);
	        
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        
	        SQLExecuter exec = new SQLExecuter("DEFAULT");
	        result = exec.executeUpdate((ISQLTemplate) new EmptyReleaseOrderDBDAOupdateLodFctrDlLogHrdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

	    }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}			
	
}