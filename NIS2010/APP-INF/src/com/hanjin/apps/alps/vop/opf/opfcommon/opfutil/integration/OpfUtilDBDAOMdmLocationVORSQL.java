/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfUtilDBDAOMdmLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOMdmLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * </pre>
	  */
	public OpfUtilDBDAOMdmLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOMdmLocationVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN X.AR_HD_QTR_OFC_CD IN ('SHARC', 'TYOHQ', 'SELHQ', 'SHAHQ') THEN 'SHARC'" ).append("\n"); 
		query.append("            WHEN X.AR_HD_QTR_OFC_CD IN ('SELIB')                            THEN 'SELIB'" ).append("\n"); 
		query.append("            WHEN X.AR_HD_QTR_OFC_CD IN ('TYOIB')                            THEN 'TYOIB'" ).append("\n"); 
		query.append("            WHEN X.AR_HD_QTR_OFC_CD IN ('HAMRU', 'HAMHQ')                   THEN 'HAMRU'" ).append("\n"); 
		query.append("            WHEN X.AR_HD_QTR_OFC_CD IN ('SINRS', 'SINHQ')                   THEN 'SINRS'" ).append("\n"); 
		query.append("            WHEN X.AR_HD_QTR_OFC_CD IN ('NYCRA', 'NYCHQ')                   THEN 'NYCRA'" ).append("\n"); 
		query.append("			WHEN X.AR_HD_QTR_OFC_CD IN ('VVOIA')                            THEN 'VVOIA'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS NAME" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append(" WHERE X.OFC_CD   = @[ofc_cd]            " ).append("\n"); 
		query.append("   AND X.DELT_FLG = 'N'" ).append("\n"); 

	}
}