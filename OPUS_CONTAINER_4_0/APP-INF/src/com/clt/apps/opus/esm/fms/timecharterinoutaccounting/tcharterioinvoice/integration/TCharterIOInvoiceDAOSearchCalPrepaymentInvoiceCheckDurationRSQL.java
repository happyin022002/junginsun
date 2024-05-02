/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceCheckDurationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceCheckDurationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Check duration
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceCheckDurationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceCheckDurationRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END CHK_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT MIN(EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("             , MAX(EXP_DT) AS EXP_DT" ).append("\n"); 
		query.append("          FROM FMS_HIRE FH" ).append("\n"); 
		query.append("         WHERE FH.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND EFF_DT <= TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("   AND EXP_DT >= TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI')" ).append("\n"); 

	}
}