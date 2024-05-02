/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomizedReportSetupDBDAOInsertCustmRptFormCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomizedReportSetupDBDAOInsertCustmRptFormCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customized Report Form Setup 정보 등록
	  * </pre>
	  */
	public CustomizedReportSetupDBDAOInsertCustmRptFormCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coldesc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.setup.integration").append("\n"); 
		query.append("FileName : CustomizedReportSetupDBDAOInsertCustmRptFormCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_USA_INLND_OP_RPT_FOM (RPT_USR_ID" ).append("\n"); 
		query.append("                    ,RPT_COL_NM" ).append("\n"); 
		query.append("					,MOFC_ID" ).append("\n"); 
		query.append("                    ,CRE_USR_ID" ).append("\n"); 
		query.append("                    ,CRE_DT" ).append("\n"); 
		query.append("                    ,UPD_USR_ID" ).append("\n"); 
		query.append("                    ,UPD_DT )" ).append("\n"); 
		query.append("            VALUES (@[user_id]" ).append("\n"); 
		query.append("                    ,@[coldesc2]" ).append("\n"); 
		query.append("					,@[user_ofc_cd]" ).append("\n"); 
		query.append("                    ,@[user_id]" ).append("\n"); 
		query.append("                    ,SYSDATE" ).append("\n"); 
		query.append("                    ,@[user_id]" ).append("\n"); 
		query.append("                    ,SYSDATE )" ).append("\n"); 

	}
}