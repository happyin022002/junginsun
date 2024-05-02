/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OCPChgColmanageDBDAO.java
*@FileTitle : Monthly Target VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2010.11.10 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OCPChgColmanageDBDAO <br>
 * @author Jeongsoo Lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class OCPChgColmanageDBDAO extends DBDAOSupport {

	/**
	 * ESD_EAS_0010 : Retrieve<br>
	 * [미주 OCP charge collection]을 [조회] 합니다.<br>
	 * 
	 * @param SearchOCPChgListVO searchOCPChgListVO
	 * @return List<SearchOCPChgListVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchOCPChgListVO> searchOcpChgList(SearchOCPChgListVO searchOCPChgListVO) throws DAOException
	{
		
		Connection					con			= null;
		PreparedStatement			ps			= null;
		ResultSet					rs			= null;
		DBRowSet					dRs			= null;
		List<SearchOCPChgListVO>	list		= null;
		Map<String, String>			mapVO		= null; 
		StringBuffer				queryStr	= new StringBuffer() ;
		int							i			= 1;

		try
		{
			if (searchOCPChgListVO != null)
			{
				mapVO = searchOCPChgListVO.getColumnValues();
			
			}
			queryStr.append("    SELECT \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      LOC.EQ_CTRL_OFC_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG, \n");
			queryStr.append("                      MDM_LOCATION LOC \n");
			queryStr.append("                WHERE BKG.DEL_CD = LOC.LOC_CD \n");
			queryStr.append("                  AND BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS CTRL_OFC_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.BKG_STS_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS BKG_STS_CD, \n");
			queryStr.append("           MVM.BKG_NO, \n");
			queryStr.append("           MVM.CNTR_NO, \n");
			queryStr.append("           MVM.CNTR_TPSZ_CD                         AS TS_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.RCV_TERM_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS RCV_TM, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.DE_TERM_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS DEL_TM,       \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      SHR.CUST_CNT_CD \n");
			queryStr.append("                   || LTRIM (TO_CHAR (NVL (SHR.CUST_SEQ, 0), '000000')) \n");
			queryStr.append("                 FROM BKG_CUSTOMER     SHR \n");
			queryStr.append("                WHERE SHR.BKG_CUST_TP_CD = 'N' \n");
			queryStr.append("                  AND SHR.BKG_NO         = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS SHPR_NO, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      CNE.CUST_CNT_CD \n");
			queryStr.append("                   || LTRIM (TO_CHAR (NVL (CNE.CUST_SEQ, 0), '000000')) \n");
			queryStr.append("                 FROM BKG_CUSTOMER     CNE \n");
			queryStr.append("                WHERE CNE.BKG_CUST_TP_CD = 'N' \n");
			queryStr.append("                  AND CNE.BKG_NO         = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS CNEE_NO, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.POR_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS POR_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.POL_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS POL_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.POD_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS POD_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.DEL_CD \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS DEL_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      NVL (BKG.SC_NO, BKG.RFA_NO) \n");
			queryStr.append("                 FROM BKG_BOOKING BKG \n");
			queryStr.append("                WHERE BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("         )                                          AS SC_RFA_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      MV2.ORG_YD_CD \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO \n");
			queryStr.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.MVMT_STS_CD = 'ID' \n");
			queryStr.append("                  AND ROWNUM = 1 \n");
			queryStr.append("         )                                          AS IB_RLSE_CD, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      TO_CHAR (MV2.CNMV_EVNT_DT, 'YYYYMMDD') \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO \n");
			queryStr.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.MVMT_STS_CD = 'ID' \n");
			queryStr.append("                  AND ROWNUM = 1 \n");
			queryStr.append("         )                                          AS IB_RLSE_DT, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      COUNT (1) \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO \n");
			queryStr.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.CNMV_CYC_NO = MV2.CNMV_CYC_NO \n");
			queryStr.append("                  AND MV2.MVMT_STS_CD = 'ID' \n");
			queryStr.append("         )                                          AS IB_RLSE_CNT, \n");
			queryStr.append("           MVM.ORG_YD_CD                            AS MT_RTN_CD, \n");
			queryStr.append("           TO_CHAR (MVM.CNMV_EVNT_DT, 'YYYYMMDD')   AS MT_RTN_DT, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BCR.CURR_CD \n");
			queryStr.append("                 FROM BKG_CHG_RT           BCR, \n");
			queryStr.append("                      AGT_CNTR_PERTP_MPG_V MPG \n");
			queryStr.append("                WHERE BCR.CHG_CD = 'OCP' \n");
			queryStr.append("                  AND MVM.CNTR_TPSZ_CD     = MPG.CNTR_TP \n");
			queryStr.append("                  AND BCR.RAT_UT_CD \n");
			queryStr.append("                   IN \n");
			queryStr.append("                    ( \n");
			queryStr.append("                      'BX', 'BL', 'UN', 'PC', 'HC', MPG.REP_TP, MVM.CNTR_TPSZ_CD \n");
			queryStr.append("                    ) \n");
			queryStr.append("                  AND BCR.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("                  AND ROWNUM = 1 \n");
			queryStr.append("         )                                          AS BKG_OCP_TP, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BCR.CHG_AMT / RAT_AS_QTY \n");
			queryStr.append("                 FROM BKG_CHG_RT           BCR, \n");
			queryStr.append("                      AGT_CNTR_PERTP_MPG_V MPG \n");
			queryStr.append("                WHERE BCR.CHG_CD = 'OCP' \n");
			queryStr.append("                  AND MVM.CNTR_TPSZ_CD     = MPG.CNTR_TP \n");
			queryStr.append("                  AND BCR.RAT_UT_CD \n");
			queryStr.append("                   IN \n");
			queryStr.append("                    ( \n");
			queryStr.append("                      'BX', 'BL', 'UN', 'PC', 'HC', MPG.REP_TP, MVM.CNTR_TPSZ_CD \n");
			queryStr.append("                    ) \n");
			queryStr.append("                  AND BCR.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("                  AND ROWNUM = 1 \n");
			queryStr.append("         )                                          AS BKG_OCP_AMT, \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      SUBSTR \n");
			queryStr.append("                    ( XMLAGG \n");
			queryStr.append("                    ( XMLELEMENT \n");
			queryStr.append("                    ( A,',' || OTS.N3PTY_NO \n");
			queryStr.append("                    ) \n");
			queryStr.append("                    ).EXTRACT('//text()') --'//text()'는 반드시 소문자이어야 합니다. \n");
			queryStr.append("                    , 2 \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 FROM TPB_OTS_DTL OTS \n");
			queryStr.append("                WHERE OTS.BKG_NO    = MVM.BKG_NO \n");
			queryStr.append("                  AND OTS.OTS_DTL_SEQ \n");
			queryStr.append("                    = \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 MIN (OTD.OTS_DTL_SEQ) \n");
			queryStr.append("                            FROM TPB_OTS_DTL OTD \n");
			queryStr.append("                           WHERE OTD.BKG_NO   = OTS.BKG_NO \n");
			queryStr.append("                             AND OTD.N3PTY_NO = OTS.N3PTY_NO \n");
			queryStr.append("                    ) \n");
			queryStr.append("                  AND OTS.IF_RHQ_CD       ='NYCNA' \n");
			queryStr.append("                  AND OTS.N3PTY_BIL_TP_CD ='TR' \n");
			queryStr.append("             GROUP BY OTS.BKG_NO \n");
			queryStr.append("         )                                          AS TPB_CD \n");
			queryStr.append("      FROM CTM_MOVEMENT MVM \n");
			queryStr.append("     WHERE MVM.MVMT_STS_CD = 'MT' \n");
			queryStr.append("       AND SUBSTR (MVM.ORG_YD_CD, 1, 2) \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("             DISTINCT LOC.CNT_CD \n");
			queryStr.append("                 FROM MDM_LOCATION LOC \n");
			queryStr.append("                WHERE LOC.CONTI_CD       = 'M' \n");
			queryStr.append("                  AND LOC.DELT_FLG     <>  'Y' \n");
			queryStr.append("         ) \n");
			queryStr.append("       AND \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN MVM.BKG_NO IS NULL \n");
			queryStr.append("                 THEN 'XXXXXX' \n");
			queryStr.append("                 ELSE SUBSTR (MV2.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                  END \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.CNTR_NO    = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.CNMV_YR    = MVM.CNMV_YR \n");
			queryStr.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO \n");
			queryStr.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO \n");
			queryStr.append("         ) = SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("       AND \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      SUBSTR (MV2.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.CNTR_NO    = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.CNMV_YR    = MVM.CNMV_YR \n");
			queryStr.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO \n");
			queryStr.append("                  AND MV2.CNMV_ID_NO = MVM.CNMV_ID_NO \n");
			queryStr.append("         ) \n");
			queryStr.append("    NOT IN \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USLGB' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USLAX' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USKCK' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USMKC' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSEA' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USTIW' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USCHS' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USSAV' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USLAX' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USLGB' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USMKC' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USKCK' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USTIW' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USSEA' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSAV' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USCHS' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USDAL' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USTLL' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USNYC' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USBOS' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MVM.ORG_YD_CD, 1, 5) = 'USSAV' \n");
			queryStr.append("                  AND SUBSTR (MV2.ORG_YD_CD, 1, 5) = 'USILM' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 WHEN SUBSTR (MV2.ORG_YD_CD, 1, 2) <> 'US' \n");
			queryStr.append("                 THEN SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                 ELSE SUBSTR (MV2.ORG_YD_CD, 1, 5) \n");
			queryStr.append("                  END \n");
			queryStr.append("                 FROM CTM_MOVEMENT MV2 \n");
			queryStr.append("                WHERE MV2.BKG_NO      = MVM.BKG_NO \n");
			queryStr.append("                  AND MV2.CNTR_NO     = MVM.CNTR_NO \n");
			queryStr.append("                  AND MV2.CNMV_CYC_NO = MV2.CNMV_CYC_NO \n");
			queryStr.append("                  AND MV2.MVMT_STS_CD = 'ID' \n");
			queryStr.append("         ) \n");
			queryStr.append("       AND EXISTS \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      1 \n");
			queryStr.append("                 FROM BKG_BOOKING  BKG \n");
			queryStr.append("                WHERE BKG.BKG_CGO_TP_CD = 'F' \n");
			queryStr.append("                  AND BKG.BKG_NO = MVM.BKG_NO \n");
			queryStr.append("                  AND NVL (BKG.OCP_CD,'X') <>  SUBSTR (MVM.ORG_YD_CD, 1, 5) \n");
			queryStr.append("         ) \n");
			if (!"".equals(mapVO.get("s_bkg_no")) && null != mapVO.get("s_bkg_no"))
			{
				queryStr.append("----+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
				queryStr.append("----++ BOOKING NUMBER Condition +++++++++++++++++++++++++++++-- \n");
				queryStr.append("----+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
				queryStr.append("       AND MVM.BKG_NO = ? --:BKG_NO \n");
			}
			else
			{
				queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
				queryStr.append("--++ MT Return Period Condition +++++++++++++++++++++++++++-- \n");
				queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
				queryStr.append("       AND MVM.CNMV_EVNT_DT \n");
				queryStr.append("   BETWEEN TO_DATE ('"+mapVO.get("fm_dt")+"', 'YYYYMMDD')           --:FR_DT \n");
				queryStr.append("       AND TO_DATE ('"+mapVO.get("to_dt")+"', 'YYYYMMDD') + 0.99999 --:TO_DT \n");
				if (!"".equals(mapVO.get("s_ctrl_ofc_cd")) && null != mapVO.get("s_ctrl_ofc_cd"))
				{
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("--++ Control Office Condition +++++++++++++++++++++++++++++-- \n");
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("       AND EXISTS \n");
					queryStr.append("         ( \n");
					queryStr.append("               SELECT \n");
					queryStr.append("                      1 \n");
					queryStr.append("                 FROM BKG_BOOKING  BKG, \n");
					queryStr.append("                      MDM_LOCATION LOC \n");
					queryStr.append("                WHERE BKG.BKG_CGO_TP_CD = 'F' \n");
					queryStr.append("                  AND BKG.DEL_CD = LOC.LOC_CD \n");
					queryStr.append("                  AND BKG.BKG_NO = MVM.BKG_NO \n");
					queryStr.append("                  AND LOC.EQ_CTRL_OFC_CD = ? --:EQ_CTRL_OFC_CD \n");
					queryStr.append("         ) \n");
				}
				if (!"".equals(mapVO.get("s_mt_rtn_cd")) && null != mapVO.get("s_mt_rtn_cd"))
				{
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("--++ MT Return Loc/Yard Condition +++++++++++++++++++++++++-- \n");
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("      AND MVM.ORG_YD_CD LIKE ?  --:ORG_YD_CD \n");
				}
				if (!"".equals(mapVO.get("s_cnee_no")) && null != mapVO.get("s_cnee_no"))
				{
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("--++ Consignee Condition ++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++-- \n");
					queryStr.append("       AND EXISTS \n");
					queryStr.append("         ( \n");
					queryStr.append("               SELECT \n");
					queryStr.append("                      1 \n");
					queryStr.append("                 FROM BKG_CUSTOMER     CNE \n");
					queryStr.append("                WHERE CNE.BKG_CUST_TP_CD = 'N' \n");
					queryStr.append("                  AND CNE.BKG_NO         = MVM.BKG_NO \n");
					queryStr.append("                  AND CNE.CUST_CNT_CD    = SUBSTR (?, 1, 2)                   --:CNEE_CD \n");
					queryStr.append("                  AND CNE.CUST_SEQ       = TO_NUMBER (NVL (SUBSTR (?, 3), 0)) --:CNEE_CD \n");
					queryStr.append("         ) \n");
				}
			}


			con  = getConnection();
			ps = new LoggableStatement(con, queryStr.toString());
			if (!"".equals(mapVO.get("s_bkg_no")) && null != mapVO.get("s_bkg_no"))
			{
				ps.setString(i++, mapVO.get("s_bkg_no"));
			}
			else
			{
				if (!"".equals(mapVO.get("s_ctrl_ofc_cd")) && null != mapVO.get("s_ctrl_ofc_cd"))
				{
					ps.setString(i++, mapVO.get("s_ctrl_ofc_cd"));
				}
				if (!"".equals(mapVO.get("s_mt_rtn_cd")) && null != mapVO.get("s_mt_rtn_cd"))
				{
					ps.setString(i++, mapVO.get("s_mt_rtn_cd"));
				}
				if (!"".equals(mapVO.get("s_cnee_no")) && null != mapVO.get("s_cnee_no"))
				{
					ps.setString(i++, mapVO.get("s_cnee_no"));
					ps.setString(i++, mapVO.get("s_cnee_no"));
				}
			}

			log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery() ;

			dRs = new DBRowSet();
			dRs.populate(rs) ;
//			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new OCPChgColmanageDBDAOSearchOCPChgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dRs, SearchOCPChgListVO .class);

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return list;
	}
	

}
