/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.30 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see 
 * @since J2EE 1.4
 */

public class PRICommonDBDAOLocNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mdm_location name select
	  * </pre>
	  */
	public PRICommonDBDAOLocNmRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT a.loc_cd as cd," ).append("\n"); 
		query.append("a.loc_nm as nm," ).append("\n"); 
		query.append("a.sconti_cd as etc1," ).append("\n"); 
		query.append("(SELECT sconti_nm FROM mdm_subcontinent WHERE sconti_cd = a.sconti_cd AND rownum = 1) AS etc2" ).append("\n"); 
		query.append("FROM mdm_location a" ).append("\n"); 
		query.append("WHERE a.loc_cd= @[cd]" ).append("\n"); 
		query.append("AND a.delt_flg ='N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDAOLocNmRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}