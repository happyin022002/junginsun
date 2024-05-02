/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDAO.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.07 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

 /**
  * NIS2010 DualTypeExceptionMgtDAO <br>
  * - NIS2010-DMTExceptionMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
  * 
  * @author SungHoon, Lee
  * @see DualTypeExceptionMgtBCImpl 참조
  * @since J2EE 1.6
  */ 
public class DualTypeExceptionMgtDBDAO extends DBDAOSupport {

	/**
	 * Dual Type Exception 에 기등록된 Customer 정보를 조회 합니다. <br>
	 * 
	 * @return List<DualTypeCustomerVO>
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<DualTypeCustomerVO> searchDualTypeCustomerList() throws DAOException {
		DBRowSet dbRowset = null;
		List<DualTypeCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAODualTypeCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
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
	 * Dual Type Exception을 조회 합니다. <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return List<DualTypeCustomerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DualTypeCustomerVO> searchDualTypeCustomer(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DualTypeCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
//				StringTokenizer st1 = null;
//				StringTokenizer st2 = null;
//				String tempS = "";
//				String tempS2 = "";
				
				//Containter & Cargo Type
		        List<String> scCntrCgoList = new ArrayList<String>();
		        List<String> rfaCntrCgoList = new ArrayList<String>();
		        
		        String cntrCgoCds = (String)dualTypeCustomerVO.getDmdtCntrCgoTpCd();
		        
		        StringTokenizer stringTokenizer = new StringTokenizer(cntrCgoCds, ",");
		        
		        while(stringTokenizer.hasMoreTokens()) {
		        	String str = stringTokenizer.nextToken();
		        	if(!str.contains("All")){
		        		if(str.contains(":")){
		        			rfaCntrCgoList.add(str);
		        		}else{
		        			scCntrCgoList.add(str);
		        		}
		        	}
		        }	        
		        
		        String[] arr_cntr = new String[10];
		        String[] arr_cgo = new String[10];
		        
		        //초기화
		        for(int i = 0; i < arr_cntr.length; i++) {
		        	arr_cntr[i] = "";
		        	arr_cgo[i] = "";
		        }
		        
		        for(int i = 0 ; i < rfaCntrCgoList.size() ; i++) {
		        	String str = rfaCntrCgoList.get(i);
		        	if(str.contains(":")){
		        		String[] arr = str.split(":");
		        		if(arr.length == 2) {
		        			arr_cntr[i] = arr[0];
		        			arr_cgo[i] = arr[1];
		        		}
		        	}
		        }
		        
		        String scInFlag = scCntrCgoList.size() == 0 ? "N" : "Y";
		        String rfaInFlag = rfaCntrCgoList.size() == 0 ? "N" : "Y";
		        	
		        velParam.put("dmdt_sc_cntr_cgo_cd_in", scInFlag);
		        velParam.put("dmdt_sc_cntr_cgo_tp_list", scCntrCgoList);
		        velParam.put("dmdt_cntr_cgo_cd_in", rfaInFlag);
		        velParam.put("dmdt_cntr_cgo_cd_size", String.valueOf(rfaCntrCgoList.size()));
		        
		        param.put("dmdt_cntr_tp_cd1", arr_cntr[0]);
		        param.put("dmdt_cntr_tp_cd2", arr_cntr[1]);
		        param.put("dmdt_cntr_tp_cd3", arr_cntr[2]);
		        param.put("dmdt_cntr_tp_cd4", arr_cntr[3]);
		        param.put("dmdt_cntr_tp_cd5", arr_cntr[4]);
		        param.put("dmdt_cntr_tp_cd6", arr_cntr[5]);
		        param.put("dmdt_cntr_tp_cd7", arr_cntr[6]);
		        param.put("dmdt_cntr_tp_cd8", arr_cntr[7]);
		        param.put("dmdt_cntr_tp_cd9", arr_cntr[8]);
		        param.put("dmdt_cntr_tp_cd10", arr_cntr[9]);
		        
		        param.put("dmdt_cgo_tp_cd1", arr_cgo[0]);
		        param.put("dmdt_cgo_tp_cd2", arr_cgo[1]);
		        param.put("dmdt_cgo_tp_cd3", arr_cgo[2]);
		        param.put("dmdt_cgo_tp_cd4", arr_cgo[3]);
		        param.put("dmdt_cgo_tp_cd5", arr_cgo[4]);
		        param.put("dmdt_cgo_tp_cd6", arr_cgo[5]);
		        param.put("dmdt_cgo_tp_cd7", arr_cgo[6]);
		        param.put("dmdt_cgo_tp_cd8", arr_cgo[7]);
		        param.put("dmdt_cgo_tp_cd9", arr_cgo[8]);
		        param.put("dmdt_cgo_tp_cd10", arr_cgo[9]);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAODualTypeCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
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
	 * Dual Type Exception을 생성 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void addDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (dualTypeCustomerVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerCSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 수정 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void modifyDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int updCnt[] = null;
			if (dualTypeCustomerVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerUSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 삭제 합니다. <br>
	 * 
	 * @param List<DualTypeCustomerVO> dualTypeCustomerVOs
	 * @exception DAOException
	 */
	public void removeDualTypeCustomer(List<DualTypeCustomerVO> dualTypeCustomerVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int delCnt[] = null;
			if(dualTypeCustomerVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DualTypeExceptionMgtDBDAODualTypeCustomerDSQL(), dualTypeCustomerVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception Coverage의 Dual Type 여부를 조회 합니다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkDualCoverage(CoverageVO coverageVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(S/C)의 삭제가능 여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeCustomerBySC(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
						new DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(Before Booking)의 삭제가능 여부를 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeCustomerByRFA(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerByRFARSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(S/C) Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeExpireDateBySC(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
						new DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateBySCRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Dual Type Exception(Before Booking) Expire Date 가 유효한지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkDelDualTypeExpireDateByRFA(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDualTypeExpireDateByRFARSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * 등록할 Dual Type Exception 이 기등록된 것인지 조회 합니다.<br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return DualTypeCustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public DualTypeCustomerVO checkDuplicateDualTypeException(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		List<DualTypeCustomerVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DualTypeCustomerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	/**
	 * 기등록된 Dual Type Exception 를 조회하는 함수<br>
	 * 
	 * @param SCOrDARListInputVO sCOrDARListInputVO
	 * @return List<SCOrDARListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCOrDARListVO> searchSCorDARListByCustomer(SCOrDARListInputVO sCOrDARListInputVO) throws DAOException {
		List<SCOrDARListVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (sCOrDARListInputVO != null){
				Map<String, String> mapVO = sCOrDARListInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				if ("S".equals(sCOrDARListInputVO.getDmdtCtrtExptTpCd())) {
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
							new DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL(), param, velParam);
				}
				else if ("B".equals(sCOrDARListInputVO.getDmdtCtrtExptTpCd())) { 
					dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
							new DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL(), param, velParam);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCOrDARListVO .class);
			}
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
	* Dual Type Exception의 다음 Sequence를 조회 합니다.<br>
	* 
	* @param DualTypeCustomerVO dualTypeCustomerVO
	* @return String
	* @exception DAOException
	*/	 
	public String searchNextCustExptSeq(DualTypeCustomerVO dualTypeCustomerVO) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dualTypeCustomerVO != null){
				Map<String, String> mapVO = dualTypeCustomerVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
					new DualTypeExceptionMgtDBDAOSearchNextCustExptSeqRSQL(), param, velParam);

			if (dbRowset.next())
				result = dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result; 
	 }

}
