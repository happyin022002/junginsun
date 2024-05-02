/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.27 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bsa 테이블의 modify flag 체크
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("	   SUBSTR(@[stl_yrmon],1,4) AS STL_YRMON " ).append("\n"); 
		query.append("      ,V.VSL_CD" ).append("\n"); 
		query.append("      ,V.NET_RGST_TONG_WGT AS NRT_WGT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM TOT_VVD_STL_AMT T, MDM_VSL_CNTR V" ).append("\n"); 
		query.append(" WHERE T.STL_YRMON LIKE SUBSTR(@[stl_yrmon],1,4)||'%'" ).append("\n"); 
		query.append("   AND T.VSL_CD  =  V.VSL_CD" ).append("\n"); 
		query.append("   AND T.NRT_WGT <> V.NET_RGST_TONG_WGT" ).append("\n"); 

	}
}