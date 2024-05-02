/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.05.26 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receipt 조회
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOReceiptRSQL").append("\n"); 
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
		query.append("  A1.RDN_NO" ).append("\n"); 
		query.append(", A1.RVIS_SEQ" ).append("\n"); 
		query.append(", A1.ISS_OFC_CD         --ISSUE OFFICE_CD" ).append("\n"); 
		query.append(", A1.RCT_RHQ_CD" ).append("\n"); 
		query.append(", A1.RCT_OFC_CD" ).append("\n"); 
		query.append(", DECODE(NVL(A1.RESPB_OFC_CD,''),'',A1.RCT_OFC_CD,A1.RESPB_OFC_CD) AS RESPB_OFC_CD" ).append("\n"); 
		query.append(",   (SELECT UMCH_TP_DESC" ).append("\n"); 
		query.append("    from BKG_REV_UMCH_TP" ).append("\n"); 
		query.append("    WHERE UMCH_TP_CD = A1.UMCH_TP_CD) AS UMCH_TP_CD" ).append("\n"); 
		query.append(",   (SELECT UMCH_SUB_TP_DESC" ).append("\n"); 
		query.append("    from BKG_REV_UMCH_SUB_TP" ).append("\n"); 
		query.append("    WHERE UMCH_TP_CD = A1.UMCH_TP_CD" ).append("\n"); 
		query.append("  AND   UMCH_SUB_TP_CD = A1.UMCH_SUB_TP_CD) AS UMCH_SUB_TP_CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("    from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD01567'" ).append("\n"); 
		query.append("    AND   INTG_CD_VAL_CTNT = A1.RDN_ISS_RSN_CD) AS RDN_ISS_RSN_CD" ).append("\n"); 
		query.append(", TO_CHAR(A1.RDN_ISS_DT,'YYYY-MM-DD') AS RDN_ISS_DT" ).append("\n"); 
		query.append(", A1.UMCH_RMK           --DISCREPANCY DETAIL" ).append("\n"); 
		query.append(", NVL(A1.RDN_STS_CD,'') AS RDN_STS_CD        --RDN STAUS CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("    from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("    AND   INTG_CD_VAL_CTNT = A1.RDN_STS_CD) AS RDN_STS_NM" ).append("\n"); 
		query.append(", ( SELECT TO_CHAR(MAX(A.CRE_DT),'YYYY-MM-DD') FROM BKG_REV_DR_NOTE_PROG A WHERE A.RDN_NO = A1.RDN_NO AND A.RVIS_SEQ = A1.RVIS_SEQ ) AS STS_UPD_DT" ).append("\n"); 
		query.append(", A1.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(A1.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(", A1.UPD_USR_ID" ).append("\n"); 
		query.append(", A1.UPD_DT" ).append("\n"); 
		query.append(",   B1.BKG_NO" ).append("\n"); 
		query.append(", A1.BKG_CORR_NO        --CA NO" ).append("\n"); 
		query.append(",   B1.BL_NO" ).append("\n"); 
		query.append(",   CASE" ).append("\n"); 
		query.append("    WHEN B2.BKG_CTRT_TP_CD = 'S' THEN B1.SC_NO" ).append("\n"); 
		query.append("    WHEN B2.BKG_CTRT_TP_CD = 'R' THEN B1.RFA_NO" ).append("\n"); 
		query.append("    WHEN B2.BKG_CTRT_TP_CD = 'T' THEN B1.TAA_NO" ).append("\n"); 
		query.append("    END AS SC_RFA_NO" ).append("\n"); 
		query.append(",   TO_CHAR(A1.UPD_DT,'YYYY-MM-DD') AS STS_UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", A1.RESPB_RHQ_CD" ).append("\n"); 
		query.append("--, A1.REV_AUD_TOOL_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("    from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD02371'" ).append("\n"); 
		query.append("    AND   INTG_CD_VAL_CTNT = A1.REV_AUD_TOOL_CD) AS REV_AUD_TOOL_CD" ).append("\n"); 
		query.append(", '' AS BL_NO_CHK" ).append("\n"); 
		query.append(", '' AS BL_NO_TP" ).append("\n"); 
		query.append(", '' AS RECEIVER_RMK" ).append("\n"); 
		query.append(", '' AS BKG_NO_SPLIT" ).append("\n"); 
		query.append(", '' AS PROG_SEQ" ).append("\n"); 
		query.append(", '' AS RDN_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    BKG_REV_DR_NOTE A1  ," ).append("\n"); 
		query.append("        BKG_BOOKING     B1  ," ).append("\n"); 
		query.append("        BKG_RATE        B2" ).append("\n"); 
		query.append("WHERE   B1.BKG_NO = A1.BKG_NO" ).append("\n"); 
		query.append("AND     B2.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND     B1.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rdn_no} != '')" ).append("\n"); 
		query.append("AND     A1.RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     (A1.RDN_NO, A1.RVIS_SEQ) IN (" ).append("\n"); 
		query.append("                                    SELECT  RDN_NO  ," ).append("\n"); 
		query.append("                                            MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                    FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                    GROUP BY" ).append("\n"); 
		query.append("                                            RDN_NO" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        A1.RDN_NO   DESC  ," ).append("\n"); 
		query.append("        A1.RVIS_SEQ DESC" ).append("\n"); 

	}
}