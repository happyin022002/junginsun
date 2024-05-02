/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TotalLossMgtDBDAOmodifyTotalLossDetailDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOmodifyTotalLossDetailDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss Request 에서 Detail 수정저장
	  * 2014-01-10, yyyymmdd 를 yyyy-mm-dd 로 변경(SQL 오류 수정), 신용찬
	  * </pre>
	  */
	public TotalLossMgtDBDAOmodifyTotalLossDetailDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_bil_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_n3pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_swift_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyer_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpc_val_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_cmpl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_trc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_plc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_cmpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_incm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOmodifyTotalLossDetailDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_TTL_LSS_RQST_DTL A" ).append("\n"); 
		query.append("   SET A.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_DTL_SEQ = @[ttl_lss_dtl_seq]" ).append("\n"); 
		query.append("      ,A.MNR_INV_TP_CD = @[mnr_inv_tp_cd]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_DTL_STS_CD = @[ttl_lss_dtl_sts_cd]" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("      ,A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("      ,A.DPC_VAL_AMT = @[dpc_val_amt]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_N3PTY_TP_CD = @[ttl_lss_n3pty_tp_cd]" ).append("\n"); 
		query.append("      ,A.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("      ,A.MNR_PRNR_SEQ = @[mnr_prnr_seq]" ).append("\n"); 
		query.append("      ,A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("      ,A.VNDR_CUST_SEQ = @[vndr_cust_seq]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_PLC_NM = @[ttl_lss_plc_nm]" ).append("\n"); 
		query.append("      ,A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("      ,A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_BIL_AMT = @[ttl_lss_bil_amt]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_BIL_DT = TO_DATE(@[ttl_lss_bil_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("      ,A.TTL_LSS_EXPN_AMT = @[ttl_lss_expn_amt]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_INCM_AMT = @[ttl_lss_incm_amt]" ).append("\n"); 
		query.append("      ,A.AR_CHK_NO = @[ar_chk_no]" ).append("\n"); 
		query.append("      ,A.N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("      ,A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("      ,A.EQ_OWNR_FLG = @[eq_ownr_flg]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_CFM_FLG = @[ttl_lss_cfm_flg]" ).append("\n"); 
		query.append("      ,A.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("      ,A.IF_TRC_SEQ = @[if_trc_seq]" ).append("\n"); 
		query.append("      ,A.DTL_RMK = @[dtl_rmk]" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,A.BANK_NM = @[bank_nm]" ).append("\n"); 
		query.append("      ,A.BANK_ACCT_NO = @[bank_acct_no]" ).append("\n"); 
		query.append("      ,A.RESPB_OFC_CD = @[respb_ofc_cd]" ).append("\n"); 
		query.append("      ,A.TTL_LSS_YD_CD = @[ttl_lss_yd_cd]" ).append("\n"); 
		query.append("      ,A.MNR_SWIFT_NO = @[mnr_swift_no]" ).append("\n"); 
		query.append("	  ,A.TTL_LSS_CMPL_CD = @[ttl_lss_cmpl_cd]" ).append("\n"); 
		query.append("	  ,A.TTL_LSS_CMPL_DT = TO_DATE(@[ttl_lss_cmpl_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("      ,A.CR_END_DT = TO_DATE(@[cr_end_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("      ,A.USA_EDI_CD = @[usa_edi_cd]" ).append("\n"); 
		query.append("	  ,A.TTL_LSS_BUYR_SEQ = @[buyer_code]" ).append("\n"); 
		query.append("WHERE A.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("AND   A.TTL_LSS_DTL_SEQ = @[ttl_lss_dtl_seq]" ).append("\n"); 

	}
}