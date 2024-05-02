/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.13 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 계획비용 요청시 사용할 일반관리비 비용코드(Expense Code)가 집행단위에서 사용할수 있는 코드인지 체크한다.
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseCheckRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseCheckRSQL").append("\n"); 
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
		query.append("#if(${sch_gbn} == 'lvlCheck')" ).append("\n"); 
		query.append("SELECT DECODE (count(*), '0', 'FALSE', 'TRUE') code" ).append("\n"); 
		query.append("FROM   GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND    GEN_EXPN_GRP_LVL = '4'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_gbn} == 'dupCheck')" ).append("\n"); 
		query.append("SELECT DECODE (count(*), '0', 'TRUE', 'FALSE') code" ).append("\n"); 
		query.append("FROM   GEM_OFC_MTX A, GEM_EXPENSE B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_gbn} == 'etc')" ).append("\n"); 
		query.append("SELECT DECODE (A.GEN_EXPN_SLS_DIV_CD,'Y', DECODE (B.SLS_OFC_FLG, 'Y', 'TRUE','FALSE')" ).append("\n"); 
		query.append(",'N', DECODE (B.SLS_OFC_FLG, 'N', 'TRUE','FALSE')" ).append("\n"); 
		query.append(",'C', 'TRUE'" ).append("\n"); 
		query.append(",'FALSE') code" ).append("\n"); 
		query.append("FROM   (SELECT GEN_EXPN_SLS_DIV_CD" ).append("\n"); 
		query.append("FROM   GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N') A" ).append("\n"); 
		query.append(",(SELECT SLS_OFC_FLG" ).append("\n"); 
		query.append("FROM   GEM_OFFICE" ).append("\n"); 
		query.append("WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N') B" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}