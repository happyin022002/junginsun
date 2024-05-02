/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAORsltLocCdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationProposalDBDAORsltLocCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SVC_SCP_LMT, MDM_LOCATION
	  * </pre>
	  */
	public RFAGroupLocationProposalDBDAORsltLocCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration ").append("\n"); 
		query.append("FileName : RFAGroupLocationProposalDBDAORsltLocCdListVORSQL").append("\n"); 
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
		query.append("#if (${etc1} != 'B')" ).append("\n"); 
		query.append("SELECT B.LOC_CD CD" ).append("\n"); 
		query.append(", B.LOC_NM NM" ).append("\n"); 
		query.append(", B.SCONTI_CD ETC1" ).append("\n"); 
		query.append(", (SELECT SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND DELT_FLG = 'N') AS ETC2" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append(", MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND B.LOC_CD      = @[cd]" ).append("\n"); 
		query.append("AND A.ORG_DEST_CD = @[etc1]" ).append("\n"); 
		query.append("AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND A.RGN_CD      = B.RGN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CD" ).append("\n"); 
		query.append(", NM" ).append("\n"); 
		query.append(", ETC1" ).append("\n"); 
		query.append(", ETC2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.LOC_CD CD" ).append("\n"); 
		query.append(", B.LOC_NM NM" ).append("\n"); 
		query.append(", B.SCONTI_CD ETC1" ).append("\n"); 
		query.append(", (SELECT SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND DELT_FLG = 'N') AS ETC2" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append(", MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND B.LOC_CD      = @[cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND A.RGN_CD      = B.RGN_CD )" ).append("\n"); 
		query.append("GROUP BY CD, NM, ETC1, ETC2 HAVING COUNT(*)>1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}