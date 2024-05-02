/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOInsertCntrMtyBkgSplitListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOInsertCntrMtyBkgSplitListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_MTY_BKG_EXE 실행테이블에 BKG SPLIT 구간정보 입력
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOInsertCntrMtyBkgSplitListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_bkg_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_split_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOInsertCntrMtyBkgSplitListCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_VSL_LODG_DCHG_EXE_PLN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      REPO_PLN_ID" ).append("\n"); 
		query.append("    , PLN_YRWK" ).append("\n"); 
		query.append("    , PLN_SEQ" ).append("\n"); 
		query.append("    , REF_ID" ).append("\n"); 
		query.append("    , CO_CD" ).append("\n"); 
		query.append("    , TRSP_MOD_CD" ).append("\n"); 
		query.append("    , VSL_LANE_CD" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD " ).append("\n"); 
		query.append("    , FM_YD_CD" ).append("\n"); 
		query.append("    , FM_ETD_DT" ).append("\n"); 
		query.append("    , TO_YD_CD" ).append("\n"); 
		query.append("    , TO_ETB_DT" ).append("\n"); 
		query.append("    , EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("    , REPO_MTY_BKG_FLG" ).append("\n"); 
		query.append("    , REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("    , REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("    , MTY_BKG_NO" ).append("\n"); 
		query.append("    , OLD_BKG_GRP_NO" ).append("\n"); 
		query.append("    , SPLIT_REPO_PLN_FLG" ).append("\n"); 
		query.append("    , PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT    REPO_PLN_ID" ).append("\n"); 
		query.append("        , PLN_YRWK" ).append("\n"); 
		query.append("        , PLN_SEQ" ).append("\n"); 
		query.append("        , @[ref_id]" ).append("\n"); 
		query.append("        , CO_CD" ).append("\n"); 
		query.append("        , TRSP_MOD_CD" ).append("\n"); 
		query.append("        , @[vsl_lane_cd]" ).append("\n"); 
		query.append("        , @[vsl_cd]" ).append("\n"); 
		query.append("	    , @[skd_voy_no]" ).append("\n"); 
		query.append("	    , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[pol_yd_cd]" ).append("\n"); 
		query.append("        , TO_DATE(@[pol_etd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	    , @[pod_yd_cd]" ).append("\n"); 
		query.append("        , TO_DATE(@[pod_etb_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        , EQ_REPO_PURP_CD -- EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("    	, REPO_MTY_BKG_FLG" ).append("\n"); 
		query.append("    	, REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("    	, REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("        , @[mty_bkg_no] " ).append("\n"); 
		query.append("        , @[old_bkg_grp_no]" ).append("\n"); 
		query.append("        , @[mty_bkg_split_flg]" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("  FROM EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND MTY_BKG_NO = @[old_bkg_grp_no]" ).append("\n"); 

	}
}