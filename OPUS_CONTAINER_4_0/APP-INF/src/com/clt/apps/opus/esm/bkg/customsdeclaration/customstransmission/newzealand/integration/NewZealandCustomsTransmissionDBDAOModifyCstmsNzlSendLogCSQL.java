/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOModifyCstmsNzlSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOModifyCstmsNzlSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOModifyCstmsNzlSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_rqst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_key_dat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_rcv_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOModifyCstmsNzlSendLogCSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("   SET EDI_RCV_MSG_CTNT = @[edi_rcv_msg_ctnt] ," ).append("\n"); 
		query.append("       CSTMS_RQST_FLG = @[cstms_rqst_flg] ," ).append("\n"); 
		query.append("#if (${bl_no}!= '')" ).append("\n"); 
		query.append("       MSG_RGST_ID = 'B/L' ," ).append("\n"); 
		query.append("       RCV_KEY_DAT_CTNT = @[rcv_key_dat_ctnt] ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       LOG_FLG = 'Y'," ).append("\n"); 
		query.append("       MRN_NO = @[mrn_no]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE EDI_REF_ID = @[edi_ref_id]" ).append("\n"); 
		query.append("#if (${bl_no}!= '')" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}