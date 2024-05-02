/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOaddAdjustHdrListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOaddAdjustHdrListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_ADJ_HDR 테이블에 insert
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOaddAdjustHdrListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_bil_to_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gain_and_lss_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_finc_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_crs_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOaddAdjustHdrListCSQL").append("\n"); 
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
		query.append("INSERT INTO  SAR_ADJ_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     OTS_ADJ_SEQ" ).append("\n"); 
		query.append("	,ADJ_NO" ).append("\n"); 
		query.append("	,ADJ_DT" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_NO" ).append("\n"); 
		query.append("	,INV_NO" ).append("\n"); 
		query.append("	,INV_OFC_CD" ).append("\n"); 
		query.append("	,ADJ_TP_CD" ).append("\n"); 
		query.append("	,BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	,BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	,SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	,SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("	,LOCL_VVD_CD" ).append("\n"); 
		query.append("	,TRNK_VVD_CD" ).append("\n"); 
		query.append("	,SAIL_DT" ).append("\n"); 
		query.append("	,SAIL_ARR_DT" ).append("\n"); 
		query.append("	,OBRD_DT" ).append("\n"); 
		query.append("	,IO_BND_CD" ).append("\n"); 
		query.append("	,DUE_DT" ).append("\n"); 
		query.append("	,SREP_CD" ).append("\n"); 
		query.append("	,ADJ_RMK" ).append("\n"); 
		query.append("	,XCH_RT_TP_CD" ).append("\n"); 
		query.append("	,XCH_RT_DT" ).append("\n"); 
		query.append("	,CR_FLG" ).append("\n"); 
		query.append("	,AR_TAX_IND_CD" ).append("\n"); 
		query.append("	,AR_TJ_TP_CD" ).append("\n"); 
		query.append("	,AR_FINC_SRC_CD" ).append("\n"); 
		query.append("	,MAX_AR_IF_NO" ).append("\n"); 
		query.append("	,AP_CURR_CD" ).append("\n"); 
		query.append("	,AP_CRS_CURR_AMT" ).append("\n"); 
		query.append("	,GAIN_AND_LSS_AMT" ).append("\n"); 
		query.append("	,AP_OFC_CD" ).append("\n"); 
		query.append("	,VNDR_NO" ).append("\n"); 
		query.append("	,AP_RMK" ).append("\n"); 
		query.append("	,RVS_FLG" ).append("\n"); 
		query.append("	,ASA_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,ADJ_KEY_NO" ).append("\n"); 
		query.append("	,ADJ_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[ots_adj_seq]," ).append("\n"); 
		query.append("	@[adj_no]," ).append("\n"); 
		query.append("	REPLACE(@[adj_dt], '-', '')," ).append("\n"); 
		query.append("	@[bl_no]," ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	@[inv_no]," ).append("\n"); 
		query.append("	@[inv_ofc_cd]," ).append("\n"); 
		query.append("	@[adj_tp_cd]," ).append("\n"); 
		query.append("	@[bil_to_cust_cnt_cd]," ).append("\n"); 
		query.append("	@[bil_to_cust_seq]," ).append("\n"); 
		query.append("	SUBSTR(@[shp_bil_to_cust_cd], 1, 2)," ).append("\n"); 
		query.append("	SUBSTR(@[shp_bil_to_cust_cd], 4, 6)," ).append("\n"); 
		query.append("	@[locl_vvd_cd]," ).append("\n"); 
		query.append("	@[trnk_vvd_cd]," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	@[sail_arr_dt]," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	DECODE(@[io_bnd_cd], 'O/B', 'O', 'I')," ).append("\n"); 
		query.append("	@[due_dt]," ).append("\n"); 
		query.append("	@[srep_cd]," ).append("\n"); 
		query.append("	@[adj_rmk]," ).append("\n"); 
		query.append("	@[xch_rt_tp_cd]," ).append("\n"); 
		query.append("	@[xch_rt_dt]," ).append("\n"); 
		query.append("	@[cr_flg]," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	''," ).append("\n"); 
		query.append("	@[ar_finc_src_cd]," ).append("\n"); 
		query.append("	@[max_ar_if_no]," ).append("\n"); 
		query.append("	@[ap_curr_cd]," ).append("\n"); 
		query.append("	REPLACE(@[ap_crs_curr_amt], ',', '')," ).append("\n"); 
		query.append("	REPLACE(@[gain_and_lss_amt], ',', '')," ).append("\n"); 
		query.append("	@[ap_ofc_cd]," ).append("\n"); 
		query.append("	@[vndr_no]," ).append("\n"); 
		query.append("	@[ap_rmk]," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	@[asa_no]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[adj_key_no]," ).append("\n"); 
		query.append("	@[adj_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}