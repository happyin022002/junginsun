/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOPriCmpbGlineMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAOPriCmpbGlineMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriCmpbGlineMapg
	  * </pre>
	  */
	public CMPBGuidelineDBDAOPriCmpbGlineMapgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAOPriCmpbGlineMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_CMPB_GLINE_MAPG (" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",       CRE_OFC_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append(",       MAPG_SEQ" ).append("\n"); 
		query.append(",       PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       CUST_CNT_CD" ).append("\n"); 
		query.append(",       CUST_SEQ" ).append("\n"); 
		query.append(",       VSL_SLAN_CD" ).append("\n"); 
		query.append(",       PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",       ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",       ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    RCV_TERM_CD" ).append("\n"); 
		query.append(",       DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",       DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    DE_TERM_CD" ).append("\n"); 
		query.append(",	    ORG_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    ORG_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    DEST_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    DEST_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",	    MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",	    RAT_UT_CD" ).append("\n"); 
		query.append(",	    PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	    CURR_CD" ).append("\n"); 
		query.append(",	    CMPB_AMT" ).append("\n"); 
		query.append(",       MAPG_SCRE" ).append("\n"); 
		query.append(",	    CRE_USR_ID" ).append("\n"); 
		query.append(",	    CRE_DT" ).append("\n"); 
		query.append(",	    UPD_USR_ID" ).append("\n"); 
		query.append(",	    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  A4.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A4.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A4.GLINE_SEQ" ).append("\n"); 
		query.append(",       ROWNUM AS MAPG_SEQ" ).append("\n"); 
		query.append(",       A4.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A4.CUST_CNT_CD" ).append("\n"); 
		query.append(",       A4.CUST_SEQ" ).append("\n"); 
		query.append(",       A4.VSL_SLAN_CD" ).append("\n"); 
		query.append(",       DECODE(A4.PRC_CMDT_TP_CD,'G','C',A4.PRC_CMDT_TP_CD) AS PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       A4.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",       DECODE(A4.ORG_LOC_TP_CD,'G','L',A4.ORG_LOC_TP_CD) AS ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",       A4.ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    A4.RCV_TERM_CD" ).append("\n"); 
		query.append(",       DECODE(A4.DEST_LOC_TP_CD,'G','L',A4.DEST_LOC_TP_CD) AS DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",       A4.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    A4.DE_TERM_CD" ).append("\n"); 
		query.append(",	    DECODE(A4.ORG_VIA_PORT_TP_CD,'G','L',A4.ORG_VIA_PORT_TP_CD) AS ORG_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    A4.ORG_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    DECODE(A4.DEST_VIA_PORT_TP_CD,'G','L',A4.DEST_VIA_PORT_TP_CD) AS DEST_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    A4.DEST_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    A4.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",	    A4.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",	    A4.RAT_UT_CD" ).append("\n"); 
		query.append(",	    A4.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	    A4.CURR_CD" ).append("\n"); 
		query.append(",	    A4.CMPB_AMT" ).append("\n"); 
		query.append(",       (DECODE(A4.PRC_CMDT_TP_CD,NULL,0,'R',4,'C',6,'G',6) +" ).append("\n"); 
		query.append("DECODE(A4.ORG_LOC_TP_CD,NULL,0,'C',3,'R',4,'L',6,'G',6) +" ).append("\n"); 
		query.append("DECODE(A4.DEST_LOC_TP_CD,NULL,0,'C',3,'R',4,'L',6,'G',6) +" ).append("\n"); 
		query.append("DECODE(A4.ORG_VIA_PORT_TP_CD,NULL,0,'C',3,'R',4,'L',6,'G',6) +" ).append("\n"); 
		query.append("DECODE(A4.DEST_VIA_PORT_TP_CD,NULL,0,'C',3,'R',4,'L',6,'G',6) +" ).append("\n"); 
		query.append("DECODE(A4.RCV_TERM_CD,NULL,0,2) +" ).append("\n"); 
		query.append("DECODE(A4.DE_TERM_CD,NULL,0,2) +" ).append("\n"); 
		query.append("DECODE(A4.RAT_UT_CD,NULL,0,2) +" ).append("\n"); 
		query.append("DECODE(A4.PRC_CGO_TP_CD,NULL,0,2) ) AS MAPG_SCRE" ).append("\n"); 
		query.append(",       @[cre_usr_id]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append(",       @[upd_usr_id]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("A3.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A3.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A3.GLINE_SEQ" ).append("\n"); 
		query.append(",       A3.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A3.CUST_CNT_CD" ).append("\n"); 
		query.append(",       A3.CUST_SEQ" ).append("\n"); 
		query.append(",       B3.VSL_SLAN_CD" ).append("\n"); 
		query.append(",       C3.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       C3.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",       D3.ROUT_PNT_LOC_TP_CD AS ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",       D3.ROUT_PNT_LOC_DEF_CD AS ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    D3.RCV_DE_TERM_CD AS RCV_TERM_CD" ).append("\n"); 
		query.append(",       E3.ROUT_PNT_LOC_TP_CD AS DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",       E3.ROUT_PNT_LOC_DEF_CD AS DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	    E3.RCV_DE_TERM_CD AS DE_TERM_CD" ).append("\n"); 
		query.append(",	    F3.ROUT_VIA_PORT_TP_CD AS ORG_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    F3.ROUT_VIA_PORT_DEF_CD AS ORG_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    G3.ROUT_VIA_PORT_TP_CD AS DEST_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	    G3.ROUT_VIA_PORT_DEF_CD AS DEST_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	    H3.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",	    H3.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",	    H3.RAT_UT_CD" ).append("\n"); 
		query.append(",	    H3.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	    H3.CURR_CD" ).append("\n"); 
		query.append(",	    H3.CMPB_AMT" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_BSE I3" ).append("\n"); 
		query.append(",       (" ).append("\n"); 
		query.append("--CUST" ).append("\n"); 
		query.append("SELECT  A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.CUST_CNT_CD" ).append("\n"); 
		query.append(",       A2.CUST_SEQ" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_CUST A2" ).append("\n"); 
		query.append("WHERE   A2.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A2.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A2.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(") A3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--SVC LANE" ).append("\n"); 
		query.append("SELECT  A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_SVC_LANE A2" ).append("\n"); 
		query.append("WHERE   A2.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A2.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A2.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(") B3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--CMDT" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       A1.PRC_CMDT_DEF_CD AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_CMDT A1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.PRC_CMDT_TP_CD <> 'G'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       B2.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",       B2.PRC_CMDT_DEF_CD AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_CMDT A1" ).append("\n"); 
		query.append(",       PRI_CMPB_GRP_CMDT B1" ).append("\n"); 
		query.append(",       PRI_CMPB_GRP_CMDT_DTL B2" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.PRC_CMDT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND     A1.PRC_CMDT_DEF_CD = B1.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("AND     B1.SVC_SCP_CD = B2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     B1.CRE_OFC_CD = B2.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     B1.GLINE_SEQ = B2.GLINE_SEQ" ).append("\n"); 
		query.append("AND     B1.GRP_CMDT_SEQ = B2.GRP_CMDT_SEQ" ).append("\n"); 
		query.append(") C3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--rout pnt origin" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",       A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A2.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       DECODE(A2.ROUT_PNT_LOC_TP_CD, 'G'," ).append("\n"); 
		query.append("A2.LOC_CD, A2.ROUT_PNT_LOC_DEF_CD) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       '' AS LOC_CD" ).append("\n"); 
		query.append(",       A1.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_TP_CD <> 'G'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       '' AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       B2.LOC_CD" ).append("\n"); 
		query.append(",       A1.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC B1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC_DTL B2" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_DEF_CD = B1.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND     B1.SVC_SCP_CD = B2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     B1.CRE_OFC_CD = B2.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     B1.GLINE_SEQ = B2.GLINE_SEQ" ).append("\n"); 
		query.append("AND     B1.GRP_LOC_SEQ = B2.GRP_LOC_SEQ" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") D3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--rout pnt dest" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",       A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A2.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       DECODE(A2.ROUT_PNT_LOC_TP_CD, 'G'," ).append("\n"); 
		query.append("A2.LOC_CD, A2.ROUT_PNT_LOC_DEF_CD) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       '' AS LOC_CD" ).append("\n"); 
		query.append(",       A1.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_TP_CD <> 'G'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",       '' AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",       B2.LOC_CD" ).append("\n"); 
		query.append(",       A1.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_PNT A1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC B1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC_DTL B2" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_DEF_CD = B1.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND     A1.ROUT_PNT_LOC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND     B1.SVC_SCP_CD = B2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     B1.CRE_OFC_CD = B2.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     B1.GLINE_SEQ = B2.GLINE_SEQ" ).append("\n"); 
		query.append("AND     B1.GRP_LOC_SEQ = B2.GRP_LOC_SEQ" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") E3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--rout via origin" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A2.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       DECODE(A2.ROUT_VIA_PORT_TP_CD, 'G'," ).append("\n"); 
		query.append("A2.LOC_CD, A2.ROUT_VIA_PORT_DEF_CD) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       '' AS LOC_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND     ROUT_VIA_PORT_TP_CD <> 'G'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       '' AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       B2.LOC_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC B1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC_DTL B2" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.ROUT_VIA_PORT_DEF_CD = B1.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND     A1.ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND     B1.SVC_SCP_CD = B2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     B1.CRE_OFC_CD = B2.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     B1.GLINE_SEQ = B2.GLINE_SEQ" ).append("\n"); 
		query.append("AND     B1.GRP_LOC_SEQ = B2.GRP_LOC_SEQ" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") F3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--rout via DEST" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A2.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       DECODE(A2.ROUT_VIA_PORT_TP_CD, 'G'," ).append("\n"); 
		query.append("A2.LOC_CD, A2.ROUT_VIA_PORT_DEF_CD) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       '' AS LOC_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND     A1.ROUT_VIA_PORT_TP_CD <> 'G'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       A1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A1.BSE_SEQ" ).append("\n"); 
		query.append(",       A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",       A1.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",       '' AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",       B2.LOC_CD" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_ROUT_VIA A1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC B1" ).append("\n"); 
		query.append(",	    PRI_CMPB_GRP_LOC_DTL B2" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.ROUT_VIA_PORT_DEF_CD = B1.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("AND     A1.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND     A1.ROUT_VIA_PORT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND     B1.SVC_SCP_CD = B2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     B1.CRE_OFC_CD = B2.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     B1.GLINE_SEQ = B2.GLINE_SEQ" ).append("\n"); 
		query.append("AND     B1.GRP_LOC_SEQ = B2.GRP_LOC_SEQ" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(") G3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--RATE" ).append("\n"); 
		query.append("SELECT  A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A2.GLINE_SEQ" ).append("\n"); 
		query.append(",       A2.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       A2.BSE_SEQ" ).append("\n"); 
		query.append(",       A2.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",       A2.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",       A2.RAT_UT_CD" ).append("\n"); 
		query.append(",       A2.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",       A2.CURR_CD" ).append("\n"); 
		query.append(",       A2.CMPB_AMT" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_AMT A2" ).append("\n"); 
		query.append("WHERE   A2.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A2.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     A2.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(") H3" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = A3.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = A3.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = A3.GLINE_SEQ" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = A3.PRS_CUST_TP_CD" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = B3.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = B3.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = B3.GLINE_SEQ" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = B3.PRS_CUST_TP_CD" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = B3.BSE_SEQ" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = C3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = C3.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = C3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = C3.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = C3.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = D3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = D3.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = D3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = D3.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = D3.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = E3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = E3.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = E3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = E3.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = E3.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = F3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = F3.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = F3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = F3.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = F3.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = G3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = G3.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = G3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = G3.PRS_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = G3.BSE_SEQ(+)" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = H3.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = H3.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = H3.GLINE_SEQ" ).append("\n"); 
		query.append("AND     I3.PRS_CUST_TP_CD = H3.PRS_CUST_TP_CD" ).append("\n"); 
		query.append("AND     I3.BSE_SEQ = H3.BSE_SEQ" ).append("\n"); 
		query.append("AND     I3.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     I3.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND     I3.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(") A4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}