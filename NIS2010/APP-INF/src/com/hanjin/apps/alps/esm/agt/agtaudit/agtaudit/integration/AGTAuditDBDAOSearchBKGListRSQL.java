/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOSearchBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBKGList
	  * </pre>
	  */
	public AGTAuditDBDAOSearchBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchBKGListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BL_NO                                                       AS BL_NO," ).append("\n"); 
		query.append("BKG_NO                                                      AS BKG_NO," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD                              AS VVD," ).append("\n"); 
		query.append("BKG_STS_CD," ).append("\n"); 
		query.append("BKG_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(BKG_CRE_DT,'YYYY-MM-DD')                            AS BKG_CRE_DT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("COUNT(1)" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM      X," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO Y" ).append("\n"); 
		query.append("WHERE X.BKG_NO          = Y.BKG_NO" ).append("\n"); 
		query.append("AND X.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("AND X.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND X.AGN_CD          = @[agn_cd]" ).append("\n"); 
		query.append("#if(${sts_cd} == '1')" ).append("\n"); 
		query.append("AND X.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'CS','CE','IC','CA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '2')" ).append("\n"); 
		query.append("AND X.COMM_PROC_STS_CD IN ('RS','RM')" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '3')" ).append("\n"); 
		query.append("AND X.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '4')" ).append("\n"); 
		query.append("AND X.COMM_PROC_STS_CD = 'IF'" ).append("\n"); 
		query.append("AND X.AC_IF_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_bl_no} != '')" ).append("\n"); 
		query.append("AND Y.BL_NO LIKE '%' || @[s_bl_no] || '%'" ).append("\n"); 
		query.append("#elseif(${bl_nos} != '')" ).append("\n"); 
		query.append("AND Y.BL_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( ${bl_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")                                                             AS AGT_COMM_CNT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("COMM_PROC_RSLT_RSN" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append(")                                                             AS COMM_PROC_RSLT_RSN" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${search_dt_fr} != '')" ).append("\n"); 
		query.append("AND A.CRE_DT >= TO_DATE(@[search_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_dt_to} != '')" ).append("\n"); 
		query.append("AND A.CRE_DT <= TO_DATE(@[search_dt_to],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_bl_no} != '')" ).append("\n"); 
		query.append("AND A.BL_NO LIKE '%' || @[s_bl_no] || '%'" ).append("\n"); 
		query.append("#elseif(${bl_nos} != '')" ).append("\n"); 
		query.append("AND A.BL_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( ${bl_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}