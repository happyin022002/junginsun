/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USDemurrageAuditDBDAO.java
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.25 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic.USDemurrageAuditBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS USDemurrageAuditDBDAO <br>
 * - ALPS-DMTInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Sung Hwan
 * @see USDemurrageAuditBCImpl 참조
 * @since J2EE 1.6
 */
public class USDemurrageAuditDBDAO extends DBDAOSupport {

	/**
	 * [3rd Party DEM/DET Collection Audit]을 [조회] 합니다.<br>
	 * 
	 * @param ChargeForAuditParmVO chargeForAuditParmVO
	 * @return ChargeForAuditVO 
	 * @throws DAOException
	 */
	public ChargeForAuditVO searchChargeForAudit(ChargeForAuditParmVO chargeForAuditParmVO) throws DAOException {		 
		 
		DBRowSet dbRowset = null;
		ChargeForAuditVO chargeForAuditVO = new ChargeForAuditVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chargeForAuditParmVO != null){
				Map<String, String> mapVO = chargeForAuditParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new USDemurrageAuditDBDAOChargeForAuditRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				chargeForAuditVO.setCntrNo(dbRowset.getString("cntr_no"));
				chargeForAuditVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				chargeForAuditVO.setCalFromDt(dbRowset.getString("cal_from_dt"));
				chargeForAuditVO.setCalToDt(dbRowset.getString("cal_to_dt"));
				chargeForAuditVO.setCalFtEnd(dbRowset.getString("cal_ft_end"));
				chargeForAuditVO.setCalOver(dbRowset.getString("cal_over"));
				chargeForAuditVO.setCurrCd(dbRowset.getString("curr_cd"));
				chargeForAuditVO.setCalCollection(dbRowset.getString("cal_collection"));
				chargeForAuditVO.setFmMvmtYdCd(dbRowset.getString("fm_mvmt_yd_cd"));
				chargeForAuditVO.setFtCmncDt(dbRowset.getString("ft_cmnc_dt"));
				chargeForAuditVO.setFtDys(dbRowset.getString("ft_dys"));
				chargeForAuditVO.setScNo(dbRowset.getString("sc_no"));
				chargeForAuditVO.setRfaNo(dbRowset.getString("rfa_no"));
				chargeForAuditVO.setExceptionAmt(dbRowset.getString("exception_amt"));
				chargeForAuditVO.setAftExptAmt(dbRowset.getString("aft_expt_amt"));
				chargeForAuditVO.setVvd(dbRowset.getString("vvd"));
				chargeForAuditVO.setBkgNo(dbRowset.getString("bkg_no"));
				chargeForAuditVO.setBlNo(dbRowset.getString("bl_no"));
				chargeForAuditVO.setDmdtChgStsCd(dbRowset.getString("dmdt_chg_sts_cd"));
				chargeForAuditVO.setSvrId(dbRowset.getString("svr_id"));
				chargeForAuditVO.setCntrCycNo(dbRowset.getString("cntr_cyc_no"));
				chargeForAuditVO.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				chargeForAuditVO.setDmdtChgLocDivCd(dbRowset.getString("dmdt_chg_loc_div_cd"));
				chargeForAuditVO.setChgSeq(dbRowset.getString("chg_seq"));
				chargeForAuditVO.setDmdtDeltRqstStsCd(dbRowset.getString("dmdt_delt_rqst_sts_cd"));
				chargeForAuditVO.setOfcCd(dbRowset.getString("ofc_cd"));

			} else {
				log.debug("============================================================================");
				log.debug(" searchChargeForAudit:::: No Data");
				log.debug("============================================================================");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chargeForAuditVO;
	}
}