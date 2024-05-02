/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
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

public class ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL").append("\n"); 
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
		query.append("SELECT  T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.EFF_DT, 'YYYY-MM-DD')						AS EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.EXP_DT, 'YYYY-MM-DD')						AS EXP_DT" ).append("\n"); 
		query.append("       ,T1.CHG_DELT_RHQ_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  WM_CONCAT(CHG_DELT_OFC_CD)" ).append("\n"); 
		query.append("              FROM  DMT_CHG_DELT_OFC_STUP" ).append("\n"); 
		query.append("             WHERE  CHG_DELT_PATH_STUP_SEQ = T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("        )														AS CHG_DELT_OFC_CD " ).append("\n"); 
		query.append("	   ,DECODE(T1.DMDT_BRNC_OFC_OP_MGR_FLG, 'Y', '1', 'N', '0')	AS DMDT_BRNC_OFC_OP_MGR_FLG" ).append("\n"); 
		query.append("       ,DECODE(T1.DMDT_BRNC_FLG,            'Y', '1', 'N', '0') AS DMDT_BRNC_FLG" ).append("\n"); 
		query.append("       ,DECODE(T1.DMDT_RHQ_FLG,             'Y', '1', 'N', '0') AS DMDT_RHQ_FLG" ).append("\n"); 
		query.append("       ,DECODE(T1.DMDT_HO_FLG,              'Y', '1', 'N', '0') AS DMDT_HO_FLG" ).append("\n"); 
		query.append("       ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD')						AS CRE_DT" ).append("\n"); 
		query.append("       ,T1.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD')						AS UPD_DT" ).append("\n"); 
		query.append("       ,T1.UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append(" WHERE  EXISTS" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  1" ).append("\n"); 
		query.append("              FROM  DMT_CHG_DELT_OFC_STUP" ).append("\n"); 
		query.append("             WHERE  CHG_DELT_PATH_STUP_SEQ = T1.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("               AND  CHG_DELT_OFC_CD IN" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#foreach( $chg_delt_ofc_cd in ${chg_delt_ofc_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $chg_delt_ofc_cd_list.size()) '$chg_delt_ofc_cd', #else '$chg_delt_ofc_cd' #end" ).append("\n"); 
		query.append("						#end	" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if (${crnt_flg} == 'Y')" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("		--// 현재 데이터" ).append("\n"); 
		query.append("		(T1.EFF_DT <= SYSDATE AND (T1.EXP_DT is null or T1.EXP_DT >= SYSDATE))" ).append("\n"); 
		query.append("	#if (${tobe_flg} == 'Y')" ).append("\n"); 
		query.append("		--// 미래 데이터" ).append("\n"); 
		query.append("		or (T1.EFF_DT > to_date(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') + 0.99999 AND (T1.EXP_DT is null or T1.EXP_DT >= to_date(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')))" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		--// 종료 데이터" ).append("\n"); 
		query.append("		or (T1.EXP_DT <= SYSDATE)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		or (T1.EXP_DT <= SYSDATE)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("	#if (${tobe_flg} == 'Y')" ).append("\n"); 
		query.append("		--// 미래 데이터" ).append("\n"); 
		query.append("		(T1.EFF_DT > to_date(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') + 0.99999 AND (T1.EXP_DT is null or T1.EXP_DT >= to_date(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')))" ).append("\n"); 
		query.append("		#if (${exp_flg} == 'Y')" ).append("\n"); 
		query.append("		--// 종료 데이터" ).append("\n"); 
		query.append("		or (T1.EXP_DT <= SYSDATE)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		--// 종료 데이터" ).append("\n"); 
		query.append("		(T1.EXP_DT <= SYSDATE)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}