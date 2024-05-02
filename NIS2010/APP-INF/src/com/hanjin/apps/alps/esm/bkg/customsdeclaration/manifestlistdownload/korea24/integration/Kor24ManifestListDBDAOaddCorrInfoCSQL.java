/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOaddCorrInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.05 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOaddCorrInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Correction 정보 추가
	  * </pre>
	  */
	public Kor24ManifestListDBDAOaddCorrInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_rcvr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_vsl_call_sgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_tml_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rgst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOaddCorrInfoCSQL").append("\n");
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
		query.append("INTO BKG_CSTMS_KR_CORR" ).append("\n");
		query.append("( SMT_AMD_NO" ).append("\n");
		query.append(", BKG_NO" ).append("\n");
		query.append(", CSTMS_DECL_TP_CD" ).append("\n");
		query.append(", BL_NO" ).append("\n");
		query.append(", KR_CSTMS_CORR_ID" ).append("\n");
		query.append(", CORR_RSN" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", AMDT_SND_DT" ).append("\n");
		query.append(", AMDT_SND_USR_ID" ).append("\n");
		query.append(", RSPN_RCV_DT" ).append("\n");
		query.append(", CLT_SEQ" ).append("\n");
		query.append(", PORT_CD" ).append("\n");
		query.append(", AMDT_RCVR_CD" ).append("\n");
		query.append(", KR_VSL_CALL_SGN_CD" ).append("\n");
		query.append(", CALL_YR" ).append("\n");
		query.append(", CALL_KNT" ).append("\n");
		query.append(", VSL_NM" ).append("\n");
		query.append(", VSL_RGST_CNT_CD" ).append("\n");
		query.append(", DCHG_MZD_CD" ).append("\n");
		query.append(", IO_TML_LOC_CD" ).append("\n");
		query.append(", VSL_CD" ).append("\n");
		query.append(", SKD_VOY_NO" ).append("\n");
		query.append(", SKD_DIR_CD" ).append("\n");
		query.append(", CSTMS_BL_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("SELECT @[sub_no]" ).append("\n");
		query.append(", @[bkg_no]" ).append("\n");
		query.append(", @[cstms_decl_tp_cd]" ).append("\n");
		query.append(", @[bl_no]" ).append("\n");
		query.append(", @[kr_cstms_corr_id]" ).append("\n");
		query.append(", @[corr_rsn]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[user_id]" ).append("\n");
		query.append(", NULL" ).append("\n");
		query.append(", NULL" ).append("\n");
		query.append(", NULL" ).append("\n");
		query.append(", @[trns_seq]" ).append("\n");
		query.append(", @[port_cd]" ).append("\n");
		query.append(", @[amdt_rcvr_flg]" ).append("\n");
		query.append(", @[kr_vsl_call_sgn_cd]" ).append("\n");
		query.append(", @[call_yr]" ).append("\n");
		query.append(", @[call_knt]" ).append("\n");
		query.append(", @[vsl_nm]" ).append("\n");
		query.append(", @[vsl_rgst_cnt_cd]" ).append("\n");
		query.append(", @[dchg_mzd_cd]" ).append("\n");
		query.append(", @[io_tml_loc_cd]" ).append("\n");
		query.append(", SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append(", @[c_bl_no]" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}