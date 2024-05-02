/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchBSRLaneComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBSRLaneComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Base Data 에서 Lane Adjust 화면에서 Lane Combo list 를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOSearchBSRLaneComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bseQtrCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaMdlVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subTrde",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBSRLaneComboListRSQL").append("\n"); 
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
		query.append("SELECT T1.TRD_CD " ).append("\n"); 
		query.append("     , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("     , T1.RLANE_CD " ).append("\n"); 
		query.append("     , T3.RLANE_NM " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , IOC_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("            , RLANE_CD AS ORG_RLANE_CD " ).append("\n"); 
		query.append("         FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND MQTA_MDL_VER_NO = @[mqtaMdlVerNo] " ).append("\n"); 
		query.append("			  #if(${trade} != '') " ).append("\n"); 
		query.append("              AND TRD_CD = @[trade] " ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if(${subTrde} != '') " ).append("\n"); 
		query.append("              AND SUB_TRD_CD = @[subTrde] " ).append("\n"); 
		query.append("              #end       " ).append("\n"); 
		query.append("              AND (FCAST_TRNS_STS_CD = '0' OR FCAST_TRNS_STS_CD IS NULL) " ).append("\n"); 
		query.append("        GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , IOC_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("       ) T1 " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT BSE_YR " ).append("\n"); 
		query.append("            , BSE_QTR_CD " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("         FROM SAQ_MON_TGT_VVD " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("              AND BSE_YR = @[year] " ).append("\n"); 
		query.append("              AND BSE_QTR_CD = @[bseQtrCd] " ).append("\n"); 
		query.append("              #if(${trade} != '') " ).append("\n"); 
		query.append("              AND TRD_CD = @[trade] " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("			  #if(${subTrde} != '') " ).append("\n"); 
		query.append("              AND SUB_TRD_CD = @[subTrde] " ).append("\n"); 
		query.append("              #end   " ).append("\n"); 
		query.append("        GROUP BY BSE_YR " ).append("\n"); 
		query.append("            , BSE_QTR_CD " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("       ) T2 " ).append("\n"); 
		query.append("     , MDM_REV_LANE T3 " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND T1.MQTA_MDL_VER_NO = SUBSTR(T2.BSE_YR, 3,2)||BSE_QTR_CD||'01' " ).append("\n"); 
		query.append("       AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("       AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("       AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("       AND T1.RLANE_CD = T3.RLANE_CD" ).append("\n"); 

	}
}