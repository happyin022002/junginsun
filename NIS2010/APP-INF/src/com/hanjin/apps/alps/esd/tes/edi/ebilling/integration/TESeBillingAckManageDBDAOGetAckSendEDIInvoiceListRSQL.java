/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TESeBillingAckManageDBDAOGetAckSendEDIInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingAckManageDBDAOGetAckSendEDIInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACK대상의 EDI INVOICE목록 가져오기
	  * </pre>
	  */
	public TESeBillingAckManageDBDAOGetAckSendEDIInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lmt_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack_act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingAckManageDBDAOGetAckSendEDIInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("H.VNDR_SEQ, H.INV_OFC_CD, H.TML_EDI_SO_OFC_CTY_CD, H.TML_EDI_SO_SEQ, H.INV_NO, H.TTL_INV_AMT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ >= 0" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD = 'R'" ).append("\n"); 
		query.append("--AND H.TML_SO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("--AND H.TML_SO_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND H.CRE_DT >= CASE" ).append("\n"); 
		query.append("WHEN @[cfm_dt] IS NOT NULL AND LENGTH(TRIM(SUBSTR(REPLACE(@[cfm_dt],'-',''),1,8))) = 8" ).append("\n"); 
		query.append("THEN TO_DATE(SUBSTR(REPLACE(@[cfm_dt],'-',''),1,8),'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE SYSDATE - 2" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM TES_EDI_ACK_SND_LOG L, TES_EDI_ACK_SND_LOG_INV I" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.EDI_SND_DT = I.EDI_SND_DT" ).append("\n"); 
		query.append("AND L.SND_LOG_SEQ = I.SND_LOG_SEQ" ).append("\n"); 
		query.append("--AND L.ACK_SND_STS_CD IN ('N','S')" ).append("\n"); 
		query.append("AND L.ACK_ACT_TP_CD = @[ack_act_tp_cd]" ).append("\n"); 
		query.append("AND I.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND I.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${lmt_knt} != '')" ).append("\n"); 
		query.append("AND ROWNUM <= @[lmt_knt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}