/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchVessleInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchVessleInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for search_vessle_information
	  * </pre>
	  */
	public Edi315SendDBDAOSearchVessleInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_trunk_vvd_splited",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchVessleInformationRSQL").append("\n"); 
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
		query.append("SELECT  REPLACE(VSL_ENG_NM, CHR(39), ' ') vsl_name," ).append("\n"); 
		query.append("VSL_RGST_CNT_CD vsl_cntr_code," ).append("\n"); 
		query.append("nvl(decode(LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', LLOYD_NO), ' ')  vsl_lloyd_no" ).append("\n"); 
		query.append("FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and VSL_CD = substr(@[e_trunk_vvd_splited],1,4)" ).append("\n"); 

	}
}