/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOValidateAmountAftBkgPathRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.13 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOValidateAmountAftBkgPathRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOValidateAmountAftBkgPath
	  * </pre>
	  */
	public ChargeCalculationDBDAOValidateAmountAftBkgPathRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOValidateAmountAftBkgPathRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(AMT_FLG), 'N') AMT_FLG" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	SELECT 'E' AMT_FLG FROM DMT_AFT_BKG_PATH_OFC_STUP" ).append("\n"); 
		query.append("	WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND NVL(OFC_CD,'A') = NVL(@[ofc_cd], 'A')" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("        TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('99991231','YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("        OR NVL(TO_DATE(@[exp_dt], 'YYYYMMDD'), TO_DATE('99991231','YYYYMMDD')) + 0.99999 BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('99991231','YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	AND NVL(TO_NUMBER(@[fm_dc_amt]), -999999999999) BETWEEN NVL(FM_DC_AMT, -999999999999) AND NVL(TO_DC_AMT, 999999999999)" ).append("\n"); 
		query.append("#if(${ibflag}=='U' && ${update_seq_list} != '')" ).append("\n"); 
		query.append("	AND AFT_BKG_PATH_STUP_SEQ NOT IN(" ).append("\n"); 
		query.append("	#foreach( $update_seq in ${update_seq_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $update_seq_list.size()) '$update_seq', #else '$update_seq' #end" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'E' AMT_FLG FROM DMT_AFT_BKG_PATH_OFC_STUP" ).append("\n"); 
		query.append("	WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND NVL(OFC_CD,'A') = NVL(@[ofc_cd], 'A')" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("        TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('99991231','YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("        OR NVL(TO_DATE(@[exp_dt], 'YYYYMMDD'), TO_DATE('99991231','YYYYMMDD')) + 0.99999 BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('99991231','YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	AND NVL(TO_NUMBER(@[to_dc_amt]), 999999999999) BETWEEN NVL(FM_DC_AMT, -999999999999) AND NVL(TO_DC_AMT, 999999999999)" ).append("\n"); 
		query.append("#if(${ibflag}=='U' && ${update_seq_list} != '')" ).append("\n"); 
		query.append("	AND AFT_BKG_PATH_STUP_SEQ NOT IN(" ).append("\n"); 
		query.append("	#foreach( $update_seq in ${update_seq_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $update_seq_list.size()) '$update_seq', #else '$update_seq' #end" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}