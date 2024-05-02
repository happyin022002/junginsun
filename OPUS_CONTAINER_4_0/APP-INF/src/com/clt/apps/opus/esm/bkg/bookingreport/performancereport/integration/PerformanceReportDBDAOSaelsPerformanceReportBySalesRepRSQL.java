/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_inlnd_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuntract_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL").append("\n"); 
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
		query.append("SELECT SALE.*" ).append("\n"); 
		query.append("      --,DECODE(SALE.TEU,0,0,ROUND(SALE.GROSS / ((SALE.FEU*2) + SALE.TEU),2)) AS TEU_GROSS" ).append("\n"); 
		query.append("      --,DECODE(SALE.FEU,0,0,ROUND(SALE.GROSS / ((SALE.TEU/2) + SALE.FEU),2)) AS FEU_GROSS" ).append("\n"); 
		query.append("      ,(SALE.GROSS / TTL )    AS TEU_GROSS" ).append("\n"); 
		query.append("      ,(SALE.GROSS / TTL*2 )  AS FEU_GROSS" ).append("\n"); 
		query.append("      --,DECODE(SALE.VOID_SLOT,0,0,ROUND(SALE.GROSS / SALE.VOID_SLOT,2)) AS VOID_RPB" ).append("\n"); 
		query.append("      --,DECODE(SALE.TTL,0,0,ROUND(SALE.GROSS / SALE.TTL,2)) AS EQ_RPB" ).append("\n"); 
		query.append("      ,DECODE((SALE.VOID_TEU + SALE.VOID_FEU),0,0,ROUND(SALE.GROSS / (SALE.VOID_TEU + SALE.VOID_FEU),2)) AS VOID_RPB" ).append("\n"); 
		query.append("      ,DECODE(SALE.TTL,0,0,ROUND(SALE.GROSS / SALE.TTL,2)) AS EQ_RPB" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("SELECT BKG.VVD" ).append("\n"); 
		query.append("      ,BKG.SLAN_CD" ).append("\n"); 
		query.append("      ,BKG.POR_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD" ).append("\n"); 
		query.append("      ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("      ,BKG.OB_SREP_NM" ).append("\n"); 
		query.append("      ,SUM(TEU)                 TEU" ).append("\n"); 
		query.append("      ,SUM(FEU)                 FEU" ).append("\n"); 
		query.append("      ,SUM(VOID_TEU)            VOID_TEU" ).append("\n"); 
		query.append("      ,SUM(VOID_FEU)            VOID_FEU" ).append("\n"); 
		query.append("      ,SUM(TTL)                 TTL" ).append("\n"); 
		query.append("      ,SUM(NET)                 NET" ).append("\n"); 
		query.append("      ,SUM(NON_NET)             NON_NET" ).append("\n"); 
		query.append("      ,SUM(MISC)                MISC" ).append("\n"); 
		query.append("      ,SUM(NON_REV)             NON_REV" ).append("\n"); 
		query.append("      ,SUM(GROSS)               GROSS      " ).append("\n"); 
		query.append("      ,SUM(OFT)                 OFT" ).append("\n"); 
		query.append("      ,SUM(BAF)                 BAF" ).append("\n"); 
		query.append("      ,SUM(CAF)                 CAF" ).append("\n"); 
		query.append("      ,SUM(OTH)                 OTH" ).append("\n"); 
		query.append("      ,SUM(DTH)                 DTH" ).append("\n"); 
		query.append("      ,SUM(DOC)                 DOC" ).append("\n"); 
		query.append("      ,SUM(TAC)                 TAC" ).append("\n"); 
		query.append("      ,SUM(R_OTHER)             R_OTHER" ).append("\n"); 
		query.append("      ,SUM(GROSS)/SUM(TTL)      TEU_GROSS" ).append("\n"); 
		query.append("      ,SUM(GROSS)/SUM(TTL)*2    FEU_GROSS" ).append("\n"); 
		query.append("#if (${rep_knd} != '')" ).append("\n"); 
		query.append("	  ,@[rep_knd] REP_KND" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  ,'' REP_KND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${grp_by} != '')" ).append("\n"); 
		query.append("	  ,@[grp_by]  GRP_BY" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  ,'' GRP_BY" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("  FROM (SELECT BKG.BKG_NO B_NO,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,BKG.POD_CD " ).append("\n"); 
		query.append("              ,BKG.BKG_NO" ).append("\n"); 
		query.append("              ,BKG.SLAN_CD" ).append("\n"); 
		query.append("              ,BKG.POR_CD" ).append("\n"); 
		query.append("              ,CUS.CUST_CNT_CD" ).append("\n"); 
		query.append("              ,CUS.CUST_SEQ" ).append("\n"); 
		query.append("              ,MCUST.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("              ,REPLACE((SELECT SREP_NM FROM MDM_SLS_REP WHERE SREP_CD = BKG.OB_SREP_CD),CHR(10),' ') OB_SREP_NM" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,1,1),'Q',0,(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,-1),'2',NVL(QUA.OP_CNTR_QTY,0),0)))) TEU" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,1,1),'Q',0,(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,-1),'2',0,NVL(QUA.OP_CNTR_QTY,0))))) FEU" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,1,1),'Q',(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,-1),'2',NVL(QUA.OP_CNTR_QTY,0),0)),0)) VOID_TEU" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,1,1),'Q',(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,-1),'2',0,NVL(QUA.OP_CNTR_QTY,0))),0)) VOID_FEU" ).append("\n"); 
		query.append("              ,SUM(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,1,1),'Q',0,(DECODE(SUBSTR(QUA.CNTR_TPSZ_CD,-1),'2',NVL(QUA.OP_CNTR_QTY,0),NVL(QUA.OP_CNTR_QTY,0)*2)))) TTL " ).append("\n"); 
		query.append("          FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("              ,BKG_QUANTITY     QUA" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     CUS" ).append("\n"); 
		query.append("              ,BKG_RATE         RAT" ).append("\n"); 
		query.append("              ,MDM_CUSTOMER     MCUST" ).append("\n"); 
		query.append("         WHERE BKG_STS_CD  NOT IN ('S','X')" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = QUA.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("           AND CUS.BKG_CUST_TP_CD  ='S'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = RAT.BKG_NO" ).append("\n"); 
		query.append("           AND CUS.CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUS.CUST_SEQ  = MCUST.CUST_SEQ" ).append("\n"); 
		query.append("           --AND SUBSTR(QUA.CNTR_TPSZ_CD,1,1) != 'Q' " ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("           ${vvd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '' && ${bkg_cgo_tp_cd} != 'A')" ).append("\n"); 
		query.append("           AND BKG.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')  " ).append("\n"); 
		query.append("           AND CUS.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("           AND CUS.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("           AND CUS.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("           AND CUS.CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cuntract_tp} == 'A' && ${cuntract_no} != '')" ).append("\n"); 
		query.append("           AND BKG.SC_NO = @[cuntract_no]" ).append("\n"); 
		query.append("#elseif (${cuntract_tp} == 'B' && ${cuntract_no} != '')" ).append("\n"); 
		query.append("           AND BKG.RFA_NO = @[cuntract_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.REP_CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '')" ).append("\n"); 
		query.append("           AND BKG.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rc_flg} != '')" ).append("\n"); 
		query.append("           AND BKG.RC_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} != '')" ).append("\n"); 
		query.append("           AND BKG.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bb_cgo_flg} != '')" ).append("\n"); 
		query.append("           AND BKG.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("           AND BKG.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${load_view} == '0')" ).append("\n"); 
		query.append("           AND NVL(BKG.BL_NO_TP, 'M') IN ('0','M')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} == '')" ).append("\n"); 
		query.append("           AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} != '')" ).append("\n"); 
		query.append("           AND BKG.BKG_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                                    FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                   WHERE @[bkg_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                           OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} == '')" ).append("\n"); 
		query.append("           AND BKG.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} != '')" ).append("\n"); 
		query.append("           AND BKG.OB_SLS_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                                       FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                      WHERE @[ob_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                 OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ib_sls_ofc_cd} != '' && ${ib_sls_ofc_sub} == '')" ).append("\n"); 
		query.append("           AND BKG.IB_SLS_OFC_CD = @[ib_sls_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ib_sls_ofc_cd} != '' && ${ib_sls_ofc_sub} != '')" ).append("\n"); 
		query.append("           AND BKG.IB_SLS_OFC_CD IN (SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                                       FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                      WHERE @[ib_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                 OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_rout_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.ORG_SCONTI_CD = @[org_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_rout_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.DEST_SCONTI_CD = @[dest_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_svc_mod_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.ORG_TRNS_SVC_MOD_CD = @[org_svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_inlnd_svc_mod_cd} != '')" ).append("\n"); 
		query.append("           AND BKG.DEST_TRNS_SVC_MOD_CD = @[dest_inlnd_svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_cnt} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BKG.POL_CD,0,2) = @[org_cnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_cnt} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BKG.DEL_CD,0,2) = @[dest_cnt]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${ioc_cd} != '' && ${ioc_cd} == 'O')" ).append("\n"); 
		query.append("           AND SUBSTR(BKG.ORG_SCONTI_CD,0,1) <> SUBSTR(BKG.DEST_SCONTI_CD,0,1)" ).append("\n"); 
		query.append("#elseif (${ioc_cd} != '' && ${ioc_cd} == 'I')" ).append("\n"); 
		query.append("           AND SUBSTR(BKG.ORG_SCONTI_CD,0,1) = SUBSTR(BKG.DEST_SCONTI_CD,0,1)" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("         GROUP BY BKG.BKG_NO,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD " ).append("\n"); 
		query.append("                 ,BKG.POD_CD" ).append("\n"); 
		query.append("                 ,BKG.BKG_NO" ).append("\n"); 
		query.append("                 ,BKG.SLAN_CD" ).append("\n"); 
		query.append("                 ,BKG.POR_CD" ).append("\n"); 
		query.append("                 ,CUS.CUST_CNT_CD" ).append("\n"); 
		query.append("                 ,CUS.CUST_SEQ" ).append("\n"); 
		query.append("                 ,MCUST.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                 ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("#if (${grp_con} != '')" ).append("\n"); 
		query.append("		         ${grp_con}" ).append("\n"); 
		query.append("#end                 " ).append("\n"); 
		query.append("        ) BKG" ).append("\n"); 
		query.append("       ,(SELECT BKG.BKG_NO " ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(MCH.CHG_REV_TP_CD,1,NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) NET" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(MCH.CHG_REV_TP_CD,2,NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) NON_NET" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(MCH.CHG_REV_TP_CD,3,NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) MISC" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(MCH.CHG_REV_TP_CD,1,0,2,0,3,0,NVL(CHG.CHG_AMT,0)) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) NON_REV" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(MCH.CHG_REV_TP_CD,4,0,NVL(CHG.CHG_AMT,0)) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) GROSS   " ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'OFT',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) OFT  " ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'BAF',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) BAF" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'CAF',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) CAF" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'OTH',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) OTH" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'DTH',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) DTH" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'DOC',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) DOC" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'TAC',NVL(CHG.CHG_AMT,0),0) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) TAC" ).append("\n"); 
		query.append("               ,ROUND(SUM(DECODE(CHG.CHG_CD,'OFT',0,'BAF',0,'CAF',0,'OTH',0,'DTH',0,'DOC',0,'TAC',0,NVL(CHG.CHG_AMT,0)) / NVL(XCH.USD_LOCL_XCH_RT,1)),2) R_OTHER " ).append("\n"); 
		query.append("           FROM BKG_BOOKING     BKG " ).append("\n"); 
		query.append("               ,BKG_CHG_RT      CHG" ).append("\n"); 
		query.append("               ,MDM_CHARGE      MCH" ).append("\n"); 
		query.append("               ,GL_MON_XCH_RT   XCH" ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = CHG.BKG_NO" ).append("\n"); 
		query.append("            AND BKG.BKG_STS_CD  NOT IN ('S','X')                          " ).append("\n"); 
		query.append("            AND TO_CHAR(CHG.CRE_DT,'YYYYMM') = XCH.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("            AND CHG.CURR_CD = XCH.CURR_CD(+)" ).append("\n"); 
		query.append("            AND XCH.ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("            AND CHG.CHG_CD = MCH.CHG_CD   " ).append("\n"); 
		query.append("            AND CHG.DP_SEQ = DECODE(CHG.CHG_CD, 'DIH', 430, CHG.DP_SEQ)" ).append("\n"); 
		query.append("            AND (   CHG.CHG_CD NOT IN('DOD', 'TUA')" ).append("\n"); 
		query.append("                 OR CHG.RCV_TERM_CD <> 'H'" ).append("\n"); 
		query.append("                 OR CHG.PRN_HDN_FLG <> 'Y'" ).append("\n"); 
		query.append("                 OR NOT EXISTS(SELECT 'X'" ).append("\n"); 
		query.append("                                 FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                                WHERE BKG.BKG_NO = CHG.BKG_NO" ).append("\n"); 
		query.append("                                  AND BKG.POD_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("                                  AND BKG.DE_TERM_CD IN ('Y','H'))" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("           ${vvd}" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${frt_term_cd} != '')" ).append("\n"); 
		query.append("           AND CHG.FRT_TERM_CD = @[frt_term_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("		   AND CHG.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("          GROUP BY  BKG.BKG_NO   " ).append("\n"); 
		query.append("         ) RATE" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = RATE.BKG_NO(+)               " ).append("\n"); 
		query.append(" GROUP BY BKG.VVD" ).append("\n"); 
		query.append("         ,BKG.POD_CD" ).append("\n"); 
		query.append("         ,BKG.SLAN_CD" ).append("\n"); 
		query.append("         ,BKG.POR_CD" ).append("\n"); 
		query.append("         ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("         ,BKG.OB_SREP_NM" ).append("\n"); 
		query.append(" )SALE" ).append("\n"); 
		query.append(" ORDER BY SALE.VVD, SALE.POR_CD, SALE.POD_CD" ).append("\n"); 

	}
}