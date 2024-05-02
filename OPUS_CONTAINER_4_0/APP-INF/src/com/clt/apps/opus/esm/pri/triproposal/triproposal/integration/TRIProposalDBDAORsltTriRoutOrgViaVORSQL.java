/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAORsltTriRoutOrgViaVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.04 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltTriRoutOrgViaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRI Origin Via. 조회
	  * </pre>
	  */
	public TRIProposalDBDAORsltTriRoutOrgViaVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltTriRoutOrgViaVORSQL").append("\n"); 
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
		query.append("SELECT TRI_PROP_NO" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append(",(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_TRI_RT_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("ORDER BY ROUT_VIA_PORT_CD" ).append("\n"); 

	}
}