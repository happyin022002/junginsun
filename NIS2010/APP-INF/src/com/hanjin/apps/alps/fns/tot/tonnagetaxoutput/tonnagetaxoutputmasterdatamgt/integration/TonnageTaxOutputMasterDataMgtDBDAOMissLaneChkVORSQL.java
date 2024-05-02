/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.05
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.12.05 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE-JUN-BUM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.12.01 이준범
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOMissLaneChkVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       L.SLAN_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,C.VSL_ENG_NM" ).append("\n"); 
		query.append("      ,L.TRD_CD   " ).append("\n"); 
		query.append("      ,'I' AS IBFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.VSL_CD" ).append("\n"); 
		query.append("          FROM TOT_BSA B" ).append("\n"); 
		query.append("         WHERE B.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("          FROM TOT_VVD_STL_AMT A" ).append("\n"); 
		query.append("         WHERE A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("           AND A.TONG_STL_BAT_JB_SEQ = (" ).append("\n"); 
		query.append("                                        SELECT MAX(T.TONG_STL_BAT_JB_SEQ)" ).append("\n"); 
		query.append("                                          FROM TOT_VVD_STL_AMT T " ).append("\n"); 
		query.append("                                         WHERE T.STL_YRMON = A.STL_YRMON" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,TOT_BSA L" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND L.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("   AND L.VSL_CD    = A.VSL_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD    = C.VSL_CD" ).append("\n"); 
		query.append(" ORDER BY L.SLAN_CD" ).append("\n"); 
		query.append("         ,A.VSL_CD" ).append("\n"); 
		query.append("         ,L.TRD_CD" ).append("\n"); 

	}
}