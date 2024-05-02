/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpNotHdrVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpNotHdrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * note header seq를 변경한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpNotHdrVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpNotHdrVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_MN SET" ).append("\n"); 
		query.append("NOTE_HDR_SEQ =" ).append("\n"); 
		query.append("#if (${is_glcopy} == 'Y')" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NOTE_HDR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", EXP_DT" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY EFF_DT DESC, PRC_CUST_TP_CD ASC) CHECK_VALUE" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND (PRC_CUST_TP_CD = @[prc_cust_tp_cd] OR PRC_CUST_TP_CD IS NULL)" ).append("\n"); 
		query.append("AND CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt],'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CHECK_VALUE = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}