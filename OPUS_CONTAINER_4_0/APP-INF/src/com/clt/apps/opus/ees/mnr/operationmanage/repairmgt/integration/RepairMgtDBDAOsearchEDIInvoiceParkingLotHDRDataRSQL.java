/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEDIInvoiceParkingLotHDRDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
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

public class RepairMgtDBDAOsearchEDIInvoiceParkingLotHDRDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEDIInvoiceParkingLotHDRData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEDIInvoiceParkingLotHDRDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEDIInvoiceParkingLotHDRDataRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD, VNDR_SEQ, INV_AMT, VAT_AMT, INV_WHLD_TAX_AMT, INV_NO" ).append("\n"); 
		query.append("	, RCV_DT, INV_CFM_DT, COST_OFC_CD, ORD_HDR_RMK" ).append("\n"); 
		query.append("    , CASE WHEN DD IS NOT NULL THEN AA||';'||BB||';'||CC||';'||DD" ).append("\n"); 
		query.append("                     WHEN CC IS NOT NULL THEN AA||';'||BB||';'||CC" ).append("\n"); 
		query.append("                     WHEN BB IS NOT NULL THEN AA||';'||BB" ).append("\n"); 
		query.append("                     WHEN AA IS NOT NULL THEN AA" ).append("\n"); 
		query.append("      END VRFY_RSLT_DESC" ).append("\n"); 
		query.append("	, CRE_DT, UPD_USR_ID, UPD_DT, '' AS CRE_FR_DT, '' AS CRE_TO_DT, MNR_RCV_ORD_INV_TMP_SEQ, '' AS RQST_EQ_NO" ).append("\n"); 
		query.append("    ,(SELECT B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR B" ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("FROM (SELECT CURR_CD, VNDR_SEQ, INV_AMT, VAT_AMT, INV_WHLD_TAX_AMT, INV_NO" ).append("\n"); 
		query.append("	       , TO_CHAR(RCV_DT,'YYYY-MM-DD') AS RCV_DT, TO_CHAR(INV_CFM_DT,'YYYY-MM-DD') AS INV_CFM_DT" ).append("\n"); 
		query.append("	       , COST_OFC_CD, ORD_HDR_RMK" ).append("\n"); 
		query.append("	       , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 1, 2))  AA" ).append("\n"); 
		query.append("           , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 4, 2))  BB" ).append("\n"); 
		query.append("           , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 7, 2))  CC" ).append("\n"); 
		query.append("           , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 10, 2)) DD" ).append("\n"); 
		query.append("	       , CRE_DT, UPD_USR_ID, UPD_DT, '' AS CRE_FR_DT, '' AS CRE_TO_DT, MNR_RCV_ORD_INV_TMP_SEQ, '' AS RQST_EQ_NO  " ).append("\n"); 
		query.append("  	FROM MNR_ORD_TMP_HDR" ).append("\n"); 
		query.append(" 	WHERE VRFY_RSLT_DESC <> 'SS' " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT CURR_CD, VNDR_SEQ, INV_AMT, VAT_AMT, INV_WHLD_TAX_AMT, INV_NO" ).append("\n"); 
		query.append("	     , TO_CHAR(RCV_DT,'YYYY-MM-DD') AS RCV_DT, TO_CHAR(INV_CFM_DT,'YYYY-MM-DD') AS INV_CFM_DT" ).append("\n"); 
		query.append("	     , COST_OFC_CD, ORD_HDR_RMK" ).append("\n"); 
		query.append("	     , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 1, 2))  AA" ).append("\n"); 
		query.append("         , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 4, 2))  BB" ).append("\n"); 
		query.append("         , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 7, 2))  CC" ).append("\n"); 
		query.append("         , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = SUBSTR(VRFY_RSLT_DESC, 10, 2)) DD" ).append("\n"); 
		query.append("	, CRE_DT, UPD_USR_ID, UPD_DT, '' AS CRE_FR_DT, '' AS CRE_TO_DT, MNR_RCV_ORD_INV_TMP_SEQ, '' AS RQST_EQ_NO" ).append("\n"); 
		query.append("  	FROM MNR_ORD_TMP_HDR A" ).append("\n"); 
		query.append(" 	WHERE A.VRFY_RSLT_DESC = 'SS'" ).append("\n"); 
		query.append("   	AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM MNR_ORD_TMP_DTL B" ).append("\n"); 
		query.append("                WHERE A.MNR_RCV_ORD_INV_TMP_SEQ = B.MNR_RCV_ORD_INV_TMP_SEQ" ).append("\n"); 
		query.append("                  AND B.VRFY_RSLT_DESC <> 'SS')" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if(${inv_no} != '')" ).append("\n"); 
		query.append("	AND INV_NO like '%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_fr_dt} != '')" ).append("\n"); 
		query.append("	AND CRE_DT >= to_date(@[cre_fr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_to_dt} != '')" ).append("\n"); 
		query.append("	AND CRE_DT < to_date(@[cre_to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("    AND MNR_RCV_ORD_INV_TMP_SEQ IN ( SELECT DISTINCT MNR_RCV_ORD_INV_TMP_SEQ " ).append("\n"); 
		query.append("                                       FROM MNR_ORD_TMP_DTL" ).append("\n"); 
		query.append("                                      WHERE EQ_NO IN (" ).append("\n"); 
		query.append("           						#foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("									#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("										'$user_eq_no'," ).append("\n"); 
		query.append("									#else" ).append("\n"); 
		query.append("										'$user_eq_no'" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("              					#end" ).append("\n"); 
		query.append("                    				)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mnr_rcv_ord_inv_tmp_seq} != '')" ).append("\n"); 
		query.append("AND MNR_RCV_ORD_INV_TMP_SEQ = @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MNR_RCV_ORD_INV_TMP_SEQ" ).append("\n"); 

	}
}