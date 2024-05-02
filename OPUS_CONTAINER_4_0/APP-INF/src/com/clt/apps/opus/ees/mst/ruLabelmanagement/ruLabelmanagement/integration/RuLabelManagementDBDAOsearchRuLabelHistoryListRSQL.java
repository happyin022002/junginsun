/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label History 조회
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ru_label_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelHistoryListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    RSTR_USG_TP_CD" ).append("\n"); 
		query.append(",   RSTR_USG_LBL_NM" ).append("\n"); 
		query.append(",   DECODE(RSTR_USG_UPD_TP_CD,'U','Update','C','Create','D','Delete') RSTR_USG_UPD_TP_CD" ).append("\n"); 
		query.append(",	CNTR_RMK AS REMARK" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM MST_CNTR_RSTR_USG_HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_cntr_no} != '') " ).append("\n"); 
		query.append("	AND CNTR_NO = @[s_cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_ru_label_type} != '') " ).append("\n"); 
		query.append("	AND RSTR_USG_TP_CD = @[s_ru_label_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}