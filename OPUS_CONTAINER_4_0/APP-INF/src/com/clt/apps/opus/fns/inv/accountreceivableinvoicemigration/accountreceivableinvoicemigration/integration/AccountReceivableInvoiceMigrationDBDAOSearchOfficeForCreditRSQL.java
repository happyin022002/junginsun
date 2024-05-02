/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchOfficeForCreditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchOfficeForCreditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Office For Credit
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchOfficeForCreditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchOfficeForCreditRSQL").append("\n"); 
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
		query.append("#if (${due_dt} != '') " ).append("\n"); 
		query.append("-- 화면에서 넘겨준 DUE DT 가 있을때" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'N' CR_FLG," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("                      TO_CHAR(TO_DATE(REPLACE(@[sail_arr_dt], '-', ''), 'YYYYMMDD') + NVL(IB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                              'YYYYMMDD')," ).append("\n"); 
		query.append("                      TO_CHAR(TO_DATE(REPLACE(@[sail_arr_dt], '-', ''), 'YYYYMMDD') + NVL(OB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                              'YYYYMMDD')) DUE_DT," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'I', NVL(IB_CR_TERM_DYS, 0), NVL(OB_CR_TERM_DYS, 0)) CR_TERM" ).append("\n"); 
		query.append("  FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'N' CR_FLG," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("                      TO_CHAR(SYSDATE + NVL(IB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                              'YYYYMMDD')," ).append("\n"); 
		query.append("                      TO_CHAR(SYSDATE + NVL(OB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                              'YYYYMMDD')) DUE_DT," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'I', NVL(IB_CR_TERM_DYS, 0), NVL(OB_CR_TERM_DYS, 0)) CR_TERM" ).append("\n"); 
		query.append("  FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}