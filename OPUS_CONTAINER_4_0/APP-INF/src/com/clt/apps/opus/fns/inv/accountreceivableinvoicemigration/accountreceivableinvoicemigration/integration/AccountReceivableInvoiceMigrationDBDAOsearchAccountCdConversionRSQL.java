/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL.java
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

public class AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[chg_cd], 'TVA', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', '212111')," ).append("\n"); 
		query.append("                         'CTX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'JP','212111','411915'))," ).append("\n"); 
		query.append("                         'CDX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'JP','212111','411915'))," ).append("\n"); 
		query.append("                         'GST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'IN','212111','411915'))," ).append("\n"); 
		query.append("                         'AST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'AU','212111','411915'))," ).append("\n"); 
		query.append("                         'VDT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111','411915'))," ).append("\n"); 
		query.append("                         'VTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111','411915'))," ).append("\n"); 
		query.append("                         'VRT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111','411915'))," ).append("\n"); 
		query.append("                         'FAC', '512641'," ).append("\n"); 
		query.append("                         'TPC', '411915'," ).append("\n"); 
		query.append("                         DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MTP', '957112', 'MBN', '954113', 'MRD', DECODE(@[chg_cd], 'XXX', '954113', @[acct_cd]),@[acct_cd])) ACCT_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd] " ).append("\n"); 

	}
}