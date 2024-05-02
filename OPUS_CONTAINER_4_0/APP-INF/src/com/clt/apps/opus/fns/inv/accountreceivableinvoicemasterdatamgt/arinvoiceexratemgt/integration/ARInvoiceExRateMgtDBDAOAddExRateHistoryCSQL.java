/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOAddExRateHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOAddExRateHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddExRateHistory
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOAddExRateHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_sts_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOAddExRateHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_DLY_XCH_RT_HIS (" ).append("\n"); 
		query.append("    HIS_SEQ " ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	FM_DT" ).append("\n"); 
		query.append(",	TO_DT" ).append("\n"); 
		query.append(",	CHG_CURR_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	IVS_XCH_RT" ).append("\n"); 
		query.append(",   CNG_RMK" ).append("\n"); 
		query.append(",   OP_STS_NM" ).append("\n"); 
		query.append(",   LOCL_CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    INV_DLY_XCH_RT_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",   REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append(",   REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append(",	@[chg_curr_cd]" ).append("\n"); 
		query.append(",	@[locl_curr_cd]" ).append("\n"); 
		query.append(",	@[ar_ofc_cd]" ).append("\n"); 
		query.append(",	DECODE(IASO.XCH_RT_RVS_FLG,'Y',ROUND(1/TO_NUMBER(@[inv_xch_rt]),6),@[inv_xch_rt])" ).append("\n"); 
		query.append(",	DECODE(IASO.XCH_RT_RVS_FLG,'Y',@[inv_xch_rt],ROUND(1/TO_NUMBER(@[inv_xch_rt]),6))" ).append("\n"); 
		query.append(",   @[cng_rmk]" ).append("\n"); 
		query.append(",   @[op_sts_nm]" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC IASO" ).append("\n"); 
		query.append("WHERE IASO.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}