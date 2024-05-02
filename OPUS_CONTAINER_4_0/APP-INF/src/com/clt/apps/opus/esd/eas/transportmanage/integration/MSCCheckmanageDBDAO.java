/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MSCCheckmanageDAO.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 ���� ��
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0006Event;
import com.clt.apps.opus.esd.eas.transportmanage.vo.SearchMscCheckListVO;
import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * MSCCheckmanageDAO PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see DBDAOSupport ��v
 * @since J2EE 1.4
 */
public class MSCCheckmanageDBDAO extends DBDAOSupport {


	/**
	 * MSC Search List
	 * @param EsdEas0006Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchMSCList(EsdEas0006Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList<String> arrCreOfcCd = null;
		
		try{
			
			SearchMscCheckListVO model = event.getSearchMscCheckListVo();
			
	        String str_ctrl_ofc_cd   =  model.getCtrlOfcCd();
	        String str_s_bnd         =  model.getSBnd();
	        String str_tromonth      =  model.getTromonth();
	        String str_fromtrodate   =  model.getFromtrodate();
	        String str_totrodate     =  model.getTotrodate();
			if(event != null && !"".equals(str_ctrl_ofc_cd)){
				arrCreOfcCd = CommonUtil.seperationParameter(str_ctrl_ofc_cd, ",");
			}
			
			param.put("fromtrodate", str_fromtrodate);
			param.put("totrodate"  , str_totrodate);
			param.put("tromonth"   , str_tromonth);
			param.put("s_bnd"      , str_s_bnd);
			param.put("arrCreOfcCd", arrCreOfcCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new MSCCheckmanageDBDAOSearchMSCListRSQL(), param, param);
			
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
	 * User가 선택한 Office의 하위 Office를 찾아옴.
	 * @param EsdEas0006Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSubOfcList(EsdEas0006Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList<String> arrCreOfcCd = null;
		
		try{
			
			SearchMscCheckListVO model = event.getSearchMscCheckListVo();
			
			String strCreOfcCd = model.getCtrlOfcCd();
			if(event != null && !"".equals(strCreOfcCd)){
				arrCreOfcCd = CommonUtil.seperationParameter(strCreOfcCd, ",");
			}
			
			param.put("asoOfc" , arrCreOfcCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new MSCCheckmanageDBDAOSearchSubOfcListRSQL(), param, param);
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

}
