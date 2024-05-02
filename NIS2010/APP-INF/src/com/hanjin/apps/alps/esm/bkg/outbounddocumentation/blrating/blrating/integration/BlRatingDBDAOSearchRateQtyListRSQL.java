/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchRateQtyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.03.23 김태경
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

public class BlRatingDBDAOSearchRateQtyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRateQtyList
	  * </pre>
	  */
	public BlRatingDBDAOSearchRateQtyListRSQL(){
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
		query.append("FileName : BlRatingDBDAOSearchRateQtyListRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT A1.CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("      ,CASE 	" ).append("\n"); 
		query.append("        WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' THEN 'AK'" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N' THEN 'DR'	" ).append("\n"); 
		query.append("       END AS CGO	" ).append("\n"); 
		query.append("      ,SUM(CASE 	" ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("       END) AS QTY" ).append("\n"); 
		query.append("		,A1.EQ_SUBST_CNTR_TPSZ_CD EQ_SUB" ).append("\n"); 
		query.append("		,A1.EQ_SUBST_CGO_QTY EQ_SUB_QTY" ).append("\n"); 
		query.append("	FROM BKG_QTY_HIS A1, BKG_QTY_DTL_HIS DTL" ).append("\n"); 
		query.append("      ,( SELECT LEVEL AS LV" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("        CONNECT BY ROWNUM <= 5" ).append("\n"); 
		query.append("       ) A2" ).append("\n"); 
		query.append(" WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND A1.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("	AND A1.CNTR_TPSZ_CD = DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	AND A1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	AND A1.CORR_NO = DTL.CORR_NO" ).append("\n"); 
		query.append(" GROUP BY A1.CNTR_TPSZ_CD,A1.EQ_SUBST_CNTR_TPSZ_CD,A1.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("      ,CASE " ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' THEN 'AK'" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("HAVING SUM(CASE " ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("       END) > 0" ).append("\n"); 
		query.append(" ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A1.CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("      ,CASE 	" ).append("\n"); 
		query.append("        WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' THEN 'AK'" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N' THEN 'DR'	" ).append("\n"); 
		query.append("       END AS CGO	" ).append("\n"); 
		query.append("      ,SUM(CASE 	" ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("       END) AS QTY" ).append("\n"); 
		query.append("		,A1.EQ_SUBST_CNTR_TPSZ_CD EQ_SUB" ).append("\n"); 
		query.append("		,A1.EQ_SUBST_CGO_QTY EQ_SUB_QTY" ).append("\n"); 
		query.append("	FROM BKG_QUANTITY A1, BKG_QTY_DTL DTL" ).append("\n"); 
		query.append("      ,( SELECT LEVEL AS LV" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("        CONNECT BY ROWNUM <= 5" ).append("\n"); 
		query.append("       ) A2" ).append("\n"); 
		query.append(" WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND A1.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("	AND A1.CNTR_TPSZ_CD = DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" GROUP BY A1.CNTR_TPSZ_CD,A1.EQ_SUBST_CNTR_TPSZ_CD,A1.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("      ,CASE " ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' THEN 'AK'" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' THEN 'RF'" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y' THEN 'DG'" ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("HAVING SUM(CASE " ).append("\n"); 
		query.append("		WHEN LV = 1 AND DTL.BB_CGO_FLG = 'Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 2 AND DTL.AWK_CGO_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 3 AND DTL.RC_FLG ='Y' AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("		WHEN LV = 4 AND DTL.DCGO_FLG ='Y'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY " ).append("\n"); 
		query.append("		WHEN LV = 5 AND DTL.BB_CGO_FLG ='N' AND AWK_CGO_FLG ='N' AND RC_FLG = 'N' AND DCGO_FLG = 'N'  AND DTL.OP_CNTR_QTY > 0 THEN DTL.OP_CNTR_QTY" ).append("\n"); 
		query.append("       END) > 0" ).append("\n"); 
		query.append(" ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}