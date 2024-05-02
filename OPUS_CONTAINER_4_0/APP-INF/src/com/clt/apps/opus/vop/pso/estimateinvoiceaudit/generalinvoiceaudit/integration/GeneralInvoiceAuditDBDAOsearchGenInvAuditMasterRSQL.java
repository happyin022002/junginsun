/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchGenInvAuditMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_CHARGE Master Search
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchGenInvAuditMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchGenInvAuditMasterRSQL").append("\n"); 
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
		query.append("SELECT T1.ISS_CTY_CD" ).append("\n"); 
		query.append("     , T1.SO_SEQ" ).append("\n"); 
		query.append("     , T1.YD_CD YD_CD" ).append("\n"); 
		query.append("     , T1.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("     , T1.COST_OFC_CD COST_OFC_CD" ).append("\n"); 
		query.append("     , T1.INV_OFC_CD" ).append("\n"); 
		query.append("     , T1.INV_NO" ).append("\n"); 
		query.append("     , T1.CURR_CD" ).append("\n"); 
		query.append("     , T1.TTL_LOCL_AMT TTL_LOCL_AMT" ).append("\n"); 
		query.append("     , TTL_USD_AMT" ).append("\n"); 
		query.append("     , T1.INV_LOCL_AMT INV_LOCL_AMT" ).append("\n"); 
		query.append("     , T1.LOCL_TAX_AMT" ).append("\n"); 
		query.append("     , T1.LOCL_NET_AMT" ).append("\n"); 
		query.append("     , T1.LOCL_DDCT_AMT" ).append("\n"); 
		query.append("     , T1.LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(T1.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("     , TO_CHAR(T1.ISS_DT, 'YYYYMMDD') ISS_DT" ).append("\n"); 
		query.append("     , TO_CHAR(T1.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(T1.DUE_DT, 'YYYY-MM-DD') DUE_DT" ).append("\n"); 
		query.append("     , T1.PAY_TERM_DYS" ).append("\n"); 
		query.append("     , T1.PSO_CHG_STS_CD PSO_CHG_STS_CD" ).append("\n"); 
		query.append("     , T1.INV_RGST_NO" ).append("\n"); 
		query.append("     , T1.PSO_TRNS_SLP_CTNT PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("     , T1.CRE_USR_ID " ).append("\n"); 
		query.append("     , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT" ).append("\n"); 
		query.append("  FROM PSO_CHARGE T1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND T1.INV_NO = @[inv_no]" ).append("\n"); 

	}
}