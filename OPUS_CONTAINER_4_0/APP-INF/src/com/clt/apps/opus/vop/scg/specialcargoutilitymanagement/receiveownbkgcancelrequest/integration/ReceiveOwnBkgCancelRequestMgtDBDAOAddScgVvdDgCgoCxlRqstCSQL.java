/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveOwnBkgCancelRequestMgtDBDAOAddScgVvdDgCgoCxlRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveOwnBkgCancelRequestMgtDBDAOAddScgVvdDgCgoCxlRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddScgVvdDgCgoCxlRqst
	  * </pre>
	  */
	public ReceiveOwnBkgCancelRequestMgtDBDAOAddScgVvdDgCgoCxlRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_cgo_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_vrfy_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_vrfy_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_cgo_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_cgo_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_cxl_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration").append("\n"); 
		query.append("FileName : ReceiveOwnBkgCancelRequestMgtDBDAOAddScgVvdDgCgoCxlRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO" ).append("\n"); 
		query.append("       SCG_VVD_DG_CGO_CXL_RQST" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	   BKG_NO" ).append("\n"); 
		query.append("     , DCGO_CXL_RQST_SEQ" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , POL_YD_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , POD_YD_CD" ).append("\n"); 
		query.append("     , CXL_CGO_KND_CD" ).append("\n"); 
		query.append("     , CXL_CGO_RQST_DT" ).append("\n"); 
		query.append("     , CXL_CGO_RSN" ).append("\n"); 
		query.append("     , DG_CNTR_KNT" ).append("\n"); 
		query.append("     , DCGO_KNT" ).append("\n"); 
		query.append("     , RQST_VRFY_RSLT_CD" ).append("\n"); 
		query.append("     , RQST_VRFY_RSLT_RMK" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT @[bkg_no]" ).append("\n"); 
		query.append("     , @[dcgo_cxl_rqst_seq]" ).append("\n"); 
		query.append("     , @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[skd_dir_cd]" ).append("\n"); 
		query.append("     , @[pol_cd]" ).append("\n"); 
		query.append("     , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("     , @[pol_yd_cd]" ).append("\n"); 
		query.append("     , @[pod_cd]" ).append("\n"); 
		query.append("     , @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("     , @[pod_yd_cd]" ).append("\n"); 
		query.append("     , @[cxl_cgo_knd_cd]" ).append("\n"); 
		query.append("     , DECODE(@[cxl_cgo_rqst_dt], NULL, SYSDATE , TO_DATE(@[cxl_cgo_rqst_dt],'YYYYMMDD HH24MISS'))" ).append("\n"); 
		query.append("     , @[cxl_cgo_rsn]" ).append("\n"); 
		query.append("     , @[dg_cntr_knt]" ).append("\n"); 
		query.append("     , @[dcgo_knt]" ).append("\n"); 
		query.append("     , @[rqst_vrfy_rslt_cd]" ).append("\n"); 
		query.append("     , @[rqst_vrfy_rslt_rmk]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}