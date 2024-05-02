/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyBondedInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.06
*@LastModifier :
*@LastVersion : 1.0
* 2012.01.06
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

public class KorManifestListDBDAOmodifyBondedInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Bonded Information update한다.
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyBondedInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dchg_loc_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOmodifyBondedInfoUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n");
		query.append("SET CSTMS_CLR_TP_CD          = @[cstms_clr_tp_cd]" ).append("\n");
		query.append(", CSTMS_DCHG_LOC_WH_CD     = @[cstms_dchg_loc_wh_cd]" ).append("\n");
		query.append(", CSTMS_CLR_LOC_CD         = @[cstms_clr_loc_cd]" ).append("\n");
		query.append(", CSTMS_CLR_WH_CD          = @[cstms_clr_wh_cd]" ).append("\n");
		query.append(", MF_CFM_FLG               = @[msn_cfm_flg]" ).append("\n");
		query.append(", KR_CSTMS_BL_TP_CD        = @[bl_tp_cd]" ).append("\n");
		query.append(", MF_SEQ_NO                = DECODE(@[mf_seq_no],NULL,@[mf_seq_no],' ',@[mf_seq_no],LPAD(@[mf_seq_no],4,'0'))" ).append("\n");
		query.append(", BD_TP_CD                 = @[bd_tp_cd]" ).append("\n");
		query.append(", VIA_WEB_FLG = DECODE(BD_TP_CD, @[bd_tp_cd], VIA_WEB_FLG, 'N')" ).append("\n");
		query.append(", CFM_DT                   = DECODE(@[msn_cfm_flg],'Y',SYSDATE,'')" ).append("\n");
		query.append(", UPD_DT                   = DECODE(@[update_chk], 'Y', SYSDATE, UPD_DT)" ).append("\n");
		query.append("WHERE BKG_NO                   = @[bkg_no]" ).append("\n");
		query.append("AND MF_REF_NO                = @[mrn_no]" ).append("\n");

	}
}