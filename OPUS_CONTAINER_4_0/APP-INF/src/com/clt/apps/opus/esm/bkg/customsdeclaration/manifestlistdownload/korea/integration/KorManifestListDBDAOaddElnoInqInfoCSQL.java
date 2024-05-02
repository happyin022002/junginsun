/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOaddElnoInqInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.21 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddElnoInqInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Export Lic No INSERT
	  * </pre>
	  */
	public KorManifestListDBDAOaddElnoInqInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_divd_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_trns_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ke_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_prt_lodg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_kr_xpt_pck_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_prt_lodg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_divd_pck_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ke_cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ke_xpt_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOaddElnoInqInfoCSQL").append("\n");
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
		query.append("INSERT" ).append("\n");
		query.append("INTO BKG_CSTMS_KR_XPT_LIC" ).append("\n");
		query.append("( BKG_NO" ).append("\n");
		query.append(", CSTMS_DECL_TP_CD" ).append("\n");
		query.append(", TRNS_SEQ" ).append("\n");
		query.append(", XPT_LIC_NO" ).append("\n");
		query.append(", PCK_QTY" ).append("\n");
		query.append(", PCK_TP_CD" ).append("\n");
		query.append(", CNTR_WGT" ).append("\n");
		query.append(", WGT_UT_CD" ).append("\n");
		query.append(", PRT_LODG_FLG" ).append("\n");
		query.append(", PRT_LODG_SEQ" ).append("\n");
		query.append(", DIVD_PCK_QTY" ).append("\n");
		query.append(", DIVD_PCK_UT_CD" ).append("\n");
		query.append(", KR_XPT_PCK_ID" ).append("\n");
		query.append(", DMST_PORT_CD" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", CSTMS_BL_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("@[ke_bkg_no]" ).append("\n");
		query.append(", @[ke_cstms_decl_tp_cd]" ).append("\n");
		query.append(", @[ke_trns_seq]" ).append("\n");
		query.append(", @[ke_xpt_lic_no]" ).append("\n");
		query.append(", NVL(@[ke_pck_qty], '0')" ).append("\n");
		query.append(", @[ke_pck_tp_cd]" ).append("\n");
		query.append(", NVL(@[ke_cntr_wgt], '0')" ).append("\n");
		query.append(", @[ke_wgt_ut_cd]" ).append("\n");
		query.append(", NVL(@[ke_prt_lodg_flg], 'N')" ).append("\n");
		query.append(", NVL(@[ke_prt_lodg_seq], '0')" ).append("\n");
		query.append(", NVL(@[ke_divd_pck_qty], '0')" ).append("\n");
		query.append(", @[ke_divd_pck_ut_cd]" ).append("\n");
		query.append(", @[ke_kr_xpt_pck_id]" ).append("\n");
		query.append(", @[port_cd]" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", @[bl_no]" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}