/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL").append("\n"); 
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
		query.append("WITH BKG AS" ).append("\n"); 
		query.append("     (SELECT  BKG.BKG_NO," ).append("\n"); 
		query.append("              BKG.BKG_STS_CD," ).append("\n"); 
		query.append("              BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("              BKG.DE_TERM_CD," ).append("\n"); 
		query.append("              BKG.POR_CD," ).append("\n"); 
		query.append("              BKG.POL_CD," ).append("\n"); 
		query.append("              BKG.MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("              BKG.MTY_PKUP_DT," ).append("\n"); 
		query.append("              BKG.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("              BKG.CMDT_CD," ).append("\n"); 
		query.append("              BKG.VNDR_RMK," ).append("\n"); 
		query.append("              BKG.FLEX_HGT_FLG" ).append("\n"); 
		query.append("      FROM    BKG_BOOKING  BKG" ).append("\n"); 
		query.append("      WHERE   BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("      #if (${from_dt} != '')" ).append("\n"); 
		query.append("        #if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("           AND BKG.BKG_CRE_DT  BETWEEN to_date(@[from_dt],'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("        #elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("           AND BKG.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("         AND BKG.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("         AND BKG.DOC_USR_ID  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("         AND BKG.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${por_cd} !='')" ).append("\n"); 
		query.append("         AND BKG.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${pol_cd} !='')" ).append("\n"); 
		query.append("         AND BKG.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${pod_cd}!='')" ).append("\n"); 
		query.append("         AND BKG.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("         AND BKG.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("         AND BKG.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${bkg_no}!='')" ).append("\n"); 
		query.append("         AND BKG.BKG_NO   = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("         AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("         AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.BKG_STS_CD," ).append("\n"); 
		query.append("       BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("       BKG.DE_TERM_CD," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       LOC.SCC_CD," ).append("\n"); 
		query.append("       BKG.MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(BKG.MTY_PKUP_DT,'YYYY-MM-DD') AS MTY_PKUP_DT," ).append("\n"); 
		query.append("       VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       BKG.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("       REPLACE(CUST.CUST_NM, CHR(10), ' ') AS CUST_NM," ).append("\n"); 
		query.append("       BKG.CMDT_CD," ).append("\n"); 
		query.append("       COM.CMDT_NM," ).append("\n"); 
		query.append("       DECODE(HIS.NTC_FAX_NO,'',YAR.FAX_NO,HIS.NTC_FAX_NO) AS NTC_FAX_NO," ).append("\n"); 
		query.append("       DECODE(HIS.NTC_EML,'',YAR.YD_EML,HIS.NTC_EML) AS NTC_EML," ).append("\n"); 
		query.append("       HIS.DIFF_RMK," ).append("\n"); 
		query.append("       BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("           SELECT (SELECT CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("                   FROM   MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                   WHERE  CNTR_TPSZ_CD = A.CNTR_TPSZ_CD) ||'-'|| OP_CNTR_QTY" ).append("\n"); 
		query.append("           FROM   BKG_QUANTITY A" ).append("\n"); 
		query.append("           WHERE  BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND    CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("       ), ', ') AS CNTR_QTY," ).append("\n"); 
		query.append("       (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = BKG.MTY_PKUP_YD_CD) AS CY_NAME," ).append("\n"); 
		query.append("       (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = VVD1.VSL_CD) || VVD1.SKD_VOY_NO || VVD1.SKD_DIR_CD AS VVD_NAME," ).append("\n"); 
		query.append("       BKG.VNDR_RMK," ).append("\n"); 
		query.append("       DECODE(BKG.FLEX_HGT_FLG,'Y','Y',NULL) AS FLEX_HGT_FLG" ).append("\n"); 
		query.append("  FROM BKG           BKG," ).append("\n"); 
		query.append("       MDM_LOCATION  LOC," ).append("\n"); 
		query.append("       BKG_VVD       VVD1," ).append("\n"); 
		query.append("       BKG_CUSTOMER  CUST," ).append("\n"); 
		query.append("       MDM_COMMODITY COM," ).append("\n"); 
		query.append("       MDM_YARD      YAR," ).append("\n"); 
		query.append("       (SELECT BKG_NO," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'F',NTC_FAX_NO,''))) NTC_FAX_NO," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'F',BKG_NTC_SND_RSLT_CD,''))) FAX_SND_RSLT_CD," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'F',SND_DT,''))) FAX_SND_DT," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'M',NTC_EML,''))) NTC_EML," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'M',BKG_NTC_SND_RSLT_CD,''))) EML_SND_RSLT_CD," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'M',SND_DT,''))) EML_SND_DT," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'E',EDI_ID,''))) EDI_ID," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DECODE(NTC_VIA_CD,'E',SND_DT,''))) EDI_SND_DT," ).append("\n"); 
		query.append("               MIN(DECODE(RK,1,DIFF_RMK)) DIFF_RMK" ).append("\n"); 
		query.append("          FROM (SELECT B.BKG_NO," ).append("\n"); 
		query.append("                       B.NTC_VIA_CD," ).append("\n"); 
		query.append("                       B.NTC_KND_CD," ).append("\n"); 
		query.append("                       B.NTC_FAX_NO," ).append("\n"); 
		query.append("                       B.NTC_EML," ).append("\n"); 
		query.append("                       B.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                       B.SND_DT," ).append("\n"); 
		query.append("                       B.EDI_ID," ).append("\n"); 
		query.append("                       B.DIFF_RMK," ).append("\n"); 
		query.append("                       RANK( ) OVER ( PARTITION BY B.BKG_NO, B.NTC_KND_CD, B.NTC_VIA_CD ORDER BY B.HIS_SEQ DESC ) AS RK, " ).append("\n"); 
		query.append("                       B.HIS_SEQ" ).append("\n"); 
		query.append("                  FROM BKG A," ).append("\n"); 
		query.append("                       BKG_NTC_HIS  B" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND NTC_KND_CD = 'CN'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE RK = 1" ).append("\n"); 
		query.append("         GROUP BY BKG_NO) HIS" ).append("\n"); 
		query.append(" WHERE BKG.POR_CD   = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO   = VVD1.BKG_NO" ).append("\n"); 
		query.append("   AND VVD1.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("   AND BKG.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("   AND BKG.BKG_NO   = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CUST.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND BKG.CMDT_CD  = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND BKG.MTY_PKUP_YD_CD = YAR.YD_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO   = HIS.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("   AND VVD1.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("   AND VVD1.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("   AND VVD1.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY 1, 2" ).append("\n"); 

	}
}