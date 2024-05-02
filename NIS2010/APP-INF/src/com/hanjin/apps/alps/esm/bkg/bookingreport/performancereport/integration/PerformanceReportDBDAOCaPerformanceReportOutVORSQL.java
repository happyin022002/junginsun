/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOCaPerformanceReportOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : 이지영
*@LastVersion : 1.0
* 2010.09.10 이지영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JI-YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaPerformanceReportOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaPerformanceReportOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cho_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lan_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("corr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cho_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaPerformanceReportOutVORSQL").append("\n"); 
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
		query.append("#if (${tab_tp} != '')" ).append("\n"); 
		query.append("SELECT CNT.*, ROUND((TOT_CA/TOT_BL*100), 3) AS RATIO FROM (" ).append("\n"); 
		query.append("#if (${tab_tp} == '0') " ).append("\n"); 
		query.append("SELECT BKG_OFC_CD  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CUST_NM" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("      ,COUNT(DISTINCT BKG_NO)                                                             AS TOT_BL" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'M',1,0)+DECODE(CA_RSN_CD,'C',1,0)" ).append("\n"); 
		query.append("       + DECODE(CA_RSN_CD,'G',1,0)+DECODE(CA_RSN_CD,'O',1,0)+DECODE(CA_RSN_CD,'R',1,0)" ).append("\n"); 
		query.append("       + DECODE(CA_RSN_CD,'A',1,0)+DECODE(CA_RSN_CD,'H',1,0))                             AS TOT_CA" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'M',1,'O',1,0),0))                             AS REA_M" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'C',1,'H',1,0),0))                             AS REA_C" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'G',1,0),0))                                   AS REA_G" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'A',1,0),0))                                   AS REA_A" ).append("\n"); 
		query.append("      ,SUM(DECODE(UNCNT,0,DECODE(CA_RSN_CD,'R',1,0),0))                                   AS REA_R                                        " ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_A,'N',0,1))                                                        AS KIND_A" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_B,'N',0,1))                                                        AS KIND_B" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_C,'N',0,1))                                                        AS KIND_C" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_D,'N',0,1))                                                        AS KIND_D" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_E,'N',0,1))                                                        AS KIND_E" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_F,'N',0,1))                                                        AS KIND_F" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_G,'N',0,1))                                                        AS KIND_G" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_H,'N',0,1))                                                        AS KIND_H" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_I,'N',0,1))                                                        AS KIND_I" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_J,'N',0,1))                                                        AS KIND_J" ).append("\n"); 
		query.append("      ,SUM(DECODE(KIND_K,'N',0,1))                                                        AS KIND_K      " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${cho_dt} == '0') " ).append("\n"); 
		query.append(" /*+  USE_NL(COR BKG CUS DOC)*/  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" /*+  USE_NL(BKG COR CUS DOC) INDEX( BKG XAK3BKG_BOOKING)  */  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   BKG.BKG_NO                                   AS BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO                                    AS BL_NO" ).append("\n"); 
		query.append("      ,BKG.BKG_OFC_CD                               AS BKG_OFC_CD       " ).append("\n"); 
		query.append("      ,BKG.SLS_RHQ_CD                               AS SLS_RHQ_CD" ).append("\n"); 
		query.append("      ,BKG.CTRT_OFC_CD                              AS CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,COR.CORR_NO                                  AS CORR_NO" ).append("\n"); 
		query.append("      ,COR.CORR_OFC_CD                              AS CORR_OFC_CD" ).append("\n"); 
		query.append("		#if (${tab_tp} == '1')" ).append("\n"); 
		query.append("      		,( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = CUS.CUST_CNT_CD AND MC.CUST_SEQ = CUS.CUST_SEQ ) AS CUST_NM" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      ,BL_OBRD_DT                                   AS BL_OBRD_DT" ).append("\n"); 
		query.append("      ,NVL(CA_RSN_CD,'*')                           AS CA_RSN_CD     " ).append("\n"); 
		query.append("      ,NVL(RAT_FLG,'N')                             AS REV" ).append("\n"); 
		query.append("      ,NVL(EXPN_FLG,'N')                            AS EXP" ).append("\n"); 
		query.append("      ,NVL(RT_CORR_FLG,'N')                         AS KIND_A" ).append("\n"); 
		query.append("      ,NVL(CHG_TERM_CORR_FLG,'N')                   AS KIND_B  " ).append("\n"); 
		query.append("      ,NVL(RCVDE_TERM_CORR_FLG,'N')                 AS KIND_C" ).append("\n"); 
		query.append("      ,NVL(ROUT_CORR_FLG,'N')                       AS KIND_D" ).append("\n"); 
		query.append("      ,NVL(CUST_CORR_FLG,'N')                       AS KIND_E" ).append("\n"); 
		query.append("      ,NVL(QTY_CORR_FLG,'N')                        AS KIND_F" ).append("\n"); 
		query.append("      ,NVL(MEAS_QTY_CORR_FLG,'N')                   AS KIND_G" ).append("\n"); 
		query.append("      ,NVL(CMDT_CORR_FLG,'N')                       AS KIND_H" ).append("\n"); 
		query.append("      ,NVL(TRNK_VSL_CORR_FLG,'N')                   AS KIND_I " ).append("\n"); 
		query.append("      ,NVL(PRPST_VSL_CORR_FLG,'N')                  AS KIND_J" ).append("\n"); 
		query.append("      ,NVL(CA_OTR_RSN_CORR_FLG,'N')                 AS KIND_K" ).append("\n"); 
		query.append("      ,DECODE(COR.DOC_PERF_EXPT_CD,NULL,0,1)        AS UNCNT" ).append("\n"); 
		query.append("      ,(Select SUM(CRR_HNGR_QTY)  from BKG_QTY_HIS where bkg_no = cor.bkg_no and cor.corr_no = corr_no)  AS C_HAUL" ).append("\n"); 
		query.append("      ,(Select SUM(MER_HNGR_QTY)  from BKG_QTY_HIS where bkg_no = cor.bkg_no and cor.corr_no = corr_no)  AS M_HAUL" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("      ,BKG_CORRECTION   COR   " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#if (${tab_tp} == '1')" ).append("\n"); 
		query.append("	      ,BKG_CUSTOMER     CUS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,BKG_BL_DOC       DOC" ).append("\n"); 
		query.append("#if (${cho_dt} == '0') " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tab_tp} == '1')" ).append("\n"); 
		query.append("   		AND BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND COR.CORR_NO NOT IN ('0000000001')" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD NOT IN ('F','E')" ).append("\n"); 
		query.append("   AND COR.CORR_DT BETWEEN TO_DATE(@[cho_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[cho_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tab_tp} == '1')" ).append("\n"); 
		query.append("   		AND BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND COR.CORR_NO(+) <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND COR.CA_RSN_CD(+) NOT IN ('F','E')" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
		query.append("   AND BKG.BKG_CRE_DT BETWEEN TO_DATE(@[cho_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[cho_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_obrd_from_dt} != '')" ).append("\n"); 
		query.append("   AND DOC.BL_OBRD_DT BETWEEN TO_DATE(@[bl_obrd_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[bl_obrd_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tab_tp} == '1')" ).append("\n"); 
		query.append("   #if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'Y' " ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MC " ).append("\n"); 
		query.append("               WHERE MC.CUST_CNT_CD = CUS.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND MC.CUST_SEQ = CUS.CUST_SEQ" ).append("\n"); 
		query.append("               AND MC.CUST_LGL_ENG_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${cust_tp} == 'S')" ).append("\n"); 
		query.append("   AND CUS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("   AND CUS.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${tab_tp} == '0') " ).append("\n"); 
		query.append("   AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_usr_id} != '') " ).append("\n"); 
		query.append("   AND COR.CORR_USR_ID = @[corr_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lan_skd_dir_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD = @[lan_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND BKG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("   AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_rsn_cd} != '') " ).append("\n"); 
		query.append("   ${rea_val}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_knd} != '') " ).append("\n"); 
		query.append("   ${ca_knd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_flg} != '') " ).append("\n"); 
		query.append("   AND COR.RAT_FLG = @[rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("#if (${tab_tp} == '0')  " ).append("\n"); 
		query.append("GROUP BY BKG_OFC_CD" ).append("\n"); 
		query.append("ORDER BY BKG_OFC_CD ASC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY CUST_NM" ).append("\n"); 
		query.append("ORDER BY CUST_NM" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append(") CNT   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${tab_tp} == '0') " ).append("\n"); 
		query.append("SELECT BKG_OFC_CD  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${cust_tp} == 'S')" ).append("\n"); 
		query.append("SELECT REPLACE(SHPR_CUST_NM, CHR(13) || CHR(10), ' ')   CUST_NM" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("SELECT REPLACE(FRT_FWRD_CUST_NM, CHR(13) || CHR(10), ' ') CUST_NM" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end                       " ).append("\n"); 
		query.append("      ,SUM(RT_CA_KNT)                                   KIND_A" ).append("\n"); 
		query.append("      ,SUM(FRT_TERM_CA_KNT)                             KIND_B" ).append("\n"); 
		query.append("      ,SUM(TERM_CA_KNT)                                 KIND_C" ).append("\n"); 
		query.append("      ,SUM(ROUT_CA_KNT)                                 KIND_D" ).append("\n"); 
		query.append("      ,SUM(CUST_CA_KNT)                                 KIND_E" ).append("\n"); 
		query.append("      ,SUM(QTY_CA_KNT)                                  KIND_F" ).append("\n"); 
		query.append("      ,SUM(MEAS_QTY_CA_KNT)                             KIND_G" ).append("\n"); 
		query.append("      ,SUM(CMDT_CA_KNT)                                 KIND_H" ).append("\n"); 
		query.append("      ,SUM(TRNK_VSL_CA_KNT)                             KIND_I" ).append("\n"); 
		query.append("      ,SUM(PRPST_VSL_CA_KNT)                            KIND_J" ).append("\n"); 
		query.append("      ,SUM(CA_OTR_RSN_KNT)                              KIND_K" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'M',1,'O',1,0))             REA_M" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'C',1,'H',1,0))             REA_C" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'G',1,0))                   REA_G" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'A',1,0))                   REA_A" ).append("\n"); 
		query.append("      ,SUM(DECODE(CA_RSN_CD,'R',1,0))                   REA_R" ).append("\n"); 
		query.append("      ,SUM(TTL_BL_KNT)                                  TOT_BL" ).append("\n"); 
		query.append("      ,SUM(TTL_CA_KNT)                                  TOT_CA" ).append("\n"); 
		query.append("      --,ROUND(SUM(TTL_BL_KNT)/SUM(TTL_CA_KNT)*100, 3)    RATIO" ).append("\n"); 
		query.append("      ,ROUND(SUM(TTL_BL_KNT)/DECODE(SUM(TTL_CA_KNT),0,1,SUM(TTL_CA_KNT))*100, 3)    RATIO" ).append("\n"); 
		query.append("  FROM BKG_CORR_SMRY" ).append("\n"); 
		query.append("#if (${cho_dt} == '0') " ).append("\n"); 
		query.append(" WHERE BKG_CORR_YRMON BETWEEN SUBSTR(@[cho_from_dt],1,6) AND SUBSTR(@[cho_to_dt],1,6)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" WHERE BKG_CRE_YRMON BETWEEN SUBSTR(@[cho_from_dt],1,6) AND SUBSTR(@[cho_to_dt],1,6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_obrd_from_dt} != '') " ).append("\n"); 
		query.append("   AND TO_CHAR(BL_OBRD_DT,'YYYYMMDD') BETWEEN @[bl_obrd_from_dt] AND @[bl_obrd_to_dt] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_nm} != '' && ${tab_tp} == '1')" ).append("\n"); 
		query.append("	#if (${cust_tp} == 'S')" ).append("\n"); 
		query.append("   AND SHPR_CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("   AND FRT_FWRD_CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_tp} == '1')" ).append("\n"); 
		query.append("  #if (${cust_tp} == 'S')" ).append("\n"); 
		query.append("   AND CUS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("   AND CUS.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${tab_tp} == '0')" ).append("\n"); 
		query.append("   AND BKG_OFC_CD = @[bkg_ofc_cd]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_usr_id} != '') " ).append("\n"); 
		query.append("   AND CA_STF_USR_ID = @[corr_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("   AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lan_skd_dir_cd} != '') " ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[lan_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("   AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("   AND POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("   AND DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_rsn_cd} != '') " ).append("\n"); 
		query.append("   ${rea_val}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_knd} != '') " ).append("\n"); 
		query.append("   ${ca_knd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_flg} != '') " ).append("\n"); 
		query.append("   AND SLS_REV_FLG = @[rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tab_tp} == '0') " ).append("\n"); 
		query.append(" GROUP BY BKG_OFC_CD" ).append("\n"); 
		query.append(" ORDER BY BKG_OFC_CD ASC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${cust_tp} == 'S')" ).append("\n"); 
		query.append(" GROUP BY SHPR_CUST_NM" ).append("\n"); 
		query.append(" ORDER BY SHPR_CUST_NM ASC" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append(" GROUP BY FRT_FWRD_CUST_NM" ).append("\n"); 
		query.append(" ORDER BY FRT_FWRD_CUST_NM ASC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}