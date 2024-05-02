/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOModifySlsRgnSaqMonQtaStePVerStatus0156USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentSlsRHQDBDAOModifySlsRgnSaqMonQtaStePVerStatus0156USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STEP 04 mqtaVerNo에 관련된 STEP 05 의 상태 변경
	  * 2011.02.17 GLOBALDATE_PKG.TIME_CONV_OFC_FNC 수정
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOModifySlsRgnSaqMonQtaStePVerStatus0156USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saq_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("statusCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOModifySlsRgnSaqMonQtaStePVerStatus0156USQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_QTA_STEP_VER" ).append("\n"); 
		query.append("SET SAQ_STS_CD = @[statusCd]," ).append("\n"); 
		query.append("    UPD_USR_ID = @[userId]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${newSaqStsCd} == 'DC' || ${newSaqStsCd} == 'DN') " ).append("\n"); 
		query.append("	,DRFT_CFM_GDT  = GLOBALDATE_PKG.TIME_CONV_OFC_FNC( COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC() ,SYSDATE, 'GMT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${newSaqStsCd} == 'FC' || ${newSaqStsCd} == 'FN') " ).append("\n"); 
		query.append("	,FNL_CFM_GDT  = GLOBALDATE_PKG.TIME_CONV_OFC_FNC( COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC() ,SYSDATE, 'GMT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  MQTA_STEP_CD = '09'" ).append("\n"); 
		query.append("AND    BSE_YR = @[year]" ).append("\n"); 
		query.append("AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND    TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND    DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND    GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("AND    SAQ_STS_CD = @[saq_sts_cd]" ).append("\n"); 
		query.append("AND    CRE_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT DISTINCT SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_LOD_TGT" ).append("\n"); 
		query.append("    WHERE  MQTA_STEP_CD = '08'" ).append("\n"); 
		query.append("    AND    BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND    TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    DIR_CD = @[bound]" ).append("\n"); 
		query.append("    AND    MQTA_VER_NO = @[mQtaVerNo] )" ).append("\n"); 

	}
}