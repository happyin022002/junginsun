/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOInsertSurveyItemsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.08.10 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAOInsertSurveyItemsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 새로 작성한 설문 조사 항목들을 입력
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOInsertSurveyItemsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOInsertSurveyItemsCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EV_ITM_SEQ, " ).append("\n"); 
		query.append("EV_ITM_NM, " ).append("\n"); 
		query.append("EV_ITM_ORD_NO, " ).append("\n"); 
		query.append("EG_ITM_FLG, " ).append("\n"); 
		query.append("DELT_FLG, " ).append("\n"); 
		query.append("CRE_USR_ID, " ).append("\n"); 
		query.append("CRE_DT, " ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT NVL(MAX(EV_ITM_SEQ), 0)+1, " ).append("\n"); 
		query.append("NVL(@[ev_itm_nm], ' '), " ).append("\n"); 
		query.append("LPAD(@[seq], 4, '0'), " ).append("\n"); 
		query.append("'N', " ).append("\n"); 
		query.append("'N', " ).append("\n"); 
		query.append("@[usr_id], " ).append("\n"); 
		query.append("SYSDATE,  " ).append("\n"); 
		query.append("@[usr_id], " ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 

	}
}