/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : MstMgmtDBDAOSearchMdmHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_DAT_CNG_HIS Request List 정보 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmHistoryListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(SELECT  CNG_DT" ).append("\n"); 
		query.append("       ,(SELECT UI_DP_TBL_NM CD_DESC" ).append("\n"); 
		query.append("           FROM MDM_TBL_INFO" ).append("\n"); 
		query.append("          WHERE HIS_FLG = 'Y' AND TBL_DIV_CD = 'T' AND TBL_NM = H.TBL_NM" ).append("\n"); 
		query.append("          GROUP BY TBL_NM, UI_DP_TBL_NM" ).append("\n"); 
		query.append("        ) TBL_NM" ).append("\n"); 
		query.append("       ,(SELECT UI_DP_FLD_NM CD_DESC" ).append("\n"); 
		query.append("           FROM MDM_COL_INFO" ).append("\n"); 
		query.append("          WHERE TBL_NM = H.TBL_NM" ).append("\n"); 
		query.append("            AND COL_NM = H.COL_NM" ).append("\n"); 
		query.append("            AND HIS_FLG = 'Y'" ).append("\n"); 
		query.append("          GROUP BY COL_NM, UI_DP_FLD_NM" ).append("\n"); 
		query.append("        ) COL_NM" ).append("\n"); 
		query.append("       ,CNG_SEQ" ).append("\n"); 
		query.append("       ,N1ST_KEY_COL_NM" ).append("\n"); 
		query.append("       ,N2ND_KEY_COL_NM" ).append("\n"); 
		query.append("       ,N3RD_KEY_COL_NM" ).append("\n"); 
		query.append("       ,N4TH_KEY_COL_NM" ).append("\n"); 
		query.append("       ,N5TH_KEY_COL_NM" ).append("\n"); 
		query.append("       ,PRE_CTNT" ).append("\n"); 
		query.append("       ,AFT_CTNT" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(UPD_DT, 'YYYY-MM-DD')  AS UPD_DT" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER (ORDER BY H.CNG_SEQ) AS ROW_SEQ" ).append("\n"); 
		query.append("   FROM MDM_DAT_CNG_HIS H" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${fm_rqst_dt} != '')" ).append("\n"); 
		query.append("    AND CNG_DT BETWEEN TO_DATE(@[fm_rqst_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_rqst_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm} != '')" ).append("\n"); 
		query.append("    AND TBL_NM = @[tbl_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${col_nm} != '')" ).append("\n"); 
		query.append("    AND COL_NM = @[col_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("  WHERE ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY CNG_DT DESC " ).append("\n"); 

	}
}