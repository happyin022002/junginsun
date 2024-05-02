/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOPriCmpbGlineBaseListRSQL.java
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

public class CMPBGuidelineDBDAOPriCmpbGlineBaseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * base list
	  * </pre>
	  */
	public CMPBGuidelineDBDAOPriCmpbGlineBaseListRSQL(){
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
		query.append("FileName : CMPBGuidelineDBDAOPriCmpbGlineBaseListRSQL").append("\n"); 
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
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       B1.VSL_SLAN_CD                                               -- SVC_LANE" ).append("\n"); 
		query.append(",       C1.PRC_CMDT_DEF_CD                                           --COMMODITY" ).append("\n"); 
		query.append(",       D1.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD            --ORIGIN PNT" ).append("\n"); 
		query.append(",       E1.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD          --ORIGIN VIA" ).append("\n"); 
		query.append(",       F1.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD         --DEST VIA" ).append("\n"); 
		query.append(",       G1.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD           --DEST PNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRI_CMPB_GLINE_BSE A1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--SVC_LANE" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(VSL_SLAN_CD, '; ')),3) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       VSL_SLAN_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY  VSL_SLAN_CD, SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_SVC_LANE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("--ORDER BY VSL_SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",        CRE_OFC_CD" ).append("\n"); 
		query.append(",        GLINE_SEQ" ).append("\n"); 
		query.append(",        PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",        BSE_SEQ" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--COMMODITY" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, '; ')),3) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       CMDT_SEQ" ).append("\n"); 
		query.append(",       PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(PRC_CMDT_TP_CD, 'G','1','R','2','C','3'),  PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("SVC_SCP_CD, CRE_OFC_CD, GLINE_SEQ, PRS_CUST_TP_CD, BSE_SEQ, CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_CMDT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("--ORDER BY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(") C1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--ORIGIN POINT" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       A.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A.BSE_SEQ" ).append("\n"); 
		query.append(",       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("--,       (A.ROUT_PNT_LOC_DEF_CD || DECODE(NVL(B.INTG_CD_VAL_DESC,''),'','','(' || B.INTG_CD_VAL_DESC || ')')) AS ROUT_PNT_LOC_DEF_CD\\" ).append("\n"); 
		query.append(",       A.ROUT_PNT_LOC_DEF_CD AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A" ).append("\n"); 
		query.append(",       COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND   B.INTG_CD_ID(+) = 'CD02138'" ).append("\n"); 
		query.append("AND   A.RCV_DE_TERM_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("--ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",        CRE_OFC_CD" ).append("\n"); 
		query.append(",        GLINE_SEQ" ).append("\n"); 
		query.append(",        PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",        BSE_SEQ" ).append("\n"); 
		query.append(",        ORG_DEST_TP_CD" ).append("\n"); 
		query.append(") D1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--ORIGIN VIA" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       A.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A.BSE_SEQ" ).append("\n"); 
		query.append(",       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("--ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",        CRE_OFC_CD" ).append("\n"); 
		query.append(",        GLINE_SEQ" ).append("\n"); 
		query.append(",        PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",        BSE_SEQ" ).append("\n"); 
		query.append(",        ORG_DEST_TP_CD" ).append("\n"); 
		query.append(") E1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--DEST VIA" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       A.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A.BSE_SEQ" ).append("\n"); 
		query.append(",       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("--ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",        CRE_OFC_CD" ).append("\n"); 
		query.append(",        GLINE_SEQ" ).append("\n"); 
		query.append(",        PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",        BSE_SEQ" ).append("\n"); 
		query.append(",        ORG_DEST_TP_CD" ).append("\n"); 
		query.append(") F1" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--DEST POINT" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       BSE_SEQ" ).append("\n"); 
		query.append(",       ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       A.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A.BSE_SEQ" ).append("\n"); 
		query.append(",       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("--,       (A.ROUT_PNT_LOC_DEF_CD || DECODE(NVL(B.INTG_CD_VAL_DESC,''),'','','(' || B.INTG_CD_VAL_DESC || ')')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       A.ROUT_PNT_LOC_DEF_CD AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       ROW_NUMBER() OVER(PARTITION BY A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD, A.CRE_OFC_CD, A.GLINE_SEQ, A.PRS_CUST_TP_CD, A.BSE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A" ).append("\n"); 
		query.append(",       COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND   B.INTG_CD_ID(+) = 'CD02139'" ).append("\n"); 
		query.append("AND   A.RCV_DE_TERM_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("--ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR BSE_SEQ = BSE_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(",        CRE_OFC_CD" ).append("\n"); 
		query.append(",        GLINE_SEQ" ).append("\n"); 
		query.append(",        PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",        BSE_SEQ" ).append("\n"); 
		query.append(",        ORG_DEST_TP_CD" ).append("\n"); 
		query.append(") G1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = B1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = B1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = B1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = C1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = C1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = C1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = C1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = C1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = D1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = D1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = D1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = D1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = D1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = E1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = E1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = E1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = E1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = E1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = F1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = F1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = F1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = F1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = F1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = G1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = G1.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = G1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = G1.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     A1.BSE_SEQ = G1.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("ORDER BY A1.BSE_SEQ" ).append("\n"); 

	}
}