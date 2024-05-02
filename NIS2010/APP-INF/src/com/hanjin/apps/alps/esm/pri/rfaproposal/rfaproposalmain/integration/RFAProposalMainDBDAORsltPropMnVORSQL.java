/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPropMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인권자, 대표 승인권자 같음
	  * 2011.11.22 [CHM-201114664] 이석준 RFA에 SELCGS에 Retroactive request에 대한 소급 승인권한 부여
	  * 2013.01.18 [CHM-201322557] 전윤주 9002662 ID 소급 권한 추가
	  * 2013.02.13 [CHM-201323025] 전윤주 8600591 ID 소급 권한 추가
	  * 2013.06.07 [CHM-201325078] 송호진 HAMUKG, SINWKG, NYCNKG 조직 코드 변경에 따른 수정
	  * ( HAMRUC, SINRSC, NYCRAC ) 
	  * 2013.06.14 [CHM-201325245] 송호진 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가
	  * 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
	  * 2013.06.27 [CHM-201325462] 송호진 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
	  * 2013.07.17 [CHM-201326000] 송호진 9700304 ID 소급 권한 추가
	  * 2014.01.09 [CHM-201428346] 전윤주 RFA 소급 승인 권한 요청 (9500460 제외, 9700091 추가)
	  * 2014.01.09 [CHM-201428351] 전윤주 가상 조직이 추가되어도 소급권한은 SELSC, TYOSC, SELCCI에 있기 때문에 소급권한 하드코딩에 추가
	  * 2014.01.20 [CHM-201428569] 서미진 ISTEB 소급 권한 추가
	  * 2014.03.06 [CHM-201429255] 서미진 hjse07031, staceyk ID 소급 권한 추가
	  * 2014.03.26 [CHM-201429548] 전윤주 SELSC, TYOSC 소급권한 회수
	  * 2014.06.26 [CHM-201430855] 최성환 RFA 소급건 관리 강화 관련 요청(RATE의 변경이 없더라도 EFF DATE가 CREATION DATE보다 빠른 경우에는 retroactive로 인식하도록 변경)
	  * 2015.01.26 [CHM-201533831] 최성환 Retro-active RFA 승인 권한 요청 - ID : 9100735
	  * 2015.01.26 [CHM-201533953] 최성환 Retro-active RFA 승인 권한 보유 목록 정리
	  * [OFFICE 기준] - Delete 대상 : "SELCGM" "SINRS"
	  * [USER ID 기준]- Delete 대상 : "04993047" "hjse01837" "9303060" "9303295" "9300060" "8600591"- Add 대상 : "9100735" (기요청) "9500455"
	  * 2015.07.15 [CHM-201536747] 전지예 Retro RFA 승인권한자 제한 하드코팅 권한상실 : ISTEB / 권한추가 : NYCWP, NYCMW
	  * 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 2015.08.26 [CHM-201537639] Retro RFA 승인권한자 제한 하드코팅 >> 요청 USER ID삭제 Requested by Hyung-Jun Kim
	  * 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
	  * 2016.01.06 [CHM-201539614] Retro RFA 승인 권한 부여 하드 코딩 요청 Requested by SELCMI / Aram Kim
	  * 2016.04.06 [CHM-201641037] Retro RFA 승인 권한 하드 코딩 요청 Request By SELCMI / Aram Kim
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropMnVORSQL").append("\n"); 
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
		query.append("WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO " ).append("\n"); 
		query.append("         , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("       , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("    AND   HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT HDR.RFA_NO" ).append("\n"); 
		query.append("      ,HDR.MST_RFA_NO" ).append("\n"); 
		query.append("      ,HDR.MST_AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ - 1 PRE_AMDT_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(DUR.CTRT_EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,CASE WHEN DUR.CTRT_EFF_DT = TO_DATE('99991231','YYYYMMDD') AND DUR.CTRT_EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(DUR.CTRT_EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MN.EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END EFF_DT" ).append("\n"); 
		query.append("      ,CASE WHEN MN.EFF_DT = TO_DATE('99991231','YYYYMMDD') AND MN.EXP_DT = TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MN.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("      --,TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD') PRE_EXP_DT" ).append("\n"); 
		query.append("      ,NVL((SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN TO_CHAR(MN.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1 " ).append("\n"); 
		query.append("       ), TO_CHAR (MN.EFF_DT - 1, 'YYYYMMDD')) PRE_EXP_DT" ).append("\n"); 
		query.append("      ,NVL((    " ).append("\n"); 
		query.append("        SELECT CASE WHEN MN.EFF_DT <= N.EXP_DT THEN 'Y'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_MN N" ).append("\n"); 
		query.append("         WHERE PROP_NO = MN.PROP_NO AND AMDT_SEQ = MN.AMDT_SEQ-1" ).append("\n"); 
		query.append("        ),'N') DUR_DUP_FLG" ).append("\n"); 
		query.append("	  ,TO_CHAR (MN.FILE_DT, 'YYYYMMDD') FILE_DT" ).append("\n"); 
		query.append("      ,MN.PROP_STS_CD" ).append("\n"); 
		query.append("      ,STS_CD.INTG_CD_VAL_DP_DESC PROP_STS" ).append("\n"); 
		query.append("      ,MN.PROP_OFC_CD" ).append("\n"); 
		query.append("      ,MN.PROP_SREP_CD" ).append("\n"); 
		query.append("      ,SLS_REP1.SREP_NM PROP_SREP_NM" ).append("\n"); 
		query.append("      ,MN.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,PROG_USR.USR_NM PROP_APRO_STAFF" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.PROP_APRO_DT, 'YYYYMMDD') PROP_APRO_DT" ).append("\n"); 
		query.append("      ,TO_CHAR (MN.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	  ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM " ).append("\n"); 
		query.append("      ,MN.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST_TY.INTG_CD_VAL_DESC PRC_CTRT_CUST_TP_NM" ).append("\n"); 
		query.append("      ,MN.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("      ,SGM1.INTG_CD_VAL_DP_DESC CTRT_CUST_VAL_SGM" ).append("\n"); 
		query.append("	  ,MN.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("	  ,SLS_REP2.SREP_NM CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,MN.TGT_MVC_QTY" ).append("\n"); 
		query.append("	  ,MN.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("      ,MN.SLS_LD_NO" ).append("\n"); 
		query.append("	  ,DECODE(@[srep_cd],'','N',DECODE(PROP_OFC_CD, @[ofc_cd],'Y','N')) REQ_USR_FLG" ).append("\n"); 
		query.append("      --,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') APRO_USR_FLG" ).append("\n"); 
		query.append("      --,DECODE (SCP_MN.CNT1, AUTH.CNT2, 'Y', 'N') ALL_USR_FLG" ).append("\n"); 
		query.append("	  ,DMDT.DMDT_FT_TP_CD" ).append("\n"); 
		query.append("	,CASE MN.PROP_STS_CD" ).append("\n"); 
		query.append("		  WHEN 'I' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			  CASE NVL(PROG.SO_KUP,'N')" ).append("\n"); 
		query.append("				WHEN 'N' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("				WHEN 'Y' THEN" ).append("\n"); 
		query.append("					CASE NVL(OFC_AUTH,'N')" ).append("\n"); 
		query.append("					WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')                   " ).append("\n"); 
		query.append("					WHEN 'N' THEN  " ).append("\n"); 
		query.append("       					CASE NVL(USR_AUTH,'N')" ).append("\n"); 
		query.append("                        WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                        ELSE 'N'                     " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				END " ).append("\n"); 
		query.append("		  END APRO_USR_FLG" ).append("\n"); 
		query.append("	,CASE MN.PROP_STS_CD" ).append("\n"); 
		query.append("		  WHEN 'I' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			 CASE NVL(PROG.SO_KUP,'N')" ).append("\n"); 
		query.append("				WHEN 'N' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')" ).append("\n"); 
		query.append("				WHEN 'Y' THEN" ).append("\n"); 
		query.append("					CASE NVL(OFC_AUTH,'N')" ).append("\n"); 
		query.append("					WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2),1, 'Y', 'N')                 " ).append("\n"); 
		query.append("					WHEN 'N' THEN  " ).append("\n"); 
		query.append("       					CASE NVL(USR_AUTH,'N')" ).append("\n"); 
		query.append("                        WHEN 'Y' THEN DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                        ELSE 'N'                     " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		     END" ).append("\n"); 
		query.append("		  END ALL_USR_FLG" ).append("\n"); 
		query.append("	,NVL(SO_KUP, 'N') SO_KUP" ).append("\n"); 
		query.append("	,DECODE(SIGN(AUTH.CNT2), 1, 'Y' , 'N') COPY_AUTH" ).append("\n"); 
		query.append("	,DECODE (SIGN(AUTH.CNT2), 1, 'Y', 'N') APRO_USR_FLG_ORI" ).append("\n"); 
		query.append("	,PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append("	,PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("	,(SELECT PRC_PROP_CRE_TP_CD FROM PRI_RP_HDR WHERE MN.PROP_NO= PROP_NO) CRE_TP" ).append("\n"); 
		query.append("	, TO_CHAR(MN.UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("    , MN.RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("	  ,PRI_RP_DMDT DMDT" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL SGM1" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP1" ).append("\n"); 
		query.append("      ,MDM_SLS_REP SLS_REP2" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL CUST_TY" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("      , (SELECT   B.PROP_NO" ).append("\n"); 
		query.append("                 ,B.AMDT_SEQ" ).append("\n"); 
		query.append("                 ,COUNT (A.SVC_SCP_CD) CNT2" ).append("\n"); 
		query.append("         FROM     PRI_AUTHORIZATION A" ).append("\n"); 
		query.append("                 ,PRI_RP_SCP_MN B" ).append("\n"); 
		query.append("				 ,INPUT_PARAMS HDR" ).append("\n"); 
		query.append("         WHERE    A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND      A.USR_ID =  @[usr_id]" ).append("\n"); 
		query.append("         AND      A.PRC_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("		 AND      A.EXP_DT > SYSDATE" ).append("\n"); 
		query.append("		 AND      HDR.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("         GROUP BY B.PROP_NO" ).append("\n"); 
		query.append("                 ,B.AMDT_SEQ) AUTH" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("		SELECT A.PROP_NO" ).append("\n"); 
		query.append("    		  ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      	  	  ,A.PROP_STS_CD" ).append("\n"); 
		query.append("      		  ,B.USR_NM" ).append("\n"); 
		query.append("		FROM   PRI_RP_PROG A" ).append("\n"); 
		query.append("		      ,COM_USER B" ).append("\n"); 
		query.append("		      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE INP.PROP_NO= A.PROP_NO     " ).append("\n"); 
		query.append("	    AND   INP.AMDT_SEQ = A.AMDT_SEQ " ).append("\n"); 
		query.append("        AND    A.PROG_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("		AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("	    AND    USE_FLG = 'Y'" ).append("\n"); 
		query.append("		AND    PROP_PROG_SEQ =" ).append("\n"); 
		query.append("          				(SELECT  /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ (PROP_PROG_SEQ)" ).append("\n"); 
		query.append("           				   FROM  PRI_RP_PROG" ).append("\n"); 
		query.append("           				  WHERE  PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           					AND  AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           					AND  PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("							AND ROWNUM = 1)" ).append("\n"); 
		query.append("		) PROG_USR" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("	SELECT /*+ INDEX_DESC(A XPKPRI_RP_PROG) */ " ).append("\n"); 
		query.append("		   DECODE(AMDT.AMDT_FLG,'N','N',(" ).append("\n"); 
		query.append("		   DECODE(SIGN(TRUNC((SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', A.CRE_DT,@[ofc_cd] ) FROM DUAL)) - TRUNC(A.EFF_DT)),1,'Y','N'))) SO_KUP" ).append("\n"); 
		query.append("		  ,A.PROP_NO" ).append("\n"); 
		query.append("		  ,CASE WHEN @[ofc_cd] IN (SELECT AUTH_APRO_OFC_CD FROM PRI_AUTH_APRO_OFC WHERE PRC_CTRT_TP_CD = 'R' AND PRC_OFC_AUTH_TP_CD = 'R' AND AUTH_APRO_USE_FLG = 'Y') THEN 'Y'" ).append("\n"); 
		query.append("	   		ELSE 'N'" ).append("\n"); 
		query.append("	   		END OFC_AUTH       " ).append("\n"); 
		query.append("          ,CASE WHEN @[usr_id] IN (SELECT AUTH_APRO_USR_ID FROM PRI_AUTH_APRO_USR WHERE PRC_CTRT_TP_CD = 'R' AND PRC_USR_AUTH_TP_CD = 'R' AND AUTH_APRO_USE_FLG = 'Y') THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("            END USR_AUTH" ).append("\n"); 
		query.append("    FROM PRI_RP_MN A" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("		 SELECT INP.PROP_NO" ).append("\n"); 
		query.append("                ,INP.AMDT_SEQ" ).append("\n"); 
		query.append("                ,MAX(DECODE(RT.AMDT_SEQ,N1ST_CMNC_AMDT_SEQ,'Y','Y')) AMDT_FLG -- RATE의 변경이 없더라도 retroactive로 인식하도록 로직 변경 항상 'Y'" ).append("\n"); 
		query.append("				--,MAX(DECODE(RT.AMDT_SEQ,N1ST_CMNC_AMDT_SEQ,'Y','N')) AMDT_FLG" ).append("\n"); 
		query.append("          FROM  INPUT_PARAMS INP" ).append("\n"); 
		query.append("               ,PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append("          WHERE INP.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("          AND   INP.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("          GROUP BY INP.PROP_NO,INP.AMDT_SEQ" ).append("\n"); 
		query.append("          ) AMDT" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = AMDT.PROP_NO" ).append("\n"); 
		query.append("    AND A.AMDT_SEQ = AMDT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("	)PROG" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("  SELECT ROUND(" ).append("\n"); 
		query.append("		 SUM(" ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("         WHEN SS.AMDT_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("         ELSE SS.PRS_CRNT_CM_AMT" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("         )) PRS_CRNT_CM_AMT   ," ).append("\n"); 
		query.append("         ROUND(" ).append("\n"); 
		query.append("		 SUM(" ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("    	 WHEN SS.AMDT_SEQ = 0 THEN SS.PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("    	 ELSE SS.PRS_RMN_CM_AMT" ).append("\n"); 
		query.append("    	 END" ).append("\n"); 
		query.append("    	 )) PRS_ESTM_CM_AMT" ).append("\n"); 
		query.append("FROM  PRI_RP_SCP_MN SS" ).append("\n"); 
		query.append("	 ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("WHERE INP.PROP_NO = SS.PROP_NO   " ).append("\n"); 
		query.append("AND   INP.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append(")PRS_CM" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    SLS_REP1.SREP_CD(+) = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("AND    SLS_REP2.SREP_CD(+) = MN.RESPB_SREP_CD" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("AND    STS_CD.INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("AND    DMDT.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND    DMDT.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_ID(+) = 'CD00698'" ).append("\n"); 
		query.append("AND    SGM1.INTG_CD_VAL_CTNT(+) = MN.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("AND    AUTH.PROP_NO(+) = INP.PROP_NO" ).append("\n"); 
		query.append("AND    AUTH.AMDT_SEQ(+) = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    CUST_TY.INTG_CD_ID(+)      = 'CD00697'" ).append("\n"); 
		query.append("AND    MN.PRC_CTRT_CUST_TP_CD = CUST_TY.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND    CUST.CUST_CNT_CD        = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND    CUST.CUST_SEQ           = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("AND    CUST.CNTR_DIV_FLG 	   = 'Y' " ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = PROG_USR.PROP_NO(+)" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ             = PROG_USR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND    MN.PROP_NO 			   = PROG.PROP_NO(+)" ).append("\n"); 

	}
}