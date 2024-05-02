/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_btm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_chg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ar_inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xch_rt_usd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_n3rd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_aply_bl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_top_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_mlt_bl_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_ar_inv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ar_inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_smry_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_rvs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_inv_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_STUP_OFC (" ).append("\n"); 
		query.append("	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_ISS_TP_CD" ).append("\n"); 
		query.append(",	INV_SND_TP_CD" ).append("\n"); 
		query.append(",	DMDT_AR_INV_ISS_FLG" ).append("\n"); 
		query.append(",	N3PTY_BIL_AR_INV_FLG" ).append("\n"); 
		query.append(",	DMDT_INV_APLY_BL_FLG" ).append("\n"); 
		query.append(",	CPY_INV_KNT" ).append("\n"); 
		query.append(",	XCH_RT_RVS_FLG" ).append("\n"); 
		query.append(",	XCH_RT_USD_TP_CD" ).append("\n"); 
		query.append(",	XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(",	TML_INV_ISS_FLG" ).append("\n"); 
		query.append(",	OTS_SMRY_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	INV_DUP_FLG" ).append("\n"); 
		query.append(",	INV_MLT_BL_ISS_FLG" ).append("\n"); 
		query.append(",	INV_VAT_CHG_CD" ).append("\n"); 
		query.append(",	INV_VAT_CHG_RT" ).append("\n"); 
		query.append(",	MNR_AR_INV_ISS_FLG" ).append("\n"); 
		query.append(",   INV_TOP_RMK" ).append("\n"); 
		query.append(",	INV_BTM_RMK" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[ar_ofc_cd]" ).append("\n"); 
		query.append(",	@[inv_iss_tp_cd]" ).append("\n"); 
		query.append(",	@[inv_snd_tp_cd]" ).append("\n"); 
		query.append(",	NVL(@[dmdt_ar_inv_iss_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[n3pty_bil_ar_inv_flg],'N')" ).append("\n"); 
		query.append(",	@[dmdt_inv_aply_bl_flg]" ).append("\n"); 
		query.append(",	@[cpy_inv_knt]" ).append("\n"); 
		query.append(",	NVL(@[xch_rt_rvs_flg],'N')" ).append("\n"); 
		query.append(",	@[xch_rt_usd_tp_cd]" ).append("\n"); 
		query.append(",	@[xch_rt_n3rd_tp_cd]" ).append("\n"); 
		query.append(",	NVL(@[tml_inv_iss_flg],'N')" ).append("\n"); 
		query.append(",	@[ots_smry_cd]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[inv_dup_flg]" ).append("\n"); 
		query.append(",	@[inv_mlt_bl_iss_flg]" ).append("\n"); 
		query.append(",	@[inv_vat_chg_cd]" ).append("\n"); 
		query.append(",	NVL(@[inv_vat_chg_rt],0)" ).append("\n"); 
		query.append(",	NVL(@[mnr_ar_inv_iss_flg],'N')" ).append("\n"); 
		query.append(",	@[inv_top_rmk]" ).append("\n"); 
		query.append(",	@[inv_btm_rmk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}