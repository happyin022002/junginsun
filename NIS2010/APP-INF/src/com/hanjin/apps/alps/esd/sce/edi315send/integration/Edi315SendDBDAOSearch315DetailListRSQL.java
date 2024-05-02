/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearch315DetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearch315DetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearch315DetailListRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearch315DetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("edi_status",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearch315DetailListRSQL").append("\n"); 
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
		query.append("WITH A AS (SELECT DISTINCT  " ).append("\n"); 
		query.append("                  G.EDI_GRP_CD EDI_GRP_CD,  " ).append("\n"); 
		query.append("                  G.CUST_TRD_PRNR_ID CUST_TP_ID,  " ).append("\n"); 
		query.append("                  G.PROV_TRD_PRNR_ID HOST_TP_ID,    " ).append("\n"); 
		query.append("                  MAX(COALESCE(E.E, E.S, E.C, E.F, E.N, E.A)) CUST_CNT_CD  " ).append("\n"); 
		query.append("             FROM (SELECT E.EDI_GRP_CD EDI_GROUP_CD, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'E',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) E," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'S',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) S," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'C',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) C," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'F',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) F," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'N',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) N," ).append("\n"); 
		query.append("                          MAX(DECODE(B.BKG_CUST_TP_CD,'A',LPAD(B.CUST_CNT_CD,2,' ')||LPAD(B.CUST_SEQ,6,'0'))) A" ).append("\n"); 
		query.append("                     FROM BKG_CUSTOMER B, EDI_GRP_CUST E  " ).append("\n"); 
		query.append("                    WHERE B.BKG_NO         =  @[bkg_no]" ).append("\n"); 
		query.append("                      AND B.CUST_CNT_CD    = E.CUST_CNT_CD  " ).append("\n"); 
		query.append("                      AND B.CUST_SEQ        = E.CUST_SEQ " ).append("\n"); 
		query.append("                      AND NVL(E.BKG_CUST_TP_DESC, B.BKG_CUST_TP_CD) LIKE '%'||B.BKG_CUST_TP_CD||'%'" ).append("\n"); 
		query.append("                      GROUP BY E.EDI_GRP_CD, CGO_TRC_SVC_FLG, IB_SVC_FLG" ).append("\n"); 
		query.append("                    UNION  " ).append("\n"); 
		query.append("                   SELECT E.EDI_GRP_CD EDI_GROUP_CD, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG" ).append("\n"); 
		query.append("                          ,'','','','','',''" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING B, EDI_GRP_CUST E  " ).append("\n"); 
		query.append("                    WHERE B.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("                      AND E.SC_NO         = DECODE(E.BKG_CTRT_DIV_CD,'1',B.SC_NO,'2',B.RFA_NO)  " ).append("\n"); 
		query.append("                   ) E, EDI_GROUP G  " ).append("\n"); 
		query.append("             WHERE G.EDI_GRP_CD = E.EDI_GROUP_CD  " ).append("\n"); 
		query.append("               AND G.DELT_FLG <> 'Y'  " ).append("\n"); 
		query.append("               AND E.CGO_TRC_SVC_FLG <> 'N'  " ).append("\n"); 
		query.append("               AND E.IB_SVC_FLG <> 'Y'" ).append("\n"); 
		query.append("			 GROUP BY  G.EDI_GRP_CD, G.CUST_TRD_PRNR_ID, G.PROV_TRD_PRNR_ID   " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    , B AS (SELECT * FROM (SELECT '1' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD ORG_STS,EDI_PRE_STS_CD SEND_STS,EDI_PRE_SAV_FLG SAVE_FLG, PRE_EDI_GRP_CD EDI_GRP_CD" ).append("\n"); 
		query.append("                             FROM SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("                            WHERE ORG_EDI_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("                              AND EDI_PRE_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                              AND NVL(EDI_AUTO_SND_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT '2' SRC,1,@[edi_status],@[edi_status],'' ,''" ).append("\n"); 
		query.append("                             FROM  DUAL" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT '3' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD,EDI_PST_STS_CD,EDI_PST_SAV_FLG, PST_EDI_GRP_CD EDI_GRP_CD" ).append("\n"); 
		query.append("                             FROM SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("                            WHERE ORG_EDI_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("                              AND EDI_PST_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                              AND NVL(EDI_AUTO_SND_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT DISTINCT 'AMS' SRC,0,M.EDI_ORG_STS_CD, M.EDI_EVNT_STS_CD,'' ,M.EDI_GRP_CD-- 추후 EDI_GRP_CD 컬럼 추가 " ).append("\n"); 
		query.append("                             FROM SCE_EDI_MNG_AMS_STS M , SCE_EDI_SND_RSLT R, SCE_COP_HDR H" ).append("\n"); 
		query.append("                            WHERE EDI_ORG_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("                              AND R.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                              AND R.CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("                              AND R.EDI_STS_CD IN M.EDI_PRE_SNT_STS_CD" ).append("\n"); 
		query.append("							  AND NVL2(M.EDI_GRP_CD, R.EDI_GRP_CD, '1') = NVL2(M.EDI_GRP_CD, M.EDI_GRP_CD, '1') -- AV Logic 수정 (2014.12.23)" ).append("\n"); 
		query.append("                              AND H.BKG_NO =  R.BKG_NO" ).append("\n"); 
		query.append("                              AND H.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("                              AND COP_IB_RAIL_CHK_CD = SUBSTR(H.COP_RAIL_CHK_CD,2,1)" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT 'COP' SRC, 0,@[edi_status], ACT_CD ,''  ,''" ).append("\n"); 
		query.append("                             FROM SCE_COP_DTL" ).append("\n"); 
		query.append("                            WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                              AND COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("            ORDER BY SRC,EDI_STS_SEQ" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      -- 2013.01.31 자동전송 EDI STATUS 에 다른 EDI STATUS 자동전송 기능 추가 " ).append("\n"); 
		query.append("      , D AS (SELECT * FROM (SELECT '4' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD ORG_STS,EDI_PRE_STS_CD SEND_STS,EDI_PRE_SAV_FLG SAVE_FLG, PRE_EDI_GRP_CD EDI_GRP_CD" ).append("\n"); 
		query.append("                               FROM SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("                              WHERE NVL(EDI_AUTO_SND_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                                AND EDI_PRE_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT '5' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD,EDI_PST_STS_CD,EDI_PST_SAV_FLG, PST_EDI_GRP_CD EDI_GRP_CD" ).append("\n"); 
		query.append("                               FROM SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("                              WHERE NVL(EDI_AUTO_SND_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                                AND EDI_PST_STS_CD IS NOT NULL                           " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("               ORDER BY SRC,EDI_STS_SEQ" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("SELECT TO_CHAR(SYSDATE , 'YYYYMMDD') RCV_DT" ).append("\n"); 
		query.append("     , SCE_EDI_HIS_DTL_SEQ.NEXTVAL RCV_DTL_SEQ" ).append("\n"); 
		query.append("     , TAG.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT ORG.* " ).append("\n"); 
		query.append("         FROM (SELECT A.EDI_GRP_CD" ).append("\n"); 
		query.append("                    , A.HOST_TP_ID" ).append("\n"); 
		query.append("                    , A.CUST_TP_ID   " ).append("\n"); 
		query.append("                    , A.CUST_CNT_CD CUST_NO" ).append("\n"); 
		query.append("                    , B.ORG_STS			ORG_EDI_STS" ).append("\n"); 
		query.append("                    , CASE WHEN NVL(B.SAVE_FLG,'N')    = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("                           WHEN NVL(C.EDI_SND_FLG,'N') = 'N' THEN 'Y' " ).append("\n"); 
		query.append("                           ELSE 'N'" ).append("\n"); 
		query.append("                      END LOG_FLG " ).append("\n"); 
		query.append("                   , C.EDI_STND_STS_CD 	EDI_STS " ).append("\n"); 
		query.append("                   , C.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("                   , C.CO_DIV_CD" ).append("\n"); 
		query.append("                   , C.EDI_EVNT_CD" ).append("\n"); 
		query.append("                   , C.EDI_VSL_TP_CD" ).append("\n"); 
		query.append("                   , CASE WHEN SUBSTR(NVL(C.EDI_SND_ITVAL_HRMNT,'0'),-1,1) = 'D'" ).append("\n"); 
		query.append("                            THEN TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, LENGTH(EDI_SND_ITVAL_HRMNT)-1)) * 24" ).append("\n"); 
		query.append("                          ELSE TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, LENGTH(EDI_SND_ITVAL_HRMNT)-1))" ).append("\n"); 
		query.append("                     END EDI_SND_ITVAL_HRMNT " ).append("\n"); 
		query.append("                   , EDI_CNTR_SND_TP_CD" ).append("\n"); 
		query.append("                   , C.ORG_CONTI_DESC" ).append("\n"); 
		query.append("                   , C.ORG_DEST_CNT_DESC" ).append("\n"); 
		query.append("                   , C.DEST_CONTI_DESC" ).append("\n"); 
		query.append("                   , C.DEST_CNT_DESC" ).append("\n"); 
		query.append("                   , C.EDI_CGO_RMK" ).append("\n"); 
		query.append("                   , NVL(C.EDI_AUTO_SND_FLG,'N') EDI_AUTO_SND_FLG" ).append("\n"); 
		query.append("                   , NVL(C.STS_SND_TP_CD,'1') STS_SND_TP_CD" ).append("\n"); 
		query.append("               FROM A, B, EDI_GRP_CGO C" ).append("\n"); 
		query.append("              WHERE A.EDI_GRP_CD = C.EDI_GRP_CD" ).append("\n"); 
		query.append("                AND B.SEND_STS = C.EDI_STND_STS_CD" ).append("\n"); 
		query.append("          --	AND NVL(C.EDI_SND_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("                AND NVL(B.EDI_GRP_CD,A.EDI_GRP_CD) = A.EDI_GRP_CD" ).append("\n"); 
		query.append("              ORDER BY A.EDI_GRP_CD,B.SRC,B.EDI_STS_SEQ " ).append("\n"); 
		query.append("              ) ORG" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("                (ORG_EDI_STS =  'VE' AND EDI_AUTO_SND_FLG = 'Y') OR --예) VE 로 VDL 보내는 경우" ).append("\n"); 
		query.append("                (ORG_EDI_STS =  'VE' AND EDI_STS = 'VE') OR         --예) 그냥 VE 전송" ).append("\n"); 
		query.append("                (ORG_EDI_STS <> 'VE')    						    --VE 전송 이외의 케이스" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#if (${cre_usr_id} == 'APLUNET_HANES')" ).append("\n"); 
		query.append("	       and cust_tp_id = 'APLUNET_HANES'" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- 2013.01.31 자동전송 EDI STATUS 에 다른 EDI STATUS 자동전송 기능 추가  " ).append("\n"); 
		query.append("        SELECT AUT.* " ).append("\n"); 
		query.append("         FROM (SELECT A.EDI_GRP_CD" ).append("\n"); 
		query.append("                    , A.HOST_TP_ID" ).append("\n"); 
		query.append("                    , A.CUST_TP_ID   " ).append("\n"); 
		query.append("                    , A.CUST_CNT_CD CUST_NO" ).append("\n"); 
		query.append("                    , D.ORG_STS			ORG_EDI_STS" ).append("\n"); 
		query.append("                    , CASE WHEN NVL(D.SAVE_FLG,'N')    = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("                           WHEN NVL(C.EDI_SND_FLG,'N') = 'N' THEN 'Y' " ).append("\n"); 
		query.append("                           ELSE 'N'" ).append("\n"); 
		query.append("                      END LOG_FLG " ).append("\n"); 
		query.append("                   , C.EDI_STND_STS_CD 	EDI_STS " ).append("\n"); 
		query.append("                   , C.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("                   , C.CO_DIV_CD" ).append("\n"); 
		query.append("                   , C.EDI_EVNT_CD" ).append("\n"); 
		query.append("                   , C.EDI_VSL_TP_CD" ).append("\n"); 
		query.append("                   , CASE WHEN SUBSTR(NVL(C.EDI_SND_ITVAL_HRMNT,'0'),-1,1) = 'D'" ).append("\n"); 
		query.append("                            THEN TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, LENGTH(EDI_SND_ITVAL_HRMNT)-1)) * 24" ).append("\n"); 
		query.append("                          ELSE TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, LENGTH(EDI_SND_ITVAL_HRMNT)-1))" ).append("\n"); 
		query.append("                     END EDI_SND_ITVAL_HRMNT " ).append("\n"); 
		query.append("                   , EDI_CNTR_SND_TP_CD" ).append("\n"); 
		query.append("                   , C.ORG_CONTI_DESC" ).append("\n"); 
		query.append("                   , C.ORG_DEST_CNT_DESC" ).append("\n"); 
		query.append("                   , C.DEST_CONTI_DESC" ).append("\n"); 
		query.append("                   , C.DEST_CNT_DESC" ).append("\n"); 
		query.append("                   , C.EDI_CGO_RMK" ).append("\n"); 
		query.append("                   , NVL(C.EDI_AUTO_SND_FLG,'N') EDI_AUTO_SND_FLG" ).append("\n"); 
		query.append("                   , NVL(C.STS_SND_TP_CD,'1') STS_SND_TP_CD" ).append("\n"); 
		query.append("               FROM A, B, EDI_GRP_CGO C, D" ).append("\n"); 
		query.append("              WHERE A.EDI_GRP_CD = D.EDI_GRP_CD" ).append("\n"); 
		query.append("                AND C.EDI_GRP_CD = D.EDI_GRP_CD" ).append("\n"); 
		query.append("                AND B.SRC IN ('AMS')" ).append("\n"); 
		query.append("                AND D.SEND_STS = C.EDI_STND_STS_CD" ).append("\n"); 
		query.append("                AND B.SEND_STS = D.ORG_STS" ).append("\n"); 
		query.append("          --	AND NVL(C.EDI_SND_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("              ORDER BY A.EDI_GRP_CD,D.SRC,D.EDI_STS_SEQ " ).append("\n"); 
		query.append("              ) AUT" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("                (ORG_EDI_STS =  'VE' AND EDI_AUTO_SND_FLG = 'Y') OR --예) VE 로 VDL 보내는 경우" ).append("\n"); 
		query.append("                (ORG_EDI_STS =  'VE' AND EDI_STS = 'VE') OR         --예) 그냥 VE 전송" ).append("\n"); 
		query.append("                (ORG_EDI_STS <> 'VE')    						    --VE 전송 이외의 케이스" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#if (${cre_usr_id} == 'APLUNET_HANES')" ).append("\n"); 
		query.append("	       and cust_tp_id = 'APLUNET_HANES'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) TAG" ).append("\n"); 

	}
}