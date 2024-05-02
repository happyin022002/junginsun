/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMClosingScheduleMgtDBDAO.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.basic.GEMClosingScheduleMgtBCImpl;
import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.vo.GemMonClzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 GEMClosingScheduleMgtDBDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author choijungmi
 * @see GEMClosingScheduleMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GEMClosingScheduleMgtDBDAO extends DBDAOSupport {

	// C.J.M===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0006] Closing Confirmation & Interface Status
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0006 GEMClosingScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category searchClosingInfo
	 * @param String clzDivCd
	 * @param String year
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GemMonClzVO> searchClosingInfo(String clzDivCd, String year) throws DAOException {
		DBRowSet dbRowset = null;
		List<GemMonClzVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("clz_div_cd", clzDivCd);
			param.put("clz_yrmon", year);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMClosingScheduleMgtDBDAOSearchClosingInfoRSQL(),param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemMonClzVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}

	/**
	 * CPS_GEM_0006 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category addClosingInfo
	 * 
	 * @param insModels
	 *            데이터객체 배열
	 * @throws DAOException
	 */
	public void addClosingInfo(List<GemMonClzVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMClosingScheduleMgtDBDAOAddClosingInfoCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0006 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category removeCloasingInfo
	 * 
	 * @param delModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void removeCloasingInfo(List<GemMonClzVO> delModels) throws DAOException,Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GEMClosingScheduleMgtDBDAORemoveCloasingInfoDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
}
