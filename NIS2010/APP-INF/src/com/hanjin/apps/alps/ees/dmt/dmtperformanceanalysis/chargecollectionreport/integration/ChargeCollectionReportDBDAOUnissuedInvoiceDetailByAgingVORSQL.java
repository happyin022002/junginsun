/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOUnissuedInvoiceDetailByAgingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOUnissuedInvoiceDetailByAgingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당기간에 발생한 Charge를 기준으로 하여 조회시점까지 관련 Charge Detail 정보를 조회한다
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOUnissuedInvoiceDetailByAgingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("uclm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOUnissuedInvoiceDetailByAgingVORSQL").append("\n"); 
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
		query.append("SELECT  C.SYS_AREA_GRP_ID                               AS SVR_ID" ).append("\n"); 
		query.append("       ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("       ,C.OFC_CD" ).append("\n"); 
		query.append("       ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,C.CNTR_NO" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,C.FT_DYS" ).append("\n"); 
		query.append("       ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD')              AS FM_MVMT_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD')              AS TO_MVMT_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD')              AS FT_CMNC_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(C.FT_END_DT , 'YYYYMMDD')              AS FT_END_DT" ).append("\n"); 
		query.append("       ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("       ,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("       ,C.SC_RFA_EXPT_AMT                              AS EXPT_AMT" ).append("\n"); 
		query.append("       ,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("       ,C.BIL_AMT" ).append("\n"); 
		query.append("       ,B.BKG_NO" ).append("\n"); 
		query.append("       ,B.BL_NO" ).append("\n"); 
		query.append("       ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD       AS VVD_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  V.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("			  FROM  VSK_VSL_SKD V" ).append("\n"); 
		query.append("			 WHERE  B.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("			   AND  B.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("			   AND  B.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("        )                                                AS LANE" ).append("\n"); 
		query.append("       ,B.POR_CD" ).append("\n"); 
		query.append("       ,B.POL_CD" ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("       ,B.SC_NO" ).append("\n"); 
		query.append("       ,B.RFA_NO" ).append("\n"); 
		query.append("       ,DECODE(C.CHG_SEQ, 1, 'G', 'B')                 AS CHG_TYPE" ).append("\n"); 
		query.append("       ,C.CHG_SEQ" ).append("\n"); 
		query.append("       ,NVL(B.SOC_FLG, 'N')                            AS SOC_FLG" ).append("\n"); 
		query.append("       ,V.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("       ,V.INV_CURR_CD" ).append("\n"); 
		query.append("       ,NVL(ID.CNTR_INV_AMT, 0)                        AS INV_CHG_AMT" ).append("\n"); 
		query.append("       ,V.DMDT_INV_NO" ).append("\n"); 
		query.append("       ,TO_CHAR(V.CRE_DT, 'YYYYMMDD')                  AS ISS_DT" ).append("\n"); 
		query.append("       ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("       ,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("       ,B.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("       ,C.CMDT_EXPT_AMT" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN V.BIL_AMT != 0 AND NVL(HRD.ATTR_CTNT1, 'N') != 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				NVL(ROUND(( SELECT SUM( AA.INV_PAY_AMT*ID.CNTR_INV_AMT/V.INV_AMT ) " ).append("\n"); 
		query.append("							FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("							WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO " ).append("\n"); 
		query.append("							  AND AA.DMDT_INV_PAY_TP_CD = 'M'), 2 ), 0)" ).append("\n"); 
		query.append("		    WHEN NVL(V.DMDT_AR_IF_CD,'N') = 'Y' THEN " ).append("\n"); 
		query.append("				NVL(ID.CNTR_INV_AMT, 0)" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				0 " ).append("\n"); 
		query.append("		END COLL_AMT" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN V.BIL_AMT != 0 THEN " ).append("\n"); 
		query.append("				V.INV_CURR_CD" ).append("\n"); 
		query.append("			WHEN NVL(HRD.ATTR_CTNT1, 'N') != 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				( SELECT MAX(INV_CURR_CD) FROM DMT_INV_OTS_PAY_RCV WHERE DMDT_INV_NO = V.DMDT_INV_NO AND DMDT_INV_PAY_TP_CD = 'M')" ).append("\n"); 
		query.append("			WHEN NVL(V.DMDT_AR_IF_CD,'N') = 'Y' THEN " ).append("\n"); 
		query.append("				V.INV_CURR_CD" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				''" ).append("\n"); 
		query.append("		END COLL_CURR_CD" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN V.BIL_AMT != 0 AND NVL(HRD.ATTR_CTNT1,'N') != 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				 ROUND(" ).append("\n"); 
		query.append("						NVL(ID.CNTR_INV_AMT, 0) - NVL(( SELECT SUM( AA.INV_PAY_AMT*ID.CNTR_INV_AMT/V.INV_AMT ) " ).append("\n"); 
		query.append("														FROM DMT_INV_OTS_PAY_RCV AA" ).append("\n"); 
		query.append("														WHERE AA.DMDT_INV_NO = V.DMDT_INV_NO" ).append("\n"); 
		query.append("														  AND AA.DMDT_INV_PAY_TP_CD = 'M' ), 0)" ).append("\n"); 
		query.append("				, 2)" ).append("\n"); 
		query.append("			WHEN NVL(V.DMDT_AR_IF_CD,'N') = 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				NVL(ID.CNTR_INV_AMT, 0)" ).append("\n"); 
		query.append("		ELSE " ).append("\n"); 
		query.append("			0 " ).append("\n"); 
		query.append("		END UNCOLL_AMT" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN V.BIL_AMT != 0 THEN " ).append("\n"); 
		query.append("				V.INV_CURR_CD" ).append("\n"); 
		query.append("			WHEN NVL(HRD.ATTR_CTNT1, 'N') != 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				NVL(( SELECT MAX(INV_CURR_CD) FROM DMT_INV_OTS_PAY_RCV WHERE DMDT_INV_NO = V.DMDT_INV_NO AND DMDT_INV_PAY_TP_CD = 'M' ),V.INV_CURR_CD)" ).append("\n"); 
		query.append("			WHEN NVL(V.DMDT_AR_IF_CD,'N') = 'N' AND C.DMDT_CHG_STS_CD = 'I' THEN " ).append("\n"); 
		query.append("				V.INV_CURR_CD" ).append("\n"); 
		query.append("		ELSE " ).append("\n"); 
		query.append("			'' " ).append("\n"); 
		query.append("		END UNCOLL_CURR_CD" ).append("\n"); 
		query.append("       ,C.CORR_RMK" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  DMT_CHG_CALC        C" ).append("\n"); 
		query.append("       ,DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("       ,DMT_INV_MN          V" ).append("\n"); 
		query.append("       ,DMT_INV_DTL         ID" ).append("\n"); 
		query.append("       ,DMT_HRD_CDG_CTNT    HRD" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (1=0" ).append("\n"); 
		query.append("	          OR ( C.DMDT_CHG_STS_CD IN ( 'F'," ).append("\n"); 
		query.append("	                  'C'," ).append("\n"); 
		query.append("	                  'I' )" ).append("\n"); 
		query.append("	              AND ( C.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') AND TO_DATE(@[end_dt], 'YYYYMMDD') + 0.99999 ) )" ).append("\n"); 
		query.append("	          OR ( C.DMDT_CHG_STS_CD IN ( 'L'," ).append("\n"); 
		query.append("	                  'U' )" ).append("\n"); 
		query.append("	              AND ( C.FM_MVMT_DT BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') AND TO_DATE(@[end_dt], 'YYYYMMDD') + 0.99999 ) ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 조건추가(S) 2013.10.23" ).append("\n"); 
		query.append("#if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("AND    NVL(C.UCLM_FLG, 'N') =  @[uclm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 조건추가(E)" ).append("\n"); 
		query.append("#if(${sts_cd_list} != '')" ).append("\n"); 
		query.append("AND		 C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("               #foreach( $sts_cd in ${sts_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $sts_cd_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("	#if (${dtl_flg} == 'B') " ).append("\n"); 
		query.append("AND     C.DMDT_CHG_STS_CD     IN     ( 'F' ,'C', 'I' )" ).append("\n"); 
		query.append("	#elseif (${dtl_flg} == 'C') " ).append("\n"); 
		query.append("AND     C.DMDT_CHG_STS_CD = 'I'" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("AND     C.DMDT_CHG_STS_CD     IN     ( 'F' ,'C', 'I', 'N')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${grp_flg} == 'R') " ).append("\n"); 
		query.append("AND     C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     C.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trf_cd_list} != '')" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("     #if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND      B.SYS_AREA_GRP_ID   = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND      B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND      B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND      C.DMDT_INV_NO       = V.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND      V.DMDT_INV_NO       = ID.DMDT_INV_NO(+)          -- 20091222 수정" ).append("\n"); 
		query.append("AND      C.DMDT_CHG_LOC_DIV_CD <> 'SZP'               -- 2010/03/18 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- CUR.TTL Detail 조회를 위해 추가 (2016.08.10)" ).append("\n"); 
		query.append("#if (${bzc_trf_curr_cd} != '')" ).append("\n"); 
		query.append("AND 	 C.BZC_TRF_CURR_CD = @[bzc_trf_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("    OR        " ).append("\n"); 
		query.append("    (C.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("         (C.DMDT_CHG_STS_CD <> 'I')" ).append("\n"); 
		query.append("         OR" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                        C.DMDT_CHG_STS_CD   =     'I'" ).append("\n"); 
		query.append("                AND     V.DMDT_INV_STS_CD     = 'I'" ).append("\n"); 
		query.append("                AND     V.DMDT_AR_IF_CD       <> 'H'" ).append("\n"); 
		query.append("                AND     C.SYS_AREA_GRP_ID     = ID.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND     C.CNTR_NO             = ID.CNTR_NO" ).append("\n"); 
		query.append("                AND     C.CNTR_CYC_NO         = ID.CNTR_CYC_NO" ).append("\n"); 
		query.append("                AND     C.DMDT_TRF_CD         = ID.DMDT_TRF_CD" ).append("\n"); 
		query.append("                AND     C.DMDT_CHG_LOC_DIV_CD = ID.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                AND     C.CHG_SEQ             = ID.CHG_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${dmdt_cntr_tp_cd} != 'A')" ).append("\n"); 
		query.append("AND    B.DMDT_CNTR_TP_CD     IN (" ).append("\n"); 
		query.append("               #foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("                    #if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("                          'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("                    #elseif ($cntr_tp == 'D' || $cntr_tp == 'R') " ).append("\n"); 
		query.append("                         '$cntr_tp'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     ( NVL(C.ORG_CHG_AMT, 0) > 0 OR NVL(C.BIL_AMT, 0) > 0 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dtl_flg} != '')" ).append("\n"); 
		query.append("     #if (${dtl_flg} != 'A')     " ).append("\n"); 
		query.append("AND     C.BIL_AMT > 0" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("AND     V.DMDT_AR_IF_CD(+) = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  HRD.HRD_CDG_ID(+) = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("   AND  HRD.ATTR_CTNT1(+) = V.CRE_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.OFC_CD" ).append("\n"); 
		query.append("        ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("        ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        ,V.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("        ,C.CNTR_NO" ).append("\n"); 

	}
}