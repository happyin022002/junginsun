/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSubsidiarySlpCtrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSubsidiarySlpCtrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.09 [CHM-201217079-01] 이준범
	  * 1.subsidiary Slip Upload  신규 기능 추가
	  *   : 실제 실적 집계 대상 조직코드 및 비용코드 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSubsidiarySlpCtrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSubsidiarySlpCtrRSQL").append("\n"); 
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
		query.append("  FROM GEM_OFC_EXPT A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT GEN_EXPN_CD AS EXPN_CD" ).append("\n"); 
		query.append("          FROM GEM_SUBS_ACCT_MTX" ).append("\n"); 
		query.append("         WHERE SUBS_ACCT_CD = @[subs_acct_cd]" ).append("\n"); 
		query.append("           AND OFC_CD       = @[csr_ofc_cd]" ).append("\n"); 
		query.append("           AND DELT_FLG     = 'N'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("  WHERE A.SND_OFC_CD = (" ).append("\n"); 
		query.append("                        SELECT OFC_CD" ).append("\n"); 
		query.append("                          FROM GEM_OFFICE" ).append("\n"); 
		query.append("                         WHERE CTR_CD  = @[csr_ctr_cd]" ).append("\n"); 
		query.append("                          AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("    AND A.RCV_OFC_CD IN (@[csr_ofc_cd], 'ALL')" ).append("\n"); 
		query.append("    AND A.GEN_EXPN_CD IN (B.EXPN_CD,'ALL')" ).append("\n"); 
		query.append("    AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}