/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgColInqmanageDBDAO.java
*@FileTitle : Drop Off Charge Collection Inquiry List
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.common.popup.integration.CommonPopUpManageDBDAOSearchTroSubOfficeRSQL;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0008Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DOFChgColInqmanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class DOFChgColInqmanageDBDAO extends DBDAOSupport {

	/**
	 * Drop Off Charge Collection Inquiry List 조회.<br>
	 * @param EsdEas0008Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgColList(EsdEas0008Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempOfcCd = ""; 
		
		try {
			DOFChgColInqmanageListVO model = event.getDOFChgColInqmanageListVo();
			if( model != null ){
				String search_choice = model.getSearchChoice();
				if(search_choice.equals("MM")){
					model.setSearchChoice("MM");
				}
				
				//ofc_cd 넣는 부분
				if(!model.getCtrlOfcCd().equals("")){
					strCd = new StringTokenizer(model.getCtrlOfcCd(), ",");
					tempOfcCd = strCd.nextToken();
					tempArrL.add(tempOfcCd);
					while(strCd.hasMoreTokens()){
						tempOfcCd = strCd.nextToken();
						tempArrL.add(tempOfcCd);
					}
				}
				
				if(tempArrL.size()>0){
					velParam.put("ctrl_ofc_cd", tempArrL);
				}
				
				if(search_choice.equals("MM")){ 
					velParam.put("search_choice", "MM");
				}
				
				if(!model.getReturnCy().equals("")){
					velParam.put("return_cy", model.getReturnCy());
				}
				
				if(!model.getCustCd().equals("")){
					velParam.put("cust_cd", model.getCustCd());
				}
				
				Map<String, String> velparam = model.getColumnValues();
				param.putAll(velparam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DOFChgColInqmanageDBDAOSearchDofChgColListRSQL(), param, velParam);
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
