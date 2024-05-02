/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.09.18 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bsa 테이블의 modify flag 체크
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration ").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL").append("\n"); 
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
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(", LDB_CAPA_QTY" ).append("\n"); 
		query.append("FROM TOT_BSA" ).append("\n"); 
		query.append("WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_BSA WHERE STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND MODI_FLG = 'Y'" ).append("\n"); 

	}
}