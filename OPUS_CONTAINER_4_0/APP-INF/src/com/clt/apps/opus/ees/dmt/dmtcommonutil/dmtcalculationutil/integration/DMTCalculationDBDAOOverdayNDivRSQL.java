/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCalculationDBDAOOverdayNDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOOverdayNDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OverdayNDiv
	  * </pre>
	  */
	public DMTCalculationDBDAOOverdayNDivRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOOverdayNDivRSQL").append("\n"); 
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
		query.append("#if (${type} == 'EXIST_CHECK') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CHG_SEQ RTN_VAL" ).append("\n"); 
		query.append("  FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("  WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   AND DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("   AND DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("   AND CHG_SEQ = @[dcc_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${type} == 'EXIST') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUM(FX_FT_OVR_DYS) RTN_VAL" ).append("\n"); 
		query.append("  FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("  WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   AND DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("   AND DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("   AND CHG_SEQ < @[dcc_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${type} == 'NOT_EXIST') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUM(FX_FT_OVR_DYS) RTN_VAL" ).append("\n"); 
		query.append("  FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("  WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   AND DMDT_TRF_CD = @[dtt_code]" ).append("\n"); 
		query.append("   AND DMDT_CHG_LOC_DIV_CD = @[loc_div]" ).append("\n"); 
		query.append("   AND CHG_SEQ <= @[dcc_seq]   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}