/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsMasterMgtDBDAO.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.CustomsMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  CustomsMasterMgtDBDAO <br>
 * - BookingMasterDataSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Gyoung Sub
 * @see CustomsMasterMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomsMasterMgtDBDAO extends DBDAOSupport {

	/**
	  * 0354 Canada ACI: Location of Goods Setup - Loc Code 을 조회합니다.<br>
	  * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	  * @return List<BkgcustomscanadagrouplocationVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkgcustomscanadagrouplocationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = bkgcustomscanadagrouplocationVO .getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsMasterMgtDBDAOSearchcustomsGroupLocationRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgcustomscanadagrouplocationVO .class);
			 
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
	  * 0354 Canada ACI: Location of Goods Setup - Loc Code 생성/수정을 위한 기존 데이타를 조회합니다.<br>
	  * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	  * @return List<BkgcustomscanadagrouplocationVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD2(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkgcustomscanadagrouplocationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = bkgcustomscanadagrouplocationVO .getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsMasterMgtDBDAOSearchcustomsGroupLocation2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgcustomscanadagrouplocationVO.class);
			 
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
	 *  0354 Canada ACI: Location of Goods - Loc Code을 생성합니다.<br>
	 * 
	 * @param List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO
	 * @exception DAOException
	 */
	public void addLocCode(List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO) throws DAOException,Exception {
		manageLocCode(bkgcustomscanadagrouplocationVO,"C");
	}
	
	
	/**
	 *  0354 Canada ACI: Location of Goods - Loc Code을 수정합니다.<br>
	 * 
	 * @param List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO
	 * @exception DAOException
	 */
	public void modifyLocCode(List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO) throws DAOException,Exception {
		manageLocCode(bkgcustomscanadagrouplocationVO,"U");
	}
	
	/**
	 *  0354 Canada ACI: Location of Goods - Loc Code 을 삭제합니다.<br>
	 * 
	 * @param List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO
	 * @exception DAOException
	 */
	public void removeLocCode(List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO) throws DAOException,Exception {
		manageLocCode(bkgcustomscanadagrouplocationVO,"D");
	}
	
	/**
	 *  0354 Canada ACI: Location of Goods - Loc Code을 Location of Goods을 트랜잭션 처리합니다.<br>
	 * 
	 * @param List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO
	 * @param String cudGubun
	 * @exception DAOException
	 */
	public void manageLocCode(List<BkgcustomscanadagrouplocationVO> bkgcustomscanadagrouplocationVO, String cudGubun) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(bkgcustomscanadagrouplocationVO.size() > 0){
				
				if (cudGubun.equals("C") || cudGubun.equals("U")){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsMasterMgtDBDAOManageLocCodeUSQL(), bkgcustomscanadagrouplocationVO,null);
					
				}else if (cudGubun.equals("D")){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new CustomsMasterMgtDBDAORemoveLocCodeDSQL(), bkgcustomscanadagrouplocationVO,null);
				}
				
				for(int i = 0; updCnt != null && i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String searchYardDesc(BkgcustomscanadagrouplocationVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ydNm = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = inputVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsMasterMgtDBDAOSearchYardDescRSQL(), param, velParam);
			if(dbRowset.next()){
				ydNm = dbRowset.getString("YD_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ydNm;
	}
	
	/**
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String searchLocDesc(BkgcustomscanadagrouplocationVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String locNm = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = inputVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomsMasterMgtDBDAOSearchLocDescRSQL(), param, velParam);
			if(dbRowset.next()){
				locNm = dbRowset.getString("LOC_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locNm;
	}	

}
