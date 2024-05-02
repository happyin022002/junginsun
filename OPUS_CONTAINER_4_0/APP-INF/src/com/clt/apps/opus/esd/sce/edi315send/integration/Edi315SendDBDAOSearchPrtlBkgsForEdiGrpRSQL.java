/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.11.02 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL").append("\n"); 
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
		query.append("SELECT HDR.BKG_NO, B.BL_NO " ).append("\n"); 
		query.append("FROM SCE_COP_HDR HDR, BKG_BOOKING B " ).append("\n"); 
		query.append("WHERE HDR.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("    AND (CNTR_NO,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD) IN ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            CASE WHEN CNTR_NO = 'COMU0000000' THEN 'PSEUDO CNTR' ELSE CNTR_NO END AS CNTR_NO, " ).append("\n"); 
		query.append("            TRNK_VSL_CD AS TRNK_VSL_CD, " ).append("\n"); 
		query.append("            TRNK_SKD_VOY_NO AS TRNK_SKD_VOY_NO, " ).append("\n"); 
		query.append("            TRNK_SKD_DIR_CD AS TRNK_SKD_DIR_CD " ).append("\n"); 
		query.append("        FROM SCE_COP_HDR A " ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("            AND CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT '1'" ).append("\n"); 
		query.append("            FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("            WHERE BKG_NO = HDR.BKG_NO " ).append("\n"); 
		query.append("                AND (CUST_CNT_CD,CUST_SEQ) IN ( " ).append("\n"); 
		query.append("                    SELECT CUST_CNT_CD,CUST_SEQ" ).append("\n"); 
		query.append("                    FROM EDI_GRP_CUST" ).append("\n"); 
		query.append("                    WHERE EDI_GRP_CD IN (" ).append("\n"); 
		query.append("                        SELECT EDI_GRP_CD" ).append("\n"); 
		query.append("                        FROM EDI_GROUP" ).append("\n"); 
		query.append("                        WHERE 1=1 " ).append("\n"); 
		query.append("                          AND CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT SC_NO" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("                AND SC_NO IN (" ).append("\n"); 
		query.append("                    SELECT SC_NO" ).append("\n"); 
		query.append("                    FROM EDI_GRP_CUST" ).append("\n"); 
		query.append("                    WHERE EDI_GRP_CD IN (" ).append("\n"); 
		query.append("                        SELECT EDI_GRP_CD" ).append("\n"); 
		query.append("                        FROM EDI_GROUP" ).append("\n"); 
		query.append("                        WHERE 1=1 " ).append("\n"); 
		query.append("                          AND SC_NO IS NOT NULL" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT HDR.BKG_NO, B.BL_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR HDR, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE HDR.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("    AND HDR.BKG_NO = @[bkg_no] AND HDR.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("    AND ( HDR.CNTR_NO='COMU0000000' ) " ).append("\n"); 
		query.append("    AND ROWNUM=1" ).append("\n"); 

	}
}