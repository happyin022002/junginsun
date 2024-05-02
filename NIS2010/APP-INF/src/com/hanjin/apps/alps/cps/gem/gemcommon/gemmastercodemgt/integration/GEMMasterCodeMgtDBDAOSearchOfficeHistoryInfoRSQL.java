/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office code history 조회
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoRSQL").append("\n"); 
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
		query.append("SELECT     OFC_HIS_SEQ" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,CTR_CD" ).append("\n"); 
		query.append("          ,EFF_DT" ).append("\n"); 
		query.append("          ,EXP_DT" ).append("\n"); 
		query.append("          ,BFR_OFC_CD" ).append("\n"); 
		query.append("          ,BFR_CTR_CD" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT" ).append("\n"); 
		query.append("FROM       GEM_OFC_HIS" ).append("\n"); 
		query.append("START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("ORDER BY   EFF_DT, OFC_HIS_SEQ" ).append("\n"); 

	}
}