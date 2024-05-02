/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchManualValInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
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

public class ArrivalNoticeDBDAOsearchManualValInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1054 code validation for manual correction
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchManualValInfoRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchManualValInfoRSQL").append("\n"); 
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
		query.append("/* Code validation 수기이행을 위해 작성된 프로그램으로 정규 프로그램이 아님 ( With 문 관리대상 아님 ) */" ).append("\n"); 
		query.append("WITH BKG_CST AS ( " ).append("\n"); 
		query.append("    SELECT SUB.BKG_NO" ).append("\n"); 
		query.append("         , SUB.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("         , SUB.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("         , SUB.POD_CD" ).append("\n"); 
		query.append("         , SUB.DEL_CD" ).append("\n"); 
		query.append("         , SUB.VAL_NM" ).append("\n"); 
		query.append("         , SUB.CUST_CNT_CD" ).append("\n"); 
		query.append("         , SUB.CUST_SEQ" ).append("\n"); 
		query.append("         , SUB.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("         , SUB.FIND_NAME_RID" ).append("\n"); 
		query.append("         , SUB.MTCH_FLG" ).append("\n"); 
		query.append("         , SUB.VAL_CD" ).append("\n"); 
		query.append("         , SUB.VAL_FAX_NO_BL" ).append("\n"); 
		query.append("         , SUB.VAL_NM_BL" ).append("\n"); 
		query.append("         , SUB.CUST_EML_BL" ).append("\n"); 
		query.append("         , SUB.CUST_FAX_NO_BL" ).append("\n"); 
		query.append("         , SUB.CUST_ADDR_BL" ).append("\n"); 
		query.append("         , SUB.CUST_NM_BL" ).append("\n"); 
		query.append("         , SUB.CUST_SEQ_BL" ).append("\n"); 
		query.append("         , SUB.CUST_CNT_CD_BL" ).append("\n"); 
		query.append("         , MCST.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("         , SUB.BL_NO" ).append("\n"); 
		query.append("         , SUB.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("         , SUB.HNDL_OFC_CD" ).append("\n"); 
		query.append("         , (SELECT ADDR.BZET_ADDR" ).append("\n"); 
		query.append("              FROM MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("             WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("               AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND ADDR.CUST_CNT_CD = SUB.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND ADDR.CUST_SEQ = SUB.CUST_SEQ" ).append("\n"); 
		query.append("               AND ROWNUM = 1 )  AS CUST_LGL_ADDR" ).append("\n"); 
		query.append("    FROM (SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("               , BKGM.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("               , BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("               , BKGM.POD_CD" ).append("\n"); 
		query.append("               , BKGM.DEL_CD" ).append("\n"); 
		query.append("               , BCST.VAL_NM" ).append("\n"); 
		query.append("               , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("               , BCST.CUST_SEQ" ).append("\n"); 
		query.append("               , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               , CVAL.ROWID FIND_NAME_RID" ).append("\n"); 
		query.append("               , ROW_NUMBER () OVER (PARTITION BY BCST.BKG_NO" ).append("\n"); 
		query.append("                                                , BCST.BKG_CUST_TP_CD " ).append("\n"); 
		query.append("                                     ORDER BY CNTC.ROWID  -- inbound contact person에  정보가 있는 것이 우선으로 처리된다." ).append("\n"); 
		query.append("                                            , DECODE(CVAL.CUST_CNT_CD, SUBSTR(BKGM.DEL_CD,1,2), 1, BCST.CUST_CNT_CD, 2, 3) -- 가능한 정보의 정합성이 높은 쪽으로 유도한다." ).append("\n"); 
		query.append("                                            , DECODE(DOFC.EQ_CTRL_OFC_CD, NULL, 1, 0)  -- 가능한 정보가 많은 것이 선택되도록 한다." ).append("\n"); 
		query.append("                                            , DECODE(MLOC.LOC_CD, NULL, 1, 0)  -- 가능한 정보가 많은 것이 선택되도록 한다." ).append("\n"); 
		query.append("                                            , CVAL.ROWID  -- 기타 다른 것은 rowid에 따라 처리한다." ).append("\n"); 
		query.append("                                    ) ODR" ).append("\n"); 
		query.append("               , BCST.VAL_CD" ).append("\n"); 
		query.append("               , BCST.VAL_FAX_NO AS VAL_FAX_NO_BL" ).append("\n"); 
		query.append("               , BCST.VAL_NM AS VAL_NM_BL" ).append("\n"); 
		query.append("               , BCST.CUST_EML AS CUST_EML_BL" ).append("\n"); 
		query.append("               , BCST.CUST_FAX_NO AS CUST_FAX_NO_BL" ).append("\n"); 
		query.append("               , BCST.CUST_ADDR AS CUST_ADDR_BL" ).append("\n"); 
		query.append("               , BCST.CUST_NM AS CUST_NM_BL" ).append("\n"); 
		query.append("               , BCST.CUST_SEQ AS CUST_SEQ_BL" ).append("\n"); 
		query.append("               , BCST.CUST_CNT_CD AS CUST_CNT_CD_BL" ).append("\n"); 
		query.append("               , BKGM.BL_NO" ).append("\n"); 
		query.append("               , MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("               , DOFC.HNDL_OFC_CD" ).append("\n"); 
		query.append("               , NVL( ( SELECT DECODE(BRAT.RT_BL_TP_CD, 'B', 'B', NULL)" ).append("\n"); 
		query.append("                          FROM BKG_RATE BRAT" ).append("\n"); 
		query.append("                         WHERE BRAT.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                     ,( SELECT 'Y' --decode(BKGM.RT_BL_TP_CD, 'B', 'COBIZ', 'AUTO')" ).append("\n"); 
		query.append("                          FROM BKG_CUST_CD_VAL BVAL -- MDM CUSTOMER VALIDATION TABLE (목적 - mdm_customer 와 동일한지  검사)" ).append("\n"); 
		query.append("                         WHERE BCST.CUST_SEQ > 0" ).append("\n"); 
		query.append("                           AND BVAL.CUST_CNT_CD = BCST.CUST_CNT_CD -- PK -- Match Case" ).append("\n"); 
		query.append("                           AND BVAL.CUST_SEQ = BCST.CUST_SEQ    -- PK" ).append("\n"); 
		query.append("                           AND 1 = CASE WHEN SUBSTR(BVAL.VAL_CUST_NM,1,10) = SUBSTR(BCST.VAL_NM, 1,10) THEN 1  " ).append("\n"); 
		query.append("                                        WHEN LENGTH(BVAL.VAL_CUST_NM) > 2   -- 한쪽에 등록된 validation name이 3자이상이고 10자 미만일 경우, 10자리로 검사하면 안잡힐 내용을 잡아준다." ).append("\n"); 
		query.append("                                             AND LENGTH(BCST.VAL_NM) > 2" ).append("\n"); 
		query.append("                                             AND  ((LENGTH(BVAL.VAL_CUST_NM) < 10 " ).append("\n"); 
		query.append("                                                  OR LENGTH(BCST.VAL_NM) < 10))" ).append("\n"); 
		query.append("                                             AND  SUBSTR(BVAL.VAL_CUST_NM,1,DECODE(SIGN(LENGTH(BVAL.VAL_CUST_NM) - LENGTH(BCST.VAL_NM)), -1, LENGTH(BVAL.VAL_CUST_NM), LENGTH(BCST.VAL_NM)))" ).append("\n"); 
		query.append("                                                = SUBSTR(BCST.VAL_NM,1,DECODE(SIGN(LENGTH(BVAL.VAL_CUST_NM) - LENGTH(BCST.VAL_NM)), -1, LENGTH(BVAL.VAL_CUST_NM), LENGTH(BCST.VAL_NM)))" ).append("\n"); 
		query.append("                                             THEN 1 " ).append("\n"); 
		query.append("                                        ELSE 0 END" ).append("\n"); 
		query.append("                           AND rownum = 1" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                    ) AS MTCH_FLG" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("               JOIN BKG_VVD BVVD" ).append("\n"); 
		query.append("               ON ( BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("                    AND BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("                    AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                    AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               JOIN BKG_BOOKING BKGM " ).append("\n"); 
		query.append("               ON ( BKGM.BKG_NO =BVVD.BKG_NO" ).append("\n"); 
		query.append("                    AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("                    AND BKGM.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                    AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("               JOIN BKG_CUSTOMER BCST  -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("               ON ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                   AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("                   AND TRIM(REPLACE(BCST.CUST_NM, CHR(10) , '')) IS NOT NULL -- 고객명 없으면 처리안함" ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("                            (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                             AND BKGM.CUST_TO_ORD_FLG = 'N' " ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD IN ('C', 'N') " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y' " ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         OR (BKGM.CUST_TO_ORD_FLG = 'Y' " ).append("\n"); 
		query.append("                             AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("              LEFT OUTER JOIN BKG_CUST_CD_VAL CVAL" ).append("\n"); 
		query.append("              ON (CVAL.VAL_CUST_NM = BCST.VAL_NM" ).append("\n"); 
		query.append("                  AND CVAL.DELT_FLG = 'N' )" ).append("\n"); 
		query.append("              LEFT OUTER JOIN BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("              ON (CNTC.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                  AND CNTC.CUST_CNT_CD = CVAL.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND CNTC.CUST_SEQ = CVAL.CUST_SEQ )" ).append("\n"); 
		query.append("              LEFT OUTER JOIN MDM_LOCATION MLOC" ).append("\n"); 
		query.append("              ON (MLOC.LOC_CD = BKGM.DEL_CD )" ).append("\n"); 
		query.append("              LEFT OUTER JOIN BKG_AN_DEST_OFC_STUP DOFC" ).append("\n"); 
		query.append("              ON (DOFC.EQ_CTRL_OFC_CD = MLOC.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("                  AND DOFC.DEST_OFC_CNTC_CD = 'I' )" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("           AND VSKD.VSL_CD  = substr(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("           AND VSKD.SKD_VOY_NO = substr(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("           AND VSKD.SKD_DIR_CD = substr(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("           AND VSKD.VPS_ETA_DT BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYYMMDD') " ).append("\n"); 
		query.append("                                   AND (TO_DATE(@[vps_eta_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} == 'B') " ).append("\n"); 
		query.append("           AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pod_cd} != '') " ).append("\n"); 
		query.append("           AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("           AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND BKGM.POL_CD = @[pol_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) SUB" ).append("\n"); 
		query.append("        LEFT OUTER JOIN MDM_CUSTOMER MCST ON" ).append("\n"); 
		query.append("           (MCST.CUST_CNT_CD = SUB.CUST_CNT_CD " ).append("\n"); 
		query.append("            AND MCST.CUST_SEQ = SUB.CUST_SEQ  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    WHERE ODR = 1" ).append("\n"); 
		query.append(") -- END OF BKG_CST" ).append("\n"); 
		query.append(", SUBQ AS (" ).append("\n"); 
		query.append("    SELECT BKGC.BKG_NO                                           -- HIDDEN(KEY)" ).append("\n"); 
		query.append("         , BKGC.BKG_CUST_TP_CD  -- FOR ARR_NTC_DTL" ).append("\n"); 
		query.append("         , BKGC.BL_NO" ).append("\n"); 
		query.append("         , BKGC.CUST_CNT_CD" ).append("\n"); 
		query.append("         , BKGC.CUST_SEQ" ).append("\n"); 
		query.append("         , BKGC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("         , BKGC.CUST_LGL_ADDR" ).append("\n"); 
		query.append("         , BKGC.CUST_CNT_CD_BL -- HIDDEN ( OUTBOUND COUNTRY CODE - BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.CUST_SEQ_BL              -- OUTBOUND CUST SEQ (BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.CUST_NM_BL               -- OUTBOUND CUSTOMER NAME (BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.CUST_ADDR_BL             -- OUTBOUND CUSTOMER ADDRESS (BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.CUST_FAX_NO_BL           -- OUTBOUND FAX (BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.CUST_EML_BL              -- OUTBOUND EMAIL (BL STAFF INPUT)" ).append("\n"); 
		query.append("         , BKGC.FIND_NAME_RID" ).append("\n"); 
		query.append("         , BKGC.DEL_CD" ).append("\n"); 
		query.append("         , BKGC.VAL_NM_BL                   -- for validation" ).append("\n"); 
		query.append("         , BKGC.VAL_FAX_NO_BL             -- for validation" ).append("\n"); 
		query.append("         , BKGC.VAL_CD" ).append("\n"); 
		query.append("         , BKGC.MTCH_FLG" ).append("\n"); 
		query.append("         , (SELECT CNTC.ROWID /*+ INDEX (CNTC XAK1BKG_IB_CUST_CNTC) */" ).append("\n"); 
		query.append("             FROM BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("                , BKG_CUST_CD_VAL CVAL" ).append("\n"); 
		query.append("             WHERE BKGC.FIND_NAME_RID IS NULL" ).append("\n"); 
		query.append("               AND CNTC.CUST_CNT_CD = BKGC.CUST_CNT_CD_BL" ).append("\n"); 
		query.append("               AND CNTC.OFC_CD IN (BKGC.EQ_CTRL_OFC_CD, BKGC.HNDL_OFC_CD, @[ofc_cd] )" ).append("\n"); 
		query.append("               AND BKGC.VAL_FAX_NO_BL = CNTC.VAL_FAX_NO" ).append("\n"); 
		query.append("               AND CVAL.CUST_CNT_CD = CNTC.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND CVAL.CUST_SEQ = CNTC.CUST_SEQ" ).append("\n"); 
		query.append("               AND CVAL.DELT_FLG= 'N'" ).append("\n"); 
		query.append("               AND ROWNUM =1" ).append("\n"); 
		query.append("            ) IB_FAX_ROWID " ).append("\n"); 
		query.append("         , (SELECT CNTC.ROWID /*+ INDEX (CNTC XAK2BKG_IB_CUST_CNTC) */" ).append("\n"); 
		query.append("             FROM BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("                , BKG_CUST_CD_VAL CVAL" ).append("\n"); 
		query.append("             WHERE BKGC.FIND_NAME_RID IS NULL" ).append("\n"); 
		query.append("               AND CNTC.CUST_CNT_CD = BKGC.CUST_CNT_CD_BL" ).append("\n"); 
		query.append("               AND CNTC.OFC_CD IN (BKGC.EQ_CTRL_OFC_CD, BKGC.HNDL_OFC_CD, @[ofc_cd] )" ).append("\n"); 
		query.append("               AND CNTC.CNTC_EML = BKGC.CUST_EML_BL" ).append("\n"); 
		query.append("               AND CVAL.CUST_CNT_CD = CNTC.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND CVAL.CUST_SEQ = CNTC.CUST_SEQ" ).append("\n"); 
		query.append("               AND CVAL.DELT_FLG= 'N'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) IB_EML_ROWID " ).append("\n"); 
		query.append("    FROM BKG_CST BKGC" ).append("\n"); 
		query.append(")   -- SUBQ" ).append("\n"); 
		query.append(", RSLT AS (" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO         -- KEY" ).append("\n"); 
		query.append("     , SUBQ.BKG_CUST_TP_CD -- KEY" ).append("\n"); 
		query.append("     , SUBQ.BL_NO  AS BL_NO" ).append("\n"); 
		query.append("     , SUBQ.CUST_CNT_CD || LPAD(DECODE(SUBQ.CUST_SEQ, 0, NULL,SUBQ.CUST_SEQ) , 6, '0') AS MDM_CUST_CD" ).append("\n"); 
		query.append("     , SUBQ.CUST_LGL_ENG_NM AS MDM_CUST_NM" ).append("\n"); 
		query.append("     , SUBQ.CUST_LGL_ADDR   AS MDM_CUST_ADDR" ).append("\n"); 
		query.append("     , SUBQ.CUST_CNT_CD_BL  AS BKG_CUST_CNT_CD" ).append("\n"); 
		query.append("     , SUBQ.CUST_SEQ_BL     AS BKG_CUST_SEQ" ).append("\n"); 
		query.append("     , SUBQ.CUST_NM_BL      AS BKG_CUST_NM" ).append("\n"); 
		query.append("     , SUBQ.CUST_ADDR_BL    AS BKG_CUST_ADDR" ).append("\n"); 
		query.append("     , CASE WHEN SUBQ.FIND_NAME_RID IS NOT NULL " ).append("\n"); 
		query.append("                 THEN MVID.CUST_CNT_CD || LPAD ( DECODE(MVID.CUST_SEQ, 0, NULL, MVID.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("            WHEN IBCT.CUST_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("                 THEN IBCT.CUST_CNT_CD || LPAD ( DECODE(IBCT.CUST_SEQ, 0, NULL, IBCT.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END  VAL_CUST_CD" ).append("\n"); 
		query.append("     , VCST.CUST_LGL_ENG_NM    AS VAL_CUST_NM" ).append("\n"); 
		query.append("     , (SELECT ADDR.BZET_ADDR" ).append("\n"); 
		query.append("          FROM MDM_CUST_ADDR ADDR" ).append("\n"); 
		query.append("         WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ADDR.CUST_CNT_CD = VCST.CUST_CNT_CD " ).append("\n"); 
		query.append("           AND ADDR.CUST_SEQ = VCST.CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1 )  AS VAL_CUST_ADDR" ).append("\n"); 
		query.append("     , SUBQ.CUST_FAX_NO_BL   AS BKG_CUST_FAX_NO" ).append("\n"); 
		query.append("     , DECODE(SUBQ.FIND_NAME_RID, NULL, DECODE(SUBQ.IB_FAX_ROWID, NULL, NULL, IBCT.FAX_NO))  AS VAL_CUST_FAX_NO" ).append("\n"); 
		query.append("     , CASE WHEN SUBQ.FIND_NAME_RID IS NOT NULL " ).append("\n"); 
		query.append("                 THEN MVID.CUST_CNT_CD || LPAD ( DECODE(MVID.CUST_SEQ, 0, NULL, MVID.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("            WHEN IBCT.CUST_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("                 THEN IBCT.CUST_CNT_CD || LPAD ( DECODE(IBCT.CUST_SEQ, 0, NULL, IBCT.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END AS COR_CUST_CD" ).append("\n"); 
		query.append("     , SUBQ.MTCH_FLG" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER (ORDER BY CASE WHEN SUBQ.FIND_NAME_RID IS NOT NULL THEN 1" ).append("\n"); 
		query.append("                                        WHEN SUBQ.IB_FAX_ROWID IS NOT NULL THEN 2" ).append("\n"); 
		query.append("                                        WHEN SUBQ.IB_EML_ROWID IS NOT NULL THEN 3" ).append("\n"); 
		query.append("                                        ELSE 4 " ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  ,CASE WHEN SUBQ.FIND_NAME_RID IS NOT NULL " ).append("\n"); 
		query.append("                                             THEN MVID.CUST_CNT_CD || LPAD ( DECODE(MVID.CUST_SEQ, 0, NULL, MVID.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("                                        WHEN IBCT.CUST_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("                                             THEN IBCT.CUST_CNT_CD || LPAD ( DECODE(IBCT.CUST_SEQ, 0, NULL, IBCT.CUST_SEQ), 6,'0')" ).append("\n"); 
		query.append("                                        ELSE NULL " ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  , SUBQ.CUST_NM_BL -- for unmatch case" ).append("\n"); 
		query.append("                                   ) AS ROW_NUM" ).append("\n"); 
		query.append("    , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , 1 AS ROW_COUNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM SUBQ" ).append("\n"); 
		query.append("     LEFT OUTER JOIN BKG_IB_CUST_CNTC IBCT ON" ).append("\n"); 
		query.append("        ( IBCT.ROWID = NVL(SUBQ.IB_FAX_ROWID, SUBQ.IB_EML_ROWID ))" ).append("\n"); 
		query.append("     LEFT OUTER JOIN BKG_CUST_CD_VAL MVID ON" ).append("\n"); 
		query.append("        ( MVID.ROWID = SUBQ.FIND_NAME_RID)" ).append("\n"); 
		query.append("     LEFT OUTER JOIN MDM_CUSTOMER VCST ON" ).append("\n"); 
		query.append("        (   (SUBQ.FIND_NAME_RID IS NOT NULL " ).append("\n"); 
		query.append("             AND VCST.CUST_CNT_CD = MVID.CUST_CNT_CD  " ).append("\n"); 
		query.append("             AND VCST.CUST_SEQ = MVID.CUST_SEQ) " ).append("\n"); 
		query.append("         OR (SUBQ.FIND_NAME_RID IS NULL " ).append("\n"); 
		query.append("             AND VCST.CUST_CNT_CD = IBCT.CUST_CNT_CD " ).append("\n"); 
		query.append("             AND VCST.CUST_SEQ = IBCT.CUST_SEQ)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT RSLT.BKG_NO         " ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_TP_CD " ).append("\n"); 
		query.append("     , RSLT.BL_NO" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_CD" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_NM" ).append("\n"); 
		query.append("     , RSLT.MDM_CUST_ADDR" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_CNT_CD" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_SEQ" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_NM" ).append("\n"); 
		query.append("     , RSLT.BKG_CUST_ADDR" ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.VAL_CUST_CD    ) AS VAL_CUST_CD    " ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.VAL_CUST_NM    ) AS VAL_CUST_NM    " ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.VAL_CUST_ADDR  ) AS VAL_CUST_ADDR  " ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.BKG_CUST_FAX_NO) AS BKG_CUST_FAX_NO" ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.VAL_CUST_FAX_NO) AS VAL_CUST_FAX_NO" ).append("\n"); 
		query.append("     , DECODE(RSLT.MTCH_FLG, 'Y', NULL, RSLT.COR_CUST_CD    ) AS COR_CUST_CD    " ).append("\n"); 
		query.append("     , RSLT.ROW_COUNT" ).append("\n"); 
		query.append("     , RSLT.MTCH_FLG" ).append("\n"); 
		query.append("     , ( SELECT /*+ index_desc (nhis  xpkBKG_NTC_HIS) */" ).append("\n"); 
		query.append("                NTC_FAX_NO" ).append("\n"); 
		query.append("           FROM BKG_NTC_HIS NHIS" ).append("\n"); 
		query.append("          WHERE NHIS.BKG_NO = RSLT.BKG_NO" ).append("\n"); 
		query.append("--            AND NHIS.BKG_CUST_TP_CD = RSLT.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            AND NTC_FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) NTC_FAX_NO" ).append("\n"); 
		query.append("     , ( SELECT /*+ index_desc (nhis  xpkBKG_NTC_HIS) */" ).append("\n"); 
		query.append("                NTC_EML" ).append("\n"); 
		query.append("           FROM BKG_NTC_HIS NHIS" ).append("\n"); 
		query.append("          WHERE NHIS.BKG_NO = RSLT.BKG_NO" ).append("\n"); 
		query.append("--            AND NHIS.BKG_CUST_TP_CD = RSLT.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            AND NTC_EML IS NOT NULL" ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) NTC_EML" ).append("\n"); 
		query.append("FROM RSLT" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("WHERE ROW_NUM > (TO_NUMBER(@[page_no]) -1) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("  AND ROW_NUM <=  TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY RSLT.VAL_CUST_CD" ).append("\n"); 
		query.append("       , RSLT.BKG_CUST_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}