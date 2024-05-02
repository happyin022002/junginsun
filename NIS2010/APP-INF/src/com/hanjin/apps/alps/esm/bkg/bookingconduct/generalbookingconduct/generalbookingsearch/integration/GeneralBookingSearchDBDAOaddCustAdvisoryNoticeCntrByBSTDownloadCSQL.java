/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByBSTDownloadCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByBSTDownloadCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCustAdvisoryNoticeCntrByBSTDownload
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByBSTDownloadCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeCntrByBSTDownloadCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_AVC_NTC_CNTR" ).append("\n"); 
		query.append("( SELECT BK.BL_NO         AS BL_NO" ).append("\n"); 
		query.append("        ,CNTR.CNTR_NO       AS CNTR_NO              " ).append("\n"); 
		query.append("       , @[cre_usr_id]   AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE         AS CRE_DT" ).append("\n"); 
		query.append("       , @[upd_usr_id]   AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE         AS UPD_DT" ).append("\n"); 
		query.append("	   ,'B'				 AS SRC_DAT_TP_CD" ).append("\n"); 
		query.append("    FROM BKG_CONTAINER CNTR, BKG_BOOKING BK, BKG_VVD BV" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("     AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("     AND BV.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("     AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("     AND BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("     AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("     AND BK.BKG_CGO_TP_CD != 'P' -- EMPTY CARGO 제외" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 AND NOT EXISTS (SELECT '*' FROM BKG_CUST_AVC_NTC_CNTR A " ).append("\n"); 
		query.append("						WHERE A.SRC_DAT_TP_CD = 'B'" ).append("\n"); 
		query.append("                		AND A.BL_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                	)" ).append("\n"); 
		query.append("GROUP BY  BK.BL_NO, CNTR.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}