/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOaddAckKntCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier :
*@LastVersion : 1.0
* 2011.11.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOaddAckKntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 수신데이타 저장 (수신 마스터 테이블)
	  * </pre>
	  */
	public PSASpecialManifestDBDAOaddAckKntCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_scs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tnk_cntr_tpsz_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hndl_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_vsl_name",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_ref_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_ref_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pck_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_err_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n");
		query.append("FileName : PSASpecialManifestDBDAOaddAckKntCSQL").append("\n");
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
		query.append("MERGE INTO BKG_CSTMS_PSA_DG_RCV_ERR" ).append("\n");
		query.append("USING DUAL" ).append("\n");
		query.append("ON (MSG_RCV_NO = @[msg_rcv_no])" ).append("\n");
		query.append("WHEN MATCHED THEN" ).append("\n");
		query.append("UPDATE SET" ).append("\n");
		query.append("CNTR_TTL_KNT = @[cntr_ttl_knt]" ).append("\n");
		query.append(",CNTR_TTL_ERR_KNT = @[cntr_ttl_err_knt]" ).append("\n");
		query.append(",CNTR_TTL_SCS_KNT = @[cntr_ttl_scs_knt]" ).append("\n");
		query.append("WHERE MSG_RCV_NO = @[msg_rcv_no]" ).append("\n");
		query.append("WHEN NOT MATCHED THEN" ).append("\n");
		query.append("INSERT" ).append("\n");
		query.append("(   PSA_EDI_MSG_TP_ID" ).append("\n");
		query.append("    ,MSG_RCV_NO" ).append("\n");
		query.append("    ,RCV_LOG_SEQ" ).append("\n");
		query.append("    ,RCV_LOG_ERR_SEQ" ).append("\n");
		query.append("    ,CSTMS_ERR_ID" ).append("\n");
		query.append("    ,CSTMS_ERR_MSG" ).append("\n");
		query.append("    ,CSTMS_ERR_REF_NO1" ).append("\n");
		query.append("    ,CSTMS_ERR_REF_NO2" ).append("\n");
		query.append("    ,CRE_USR_ID" ).append("\n");
		query.append("    ,CRE_DT" ).append("\n");
		query.append("    ,UPD_USR_ID" ).append("\n");
		query.append("    ,UPD_DT" ).append("\n");
		query.append("    ,PSA_VSL_NM" ).append("\n");
		query.append("    ,IB_VVD_CD" ).append("\n");
		query.append("    ,OB_VVD_CD" ).append("\n");
		query.append("    ,CNTR_NO" ).append("\n");
		query.append("    ,CNTR_HNDL_KND_CD" ).append("\n");
		query.append("    ,ERR_CNTR_STS_CD" ).append("\n");
		query.append("    ,TNK_CNTR_TPSZ_FLG" ).append("\n");
		query.append("    ,TTL_PCK_QTY" ).append("\n");
		query.append("    ,TTL_PCK_TP_NM" ).append("\n");
		query.append("    ,DG_TTL_WGT" ).append("\n");
		query.append("    ,IMO_NO" ).append("\n");
		query.append("    ,IMDG_UN_NO" ).append("\n");
		query.append("    ,CNTR_TTL_KNT" ).append("\n");
		query.append("    ,CNTR_TTL_ERR_KNT" ).append("\n");
		query.append("    ,CNTR_TTL_SCS_KNT" ).append("\n");
		query.append("	,FLSH_PNT_TEMP_CTNT" ).append("\n");
		query.append(") VALUES (" ).append("\n");
		query.append("     @[psa_edi_msg_tp_id]" ).append("\n");
		query.append("    ,@[msg_rcv_no]" ).append("\n");
		query.append("    ,@[rcv_log_seq]" ).append("\n");
		query.append("	,(" ).append("\n");
		query.append("        SELECT NVL(MAX(RCV_LOG_ERR_SEQ), 0) + 1" ).append("\n");
		query.append("        FROM BKG_CSTMS_PSA_DG_RCV_ERR" ).append("\n");
		query.append("        WHERE PSA_EDI_MSG_TP_ID = @[psa_edi_msg_tp_id]" ).append("\n");
		query.append("        AND   MSG_RCV_NO        = @[msg_rcv_no]" ).append("\n");
		query.append("        AND   RCV_LOG_SEQ       = @[rcv_log_seq]" ).append("\n");
		query.append("    )" ).append("\n");
		query.append("    ,@[cstms_err_id]" ).append("\n");
		query.append("    ,@[cstms_err_msg]" ).append("\n");
		query.append("    ,@[cstms_err_ref_no1]" ).append("\n");
		query.append("    ,@[cstms_err_ref_no2]" ).append("\n");
		query.append("    ,@[cre_usr_id]" ).append("\n");
		query.append("    ,SYSDATE" ).append("\n");
		query.append("    ,@[upd_usr_id]" ).append("\n");
		query.append("    ,SYSDATE" ).append("\n");
		query.append("    ,@[psa_vsl_name]" ).append("\n");
		query.append("    ,@[ib_vvd_cd]" ).append("\n");
		query.append("    ,@[ob_vvd_cd]" ).append("\n");
		query.append("    ,@[cntr_no]" ).append("\n");
		query.append("    ,@[cntr_hndl_knd_cd]" ).append("\n");
		query.append("    ,@[err_cntr_sts_cd]" ).append("\n");
		query.append("    ,@[tnk_cntr_tpsz_flg]" ).append("\n");
		query.append("    ,@[ttl_pck_qty]" ).append("\n");
		query.append("    ,@[ttl_pck_tp_nm]" ).append("\n");
		query.append("    ,@[dg_ttl_wgt]" ).append("\n");
		query.append("    ,@[imo_no]" ).append("\n");
		query.append("    ,@[imdg_un_no]" ).append("\n");
		query.append("    ,@[cntr_ttl_knt]" ).append("\n");
		query.append("    ,@[cntr_ttl_err_knt]" ).append("\n");
		query.append("    ,@[cntr_ttl_scs_knt]" ).append("\n");
		query.append("	,@[flsh_pnt_temp_ctnt]" ).append("\n");
		query.append(")" ).append("\n");

	}
}