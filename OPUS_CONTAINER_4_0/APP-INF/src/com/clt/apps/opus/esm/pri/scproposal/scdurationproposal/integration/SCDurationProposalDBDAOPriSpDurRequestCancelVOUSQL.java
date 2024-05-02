/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalDBDAOPriSpDurRequestCancelVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.02 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCDurationProposalDBDAOPriSpDurRequestCancelVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Cancel시 Accept데이터를 Init로 변경한다.
	  * </pre>
	  */
	public SCDurationProposalDBDAOPriSpDurRequestCancelVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration").append("\n"); 
		query.append("FileName : SCDurationProposalDBDAOPriSpDurRequestCancelVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_DUR SET" ).append("\n"); 
		query.append("PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append(", ACPT_USR_ID = ''" ).append("\n"); 
		query.append(", ACPT_OFC_CD = ''" ).append("\n"); 
		query.append(", ACPT_DT     = ''" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE  PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 
		query.append("AND    N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}