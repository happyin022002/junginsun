/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
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

public class AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommForAuditAgtAgnCommDtl
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommDtlCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommForAuditAgtAgnCommDtlCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AGT_AGN_COMM_DTL" ).append("\n"); 
		query.append("( BKG_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("AC_SEQ," ).append("\n"); 
		query.append("BKG_VOL_QTY," ).append("\n"); 
		query.append("LOCL_CURR_CD," ).append("\n"); 
		query.append("ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.BKG_NO                                    AS BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD                                    AS AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD                                   AS IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD                                    AS AC_TP_CD," ).append("\n"); 
		query.append("B.TPSZ                                      AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("AC_SEQ                                      AS AC_SEQ," ).append("\n"); 
		query.append("B.QTY                                       AS BKG_VOL_QTY," ).append("\n"); 
		query.append("A.CURR_CD                                   AS CURR_CD," ).append("\n"); 
		query.append("ROUND (A.ACT_IF_COMM_AMT * DECODE (A.AC_TP_CD, 'G', B.QTY_RATIO, 'K', B.QTY_RATIO, B.QTY_RATIO_TPSZ), 2)       AS ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("ROUND (A.ACT_IF_LOCL_COMM_AMT * DECODE (A.AC_TP_CD, 'G', B.QTY_RATIO, 'K', B.QTY_RATIO, B.QTY_RATIO_TPSZ), 2)  AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("@[upd_usr_id]                               AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                     AS UPD_DT," ).append("\n"); 
		query.append("@[cre_usr_id]                               AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                     AS UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AC_SEQ," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD       = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD    = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD    <> 'T'" ).append("\n"); 
		query.append("AND AC_SEQ       = @[ac_seq]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("DISTINCT BKG_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("OP_CNTR_QTY QTY," ).append("\n"); 
		query.append("RATIO_TO_REPORT(OP_CNTR_QTY) OVER(PARTITION BY BKG_NO, CNTR_TPSZ_CD) AS QTY_RATIO_TPSZ," ).append("\n"); 
		query.append("RATIO_TO_REPORT(OP_CNTR_QTY) OVER(PARTITION BY BKG_NO)               AS QTY_RATIO" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.BKG_NO                = B.BKG_NO(+)" ).append("\n"); 

	}
}