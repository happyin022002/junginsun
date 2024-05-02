/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCProposalMainDBDAOaddContractDeleteHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.06.21 김경미
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

public class SCProposalMainDBDAOaddContractDeleteHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약 삭제 history 관리
	  * </pre>
	  */
	public SCProposalMainDBDAOaddContractDeleteHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_delt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOaddContractDeleteHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_CTRT_DELT_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" PROP_NO," ).append("\n"); 
		query.append(" AMDT_SEQ," ).append("\n"); 
		query.append(" PRC_CTRT_DELT_DT," ).append("\n"); 
		query.append(" PRC_CTRT_TP_CD," ).append("\n"); 
		query.append(" PRC_CTRT_NO," ).append("\n"); 
		query.append(" PRC_CTRT_DELT_USR_ID," ).append("\n"); 
		query.append(" PRC_CTRT_CRE_USR_ID," ).append("\n"); 
		query.append(" PRC_CTRT_CRE_DT," ).append("\n"); 
		query.append(" PRC_CTRT_DELT_RMK," ).append("\n"); 
		query.append(" CRE_USR_ID," ).append("\n"); 
		query.append(" CRE_DT," ).append("\n"); 
		query.append(" UPD_USR_ID," ).append("\n"); 
		query.append(" UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PROP_NO," ).append("\n"); 
		query.append("       AMDT_SEQ," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       'S'," ).append("\n"); 
		query.append("       ''," ).append("\n"); 
		query.append("       @[prc_ctrt_delt_usr_id]," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       NVL(@[prc_ctrt_delt_rmk], '')," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("FROM PRI_SP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}