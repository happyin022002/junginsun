/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTFindCodeDBDAO.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic.TOTFindCodeBCImpl;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS TOTFindCodeDBDAO <br>
 * - ALPS-TOTCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Chang Soo
 * @see TOTFindCodeBCImpl 참조
 * @since J2EE 1.6
 */
public class TOTFindCodeDBDAO extends DBDAOSupport {

	 
	/**
	 * 해당 선박코드의 vessel name 과 계약일자 데이터를 조회한다.  <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslVO> searchFmsVslInfo(VslVO vslVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslVO != null){
				Map<String, String> mapVO = vslVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0001 DAQ > search recent dt진입:::::::::");
            TOTFindCodeDBDAODeliveryNRedeliveryVORSQL template = new TOTFindCodeDBDAODeliveryNRedeliveryVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

		/**
		 * 해당년월의 마감여부를 조회한다. <br>
		 * 
		 * @param String isYear
		 * @return List<TotStlClzVO>
		 * @exception DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<TotStlClzVO> searchStlClosing(String isYear) throws DAOException {
		DBRowSet dbRowset = null;
		List<TotStlClzVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("stl_yr", isYear);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate)new TOTFindCodeDBDAOTotStlClzVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotStlClzVO .class);
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
		 * lane에 해당하는 trade code를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTrdCodeByLaneList(TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTrdCodeByLaneRSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
*/
		/**
		 * 해당하는 trade code를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTradeCodeList(TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTpCdRSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * BSA 정보의 tax 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
		 * 
		 * @param MdmLaneVO mdmLaneVO
		 * @return List<MdmLaneVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<MdmLaneVO> searchLaneCheckList(MdmLaneVO mdmLaneVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MdmLaneVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (mdmLaneVO != null) {
					 Map<String, String> mapVO = mdmLaneVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOMdmRevLaneVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLaneVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * pendlum lane을 조회한다.  <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchPLaneCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOPlaneVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * pendlum lane에 해당하는 trade를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchPLaneTrdCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOPlaneTradeVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * pendlum lane에 해당하는 trade를 조회한다.  <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchPLaneDistinctTrdCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOPlaneDistinctTradeVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * BSA lane을 조회한다.  <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchBsaLaneCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOBsaLaneVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * BSA lane에 해당하는 trade를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchBsaTrdCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOBsaTrdVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

	    
		/**
		 * 해당 시작일자 종료일자 lane, dir_cd 에 해당하는 port조회한다. <br>
		 * 
		 * @param VskVslPortSkdVO vskVslPortSkdVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchPortCodeList (VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (vskVslPortSkdVO != null) {
					 Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOPortVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * BSA Trade code 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchBSATradeCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOBSATradeVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * tot lane을 조회한다.  <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTotLaneCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTotLaneVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	   

		/**
		 * tot lane에 해당하는 lane과 trade를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTotLaneTrdCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTotLaneTrdVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * tot lane에 해당하는 trade를 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTotLaneDistinctTrdCodeList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTotLaneDistinctTrdVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}    

		/**
		 * trade에 해당하는 lane을 조회한다. <br>
		 * 
		 * @param TotCodeParamVO totCodeParamVO
		 * @return List<TotCodeInfoVO>
		 * @exception DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<TotCodeInfoVO> searchTotLaneByTrdList (TotCodeParamVO totCodeParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TotCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (totCodeParamVO != null) {
					 Map<String, String> mapVO = totCodeParamVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate) new TOTFindCodeDBDAOTotLaneByTrdVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, TotCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}   
	        	    
}