/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CHKMAIL_ADDRDBDAO
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-22
 *@LastModifier : yujin
 *@LastVersion : 1.0
 * 2007-10-22 yujin
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCarrierVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author yujin
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCarrierDBDAO extends DBDAOSupport {
	
	/**
	 * 기존 데이타 유무 검색
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCarrier(String crr_cd) throws DAOException{
		boolean isSuccessful = false; 	
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("crr_cd", crr_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmCarrierDBDAOSearchMdmCarrierRSQL(), param, null);

//			if(dbRowset.next()){
				if(dbRowset.getRowCount() <= 0) isSuccessful = true;
//			}
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
		
		return isSuccessful;
	}

	/** 
	 * insert
	 * @param mdmCarrierVO MdmCarrierVO
	 * @return
	 * @throws DAOException
	 */
	public int addMdmCarrier(MdmCarrierVO mdmCarrierVO) throws DAOException {
		int insCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mdmCarrierVO.getColumnValues();

			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}				
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCarrierDBDAOCreateMdmCarrierCSQL(),  param, velParam);		

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
		
		return insCnt;
	}
	
	/** 
	 * modify
	 * @param mdmCarrierVO MdmCarrierVO
	 * @return
	 * @throws DAOException
	 */
	public int modifyMdmCarrier(MdmCarrierVO mdmCarrierVO) throws DAOException {
		int uptCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mdmCarrierVO.getColumnValues();

			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}				
			
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCarrierDBDAOModifyMdmCarrierUSQL(),  param, velParam);		

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
		
		return uptCnt;
	}

	/** 
	 * remove
	 * @param mdmCarrierVO MdmCarrierVO
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmCarrier(MdmCarrierVO mdmCarrierVO) throws DAOException {

		int delCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = mdmCarrierVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
				
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCarrierDBDAORemoveMdmCarrierDSQL(),  param, velParam);			

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
		return delCnt;
	}
	

}
