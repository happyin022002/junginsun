/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAORsltRtListVerticalExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.07 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAORsltRtListVerticalExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vertical Excel
	  * </pre>
	  */
	public CMPBGuidelineDBDAORsltRtListVerticalExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAORsltRtListVerticalExcelVORSQL").append("\n"); 
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
		query.append("SELECT A.ROUT_ROWKEY" ).append("\n"); 
		query.append(",A.ROUT_DP_SEQ" ).append("\n"); 
		query.append(",A.VSL_SLAN_CD" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",A.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",A.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.CMPB_AMT" ).append("\n"); 
		query.append(",A.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",A.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",(TO_NUMBER(SUBSTR(A.ROUT_ROWKEY, 1, INSTR(A.ROUT_ROWKEY, '|', 1, 1) - 1)) || ';' ||" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COUNT(A.VSL_SLAN_CD)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("A1.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM    MDM_SVC_SCP_LANE A1" ).append("\n"); 
		query.append(",       MDM_VSL_SVC_LANE B1" ).append("\n"); 
		query.append("WHERE   A1.VSL_SLAN_CD = B1.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(") ) AS CNT_SVC_LANE" ).append("\n"); 
		query.append("FROM (SELECT S.ROUT_ROWKEY" ).append("\n"); 
		query.append(",A.ROUT_DP_SEQ" ).append("\n"); 
		query.append(",B.VSL_SLAN_CD" ).append("\n"); 
		query.append(",C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",C.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",D.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",D.RCV_DE_TERM_NM AS ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",F.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",G.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",G.RCV_DE_TERM_NM AS DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",H.RAT_UT_CD" ).append("\n"); 
		query.append(",H.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",H.CURR_CD" ).append("\n"); 
		query.append(",H.CMPB_AMT" ).append("\n"); 
		query.append(",H.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",H.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append("FROM (SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_SVC_LANE" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_PNT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_VIA" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_PNT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_VIA" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT BSE_SEQ" ).append("\n"); 
		query.append(",LPAD(BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ ORDER BY BSE_SEQ)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_AMT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("--BSE" ).append("\n"); 
		query.append(",(SELECT ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD" ).append("\n"); 
		query.append("ORDER BY T.BSE_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_BSE T" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("--SVC LANE" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.VSL_SLAN_CD" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_SVC_LANE T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("--CMDT" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",  DECODE(T.PRC_CMDT_TP_CD," ).append("\n"); 
		query.append("'G'," ).append("\n"); 
		query.append("(SELECT PRC_GRP_CMDT_DESC                       --GROUP COMMODITY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = T.CRE_OFC_CD" ).append("\n"); 
		query.append("AND   GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
		query.append("AND   PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND   ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT REP_CMDT_NM                             --REP COMMODITY" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C'," ).append("\n"); 
		query.append("(SELECT CMDT_NM                                  --COMMODITY" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99),T.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_CMDT T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("--ROUT PNT ORIGIN" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	DECODE(T.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_CMPB_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                 --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', '1', 'R', '2', 'G', '3', 'L', '4', 99),T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_PNT T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("--ROUT VIA ORIGIN" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'C', '1', 'R', '2', 'G', '3', 'L', '4', 99),T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_VIA T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("--ROUT VIA DEST" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'C', '1', 'R', '2', 'G', '3', 'L', '4', 99),T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_VIA T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") F" ).append("\n"); 
		query.append("--ROUT PNT DEST" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	DECODE(T.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_CMPB_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = T.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = T.GLINE_SEQ" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                 --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', '1', 'R', '2', 'G', '3', 'L', '4', 99),T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_PNT T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") G" ).append("\n"); 
		query.append(",(SELECT T.BSE_SEQ" ).append("\n"); 
		query.append(",T.RAT_UT_CD" ).append("\n"); 
		query.append(",T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",T.CURR_CD" ).append("\n"); 
		query.append(",T.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",T.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",T.CMPB_AMT" ).append("\n"); 
		query.append(",LPAD(T.BSE_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.SVC_SCP_CD, T.CRE_OFC_CD, T.GLINE_SEQ, T.PRS_CUST_TP_CD, T.BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY T.MQC_RNG_FM_QTY,T.MQC_RNG_TO_QTY,T.RAT_UT_CD,T.PRC_CGO_TP_CD,T.CURR_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_AMT T" ).append("\n"); 
		query.append("WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND T.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND T.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND T.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append(") H" ).append("\n"); 
		query.append("WHERE S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = C.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = D.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = G.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = H.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("ORDER BY S.ROUT_ROWKEY) A" ).append("\n"); 

	}
}