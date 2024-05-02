/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGuidelineMainDBDAORsltGlineScpEffDtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.04 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGuidelineMainDBDAORsltGlineScpEffDtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCGuidelineMainDBDAORsltGlineScpEffDtListVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(",GLINE_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_SG_MN" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("ORDER BY EFF_DT DESC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration").append("\n"); 
		query.append("FileName : SCGuidelineMainDBDAORsltGlineScpEffDtListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}