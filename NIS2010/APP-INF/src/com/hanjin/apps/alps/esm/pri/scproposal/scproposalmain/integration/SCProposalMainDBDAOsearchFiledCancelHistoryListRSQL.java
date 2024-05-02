/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCProposalMainDBDAOsearchFiledCancelHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOsearchFiledCancelHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
	  * </pre>
	  */
	public SCProposalMainDBDAOsearchFiledCancelHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOsearchFiledCancelHistoryListRSQL").append("\n"); 
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
		query.append("SELECT FILE_CXL_SEQ," ).append("\n"); 
		query.append("TO_CHAR(RQST_DT,'YYYY-MM-DD') RQST_DT,RQST_USR_NM,RQST_USR_ID,RQST_OFC_CD,CRE_USR_NM," ).append("\n"); 
		query.append("CRE_USR_ID,FILE_CXL_RSN,SC_NO,PROP_NO,AMDT_SEQ,TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("FROM PRI_SP_FILE_CXL_HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${sc_no}!='')" ).append("\n"); 
		query.append("AND SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prop_no}!='')" ).append("\n"); 
		query.append("AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rqst_usr_id}!='')" ).append("\n"); 
		query.append("AND RQST_USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_dt}!='')" ).append("\n"); 
		query.append("AND RQST_DT between to_date(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY 1 DESC" ).append("\n"); 

	}
}