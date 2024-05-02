/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOModifyChargeRateTempForCMPBDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
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

public class BlRatingDBDAOModifyChargeRateTempForCMPBDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMPB산출을 위해 BKG Creation/Update시 BKG Volume에 해당되는 최저 Revenue만 남기고 나머지 정보는 삭제함
	  * </pre>
	  */
	public BlRatingDBDAOModifyChargeRateTempForCMPBDSQL(){
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
		query.append("FileName : BlRatingDBDAOModifyChargeRateTempForCMPBDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM BKG_AUTO_RT_OCN_FRT_TMP" ).append("\n"); 
		query.append("WHERE (BKG_NO, OFT_CMB_SEQ, CNTR_TPSZ_CD, CTRT_CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    NOT IN (SELECT BKG_NO, OFT_CMB_SEQ, CNTR_TPSZ_CD, CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT T.BKG_NO, T.OFT_CMB_SEQ, T.CNTR_TPSZ_CD, T.CTRT_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                           ROW_NUMBER() OVER (PARTITION BY Q.CNTR_TPSZ_CD, Q.CTRT_CNTR_TPSZ_CD, Q.SUBST_SEQ" ).append("\n"); 
		query.append("                                              ORDER BY T.CHG_AMT) RNUM" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_NO, " ).append("\n"); 
		query.append("                                 CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                                 SUBST_SEQ," ).append("\n"); 
		query.append("                                 CASE WHEN CNTR_TPSZ_CD LIKE 'R%' AND DRY_CGO_FLG = 'Y' -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("                                              THEN CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("                                      ELSE NVL(EQ_SUBST_CNTR_TPSZ_CD, CNTR_TPSZ_CD)  " ).append("\n"); 
		query.append("                                 END CTRT_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                 DRY_CGO_FLG," ).append("\n"); 
		query.append("                                 AWK_CGO_FLG," ).append("\n"); 
		query.append("                                 DCGO_FLG," ).append("\n"); 
		query.append("                                 RC_FLG," ).append("\n"); 
		query.append("                                 BB_CGO_FLG" ).append("\n"); 
		query.append("                          FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("                          WHERE BKG_NO = @[bkg_no]) Q, " ).append("\n"); 
		query.append("                         BKG_AUTO_RT_OCN_FRT_TMP T" ).append("\n"); 
		query.append("                    WHERE Q.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    -- AND Q.CNTR_TPSZ_CD  NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                    AND Q.CNTR_TPSZ_CD = T.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND Q.CTRT_CNTR_TPSZ_CD = T.CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND Q.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("                    AND T.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                    AND Q.DRY_CGO_FLG = T.DRY_CGO_FLG" ).append("\n"); 
		query.append("                    AND Q.AWK_CGO_FLG = T.AWK_CGO_FLG" ).append("\n"); 
		query.append("                    AND Q.DCGO_FLG = T.DCGO_FLG" ).append("\n"); 
		query.append("                    AND Q.RC_FLG = T.RC_FLG" ).append("\n"); 
		query.append("                    AND Q.BB_CGO_FLG = T.BB_CGO_FLG" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("            WHERE RNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}