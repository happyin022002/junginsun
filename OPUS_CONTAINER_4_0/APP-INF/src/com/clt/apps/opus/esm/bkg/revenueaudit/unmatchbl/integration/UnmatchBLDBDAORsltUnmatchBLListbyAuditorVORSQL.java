/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2010.10.29 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    unmatch bl list by auditor
	  * </pre>
	  */
	public UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rater_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_stl_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO                  ," ).append("\n"); 
		query.append("        UMCH_BKG_SEQ            ," ).append("\n"); 
		query.append("        RT_APLY_DT              ," ).append("\n"); 
		query.append("        RCT_RHQ_CD              ," ).append("\n"); 
		query.append("        BKG_OFC_CD              ," ).append("\n"); 
		query.append("        VVD_CD                  ," ).append("\n"); 
		query.append("        BL_NO                   ," ).append("\n"); 
		query.append("        SC_RFA_NO               ," ).append("\n"); 
		query.append("        DECODE(CTRT_TP_CD, 'R', 'RFA', 'S', 'S/C', 'TAA')  CTRT_TP_CD , --異붽?" ).append("\n"); 
		query.append("        UMCH_A                  ," ).append("\n"); 
		query.append("		UMCH_Al                  ," ).append("\n"); 
		query.append("		UMCH_All                  ," ).append("\n"); 
		query.append("		DECODE(REV_AUD_STS_CD,'S','',TRIM(TO_CHAR(sysdate - TO_DATE(N1ST_UMCH_FND_DT,'YYYY-MM-DD'),'999999'))) ERROR_LAPSE, --異붽?" ).append("\n"); 
		query.append("        UMCH_B                  ," ).append("\n"); 
		query.append("        UMCH_C                  ," ).append("\n"); 
		query.append("        UMCH_D                  ," ).append("\n"); 
		query.append("        UMCH_E                  ," ).append("\n"); 
		query.append("        UMCH_F                  ," ).append("\n"); 
		query.append("        BKG_CONTRACT            ," ).append("\n"); 
		query.append("        DIFF_USD_AMT            ," ).append("\n"); 
		query.append("        RDN_NO                  ," ).append("\n"); 
		query.append("		(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	     FROM COM_INTG_CD_DTL, BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   AND INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("		   AND INTG_CD_VAL_CTNT = A.RDN_STS_CD" ).append("\n"); 
		query.append("		   AND A.RDN_NO = J.RDN_NO" ).append("\n"); 
		query.append("		   AND A.RVIS_SEQ = (SELECT MAX(RVIS_SEQ) FROM BKG_REV_DR_NOTE K" ).append("\n"); 
		query.append("							 WHERE K.RDN_NO = A.RDN_NO)" ).append("\n"); 
		query.append("		) RDN_STATUS," ).append("\n"); 
		query.append("        (SELECT " ).append("\n"); 
		query.append("          MIN (TO_CHAR(VSK.VPS_ETD_DT,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSK, BKG_BOOKING BK" ).append("\n"); 
		query.append("		  WHERE 1=1" ).append("\n"); 
		query.append("		  AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("		  AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		  AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		  AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		  AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("	      AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		  AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("          AND BK.BKG_NO = J.BKG_NO" ).append("\n"); 
		query.append("		  AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("         ) POL_ETD," ).append("\n"); 
		query.append("        REV_AUD_STS_CD          ," ).append("\n"); 
		query.append("        REV_AUD_STS_NM          ," ).append("\n"); 
		query.append("        REV_AUD_STL_KND_CD      ," ).append("\n"); 
		query.append("        REV_AUD_STL_KND_NM      ," ).append("\n"); 
		query.append("        UMCH_RSN_RMK            ," ).append("\n"); 
		query.append("        RGN_GRP_AVC_RMK         ," ).append("\n"); 
		query.append("        RATER_ID                ," ).append("\n"); 
		query.append("        BKG_CTRT_TP_CD          ," ).append("\n"); 
		query.append("        AUTO_RAT_FLG            ," ).append("\n"); 
		query.append("        N1ST_UMCH_FND_DT        ," ).append("\n"); 
		query.append("        LST_UMCH_FND_DT         ," ).append("\n"); 
		query.append("        REV_AUD_TP_CD           ," ).append("\n"); 
		query.append("        REV_AUD_TP_NM           ," ).append("\n"); 
		query.append("        UPD_DT                  ," ).append("\n"); 
		query.append("        UPD_USR_ID              ," ).append("\n"); 
		query.append("		TO_CHAR(BDR_DT,'YYYY-MM-DD')                   BDR_DT," ).append("\n"); 
		query.append("        SREP_CD                  ,				" ).append("\n"); 
		query.append("        DECODE(BDR_FLG, 'N', 'No', 'Y', 'Yes', 'No')  BDR_FLG ," ).append("\n"); 
		query.append("       -- DECODE(CONTI_CD, 'F', 'Africa', 'M', 'America', 'A','Asia','E','Europe')  CONTI_CD , --異붽?" ).append("\n"); 
		query.append("        ''  RT_APLY_DT_FROM     ," ).append("\n"); 
		query.append("        ''  RT_APLY_DT_TO       ," ).append("\n"); 
		query.append("        ''  UMCH_TP_CD          ," ).append("\n"); 
		query.append("        ''  AUDIT_SEQ_CD        ," ).append("\n"); 
		query.append("        ''  RCT_OFC_CD          ," ).append("\n"); 
		query.append("        ''  BDR_STATUS_CD       ," ).append("\n"); 
		query.append("        ''  CONTRACT_NO			," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("			WHEN ERR_CHG1 IS NOT NULL AND ERR_CHG2 IS NOT NULL THEN ERR_CHG1||','||ERR_CHG2" ).append("\n"); 
		query.append("			WHEN ERR_CHG1 IS NULL THEN ERR_CHG2" ).append("\n"); 
		query.append("			WHEN ERR_CHG2 IS NULL THEN ERR_CHG1" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("		END ERR_CHG" ).append("\n"); 
		query.append("		--DECODE(ERR_CHG1,NULL,NULL,ERR_CHG1||',')||ERR_CHG2 ERR_CHG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("--BKG_SLS_REP SLS," ).append("\n"); 
		query.append("--BKG_BL_DOC  DOC," ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("        SELECT  UB.BKG_NO           ," ).append("\n"); 
		query.append("                UB.UMCH_BKG_SEQ     ," ).append("\n"); 
		query.append("				BB.BDR_DT   BDR_DT  ," ).append("\n"); 
		query.append("				BK.OB_SREP_CD SREP_CD," ).append("\n"); 
		query.append("                TO_CHAR(BR.RT_APLY_DT,'YYYY-MM-DD') RT_APLY_DT  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT A.OFC_CD" ).append("\n"); 
		query.append("                FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                WHERE  A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                START  WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                ) RCT_RHQ_CD        ,                                       --RHQ" ).append("\n"); 
		query.append("                BK.BKG_OFC_CD       ,                                       --OFFICE" ).append("\n"); 
		query.append("                BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD   VVD_CD  ,     --VVD_CD" ).append("\n"); 
		query.append("                BK.BL_NO            ,                                       --BL_NO" ).append("\n"); 
		query.append("                DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, 'T', BK.TAA_NO)  SC_RFA_NO ," ).append("\n"); 
		query.append("                BR.BKG_CTRT_TP_CD CTRT_TP_CD  ,                             -- 怨꾩빟 TYPE" ).append("\n"); 
		query.append("                U1.A  UMCH_A       ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("				U1.A1  UMCH_Al        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("				U1.A2  UMCH_All        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U1.B  UMCH_B        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U1.C  UMCH_C        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U1.D  UMCH_D        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U1.E  UMCH_E        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U1.F  UMCH_F        ,                                       --UMCH_CODE A~F" ).append("\n"); 
		query.append("                U2.CTRT_ITM_LOG BKG_CONTRACT  ,                             --BKG_CONTRACT" ).append("\n"); 
		query.append("                UB.STL_MNL_DIFF_AMT DIFF_USD_AMT  ,                         --DFF_USD_AMT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  MAX(A.RDN_NO)" ).append("\n"); 
		query.append("                FROM    BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO  = UB.BKG_NO" ).append("\n"); 
		query.append("                ) RDN_NO            ,                                       --理쒖떊 RDN_NO" ).append("\n"); 
		query.append("                UB.REV_AUD_STS_CD   ,                                       --SETTLE CODE" ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01570' AND INTG_CD_VAL_CTNT = UB.REV_AUD_STS_CD )      REV_AUD_STS_NM      ," ).append("\n"); 
		query.append("                UB.REV_AUD_STL_KND_CD ,                                     --SETTLE DETAIL CODE" ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02134' AND INTG_CD_VAL_CTNT = UB.REV_AUD_STL_KND_CD  ) REV_AUD_STL_KND_NM  ," ).append("\n"); 
		query.append("                UB.UMCH_RSN_RMK     ,                                       --RMK BY OFFICE" ).append("\n"); 
		query.append("                UB.RGN_GRP_AVC_RMK  ,                                       --RMK BY AUDITOR" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  UPD_USR_ID" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  BKG_NO      ," ).append("\n"); 
		query.append("                                UPD_USR_ID  ," ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER( PARTITION BY BKG_NO ORDER BY UPD_DT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                        FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                AND     ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                ) RATER_ID          ,                                       --RATER_ID" ).append("\n"); 
		query.append("                BR.BKG_CTRT_TP_CD   ,   -- ??" ).append("\n"); 
		query.append("                TO_CHAR(UB.N1ST_UMCH_FND_DT , 'YYYY-MM-DD') N1ST_UMCH_FND_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(UB.LST_UMCH_FND_DT  , 'YYYY-MM-DD') LST_UMCH_FND_DT   ," ).append("\n"); 
		query.append("                UB.REV_AUD_TP_CD    ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02164' AND INTG_CD_VAL_CTNT = UB.REV_AUD_TP_CD ) REV_AUD_TP_NM ," ).append("\n"); 
		query.append("                DECODE(UB.REV_AUD_STS_CD, 'S', TO_CHAR(UB.UPD_DT,'YYYY-MM-DD')) UPD_DT          , -- ??" ).append("\n"); 
		query.append("                DECODE(UB.REV_AUD_STS_CD, 'S', UB.UPD_USR_ID)                   UPD_USR_ID      , -- ??" ).append("\n"); 
		query.append("                NVL(BB.BDR_FLG, 'N')  BDR_FLG ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                ) AUTO_RAT_FLG," ).append("\n"); 
		query.append("--                BKG_JOIN_FNC(CURSOR(SELECT CHG_CD FROM BKG_REV_UMCH_ITM_DTL A" ).append("\n"); 
		query.append("--                                    WHERE A.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("--									  AND A.UMCH_BKG_CTRT_TP_CD ='C'" ).append("\n"); 
		query.append("--									  AND A.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("--		                              AND A.UMCH_BKG_SEQ = (SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM_DTL B" ).append("\n"); 
		query.append("--        		                                            WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--                		                                      AND B.UMCH_TP_CD IN ('E','F')" ).append("\n"); 
		query.append("--															  AND B.UMCH_BKG_CTRT_TP_CD ='C'" ).append("\n"); 
		query.append("--                        		                            )" ).append("\n"); 
		query.append("--                            )) ERR_CHG" ).append("\n"); 
		query.append("				 REPLACE(REPLACE(BKG_JOIN_FNC(CURSOR(select " ).append("\n"); 
		query.append("                                        BKG_GET_TOKEN_FNC(COLUMN_VALUE ,1,']')||']' col" ).append("\n"); 
		query.append("                                        FROM TABLE(BKG_SPLIT_CLOB_FNC((select CTRT_ITM_LOG from bkg_rev_umch_itm" ).append("\n"); 
		query.append("                                        where bkg_no =UB.BKG_NO" ).append("\n"); 
		query.append("                                        and UMCH_TP_CD IN ('E')" ).append("\n"); 
		query.append("                                        and UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        ),chr(10))" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         WHERE substr(COLUMN_VALUE,1,1) ='['" ).append("\n"); 
		query.append("											  AND LENGTH(COLUMN_VALUE) =47" ).append("\n"); 
		query.append("                                        )),']',''),'[','') ERR_CHG1" ).append("\n"); 
		query.append("                  ,REPLACE(REPLACE(BKG_JOIN_FNC(CURSOR(select " ).append("\n"); 
		query.append("                                        BKG_GET_TOKEN_FNC(COLUMN_VALUE ,1,']')||']' col" ).append("\n"); 
		query.append("                                        FROM TABLE(BKG_SPLIT_CLOB_FNC((select CTRT_ITM_LOG from bkg_rev_umch_itm" ).append("\n"); 
		query.append("                                        where bkg_no =UB.BKG_NO" ).append("\n"); 
		query.append("                                        and UMCH_TP_CD IN ('F')" ).append("\n"); 
		query.append("                                        and UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        ),chr(10))" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         WHERE substr(COLUMN_VALUE,1,1) ='['" ).append("\n"); 
		query.append("                                        )),']',''),'[','') ERR_CHG2    " ).append("\n"); 
		query.append("        FROM    BKG_REV_UMCH_BKG  UB  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                BKG_RATE          BR  ," ).append("\n"); 
		query.append("                BKG_BL_DOC        BB  ," ).append("\n"); 
		query.append("				MDM_LOCATION	  POR ," ).append("\n"); 
		query.append("				MDM_LOCATION	  DEL ," ).append("\n"); 
		query.append("#if (${dt_type} == 'PCT') " ).append("\n"); 
		query.append("                BKG_VVD Z, " ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD VSK, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  BKG_NO        ," ).append("\n"); 
		query.append("                          UMCH_BKG_SEQ  ," ).append("\n"); 
		query.append("    	                  MAX(CASE WHEN UMCH_TP_CD = 'A'  THEN UMCH_TP_CD END) A ," ).append("\n"); 
		query.append("	                      MAX(CASE WHEN UMCH_TP_CD = 'A1' THEN UMCH_TP_CD END) A1 ," ).append("\n"); 
		query.append("                    	  MAX(CASE WHEN UMCH_TP_CD = 'A2' THEN UMCH_TP_CD END) A2 ," ).append("\n"); 
		query.append("                	      MAX(CASE WHEN UMCH_TP_CD = 'B'  THEN UMCH_TP_CD END) B ," ).append("\n"); 
		query.append("            	          MAX(CASE WHEN UMCH_TP_CD = 'C'  THEN UMCH_TP_CD END) C ," ).append("\n"); 
		query.append("        	              MAX(CASE WHEN UMCH_TP_CD = 'D'  THEN UMCH_TP_CD END) D ," ).append("\n"); 
		query.append("    	                  MAX(CASE WHEN UMCH_TP_CD = 'E'  THEN UMCH_TP_CD END) E ," ).append("\n"); 
		query.append("	                      MAX(CASE WHEN UMCH_TP_CD = 'F'  THEN UMCH_TP_CD END) F" ).append("\n"); 
		query.append("                FROM    BKG_REV_UMCH_ITM  U1" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                #if (${bl_no} != '')" ).append("\n"); 
		query.append("                AND     BKG_NO        LIKE @[bl_no] || '%'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                AND     EXISTS  (" ).append("\n"); 
		query.append("                                SELECT  'X'" ).append("\n"); 
		query.append("                                FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("                                WHERE   BK.BKG_NO     = U1.BKG_NO" ).append("\n"); 
		query.append("                                AND     BK.VSL_CD     LIKE SUBSTR(@[vvd_cd],1,4) || '%'" ).append("\n"); 
		query.append("                                AND     BK.SKD_VOY_NO LIKE SUBSTR(@[vvd_cd],5,4) || '%'" ).append("\n"); 
		query.append("                                AND     BK.SKD_DIR_CD LIKE SUBSTR(@[vvd_cd],9,1) || '%'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                        BKG_NO, UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                ) U1  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  BKG_NO        ," ).append("\n"); 
		query.append("                        UMCH_BKG_SEQ  ," ).append("\n"); 
		query.append("                        REPLACE(LTRIM(SYS_CONNECT_BY_PATH(CTRT_ITM_LOG,'^|^'),'^|^'), '^|^', CHR(10)||CHR(10)) CTRT_ITM_LOG" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT   /*+ USE_NL(U2 UB) */" ).append("\n"); 
		query.append("								U2.BKG_NO        ," ).append("\n"); 
		query.append("                                U2.UMCH_BKG_SEQ  ," ).append("\n"); 
		query.append("                                '( Error Kind ' || UMCH_TP_CD || ' )' || CHR(10) || CTRT_ITM_LOG  CTRT_ITM_LOG ," ).append("\n"); 
		query.append("                                ROW_NUMBER()  OVER ( PARTITION BY U2.BKG_NO, U2.UMCH_BKG_SEQ ORDER BY UMCH_TP_CD  ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                                COUNT(1)      OVER ( PARTITION BY U2.BKG_NO, U2.UMCH_BKG_SEQ                      ) CNT" ).append("\n"); 
		query.append("                        FROM    BKG_REV_UMCH_ITM  U2, BKG_REV_UMCH_BKG UB" ).append("\n"); 
		query.append("                            #if (${dt_type} == 'PCT') " ).append("\n"); 
		query.append("                                   , BKG_VVD Z, VSK_VSL_PORT_SKD VSK, BKG_BOOKING BK" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("						  AND U2.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("                          AND U2.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("						#if (${rt_aply_dt_from} != '')" ).append("\n"); 
		query.append("						  	AND     UB.N1ST_UMCH_FND_DT >= TO_DATE(@[rt_aply_dt_from],'YYYY/MM/DD')" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("				        #if (${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("					        AND     UB.N1ST_UMCH_FND_DT <= TO_DATE(@[rt_aply_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                           AND U2.BKG_NO=Z.BKG_NO" ).append("\n"); 
		query.append("                           AND VSK.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("						   AND VSK.SKD_VOY_NO = Z.SKD_VOY_NO" ).append("\n"); 
		query.append("						   AND VSK.SKD_DIR_CD = Z.SKD_DIR_CD" ).append("\n"); 
		query.append("						   AND VSK.CLPT_IND_SEQ = Z.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("						   AND VSK.VPS_PORT_CD = Z.POL_CD" ).append("\n"); 
		query.append("					       AND Z.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("						   AND Z.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("						   AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("					       --AND Z.VSL_PRE_PST_CD||Z.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("						#if (${rt_aply_dt_from} != '')     " ).append("\n"); 
		query.append("	   					    AND    VSK.VPS_ETD_DT      >=  TO_DATE(@[rt_aply_dt_from],'yyyy-mm-dd')" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${rt_aply_dt_to} != '') " ).append("\n"); 
		query.append("	     					AND    VSK.VPS_ETD_DT      <=  TO_DATE(@[rt_aply_dt_to],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("						#end   " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("			    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if (${bl_no} != '')" ).append("\n"); 
		query.append("                        AND     UB.BKG_NO        LIKE @[bl_no] || '%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                        AND     EXISTS  (" ).append("\n"); 
		query.append("                                        SELECT  'X'" ).append("\n"); 
		query.append("                                        FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("                                        WHERE   BK.BKG_NO     = U2.BKG_NO" ).append("\n"); 
		query.append("                                        AND     BK.VSL_CD     LIKE SUBSTR(@[vvd_cd],1,4) || '%'" ).append("\n"); 
		query.append("                                        AND     BK.SKD_VOY_NO LIKE SUBSTR(@[vvd_cd],5,4) || '%'" ).append("\n"); 
		query.append("                                        AND     BK.SKD_DIR_CD LIKE SUBSTR(@[vvd_cd],9,1) || '%'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE   LEVEL       = CNT" ).append("\n"); 
		query.append("                START WITH" ).append("\n"); 
		query.append("                        ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                CONNECT BY" ).append("\n"); 
		query.append("                        BKG_NO        = PRIOR BKG_NO" ).append("\n"); 
		query.append("                AND     UMCH_BKG_SEQ  = PRIOR UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                AND     ROW_NUMBER    = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("                ) U2" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("        AND     BR.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BB.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     U1.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("        AND     U1.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("        AND     U2.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("        AND     U2.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("		AND     BK.POR_CD 		= POR.LOC_CD" ).append("\n"); 
		query.append("		AND     BK.DEL_CD 		= DEL.LOC_CD" ).append("\n"); 
		query.append("		AND     POR.DELT_FLG ='N'" ).append("\n"); 
		query.append("		AND     DEL.DELT_FLG ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${conti_cd} != '')" ).append("\n"); 
		query.append("			AND POR.CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${conti_cd2} != '')" ).append("\n"); 
		query.append("			AND DEL.CONTI_CD = @[conti_cd2]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${audit_seq_cd} == 'P')" ).append("\n"); 
		query.append("        AND     ( UB.BKG_NO, UB.UMCH_BKG_SEQ )  IN" ).append("\n"); 
		query.append("                ( SELECT BKG_NO, MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM GROUP BY BKG_NO )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	#if (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("						#if (${rt_aply_dt_from} != '')" ).append("\n"); 
		query.append("						  	AND     UB.N1ST_UMCH_FND_DT >= TO_DATE(@[rt_aply_dt_from],'YYYY/MM/DD')" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("				        #if (${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("					        AND     UB.N1ST_UMCH_FND_DT <= TO_DATE(@[rt_aply_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("	    AND U2.BKG_NO=Z.BKG_NO" ).append("\n"); 
		query.append("		AND UB.BKG_NO = Z.BKG_NO" ).append("\n"); 
		query.append("        AND VSK.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("	    AND VSK.SKD_VOY_NO = Z.SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND VSK.SKD_DIR_CD = Z.SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND VSK.CLPT_IND_SEQ = Z.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	    AND VSK.VPS_PORT_CD = Z.POL_CD" ).append("\n"); 
		query.append("		AND Z.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		AND Z.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("		AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("		--AND Z.VSL_PRE_PST_CD||Z.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("						#if (${rt_aply_dt_from} != '')     " ).append("\n"); 
		query.append("	   				    AND    VSK.VPS_ETD_DT      >=  TO_DATE(@[rt_aply_dt_from],'yyyy-mm-dd')" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${rt_aply_dt_to} != '') " ).append("\n"); 
		query.append("	     					AND    VSK.VPS_ETD_DT      <=  TO_DATE(@[rt_aply_dt_to],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rev_aud_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     UB.REV_AUD_STS_CD     = @[rev_aud_sts_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rev_aud_stl_knd_cd} != '')" ).append("\n"); 
		query.append("        AND     UB.REV_AUD_STL_KND_CD = @[rev_aud_stl_knd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rct_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD         = @[rct_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND     BK.BL_NO        LIKE @[bl_no] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.VSL_CD             LIKE SUBSTR(@[vvd_cd],1,4) || '%'" ).append("\n"); 
		query.append("        AND     BK.SKD_VOY_NO         LIKE SUBSTR(@[vvd_cd],5,4) || '%'" ).append("\n"); 
		query.append("        AND     BK.SKD_DIR_CD         LIKE SUBSTR(@[vvd_cd],9,1) || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     BR.BKG_CTRT_TP_CD     = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) J" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${umch_tp_cd} == 'N')" ).append("\n"); 
		query.append("AND     ( UMCH_A = 'A' OR UMCH_Al = 'A1' OR UMCH_All = 'A2' OR UMCH_B = 'B' OR UMCH_C = 'C' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${umch_tp_cd} == 'R')" ).append("\n"); 
		query.append("AND     ( UMCH_D = 'D' OR UMCH_E = 'E' OR UMCH_F = 'F' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("AND     RCT_RHQ_CD      = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contract_no} != '')" ).append("\n"); 
		query.append("AND     SC_RFA_NO       LIKE @[contract_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rater_id} != '')" ).append("\n"); 
		query.append("AND     RATER_ID        LIKE @[rater_id] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bdr_status_cd} != '')" ).append("\n"); 
		query.append("AND     BDR_FLG         = @[bdr_status_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auto_rat_flg} != '')" ).append("\n"); 
		query.append("AND     AUTO_RAT_FLG    = @[auto_rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '') " ).append("\n"); 
		query.append("AND ERR_CHG1||ERR_CHG2 LIKE '%'|| @[chg_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        N1ST_UMCH_FND_DT  ," ).append("\n"); 
		query.append("        LST_UMCH_FND_DT" ).append("\n"); 

	}
}