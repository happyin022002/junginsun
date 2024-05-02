/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllNtfcSvcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllNtfcSvcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * email 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllNtfcSvcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllNtfcSvcListRSQL").append("\n"); 
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
		query.append("  SC_NO" ).append("\n"); 
		query.append(", CUST_CD" ).append("\n"); 
		query.append(", CTRT_PTY_NM" ).append("\n"); 
		query.append(", PROP_MQC_QTY" ).append("\n"); 
		query.append(", UNIT_NM" ).append("\n"); 
		query.append(", PROP_OFC_CD" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", EMAIL_LIST_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    A.SC_NO" ).append("\n"); 
		query.append(",   SEXP.DWLL_CUST_CNT_CD || LPAD(SEXP.DWLL_CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append(",   A.CTRT_PTY_NM" ).append("\n"); 
		query.append(",   A.FNL_MQC_QTY AS PROP_MQC_QTY" ).append("\n"); 
		query.append(",   A.INTG_CD_VAL_DP_DESC UNIT_NM" ).append("\n"); 
		query.append(",	A.PROP_OFC_CD" ).append("\n"); 
		query.append(",   TO_CHAR(CTRT_EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",   TO_CHAR(CTRT_EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",   'Edit (Registered : '|| (SELECT COUNT(1) FROM SCE_DWLL_CUST_SVC_LIST S WHERE S.DWLL_CUST_CNT_CD = SEXP.DWLL_CUST_CNT_CD AND S.DWLL_CUST_SEQ = SEXP.DWLL_CUST_SEQ AND S.DELT_FLG = 'N' ) || ' )' EMAIL_LIST_CNT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    *" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            ROW_NUMBER() OVER ( PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY HDR.CRE_DT DESC, PTY.AMDT_SEQ DESC) SEL_SEQ" ).append("\n"); 
		query.append("        ,   PTY.PROP_NO" ).append("\n"); 
		query.append("        ,   PTY.AMDT_SEQ" ).append("\n"); 
		query.append("        ,   HDR.SC_NO" ).append("\n"); 
		query.append("        ,   PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,   PTY.CUST_SEQ" ).append("\n"); 
		query.append("        ,   PTY.CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,   PTY.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("		, MN.PROP_OFC_CD" ).append("\n"); 
		query.append("        , CTRT_EFF_DT" ).append("\n"); 
		query.append("        , CTRT_EXP_DT" ).append("\n"); 
		query.append("        , MQC.FNL_MQC_QTY" ).append("\n"); 
		query.append("        ,   UNIT.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("        ,   PRI_SP_HDR HDR" ).append("\n"); 
		query.append("        ,   PRI_SP_DUR DUR" ).append("\n"); 
		query.append("        ,   PRI_SP_MQC MQC" ).append("\n"); 
		query.append("		,   PRI_SP_MN MN" ).append("\n"); 
		query.append("        ,   (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC from COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00897' ) UNIT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND PTY.PRC_CTRT_PTY_TP_CD='C'" ).append("\n"); 
		query.append("        AND SUBSTR(HDR.SC_NO, 1,3) IN ('AEF', 'AEN', 'ANW','ASE','AWE','ASW', 'AWN', 'GLO', 'SAN', 'SAS', 'CEN','ANW','CEF','MME')" ).append("\n"); 
		query.append("        AND HDR.PROP_NO = PTY.PROP_NO    " ).append("\n"); 
		query.append("        AND PTY.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("        AND PTY.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("		AND PTY.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("		AND PTY.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND MQC.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("        AND MQC.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND MQC.CNTR_LOD_UT_CD = UNIT.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("            #if($scpfxcdArr.size() > 0)" ).append("\n"); 
		query.append("    AND ( " ).append("\n"); 
		query.append("         #foreach( ${key} in ${scpfxcdArr}) " ).append("\n"); 
		query.append("             #if($velocityCount < $scpfxcdArr.size()) " ).append("\n"); 
		query.append("             HDR.SC_NO LIKE '$key' || @[sc_no] || DECODE(@[mtch_flg], 'Y', '', '%') OR" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             HDR.SC_NO LIKE '$key' || @[sc_no] || DECODE(@[mtch_flg], 'Y', '', '%')" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${ctrt_exp_dt} != '')" ).append("\n"); 
		query.append("        AND DUR.CTRT_EXP_DT >= TO_DATE(@[ctrt_exp_dt], 'yyyy-MM-dd')" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${ctrt_eff_dt} != '') " ).append("\n"); 
		query.append("        AND DUR.CTRT_EFF_DT <= TO_DATE(@[ctrt_eff_dt], 'yyyy-MM-DD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE SEL_SEQ=1" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(",   SCE_DWLL_NTFC_CUST_EXPT SEXP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("	AND SEXP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_CNT_CD LIKE '%'||@[cust_cnt_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_seq} != '' )" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_SEQ LIKE '%'||TO_NUMBER(@[cust_seq])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        '' SC_NO" ).append("\n"); 
		query.append("    ,   SEXP.DWLL_CUST_CNT_CD || LPAD(SEXP.DWLL_CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append("    ,   CUST_LGL_ENG_NM AS CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,   0 PROP_MQC_QTY" ).append("\n"); 
		query.append("    ,   '' UNIT_NM" ).append("\n"); 
		query.append("    ,   '' PROP_OFC_CD" ).append("\n"); 
		query.append("    ,   '' EFF_DT" ).append("\n"); 
		query.append("    ,   '' EXP_DT" ).append("\n"); 
		query.append("    ,   'Edit (Registered : '|| (SELECT COUNT(1) FROM SCE_DWLL_CUST_SVC_LIST S WHERE S.DWLL_CUST_CNT_CD = SEXP.DWLL_CUST_CNT_CD AND S.DWLL_CUST_SEQ = SEXP.DWLL_CUST_SEQ AND S.DELT_FLG = 'N' ) || ' )' EMAIL_LIST_CNT" ).append("\n"); 
		query.append("    FROM SCE_DWLL_NTFC_CUST_EXPT SEXP, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND SEXP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND SEXP.DWLL_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND SEXP.DWLL_CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_CNT_CD LIKE '%'||@[cust_cnt_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_seq} != '' )" ).append("\n"); 
		query.append("    AND SEXP.DWLL_CUST_SEQ LIKE '%'||TO_NUMBER(@[cust_seq])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND NOT EXISTS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("               'X'" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("            ,   PRI_SP_HDR HDR" ).append("\n"); 
		query.append("            ,   PRI_SP_DUR DUR" ).append("\n"); 
		query.append("            ,   PRI_SP_MQC MQC" ).append("\n"); 
		query.append("                    ,   PRI_SP_MN MN" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND PTY.PRC_CTRT_PTY_TP_CD='C'" ).append("\n"); 
		query.append("            AND SUBSTR(HDR.SC_NO, 1,3) IN ('AEF', 'AEN', 'ANW','ASE','AWE','ASW', 'AWN', 'GLO', 'SAN', 'SAS', 'CEN','ANW','CEF','MME')" ).append("\n"); 
		query.append("            AND HDR.PROP_NO = PTY.PROP_NO    " ).append("\n"); 
		query.append("            AND PTY.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("            AND PTY.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND PTY.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                    AND PTY.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("            AND MQC.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("            AND MQC.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("            AND SEXP.DWLL_CUST_CNT_CD = PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND SEXP.DWLL_CUST_SEQ = PTY.CUST_SEQ" ).append("\n"); 
		query.append("                       #if($scpfxcdArr.size() > 0)" ).append("\n"); 
		query.append("    AND ( " ).append("\n"); 
		query.append("         #foreach( ${key} in ${scpfxcdArr}) " ).append("\n"); 
		query.append("             #if($velocityCount < $scpfxcdArr.size()) " ).append("\n"); 
		query.append("             HDR.SC_NO LIKE '$key' || @[sc_no] || DECODE(@[mtch_flg], 'Y', '', '%') OR" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             HDR.SC_NO LIKE '$key' || @[sc_no] || DECODE(@[mtch_flg], 'Y', '', '%')" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SC_NO, CUST_CD" ).append("\n"); 

	}
}