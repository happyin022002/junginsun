/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CNTR_VENDOR_CLASSDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCntrVndrClssVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4 
 */
public class ReceiveQueueMdmCntrVndrClssDBDAO extends DBDAOSupport{
	
	public boolean addMdmCntrVndrClss(List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs) throws DAOException {
		boolean isSuccessful = false; 

		try {
			int rowCnt[] = null;

			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmCntrVndrClssDBDAOAddMdmCntrVndrClssCSQL(),
					mdmCntrVndrClssVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 
	}
	
	public boolean addMdmCntrVndrClss(MdmCntrVndrClssVO mdmCntrVndrClssVO) throws DAOException {
		boolean isSuccessful = false; 

		try {
			int rowCnt = 0;

			if (mdmCntrVndrClssVO != null
				&&
				(mdmCntrVndrClssVO.getVndrSeq() != null && mdmCntrVndrClssVO.getVndrSeq().trim().length() > 0)
				&&
				(mdmCntrVndrClssVO.getVndrCostCd() != null && mdmCntrVndrClssVO.getVndrCostCd().trim().length() > 0)
				&&
				(mdmCntrVndrClssVO.getCntrVndrSvcCd() != null && mdmCntrVndrClssVO.getCntrVndrSvcCd().trim().length() > 0)
			) {
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.putAll(mdmCntrVndrClssVO.getColumnValues());
				velParam.putAll(mdmCntrVndrClssVO.getColumnValues());
						
				SQLExecuter sqlExe = new SQLExecuter("");

				rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmCntrVndrClssDBDAOAddMdmCntrVndrClssCSQL(),
						param, velParam);
				
				isSuccessful = (rowCnt != 0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 
	}
	
	public boolean modifyMdmCntrVndrClss(MdmCntrVndrClssVO mdmCntrVndrClssVO) throws DAOException {
		boolean isSuccessful = false; 

		try {
			int rowCnt = 0;

			if (mdmCntrVndrClssVO != null
					&&
					(mdmCntrVndrClssVO.getVndrSeq() != null && mdmCntrVndrClssVO.getVndrSeq().trim().length() > 0)
					&&
					(mdmCntrVndrClssVO.getVndrCostCd() != null && mdmCntrVndrClssVO.getVndrCostCd().trim().length() > 0)
					&&
					(mdmCntrVndrClssVO.getCntrVndrSvcCd() != null && mdmCntrVndrClssVO.getCntrVndrSvcCd().trim().length() > 0)
				) {
				SQLExecuter sqlExe = new SQLExecuter("");

				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.putAll(mdmCntrVndrClssVO.getColumnValues());
				velParam.putAll(mdmCntrVndrClssVO.getColumnValues());

				rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmCntrVndrClssDBDAOModifyMdmCntrVndrClssUSQL(),
						param, velParam);
				
				isSuccessful = (rowCnt != 0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 
	}
	
	/**
	 * 기존 데이타 유무 검색
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCntrVndrClss(MdmCntrVndrClssVO mdmCntrVndrClssVO) throws DAOException{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.putAll(mdmCntrVndrClssVO.getColumnValues());
		velParam.putAll(mdmCntrVndrClssVO.getColumnValues());
		
		boolean isExisted = false;
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReceiveQueueMdmCntrVndrClssDBDAOSearchMdmCntrVndrClssRSQL(),
					param, velParam);
			
			isExisted = dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExisted;
	}
	
	/**
	 * Delete
	 * @param mdmCntrVndrClssVO
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmCntrVndrClss(MdmCntrVndrClssVO mdmCntrVndrClssVO) throws DAOException{

		boolean isSuccessful = false;		
		try {
			
			int rowCnt = 0;
			
			if (mdmCntrVndrClssVO != null
					&&
					(mdmCntrVndrClssVO.getVndrSeq() != null && mdmCntrVndrClssVO.getVndrSeq().trim().length() > 0)
					&&
					(mdmCntrVndrClssVO.getVndrCostCd() != null && mdmCntrVndrClssVO.getVndrCostCd().trim().length() > 0)
					&&
					(mdmCntrVndrClssVO.getCntrVndrSvcCd() != null && mdmCntrVndrClssVO.getCntrVndrSvcCd().trim().length() > 0)
				) {
				SQLExecuter sqlExe = new SQLExecuter("");

				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.putAll(mdmCntrVndrClssVO.getColumnValues());
				velParam.putAll(mdmCntrVndrClssVO.getColumnValues());

				rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmCntrVndrClssDBDAORemoveMdmCntrVndrClssDSQL(),
						param, velParam);
				
				isSuccessful = (rowCnt != 0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		return isSuccessful; 	
	}
	
	public boolean removeMdmCntrVndrClss(List<MdmCntrVndrClssVO> mdmCntrVndrClssVOs) throws DAOException {
		boolean isSuccessful = false; 

		try {
			int rowCnt[] = null;

			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmCntrVndrClssDBDAORemoveMdmCntrVndrClssDSQL(),
					mdmCntrVndrClssVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 
	}
}

