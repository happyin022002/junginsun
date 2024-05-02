/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearch315DetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.26
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.08.26 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
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
		params.put("edi_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("TO_char(sysdate , 'yyyymmdd') rcv_dt," ).append("\n"); 
		query.append("SCE_EDI_HIS_DTL_SEQ.nextval rcv_dtl_seq , " ).append("\n"); 
		query.append("VVVV.* " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    WITH A AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    DISTINCT  " ).append("\n"); 
		query.append("                   G.EDI_GRP_CD EDI_GRP_CD,  " ).append("\n"); 
		query.append("                   G.CUST_TRD_PRNR_ID cust_tp_id,  " ).append("\n"); 
		query.append("                   G.PROV_TRD_PRNR_ID host_tp_id,  " ).append("\n"); 
		query.append("                   --MAX(LPAD(E.CUST_CNT_CD,2,' ')||LPAD(E.CUST_SEQ,6,'0')) cust_cnt_cd  " ).append("\n"); 
		query.append("				   MAX(LPAD(E.CUST_CNT_CD,2,' ')||E.CUST_SEQ) cust_cnt_cd  " ).append("\n"); 
		query.append("           FROM    (  " ).append("\n"); 
		query.append("                       SELECT E.EDI_GRP_CD edi_group_cd, E.CUST_CNT_CD, E.CUST_SEQ, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG  " ).append("\n"); 
		query.append("                         FROM BKG_CUSTOMER B, EDI_GRP_CUST E, BKG_BOOKING C  " ).append("\n"); 
		query.append("                        WHERE B.BKG_NO        =  @[bkg_no]" ).append("\n"); 
		query.append("                          AND E.CUST_CNT_CD   = B.CUST_CNT_CD  " ).append("\n"); 
		query.append("                          AND E.CUST_SEQ      = B.CUST_SEQ  " ).append("\n"); 
		query.append("                          AND B.BKG_NO        = C.BKG_NO" ).append("\n"); 
		query.append("                          AND C.BB_CGO_FLG    = 'N'  " ).append("\n"); 
		query.append("                        UNION  " ).append("\n"); 
		query.append("                       SELECT E.EDI_GRP_CD edi_group_cd,  E.CUST_CNT_CD, E.CUST_SEQ, E.CGO_TRC_SVC_FLG, E.IB_SVC_FLG  " ).append("\n"); 
		query.append("                         FROM BKG_BOOKING B, EDI_GRP_CUST E  " ).append("\n"); 
		query.append("                        WHERE B.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("                          AND E.SC_NO         = DECODE(e.bkg_ctrt_div_cd,'1',b.sc_no,'2',b.rfa_no)" ).append("\n"); 
		query.append("                          AND B.BB_CGO_FLG    = 'N'  " ).append("\n"); 
		query.append("                   ) E, EDI_GROUP G  " ).append("\n"); 
		query.append("           WHERE   G.EDI_GRP_CD = E.edi_group_cd  " ).append("\n"); 
		query.append("           AND     G.DELT_FLG <> 'Y'  " ).append("\n"); 
		query.append("           AND     E.CGO_TRC_SVC_FLG <> 'N'  " ).append("\n"); 
		query.append("           AND     E.IB_SVC_FLG <> 'Y'  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("           GROUP BY G.EDI_GRP_CD,  " ).append("\n"); 
		query.append("                   G.CUST_TRD_PRNR_ID,  " ).append("\n"); 
		query.append("                   G.PROV_TRD_PRNR_ID  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , B AS (" ).append("\n"); 
		query.append("        select * from (" ).append("\n"); 
		query.append("            select '1' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD org_sts,EDI_PRE_STS_CD SEND_STS,EDI_PRE_SAV_FLG SAVE_FLG, PRE_EDI_GRP_CD edi_grp_cd" ).append("\n"); 
		query.append("            from SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("            WHERE ORG_EDI_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("            AND EDI_PRE_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '2' SRC,1,@[edi_status],@[edi_status],'' ,''" ).append("\n"); 
		query.append("            FROM  DUAL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            select '3' SRC,EDI_STS_SEQ,ORG_EDI_STS_CD,EDI_PST_STS_CD,EDI_PST_SAV_FLG, PST_EDI_GRP_CD edi_grp_cd" ).append("\n"); 
		query.append("            From SCE_EDI_MNG_STS" ).append("\n"); 
		query.append("            WHERE ORG_EDI_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("            AND EDI_PST_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT distinct 'AMS' SRC,0,M.EDI_ORG_STS_CD, M.EDI_EVNT_STS_CD,'' ,EDI_RMK1-- 추후 EDI_GRP_CD 컬럼 추가 " ).append("\n"); 
		query.append("            FROM SCE_EDI_MNG_AMS_STS M , SCE_EDI_SND_RSLT R, SCE_COP_HDR H" ).append("\n"); 
		query.append("            WHERE EDI_ORG_STS_CD = @[edi_status]" ).append("\n"); 
		query.append("            AND   R.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("            AND   R.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND   R.EDI_STS_CD IN M.EDI_PRE_SNT_STS_CD" ).append("\n"); 
		query.append("            AND   H.BKG_NO =  R.BKG_NO" ).append("\n"); 
		query.append("            AND   H.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("            AND   M.COP_IB_RAIL_CHK_CD = CASE WHEN M.EDI_EVNT_STS_CD IN ('AVN','AVL','AFL','AFN') THEN M.COP_IB_RAIL_CHK_CD   " ).append("\n"); 
		query.append("                                              ELSE SUBSTR(H.COP_RAIL_CHK_CD,2,1) " ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 'COP' SRC, 0,@[edi_status], ACT_CD ,''  ,''" ).append("\n"); 
		query.append("            FROM SCE_COP_DTL" ).append("\n"); 
		query.append("            WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("            AND   COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        order by SRC,EDI_STS_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           a.EDI_GRP_CD" ).append("\n"); 
		query.append("          ,a.HOST_TP_ID" ).append("\n"); 
		query.append("          ,a.CUST_TP_ID   " ).append("\n"); 
		query.append("          ,a.cust_cnt_cd cust_no" ).append("\n"); 
		query.append("          ,b.org_sts			org_edi_sts" ).append("\n"); 
		query.append("		  ,CASE WHEN NVL(b.SAVE_FLG,'N')    = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("                WHEN NVL(C.EDI_SND_FLG,'N') = 'N' THEN 'Y' " ).append("\n"); 
		query.append("				ELSE 'N'" ).append("\n"); 
		query.append("           END log_flg " ).append("\n"); 
		query.append("          ,c.EDI_STND_STS_CD 	EDI_STS " ).append("\n"); 
		query.append("          ,c.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("          ,c.CO_DIV_CD" ).append("\n"); 
		query.append("          ,c.EDI_EVNT_CD" ).append("\n"); 
		query.append("          ,c.EDI_VSL_TP_CD" ).append("\n"); 
		query.append("		  , case when substr(nvl(c.EDI_SND_ITVAL_HRMNT,'0'),-1,1) = 'D'" ).append("\n"); 
		query.append("            then TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, length(EDI_SND_ITVAL_HRMNT)-1)) * 24" ).append("\n"); 
		query.append("            else TO_NUMBER(SUBSTR(EDI_SND_ITVAL_HRMNT, 1, length(EDI_SND_ITVAL_HRMNT)-1))" ).append("\n"); 
		query.append("            end EDI_SND_ITVAL_HRMNT " ).append("\n"); 
		query.append("          ,EDI_CNTR_SND_TP_CD" ).append("\n"); 
		query.append("          ,c.ORG_CONTI_DESC" ).append("\n"); 
		query.append("          ,c.ORG_DEST_CNT_DESC" ).append("\n"); 
		query.append("          ,c.DEST_CONTI_DESC" ).append("\n"); 
		query.append("          ,c.DEST_CNT_DESC" ).append("\n"); 
		query.append("          ,c.edi_cgo_rmk" ).append("\n"); 
		query.append("          ,nvl(c.EDI_AUTO_SND_FLG,'N') EDI_AUTO_SND_FLG" ).append("\n"); 
		query.append("    FROM  A, B, EDI_GRP_CGO C" ).append("\n"); 
		query.append("    WHERE A.EDI_GRP_CD = C.EDI_GRP_CD" ).append("\n"); 
		query.append("    AND   B.SEND_STS = C.EDI_STND_STS_CD" ).append("\n"); 
		query.append("--	AND   NVL(C.EDI_SND_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("	AND   NVL(B.EDI_GRP_CD,A.EDI_GRP_CD) = A.EDI_GRP_CD" ).append("\n"); 
		query.append("    ORDER BY A.EDI_GRP_CD,SRC,B.EDI_STS_SEQ " ).append("\n"); 
		query.append(") VVVV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("    	(ORG_EDI_STS =  'VE' AND EDI_AUTO_SND_FLG = 'Y') OR --예) VE 로 VDL 보내는 경우" ).append("\n"); 
		query.append("    	(ORG_EDI_STS =  'VE' AND EDI_STS = 'VE') OR         --예) 그냥 VE 전송" ).append("\n"); 
		query.append("    	(ORG_EDI_STS <> 'VE')    						    --VE 전송 이외의 케이스" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${cre_usr_id} == 'APLUNET_HANES')" ).append("\n"); 
		query.append("  and cust_tp_id = 'APLUNET_HANES'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${man_flg} == 'Y')" ).append("\n"); 
		query.append("--  AND (CUST_EDI_STS_CD = [cust_status]) OR ( EDI_STS IN (SELECT EDI_PST_STS_CD FROM SCE_EDI_MNG_STS WHERE PST_EDI_GRP_CD = EDI_GRP_CD))" ).append("\n"); 
		query.append("--                               OR ( EDI_STS IN (SELECT EDI_PRE_STS_CD FROM SCE_EDI_MNG_STS WHERE PRE_EDI_GRP_CD = EDI_GRP_CD))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}