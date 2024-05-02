/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkwardCargoCommonDBDAO.java
*@FileTitle : TES의 Awkward Cargo 공용 작업
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2013-03-21
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargocommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.syscommon.common.table.TesAwkCgoErrLogVO;


/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see ApprovalStepSendBCImpl 참조
 * @since J2EE 1.4
 */
public class AwkwardCargoCommonDBDAO extends DBDAOSupport {
	
	/**
	 * Awkward Cargo의 공통 Error 기록
	 * @param actCostErrLogVO
	 * @throws DAOException
	 */
	public void logAwkCgoCommErrMsg(TesAwkCgoErrLogVO actCostErrLogVO) throws DAOException {
		log.debug("\n BEGIN - AwkwardCargoCommonDBDAO.logAwkCgoCommErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (actCostErrLogVO!=null){
				param.put("tml_awk_cgo_err_tp_cd", JSPUtil.getNull(actCostErrLogVO.getTmlAwkCgoErrTpCd()));
				param.put("err_log_rmk", JSPUtil.getNull(actCostErrLogVO.getErrLogRmk()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AwkwardCargoCommonDBDAOLogAwkCgoCommErrMsgCSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			}
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
		log.debug("\n END - AwkwardCargoCommonDBDAO.logAwkCgoCommErrMsg - ########################################### ");
	}

}