/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PoolChassisDBDAOUpdateInvoicePoolChassisUSQL.java
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

public class PoolChassisDBDAOUpdateInvoicePoolChassisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Work 테이블의 자료를 수정한다.
	  * </pre>
	  */
	public PoolChassisDBDAOUpdateInvoicePoolChassisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOUpdateInvoicePoolChassisUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("   SET INV_CURR_CD          = @[inv_curr_cd]" ).append("\n"); 
		query.append("      ,INV_BZC_AMT          = NVL(@[inv_bzc_amt], 0)" ).append("\n"); 
		query.append("      ,INV_TTL_AMT          = NVL(@[inv_ttl_amt], 0)" ).append("\n"); 
		query.append("      ,INV_RCV_DT           = TO_DATE(@[inv_rcv_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,INV_ISS_DT           = TO_DATE(@[inv_iss_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,INV_VAT_AMT          = NVL(@[inv_vat_amt], 0)" ).append("\n"); 
		query.append("      ,POOL_CHSS_COST_YRMON = @[pool_chss_cost_yrmon]" ).append("\n"); 
		query.append("      ,UPD_USR_ID           = @[usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT               = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT          = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 

	}
}