/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchTpbInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.04.04 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchTpbInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchTpbInfoRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchTpbInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchTpbInfoRSQL").append("\n"); 
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
		query.append("    A.CNTR_NO," ).append("\n"); 
		query.append("    A.BKG_NO," ).append("\n"); 
		query.append("    A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    A.CGO," ).append("\n"); 
		query.append("    A.SO_NM," ).append("\n"); 
		query.append("    A.CNMV_STS_CD," ).append("\n"); 
		query.append("    SUBSTR(A.TPB,1,INSTR(A.TPB,'$',1)-1) AS TPB_NO," ).append("\n"); 
		query.append("    SUBSTR(A.TPB,INSTR(A.TPB,'$',1)+1) AS IF_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    C.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("    C.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("    C.CNTR_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    CASE WHEN C.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("         WHEN C.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("         WHEN C.BB_CGO_FLG ='Y'  THEN 'BB'" ).append("\n"); 
		query.append("         WHEN C.AWK_CGO_FLG ='Y' THEN 'AK'" ).append("\n"); 
		query.append("    ELSE 'DR'" ).append("\n"); 
		query.append("    END CGO," ).append("\n"); 
		query.append("    NVL((SELECT 'Yes' FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("     WHERE SO.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("     AND SO.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_STS_CD IN('C','I','R')" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("     ), 'No') SO_NM," ).append("\n"); 
		query.append("     C.CNMV_STS_CD AS CNMV_STS_CD," ).append("\n"); 
		query.append("     (SELECT N3PTY_NO||'$'||IF_AMT FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append("      WHERE A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND A.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("		AND A.OTS_DTL_SEQ = (SELECT MAX(K.OTS_DTL_SEQ) FROM TPB_OTS_DTL K" ).append("\n"); 
		query.append("                        WHERE K.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                        AND   K.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("						AND   K.N3PTY_DELT_TP_CD='N'" ).append("\n"); 
		query.append("                        AND   K.N3PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append(") TPB" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}