/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDIEccMvmtCSQL.java
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

public class ContainerMovementMgtDBDAOInsertEDIEccMvmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Batch ECC관련 데이타를 CTM_BOOKING 테이블에 INSERT
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDIEccMvmtCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDIEccMvmtCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_BOOKING" ).append("\n"); 
		query.append("			(BKG_NO			," ).append("\n"); 
		query.append("			BL_NO			," ).append("\n"); 
		query.append("			BKG_STS_CD		," ).append("\n"); 
		query.append("			BKG_CGO_TP_CD	," ).append("\n"); 
		query.append("			SLAN_CD			," ).append("\n"); 
		query.append("			SVC_SCP_CD		," ).append("\n"); 
		query.append("			VSL_CD			," ).append("\n"); 
		query.append("			SKD_VOY_NO		," ).append("\n"); 
		query.append("			SKD_DIR_CD		," ).append("\n"); 
		query.append("			RCV_TERM_CD		," ).append("\n"); 
		query.append("			DE_TERM_CD		," ).append("\n"); 
		query.append("			POR_CD			," ).append("\n"); 
		query.append("			POL_CD			," ).append("\n"); 
		query.append("			POD_CD			," ).append("\n"); 
		query.append("			DEL_CD			," ).append("\n"); 
		query.append("			OSCA_CMDT_CD	," ).append("\n"); 
		query.append("			DCGO_FLG		," ).append("\n"); 
		query.append("			RC_FLG			," ).append("\n"); 
		query.append("			AWK_CGO_FLG		," ).append("\n"); 
		query.append("			BB_CGO_FLG		," ).append("\n"); 
		query.append("			RD_CGO_FLG		," ).append("\n"); 
		query.append("			HNGR_FLG		," ).append("\n"); 
		query.append("			PRCT_FLG		," ).append("\n"); 
		query.append("			SPCL_HIDE_FLG	," ).append("\n"); 
		query.append("			SOC_FLG			," ).append("\n"); 
		query.append("			SPLIT_FLG		," ).append("\n"); 
		query.append("			HCMT_CMB_FLG	," ).append("\n"); 
		query.append("			BKG_CRE_TP_CD	," ).append("\n"); 
		query.append("			TO_BKG_NO		," ).append("\n"); 
		query.append("			FM_BKG_NO		," ).append("\n"); 
		query.append("			MTY_SPLIT_AVAL_CD," ).append("\n"); 
		query.append("			PRE_RLY_PORT_CD	," ).append("\n"); 
		query.append("			PST_RLY_PORT_CD	," ).append("\n"); 
		query.append("			CRE_USR_ID		," ).append("\n"); 
		query.append("			CRE_DT			," ).append("\n"); 
		query.append("			UPD_USR_ID		," ).append("\n"); 
		query.append("			UPD_DT			," ).append("\n"); 
		query.append("			BL_NO_TP		," ).append("\n"); 
		query.append("			BL_TP_CD		," ).append("\n"); 
		query.append("			REP_CMDT_CD		," ).append("\n"); 
		query.append("			RAIL_BLK_CD		," ).append("\n"); 
		query.append("			OSCA_CRE_DT     ," ).append("\n"); 
		query.append("			OSCA_UPD_DT		," ).append("\n"); 
		query.append("			VPS_ETD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     VALUES " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("			@[bkg_no]			," ).append("\n"); 
		query.append("			@[bl_no]			," ).append("\n"); 
		query.append("			@[bkg_sts_cd]		," ).append("\n"); 
		query.append("			@[bkg_cgo_tp_cd]	," ).append("\n"); 
		query.append("			(SELECT VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE MODI_VSL_SLAN_CD2 = @[slan_cd] and rownum = 1)," ).append("\n"); 
		query.append("			@[svc_scp_cd]		," ).append("\n"); 
		query.append("			NVL((SELECT MAP.VSL_CD FROM  MDM_VSL_CNTR MAP WHERE" ).append("\n"); 
		query.append("			MAP.VSL_CD LIKE SUBSTR(TRIM(@[vsl_cd]),1,3)||'%' AND SUBSTR(MAP.VSL_CD,1,3) = SUBSTR(TRIM(@[vsl_cd]),1,3) " ).append("\n"); 
		query.append("			AND DELT_FLG != 'Y' AND ROWNUM <= 1),'COXX')	," ).append("\n"); 
		query.append("			Decode(length(@[skd_voy_no]), 3, '0'||@[skd_voy_no], 4, @[skd_voy_no], NVL(@[skd_voy_no],'0001'))	," ).append("\n"); 
		query.append("			NVL(@[skd_dir_cd],'E')		," ).append("\n"); 
		query.append("			@[rcv_term_cd]		," ).append("\n"); 
		query.append("			@[de_term_cd]		," ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS POR_CD from MDM_YARD WHERE MODI_YD_CD=@[por_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS POL_CD from MDM_YARD WHERE MODI_YD_CD=@[pol_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS POD_CD from MDM_YARD WHERE MODI_YD_CD=@[pod_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			NVL((select SUBSTR(YD_CD,0,5) AS DEL_CD from MDM_YARD WHERE MODI_YD_CD=@[del_cd] AND DELT_FLG != 'Y' AND ROWNUM=1),'')			," ).append("\n"); 
		query.append("			''	," ).append("\n"); 
		query.append("			@[dcgo_flg]		," ).append("\n"); 
		query.append("			@[rc_flg]			," ).append("\n"); 
		query.append("			@[awk_cgo_flg]		," ).append("\n"); 
		query.append("			@[bb_cgo_flg]		," ).append("\n"); 
		query.append("			@[rd_cgo_flg]		," ).append("\n"); 
		query.append("			@[hngr_flg]		," ).append("\n"); 
		query.append("			@[prct_flg]		," ).append("\n"); 
		query.append("			@[spcl_hide_flg]	," ).append("\n"); 
		query.append("			@[soc_flg]			," ).append("\n"); 
		query.append("			@[split_flg]		," ).append("\n"); 
		query.append("			@[hcmt_cmb_flg]	," ).append("\n"); 
		query.append("			@[bkg_cre_tp_cd]	," ).append("\n"); 
		query.append("			@[to_bkg_no]		," ).append("\n"); 
		query.append("			@[fm_bkg_no]		," ).append("\n"); 
		query.append("			@[mty_split_aval_cd]," ).append("\n"); 
		query.append("			@[pre_rly_port_cd]	," ).append("\n"); 
		query.append("			@[pst_rly_port_cd]	," ).append("\n"); 
		query.append("			@[cre_usr_id]		," ).append("\n"); 
		query.append("			sysdate			," ).append("\n"); 
		query.append("			@[upd_usr_id]		," ).append("\n"); 
		query.append("			sysdate			," ).append("\n"); 
		query.append("			@[bl_no_tp]		," ).append("\n"); 
		query.append("			@[bl_tp_cd]		," ).append("\n"); 
		query.append("			@[rep_cmdt_cd]		," ).append("\n"); 
		query.append("			@[rail_blk_cd]		," ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[cre_dt],0,19),'YYYY-MM-DD HH24:MI:SS')			," ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[upd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[etd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}