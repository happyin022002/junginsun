/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : jklim
*@LastVersion : 1.0
* 2013.10.01 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Doc Performance Report
	  * Documentation 실적 산출 기능
	  * 2.Pre-Audit B/L List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL").append("\n"); 
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
		query.append("    A.BKG_NO," ).append("\n"); 
		query.append("    A.BL_NO," ).append("\n"); 
		query.append("    A.CLASS_TYPE," ).append("\n"); 
		query.append("    A.BKG_DT," ).append("\n"); 
		query.append("    A.BKG_STF," ).append("\n"); 
		query.append("    A.BKG_OFC_CD," ).append("\n"); 
		query.append("    A.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("	A.POR_CD," ).append("\n"); 
		query.append("    A.POL_CD," ).append("\n"); 
		query.append("    A.POD_CD," ).append("\n"); 
		query.append("    A.SLAN_CD," ).append("\n"); 
		query.append("    A.BKG_STS," ).append("\n"); 
		query.append("    A.VVD_CD," ).append("\n"); 
		query.append("    A.SKD_VOY_NO," ).append("\n"); 
		query.append("    A.VSL_CD," ).append("\n"); 
		query.append("    A.SKD_DIR_CD," ).append("\n"); 
		query.append("	DECODE(A.DOC_KND_STS_CD,'3' ,BKG_GET_TOKEN_FNC(VPS,1,','), A.ETD) AS DOCP_DT," ).append("\n"); 
		query.append("    --DECODE(A.DOC_KND_STS_CD,'3',BKG_GET_TOKEN_FNC(VPS,1,','),NVL(TO_CHAR(A.POL_ETD_DT,'YYYY-MM-DD'),BKG_GET_TOKEN_FNC(VPS,2,','))) AS DOCP_DT," ).append("\n"); 
		query.append("    A.BKG_DOC_DT AS PORT_CLZ_DT," ).append("\n"); 
		query.append("	A.DOC_PROC_RSLT_RMK AS DPCS_SMRY_RMK," ).append("\n"); 
		query.append("	--LTRIM(SUBSTR(A.DPCS_SMRY_RMK,(INSTR(A.DPCS_SMRY_RMK,',')+1))) AS DPCS_SMRY_RMK," ).append("\n"); 
		query.append("    A.CRE_DT AS BATCH_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DP.BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO" ).append("\n"); 
		query.append("      ,NVL(PA.DOC_KND_STS_CD, '9') CLASS_TYPE" ).append("\n"); 
		query.append("      ,BKG.BKG_CRE_DT BKG_DT" ).append("\n"); 
		query.append("      ,BKG.DOC_USR_ID BKG_STF" ).append("\n"); 
		query.append("      ,DP.BKG_OFC_CD" ).append("\n"); 
		query.append("      ,DP.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,BKG.POR_CD" ).append("\n"); 
		query.append("      ,DP.POL_CD" ).append("\n"); 
		query.append("      ,DP.POD_CD" ).append("\n"); 
		query.append("      ,DP.SLAN_CD" ).append("\n"); 
		query.append("      ,DECODE(PA.DOC_PROC_RSLT_TP_CD, 'I','N','1','N','N','N','Y')  BKG_STS" ).append("\n"); 
		query.append("	  --,DECODE(DP.DOC_PROC_RSLT_TP_CD, 'I','Y','1','Y','N')  BKG_STS" ).append("\n"); 
		query.append("      ,DP.VSL_CD || DP.SKD_VOY_NO || DP.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("      --,DECODE(DP.DOC_KND_STS_CD,'3',TO_CHAR(VPS.VPS_ETA_DT,'YYYY-MM-DD'),NVL(TO_CHAR(BKG.POL_ETD_DT,'YYYY-MM-DD'),TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD')))  DOCP_DT   " ).append("\n"); 
		query.append("      ,DP.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,DP.VSL_CD" ).append("\n"); 
		query.append("      ,DP.SKD_DIR_CD" ).append("\n"); 
		query.append("	  ,(SELECT TO_CHAR(VPS.VPS_ETA_DT,'YYYY-MM-DD')||','||TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD VPS, BKG_VVD BV" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND    BV.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("        AND    BV.VSL_CD = VPS.VSL_CD " ).append("\n"); 
		query.append("        AND    BV.SKD_VOY_NO = VPS.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    BV.SKD_DIR_CD = VPS.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND    DECODE(DP.DOC_KND_STS_CD,'3',BV.POD_CD,BV.POL_CD) = VPS.VPS_PORT_CD " ).append("\n"); 
		query.append("        AND    VPS.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("	#if (${class_type} == '3') " ).append("\n"); 
		query.append("		AND    BKG.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND    BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)VPS" ).append("\n"); 
		query.append("		,(SELECT TO_CHAR(VSK.VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("        		FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("        		WHERE 1=1" ).append("\n"); 
		query.append("        		  AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("        		  AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("        		  AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("        		  AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("        		  AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("        		  AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        		  AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("        		  AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("       ) ETD	" ).append("\n"); 
		query.append("   	  ,BKG.POL_ETD_DT AS POL_ETD_DT" ).append("\n"); 
		query.append("      ,PA.DOC_KND_STS_CD AS DOC_KND_STS_CD" ).append("\n"); 
		query.append("      --,DP.BKG_DOC_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(BKG.PORT_CLZ_DT,'YYYYMMDD') BKG_DOC_DT" ).append("\n"); 
		query.append("      ,PA.DOC_PROC_RSLT_RMK" ).append("\n"); 
		query.append("      ,TO_CHAR(DP.CRE_DT,'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG" ).append("\n"); 
		query.append("      ,BKG_DPCS_PROC_SMRY DP" ).append("\n"); 
		query.append("      ,BKG_DPCS_PROC_SMRY PA" ).append("\n"); 
		query.append("WHERE  DP.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("--AND    DECODE(DP.DOC_KND_STS_CD, '3','T',BKG.POL_CD) = DECODE(DP.DOC_KND_STS_CD,'3',BV.VSL_PRE_PST_CD,BV.POL_CD) " ).append("\n"); 
		query.append("AND    BKG.BKG_STS_CD IN ('W', 'F', 'S') " ).append("\n"); 
		query.append("AND    DP.DELT_FLG = 'N' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fr_dt} != '' && ${class_type} !='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT >= TO_CHAR(TO_DATE(@[fr_dt],'YYYY-MM-DD')-7 ,'YYYYMMDD') " ).append("\n"); 
		query.append("		AND    BKG.PORT_CLZ_DT >= TO_DATE(@[fr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#elseif (${fr_dt} != '' && ${class_type} =='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT >= TO_CHAR(TO_DATE(@[fr_dt],'YYYY-MM-DD') ,'YYYYMMDD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${to_dt} != '' && ${class_type} !='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT <= TO_CHAR(TO_DATE(@[to_dt],'YYYY-MM-DD')+7,'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("		AND    BKG.PORT_CLZ_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#elseif (${to_dt} != '' && ${class_type} =='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT <= TO_CHAR(TO_DATE(@[to_dt],'YYYY-MM-DD'),'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND    DP.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND    DP.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND    DP.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${class_type} != '') " ).append("\n"); 
		query.append("AND    DP.DOC_KND_STS_CD = '2'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    DP.BKG_NO = PA.BKG_NO(+)" ).append("\n"); 
		query.append("AND    PA.DOC_KND_STS_CD(+) = '9'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND    BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("AND    BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("AND	   DP.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND	   DP.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND	   DP.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("and    DP.BKG_OFC_CD = @[sel_bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}