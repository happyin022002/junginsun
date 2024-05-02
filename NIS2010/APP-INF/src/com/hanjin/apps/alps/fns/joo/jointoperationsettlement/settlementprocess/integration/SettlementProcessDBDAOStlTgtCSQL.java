/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.05.24 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOStlTgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target 저장
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_sto_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_shw_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_scg_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rev_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rev_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_tgt_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_STL_TGT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" REV_YRMON" ).append("\n"); 
		query.append(",REV_YRMON_SEQ" ).append("\n"); 
		query.append(",REV_SEQ" ).append("\n"); 
		query.append(",ACCT_YRMON " ).append("\n"); 
		query.append(",STL_VVD_SEQ " ).append("\n"); 
		query.append(",STL_SEQ  " ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",RE_DIVR_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD     	--" ).append("\n"); 
		query.append(",VPS_PORT_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",RF_SCG_STL_TP_CD   --" ).append("\n"); 
		query.append(",STL_TGT_FLG 		--" ).append("\n"); 
		query.append(",STL_CLZ_FLG 		--" ).append("\n"); 
		query.append(",SLAN_CD        	--" ).append("\n"); 
		query.append(",RDR_FLG" ).append("\n"); 
		query.append(",VPS_ETD_DT" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",JO_STL_JB_CD" ).append("\n"); 
		query.append(",JO_STL_STS_CD" ).append("\n"); 
		query.append(",JO_STL_ITM_CD" ).append("\n"); 
		query.append(",BSA_QTY" ).append("\n"); 
		query.append(",BSA_SLT_PRC" ).append("\n"); 
		query.append(",FNL_BSA_QTY        --" ).append("\n"); 
		query.append(",FNL_BSA_SLT_PRC    --" ).append("\n"); 
		query.append(",LOCL_CURR_CD" ).append("\n"); 
		query.append(",STL_LOCL_AMT" ).append("\n"); 
		query.append(",STL_RMK" ).append("\n"); 
		query.append(",JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append(",OVR_USD_STO_TP_CD" ).append("\n"); 
		query.append(",REV_SHW_FLG " ).append("\n"); 
		query.append(",REV_BSA_QTY " ).append("\n"); 
		query.append(",REV_BSA_SLT_PRC 	" ).append("\n"); 
		query.append(",REV_ENBL_FLG" ).append("\n"); 
		query.append(",REV_CRR_CD                                   " ).append("\n"); 
		query.append(",N2ND_REV_BSA_QTY                             " ).append("\n"); 
		query.append(",N2ND_REV_BSA_SLT_PRC                         " ).append("\n"); 
		query.append(",N2ND_REV_ENBL_FLG                            " ).append("\n"); 
		query.append(",N2ND_REV_CRR_CD                              " ).append("\n"); 
		query.append(",N3RD_REV_BSA_QTY                             " ).append("\n"); 
		query.append(",N3RD_REV_BSA_SLT_PRC                         " ).append("\n"); 
		query.append(",N3RD_REV_ENBL_FLG                            " ).append("\n"); 
		query.append(",N3RD_REV_CRR_CD                              " ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" @[rev_yrmon]			AS REV_YRMON                  " ).append("\n"); 
		query.append(",@[rev_yrmon_seq]   	AS REV_YRMON_SEQ                " ).append("\n"); 
		query.append(",(SELECT NVL(MAX(REV_SEQ),0)+1 AS REV_SEQ FROM JOO_STL_TGT WHERE REV_YRMON = @[rev_yrmon] AND REV_YRMON_SEQ = @[rev_yrmon_seq]) AS REV_SEQ" ).append("\n"); 
		query.append(",'999912'				AS ACCT_YRMON" ).append("\n"); 
		query.append(",'0' 					AS STL_VVD_SEQ" ).append("\n"); 
		query.append(",'0'					AS STL_SEQ" ).append("\n"); 
		query.append(",@[trd_cd]				AS TRD_CD                     " ).append("\n"); 
		query.append(",@[crr_cd]				AS CRR_CD                     " ).append("\n"); 
		query.append(",@[rlane_cd]			AS RLANE_CD                   " ).append("\n"); 
		query.append(",@[re_divr_cd]			AS RE_DIVR_CD                 " ).append("\n"); 
		query.append(",@[vsl_cd]				AS VSL_CD                     " ).append("\n"); 
		query.append(",@[skd_voy_no]			AS SKD_VOY_NO                 " ).append("\n"); 
		query.append(",@[skd_dir_cd]			AS SKD_DIR_CD    " ).append("\n"); 
		query.append(",@[rev_dir_cd]			AS REV_DIR_CD     	--             " ).append("\n"); 
		query.append(",@[vps_port_cd]			AS VPS_PORT_CD                " ).append("\n"); 
		query.append(",@[yd_cd]				AS YD_CD                      " ).append("\n"); 
		query.append(",@[clpt_ind_seq]		AS CLPT_IND_SEQ     " ).append("\n"); 
		query.append(",@[rf_scg_stl_tp_cd] 	AS RF_SCG_STL_TP_CD   --" ).append("\n"); 
		query.append(",@[stl_tgt_flg] 		AS STL_TGT_FLG 		--" ).append("\n"); 
		query.append(",@[stl_clz_flg] 		AS STL_CLZ_FLG 		--" ).append("\n"); 
		query.append(",SUBSTR(@[rlane_cd],0,3) AS SLAN_CD        	--          " ).append("\n"); 
		query.append(",@[rdr_flg]				AS RDR_FLG                    " ).append("\n"); 
		query.append(",TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MISS')	AS VPS_ETD_DT                    " ).append("\n"); 
		query.append(",@[acct_cd]				AS ACCT_CD                    " ).append("\n"); 
		query.append(",@[jo_stl_jb_cd]		AS JO_STL_JB_CD               " ).append("\n"); 
		query.append(",@[jo_stl_sts_cd]		AS JO_STL_STS_CD              " ).append("\n"); 
		query.append(",@[jo_stl_itm_cd]		AS JO_STL_ITM_CD              " ).append("\n"); 
		query.append(",@[bsa_qty]				AS BSA_QTY                    " ).append("\n"); 
		query.append(",@[bsa_slt_prc]			AS BSA_SLT_PRC                " ).append("\n"); 
		query.append(",@[fnl_bsa_qty]			AS FNL_BSA_QTY        --" ).append("\n"); 
		query.append(",@[fnl_bsa_slt_prc]		AS FNL_BSA_SLT_PRC    --" ).append("\n"); 
		query.append(",NVL(@[locl_curr_cd],'USD')				  		 AS LOCL_CURR_CD               " ).append("\n"); 
		query.append(",NVL(@[fnl_bsa_qty],0)*NVL(@[fnl_bsa_slt_prc],0) AS STL_LOCL_AMT               " ).append("\n"); 
		query.append(",@[stl_rmk]				AS STL_RMK                    " ).append("\n"); 
		query.append(",@[jo_stl_tgt_itm_cd]	AS JO_STL_TGT_ITM_CD          " ).append("\n"); 
		query.append(",@[ovr_usd_sto_tp_cd]	AS OVR_USD_STO_TP_CD       " ).append("\n"); 
		query.append(",NVL(@[rev_shw_flg],'Y') AS REV_SHW_FLG" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[rev_bsa_qty],'R/FI',@[rev_bsa_qty],NULL) 					 AS REV_BSA_QTY" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[rev_bsa_slt_prc],'R/FI',@[rev_bsa_slt_prc],NULL)			 AS REV_BSA_SLT_PRC" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI','0','R/FI','0',NULL)						 					 AS REV_ENBL_FLG " ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[rev_crr_cd],'R/FI',@[rev_crr_cd],NULL) 			 		 AS REV_CRR_CD" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n2nd_rev_bsa_qty],'R/FI',@[n2nd_rev_bsa_qty],NULL) 		 AS N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n2nd_rev_bsa_slt_prc],'R/FI',@[n2nd_rev_bsa_slt_prc],NULL)	 AS N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI','0','R/FI','0',NULL) 	 	 								 AS N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n2nd_rev_crr_cd],'R/FI',@[n2nd_rev_crr_cd],NULL) 		 	 AS N2ND_REV_CRR_CD" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n3rd_rev_bsa_qty],'R/FI',@[n3rd_rev_bsa_qty],NULL) 		 AS N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n3rd_rev_bsa_slt_prc],'R/FI',@[n3rd_rev_bsa_slt_prc],NULL)	 AS N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI','0','R/FI','0',NULL) 	 	 								 AS N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append(",DECODE(@[jo_stl_itm_cd] || @[rf_scg_stl_tp_cd],'OUSI',@[n3rd_rev_crr_cd],'R/FI',@[n3rd_rev_crr_cd],NULL)		 	 AS N3RD_REV_CRR_CD" ).append("\n"); 
		query.append(",@[delt_flg]			AS DELT_FLG      " ).append("\n"); 
		query.append(",SYSDATE				AS CRE_DT                     " ).append("\n"); 
		query.append(",@[upd_usr_id]			AS CRE_USR_ID                 " ).append("\n"); 
		query.append(",SYSDATE				AS UPD_DT                     " ).append("\n"); 
		query.append(",@[upd_usr_id]			AS UPD_USR_ID           " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}