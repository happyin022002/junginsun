/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAgentRateMinCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOSearchAgentRateMinCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAgentRateMinCommListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSearchAgentRateMinCommListRSQL").append("\n"); 
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
		query.append("SELECT AGN_CD," ).append("\n"); 
		query.append("       AGN_AGMT_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       AC_TP_CD," ).append("\n"); 
		query.append("       AGN_AGMT_SEQ, " ).append("\n"); 
		query.append("	   AGN_AGMT_MIN_COMM_SEQ," ).append("\n"); 
		query.append("	   MIN_COMM_DIV_CD," ).append("\n"); 
		query.append("	   MIN_COMM_RT," ).append("\n"); 
		query.append("	   MIN_COMM_CURR_CD," ).append("\n"); 
		query.append("	   MIN_COMM_PER_CD," ).append("\n"); 
		query.append("	   MIN_COMM_NET_REV_AMT," ).append("\n"); 
		query.append("	   MIN_COMM_NET_REV_CURR_CD," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("	   UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_MIN_COMM " ).append("\n"); 
		query.append(" WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("   AND AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append(" ORDER BY AGN_AGMT_MIN_COMM_SEQ" ).append("\n"); 

	}
}