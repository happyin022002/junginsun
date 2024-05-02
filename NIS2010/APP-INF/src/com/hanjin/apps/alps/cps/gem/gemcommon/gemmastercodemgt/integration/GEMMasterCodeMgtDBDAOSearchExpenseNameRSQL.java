/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.11 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용코드(Expense Code) 의 한글약어명, 영문약어명, 비용주관팀을 조회한다
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseNameRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append(",ENG_ABBR_NM" ).append("\n"); 
		query.append(",KRN_ABBR_NM" ).append("\n"); 
		query.append(",TIC_CD" ).append("\n"); 
		query.append("FROM   (SELECT 'ALL' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'ALL' ENG_ABBR_NM" ).append("\n"); 
		query.append(",'전체' KRN_ABBR_NM" ).append("\n"); 
		query.append(",'' TIC_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append(",ENG_ABBR_NM" ).append("\n"); 
		query.append(",KRN_ABBR_NM" ).append("\n"); 
		query.append(",TIC_CD" ).append("\n"); 
		query.append("FROM   GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N') A" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseNameRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}