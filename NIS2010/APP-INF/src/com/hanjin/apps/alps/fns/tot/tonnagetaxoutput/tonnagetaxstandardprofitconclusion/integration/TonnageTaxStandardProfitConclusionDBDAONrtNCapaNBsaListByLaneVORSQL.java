/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.01.21 장창수
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

public class TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane별 NRT/CAPA/BSA Allocation 을 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD  VVD" ).append("\n"); 
		query.append(", A.STL_YRMON" ).append("\n"); 
		query.append(", B.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(", B.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(", A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append(", A.CRR_BSA_CAPA" ).append("\n"); 
		query.append(", A.TONG_BSA_CAPA" ).append("\n"); 
		query.append("FROM TOT_BSA A, MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE A.STL_YRMON BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 

	}
}