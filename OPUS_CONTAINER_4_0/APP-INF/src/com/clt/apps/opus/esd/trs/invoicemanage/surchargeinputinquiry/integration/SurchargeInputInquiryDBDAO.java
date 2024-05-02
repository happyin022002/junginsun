/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SurchargeInputInquiryDBDAO.java
 *@FileTitle : surcharge 입력/수정/삭제화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-03-17
 *@LastModifier : Bong-jun
 *@LastVersion : 1.8
 * 2006-11-21 poong_yeon
 * 1.0 최초 생성
 * 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.searchWorkOrderIssueListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-InvoiceManage에 대한 DB 처리를 담당<br>
 * - ESD-InvoiceManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see SurchargeInputInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class SurchargeInputInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * SurchargeInputInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @param singleVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException 2014.12.11 Modified by Hyungwook Choi
	 */
	public DBRowSet searchSurchargeInputInquiryList(EsdTrs0918Event event, searchWorkOrderIssueListVO singleVO) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			String trsp_so_ofc_cty_cd = event.getTrspSoOfcCtyCd();
			String trsp_so_seq = event.getTrspSoSeq();

			param.put("TRSP_SO_OFC_CTY_CD", trsp_so_ofc_cty_cd);
			param.put("TRSP_SO_SEQ", trsp_so_seq);

			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL(), param, param);

			// 2014.12.11 Hyungwook Choi
			if (singleVO != null) {
				Map<String, String> mapVO = singleVO.getColumnValues();
				param.putAll(mapVO);
			}
			if (dRs.getRowCount() == 0) {
				dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListByAgreementRSQL(), param, param);
			}

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
	 * surcharge의 모든 코드와 코드명을 가지고 온다 .<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSurchargeCodeNameList(EsdTrs0918Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL(), param, param);
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
	 * 서차지 항목을 temp 에 추가.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public String addTempSurchargeList(EsdTrs0918Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SurchargeVO[] scModels = event.getSurchargeVOs();
		SurchargeVO scModel = null;
		String groupSeq = "";
		try {
			/* TEMP GROUP SEQ SELECT */
			DBRowSet dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL(), param, param);
			dRs.next();
			groupSeq = dRs.getString("GROUP_SEQ");
			/***** surcharge insert start ****/
			if (scModels != null && scModels.length > 0) {
				for (int i = 0; i < scModels.length; i++) {
					scModel = scModels[i];
					param.put("TRSP_SO_OFC_CTY_CD", scModel.getTrspSoOfcCtyCd());
					param.put("TRSP_SO_SEQ", scModel.getTrspSoSeq());
					param.put("LGS_COST_CD", scModel.getLgsCostCd());
					param.put("SCG_DTL_SEQ", (i + 1));
					param.put("WO_PRV_GRP_SEQ", groupSeq);
					param.put("SCG_AMT", JSPUtil.removeCharacter(scModel.getScgAmt(), ","));
					param.put("DRY_RUN_RLBL_PTY_TP_CD", scModel.getDryRunRlblPtyTpCd());
					param.put("FNE_CUZ_DESC", scModel.getFneCuzDesc());
					param.put("FUMG_COST_TP_CD", scModel.getFumgCostTpCd());
					param.put("MGST_TPSZ_CD", scModel.getMgstTpszCd());
					param.put("INSP_RF_PTI_CSTMS_TP_CD", scModel.getInspRfPtiCstmsTpCd());
					param.put("LFTG_KNT", scModel.getLftgKnt());
					param.put("LFTG_CUZ_DESC", scModel.getLftgCuzDesc());
					param.put("STOP_LOC_NOD_CD", scModel.getStopLocNodCd());
					param.put("GRS_WGT", JSPUtil.removeCharacter(scModel.getGrsWgt(), ","));
					param.put("INCRT_DT", scModel.getIncrtDt());
					param.put("SCL_STOP_PLC_NOD_CD", scModel.getSclStopPlcNodCd()); // sclStopPlcNodCd
					param.put("STO_DYS", scModel.getStoDys());
					param.put("OB_BKG_NO", scModel.getObBkgNo());
					param.put("WT_HRS", scModel.getWtHrs());
					param.put("OTR_RMK", scModel.getOtrRmk());
					param.put("INV_SCG_AMT", JSPUtil.removeCharacter(scModel.getInvScgAmt(), ",")); // invScgAmt
					param.put("INV_DRY_RUN_RLBL_PTY_TP_CD", scModel.getInvDryRunRlblPtyTpCd()); // invDryRunRlblPtyTpCd
					param.put("INV_FNE_CUZ_DESC", scModel.getInvFneCuzDesc()); // invFneCuzDesc
					param.put("INV_FUMG_COST_TP_CD", scModel.getInvFumgCostTpCd()); // invFumgCostTpCd
					param.put("INV_MGST_TPSZ_CD", scModel.getInvMgstTpszCd()); // invMgstTpszCd
					param.put("INV_INSP_RF_PTI_CSTMS_TP_CD", scModel.getInvInspRfPtiCstmsTpCd());// invInspRfPtiCstmsTpCd
					param.put("INV_LFTG_KNT", scModel.getInvLftgKnt()); // invLftgKnt
					param.put("INV_LFTG_CUZ_DESC", scModel.getInvLftgCuzDesc()); // invLftgCuzDesc
					param.put("INV_STOP_LOC_NOD_CD", scModel.getInvStopLocNodCd()); // invStopLocNodCd
					param.put("INV_GRS_WGT", JSPUtil.removeCharacter(scModel.getInvGrsWgt(), ",")); // invGrsWgt
					param.put("INV_INCRT_DT", scModel.getInvIncrtDt()); // invIncrtDt
					param.put("INV_SCL_STOP_PLC_NOD_CD", scModel.getInvSclStopPlcNodCd()); // invSclStopPlcNodCd
					param.put("INV_STO_DYS", scModel.getInvStoDys()); // invStoDys
					param.put("INV_OB_BKG_NO", scModel.getInvObBkgNo()); // invObBkgNo
					param.put("INV_WT_HRS", scModel.getInvWtHrs()); // invWtHrs
					param.put("INV_OTR_RMK", scModel.getInvOtrRmk()); // invOtrRmk
					param.put("N3PTY_BIL_FLG", scModel.getN3ptyBilFlg());
					param.put("CUST_CNT_CD", scModel.getCustCntCd());
					param.put("CUST_SEQ", scModel.getCustSeq());
					param.put("N3PTY_VNDR_SEQ", scModel.getN3ptyVndrSeq());
					param.put("N3PTY_OFC_CD", scModel.getN3ptyOfcCd());
					param.put("N3PTY_AMT", JSPUtil.removeCharacter(scModel.getN3ptyAmt(), ","));
					param.put("N3PTY_DESC", scModel.getN3ptyDesc());
					param.put("CRE_OFC_CD", event.getFormUsrOfcCd());
					param.put("CRE_USR_ID", event.getFormCreUsrId());
					param.put("UPD_USR_ID", event.getFormCreUsrId());
					param.put("FOR_USR_OFC_CD", event.getFormUsrOfcCd());
					param.put("INCUR_DT", scModel.getIncurDt());
					param.put("CHSS_NO", scModel.getChssNo());
					param.put("INV_INCUR_DT", scModel.getInvIncurDt());
					param.put("INV_CHSS_NO", scModel.getInvChssNo());

					param.put("FUEL_RTO", scModel.getFuelRto());
					param.put("TRSP_AGMT_OFC_CTY_CD", scModel.getTrspAgmtOfcCtyCd());
					param.put("TRSP_AGMT_SEQ", scModel.getTrspAgmtSeq());
					param.put("TRSP_AGMT_RT_TP_SER_NO", scModel.getTrspAgmtRtTpSerNo());
					param.put("TRSP_AGMT_SCG_NOD_SEQ", scModel.getTrspAgmtScgNodSeq());
					param.put("TRSP_AGMT_SCG_RT_SEQ", scModel.getTrspAgmtScgRtSeq());
					param.put("COM_SCG_KND_CD", scModel.getComScgKndCd());
					param.put("COM_SCG_SEQ", scModel.getComScgSeq());

					param.put("CURR_CD", scModel.getCurrCd());
					param.put("ORG_SCG_AMT", scModel.getOrgScgAmt());
					new SQLExecuter().executeUpdate(new SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL(), param, param);
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
		return groupSeq;
	}

	/**
	 * SurchargeInputInquiry의 모든 목록을 가져온다.<br>
	 * 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTPBIfFlag(EsdTrs0918Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			String trsp_so_ofc_cty_cd = event.getTrspSoOfcCtyCd();
			String trsp_so_seq = event.getTrspSoSeq();
			log.info("TRSP_SO_OFC_CTY_CD::::::" + trsp_so_ofc_cty_cd + trsp_so_seq);

			param.put("TRSP_SO_OFC_CTY_CD", trsp_so_ofc_cty_cd);
			param.put("TRSP_SO_SEQ", trsp_so_seq);

			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

}
