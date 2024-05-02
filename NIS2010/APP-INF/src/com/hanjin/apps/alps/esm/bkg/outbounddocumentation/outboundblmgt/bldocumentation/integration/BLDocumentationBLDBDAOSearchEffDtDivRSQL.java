/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchEffDtDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchEffDtDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOSearchEffDtDivRSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchEffDtDivRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchEffDtDivRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("    #if (${div} == 'BKG')" ).append("\n"); 
		query.append("    SELECT 'Y' AS DIV_FLG " ).append("\n"); 
		query.append("      FROM BKG_BKG_HIS BKG" ).append("\n"); 
		query.append("          ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("       AND BKG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("       AND BKG.DEL_CD LIKE CTNT.ATTR_CTNT1||'%'" ).append("\n"); 
		query.append("       AND CTNT.HRD_CDG_ID = 'AUTO_CLAUSE_DATE'" ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT2 = 'BKG'" ).append("\n"); 
		query.append("       AND BKG.BKG_CRE_DT >= TO_DATE(CTNT.ATTR_CTNT3,'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("    #elseif (${div} == 'CRD')" ).append("\n"); 
		query.append("    SELECT 'Y' AS DIV_FLG " ).append("\n"); 
		query.append("      FROM BKG_CNTR_HIS CON" ).append("\n"); 
		query.append("          ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("     WHERE CON.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND CON.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("       AND CTNT.HRD_CDG_ID = 'AUTO_CLAUSE_DATE'" ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT2 = 'CRD'" ).append("\n"); 
		query.append("       AND CON.CGO_RCV_DT >= TO_DATE(CTNT.ATTR_CTNT3,'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${div} == 'BKG')" ).append("\n"); 
		query.append("    SELECT 'Y' AS DIV_FLG  " ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("       AND BKG.DEL_CD LIKE CTNT.ATTR_CTNT1||'%'" ).append("\n"); 
		query.append("       AND CTNT.HRD_CDG_ID = 'AUTO_CLAUSE_DATE'" ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT2 = 'BKG'" ).append("\n"); 
		query.append("       AND BKG.BKG_CRE_DT >= TO_DATE(CTNT.ATTR_CTNT3,'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("    #elseif (${div} == 'CRD')" ).append("\n"); 
		query.append("    SELECT 'Y' AS DIV_FLG " ).append("\n"); 
		query.append("      FROM BKG_CONTAINER CON" ).append("\n"); 
		query.append("          ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("     WHERE CON.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND CTNT.HRD_CDG_ID = 'AUTO_CLAUSE_DATE'" ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT2 = 'CRD'" ).append("\n"); 
		query.append("       AND CON.CGO_RCV_DT >= TO_DATE(CTNT.ATTR_CTNT3,'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}