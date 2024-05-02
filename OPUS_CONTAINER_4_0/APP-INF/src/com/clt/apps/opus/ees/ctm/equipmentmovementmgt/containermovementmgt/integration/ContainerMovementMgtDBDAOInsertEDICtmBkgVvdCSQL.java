/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDICtmBkgVvdCSQL.java
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

public class ContainerMovementMgtDBDAOInsertEDICtmBkgVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Batch 실행시 BKG_VVD/EPP_VVD 파일 전송시 CTM_BKG_VVD 테이블에 저장
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDICtmBkgVvdCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDICtmBkgVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_BKG_VVD" ).append("\n"); 
		query.append("			(BKG_NO				," ).append("\n"); 
		query.append("			VSL_PRE_PST_CD		," ).append("\n"); 
		query.append("			VSL_SEQ				," ).append("\n"); 
		query.append("			SLAN_CD				," ).append("\n"); 
		query.append("			VSL_CD				," ).append("\n"); 
		query.append("			SKD_VOY_NO			," ).append("\n"); 
		query.append("			SKD_DIR_CD			," ).append("\n"); 
		query.append("			POL_CD				," ).append("\n"); 
		query.append("			POL_YD_CD			," ).append("\n"); 
		query.append("			POD_CD				," ).append("\n"); 
		query.append("			POD_YD_CD			," ).append("\n"); 
		query.append("			CRE_USR_ID			," ).append("\n"); 
		query.append("			CRE_DT				," ).append("\n"); 
		query.append("			UPD_USR_ID			," ).append("\n"); 
		query.append("			UPD_DT				," ).append("\n"); 
		query.append("			OP_CD				," ).append("\n"); 
		query.append("			POL_CLPT_IND_SEQ	," ).append("\n"); 
		query.append("			POD_CLPT_IND_SEQ	," ).append("\n"); 
		query.append("			BKG_TRSP_MZD_CD		," ).append("\n"); 
		query.append("			CNTR_LODG_FLG		," ).append("\n"); 
		query.append("			REV_VVD_FLG			," ).append("\n"); 
		query.append("			OSCA_CRE_DT     	," ).append("\n"); 
		query.append("			OSCA_UPD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     VALUES " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("			@[bkg_no]			," ).append("\n"); 
		query.append("			@[vsl_pre_pst_cd]	," ).append("\n"); 
		query.append("			@[vsl_seq]			," ).append("\n"); 
		query.append("			(SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE MODI_VSL_SLAN_CD2 = @[slan_cd] and rownum = 1)," ).append("\n"); 
		query.append("			NVL((SELECT MAP.VSL_CD FROM  MDM_VSL_CNTR MAP WHERE" ).append("\n"); 
		query.append("				 MAP.VSL_CD LIKE SUBSTR(TRIM(@[vsl_cd]),1,3)||'%' AND SUBSTR(MAP.VSL_CD,1,3) = SUBSTR(TRIM(@[vsl_cd]),1,3) " ).append("\n"); 
		query.append("				AND DELT_FLG != 'Y' AND ROWNUM <= 1),'')," ).append("\n"); 
		query.append("			Decode(length(@[skd_voy_no]), 3, '0'||@[skd_voy_no], 4, @[skd_voy_no], NVL(@[skd_voy_no],''))	," ).append("\n"); 
		query.append("			NVL(@[skd_dir_cd],'')	," ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS POL_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			NVL((select YD_CD AS POL_YD_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')		,			" ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS POD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			NVL((select YD_CD AS POD_YD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_yd_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')		," ).append("\n"); 
		query.append("			@[cre_usr_id]		," ).append("\n"); 
		query.append("			sysdate		," ).append("\n"); 
		query.append("			@[upd_usr_id]				," ).append("\n"); 
		query.append("			sysdate	 	," ).append("\n"); 
		query.append("			@[op_cd]					," ).append("\n"); 
		query.append("			@[pol_clpt_ind_seq]			," ).append("\n"); 
		query.append("			@[pod_clpt_ind_seq]			," ).append("\n"); 
		query.append("			@[bkg_trsp_mzd_cd]			," ).append("\n"); 
		query.append("			NVL(@[cntr_lodg_flg],'N')			," ).append("\n"); 
		query.append("			@[rev_vvd_flg]				," ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[cre_dt],0,19),'YYYY-MM-DD HH24:MI:SS')		,			" ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[upd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}