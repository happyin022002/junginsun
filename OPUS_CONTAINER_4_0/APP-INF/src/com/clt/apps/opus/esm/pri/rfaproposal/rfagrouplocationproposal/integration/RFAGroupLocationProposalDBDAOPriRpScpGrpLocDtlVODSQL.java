/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.10 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP SCP GRP LOC DTL 삭제   
	  * </pre>
	  */
	public RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grp_loc_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationProposalDBDAOPriRpScpGrpLocDtlVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GRP_LOC_SEQ = @[grp_loc_seq]" ).append("\n"); 
		query.append("#if (${IS_CASCADE} != \"Y\")" ).append("\n"); 
		query.append("AND GRP_LOC_DTL_SEQ = @[grp_loc_dtl_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}