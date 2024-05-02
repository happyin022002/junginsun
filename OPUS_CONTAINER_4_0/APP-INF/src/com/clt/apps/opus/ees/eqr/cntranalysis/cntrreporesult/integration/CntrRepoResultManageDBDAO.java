/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoResultManageDBDAO.java
*@FileTitle : CntrRepoResultManageDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS CntrRepoResultManageDBDAO <br>
 * - OPUS-RepoPlanManage system Business Logic.<br>
 * 
 * @author Bong-jun,Yang
 * @see CntrRepoResultManageBCImpl
 * @since J2EE 1.6
 */
public class CntrRepoResultManageDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5286258241547689347L;

	/**
	 * [EES_EQR_0144 : Empty Repo Result }<br>
	 * 
	 * @param EmptyRepoResultOptionVO emptyRepoResultOptionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchEmptyRepoResult(EmptyRepoResultOptionVO emptyRepoResultOptionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(emptyRepoResultOptionVO != null){
				Map<String, String> mapVO = emptyRepoResultOptionVO.getColumnValues();
			
			ArrayList arrFmLoc = (ArrayList) Utils.replaceStrToList(emptyRepoResultOptionVO.getFmloc());
			ArrayList arrToLoc = (ArrayList) Utils.replaceStrToList(emptyRepoResultOptionVO.getToloc());
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(emptyRepoResultOptionVO.getCntrtpszcd());
			ArrayList arrMode = (ArrayList) Utils.replaceStrToList(emptyRepoResultOptionVO.getTransmode());
			
			String isUnion = "FALSE";
			if (emptyRepoResultOptionVO.getTransmode().indexOf("ALL") != -1 || emptyRepoResultOptionVO.getTransmode().indexOf("RD") != -1) {
				isUnion = "TRUE";
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("arrFmLoc", arrFmLoc);
			velParam.put("arrToLoc", arrToLoc);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrMode", arrMode);
			velParam.put("isUnion", isUnion);
			
			log.info(" ★");
			log.info("getFmDate : "+emptyRepoResultOptionVO.getFmdate());
			log.info("getFmLoc : "+emptyRepoResultOptionVO.getFmloc());
			log.info("getFmLocTp : "+emptyRepoResultOptionVO.getFmloctp());
			log.info("getPeriod : "+emptyRepoResultOptionVO.getPeriod());
			log.info("getToDate : "+emptyRepoResultOptionVO.getTodate());
			log.info("getToLoc : "+emptyRepoResultOptionVO.getToloc());
			log.info("getToLocTp : "+emptyRepoResultOptionVO.getToloctp());
			log.info("getTpSz : "+emptyRepoResultOptionVO.getTpsz());
			log.info("getTransMode : "+emptyRepoResultOptionVO.getTransmode());
			log.info("getCntrtpszcd : "+emptyRepoResultOptionVO.getCntrtpszcd());
			log.info(" ★");
			
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoResultManageDBDAOSearchResultListRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
}