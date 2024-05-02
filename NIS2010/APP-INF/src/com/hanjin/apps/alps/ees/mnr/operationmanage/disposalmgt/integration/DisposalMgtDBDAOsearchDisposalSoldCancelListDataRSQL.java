/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalSoldCancelListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.01.17 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalSoldCancelListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * --------------------------------------------------------
	  * * History
	  * * 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
	  * *                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalSoldCancelListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kind_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalSoldCancelListDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A.INV_NO," ).append("\n"); 
		query.append("       CASE WHEN A.MNR_INV_STS_CD = 'HC' THEN" ).append("\n"); 
		query.append("                 (SELECT /*+ INDEX_DESC (IAI XPKINV_AR_IF_MN) */" ).append("\n"); 
		query.append("                         DECODE(IAA.INV_ERP_IF_STS_CD, 'N', (SELECT MGC.MNR_CD_DESC" ).append("\n"); 
		query.append("                                                               FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("                                                              WHERE A.MNR_INV_STS_CD = MGC.MNR_CD_ID" ).append("\n"); 
		query.append("                                                                AND MGC.PRNT_CD_ID = 'CD00027'" ).append("\n"); 
		query.append("                                                                AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                                       'E', IAA.ERR_DESC," ).append("\n"); 
		query.append("                                                       'Y', 'ERP Interfaced')" ).append("\n"); 
		query.append("                    FROM INV_AR_IF_MN IAI," ).append("\n"); 
		query.append("                         INV_AR_AMT IAA" ).append("\n"); 
		query.append("                   WHERE IAI.AR_IF_NO = IAA.AR_IF_NO" ).append("\n"); 
		query.append("                     AND A.INV_NO = IAI.BL_SRC_NO" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 (SELECT MGC.MNR_CD_DESC" ).append("\n"); 
		query.append("                    FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("                   WHERE A.MNR_INV_STS_CD = MGC.MNR_CD_ID" ).append("\n"); 
		query.append("                     AND MGC.PRNT_CD_ID = 'CD00027'" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("       END AS MNR_INV_STS_CD," ).append("\n"); 
		query.append("       D.DISP_NO," ).append("\n"); 
		query.append("       D.DISP_DTL_SEQ," ).append("\n"); 
		query.append("       A.MNR_PRNR_CNT_CD||TO_CHAR(A.MNR_PRNR_SEQ, '000000') AS BUYER_CODE," ).append("\n"); 
		query.append("       B.MNR_PRNR_LGL_ENG_NM AS BUYER_NAME," ).append("\n"); 
		query.append("       D.EQ_NO," ).append("\n"); 
		query.append("       F.EQ_KND_CD," ).append("\n"); 
		query.append("       F.EQ_KND_NM," ).append("\n"); 
		query.append("       D.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       F.LSTM_CD," ).append("\n"); 
		query.append("       F.CNTR_STS_CD," ).append("\n"); 
		query.append("       F.CNMV_STS_CD," ).append("\n"); 
		query.append("       TO_CHAR(D.DISP_SOLD_DT, 'YYYY-MM-DD') AS DISP_SOLD_DT," ).append("\n"); 
		query.append("       F.LST_STS_YD_CD," ).append("\n"); 
		query.append("       A.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MNR_RCV_INV_WRK A," ).append("\n"); 
		query.append("       MNR_PARTNER B," ).append("\n"); 
		query.append("       MNR_DISP_HDR C," ).append("\n"); 
		query.append("       MNR_DISP_DTL D," ).append("\n"); 
		query.append("       MNR_GEN_CD G," ).append("\n"); 
		query.append("       MDM_CURRENCY E," ).append("\n"); 
		query.append("       INV_AR_IF_MN IAI," ).append("\n"); 
		query.append("       INV_AR_AMT IAA," ).append("\n"); 
		query.append("       (SELECT A.EQ_NO," ).append("\n"); 
		query.append("               A.EQ_KND_CD," ).append("\n"); 
		query.append("               DECODE(A.EQ_KND_CD, 'U', 'CNTR', 'Z', 'Chassis', 'G', 'M.G.Set') AS EQ_KND_NM," ).append("\n"); 
		query.append("               A.AGMT_LSTM_CD AS LSTM_CD," ).append("\n"); 
		query.append("               B.EQ_ASET_STS_CD AS CNTR_STS_CD," ).append("\n"); 
		query.append("               A.CHSS_MVMT_STS_CD AS CNMV_STS_CD," ).append("\n"); 
		query.append("               A.CRNT_YD_CD AS LST_STS_YD_CD" ).append("\n"); 
		query.append("          FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("               CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("         WHERE A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("           AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT CNTR_NO AS EQ_NO," ).append("\n"); 
		query.append("               'U' AS EQ_KND_CD," ).append("\n"); 
		query.append("               'CNTR' AS EQ_KND_NM," ).append("\n"); 
		query.append("               LSTM_CD," ).append("\n"); 
		query.append("               CNTR_STS_CD," ).append("\n"); 
		query.append("               CNMV_STS_CD," ).append("\n"); 
		query.append("               LST_STS_YD_CD" ).append("\n"); 
		query.append("          FROM MST_CONTAINER) F" ).append("\n"); 
		query.append(" WHERE A.MNR_PRNR_CNT_CD = B.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_SEQ = B.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("--AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(NVL(null, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()), TO_DATE('2011-06-01', 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(NVL(null, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()), TO_DATE('2011-12-31', 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("   AND IAI.AR_IF_NO = IAA.AR_IF_NO(+)" ).append("\n"); 
		query.append("   AND A.INV_NO = IAI.BL_SRC_NO(+)" ).append("\n"); 
		query.append("   AND C.DISP_NO = D.DISP_NO" ).append("\n"); 
		query.append("   AND A.RCV_INV_SEQ = D.RCV_INV_SEQ" ).append("\n"); 
		query.append("   AND C.DISP_NO = D.DISP_NO" ).append("\n"); 
		query.append("   AND C.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("   AND G.PRNT_CD_ID(+) = 'CD00035'" ).append("\n"); 
		query.append("   AND C.DISP_TP_CD = G.MNR_CD_ID(+)" ).append("\n"); 
		query.append("   AND D.EQ_NO = F.EQ_NO" ).append("\n"); 
		query.append("#if (${kind_cd} == 'I')" ).append("\n"); 
		query.append("   AND A.INV_NO = @[kind_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${kind_cd} == 'D')" ).append("\n"); 
		query.append("   AND D.INV_NO IN (SELECT INV_NO FROM MNR_DISP_DTL WHERE DISP_NO = @[kind_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${kind_cd} == 'E')" ).append("\n"); 
		query.append("   AND A.INV_NO IN (SELECT INV_NO FROM MNR_DISP_DTL WHERE EQ_NO = @[kind_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}