/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.19 장창수
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

public class TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운항일수가 0이면서 booking물량이 있는 데이터를 조회한다.
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL").append("\n"); 
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
		query.append("SELECT A.STL_YRMON" ).append("\n"); 
		query.append(", A.TRD_CD" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD  VVD" ).append("\n"); 
		query.append(", A.PORT_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.ETD_DT,'YYYYMMDD') ETD_DT" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(", A.BSA_CAPA" ).append("\n"); 
		query.append(", A.ACT_BSA_CAPA" ).append("\n"); 
		query.append(", A.USG_RT" ).append("\n"); 
		query.append(", A.VOY_DYS" ).append("\n"); 
		query.append(", A.TONG_TAX_AMT" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT A" ).append("\n"); 
		query.append("WHERE A.STL_YRMON BETWEEN @[stl_yrmon] AND @[e_stl_yrmon]" ).append("\n"); 
		query.append("AND A.TONG_STL_BAT_JB_SEQ = (SELECT MAX(TONG_STL_BAT_JB_SEQ) FROM TOT_PORT_STL_AMT WHERE STL_YRMON = A.STL_YRMON)" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ACT_BSA_CAPA >0" ).append("\n"); 
		query.append("AND A.VOY_DYS = 0" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}