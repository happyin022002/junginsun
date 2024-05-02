/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchHouseBlYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchHouseBlYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * House B/L YN
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchHouseBlYnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchHouseBlYnRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(1), 0, 'N', 'Y') AS NVO_HBS_YN" ).append("\n"); 
		query.append("      ,DECODE(MAX(HBL_TP),'B','B',DECODE(MAX(HBL_TP2),'B','B','A')) AS HBL_TP" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CASE WHEN GDS_DESC_LINE = 1 AND LENGTH(GDS_DESC) < 329 THEN 'A'" ).append("\n"); 
		query.append("                    WHEN GDS_DESC_LINE > 1 AND GDS_DESC_LINE < 9 THEN 'A'" ).append("\n"); 
		query.append("                    WHEN GDS_DESC_LINE = 0 THEN 'A'" ).append("\n"); 
		query.append("                    ELSE 'B'" ).append("\n"); 
		query.append("                    END AS HBL_TP," ).append("\n"); 
		query.append("               CASE WHEN MK_DESC_LINE = 1 AND LENGTH(MK_DESC) < 329 THEN 'A'" ).append("\n"); 
		query.append("                    WHEN MK_DESC_LINE > 1 AND LENGTH(MK_DESC) < 9 THEN 'A'" ).append("\n"); 
		query.append("                    WHEN MK_DESC_LINE = 0 THEN 'A'" ).append("\n"); 
		query.append("                    ELSE 'B'" ).append("\n"); 
		query.append("                    END AS HBL_TP2" ).append("\n"); 
		query.append("        FROM (  " ).append("\n"); 
		query.append("              SELECT MK_DESC  " ).append("\n"); 
		query.append("                    ,GDS_DESC  " ).append("\n"); 
		query.append("                    ,DECODE(LENGTH(MK_DESC), NULL, 0, ((LENGTH(MK_DESC) - LENGTH(REPLACE(MK_DESC, CHR(13)||CHR(10)))) / LENGTH(CHR(13)||CHR(10)) + 1)) AS MK_DESC_LINE  " ).append("\n"); 
		query.append("                    ,DECODE(LENGTH(GDS_DESC), NULL, 0, ((LENGTH(GDS_DESC) - LENGTH(REPLACE(GDS_DESC, CHR(13)||CHR(10)))) / LENGTH(CHR(13)||CHR(10)) + 1)) AS GDS_DESC_LINE  " ).append("\n"); 
		query.append("                    ,length(GDS_DESC)" ).append("\n"); 
		query.append("                FROM (  " ).append("\n"); 
		query.append("                      SELECT REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(BL_MK_DESC,'[[:cntrl:]]{104,}',CHR(13)||CHR(10)),CHR(96),CHR(39)), CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '[[:space:]]+$', '')  AS MK_DESC  " ).append("\n"); 
		query.append("                            ,REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(BL_GDS_DESC,'[[:cntrl:]]{104,}',CHR(13)||CHR(10)),CHR(96),CHR(39)), CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '[[:space:]]+$', '') AS GDS_DESC  " ).append("\n"); 
		query.append("                        FROM BKG_HBL  " ).append("\n"); 
		query.append("                       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     )  " ).append("\n"); 
		query.append("            )  " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}