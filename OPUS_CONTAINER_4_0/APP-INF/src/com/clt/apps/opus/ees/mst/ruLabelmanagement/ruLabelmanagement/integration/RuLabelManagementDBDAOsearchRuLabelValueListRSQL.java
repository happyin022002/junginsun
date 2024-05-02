/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelValueListRSQL.java
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

public class RuLabelManagementDBDAOsearchRuLabelValueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Value 데이타 조회
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelValueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelValueListRSQL").append("\n"); 
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
		query.append("	RSTR_USG_LBL_NM " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MST_RSTR_USG_CD " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ru_label_type} != '') " ).append("\n"); 
		query.append("	AND RSTR_USG_TP_CD = @[ru_label_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY RSTR_USG_LBL_NM" ).append("\n"); 

	}
}