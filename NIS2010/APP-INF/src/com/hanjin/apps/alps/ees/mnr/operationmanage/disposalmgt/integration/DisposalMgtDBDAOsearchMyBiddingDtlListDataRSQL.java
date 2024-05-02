/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchMyBiddingDtlListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.09
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.02.11 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.04.09 신혜정 [CHM-201217745] Disposal request 시 입력한 수리비를 SPP에서 바이어가 Price 입력시 보여주는 logic 구현 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchMyBiddingDtlListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - EES_MNR_S304 화면에서 상세조회
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchMyBiddingDtlListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_ut_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchMyBiddingDtlListDataRSQL").append("\n"); 
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
		query.append("SELECT A.DISP_NO" ).append("\n"); 
		query.append("     , A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("     , A.DISP_UT_TP_CD" ).append("\n"); 
		query.append("     , A.EQ_NO" ).append("\n"); 
		query.append("     , F.EQ_KND_CD" ).append("\n"); 
		query.append("     , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , CASE WHEN F.EQ_KND_CD = 'U' THEN (SELECT CNTR_TPSZ_DESC CD FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = A.EQ_TPSZ_CD)" ).append("\n"); 
		query.append("            ELSE (SELECT DIFF_DESC CD_DESC FROM CGM_EQ_TP_SZ CETS WHERE CETS.EQ_KND_CD = F.EQ_KND_CD AND CETS.EQ_TPSZ_CD = A.EQ_TPSZ_CD)" ).append("\n"); 
		query.append("       END  EQ_TPSZ_NM" ).append("\n"); 
		query.append("     , A.DISP_YD_CD" ).append("\n"); 
		query.append("     , A.DISP_QTY" ).append("\n"); 
		query.append("     , A.DISP_SOLD_DT" ).append("\n"); 
		query.append("     , A.DISP_TRKR_NM" ).append("\n"); 
		query.append("     , A.DISP_RLSE_NO" ).append("\n"); 
		query.append("     , A.DISP_UT_PRC" ).append("\n"); 
		query.append("     , A.DISP_RSN_CD" ).append("\n"); 
		query.append("     , A.PART_AMT" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.FILE_SEQ" ).append("\n"); 
		query.append("     , A.RCV_INV_SEQ" ).append("\n"); 
		query.append("     --MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("     ,(SELECT C.MNR_DISP_DTL_RMK " ).append("\n"); 
		query.append("         FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("            , MNR_PARTNER E" ).append("\n"); 
		query.append("        WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("          AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("          AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("          AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("          AND E.SP_PTAL_ID = @[sp_ptal_id]) AS MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("     --MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("     ,(SELECT C.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("         FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("            , MNR_PARTNER E" ).append("\n"); 
		query.append("        WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("          AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("          AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("          AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("          AND E.SP_PTAL_ID = @[sp_ptal_id]) AS MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("     --MNR_PRNR_SEQ" ).append("\n"); 
		query.append("     ,(SELECT C.MNR_PRNR_SEQ " ).append("\n"); 
		query.append("         FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("            , MNR_PARTNER E" ).append("\n"); 
		query.append("        WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("          AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("          AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("          AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("          AND E.SP_PTAL_ID = @[sp_ptal_id]) AS MNR_PRNR_SEQ" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("     , DECODE(LENGTH(A.DISP_YD_CD),7,(SELECT YD_NM  FROM MDM_YARD WHERE YD_CD  = A.DISP_YD_CD)," ).append("\n"); 
		query.append("                                     (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.DISP_YD_CD)) DISP_YD_NM" ).append("\n"); 
		query.append("     , SUBSTR(B.MANU_DT,0,4) MANU_YEAR" ).append("\n"); 
		query.append("     , B.MTRL_NM " ).append("\n"); 
		query.append("     , B.MKR_NM " ).append("\n"); 
		query.append("     , B.MDL_NM" ).append("\n"); 
		query.append("     --PART_DISP_QTY" ).append("\n"); 
		query.append("     , (SELECT DISP_QTY " ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("             , MNR_PARTNER E" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("           AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("           AND E.SP_PTAL_ID = @[sp_ptal_id]) AS PART_DISP_QTY" ).append("\n"); 
		query.append("     --PART_UT_AMT" ).append("\n"); 
		query.append("     , (SELECT PART_UT_AMT " ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("             , MNR_PARTNER E" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("           AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("           AND E.SP_PTAL_ID = @[sp_ptal_id]) AS PART_UT_AMT" ).append("\n"); 
		query.append("	  -- TMP_PART_UT_AMT 변경여부를 체크하기 위한 임시값" ).append("\n"); 
		query.append("     , (SELECT PART_UT_AMT " ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("             , MNR_PARTNER E" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=A.DISP_NO " ).append("\n"); 
		query.append("           AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("           AND E.SP_PTAL_ID = @[sp_ptal_id]) AS TMP_PART_UT_AMT" ).append("\n"); 
		query.append("     --MNR_DISP_CFM_STS_NM " ).append("\n"); 
		query.append("     , (SELECT CASE WHEN C.MNR_DISP_CFM_STS_CD = 'C' THEN 'Won'" ).append("\n"); 
		query.append("                    WHEN C.MNR_DISP_CFM_STS_CD = 'N' THEN 'Lost'" ).append("\n"); 
		query.append("                    WHEN D.DISP_STS_CD = 'HA' AND SYSDATE BETWEEN D.DISP_ST_DT AND D.DISP_END_DT THEN 'Processing'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART C" ).append("\n"); 
		query.append("             , MNR_DISP_HDR D" ).append("\n"); 
		query.append("             , MNR_PARTNER E" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=A.DISP_NO" ).append("\n"); 
		query.append("           AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD " ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("           AND C.DISP_NO = D.DISP_NO" ).append("\n"); 
		query.append("           AND E.SP_PTAL_ID = @[sp_ptal_id]) AS MNR_DISP_CFM_STS_NM" ).append("\n"); 
		query.append("     --RANK " ).append("\n"); 
		query.append("     , (SELECT C.RNO - C.LVL  + 1 AS RNK" ).append("\n"); 
		query.append("          FROM ( SELECT DISP_NO" ).append("\n"); 
		query.append("                      , DISP_DTL_SEQ" ).append("\n"); 
		query.append("                      , MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("                      , MNR_PRNR_SEQ     " ).append("\n"); 
		query.append("                      , PART_UT_AMT" ).append("\n"); 
		query.append("                      , UPD_DT     " ).append("\n"); 
		query.append("                      , RANK() OVER (ORDER BY DISP_NO, DISP_DTL_SEQ) AS LVL" ).append("\n"); 
		query.append("                      , RANK() OVER (ORDER BY DISP_NO, DISP_DTL_SEQ,PART_UT_AMT DESC, UPD_DT ASC) AS RNO" ).append("\n"); 
		query.append("                   FROM MNR_DISP_BUYR_DTL_PART" ).append("\n"); 
		query.append("               ) C" ).append("\n"); 
		query.append("               , MNR_PARTNER E" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=A.DISP_NO" ).append("\n"); 
		query.append("           AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ " ).append("\n"); 
		query.append("           AND E.SP_PTAL_ID = @[sp_ptal_id] ) AS RNK" ).append("\n"); 
		query.append("     --INVOICE STATUS NAME" ).append("\n"); 
		query.append("     , (SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("          FROM MNR_GEN_CD" ).append("\n"); 
		query.append("         WHERE PRNT_CD_ID = 'CD00027'" ).append("\n"); 
		query.append("           AND MNR_CD_ID = (SELECT MNR_INV_STS_CD " ).append("\n"); 
		query.append("                              FROM MNR_RCV_INV_WRK" ).append("\n"); 
		query.append("                             WHERE INV_NO = A.INV_NO)) AS INV_STS_NM" ).append("\n"); 
		query.append("	 --BIDS COUNT" ).append("\n"); 
		query.append("	 , NVL((SELECT C.VNDR_BID_KNT " ).append("\n"); 
		query.append("				FROM MNR_DISP_BUYR_DTL_PART C, MNR_PARTNER E" ).append("\n"); 
		query.append("					WHERE C.DISP_NO=A.DISP_NO" ).append("\n"); 
		query.append("					AND C.DISP_DTL_SEQ = A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("					AND C.MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("					AND C.MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("					AND E.SP_PTAL_ID = @[sp_ptal_id]),0) AS VNDR_BID_KNT" ).append("\n"); 
		query.append("	 ,B.RPR_COST_AMT" ).append("\n"); 
		query.append("  FROM MNR_DISP_DTL A" ).append("\n"); 
		query.append("     , MNR_EQ_STS_V B" ).append("\n"); 
		query.append("     , MNR_DISP_HDR F" ).append("\n"); 
		query.append(" WHERE A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("   AND A.DISP_NO = F.DISP_NO" ).append("\n"); 
		query.append("   AND A.DISP_NO = @[selected_disp_no]" ).append("\n"); 
		query.append("   AND A.DISP_UT_TP_CD = @[disp_ut_tp_cd]" ).append("\n"); 

	}
}