/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchEqRepoCostDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.11.18 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchEqRepoCostDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquire EQ Repo-contribution Cost Detail
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchEqRepoCostDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchEqRepoCostDetailListRSQL").append("\n"); 
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
		query.append("SELECT  ITEM" ).append("\n"); 
		query.append(",ITEM_NM" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND( 0" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("+ ESTM_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",2)" ).append("\n"); 
		query.append(") ESTM_TOTAL" ).append("\n"); 
		query.append(",ROUND( 0" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("+ REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",2) REPO_TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(ESTM_$key, 2)) ESTM_$key" ).append("\n"); 
		query.append(",ROUND(REPO_$key, 2) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (SELECT 	B.ITEM" ).append("\n"); 
		query.append(",B.ITEM_NM" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",SUM(NVL(A.ESTM_$key, 0)) ESTM_$key" ).append("\n"); 
		query.append(",SUM(NVL(A.REPO_$key, 0)) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'ITM1' ITEM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_QTY,0), 0) ESTM_$key" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_QTY,0), 0) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM 	MAS_BKG_REV_DTL" ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ITM2' ITEM" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_REV,0) + NVL(BKG_OFT_REV,0) + NVL(BKG_MISC_REV, 0)+ NVL(SCR_CHG_REV, 0), 0) ESTM_$key" ).append("\n"); 
		query.append(",0 REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM 	MAS_BKG_REV_DTL" ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT K.SGRP_COST_CD ITEM" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(H.CNTR_TPSZ_CD, '$key', SUM(NVL(G.ESTM_USD_TTL_AMT, 0))) ESTM_$key" ).append("\n"); 
		query.append(",DECODE(H.CNTR_TPSZ_CD, '$key', SUM(NVL(H.REPO_COST_AMT, 0))) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MAS_BKG_COST_SMRY G" ).append("\n"); 
		query.append(",MAS_CNTR_REPO_IDX_ITM H" ).append("\n"); 
		query.append(",MAS_STND_ACCT_V K" ).append("\n"); 
		query.append("WHERE	G.BKG_NO(+) = H.BKG_NO" ).append("\n"); 
		query.append("AND G.CNTR_TPSZ_CD(+) = H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND G.STND_COST_CD(+) = H.STND_COST_CD" ).append("\n"); 
		query.append("AND G.COST_ROUT_NO(+) = H.COST_ROUT_NO" ).append("\n"); 
		query.append("AND H.STND_COST_CD = K.STND_COST_CD" ).append("\n"); 
		query.append("AND K.MAS_COST_SRC_PRT_CD IN( 'PA','CO')" ).append("\n"); 
		query.append("AND K.STND_COST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(G.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND H.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND H.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("GROUP BY K.SGRP_COST_CD, H.CNTR_TPSZ_CD 	) A," ).append("\n"); 
		query.append("( SELECT 1 NO,'ITM1' ITEM, 'Load(TEU or BOX)' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 NO,'ITM2' ITEM, 'Gross Revenue' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 NO,'CVFS' ITEM, 'Full Stevedorage' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 4 NO,'CVIP' ITEM, 'Full_Internal Pricing' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 NO,'CVTR' ITEM, 'Full Trans' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 6 NO,'CVES' ITEM, 'Empty Stevedorage' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 7 NO,'CVET' ITEM, 'Empty Trans' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 8 NO,'CVAC' ITEM, 'Agency Commission' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 9 NO,'EQCF' ITEM, 'CNTR Fixed Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 10 NO,'EQSF' ITEM, 'CHSS Fixed Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 11 NO,'BUAC' ITEM, 'Business Activity Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 12 NO,'CVVI' ITEM, 'Terminal Volume Incentive' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ITEM(+) = B.ITEM" ).append("\n"); 
		query.append("GROUP BY B.NO, B.ITEM, B.ITEM_NM" ).append("\n"); 
		query.append("ORDER BY B.NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}