/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TotalLossMgtDBDAOaddTotalLossDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2010.02.09 권영법
* 1.0 Creation
* -------------------------------------------------------- 
* 2012.04.24 신혜정 [CHM-201217356] 3rd Party 리스트내 SCAC Code 항목 추가
*                                   [Confirm]시 Sub Reason 이 Trucker 일 경우 필수 항목 체크 
* 2012.05.02 신혜정 [CHM-201217379] 3rd Party 리스트내 buyer Code, buyer name 항목 추가  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOaddTotalLossDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss Request 의 Detail  입력저장
	  * </pre>
	  */
	public TotalLossMgtDBDAOaddTotalLossDetailDataCSQL(){
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
		params.put("temp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dpc_val_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TotalLossMgtDBDAOaddTotalLossDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  TTL_LSS_NO" ).append("\n"); 
		query.append(" ,TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append(" ,MNR_INV_TP_CD" ).append("\n"); 
		query.append(" ,TTL_LSS_DTL_STS_CD" ).append("\n"); 
		query.append(" ,EQ_KND_CD" ).append("\n"); 
		query.append(" ,RQST_EQ_NO" ).append("\n"); 
		query.append(" ,EQ_TPSZ_CD" ).append("\n"); 
		query.append(" ,DPC_VAL_AMT" ).append("\n"); 
		query.append(" ,TTL_LSS_N3PTY_TP_CD" ).append("\n"); 
		query.append(" ,MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(" ,MNR_PRNR_SEQ" ).append("\n"); 
		query.append(" ,CNT_CD" ).append("\n"); 
		query.append(" ,VNDR_CUST_SEQ" ).append("\n"); 
		query.append(" ,TTL_LSS_PLC_NM" ).append("\n"); 
		query.append(" ,INV_NO" ).append("\n"); 
		query.append(" ,CURR_CD" ).append("\n"); 
		query.append(" ,TTL_LSS_BIL_AMT" ).append("\n"); 
		query.append(" ,TTL_LSS_BIL_DT" ).append("\n"); 
		query.append(" ,TTL_LSS_EXPN_AMT" ).append("\n"); 
		query.append(" ,TTL_LSS_INCM_AMT" ).append("\n"); 
		query.append(" ,AR_CHK_NO" ).append("\n"); 
		query.append(" ,N3PTY_NO" ).append("\n"); 
		query.append(" ,CSR_NO" ).append("\n"); 
		query.append(" ,EQ_OWNR_FLG" ).append("\n"); 
		query.append(" ,TTL_LSS_CFM_FLG" ).append("\n"); 
		query.append(" ,PAY_INV_SEQ" ).append("\n"); 
		query.append(" ,IF_TRC_SEQ" ).append("\n"); 
		query.append(" ,DTL_RMK" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,BANK_NM" ).append("\n"); 
		query.append(" ,BANK_ACCT_NO" ).append("\n"); 
		query.append(" ,RESPB_OFC_CD" ).append("\n"); 
		query.append(" ,TTL_LSS_YD_CD" ).append("\n"); 
		query.append(" ,MNR_SWIFT_NO" ).append("\n"); 
		query.append(" ,CR_END_DT" ).append("\n"); 
		query.append(" ,USA_EDI_CD" ).append("\n"); 
		query.append(" ,TTL_LSS_BUYR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  @[ttl_lss_no]" ).append("\n"); 
		query.append(" ,(SELECT NVL(MAX(TTL_LSS_DTL_SEQ),0)+ @[temp_seq]" ).append("\n"); 
		query.append("   FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("   WHERE TTL_LSS_NO=@[ttl_lss_no]" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" ,@[mnr_inv_tp_cd]" ).append("\n"); 
		query.append(" ,@[ttl_lss_dtl_sts_cd]" ).append("\n"); 
		query.append(" ,@[eq_knd_cd]" ).append("\n"); 
		query.append(" ,@[rqst_eq_no]" ).append("\n"); 
		query.append(" ,@[eq_tpsz_cd]" ).append("\n"); 
		query.append(" ,@[dpc_val_amt]" ).append("\n"); 
		query.append(" ,@[ttl_lss_n3pty_tp_cd]" ).append("\n"); 
		query.append(" ,@[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append(" ,@[mnr_prnr_seq]" ).append("\n"); 
		query.append(" ,@[cnt_cd]" ).append("\n"); 
		query.append(" ,@[vndr_cust_seq]" ).append("\n"); 
		query.append(" ,@[ttl_lss_plc_nm]" ).append("\n"); 
		query.append(" ,@[inv_no]" ).append("\n"); 
		query.append(" ,@[curr_cd]" ).append("\n"); 
		query.append(" ,@[ttl_lss_bil_amt]" ).append("\n"); 
		query.append(" ,TO_DATE(@[ttl_lss_bil_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(" ,@[ttl_lss_expn_amt]" ).append("\n"); 
		query.append(" ,@[ttl_lss_incm_amt]" ).append("\n"); 
		query.append(" ,@[ar_chk_no]" ).append("\n"); 
		query.append(" ,@[n3pty_no]" ).append("\n"); 
		query.append(" ,@[csr_no]" ).append("\n"); 
		query.append(" ,@[eq_ownr_flg]" ).append("\n"); 
		query.append(" ,@[ttl_lss_cfm_flg]" ).append("\n"); 
		query.append(" ,@[pay_inv_seq]" ).append("\n"); 
		query.append(" ,@[if_trc_seq]" ).append("\n"); 
		query.append(" ,@[dtl_rmk]" ).append("\n"); 
		query.append(" ,@[cre_usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[upd_usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[bank_nm]" ).append("\n"); 
		query.append(" ,@[bank_acct_no]" ).append("\n"); 
		query.append(" ,@[respb_ofc_cd]" ).append("\n"); 
		query.append(" ,@[ttl_lss_yd_cd]" ).append("\n"); 
		query.append(" ,@[mnr_swift_no]" ).append("\n"); 
		query.append(" ,TO_DATE(@[cr_end_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(" ,@[usa_edi_cd]" ).append("\n"); 
		query.append(" ,@[buyer_code]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}