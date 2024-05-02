/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOAddPriSimChgRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
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

public class PRISimulationDBDAOAddPriSimChgRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * save pri_sim_chg_rt
	  * </pre>
	  */
	public PRISimulationDBDAOAddPriSimChgRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_inlnd_hlg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_inlnd_hlg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_arb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_inlnd_hlg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_arb_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_inlnd_hlg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_arb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_arb_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_incl_xcld_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOAddPriSimChgRtCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SIM_CHG_RT (" ).append("\n"); 
		query.append("   PCTL_NO" ).append("\n"); 
		query.append("  ,CNTR_SZ_CD" ).append("\n"); 
		query.append("  ,CMDT_CD" ).append("\n"); 
		query.append("  ,CMDT_SEQ" ).append("\n"); 
		query.append("  ,RT_SEQ" ).append("\n"); 
		query.append("  ,AUTO_RAT_FLG" ).append("\n"); 
		query.append("  ,FRT_TERM_CD" ).append("\n"); 
		query.append("  ,CGO_CATE_CD" ).append("\n"); 
		query.append("  ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("  ,CHG_CD" ).append("\n"); 
		query.append("  ,CURR_CD" ).append("\n"); 
		query.append("  ,RAT_UT_CD" ).append("\n"); 
		query.append("  ,BKG_QTY" ).append("\n"); 
		query.append("  ,RAT_AS_QTY" ).append("\n"); 
		query.append("  ,CHG_UT_AMT" ).append("\n"); 
		query.append("  ,CHG_AMT" ).append("\n"); 
		query.append("  ,RCV_TERM_CD" ).append("\n"); 
		query.append("  ,DE_TERM_CD" ).append("\n"); 
		query.append("  ,FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("  ,APLY_XCH_RTO" ).append("\n"); 
		query.append("  ,NOTE_RT_SEQ" ).append("\n"); 
		query.append("  ,PROP_NO" ).append("\n"); 
		query.append("  ,AMDT_SEQ" ).append("\n"); 
		query.append("  ,SVC_SCP_CD" ).append("\n"); 
		query.append("  ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("  ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,ORG_INLND_HLG_AMT" ).append("\n"); 
		query.append("  ,ORG_INLND_HLG_CURR_CD" ).append("\n"); 
		query.append("  ,DEST_INLND_HLG_AMT" ).append("\n"); 
		query.append("  ,DEST_INLND_HLG_CURR_CD" ).append("\n"); 
		query.append("  ,ORG_ARB_AMT" ).append("\n"); 
		query.append("  ,ORG_ARB_CURR_CD" ).append("\n"); 
		query.append("  ,DEST_ARB_AMT" ).append("\n"); 
		query.append("  ,DEST_ARB_CURR_CD" ).append("\n"); 
		query.append("  ,SOC_FLG" ).append("\n"); 
		query.append("  ) VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   @[pctl_no]" ).append("\n"); 
		query.append("  ,@[cntr_sz_cd]" ).append("\n"); 
		query.append("  ,@[cmdt_cd]" ).append("\n"); 
		query.append("  ,NVL(@[cmdt_seq],0)" ).append("\n"); 
		query.append("  ,(SELECT NVL(MAX(RT_SEQ),0) + 1 " ).append("\n"); 
		query.append("      FROM PRI_SIM_CHG_RT " ).append("\n"); 
		query.append("     WHERE PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("       AND CNTR_SZ_CD = @[cntr_sz_cd] " ).append("\n"); 
		query.append("       AND CMDT_CD = @[cmdt_cd] " ).append("\n"); 
		query.append("       AND CMDT_SEQ = NVL(@[cmdt_seq],0)" ).append("\n"); 
		query.append("       AND AUTO_RAT_FLG = @[auto_rat_flg]" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("  ,@[auto_rat_flg]" ).append("\n"); 
		query.append("  ,@[frt_term_cd]" ).append("\n"); 
		query.append("  ,@[cgo_cate_cd]" ).append("\n"); 
		query.append("  ,@[imdg_clss_cd]" ).append("\n"); 
		query.append("  ,@[chg_cd]" ).append("\n"); 
		query.append("  ,@[curr_cd]" ).append("\n"); 
		query.append("  ,@[rat_ut_cd]" ).append("\n"); 
		query.append("  ,'1'" ).append("\n"); 
		query.append("  ,@[rat_as_qty]" ).append("\n"); 
		query.append("  ,@[chg_ut_amt]" ).append("\n"); 
		query.append("  ,@[chg_amt]" ).append("\n"); 
		query.append("  ,@[rcv_term_cd]" ).append("\n"); 
		query.append("  ,@[de_term_cd]" ).append("\n"); 
		query.append("  ,@[frt_incl_xcld_div_cd]" ).append("\n"); 
		query.append("  ,(SELECT ROUND(SAR_GET_GL_XCH_RT_FNC('1',(SELECT TO_CHAR(RT_APLY_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("                                              FROM PRI_SIM_RT" ).append("\n"); 
		query.append("                                             WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                                               AND CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("                                               AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("                                               AND CMDT_SEQ = NVL(@[cmdt_seq],0)" ).append("\n"); 
		query.append("                                               AND AUTO_RAT_FLG = @[auto_rat_flg]" ).append("\n"); 
		query.append("                                           ), @[curr_cd],'USD'),6) " ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("  ,@[note_rt_seq]" ).append("\n"); 
		query.append("  ,@[prop_no]" ).append("\n"); 
		query.append("  ,@[amdt_seq]" ).append("\n"); 
		query.append("  ,@[svc_scp_cd]" ).append("\n"); 
		query.append("  ,@[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("  ,@[cmdt_hdr_seq]" ).append("\n"); 
		query.append("  ,@[rout_seq]" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[org_inlnd_hlg_amt]" ).append("\n"); 
		query.append("  ,@[org_inlnd_hlg_curr_cd]" ).append("\n"); 
		query.append("  ,@[dest_inlnd_hlg_amt]" ).append("\n"); 
		query.append("  ,@[dest_inlnd_hlg_curr_cd]" ).append("\n"); 
		query.append("  ,@[org_arb_amt]" ).append("\n"); 
		query.append("  ,@[org_arb_curr_cd]" ).append("\n"); 
		query.append("  ,@[dest_arb_amt]" ).append("\n"); 
		query.append("  ,@[dest_arb_curr_cd]" ).append("\n"); 
		query.append("  ,@[soc_flg]" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}