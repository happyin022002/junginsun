/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffTariffDBDAOSearchDodTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAOSearchDodTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDodTariffList
	  * </pre>
	  */
	public DropOffTariffDBDAOSearchDodTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_sfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_frm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOSearchDodTariffListRSQL").append("\n"); 
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
		query.append("SELECT DDT.DRP_OFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_DIV_CD," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CNT_CD," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXP_DT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXP_FLG," ).append("\n"); 
		query.append("       DDT.DEL_CD," ).append("\n"); 
		query.append("       DDT.CNTR_RTN_LOC_CD," ).append("\n"); 
		query.append("       NVL(DDT.CNTR_RTN_YD_SFX_CD, 'ALL') as CNTR_RTN_YD_SFX_CD," ).append("\n"); 
		query.append("       DDT.POL_CONTI_CD," ).append("\n"); 
		query.append("       DDT.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DDT.CURR_CD," ).append("\n"); 
		query.append("       DDT.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("       DDT.SPCL_CUST_SEQ," ).append("\n"); 
		query.append("#if(${s_trf_div_cd} != 'G')" ).append("\n"); 
		query.append("	   DDT.SPCL_CUST_CNT_CD||LPAD(DDT.SPCL_CUST_SEQ,6,'0') AS SPCL_CUST_CNT_SEQ," ).append("\n"); 
		query.append("	   (select SPCL_CUST_CNT_CD||LPAD(SPCL_CUST_SEQ,6,'0') || ', ' || SUBSTR(CUST_LGL_ENG_NM, 0, 20) CUST_NM" ).append("\n"); 
		query.append("		  from MDM_CUSTOMER" ).append("\n"); 
		query.append("		 where 1=1" ).append("\n"); 
		query.append("		   AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("		   --AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		  AND CUST_CNT_CD = DDT.SPCL_CUST_CNT_CD " ).append("\n"); 
		query.append("           AND CUST_SEQ = DDT.SPCL_CUST_SEQ) AS SPCL_CUST_NM," ).append("\n"); 
		query.append("       (select COUNT(* ) from DOD_DRP_OFF_CHG where DRP_OFF_CHG_TRF_SPCL_SEQ = DDT.DRP_OFF_CHG_TRF_SEQ) as CHG_CNT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       (select COUNT(* ) from DOD_DRP_OFF_CHG where DRP_OFF_CHG_TRF_SEQ = DDT.DRP_OFF_CHG_TRF_SEQ) as CHG_CNT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_EXPT_FLG," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CFM_USR_ID," ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_CFM_DT," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.DRP_OFF_CHG_TRF_CFM_DT,'YYYY-MM-DD HH24:MI') as DRP_OFF_CHG_TRF_CFM_DT," ).append("\n"); 
		query.append("	   DECODE(       DDT.DRP_OFF_CHG_TRF_CFM_FLG, 'Y', 'C', 'S') as DRP_OFF_CHG_TRF_CFM_FLG, " ).append("\n"); 
		query.append("       DDT.DRP_OFF_CHG_TRF_RMK," ).append("\n"); 
		query.append("       DDT.DELT_FLG," ).append("\n"); 
		query.append("       DDT.CRE_USR_ID," ).append("\n"); 
		query.append("	  DDT.RFA_NO," ).append("\n"); 
		query.append("	  DDT.SC_NO," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.CRE_DT,'YYYY-MM-DD HH24:MI') as CRE_DT," ).append("\n"); 
		query.append("       DDT.UPD_USR_ID," ).append("\n"); 
		query.append("	   TO_CHAR(       DDT.UPD_DT,'YYYY-MM-DD HH24:MI') as UPD_DT,       " ).append("\n"); 
		query.append("		'' S_CNT_CD," ).append("\n"); 
		query.append("		'' S_FRM_EFF_DT," ).append("\n"); 
		query.append("		'' S_TO_EFF_DT," ).append("\n"); 
		query.append("		'' S_RTN_LOC_CD," ).append("\n"); 
		query.append("		'' S_YD_SFX_CD," ).append("\n"); 
		query.append("        '' S_CUST_CD," ).append("\n"); 
		query.append("		'' S_TRF_DIV_CD," ).append("\n"); 
		query.append("		'' S_TRF_EXPT_FLG," ).append("\n"); 
		query.append("		'' S_OFC_CD," ).append("\n"); 
		query.append("        (SELECT COUNT(1) FROM DOD_ATCH_FILE WHERE ATCH_FILE_LNK_ID = DDT.ATCH_FILE_LNK_ID) ATCH_FILE_LNK_CNT -- Attach File Count" ).append("\n"); 
		query.append("       #if(${s_trf_div_cd} == 'S')" ).append("\n"); 
		query.append("          ,(CASE WHEN DDT.RFA_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("             (SELECT /*+ DRIVING_SITE (MN) USE_NL(MN HDR CUST) */" ).append("\n"); 
		query.append("            	        CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("              	   ,PRI_RP_MN MN" ).append("\n"); 
		query.append("              	   ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("               WHERE MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("               AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("               AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("               AND MN.RFA_CTRT_TP_CD IN ('C','S')" ).append("\n"); 
		query.append("               AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("               AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_RP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND HDR.RFA_NO = DDT.RFA_NO)" ).append("\n"); 
		query.append("          WHEN DDT.SC_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("             (SELECT /*+ DRIVING_SITE (MN) USE_NL(MN HDR CUST) */" ).append("\n"); 
		query.append("                   CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("              FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("                ,PRI_SP_MN MN" ).append("\n"); 
		query.append("                ,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("              WHERE MN.REAL_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND MN.REAL_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("              AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("              AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("              AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("              AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_SP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("              AND HDR.SC_NO = DDT.SC_NO)" ).append("\n"); 
		query.append("         END) CUST_NM" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("  FROM DOD_DRP_OFF_CHG_TRF DDT" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND SUBSTR(DDT.CNTR_RTN_LOC_CD,0,2) = @[s_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_rtn_loc_cd} != '') " ).append("\n"); 
		query.append("	AND DDT.CNTR_RTN_LOC_CD = @[s_rtn_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_yd_sfx_cd} != '' && ${s_yd_sfx_cd} != 'ALL') " ).append("\n"); 
		query.append("	AND DDT.CNTR_RTN_YD_SFX_CD = @[s_yd_sfx_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_cd} != '') " ).append("\n"); 
		query.append("	AND spcl_cust_cnt_cd || lpad(spcl_cust_seq, 6, '0') = @[s_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_frm_eff_dt} != '' && ${s_to_eff_dt} != '')" ).append("\n"); 
		query.append("	AND to_date(DDT.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') <= to_date(REPLACE(@[s_frm_eff_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("    and to_date(DDT.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') >= to_date(REPLACE(@[s_to_eff_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_trf_div_cd} != '')" ).append("\n"); 
		query.append("	AND DRP_OFF_CHG_TRF_DIV_CD = @[s_trf_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_no} != '')" ).append("\n"); 
		query.append("	#if (${s_no_type} == 'S')" ).append("\n"); 
		query.append("		AND DDT.SC_NO = @[s_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND DDT.RFA_NO = @[s_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_trf_expt_flg} == 'on')" ).append("\n"); 
		query.append("	AND DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '' && ${s_ofc_cd} != 'SELOPE' && ${s_ofc_cd} != 'SELCMS' && ${s_ofc_cd} != 'SELCMU' && ${s_ofc_cd} != 'SELCMA' && ${s_ofc_cd} != 'SELCMI')" ).append("\n"); 
		query.append("	  AND (SELECT OFC_CD " ).append("\n"); 
		query.append("           FROM COM_USER " ).append("\n"); 
		query.append("           WHERE USR_ID = DDT.UPD_USR_ID) " ).append("\n"); 
		query.append("              IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                   FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("           	       AND NVL(O.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("                       START WITH OFC_CD = SUBSTR(@[s_ofc_cd], 1, 5)" ).append("\n"); 
		query.append("    	           CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trf_cfm_page} == 'TC')" ).append("\n"); 
		query.append("	AND DDT.DRP_OFF_CHG_TRF_CFM_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY   DDT.DRP_OFF_CHG_TRF_EFF_DT," ).append("\n"); 
		query.append("       	   DDT.DRP_OFF_CHG_TRF_EXP_DT," ).append("\n"); 
		query.append("           DDT.DRP_OFF_CHG_TRF_CNT_CD," ).append("\n"); 
		query.append("           DDT.DEL_CD," ).append("\n"); 
		query.append("           DDT.CNTR_RTN_LOC_CD" ).append("\n"); 

	}
}