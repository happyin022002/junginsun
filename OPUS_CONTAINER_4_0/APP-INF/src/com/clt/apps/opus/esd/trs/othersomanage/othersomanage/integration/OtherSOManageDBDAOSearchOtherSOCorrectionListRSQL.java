/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OtherSOManageDBDAOSearchOtherSOCorrectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.06.11 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchOtherSOCorrectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Other Correction 목록 조회
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchOtherSOCorrectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_cost_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOSearchOtherSOCorrectionListRSQL").append("\n"); 
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
		query.append("    A.EQ_NO	eq_no," ).append("\n"); 
		query.append("    A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("    A.FM_NOD_CD," ).append("\n"); 
		query.append("    SUBSTR(A.FM_NOD_CD, 1, 5) FM_LOC_VALUE," ).append("\n"); 
		query.append("    SUBSTR(A.FM_NOD_CD, 6, 2) FM_YARD_VALUE," ).append("\n"); 
		query.append("    A.VIA_NOD_CD," ).append("\n"); 
		query.append("    SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC_VALUE," ).append("\n"); 
		query.append("    SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD_VALUE," ).append("\n"); 
		query.append("    A.TO_NOD_CD," ).append("\n"); 
		query.append("    SUBSTR(A.TO_NOD_CD, 1, 5) TO_LOC_VALUE," ).append("\n"); 
		query.append("    SUBSTR(A.TO_NOD_CD, 6, 2) TO_YARD_VALUE," ).append("\n"); 
		query.append("    A.DOR_NOD_CD," ).append("\n"); 
		query.append("    SUBSTR(A.DOR_NOD_CD, 1, 5) DR_LOC_VALUE," ).append("\n"); 
		query.append("    SUBSTR(A.DOR_NOD_CD, 6, 2) DR_YARD_VALUE," ).append("\n"); 
		query.append("    A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("    A.DOR_DE_ADDR," ).append("\n"); 
		query.append("    A.VNDR_SEQ," ).append("\n"); 
		query.append("    B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("    A.CURR_CD," ).append("\n"); 
		query.append("    A.BZC_AMT," ).append("\n"); 
		query.append("    A.NEGO_AMT," ).append("\n"); 
		query.append("    A.FUEL_SCG_AMT," ).append("\n"); 
		query.append("    A.ETC_ADD_AMT," ).append("\n"); 
		query.append("    A.REF_BKG_NO," ).append("\n"); 
		query.append("    A.REF_BL_NO," ).append("\n"); 
		query.append("    A.TRSP_PURP_RSN," ).append("\n"); 
		query.append("    A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("    A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("    A.TRSP_SO_TP_CD," ).append("\n"); 
		query.append("    A.TRSP_SO_STS_CD," ).append("\n"); 
		query.append("    A.EQ_KND_CD," ).append("\n"); 
		query.append("    A.CGO_TP_CD," ).append("\n"); 
		query.append("    A.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    A.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("    A.CRE_OFC_CD," ).append("\n"); 
		query.append("    TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("    A.CRE_USR_ID," ).append("\n"); 
		query.append("    TO_CHAR(A.LOCL_UPD_DT, 'YYYYMMDD') UPD_DT," ).append("\n"); 
		query.append("    A.UPD_USR_ID," ).append("\n"); 
		query.append("	DECODE((SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("		   FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("		  WHERE 1=1" ).append("\n"); 
		query.append("            AND A.TRSP_SO_OFC_CTY_CD = RMK.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("            AND A.TRSP_SO_SEQ = RMK.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("			AND NVL(RMK.DELT_FLG, 'X') = 'N'), '', '', 'Y') INTER_RMK" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A," ).append("\n"); 
		query.append("     MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.TRSP_SO_STS_CD IN ('C','R') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	#if(${fmdate} != '')" ).append("\n"); 
		query.append("       	AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${trs_cost_md_cd} != '')" ).append("\n"); 
		query.append("    	AND A.TRSP_COST_DTL_MOD_CD = @[trs_cost_md_cd]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${trs_md_cd} != '')" ).append("\n"); 
		query.append("		AND A.TRSP_CRR_MOD_CD = @[trs_md_cd]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${trsp_so_fm_node} != '')" ).append("\n"); 
		query.append("    	AND A.FM_NOD_CD = @[trsp_so_fm_node]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${trsp_so_to_node} != '')" ).append("\n"); 
		query.append("    	AND A.TO_NOD_CD = @[trsp_so_to_node]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if($eqnumberArr.size() > 0)" ).append("\n"); 
		query.append("  	   	AND A.EQ_NO IN (" ).append("\n"); 
		query.append("	   		#foreach( ${key} in ${eqnumberArr}) " ).append("\n"); 
		query.append("	      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 		    		'${key}'	" ).append("\n"); 
		query.append("	      		#else " ).append("\n"); 
		query.append(" 		    		, '${key}'	" ).append("\n"); 
		query.append("	      		#end " ).append("\n"); 
		query.append("	   		#end " ).append("\n"); 
		query.append("	   	)" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	#if(${trsp_so_tp_cd} != '')" ).append("\n"); 
		query.append("   		AND A.TRSP_SO_TP_CD = @[trsp_so_tp_cd]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.EQ_NO" ).append("\n"); 

	}
}