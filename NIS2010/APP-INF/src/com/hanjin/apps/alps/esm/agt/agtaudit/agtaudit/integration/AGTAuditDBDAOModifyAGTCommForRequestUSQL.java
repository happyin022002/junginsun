/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommForRequestUSQL.java
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

public class AGTAuditDBDAOModifyAGTCommForRequestUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyAGTCommForRequestMaster
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommForRequestUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dly_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AGTAuditDBDAOModifyAGTCommForRequestUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM U" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("( U.ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("U.COMM_PROC_STS_CD," ).append("\n"); 
		query.append("U.COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("U.AC_RQST_USR_ID," ).append("\n"); 
		query.append("U.AC_RQST_USR_EML," ).append("\n"); 
		query.append("U.AC_RQST_DT," ).append("\n"); 
		query.append("U.AC_APRO_USR_ID," ).append("\n"); 
		query.append("U.AC_APRO_USR_EML," ).append("\n"); 
		query.append("U.AC_APRO_DT," ).append("\n"); 
		query.append("U.UPD_USR_ID," ).append("\n"); 
		query.append("U.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("CASE A.ACT_IF_LOCL_COMM_AMT" ).append("\n"); 
		query.append("WHEN 0" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("CASE A.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append("WHEN '3'" ).append("\n"); 
		query.append("THEN ROUND (A.ACT_COMM_AMT * TO_NUMBER(@[dly_xch_rt]), 2)" ).append("\n"); 
		query.append("WHEN '1'" ).append("\n"); 
		query.append("THEN ROUND (A.ACT_COMM_AMT * TO_NUMBER(@[vvd_xch_rt]), 2)" ).append("\n"); 
		query.append("ELSE A.ACT_LOCL_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE A.ACT_LOCL_COMM_AMT" ).append("\n"); 
		query.append("END                                             AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("'RS'                                        AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("'Request OK!'                               AS COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("@[ac_rqst_usr_id]                           AS AC_RQST_USR_ID," ).append("\n"); 
		query.append("@[ac_rqst_usr_eml]                          AS AC_RQST_USR_EML," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND OFC_CD = DECODE(VNDR_CNT_CD,'CN',@[ar_ofc_cd], @[agn_cd])" ).append("\n"); 
		query.append(")                                             AS AC_RQST_DT," ).append("\n"); 
		query.append("NULL                                        AS AC_APRO_USR_ID," ).append("\n"); 
		query.append("NULL                                        AS AC_APRO_USR_EML," ).append("\n"); 
		query.append("NULL                                        AS AC_APRO_DT," ).append("\n"); 
		query.append("@[upd_usr_id]                               AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                     AS UPD_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM     A" ).append("\n"); 
		query.append("WHERE A.BKG_NO         = U.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD         = U.AGN_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("AND A.IO_BND_CD      = U.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ         = U.AC_SEQ" ).append("\n"); 
		query.append("AND A.CRE_USR_ID    != 'COST'" ).append("\n"); 
		query.append("AND A.AC_TP_CD       = U.AC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE U.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND U.AGN_CD         = @[agn_cd]" ).append("\n"); 
		query.append("AND U.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("AND U.IO_BND_CD      = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND U.AC_SEQ         = @[ac_seq]" ).append("\n"); 
		query.append("AND U.CRE_USR_ID    != 'COST'" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD = 'CS'" ).append("\n"); 

	}
}