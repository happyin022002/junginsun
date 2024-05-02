/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalInterface301FullDGApprovalBC.java
*@FileTitle : Common Utility in SCG
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : TOP
*@LastVersion : 1.0
* 2015.09.04 TOP
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS-Scgcommon Business Logic Command Interface<br>
 * - OPUS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author TOP
 * @see Scg_com_EventResponse 참조
 * @since J2EE 1.4
 */
public class ExternalInterface301FullDGApprovalDBDAO extends DBDAOSupport {

	/**
	 * BKG POL의 CONTINENT CODE 조회 <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkEffectivenessForEurope301F(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO) throws DAOException {
		
		DBRowSet dbRowset 		= null;
		boolean	 isTarget301F	= false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {			
			
			if(searchScgAprovalAuthCdVO == null)	return	false;
			
			param.putAll(searchScgAprovalAuthCdVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ExternalInterface301FullDGApprovalDBDAOCheckEffectivenessForEurope301FRSQL(),param, null);
			
			if (dbRowset.next())	isTarget301F	= true;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return	isTarget301F;
	}
 
}
