/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchFoodQualityDetailKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchFoodQualityDetailKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Food Quality Detail Key
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchFoodQualityDetailKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("division",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("component",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("damage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repair",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchFoodQualityDetailKeyRSQL").append("\n"); 
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
		query.append("SELECT MRD.RQST_EQ_NO," ).append("\n"); 
		query.append("       MRD.RPR_RQST_SEQ," ).append("\n"); 
		query.append("       MRD.RPR_RQST_VER_NO," ).append("\n"); 
		query.append("       MRD.RPR_RQST_DTL_SEQ AS SEQ," ).append("\n"); 
		query.append("       MRH.MNR_ORD_OFC_CTY_CD || MRH.MNR_ORD_SEQ AS WO_NO," ).append("\n"); 
		query.append("       MRV.LESSOR_NM AS Service_Provider_name," ).append("\n"); 
		query.append("       MRD.RQST_EQ_NO AS Container_No," ).append("\n"); 
		query.append("       MRH.EQ_TPSZ_CD AS TP_SZ," ).append("\n"); 
		query.append("       MRV.LSTM_CD AS Term," ).append("\n"); 
		query.append("       MRV.RCC_CD AS RCC," ).append("\n"); 
		query.append("       MRV.LCC_CD AS LCC," ).append("\n"); 
		query.append("       MRV.SCC_CD AS SCC," ).append("\n"); 
		query.append("       MRV.CRNT_YD_CD AS Yard," ).append("\n"); 
		query.append("       MRD.EQ_LOC_CD AS Location," ).append("\n"); 
		query.append("       MRD.EQ_CMPO_CD AS Component," ).append("\n"); 
		query.append("       MRD.EQ_DMG_CD AS Damage," ).append("\n"); 
		query.append("       MRD.EQ_RPR_CD AS Repair," ).append("\n"); 
		query.append("       MRD.TRF_DIV_CD AS Division," ).append("\n"); 
		query.append("       DECODE (MRD.VOL_TP_CD,  'Q', 'Qty',  'Z', 'Square',  'Size')" ).append("\n"); 
		query.append("          AS Mrd_Type," ).append("\n"); 
		query.append("       MRD.RPR_QTY AS Mrd_Qty," ).append("\n"); 
		query.append("       MRD.RPR_SZ_NO AS Mrd_Size_Square," ).append("\n"); 
		query.append("       MRD.RPR_LBR_HRS AS Mrd_Hour," ).append("\n"); 
		query.append("       MRD.RPR_LBR_RT AS Rate," ).append("\n"); 
		query.append("       MRD.LBR_COST_AMT AS Mrd_Cost," ).append("\n"); 
		query.append("       MRD.MTRL_COST_AMT AS Material," ).append("\n"); 
		query.append("       MRD.MNR_WRK_AMT AS Mrd_Amount," ).append("\n"); 
		query.append("       MRD.MNR_VRFY_TP_CD AS mnr_vrfy_tp_cd" ).append("\n"); 
		query.append("  FROM MNR_RPR_RQST_DTL MRD," ).append("\n"); 
		query.append("       MNR_RPR_RQST_HDR MRH," ).append("\n"); 
		query.append("       MNR_EQ_STS_V MRV," ).append("\n"); 
		query.append("       (SELECT /*+ LEADING(MOH) */ MRRD.RQST_EQ_NO, MRRD.RPR_RQST_SEQ, MRRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("          FROM MNR_RPR_RQST_HDR MRRH," ).append("\n"); 
		query.append("               (SELECT /*+ INDEX(MNR_RPR_RQST_DTL XPKMNR_RPR_RQST_DTL) */" ).append("\n"); 
		query.append("					   RQST_EQ_NO," ).append("\n"); 
		query.append("                       RPR_RQST_SEQ," ).append("\n"); 
		query.append("                       RPR_RQST_VER_NO," ).append("\n"); 
		query.append("                       RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("                  FROM MNR_RPR_RQST_DTL" ).append("\n"); 
		query.append("                 WHERE RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("				   AND EQ_LOC_CD = @[location_cd]" ).append("\n"); 
		query.append("				   AND   EQ_CMPO_CD = @[component]" ).append("\n"); 
		query.append("				   AND   EQ_RPR_CD  = @[repair]   " ).append("\n"); 
		query.append("				   AND   EQ_DMG_CD  = @[damage]" ).append("\n"); 
		query.append("				    #if (${division} != '') " ).append("\n"); 
		query.append("				   		AND   TRF_DIV_CD  = @[division]" ).append("\n"); 
		query.append("				   	#else" ).append("\n"); 
		query.append("						AND   TRF_DIV_CD  IS NULL" ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append(") MRRD, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append(" WHERE     MOH.MNR_ORD_OFC_CTY_CD = MRRH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND   MOH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("       AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999      " ).append("\n"); 
		query.append("	   AND MOH.MNR_ORD_SEQ = MRRH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       AND MRRH.RQST_EQ_NO = MRRD.RQST_EQ_NO" ).append("\n"); 
		query.append("       AND MRRH.RPR_RQST_SEQ = MRRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       AND MRRH.RPR_RQST_VER_NO = MRRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       AND MRRH.RPR_RQST_LST_VER_FLG = MRRD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("       AND MRRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("	   AND MRRH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	   AND MRRH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append(")MRT" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("       AND MRH.RQST_EQ_NO = MRD.RQST_EQ_NO" ).append("\n"); 
		query.append("       AND MRH.RPR_RQST_SEQ = MRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       AND MRH.RPR_RQST_VER_NO = MRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       AND MRH.RQST_EQ_NO = MRV.EQ_NO" ).append("\n"); 
		query.append("       AND MRD.RQST_EQ_NO = MRT.RQST_EQ_NO" ).append("\n"); 
		query.append("       AND MRD.RPR_RQST_SEQ = MRT.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       AND MRD.RPR_RQST_VER_NO = MRT.RPR_RQST_VER_NO" ).append("\n"); 

	}
}