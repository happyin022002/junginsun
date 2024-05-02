/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsReportDBDAOsearchSendLogInEURRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsReportDBDAOsearchSendLogInEURRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 지역 CTA 전송 로그를 B/L별로 조회 함
	  * 2011.02.28 김영철 [] Transmit History (ESM_BKG_1032) 화면에서 조건 추가 ( VVD )
	  * 2011.03.16 김영철 [] Transmit History (ESM_BKG_1032) 화면에서 vvd 값을 BKG_VVD 테이블에서 가지고 오도록 수정함.
	  * </pre>
	  */
	public EurCustomsReportDBDAOsearchSendLogInEURRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_for_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsReportDBDAOsearchSendLogInEURRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.ORG_MSG_TP_ID                 -- Message Type" ).append("\n"); 
		query.append("      ,A.MSG_FUNC_ID                  -- Message Update" ).append("\n"); 
		query.append("      ,A.ACK_KND_ID                   -- ACK_KND_ID" ).append("\n"); 
		query.append("      ,DECODE(A.ACK_RCV_STS_CD, 'A', 'Accepted', 'R', 'Rejected', 'C', 'Conditionally Accepted', '') ACK_RCV_STS_CD  -- Acknowledge Result" ).append("\n"); 
		query.append("      ,A.ACK_DT                       -- Acknowledge Date" ).append("\n"); 
		query.append("      ,A.APRO_DT                      -- Approve Date" ).append("\n"); 
		query.append("      ,A.BL_NO                        -- B/L No." ).append("\n"); 
		query.append("      ,A.CNTR_NO                      -- Container No." ).append("\n"); 
		query.append("      ,A.MSG_ACPT_REF_NO              -- Accept Reference No." ).append("\n"); 
		query.append("      ,A.MSG_RCV_NO                   -- Declaration No" ).append("\n"); 
		query.append("      ,(SELECT CNTR.CNTR_PRT_FLG" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         WHERE CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("       ) AS CNTR_PRT_FLG" ).append("\n"); 
		query.append("      ,(BKG_JOIN_CLOB_FNC(CURSOR(SELECT DECODE(CSTMS_ERR_ID, NULL, '', CSTMS_ERR_ID || '|' || CSTMS_ERR_MSG || '|' || CSTMS_ERR_REF_NO1 || '|' || CSTMS_ERR_REF_NO2)" ).append("\n"); 
		query.append("                                   FROM BKG_CSTMS_EUR_DG_RCV_ERR" ).append("\n"); 
		query.append("                                  WHERE EUR_EDI_MSG_TP_ID = A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                    AND MSG_RCV_NO = A.MSG_RCV_NO" ).append("\n"); 
		query.append("                                    AND RCV_LOG_SEQ = A.RCV_LOG_SEQ" ).append("\n"); 
		query.append("                                ),CHR(13)" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("       ) CSTMS_ERR_ID  -- Reject Reason" ).append("\n"); 
		query.append("      ,(SELECT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("          FROM BKG_VVD VVD" ).append("\n"); 
		query.append("         WHERE VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.POD_CD = DECODE(A.CRE_USR_ID,'BIP','DEBRV','IMP','DEHAM','FCPSYS','GBFXT','') " ).append("\n"); 
		query.append("       ) VVD" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_DG_RCV A" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BL_NO    = BKG.BL_NO(+)" ).append("\n"); 
		query.append("   AND A.EUR_EDI_MSG_TP_ID = 'CTA'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("   AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vps_eta_dt} != '')" ).append("\n"); 
		query.append("   AND A.ACK_DT >=  TO_DATE(REPLACE(@[s_vps_eta_dt],'-',''), 'YYYYMMDD') AND A.ACK_DT < TO_DATE(REPLACE(@[e_vps_eta_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fr_ack} == 'Y')" ).append("\n"); 
		query.append("   AND A.MSG_ACPT_REF_NO  LIKE 'FR____' || @[vvd_for_fr] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND A.VVD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.UPD_DT DESC" ).append("\n"); 

	}
}