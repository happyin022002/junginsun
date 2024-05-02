/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ExceptionAckRailRoadDAO.java
 *@FileTitle : Exception Ack Rail Road
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-04-19
 *@LastModifier : S.W. KIM
 *@LastVersion : 1.0
 * 2016-04-19 ksw	   	1.0  최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.event.EsdTrs0077Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsExptAckRailVndrVO;

/**
 * ExceptionAckRailRoadDBDAO
 * 
 * @author
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class ExceptionAckRailRoadDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception Rail Road Vendor - RETRIEVE
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchExceptionAckRailRoadVendorList(EsdTrs0077Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("sel_railroad", event.getSelRailroad());
			dRs = new SQLExecuter().executeQuery(new ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * Exception Rail Road Vendor - SAVE
	 * 
	 * @param trsExptAckRailVndrVO
	 * @throws DAOException
	 */
	public void multiExceptionAckRailRoadVendor(TrsExptAckRailVndrVO trsExptAckRailVndrVO) throws DAOException {
		try {
			new SQLExecuter().executeUpdate(new ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendorCSQL(), trsExptAckRailVndrVO.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * Exception Ack Rail Road Vendor - Duplicate Check
	 * 
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public boolean checkDuplcateVendor(List<TrsExptAckRailVndrVO> vos) throws DAOException {
		boolean isExists = false;
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			List<String> vndrSeq = new ArrayList<String>();
			for (TrsExptAckRailVndrVO vo : vos) {
				vndrSeq.add(vo.getVndrSeq());
			}
			param.put("arr_vndr_seq", vndrSeq);
			DBRowSet ds = new SQLExecuter().executeQuery(new ExceptionAckRailRoadDBDAOCheckDuplcateVenderRSQL(), param, param);
			if (ds.next()) {
				isExists = ds.getInt(1) > 0 ? true : false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return isExists;
	}
}