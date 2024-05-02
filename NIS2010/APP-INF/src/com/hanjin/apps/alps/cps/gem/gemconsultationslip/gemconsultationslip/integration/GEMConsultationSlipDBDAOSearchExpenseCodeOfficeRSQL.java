/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchExpenseCodeOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOSearchExpenseCodeOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * office 별 expense code를 가져온다.
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchExpenseCodeOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expense_text",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchExpenseCodeOfficeRSQL").append("\n"); 
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
		query.append("SELECT LVL4_CODE subs_expn_cd, " ).append("\n"); 
		query.append("       LVL4_NAME subs_expn_nm" ).append("\n"); 
		query.append("FROM GEM_CSR_LEVEL_V" ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("      #if (${subs_ofc_cd} == 'SELBPG')" ).append("\n"); 
		query.append("      AND  OFC_CD = 'NYCSC'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${subs_ofc_cd} != 'SELBPG')" ).append("\n"); 
		query.append("      AND OFC_CD =@[subs_ofc_cd]" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("     AND EXPN_DIV_CD =@[expn_div_cd]" ).append("\n"); 
		query.append("     #if (${expense_text} != '')" ).append("\n"); 
		query.append("     AND LVL4_NAME = @[expense_text]" ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("     GROUP BY LVL4_CODE , LVL4_NAME" ).append("\n"); 

	}
}