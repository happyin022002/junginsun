/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOSearch310PdfGrpCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearch310PdfGrpCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DRAFT B/L 을 화주의 FTP에 직접 등록시 어느 위치에 생성 시킬지 체크
	  * </pre>
	  */
	public BLIssuanceDBDAOSearch310PdfGrpCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ec_edircv_id_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_edi_cust",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearch310PdfGrpCheckRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1" ).append("\n"); 
		query.append(" 	 , CASE WHEN ATTR_CTNT1 ='KUEHNENAGEL' THEN " ).append("\n"); 
		query.append("            NVL((SELECT RAT_FLG FROM BKG_CUST_BL_IMG_STUP WHERE CUST_CNT_CD = CUST.CUST_CNT_CD AND CUST_SEQ = CUST.CUST_SEQ AND NVL(BK.BL_TP_CD,'C') = BL_IMG_FILE_TP_CD),ATTR_CTNT2)  " ).append("\n"); 
		query.append("            ELSE ATTR_CTNT2" ).append("\n"); 
		query.append("       END ATTR_CTNT2" ).append("\n"); 
		query.append("     , ATTR_CTNT3  " ).append("\n"); 
		query.append(" 	 , CASE WHEN ATTR_CTNT1 ='KUEHNENAGEL' AND NVL((SELECT RAT_FLG FROM BKG_CUST_BL_IMG_STUP WHERE CUST_CNT_CD = CUST.CUST_CNT_CD AND CUST_SEQ = CUST.CUST_SEQ AND NVL(BK.BL_TP_CD,'C') = BL_IMG_FILE_TP_CD),ATTR_CTNT2) = 'N' THEN " ).append("\n"); 
		query.append("            ATTR_CTNT4 || NVL((SELECT CUST_REF_NO_CTNT FROM BKG_REFERENCE WHERE BKG_NO = BK.BKG_NO AND BKG_REF_TP_CD = 'ESFF' AND LENGTH(CUST_REF_NO_CTNT) = 16 AND ROWNUM =1),(SELECT FWRD_REF_NO FROM (SELECT FWRD_REF_NO FROM BKG_XTER_RQST_MST WHERE BKG_NO = @[bkg_no] AND LENGTH(FWRD_REF_NO) = 16 ORDER BY CRE_DT DESC) WHERE ROWNUM =1)) " ).append("\n"); 
		query.append("            || DECODE(BK.BL_TP_CD,'W','X100101.','X110101.') ||'SML'|| TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') ||'.pdf' " ).append("\n"); 
		query.append("            WHEN ATTR_CTNT1 ='KUEHNENAGEL' AND NVL((SELECT RAT_FLG FROM BKG_CUST_BL_IMG_STUP WHERE CUST_CNT_CD = CUST.CUST_CNT_CD AND CUST_SEQ = CUST.CUST_SEQ AND NVL(BK.BL_TP_CD,'C') = BL_IMG_FILE_TP_CD),ATTR_CTNT2) = 'Y' THEN" ).append("\n"); 
		query.append("            ATTR_CTNT4 || NVL((SELECT CUST_REF_NO_CTNT FROM BKG_REFERENCE WHERE BKG_NO = BK.BKG_NO AND BKG_REF_TP_CD = 'ESFF' AND LENGTH(CUST_REF_NO_CTNT) = 16 AND ROWNUM =1),(SELECT FWRD_REF_NO FROM (SELECT FWRD_REF_NO FROM BKG_XTER_RQST_MST WHERE BKG_NO = @[bkg_no] AND LENGTH(FWRD_REF_NO) = 16 ORDER BY CRE_DT DESC) WHERE ROWNUM =1)) " ).append("\n"); 
		query.append("            || DECODE(BK.BL_TP_CD,'W','X130101.','X140101.') ||'SML'|| TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') ||'.pdf' " ).append("\n"); 
		query.append("			WHEN ATTR_CTNT1 ='BDP_ANR' AND NVL(BK.BL_TP_CD,'N') ='W' THEN" ).append("\n"); 
		query.append("            ATTR_CTNT4 || (SELECT TRIM(REPLACE(CUST_REF_NO_CTNT,'BDP REF','')) FROM BKG_REFERENCE WHERE BKG_NO = BK.BKG_NO AND BKG_REF_TP_CD = 'ESFF' AND ROWNUM =1 )||'_'|| BK.BKG_NO ||'_'||'SMLM'||BK.BL_NO || CASE WHEN ATTR_CTNT6 = 'YYYYMMDDHH24MISS' THEN '_'||TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') ELSE '' END ||'_ExpressBL.pdf'  " ).append("\n"); 
		query.append("            ELSE ATTR_CTNT4 || BK.BKG_NO || ATTR_CTNT5 || CASE WHEN ATTR_CTNT6 = 'YYYYMMDDHH24MISS' THEN '_'||TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') ELSE '' END ||'.pdf'  " ).append("\n"); 
		query.append("       END ATTR_CTNT4" ).append("\n"); 
		query.append("       -- OBL RELEASE / SWB RELEASE일때만 NON-nego copy form사용" ).append("\n"); 
		query.append(" 	 , CASE WHEN ATTR_CTNT1 ='KUEHNENAGEL' AND NVL(BK.BL_TP_CD,'N') = 'W' THEN ATTR_CTNT9" ).append("\n"); 
		query.append("            WHEN ATTR_CTNT1 ='KUEHNENAGEL' AND NVL(BK.BL_TP_CD,'N') = 'N' AND ISS.OBL_RLSE_FLG = 'Y' THEN ATTR_CTNT9" ).append("\n"); 
		query.append("            WHEN ATTR_CTNT1 ='KUEHNENAGEL' THEN 'BKG016'" ).append("\n"); 
		query.append("            ELSE ATTR_CTNT9" ).append("\n"); 
		query.append("       END ATTR_CTNT9" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	 BKG_BOOKING BK," ).append("\n"); 
		query.append("     BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("     BKG_EDI_GRP GRP," ).append("\n"); 
		query.append("     BKG_EDI_GRP_CUST GRP_CUST," ).append("\n"); 
		query.append("     BKG_HRD_CDG_CTNT HRD," ).append("\n"); 
		query.append("     BKG_BL_ISS ISS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("  AND (" ).append("\n"); 
		query.append("        (CUST.CUST_CNT_CD = GRP_CUST.CNT_CD AND CUST.CUST_SEQ = GRP_CUST.CUST_SEQ)" ).append("\n"); 
		query.append("        OR BK.SC_NO = GRP_CUST.SC_NO" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if (${ec_edircv_id_old} == 'KUEHNENAGEL') " ).append("\n"); 
		query.append("  AND CUST.CUST_CNT_CD = SUBSTR(@[group_edi_cust],0,2)" ).append("\n"); 
		query.append("  AND CUST.CUST_SEQ = SUBSTR(@[group_edi_cust],3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND GRP.ESVC_GRP_CD = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("  AND GRP.CUST_TRD_PRNR_ID = HRD.ATTR_CTNT1" ).append("\n"); 
		query.append("  AND HRD.HRD_CDG_ID ='310_EDI_PDF_GRP'" ).append("\n"); 
		query.append("  AND GRP.ESVC_GRP_DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND GRP_CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND GRP.CO_CD ='H'" ).append("\n"); 
		query.append("  AND ATTR_CTNT1 = @[ec_edircv_id_old]" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT 'Y' FROM BKG_BOOKING WHERE BKG_NO = BK.BKG_NO AND NVL(BL_TP_CD,'N') <> 'W' AND 'BDP_ANR' = @[ec_edircv_id_old]) --BDP_ANR 은 Waybill 만 전송" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}