/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOsearchDiversionRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.27 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOsearchDiversionRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관에 신고할 대상 Diverson Request 정보 데이터를 조회한다
	  * Return 은 Eur24DiversionRequestVO : 신규 생성
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOsearchDiversionRequestRSQL(){
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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOsearchDiversionRequestRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYMMDDHH24MISS') DOC_NO," ).append("\n"); 
		query.append("  EUR.CVY_REF_NO CALL_REF_NO," ).append("\n"); 
		query.append("  '' ORG_REF_NO," ).append("\n"); 
		query.append("  EUR.VSL_CD||EUR.SKD_VOY_NO||EUR.SKD_DIR_CD CRN," ).append("\n"); 
		query.append("  EUR.VSL_CD||EUR.SKD_VOY_NO||EUR.SKD_DIR_CD||'.'||(" ).append("\n"); 
		query.append("    SELECT TRIM(TO_CHAR(COUNT(VSL_CD) + 1, '000'))" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("    WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND EUR_EDI_MSG_TP_ID = 'DIV')||'.323' DIV_REF_NO," ).append("\n"); 
		query.append("  '1' TRANS_MODE," ).append("\n"); 
		query.append("  VSL.LLOYD_NO LLOYD_CD," ).append("\n"); 
		query.append("  VSL.VSL_ENG_NM VSL_NAME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("       THEN DECODE(CONV.ATTR_CTNT1, NULL, TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDDHH24')||'0000'" ).append("\n"); 
		query.append("                                        , TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD') || CONV.ATTR_CTNT3)" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("        CASE WHEN ACT.SLAN_CD = 'TLS'" ).append("\n"); 
		query.append("             THEN" ).append("\n"); 
		query.append("                CASE WHEN TO_CHAR(ACT.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                     THEN" ).append("\n"); 
		query.append("                        TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDD')|| '050000'" ).append("\n"); 
		query.append("                     ELSE   " ).append("\n"); 
		query.append("                        TO_CHAR(TRUNC(ACT.INIT_ETA_DT, 'IW') + 4, 'YYYYMMDD') || '050000'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             WHEN ACT.SLAN_CD = 'RFS' AND ACT.SKD_DIR_CD = 'N'" ).append("\n"); 
		query.append("             THEN" ).append("\n"); 
		query.append("                CASE WHEN TO_CHAR(ACT.INIT_ETA_DT,'D') = '5'" ).append("\n"); 
		query.append("                     THEN TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(TRUNC(ACT.INIT_ETA_DT, 'D') + 4, 'YYYYMMDD') || '040000' -- 일요일 기준" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("             WHEN ACT.SLAN_CD = 'RFS' AND ACT.SKD_DIR_CD = 'S'" ).append("\n"); 
		query.append("             THEN" ).append("\n"); 
		query.append("                CASE WHEN TO_CHAR(ACT.INIT_ETA_DT,'D') = '1'" ).append("\n"); 
		query.append("                     THEN TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDD')|| ' 040000'" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(TRUNC(ACT.INIT_ETA_DT, 'D'), 'YYYYMMDD') || '040000'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             ELSE " ).append("\n"); 
		query.append("                DECODE(CONV.ATTR_CTNT1, NULL, TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDDHH24')||'0000'" ).append("\n"); 
		query.append("                                            , TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDD') || CONV.ATTR_CTNT3)" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("     END AS ETA," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--TO_CHAR(ACT.INIT_ETA_DT, 'YYYYMMDD') ETA," ).append("\n"); 
		query.append("  SUBSTR(EUR.CSTMS_PORT_CD, 1, 2) CNT_CD," ).append("\n"); 
		query.append("  EUR.N1ST_CLPT_CD ORIGINAL_PORT," ).append("\n"); 
		query.append("  '1' INFO_TYPE," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("    WHERE A.PORT_CD = EUR.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      AND DECODE(A.TML_CD, 'ALL' , EUR.CSTMS_YD_CD, A.TML_CD)= EUR.CSTMS_YD_CD" ).append("\n"); 
		query.append("      AND ROWNUM=1 ) AS ORG_FIRST_OFFICE," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("    WHERE A.PORT_CD = SUBSTR(EUR.RVIS_N1ST_CLPT_CD, 1, 5)" ).append("\n"); 
		query.append("      AND DECODE(A.TML_CD, 'ALL' , EUR.RVIS_CSTMS_YD_CD , A.TML_CD)= EUR.RVIS_CSTMS_YD_CD" ).append("\n"); 
		query.append("      AND ROWNUM=1 ) AS ACT_FIRST_OFFICE," ).append("\n"); 
		query.append("  EUR.LST_CLPT_CD PREV_PORT," ).append("\n"); 
		query.append("  EUR.LST_CLPT_CD ROUTING_PORT," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',1,1) PT_TYPE," ).append("\n"); 
		query.append("  '' PT_TIN," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',2,1) PT_EORI," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',3,1) PT_NAME," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',4,1) PT_ADDRESS," ).append("\n"); 
		query.append("  '' PT_STREET," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',6,1) PT_CITY," ).append("\n"); 
		query.append("  '' PT_POSTAL_CD," ).append("\n"); 
		query.append("  BKG_GET_BKG_CTMS_CD_FNC('EU','EU24_PT_INFO',8,1) PT_CNT_CD," ).append("\n"); 
		query.append("  STUP.CNTC_NM PT_CON_NAME," ).append("\n"); 
		query.append("  STUP.CNTC_PSN_NM PT_CON_CMPY," ).append("\n"); 
		query.append("  STUP.CNTC_EML PT_EM_NO," ).append("\n"); 
		query.append("  STUP.CNTC_PHN_NO PT_TEL_NO," ).append("\n"); 
		query.append("  STUP.CNTC_FAX_NO PT_FAX_NO," ).append("\n"); 
		query.append("  EUR.VSL_CD," ).append("\n"); 
		query.append("  EUR.SKD_VOY_NO," ).append("\n"); 
		query.append("  EUR.SKD_DIR_CD," ).append("\n"); 
		query.append("  EUR.CSTMS_PORT_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("  BKG_CSTMS_EUR_VSL EUR," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD ACT," ).append("\n"); 
		query.append("  (SELECT CNTC_NM," ).append("\n"); 
		query.append("      CNTC_PSN_NM," ).append("\n"); 
		query.append("      CNTC_EML," ).append("\n"); 
		query.append("      CNTC_PHN_NO," ).append("\n"); 
		query.append("      CNTC_FAX_NO" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A," ).append("\n"); 
		query.append("      BKG_CSTMS_EUR_VSL B" ).append("\n"); 
		query.append("    WHERE B.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("      AND B.CSTMS_PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("      AND B.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND A.TML_CD IN ('ALL'," ).append("\n"); 
		query.append("          B.CSTMS_YD_CD )" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) STUP" ).append("\n"); 
		query.append("      ,(SELECT T1.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("          FROM ( SELECT K.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_EUR_BL K " ).append("\n"); 
		query.append("                  WHERE K.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("                    AND K.VSL_CD   = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                    AND K.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) T1 RIGHT OUTER JOIN dual" ).append("\n"); 
		query.append("            ON T1.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("      ) XXX" ).append("\n"); 
		query.append("      ,BKG_CSTMS_CD_CONV_CTNT CONV" ).append("\n"); 
		query.append("WHERE EUR.VSL_CD = SUBSTR(@[vvd], 1, 4) #if (${cvy_ref_no} != '')" ).append("\n"); 
		query.append("  AND EUR.CVY_REF_NO = @[cvy_ref_no] #end" ).append("\n"); 
		query.append("  AND EUR.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("  AND EUR.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND EUR.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND EUR.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND EUR.VSL_CD = ACT.VSL_CD(+)" ).append("\n"); 
		query.append("  AND EUR.SKD_VOY_NO = ACT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND EUR.SKD_DIR_CD = ACT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND EUR.CSTMS_PORT_CD = ACT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND ACT.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND CONV.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("  AND CONV.CSTMS_DIV_ID(+) = 'CRR_CD'" ).append("\n"); 
		query.append("  AND CONV.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND VSL.CRR_CD = CONV.ATTR_CTNT1(+)" ).append("\n"); 

	}
}