/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseRequestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.17 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseRequestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택 Request No.에 대한 요청정보을 조회한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseRequestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseRequestInfoRSQL").append("\n"); 
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
		query.append("SELECT  REGEXP_REPLACE(N1ST_REF_OFC_CD||','||N2ND_REF_OFC_CD" ).append("\n"); 
		query.append("||','||N3RD_REF_OFC_CD||','||N4TH_REF_OFC_CD," ).append("\n"); 
		query.append("'^,|(,){2}|,$','') AS REF_OFC_CD," ).append("\n"); 
		query.append("RQST_NO, RQST_OFC_CD, MSS_RQST_IO_MOD_CD," ).append("\n"); 
		query.append("TO_CHAR(RQST_DT, 'YYYY-MM-DD') AS RQST_DT," ).append("\n"); 
		query.append("N1ST_REF_OFC_CD, N2ND_REF_OFC_CD, N3RD_REF_OFC_CD," ).append("\n"); 
		query.append("N4TH_REF_OFC_CD, RQST_USR_ID, DIFF_RMK, CURR_CD" ).append("\n"); 
		query.append("FROM    LSE_MSS_USD_RQST" ).append("\n"); 
		query.append("WHERE   APRO_NO IS NULL" ).append("\n"); 
		query.append("AND     RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}