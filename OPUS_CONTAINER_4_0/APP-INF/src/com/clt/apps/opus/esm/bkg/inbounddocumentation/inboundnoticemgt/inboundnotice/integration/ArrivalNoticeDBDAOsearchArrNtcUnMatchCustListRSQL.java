/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcUnMatchCustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
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

public class ArrivalNoticeDBDAOsearchArrNtcUnMatchCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquery Arrival Notice Customer Validation Unmatch Customer List
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcUnMatchCustListRSQL(){
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
		params.put("excel_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcUnMatchCustListRSQL").append("\n"); 
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
		query.append("/* Query 복잡도를 줄이기 위해 With 사용 Global Temporary 사용안함 */" ).append("\n"); 
		query.append("WITH SUBQ AS (" ).append("\n"); 
		query.append("    SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("         , BKGM.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("         , BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("         , BKGM.POD_CD" ).append("\n"); 
		query.append("         , BKGM.DEL_CD" ).append("\n"); 
		query.append("         , BCST.VAL_NM" ).append("\n"); 
		query.append("         , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("         , BCST.CUST_SEQ" ).append("\n"); 
		query.append("         , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("         , CVAL.CUST_CNT_CD AS VAL_CUST_CNT_CD -- Validation으로 찾은 것" ).append("\n"); 
		query.append("         , CVAL.CUST_SEQ    AS VAL_CUST_SEQ    -- Validation으로 찾은 것" ).append("\n"); 
		query.append("         , CVAL.VAL_CUST_ADDR AS VAL_CUST_ADDR -- Validation으로 찾은 것 " ).append("\n"); 
		query.append("         , ROW_NUMBER () OVER (PARTITION BY BCST.BKG_NO" ).append("\n"); 
		query.append("                                          , BCST.BKG_CUST_TP_CD " ).append("\n"); 
		query.append("                               ORDER BY DECODE(CNTC.ROWID, NULL, 1, 0)   -- inbound contact person에  정보가 있는 것이 우선으로 처리된다." ).append("\n"); 
		query.append("                                      , DECODE(CVAL.CUST_CNT_CD, SUBSTR(BKGM.DEL_CD,1,2), 1, BCST.CUST_CNT_CD, 2, 3) -- 가능한 정보의 정합성이 높은 쪽으로 유도한다." ).append("\n"); 
		query.append("                                      , DECODE(ECTT.OFC_CD, NULL, 1, 0)  -- 가능한 정보가 많은 것이 선택되도록 한다." ).append("\n"); 
		query.append("                                      , DECODE(MLOC.LOC_CD, NULL, 1, 0)  -- 가능한 정보가 많은 것이 선택되도록 한다." ).append("\n"); 
		query.append("                                      , NVL(CNTC.UPD_DT,TO_DATE('19000101','YYYYMMDD'))  DESC" ).append("\n"); 
		query.append("                                      , NVL(CVAL.UPD_DT,TO_DATE('19000101','YYYYMMDD'))  DESC" ).append("\n"); 
		query.append("                                      , CNTC.ROWID " ).append("\n"); 
		query.append("                              ) ODR" ).append("\n"); 
		query.append("         , BCST.MTCH_FLG" ).append("\n"); 
		query.append("         , BCST.VAL_CD" ).append("\n"); 
		query.append("         , BCST.VAL_FAX_NO AS VAL_FAX_NO_BL" ).append("\n"); 
		query.append("         , BCST.VAL_NM AS VAL_NM_BL" ).append("\n"); 
		query.append("         , BCST.CUST_EML AS CUST_EML_BL" ).append("\n"); 
		query.append("         , BCST.CUST_FAX_NO AS CUST_FAX_NO_BL" ).append("\n"); 
		query.append("         , BCST.CUST_ADDR AS CUST_ADDR_BL" ).append("\n"); 
		query.append("         , BCST.CUST_NM AS CUST_NM_BL" ).append("\n"); 
		query.append("         , BCST.CUST_SEQ AS CUST_SEQ_BL" ).append("\n"); 
		query.append("         , BCST.CUST_CNT_CD AS CUST_CNT_CD_BL" ).append("\n"); 
		query.append("         , BKGM.BL_NO" ).append("\n"); 
		query.append("         , MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("--         , DOFC.HNDL_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("         JOIN BKG_VVD BVVD" ).append("\n"); 
		query.append("         ON ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가" ).append("\n"); 
		query.append("              AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가" ).append("\n"); 
		query.append("              AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("         JOIN VSK_VSL_PORT_SKD VSKD " ).append("\n"); 
		query.append("         ON ( BVVD.VSL_CD         = VSKD.VSL_CD " ).append("\n"); 
		query.append("              AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CD     = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         JOIN BKG_CUSTOMER BCST  -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("         ON ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("             AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("             AND (" ).append("\n"); 
		query.append("                      (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                       AND BKGM.CUST_TO_ORD_FLG = 'N' " ).append("\n"); 
		query.append("                       AND BCST.BKG_CUST_TP_CD IN ('C', 'N') " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                   OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y' " ).append("\n"); 
		query.append("                       AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                   OR (BKGM.CUST_TO_ORD_FLG = 'Y' " ).append("\n"); 
		query.append("                       AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("             AND BCST.MTCH_FLG = 'N' -- Not Auto Match" ).append("\n"); 
		query.append("             AND (   BCST.VAL_CD IS NULL -- Not Execute Manual Validation" ).append("\n"); 
		query.append("                  OR BCST.VAL_CD = 'X' -- Auto-Cancel된 것은 Un-Match Customer List에 조회되어야 한다." ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("             AND TRIM(REPLACE(REPLACE(BCST.CUST_NM, CHR(10), ''), CHR(13), '')) IS NOT NULL -- 고객명 없으면 처리안함" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("         LEFT OUTER JOIN BKG_CUST_CD_VAL CVAL" ).append("\n"); 
		query.append("         ON (CVAL.VAL_CUST_NM = BCST.VAL_NM  -- NAME MATCH" ).append("\n"); 
		query.append("             AND CVAL.DELT_FLG = 'N' " ).append("\n"); 
		query.append("             AND NVL(CVAL.NMD_CUST_FLG, 'N')  <> 'Y')" ).append("\n"); 
		query.append("         LEFT OUTER JOIN BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("         ON (CNTC.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("             AND CNTC.CUST_CNT_CD = CVAL.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND CNTC.CUST_SEQ = CVAL.CUST_SEQ )" ).append("\n"); 
		query.append("         LEFT OUTER JOIN MDM_LOCATION MLOC" ).append("\n"); 
		query.append("         ON (MLOC.LOC_CD = BKGM.DEL_CD )" ).append("\n"); 
		query.append("         LEFT OUTER JOIN BKG_IB_CUST_CNTC ECTT" ).append("\n"); 
		query.append("         ON (ECTT.OFC_CD = MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("             AND ECTT.CUST_CNT_CD = CVAL.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND ECTT.CUST_SEQ = CVAL.CUST_SEQ )" ).append("\n"); 
		query.append("--         LEFT OUTER JOIN BKG_AN_DEST_OFC_STUP DOFC" ).append("\n"); 
		query.append("--         ON (DOFC.EQ_CTRL_OFC_CD = MLOC.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("--             AND DOFC.DEST_OFC_CNTC_CD = 'I' )" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("       AND BVVD.VSL_CD     = substr(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("       AND BVVD.SKD_VOY_NO = substr(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("       AND BVVD.SKD_DIR_CD = substr(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("       AND BVVD.POD_CD     = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("       AND VSKD.VPS_ETA_DT BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYYMMDD') " ).append("\n"); 
		query.append("                               AND (TO_DATE(@[vps_eta_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIO함L 2)" ).append("\n"); 
		query.append("       AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("       AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("       AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BKGM.POL_CD = @[pol_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RSLT AS ( " ).append("\n"); 
		query.append("    SELECT DENSE_RANK() OVER (ORDER BY SUBQ.VAL_NM" ).append("\n"); 
		query.append("                                     , SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0')" ).append("\n"); 
		query.append("                                     , SUBSTR(SUBQ.CUST_ADDR_BL, 1, 10) " ).append("\n"); 
		query.append("                                     , NVL(SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0'), SUBQ.VAL_NM)" ).append("\n"); 
		query.append("                                     , SUBQ.CUST_CNT_CD || LPAD(DECODE(SUBQ.CUST_SEQ, 0, NULL,SUBQ.CUST_SEQ) , 6, '0') " ).append("\n"); 
		query.append("                             ) AS GRP_SEQ" ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (PARTITION BY SUBQ.VAL_NM" ).append("\n"); 
		query.append("                                     , SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0')" ).append("\n"); 
		query.append("                                     , SUBSTR(SUBQ.CUST_ADDR_BL, 1, 10) " ).append("\n"); 
		query.append("                                     , NVL(SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0'), SUBQ.VAL_NM)" ).append("\n"); 
		query.append("                                     , SUBQ.CUST_CNT_CD || LPAD(DECODE(SUBQ.CUST_SEQ, 0, NULL,SUBQ.CUST_SEQ) , 6, '0') " ).append("\n"); 
		query.append("                              ORDER BY 1" ).append("\n"); 
		query.append("                             )                AS MEMBER_ODR" ).append("\n"); 
		query.append("         , COUNT(1) OVER (PARTITION BY SUBQ.VAL_NM" ).append("\n"); 
		query.append("                                     , SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0')" ).append("\n"); 
		query.append("                                     , SUBSTR(SUBQ.CUST_ADDR_BL, 1, 10) " ).append("\n"); 
		query.append("                                     , NVL(SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0'), SUBQ.VAL_NM)" ).append("\n"); 
		query.append("                                     , SUBQ.CUST_CNT_CD || LPAD(DECODE(SUBQ.CUST_SEQ, 0, NULL,SUBQ.CUST_SEQ) , 6, '0') " ).append("\n"); 
		query.append("                          ) AS MEMBER_CNT" ).append("\n"); 
		query.append("         , SUBQ.BKG_NO" ).append("\n"); 
		query.append("         , SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("         , SUBQ.BL_NO" ).append("\n"); 
		query.append("         , SUBQ.CUST_CNT_CD || LPAD(DECODE(SUBQ.CUST_SEQ, 0, NULL,SUBQ.CUST_SEQ) , 6, '0') AS MDM_CUST_CD" ).append("\n"); 
		query.append("         , MCST.CUST_LGL_ENG_NM  AS MDM_CUST_NM" ).append("\n"); 
		query.append("         , MADR.VAL_CUST_ADDR    AS MDM_CUST_ADDR" ).append("\n"); 
		query.append("         , SUBQ.CUST_CNT_CD_BL   AS BKG_CUST_CNT_CD" ).append("\n"); 
		query.append("         , SUBQ.CUST_SEQ_BL      AS BKG_CUST_SEQ" ).append("\n"); 
		query.append("         , SUBQ.CUST_NM_BL       AS BKG_CUST_NM" ).append("\n"); 
		query.append("         , SUBQ.CUST_ADDR_BL     AS BKG_CUST_ADDR" ).append("\n"); 
		query.append("         , SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0') AS VAL_CUST_CD" ).append("\n"); 
		query.append("         , VCST.CUST_LGL_ENG_NM  AS VAL_CUST_NM" ).append("\n"); 
		query.append("         , SUBQ.VAL_CUST_ADDR    AS VAL_CUST_ADDR" ).append("\n"); 
		query.append("         , SUBQ.VAL_CUST_CNT_CD || LPAD(DECODE(SUBQ.VAL_CUST_SEQ, 0, NULL,SUBQ.VAL_CUST_SEQ) , 6, '0') AS COR_CUST_CD" ).append("\n"); 
		query.append("         , SUBQ.VAL_NM" ).append("\n"); 
		query.append("      FROM SUBQ" ).append("\n"); 
		query.append("           LEFT OUTER JOIN MDM_CUSTOMER MCST     -- Booking에 입력한 코드에 대한 고객명을 얻기 위함" ).append("\n"); 
		query.append("           ON (MCST.CUST_CNT_CD = SUBQ.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND MCST.CUST_SEQ = SUBQ.CUST_SEQ  " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           LEFT OUTER JOIN BKG_CUST_CD_VAL MADR  -- Booking에 입력한 코드에 대한 주소를 얻기 위함" ).append("\n"); 
		query.append("           ON (MADR.CUST_CNT_CD = SUBQ.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND MADR.CUST_SEQ = SUBQ.CUST_SEQ  " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           LEFT OUTER JOIN MDM_CUSTOMER VCST ON" ).append("\n"); 
		query.append("              ( VCST.CUST_CNT_CD = SUBQ.VAL_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND VCST.CUST_SEQ = SUBQ.VAL_CUST_SEQ" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("     WHERE ODR = 1" ).append("\n"); 
		query.append(") -- END OF RSLT" ).append("\n"); 
		query.append("SELECT RSLT.GRP_SEQ" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2,       0, -1) AS GRP_IMG_IDX" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2,       1, DECODE(RSLT.MEMBER_CNT, 1, 1, 2)) AS LVL_CD  -- Member Count가 1이면 단독 Leaf, 아니면 Group의 Leaf" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2, GRP_SEQ, DECODE(RSLT.MEMBER_CNT, 1, RSLT.GRP_SEQ, NULL)) GRP_SEQ_VIEW" ).append("\n"); 
		query.append("     , RSLT.VAL_CUST_CD" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_NM" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2, '', RSLT.BKG_NO ) AS BKG_NO" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2, '', RSLT.BKG_CUST_TP_CD ) AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2, '', DECODE(RSLT.BKG_CUST_TP_CD, 'C', 'CNEE', 'NTFY')) AS BKG_CUST_TP_CD_VIEW" ).append("\n"); 
		query.append("     , DECODE(DMUX.RNUM, 2, '', RSLT.BL_NO ) AS BL_NO" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_CD" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_NM" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_ADDR" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_CNT_CD" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_SEQ" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_ADDR" ).append("\n"); 
		query.append("     , RSLT.VAL_CUST_NM" ).append("\n"); 
		query.append("     , RSLT.VAL_CUST_ADDR" ).append("\n"); 
		query.append("     , RSLT.COR_CUST_CD" ).append("\n"); 
		query.append("  FROM RSLT" ).append("\n"); 
		query.append("     , (SELECT ROWNUM RNUM" ).append("\n"); 
		query.append("          FROM COM_INTG_CD" ).append("\n"); 
		query.append("         WHERE ROWNUM < DECODE(@[excel_flg], 'Y', 2,3)) DMUX -- Excel일 경우 그룹 record는 나오면 안된다." ).append("\n"); 
		query.append(" WHERE DMUX.RNUM IN(1, DECODE(RSLT.MEMBER_ODR, 2, 2, 0))" ).append("\n"); 
		query.append(" ORDER BY RSLT.GRP_SEQ" ).append("\n"); 
		query.append("        , DECODE(DMUX.RNUM, 2,       0, -1) DESC" ).append("\n"); 

	}
}