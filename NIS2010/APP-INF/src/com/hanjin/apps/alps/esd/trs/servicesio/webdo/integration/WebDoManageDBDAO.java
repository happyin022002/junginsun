/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAO.java
*@FileTitle : USA Delivery Order Insert/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011-10-07 Choi jonghyek
* 1.0 최초 생성
* history
* 2011.10.18 김종호 [CHM-201113793] HJS Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
* 2012.05.14 최 선 [] WEB DO - TRS I/F 시, 로그 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.webdo.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.webdo.basic.WebDoManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi jonghyek
 * @see WebDoManageBCImpl 참조
 * @since J2EE 1.4
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
		int iDupChk = 0;
		DBRowSet dHRs = null;
		DBRowSet dDRs = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object> ();
			Map<String, Object> velParam = new HashMap<String, Object> ();

			param.putAll(ifSchemaVO.getColumnValues());
			velParam.putAll(ifSchemaVO.getColumnValues());
			
			dHRs = sqlExe.executeQuery(new WebDoManageDBDAOMultiUSADeliveryOrderHdrDupChkRSQL(), param, velParam);
            if (dHRs.next()) iDupChk = dHRs.getInt("chk"); //TRS_TRSP_USA_DO_HDR 에 해당 B/L이 있을 경우 iDupChk=1
            	log.error("@@@@@@DBDAO : iDupChk = "+iDupChk);
            if (iDupChk > 0) {
            	log.error("@@@@@@DBDAO Header : iDupChk = 1 ");
            	log.error("@@@@@@param1 : " + param);
            	log.error("@@@@@@velParam1 : " + velParam);
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOMultiUSADeliveryOrderHdrUpdUSQL(), param, velParam);
            }else{
            	log.error("@@@@@@DBDAO Header : iDupChk = 0 ");
            	log.error("@@@@@@param2 : " + param);
            	log.error("@@@@@@velParam2 : " + velParam);
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOMultiUSADeliveryOrderHdrInsCSQL(), param, velParam);
            }
            
            iDupChk = 0;
			dDRs = sqlExe.executeQuery(new WebDoManageDBDAOMultiUSADeliveryOrderDtlDupChkRSQL(), param, velParam);
			if (dDRs.next()) iDupChk = dDRs.getInt("chk"); //TRS_TRSP_USA_DO_DTL 에 해당 B/L, eq no.가 있을 경우에 iDupChk=1 
				log.error("@@@@@@DBDAO : iDupChk = "+iDupChk);
			if (iDupChk > 0) {
            	log.error("@@@@@@DBDAO Detail : iDupChk = 1 ");
            	log.error("@@@@@@param3 : " + param);
            	log.error("@@@@@@velParam3 : " + velParam);
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOMultiUSADeliveryOrderDtlUpdUSQL(), param, velParam);
            }else{
            	log.error("@@@@@@DBDAO Detail : iDupChk = 0 ");
            	log.error("@@@@@@param4 : " + param);
            	log.error("@@@@@@velParam4 : " + velParam);
            	rowCnt = sqlExe.executeUpdate(new WebDoManageDBDAOMultiUSADeliveryOrderDtlInsCSQL(), param, velParam);
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
}