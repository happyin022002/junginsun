/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityDAO.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.28 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.primasterdata.commodity.basic.CommodityBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  CommodityDAO <br>
 * - PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see CommodityBCImpl 참조
 * @since J2EE 1.4
 */
public class CommodityDBDAO extends DBDAOSupport {

	/**
	 * Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParmVO
	 * @return List<RsltCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCmdtListVO> searchCommodityList(CmdtParaVO cmdtParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParmVO != null){
				Map<String, String> mapVO = cmdtParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAORsltCmdtListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCmdtListVO .class);
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
	 * Rep Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParmVO
	 * @return List<RsltRepCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRepCmdtListVO> searchRepCommodityList(CmdtParaVO cmdtParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRepCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParmVO != null){
				Map<String, String> mapVO = cmdtParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAORsltRepCmdtListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRepCmdtListVO .class);
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
	 * SG Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriSgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * SG Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchSgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriSgGrpCmdtDtlVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * RG Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriRgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * RG Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchRgGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriRgGrpCmdtDtlVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * SP SCOPE Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriSpScpGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * SP SCOPE Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchSpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriSpScpGrpCmdtDtlVORSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * RP SCOPE Group Commodity List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriRpScpGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * RP SCOPE Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchRpScpGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriRpScpGrpCmdtDtlVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	  * Surcharge Group Commodity List를 조회한다. <br>
	  * 
	  * @param CmdtParaVO cmdtParaVO
	  * @return List<RsltGrpCmdtListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityList(CmdtParaVO cmdtParaVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<RsltGrpCmdtListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(cmdtParaVO != null){
				 Map<String, String> mapVO = cmdtParaVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			                                                              
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriScgGrpCmdtVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * Surcharge Group Commodity Detail List를 조회한다. <br>
	 * 
	 * @param CmdtParaVO cmdtParaVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchSurchargeGroupCommodityDetailList(CmdtParaVO cmdtParaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmdtParaVO != null){
				Map<String, String> mapVO = cmdtParaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOPriScgGrpCmdtDtlRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
 
 
 
 
		 
}
