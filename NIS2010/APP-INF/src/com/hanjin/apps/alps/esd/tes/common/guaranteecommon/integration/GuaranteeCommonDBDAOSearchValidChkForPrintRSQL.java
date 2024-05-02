/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchValidChkForPrintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchValidChkForPrintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Valid Check For Guarantee Inquiry Print
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchValidChkForPrintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no_hidden",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchValidChkForPrintRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    NVL(" ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN COUNT(GL.GNTE_NO) > 0 AND " ).append("\n"); 
		query.append("            SUM(" ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("            WHEN GL.TML_IF_OFC_CD IS NOT NULL AND GL.TML_IF_SEQ IS NOT NULL " ).append("\n"); 
		query.append("            THEN 1 " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("            END) + " ).append("\n"); 
		query.append("            SUM(" ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("            WHEN GL.IRR_NO IS NOT NULL " ).append("\n"); 
		query.append("            THEN 1 " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("            END) = COUNT(GL.GNTE_NO)" ).append("\n"); 
		query.append("        THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END CHK_PRINT" ).append("\n"); 
		query.append("    FROM TES_GNTE_HDR GH, TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND NVL(GH.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND NVL(GH.DMY_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND GH.GNTE_NO = GL.GNTE_NO" ).append("\n"); 
		query.append("      AND GH.GNTE_NO = @[gnte_no_hidden]" ).append("\n"); 
		query.append("    GROUP BY GL.GNTE_NO),'N') CHK_PRINT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}