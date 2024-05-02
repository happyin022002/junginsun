/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeInvoiceDBDAO.java
*@FileTitle : Requested Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CanalTransitFeeInvoiceDBDAO <br>
 * - ALPS-EstimateInvoiceAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see CanalTransitFeeInvoiceBCImpl 참조
 * @since J2EE 1.6
 */
public class CanalTransitFeeInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 분터 Requested Actual Invoice 를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CanalTzFeeInvDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeInvDtlCondVO != null){
				Map<String, String> mapVO = canalTzFeeInvDtlCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeInvDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}