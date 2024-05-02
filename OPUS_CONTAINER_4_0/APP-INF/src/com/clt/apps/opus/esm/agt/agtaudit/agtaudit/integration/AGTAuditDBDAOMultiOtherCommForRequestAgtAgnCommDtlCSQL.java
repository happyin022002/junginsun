/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlCSQL.java
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

public class AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOtherCommForRequestAgtAgnCommDtl
	  * </pre>
	  */
	public AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommDtlCSQL").append("\n"); 
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
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[bkg_no]         AS BKG_NO," ).append("\n"); 
		query.append("AGN_CD            AS AGN_CD," ).append("\n"); 
		query.append("'O'               AS IO_BND_CD," ).append("\n"); 
		query.append("'T'               AS AC_TP_CD," ).append("\n"); 
		query.append("'BX'              AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("1                 AS AC_SEQ," ).append("\n"); 
		query.append("1                 AS BKG_VOL_QTY," ).append("\n"); 
		query.append("CURR_CD           AS LOCL_CURR_CD," ).append("\n"); 
		query.append("ACT_COMM_AMT      AS ACT_USD_COMM_AMT," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT AS ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("CRE_USR_ID        AS CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT            AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID        AS UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT            AS UPD_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}