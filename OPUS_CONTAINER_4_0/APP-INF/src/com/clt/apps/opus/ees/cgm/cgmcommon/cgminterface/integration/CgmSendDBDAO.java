/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmEdiSendEAIDAO.java
*@FileTitle : CgmEdiSendEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : P.K.S
*@LastVersion : 1.0
* 2014.11.25 P.K.S
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.vo.ChassisShipMentFlatFileVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * COM CgmSendDBDAO <br>
 * DB system Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author P.K.S
 * @see CgmEdiInterfaceMgtBC 참조
 * @since J2EE 1.6
 */
public class CgmSendDBDAO  extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
	  * ChassisShipMentFlatFile 조회합니다.<br>
      * @param ChassisShipMentFlatFileVO chassisShipMentFlatFileVO
	  * @return List<ChassisShipMentFlatFileVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<ChassisShipMentFlatFileVO> searchChassisShipMentFlatFile(ChassisShipMentFlatFileVO chassisShipMentFlatFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ChassisShipMentFlatFileVO> chassisShipMentFlatFileVOs = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = chassisShipMentFlatFileVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmSendDBDAOsearchChassisShipMentFlatFileRSQL(), param, velParam);
			 chassisShipMentFlatFileVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, ChassisShipMentFlatFileVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return chassisShipMentFlatFileVOs;
	 }
	 
	 /**
	  * ChassisShipMent Pool 조회.<br>
	  * @return List<ChassisShipMentFlatFileVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<ChassisShipMentFlatFileVO> searchChassisShipmentRecieverData() throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ChassisShipMentFlatFileVO> chassisShipMentFlatFileVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmSendDBDAOsearchChassisShipmentReceiverDataRSQL(), param, velParam);
			 chassisShipMentFlatFileVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, ChassisShipMentFlatFileVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return chassisShipMentFlatFileVOs;
	 }
}
