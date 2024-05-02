/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MSTCommonDBDAOSearchEqTypeSizeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchEqTypeSizeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Common Code Select
	  * </pre>
	  */
	public MSTCommonDBDAOSearchEqTypeSizeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchEqTypeSizeListDataRSQL").append("\n"); 
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
		query.append("SELECT AA.EQ_KND_CD," ).append("\n"); 
		query.append("       AA.CODE," ).append("\n"); 
		query.append("       AA.CODE_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT 'U' EQ_KND_CD,A.CNTR_TPSZ_CD CODE,A.CNTR_TPSZ_DESC CODE_NM,A.RPT_DP_SEQ DP_SEQ " ).append("\n"); 
		query.append("     FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("     WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append("     AND ACIAC_DIV_CD ='A'" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT A.EQ_KND_CD,A.EQ_TPSZ_CD CODE,A.DIFF_DESC CODE_NM, A.DP_SEQ" ).append("\n"); 
		query.append("     FROM CGM_EQ_TP_SZ A) AA" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("#if(${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND AA.CODE = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND AA.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(AA.EQ_KND_CD,'U',1,'Z',2,3), AA.DP_SEQ" ).append("\n"); 

	}
}