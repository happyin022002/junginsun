/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCstmsRefInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCstmsRefInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0668-01 화면에서 사용하는 SQL문
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCstmsRefInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCstmsRefInfoRSQL").append("\n"); 
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
		query.append("SELECT  BKGM.BKG_NO" ).append("\n"); 
		query.append("       ,BKGM.BL_NO" ).append("\n"); 
		query.append("       ,CABL.CSTMS_LOC_CD AS CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ,lPAD(CABL.CSTMS_FILE_TP_CD, 2,'0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("       ,CAIB.IBD_TRSP_NO" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR( MAX(ARR_DT), 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("          WHERE CNT_CD  = CABL.CNT_CD " ).append("\n"); 
		query.append("          AND   BL_NO   = CABL.BL_NO" ).append("\n"); 
		query.append("          AND   DSPO_CD = '1J'" ).append("\n"); 
		query.append("          AND   CAIB.IBD_TRSP_NO IS NOT NULL" ).append("\n"); 
		query.append("         ) AS  IBD_TRSP_ISS_DT" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append("      JOIN BKG_CSTMS_ADV_BL CABL" ).append("\n"); 
		query.append("      ON ( CABL.CNT_CD  = 'US'" ).append("\n"); 
		query.append("           AND CABL.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("           AND CABL.BL_NO  = BKGM.BL_NO  )  " ).append("\n"); 
		query.append("      LEFT OUTER JOIN BKG_CSTMS_ADV_IBD CAIB" ).append("\n"); 
		query.append("      ON ( CABL.CNT_CD     = CAIB.CNT_CD" ).append("\n"); 
		query.append("           AND CABL.BL_NO  = CAIB.BL_NO )   " ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}