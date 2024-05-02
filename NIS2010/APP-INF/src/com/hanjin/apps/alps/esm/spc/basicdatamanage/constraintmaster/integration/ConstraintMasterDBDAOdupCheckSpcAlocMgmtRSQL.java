/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.03 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중복체크
	  * </pre>
	  */
	public ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_aply_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_aply_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_per_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_aloc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_ts_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpb_per_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_ts_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ts_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_por_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL").append("\n"); 
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
		query.append("SELECT 'Type : '||" ).append("\n"); 
		query.append("      (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("    	FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("        WHERE BKG_ALOC_TP_CD = INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("        AND INTG_CD_ID = 'CD03428'" ).append("\n"); 
		query.append("		)|| ' ' ||" ).append("\n"); 
		query.append("      		DECODE(BKG_ALOC_TP_CD,'T',', T.Lane : '|| TRNK_SLAN_CD,'') ||" ).append("\n"); 
		query.append("        	DECODE(BKG_ALOC_TP_CD,'S',', T/S Lane : '|| N1ST_TS_SLAN_CD ,'') || " ).append("\n"); 
		query.append("        	DECODE(BKG_ALOC_TP_CD,'E',', Cntr Type : '|| CNTR_TPSZ_CD,'') ||" ).append("\n"); 
		query.append("        	DECODE(BKG_ALOC_TP_CD,'M',', Commodity : '|| NVL(CMDT_CD,SCG_GRP_CMDT_SEQ),'') || " ).append("\n"); 
		query.append("        	DECODE(BKG_ALOC_TP_CD,'C',', SC No / RFA No / Contract Code / Shipper Code : '" ).append("\n"); 
		query.append("        			|| SC_NO || ' / ' || RFA_NO || ' / ' || CTRT_CUST_CNT_CD||CTRT_CUST_SEQ || ' / ' || CUST_CNT_CD||CUST_SEQ, '')||" ).append("\n"); 
		query.append("			DECODE(BKG_ALOC_TP_CD,'F',', Sub Trade / BD : '|| SUB_TRD_CD ||'/' || TRNK_DIR_CD, '') ||" ).append("\n"); 
		query.append("			DECODE(BKG_ALOC_TP_CD,'A',', Sub Trade / BD : '|| SUB_TRD_CD ||'/' || TRNK_DIR_CD, '')  " ).append("\n"); 
		query.append("			AS BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("WHERE BKG_ALOC_TP_CD =  @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("AND BKG_ALOC_SEQ 					<> NVL(TO_NUMBER(@[bkg_aloc_seq])        ,0)" ).append("\n"); 
		query.append("AND NVL(RVIS_CNTR_CUST_TP_CD  	,'NULL') = NVL(@[acct_tp]       ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(TRNK_SLAN_CD    	,'NULL') = NVL(@[trnk_slan_cd]                   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(TRNK_DIR_CD     	,'NULL') = NVL(@[trnk_dir_cd]                    ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(VSL_CD      		,'NULL') = NVL(SUBSTR(@[vvd],1,4)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SKD_VOY_NO    		,'NULL') = NVL(SUBSTR(@[vvd],5,4)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SKD_DIR_CD    		,'NULL') = NVL(SUBSTR(@[vvd],9,1)                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SLS_RHQ_CD    		,'NULL') = NVL(@[sls_rhq_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(OB_SLS_OFC_CD  		,'NULL') = NVL(@[ob_sls_ofc_cd]                  ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POR_NOD_CD      	,'NULL') = NVL(@[por_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_POR_SCC_CD  	,'NULL') = NVL(@[bkg_por_scc_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POL_NOD_CD      	,'NULL') = NVL(@[pol_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(N1ST_TS_SLAN_CD 	,'NULL') = NVL(@[n1st_ts_slan_cd]                ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(POD_NOD_CD      	,'NULL') = NVL(@[pod_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(DEL_NOD_CD      	,'NULL') = NVL(@[del_nod_cd]                     ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(BKG_DEL_SCC_CD  	,'NULL') = NVL(@[bkg_del_scc_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(SC_NO           	,'NULL') = NVL(@[sc_no]                          ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(RFA_NO          	,'NULL') = NVL(@[rfa_no]                         ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CTRT_CUST_CNT_CD	,'NULL') = NVL(SUBSTR(@[ctrt_cust_cnt_cd],1,2)   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CTRT_CUST_SEQ   	,0)      = NVL(SUBSTR(@[ctrt_cust_cnt_cd],3)     ,0)  " ).append("\n"); 
		query.append("AND NVL(CUST_CNT_CD     	,'NULL') = NVL(SUBSTR(@[cust_cnt_cd],1,2)        ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CUST_SEQ        	,0)      = NVL(SUBSTR(@[cust_cnt_cd],3)          ,0)  " ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(Z.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL Z WHERE Z.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ),'NULL') = NVL(@[cntr_tpsz_cd],'NULL')  " ).append("\n"); 
		query.append("AND NVL(N1ST_TS_DIR_CD  	,'NULL') = NVL(@[n1st_ts_dir_cd]                 ,'NULL')  " ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ),'NULL') = NVL(@[cmdt_cd],'NULL')  " ).append("\n"); 
		query.append("AND NVL(SCG_GRP_CMDT_SEQ	,0)      = NVL(@[scg_grp_cmdt_seq]               ,0)" ).append("\n"); 
		query.append("AND NVL(CMPB_AMT			,0) 	 = NVL(TO_NUMBER(@[cmpb_amt])            ,0)" ).append("\n"); 
		query.append("AND NVL(BKG_CTRL_TP_CD	    ,'NULL') = NVL(@[bkg_ctrl_tp_cd]           		,'NULL')" ).append("\n"); 
		query.append("AND NVL(CUST_GRP_ID    	    ,'NULL') = NVL(@[cust_grp_id]                   ,'NULL')  " ).append("\n"); 
		query.append("AND NVL(CMPB_PER_TON_AMT        ,0) = NVL(TO_NUMBER(@[cmpb_per_wgt])            ,0)  " ).append("\n"); 
		query.append("AND NVL(TON_PER_TEU_WGT         ,0) = NVL(TO_NUMBER(@[wgt_per_teu])             ,0)  " ).append("\n"); 
		query.append("AND NVL(RFA_CTRT_TP_CD      ,'NULL') = NVL(@[rfa_ctrt_tp_cd]                ,'NULL')  " ).append("\n"); 
		query.append("#if (${sls_rhq_cd} != 'NYCRA') " ).append("\n"); 
		query.append("  AND NVL(DCGO_FLG			,'NULL')  = NVL(@[dcgo_flg]           				,'NULL')" ).append("\n"); 
		query.append("  AND NVL(RD_CGO_FLG		,'NULL')  = NVL(@[rd_cgo_flg]           			,'NULL')" ).append("\n"); 
		query.append("  AND NVL(ALOC_APLY_FM_DT	,'NULL')  = NVL(REPLACE(@[aloc_aply_fm_dt],'-','')  ,'NULL')" ).append("\n"); 
		query.append("  AND NVL(ALOC_APLY_TO_DT	,'NULL')  = NVL(REPLACE(@[aloc_aply_to_dt],'-','')  ,'NULL')" ).append("\n"); 
		query.append("  AND NVL(SUB_TRD_CD		,'NULL')  = NVL(@[sub_trd_cd]           			,'NULL')" ).append("\n"); 
		query.append("  AND NVL(OFT_CHG_AMT		,0) 	  = NVL(TO_NUMBER(@[oft_chg_amt])           ,0)" ).append("\n"); 
		query.append("  AND NVL(USA_BKG_MOD_CD	,'OTH')   = NVL(@[usa_bkg_mod_cd]           		,'OTH')" ).append("\n"); 
		query.append("  AND NVL(HUL_BND_CD	    ,'XX')    = NVL(@[hul_bnd_cd]           		    ,'XX')" ).append("\n"); 
		query.append("  AND NVL(APLY_FM_YRWK	    ,'XXXXXX')= NVL(REPLACE(@[aply_fm_yrwk],'-','')     ,'XXXXXX')" ).append("\n"); 
		query.append("  AND NVL(APLY_TO_YRWK	    ,'XXXXXX')= NVL(REPLACE(@[aply_to_yrwk],'-','')     ,'XXXXXX')" ).append("\n"); 
		query.append("  AND NVL((SELECT WM_CONCAT(AD.CUST_CNT_CD || LPAD(AD.CUST_SEQ, '0', 6)) FROM SPC_BKG_ALOC_MGMT_CUST_DTL AD WHERE AD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND AD.BKG_CUST_TP_CD = 'B'), 'XX999999') = NVL(@[agmt_act_cnt_cd]||@[agmt_act_cust_seq], 'XX999999')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[trunk_pol_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[trunk_pod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[n1st_ts_pol_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[n1st_ts_pod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[n1st_ts_pol_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[n1st_ts_pod_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[bkg_por_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[por_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[bkg_pol_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[pol_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[bkg_pod_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[pod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 2 ),'NULL') = NVL(@[bkg_del_cnt_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 5 ),'NULL') = NVL(@[del_cd],'NULL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SAY' ),'NULL') = NVL(@[ts_nod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SLY' ),'NULL') = NVL(@[ts_pol_nod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SDY' ),'NULL') = NVL(@[ts_pod_nod_cd],'NULL')" ).append("\n"); 
		query.append("AND NVL((SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'STW' ),'NULL') = NVL(null,'NULL')" ).append("\n"); 

	}
}