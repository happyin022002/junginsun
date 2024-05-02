/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcGrpSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcGrpSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0946 조회
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcGrpSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcGrpSendListRSQL").append("\n"); 
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
		query.append("/** 0946 조회   */" ).append("\n"); 
		query.append("SELECT A" ).append("\n"); 
		query.append("     , CUST_CD" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , GUBUN" ).append("\n"); 
		query.append("     , CUST_NM" ).append("\n"); 
		query.append("     , SCH_TP" ).append("\n"); 
		query.append("     , VPS_ETA_DT_START" ).append("\n"); 
		query.append("     , VPS_ETA_DT_END" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , CUST_REF_NO" ).append("\n"); 
		query.append("     , S_NO" ).append("\n"); 
		query.append("     , C_NO" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , KNT" ).append("\n"); 
		query.append("     , CSTMS_DESC" ).append("\n"); 
		query.append("     , ETA_DT" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , ADDRESS" ).append("\n"); 
		query.append("     , IMPORTANT_NOTICE" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , BKG_CUST_TP_CD_ODR" ).append("\n"); 
		query.append("     , '' RVIS_FLG" ).append("\n"); 
		query.append("     , NVL(@[ts_flg],'N') AS TS_FLG" ).append("\n"); 
		query.append("  FROM (SELECT '' A" ).append("\n"); 
		query.append("               --검색조건" ).append("\n"); 
		query.append("             , '' AS CUST_CD" ).append("\n"); 
		query.append("             , BKGM.SC_NO      " ).append("\n"); 
		query.append("             , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("             , BCST.CUST_SEQ   " ).append("\n"); 
		query.append("             , '' AS GUBUN" ).append("\n"); 
		query.append("             , BCST.CUST_NM" ).append("\n"); 
		query.append("               --OPENER에서 넘어온것." ).append("\n"); 
		query.append("             , '' AS SCH_TP" ).append("\n"); 
		query.append("             , '' AS VPS_ETA_DT_START" ).append("\n"); 
		query.append("             , '' AS VPS_ETA_DT_END" ).append("\n"); 
		query.append("             , BKGM.POD_CD" ).append("\n"); 
		query.append("             , '' AS CUST_REF_NO" ).append("\n"); 
		query.append("             , '' AS S_NO" ).append("\n"); 
		query.append("             , '' AS C_NO" ).append("\n"); 
		query.append("               --출력데이터" ).append("\n"); 
		query.append("             , BKGM.BL_NO" ).append("\n"); 
		query.append("             , BKG_JOIN_FNC (" ).append("\n"); 
		query.append("                     CURSOR (SELECT ' ' || CNTR.CNTR_TPSZ_CD || ' X ' || COUNT(1)" ).append("\n"); 
		query.append("                               FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                              WHERE CNTR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                              GROUP BY CNTR.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("                             ) AS KNT" ).append("\n"); 
		query.append("             , BDOC.CSTMS_DESC" ).append("\n"); 
		query.append("             , VSKD.VPS_ETA_DT AS ETA_DT" ).append("\n"); 
		query.append("             , BKGM.VSL_CD || BKGM.SKD_VOY_NO || BKGM.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , BKGM.POL_CD" ).append("\n"); 
		query.append("             , BKGM.DEL_CD" ).append("\n"); 
		query.append("             , '' AS ADDRESS" ).append("\n"); 
		query.append("             , '' AS IMPORTANT_NOTICE" ).append("\n"); 
		query.append("               --기타" ).append("\n"); 
		query.append("             , BKGM.VSL_CD    " ).append("\n"); 
		query.append("             , BKGM.SKD_VOY_NO" ).append("\n"); 
		query.append("             , BKGM.SKD_DIR_CD" ).append("\n"); 
		query.append("             , BKGM.BKG_NO    " ).append("\n"); 
		query.append("             , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY BKGM.BKG_NO ORDER BY BCST.BKG_CUST_TP_CD) BKG_CUST_TP_CD_ODR" ).append("\n"); 
		query.append("          FROM BKG_BOOKING   BKGM" ).append("\n"); 
		query.append("             , BKG_VVD BVVD" ).append("\n"); 
		query.append("             , BKG_BL_DOC BDOC" ).append("\n"); 
		query.append("             , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BKGM.BKG_NO = BDOC.BKG_NO" ).append("\n"); 
		query.append("           AND BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("           AND BVVD.VSL_CD = VSKD.VSL_CD   -- TS처리" ).append("\n"); 
		query.append("           AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND BVVD.VSL_CD = VSKD.VSL_CD(+)  -- TS처리" ).append("\n"); 
		query.append("           AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND BKGM.BKG_NO =BVVD.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("                     AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     AND BKGM.PST_RLY_PORT_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND BKGM.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BKGM.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("           AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("           AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("           AND BCST.AN_SND_FLG ='Y'" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("                    (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                     AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                 OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                     AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                 OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                     AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#if (${gubun} == 'C') " ).append("\n"); 
		query.append("           AND BCST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("           AND BCST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#elseif (${gubun} == 'S') " ).append("\n"); 
		query.append("           AND (BKGM.SC_NO = @[sc_no] or BKGM.RFA_NO = @[sc_no] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND 1<>1 --조회조건없이 검색되는것을 방지" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("           AND BVVD.VSL_CD  = SUBSTR(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("           AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("           AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D')" ).append("\n"); 
		query.append("           AND VSKD.VPS_ETA_DT " ).append("\n"); 
		query.append("               BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                   AND TO_DATE(@[vps_eta_dt_end], 'YYYY-MM-DD') +0.99999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B')" ).append("\n"); 
		query.append("           AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pod_cd} != '' && ${ts_flg} != 'Y') " ).append("\n"); 
		query.append("              AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pod_cd} != '' && ${ts_flg} == 'Y') " ).append("\n"); 
		query.append("              AND BKGM.PST_RLY_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("           AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND BKGM.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("           AND BCST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("           AND BCST.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("           AND UPPER(BCST.CUST_NM) LIKE UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_ref_no} != '')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                         FROM BKG_REFERENCE" ).append("\n"); 
		query.append("                        WHERE BKG_REF_TP_CD = 'BKPO'" ).append("\n"); 
		query.append("                          AND BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                          AND CUST_REF_NO_CTNT = @[cust_ref_no] " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )RSLT" ).append("\n"); 
		query.append("ORDER BY BKG_CUST_TP_CD_ODR, BL_NO , VVD" ).append("\n"); 

	}
}