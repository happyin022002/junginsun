/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEDIInvoiceParkingLotDTLDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchEDIInvoiceParkingLotDTLDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEDIInvoiceParkingLotDTLData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEDIInvoiceParkingLotDTLDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEDIInvoiceParkingLotDTLDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_RCV_ORD_INV_TMP_DTL_SEQ" ).append("\n"); 
		query.append("	, EQ_KND_CD" ).append("\n"); 
		query.append("	, EQ_NO, RPR_QTY, CURR_CD, INV_AMT, RPR_RSLT_DT" ).append("\n"); 
		query.append("	, YD_CD, COST_CD, VNDR_SEQ, ORD_DTL_RMK" ).append("\n"); 
		query.append("    , CASE WHEN DD IS NOT NULL THEN AA||';'||BB||';'||CC||';'||DD" ).append("\n"); 
		query.append("           WHEN CC IS NOT NULL THEN AA||';'||BB||';'||CC" ).append("\n"); 
		query.append("           WHEN BB IS NOT NULL THEN AA||';'||BB" ).append("\n"); 
		query.append("           WHEN AA IS NOT NULL THEN AA" ).append("\n"); 
		query.append("      END VRFY_RSLT_DESC" ).append("\n"); 
		query.append("    , RQST_REF_NO, CRE_DT, INV_NO, MNR_RCV_ORD_INV_TMP_SEQ, UPD_USR_ID, UPD_DT, '' AS CELL_VALUE, '' AS CRE_FR_DT, '' AS CRE_TO_DT, '' AS RQST_EQ_NO" ).append("\n"); 
		query.append("    ,(SELECT B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR B" ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("    ,COST_CD||COST_DTL_CD AS COST_CD_ALL" ).append("\n"); 
		query.append("FROM (SELECT d.MNR_RCV_ORD_INV_TMP_DTL_SEQ" ).append("\n"); 
		query.append("		, d.EQ_KND_CD" ).append("\n"); 
		query.append("		, d.EQ_NO, d.RPR_QTY, d.CURR_CD, d.INV_AMT, TO_CHAR(d.RPR_RSLT_DT,'YYYY-MM-DD') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("		, d.YD_CD, d.COST_CD, d.VNDR_SEQ, d.ORD_DTL_RMK" ).append("\n"); 
		query.append("    	, (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(d.VRFY_RSLT_DESC, 1, 2))  AA" ).append("\n"); 
		query.append("    	, (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(d.VRFY_RSLT_DESC, 4, 2))  BB" ).append("\n"); 
		query.append("    	, (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(d.VRFY_RSLT_DESC, 7, 2))  CC" ).append("\n"); 
		query.append("    	, (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(d.VRFY_RSLT_DESC, 10, 2)) DD" ).append("\n"); 
		query.append("    	, d.RQST_REF_NO, d.CRE_DT, h.INV_NO, h.MNR_RCV_ORD_INV_TMP_SEQ, d.UPD_USR_ID, d.UPD_DT, '' AS CELL_VALUE, '' AS CRE_FR_DT, '' AS CRE_TO_DT, '' AS RQST_EQ_NO, D.COST_DTL_CD" ).append("\n"); 
		query.append("		FROM MNR_ORD_TMP_HDR h, MNR_ORD_TMP_DTL d " ).append("\n"); 
		query.append("		WHERE h.MNR_RCV_ORD_INV_TMP_SEQ = d.MNR_RCV_ORD_INV_TMP_SEQ" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${mnr_rcv_ord_inv_tmp_seq} != '')" ).append("\n"); 
		query.append("	AND MNR_RCV_ORD_INV_TMP_SEQ = @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MNR_RCV_ORD_INV_TMP_DTL_SEQ" ).append("\n"); 

	}
}