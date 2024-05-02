/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpHdrVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.15 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpHdrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAOPriSpHdrVOUSQL
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpHdrVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_prpr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpHdrVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_HDR SET" ).append("\n"); 
		query.append("  SC_NO                 = DECODE(@[sc_no],'INIT',NULL, NVL(@[sc_no],SC_NO)) ," ).append("\n"); 
		query.append("  PROP_PRPR_FLG         = NVL(@[prop_prpr_flg],PROP_PRPR_FLG)           ," ).append("\n"); 
		query.append("  ORG_PROP_NO           = NVL(@[org_prop_no],ORG_PROP_NO)               ," ).append("\n"); 
		query.append("  ORG_AMDT_SEQ          = NVL(@[org_amdt_seq],ORG_AMDT_SEQ)             ," ).append("\n"); 
		query.append("  UPD_USR_ID            = @[upd_usr_id]                                 ," ).append("\n"); 
		query.append("  UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	PROP_NO = @[prop_no]" ).append("\n"); 

	}
}