/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAOPriTrfBzcVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffGeneralInformationDBDAOPriTrfBzcVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Basic 정보를 Insert 한다.
	  * </pre>
	  */
	public TariffGeneralInformationDBDAOPriTrfBzcVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_vol_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pub_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_cnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pub_ofc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_bzc_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.integration ").append("\n"); 
		query.append("FileName : TariffGeneralInformationDBDAOPriTrfBzcVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_BZC" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    TRF_PFX_CD" ).append("\n"); 
		query.append("   ,TRF_NO" ).append("\n"); 
		query.append("   ,AMDT_SEQ" ).append("\n"); 
		query.append("   ,EFF_DT" ).append("\n"); 
		query.append("   ,EXP_DT" ).append("\n"); 
		query.append("   ,TRF_BZC_TP_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_WGT" ).append("\n"); 
		query.append("   ,TRF_BZC_WGT_UT_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_VOL_QTY" ).append("\n"); 
		query.append("   ,TRF_BZC_VOL_UT_CD" ).append("\n"); 
		query.append("   ,CURR_CD" ).append("\n"); 
		query.append("   ,PUB_CNTC_PSON_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_ADDR" ).append("\n"); 
		query.append("   ,PUB_OFC_CTY_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_STE_CD" ).append("\n"); 
		query.append("   ,PUB_OFC_ZIP_CD" ).append("\n"); 
		query.append("   ,PUB_OFC_CNT_NM" ).append("\n"); 
		query.append("   ,PUB_OFC_PHN_NO" ).append("\n"); 
		query.append("   ,PUB_OFC_FAX_NO" ).append("\n"); 
		query.append("   ,RQST_OFC_CD" ).append("\n"); 
		query.append("   ,APRO_OFC_CD" ).append("\n"); 
		query.append("   ,TRF_BZC_STS_CD" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,PUB_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    @[trf_pfx_cd]" ).append("\n"); 
		query.append("   ,@[trf_no]" ).append("\n"); 
		query.append("   ,@[amdt_seq]" ).append("\n"); 
		query.append("   ,TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   ,TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   ,@[trf_bzc_tp_cd]" ).append("\n"); 
		query.append("   ,@[trf_bzc_wgt]" ).append("\n"); 
		query.append("   ,@[trf_bzc_wgt_ut_cd]" ).append("\n"); 
		query.append("   ,@[trf_bzc_vol_qty]" ).append("\n"); 
		query.append("   ,@[trf_bzc_vol_ut_cd]" ).append("\n"); 
		query.append("   ,@[curr_cd]" ).append("\n"); 
		query.append("   ,@[pub_cntc_pson_nm]" ).append("\n"); 
		query.append("   ,@[pub_ofc_addr]" ).append("\n"); 
		query.append("   ,@[pub_ofc_cty_nm]" ).append("\n"); 
		query.append("   ,@[pub_ofc_ste_cd]" ).append("\n"); 
		query.append("   ,@[pub_ofc_zip_cd]" ).append("\n"); 
		query.append("   ,@[pub_ofc_cnt_nm]" ).append("\n"); 
		query.append("   ,@[pub_ofc_phn_no]" ).append("\n"); 
		query.append("   ,@[pub_ofc_fax_no]" ).append("\n"); 
		query.append("   ,@[rqst_ofc_cd]" ).append("\n"); 
		query.append("   ,@[apro_ofc_cd]" ).append("\n"); 
		query.append("   ,@[trf_bzc_sts_cd]" ).append("\n"); 
		query.append("   ,@[cre_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,TO_DATE(@[pub_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}