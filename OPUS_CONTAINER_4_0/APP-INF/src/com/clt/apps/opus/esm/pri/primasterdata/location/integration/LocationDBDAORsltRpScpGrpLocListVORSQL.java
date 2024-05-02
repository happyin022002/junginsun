/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltRpScpGrpLocListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.27 최성민
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

public class LocationDBDAORsltRpScpGrpLocListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal Group Location combo
	  * </pre>
	  */
	public LocationDBDAORsltRpScpGrpLocListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltRpScpGrpLocListVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.PROP_NO" ).append("\n"); 
		query.append(", A.AMDT_SEQ" ).append("\n"); 
		query.append(", A.GRP_LOC_SEQ" ).append("\n"); 
		query.append(", A.PRC_GRP_LOC_CD CD" ).append("\n"); 
		query.append(", A.PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC A" ).append("\n"); 
		query.append(", ( SELECT DISTINCT SVC_SCP_CD, PROP_NO, AMDT_SEQ, GRP_LOC_SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE SRC_INFO_CD != 'AD' ) B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ = B.GRP_LOC_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.PROP_NO 	= @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 
		query.append("#if (${org_dest_cd} != '' && ${org_dest_cd} != 'null')" ).append("\n"); 
		query.append("AND (A.ORG_DEST_TP_CD = 'B' OR A.ORG_DEST_TP_CD = @[org_dest_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.PRC_GRP_LOC_CD ASC" ).append("\n"); 

	}
}