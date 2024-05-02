/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyCancelAGTCommForAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyCancelAGTCommForAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGTAuditDBDAOModifyCancelAGTCommForAudit
	  * </pre>
	  */
	public AGTAuditDBDAOModifyCancelAGTCommForAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyCancelAGTCommForAuditUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM" ).append("\n"); 
		query.append("SET COMM_PROC_STS_CD  = 'CA'," ).append("\n"); 
		query.append("#if (${sts_cd} != '1')" ).append("\n"); 
		query.append("COMM_PROC_STS_RSN = 'Approval Cancel!'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("COMM_PROC_STS_RSN = 'Request Cancel!'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AC_RQST_USR_ID   = NULL," ).append("\n"); 
		query.append("AC_RQST_USR_EML  = NULL," ).append("\n"); 
		query.append("AC_RQST_DT       = NULL," ).append("\n"); 
		query.append("COMM_APRO_NO     = NULL," ).append("\n"); 
		query.append("AC_APRO_USR_ID   = NULL," ).append("\n"); 
		query.append("AC_APRO_USR_EML  = NULL," ).append("\n"); 
		query.append("AC_APRO_DT       = NULL," ).append("\n"); 
		query.append("UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD           = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD        = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD        <> 'T'" ).append("\n"); 
		query.append("AND AC_SEQ           = @[ac_seq]" ).append("\n"); 
		query.append("#if (${sts_cd} != '1')" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD IN('RS','RM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}