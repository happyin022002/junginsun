/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommExRateForRequestDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2011.01.11 추경원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommExRateForRequestDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommExRateForRequestDtl
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommExRateForRequestDtlUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommExRateForRequestDtlUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM_DTL U" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("( U.ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("U.ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("U.UPD_USR_ID," ).append("\n"); 
		query.append("U.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("CASE A.CURR_CD" ).append("\n"); 
		query.append("WHEN 'AUD'" ).append("\n"); 
		query.append("THEN ROUND" ).append("\n"); 
		query.append("( RATIO_TO_REPORT" ).append("\n"); 
		query.append("( B.ACT_LOCL_COMM_AMT" ).append("\n"); 
		query.append(") OVER" ).append("\n"); 
		query.append("( PARTITION BY" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* A.ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN 'JPY'" ).append("\n"); 
		query.append("THEN ROUND" ).append("\n"); 
		query.append("( RATIO_TO_REPORT" ).append("\n"); 
		query.append("( B.ACT_LOCL_COMM_AMT" ).append("\n"); 
		query.append(") OVER" ).append("\n"); 
		query.append("( PARTITION BY" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* A.ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE B.ACT_USD_COMM_AMT" ).append("\n"); 
		query.append("END                                              AS ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("CASE A.CURR_CD" ).append("\n"); 
		query.append("WHEN 'USD'" ).append("\n"); 
		query.append("THEN B.ACT_USD_COMM_AMT" ).append("\n"); 
		query.append("WHEN 'JPY'" ).append("\n"); 
		query.append("THEN ROUND" ).append("\n"); 
		query.append("( RATIO_TO_REPORT" ).append("\n"); 
		query.append("( B.ACT_USD_COMM_AMT" ).append("\n"); 
		query.append(") OVER" ).append("\n"); 
		query.append("( PARTITION BY" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* A.ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN 'TWD'" ).append("\n"); 
		query.append("THEN ROUND" ).append("\n"); 
		query.append("( RATIO_TO_REPORT" ).append("\n"); 
		query.append("( B.ACT_USD_COMM_AMT" ).append("\n"); 
		query.append(") OVER" ).append("\n"); 
		query.append("( PARTITION BY" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* A.ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE ROUND" ).append("\n"); 
		query.append("( RATIO_TO_REPORT" ).append("\n"); 
		query.append("( B.ACT_USD_COMM_AMT" ).append("\n"); 
		query.append(") OVER" ).append("\n"); 
		query.append("( PARTITION BY" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* A.ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END                                             AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("@[upd_usr_id]                               AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                     AS UPD_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM     A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL B" ).append("\n"); 
		query.append("WHERE A.BKG_NO         = U.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD         = U.AGN_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("AND A.IO_BND_CD      = U.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ         = U.AC_SEQ" ).append("\n"); 
		query.append("--                  AND A.CRE_USR_ID    != 'COST'" ).append("\n"); 
		query.append("AND A.AC_TP_CD       = U.AC_TP_CD" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD   = U.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE U.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND U.AGN_CD         = @[agn_cd]" ).append("\n"); 
		query.append("AND U.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("AND U.IO_BND_CD      = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND U.AC_SEQ         = @[ac_seq]" ).append("\n"); 
		query.append("--       AND U.CRE_USR_ID    != 'COST'" ).append("\n"); 

	}
}