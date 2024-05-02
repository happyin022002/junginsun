/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalDBDAORsltCtrtCluzListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.22 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAORsltCtrtCluzListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteProposalDBDAORsltCtrtCluzListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAORsltCtrtCluzListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PM.PROP_NO" ).append("\n"); 
		query.append(",    PM.AMDT_SEQ" ).append("\n"); 
		query.append(",    CM.SVC_SCP_CD" ).append("\n"); 
		query.append(",    CM.GLINE_SEQ" ).append("\n"); 
		query.append(",    CM.CTRT_CLUZ_SEQ" ).append("\n"); 
		query.append(",    CM.NOTE_CLSS_CD" ).append("\n"); 
		query.append(",    CD.CTRT_CLUZ_DTL_SEQ" ).append("\n"); 
		query.append(",    CD.CHG_CD" ).append("\n"); 
		query.append(",    CD.CTRT_CLUZ_CTNT" ).append("\n"); 
		query.append("FROM  PRI_SP_SCP_MN PM" ).append("\n"); 
		query.append(", PRI_SG_MN GM" ).append("\n"); 
		query.append(", PRI_SG_CTRT_CLUZ CM" ).append("\n"); 
		query.append(", PRI_SG_CTRT_CLUZ_DTL CD" ).append("\n"); 
		query.append("WHERE PM.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   PM.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   PM.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   GM.SVC_SCP_CD = PM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   GM.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   PM.EFF_DT BETWEEN GM.EFF_DT AND GM.EXP_DT" ).append("\n"); 
		query.append("AND   CM.SVC_SCP_CD = GM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   CM.GLINE_SEQ = GM.GLINE_SEQ" ).append("\n"); 
		query.append("AND   CM.NOTE_CLSS_CD = @[note_clss_cd]" ).append("\n"); 
		query.append("AND   CD.SVC_SCP_CD = CM.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   CD.GLINE_SEQ = CM.GLINE_SEQ" ).append("\n"); 
		query.append("AND   CD.CTRT_CLUZ_SEQ = CM.CTRT_CLUZ_SEQ" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND   CD.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CM.SVC_SCP_CD" ).append("\n"); 
		query.append(", CM.GLINE_SEQ" ).append("\n"); 
		query.append(", CM.CTRT_CLUZ_SEQ" ).append("\n"); 
		query.append(", CD.CTRT_CLUZ_DTL_SEQ" ).append("\n"); 

	}
}