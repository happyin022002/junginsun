/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyOtherCommForRequestUSQL.java
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

public class AGTAuditDBDAOModifyOtherCommForRequestUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyOtherCommForRequest
	  * </pre>
	  */
	public AGTAuditDBDAOModifyOtherCommForRequestUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_rqst_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyOtherCommForRequestUSQL").append("\n"); 
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
		query.append("SET" ).append("\n"); 
		query.append("( COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("AC_RQST_USR_ID," ).append("\n"); 
		query.append("AC_RQST_USR_EML," ).append("\n"); 
		query.append("AC_RQST_DT," ).append("\n"); 
		query.append("AC_APRO_USR_ID," ).append("\n"); 
		query.append("AC_APRO_USR_EML," ).append("\n"); 
		query.append("AC_APRO_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("'RS'                                                 AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("'Request OK!'                                        AS COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("@[ac_rqst_usr_id]                                    AS AC_RQST_USR_ID," ).append("\n"); 
		query.append("@[ac_rqst_usr_eml]                                   AS AC_RQST_USR_EML," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD) AS AC_RQST_DT," ).append("\n"); 
		query.append("NULL                                                 AS AC_APRO_USR_ID," ).append("\n"); 
		query.append("NULL                                                 AS AC_APRO_USR_EML," ).append("\n"); 
		query.append("NULL                                                 AS AC_APRO_DT," ).append("\n"); 
		query.append("@[upd_usr_id]                                        AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                              AS UPD_DT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD             = @[agn_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD       = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD    = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD     = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND AC_SEQ       = @[ac_seq]" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'CS','CA'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}