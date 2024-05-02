/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfStowageMgtDBDAO.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현
* 1.0 Creation
*=========================================================
* History
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAOAddBkgInvHistoryCSQL;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.OpfStowageBayPlanListVO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.BayPlanCntrDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS OpfStowageMgtDBDAO <br>
 * - ALPS-OpfStowageMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see OpfStowageMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class OpfStowageMgtDBDAO extends DBDAOSupport {

	/**
	 * Bay Plan 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<OpfStowageBayPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStowageBayPlanListVO != null){
				Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan의 Contailner 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<BayPlanCntrDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BayPlanCntrDtlVO> searchBayPlanCntrDtl(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<BayPlanCntrDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStowageBayPlanListVO != null){
				Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanCntrDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDtlVO .class);
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
	 * Bay Plan Hach Cover정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanHtchCvrList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<OpfStowageBayPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStowageBayPlanListVO != null){
				Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanHtchCvrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan에서 조회조건 Container의 Bay 위치정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrPositionList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<OpfStowageBayPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStowageBayPlanListVO != null){
				Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanCntrPositionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan에서 해당Container의 Bay Index정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayIdx(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
			 
			DBRowSet dbRowset = null;
			List<OpfStowageBayPlanListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(opfStowageBayPlanListVO != null){
					Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanCntrBayIdxRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan의 Container에 해당되는 Bay List를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
			 
			DBRowSet dbRowset = null;
			List<OpfStowageBayPlanListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(opfStowageBayPlanListVO != null){
					Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanCntrBayListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan의 Container에 해당되는 VVD 및 Port를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrVvdPortList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
			 
			DBRowSet dbRowset = null;
			List<OpfStowageBayPlanListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(opfStowageBayPlanListVO != null){
					Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOBayPlanCntrVvdPortListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * Bay Plan Port별 Color정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStowageBayPlanListVO> searchPortColorList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<OpfStowageBayPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStowageBayPlanListVO != null){
				Map<String, String> mapVO = opfStowageBayPlanListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OpfStowageMgtDBDAOPortColorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStowageBayPlanListVO .class);
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
	 * 타선사 Container 조회시 VESSEL정보가 없는경우 관련테이블에 데이터를 생성하기 위해 STO_TPL_CRE_PRC 호출<br>
	 * 
	 * @param String vslCd
	 * @exception DAOException
	 */
	public void addBBayPlanVslCd(String vslCd)  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("vslCd", vslCd);
			param.putAll(mapVO);
			
			new SQLExecuter("OPF_HJSBAT").executeSP((ISQLTemplate)new OpfStowageMgtDBDAOAddVslCdCSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
		 
	 
}
