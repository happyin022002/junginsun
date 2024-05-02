/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingNumberGenarationDBDAOBkgReferenceNoGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingNumberGenarationDBDAOBkgReferenceNoGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Refrence No 조회
	  * </pre>
	  */
	public BookingNumberGenarationDBDAOBkgReferenceNoGenerationRSQL(){
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
		params.put("bkg_no_gen_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration").append("\n"); 
		query.append("FileName : BookingNumberGenarationDBDAOBkgReferenceNoGenerationRSQL").append("\n"); 
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
		query.append("SELECT 	CASE WHEN @[bkg_no_gen_div_cd] = 'RPT' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END rpt_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'JPD' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END jpd_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'D/O' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END dno_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'C/A' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END ca_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'KOR' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END dmy_bkg_no_for_custom" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'UIT' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END uit_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'CAD' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END cad_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'S/R' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END sr_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'KWD' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END kr_whf_decl_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'KWC' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END kr_whf_csr_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'FSR' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END fsr_no" ).append("\n"); 
		query.append(",	CASE WHEN @[bkg_no_gen_div_cd] = 'USD' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END usd_no" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}