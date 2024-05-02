/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagemntDBDAO.java
*@FileTitle : RuLabelManagemnt
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* =======================================================     
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelInfoVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 *  RuLabelManagemntDBDAO <br>
 *  RuLabelManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Young Jin
 * @see  참조
 * @since J2EE 1.6
 */
public class RuLabelManagementDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * EES_MST_0050 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0050
	 * @category searchRuLabelListData     
	 * @param ruLabelInfoVO RuLabelInfoVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelListData(RuLabelInfoVO ruLabelInfoVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelInfoVO != null){
				Map<String, String> mapVO = ruLabelInfoVO .getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	
	
	/**
	 * EES_MST_0050 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0050
	 * @category searchRuLabelListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public String searchRuLabelDeleteCntData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//int allCntrCnt = 0;
		String strCntrCnt = "";
		String strRuLabelType = "";
		try{
			//velocity parameter
			String allTotalTp = ruLabelListVO.getAllRuLabelType();
			String allTotalVal = ruLabelListVO.getAllRuLabelValue();
			String allTotalFlag = ruLabelListVO.getAllIbFlag();
			String[] arrTotalTp = allTotalTp.split("\\,");
			String[] arrTotalVal = allTotalVal.split("\\,");
			String[] arrIbFlag = allTotalFlag.split("\\,");
			
			if (arrTotalTp.length > 0) {
				for(int i=0; i<arrTotalTp.length; i++) {
					Map<String, String> mapVO = ruLabelListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					if( arrIbFlag[i].equals("D")) {
						param.put("ru_label_type", arrTotalTp[i]);
			        	velParam.put("ru_label_type", arrTotalTp[i]);
			        	
			        	param.put("ru_label_value", arrTotalVal[i]);
			        	velParam.put("ru_label_value", arrTotalVal[i]);
			        	
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelTypeListRSQL(), param, velParam);
						if(dbRowset.next()){
							strCntrCnt = dbRowset.getString("CNTR_NO");
							if(!strCntrCnt.equals("")) {
								strRuLabelType = arrTotalTp[i]; 
								break;
							}
						}	
					} 
				}
			}
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRuLabelType;		
	}
	/**
	 * 
	 * @param ruLabelListVOs
	 * @throws DAOException
	 */
	public void addRuLabelData(List<RuLabelListVO> ruLabelListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (ruLabelListVOs.size() > 0) {
				
				addCnt = sqlExe.executeBatch((ISQLTemplate) new RuLabelManagementDBDAOAddRubelManagementDataCSQL(), ruLabelListVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 
	 * @param ruLabelListVOs
	 * @throws DAOException
	 */  
	public void modifyRuLabelData(List<RuLabelListVO> ruLabelListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (ruLabelListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RuLabelManagementDBDAOModifyRubelManagementDataUSQL(), ruLabelListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 
	 * @param ruLabelListVOs
	 * @throws DAOException
	 */
	public void removeRuLabelData(List<RuLabelListVO> ruLabelListVOs) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strCntr = "";
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (ruLabelListVOs.size() > 0) {
				
				velParam.put("rstr_usg_tp",ruLabelListVOs.get(0).getRstrUsgTpCd());
				for(int i=0; i<ruLabelListVOs.size(); i++) {
					Map<String, String> mapVO = ruLabelListVOs.get(i).getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("ru_label_type", mapVO.get("rstr_usg_tp_cd"));
		        	velParam.put("ru_label_type", mapVO.get("rstr_usg_tp_cd"));
		        	
		        	param.put("ru_label_value", mapVO.get("rstr_usg_lbl_nm"));
		        	velParam.put("ru_label_value", mapVO.get("rstr_usg_lbl_nm"));
		        	
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelTypeListRSQL(), param, velParam);
					
					while (dbRowset.next()) {
						strCntr =dbRowset.getString("CNTR_NO");
						
						param.put("cntr_no", strCntr);
			        	velParam.put("cntr_no", strCntr);
			        	
			        	param.put("remark", "");
			        	velParam.put("remark", "");
			        	
			        	param.put("rstr_usg_upd_tp_cd", "D");
			        	velParam.put("rstr_usg_upd_tp_cd", "D");
			        	
			        	sqlExe.executeUpdate((ISQLTemplate) new RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL(), param, velParam);
			        	sqlExe.executeUpdate((ISQLTemplate) new RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL(), param, velParam);
					}
					
				}
				
				
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RuLabelManagementDBDAORemoveRubelManagementDataUSQL(), ruLabelListVOs, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelAttachListData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		int intPage = 0;
		if(ruLabelListVO.getIPage() == null || "".equals(ruLabelListVO.getIPage())) {
			intPage = 1;
		}else{
			intPage = Integer.parseInt(ruLabelListVO.getIPage());
		}
		int currentPage = intPage;
		int pageRow	  = Integer.parseInt(ruLabelListVO.getPagerows());		
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
   	  	
   	  	
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrList = null;
		List<String> arrLabelValueList = null;
		List<String> arrAgmtSeq = null;
		
		try{
			if(ruLabelListVO != null){
				
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
		        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSCntrNo()).equals("") ) {
					arrCntrList = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSCntrNo(),",","|"));
		        	param.put("cntr_list", arrCntrList);
		        	velParam.put("cntr_list", arrCntrList);        	
		        }
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSRuLabelValue()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSRuLabelValue(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        }
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSMultiAgmtSeq()).equals("") ) {
					arrAgmtSeq = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSMultiAgmtSeq().replaceAll("HHO", ""),",","|"));
		        	param.put("agmtseq_list", arrAgmtSeq);
		        	velParam.put("agmtseq_list", arrAgmtSeq);        	
		        } 
				
				if("ALL".equals(ruLabelListVO.getSRuLabelType())) {
					param.put("s_ru_label_type", "");
					velParam.put("s_ru_label_type", "");
				}
				
				if("ALL".equals(ruLabelListVO.getSRuLabelValue())) {
					param.put("s_ru_label_value", "");
					velParam.put("s_ru_label_value", "");
				}
				
				if("ALL".equals(ruLabelListVO.getSTpCd())) {
					param.put("s_tp_cd", "");
					velParam.put("s_tp_cd", "");
				}
				if("ALL".equals(ruLabelListVO.getSCntrStsCd())) {
					param.put("s_cntr_sts_cd", "");
					velParam.put("s_cntr_sts_cd", "");
				}				
		         param.put("startno", startNo);
				 param.put("endno", endNo);
				 
		         velParam.put("startno", startNo);
		         velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelAttachmentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelAttachExcelListData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
   	  	
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ruLabelListVO != null){
				
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
		        if(ruLabelListVO.getTmpSeq() != null) {
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					param.put("tmp_seq", ruLabelListVO.getTmpSeq());
			        velParam.put("tmp_seq", ruLabelListVO.getTmpSeq());
			        
			        param.put("cre_usr_id", ruLabelListVO.getCreUsrId());
			        velParam.put("cre_usr_id", ruLabelListVO.getCreUsrId());
			        
			        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL(), param, velParam);
			        list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
		        }
		        
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return int
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public int searchCntrTotalRuLabelAttachListData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrList = null;
		List<String> arrLabelValueList = null;
		List<String> arrAgmtSeq = null;
		
		try{
			if(ruLabelListVO != null){
				
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
		        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSCntrNo()).equals("") ) {
					arrCntrList = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSCntrNo(),",","|"));
		        	param.put("cntr_list", arrCntrList);
		        	velParam.put("cntr_list", arrCntrList);        	
		        }
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSRuLabelValue()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSRuLabelValue(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				if ( !JSPUtil.getNull(ruLabelListVO.getSMultiAgmtSeq()).equals("") ) {
					arrAgmtSeq = JSPUtil.convertStringToArrayList(JSPUtil.replace(ruLabelListVO.getSMultiAgmtSeq().replaceAll("HHO", ""),",","|"));
		        	param.put("agmtseq_list", arrAgmtSeq);
		        	velParam.put("agmtseq_list", arrAgmtSeq);        	
		        } 
				
				if("ALL".equals(ruLabelListVO.getSRuLabelType())) {
					param.put("s_ru_label_type", "");
					velParam.put("s_ru_label_type", "");
				}
				
				if("ALL".equals(ruLabelListVO.getSRuLabelValue())) {
					param.put("s_ru_label_value", "");
					velParam.put("s_ru_label_value", "");
				}
				
				if("ALL".equals(ruLabelListVO.getSTpCd())) {
					param.put("s_tp_cd", "");
					velParam.put("s_tp_cd", "");
				}
				if("ALL".equals(ruLabelListVO.getSCntrStsCd())) {
					param.put("s_cntr_sts_cd", "");
					velParam.put("s_cntr_sts_cd", "");
				}					
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOtotalCntRuLabelAttachmentListRSQL(), param, velParam);
			if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;		
	}
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Value를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelValueListData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){
				
				
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelValueListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	
	
	/** EES_MST_0051 : <br>
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 조회한다.<br>
	 * 
     * @author Park Young Jin
     * @category EES_MST_0051
     * @category searchRuLabelAttachCntrListData
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<RuLabelListVO> searchRuLabelAttachCntrListData(RuLabelListVO ruLabelListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){				

					Map<String, String> mapVO = ruLabelListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelAttachCntrmentListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO.class);
					
			}												
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }		
	
	
	
	/**
	 * 
	 * @param ruLabelListVOs
	 * @throws DAOException
	 */
	public void addRuLabelAttachData(List<RuLabelListVO> ruLabelListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (ruLabelListVOs.size() > 0) {
				
				addCnt = sqlExe.executeBatch((ISQLTemplate) new RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL(), ruLabelListVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	
	/**
	 * 
	 * @param ruLabelListVOs
	 * @throws DAOException
	 */
	public void addRuLabelHistoryData(List<RuLabelListVO> ruLabelListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (ruLabelListVOs.size() > 0) {
				
				addCnt = sqlExe.executeBatch((ISQLTemplate) new RuLabelManagementDBDAOAddRuLabelAttachHistoryDataCSQL(), ruLabelListVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * EES_MST_0050 : retrieve <br>
	 * RU Label Maintenace를 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_MST_0050
	 * @category searchRuLabelListData     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelHistoryListData(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * CNTR별 RULabel이 존재하는지 조회합니다.<br>	 
	 * @author Un Jeong
	 * @category EES_MST_0051
	 * @category checkRuLabel     
	 * @param  cntrNo String
	 * @param  ruLabelType String
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String checkRuLabel(String cntrNo, String ruLabelType) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("cntr_no", cntrNo);
			param.put("ru_label_type", ruLabelType);
			velParam.put("ru_label_type", ruLabelType);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOcheckRulabelRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnFlag;
	}
	
	/**
	 * EES_MST_0050 : retrieve <br>
	 * Checking RULabel`s Duplication<br>	 
	 * @author Un Jeong
	 * @category EES_MST_0050
	 * @category checkRuLabel     
	 * @param ruTpCd String 
	 * @param ruLblNm String 
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String checkRulabelDuplication(String ruTpCd, String ruLblNm) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rstrUsgCdFlg = "N";
		try{		
			param.put("rstr_usg_tp_cd", ruTpCd);
			param.put("rstr_usg_lbl_nm", ruLblNm);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOcheckRulabelDupRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rstrUsgCdFlg = "Y";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rstrUsgCdFlg;
	}
	
	/**
	 * EES_MST_0053 : retrieve <br>
	 * RU Label Info<br>	 
	 * @author 
	 * @category EES_MST_0053
	 * @category searchRuLabelInfoService     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelInfoService(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelInquiyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * EES_MST_0054 : retrieve <br>
	 * RU Label - Search Condition<br>	 
	 * @author 
	 * @category EES_MST_0054
	 * @category searchRuLabelConditionService     
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RuLabelListVO> searchRuLabelConditionService(RuLabelListVO ruLabelListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){
				Map<String, String> mapVO = ruLabelListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelConditionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	/**
	 * [EES_MST_0051]Excel Load. <br>
	 * 시퀀스를 조회 생성한다.<br>
	 * @return String
	 * @exception DAOException
	 */
	public String addMnrTempSequenceData() throws DAOException{
		DBRowSet dbRowset = null; 
		String returnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL(), param, velParam);
			if(dbRowset.next()){ 
				returnVal = dbRowset.getString("SEQ");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    
		return returnVal;
	}
	
	
	/**
	 * [EES_MST_0051]Excel Load. <br>
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * @param List<RuLabelListVO> ruLabelListVOs
	 * @exception DAOException
	 */
	public void addMnrTempData(List<RuLabelListVO> ruLabelListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (ruLabelListVOs.size() > 0) {
				
				addCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralCodeCheckMgtDBDAOaddMstTempDataCSQL(), ruLabelListVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** EES_MST_0051 : <br>
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 조회한다.<br>
	 * 
     * @author Park Young Jin
     * @category EES_MST_0051
     * @category searchRuLabelAttachCntrListData
	 * @param RuLabelListVO ruLabelListVO
	 * @param seqValue String 
	 * @return List<RuLabelListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<RuLabelListVO> searchRuLabelAttachCntrExcelListData(RuLabelListVO ruLabelListVO, String seqValue) throws DAOException {
		DBRowSet dbRowset = null;
		List<RuLabelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ruLabelListVO != null){				

					Map<String, String> mapVO = ruLabelListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					param.put("seqValue", seqValue);
					velParam.put("seqValue", seqValue);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RuLabelListVO.class);
					
			}												
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }		
	
	
	
	
}