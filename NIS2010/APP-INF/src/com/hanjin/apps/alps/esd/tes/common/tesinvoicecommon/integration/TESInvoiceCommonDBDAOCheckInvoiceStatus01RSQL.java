/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOCheckInvoiceStatus01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.05 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOCheckInvoiceStatus01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice의 상태를 확인 ( CSR No )
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOCheckInvoiceStatus01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sts_rc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sts_csr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sts_cf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOCheckInvoiceStatus01RSQL").append("\n"); 
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
		query.append("SELECT	INV_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(DELT_FLG,'N') = 'Y' THEN 'D'" ).append("\n"); 
		query.append("WHEN NVL(TML_INV_RJCT_STS_CD,'N') = 'RJ' THEN 'R'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[mode] = @[inv_sts_rc] THEN  -- Invoice update하고자 할 때" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TML_INV_STS_CD IN ('R') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN @[mode] = @[inv_sts_cf] THEN  -- CSR 생성 할 때와 invoice confirm을 풀 때" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TML_INV_STS_CD IN ('C') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN @[mode] = @inv_sts_ar] THEN  -- Approval Requested 상태의 CSR을 cancel하고자 할 때" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TML_INV_STS_CD IN ('A') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN @[mode] = @[inv_sts_csr] THEN  -- CSR cancel하고자 할 때" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TML_INV_STS_CD IN ('A','P') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE 'M'  -- MODE가 제대로 입력되지 않았을 경우" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END STS" ).append("\n"); 
		query.append("FROM	TES_TML_SO_HDR" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		CSR_NO	= @[csr_no]" ).append("\n"); 

	}
}