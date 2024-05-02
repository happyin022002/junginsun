/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOAutoRatingHistoryUSQL.java
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

public class BlRatingDBDAOAutoRatingHistoryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AutoRatingHistory
	  * </pre>
	  */
	public BlRatingDBDAOAutoRatingHistoryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_xch_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_itm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAutoRatingHistoryUSQL").append("\n"); 
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
		query.append("#if (${sql_type} == 'count') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 	COUNT(BKG_NO) FROM BKG_AUTO_RT_HIS WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'delete') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DELETE  FROM BKG_AUTO_RT_HIS WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'insert') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT INTO BKG_AUTO_RT_HIS (" ).append("\n"); 
		query.append("	   BKG_NO, RT_SEQ, BL_RT_SEQ, DP_SEQ, " ).append("\n"); 
		query.append("	   FRT_TERM_CD, TRF_ITM_NO, CGO_CATE_CD, " ).append("\n"); 
		query.append("	   IMDG_CLSS_CD, CHG_CD, CURR_CD, " ).append("\n"); 
		query.append("	   RAT_UT_CD, BKG_QTY, RAT_AS_QTY, " ).append("\n"); 
		query.append("	   CHG_UT_AMT, CHG_AMT, RCV_TERM_CD, " ).append("\n"); 
		query.append("	   DE_TERM_CD, N3PTY_RCV_OFC_CD, N3PTY_CUST_CNT_CD, " ).append("\n"); 
		query.append("	   N3PTY_CUST_SEQ, FRT_INCL_XCLD_DIV_CD, INV_STS_CD, " ).append("\n"); 
		query.append("	   PRN_HDN_FLG, AUTO_RAT_CD, APLY_XCH_RTO, " ).append("\n"); 
		query.append("	   AGMT_RAT_UT_CD, SOC_FLG, " ).append("\n"); 
		query.append("	   NOTE_RT_SEQ,PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("	   CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("	   UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("	VALUES (" ).append("\n"); 
		query.append("	   @[bkg_no], " ).append("\n"); 
		query.append("	   (SELECT  NVL(MAX(RT_SEQ),0)+1 AS SEQ FROM BKG_AUTO_RT_HIS WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   ),1, (SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD=@[chg_cd] AND DELT_FLG='N'), " ).append("\n"); 
		query.append("	   @[frt_term_cd], @[trf_itm_no], @[cgo_cate_cd], " ).append("\n"); 
		query.append("	   @[imdg_clss_cd], @[chg_cd], @[curr_cd], " ).append("\n"); 
		query.append("	   @[rat_ut_cd], @[bkg_qty], @[rat_as_qty], " ).append("\n"); 
		query.append("	   @[chg_ut_amt], @[chg_amt], @[rcv_term_cd], " ).append("\n"); 
		query.append("	   @[de_term_cd], @[n3pty_rcv_ofc_cd], @[n3pty_cust_cnt_cd], " ).append("\n"); 
		query.append("	   @[n3pty_cust_seq], @[incl_oft_flg], @[inv_sts_cd], " ).append("\n"); 
		query.append("       DECODE(@[prn_hdn_flg],'1','Y','N')," ).append("\n"); 
		query.append("       @[auto_rat_cd], @[aply_xch_rto], " ).append("\n"); 
		query.append("	   @[agmt_rat_ut_cd], @[soc_flg]," ).append("\n"); 
		query.append("	   @[note_rt_seq], @[prop_no], @[amdt_seq], @[svc_scp_cd], @[gen_spcl_rt_tp_cd]," ).append("\n"); 
		query.append("	   @[upd_usr_id], sysdate, " ).append("\n"); 
		query.append("	   @[upd_usr_id], sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}