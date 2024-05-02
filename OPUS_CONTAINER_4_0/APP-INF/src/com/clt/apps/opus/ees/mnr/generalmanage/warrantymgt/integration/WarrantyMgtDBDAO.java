/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtDBDAO.java
*@FileTitle : Warranty
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomMnrEqRngStsVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
         
/** 
 * COM WarrantyMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms
 * @see GeneralCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class WarrantyMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
 
	/**
	 * [EES_MNR_0213]Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertInfoINVO warrantyAlertInfoINVO
	 * @return List<CustomMnrEqRngStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomMnrEqRngStsVO> searchWarrantyAlertInfoData(WarrantyAlertInfoINVO warrantyAlertInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrEqRngStsVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = warrantyAlertInfoINVO.getColumnValues();
		       
			param.putAll(mapVO);                   
			velParam.putAll(mapVO);    
			       
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WarrantyMgtDBDAOsearchWarrantyAlertInfoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqRngStsVO .class);
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
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertListINVO warrantyAlertListINVO
	 * @return List<CustomWarrantyAlertListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomWarrantyAlertListVO> searchWarrantyAlertListData(WarrantyAlertListINVO warrantyAlertListINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomWarrantyAlertListVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = warrantyAlertListINVO.getColumnValues();
		       
			param.putAll(mapVO);                   
			velParam.putAll(mapVO);    
			       
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WarrantyMgtDBDAOsearchWarrantyAlertListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomWarrantyAlertListVO .class);
		}catch(SQLException se){ 
			log.error(se.getMessage(),se);   
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return list;
	}
	

}
