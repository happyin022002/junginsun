/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
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

public class RuLabelManagementDBDAOsearchRuLabelTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST_CONTAINER에 Label Type에 데이타가 있는지 확인하여 데이타가 있다면 삭제안되게 처리
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelTypeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ru_label_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelTypeListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO FROM MST_CONTAINER WHERE 1=1" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'FLOW') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM1 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'OWFU') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM2 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'OFHR') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM3 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'DOME') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM4 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'SALE') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM5 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'GOHH') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM6 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'REFR') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM7 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'ASST') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM8 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'OTR1') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM9 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'OTR2') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM10 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ru_label_type} == 'OTR3') " ).append("\n"); 
		query.append("AND RSTR_USG_TP_LBL_NM11 = @[ru_label_value]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}