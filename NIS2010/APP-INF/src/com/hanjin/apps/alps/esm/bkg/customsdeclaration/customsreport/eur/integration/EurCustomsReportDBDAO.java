/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsReportDBDAO.java
 *@FileTitle : EurCustomsReportDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.basic.EurCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.vo.EurSearchSendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.vo.EurSearchSendLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 CndCustomsReportDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see EurCustomsReportBCImpl 참조
 * @since J2EE 1.6
 */
public class EurCustomsReportDBDAO extends DBDAOSupport {

	/**
	 * 구주 지역 CTA 전송 로그를 B/L별로 조회 함<br>
	 * 
	 * @param  EurSearchSendLogCondVO eurSearchSendLogCondVO
	 * @return List<SendLogDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SendLogDetailVO> searchSendLog(EurSearchSendLogCondVO eurSearchSendLogCondVO) throws DAOException {

		List<SendLogDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (eurSearchSendLogCondVO != null) {
				Map<String, String> mapVO = eurSearchSendLogCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsReportDBDAOsearchSendLogInEURRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EurSearchSendLogDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}