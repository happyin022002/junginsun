/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVslBlkDBDAO
 *@FileTitle : ENIS MDM Vessel Bulk Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-01-19
 *@LastModifier : Seyeong Yoon
 *@LastVersion : 1.0
 * 2010-01-19 Seyeong Yoon
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmVslBlkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Seyeong Yoon
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVslBlkDBDAO extends DBDAOSupport {
	
	/**
	 * 기존 데이타 유무 검색
	 * @param String vsl_cd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchMdmVslBlk(String vsl_cd) throws DAOException{
		boolean isSuccessful = false; 	
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vsl_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmVslBlkDBDAOSearchMdmVslBlkRSQL(), param, null);

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
	 * @param mdmVslBlkVO MdmVslBlkVO
	 * @return
	 * @throws DAOException
	 */
	public int addMdmVslBlk(MdmVslBlkVO mdmVslBlkVO) throws DAOException {
		int insCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mdmVslBlkVO.getColumnValues();

			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}				
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVslBlkDBDAOCreateMdmVslBlkCSQL(),  param, velParam);		

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
	 * @param mdmVslBlkVO MdmVslBlkVO
	 * @return
	 * @throws DAOException
	 */
	public int modifyMdmVslBlk(MdmVslBlkVO mdmVslBlkVO) throws DAOException {
		int uptCnt = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mdmVslBlkVO.getColumnValues();

			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}				
			
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVslBlkDBDAOModifyMdmVslBlkUSQL(),  param, velParam);		

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
	 * @param mdmVslBlkVO MdmVslBlkVO
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmVslBlk(MdmVslBlkVO mdmVslBlkVO) throws DAOException {

		int delCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = mdmVslBlkVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
				
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVslBlkDBDAORemoveMdmVslBlkDSQL(),  param, velParam);			

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
