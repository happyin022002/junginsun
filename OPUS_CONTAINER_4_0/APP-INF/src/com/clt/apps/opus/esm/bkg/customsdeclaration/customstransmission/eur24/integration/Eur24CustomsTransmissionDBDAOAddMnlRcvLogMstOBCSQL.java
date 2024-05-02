/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOAddMnlRcvLogMstOBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.21 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOAddMnlRcvLogMstOBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXS B/L Inquiry 화면에서 Status 가 Hold(Doc) / Hold(Phys) 인 경우, 그 값을 Hold Release 로 변경 저장
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOAddMnlRcvLogMstOBCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ack_rcv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOAddMnlRcvLogMstOBCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BND_TP_CD,          EDI_RCV_DT,     EDI_RCV_SEQ" ).append("\n"); 
		query.append("  , EUR_EDI_MSG_TP_ID,  MSG_RCV_NO" ).append("\n"); 
		query.append("  , ACK_KND_ID,         ACK_RCV_STS_CD, EUR_CSTMS_ACK_CD" ).append("\n"); 
		query.append("  , MVMT_REF_NO,        RCV_TMS" ).append("\n"); 
		query.append("  , CRE_USR_ID,         CRE_DT,         UPD_USR_ID,      UPD_DT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'O',  @[edi_rcv_dt],	@[edi_rcv_seq]" ).append("\n"); 
		query.append("     , eur_edi_msg_tp_id,	msg_rcv_no" ).append("\n"); 
		query.append("     , ack_knd_id,          @[ack_rcv_sts_cd],	eur_cstms_ack_cd" ).append("\n"); 
		query.append("     , mvmt_ref_no,			CURRENT_TIMESTAMP" ).append("\n"); 
		query.append("     , @[cre_usr_id],       SYSDATE,	@[upd_usr_id],		SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("WHERE MSG_RCV_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("AND RCV_TMS =( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                WHERE MSG_RCV_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("                  AND BND_TP_CD = 'O' " ).append("\n"); 
		query.append("                  AND EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("                  AND EDI_RCV_SEQ > 0" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("AND BND_TP_CD = 'O' " ).append("\n"); 
		query.append("AND EDI_RCV_DT > ' '" ).append("\n"); 
		query.append("AND EDI_RCV_SEQ > 0" ).append("\n"); 

	}
}