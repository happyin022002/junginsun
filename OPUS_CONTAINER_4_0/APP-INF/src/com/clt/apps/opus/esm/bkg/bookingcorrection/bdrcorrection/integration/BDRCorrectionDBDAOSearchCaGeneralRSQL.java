/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2011.02.23 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeIlMin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaGeneralRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaGeneralRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       (SELECT ATTR_CTNT2 " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'HIST_UI_NAME' " ).append("\n"); 
		query.append("           AND ATTR_CTNT1 = MST.BKG_HIS_ISS_UI_ID) ITEM_HDR, " ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("       WHEN BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_05' THEN ''" ).append("\n"); 
		query.append("       WHEN BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_08' THEN ''" ).append("\n"); 
		query.append("       ELSE DTL.HIS_CATE_NM" ).append("\n"); 
		query.append("       END HIS_CATE_NM," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("       WHEN BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_05' THEN ''" ).append("\n"); 
		query.append("       WHEN BKG_HIS_ISS_UI_ID = 'ESM_BKG_0079_08' THEN ''" ).append("\n"); 
		query.append("       ELSE DTL.PRE_CTNT" ).append("\n"); 
		query.append("       END PRE_CTNT," ).append("\n"); 
		query.append("       NVL((SELECT ATTR_CTNT10" ).append("\n"); 
		query.append("              FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("             WHERE HRD_CDG_ID = 'HIST_UI_NAME' " ).append("\n"); 
		query.append("               AND ATTR_CTNT1 = MST.BKG_HIS_ISS_UI_ID" ).append("\n"); 
		query.append("               AND MST.BKG_HIS_ISS_UI_ID IN ('ESM_BKG_0079_05','ESM_BKG_0079_08')),DTL.CRNT_CTNT) AS CRNT_CTNT" ).append("\n"); 
		query.append("  FROM BKG_HIS_MST MST" ).append("\n"); 
		query.append("     , BKG_HIS_DTL DTL" ).append("\n"); 
		query.append(" WHERE MST.BKG_NO  = DTL.BKG_NO" ).append("\n"); 
		query.append("   AND MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("   AND MST.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND MST.CORR_NO = @[ca_no]" ).append("\n"); 

	}
}