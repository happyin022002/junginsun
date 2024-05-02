/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgt.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.20 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.CustomMnrEqDpcVO;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
   
/** 
 * COM DVFactorMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms
 * @see DVFactorMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class DVFactorMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0107]DV Factor의 정보를 조회 합니다. <br>
	 *
	 * @param DVFactorINVO dVFactorINVO
	 * @return List<CustomMnrEqDpcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqDpcVO> searchDVFactorListData(DVFactorINVO dVFactorINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrEqDpcVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		            
		try{        
			if(dVFactorINVO != null){  
				if (dVFactorINVO.getEqKndCd() != null && dVFactorINVO.getEqKndCd().trim().length() > 0) {
					param.put("eq_knd_cd", dVFactorINVO.getEqKndCd());                     
					param.put("eq_dpc_yr", dVFactorINVO.getEqDpcYr());
					param.put("eq_dpc_rt", dVFactorINVO.getEqDpcRt());
					velParam.put("eq_knd_cd", dVFactorINVO.getEqKndCd());        
					velParam.put("eq_dpc_yr", dVFactorINVO.getEqDpcYr());           
					velParam.put("eq_dpc_rt", dVFactorINVO.getEqDpcRt());           
				}                   
			}                 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchDVFactorListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqDpcVO .class);
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
	 * [EES_MNR_0107]DV Factor의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrEqDpcVO> customMnrEqDpcVOs
	 * @exception DAOException
	 */ 
	public void modifyDVFactorData(List<CustomMnrEqDpcVO> customMnrEqDpcVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(customMnrEqDpcVOs.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DVFactorMgtDBDAOmodifyDVFactorDataUSQL(), customMnrEqDpcVOs,null);
				    
				for(int i = 0; i < updCnt.length; i++){  
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
	
}
