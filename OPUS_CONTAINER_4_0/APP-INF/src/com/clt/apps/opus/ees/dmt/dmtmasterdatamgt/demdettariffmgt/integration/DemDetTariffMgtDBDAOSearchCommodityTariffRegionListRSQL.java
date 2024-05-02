/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchCommodityTariffRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchCommodityTariffRegionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Exception Tariff Inquiry
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchCommodityTariffRegionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchCommodityTariffRegionListRSQL").append("\n"); 
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
		query.append("	A.CFM_FLG" ).append("\n"); 
		query.append("	, A.DMDT_TRF_CD" ).append("\n"); 
		query.append("	, CASE WHEN TRIM(A.CVRG_YD_CD) IS NULL THEN " ).append("\n"); 
		query.append("		(CASE WHEN TRIM(A.CVRG_LOC_CD) IS NULL THEN" ).append("\n"); 
		query.append("			(CASE WHEN TRIM(A.CVRG_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("				(CASE WHEN TRIM(A.CVRG_RGN_CD) IS NULL THEN A.CVRG_CNT_CD ELSE A.CVRG_RGN_CD END)" ).append("\n"); 
		query.append("			ELSE A.CVRG_STE_CD" ).append("\n"); 
		query.append("			END)" ).append("\n"); 
		query.append("		ELSE A.CVRG_LOC_CD" ).append("\n"); 
		query.append("		END)" ).append("\n"); 
		query.append("	ELSE A.CVRG_YD_CD" ).append("\n"); 
		query.append("	END COVRG" ).append("\n"); 
		query.append("	, CASE WHEN TRIM(A.ORG_DEST_LOC_CD) IS NULL THEN " ).append("\n"); 
		query.append("		(CASE WHEN TRIM(A.ORG_DEST_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("			(CASE WHEN TRIM(A.ORG_DEST_RGN_CD) IS NULL THEN " ).append("\n"); 
		query.append("				(CASE WHEN TRIM(A.ORG_DEST_CNT_CD) IS NULL THEN A.ORG_DEST_CONTI_CD ELSE A.ORG_DEST_CNT_CD END)" ).append("\n"); 
		query.append("			ELSE A.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("			END)" ).append("\n"); 
		query.append("		ELSE A.ORG_DEST_STE_CD" ).append("\n"); 
		query.append("		END)" ).append("\n"); 
		query.append("	ELSE A.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("	END ORG_DEST" ).append("\n"); 
		query.append("	, B.CMDT_CD" ).append("\n"); 
		query.append("	, C.CMDT_NM" ).append("\n"); 
		query.append("	, C.REP_CMDT_CD" ).append("\n"); 
		query.append("	, TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("	, TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("	, B.CMDT_ADD_DYS" ).append("\n"); 
		query.append("	, B.CMDT_TTL_DYS" ).append("\n"); 
		query.append("	, B.XCLD_SAT_FLG" ).append("\n"); 
		query.append("	, B.XCLD_SUN_FLG" ).append("\n"); 
		query.append("	, B.XCLD_HOL_FLG" ).append("\n"); 
		query.append("	, TO_CHAR(B.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("	, B.UPD_OFC_CD AS UPD_OFC_CD" ).append("\n"); 
		query.append("	, (SELECT USR_NM FROM COM_USER WHERE USR_ID = B.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append("	, CASE WHEN TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("      	ELSE 'N'" ).append("\n"); 
		query.append("		END EXPIRE_CHK" ).append("\n"); 
		query.append("	,CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'TF' THEN 'THU'" ).append("\n"); 
		query.append("          WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'FS' THEN 'FRI'" ).append("\n"); 
		query.append("          ELSE 'SAT'" ).append("\n"); 
		query.append("          END WKND1" ).append("\n"); 
		query.append("	,CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'TF' THEN 'FRI'" ).append("\n"); 
		query.append("          WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'FS' THEN 'SAT'" ).append("\n"); 
		query.append("          ELSE 'SUN'" ).append("\n"); 
		query.append("          END WKND2" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN A, DMT_CMDT_GRP B, MDM_COMMODITY C" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.TRF_SEQ = B.TRF_SEQ" ).append("\n"); 
		query.append("AND B.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cvrg_conti_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_cnt_cd} == 'US' || ${cvrg_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("	#if (${cvrg_ste_cd} != '')" ).append("\n"); 
		query.append("	AND A.CVRG_STE_CD = @[cvrg_ste_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("	AND A.CVRG_RGN_CD = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_LOC_CD = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_conti_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CNT_CD = @[org_dest_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_cnt_cd} == 'US' || ${org_dest_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("	#if (${org_dest_ste_cd} != '')" ).append("\n"); 
		query.append("	AND A.ORG_DEST_STE_CD = @[org_dest_ste_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("	AND A.ORG_DEST_RGN_CD = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_loc_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_LOC_CD = @[org_dest_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cfm_flg} != '')" ).append("\n"); 
		query.append("AND A.CFM_FLG = @[cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_trf_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_trf_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${validity1} != '')" ).append("\n"); 
		query.append("AND ( TO_CHAR(EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("      AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		OR (TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("            AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("        #if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        #if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("    #if (${validity2} != '')" ).append("\n"); 
		query.append("		TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("        AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("		#if (${validity3} != '')" ).append("\n"); 
		query.append("			OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.DMDT_TRF_CD, LENGTH(COVRG),COVRG, LENGTH(ORG_DEST), ORG_DEST, B.CMDT_CD, B.EFF_DT, B.EXP_DT" ).append("\n"); 

	}
}