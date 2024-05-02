/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonPopUpManageDBDAO.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.common.popup.basic.CommonPopUpManageBCImpl;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0001Event;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0002Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;



/**
 * ESD-EAS에 대한 DB 처리를 담당<br>
 * - ESD-EAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author yujin
 * @see CommonPopUpManageBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonPopUpManageDBDAO extends DBDAOSupport {

	/**
	 * Common Office의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdEasCom0001Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchServiceOfficeCodeManage(EsdEasCom0001Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sCtrl_ofc_cd = event.getCtrl_ofc_cd();
//		String sCtrl_ofc_cd = event.getSel_ofc_cd();
		
		try{
			param.put("ofc_cd", sCtrl_ofc_cd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CommonPopUpManageDBDAOSearchServiceOfficeCodeManageRSQL(), param, param);
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
		
		return dbRowset;
	}
	
	/**
	 * Common Office의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdEasCom0002Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchServiceOfficeCodeManage2(EsdEasCom0002Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sCtrl_ofc_cd = event.getDOFChgColInqmanageListVo().getCtrlOfcCd();
		try{
			param.put("ofc_cd", sCtrl_ofc_cd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CommonPopUpManageDBDAOSearchServiceOfficeCodeManageRSQL(), param, param);
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
		
		return dbRowset;
	}
	
	/**
	 * TRO SUB Office조회
	 * 
	 * @param event EsdEasCom0002Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTroSubOfc(EsdEasCom0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempOfcCd = ""; 
		
		try {
			if(event != null){
				
				//ofc_cd 넣는 부분
				if(!event.getDOFChgColInqmanageListVo().getSrcOfc().equals("")){
					strCd = new StringTokenizer(event.getDOFChgColInqmanageListVo().getSrcOfc(), ",");
					tempOfcCd = strCd.nextToken();
					tempArrL.add(tempOfcCd);
					while(strCd.hasMoreTokens()){
						tempOfcCd = strCd.nextToken();
						tempArrL.add(tempOfcCd);
					}
				}
				if(tempArrL.size()>0){
					velParam.put("ofc_cd", tempArrL);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonPopUpManageDBDAOSearchTroSubOfficeRSQL(), param, velParam);
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
}
