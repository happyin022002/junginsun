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
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copupdate.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.basic.COPUpdateBCImpl;
import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seong-mun Kang
 * @see COPUpdateBCImpl 참조
 * @since J2EE 1.4
 */
public class COPUpdateDBDAO extends DBDAOSupport {
	
	/**
     * COP Manual Batch Update 에서 Actual datata search<br>
     * 
     * @param COPUpdateInfoVO inqVO
     * @return List<COPUpdateInfoVO>
     * @throws DAOException
     */
	public List<COPUpdateInfoVO> searchCOPDetailData(COPUpdateInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;		 
		List<COPUpdateInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         //String cop_no = JSPUtil.getNull((String)parameterMap.get("old_cop_no"));

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
/*
				
			cstmt.clearParameters() ;
			cstmt.setString(++idx, copNo) ;
			cstmt.setString(++idx, copGrpSeq) ;
			cstmt.setString(++idx, copDtlSeq) ;
			cstmt.setString(++idx, estmDT) ;
			cstmt.setString(++idx, userId) ;
			cstmt.setString(++idx, "") ;
			cstmt.registerOutParameter(idx, Types.VARCHAR); 
			cstmt.executeUpdate() ;
*/

        result = true;
        return result ;
     }
    
    /**
     * COP Status 수정
     * 
     * @param String copNo
     * @param String copStsCd
     * @exception EventException
     */
	public void modifyCopStsCd(String copNo, String copStsCd) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    // String new_cop_no   = JSPUtil.getNull((String)parameterMap.get("new_cop_no"));

	     try{
	    	 //if (inqVO.getNewCopNo() != null && inqVO.getNewCopNo().trim().length() > 0) {
	    	 param.put("cop_sts_cd", copStsCd);
	    	 param.put("cop_no", copNo);

			log.debug("\n param:"+param);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new COPUpdateDBDAOModifyCopStsCdUSQL(), param, velParam);

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

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         //String cop_no = JSPUtil.getNull((String)parameterMap.get("old_cop_no"));
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