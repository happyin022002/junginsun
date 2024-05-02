/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateProductCatalogInternalTemp
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emt_pk_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgOffCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emt_rtn_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dTerm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pm_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prdCtlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ag_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rTerm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL").append("\n"); 
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
		query.append("INSERT ALL" ).append("\n"); 
		query.append("WHEN PCTL_SEQ =1 THEN" ).append("\n"); 
		query.append("    INTO PRD_PROD_CTL_MST " ).append("\n"); 
		query.append("    (PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, POL_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD, " ).append("\n"); 
		query.append("    POD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, OB_ITCHG_CTNT, IB_ITCHG_CTNT, " ).append("\n"); 
		query.append("    N1ST_VSL_LODG_DUE_DT,BKG_RCV_TERM_CD, BKG_DE_TERM_CD,  CMDT_CD, BKG_OFC_CD,  SC_OFC_CD,CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES " ).append("\n"); 
		query.append("    (PCTL_NO,MTPU_CY,@[por] , POR,@[pol] ,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("    @[pod],@[del],DEL,MTRTN_CY,OUT_CONTENT,IN_CONTENT," ).append("\n"); 
		query.append("    TO_DATE(@[skd_date],'YYYYMMDD') ,@[rTerm], @[dTerm],@[com],@[bkgOffCd],@[sc_ofc],NVL(@[user_id],'System'), CRE_DT,NVL(@[user_id],'System'), UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN PCTL_SEQ > 0 THEN" ).append("\n"); 
		query.append("    INTO PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("    ( PCTL_NO, PCTL_SEQ, ORG_NOD_CD, DEST_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, TRSP_MOD_CD, " ).append("\n"); 
		query.append("    PCTL_WTR_DIV_CD, ORG_NOD_TP_CD, DEST_NOD_TP_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT, TZ_DWLL_TM_HRS, " ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, VSL_SLAN_CD, CRR_CD, VSL_CD, SKD_VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG, INLND_ROUT_INV_BIL_PATT_CD, SKD_DIR_CD, ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD, " ).append("\n"); 
		query.append("    ROUT_SEQ, ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ,                                          " ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT , " ).append("\n"); 
		query.append("    RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO )" ).append("\n"); 
		query.append("    VALUES " ).append("\n"); 
		query.append("    (PCTL_NO,PCTL_SEQ,NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("    WTR_DIV_CD,NODE1_TP,NODE2_TP,MT_YD_FLG,A_TIME,D_TIME,TZTM_DW_HRS," ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,SLANE,CRR_CD,VSL_CD,VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG,INLND_ROUT_INV_BIL_PATT_CD,DIR_CD,ROUT_ORG,ROUT_DEST," ).append("\n"); 
		query.append("    ROUT_SEQ,ORG_PORT_SEQ,DST_PORT_SEQ," ).append("\n"); 
		query.append("    NVL(@[user_id],'System'), CRE_DT,NVL(@[user_id],'System'), UPD_DT," ).append("\n"); 
		query.append("    RAIL_CRR_TYPE,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO) " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[prdCtlNo]	||lpad(gp1,4,0) pctl_no, ord pctl_seq," ).append("\n"); 
		query.append("NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD, DECODE(NODE_NEW_KIND,'L',substr(trsp_mod_cd,1,2),'X') trsp_mod_cd," ).append("\n"); 
		query.append("decode(trsp_mod_cd,'WD','W','VD','V') WTR_DIV_CD," ).append("\n"); 
		query.append("NODE1_TP,NODE2_TP,OUT_CONTENT,IN_CONTENT,MTPU_CY,MTRTN_CY,POR,DEL,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,  " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN F_NO2 = 0  AND NODE_NEW_KIND = 'N' AND @[rTerm] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("WHEN F_NO2 = 33 AND NODE_NEW_KIND = 'N' AND @[dTerm] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N' END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("MT_YD_FLG," ).append("\n"); 
		query.append("(CASE WHEN A_TIME IS NOT NULL THEN A_TIME" ).append("\n"); 
		query.append("      WHEN F_NO2 = 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24 " ).append("\n"); 
		query.append("      WHEN F_NO2 < 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24)  + DECODE(@[pm_f],'Y',3, 6)/24 " ).append("\n"); 
		query.append("      WHEN F_NO2 >= 20  THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) -TZTM_DW_HRS/24" ).append("\n"); 
		query.append("END) " ).append("\n"); 
		query.append("A_TIME," ).append("\n"); 
		query.append("(CASE WHEN D_TIME IS NOT NULL THEN D_TIME" ).append("\n"); 
		query.append("      WHEN F_NO2 = 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24" ).append("\n"); 
		query.append("      WHEN F_NO2 < 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24 + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("      WHEN F_NO2 >= 20 THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) " ).append("\n"); 
		query.append("END) " ).append("\n"); 
		query.append("D_TIME," ).append("\n"); 
		query.append("ROUND((" ).append("\n"); 
		query.append("    (CASE WHEN D_TIME IS NOT NULL THEN D_TIME" ).append("\n"); 
		query.append("          WHEN F_NO2 = 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24" ).append("\n"); 
		query.append("          WHEN F_NO2 < 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24 + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("          WHEN F_NO2 >= 20 THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) " ).append("\n"); 
		query.append("    END)  -" ).append("\n"); 
		query.append("    (CASE WHEN A_TIME IS NOT NULL THEN A_TIME" ).append("\n"); 
		query.append("          WHEN F_NO2 = 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24 " ).append("\n"); 
		query.append("          WHEN F_NO2 < 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24)  + DECODE(@[pm_f],'Y',3, 6)/24 " ).append("\n"); 
		query.append("          WHEN F_NO2 >= 20  THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) -TZTM_DW_HRS/24" ).append("\n"); 
		query.append("    END) 	" ).append("\n"); 
		query.append(") *24)" ).append("\n"); 
		query.append("TZTM_DW_HRS ," ).append("\n"); 
		query.append("(CASE WHEN NODE_NEW_KIND = 'N' THEN N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      WHEN NODE_NEW_KIND = 'L' AND F_NO2 =0 AND @[rTerm] = 'D' THEN" ).append("\n"); 
		query.append("        LEAD(N1ST_VNDR_SEQ, 1) OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY F_NO2,L_N0)" ).append("\n"); 
		query.append("      WHEN NODE_NEW_KIND = 'L' AND F_NO2 =32 AND @[dTerm] = 'D' THEN" ).append("\n"); 
		query.append("        LAG(N1ST_VNDR_SEQ, 1) OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY F_NO2,L_N0)" ).append("\n"); 
		query.append("      ELSE N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,SLANE," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VOY_NO," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("ORG_PORT_SEQ," ).append("\n"); 
		query.append("DST_PORT_SEQ," ).append("\n"); 
		query.append("INLND_ROUT_CMB_FLG,TRIM(INLND_ROUT_INV_BIL_PATT_CD) INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("ROUT_ORG,ROUT_DEST,ROUT_SEQ," ).append("\n"); 
		query.append(" @[ag_seq] COST_ACT_GRP_SEQ ,  @[user_id] CRE_USR_ID, sysdate CRE_DT , @[update_id] UPD_USR_ID, sysdate UPD_DT," ).append("\n"); 
		query.append("TRIM(RAIL_CRR_TYPE) RAIL_CRR_TYPE , TRIM(INLND_ROUT_INCL_STTL_FLG) INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("TRIM(TRSP_AGMT_OFC_CTY_CD) TRSP_AGMT_OFC_CTY_CD, TRIM(TRSP_AGMT_SEQ) TRSP_AGMT_SEQ, TRIM(AGMT_REF_NO) AGMT_REF_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("     GP1,F_NO2,L_N0,O1,ROW_NUMBER() over (PARTITION BY GP1 ORDER BY F_NO2,L_N0,O1) ord," ).append("\n"); 
		query.append("     NODE_NEW1,(SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) NODE1_TP," ).append("\n"); 
		query.append("     DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))  NODE_NEW2," ).append("\n"); 
		query.append("     (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2," ).append("\n"); 
		query.append("     SUBSTR(NODE_NEW2,3,7))) NODE2_TP,NODE_NEW_KIND,OI_BND_CD,OUT_CONTENT,IN_CONTENT, MTPU_CY,MTRTN_CY,OB_ORG POR,IB_DEST DEL,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,CCT," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN ( 0,32) THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 = 1 AND @[rTerm] ='S' AND OB_SEQ= 0 THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 = 20 AND @[dTerm] IN ('S','T','F','Y') AND IB_SEQ= 0 THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN (13,15,17,19) THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DECODE(VSL_SVC_TP_CD, 'O', 'WD', 'VD')" ).append("\n"); 
		query.append("            FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("            WHERE VSL_SLAN_CD = DECODE(F_NO2,13,N1ST_LANE_CD,15,N2ND_LANE_CD,17,N3RD_LANE_CD,19,N4TH_LANE_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN SUBSTR(NODE_NEW2,10,2)" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("        NVL((" ).append("\n"); 
		query.append("            SELECT D.TRSP_MOD_CD" ).append("\n"); 
		query.append("            FROM PRD_INLND_ROUT_MST M, PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("            WHERE M.ROUT_ORG_NOD_CD =NODE_NEW1" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))" ).append("\n"); 
		query.append("            AND M.PRIO_SEQ = (" ).append("\n"); 
		query.append("                               SELECT /*+ INDEX (M2 XAK1PRD_INLND_ROUT_MST) */" ).append("\n"); 
		query.append("                               M2.PRIO_SEQ" ).append("\n"); 
		query.append("                               FROM PRD_INLND_ROUT_MST M2, PRD_INLND_ROUT_DTL D2" ).append("\n"); 
		query.append("                               WHERE" ).append("\n"); 
		query.append("                               M2.ROUT_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                               AND M2.ROUT_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("                               AND M2.ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                               AND M2.ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                               AND M2.ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND NVL(M2.PCTL_IO_BND_CD,OI_BND_CD) IN (OI_BND_CD, 'B')" ).append("\n"); 
		query.append("                               AND NVL(M2.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                               AND D2.LNK_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                               AND D2.LNK_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("                               AND D2.ROUT_DTL_SEQ = 1" ).append("\n"); 
		query.append("                               AND NOT EXISTS ( SELECT 'X' FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("                                                WHERE" ).append("\n"); 
		query.append("                                                ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                                AND ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                                AND ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("                                                AND ROUT_DTL_SEQ = 2 )" ).append("\n"); 
		query.append("                               AND ROWNUM = 1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("            AND M.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("            AND NVL(M.PCTL_IO_BND_CD,OI_BND_CD) IN (OI_BND_CD, 'B')" ).append("\n"); 
		query.append("            AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND M.ROUT_ORG_NOD_CD = D.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = D.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ),'TD')" ).append("\n"); 
		query.append("    END) trsp_mod_cd," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 IN (1,32) AND (SELECT NOD_TP_CD FROM PRD_NODE" ).append("\n"); 
		query.append("                                                        WHERE NOD_CD = NODE_NEW1) = 'Z' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CGO_HNDL_TM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 = 1 AND @[rTerm] ='S' AND OB_SEQ = 0 AND" ).append("\n"); 
		query.append("            (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        0" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 = 32 AND @[dTerm] ='S' AND IB_SEQ = 0 AND" ).append("\n"); 
		query.append("            (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        0" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DECODE(F_NO2,33,0,DECODE(F_NO2,0,0,DECODE(OI_BND_CD, 'T', 0, DECODE(@[pm_f],'Y'," ).append("\n"); 
		query.append("                                           3, 6)))) FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rTerm] = 'D' AND F_NO2 = 0   THEN" ).append("\n"); 
		query.append("        (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW2 )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[dTerm] = 'D' AND F_NO2 = 32  THEN" ).append("\n"); 
		query.append("        (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1 )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rTerm] =  'S' AND F_NO2 = 0   THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rTerm] =  'S' AND F_NO2 = 1  AND OB_SEQ = 0 THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[dTerm] =  'S' AND F_NO2 = 32   THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[dTerm] =  'S' AND F_NO2 = 20 AND IB_SEQ = 0 THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rTerm] NOT IN ( 'D','S' ) AND F_NO2 = 0   THEN 24" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[dTerm] NOT IN ( 'D','S' ) AND F_NO2 = 32  THEN 24" ).append("\n"); 
		query.append("        WHEN (F_NO2 =13 ) AND (NODE_NEW_KIND='L') THEN N1ST_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =15 ) AND (NODE_NEW_KIND='L') THEN N2ND_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =17 ) AND (NODE_NEW_KIND='L') THEN N3RD_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =19 ) AND (NODE_NEW_KIND='L') THEN N4TH_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND OI_BND_CD ='T' AND F_NO2 NOT IN (13,15,17,19) THEN 6" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("         (SELECT TZTM_HRS" ).append("\n"); 
		query.append("            FROM PRD_INLND_EACH_LNK" ).append("\n"); 
		query.append("           WHERE lnk_org_nod_cd = NODE_NEW1" ).append("\n"); 
		query.append("            AND lnk_dest_nod_cd = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))" ).append("\n"); 
		query.append("            AND TRSP_MOD_CD = DECODE(LENGTH(NODE_NEW2),7,'TD',SUBSTR(NODE_NEW2,10,2))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    END ) TZTM_DW_HRS," ).append("\n"); 
		query.append("    POLT1 POL_T," ).append("\n"); 
		query.append("    SUBSTR(TRIM(PODT1||PODT2||PODT3||PODT4),-14) POD_T , " ).append("\n"); 
		query.append("    A_TIME," ).append("\n"); 
		query.append("    D_TIME," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(N1ST_VNDR_SEQ)" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN (13,15,17,19) THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(VNDR_SEQ)" ).append("\n"); 
		query.append("            FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("            WHERE VSL_SLAN_CD =DECODE(F_NO2,13,N1ST_LANE_CD,15,N2ND_LANE_CD,17,N3RD_LANE_CD,19,N4TH_LANE_CD)" ).append("\n"); 
		query.append("            AND LNK_ORG_LOC_CD = SUBSTR(NODE_NEW1,1,5)" ).append("\n"); 
		query.append("            AND LNK_DEST_LOC_CD = DECODE(LENGTH(NODE_NEW2),7,SUBSTR(NODE_NEW2,1,5),SUBSTR(NODE_NEW2,3,5))" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN DECODE(SUBSTR(NODE_NEW2,12,6),'N','',SUBSTR(NODE_NEW2,12,6))" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(D.VNDR_SEQ )" ).append("\n"); 
		query.append("            FROM PRD_INLND_ROUT_MST M, PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("            WHERE M.ROUT_ORG_NOD_CD =NODE_NEW1" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))" ).append("\n"); 
		query.append("            AND M.PRIO_SEQ = (" ).append("\n"); 
		query.append("                               SELECT /*+ INDEX (M2 XAK1PRD_INLND_ROUT_MST) */" ).append("\n"); 
		query.append("                               M2.PRIO_SEQ" ).append("\n"); 
		query.append("                               FROM PRD_INLND_ROUT_MST M2, PRD_INLND_ROUT_DTL D2" ).append("\n"); 
		query.append("                               WHERE" ).append("\n"); 
		query.append("                               M2.ROUT_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                               AND M2.ROUT_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("                               AND M2.ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                               AND M2.ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                               AND M2.ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("                               AND NVL(M2.PCTL_IO_BND_CD,OI_BND_CD) IN (OI_BND_CD, 'B')" ).append("\n"); 
		query.append("                               AND NVL(M2.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                               AND D2.LNK_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                               AND D2.LNK_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("                               AND D2.ROUT_DTL_SEQ = 1" ).append("\n"); 
		query.append("                               AND NOT EXISTS ( SELECT 'X' FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("                                                WHERE" ).append("\n"); 
		query.append("                                                ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                                AND ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                                AND ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("                                                AND ROUT_DTL_SEQ = 2 )" ).append("\n"); 
		query.append("                               AND ROWNUM = 1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("            AND M.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("            AND NVL(M.PCTL_IO_BND_CD,OI_BND_CD) IN (OI_BND_CD, 'B')" ).append("\n"); 
		query.append("            AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND M.ROUT_ORG_NOD_CD = D.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("            AND M.ROUT_DEST_NOD_CD = D.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    END ) N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     END ) N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     END ) N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN (F_NO2 =13 ) AND (NODE_NEW_KIND='L') THEN N1ST_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =15 ) AND (NODE_NEW_KIND='L') THEN N2ND_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =17 ) AND (NODE_NEW_KIND='L') THEN N3RD_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =19 ) AND (NODE_NEW_KIND='L') THEN N4TH_LANE_CD" ).append("\n"); 
		query.append("    END ) SLANE," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,15,VVD2,17,VVD3,19,VVD4,NULL),1,4)" ).append("\n"); 
		query.append("    END ) VSL_CD," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,15,VVD2,17,VVD3,19,VVD4,NULL),5,4)" ).append("\n"); 
		query.append("    END ) VOY_NO," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,15,VVD2,17,VVD3,19,VVD4,NULL),9,1)" ).append("\n"); 
		query.append("    END ) DIR_CD," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,CRR1,15,CRR2,17,CRR3,19,CRR4,NULL)" ).append("\n"); 
		query.append("    END ) CRR_CD," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,POL_SEQ1,15,POL_SEQ2,17,POL_SEQ3,19,POL_SEQ4,NULL)" ).append("\n"); 
		query.append("    END ) ORG_PORT_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,15,17,19) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,POD_SEQ1,15,POD_SEQ2,17,POD_SEQ3,19,POD_SEQ4,NULL)" ).append("\n"); 
		query.append("    END ) DST_PORT_SEQ,    " ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'N',SUBSTR(NODE_NEW2,18,1))  INLND_ROUT_CMB_FLG," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,19,3))  INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,22,3))  RAIL_CRR_TYPE," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,25,3))  TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,28,6))  TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,34,15))  AGMT_REF_NO," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,49,1))  INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_ORG,'O',OB_ORG,'T',ORG_LOC_CD) ROUT_ORG," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_DEST,'O',OB_DEST,'T',DEST_LOC_CD) ROUT_DEST," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_SEQ,'O',OB_SEQ,'T',OCN_SEQ) ROUT_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        GP1,  F_N0 AS F_NO2, L_N0, O1," ).append("\n"); 
		query.append("        (CASE LENGTH(NODE1) WHEN 7 THEN NODE1 ELSE SUBSTR(NODE1,3,7)  END ) NODE_NEW1," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         CASE WHEN L_N0 = 1 THEN NODE1" ).append("\n"); 
		query.append("              WHEN L_N0 = 2 AND F_N0 =32 AND @[dTerm] = 'S' AND IB_SEQ =0 THEN ''" ).append("\n"); 
		query.append("              WHEN L_N0 = 2 THEN LEAD(NODE1, 1, NULL) OVER (PARTITION BY GP1 ORDER BY GP1,F_N0,L_N0,O1)" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("        ) NODE_NEW2," ).append("\n"); 
		query.append("        (CASE L_N0 WHEN 1 THEN 'N' WHEN 2 THEN 'L' END) NODE_NEW_KIND," ).append("\n"); 
		query.append("        ( CASE" ).append("\n"); 
		query.append("            WHEN F_N0 IN (13,15,17,19) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,13,POLT1,15,POLT2,17,POLT3,19,POLT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            WHEN F_N0 IN (15,17,19) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,13,POLT1,15,POLT2,17,POLT3,19,POLT4,NULL),'YYYYMMDDHH24MISS') -6/24 --CCT???" ).append("\n"); 
		query.append("            WHEN F_N0 IN (14,16,18) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,14,PODT1,16,PODT2,18,PODT3,NULL),'YYYYMMDDHH24MISS') + 6/24" ).append("\n"); 
		query.append("            WHEN F_N0 IN (14,16,18) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,14,PODT1,16,PODT2,18,PODT3,NULL),'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("        END ) A_TIME," ).append("\n"); 
		query.append("        ( CASE" ).append("\n"); 
		query.append("            WHEN F_N0 IN (13,15,17,19) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,13,PODT1,15,PODT2,17,PODT3,19,PODT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            WHEN F_N0 IN (15,17,19) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,13,POLT1,15,POLT2,17,POLT3,19,POLT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            WHEN F_N0 IN (14,16,18) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,14,PODT1,16,PODT2,18,PODT3,NULL),'YYYYMMDDHH24MISS') + 12/24" ).append("\n"); 
		query.append("            WHEN F_N0 IN (14,16,18) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                TO_DATE(DECODE(F_N0,14,PODT1,16,PODT2,18,PODT3,NULL),'YYYYMMDDHH24MISS') + 6/24" ).append("\n"); 
		query.append("        END ) D_TIME," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN F_N0 <=12 OR (F_N0 = 13 AND L_N0 =1)  THEN 'O'" ).append("\n"); 
		query.append("            WHEN F_N0 >= 20  THEN 'I' ELSE 'T'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        ) OI_BND_CD," ).append("\n"); 
		query.append("        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,CCT," ).append("\n"); 
		query.append("        POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("        POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("        POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("        POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("        N1ST_TZTM_HRS ,N2ND_TZTM_HRS ,N3RD_TZTM_HRS ,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("        IB_ORG, IB_DEST,IB_SEQ,IN_CONTENT,MTRTN_CY,DEL," ).append("\n"); 
		query.append("        OB_ORG, OB_DEST,OB_SEQ,OUT_CONTENT,MTPU_CY," ).append("\n"); 
		query.append("        ORG_LOC_CD, DEST_LOC_CD, OCN_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT C_POL,F_N0, GP1,NODE1,ROWNUM O1," ).append("\n"); 
		query.append("            N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("            N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("            POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("            POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("            POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("            POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("            IB_ORG, IB_DEST,IB_SEQ,IN_CONTENT,MTRTN_CY,DEL," ).append("\n"); 
		query.append("            OB_ORG, OB_DEST,OB_SEQ,OUT_CONTENT,MTPU_CY," ).append("\n"); 
		query.append("            ORG_LOC_CD, DEST_LOC_CD,OCN_SEQ" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                GP1,F_N0," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                CASE F_N0" ).append("\n"); 
		query.append("                    WHEN 0 THEN MTPU_CY" ).append("\n"); 
		query.append("                    WHEN 1 THEN DECODE(@[rTerm],'T','',DECODE(@[rTerm],'F','',DECODE(@[por],@[pol],DECODE(OB_SEQ,0,DECODE(@[rTerm],'D',OB_ORG,'S',OB_ORG,''),OB_ORG),OB_ORG)))" ).append("\n"); 
		query.append("                    WHEN 2 THEN OL_NODE01   WHEN 3 THEN OL_NODE02   WHEN 4 THEN OL_NODE03   WHEN 5 THEN OL_NODE04" ).append("\n"); 
		query.append("                    WHEN 6 THEN OL_NODE05   WHEN 7 THEN OL_NODE06   WHEN 8 THEN OL_NODE07   WHEN 9 THEN OL_NODE08" ).append("\n"); 
		query.append("                    WHEN 10 THEN OL_NODE09  WHEN 11 THEN OL_NODE10  WHEN 12 THEN NULL" ).append("\n"); 
		query.append("                    WHEN 13 THEN DECODE(@[rTerm],'T',OB_ORG,DECODE(@[rTerm],'F',OB_ORG,NVL(POL0,POL1)))  WHEN 14 THEN DECODE(POD1,POD_NODE,'',DECODE(POD1,POL2,'',POD1))" ).append("\n"); 
		query.append("                    WHEN 15 THEN POL2     WHEN 16 THEN DECODE(POD2,POD_NODE,'',DECODE(POD2,POL3,'',POD2))     WHEN 17 THEN POL3     WHEN 18 THEN DECODE(POD3,POD_NODE,'',DECODE(POD3,POL4,'',POD3))" ).append("\n"); 
		query.append("                    WHEN 19 THEN POL4     WHEN 20 THEN POD_NODE      WHEN 21 THEN NULL     WHEN 22 THEN IL_NODE01" ).append("\n"); 
		query.append("                    WHEN 23 THEN IL_NODE02  WHEN 24 THEN IL_NODE03  WHEN 25 THEN IL_NODE04  WHEN 26 THEN IL_NODE05" ).append("\n"); 
		query.append("                    WHEN 27 THEN IL_NODE06  WHEN 28 THEN IL_NODE07  WHEN 29 THEN IL_NODE08  WHEN 30 THEN IL_NODE09" ).append("\n"); 
		query.append("                    WHEN 31 THEN IL_NODE10" ).append("\n"); 
		query.append("                    WHEN 32 THEN DECODE(@[dTerm],'T','',DECODE(@[dTerm],'F','',DECODE(NVL(@[pod],SUBSTR(POD_NODE,1,5)),@[del],DECODE(IB_SEQ,0,DECODE(@[dTerm],'D',DEL,'S',DEL,''),DEL),DEL)))" ).append("\n"); 
		query.append("                    WHEN 33 THEN MTRTN_CY ELSE 'N/A'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                ) NODE1, OUT_CONTENT,IN_CONTENT," ).append("\n"); 
		query.append("                N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                MTPU_CY," ).append("\n"); 
		query.append("                OL_NODE01,OL_NODE02,OL_NODE03,OL_NODE04,OL_NODE05,OL_NODE06,OL_NODE07,OL_NODE08,OL_NODE09,OL_NODE10," ).append("\n"); 
		query.append("                POL0 AS C_POL," ).append("\n"); 
		query.append("                IL_NODE01,IL_NODE02,IL_NODE03,IL_NODE04,IL_NODE05,IL_NODE06,IL_NODE07,IL_NODE08,IL_NODE09,IL_NODE10," ).append("\n"); 
		query.append("                DEL," ).append("\n"); 
		query.append("                MTRTN_CY," ).append("\n"); 
		query.append("                OB_ORG,OB_DEST,OB_PRIO_SEQ,OB_SEQ,             " ).append("\n"); 
		query.append("                IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ,           " ).append("\n"); 
		query.append("                ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                    OB_ORG,OB_DEST,OB_SEQ,OB_PRIO_SEQ,OB_CNT," ).append("\n"); 
		query.append("                    (CASE WHEN @[rTerm] = 'S' AND OB_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("                          WHEN @[emt_pk_yd] IS NOT NULL THEN @[emt_pk_yd]" ).append("\n"); 
		query.append("                          WHEN @[rTerm] ='D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = OB_ORG)" ).append("\n"); 
		query.append("                          ELSE (SELECT L.MTY_PKUP_YD_CD FROM MDM_LOCATION L WHERE L.LOC_CD =@[por])" ).append("\n"); 
		query.append("                    END) MTPU_CY," ).append("\n"); 
		query.append("                    OB_ORG AS POR," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 1 , DECODE(OB_CNT, 1 , '', OB_ROUT))) OL_NODE01," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 2 , DECODE(OB_CNT, 2 , '', OB_ROUT))) OL_NODE02," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 3 , DECODE(OB_CNT, 3 , '', OB_ROUT))) OL_NODE03," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 4 , DECODE(OB_CNT, 4 , '', OB_ROUT))) OL_NODE04," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 5 , DECODE(OB_CNT, 5 , '', OB_ROUT))) OL_NODE05," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 6 , DECODE(OB_CNT, 6 , '', OB_ROUT))) OL_NODE06," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 7 , DECODE(OB_CNT, 7 , '', OB_ROUT))) OL_NODE07," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 8 , DECODE(OB_CNT, 8 , '', OB_ROUT))) OL_NODE08," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 9 , DECODE(OB_CNT, 9 , '', OB_ROUT))) OL_NODE09," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_DTL_SEQ, 10, DECODE(OB_CNT, 10, '', OB_ROUT))) OL_NODE10," ).append("\n"); 
		query.append("                    DECODE(OB_SEQ,0,NULL,MAX(OB_ROUT)) AS POL0 ," ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 1 , '', DECODE(OB_DTL_SEQ, 1 , SUBSTR(OB_ROUT,3,7))))) ||       " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 2 , '', DECODE(OB_DTL_SEQ, 2 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 3 , '', DECODE(OB_DTL_SEQ, 3 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 4 , '', DECODE(OB_DTL_SEQ, 4 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 5 , '', DECODE(OB_DTL_SEQ, 5 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 6 , '', DECODE(OB_DTL_SEQ, 6 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 7 , '', DECODE(OB_DTL_SEQ, 7 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 8 , '', DECODE(OB_DTL_SEQ, 8 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 9 , '', DECODE(OB_DTL_SEQ, 9 , '-'||SUBSTR(OB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 10, '', DECODE(OB_DTL_SEQ, 10, '-'||SUBSTR(OB_ROUT,3,7)))))     " ).append("\n"); 
		query.append("                    AS OUT_CONTENT," ).append("\n"); 
		query.append("                    ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,                    " ).append("\n"); 
		query.append("                    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                    LNK_KNT," ).append("\n"); 
		query.append("                    POL1,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                    POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                    POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                    POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                    POD_NODE," ).append("\n"); 
		query.append("                    CHECK_ROUT," ).append("\n"); 
		query.append("                    IB_ORG,IB_DEST,IB_SEQ,IB_PRIO_SEQ,IB_CNT," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 1 , DECODE(IB_CNT, 1 , '', IB_ROUT))) IL_NODE01," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 2 , DECODE(IB_CNT, 2 , '', IB_ROUT))) IL_NODE02," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 3 , DECODE(IB_CNT, 3 , '', IB_ROUT))) IL_NODE03," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 4 , DECODE(IB_CNT, 4 , '', IB_ROUT))) IL_NODE04," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 5 , DECODE(IB_CNT, 5 , '', IB_ROUT))) IL_NODE05," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 6 , DECODE(IB_CNT, 6 , '', IB_ROUT))) IL_NODE06," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 7 , DECODE(IB_CNT, 7 , '', IB_ROUT))) IL_NODE07," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 8 , DECODE(IB_CNT, 8 , '', IB_ROUT))) IL_NODE08," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 9 , DECODE(IB_CNT, 9 , '', IB_ROUT))) IL_NODE09," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_DTL_SEQ, 10, DECODE(IB_CNT, 10, '', IB_ROUT))) IL_NODE10," ).append("\n"); 
		query.append("                    MAX(IB_ROUT) DEL," ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 1 , '', DECODE(IB_DTL_SEQ, 1 , SUBSTR(IB_ROUT,3,7))))) ||       " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 2 , '', DECODE(IB_DTL_SEQ, 2 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 3 , '', DECODE(IB_DTL_SEQ, 3 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 4 , '', DECODE(IB_DTL_SEQ, 4 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 5 , '', DECODE(IB_DTL_SEQ, 5 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 6 , '', DECODE(IB_DTL_SEQ, 6 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 7 , '', DECODE(IB_DTL_SEQ, 7 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 8 , '', DECODE(IB_DTL_SEQ, 8 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 9 , '', DECODE(IB_DTL_SEQ, 9 , '-'||SUBSTR(IB_ROUT,3,7))))) ||  " ).append("\n"); 
		query.append("                    MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 10, '', DECODE(IB_DTL_SEQ, 10, '-'||SUBSTR(IB_ROUT,3,7)))))     " ).append("\n"); 
		query.append("                    AS IN_CONTENT," ).append("\n"); 
		query.append("                    (CASE WHEN @[dTerm] = 'S' AND IB_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("                          WHEN @[emt_rtn_yd] IS NOT NULL THEN @[emt_rtn_yd]" ).append("\n"); 
		query.append("                          WHEN @[dTerm] ='D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = IB_DEST)" ).append("\n"); 
		query.append("                          ELSE (SELECT NVL(L.EQ_RTN_YD_CD, L.MTY_PKUP_YD_CD) FROM MDM_LOCATION L WHERE L.LOC_CD =@[del]) " ).append("\n"); 
		query.append("                    END) MTRTN_CY," ).append("\n"); 
		query.append("                    RANK() OVER (ORDER BY  ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ, OB_ORG,OB_DEST,OB_SEQ," ).append("\n"); 
		query.append("                                IB_ORG,IB_DEST,IB_SEQ,POL1,POD1,POL2, POD2,POL3,POD3,POL4,POD4) GP1                                           " ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                        OB_ORG,OB_DEST,OB_SEQ," ).append("\n"); 
		query.append("                        RANK() OVER (PARTITION BY ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,OB_ORG,OB_DEST ORDER BY FULL_RTN_PRIO_SEQ, OB_MODE_PRIO_SEQ,OB_PRIO_SEQ) OB_RK," ).append("\n"); 
		query.append("                        OB_PRIO_SEQ," ).append("\n"); 
		query.append("                        RPAD(OD.ROUT_DTL_SEQ,2,' ')||OD.LNK_DEST_NOD_CD||OD.TRSP_MOD_CD||LPAD(NVL(OD.VNDR_SEQ,0),6,0)||" ).append("\n"); 
		query.append("                               NVL(OD.INLND_ROUT_CMB_FLG,'N')||LPAD(NVL(OB_INLND_ROUT_INV_BIL_PATT_CD,' '),3,' ') ||" ).append("\n"); 
		query.append("                               RPAD(NVL(OD.RAIL_CRR_TP_CD,' '),3,' ') || RPAD(NVL(OD.TRSP_AGMT_OFC_CTY_CD,' '),3,' ') || LPAD(NVL(OD.TRSP_AGMT_SEQ,0),6,0) ||" ).append("\n"); 
		query.append("                               RPAD(NVL(OD.AGMT_REF_NO,' '),15,' ') || RPAD(NVL(OB_INLND_ROUT_INCL_STTL_FLG,' '),1,' ') OB_ROUT," ).append("\n"); 
		query.append("                        OD.ROUT_DTL_SEQ OB_DTL_SEQ," ).append("\n"); 
		query.append("                        COUNT(DISTINCT OD.ROUT_DTL_SEQ) OVER (PARTITION BY OB_ORG,OB_DEST,OB_SEQ) AS OB_CNT," ).append("\n"); 
		query.append("                        ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,LNK_KNT," ).append("\n"); 
		query.append("                        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                        N1ST_TZTM_HRS ,N2ND_TZTM_HRS ,N3RD_TZTM_HRS ,N4TH_TZTM_HRS,CCT,                        " ).append("\n"); 
		query.append("                        POL1,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                        POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                        POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                        POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                        POD_NODE," ).append("\n"); 
		query.append("                        CHECK_ROUT," ).append("\n"); 
		query.append("                        IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ," ).append("\n"); 
		query.append("                        RANK() OVER (PARTITION BY ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,IB_ORG,IB_DEST ORDER BY IB_MODE_PRIO_SEQ,IB_PRIO_SEQ ) IB_RK,   " ).append("\n"); 
		query.append("                        RPAD(ID.ROUT_DTL_SEQ,2,' ')||ID.LNK_DEST_NOD_CD||ID.TRSP_MOD_CD||LPAD(NVL(ID.VNDR_SEQ,0),6,0)||" ).append("\n"); 
		query.append("                        NVL(ID.INLND_ROUT_CMB_FLG,'N')||LPAD(NVL(IB_INLND_ROUT_INV_BIL_PATT_CD,' '),3,' ') ||" ).append("\n"); 
		query.append("                        RPAD(NVL(ID.RAIL_CRR_TP_CD,' '),3,' ') || RPAD(NVL(ID.TRSP_AGMT_OFC_CTY_CD,' '),3,' ') || LPAD(NVL(ID.TRSP_AGMT_SEQ,0),6,0) ||" ).append("\n"); 
		query.append("                        RPAD(NVL(ID.AGMT_REF_NO,' '),15,' ') || RPAD(NVL(IB_INLND_ROUT_INCL_STTL_FLG,' '),1,' ') IB_ROUT," ).append("\n"); 
		query.append("                        ID.ROUT_DTL_SEQ IB_DTL_SEQ," ).append("\n"); 
		query.append("                        COUNT(DISTINCT ID.ROUT_DTL_SEQ) OVER (PARTITION BY IB_ORG,IB_DEST,IB_SEQ) AS IB_CNT" ).append("\n"); 
		query.append("                        FROM " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT ROWNUM," ).append("\n"); 
		query.append("                            NVL(O.ROUT_ORG_NOD_CD,POL1) OB_ORG," ).append("\n"); 
		query.append("                            NVL(O.ROUT_DEST_NOD_CD,POL1) OB_DEST," ).append("\n"); 
		query.append("                            DECODE(NVL(@[full_rtn_yd],'X'),O.FULL_RTN_YD_CD,1,2) FULL_RTN_PRIO_SEQ," ).append("\n"); 
		query.append("                            DECODE(SIGN(INSTR(O.TRSP_MOD_CD,SUBSTR(@[ob_trsp_mode],1,1))),1,1,2) OB_MODE_PRIO_SEQ," ).append("\n"); 
		query.append("                            O.PRIO_SEQ OB_PRIO_SEQ," ).append("\n"); 
		query.append("                            NVL(O.ROUT_SEQ,0) OB_SEQ,                 " ).append("\n"); 
		query.append("                            O.INLND_ROUT_INCL_STTL_FLG OB_INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                            O.INLND_ROUT_INV_BIL_PATT_CD OB_INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("                            T.ORG_LOC_CD,T.DEST_LOC_CD,T.ROUT_SEQ OCN_SEQ,T.LNK_KNT," ).append("\n"); 
		query.append("                            T.N1ST_LANE_CD,T.N2ND_LANE_CD,T.N3RD_LANE_CD,T.N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                            T.N1ST_TZTM_HRS,T.N2ND_TZTM_HRS,T.N3RD_TZTM_HRS,T.N4TH_TZTM_HRS,T.CCT,                           " ).append("\n"); 
		query.append("                            T.POL1,T.POD1,T.POLT1,T.PODT1,T.VVD1,T.CRR1,T.POL_SEQ1,T.POD_SEQ1," ).append("\n"); 
		query.append("                            T.POL2,T.POD2,T.POLT2,T.PODT2,T.VVD2,T.CRR2,T.POL_SEQ2,T.POD_SEQ2," ).append("\n"); 
		query.append("                            T.POL3,T.POD3,T.POLT3,T.PODT3,T.VVD3,T.CRR3,T.POL_SEQ3,T.POD_SEQ3," ).append("\n"); 
		query.append("                            T.POL4,T.POD4,T.POLT4,T.PODT4,T.VVD4,T.CRR4,T.POL_SEQ4,T.POD_SEQ4," ).append("\n"); 
		query.append("                            T.POD_NODE," ).append("\n"); 
		query.append("                            T.CHECK_ROUT," ).append("\n"); 
		query.append("                            NVL(I.ROUT_ORG_NOD_CD,T.POD_NODE) IB_ORG," ).append("\n"); 
		query.append("                            NVL(I.ROUT_DEST_NOD_CD,T.POD_NODE) IB_DEST," ).append("\n"); 
		query.append("                            DECODE(SIGN(INSTR(I.TRSP_MOD_CD,SUBSTR(@[ib_trsp_mode],1,1))),1,1,2) IB_MODE_PRIO_SEQ," ).append("\n"); 
		query.append("                            I.PRIO_SEQ IB_PRIO_SEQ," ).append("\n"); 
		query.append("                            NVL(I.ROUT_SEQ,0) IB_SEQ,    " ).append("\n"); 
		query.append("                            I.INLND_ROUT_INCL_STTL_FLG IB_INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                            I.INLND_ROUT_INV_BIL_PATT_CD IB_INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("                            I.PCTL_IO_BND_CD," ).append("\n"); 
		query.append("                            (CASE WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                    AND @[por] = @[pol] AND @[rTerm] = 'S' AND POL1_S ='Y' THEN 'Y'" ).append("\n"); 
		query.append("                                  WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                    AND @[por] = @[pol] AND @[rTerm] <> 'D' THEN 'Y'" ).append("\n"); 
		query.append("                                  WHEN O.ROUT_ORG_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                    AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                         WHERE N.NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                           AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[rTerm],'D','D','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rTerm],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rTerm],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rTerm],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rTerm],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rTerm],'Y','P','') )" ).append("\n"); 
		query.append("                                         ) = 'X' " ).append("\n"); 
		query.append("                                         AND NVL(O.PCTL_IO_BND_CD,'I')  IN ('O','B')" ).append("\n"); 
		query.append("                                         AND DECODE(@[rTerm],'S','Y','X') =" ).append("\n"); 
		query.append("                                                                NVL((SELECT DECODE(@[rTerm],'S',YD_FCTY_TP_CFS_FLG,'X') " ).append("\n"); 
		query.append("                                                                     FROM MDM_YARD " ).append("\n"); 
		query.append("                                                                     WHERE YD_CD=O.ROUT_ORG_NOD_CD),'X')" ).append("\n"); 
		query.append("                                         AND O.ROUT_ORG_NOD_CD  LIKE DECODE(@[rTerm],'F','','T',''," ).append("\n"); 
		query.append("                                                                              DECODE(@[por_n],''," ).append("\n"); 
		query.append("                                                                                   DECODE(@[rTerm],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por]),@[por]||'%')" ).append("\n"); 
		query.append("                                                                              ,@[por_n])" ).append("\n"); 
		query.append("                                                                       )" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                         THEN 'Y'" ).append("\n"); 
		query.append("                                  ELSE 'X'" ).append("\n"); 
		query.append("                             END) ORG_CHECK," ).append("\n"); 
		query.append("                             (CASE WHEN I.ROUT_DEST_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                    AND @[pod] = @[del] AND @[dTerm] = 'S' AND POD_NODE_S ='Y' THEN 'Y'" ).append("\n"); 
		query.append("                                   WHEN I.ROUT_DEST_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                    AND @[pod] = @[del] AND @[dTerm] <> 'D' THEN 'Y'" ).append("\n"); 
		query.append("                                   WHEN I.ROUT_DEST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                    AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                         WHERE N.NOD_CD = I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                           AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[dTerm],'D','D','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[dTerm],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[dTerm],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[dTerm],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[dTerm],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                                                       DECODE(@[dTerm],'Y','P','') )" ).append("\n"); 
		query.append("                                         ) = 'X' " ).append("\n"); 
		query.append("                                         AND NVL(I.PCTL_IO_BND_CD,'I') IN ('I','B')" ).append("\n"); 
		query.append("                                         AND DECODE(@[dTerm],'S','Y','X') =" ).append("\n"); 
		query.append("                                                                NVL((SELECT DECODE(@[dTerm],'S',YD_FCTY_TP_CFS_FLG,'X') " ).append("\n"); 
		query.append("                                                                     FROM MDM_YARD " ).append("\n"); 
		query.append("                                                                     WHERE YD_CD=I.ROUT_DEST_NOD_CD),'X')" ).append("\n"); 
		query.append("                                         AND I.ROUT_DEST_NOD_CD  LIKE DECODE(@[dTerm],'F','','T',''," ).append("\n"); 
		query.append("                                                                              DECODE(@[del_n],''," ).append("\n"); 
		query.append("                                                                                   DECODE(@[dTerm],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del]),@[del]||'%')" ).append("\n"); 
		query.append("                                                                              ,@[del_n])" ).append("\n"); 
		query.append("                                                                       )" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                         THEN 'Y'" ).append("\n"); 
		query.append("                                  ELSE 'X'" ).append("\n"); 
		query.append("                             END) DEST_CHECK      " ).append("\n"); 
		query.append("                                FROM ( " ).append("\n"); 
		query.append("                                SELECT ROWNUM," ).append("\n"); 
		query.append("                                ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT," ).append("\n"); 
		query.append("                                N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                                POL1,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                                POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                                POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                                POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                                POD_NODE,POL1_S,POD_NODE_S," ).append("\n"); 
		query.append("                                (CASE WHEN POD_NODE IS NULL THEN 'X'" ).append("\n"); 
		query.append("                                      WHEN LNK_KNT = 4 AND ( POL4 IS NULL OR POD4 IS NULL OR POLT4 IS NULL OR PODT4 IS NULL " ).append("\n"); 
		query.append("                                                            OR ( N4TH_SVC_TP <> 'O' AND ( VVD4 IS NULL OR CRR4 IS NULL OR POL_SEQ4 IS NULL OR  POD_SEQ4 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                           THEN 'X'" ).append("\n"); 
		query.append("                                      WHEN LNK_KNT = 3 AND ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL " ).append("\n"); 
		query.append("                                                            OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                           THEN 'X'" ).append("\n"); 
		query.append("                                      WHEN LNK_KNT = 2 AND ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL  " ).append("\n"); 
		query.append("                                                            OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                            OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL ) " ).append("\n"); 
		query.append("                                                            OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                           THEN 'X'" ).append("\n"); 
		query.append("                                      WHEN LNK_KNT = 1 AND ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL  " ).append("\n"); 
		query.append("                                                            OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                           THEN 'X'" ).append("\n"); 
		query.append("                                    ELSE 'Y'" ).append("\n"); 
		query.append("                                END ) CHECK_ROUT" ).append("\n"); 
		query.append("                                FROM (" ).append("\n"); 
		query.append("                                    SELECT /*+ NO_MERGE(B)  */ " ).append("\n"); 
		query.append("                                    ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT," ).append("\n"); 
		query.append("                                    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                    N1ST_SVC_TP,N2ND_SVC_TP, N3RD_SVC_TP,N4TH_SVC_TP," ).append("\n"); 
		query.append("                                    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("                                    (SELECT YD_FCTY_TP_CFS_FLG " ).append("\n"); 
		query.append("                                     FROM MDM_YARD " ).append("\n"); 
		query.append("                                     WHERE YD_CD=TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL1')+4,7)))) POL1_S,  " ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'CCC'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CCC')+3,14))) CCT,                               " ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL1')+4,7))) POL1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))) POD1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POLT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT1')+5,14))) POLT1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'PODT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT1')+5,14))) PODT1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'VVD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD1')+4,9))) VVD1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'CRR1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR1')+4,4))) CRR1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ1')+8,2))) POL_SEQ1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ1')+8,2))) POD_SEQ1," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL2')+4,7))) POL2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7))) POD2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POLT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT2')+5,14))) POLT2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'PODT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT2')+5,14))) PODT2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'VVD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD2')+4,9))) VVD2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'CRR2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR2')+4,4))) CRR2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ2')+8,2))) POL_SEQ2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ2')+8,2))) POD_SEQ2," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL3')+4,7))) POL3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7))) POD3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POLT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT3')+5,14))) POLT3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'PODT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT3')+5,14))) PODT3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'VVD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD3')+4,9))) VVD3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'CRR3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR3')+4,4))) CRR3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ3')+8,2))) POL_SEQ3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ3')+8,2))) POD_SEQ3," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL4')+4,7))) POL4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7))) POD4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POLT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT4')+5,14))) POLT4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'PODT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT4')+5,14))) PODT4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'VVD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD4')+4,9))) VVD4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'CRR4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR4')+4,4))) CRR4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ4')+8,2))) POL_SEQ4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ4')+8,2))) POD_SEQ4," ).append("\n"); 
		query.append("                                    TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7)))," ).append("\n"); 
		query.append("                                                   3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7)))," ).append("\n"); 
		query.append("                                                   2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7)))," ).append("\n"); 
		query.append("                                                   TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))))) POD_NODE," ).append("\n"); 
		query.append("                                    (SELECT YD_FCTY_TP_CFS_FLG " ).append("\n"); 
		query.append("                                     FROM MDM_YARD " ).append("\n"); 
		query.append("                                     WHERE YD_CD=TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7)))," ).append("\n"); 
		query.append("                                                   3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7)))," ).append("\n"); 
		query.append("                                                   2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7)))," ).append("\n"); 
		query.append("                                                   TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7)))))) POD_NODE_S," ).append("\n"); 
		query.append("                                    SKD_STR " ).append("\n"); 
		query.append("                                    FROM (" ).append("\n"); 
		query.append("--=============================================================================================================================================                                     " ).append("\n"); 
		query.append("-- 그냥 Internal 과 차이가 있는 부분" ).append("\n"); 
		query.append("                                        SELECT @[pol] ORG_LOC_CD, @[pod] DEST_LOC_CD, 0 ROUT_SEQ," ).append("\n"); 
		query.append("                                        (CASE WHEN @[pol4] IS NOT NULL THEN 4" ).append("\n"); 
		query.append("                                              WHEN @[pol3] IS NOT NULL THEN 3" ).append("\n"); 
		query.append("                                              WHEN @[pol2] IS NOT NULL THEN 2" ).append("\n"); 
		query.append("                                              ELSE 1" ).append("\n"); 
		query.append("                                        END) " ).append("\n"); 
		query.append("                                        LNK_KNT," ).append("\n"); 
		query.append("                                        @[lane1] N1ST_LANE_CD,@[lane2] N2ND_LANE_CD,@[lane3] N3RD_LANE_CD,@[lane4] N4TH_LANE_CD," ).append("\n"); 
		query.append("                                        @[pol2] N2ND_POL_CD,@[pol3] N3RD_POL_CD,@[pol4] N4TH_POL_CD," ).append("\n"); 
		query.append("                                        (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                        WHERE VSL_SLAN_CD = @[lane1] ) N1ST_SVC_TP," ).append("\n"); 
		query.append("                                        (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                        WHERE VSL_SLAN_CD = @[lane2]) N2ND_SVC_TP," ).append("\n"); 
		query.append("                                        (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                        WHERE VSL_SLAN_CD = @[lane3]) N3RD_SVC_TP," ).append("\n"); 
		query.append("                                        (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                        WHERE VSL_SLAN_CD = @[lane4]) N4TH_SVC_TP,  " ).append("\n"); 
		query.append("                                        (CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                   WHERE VSL_SLAN_CD = @[lane1] ) ='O'" ).append("\n"); 
		query.append("                                                 THEN (SELECT TZTM_HRS FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                       WHERE LNK_ORG_LOC_CD = @[pol1]" ).append("\n"); 
		query.append("                                                         AND LNK_DEST_LOC_CD = @[pod1]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane1])" ).append("\n"); 
		query.append("                                             ELSE (SELECT TZTM_HRS FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                       WHERE FM_PORT_CD = @[pol1]" ).append("\n"); 
		query.append("                                                         AND TO_PORT_CD = @[pod1]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane1]" ).append("\n"); 
		query.append("														 AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                        END)" ).append("\n"); 
		query.append("                                        N1ST_TZTM_HRS ," ).append("\n"); 
		query.append("                                        (CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                   WHERE VSL_SLAN_CD = @[lane2] ) ='O'" ).append("\n"); 
		query.append("                                                 THEN (SELECT TZTM_HRS FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                       WHERE LNK_ORG_LOC_CD = @[pol2]" ).append("\n"); 
		query.append("                                                         AND LNK_DEST_LOC_CD = @[pod2]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane2])" ).append("\n"); 
		query.append("                                             ELSE (SELECT TZTM_HRS FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                       WHERE FM_PORT_CD = @[pol2]" ).append("\n"); 
		query.append("                                                         AND TO_PORT_CD = @[pod2]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane2]" ).append("\n"); 
		query.append("														 AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                        END)" ).append("\n"); 
		query.append("                                        N2ND_TZTM_HRS ," ).append("\n"); 
		query.append("                                        (CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                   WHERE VSL_SLAN_CD = @[lane3] ) ='O'" ).append("\n"); 
		query.append("                                                 THEN (SELECT TZTM_HRS FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                       WHERE LNK_ORG_LOC_CD = @[pol3]" ).append("\n"); 
		query.append("                                                         AND LNK_DEST_LOC_CD = @[pod3]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane3])" ).append("\n"); 
		query.append("                                             ELSE (SELECT TZTM_HRS FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                       WHERE FM_PORT_CD = @[pol3]" ).append("\n"); 
		query.append("                                                         AND TO_PORT_CD = @[pod3]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane3]" ).append("\n"); 
		query.append("														 AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                        END)" ).append("\n"); 
		query.append("                                        N3RD_TZTM_HRS ," ).append("\n"); 
		query.append("                                        (CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                   WHERE VSL_SLAN_CD = @[lane4] ) ='O'" ).append("\n"); 
		query.append("                                                 THEN (SELECT TZTM_HRS FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                       WHERE LNK_ORG_LOC_CD = @[pol4]" ).append("\n"); 
		query.append("                                                         AND LNK_DEST_LOC_CD = @[pod4]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane4])" ).append("\n"); 
		query.append("                                             ELSE (SELECT TZTM_HRS FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                       WHERE FM_PORT_CD = @[pol4]" ).append("\n"); 
		query.append("                                                         AND TO_PORT_CD = @[pod4]" ).append("\n"); 
		query.append("                                                         AND VSL_SLAN_CD = @[lane4]" ).append("\n"); 
		query.append("														 AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                        END)" ).append("\n"); 
		query.append("                                        N4TH_TZTM_HRS," ).append("\n"); 
		query.append("                                        PRD_GET_OCN_SKD_FNC(@[s_date],@[s_type],@[pol],@[pod]," ).append("\n"); 
		query.append("                                            @[pol1],'',@[pod1],'',@[lane1],(CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                             WHERE VSL_SLAN_CD = @[lane1] ) ='O'" ).append("\n"); 
		query.append("                                                                           THEN (SELECT SKD_DIR_CD FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                                                 WHERE LNK_ORG_LOC_CD = @[pol1]" ).append("\n"); 
		query.append("                                                                                   AND LNK_DEST_LOC_CD = @[pod1]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane1])" ).append("\n"); 
		query.append("                                                                       ELSE (SELECT SKD_DIR_CD FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                                                 WHERE FM_PORT_CD = @[pol1]" ).append("\n"); 
		query.append("                                                                                   AND TO_PORT_CD = @[pod1]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane1]" ).append("\n"); 
		query.append("																				   AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("																				  " ).append("\n"); 
		query.append("                                                                  END)," ).append("\n"); 
		query.append("                                                                  (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                  WHERE VSL_SLAN_CD = @[lane1] )," ).append("\n"); 
		query.append("                                                                  @[vvd1]," ).append("\n"); 
		query.append("                                            @[pol2],'',@[pod2],'',@[lane2],(CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                             WHERE VSL_SLAN_CD = @[lane2] ) ='O'" ).append("\n"); 
		query.append("                                                                           THEN (SELECT SKD_DIR_CD FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                                                 WHERE LNK_ORG_LOC_CD = @[pol2]" ).append("\n"); 
		query.append("                                                                                   AND LNK_DEST_LOC_CD = @[pod2]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane2])" ).append("\n"); 
		query.append("                                                                       ELSE (SELECT SKD_DIR_CD FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                                                 WHERE FM_PORT_CD = @[pol2]" ).append("\n"); 
		query.append("                                                                                   AND TO_PORT_CD = @[pod2]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane2]" ).append("\n"); 
		query.append("                                                                                   AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("																				   " ).append("\n"); 
		query.append("                                                                  END)," ).append("\n"); 
		query.append("                                                                  (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                  WHERE VSL_SLAN_CD = @[lane2] )," ).append("\n"); 
		query.append("                                                                  @[vvd2]," ).append("\n"); 
		query.append("                                            @[pol3],'',@[pod3],'',@[lane3],(CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                             WHERE VSL_SLAN_CD = @[lane3] ) ='O'" ).append("\n"); 
		query.append("                                                                           THEN (SELECT SKD_DIR_CD FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                                                 WHERE LNK_ORG_LOC_CD = @[pol3]" ).append("\n"); 
		query.append("                                                                                   AND LNK_DEST_LOC_CD = @[pod3]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane3])" ).append("\n"); 
		query.append("                                                                       ELSE (SELECT SKD_DIR_CD FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                                                 WHERE FM_PORT_CD = @[pol3]" ).append("\n"); 
		query.append("                                                                                   AND TO_PORT_CD = @[pod3]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane3]" ).append("\n"); 
		query.append("																				   AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                                                  END)," ).append("\n"); 
		query.append("                                                                  (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                  WHERE VSL_SLAN_CD = @[lane3] )," ).append("\n"); 
		query.append("                                                                  @[vvd3]," ).append("\n"); 
		query.append("                                            @[pol4],'',@[pod4],'',@[lane4],(CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                             WHERE VSL_SLAN_CD = @[lane4] ) ='O'" ).append("\n"); 
		query.append("                                                                           THEN (SELECT SKD_DIR_CD FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("                                                                                 WHERE LNK_ORG_LOC_CD = @[pol4]" ).append("\n"); 
		query.append("                                                                                   AND LNK_DEST_LOC_CD = @[pod4]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane4])" ).append("\n"); 
		query.append("                                                                       ELSE (SELECT SKD_DIR_CD FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                                                                                 WHERE FM_PORT_CD = @[pol4]" ).append("\n"); 
		query.append("                                                                                   AND TO_PORT_CD = @[pod4]" ).append("\n"); 
		query.append("                                                                                   AND VSL_SLAN_CD = @[lane4]" ).append("\n"); 
		query.append("																				   AND DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                                                                  END)," ).append("\n"); 
		query.append("                                                                  (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                  WHERE VSL_SLAN_CD = @[lane4] )," ).append("\n"); 
		query.append("                                                                  @[vvd4],      " ).append("\n"); 
		query.append("                                        NVL(@[cgo_tp],'AL'),'N') SKD_STR" ).append("\n"); 
		query.append("                                        FROM DUAL    " ).append("\n"); 
		query.append("                                        WHERE NOT EXISTS" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                           SELECT 'X' FROM PRD_MBGO_MGMT TT" ).append("\n"); 
		query.append("                                           WHERE SUBSTR (@[pol], 1, 2) = TT.FM_CNT_CD" ).append("\n"); 
		query.append("                                           AND DECODE(@[pol2],NULL,'D','T') = 'D'" ).append("\n"); 
		query.append("                                           AND SUBSTR (@[pod], 1, 2) = TT.TO_CNT_CD" ).append("\n"); 
		query.append("                                        )  " ).append("\n"); 
		query.append("--=============================================================================================================================================                                                                    " ).append("\n"); 
		query.append("                                    ) B " ).append("\n"); 
		query.append("                                ) C" ).append("\n"); 
		query.append("                            ) T , PRD_INLND_ROUT_MST O, PRD_INLND_ROUT_MST I" ).append("\n"); 
		query.append("                            WHERE T.CHECK_ROUT = 'Y' " ).append("\n"); 
		query.append("                            AND O.INLND_ROUT_BKG_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                            AND O.ROUT_DEST_NOD_CD(+)= T.POL1" ).append("\n"); 
		query.append("                            AND @[por] = SUBSTR(O.ROUT_ORG_NOD_CD(+),1,5)" ).append("\n"); 
		query.append("                            AND DECODE(@[rTerm],'D','X','S','X',DECODE(@[por_n],NULL,DECODE(NVL(@[so_seq],0),0,@[por],'X'),SUBSTR(@[por_n],1,5))) <> SUBSTR(O.ROUT_DEST_NOD_CD(+),1,5)" ).append("\n"); 
		query.append("                            AND DECODE(@[rTerm],'S',DECODE(T.POL1_S,'Y','Y',O.ROUT_ORG_NOD_CD(+)) ,'X') =  DECODE(@[rTerm],'S',O.ROUT_ORG_NOD_CD(+),'X')" ).append("\n"); 
		query.append("                            AND NVL(O.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND I.INLND_ROUT_BKG_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                            AND I.ROUT_ORG_NOD_CD(+)= T.POD_NODE" ).append("\n"); 
		query.append("                            AND DECODE(@[dTerm],'D','X','S','X',DECODE(@[pod_n],NULL,DECODE(NVL(@[so_seq],0),0,nvl(nvl(@[pod],SUBSTR(T.POD_NODE,1,5)),'X'),'X'),SUBSTR(@[pod_n],1,5))) <> SUBSTR(I.ROUT_DEST_NOD_CD(+),1,5)" ).append("\n"); 
		query.append("                            AND DECODE(@[dTerm],'S',DECODE(T.POD_NODE_S,'Y','Y',I.ROUT_DEST_NOD_CD(+)) ,'X') =  DECODE(@[dTerm],'S',I.ROUT_DEST_NOD_CD(+),'X')" ).append("\n"); 
		query.append("                            AND NVL(I.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND I.ROUT_DEST_NOD_CD(+) LIKE @[del]||'%' " ).append("\n"); 
		query.append("                        ) ROUT, PRD_INLND_ROUT_DTL OD,PRD_INLND_ROUT_DTL ID" ).append("\n"); 
		query.append("                        WHERE ROUT.ORG_CHECK = 'Y'" ).append("\n"); 
		query.append("                        AND ROUT.DEST_CHECK ='Y'" ).append("\n"); 
		query.append("                        AND ROUT.OB_ORG =OD.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("                        AND ROUT.OB_DEST =OD.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("                        AND ROUT.OB_SEQ =OD.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                        AND ROUT.IB_ORG =ID.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("                        AND ROUT.IB_DEST =ID.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("                        AND ROUT.IB_SEQ =ID.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                WHERE IB_RK =1 AND OB_RK= 1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                GROUP BY OB_ORG,OB_ORG,OB_DEST,OB_PRIO_SEQ,OB_SEQ,OB_CNT," ).append("\n"); 
		query.append("                ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,LNK_KNT," ).append("\n"); 
		query.append("                N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                POL1,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                POD_NODE,CHECK_ROUT," ).append("\n"); 
		query.append("                IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ,IB_CNT " ).append("\n"); 
		query.append("                )," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=33" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE TRIM(NODE1) IS NOT NULL" ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CPY_NO L_N0 FROM COM_CPY_NO WHERE CPY_NO IN (1,2)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE (F_NO2 <> 33 OR L_N0 <> 2 )" ).append("\n"); 
		query.append("    AND NODE_NEW2 IS NOT NULL" ).append("\n"); 
		query.append("    ORDER BY 1,2,3" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY GP1, ORD" ).append("\n"); 

	}
}