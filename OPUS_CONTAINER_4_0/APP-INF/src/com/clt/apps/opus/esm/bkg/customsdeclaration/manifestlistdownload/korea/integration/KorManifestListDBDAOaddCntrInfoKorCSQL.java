/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOaddCntrInfoKorCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.29
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddCntrInfoKorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 컨테이너 INSERT
	  * </pre>
	  */
	public KorManifestListDBDAOaddCntrInfoKorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fe_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mea_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mea_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_wgt_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOaddCntrInfoKorCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_KR_CNTR " ).append("\n");
		query.append("(     BKG_NO " ).append("\n");
		query.append(", CSTMS_DECL_TP_CD " ).append("\n");
		query.append(", TRNS_SEQ " ).append("\n");
		query.append(", CNTR_NO " ).append("\n");
		query.append(", FULL_MTY_CD " ).append("\n");
		query.append(", CNTR_SEAL_NO1 " ).append("\n");
		query.append(", CNTR_SEAL_NO2" ).append("\n");
		query.append(", CNTR_TPSZ_CD " ).append("\n");
		query.append(", PCK_QTY " ).append("\n");
		query.append(", PCK_TP_CD " ).append("\n");
		query.append(", CNTR_WGT " ).append("\n");
		query.append(", WGT_UT_CD " ).append("\n");
		query.append(", MEAS_QTY " ).append("\n");
		query.append(", MEAS_UT_CD " ).append("\n");
		query.append(", DMST_PORT_CD " ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", CSTMS_BL_NO" ).append("\n");
		query.append(") " ).append("\n");
		query.append("VALUES " ).append("\n");
		query.append("( " ).append("\n");
		query.append("@[bkg_no] " ).append("\n");
		query.append(", DECODE(@[expt_kcd_tp],'R','R','T','T',@[kcd_tp]) " ).append("\n");
		query.append(", @[kt_seq] " ).append("\n");
		query.append(", @[cntr_no] " ).append("\n");
		query.append(", @[fe_ind] " ).append("\n");
		query.append(", @[seal_no1] " ).append("\n");
		query.append(", @[seal_no2] " ).append("\n");
		query.append(", @[cntrts_cd] " ).append("\n");
		query.append(", @[cntr_pkg_qty] " ).append("\n");
		query.append(", @[cntr_pkg_cd] " ).append("\n");
		query.append(", @[cntr_wgt_qty] " ).append("\n");
		query.append(", @[cntr_wgt_tp] " ).append("\n");
		query.append(", CASE WHEN @[cntr_mea_tp] = 'CBM' THEN" ).append("\n");
		query.append("	CASE WHEN SUBSTR(@[cntrts_cd], 2,1) = '2' THEN " ).append("\n");
		query.append("      CASE WHEN TO_NUMBER(@[cntr_mea_qty]) >= 70 THEN 69 ELSE TO_NUMBER(@[cntr_mea_qty]) END" ).append("\n");
		query.append("  	ELSE " ).append("\n");
		query.append("      CASE WHEN TO_NUMBER(@[cntr_mea_qty]) >= 140 THEN 139 ELSE TO_NUMBER(@[cntr_mea_qty]) END" ).append("\n");
		query.append("  	END" ).append("\n");
		query.append("  ELSE" ).append("\n");
		query.append("    TO_NUMBER(@[cntr_mea_qty])" ).append("\n");
		query.append("  END" ).append("\n");
		query.append(", @[cntr_mea_tp] " ).append("\n");
		query.append(", @[kt_port] " ).append("\n");
		query.append(", @[username]" ).append("\n");
		query.append(", @[username]" ).append("\n");
		query.append(", @[c_bl_no]" ).append("\n");
		query.append(")" ).append("\n");

	}
}