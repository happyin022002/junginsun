/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpMnFileDtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.08.04 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpMnFileDtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.05.29 전윤주 [CHM-201430580] Filing 자동화 기능이 추가되어 조회 시 가져오는 정보 변경
	  * * 2014.09.13 송호진 [CHM-201430558] 반영 포함 Check Out
	  * * 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpMnFileDtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpMnFileDtVORSQL").append("\n"); 
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
		query.append("SELECT A1.PROP_NO" ).append("\n"); 
		query.append("      ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("      ,( SELECT TO_CHAR(FILE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("           FROM PRI_SP_MN" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ - 1 ) LAST_FILE_DT" ).append("\n"); 
		query.append("      ,	CASE X.FMC_FILE_MDT_FLG " ).append("\n"); 
		query.append("			WHEN 'Y' THEN " ).append("\n"); 
		query.append("				DECODE ( ( SELECT  TO_CHAR(FMC_FILE_CFM_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                  FROM    PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                  WHERE   PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                  AND     AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                  AND     FILE_PROG_SEQ = ( SELECT  MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                            FROM    PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                            WHERE   PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                            AND     AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND     FMC_FILE_TP_CD = 'S' ) )" ).append("\n"); 
		query.append("                , NULL, TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                , 'Error', TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                , TO_CHAR( A1.EFF_DT, 'YYYYMMDD') ) " ).append("\n"); 
		query.append("			WHEN 'N' THEN " ).append("\n"); 
		query.append("				TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[prop_ofc_cd]),  'YYYYMMDD') " ).append("\n"); 
		query.append("			END AS EFF_DT " ).append("\n"); 
		query.append("      --  CFM_NO 가 NULL 이거나 Error 일 때. 즉, FileContract ( Send ) 경우에만 미주 동부 시간 기본 세팅 " ).append("\n"); 
		query.append("      --, TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC'), 'YYYYMMDD') EFF_DT -- 미주 동부 시간 기본 세팅" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC'), 'YYYY-MM-DD HH24:MI') US_EST_SYS_DT --미국 동부시간 기준 잡기 위해 office 지정" ).append("\n"); 
		query.append("      ,( SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("           FROM PRI_SP_MN" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ - 1 ) PRE_EFF_DT    " ).append("\n"); 
		query.append("      ,( SELECT TO_CHAR(FMC_FILE_CFM_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'S' " ).append("\n"); 
		query.append("                                ) -- sending type 중에 가장 마지막" ).append("\n"); 
		query.append("        ) FMC_FILE_CFM_DT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      ,( SELECT CFM_NO" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'S' " ).append("\n"); 
		query.append("                                ) -- sending type 중에 가장 마지막" ).append("\n"); 
		query.append("       ) CFM_NO" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      ,( SELECT (SELECT USR_NM FROM COM_USER WHERE USR_ID = PROG.FILE_PROG_USR_ID)" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'S' " ).append("\n"); 
		query.append("                                ) -- sending type 중에 가장 마지막" ).append("\n"); 
		query.append("       ) FILE_STFF" ).append("\n"); 
		query.append("      ,( SELECT TO_CHAR(FMC_FILE_CFM_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'C' " ).append("\n"); 
		query.append("                                ) -- correction type 중에 가장 마지막" ).append("\n"); 
		query.append("       ) FNL_CT_DT" ).append("\n"); 
		query.append("      ,( SELECT CFM_NO" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'C' " ).append("\n"); 
		query.append("                                ) -- correction type 중에 가장 마지막" ).append("\n"); 
		query.append("       ) FNL_CT_CFM_NO" ).append("\n"); 
		query.append("      ,( SELECT (SELECT USR_NM FROM COM_USER WHERE USR_ID = PROG.FILE_PROG_USR_ID)" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'C' " ).append("\n"); 
		query.append("                                ) -- correction type 중에 가장 마지막" ).append("\n"); 
		query.append("           ) FNL_CT_STFF" ).append("\n"); 
		query.append("      ,( SELECT COUNT(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("          FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("         WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("           AND FMC_FILE_TP_CD = 'C' ) CT_CNT            " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      ,( SELECT FILE_CORR_CMT_CTNT" ).append("\n"); 
		query.append("           FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("          WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("            AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                  SELECT MAX(FILE_PROG_SEQ)" ).append("\n"); 
		query.append("                                    FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                   WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                     AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                     AND FMC_FILE_TP_CD = 'C' " ).append("\n"); 
		query.append("                                ) -- correction type 중에 가장 마지막" ).append("\n"); 
		query.append("        ) FILE_CORR_CMT_CTNT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      ,HOM_MLT_RTN_PKG.HOM_TBL_TO_STR_FNC( CURSOR( " ).append("\n"); 
		query.append("                                                 SELECT FMC_FILE_ERR_MSG" ).append("\n"); 
		query.append("                                                   FROM PRI_SP_FILE_ERR" ).append("\n"); 
		query.append("                                                  WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                                    AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                                    AND FILE_PROG_SEQ = (    " ).append("\n"); 
		query.append("                                                                          SELECT MAX(FILE_PROG_SEQ) -- 현재 진행된 가장 마지막 progress" ).append("\n"); 
		query.append("                                                                            FROM PRI_SP_FILE_PROG" ).append("\n"); 
		query.append("                                                                           WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                                                                             AND AMDT_SEQ = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                                                        ) " ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                                           )FMC_FILE_ERR_MSG" ).append("\n"); 
		query.append("      , TO_CHAR(A1.FILE_DT, 'YYYYMMDD')  AS FILE_DT" ).append("\n"); 
		query.append("      , X.FMC_FILE_MDT_FLG" ).append("\n"); 
		query.append("      , '' AS FILE_PROG_SEQ" ).append("\n"); 
		query.append("      , '' AS FMC_FILE_TP_CD" ).append("\n"); 
		query.append("      , '' AS FILE_EFF_DT" ).append("\n"); 
		query.append("      , '' AS FMC_FILE_SND_DT" ).append("\n"); 
		query.append("      , '' AS FILE_PROG_DT" ).append("\n"); 
		query.append("      , '' AS FILE_PROG_USR_ID" ).append("\n"); 
		query.append("      , '' AS FMC_FILE_NM" ).append("\n"); 
		query.append("      , '' AS ORZ_NO" ).append("\n"); 
		query.append("      , '' AS FMC_CTRT_NO" ).append("\n"); 
		query.append("      , '' AS FMC_AMDT_NO" ).append("\n"); 
		query.append("      , '' AS FMC_FILE_USR_ID" ).append("\n"); 
		query.append("      , '' AS FMC_FILE_SESS_ID" ).append("\n"); 
		query.append("      , '' AS FMC_NO" ).append("\n"); 
		query.append("      , '' AS FMC_EFF_DT" ).append("\n"); 
		query.append("      , '' AS FILE_SZ_CAPA" ).append("\n"); 
		query.append("      , '' AS MNL_FILE_FLG" ).append("\n"); 
		query.append("      , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("      , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_USER_NAME" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_ORG_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_CON_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_AMD_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_EFF_DATE" ).append("\n"); 
		query.append("      , '' AS ERR_CODE_FILE" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_USER_NAME" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_ORG_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_CON_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_AMD_NUM" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_EFF_DATE" ).append("\n"); 
		query.append("      , '' AS ERR_MSG_FILE" ).append("\n"); 
		query.append("      , '' AS SC_NO" ).append("\n"); 
		query.append("      , '' AS PROP_OFC_CD" ).append("\n"); 
		query.append("      , '' AS EFF_DT_CHG" ).append("\n"); 
		query.append("FROM 	PRI_SP_MN A1" ).append("\n"); 
		query.append("	,	PRI_SP_HDR H" ).append("\n"); 
		query.append("	,	PRI_SC_PFX X" ).append("\n"); 
		query.append("WHERE 	A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND 	A1.AMDT_SEQ  = @[amdt_seq]" ).append("\n"); 
		query.append("AND		A1.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("AND		SUBSTR ( H.SC_NO, 1, 3 ) = X.SC_PFX_CD" ).append("\n"); 

	}
}