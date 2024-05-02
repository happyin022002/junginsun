/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCommonDBDAOSearchYardInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.27
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.11.27 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchYardInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mdm yard 정보
	  * </pre>
	  */
	public DMTCommonDBDAOSearchYardInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchYardInfoRSQL").append("\n"); 
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
		query.append("SELECT  YD_NM||'|'||DMDT_OFC_CD||'|'||DEM_IB_CLT_FLG||'|'||DEM_OB_CLT_FLG||'|'||CAL_TYPE AS YD_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT  A.YD_NM AS YD_NM," ).append("\n"); 
		query.append("         A.DMDT_OFC_CD AS DMDT_OFC_CD, " ).append("\n"); 
		query.append("         A.DEM_IB_CLT_FLG AS DEM_IB_CLT_FLG," ).append("\n"); 
		query.append("         A.DEM_OB_CLT_FLG AS DEM_OB_CLT_FLG ," ).append("\n"); 
		query.append("         ( SELECT /*+ INDEX_DESC( B DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                  B.DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("            FROM  DMT_CALC_TP B ," ).append("\n"); 
		query.append("                  MDM_LOCATION C" ).append("\n"); 
		query.append("            WHERE C.LOC_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("            AND   ( B.CNT_CD   =  C.CNT_CD OR B.CNT_CD = ' ' )" ).append("\n"); 
		query.append("            AND   ( B.RGN_CD   =  C.RGN_CD OR B.RGN_CD = ' ' )" ).append("\n"); 
		query.append("            AND   ( B.STE_CD   =  C.STE_CD OR B.STE_CD = ' ' )" ).append("\n"); 
		query.append("            AND   ( B.LOC_CD   =  C.LOC_CD OR B.LOC_CD = ' ' )" ).append("\n"); 
		query.append("            AND   B.IO_BND_CD  =  'I'" ).append("\n"); 
		query.append("            AND   B.CALC_TP_SEQ = ( SELECT /*+ INDEX_DESC( D XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                          D.CALC_TP_SEQ" ).append("\n"); 
		query.append("                                   FROM   DMT_CALC_TP  D" ).append("\n"); 
		query.append("                                   WHERE  ( D.CNT_CD = C.CNT_CD   OR  D.CNT_CD = ' ' )" ).append("\n"); 
		query.append("                                   AND    ( D.RGN_CD = C.RGN_CD   OR  D.RGN_CD = ' ' )" ).append("\n"); 
		query.append("                                   AND    ( D.STE_CD = C.STE_CD   OR  D.STE_CD = ' ' )" ).append("\n"); 
		query.append("                                   AND    ( D.LOC_CD = C.LOC_CD   OR  D.LOC_CD = ' ' )" ).append("\n"); 
		query.append("                                   AND    D.IO_BND_CD =  'I'" ).append("\n"); 
		query.append("                                   AND    ROWNUM = 1" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("            AND  ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS CAL_TYPE" ).append("\n"); 
		query.append(" FROM MDM_YARD A" ).append("\n"); 
		query.append(" WHERE A.YD_CD =  @[yd_cd]" ).append("\n"); 
		query.append(" AND A.DELT_FLG = 'N' )" ).append("\n"); 

	}
}