/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.20 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090911 2079 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("t1.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '1' THEN 1 END),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '2' THEN 1 END),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '3' THEN 1 END),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '4' THEN 1 END),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '5' THEN 1 END),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '6' THEN 1 END),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '7' THEN 1 END),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '8' THEN 1 END),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '9' THEN 1 END),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '10' THEN 1 END),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '11' THEN 1 END),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '12' THEN 1 END),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '13' THEN 1 END),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '14' THEN 1 END),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '15' THEN 1 END),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '16' THEN 1 END),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '17' THEN 1 END),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '18' THEN 1 END),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '19' THEN 1 END),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN t1.DP_SEQ = '20' THEN 1 END),0) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.EQ_NO AS EQ_NO" ).append("\n"); 
		query.append(",B.STS_EVNT_OFC_CD AS STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",G.DP_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_EQ_STS_HIS B,CGM_EQ_TP_SZ G" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = G.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inq_fm_dys} != '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT BETWEEN TO_DATE(@[inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} != '' && ${inq_to_dys} == '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT >= TO_DATE(@[inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} == '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT <= TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND B.STS_EVNT_OFC_CD IN ($crnt_ofc_cd) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT = " ).append("\n"); 
		query.append("        (	SELECT" ).append("\n"); 
		query.append("            	MAX(t2.STS_EVNT_DT)" ).append("\n"); 
		query.append("	        FROM CGM_EQUIPMENT t1, CGM_EQ_STS_HIS t2" ).append("\n"); 
		query.append("    	    WHERE" ).append("\n"); 
		query.append("    	    	t1.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("	    	    AND t1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("		        AND t1.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("		        AND t2.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("			#if (${inq_fm_dys} != '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("				AND t2.STS_EVNT_DT BETWEEN TO_DATE(@[inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("			#elseif (${inq_fm_dys} != '' && ${inq_to_dys} == '')" ).append("\n"); 
		query.append("				AND t2.STS_EVNT_DT >= TO_DATE(@[inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("			#elseif (${inq_fm_dys} == '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("				AND t2.STS_EVNT_DT <= TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("				AND t2.STS_EVNT_OFC_CD IN ($crnt_ofc_cd) " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    		    AND t1.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(") t1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY t1.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append("ORDER BY t1.STS_EVNT_OFC_CD" ).append("\n"); 

	}
}