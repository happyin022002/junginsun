/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForBkgReceiptNtc
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sales_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_status",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcRSQL").append("\n"); 
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
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("	SELECT BK.FULL_RTN_YD_CD, BK.BKG_NO, SKD.SLAN_CD SLAN_CD, VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("				   			  , CASE WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("									 WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("				   					 WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("				   					 ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("				   			  , VPS_ETB_DT" ).append("\n"); 
		query.append("				   			  , VPS_ETD_DT" ).append("\n"); 
		query.append("				   			  , pol_nod_cd" ).append("\n"); 
		query.append("							  , NVL(VVD.POL_CLPT_IND_SEQ, 1) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("				   			  , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("						   FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("				   		  WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("				   			AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("				   			AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("							AND VVD.VSL_CD	   NOT IN ('COXX','COYY','COZZ')" ).append("\n"); 
		query.append("				   			AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("				   			AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("				   			AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("				   			AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("				   			AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				   			AND 'X' != BK.BKG_STS_CD " ).append("\n"); 
		query.append("				   			AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("							#if (''!=${bkg_no}) AND @[bkg_no] = BK.BKG_NO #end" ).append("\n"); 
		query.append("							#if (''!=${bkg_from_dt}) AND BK.BKG_CRE_DT > TO_DATE(@[bkg_from_dt],'yyyy-mm-dd') #end" ).append("\n"); 
		query.append("							#if (''!=${bkg_to_dt}) AND BK.BKG_CRE_DT < TO_DATE(@[bkg_to_dt],'yyyy-mm-dd') + 1 #end" ).append("\n"); 
		query.append("							#if (''!=${bkg_ofc_cd}) AND @[bkg_ofc_cd] = BK.BKG_OFC_CD #end" ).append("\n"); 
		query.append("							#if (''!=${bkg_staff}) AND @[bkg_staff] = BK.DOC_USR_ID #end" ).append("\n"); 
		query.append("							#if ('All'!=${bkg_status} && ''!=${bkg_status}) AND @[bkg_status] = BK.BKG_STS_CD #end" ).append("\n"); 
		query.append("							#if ('All'!=${bkg_kind} && ''!=${bkg_kind}) AND @[bkg_kind] = BK.XTER_BKG_RQST_CD #end" ).append("\n"); 
		query.append("							#if (''!=${vvd}) AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("											 AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("											 AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (''!=${por_cd}) AND @[por_cd] = BK.POR_CD #end" ).append("\n"); 
		query.append("							#if (''!=${pol_cd}) AND BK.POL_CD like @[pol_cd]||'%'" ).append("\n"); 
		query.append("								#if (''!=${pol_yd_cd}) AND BK.POL_NOD_CD = @[pol_cd]||@[pol_yd_cd] #end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (''!=${pod_cd}) AND BK.POD_CD like @[pod_cd]||'%'" ).append("\n"); 
		query.append("								#if (''!=${pod_yd_cd}) AND BK.POD_NOD_CD = @[pod_cd]||@[pod_yd_cd] #end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (''!=${del_cd}) AND @[del_cd] = BK.DEL_CD #end" ).append("\n"); 
		query.append("							#if (''!=${sales_ofc}) AND @[sales_ofc] = BK.OB_SLS_OFC_CD #end" ).append("\n"); 
		query.append("							#if (''!=${sales_rep}) AND @[sales_rep] = BK.OB_SREP_CD #end" ).append("\n"); 
		query.append("							#if (''!=${full_rtn_yd_cd}) AND @[full_rtn_yd_cd] = BK.FULL_RTN_YD_CD #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	   BKG.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("       BKG.BKG_NO," ).append("\n"); 
		query.append("	   BKG.EDI_HLD_FLG," ).append("\n"); 
		query.append("       BKG.BKG_STS_CD AS STATUS," ).append("\n"); 
		query.append("       BKG.XTER_BKG_RQST_CD AS KIND," ).append("\n"); 
		query.append("       CST.CUST_CNT_CD||LPAD(CST.CUST_SEQ,6,0) AS SHIPPER_CODE," ).append("\n"); 
		query.append("       REPLACE(CST.CUST_NM, CHR(10), ' ') AS SHIPPER_NAME," ).append("\n"); 
		query.append("       NVL2(FFC.CUST_CNT_CD,FFC.CUST_CNT_CD||LPAD(FFC.CUST_SEQ,6,0),NULL) AS FF_CD," ).append("\n"); 
		query.append("       NVL(FAX.NTC_FAX_NO,CTT.CNTC_PSON_FAX_NO) AS FAX," ).append("\n"); 
		query.append("       NVL(EML.NTC_EML,CTT.CNTC_PSON_EML) AS EML," ).append("\n"); 
		query.append("       to_char((select sys_set_dt from bkg_clz_tm clz where clz.bkg_no = bkg.bkg_no AND CLZ_TP_CD = 'R'), 'yyyy-mm-dd hh24:mi') AS CARGO_CCT," ).append("\n"); 
		query.append("       (CASE WHEN (SELECT /*+index_asc(scd XPKSCE_COP_DTL) */ decode(BKG.POL_CD,SUBSTR(SCD.NOD_CD,1,5),'Y','N')" ).append("\n"); 
		query.append("                            FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                                 ,SCE_COP_DTL SCD" ).append("\n"); 
		query.append("                            WHERE SCH.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                            AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("                            AND SCD.ACT_CD LIKE 'F%AD'" ).append("\n"); 
		query.append("                            AND rownum = 1) = 'N' THEN" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("              to_char((SELECT NVL(PRD_GET_INLND_CCT_FNC(BK.PCTL_NO)" ).append("\n"); 
		query.append("              ,(SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                                                   DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                                            FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_INLND_ROUT_MST O" ).append("\n"); 
		query.append("                                                            WHERE DTL.PCTL_NO = BK.PCTL_NO" ).append("\n"); 
		query.append("                                                            AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                            AND DTL.ROUT_ORG_NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                                            AND DTL.ROUT_DEST_NOD_CD = O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                                            AND DTL.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("                                                            AND DTL.ORG_NOD_CD = O.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                                                            AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                                                            AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                            UNION ALL" ).append("\n"); 
		query.append("                                                            SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                                                 DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                                            FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                                            WHERE DTL.PCTL_NO = BK.PCTL_NO" ).append("\n"); 
		query.append("                                                            AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                            AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("                                                            AND ROWNUM = 1)" ).append("\n"); 
		query.append("                          )  FROM BKG_BOOKING BK WHERE BK.BKG_NO = BKG.BKG_NO) , 'yyyy-mm-dd hh24:mi') " ).append("\n"); 
		query.append("           ELSE (select to_char(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_FNC(BKG.BKG_NO), 'yyyy-mm-dd hh24:mi') " ).append("\n"); 
		query.append("        				            from SKD" ).append("\n"); 
		query.append("        				            WHERE SKD.BKG_NO =BKG.BKG_NO )                         " ).append("\n"); 
		query.append("            END)  AS CARGO_CCT_CNG," ).append("\n"); 
		query.append("       to_char((select mnl_set_dt from bkg_clz_tm clz where clz.bkg_no = bkg.bkg_no AND CLZ_TP_CD = 'R'), 'yyyy-mm-dd hh24:mi') AS CARGO_CCT_MNL," ).append("\n"); 
		query.append("       to_char((select sys_set_dt from bkg_clz_tm clz where clz.bkg_no = bkg.bkg_no AND CLZ_TP_CD = 'T'), 'yyyy-mm-dd hh24:mi') AS CCT," ).append("\n"); 
		query.append("	   to_char(((select PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_FNC(BKG.BKG_NO)" ).append("\n"); 
		query.append("				   from SKD" ).append("\n"); 
		query.append("				  WHERE SKD.BKG_NO =BKG.BKG_NO)),'yyyy-mm-dd hh24:mi') AS CCT_CNG," ).append("\n"); 
		query.append("       to_char((select mnl_set_dt from bkg_clz_tm clz where clz.bkg_no = bkg.bkg_no AND CLZ_TP_CD = 'T'), 'yyyy-mm-dd hh24:mi') AS CCT_MNL," ).append("\n"); 
		query.append("	   to_char((select nvl(mnl_set_dt, sys_set_dt) from bkg_clz_tm clz where clz.bkg_no = bkg.bkg_no AND CLZ_TP_CD = 'D'), 'yyyy-mm-dd hh24:mi') AS DOC_CCT," ).append("\n"); 
		query.append("       BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS TVVD," ).append("\n"); 
		query.append("       BKG.POR_CD AS POR," ).append("\n"); 
		query.append("       BKG.EQ_CTRL_OFC_CD AS EQ_OFC," ).append("\n"); 
		query.append("       BKG.POL_CD AS POL," ).append("\n"); 
		query.append("       BKG.POD_CD AS POD," ).append("\n"); 
		query.append("       BKG.DEL_CD AS DEL," ).append("\n"); 
		query.append("       BKG.DOC_USR_ID AS BKG_STAFF," ).append("\n"); 
		query.append("       CTT.CNTC_PSON_NM AS CONTACT_PIC," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) ) AS FAX_RESULT," ).append("\n"); 
		query.append("       NVL (FSI.XPT_ERR_MSG, FSI.XPT_ERR_DTL_MSG) AS FAX_ERR," ).append("\n"); 
		query.append("       --TO_CHAR(NVL (FSI.XPT_DT,NVL(FSI.UPD_DT,FAX.SND_RQST_DT)),'yyyy-mm-dd hh24:mi') AS FAX_DATE," ).append("\n"); 
		query.append("       TO_CHAR(NVL (FAX.SND_RQST_DT,NVL(FSI.XPT_DT,FSI.UPD_DT)),'yyyy-mm-dd hh24:mi') AS FAX_DATE," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS EML_RESULT," ).append("\n"); 
		query.append("       ESI.EML_ERR_MSG AS EML_ERR," ).append("\n"); 
		query.append("       --TO_CHAR(NVL (ESI.EML_DT,EML.SND_RQST_DT),'yyyy-mm-dd hh24:mi') AS EML_DATE," ).append("\n"); 
		query.append("       TO_CHAR(NVL (EML.SND_RQST_DT,ESI.EML_DT),'yyyy-mm-dd hh24:mi') AS EML_DATE," ).append("\n"); 
		query.append("       NVL((SELECT /*+ INDEX(A2 XPKBKG_CUSTOMER) */" ).append("\n"); 
		query.append("				   A3.RCT_NTC_RMK" ).append("\n"); 
		query.append("            FROM   BKG_BOOKING A1," ).append("\n"); 
		query.append("                   BKG_CUSTOMER A2," ).append("\n"); 
		query.append("                   BKG_RPT_ITM_STUP A3" ).append("\n"); 
		query.append("            WHERE  A1.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND    A1.BKG_OFC_CD = A3.BKG_OFC_CD" ).append("\n"); 
		query.append("            AND    A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("            AND    A2.BKG_CUST_TP_CD IN ('S', 'F')" ).append("\n"); 
		query.append("            AND    A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND    A2.CUST_SEQ = A3.CUST_SEQ" ).append("\n"); 
		query.append("			AND    rownum = 1)," ).append("\n"); 
		query.append("           (SELECT A2.RCT_NTC_RMK" ).append("\n"); 
		query.append("            FROM   BKG_BOOKING A1," ).append("\n"); 
		query.append("                   BKG_RPT_ITM_STUP A2" ).append("\n"); 
		query.append("            WHERE  A1.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND    A1.BKG_OFC_CD = A2.BKG_OFC_CD" ).append("\n"); 
		query.append("            AND    A2.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            AND    A2.CUST_SEQ IS NULL)) REMARK" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_CUSTOMER CST," ).append("\n"); 
		query.append("       BKG_CUSTOMER FFC," ).append("\n"); 
		query.append("       BKG_CNTC_PSON CTT," ).append("\n"); 
		query.append("       BKG_BL_ISS ISS," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC," ).append("\n"); 
		query.append("       BKG_CUSTOMER CST2," ).append("\n"); 
		query.append("       BKG_NTC_HIS FAX," ).append("\n"); 
		query.append("       BKG_NTC_HIS EML," ).append("\n"); 
		query.append("       COM_FAX_SND_INFO FSI," ).append("\n"); 
		query.append("       COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = CST.BKG_NO" ).append("\n"); 
		query.append("   AND 'S' = CST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = FFC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'F' = FFC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CTT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'BK' = CTT.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'X' != BKG.BKG_STS_CD " ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("   AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND 'BK' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("   AND NVL(FAX.HIS_SEQ,1) = " ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("        AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'BK' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND 'BK' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("        AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'BK' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("   AND EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("   #if (''!=${bkg_no})" ).append("\n"); 
		query.append("   AND @[bkg_no] = BKG.BKG_NO" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${multiBkgNo} != '')" ).append("\n"); 
		query.append("   AND BKG.BKG_NO IN (" ).append("\n"); 
		query.append("   	#foreach($multiBkgNoVal IN ${multiBkgNo})" ).append("\n"); 
		query.append("    	#if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bkg_from_dt})" ).append("\n"); 
		query.append("   AND BKG.BKG_CRE_DT > TO_DATE(@[bkg_from_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bkg_to_dt})" ).append("\n"); 
		query.append("   AND BKG.BKG_CRE_DT < TO_DATE(@[bkg_to_dt],'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bkg_ofc_cd})" ).append("\n"); 
		query.append("   AND @[bkg_ofc_cd] = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bkg_staff})" ).append("\n"); 
		query.append("   AND @[bkg_staff] = BKG.DOC_USR_ID" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${bkg_status} && ''!=${bkg_status})" ).append("\n"); 
		query.append("   AND @[bkg_status] = BKG.BKG_STS_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${bkg_kind} && ''!=${bkg_kind})" ).append("\n"); 
		query.append("   AND @[bkg_kind] = BKG.XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${vvd})" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${por_cd})" ).append("\n"); 
		query.append("   AND @[por_cd] = BKG.POR_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${pol_cd})" ).append("\n"); 
		query.append("   AND BKG.POL_CD like @[pol_cd]||'%'" ).append("\n"); 
		query.append("		   #if (''!=${pol_yd_cd})" ).append("\n"); 
		query.append("		   AND BKG.POL_NOD_CD = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${pod_cd})" ).append("\n"); 
		query.append("   AND BKG.POD_CD like @[pod_cd]||'%'" ).append("\n"); 
		query.append("	     #if (''!=${pod_yd_cd})" ).append("\n"); 
		query.append("	     AND BKG.POD_NOD_CD = @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${del_cd})" ).append("\n"); 
		query.append("   AND @[del_cd] = BKG.DEL_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${sales_ofc})" ).append("\n"); 
		query.append("   AND @[sales_ofc] = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${sales_rep})" ).append("\n"); 
		query.append("   AND @[sales_rep] = BKG.OB_SREP_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${cust_tp_cd} && ''!=${cust_tp_cd})" ).append("\n"); 
		query.append("   AND @[cust_tp_cd] = CST2.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("   AND CST2.CUST_CNT_CD = SUBSTR(@[cust_cnt_cd], 1, 2)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_seq})" ).append("\n"); 
		query.append("   AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_nm})" ).append("\n"); 
		query.append("   AND CST2.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${fax_proc_sts_cd})" ).append("\n"); 
		query.append("   AND NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("       DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("       NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("       DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) = @[fax_proc_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${eml_proc_sts_cd})" ).append("\n"); 
		query.append("   AND NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("       DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("       NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("       DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) = @[eml_proc_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${full_rtn_yd_cd})" ).append("\n"); 
		query.append("   AND BKG.FULL_RTN_YD_CD = @[full_rtn_yd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('Y'!=${edi_hld_flg})" ).append("\n"); 
		query.append("   AND BKG.EDI_HLD_FLG = 'N'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}