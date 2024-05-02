/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDocPFMCOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDocPFMCOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Doc Performance Report-ESM_BKG_0214
	  * Documentation 실적 산출 기능
	  * 1.Office List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDocPFMCOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("class_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDocPFMCOfcListRSQL").append("\n"); 
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
		query.append("SELECT BK.BDO_OFC2 REGION" ).append("\n"); 
		query.append("      ,BK.BDO_OFC3 GSO" ).append("\n"); 
		query.append("      ,BK.BDO_OFC4 BKG_OFC_CD" ).append("\n"); 
		query.append("      ,NVL(BK.CNT,0) CNT  --a_st2" ).append("\n"); 
		query.append("      ,NVL(BK.DTL_CNT,0)  DTL_CNT--bkg_cnt" ).append("\n"); 
		query.append("      ,BK.BDO_OFC1" ).append("\n"); 
		query.append("      ,NVL(BK.DTL_CNT,0) || '/' || NVL(BK.CNT,0) OFC_CNT" ).append("\n"); 
		query.append("      , CASE WHEN NVL(BK.DTL_CNT,0) = 0 OR NVL(BK.CNT,0) = 0 THEN '0.00%' " ).append("\n"); 
		query.append("             ELSE TRIM(TO_CHAR(((NVL(BK.DTL_CNT,0) * 0.1) / (NVL(BK.CNT,0) * 0.1)) * 100, '99990.99')) || '%' " ).append("\n"); 
		query.append("        END RATIO" ).append("\n"); 
		query.append("      ,'' FR_DT" ).append("\n"); 
		query.append("      ,'' TO_DT" ).append("\n"); 
		query.append("      ,'' POL_CD" ).append("\n"); 
		query.append("      ,'' SLAN_CD" ).append("\n"); 
		query.append("      ,'' VVD_CD" ).append("\n"); 
		query.append("      ,'' BKG_NO" ).append("\n"); 
		query.append("      ,'' BL_NO" ).append("\n"); 
		query.append("      ,'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,'' CLASS_TYPE" ).append("\n"); 
		query.append("	  ,'' BKG_NO" ).append("\n"); 
		query.append("      ,'' BL_NO " ).append("\n"); 
		query.append("FROM	(SELECT	" ).append("\n"); 
		query.append("#if (${bl_no} != '' || ${bkg_no} !='') " ).append("\n"); 
		query.append("                /*+ index(bd XPKBKG_DPCS_PROC_SMRY) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                /*+ leading(bd dp bkg) index_ss(dp XAK3BKG_DPCS_PROC_SMRY) */  /* @@ 힌트적용  2014.11.24 튜닝 */" ).append("\n"); 
		query.append("#if (${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013')" ).append("\n"); 
		query.append("                DECODE(BD.RGN_OFC_CD,'TYOIB','SHARC',BD.RGN_OFC_CD) BDO_OFC2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                BD.RGN_OFC_CD BDO_OFC2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              , BD.GSO_OFC_CD BDO_OFC3" ).append("\n"); 
		query.append("              , BKG.BKG_OFC_CD BDO_OFC4" ).append("\n"); 
		query.append("              , SUB_GRP_CTNT BDO_OFC1" ).append("\n"); 
		query.append("              ,COUNT(DP.BKG_NO) CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(DP.DOC_PROC_RSLT_TP_CD, 'L', 0.5, 'I', 1, '1',1, 'N', 1, 0)) DTL_CNT" ).append("\n"); 
		query.append("        FROM   BKG_DPCS_PROC_SMRY DP" ).append("\n"); 
		query.append("              ,BKG_BOOKING        BKG" ).append("\n"); 
		query.append("              ,BKG_DOC_PERF_OFC   BD" ).append("\n"); 
		query.append("        WHERE  DP.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("        AND    BKG.BKG_STS_CD IN ('W', 'F', 'S') " ).append("\n"); 
		query.append("        AND    DP.DELT_FLG = 'N' " ).append("\n"); 
		query.append("        AND    DECODE(SUBSTR(BD.POR_CD,1,2),'JP',DP.BKG_OFC_CD,BD.BKG_OFC_CD) = DP.BKG_OFC_CD" ).append("\n"); 
		query.append("        AND    BD.GSO_OFC_CD <> 'SHADKJ' " ).append("\n"); 
		query.append("        AND    BD.BKG_OFC_CD <> 'SHADKJ'" ).append("\n"); 
		query.append("		AND    DECODE(SUBSTR(BD.POR_CD,1,2),'JP',BD.POR_CD,BKG.POR_CD) = BKG.POR_CD" ).append("\n"); 
		query.append("#if (${fr_dt} != '' && ${class_type} !='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT >= TO_CHAR(TO_DATE(@[fr_dt],'YYYY-MM-DD')-7 ,'YYYYMMDD') " ).append("\n"); 
		query.append("		AND    BKG.PORT_CLZ_DT >= TO_DATE(@[fr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#elseif (${fr_dt} != '' && ${class_type} =='9') " ).append("\n"); 
		query.append("		AND    DP.BKG_DOC_DT >= TO_CHAR(TO_DATE(@[fr_dt],'YYYY-MM-DD') ,'YYYYMMDD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${to_dt} != '' && ${class_type} !='9') " ).append("\n"); 
		query.append("        AND    DP.BKG_DOC_DT <= TO_CHAR(TO_DATE(@[to_dt],'YYYY-MM-DD')+7,'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("		AND    BKG.PORT_CLZ_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#elseif (${to_dt} != '' && ${class_type} =='9') " ).append("\n"); 
		query.append("		AND    DP.BKG_DOC_DT <= TO_CHAR(TO_DATE(@[to_dt],'YYYY-MM-DD'),'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND    DP.DOC_KND_STS_CD = @[class_type]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		AND	   BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("		AND	   BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("		AND	   DP.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("		AND    BKG.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		AND    BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("		AND    BKG.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("		AND   BKG.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND   BKG.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND   BKG.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gso} != '') " ).append("\n"); 
		query.append("		AND	   GSO_OFC_CD = @[gso]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${region} != '') " ).append("\n"); 
		query.append("   #if (${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013')" ).append("\n"); 
		query.append("		#if(${region} == 'SHARC')" ).append("\n"); 
		query.append("		AND    RGN_OFC_CD IN ( @[region],'TYOIB')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${region} == 'TYOIB')" ).append("\n"); 
		query.append("		AND    RGN_OFC_CD =''" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${region} != 'TYOIB' && ${region} != 'SHARC')" ).append("\n"); 
		query.append("		AND    RGN_OFC_CD= @[region]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    RGN_OFC_CD= @[region]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP  BY" ).append("\n"); 
		query.append("#if (${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013')" ).append("\n"); 
		query.append("              DECODE(BD.RGN_OFC_CD,'TYOIB','SHARC',BD.RGN_OFC_CD) " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              BD.RGN_OFC_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			  , BD.GSO_OFC_CD " ).append("\n"); 
		query.append("              , BKG.BKG_OFC_CD " ).append("\n"); 
		query.append("              , SUB_GRP_CTNT ) BK" ).append("\n"); 

	}
}