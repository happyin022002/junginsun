/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPUpdateDBDAO.java
*@FileTitle : COP Update
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copmanage.copupdate.basic.COPUpdateBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seong-mun Kang
 * @see COPUpdateBCImpl 참조
 * @since J2EE 1.4
 */
public class COPUpdateDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
     * COP Manual Batch Update 에서 Actual datata search<br>
     * 
     * @param COPUpdateInfoVO inqVO
     * @return List<COPUpdateInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<COPUpdateInfoVO> searchCOPDetailData(COPUpdateInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;		 
		List<COPUpdateInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

         try{
				Map<String, String> mapVO = inqVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 				
 				log.debug("\n param:"+param);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPUpdateDBDAOSearchCOPDetailDataRSQL(), param, velParam);
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, COPUpdateInfoVO .class);				
         } catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		 } catch (DAOException de) {
 			log.error(de.getMessage(), de);
 			throw de;
 		 } catch (Exception e) {
 			log.error(e.getMessage(), e);
 			throw new DAOException(e.getMessage());
 		 } 
 		 return list;
    }
	
	/**
     * COP Manual Batch Update 에서 Estimate Date Modify<br>
     * 
     * @param COPUpdateInfoVO paramVO
     * @return boolean
     * @throws DAOException
     */
	public boolean modifyCOPEstmDT(COPUpdateInfoVO paramVO) throws DAOException {
		boolean result = false;
        result = true;
        return result ;
     }
	
	/**
     * Actual Date 입력 된 건이지 확인<br>
     * 
     * @param COPUpdateInfoVO inqVO
     * @return boolean
     * @throws DAOException
     */
	public boolean searchCOPDetailActDt(COPUpdateInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;		 
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean result = false;
         try{
				Map<String, String> mapVO = inqVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 				
 				log.debug("\n param:"+param);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPUpdateDBDAOSearchCOPDetailActDtRSQL(), param, velParam);
 				if(dbRowset.next())	{
 					String actDt = dbRowset.getString("act_dt");
 					if(actDt == null || actDt.length() == 0){
 						result = false;
 					}else{
 						result = true;
 					}
 				}

         } catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		 } catch (DAOException de) {
 			log.error(de.getMessage(), de);
 			throw de;
 		 } catch (Exception e) {
 			log.error(e.getMessage(), e);
 			throw new DAOException(e.getMessage());
 		 } 
 		 return result;
    }
   
}