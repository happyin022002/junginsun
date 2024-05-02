/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOUpdateLinkConstraintUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOUpdateLinkConstraintUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateLinkConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOUpdateLinkConstraintUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_cnst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_cnst_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_lnk_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOUpdateLinkConstraintUSQL").append("\n"); 
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
		query.append("UPDATE PRD_LNK_CNST_MGMT " ).append("\n"); 
		query.append("SET LNK_CNST_ITM_CD = @[lnk_cnst_itm_cd] , " ).append("\n"); 
		query.append("	PCTL_CNST_ITM_NM = (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("						WHERE INTG_CD_ID = 'CD01386' AND INTG_CD_VAL_CTNT = @[lnk_cnst_itm_cd] ), " ).append("\n"); 
		query.append("	LNK_CNST_RMK = @[lnk_cnst_rmk] , " ).append("\n"); 
		query.append("	SVC_USE_FLG = @[svc_use_flg] , " ).append("\n"); 
		query.append("	CNTR_TP_CD = @[cntr_tp_cd] , " ).append("\n"); 
		query.append("	EFF_FM_DT = REPLACE(@[eff_fm_dt], '-','') , " ).append("\n"); 
		query.append("	EFF_TO_DT = REPLACE(@[eff_to_dt], '-','') , " ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id] , " ).append("\n"); 
		query.append("	UPD_OFC_CD = @[upd_ofc_cd] , " ).append("\n"); 
		query.append("	UPD_DT	= SYSDATE," ).append("\n"); 
		query.append("    VSL_SLAN_CD = @[vsl_slan_cd]," ).append("\n"); 
		query.append("    VSL_CD      = SUBSTR(@[vvd], 1,4)," ).append("\n"); 
		query.append("    SKD_VOY_NO  = SUBSTR(@[vvd], 5,4)," ).append("\n"); 
		query.append("    SKD_DIR_CD  = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("WHERE	LNK_ORG_NOD_CD = @[lnk_org_nod_cd] " ).append("\n"); 
		query.append("	AND LNK_DEST_NOD_CD = @[lnk_dest_nod_cd] " ).append("\n"); 
		query.append("	AND TRSP_MOD_CD = @[trsp_mod_cd] " ).append("\n"); 
		query.append("	AND LNK_CNST_ITM_CD = @[old_lnk_cnst_itm_cd]" ).append("\n"); 
		query.append("    AND lnk_cnst_seq =  @[lnk_cnst_seq]" ).append("\n"); 

	}
}