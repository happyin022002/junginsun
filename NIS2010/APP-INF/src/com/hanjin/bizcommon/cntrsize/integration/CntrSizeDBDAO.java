/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : CntrSizeDBDAO.java
*@FileTitle : CntrSize
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012-02-16 민정호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.cntrsize.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.cntrsize.basic.CntrSizeBCImpl;
import com.hanjin.bizcommon.cntrsize.event.ComCom0003Event;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see CntrSizeBCImpl 참조
 * @since J2EE 1.4
 */
public class CntrSizeDBDAO extends DBDAOSupport {
	
	
	/**
	 * Container Size 의 모든 목록을 가져온다.<br>
	 * @param MdmCntrSzListVO mdmCntrSzListVO
	 * @return List<MdmCntrSzListVO>
	 * @throws DAOException
	 */
	public int totalCntrSize(Event et) throws DAOException {
		DBRowSet dbRowset = null;
    	// PDTO(Data Transfer Object including Parameters)
		ComCom0003Event event=(ComCom0003Event)et;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try {
			if(!event.getCntr_sz_cd().equals("")) {
				param.put("cntr_sz_cd", event.getCntr_sz_cd());
				velParam.put("cntr_sz_cd", event.getCntr_sz_cd());
			}
			if(!event.getCntr_sz_desc().equals("")) {
				param.put("cntr_sz_desc", event.getCntr_sz_desc());
				velParam.put("cntr_sz_desc", event.getCntr_sz_desc());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrSizeDBDAOTotalCntrSzRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;	
	}
	
	/**
	 * CntrTpSz의 모든 목록을 가져온다.<br>
	 * @param et COM_ENS_0G1Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrSizeList(Event et) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		ComCom0003Event event=(ComCom0003Event)et;
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = event.getIPage();
		int startpart   = Constants.PAGE_SIZE_50 * (currentPage - 1) + 1;
		int endpart     = Constants.PAGE_SIZE_50 * currentPage;
		try{
			if(!event.getCntr_sz_cd().equals("")) {
				param.put("cntr_sz_cd", event.getCntr_sz_cd());
				velParam.put("cntr_sz_cd", event.getCntr_sz_cd());
			}
			if(!event.getCntr_sz_desc().equals("")) {
				param.put("cntr_sz_desc", event.getCntr_sz_desc());
				velParam.put("cntr_sz_desc", event.getCntr_sz_desc());
			}
			param.put("startpart", startpart);
			param.put("endpart", endpart);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrSizeDBDAOMdmCntrSzListRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}