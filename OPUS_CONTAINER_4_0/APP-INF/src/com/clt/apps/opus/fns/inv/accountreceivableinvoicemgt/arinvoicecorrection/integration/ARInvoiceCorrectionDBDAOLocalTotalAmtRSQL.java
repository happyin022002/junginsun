/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOLocalTotalAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.11.25 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOLocalTotalAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE MAIN 테이블에서 LOCAL TOTAL AMT의 총합을 구한다.
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOLocalTotalAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOLocalTotalAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(NVL(INV_TTL_LOCL_AMT,0)),0) AMT_TOT" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND REV_TP_CD IN ('B','C')" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND REV_VSL_CD||REV_SKD_VOY_NO||REV_SKD_DIR_CD||REV_DIR_CD = @[old_vvd]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}