/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOUpdateEDIEccMvmtUSQL.java
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

public class ContainerMovementMgtDBDAOUpdateEDIEccMvmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Batch BKG_BOOKING/EPP 파일에 U인경우 업데이트처리
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOUpdateEDIEccMvmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_blk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcmt_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_split_aval_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOUpdateEDIEccMvmtUSQL").append("\n"); 
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
		query.append("UPDATE CTM_BOOKING SET" ).append("\n"); 
		query.append("	BL_NO			=	@[bl_no]			," ).append("\n"); 
		query.append("	BKG_STS_CD		=	@[bkg_sts_cd]		," ).append("\n"); 
		query.append("	BKG_CGO_TP_CD	=	@[bkg_cgo_tp_cd]	," ).append("\n"); 
		query.append("	SLAN_CD			=	(SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE MODI_VSL_SLAN_CD2 = @[slan_cd] and rownum = 1)			," ).append("\n"); 
		query.append("	SVC_SCP_CD		=	@[svc_scp_cd]		," ).append("\n"); 
		query.append("	VSL_CD			=	NVL((SELECT MAP.VSL_CD FROM  MDM_VSL_CNTR MAP WHERE" ).append("\n"); 
		query.append("				 		MAP.VSL_CD LIKE SUBSTR(TRIM(@[vsl_cd]),1,3)||'%' AND SUBSTR(MAP.VSL_CD,1,3) = SUBSTR(TRIM(@[vsl_cd]),1,3) " ).append("\n"); 
		query.append("						AND DELT_FLG != 'Y' AND ROWNUM <= 1),'COXX')	," ).append("\n"); 
		query.append("	SKD_VOY_NO		=	Decode(length(@[skd_voy_no]), 3, '0'||@[skd_voy_no], 4, @[skd_voy_no], NVL(@[skd_voy_no],'0001'))	," ).append("\n"); 
		query.append("	SKD_DIR_CD		=	NVL(@[skd_dir_cd],'E')		," ).append("\n"); 
		query.append("	RCV_TERM_CD		=	@[rcv_term_cd]		," ).append("\n"); 
		query.append("	DE_TERM_CD		=	@[de_term_cd]		," ).append("\n"); 
		query.append("	POR_CD			=	NVL((select SUBSTR(YD_CD,0,5) AS POR_CD from MDM_YARD WHERE MODI_YD_CD=@[por_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')	," ).append("\n"); 
		query.append("	POL_CD			=	NVL((select SUBSTR(YD_CD,0,5) AS POL_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')		," ).append("\n"); 
		query.append("	POD_CD			=	NVL((select SUBSTR(YD_CD,0,5) AS POD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')	," ).append("\n"); 
		query.append("	DEL_CD			=	NVL((select SUBSTR(YD_CD,0,5) AS DEL_CD from MDM_YARD WHERE MODI_YD_CD=@[del_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')		," ).append("\n"); 
		query.append("	OSCA_CMDT_CD	=	''					," ).append("\n"); 
		query.append("	DCGO_FLG		=	@[dcgo_flg]			," ).append("\n"); 
		query.append("	RC_FLG			=	@[rc_flg]			," ).append("\n"); 
		query.append("	AWK_CGO_FLG		=	@[awk_cgo_flg]		," ).append("\n"); 
		query.append("	BB_CGO_FLG		=	@[bb_cgo_flg]		," ).append("\n"); 
		query.append("	RD_CGO_FLG		=	@[rd_cgo_flg]		," ).append("\n"); 
		query.append("	HNGR_FLG		=	@[hngr_flg]			," ).append("\n"); 
		query.append("	PRCT_FLG		=	@[prct_flg]			," ).append("\n"); 
		query.append("	SPCL_HIDE_FLG	=	@[spcl_hide_flg]	," ).append("\n"); 
		query.append("	SOC_FLG			=	@[soc_flg]			," ).append("\n"); 
		query.append("	SPLIT_FLG		=	@[split_flg]		," ).append("\n"); 
		query.append("	HCMT_CMB_FLG	=	@[hcmt_cmb_flg]		," ).append("\n"); 
		query.append("	BKG_CRE_TP_CD	=	@[bkg_cre_tp_cd]	," ).append("\n"); 
		query.append("	TO_BKG_NO		=	@[to_bkg_no]		," ).append("\n"); 
		query.append("	FM_BKG_NO		=	@[fm_bkg_no]		," ).append("\n"); 
		query.append("	MTY_SPLIT_AVAL_CD	=	@[mty_split_aval_cd]	," ).append("\n"); 
		query.append("	PRE_RLY_PORT_CD	=	@[pre_rly_port_cd]	," ).append("\n"); 
		query.append("	PST_RLY_PORT_CD	=	@[pst_rly_port_cd]	," ).append("\n"); 
		query.append("	UPD_USR_ID		=	@[upd_usr_id]		," ).append("\n"); 
		query.append("	UPD_DT			=	sysdate	, " ).append("\n"); 
		query.append("	BL_NO_TP		=	@[bl_no_tp]			," ).append("\n"); 
		query.append("	BL_TP_CD		=	@[bl_tp_cd]			," ).append("\n"); 
		query.append("	REP_CMDT_CD		=	@[rep_cmdt_cd]		," ).append("\n"); 
		query.append("	RAIL_BLK_CD		=	@[rail_blk_cd]		," ).append("\n"); 
		query.append(" 	OSCA_UPD_DT 	=   TO_DATE(SUBSTR(@[upd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("	VPS_ETD_DT 		=   TO_DATE(SUBSTR(@[etd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	BKG_NO			=	@[bkg_no]" ).append("\n"); 

	}
}