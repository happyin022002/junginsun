/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * SCG_PRNR_SPCL_CGO_TRSM_ACK
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_rjct_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_acpt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_upd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_locl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_rcvr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_ack_gdt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL").append("\n"); 
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
		query.append("INSERT INTO" ).append("\n"); 
		query.append("       SCG_PRNR_SPCL_CGO_TRSM_ACK" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  TRSM_BND_CD" ).append("\n"); 
		query.append("    , TRSM_DT" ).append("\n"); 
		query.append("    , SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("    , PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("    , ACK_SUB_SEQ" ).append("\n"); 
		query.append("    , EDI_MSG_ID" ).append("\n"); 
		query.append("    , EDI_SNDR_ID" ).append("\n"); 
		query.append("    , EDI_RCVR_ID" ).append("\n"); 
		query.append("    , EDI_IF_ID" ).append("\n"); 
		query.append("    , TRSM_STS_CD" ).append("\n"); 
		query.append("    , EDI_HDR_MSG" ).append("\n"); 
		query.append("    , ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("    , ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("    , ORG_MSG_TP_CD" ).append("\n"); 
		query.append("    , MSG_UPD_FLG" ).append("\n"); 
		query.append("    , ORG_MSG_NM" ).append("\n"); 
		query.append("    , MSG_ACK_TP_CD" ).append("\n"); 
		query.append("    , MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("    , MSG_ACK_LOCL_DT" ).append("\n"); 
		query.append("    , MSG_ACK_GDT" ).append("\n"); 
		query.append("    , ERR_DTL_CD" ).append("\n"); 
		query.append("    , MSG_RJCT_CD" ).append("\n"); 
		query.append("    , MSG_RJCT_RSN" ).append("\n"); 
		query.append("    , MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  SELECT @[trsm_bnd_cd]" ).append("\n"); 
		query.append("       , TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("       , @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("       , @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("       , (SELECT NVL(MAX(ACK_SUB_SEQ),0) + 1 " ).append("\n"); 
		query.append("            FROM SCG_PRNR_SPCL_CGO_TRSM_ACK" ).append("\n"); 
		query.append("           WHERE TRSM_BND_CD       = @[trsm_bnd_cd]" ).append("\n"); 
		query.append("             AND TRSM_DT           = TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("             AND SPCL_CGO_CATE_CD  = @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("             AND PRNR_SPCL_CGO_SEQ = @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       , @[edi_msg_id]" ).append("\n"); 
		query.append("       , @[edi_sndr_id]" ).append("\n"); 
		query.append("       , @[edi_rcvr_id]" ).append("\n"); 
		query.append("       , @[edi_if_id]" ).append("\n"); 
		query.append("       , @[trsm_sts_cd]" ).append("\n"); 
		query.append("       , @[edi_hdr_msg]" ).append("\n"); 
		query.append("       , @[org_msg_rcvr_nm]" ).append("\n"); 
		query.append("       , @[org_msg_key_no]" ).append("\n"); 
		query.append("       , @[org_msg_tp_cd]" ).append("\n"); 
		query.append("       , @[msg_upd_flg]" ).append("\n"); 
		query.append("       , @[org_msg_nm]" ).append("\n"); 
		query.append("       , @[msg_ack_tp_cd]" ).append("\n"); 
		query.append("       , @[msg_ack_rslt_cd]       " ).append("\n"); 
		query.append("       #if(${msg_ack_locl_dt} != '') " ).append("\n"); 
		query.append("       , TO_DATE(@[msg_ack_locl_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       , null" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${msg_ack_gdt} != '') " ).append("\n"); 
		query.append("       , TO_DATE(@[msg_ack_gdt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       , null" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       , @[err_dtl_cd]" ).append("\n"); 
		query.append("       , @[msg_rjct_cd]" ).append("\n"); 
		query.append("       , @[msg_rjct_rsn]" ).append("\n"); 
		query.append("       , @[msg_acpt_ref_no]" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[upd_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}