/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.23 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkVvdLevel
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT 'OK'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("ar_mst_rev_vvd F" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("F.vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("AND F.skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("AND F.skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("mdm_account" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("acct_cd = DECODE(@[acct_cd], '110911', acct_cd, '564611', acct_cd, @[acct_cd])" ).append("\n"); 
		query.append("AND F.vvd_com_lvl IN (DECODE(vvd_lvl_flg1, 'Y', '1', ''), DECODE(vvd_lvl_flg2, 'Y', '2', '')," ).append("\n"); 
		query.append("DECODE(vvd_lvl_flg3, 'Y', '3', ''), DECODE(vvd_lvl_flg4, 'Y', '4', '')," ).append("\n"); 
		query.append("DECODE(vvd_lvl_flg5, 'Y', '5', ''), DECODE(vvd_lvl_flg6, 'Y', '6', ''))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}