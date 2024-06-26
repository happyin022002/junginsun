/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOCheckMaxIfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.06.22 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOCheckMaxIfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOCheckMaxIfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOCheckMaxIfNoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 
		query.append(" WHERE @[ar_if_no] = (SELECT MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                          FROM INV_AR_MN" ).append("\n"); 
		query.append("                         WHERE AR_OFC_CD = @[ar_ofc_cd]					 " ).append("\n"); 
		query.append("                           AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                           AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND NVL(INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("                           AND NVL(INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND BL_SRC_NO  = @[bl_src_no])" ).append("\n"); 

	}
}