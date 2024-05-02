/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CHAuditTroArmanageDBDAO.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
* N200903200050 EAS 보완요청 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event;
import com.clt.apps.opus.esd.eas.transportmanage.vo.ChAuditTroArManageVO;
import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * CHAuditTroArmanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see DBDAOSupport 참조
 * @since J2EE 1.4
 */
public class CHAuditTroArmanageDBDAO extends DBDAOSupport {

    /**
     * C/H Audit Main Search의 목록을 가져온다.<br>
     * 
     * @param EsdEas0004Event event 검색조건을 담고 있는 ChAuditTroArManageVO 객체
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     * * N200903200050 EAS 보완요청 
     */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChAuditList(EsdEas0004Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList<String> arrCreOfcCd = null;
		
		try{
			ChAuditTroArManageVO model = event.getChAuditTroArManageVo();
			
			String strCreOfcCd = model.getCtrlOfcCd();
			if(event != null && !"".equals(strCreOfcCd)){
				arrCreOfcCd = CommonUtil.seperationParameter(strCreOfcCd, ",");
			}
			
			param.put("str_bkgno"          , model.getBkgno());
//			param.put("bkg_no_split"    , model.getBkgno());
			param.put("str_blno"           , model.getBlno());
//			param.put("bl_no_tp"        , model.getBlno());
//			param.put("bl_no_chk"       , model.getBlno());
			param.put("str_somonth"     , model.getSomonth());
			param.put("str_invmonth"    , model.getInvmonth());
			param.put("str_fromsodate"  , model.getFromsodate());
			param.put("str_tosodate"    , model.getTosodate());
			param.put("str_frominvdate" , model.getFrominvdate());
			param.put("str_toinvdate"   , model.getToinvdate());
			param.put("str_vvdno"       , model.getVvdno());
			param.put("arrCreOfcCd"     , arrCreOfcCd);
			param.put("str_s_type"      , model.getSType());
			param.put("str_s_bnd"       , model.getSBnd());
			param.put("str_dtltype"       , model.getSDtltype());
			param.put("data_type"       , model.getDType());
			log.info("model.getSDtltype()"+model.getSDtltype());
			
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CHAuditTroArmanageDBDAOSearchChAuditListRSQL(), param, param);
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

    
    /** searchChAuditBKGList <br>
     * 
     * @param EsdEas0004Event event
     * @return DBRowSet
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChAuditBKGList(EsdEas0004Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList<String> arrCreOfcCd = null;
		
		try{
			ChAuditTroArManageVO model = event.getChAuditTroArManageVo();
			
			String strCreOfcCd = model.getCtrlOfcCd();
			if(event != null && !"".equals(strCreOfcCd)){
				arrCreOfcCd = CommonUtil.seperationParameter(strCreOfcCd, ",");
			}
			
			param.put("str_bkgno"       , model.getBkgno());
			param.put("str_somonth"     , model.getSomonth());
			param.put("str_invmonth"    , model.getInvmonth());
			param.put("str_fromsodate"  , model.getFromsodate());
			param.put("str_tosodate"    , model.getTosodate());
			param.put("str_frominvdate" , model.getFrominvdate());
			param.put("str_toinvdate"   , model.getToinvdate());
			param.put("str_s_bnd"       , model.getSBnd());
			param.put("str_vvdno"       , model.getVvdno());
			param.put("str_s_type"      , model.getSType());
			param.put("data_type"       , model.getDType());
			param.put("arrCreOfcCd"     , arrCreOfcCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CHAuditTroArmanageDBDAOSearchChAuditBKGListRSQL(), param, param);
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

	/** searchSubOfficeList <br>
	 * 
	 * @param EsdEas0004Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSubOfficeList(EsdEas0004Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList<String> arrCreOfcCd = null;
		
		try{
			
			ChAuditTroArManageVO model = event.getChAuditTroArManageVo();
			
			String strCreOfcCd = model.getCtrlOfcCd();
			if(event != null && !"".equals(strCreOfcCd)){
				arrCreOfcCd = CommonUtil.seperationParameter(strCreOfcCd, ",");
			}
			
			param.put("asoOfc" , arrCreOfcCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CHAuditTroArmanageDBDAOSearchSubOfficeListRSQL(), param, param);
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
