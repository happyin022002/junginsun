/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : CntrTypeDBDAO.java
*@FileTitle : CntrType
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012-02-16 민정호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.cntrtype.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.cntrtype.basic.CntrTypeBCImpl;
import com.hanjin.bizcommon.cntrtype.event.ComCom0002Event;
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
public class CntrTypeDBDAO extends DBDAOSupport {
	
	
	/**
	 * Container Size 의 모든 목록을 가져온다.<br>
	 * @param MdmCntrSzListVO mdmCntrSzListVO
	 * @return List<MdmCntrSzListVO>
	 * @throws DAOException
	 */
	public int totalCntrType(Event et) throws DAOException {
		DBRowSet dbRowset = null;
    	// PDTO(Data Transfer Object including Parameters)
		ComCom0002Event event=(ComCom0002Event)et;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try {
			if(!event.getCntr_tp_cd().equals("")) {
				param.put("cntr_tp_cd", event.getCntr_tp_cd());
				velParam.put("cntr_tp_cd", event.getCntr_tp_cd());
			}
			if(!event.getCntr_tp_desc().equals("")) {
				param.put("cntr_tp_desc", event.getCntr_tp_desc());
				velParam.put("cntr_tp_desc", event.getCntr_tp_desc());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrTypeDBDAOTotalCntrTpRSQL(), param, velParam);
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
	public DBRowSet searchCntrTypeList(Event et) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		ComCom0002Event event=(ComCom0002Event)et;
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int currentPage = event.getIPage();
		int startpart   = Constants.PAGE_SIZE_50 * (currentPage - 1) + 1;
		int endpart     = Constants.PAGE_SIZE_50 * currentPage;
		try{
			if(!event.getCntr_tp_cd().equals("")) {
				param.put("cntr_tp_cd", event.getCntr_tp_cd());
				velParam.put("cntr_tp_cd", event.getCntr_tp_cd());
			}
			if(!event.getCntr_tp_desc().equals("")) {
				param.put("cntr_tp_desc", event.getCntr_tp_desc());
				velParam.put("cntr_tp_desc", event.getCntr_tp_desc());
			}
			param.put("startpart", startpart);
			param.put("endpart", endpart);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrTypeDBDAOMdmCntrTpListRSQL(), param, velParam);
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