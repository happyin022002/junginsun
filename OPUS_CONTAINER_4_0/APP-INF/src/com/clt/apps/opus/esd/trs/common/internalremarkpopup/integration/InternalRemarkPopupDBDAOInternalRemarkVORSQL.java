/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InternalRemarkPopupDBDAOInternalRemarkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InternalRemarkPopupDBDAOInternalRemarkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Get Internal Remarks from TRS_INTER_RMK Table
	  * </pre>
	  */
	public InternalRemarkPopupDBDAOInternalRemarkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration").append("\n"); 
		query.append("FileName : InternalRemarkPopupDBDAOInternalRemarkVORSQL").append("\n"); 
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
		query.append("--BKG LEVEL " ).append("\n"); 
		query.append("SELECT DECODE(BKG_NO, 'DUM000000000', '', BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_SEQ" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_CTNT AS INTER_RMK" ).append("\n"); 
		query.append("      ,UPD_USR_ID AS USR_ID" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT AS UPD_DT" ).append("\n"); 
		query.append("	  ,DECODE(INTER_RMK_CD, 'D', 'EMAIL'," ).append("\n"); 
		query.append("                            'G', 'GEMAIL'," ).append("\n"); 
		query.append("                            'E', 'EMEDIT'," ).append("\n"); 
		query.append("                            'C', 'CUSNOT'," ).append("\n"); 
		query.append("                            'B', 'BKG', 'TRS') AS INTER_RMK_CD" ).append("\n"); 
		query.append("FROM  TRS_INTER_RMK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND EQ_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG CNTR LEVEL" ).append("\n"); 
		query.append("SELECT DECODE(BKG_NO, 'DUM000000000', '', BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_SEQ" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_CTNT AS INTER_RMK" ).append("\n"); 
		query.append("      ,UPD_USR_ID AS USR_ID" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT AS UPD_DT" ).append("\n"); 
		query.append("	  ,DECODE(INTER_RMK_CD, 'D', 'EMAIL'," ).append("\n"); 
		query.append("                            'G', 'GEMAIL'," ).append("\n"); 
		query.append("                            'E', 'EMEDIT'," ).append("\n"); 
		query.append("                            'C', 'CUSNOT'," ).append("\n"); 
		query.append("                            'B', 'BKG', 'TRS') AS INTER_RMK_CD" ).append("\n"); 
		query.append("FROM  TRS_INTER_RMK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND NVL2(@[eq_no], EQ_NO, 'XX') = NVL(@[eq_no], 'XX')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--TRS S/O LEVEL" ).append("\n"); 
		query.append("SELECT DECODE(BKG_NO, 'DUM000000000', '', BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_SEQ" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("      ,TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,INTER_RMK_CTNT AS INTER_RMK" ).append("\n"); 
		query.append("      ,UPD_USR_ID AS USR_ID" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT AS UPD_DT" ).append("\n"); 
		query.append("	  ,DECODE(INTER_RMK_CD, 'D', 'EMAIL'," ).append("\n"); 
		query.append("                            'G', 'GEMAIL'," ).append("\n"); 
		query.append("                            'E', 'EMEDIT'," ).append("\n"); 
		query.append("                            'C', 'CUSNOT'," ).append("\n"); 
		query.append("                            'B', 'BKG', 'TRS') AS INTER_RMK_CD" ).append("\n"); 
		query.append("FROM  TRS_INTER_RMK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND INTER_RMK_CD = 'T'" ).append("\n"); 
		query.append("  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if(${so_no} != '')" ).append("\n"); 
		query.append("  AND TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_no], 0, 3)" ).append("\n"); 
		query.append("  AND TRSP_SO_SEQ = SUBSTR(@[so_no], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}