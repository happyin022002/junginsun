/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationGuidelineDBDAORsltPriSgGrpLocVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.01 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationGuidelineDBDAORsltPriSgGrpLocVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GroupLocation 조회
	  * </pre>
	  */
	public SCGroupLocationGuidelineDBDAORsltPriSgGrpLocVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append(",GRP_LOC_SEQ" ).append("\n"); 
		query.append(",PRC_GRP_LOC_CD" ).append("\n"); 
		query.append(",PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY PRC_GRP_LOC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.integration").append("\n"); 
		query.append("FileName : SCGroupLocationGuidelineDBDAORsltPriSgGrpLocVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}