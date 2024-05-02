/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 재계산된 TOT_PORT_STL_AMT 의 데이터 추출
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL").append("\n"); 
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
		query.append("SELECT STL_YRMON" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",MAX(LDB_CAPA_QTY)            LDB_CAPA_QTY" ).append("\n"); 
		query.append(",MAX(USG_RT)                  USG_RT" ).append("\n"); 
		query.append(",SUM(TRUNC(TONG_TAX_AMT,0))            TONG_TAX_AMT" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY STL_YRMON, VSL_CD" ).append("\n"); 

	}
}