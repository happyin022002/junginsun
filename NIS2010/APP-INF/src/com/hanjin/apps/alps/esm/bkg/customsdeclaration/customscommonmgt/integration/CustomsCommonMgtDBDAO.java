/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtDBDAO.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.09 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.sql.SQLException; 
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS CustomsCommonMgtDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author YoungHeon Lee
 * @see CustomsCommonMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomsCommonMgtDBDAO extends DBDAOSupport {
	
	/**
	 * Country Code, Customs Division ID, Customs Code Description 등의 정보를 조회해온다.<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws DAOException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvDescList(CstmsCdConvVO cstmsCdConvVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CstmsCdConvVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(cstmsCdConvVO != null){
					Map<String, String> mapVO = cstmsCdConvVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOsearchCstmsCdConvDescListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsCdConvVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * sheet2에서 sheet1의 Country Code, Customs Division ID에 대한 Attribute Content의 정보를 조회해온다.<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws DAOException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvCtntList(CstmsCdConvVO cstmsCdConvVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CstmsCdConvVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(cstmsCdConvVO != null){
					Map<String, String> mapVO = cstmsCdConvVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOsearchCstmsCdConvCtntListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsCdConvVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * Country Code, Customs Division ID, Customs Code Description 등의 정보를 입력한다.<br>
	 * @param List<CstmsCdConvVO> insertVoList
	 * @throws DAOException
	 */
	public void addCstmsCdConvDesc(List<CstmsCdConvVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOaddCstmsCdConvDescCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Customs Division ID, Customs Code Description 등의 정보를 수정한다.<br>
	 * @param List<CstmsCdConvVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyCstmsCdConvDesc(List<CstmsCdConvVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOmodifyCstmsCdConvDescUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Customs Division ID, Customs Code Description 등의 정보를 삭제한다.<br>
	 * @param List<CstmsCdConvVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeCstmsCdConvDesc(List<CstmsCdConvVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOremoveCstmsCdConvDescDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * sheet1과 sheet2의 Country Code, Customs Division ID에 대한 정보를 삭제한다.<br>
	 * @param List<CstmsCdConvVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeCstmsCdConvDescCtnt(List<CstmsCdConvVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOremoveCstmsCdConvDescCtntDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * sheet2에서 sheet1의 Country Code, Customs Division ID에 대한 Attribute Content의 정보를 입력한다.<br>
	 * @param List<CstmsCdConvVO> insertVoList
	 * @throws DAOException, Exception
	 */
	public void addCstmsCdConvCtnt(List<CstmsCdConvVO> insertVoList) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        CstmsCdConvVO cstmsCdConvVO = null;
        
        int result = 0;
        
        try {
        	for(int i = 0; i < insertVoList.size(); i++) {
        	
        		cstmsCdConvVO = insertVoList.get(i);
	        	if(cstmsCdConvVO != null) {
		            Map<String, String> mapVO = cstmsCdConvVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CustomsCommonMgtDBDAOaddCstmsCdConvCtntCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getMessage());
	            }
        	} // end for(i)
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
	
	/**
	 * sheet2에서 sheet1의 Country Code, Customs Division ID에 대한 Attribute Content의 정보를 수정한다.<br>
	 * @param List<CstmsCdConvVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyCstmsCdConvCtnt(List<CstmsCdConvVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOmodifyCstmsCdConvCtntUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * sheet2에서 sheet1의 Country Code, Customs Division ID에 대한 Attribute Content의 정보를 삭제한다.<br>
	 * @param List<CstmsCdConvVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeCstmsCdConvCtnt(List<CstmsCdConvVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOremoveCstmsCdConvCtntDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Customs Division ID의 중복 Data 유무를 조회한다.<br>
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @return String
	 * @throws DAOException
	 */
	public DBRowSet checkCstmsCdConvDesc(String cntCd, String cstmsDivId) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(cntCd != null){
					param.put("cnt_cd"    ,cntCd);
					
				}
				if(cstmsDivId != null){
					param.put("cstms_div_id"    ,cstmsDivId);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOcheckCstmsCdConvDescRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
//				throw new DAOException(new ErrorHandler(se).getMessage());	
				throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 등의 정보를 조회해온다.<br>
	 * @param CstmsPckTpConvVO cstmsPckTpConvVO
	 * @return List<CstmsPckTpConvVO>
	 * @throws DAOException
	 */
	public List<CstmsPckTpConvVO> searchCstmsPckTpConvList(CstmsPckTpConvVO cstmsPckTpConvVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CstmsPckTpConvVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(cstmsPckTpConvVO != null){
					Map<String, String> mapVO = cstmsPckTpConvVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOsearchCstmsPckTpConvListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsPckTpConvVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 등의 정보를 입력한다.<br>
	 * @param List<CstmsPckTpConvVO> insertVoList
	 * @throws DAOException
	 */
	public void addCstmsPckTpConv(List<CstmsPckTpConvVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOaddCstmsPckTpConvCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 등의 정보를 수정한다.<br>
	 * @param List<CstmsPckTpConvVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyCstmsPckTpConv(List<CstmsPckTpConvVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOmodifyCstmsPckTpConvUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 등의 정보를 삭제한다.<br>
	 * @param List<CstmsPckTpConvVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeCstmsPckTpConv(List<CstmsPckTpConvVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOremoveCstmsPckTpConvDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 세 항목의 중복 Data 유무를 조회한다.<br>
	 * @param String cntCd
	 * @param String pckTpCd
	 * @param String cstmsPckTpCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkCstmsPckTpConv(String cntCd, String pckTpCd, String cstmsPckTpCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(cntCd != null){
					param.put("cnt_cd"    ,cntCd);
					
				}
				if(pckTpCd != null){
					param.put("pck_tp_cd"    ,pckTpCd);
					
				}
				if(cstmsPckTpCd != null){
					param.put("cstms_pck_tp_cd"    ,cstmsPckTpCd);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOcheckCstmsPckTpConvRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
//				throw new DAOException(new ErrorHandler(se).getMessage());	
				throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Country Code, Package Type Code, Customs Package Type Code 세 항목의 중복 Data 유무를 조회한다.<br>
	 * @param String pckTpCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkPckTpCd(String pckTpCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(pckTpCd != null){
					param.put("pck_tp_cd"    ,pckTpCd);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOcheckPckTpCdRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
//				throw new DAOException(new ErrorHandler(se).getMessage());	
				throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}

	/**
	 * Country Code, Customs Error Code 등의 정보를 조회해온다.<br>
	 * @param CstmsErrCdVO cstmsErrCdVO
	 * @return List<CstmsErrCdVO>
	 * @throws DAOException
	 */
	public List<CstmsErrCdVO> searchCstmsAdvErrList(CstmsErrCdVO cstmsErrCdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CstmsErrCdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(cstmsErrCdVO != null){
					Map<String, String> mapVO = cstmsErrCdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOsearchCstmsAdvErrListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsErrCdVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	/**
	 * Country Code, Customs Error Code 등의 정보를 입력한다.
	 * @param List<CstmsErrCdVO> insertVoList
	 * @throws DAOException
	 */
	public void addCstmsAdvErr(List<CstmsErrCdVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOaddCstmsAdvErrCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * Country Code, Customs Error Code 등의 정보를 수정한다.
	 * @param List<CstmsErrCdVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyCstmsAdvErr(List<CstmsErrCdVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOmodifyCstmsAdvErrUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Customs Error Code 등의 정보를 삭제한다.
	 * @param List<CstmsErrCdVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeCstmsAdvErr(List<CstmsErrCdVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsCommonMgtDBDAOremoveCstmsAdvErrDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country Code, Customs Error Code의 중복 Data 유무를 조회한다.<br>
	 * @param String cntCd
	 * @param String cstmsErrCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkCstmsAdvErr(String cntCd, String cstmsErrCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(cntCd != null){
					param.put("cnt_cd"    ,cntCd);
					
				}
				if(cstmsErrCd != null){
					param.put("cstms_err_cd"    ,cstmsErrCd);
					
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsCommonMgtDBDAOcheckCstmsAdvErrRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}

	/**
	 * EDI수신오류 시 메일전송 목록 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return List<CstmsEmlNtfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<CstmsEmlNtfcVO> searchCstmsEmlNtfcList(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstmsEmlNtfcVO != null) {
				Map<String, String> mapVO = cstmsEmlNtfcVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomsCommonMgtDBDAOsearchCstmsEmlNtfcListRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsEmlNtfcVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
}