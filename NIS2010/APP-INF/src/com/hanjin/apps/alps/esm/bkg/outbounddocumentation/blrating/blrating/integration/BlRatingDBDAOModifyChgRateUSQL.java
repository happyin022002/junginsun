/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOModifyChgRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyChgRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CHG_RT Data에 해당하는 정보를 수정한다
	  * </pre>
	  */
	public BlRatingDBDAOModifyChgRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("n3pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incl_oft_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_rat_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_itm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyChgRateUSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_CHG_RT_HIS " ).append("\n"); 
		query.append("SET    " ).append("\n"); 
		query.append("	CHG_CD            = @[chg_cd]," ).append("\n"); 
		query.append("    DP_SEQ = (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N')," ).append("\n"); 
		query.append("	TRF_ITM_NO        = @[trf_itm_no]," ).append("\n"); 
		query.append("	CURR_CD           = @[curr_cd]," ).append("\n"); 
		query.append("	CHG_UT_AMT        = @[chg_ut_amt]," ).append("\n"); 
		query.append("	RAT_AS_QTY        = @[rat_as_qty]," ).append("\n"); 
		query.append("	RAT_UT_CD         = @[rat_ut_cd]," ).append("\n"); 
		query.append("	CHG_AMT           = @[chg_amt]," ).append("\n"); 
		query.append("	FRT_INCL_XCLD_DIV_CD = @[incl_oft_flg]," ).append("\n"); 
		query.append("	FRT_TERM_CD       = @[frt_term_cd]," ).append("\n"); 
		query.append("	N3PTY_RCV_OFC_CD  = @[n3pty_rcv_ofc_cd]," ).append("\n"); 
		query.append("	N3PTY_CUST_CNT_CD = @[n3pty_cust_cnt_cd]," ).append("\n"); 
		query.append("	N3PTY_CUST_SEQ    = @[n3pty_cust_seq]," ).append("\n"); 
		query.append("	CGO_CATE_CD       = @[cgo_cate_cd]," ).append("\n"); 
		query.append("	SOC_FLG           = @[soc_flg]," ).append("\n"); 
		query.append("	RCV_TERM_CD       = @[rcv_term_cd]," ).append("\n"); 
		query.append("	DE_TERM_CD        = @[de_term_cd]," ).append("\n"); 
		query.append("	IMDG_CLSS_CD      = @[imdg_clss_cd]," ).append("\n"); 
		query.append("	AUTO_RAT_CD       = @[auto_rat_cd]," ).append("\n"); 
		query.append("	#if (${prn_hdn_flg} == '1') " ).append("\n"); 
		query.append("	PRN_HDN_FLG       = 'Y'," ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	PRN_HDN_FLG       = 'N'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	NOTE_RT_SEQ		= @[note_rt_seq]," ).append("\n"); 
		query.append("	PROP_NO			= @[prop_no]," ).append("\n"); 
		query.append("	AMDT_SEQ		= @[amdt_seq]," ).append("\n"); 
		query.append("	SVC_SCP_CD			= @[svc_scp_cd]," ).append("\n"); 
		query.append("	GEN_SPCL_RT_TP_CD	= @[gen_spcl_rt_tp_cd]," ).append("\n"); 
		query.append("	CMDT_HDR_SEQ		= @[cmdt_hdr_seq]," ).append("\n"); 
		query.append("	ROUT_SEQ		= @[rout_seq]," ).append("\n"); 
		query.append("	FX_RT_FLG		= @[fx_rt_flg]," ).append("\n"); 
		query.append("	UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT            = sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("	AND    RT_SEQ     = @[rt_seq]" ).append("\n"); 
		query.append("	AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_CHG_RT " ).append("\n"); 
		query.append("SET    " ).append("\n"); 
		query.append("	CHG_CD            = @[chg_cd]," ).append("\n"); 
		query.append("    DP_SEQ = (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N')," ).append("\n"); 
		query.append("	TRF_ITM_NO        = @[trf_itm_no]," ).append("\n"); 
		query.append("	CURR_CD           = @[curr_cd]," ).append("\n"); 
		query.append("	CHG_UT_AMT        = @[chg_ut_amt]," ).append("\n"); 
		query.append("	RAT_AS_QTY        = @[rat_as_qty]," ).append("\n"); 
		query.append("	RAT_UT_CD         = @[rat_ut_cd]," ).append("\n"); 
		query.append("	CHG_AMT           = @[chg_amt]," ).append("\n"); 
		query.append("	FRT_INCL_XCLD_DIV_CD      = @[incl_oft_flg]," ).append("\n"); 
		query.append("	FRT_TERM_CD       = @[frt_term_cd]," ).append("\n"); 
		query.append("	N3PTY_RCV_OFC_CD  = @[n3pty_rcv_ofc_cd]," ).append("\n"); 
		query.append("	N3PTY_CUST_CNT_CD = @[n3pty_cust_cnt_cd]," ).append("\n"); 
		query.append("	N3PTY_CUST_SEQ    = @[n3pty_cust_seq]," ).append("\n"); 
		query.append("	CGO_CATE_CD       = @[cgo_cate_cd]," ).append("\n"); 
		query.append("	SOC_FLG           = @[soc_flg]," ).append("\n"); 
		query.append("	RCV_TERM_CD       = @[rcv_term_cd]," ).append("\n"); 
		query.append("	DE_TERM_CD        = @[de_term_cd]," ).append("\n"); 
		query.append("	IMDG_CLSS_CD      = @[imdg_clss_cd]," ).append("\n"); 
		query.append("	AUTO_RAT_CD       = @[auto_rat_cd]," ).append("\n"); 
		query.append("	#if (${prn_hdn_flg} == '1') " ).append("\n"); 
		query.append("	PRN_HDN_FLG       = 'Y'," ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	PRN_HDN_FLG       = 'N'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	NOTE_RT_SEQ		= @[note_rt_seq]," ).append("\n"); 
		query.append("	PROP_NO			= @[prop_no]," ).append("\n"); 
		query.append("	AMDT_SEQ		= @[amdt_seq]," ).append("\n"); 
		query.append("	SVC_SCP_CD		= @[svc_scp_cd]," ).append("\n"); 
		query.append("	GEN_SPCL_RT_TP_CD	= @[gen_spcl_rt_tp_cd]," ).append("\n"); 
		query.append("	CMDT_HDR_SEQ		= @[cmdt_hdr_seq]," ).append("\n"); 
		query.append("	ROUT_SEQ		= @[rout_seq]," ).append("\n"); 
		query.append("	FX_RT_FLG		= @[fx_rt_flg]," ).append("\n"); 
		query.append("	UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT            = sysdate" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("	AND    RT_SEQ     = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}