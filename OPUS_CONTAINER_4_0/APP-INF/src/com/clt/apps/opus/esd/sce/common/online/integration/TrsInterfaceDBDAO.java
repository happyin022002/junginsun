/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsInterfaceDBDAO.java
*@FileTitle : TrsInterface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-19
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2007-01-19 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.online.basic.TrsInterfaceBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCEM에 대한 DB 처리를 담당<br>
 * - SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author changgyu kim
 * @see TrsInterfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class TrsInterfaceDBDAO extends DBDAOSupport {
	
	/**
	 * Default id
	 */
	private static final long serialVersionUID = 1L;

	/** WAS restart 시 SCE_ACT_RCV_IF 의 ACT_STS_MAPG_CD 를 원복한다. (XX ==> 00)
     * @throws DAOException
     */
	public void modifyActRcvIf() throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(
					(ISQLTemplate) new TrsInterfaceDBDAOModifyActRcvIfUSQL(),
					param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** WAS restart 시 SCE_ACT_TML_IF 의 TML_IF_STS_CD 를 원복한다. (XX ==> 00)
     * @throws DAOException
     */
	public void modifyActTmlIf() throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(
					(ISQLTemplate) new TrsInterfaceDBDAOModifyActTmlIfUSQL(),
					param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/** WAS restart 시 SCE_CLM_IF 의 SO_MAPG_STS_CD 를 원복한다. (XX ==> 00)
     * @throws DAOException
     */
	public void modifyClmIf() throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(
					(ISQLTemplate) new TrsInterfaceDBDAOModifyClmIfUSQL(),
					param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** WAS restart 시 SCE_EDI_AMS_IF 의 EDI_IF_STS_CD 를 원복한다. (XX ==> 00)
     * @throws DAOException
     */
	public void modifyEdiAmsIf() throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(
					(ISQLTemplate) new TrsInterfaceDBDAOModifyEdiAmsIfUSQL(),
					param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** WAS restart 시 SCE_VPS_IF 의 VPS_IF_STS_CD 를 원복시킨다. (XX ~> 00)
     * @throws DAOException
     */
	public void modifyVpsIf() throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			SQLExecuter sqlExe = new SQLExecuter("");

			updCnt = sqlExe.executeUpdate(
					(ISQLTemplate) new TrsInterfaceDBDAOModifyVpsIfUSQL(),
					param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update..");

		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
