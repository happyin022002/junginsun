/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltRgGrpLocListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.24 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltRgGrpLocListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Guideline Group Location combo
	  * </pre>
	  */
	public LocationDBDAORsltRgGrpLocListVORSQL(){
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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltRgGrpLocListVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", GRP_LOC_SEQ" ).append("\n"); 
		query.append(", ORG_DEST_TP_CD ORG_DEST_CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_CD CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("#if (${org_dest_cd} != '' && ${org_dest_cd} != 'null')" ).append("\n"); 
		query.append("AND (ORG_DEST_TP_CD = 'B' OR ORG_DEST_TP_CD = @[org_dest_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY PRC_GRP_LOC_CD ASC" ).append("\n"); 

	}
}