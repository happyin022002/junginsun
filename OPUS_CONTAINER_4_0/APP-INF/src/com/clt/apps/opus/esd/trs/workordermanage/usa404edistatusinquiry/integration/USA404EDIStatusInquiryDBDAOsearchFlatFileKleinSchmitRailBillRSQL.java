/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBill
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_msg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strsp_edi_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,O.FM_NOD_CD AS ORG_YARD" ).append("\n"); 
		query.append("	  ,I.YD_LOC_CTY_NM AS ORG_CITY" ).append("\n"); 
		query.append("	  ,I.YD_LOC_STE_CD AS ORG_STATE" ).append("\n"); 
		query.append("      ,O.TO_NOD_CD AS DEST_YARD" ).append("\n"); 
		query.append("	  ,K.YD_LOC_CTY_NM AS DEST_CITY" ).append("\n"); 
		query.append("	  ,K.YD_LOC_STE_CD AS DEST_STATE" ).append("\n"); 
		query.append("	  ,O.ROUTCARR AS N1ST_CARRIER" ).append("\n"); 
		query.append("	  ,O.ROUTCITY AS N1ST_INTERCHANGE" ).append("\n"); 
		query.append("	  ,O.ROUTCARR2 AS N2ND_CARRIER" ).append("\n"); 
		query.append("	  ,O.ROUTCITY2 AS N2ND_INTERCHANGE" ).append("\n"); 
		query.append("	  ,O.ROUTCARR3 AS N3RD_CARRIER" ).append("\n"); 
		query.append("	  ,O.AGMT_REF_NO AS N1ST_AUTH" ).append("\n"); 
		query.append("	  ,O.AGMT_REF_NO2 AS N2ND_AUTH" ).append("\n"); 
		query.append("	  ,O.AGMT_REF_NO3 AS N3RD_AUTH" ).append("\n"); 
		query.append("	  ,O.INTMOSVR AS N1ST_PLAN" ).append("\n"); 
		query.append("	  ,O.INTMOSVR2 AS N2ND_PLAN" ).append("\n"); 
		query.append("	  ,O.INTMOSVR3 AS N3RD_PLAN" ).append("\n"); 
		query.append("	  ,'CN' AS EQ_TPYE" ).append("\n"); 
		query.append("	  ,DECODE(O.ROUTSEQ, 'R', 'Y', 'N') AS N1ST_RULE" ).append("\n"); 
		query.append("	  ,DECODE(SUBSTR(A.RAIL_CMB_THRU_TP_CD, 2, 1), '3', 'Y', '') AS N2ND_RULE" ).append("\n"); 
		query.append("	  ,DECODE(@[p_msg_type], 'C', 'CA', " ).append("\n"); 
		query.append("	  			NVL2((SELECT MAX(BIL_EDI_RCV_RSLT_DT) FROM TRS_TRSP_EDI_RAIL_ORD WHERE TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = A.TRSP_SO_SEQ AND BIL_EDI_CTRL_SEQ = O.BIL_EDI_CTRL_SEQ)," ).append("\n"); 
		query.append("	  			'CO'," ).append("\n"); 
		query.append("	  			'')) AS MSG_TYPE" ).append("\n"); 
		query.append("	  ,C.USA_EDI_CD" ).append("\n"); 
		query.append("	  ,@[strsp_edi_snd_no] AS STRSP_EDI_SND_NO" ).append("\n"); 
		query.append("	FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("			,MDM_VENDOR C" ).append("\n"); 
		query.append("			,MDM_YARD I" ).append("\n"); 
		query.append("			,MDM_YARD K" ).append("\n"); 
		query.append("			,(SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("					,MIN(DECODE(A.SUB_RAIL_SEQ, 1, A.VNDR_SEQ)) VNDR_SEQ" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, B.USA_EDI_CD, '')) ROUTCARR" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(C.RAIL_CMB_THRU_TP_CD, 3), 'T', 'S', 'C', 'S', 'R'), '')) ROUTSEQ" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, MST.ROUT_PLN_CD, '')) INTMOSVR" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, A.TO_NOD_CD, '')) TO_YARD_CD" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, AGMT.AGMT_REF_NO)) AGMT_REF_NO" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, B.USA_EDI_CD, '')) ROUTCARR2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, '1', '')) ROUTSEQ2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, MST.ROUT_PLN_CD, '')) INTMOSVR2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, A.TO_NOD_CD, '')) TO_YARD_CD2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 2, AGMT.AGMT_REF_NO)) AGMT_REF_NO2" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, B.USA_EDI_CD, '')) ROUTCARR3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, '2', '')) ROUTSEQ3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, MST.ROUT_PLN_CD, '')) INTMOSVR3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, A.TO_NOD_CD, '')) TO_YARD_CD3" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 3, AGMT.AGMT_REF_NO)) AGMT_REF_NO3" ).append("\n"); 
		query.append("					,MAX(EDI.BIL_EDI_CTRL_SEQ) BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("					,MAX(EDI.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("					,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'CN', 'T', 'CC'))) EQDESC_C" ).append("\n"); 
		query.append("					,MAX(C.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("					,MAX(C.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("				FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("					,MDM_VENDOR                 B" ).append("\n"); 
		query.append("					,TRS_TRSP_RAIL_BIL_ORD      C" ).append("\n"); 
		query.append("					,TRS_TRSP_EDI_TMP           TMP" ).append("\n"); 
		query.append("					,TRS_TRSP_EDI_RAIL_ORD      EDI" ).append("\n"); 
		query.append("					,TRS_AGMT_HDR               AGMT" ).append("\n"); 
		query.append("					,PRD_INLND_ROUT_DTL         PRD" ).append("\n"); 
		query.append("					,PRD_INLND_ROUT_MST         MST" ).append("\n"); 
		query.append("				 WHERE TMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_OFC_CTY_CD = TMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_SEQ = TMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("					 AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("					 AND C.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("					 AND C.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("					 AND C.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("					 AND A.ROUT_DTL_SEQ = PRD.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("					 AND MST.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("					 AND MST.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("					 AND MST.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_OFC_CTY_CD = EDI.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					 AND A.TRSP_SO_SEQ = EDI.TRSP_SO_SEQ" ).append("\n"); 
		query.append("					 AND A.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("					 AND A.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("					 AND C.RAIL_CMB_THRU_TP_CD IN ('C1T', 'C2T', 'C3T', 'C2R', 'C3R', 'C2C', 'C3S')" ).append("\n"); 
		query.append("				 GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					  ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("					  ,A.VNDR_SEQ" ).append("\n"); 
		query.append("					  ,B.USA_EDI_CD ROUTCARR" ).append("\n"); 
		query.append("					  ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(C.RAIL_CMB_THRU_TP_CD, 3), 'T', 'S', 'C', 'S', 'R'), 2, 1, 3, 2)) ROUTSEQ" ).append("\n"); 
		query.append("					  ,PRD.INLND_ROUT_JUNC_NM ROUTCITY" ).append("\n"); 
		query.append("					  ,MST.ROUT_PLN_CD INTMOSVR" ).append("\n"); 
		query.append("					  ,DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X') TRANSTP" ).append("\n"); 
		query.append("					  ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, A.TO_NOD_CD, '')) TO_YARD_CD" ).append("\n"); 
		query.append("					  ,MAX(AGMT.AGMT_REF_NO) AGMT_REF_NO" ).append("\n"); 
		query.append("					  ,'' ROUTCARR2" ).append("\n"); 
		query.append("					  ,'' ROUTSEQ2" ).append("\n"); 
		query.append("					  ,'' ROUTCITY2" ).append("\n"); 
		query.append("					  ,'' INTMOSVR2" ).append("\n"); 
		query.append("					  ,'' TRANSTP2" ).append("\n"); 
		query.append("					  ,'' TO_YARD_CD2" ).append("\n"); 
		query.append("					  ,'' AGMT_REF_NO2" ).append("\n"); 
		query.append("					  ,'' ROUTCARR3" ).append("\n"); 
		query.append("					  ,'' ROUTSEQ3" ).append("\n"); 
		query.append("					  ,'' ROUTCITY3" ).append("\n"); 
		query.append("					  ,'' INTMOSVR3" ).append("\n"); 
		query.append("					  ,'' TRANSTP3" ).append("\n"); 
		query.append("					  ,'' TO_YARD_CD3" ).append("\n"); 
		query.append("					  ,'' AGMT_REF_NO3" ).append("\n"); 
		query.append("					  ,MAX(EDI.BIL_EDI_CTRL_SEQ) BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("					  ,MAX(EDI.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("					  ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'CN', 'T', 'CC'))) EQDESC_C" ).append("\n"); 
		query.append("					  ,MAX(A.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("					  ,MAX(A.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("				FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("					  ,MDM_VENDOR                 B" ).append("\n"); 
		query.append("					  ,TRS_TRSP_RAIL_BIL_ORD      C" ).append("\n"); 
		query.append("					  ,TRS_TRSP_EDI_TMP           TMP" ).append("\n"); 
		query.append("					  ,TRS_TRSP_EDI_RAIL_ORD      EDI" ).append("\n"); 
		query.append("					  ,TRS_AGMT_HDR               AGMT" ).append("\n"); 
		query.append("					  ,PRD_INLND_ROUT_DTL         PRD" ).append("\n"); 
		query.append("					  ,PRD_INLND_ROUT_MST         MST" ).append("\n"); 
		query.append("			    WHERE TMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_OFC_CTY_CD = TMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_SEQ = TMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			   	 AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			   	 AND C.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("			   	 AND C.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("			   	 AND C.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("			   	 AND A.ROUT_DTL_SEQ = PRD.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("			   	 AND MST.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("			   	 AND MST.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("			   	 AND MST.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_OFC_CTY_CD = EDI.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   	 AND A.TRSP_SO_SEQ = EDI.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			   	 AND A.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("			   	 AND A.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("			   	 AND B.VNDR_SEQ = EDI.VNDR_SEQ" ).append("\n"); 
		query.append("			   	 AND C.RAIL_CMB_THRU_TP_CD IN ('S2R', 'S3R')" ).append("\n"); 
		query.append("			    GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.VNDR_SEQ, B.USA_EDI_CD, A.TO_NOD_CD, PRD.INLND_ROUT_JUNC_NM, MST.ROUT_PLN_CD, A.RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("			    ORDER BY TRSP_SO_SEQ" ).append("\n"); 
		query.append("			) O" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = O.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	 AND A.TRSP_SO_SEQ = O.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	 AND O.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	 AND O.FM_NOD_CD = I.YD_CD" ).append("\n"); 
		query.append("	 AND O.TO_NOD_CD = K.YD_CD" ).append("\n"); 
		query.append("	 AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	 AND C.USA_EDI_CD IN ('BNSF','CSXI','CSXT','CSLI','FEC','IAIS','KCS','NS' ,'UP' ,'WC')" ).append("\n"); 

	}
}