/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingMasterMgtDBDAOAddRestrictCmdtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOAddRestrictCmdtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Restricted Commodities Set-up(INSERT)
	  * </pre>
	  */
	public BookingMasterMgtDBDAOAddRestrictCmdtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_cmdt_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frob_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("web_site_url",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOAddRestrictCmdtCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IMP_RSTR_CMDT (" ).append("\n"); 
		query.append("	RGN_OFC_CD," ).append("\n"); 
		query.append("	CNT_CD," ).append("\n"); 
		query.append("	LOC_CD," ).append("\n"); 
		query.append("	DP_SEQ," ).append("\n"); 
		query.append("	TS_FLG," ).append("\n"); 
		query.append("	FROB_FLG," ).append("\n"); 
		query.append("	RSTR_CMDT_NM," ).append("\n"); 
		query.append("	PROHI_CMDT_NM," ).append("\n"); 
		query.append("	EFF_DT," ).append("\n"); 
		query.append("	EXP_DT," ).append("\n"); 
		query.append("	WEB_SITE_URL," ).append("\n"); 
		query.append("	INTER_RMK," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("	RSTR_CMDT_GRP_NM" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[rgn_ofc_cd]," ).append("\n"); 
		query.append("	@[cnt_cd]," ).append("\n"); 
		query.append("	DECODE(@[loc_cd],'ALL','*****',@[loc_cd])," ).append("\n"); 
		query.append("	(SELECT NVL(MAX(DP_SEQ)+1, 1) " ).append("\n"); 
		query.append("		FROM BKG_IMP_RSTR_CMDT " ).append("\n"); 
		query.append("	   WHERE RGN_OFC_CD = @[rgn_ofc_cd] " ).append("\n"); 
		query.append("		 AND CNT_CD     = @[cnt_cd]" ).append("\n"); 
		query.append("		 AND LOC_CD     = DECODE(@[loc_cd],'ALL','*****',@[loc_cd]))," ).append("\n"); 
		query.append("	DECODE(NVL(@[ts_flg], 0), 0, 'N', 'Y')," ).append("\n"); 
		query.append("	DECODE(NVL(@[frob_flg], 0), 0, 'N', 'Y')," ).append("\n"); 
		query.append("	@[rstr_cmdt_nm]," ).append("\n"); 
		query.append("	@[prohi_cmdt_nm]," ).append("\n"); 
		query.append("	TO_DATE(@[eff_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("	TO_DATE(@[exp_dt], 'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("	@[web_site_url]," ).append("\n"); 
		query.append("	@[inter_rmk]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("	@[rstr_cmdt_grp_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}