/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RehandExpmanageDBDAOSearchOfficeHierarchyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOSearchOfficeHierarchyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeHierarchy
	  * </pre>
	  */
	public RehandExpmanageDBDAOSearchOfficeHierarchyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.terminalmanage.integration ").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOSearchOfficeHierarchyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	LEVEL, DECODE(LEVEL," ).append("\n"); 
		query.append("	1, OFC_CD," ).append("\n"); 
		query.append("	2, '      '||OFC_CD," ).append("\n"); 
		query.append("	3, '            '||OFC_CD," ).append("\n"); 
		query.append("	4, '                  '||OFC_CD," ).append("\n"); 
		query.append("	5, '                        '||OFC_CD," ).append("\n"); 
		query.append("	6, '                           '||OFC_CD," ).append("\n"); 
		query.append("	7, '                                 '||OFC_CD," ).append("\n"); 
		query.append("	8, '                                       '||OFC_CD," ).append("\n"); 
		query.append("	9, '                                             '||OFC_CD," ).append("\n"); 
		query.append("	10, '                                                  '||OFC_CD," ).append("\n"); 
		query.append("	'') OFC_CD_NAME, OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("ORDER SIBLINGS BY OFC_CD" ).append("\n"); 

	}
}