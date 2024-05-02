/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOAddCopHdrByValuesCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.07 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddCopHdrByValuesCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Value 를 받아 SCE_COP_HDR 정보를 생성한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOAddCopHdrByValuesCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ob_dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_fsh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prov_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_upd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_dt_src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_rail_chk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddCopHdrByValuesCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_COP_HDR (" ).append("\n"); 
		query.append("COP_NO                      ," ).append("\n"); 
		query.append("BKG_NO                      ," ).append("\n"); 
		query.append("CNTR_NO                     ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD                ," ).append("\n"); 
		query.append("CNMV_YR                     ," ).append("\n"); 
		query.append("COP_STS_CD                  ," ).append("\n"); 
		query.append("PCTL_NO                     ," ).append("\n"); 
		query.append("MST_COP_NO                  ," ).append("\n"); 
		query.append("COP_FSH_DT                  ," ).append("\n"); 
		query.append("TRNK_VSL_CD                 ," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO             ," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD             ," ).append("\n"); 
		query.append("POR_NOD_CD                  ," ).append("\n"); 
		query.append("POL_NOD_CD                  ," ).append("\n"); 
		query.append("POD_NOD_CD                  ," ).append("\n"); 
		query.append("DEL_NOD_CD                  ," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD             ," ).append("\n"); 
		query.append("IB_TRO_FLG                  ," ).append("\n"); 
		query.append("OB_TRO_FLG                  ," ).append("\n"); 
		query.append("RAIL_RCV_COFF_DT_SRC_TP_CD  ," ).append("\n"); 
		query.append("RAIL_RCV_COFF_FM_DT         ," ).append("\n"); 
		query.append("CRE_USR_ID                  ," ).append("\n"); 
		query.append("CRE_DT                      ," ).append("\n"); 
		query.append("UPD_USR_ID                  ," ).append("\n"); 
		query.append("UPD_DT                      ," ).append("\n"); 
		query.append("COP_SUB_STS_CD              ," ).append("\n"); 
		query.append("RAIL_RCV_COFF_TO_DT         ," ).append("\n"); 
		query.append("UMCH_STS_CD                 ," ).append("\n"); 
		query.append("PROV_CNTR_NO                ," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD           ," ).append("\n"); 
		query.append("CFM_OB_DOR_ARR_DT           ," ).append("\n"); 
		query.append("CFM_APNT_DT                 ," ).append("\n"); 
		query.append("COP_UPD_RMK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cop_no]," ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[cnmv_yr]," ).append("\n"); 
		query.append("@[cop_sts_cd]," ).append("\n"); 
		query.append("@[pctl_no]," ).append("\n"); 
		query.append("@[mst_cop_no]," ).append("\n"); 
		query.append("TO_DATE(@[cop_fsh_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[trnk_vsl_cd]," ).append("\n"); 
		query.append("@[trnk_skd_voy_no]," ).append("\n"); 
		query.append("@[trnk_skd_dir_cd]," ).append("\n"); 
		query.append("@[por_nod_cd]," ).append("\n"); 
		query.append("@[pol_nod_cd]," ).append("\n"); 
		query.append("@[pod_nod_cd]," ).append("\n"); 
		query.append("@[del_nod_cd]," ).append("\n"); 
		query.append("@[cop_rail_chk_cd]," ).append("\n"); 
		query.append("@[ib_tro_flg]," ).append("\n"); 
		query.append("@[ob_tro_flg]," ).append("\n"); 
		query.append("@[rail_rcv_coff_dt_src_tp_cd]," ).append("\n"); 
		query.append("TO_DATE(@[rail_rcv_coff_fm_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cop_sub_sts_cd]," ).append("\n"); 
		query.append("TO_DATE(@[rail_rcv_coff_to_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[umch_sts_cd]," ).append("\n"); 
		query.append("@[prov_cntr_no]," ).append("\n"); 
		query.append("@[prov_cntr_tpsz_cd]," ).append("\n"); 
		query.append("TO_DATE(@[cfm_ob_dor_arr_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("TO_DATE(@[cfm_apnt_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI') || '> ' || @[cop_upd_rmk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}