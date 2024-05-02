/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAO.java
*@FileTitle : DMT_CHG_CALC Table을 업데이트한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011-10-20
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2011-10-20 Kwon Min
* 1.0 최초 생성
* 2011.10.20 권  민 [CHM-201113793] SM Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAOMovementSZPBBVORSQL;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.basic.WebDoManageBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAOsearchEffectiveDateRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DMT 에 대한 DB 처리를 담당<br>
 * - DMT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author	Kwon Min
 * @see		WebDoManageBCImpl 참조
 * @since	J2EE 1.4
 */
public class WebDoManageDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param ifSchemaVO
	 * @return int
	 * @throws DAOException
	 */
	public int multiUsDo(IfSchemaVO ifSchemaVO) throws DAOException {
		int rowCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");

			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();

			param.putAll(ifSchemaVO.getColumnValues());
			velParam.putAll(ifSchemaVO.getColumnValues());
			
			String DTT_CODE	= ifSchemaVO.getDmdtTrfCd();
			
            if (DTT_CODE != null && DTT_CODE.equals("DMIF")) {
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOmodifyIfDMTDmifUSQL(), param, velParam);
            }else{
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOmodifyIfDMTOtherUSQL(), param, velParam);
            }
            
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * @param ifSchemaVO
	 * @return ifSchemaVO
	 * @throws DAOException
	 */
	public List<IfSchemaVO> searchPrecalOverday(IfSchemaVO ifSchemaVO) throws DAOException {
		List<IfSchemaVO> list	= null;
		DBRowSet dbRowset		= null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");

			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();

			param.putAll(ifSchemaVO.getColumnValues());
			velParam.putAll(ifSchemaVO.getColumnValues());
			
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new WebDoManageDBDAOsearchPrecalOverdayRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IfSchemaVO .class);
            
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