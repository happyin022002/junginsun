/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateAGTCSRHeaderAgtAgnCommDtl
	  * </pre>
	  */
	public AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCreateAGTCSRHeaderAgtAgnCommDtlUSQL").append("\n"); 
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
		query.append("UPDATE /*+ bypass_ujvc */" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("B.ACT_USD_COMM_AMT + A.ACT_USD_COMM_AMT  AS A_ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("B.ACT_LOCL_COMM_AMT + A.ACT_LOCL_COMM_AMT AS A_ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("@[upd_usr_id]       AS A_UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE             AS A_UPD_DT," ).append("\n"); 
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("B.AGN_CD," ).append("\n"); 
		query.append("B.IO_BND_CD," ).append("\n"); 
		query.append("B.AC_TP_CD," ).append("\n"); 
		query.append("B.AC_SEQ," ).append("\n"); 
		query.append("B.ACT_USD_COMM_AMT  AS B_ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("B.ACT_LOCL_COMM_AMT AS B_ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.UPD_USR_ID        AS B_UPD_USR_ID," ).append("\n"); 
		query.append("B.UPD_DT            AS B_UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("A.ACT_IF_COMM_AMT      - SUM (B.ACT_USD_COMM_AMT)  AS ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_IF_LOCL_COMM_AMT - SUM (B.ACT_LOCL_COMM_AMT) AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM BKG_QUANTITY X" ).append("\n"); 
		query.append("WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM   = 1" ).append("\n"); 
		query.append(") AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM        A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL    B" ).append("\n"); 
		query.append("WHERE A.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD            = B.AGN_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD         = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD          = B.AC_TP_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ            = B.AC_SEQ" ).append("\n"); 
		query.append("AND A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("AND A.AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD  = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("${com_apr_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("A.ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("A.ACT_IF_LOCL_COMM_AMT" ).append("\n"); 
		query.append("HAVING A.ACT_IF_COMM_AMT - SUM (B.ACT_USD_COMM_AMT)+1 <> 0" ).append("\n"); 
		query.append("OR A.ACT_IF_LOCL_COMM_AMT - SUM (B.ACT_LOCL_COMM_AMT) <> 0" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL    B" ).append("\n"); 
		query.append("WHERE A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD        = B.AGN_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD     = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD      = B.AC_TP_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ        = B.AC_SEQ" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD  = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET B_ACT_USD_COMM_AMT  = A_ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("B_ACT_LOCL_COMM_AMT = A_ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("B_UPD_USR_ID        = A_UPD_USR_ID," ).append("\n"); 
		query.append("B_UPD_DT            = A_UPD_DT" ).append("\n"); 

	}
}