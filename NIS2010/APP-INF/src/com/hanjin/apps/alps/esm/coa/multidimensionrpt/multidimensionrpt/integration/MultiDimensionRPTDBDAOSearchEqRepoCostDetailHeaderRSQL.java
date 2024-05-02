/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchEqRepoCostDetailHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.03.18 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchEqRepoCostDetailHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquire EQ Repo-contribution Cost Detail
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchEqRepoCostDetailHeaderRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchEqRepoCostDetailHeaderRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  ,NVL(B.EQ_REPO_CR_RTO, 0) EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  (SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("   FROM COA_SPCL_REPO_CNTR_RGST " ).append("\n"); 
		query.append("   WHERE REPO_FLG = 'Y'" ).append("\n"); 
		query.append("     AND NVL(DELT_FLG,'N') = 'N') A" ).append("\n"); 
		query.append("  ,(SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,MAX(EQ_REPO_CR_RTO) EQ_REPO_CR_RTO " ).append("\n"); 
		query.append("   FROM COA_CNTR_REPO_IDX_ITM" ).append("\n"); 
		query.append("   WHERE BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("   GROUP BY CNTR_TPSZ_CD) B" ).append("\n"); 
		query.append("WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("ORDER BY A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}