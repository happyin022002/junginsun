/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoDelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoDelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoDel
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoDelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_del_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoDelRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_NM DEL_NAME," ).append("\n"); 
		query.append("LOC_CD DEL_CODE," ).append("\n"); 
		query.append("DECODE(CNT_CD, 'US', 'D', 'K') DEL_AMSQUAL," ).append("\n"); 
		query.append("LOC_AMS_PORT_CD DEL_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LOC_CD = @[e_del_loc]" ).append("\n"); 

	}
}