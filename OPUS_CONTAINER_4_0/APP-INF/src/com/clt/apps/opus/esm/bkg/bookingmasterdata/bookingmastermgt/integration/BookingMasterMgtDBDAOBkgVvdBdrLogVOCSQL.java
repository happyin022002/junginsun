/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgVvdBdrLogVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.06 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgVvdBdrLogVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgVvdBdrLogVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_bdr_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_bdr_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_estm_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_auto_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_auto_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_estm_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_auto_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_auto_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_mnl_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_mnl_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_bdr_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_vsl_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_mnl_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_mnl_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgVvdBdrLogVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_VVD_BDR_LOG (" ).append("\n"); 
		query.append("TRNK_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_DT" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_UPD_DT" ).append("\n"); 
		query.append(",	BDR_VSL_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SLAN_TP_CD" ).append("\n"); 
		query.append(",	TRNK_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[trnk_auto_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[trnk_auto_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[trnk_mnl_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[trnk_mnl_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[trnk_bdr_cre_usr_id]" ).append("\n"); 
		query.append(",	@[fdr_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[fdr_estm_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[fdr_auto_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[fdr_auto_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[fdr_mnl_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[fdr_mnl_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[fdr_bdr_cre_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[fdr_bdr_upd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[bdr_vsl_chk_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[pol_cd]" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[pol_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[pod_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[slan_tp_cd]" ).append("\n"); 
		query.append(",	@[trnk_bdr_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[trnk_estm_bdr_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}