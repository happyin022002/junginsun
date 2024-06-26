/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCProposalMainDBDAORevertPriSpMqcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.02.18 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORevertPriSpMqcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * File 및 Cancel PRI_SP_MQC
	  * </pre>
	  */
	public SCProposalMainDBDAORevertPriSpMqcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORevertPriSpMqcUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_MQC " ).append("\n"); 
		query.append("   SET PRC_PROG_STS_CD   = DECODE(@[prop_sts_cd], 'I', 'I', 'A') " ).append("\n"); 
		query.append("     , FNL_MQC_QTY       = DECODE(@[prop_sts_cd], 'I', 0, PROP_MQC_QTY) " ).append("\n"); 
		query.append("     , ACPT_USR_ID       = DECODE(@[prop_sts_cd], 'I', NULL, @[cre_usr_id])" ).append("\n"); 
		query.append("     , ACPT_OFC_CD       = DECODE(@[prop_sts_cd], 'I', NULL, @[prog_ofc_cd])    " ).append("\n"); 
		query.append("     , ACPT_DT           = DECODE(@[prop_sts_cd], 'I', NULL, SYSDATE)" ).append("\n"); 
		query.append("     , UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT            = SYSDATE " ).append("\n"); 
		query.append(" WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ 	     = @[amdt_seq]" ).append("\n"); 
		query.append("   AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}