/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchPpdChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchPpdChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchPpdChgInfoRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchPpdChgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchPpdChgInfoRSQL").append("\n"); 
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
		query.append("WITH PPD AS( " ).append("\n"); 
		query.append("            SELECT BKG_NO, BL_NO, VVD, POL_CD, POD_CD, POL_ETD_DT, UPD_DT, UPD_USR_ID, UPD_USR_NM, " ).append("\n"); 
		query.append("                   MAX(SHPR_CD) SHPR_CD, " ).append("\n"); 
		query.append("                   MAX(SHPR_NM) SHPR_NM, " ).append("\n"); 
		query.append("                   MAX(FRWD_CD) FRWD_CD, " ).append("\n"); 
		query.append("                   MAX(FRWD_NM) FRWD_NM" ).append("\n"); 
		query.append("            FROM   (" ).append("\n"); 
		query.append("                    SELECT  DISTINCT " ).append("\n"); 
		query.append("                            BK.BKG_NO," ).append("\n"); 
		query.append("                            BK.BL_NO, " ).append("\n"); 
		query.append("                            BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD, " ).append("\n"); 
		query.append("                            BK.POL_CD," ).append("\n"); 
		query.append("                            BK.POD_CD," ).append("\n"); 
		query.append("                            TO_CHAR(BK.POL_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') POL_ETD_DT," ).append("\n"); 
		query.append("                            TO_CHAR(BCR.UPD_DT, 'YYYY/MM/DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("                            BCR.UPD_USR_ID," ).append("\n"); 
		query.append("                            (SELECT USR_NM FROM COM_USER WHERE USR_ID = BCR.UPD_USR_ID) UPD_USR_NM," ).append("\n"); 
		query.append("                            DECODE(BC.BKG_CUST_TP_CD, 'S', BC.CUST_CNT_CD||TRIM(TO_CHAR(BC.CUST_SEQ,'000000')),'') SHPR_CD," ).append("\n"); 
		query.append("                            DECODE(BC.BKG_CUST_TP_CD, 'S', NVL(BC.CUST_NM, MC.CUST_LGL_ENG_NM),'') SHPR_NM," ).append("\n"); 
		query.append("                            DECODE(BC.BKG_CUST_TP_CD, 'F', BC.CUST_CNT_CD||TRIM(TO_CHAR(BC.CUST_SEQ,'000000')),'') FRWD_CD," ).append("\n"); 
		query.append("                            DECODE(BC.BKG_CUST_TP_CD, 'F', NVL(BC.CUST_NM, MC.CUST_LGL_ENG_NM),'') FRWD_NM" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING BK," ).append("\n"); 
		query.append("                            BKG_CUSTOMER BC," ).append("\n"); 
		query.append("                            MDM_CUSTOMER MC," ).append("\n"); 
		query.append("                            BKG_CHG_RT BCR" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     BK.BKG_NO = BCR.BKG_NO" ).append("\n"); 
		query.append("                    AND     BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                    AND     BC.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                    AND     BC.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                    AND     BC.BKG_CUST_TP_CD IN ('S','F')" ).append("\n"); 
		query.append("                    AND     BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND     BCR.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                    AND     BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                    AND     BCR.FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("              GROUP BY BKG_NO, BL_NO, VVD, POL_CD, POD_CD, POL_ETD_DT, UPD_DT, UPD_USR_ID, UPD_USR_NM" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT  PPD_INFO.BL_NO, " ).append("\n"); 
		query.append("        PPD_INFO.VVD, " ).append("\n"); 
		query.append("        PPD_INFO.POL_CD," ).append("\n"); 
		query.append("        PPD_INFO.POD_CD," ).append("\n"); 
		query.append("        PPD_INFO.POL_ETD_DT," ).append("\n"); 
		query.append("        PPD_INFO.UPD_DT," ).append("\n"); 
		query.append("        PPD_INFO.UPD_USR_NM," ).append("\n"); 
		query.append("        DECODE(PPD_INFO.SHPR_CD, NULL, '', PPD_INFO.SHPR_CD||' - '||PPD_INFO.SHPR_NM) SHPR," ).append("\n"); 
		query.append("        DECODE(PPD_INFO.FRWD_CD, NULL, '', PPD_INFO.FRWD_CD||' - '||PPD_INFO.FRWD_NM) FRWD," ).append("\n"); 
		query.append("        PPD_AMT.CURR_CD," ).append("\n"); 
		query.append("        PPD_AMT.CHG_AMT CHG_AMT" ).append("\n"); 
		query.append("FROM         " ).append("\n"); 
		query.append("        (SELECT BKG_NO, CURR_CD, SUM(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("         FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("         WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND    FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("         AND    FRT_INCL_XCLD_DIV_CD <> 'I'" ).append("\n"); 
		query.append("         GROUP BY BKG_NO, CURR_CD) PPD_AMT," ).append("\n"); 
		query.append("        (SELECT BKG_NO, BL_NO, VVD, POL_CD, POD_CD, POL_ETD_DT, UPD_DT, UPD_USR_ID, UPD_USR_NM, SHPR_CD, SHPR_NM, FRWD_CD, FRWD_NM" ).append("\n"); 
		query.append("         FROM   PPD" ).append("\n"); 
		query.append("         WHERE  ROWNUM = 1) PPD_INFO" ).append("\n"); 
		query.append("WHERE PPD_AMT.BKG_NO = PPD_INFO.BKG_NO" ).append("\n"); 

	}
}