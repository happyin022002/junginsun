/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.10.22 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tot_stl_cfm 테이블에 confirm 여부를 조회한다.
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(SUM(DECODE(A.TONG_ITM_CD,'NRT', COUNT(A.TONG_ITM_CD))),NULL,'N','Y') NRT_YN" ).append("\n"); 
		query.append(",DECODE(SUM(DECODE(A.TONG_ITM_CD,'USE', COUNT(A.TONG_ITM_CD))),NULL,'N','Y') USE_YN" ).append("\n"); 
		query.append(",DECODE(SUM(DECODE(A.TONG_ITM_CD,'DYS', COUNT(A.TONG_ITM_CD))),NULL,'N','Y') DAY_YN" ).append("\n"); 
		query.append("FROM TOT_STL_CFM A" ).append("\n"); 
		query.append("WHERE A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon] AND TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("GROUP BY A.TONG_ITM_CD" ).append("\n"); 

	}
}