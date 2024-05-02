/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchInvArIfMnDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.14
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.07.14 한종희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchInvArIfMnDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchInvArIfMnDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchInvArIfMnDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchInvArIfMnDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        MAX(MRW.INV_NO) AS BL_SRC_NO," ).append("\n"); 
		query.append("        MAX(MRW.INV_NO) AS INV_SRC_NO," ).append("\n"); 
		query.append("        MAX(MRW.MNR_PRNR_CNT_CD) AS CUST_CNT_CD," ).append("\n"); 
		query.append("        MAX(MRW.MNR_PRNR_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("        MAX(MO.AR_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("        'MNR' AS IF_SRC_CD," ).append("\n"); 
		query.append("        'CNTC' AS VSL_CD," ).append("\n"); 
		query.append("        SUBSTR(MAX(SQ.GL_EFF_DT), 3, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("        'M' AS SKD_DIR_CD," ).append("\n"); 
		query.append("        MAX(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), SYSDATE, MRW.ISS_OFC_CD),'YYYYMMDD')) AS SAIL_ARR_DT," ).append("\n"); 
		query.append("        MAX((SELECT MAR.LOC_CD FROM MDM_ORGANIZATION MAR WHERE MO.AR_OFC_CD = MAR.OFC_CD AND ROWNUM = 1)) AS POL_CD," ).append("\n"); 
		query.append("        MAX((SELECT MAR.LOC_CD FROM MDM_ORGANIZATION MAR WHERE MO.AR_OFC_CD = MAR.OFC_CD AND ROWNUM = 1)) AS POD_CD," ).append("\n"); 
		query.append("        'OTH' AS SVC_SCP_CD," ).append("\n"); 
		query.append("        'CNT' AS SLAN_CD," ).append("\n"); 
		query.append("        MAX((SELECT MAR.LOC_CD FROM MDM_ORGANIZATION MAR WHERE MO.AR_OFC_CD = MAR.OFC_CD AND ROWNUM = 1)) AS POR_CD," ).append("\n"); 
		query.append("        MAX((SELECT MAR.LOC_CD FROM MDM_ORGANIZATION MAR WHERE MO.AR_OFC_CD = MAR.OFC_CD AND ROWNUM = 1)) AS DEL_CD," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("    SELECT NVL(SUM(DECODE(MDH.EQ_KND_CD , 'U', DECODE(SUBSTR(MDD.EQ_TPSZ_CD, 2, 1), 2, 1, 0), 0)), 0) " ).append("\n"); 
		query.append("    FROM MNR_DISP_DTL MDD, MNR_DISP_HDR MDH" ).append("\n"); 
		query.append("    WHERE MDD.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("    AND   MDD.DISP_NO = MDH.DISP_NO" ).append("\n"); 
		query.append("        ) AS BKG_TEU_QTY," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("    SELECT NVL(SUM(DECODE(MDH.EQ_KND_CD , 'U', DECODE(SUBSTR(MDD.EQ_TPSZ_CD, 2, 1), 2, 0, 1), 0)), 0) " ).append("\n"); 
		query.append("    FROM MNR_DISP_DTL MDD, MNR_DISP_HDR MDH" ).append("\n"); 
		query.append("    WHERE MDD.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("    AND   MDD.DISP_NO = MDH.DISP_NO" ).append("\n"); 
		query.append("        ) AS BKG_FEU_QTY," ).append("\n"); 
		query.append("        TO_CHAR(LAST_DAY(TO_DATE(MAX(SQ.GL_EFF_DT),'YYYYMMDD')),'yyyymmdd') AS SAIL_DT," ).append("\n"); 
		query.append("        'O' AS IO_BND_CD," ).append("\n"); 
		query.append("        MAX(MRW.MNR_INV_REF_NO) AS INV_REF_NO," ).append("\n"); 
		query.append("        '' AS SRC_IF_DT," ).append("\n"); 
		query.append("        '' AS SRC_IF_SEQ," ).append("\n"); 
		query.append("    '' AS SRC_IF_DT," ).append("\n"); 
		query.append("    '' AS WHF_DECL_NO,    " ).append("\n"); 
		query.append("    '' AS BL_NO," ).append("\n"); 
		query.append("    '' AS SREP_CD,    " ).append("\n"); 
		query.append("    '' AS DEST_TRNS_SVC_MOD_CD,    " ).append("\n"); 
		query.append("    '' AS SC_NO," ).append("\n"); 
		query.append("    '' AS SLS_OFC_CD," ).append("\n"); 
		query.append("    '' AS MST_BL_NO," ).append("\n"); 
		query.append("    '' AS VVD_TRNS_FLG," ).append("\n"); 
		query.append("    '' AS CGO_WGT," ).append("\n"); 
		query.append("    '' AS BKG_CORR_NO,        " ).append("\n"); 
		query.append("    '' AS WHF_DECL_DIR_CD," ).append("\n"); 
		query.append("    '' AS FRT_FWRD_CUST_SEQ,        " ).append("\n"); 
		query.append("    '' AS WHF_DECL_VOY_NO," ).append("\n"); 
		query.append("    '' AS CRE_USR_ID," ).append("\n"); 
		query.append("    '' AS SI_REF_NO," ).append("\n"); 
		query.append("    '' AS BKG_NO," ).append("\n"); 
		query.append("    '' AS TRNK_VSL_CD,    " ).append("\n"); 
		query.append("    '' AS TRNK_SKD_VOY_NO,    " ).append("\n"); 
		query.append("    '' AS WHF_DECL_CFM_DT," ).append("\n"); 
		query.append("    '' AS CRE_DT," ).append("\n"); 
		query.append("    '' AS WHF_DECL_OFC_CD," ).append("\n"); 
		query.append("    '' AS TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    '' AS RFA_NO,    " ).append("\n"); 
		query.append("    '' AS AR_IF_NO," ).append("\n"); 
		query.append("    '' AS WHF_DECL_VSL_CD," ).append("\n"); 
		query.append("    MAX(TO_CHAR(MRW.INV_DUE_DT, 'YYYYMMDD')) AS DUE_DT," ).append("\n"); 
		query.append("    '' AS UPD_DT," ).append("\n"); 
		query.append("    '' AS BKG_CORR_DT," ).append("\n"); 
		query.append("    '' AS CGO_MEAS_QTY," ).append("\n"); 
		query.append("    '' AS BL_INV_IF_DT,    " ).append("\n"); 
		query.append("    '' AS WHF_MRN_NO," ).append("\n"); 
		query.append("    '' AS INV_REF_NO," ).append("\n"); 
		query.append("    MAX(SQ.GL_EFF_DT) AS GL_EFF_DT,    " ).append("\n"); 
		query.append("    '' AS TRSP_RQST_ORD_FLG," ).append("\n"); 
		query.append("    '' AS BL_INV_IF_FLG,    " ).append("\n"); 
		query.append("    '' AS BL_TP_CD," ).append("\n"); 
		query.append("    '' AS BKG_REF_NO,        " ).append("\n"); 
		query.append("    '' AS AP_AR_OFFST_NO," ).append("\n"); 
		query.append("    'CNT' AS SLAN_CD," ).append("\n"); 
		query.append("    '' AS INV_RMK," ).append("\n"); 
		query.append("    '' AS FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("    MAX(MRW.CRE_USR_ID) CRE_USR_ID," ).append("\n"); 
		query.append("    MAX(MRW.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK MRW, " ).append("\n"); 
		query.append("  MNR_DISP_DTL MDD, " ).append("\n"); 
		query.append("  MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("  SELECT  MAX(DECODE (A.CLZ_STS_CD, 'O',A.EFF_YRMON, 'C',B.EFF_YRMON)) GL_EFF_DT" ).append("\n"); 
		query.append("  FROM   " ).append("\n"); 
		query.append("    (SELECT  AP.CLZ_STS_CD CLZ_STS_CD, TO_CHAR(MRW.ISS_DT, 'YYYYMMDD') EFF_YRMON " ).append("\n"); 
		query.append("        FROM    AP_PERIOD AP, MNR_RCV_INV_WRK MRW" ).append("\n"); 
		query.append("        WHERE   AP.SYS_DIV_CD = '33'" ).append("\n"); 
		query.append("        AND     AP.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("        AND     AP.OFC_CD IN (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                               FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                               WHERE MRW.ISS_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                               AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("                               UNION ALL" ).append("\n"); 
		query.append("                               SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(AR_OFC_CD)" ).append("\n"); 
		query.append("                               FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                               WHERE MRW.ISS_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                               AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]                              " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("        AND     MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("        AND     AP.EFF_YRMON = TO_CHAR(MRW.ISS_DT, 'YYYYMM')" ).append("\n"); 
		query.append("        ) A, " ).append("\n"); 
		query.append("       (SELECT  MIN(AP.EFF_YRMON)||'01' AS EFF_YRMON " ).append("\n"); 
		query.append("        FROM    AP_PERIOD AP, MNR_RCV_INV_WRK MRW" ).append("\n"); 
		query.append("        WHERE   AP.SYS_DIV_CD = '33'" ).append("\n"); 
		query.append("        AND     AP.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("        AND     AP.OFC_CD IN ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                               FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                               WHERE MRW.ISS_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                               AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("                               UNION ALL" ).append("\n"); 
		query.append("                               SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(AR_OFC_CD)" ).append("\n"); 
		query.append("                               FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                               WHERE MRW.ISS_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                               AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]                                  " ).append("\n"); 
		query.append("                             )     " ).append("\n"); 
		query.append("        AND     MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("        AND     AP.EFF_YRMON >= TO_CHAR(MRW.ISS_DT, 'YYYYMM')" ).append("\n"); 
		query.append("        AND     AP.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("  ) SQ" ).append("\n"); 
		query.append("WHERE MRW.ISS_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND   MRW.RCV_INV_SEQ = MDD.RCV_INV_SEQ" ).append("\n"); 
		query.append("AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("GROUP BY MRW.RCV_INV_SEQ" ).append("\n"); 

	}
}