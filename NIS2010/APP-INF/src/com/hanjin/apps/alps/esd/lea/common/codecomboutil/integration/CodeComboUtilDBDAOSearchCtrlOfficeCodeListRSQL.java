/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CodeComboUtilDBDAOSearchCtrlOfficeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeComboUtilDBDAOSearchCtrlOfficeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CtrlOfficeCodeList
	  * </pre>
	  */
	public CodeComboUtilDBDAOSearchCtrlOfficeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration").append("\n"); 
		query.append("FileName : CodeComboUtilDBDAOSearchCtrlOfficeCodeListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT YY.CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM( SELECT DISTINCT" ).append("\n"); 
		query.append("                   	CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SHARC' --('SELTOB','SELCOE') THEN 'SHAAS'" ).append("\n"); 
		query.append("                         ELSE XX.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                    END	      AS RHQ_CD" ).append("\n"); 
		query.append("               	   ,CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SELSC' --('SELTOB','SELCOE') THEN 'SELBB'" ).append("\n"); 
		query.append("                         ELSE XX.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                   	END       AS P_OFC_CD" ).append("\n"); 
		query.append("               		, XX.OFC_CD AS CTRL_OFC_CD" ).append("\n"); 
		query.append("        	FROM( SELECT *" ).append("\n"); 
		query.append("                 FROM( SELECT L.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                             ,L.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                             ,L.OFC_CD" ).append("\n"); 
		query.append("                             ,L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("                             ,L.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("                             ,ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC)  OFC_ORDER" ).append("\n"); 
		query.append("                        FROM  MAS_OFC_LVL L" ).append("\n"); 
		query.append("                       WHERE  L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                         AND  L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                     ) X" ).append("\n"); 
		query.append("                WHERE X.OFC_ORDER = 1" ).append("\n"); 
		query.append("               ) XX" ).append("\n"); 
		query.append(") YY " ).append("\n"); 
		query.append("WHERE YY.RHQ_CD = @[rhq_cd]" ).append("\n"); 

	}
}