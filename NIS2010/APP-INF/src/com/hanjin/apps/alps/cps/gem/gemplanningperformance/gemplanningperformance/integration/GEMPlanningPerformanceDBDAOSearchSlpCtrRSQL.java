/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSlpCtrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.09.03 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSlpCtrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 품의서의 Office Code 와 Center Code 중 실제 실적 반영 조직을 조회한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSlpCtrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSlpCtrRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, @[csr_ctr_cd], @[slp_ctr_cd]) code" ).append("\n"); 
		query.append("FROM   GEM_OFC_EXPT A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DECODE(Y.GEN_EXPN_CD, '', X.GEN_EXPN_CD, Y.GEN_EXPN_CD) EXPN_CD" ).append("\n"); 
		query.append("FROM GEM_ACCT_MTX X, GEM_ACCT_EXPT Y" ).append("\n"); 
		query.append("WHERE X.ACCT_CD     = @[acct_cd]" ).append("\n"); 
		query.append("AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND Y.OFC_CD(+)   = @[csr_ofc_cd]" ).append("\n"); 
		query.append("AND X.ACCT_CD     = Y.ACCT_CD(+)" ).append("\n"); 
		query.append("AND X.GEN_EXPN_CD = Y.SPRT_GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("AND Y.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND Y.SPRT_YRMON(+) <= SUBSTR(@[gl_eff_dt],1,6)" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.SND_OFC_CD = (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM GEM_OFFICE" ).append("\n"); 
		query.append("WHERE CTR_CD  = @[csr_ctr_cd]" ).append("\n"); 
		query.append("AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.RCV_OFC_CD IN (@[csr_ofc_cd], 'ALL')" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD IN (B.EXPN_CD,'ALL')" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}