/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchCargoSmartAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchCargoSmartAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchCargoSmartAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("res_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchCargoSmartAckRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'{CNTR_INFO' || CHR(10)" ).append("\n"); 
		query.append("	|| 'CNTR_NO:' || VGM.CNTR_NO  || CHR(10)" ).append("\n"); 
		query.append("#if (${res_tp_cd} == '1') " ).append("\n"); 
		query.append("	||'VGM_C_DATE:' || TO_CHAR(VGM.CRE_DT,'YYYYMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	||'VGM_C_DATE:' || CHR(10)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${res_tp_cd} == '1') " ).append("\n"); 
		query.append("	||'VGM_R_DATE:' || CHR(10)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	||'VGM_R_DATE:' || TO_CHAR(VGM.CRE_DT,'YYYYMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${res_tp_cd} == '1') " ).append("\n"); 
		query.append("	||'RESPONSE:' || CHR(10)" ).append("\n"); 
		query.append("#elseif (${res_tp_cd} == '2') " ).append("\n"); 
		query.append("	||'RESPONSE:invalid booking or container number' || CHR(10)" ).append("\n"); 
		query.append("#elseif (${res_tp_cd} == '3') " ).append("\n"); 
		query.append("	||'RESPONSE:VGM verify date is greater than the edi send date' || CHR(10)" ).append("\n"); 
		query.append("#elseif (${res_tp_cd} == '4') " ).append("\n"); 
		query.append("	||'RESPONSE:VGM is less or equal to container tare weight' || CHR(10)" ).append("\n"); 
		query.append("#elseif (${res_tp_cd} == '5') " ).append("\n"); 
		query.append("	||'RESPONSE:VGM is greater than (Max Payload + Tare weight)' || CHR(10)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	||'CUST_MSG_STS:' || VGM.XTER_MSG_FUNC_CD || CHR(10)" ).append("\n"); 
		query.append("#if (${res_tp_cd} == '1') " ).append("\n"); 
		query.append("	||'RES_TP_CD:' || 'Approve' || CHR(10)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	||'RES_TP_CD:' || 'Reject' || CHR(10)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	||'RES_CD:' || @[res_tp_cd] || CHR(10)" ).append("\n"); 
		query.append("	||'ACK_C_DATE:' || TO_CHAR(VGM.CRE_DT,'YYYYMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("	||(	SELECT LISTAGG(" ).append("\n"); 
		query.append("		'{ACK_REF_INFO' || CHR(10)" ).append("\n"); 
		query.append("	|| 		'REF_TP_CD:' || RF.XTER_REF_TP_CD || CHR(10)" ).append("\n"); 
		query.append("	|| 		'REF_NO:'    || RF.REF_NO || CHR(10)" ).append("\n"); 
		query.append("	|| 	'}ACK_REF_INFO' || CHR(10), '') WITHIN GROUP (ORDER BY RF.XTER_REF_SEQ)" ).append("\n"); 
		query.append("		FROM BKG_XTER_VGM_REF_NO RF" ).append("\n"); 
		query.append("		WHERE RF.XTER_SNDR_ID = VGM.XTER_SNDR_ID " ).append("\n"); 
		query.append("		AND RF.XTER_VGM_DOC_ID = VGM.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("		AND RF.XTER_VGM_RQST_SEQ = VGM.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	||(	SELECT LISTAGG (" ).append("\n"); 
		query.append("		'{ACK_CUST_INFO' || CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_TP:'       ||  CUST.VGM_CUST_TP_CD || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_NM:'       ||  REPLACE(CUST.VGM_CUST_NM, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_ADDR:'     ||  REPLACE(CUST.VGM_CUST_ADDR, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_CTY_NM:'   ||  REPLACE(CUST.VGM_CUST_CTY_NM, CHR(10), ' ') || CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_STE:'      ||  CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_PST_CD:'   ||  CUST.VGM_PST_CD_CTNT || CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_CNT_CD:'   ||  CUST.VGM_CUST_CNT_CD || CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_CNTC_TP:'  ||  CUST.VGM_CUST_CNTC_TP_CD || CHR(10)" ).append("\n"); 
		query.append("	|| 		'CUST_CNTC_NM:'  ||  REPLACE(CUST.VGM_CUST_CNTC_NM, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_FAX:'      ||  REPLACE(CUST.VGM_CUST_FAX_NO, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_EML:'      ||  REPLACE(CUST.VGM_CUST_EML, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_PHN:'      ||  REPLACE(CUST.VGM_CUST_PHN_NO, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| 		'CUST_ML_ADDR:'  ||  REPLACE(CUST.VGM_CUST_PST_ADDR, CHR(10), ' ') || CHR(10)  " ).append("\n"); 
		query.append("	|| '}ACK_CUST_INFO' || CHR(10), '') WITHIN GROUP (ORDER BY CUST.XTER_REF_SEQ)" ).append("\n"); 
		query.append("  	|| '}CNTR_INFO' || CHR(10)  " ).append("\n"); 
		query.append("		FROM BKG_XTER_VGM_CUST CUST" ).append("\n"); 
		query.append("		WHERE CUST.XTER_SNDR_ID = VGM.XTER_SNDR_ID " ).append("\n"); 
		query.append("		AND CUST.XTER_VGM_DOC_ID = VGM.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("		AND CUST.XTER_VGM_RQST_SEQ = VGM.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		) AS FLAT_FILE" ).append("\n"); 
		query.append("FROM BKG_XTER_VGM_RQST VGM" ).append("\n"); 
		query.append("WHERE VGM.EDI_MSG_PROC_ID = @[edi_no]" ).append("\n"); 
		query.append("AND VGM.XTER_VGM_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}