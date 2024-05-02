/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOUpdateEDICtmBkgVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOUpdateEDICtmBkgVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateEDICtmBkgVvd
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOUpdateEDICtmBkgVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trsp_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_lodg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_vvd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOUpdateEDICtmBkgVvdUSQL").append("\n"); 
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
		query.append("UPDATE ctm_bkg_vvd" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("		SLAN_CD 			= (SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE MODI_VSL_SLAN_CD2 = @[slan_cd] and rownum = 1)" ).append("\n"); 
		query.append("		,VSL_CD 			= NVL((SELECT MAP.VSL_CD FROM  MDM_VSL_CNTR MAP WHERE" ).append("\n"); 
		query.append("				                MAP.VSL_CD LIKE SUBSTR(TRIM(@[vsl_cd]),1,3)||'%' AND SUBSTR(MAP.VSL_CD,1,3) = SUBSTR(TRIM(@[vsl_cd]),1,3) " ).append("\n"); 
		query.append("				                AND DELT_FLG != 'Y' AND ROWNUM <= 1),'')" ).append("\n"); 
		query.append("		,SKD_VOY_NO			= Decode(length(@[skd_voy_no]), 3, '0'||@[skd_voy_no], 4, @[skd_voy_no], NVL(@[skd_voy_no],''))" ).append("\n"); 
		query.append("		,SKD_DIR_CD         = NVL(@[skd_dir_cd],'')" ).append("\n"); 
		query.append("		,POL_CD             = NVL((select SUBSTR(YD_CD,0,5) AS POL_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')" ).append("\n"); 
		query.append("		,POL_YD_CD          = NVL((select YD_CD AS POL_YD_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')" ).append("\n"); 
		query.append("		,POD_CD             = NVL((select SUBSTR(YD_CD,0,5) AS POD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')" ).append("\n"); 
		query.append("		,POD_YD_CD          = NVL((select YD_CD AS POD_YD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')" ).append("\n"); 
		query.append("		,UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("		,UPD_DT             = sysdate" ).append("\n"); 
		query.append("		,OP_CD              = @[op_cd]" ).append("\n"); 
		query.append("		,POL_CLPT_IND_SEQ   = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("		,POD_CLPT_IND_SEQ   = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("		,BKG_TRSP_MZD_CD    = @[bkg_trsp_mzd_cd]" ).append("\n"); 
		query.append("		,CNTR_LODG_FLG      = NVL(@[cntr_lodg_flg],'N')" ).append("\n"); 
		query.append("		,REV_VVD_FLG        = @[rev_vvd_flg]" ).append("\n"); 
		query.append("		,OSCA_CRE_DT        = TO_DATE(SUBSTR(@[cre_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		,OSCA_UPD_DT        = TO_DATE(SUBSTR(@[upd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("AND VSL_SEQ = @[vsl_seq]" ).append("\n"); 

	}
}