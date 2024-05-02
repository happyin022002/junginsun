/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USADeliveryOrderManageDBDAO.java
 *@FileTitle : USA Delivery Order Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-20
 *@LastModifier : poong yeon cho
 *@LastVersion : 1.0
 * 2008-10-20 poong yeon cho
 * 1.0 최초 생성
 * -------------------------------------------------------
 * history
 * 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.vo.UsaDeliveryOrderManageVO;
import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspUsaDoDtlVO;
import com.clt.syscommon.common.table.TrsTrspUsaDoHdrVO;

/**
 * ENIS-USADeliveryOrderManage에 대한 DB 처리를 담당<br>
 * - ENIS-USADeliveryOrderManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong yeon cho
 * @see USADeliveryOrderManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USADeliveryOrderManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * USADeliveryOrderManage의 Consignee정보searchUSDeliveryOrderConsigneeManage를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSDeliveryOrderConsigneeManage(EsdTrs0083Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSDeliveryOrderConsigneeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * USADeliveryOrderManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSADeliveryOrderManageList(EsdTrs0083Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSDeliveryOrderListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * USADeliveryOrderManage의 저정여부를 알기위해 SO를 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSADeliveryOrderCheck(EsdTrs0083Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		UsaDeliveryOrderManageVO usDoVO = event.getUsaDeliveryOrderManageVO();
		try {
			param.put("bkgNoArr", CommonUtil.seperationParameter(usDoVO.getBookingNo(), ","));
			param.put("blNoArr", CommonUtil.seperationParameter(usDoVO.getBillNo(), ","));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new USADeliveryOrderManageDBDAOSearchUSADeliveryOrderCheckRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		return dRs;
	}

	/**
	 * USADeliveryOrderManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param models 여러 데이타 모델
	 * @see ESD_TRS_083Event
	 * @throws DAOException
	 */
	/**
	 * @param event
	 * @throws DAOException
	 */
	public void multiUSADeliveryOrderManage(EsdTrs0083Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspUsaDoHdrVO[] hdrModels = event.getTrsTrspUsaDoHdrVOs();
		TrsTrspUsaDoDtlVO[] dtlModels = event.getTrsTrspUsaDoDtlVOs();
		int updCnt = 0;
		try {
			TrsTrspUsaDoHdrVO hdrModel = null;
			for (int i = 0; hdrModels != null && i < hdrModels.length; i++) {
				hdrModel = (TrsTrspUsaDoHdrVO) hdrModels[i];
				if (hdrModel.getIbflag().length() > 0) {
					param.put("bl_no", hdrModel.getBlNo());
					param.put("fctry_nm", hdrModel.getFctryNm());
					param.put("act_cust_n1st_addr", hdrModel.getActCustN1stAddr());
					param.put("act_cust_zip_cd", hdrModel.getActCustZipCd());
					param.put("cntc_pson_nm", hdrModel.getCntcPsonNm());
					param.put("cntc_pson_phn_no", hdrModel.getCntcPsonPhnNo());
					param.put("cntc_pson_fax_no", hdrModel.getCntcPsonFaxNo());
					param.put("if_sys_knd_cd", hdrModel.getIfSysKndCd());
					param.put("cre_usr_id", event.getForm_cre_usr_id());
					param.put("upd_usr_id", event.getForm_cre_usr_id());
					param.put("usr_ofc_cd", event.getForm_usr_ofc_cd());
					/* TRS_TRSP_USA_DO_HDR */
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert/update SQL");
					}
				}
			}

			/* TRS_TRSP_USA_DO_DTL */
			TrsTrspUsaDoDtlVO dtlModel = null;
			for (int i = 0; dtlModels != null && i < dtlModels.length; i++) {
				dtlModel = (TrsTrspUsaDoDtlVO) dtlModels[i];
				if (dtlModel.getIbflag().length() > 0) {
					param.put("bl_no", dtlModel.getBlNo());
					param.put("eq_no", dtlModel.getEqNo());
					param.put("do_rmk", dtlModel.getDoRmk());
					param.put("cre_usr_id", event.getForm_cre_usr_id());
					param.put("upd_usr_id", event.getForm_cre_usr_id());
					param.put("usr_ofc_cd", event.getForm_usr_ofc_cd());
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL(), param, param);
					if (updCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert/update SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
}