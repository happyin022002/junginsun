/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOaddCNTRInqInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddCNTRInqInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 정보 INSERT
	  * </pre>
	  */
	public KorManifestListDBDAOaddCNTRInqInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cntr_seal_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cntr_seal_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kc_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOaddCNTRInqInfoCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_KR_CNTR " ).append("\n"); 
		query.append("     ( BKG_NO" ).append("\n"); 
		query.append("     , CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , TRNS_SEQ" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , FULL_MTY_CD" ).append("\n"); 
		query.append("     , CNTR_SEAL_NO1" ).append("\n"); 
		query.append("     , CNTR_SEAL_NO2" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , PCK_QTY" ).append("\n"); 
		query.append("     , PCK_TP_CD" ).append("\n"); 
		query.append("     , CNTR_WGT" ).append("\n"); 
		query.append("     , WGT_UT_CD" ).append("\n"); 
		query.append("     , MEAS_QTY" ).append("\n"); 
		query.append("     , MEAS_UT_CD" ).append("\n"); 
		query.append("     , DMST_PORT_CD" ).append("\n"); 
		query.append("	 , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , CSTMS_BL_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("     ( @[kc_bkg_no]" ).append("\n"); 
		query.append("     , @[kc_cstms_decl_tp_cd]" ).append("\n"); 
		query.append("     , @[trns_seq]" ).append("\n"); 
		query.append("     , @[kc_cntr_no]" ).append("\n"); 
		query.append("     , @[kc_full_mty_cd]" ).append("\n"); 
		query.append("     , @[kc_cntr_seal_no1]" ).append("\n"); 
		query.append("     , @[kc_cntr_seal_no2]" ).append("\n"); 
		query.append("     , @[kc_cntr_tpsz_cd]" ).append("\n"); 
		query.append("     , @[kc_pck_qty]" ).append("\n"); 
		query.append("     , @[kc_pck_tp_cd]" ).append("\n"); 
		query.append("     , @[kc_cntr_wgt]" ).append("\n"); 
		query.append("     , @[kc_wgt_ut_cd]" ).append("\n"); 
		query.append("  	 , CASE WHEN @[kc_meas_ut_cd] = 'CBM' THEN  " ).append("\n"); 
		query.append("         CASE WHEN SUBSTR(@[kc_cntr_tpsz_cd], 2,1) = '2' THEN " ).append("\n"); 
		query.append("           CASE WHEN TO_NUMBER(@[kc_meas_qty])*0.883 > 70 THEN 70 ELSE TO_NUMBER(@[kc_meas_qty]) END" ).append("\n"); 
		query.append("  	   	 ELSE " ).append("\n"); 
		query.append("           CASE WHEN TO_NUMBER(@[kc_meas_qty])*0.883 > 140 THEN 140 ELSE TO_NUMBER(@[kc_meas_qty]) END" ).append("\n"); 
		query.append("       	 END" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("    	TO_NUMBER(@[kc_meas_qty])" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("     , @[kc_meas_ut_cd] " ).append("\n"); 
		query.append("     , @[port_cd]" ).append("\n"); 
		query.append("	 , @[user_id]  " ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , @[bl_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}