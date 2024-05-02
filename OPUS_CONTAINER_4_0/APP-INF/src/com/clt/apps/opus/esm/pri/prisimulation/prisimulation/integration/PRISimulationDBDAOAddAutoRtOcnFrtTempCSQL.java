/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * save temporarily for calling surcharge auto-rating
	  * </pre>
	  */
	public PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dry_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOAddAutoRtOcnFrtTempCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SIM_OCN_FRT_TMP (" ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("OFT_CMB_SEQ," ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("OFRT_SEQ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("EQ_SUBST_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CTRT_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("DE_TERM_CD," ).append("\n"); 
		query.append("DRY_CGO_FLG," ).append("\n"); 
		query.append("AWK_CGO_FLG," ).append("\n"); 
		query.append("DCGO_FLG," ).append("\n"); 
		query.append("RC_FLG," ).append("\n"); 
		query.append("BB_CGO_FLG," ).append("\n"); 
		query.append("SOC_FLG," ).append("\n"); 
		query.append("IMDG_CLSS_CD," ).append("\n"); 
		query.append("PRC_GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("PRC_CMDT_HDR_SEQ," ).append("\n"); 
		query.append("PRC_ROUT_SEQ," ).append("\n"); 
		query.append("PRC_RT_SEQ," ).append("\n"); 
		query.append("OP_CNTR_QTY," ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_UT_AMT," ).append("\n"); 
		query.append("RAT_AS_QTY," ).append("\n"); 
		query.append("CHG_AMT," ).append("\n"); 
		query.append("POR_MTCH_FLG," ).append("\n"); 
		query.append("DEL_MTCH_FLG," ).append("\n"); 
		query.append("TRI_PROP_NO," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[pctl_no]," ).append("\n"); 
		query.append("1, /* OFT Autorating 은  1로 입력 */" ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("NVL((select max(OFRT_SEQ) FROM PRI_SIM_OCN_FRT_TMP),0)+1," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[eq_subst_cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[ctrt_cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[rcv_term_cd]," ).append("\n"); 
		query.append("@[de_term_cd]," ).append("\n"); 
		query.append("@[dry_cgo_flg]," ).append("\n"); 
		query.append("@[awk_cgo_flg]," ).append("\n"); 
		query.append("@[dcgo_flg]," ).append("\n"); 
		query.append("@[rc_flg]," ).append("\n"); 
		query.append("@[bb_cgo_flg]," ).append("\n"); 
		query.append("@[soc_flg]," ).append("\n"); 
		query.append("@[imdg_clss_cd]," ).append("\n"); 
		query.append("@[prc_gen_spcl_rt_tp_cd]," ).append("\n"); 
		query.append("${prc_cmdt_hdr_seq}," ).append("\n"); 
		query.append("${prc_rout_seq}," ).append("\n"); 
		query.append("${prc_rt_seq}," ).append("\n"); 
		query.append("${op_cntr_qty}," ).append("\n"); 
		query.append("@[chg_cd]," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("@[chg_ut_amt],--[fnl_frt_rt_amt]" ).append("\n"); 
		query.append("@[rat_as_qty],--[op_cntr_qty]," ).append("\n"); 
		query.append("@[chg_amt],--[fnl_frt_rt_amt]," ).append("\n"); 
		query.append("@[por_mtch_flg]," ).append("\n"); 
		query.append("@[del_mtch_flg]," ).append("\n"); 
		query.append("@[tri_prop_no]," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE, " ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}