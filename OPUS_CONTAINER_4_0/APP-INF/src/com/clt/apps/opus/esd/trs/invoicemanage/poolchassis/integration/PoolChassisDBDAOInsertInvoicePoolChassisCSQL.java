/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PoolChassisDBDAOInsertInvoicePoolChassisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOInsertInvoicePoolChassisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Work 테이블에 자료를 입력한다.
	  * </pre>
	  */
	public PoolChassisDBDAOInsertInvoicePoolChassisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hidden_chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pool_chss_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOInsertInvoicePoolChassisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_WRK (" ).append("\n"); 
		query.append("   INV_NO" ).append("\n"); 
		query.append("  ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("  ,TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("  ,INV_CURR_CD" ).append("\n"); 
		query.append("  ,INV_BZC_AMT" ).append("\n"); 
		query.append("  ,INV_TTL_AMT" ).append("\n"); 
		query.append("  ,INV_RCV_DT" ).append("\n"); 
		query.append("  ,INV_ISS_DT" ).append("\n"); 
		query.append("  ,INV_VAT_AMT" ).append("\n"); 
		query.append("  ,POOL_CHSS_COST_YRMON" ).append("\n"); 
		query.append("  ,CHSS_POOL_CD" ).append("\n"); 
		query.append("  ,DELT_FLG" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,LOCL_CRE_DT" ).append("\n"); 
		query.append("  ,LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[inv_no]" ).append("\n"); 
		query.append("  ,@[paymt_sp_cd]" ).append("\n"); 
		query.append("  ,'SV'" ).append("\n"); 
		query.append("  ,@[inv_curr_cd]" ).append("\n"); 
		query.append("  ,NVL(@[inv_bzc_amt], 0)" ).append("\n"); 
		query.append("  ,NVL(@[inv_ttl_amt], 0)" ).append("\n"); 
		query.append("  ,TO_DATE(@[inv_rcv_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("  ,TO_DATE(@[inv_iss_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("  ,NVL(@[inv_vat_amt], 0)" ).append("\n"); 
		query.append("  ,@[pool_chss_cost_yrmon]" ).append("\n"); 
		query.append("  ,@[hidden_chss_pool_cd]" ).append("\n"); 
		query.append("  ,'N'" ).append("\n"); 
		query.append("  ,@[ofc_cd]" ).append("\n"); 
		query.append("  ,@[usr_id]" ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("  ,@[usr_id]" ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}