/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAORsltCheckOriginDestSvcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltCheckOriginDestSvcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Region Code, Country Code가 MDM_SVC_SCP_LMT 에 Origin, Dest에 맞춰서 존재 하는지 확인한다.
	  * </pre>
	  */
	public PRICommonDBDAORsltCheckOriginDestSvcVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltCheckOriginDestSvcVORSQL").append("\n"); 
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
		query.append("SELECT RGN_CD AS CD, RGN_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_REGION LOC" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("#if( ${etc1} == 'C' || ${cd_length} == '2')" ).append("\n"); 
		query.append("	CNT_CD = @[cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	RGN_CD = @[cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'F' FROM MDM_SVC_SCP_LMT LMT" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    #if ( ${etc2} != 'B' )" ).append("\n"); 
		query.append("        AND ORG_DEST_CD =  @[etc2]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("        AND LMT.RGN_CD = LOC.RGN_CD" ).append("\n"); 
		query.append("		AND LMT.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}