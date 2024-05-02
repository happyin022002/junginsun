/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.09.09 장창수
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

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tot_erp_if 년월 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL").append("\n"); 
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
		query.append("SELECT T.STL_YRMON" ).append("\n"); 
		query.append(",T.BAT_JB_SEQ" ).append("\n"); 
		query.append(",T.VSL_CD" ).append("\n"); 
		query.append(",(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = T.VSL_CD) VSL_NM" ).append("\n"); 
		query.append(",NVL(T.TONG_FLET_TP_CD,'X')   TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",T.CNT_CD" ).append("\n"); 
		query.append(",T.NRT_WGT" ).append("\n"); 
		query.append(",T.PER_TON_REV" ).append("\n"); 
		query.append(",T.VOY_DYS" ).append("\n"); 
		query.append(",T.USG_RT" ).append("\n"); 
		query.append(",T.TONG_TAX_AMT" ).append("\n"); 
		query.append(",T.NRT_TONG_TAX_AMT" ).append("\n"); 
		query.append(",T.LDB_CAPA_QTY" ).append("\n"); 
		query.append(",T.ACT_BSA_CAPA" ).append("\n"); 
		query.append(",T.CTRT_DYS" ).append("\n"); 
		query.append(",REPLACE(T.VVD_RMK,'||',',') VVD_RMK" ).append("\n"); 
		query.append(",T.CRE_DT" ).append("\n"); 
		query.append(",T.CRE_USR_ID" ).append("\n"); 
		query.append(",T.UPD_DT" ).append("\n"); 
		query.append(",T.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') R_SEQ" ).append("\n"); 
		query.append(", ROWNUM   R_NUM" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')  CRT_DT" ).append("\n"); 
		query.append("FROM TOT_ERP_IF T" ).append("\n"); 
		query.append("WHERE (T.STL_YRMON, T.BAT_JB_SEQ) IN (" ).append("\n"); 
		query.append("SELECT STL_YRMON, MAX(BAT_JB_SEQ)" ).append("\n"); 
		query.append("FROM TOT_ERP_IF" ).append("\n"); 
		query.append("WHERE STL_YRMON BETWEEN SUBSTR(@[stl_yrmon],1,4)|| '01' AND @[stl_yrmon]" ).append("\n"); 
		query.append("GROUP BY STL_YRMON )" ).append("\n"); 

	}
}