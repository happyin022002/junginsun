/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchPCFStatusInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchPCFStatusInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search PCF Status Info
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchPCFStatusInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_atd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_atd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchPCFStatusInfoRSQL").append("\n"); 
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
		query.append("#if (${re_divr_cd} == 'R')	" ).append("\n"); 
		query.append("    SELECT CHN_AGN_CD" ).append("\n"); 
		query.append("         , VVD_CD" ).append("\n"); 
		query.append("         , CNT1 , AMT1" ).append("\n"); 
		query.append("         , CNT2 , AMT2" ).append("\n"); 
		query.append("         , CNT3 , AMT3" ).append("\n"); 
		query.append("         , CNT4 , AMT4" ).append("\n"); 
		query.append("         , CNT5 , AMT5" ).append("\n"); 
		query.append("         , CNT6 , AMT6" ).append("\n"); 
		query.append("         , CNT7 , AMT7" ).append("\n"); 
		query.append("         , CNT8 , AMT8" ).append("\n"); 
		query.append("         , CNT1 + CNT2 + CNT3 + CNT4 + CNT5 + CNT6 + CNT7 + CNT8 AS TOT_CNT" ).append("\n"); 
		query.append("         , AMT1 + AMT2 + AMT3 + AMT4 + AMT5 + AMT6 + AMT7 + AMT8 AS TOT_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT A.CHN_AGN_CD" ).append("\n"); 
		query.append("                 , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D2'   , 1, 0)) AS CNT1" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T2'   , 1, 0)) AS CNT2" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW2'  , 1, 0)) AS CNT3" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D4/5' , 1, 0)) AS CNT4" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T4/5' , 1, 0)) AS CNT5" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW45' , 1, 0)) AS CNT6" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D7'   , 1, 0)) AS CNT7" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'DG7'  , 1, 0)) AS CNT8" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D2'   , F.PCF_UT_AMT1, 0)) AS AMT1" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T2'   , F.PCF_UT_AMT2, 0)) AS AMT2" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW2'  , F.PCF_UT_AMT3, 0)) AS AMT3" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D4/5' , F.PCF_UT_AMT4, 0)) AS AMT4" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T4/5' , F.PCF_UT_AMT5, 0)) AS AMT5" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW45' , F.PCF_UT_AMT6, 0)) AS AMT6" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D7'   , F.PCF_UT_AMT7, 0)) AS AMT7" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'DG7'  , F.PCF_UT_AMT8, 0)) AS AMT8" ).append("\n"); 
		query.append("            FROM BKG_BOOKING A" ).append("\n"); 
		query.append("               , BKG_VVD B" ).append("\n"); 
		query.append("               , BKG_CONTAINER C" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD D" ).append("\n"); 
		query.append("               , INV_PCF_CNTR_TP_SZ E" ).append("\n"); 
		query.append("               , INV_PCF_REV_EXPN_AMT F" ).append("\n"); 
		query.append("           #if (${vvd_cd} != '')	" ).append("\n"); 
		query.append("               , (SELECT TRIM(COLUMN_VALUE) AS VVD FROM TABLE(BKG_SPLIT_FNC(@[vvd_cd], ',')) WHERE COLUMN_VALUE IS NOT NULL) G  " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("            AND B.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("            AND B.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND B.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND B.POL_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND B.POL_CLPT_IND_SEQ = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("            AND B.VSL_CD = SUBSTR(G.VVD, 1, 4)" ).append("\n"); 
		query.append("            AND B.SKD_VOY_NO = SUBSTR(G.VVD, 5, 4)" ).append("\n"); 
		query.append("            AND B.SKD_DIR_CD = SUBSTR(G.VVD, 9, 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND E.BKG_CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            AND E.RD_CGO_FLG = C.RD_CGO_FLG" ).append("\n"); 
		query.append("            AND E.DCGO_FLG = C.DCGO_FLG" ).append("\n"); 
		query.append("            AND F.PORT_CD = B.POL_CD" ).append("\n"); 
		query.append("            AND A.CHN_AGN_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND B.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')    " ).append("\n"); 
		query.append("            AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chn_agn_cd} != '') " ).append("\n"); 
		query.append("            AND A.CHN_AGN_CD = @[chn_agn_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND F.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("            AND TO_CHAR(D.ACT_DEP_DT, 'YYYYMMDD') BETWEEN REPLACE(@[fm_atd_dt],'-','') AND REPLACE(@[to_atd_dt],'-','')" ).append("\n"); 
		query.append("            AND TO_CHAR(D.ACT_DEP_DT, 'YYYYMMDD') BETWEEN F.FM_EFF_DT AND F.TO_EFF_DT" ).append("\n"); 
		query.append("            GROUP BY A.CHN_AGN_CD" ).append("\n"); 
		query.append("                   , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY CHN_AGN_CD" ).append("\n"); 
		query.append("           , VVD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT TMNL_CD" ).append("\n"); 
		query.append("         , VVD_CD" ).append("\n"); 
		query.append("         , CNT1 , AMT1" ).append("\n"); 
		query.append("         , CNT2 , AMT2" ).append("\n"); 
		query.append("         , CNT3 , AMT3" ).append("\n"); 
		query.append("         , CNT4 , AMT4" ).append("\n"); 
		query.append("         , CNT5 , AMT5" ).append("\n"); 
		query.append("         , CNT6 , AMT6" ).append("\n"); 
		query.append("         , CNT7 , AMT7" ).append("\n"); 
		query.append("         , CNT8 , AMT8" ).append("\n"); 
		query.append("         , CNT1 + CNT2 + CNT3 + CNT4 + CNT5 + CNT6 + CNT7 + CNT8 AS TOT_CNT" ).append("\n"); 
		query.append("         , AMT1 + AMT2 + AMT3 + AMT4 + AMT5 + AMT6 + AMT7 + AMT8 AS TOT_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT SUBSTR(B.POL_YD_CD, 6) AS TMNL_CD" ).append("\n"); 
		query.append("                 , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D2'   , 1, 0)) AS CNT1" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T2'   , 1, 0)) AS CNT2" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW2'  , 1, 0)) AS CNT3" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D4/5' , 1, 0)) AS CNT4" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T4/5' , 1, 0)) AS CNT5" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW45' , 1, 0)) AS CNT6" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D7'   , 1, 0)) AS CNT7" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'DG7'  , 1, 0)) AS CNT8" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D2'   , F.PCF_UT_AMT1, 0)) AS AMT1" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T2'   , F.PCF_UT_AMT2, 0)) AS AMT2" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW2'  , F.PCF_UT_AMT3, 0)) AS AMT3" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D4/5' , F.PCF_UT_AMT4, 0)) AS AMT4" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'T4/5' , F.PCF_UT_AMT5, 0)) AS AMT5" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'AW45' , F.PCF_UT_AMT6, 0)) AS AMT6" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'D7'   , F.PCF_UT_AMT7, 0)) AS AMT7" ).append("\n"); 
		query.append("                 , SUM(DECODE(E.PCF_CNTR_TPSZ_CD, 'DG7'  , F.PCF_UT_AMT8, 0)) AS AMT8" ).append("\n"); 
		query.append("            FROM BKG_BOOKING A" ).append("\n"); 
		query.append("               , BKG_VVD B" ).append("\n"); 
		query.append("               , BKG_CONTAINER C" ).append("\n"); 
		query.append("               , VSK_ACT_PORT_SKD D" ).append("\n"); 
		query.append("               , INV_PCF_CNTR_TP_SZ E" ).append("\n"); 
		query.append("               , INV_PCF_REV_EXPN_AMT F" ).append("\n"); 
		query.append("           #if (${vvd_cd} != '')	" ).append("\n"); 
		query.append("               , (SELECT TRIM(COLUMN_VALUE) AS VVD FROM TABLE(BKG_SPLIT_FNC(@[vvd_cd], ',')) WHERE COLUMN_VALUE IS NOT NULL) G  " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("            WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("            AND B.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("            AND B.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND B.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND B.POL_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND B.POL_CLPT_IND_SEQ = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("            AND B.VSL_CD = SUBSTR(G.VVD, 1, 4)" ).append("\n"); 
		query.append("            AND B.SKD_VOY_NO = SUBSTR(G.VVD, 5, 4)" ).append("\n"); 
		query.append("            AND B.SKD_DIR_CD = SUBSTR(G.VVD, 9, 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND E.BKG_CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            AND E.RD_CGO_FLG = C.RD_CGO_FLG" ).append("\n"); 
		query.append("            AND E.DCGO_FLG = C.DCGO_FLG" ).append("\n"); 
		query.append("            AND F.PORT_CD = B.POL_CD" ).append("\n"); 
		query.append("            AND B.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')    " ).append("\n"); 
		query.append("            AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${tmnl_cd} != '') " ).append("\n"); 
		query.append("            AND SUBSTR(B.POL_YD_CD, 6) = @[tmnl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND F.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("            AND TO_CHAR(D.ACT_DEP_DT, 'YYYYMMDD') BETWEEN REPLACE(@[fm_atd_dt],'-','') AND REPLACE(@[to_atd_dt],'-','')" ).append("\n"); 
		query.append("            AND TO_CHAR(D.ACT_DEP_DT, 'YYYYMMDD') BETWEEN F.FM_EFF_DT AND F.TO_EFF_DT" ).append("\n"); 
		query.append("            GROUP BY SUBSTR(B.POL_YD_CD, 6)" ).append("\n"); 
		query.append("                   , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY TMNL_CD" ).append("\n"); 
		query.append("           , VVD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}