/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(OFC_CD, NULL, 1, 2)  	AS NULL_FLG    -- OFC 가 NULL 인 RHQ 공통 설정을 먼저 표시하기 위한 정렬용 FLAG" ).append("\n"); 
		query.append("       ,RHQ_CD" ).append("\n"); 
		query.append("	   ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') 	AS EFF_DT" ).append("\n"); 
		query.append("	   ,FM_DC_AMT" ).append("\n"); 
		query.append("	   ,AFT_BKG_PATH_STUP_SEQ" ).append("\n"); 
		query.append("	   ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') 	AS EXP_DT" ).append("\n"); 
		query.append("	   ,TO_DC_AMT" ).append("\n"); 
		query.append("	   ,OFC_CD" ).append("\n"); 
		query.append("	   ,BRNC_OFC_PIC_CHK_FLG" ).append("\n"); 
		query.append("	   ,BRNC_OFC_OP_MGR_APRO_FLG" ).append("\n"); 
		query.append("	   ,BRNC_OFC_MGR_APRO_FLG" ).append("\n"); 
		query.append("	   ,RHQ_PIC_CHK_FLG" ).append("\n"); 
		query.append("	   ,RHQ_MGR_APRO_FLG" ).append("\n"); 
		query.append("	   ,HO_PIC_CHK_FLG" ).append("\n"); 
		query.append("	   ,HO_MGR_APRO_FLG" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  FROM  DMT_AFT_BKG_PATH_OFC_STUP" ).append("\n"); 
		query.append(" WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND  RHQ_CD   = @[rhq_cd]" ).append("\n"); 
		query.append("   AND  (OFC_CD IS NULL " ).append("\n"); 
		query.append("			OR OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $aft_bkg_ofc_cd in ${aft_bkg_ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $aft_bkg_ofc_cd_list.size()) '$aft_bkg_ofc_cd', #else '$aft_bkg_ofc_cd' #end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   #if (${crnt_flg} == 'Y')" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("		(TO_CHAR(EFF_DT, 'YYYYMMDD') <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND (EXP_DT IS NULL OR TO_CHAR(EXP_DT, 'YYYYMMDD') >= TO_CHAR(SYSDATE, 'YYYYMMDD')))" ).append("\n"); 
		query.append("		#if (${tobe_flg} == 'Y')" ).append("\n"); 
		query.append("		OR TO_CHAR(EFF_DT, 'YYYYMMDD') > TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("			#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		OR (EXP_DT IS NOT NULL AND TO_CHAR(EXP_DT, 'YYYYMMDD') < TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		OR (EXP_DT IS NOT NULL AND TO_CHAR(EXP_DT, 'YYYYMMDD') < TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND  (		" ).append("\n"); 
		query.append("		#if (${tobe_flg} == 'Y')" ).append("\n"); 
		query.append("		TO_CHAR(EFF_DT, 'YYYYMMDD') > TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("			#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		OR (EXP_DT IS NOT NULL AND TO_CHAR(EXP_DT, 'YYYYMMDD') < TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		(EXP_DT IS NOT NULL AND TO_CHAR(EXP_DT, 'YYYYMMDD') < TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("		1=0" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("ORDER BY NULL_FLG, OFC_CD, EFF_DT, TO_DC_AMT, FM_DC_AMT" ).append("\n"); 

	}
}