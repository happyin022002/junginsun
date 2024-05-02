/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcCustListForUploadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.02.25 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcCustListForUploadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0672-3 조회
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcCustListForUploadRSQL(){
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
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcCustListForUploadRSQL").append("\n"); 
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
		query.append("SELECT CMST.BKG_NO       " ).append("\n"); 
		query.append("     , CMST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , MAX(CMST.BL_NO      ) AS BL_NO" ).append("\n"); 
		query.append("     , MAX(CMST.CUST_CNT_CD) AS CUST_CNT_CD" ).append("\n"); 
		query.append("     , MAX(CMST.CUST_SEQ   ) AS CUST_SEQ" ).append("\n"); 
		query.append("     , MAX(CMST.CUST_NM    ) AS CUST_NM" ).append("\n"); 
		query.append("     , MAX(CMST.CUST_FAX_NO) AS CUST_FAX_NO" ).append("\n"); 
		query.append("     , MAX(CMST.CUST_EML   ) AS CUST_EML" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'C2',NDTL.FAX_NO,''))  AS FAX_NO1" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'B1',NDTL.FAX_NO,''))  AS FAX_NO2" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'B2',NDTL.FAX_NO,''))  AS FAX_NO3" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'C2',NDTL.NTC_EML,'')) AS NTC_EML1" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'B1',NDTL.NTC_EML,'')) AS NTC_EML2" ).append("\n"); 
		query.append("     , MAX(DECODE(NDTL.CUST_CNTC_TP_CD,'B2',NDTL.NTC_EML,'')) AS NTC_EML3" ).append("\n"); 
		query.append("        --저장용" ).append("\n"); 
		query.append("     , '' AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("     , '' AS FAX_NO" ).append("\n"); 
		query.append("     , '' AS NTC_EML" ).append("\n"); 
		query.append("FROM ( /* ======= CMST START ========= */" ).append("\n"); 
		query.append("     SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("          , BKGM.BL_NO" ).append("\n"); 
		query.append("          , BKGM.SC_NO" ).append("\n"); 
		query.append("          , BKGM.DEL_CD" ).append("\n"); 
		query.append("          , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("          , BCST.CUST_SEQ" ).append("\n"); 
		query.append("          , BCST.CUST_NM" ).append("\n"); 
		query.append("          , BCST.CUST_FAX_NO" ).append("\n"); 
		query.append("          , BCST.CUST_EML" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("          , BKG_VVD BVVD" ).append("\n"); 
		query.append("          , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("          , BKG_CUSTOMER BCST      " ).append("\n"); 
		query.append("      WHERE 1 = 1      " ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("        AND BVVD.VSL_CD     = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("        AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("        AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("        AND BVVD.POD_CD     = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("        AND VSKD.VPS_ETA_DT " ).append("\n"); 
		query.append("            BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                AND TO_DATE(@[vps_eta_dt_end], 'YYYY-MM-DD') +0.99999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("        AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("        AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("        AND BKGM.DEL_CD LIKE LPAD(@[del_cd], 2, '-') || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("        AND BKGM.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_no} != '' && ${c_no} != '') " ).append("\n"); 
		query.append("        AND BKGM.SC_NO = @[s_no] || @[c_no] -- SC NO (OPTINALE 9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("        AND UPPER(BCST.CUST_NM) like '%' || UPPER(@[cust_nm]) || '%'   -- name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("        AND (   BCST.CUST_CNT_CD = @[cust_cnt_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("        AND (   BCST.CUST_SEQ = @[cust_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_ref_no} != '') " ).append("\n"); 
		query.append("        AND (BKGM.BKG_NO) IN (SELECT BR.BKG_NO" ).append("\n"); 
		query.append("                                FROM BKG_REFERENCE BR" ).append("\n"); 
		query.append("                               WHERE BR.BKG_REF_TP_CD = 'BKPO'" ).append("\n"); 
		query.append("                                 AND BR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                 AND BR.CUST_REF_NO_CTNT  = @[cust_ref_no]  -- 고객이 요청하는 번호 (0ptional 8)" ).append("\n"); 
		query.append("                              ) -- BKG REFERENCE NUMBER -- (OPTIONAL END )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("        AND BVVD.VSL_CD = VSKD.VSL_CD    -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("        AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND BVVD.VSL_CD = VSKD.VSL_CD(+)   -- Duration이 아닌경우에는 데이터를 추출하기 위하여 해당과 같이 처리한다. (20100106 Park Mangeon)" ).append("\n"); 
		query.append("        AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND BKGM.BKG_NO =BVVD.BKG_NO      " ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("        AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND BKGM.PST_RLY_PORT_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        AND BKGM.BKG_STS_CD NOT IN( 'X', 'S')" ).append("\n"); 
		query.append("        AND BKGM.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND BKGM.BKG_CGO_TP_CD IN ('F', 'R')                           -------- modified by 0672-01" ).append("\n"); 
		query.append("        AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("        AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("                 (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                  AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("              OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("              OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("--        AND NVL(BCST.VAL_CD, '*') <> 'S'  -- SKIP은 NOTICE를 발송하지 않는다. (20091229 - 심영우과장에 의함)" ).append("\n"); 
		query.append("        AND BCST.VAL_CD = 'N'      --------- Not Exists에 대해서 연락처 정보 처리" ).append("\n"); 
		query.append("      ) CMST /* ======= CMST END ========= */      " ).append("\n"); 
		query.append("      LEFT OUTER JOIN BKG_ARR_NTC_DTL NDTL       " ).append("\n"); 
		query.append("      ON( CMST.BKG_NO=  NDTL.BKG_NO" ).append("\n"); 
		query.append("          AND CMST.BKG_CUST_TP_CD = NDTL.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          AND NDTL.CUST_CNTC_TP_CD IN( 'C2', 'B1', 'B2')" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(" GROUP BY CMST.BKG_NO" ).append("\n"); 
		query.append("        , CMST.BKG_CUST_TP_CD" ).append("\n"); 

	}
}