/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdiTransmitHistoryDBDAO.java
 *@FileTitle : DG EDI Transmit History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.15
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.10.15 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.DgEdiFltFileVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendDgEdiHeaderInfoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic.EdiTransmitHistoryBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration.ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 *  EdiTransmitHistoryDBDAO <br>
 *  EDI HISTORY.<br>
 * 
 * @author DONG SOO YANG
 * @see EdiTransmitHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class ScgUtilDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	
	/**
	 *  searchSendEdiHeader
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendDgEdiHeaderInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendDgEdiHeaderInfoVO> searchSendEdiHeader(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendDgEdiHeaderInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScgUtilEAIDAOSearchEdiSendHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendDgEdiHeaderInfoVO .class);
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
	 * SCG_PRNR_SPCL_CGO_FLT_FILE 데이터를 생성한다.<br>
	 * 
	 * @param DgEdiFltFileVO excVO
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoFltFile(DgEdiFltFileVO excVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = excVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScgUtilDBDAOAddScgPrnrSpclCgoFltFileCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	

	 /**
	 * SCG_PRNR_SPCL_CGO_FLT_FILE 데이터를 생성한다.<br>
	 * 
	 * @param DgEdiFltFileVO excVO
	 * @exception DAOException
	 */
	public void modifyScgPrnrSpclCgoFltFile(DgEdiFltFileVO excVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = excVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ScgUtilDBDAOModifyScgPrnrSpclCgoFltFileUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	 /**
	 * SCG_PRNR_SPCL_CGO_FLT_FILE 데이터 생성여부 조회한다.<br>
	 * 
	 * @param DgEdiFltFileVO excVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkPrnrSpclCgoFltFileExist(DgEdiFltFileVO excVO) throws DAOException {
		
		DBRowSet dbRowset			= null;
		boolean	isExistFlatFileLog 	= false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(excVO == null)	return	false;
			
			param.putAll(excVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScgUtilDBDAOCheckPrnrSpclCgoFltFileExistRSQL(), param, null);
			if(dbRowset.next())		isExistFlatFileLog	= true;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExistFlatFileLog;
	 }	
}

