/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_atch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_HIS" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("      VSKD_CNG_NO" ).append("\n"); 
		query.append("    , BKG_ATCH_FLG" ).append("\n"); 
		query.append("    , VSKD_TP_CD" ).append("\n"); 
		query.append("    , BFR_VSL_CD" ).append("\n"); 
		query.append("    , BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("    , BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("	, BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("    , VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("    , DIFF_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	BFR_PF_SVC_TP_CD" ).append("\n"); 
		query.append("	,	AFT_PF_SVC_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    LTRIM(TO_CHAR(VSK_VSL_SKD_HIS_SEQ.NEXTVAL, '00000000000000'))	-- <old:VSK_VSL_SKD_DEL_SEQ> --" ).append("\n"); 
		query.append("	, @[bkg_atch_flg]						-- 'Y':WITH BOOKINGS, 'N':WITHOUT BOOKINGS --" ).append("\n"); 
		query.append("    , 'M'" ).append("\n"); 
		query.append("    , @[bfr_vsl_cd]" ).append("\n"); 
		query.append("    , @[bfr_skd_voy_no]" ).append("\n"); 
		query.append("    , @[bfr_skd_dir_cd]" ).append("\n"); 
		query.append("	, @[bfr_vsl_slan_cd]" ).append("\n"); 
		query.append("    , 'V'" ).append("\n"); 
		query.append("    , 'BKG_NO[' || (SELECT SUBSTR(MAX(TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MI') || T1.BKG_NO), 13) AS BKG_NO" ).append("\n"); 
		query.append("        FROM    BKG_VVD T1, BKG_BOOKING T2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.BKG_NO = T2.BKG_NO" ).append("\n"); 
		query.append("        AND T2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("        AND T1.VSL_CD = @[bfr_vsl_cd]" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO = @[bfr_skd_voy_no]" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD = @[bfr_skd_dir_cd]) || ']'" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	@[bfr_pf_svc_tp_cd]" ).append("\n"); 
		query.append("	,	NULL" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}