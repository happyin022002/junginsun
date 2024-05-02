/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyIntAuthCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOModifyIntAuthCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홈페이지에서 OBL 출력시 신규 B/L의 경우 OPUS 에 출력정보 추가
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyIntAuthCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prn_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_bl_snd_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prn_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrg_file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_ecd_proc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("info_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_prn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_ver_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyIntAuthCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_INET_BL_PRN_AUTH " ).append("\n"); 
		query.append("    ( BKG_NO" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , INFO_SEQ" ).append("\n"); 
		query.append("    , MRG_FILE_NM" ).append("\n"); 
		query.append("    , DOC_ECD_PROC_FLG" ).append("\n"); 
		query.append("    , MRG_DT" ).append("\n"); 
		query.append("    , N1ST_PRN_DT" ).append("\n"); 
		query.append("    , WBL_PRN_DT" ).append("\n"); 
		query.append("    , WBL_PRN_GDT" ).append("\n"); 
		query.append("    , PRN_USR_ID" ).append("\n"); 
		query.append("    , PRN_CUST_TP_CD" ).append("\n"); 
		query.append("    , INET_BL_SND_VIA_CD" ).append("\n"); 
		query.append("    , SHPR_CNT_CD" ).append("\n"); 
		query.append("    , SHPR_SEQ" ).append("\n"); 
		query.append("    , CNEE_CNT_CD" ).append("\n"); 
		query.append("    , CNEE_SEQ" ).append("\n"); 
		query.append("    , NTFY_CNT_CD" ).append("\n"); 
		query.append("    , NTFY_SEQ" ).append("\n"); 
		query.append("    , FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append("    , FRT_FWRD_SEQ" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    , LOCL_VER_CTNT" ).append("\n"); 
		query.append("    , WBL_PRN_KNT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , DELT_FLG )" ).append("\n"); 
		query.append("VALUES ( @[bkg_no] " ).append("\n"); 
		query.append("     , @[bl_no]" ).append("\n"); 
		query.append("     , @[info_seq]" ).append("\n"); 
		query.append("     , @[mrg_file_nm]" ).append("\n"); 
		query.append("     , NVL(@[doc_ecd_proc_flg],'Y')" ).append("\n"); 
		query.append("     , TO_DATE(@[mrg_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , TO_DATE(@[n1st_prn_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , TO_DATE(@[wbl_prn_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , TO_DATE(@[wbl_prn_gdt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("     , @[prn_usr_id]" ).append("\n"); 
		query.append("     , @[prn_cust_tp_cd]" ).append("\n"); 
		query.append("     , @[inet_bl_snd_via_cd]" ).append("\n"); 
		query.append("     , @[shpr_cnt_cd]" ).append("\n"); 
		query.append("     , @[shpr_seq]" ).append("\n"); 
		query.append("     , @[cnee_cnt_cd]" ).append("\n"); 
		query.append("     , @[cnee_seq]" ).append("\n"); 
		query.append("     , @[ntfy_cnt_cd]" ).append("\n"); 
		query.append("     , @[ntfy_seq]" ).append("\n"); 
		query.append("     , @[frt_fwrd_cnt_cd]" ).append("\n"); 
		query.append("     , @[frt_fwrd_seq]" ).append("\n"); 
		query.append("     , @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[skd_dir_cd]" ).append("\n"); 
		query.append("     , @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("     , @[locl_ver_ctnt]" ).append("\n"); 
		query.append("     , @[wbl_prn_knt]" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , NVL(@[doc_ecd_proc_flg],'N')" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}