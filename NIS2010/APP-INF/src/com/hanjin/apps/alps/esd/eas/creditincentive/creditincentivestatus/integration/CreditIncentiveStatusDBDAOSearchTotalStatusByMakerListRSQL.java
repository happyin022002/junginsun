/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOSearchTotalStatusByMakerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.12 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOSearchTotalStatusByMakerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tota lStatus By Maker PopUp화면 조회
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOSearchTotalStatusByMakerListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_mkr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cr_usd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOSearchTotalStatusByMakerListRSQL").append("\n"); 
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
		query.append("SELECT X.MKR_CD" ).append("\n"); 
		query.append("      ,(SELECT Y.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL Y WHERE Y.INTG_CD_ID = 'CD03516' AND Y.INTG_CD_VAL_CTNT = X.MKR_CD) MKR_NM" ).append("\n"); 
		query.append("      ,NVL(SUM(X.CR_ISS_AMT),0) CR_ISS_AMT" ).append("\n"); 
		query.append("      ,NVL(SUM(X.CR_USD_AMT),0) CR_USD_AMT" ).append("\n"); 
		query.append("      ,NVL(SUM(X.CR_ISS_AMT),0) - NVL(SUM(X.CR_USD_AMT),0) CR_BAL_AMT" ).append("\n"); 
		query.append("  FROM (SELECT A.MKR_CD" ).append("\n"); 
		query.append("              ,A.CR_ISS_NO" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.CR_ISS_TTL_AMT,0)) CR_ISS_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,SUM(B.CR_USD_AMT)) CR_USD_AMT" ).append("\n"); 
		query.append("          FROM EAS_MNR_CR_ISS A" ).append("\n"); 
		query.append("              ,EAS_MNR_CR_USD B " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.CR_ISS_NO = B.CR_ISS_NO(+)" ).append("\n"); 
		query.append("           AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND 'N'= B.DELT_FLG(+) " ).append("\n"); 
		query.append("#if (${s_fm_dt} !='' && ${s_to_dt} !='')" ).append("\n"); 
		query.append("           AND A.CR_ISS_DT BETWEEN TO_DATE(@[s_fm_dt],'YYYYMMDD') AND TO_DATE(@[s_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_mkr_cd} !='')" ).append("\n"); 
		query.append("           AND A.MKR_CD = @[s_mkr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cr_usd_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND B.CR_USD_OFC_CD = @[s_cr_usd_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY A.CR_ISS_NO" ).append("\n"); 
		query.append("                 ,A.MKR_CD" ).append("\n"); 
		query.append("                 ,A.CURR_CD" ).append("\n"); 
		query.append("                 ,NVL(A.CR_ISS_TTL_AMT,0)" ).append("\n"); 
		query.append("      ) X" ).append("\n"); 
		query.append(" GROUP BY X.MKR_CD" ).append("\n"); 

	}
}