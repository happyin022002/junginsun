/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrNtcBankAcctCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddArrNtcBankAcctCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrNtcBankAcctCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bank_in_acct_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drft_bl_bank_acct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration ").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrNtcBankAcctCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC_WD (" ).append("\n"); 
		query.append("AN_SEQ" ).append("\n"); 
		query.append(",	AN_TP_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	CHN_AGN_CD" ).append("\n"); 
		query.append("--,	LOCL_LANG_FLG" ).append("\n"); 
		query.append("--,	ARR_PRV_FOM_CD" ).append("\n"); 
		query.append("--,	ECLZ_BL_CPY_FLG" ).append("\n"); 
		query.append("--,	ADDR_CTNT" ).append("\n"); 
		query.append("--,	IMPT_NTC_RMK" ).append("\n"); 
		query.append(",	BANK_IN_ACCT_CTNT" ).append("\n"); 
		query.append(",	DRFT_BL_BANK_ACCT_DP_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("NVL((SELECT /*+ INDEX_DESC(T XPKBKG_ARR_NTC_WD) */ AN_SEQ" ).append("\n"); 
		query.append("FROM BKG_ARR_NTC_WD T" ).append("\n"); 
		query.append("WHERE ROWNUM = 1),0)+1" ).append("\n"); 
		query.append(",	'ACT'" ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	'*'" ).append("\n"); 
		query.append(",	'*'" ).append("\n"); 
		query.append("--,	locl_lang_flg" ).append("\n"); 
		query.append("--,	arr_prv_fom_cd" ).append("\n"); 
		query.append("--,	eclz_bl_cpy_flg" ).append("\n"); 
		query.append("--,	addr_ctnt" ).append("\n"); 
		query.append("--,	impt_ntc_rmk" ).append("\n"); 
		query.append(",	@[bank_in_acct_ctnt]" ).append("\n"); 
		query.append(",	@[drft_bl_bank_acct_dp_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}