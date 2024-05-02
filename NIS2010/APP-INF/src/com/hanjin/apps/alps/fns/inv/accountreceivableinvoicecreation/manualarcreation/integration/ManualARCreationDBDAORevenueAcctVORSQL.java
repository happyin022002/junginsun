/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManualARCreationDBDAORevenueAcctVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAORevenueAcctVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ManualARCreationDBDAORevenueAcctVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAORevenueAcctVORSQL").append("\n"); 
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
		query.append("SELECT ACCT_CD," ).append("\n"); 
		query.append("  ACCT_ENG_NM," ).append("\n"); 
		query.append("  nvl(REV_TP_SRC_CD, 'XXX') as REV_CD," ).append("\n"); 
		query.append("  nvl(CHG_CD, 'N') as CHG_CD," ).append("\n"); 
		query.append("  REP_CHG_CD," ).append("\n"); 
		query.append("  ACCT_KRN_NM" ).append("\n"); 
		query.append("FROM INV_REV_ACCT_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} == 'HAMRU' || ${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("WHERE ACCT_CD in ('411531'," ).append("\n"); 
		query.append("      '411541'," ).append("\n"); 
		query.append("      '411591'," ).append("\n"); 
		query.append("      '411911'," ).append("\n"); 
		query.append("      '411915'," ).append("\n"); 
		query.append("      '212111'," ).append("\n"); 
		query.append("	  '411917')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE (ACCT_CD in ('411531'," ).append("\n"); 
		query.append("       '411541'," ).append("\n"); 
		query.append("       '411591'," ).append("\n"); 
		query.append("       '411911'," ).append("\n"); 
		query.append("       '411915'," ).append("\n"); 
		query.append("       '212111')" ).append("\n"); 
		query.append("      OR (ACCT_CD ='411991' AND REV_TP_SRC_CD='OTH' )" ).append("\n"); 
		query.append("	  #if (${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("        OR ACCT_CD = '411917'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  AND INV_SRC_CD = 'OTH'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ACCT_CD," ).append("\n"); 
		query.append("  ACCT_ENG_NM," ).append("\n"); 
		query.append("  'XXX' as REV_CD," ).append("\n"); 
		query.append("  DECODE(ACCT_CD, '212111', 'TVA', 'XXX') as CHG_CD," ).append("\n"); 
		query.append("  DECODE(ACCT_CD, '212111', 'CST', 'XXX') as REP_CHG_CD," ).append("\n"); 
		query.append("  ACCT_KRN_NM" ).append("\n"); 
		query.append("FROM mdm_account" ).append("\n"); 
		query.append("WHERE ACCT_CD in ('212111'," ).append("\n"); 
		query.append("      '957112'," ).append("\n"); 
		query.append("      '954111'," ).append("\n"); 
		query.append("      '422011'," ).append("\n"); 
		query.append("      '710111')   " ).append("\n"); 
		query.append("ORDER BY ACCT_CD" ).append("\n"); 

	}
}