/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcCustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 672-2
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcCustListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("is_validated",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcCustListRSQL").append("\n"); 
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
		query.append("/** 672-2 */" ).append("\n"); 
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("       BKGM.CHG_DP_FLG       									AS CHG_DP_FLG" ).append("\n"); 
		query.append("     , BKGM.BL_NO       										AS BL_NO   " ).append("\n"); 
		query.append("     , BKGM.BKG_CUST_TP_CD      								AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , NVL(DECODE(IS_AN,'N','N','Y'),'N')                       AS IS_AN" ).append("\n"); 
		query.append("     , DECODE(BKGM.CONTI_CD,'M',BKGM.SC_NO,'') 					AS SC_NO    -- POD의 CONTIENT 가 AMERICA인 경우에만 보여주고" ).append("\n"); 
		query.append("     , BKGM.DEL_CD      										AS DEL_CD" ).append("\n"); 
		query.append("     , BKGM.VAL_CD      										AS VAL_CD" ).append("\n"); 
		query.append("     , EVALUATION_YN      										AS EVALUATION_YN" ).append("\n"); 
		query.append("     , NVL(ANTC.VSL_INFO_SET_FLG,'N') 							AS VSL_INFO_SET_FLG --BKGM.MTCH_FLG" ).append("\n"); 
		query.append("     , BKGM.CUST_CNT_CD || DECODE(BKGM.CUST_SEQ, 0, NULL, NULL, NULL, LPAD(BKGM.CUST_SEQ, 6, '0'))  AS CUST_CD" ).append("\n"); 
		query.append("     , BKGM.CUST_CNT_CD      									AS CUST_CNT_CD" ).append("\n"); 
		query.append("     , BKGM.CUST_SEQ      										AS CUST_SEQ" ).append("\n"); 
		query.append("     , BKGM.CUST_NM      										AS CUST_NM" ).append("\n"); 
		query.append("     , BKGM.CUST_ADDR      										AS CUST_ADDR" ).append("\n"); 
		query.append("     , BKGM.CUST_FAX_NO      									AS CUST_FAX_NO" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTC1.FAX_NO)  			AS FAX1" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTC2.FAX_NO)  			AS FAX2" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTB1.FAX_NO)  			AS FAX3" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTB2.FAX_NO)  			AS FAX4" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTAN.FAX_NO)  			AS FAX5" ).append("\n"); 
		query.append("     , NVL(DTC1.FAX_SND_FLG,'Y')								AS FAX_SND_FLG1" ).append("\n"); 
		query.append("     , NVL(DTC2.FAX_SND_FLG,'Y') 								AS FAX_SND_FLG2" ).append("\n"); 
		query.append("     , NVL(DTB1.FAX_SND_FLG,'Y')  								AS FAX_SND_FLG3" ).append("\n"); 
		query.append("     , NVL(DTB2.FAX_SND_FLG,'Y')  								AS FAX_SND_FLG4" ).append("\n"); 
		query.append("     , NVL(DTAN.FAX_SND_FLG,'Y')  								AS FAX_SND_FLG5" ).append("\n"); 
		query.append("     , BKGM.CUST_EML  										    AS CUST_EML" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTC1.NTC_EML)             AS EML1 " ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTC2.NTC_EML)             AS EML2" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTB1.NTC_EML)             AS EML3" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTB2.NTC_EML)             AS EML4" ).append("\n"); 
		query.append("     , DECODE(BKGM.IB_CMDT_FLG,'1','',DTAN.NTC_EML)             AS EML5" ).append("\n"); 
		query.append("     , NVL(DTC1.EML_SND_FLG,'Y')  								AS EML_SND_FLG1" ).append("\n"); 
		query.append("     , NVL(DTC2.EML_SND_FLG,'Y')  								AS EML_SND_FLG2" ).append("\n"); 
		query.append("     , NVL(DTB1.EML_SND_FLG,'Y')  								AS EML_SND_FLG3" ).append("\n"); 
		query.append("     , NVL(DTB2.EML_SND_FLG,'Y')  								AS EML_SND_FLG4" ).append("\n"); 
		query.append("     , NVL(DTAN.EML_SND_FLG,'Y')  								AS EML_SND_FLG5" ).append("\n"); 
		query.append("     , BKGM.VSL_CD || BKGM.SKD_VOY_NO || BKGM.SKD_DIR_CD 		AS VVD" ).append("\n"); 
		query.append("     , BKGM.BKG_NO                                              AS BKG_NO" ).append("\n"); 
		query.append("     , BKGM.IS_VALIDATED                                        AS IS_VALIDATED" ).append("\n"); 
		query.append("     , BKGM.ROW_COUNT                                           AS ROW_COUNT" ).append("\n"); 
		query.append("     , BKGM.IB_CMDT_FLG                                         AS IB_CMDT_FLG" ).append("\n"); 
		query.append("     --수정용도" ).append("\n"); 
		query.append("   	 ,''                                                        AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("   	 ,''                                                        AS FAX_NO" ).append("\n"); 
		query.append("   	 ,''                                                        AS NTC_EML" ).append("\n"); 
		query.append("   	 ,''                                                        AS CRE_USR_ID" ).append("\n"); 
		query.append("     ,''                                                        AS UPD_USR_ID" ).append("\n"); 
		query.append("     , FRT_TERM_CD                                              AS FRT_TERM_CD" ).append("\n"); 
		query.append(" FROM ( SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("               BKGM.BKG_NO" ).append("\n"); 
		query.append("             , BKGM.DEL_CD" ).append("\n"); 
		query.append("             , NVL(BKGM.SC_NO,BKGM.RFA_NO) SC_NO  " ).append("\n"); 
		query.append("             ,( SELECT CONTI_CD " ).append("\n"); 
		query.append("                FROM MDM_LOCATION " ).append("\n"); 
		query.append("                WHERE LOC_CD=BKGM.POD_CD ) CONTI_CD   " ).append("\n"); 
		query.append("             , BVVD.VSL_CD " ).append("\n"); 
		query.append("             , BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("             , BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("             , BKGM.BL_NO  " ).append("\n"); 
		query.append("             , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             ,(SELECT NVL(CUST_NM||CUST_ADDR,'N') " ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("               WHERE BKG_NO=BKGM.BKG_NO AND BKG_CUST_TP_CD='A' ) IS_AN  -- ALSO NOTIFY 존재유무" ).append("\n"); 
		query.append("             , BCST.AN_SND_FLG AS IS_VALIDATED" ).append("\n"); 
		query.append("             , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("             , BCST.CUST_SEQ" ).append("\n"); 
		query.append("             , NVL(BCST.IB_CUST_NM,BCST.CUST_NM)  AS CUST_NM" ).append("\n"); 
		query.append("             , NVL(BCST.IB_CUST_ADDR,BCST.CUST_ADDR) AS CUST_ADDR" ).append("\n"); 
		query.append("             , DECODE(BCST.VAL_CD, 'X', NULL, BCST.VAL_CD) AS VAL_CD -- X(Auto-Cancel)은 Evaluation하지 않은 것으로 처리 20100201" ).append("\n"); 
		query.append("             , BCST.CUST_FAX_NO" ).append("\n"); 
		query.append("             , BCST.CUST_EML" ).append("\n"); 
		query.append("             , 'C1' CNTC_TP_C1" ).append("\n"); 
		query.append("             , 'C2' CNTC_TP_C2" ).append("\n"); 
		query.append("             , 'B1' CNTC_TP_B1" ).append("\n"); 
		query.append("             , 'B2' CNTC_TP_B2" ).append("\n"); 
		query.append("             , 'AN' CNTC_TP_AN" ).append("\n"); 
		query.append("              , BCST.CHG_DP_FLG --DECODE(NVL(BCHG.FRT_TERM_CD,'C'),'P','Y','C','N') AS CHG_DP_FLG --" ).append("\n"); 
		query.append("              , DECODE(BCST.AN_SND_FLG, 'Y', DECODE( BCST.MTCH_FLG,'Y','A', BCST.VAL_CD)  -- X(Auto-Cancel)은 AN_SND_FLG가 N이므로 변경 불필요 20100201" ).append("\n"); 
		query.append("                                           , 'No' ) AS EVALUATION_YN" ).append("\n"); 
		query.append("             , 1 AS ROW_NUM" ).append("\n"); 
		query.append("             , 1 AS ROW_COUNT" ).append("\n"); 
		query.append("             , (SELECT COUNT(1)" ).append("\n"); 
		query.append("                  FROM BKG_IB_CMDT_CNTC CMDT " ).append("\n"); 
		query.append("                 WHERE CMDT.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND CMDT.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CMDT.CUST_SEQ = BCST.CUST_SEQ" ).append("\n"); 
		query.append("                   AND CMDT.DELT_FLG ='N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ) AS IB_CMDT_FLG" ).append("\n"); 
		query.append("             , BCHG.FRT_TERM_CD AS FRT_TERM_CD" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("            , BKG_VVD BVVD" ).append("\n"); 
		query.append("            , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("            , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("            , BKG_RATE BCHG" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("          AND BVVD.VSL_CD     = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("          AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("          AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("          AND BVVD.POD_CD     = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("          AND VSKD.VPS_ETA_DT " ).append("\n"); 
		query.append("              BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                  AND TO_DATE(@[vps_eta_dt_end], 'YYYY-MM-DD') +0.99999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("          AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("          AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("          AND BKGM.DEL_CD LIKE LPAD(@[del_cd], 2, '-') || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("          AND BKGM.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_no} != '' && ${c_no} != '') " ).append("\n"); 
		query.append("          AND BKGM.SC_NO = @[s_no] || @[c_no] -- SC NO (OPTINALE 9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("          AND (UPPER(BCST.CUST_NM) like '%' || UPPER(@[cust_nm]) || '%'   -- name" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("          AND (   BCST.CUST_CNT_CD = @[cust_cnt_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("          AND (   BCST.CUST_SEQ = @[cust_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_ref_no} != '') " ).append("\n"); 
		query.append("          AND (BKGM.BKG_NO) IN (SELECT BR.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_REFERENCE BR" ).append("\n"); 
		query.append("                                 WHERE BR.BKG_REF_TP_CD = 'BKPO'" ).append("\n"); 
		query.append("                                   AND BR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                   AND BR.CUST_REF_NO_CTNT  = @[cust_ref_no]  -- 고객이 요청하는 번호 (0ptional 8)" ).append("\n"); 
		query.append("                               ) -- BKG REFERENCE NUMBER -- (OPTIONAL END )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("          AND BVVD.VSL_CD = VSKD.VSL_CD    -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("          AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND BVVD.VSL_CD = VSKD.VSL_CD(+)   -- Duration이 아닌경우에는 데이터를 추출하기 위하여 해당과 같이 처리한다. (20100106 Park Mangeon)" ).append("\n"); 
		query.append("          AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND BKGM.BKG_NO =BVVD.BKG_NO      " ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("          AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND BKGM.PST_RLY_PORT_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("          AND BKGM.BKG_STS_CD NOT IN( 'X', 'S')" ).append("\n"); 
		query.append("          AND BKGM.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("          AND BKGM.BKG_CGO_TP_CD IN ('F', 'R')                           -------- modified by 0672-01" ).append("\n"); 
		query.append("          AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("          AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("          AND (" ).append("\n"); 
		query.append("                   (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                    AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                    AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                    AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          AND NVL(BCST.VAL_CD, '*') <> 'S'  -- SKIP은 NOTICE를 발송하지 않는다. (20091229 - 심영우과장에 의함)" ).append("\n"); 
		query.append("          AND BKGM.BKG_NO = BCHG.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if ( ${frt_term_cd} == 'P')" ).append("\n"); 
		query.append("                   AND BCHG.FRT_TERM_CD = 'P' " ).append("\n"); 
		query.append("    #elseif ( ${frt_term_cd} == 'C')" ).append("\n"); 
		query.append("                   AND BCHG.FRT_TERM_CD = 'C' " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         ORDER BY BKGM.BL_NO, BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       ) BKGM" ).append("\n"); 
		query.append("     , BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("     , BKG_ARR_NTC_DTL DTC1" ).append("\n"); 
		query.append("     , BKG_ARR_NTC_DTL DTC2" ).append("\n"); 
		query.append("     , BKG_ARR_NTC_DTL DTB1" ).append("\n"); 
		query.append("     , BKG_ARR_NTC_DTL DTB2" ).append("\n"); 
		query.append("     , BKG_ARR_NTC_DTL DTAN" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${is_validated} != '') " ).append("\n"); 
		query.append("   AND IS_VALIDATED = @[is_validated]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ANTC.BKG_NO(+) = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND DTC1.BKG_NO(+)          = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND DTC1.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND DTC1.CUST_CNTC_TP_CD(+) = BKGM.CNTC_TP_C1" ).append("\n"); 
		query.append("   AND DTC2.BKG_NO(+)          = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND DTC2.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND DTC2.CUST_CNTC_TP_CD(+) = BKGM.CNTC_TP_C2 " ).append("\n"); 
		query.append("   AND DTB1.BKG_NO(+)          = BKGM.BKG_NO " ).append("\n"); 
		query.append("   AND DTB1.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND DTB1.CUST_CNTC_TP_CD(+) = BKGM.CNTC_TP_B1 " ).append("\n"); 
		query.append("   AND DTB2.BKG_NO(+)          = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND DTB2.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND DTB2.CUST_CNTC_TP_CD(+) = BKGM.CNTC_TP_B2" ).append("\n"); 
		query.append("   AND DTAN.BKG_NO(+)          = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND DTAN.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND DTAN.CUST_CNTC_TP_CD(+) = BKGM.CNTC_TP_AN" ).append("\n"); 

	}
}