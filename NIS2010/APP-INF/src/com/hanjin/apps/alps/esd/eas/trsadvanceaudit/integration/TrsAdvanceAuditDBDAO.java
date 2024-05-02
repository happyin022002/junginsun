/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteCondVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudDtlListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * TrsAdvanceAuditDBDAO  PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class TrsAdvanceAuditDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -1132976440312128013L;
	
	/**
	 * TRS Pre-Audit Criterion setting 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteListVO> searchTrsCrteList(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TrsPreAudCrteListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			 if(trsPreAudCrteCondVO != null){
				 Map<String, String> mapVO = trsPreAudCrteCondVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOTrsPreAudCrteListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsPreAudCrteListVO .class);			 
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
     * ESD_EAS_0342 - Modify
     *
     * @param  List<TrsPreAudCrteListVO> multiList
     * @throws DAOException
     */
	public void modifyTrsCrte(List<TrsPreAudCrteListVO> multiList) throws DAOException {
        int updCnt[] = null;
        DBRowSet dbRowset = null;
        //query parameter
		Map<String, String> param = new HashMap<String, String>();
        TrsPreAudCrteListVO trsPreAudCrteListVO = new  TrsPreAudCrteListVO();

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(multiList != null ){

            	for(int i=0;i<multiList.size();i++){
            		trsPreAudCrteListVO = (TrsPreAudCrteListVO)multiList.get(i);
            		param =	trsPreAudCrteListVO.getColumnValues();
            		
            		if (trsPreAudCrteListVO.getIbflag().equals("I")) {
            			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOModifyTrsCrteRSQL(), param, null);
            			if(dbRowset.next()){
            				if( Integer.parseInt(dbRowset.getString("cnt")) >0){
            					throw new DAOException("Office code has been duplicated");
            				}
            			}
            		}
            	}
            	
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new TrsAdvanceAuditDBDAOTrsPreAudCrteListUSQL(), multiList, null);
            	for(int i = 0; i < updCnt.length; i++){
            		if(updCnt[i]== Statement.EXECUTE_FAILED)
            			throw new DAOException("Fail to update No"+ i + " SQL");
            	}
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
    /**
     * ESD_EAS_0342 - Modify
     *
     * @param  TrsPreAudCrteCondVO vo
     * @throws DAOException
     */
	public void removeTrsCrte(TrsPreAudCrteCondVO vo) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try { 
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new TrsAdvanceAuditDBDAOTrsPreAudCrteListDSQL(), param, null);
			if(delCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Transportation Invoice Charge 조회한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudListVO> searchTrsPreAudList(TrsPreAudListVO trsPreAudListVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<TrsPreAudListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		try{
				 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			    if(trsPreAudListVO.getSInvNo() != null && trsPreAudListVO.getSInvNo().length() > 0) {
					List<String> invNos = new ArrayList<String>();
					String[] arrInvNo = trsPreAudListVO.getSInvNo().split(",");
					for(int i = 0; i < arrInvNo.length; i++) {
						invNos.add(arrInvNo[i]);
					}
					param.put("invNos", invNos);
					velParam.put("invNos", invNos);
				}
			 
			    if(trsPreAudListVO.getSCsrNo() != null && trsPreAudListVO.getSCsrNo().length() > 0) {
					List<String> csrNos = new ArrayList<String>();
					String[] arrCsrNo = trsPreAudListVO.getSCsrNo().split(",");
					for(int i = 0; i < arrCsrNo.length; i++) {
						csrNos.add(arrCsrNo[i]);
					}
					param.put("csrNos", csrNos);
					velParam.put("csrNos", csrNos);
				}			 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOsearchTrsPreAudListRSQL(), param, velParam);
			 
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsPreAudListVO.class);
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
	 * Add office 시 등록된 office 인지 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteCondVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteCondVO> searchAddOffice(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsPreAudCrteCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(trsPreAudCrteCondVO != null){
				Map<String, String> mapVO = trsPreAudCrteCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOSearchAddOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsPreAudCrteCondVO.class);			 
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
	 * Transportation Invoice Charge - detail 조회한다.<br>
	 * 
	 * @param TrsPreAudDtlListVO trsPreAudDtlListVO
	 * @return List<TrsPreAudDtlListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudDtlListVO> searchTrsPreAudDtlList(TrsPreAudDtlListVO trsPreAudDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsPreAudDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(trsPreAudDtlListVO != null){
				Map<String, String> mapVO = trsPreAudDtlListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOsearchTrsPreAudDtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsPreAudDtlListVO.class);			 
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
	  * Transportation Invoice Charge  를 저장한다.<br>
	  * 
	  * @param TrsPreAudListVO TrsPreAudListVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void confirmTrsPreAudit(TrsPreAudListVO trsPreAudListVO) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;
			 if(trsPreAudListVO != null){
				 //query parameter
				 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
				 param.putAll(mapVO);

				 //실시간 배치대상에 이미 포함되어 있는지를 검사한다.
				 TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL chkSQL = new TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL();
				 dbRowset = sqlExe.executeQuery(chkSQL, param, param);
				 String progFlg = "";

				 if(dbRowset.next()){
					 progFlg = dbRowset.getString("prog_flg");
					 if (progFlg.equals("Y")) {
						 throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is included in the re-batch target."})).getMessage());
					 }
				 }
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL() , param, param);

				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
		 * Transportation Invoice Auto Audit 대상을 조회한다.<br>
		 * 
		 * @param TrsPreAudListVO trsPreAudListVO
		 * @return List<TrsPreAudListVO>
		 * @exception EventException
		 */
		public List<TrsPreAudListVO> searchTrsAutoAudList(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			DBRowSet dbRowset = null;
			 List<TrsPreAudListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			try{
					 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				    if(trsPreAudListVO.getSInvNo() != null && trsPreAudListVO.getSInvNo().length() > 0) {
						List<String> invNos = new ArrayList<String>();
						String[] arrInvNo = trsPreAudListVO.getSInvNo().split(",");
						for(int i = 0; i < arrInvNo.length; i++) {
							invNos.add(arrInvNo[i]);
						}
						param.put("invNos", invNos);
						velParam.put("invNos", invNos);
					}

				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAdvanceAuditDBDAOsearchTrsAutoAudListRSQL(), param, velParam);
				 
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsPreAudListVO.class);
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
		  * Audit History를 저장한다.<br>
		  * 
		  * @param TrsPreAudListVO trsPreAudListVO
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public void addAutoAuditHis(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			 
			 Map<String, Object> param = new HashMap<String, Object>();
			 try{
				 SQLExecuter sqlExe = new SQLExecuter("");
				 
				 if(trsPreAudListVO != null){
					 //query parameter
					 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					param.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOaddAutoAuditHisCSQL() , param, null);
					 
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
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
		  * Auto Audit 내역을 삭제한다.<br>
		  * 
		  * @param TrsPreAudListVO trsPreAudListVO
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public void removeAutoAudit(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			 
			 Map<String, Object> param = new HashMap<String, Object>();
			 try{
				 SQLExecuter sqlExe = new SQLExecuter("");
				 
				 if(trsPreAudListVO != null){
					 //query parameter
					 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					param.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOremoveAutoAuditDSQL() , param, null);
					 
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
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
		  * Auto Audit Detail 내역을 삭제한다.<br>
		  * 
		  * @param TrsPreAudListVO trsPreAudListVO
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public void removeAutoAuditDtl(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			 
			 Map<String, Object> param = new HashMap<String, Object>();
			 try{
				 SQLExecuter sqlExe = new SQLExecuter("");
				 
				 if(trsPreAudListVO != null){
					 //query parameter
					 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					param.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOremoveAutoAuditDtlDSQL() , param, null);
					 
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
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
		  * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
		  * 
		  * @param TrsPreAudListVO trsPreAudListVO
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public void updateBatchStatus(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			 
			 Map<String, Object> param = new HashMap<String, Object>();
			 try{
				 SQLExecuter sqlExe = new SQLExecuter("");
				 
				 if(trsPreAudListVO != null){
					 //query parameter
					 Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					param.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOupdateBatchStatusUSQLUSQL() , param, null);
					 
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
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
		  * 실시간 배치 대상을 저장한다.<br>
		  * 
		  * @param TrsPreAudListVO TrsPreAudListVO
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public void saveReBatchTarget(TrsPreAudListVO trsPreAudListVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 Map<String, Object> param = new HashMap<String, Object>();
			 try{
				 SQLExecuter sqlExe = new SQLExecuter("");
				 
				 if(trsPreAudListVO != null){
					//query parameter
					Map<String, String> mapVO = trsPreAudListVO.getColumnValues();
					param.putAll(mapVO);

					//실시간 배치대상에 이미 포함되어 있는지를 검사한다.
					TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL chkSQL = new TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL();
					dbRowset = sqlExe.executeQuery(chkSQL, param, param);
					String progFlg = "";

					if(dbRowset.next()){
						progFlg = dbRowset.getString("prog_flg");
						if (progFlg.equals("Y")) {
							throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is already included in batch target."})).getMessage());
						}
					}
					
					int result = sqlExe.executeUpdate((ISQLTemplate) new TrsAdvanceAuditDBDAOsaveReBatchTargetCSQL() , param, param);
					if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
				 }	
				 
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
		 }
	 
}