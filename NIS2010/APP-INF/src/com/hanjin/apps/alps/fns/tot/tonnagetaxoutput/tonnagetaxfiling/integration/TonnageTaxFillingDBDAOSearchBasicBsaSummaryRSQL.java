/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxFillingDBDAOSearchBasicBsaSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxFillingDBDAOSearchBasicBsaSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운항중인 모든 선박(피더선박 제외)들의 기본 BSA 변동별 내역을 조회한다.
	  * </pre>
	  */
	public TonnageTaxFillingDBDAOSearchBasicBsaSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration").append("\n"); 
		query.append("FileName : TonnageTaxFillingDBDAOSearchBasicBsaSummaryRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD," ).append("\n"); 
		query.append("  A.SLAN_CD," ).append("\n"); 
		query.append("  A.VSL_CD," ).append("\n"); 
		query.append("  B.VSL_ENG_NM," ).append("\n"); 
		query.append("  A.NRT_WGT," ).append("\n"); 
		query.append("  A.NRT_TONG_TAX_AMT," ).append("\n"); 
		query.append("  A.LDB_CAPA_QTY," ).append("\n"); 
		query.append("  A.BSA_CAPA," ).append("\n"); 
		query.append("  CASE WHEN INSTR(TO_CHAR(A.USG_RT), '.') = 1 THEN '0'||TO_CHAR(A.USG_RT) ELSE NVL(TO_CHAR(A.USG_RT), '0') END" ).append("\n"); 
		query.append("  || '%' USG_RT," ).append("\n"); 
		query.append("  A.FM_VVD_STL_DT," ).append("\n"); 
		query.append("  A.TO_VVD_STL_DT," ).append("\n"); 
		query.append("  A.VOY_DYS," ).append("\n"); 
		query.append("  A.PER_TON_REV," ).append("\n"); 
		query.append("  A.TONG_TAX_AMT" ).append("\n"); 
		query.append("FROM TOT_BZC_BSA_SMRY A," ).append("\n"); 
		query.append("  MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.TONG_BZC_BSA_YR = @[year]" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD, A.FM_VVD_STL_DT" ).append("\n"); 

	}
}