/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchCntrKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchCntrKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrKey
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchCntrKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchCntrKeyRSQL").append("\n"); 
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
		query.append("SELECT FM_MVMT_YR" ).append("\n"); 
		query.append("       , FM_MVMT_SEQ" ).append("\n"); 
		query.append("       , FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("        SELECT FM_MVMT_YR" ).append("\n"); 
		query.append("               , FM_MVMT_SEQ" ).append("\n"); 
		query.append("               , FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("          FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("         WHERE (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("                SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO" ).append("\n"); 
		query.append("                  FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("                 WHERE BKG_NO IN (@[bkg_no])" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND FM_MVMT_STS_CD = @[fm_mvmt_sts_cd]" ).append("\n"); 
		query.append("            AND FM_MVMT_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("            AND TO_CHAR(FM_MVMT_DT, 'YYYYMMDD') = substr(@[fm_mvmt_dt], 1, 8)" ).append("\n"); 
		query.append("          UNION" ).append("\n"); 
		query.append("         SELECT CNMV_YR AS FM_MVMT_YR" ).append("\n"); 
		query.append("                , CNMV_SEQ AS FM_MVMT_SEQ" ).append("\n"); 
		query.append("                , CNMV_SPLIT_NO AS FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND MVMT_STS_CD = @[fm_mvmt_sts_cd]" ).append("\n"); 
		query.append("            AND ORG_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("            AND TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDD') = substr(@[fm_mvmt_dt], 1, 8)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ROWNUM = 1 " ).append("\n"); 

	}
}