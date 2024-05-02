/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.03
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2012.01.03 이준범
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

public class TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.12.01 이준범
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL(){
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
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAONrtBsaChgVORSQL").append("\n"); 
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
		query.append("SELECT NVL(A.STL_YRMON, B.STL_YRMON) AS STL_YRMON" ).append("\n"); 
		query.append("      ,A.SLAN_CD" ).append("\n"); 
		query.append("      ,NVL(A.VSL_CD, B.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("      ,A.VVD" ).append("\n"); 
		query.append("      ,NVL(B.NRT_BFR, 0) AS NRT_BFR" ).append("\n"); 
		query.append("      ,NVL(B.NRT_AFT, 0) AS NRT_AFT" ).append("\n"); 
		query.append("      ,NVL(A.BSA_BFR, 0) AS BSA_BFR" ).append("\n"); 
		query.append("      ,NVL(A.BSA_AFT, 0) AS BSA_AFT" ).append("\n"); 
		query.append("      ,'I' AS IBFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT " ).append("\n"); 
		query.append("               T.STL_YRMON" ).append("\n"); 
		query.append("              ,T.SLAN_CD" ).append("\n"); 
		query.append("              ,T.VSL_CD" ).append("\n"); 
		query.append("              ,T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,T.FNL_HJS_BSA_CAPA AS BSA_BFR" ).append("\n"); 
		query.append("              ,C.FNL_HJS_BSA_CAPA AS BSA_AFT" ).append("\n"); 
		query.append("          FROM TOT_BSA T" ).append("\n"); 
		query.append("              ,BSA_VVD_MST C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND T.STL_YRMON  = @[stl_yrmon]" ).append("\n"); 
		query.append("           AND T.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("           AND C.RLANE_CD LIKE T.SLAN_CD||'%'" ).append("\n"); 
		query.append("           AND T.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("           AND T.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND T.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND T.FNL_HJS_BSA_CAPA <> C.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("       ) A " ).append("\n"); 
		query.append("       FULL OUTER JOIN " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT DISTINCT " ).append("\n"); 
		query.append("               T.STL_YRMON" ).append("\n"); 
		query.append("              ,V.VSL_CD" ).append("\n"); 
		query.append("              ,T.NRT_WGT           AS NRT_BFR" ).append("\n"); 
		query.append("              ,V.NET_RGST_TONG_WGT AS NRT_AFT" ).append("\n"); 
		query.append("              ,(SELECT MAX(B.SLAN_CD) FROM TOT_BSA B WHERE T.STL_YRMON = B.STL_YRMON AND T.VSL_CD = B.VSL_CD ) AS SLAN_CD" ).append("\n"); 
		query.append("          FROM TOT_VVD_STL_AMT T" ).append("\n"); 
		query.append("              ,MDM_VSL_CNTR V" ).append("\n"); 
		query.append("         WHERE T.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("           AND T.VSL_CD    =  V.VSL_CD" ).append("\n"); 
		query.append("           AND T.NRT_WGT  <> V.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("    ON A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append(" ORDER BY NVL(A.STL_YRMON, B.STL_YRMON)" ).append("\n"); 
		query.append("         ,A.SLAN_CD" ).append("\n"); 
		query.append("         ,NVL(A.VSL_CD, B.VSL_CD)" ).append("\n"); 
		query.append("         ,A.VVD" ).append("\n"); 

	}
}