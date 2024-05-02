/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementDBDAOcheckRulabelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.09.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOcheckRulabelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RU Label Check :
	  * RU Label Attachment Detachment 화면에서 Cntr별 RU LAbel 등록시에 Container No와 RU Label Type에 대한 
	  * Duplication Error를 처리하기 위해  Cntr의 RU 존재여부를 체크한다.
	  * </pre>
	  */
	public RuLabelManagementDBDAOcheckRulabelRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOcheckRulabelRSQL").append("\n"); 
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
		query.append("SELECT 'X' AS FLAG" ).append("\n"); 
		query.append("   FROM MST_CONTAINER A " ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    AND NVL(@[ru_label_type], 'X') = NVL(@[ru_label_type], 'Y')      " ).append("\n"); 
		query.append("#if (${ru_label_type} == 'FLOW')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM1 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'OWFU')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM2 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'OFHR')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM3 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'DOME')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM4 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'SALE')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM5 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'GOHH')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM6 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'REFR')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM7 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'ASST')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM8 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'OTR1')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM9 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'OTR2')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM10 IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${ru_label_type} == 'OTR3')" ).append("\n"); 
		query.append("    AND A.RSTR_USG_TP_LBL_NM11 IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}