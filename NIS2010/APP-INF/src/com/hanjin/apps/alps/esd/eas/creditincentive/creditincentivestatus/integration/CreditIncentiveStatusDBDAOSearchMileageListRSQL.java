/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchMileageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.16 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchMileageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Mileage
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchMileageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchMileageListRSQL").append("\n"); 
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
		query.append("SELECT A.BSE_YR" ).append("\n"); 
		query.append("      ,A.INCNT_NO" ).append("\n"); 
		query.append("      ,A.RHQ_CD" ).append("\n"); 
		query.append("      ,A.TEAM_NM" ).append("\n"); 
		query.append("      ,A.BANK_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(A.MLG_FM_DT,'YYYYMMDD') MLG_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.MLG_TO_DT,'YYYYMMDD') MLG_TO_DT" ).append("\n"); 
		query.append("      ,A.PAY_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.MLG_ISS_DT,'YYYYMMDD') MLG_ISS_DT" ).append("\n"); 
		query.append("      ,A.MLG_PNT_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CSH_BAK_DT,'YYYYMMDD') CSH_BAK_DT" ).append("\n"); 
		query.append("      ,A.CSH_BAK_AMT" ).append("\n"); 
		query.append("      ,SUM(SUM(A.MLG_PNT_AMT)-SUM(A.CSH_BAK_AMT)) OVER (ORDER BY A.BSE_YR,A.INCNT_NO) CSH_BAK_BAL_AMT" ).append("\n"); 
		query.append("      ,A.INCNT_RMK" ).append("\n"); 
		query.append("      ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y') ATCH_FLG" ).append("\n"); 
		query.append("      ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("	  ,DECODE(A.ATCH_N2ND_FILE_LNK_ID,'','N','Y') ATCH2_FLG" ).append("\n"); 
		query.append("	  ,A.ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM EAS_BNF_MLG A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_fm_dt} !='' && ${s_to_dt} !='')" ).append("\n"); 
		query.append("   AND A.MLG_ISS_DT BETWEEN TO_DATE(@[s_fm_dt],'YYYYMMDD') AND TO_DATE(@[s_to_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.BSE_YR" ).append("\n"); 
		query.append("	    ,A.INCNT_NO" ).append("\n"); 
		query.append("        ,A.RHQ_CD" ).append("\n"); 
		query.append("        ,A.TEAM_NM" ).append("\n"); 
		query.append("        ,A.BANK_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(A.MLG_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ,TO_CHAR(A.MLG_TO_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ,A.PAY_AMT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.MLG_ISS_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ,A.MLG_PNT_AMT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CSH_BAK_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        ,A.CSH_BAK_AMT" ).append("\n"); 
		query.append("        ,A.INCNT_RMK" ).append("\n"); 
		query.append("        ,DECODE(A.ATCH_FILE_LNK_ID,'','N','Y')" ).append("\n"); 
		query.append("        ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("	    ,DECODE(A.ATCH_N2ND_FILE_LNK_ID,'','N','Y')" ).append("\n"); 
		query.append("	    ,A.ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("        ,A.DELT_FLG" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,A.CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.UPD_DT" ).append("\n"); 
		query.append("ORDER BY A.BSE_YR" ).append("\n"); 
		query.append("        ,A.INCNT_NO" ).append("\n"); 

	}
}