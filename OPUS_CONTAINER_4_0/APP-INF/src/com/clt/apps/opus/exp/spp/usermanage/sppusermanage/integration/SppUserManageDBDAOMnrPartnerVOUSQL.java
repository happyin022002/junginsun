/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOMnrPartnerVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.08.13 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOMnrPartnerVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * partner modify
	  * </pre>
	  */
	public SppUserManageDBDAOMnrPartnerVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empe_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_prnr_knd_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_capi_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_shop_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration").append("\n"); 
		query.append("FileName : SppUserManageDBDAOMnrPartnerVOUSQL").append("\n"); 
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
		query.append("update mnr_partner" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("ctrl_ofc_cd             =	@[ctrl_ofc_cd]          ," ).append("\n"); 
		query.append("mnr_prnr_knd_cd         =	@[mnr_prnr_knd_cd]      ," ).append("\n"); 
		query.append("mnr_prnr_knd_dtl_cd     =	@[mnr_prnr_knd_dtl_cd]  ," ).append("\n"); 
		query.append("mnr_prnr_sts_cd         =	@[mnr_prnr_sts_cd]      ," ).append("\n"); 
		query.append("mnr_prnr_lgl_eng_nm     =	@[mnr_prnr_lgl_eng_nm]  ," ).append("\n"); 
		query.append("mnr_prnr_locl_lang_nm   =	@[mnr_prnr_locl_lang_nm]," ).append("\n"); 
		query.append("mnr_prnr_addr           =	@[mnr_prnr_addr]        ," ).append("\n"); 
		query.append("bank_nm                 =	@[bank_nm]              ," ).append("\n"); 
		query.append("bank_acct_no            =	@[bank_acct_no]         ," ).append("\n"); 
		query.append("pay_mzd_cd              =	@[pay_mzd_cd]           ," ).append("\n"); 
		query.append("zip_cd                  =	@[zip_cd]               ," ).append("\n"); 
		query.append("ownr_nm                 =	@[ownr_nm]              ," ).append("\n"); 
		query.append("bzct_nm                 =	@[bzct_nm]              ," ).append("\n"); 
		query.append("bztp_nm                 =	@[bztp_nm]              ," ).append("\n"); 
		query.append("bzet_addr               =	@[bzet_addr]            ," ).append("\n"); 
		query.append("biz_rgst_no             =	@[biz_rgst_no]          ," ).append("\n"); 
		query.append("mnr_shop_flg            =	@[mnr_shop_flg]         ," ).append("\n"); 
		query.append("mnr_prnr_capi_amt       =	@[mnr_prnr_capi_amt]    ," ).append("\n"); 
		query.append("empe_knt                =	@[empe_knt]             ," ).append("\n"); 
		query.append("intl_phn_no             =	@[intl_phn_no]          ," ).append("\n"); 
		query.append("phn_no                  =	@[phn_no]               ," ).append("\n"); 
		query.append("intl_fax_no             =	@[intl_fax_no]          ," ).append("\n"); 
		query.append("fax_no                  =	@[fax_no]               ," ).append("\n"); 
		query.append("mnr_prnr_eml            =	@[mnr_prnr_eml]         ," ).append("\n"); 
		query.append("upd_usr_id              =	@[upd_usr_id]           ," ).append("\n"); 
		query.append("upd_dt                  =	sysdate" ).append("\n"); 
		query.append("where mnr_prnr_cre_seq			=	@[mnr_prnr_cre_seq]" ).append("\n"); 

	}
}