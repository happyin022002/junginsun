/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReplanManageDBDAOModifyPlnSoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOModifyPlnSoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_PLN_SO_LIST 정보 변경 업무를 담당한다.
	  * </pre>
	  */
	public ReplanManageDBDAOModifyPlnSoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_inv_bil_patt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_patt_div_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rqst_rsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOModifyPlnSoListUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("COST_ACT_GRP_CD 			= NVL(@[cost_act_grp_cd],			 A.COST_ACT_GRP_CD           )," ).append("\n"); 
		query.append("CTRL_OFC_CD                 = NVL(@[ctrl_ofc_cd],                A.CTRL_OFC_CD               )," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT             = NVL(TO_DATE(@[n1st_nod_pln_dt],	'YYYYMMDDHH24MISS'),		A.N1ST_NOD_PLN_DT           )," ).append("\n"); 
		query.append("N1ST_NOD_CD                 = NVL(@[n1st_nod_cd],                A.N1ST_NOD_CD				 )," ).append("\n"); 
		query.append("N2ND_NOD_CD                 = NVL(@[n2nd_nod_cd],                A.N2ND_NOD_CD               )," ).append("\n"); 
		query.append("N3RD_NOD_CD                 = NVL(@[n3rd_nod_cd],                A.N3RD_NOD_CD               )," ).append("\n"); 
		query.append("N4TH_NOD_CD                 = NVL(@[n4th_nod_cd],                A.N4TH_NOD_CD               )," ).append("\n"); 
		query.append("PCTL_IO_BND_CD              = NVL(@[pctl_io_bnd_cd],             A.PCTL_IO_BND_CD            )," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD            = NVL(@[pctl_cost_mod_cd],           A.PCTL_COST_MOD_CD          )," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ               = NVL(@[n1st_vndr_seq],              A.N1ST_VNDR_SEQ             )," ).append("\n"); 
		query.append("TRSP_SO_STS_CD              = NVL(@[trsp_so_sts_cd],             A.TRSP_SO_STS_CD            )," ).append("\n"); 
		query.append("TRNS_RQST_OFC_CD            = NVL(@[trns_rqst_ofc_cd],           A.TRNS_RQST_OFC_CD          )," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID            = NVL(@[trns_rqst_usr_id],           A.TRNS_RQST_USR_ID          )," ).append("\n"); 
		query.append("TRNS_RQST_RSN               = NVL(@[trns_rqst_rsn],              A.TRNS_RQST_RSN             )," ).append("\n"); 
		query.append("TRSP_MOD_CD                 = NVL(@[trsp_mod_cd],                A.TRSP_MOD_CD               )," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD  = NVL(@[inlnd_rout_inv_bil_patt_cd], A.INLND_ROUT_INV_BIL_PATT_CD)," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG        = NVL(@[inv_bil_patt_div_flg],       A.INV_BIL_PATT_DIV_FLG      )," ).append("\n"); 
		query.append("UPD_USR_ID                  = NVL(@[upd_usr_id],                 A.UPD_USR_ID                )," ).append("\n"); 
		query.append("UPD_DT                      = SYSDATE," ).append("\n"); 
		query.append("DELT_USR_ID                 = NVL(@[upd_usr_id],                 A.DELT_USR_ID               )," ).append("\n"); 
		query.append("DELT_DT                     = SYSDATE," ).append("\n"); 
		query.append("DOR_ARR_DT                  = NVL(TO_DATE(@[dor_arr_dt], 		 'YYYYMMDDHH24MISS'),         A.DOR_ARR_DT                )," ).append("\n"); 
		query.append("LST_NOD_PLN_DT              = NVL(TO_DATE(@[lst_nod_pln_dt], 	 'YYYYMMDDHH24MISS'),         A.LST_NOD_PLN_DT            )," ).append("\n"); 
		query.append("RVIS_IND_FLG				= NVL(@[rvis_ind_flg],               A.RVIS_IND_FLG              )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    COP_NO = @[cop_no]" ).append("\n"); 
		query.append("    AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 

	}
}