/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchRqstExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.30 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchRqstExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조직별 비용계획 수립 가능한 비용코드를 체크하고, 비용 코드의 한글약어명,영문약어명,비용주관팀 정보를 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchRqstExpenseRSQL(){
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
		params.put("tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchRqstExpenseRSQL").append("\n"); 
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
		query.append("SELECT A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",A.ENG_ABBR_NM" ).append("\n"); 
		query.append(",A.KRN_ABBR_NM" ).append("\n"); 
		query.append(",A.TIC_CD" ).append("\n"); 
		query.append(",A.GEM_EXPN_GRP_CD1 GEN_EXPN_GROUP_CD" ).append("\n"); 
		query.append("FROM   GEM_EXPN_GRP_V A, GEM_OFC_MTX B" ).append("\n"); 
		query.append("WHERE  A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    B.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("#if (${tic_cd} != '')" ).append("\n"); 
		query.append("AND A.TIC_CD = @[tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_expn_group_cd} != '')" ).append("\n"); 
		query.append("AND A.GEM_EXPN_GRP_CD1 =  @[gen_expn_group_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}