/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OceanRouteManageDBDAOUpdateOceanRouteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOUpdateOceanRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateOceanRoute
	  * </pre>
	  */
	public OceanRouteManageDBDAOUpdateOceanRouteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_prior",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_note",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ocn_rout_tmp_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ocn_rout_tmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_f_u",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_upd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOUpdateOceanRouteUSQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT " ).append("\n"); 
		query.append("SET    FDR_USD_FLG      = @[s_f_u] , " ).append("\n"); 
		query.append("       OCN_ROUT_PRIO_CD    = @[s_prior] , " ).append("\n"); 
		query.append("       OCN_ROUT_PRIO_CNG_FLG = DECODE((SELECT 'Y' FROM COM_USER WHERE USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append("                                      , 'Y', CASE WHEN OCN_ROUT_PRIO_CNG_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                                  WHEN ocn_rout_prio_cd <> @[s_prior] THEN 'Y'" ).append("\n"); 
		query.append("                                                  ELSE 'N' END" ).append("\n"); 
		query.append("                                      , 'N')," ).append("\n"); 
		query.append("       UPD_IND_CD       = @[s_route_flg] , " ).append("\n"); 
		query.append("       UPD_OFC_CD       =  @[cre_ofc_cd] , " ).append("\n"); 
		query.append("       UPD_USR_ID       = @[upd_usr_id] ," ).append("\n"); 
		query.append("       OCN_ROUT_UPD_DT           = sysdate, " ).append("\n"); 
		query.append("       OCN_ROUT_USR_RMK = REPLACE(REPLACE(REPLACE( @[s_route_rmk] , CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("	   , OCN_ROUT_TMP_FLG = @[s_ocn_rout_tmp_flg]" ).append("\n"); 
		query.append("	   , OCN_ROUT_TMP_EXP_DT = to_date(@[s_ocn_rout_tmp_exp_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("       , OCN_ROUT_TMP_RMK = REPLACE(REPLACE(REPLACE(  @[s_route_note] , CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("       , VAL_EXPT_FLG = DECODE( @[s_upd_ind_cd] , 'V', 'Y','N')" ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD       = @[s_pol]" ).append("\n"); 
		query.append("AND    DEST_LOC_CD      = @[s_pod] " ).append("\n"); 
		query.append("AND    ROUT_SEQ         = @[s_rout_seq]" ).append("\n"); 

	}
}