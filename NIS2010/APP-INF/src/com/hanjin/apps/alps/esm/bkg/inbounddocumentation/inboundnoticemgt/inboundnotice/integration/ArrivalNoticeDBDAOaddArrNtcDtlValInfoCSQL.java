/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrNtcDtlValInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
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

public class ArrivalNoticeDBDAOaddArrNtcDtlValInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * code validation에 의해 Arrival Notice Detail이 자동으로 등록되도록 처리
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrNtcDtlValInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrNtcDtlValInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC_DTL" ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("      , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      , CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      , FAX_NO" ).append("\n"); 
		query.append("      , FAX_TP_CD  -- 5" ).append("\n"); 
		query.append("      , FAX_SND_FLG" ).append("\n"); 
		query.append("      , NTC_EML" ).append("\n"); 
		query.append("      , EML_TP_CD" ).append("\n"); 
		query.append("      , EML_SND_FLG" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT  " ).append("\n"); 
		query.append("      , UPD_USR_ID " ).append("\n"); 
		query.append("      , UPD_DT    -- 15" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO" ).append("\n"); 
		query.append("     , SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , CNTC.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("     , CNTC.FAX_NO" ).append("\n"); 
		query.append("        , 'A' -- by codevalidation auto code  -- 5" ).append("\n"); 
		query.append("     , DECODE(SUBQ.AN_SND_FLG, 'Y', CNTC.FAX_SND_FLG, SUBQ.AN_SND_FLG) AS FAX_SND_FLG" ).append("\n"); 
		query.append("     , CNTC.CNTC_EML " ).append("\n"); 
		query.append("        , 'A' -- by codevalidation auto code" ).append("\n"); 
		query.append("     , DECODE(SUBQ.AN_SND_FLG, 'Y', CNTC.EML_SND_FLG, SUBQ.AN_SND_FLG) AS EML_SND_FLG " ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , SYSDATE   -- 15" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("            , BKGM.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("            , BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("            , BKGM.POD_CD" ).append("\n"); 
		query.append("            , BKGM.DEL_CD" ).append("\n"); 
		query.append("            , BCST.VAL_NM" ).append("\n"); 
		query.append("            , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("            , BCST.CUST_SEQ" ).append("\n"); 
		query.append("            , BCST.BKG_CUST_TP_CD   " ).append("\n"); 
		query.append("            , BCST.CUST_FAX_NO" ).append("\n"); 
		query.append("            , BCST.CUST_EML" ).append("\n"); 
		query.append("            , BCST.AN_SND_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* 2015.08.03 한진그룹 코드 표준화 */" ).append("\n"); 
		query.append("          , CASE WHEN SUBSTR(BKGM.DEL_CD,1,2) ='US' AND SUBSTR(BKGM.POD_CD,1,2) ='CA' THEN 'TORSC'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(BKGM.DEL_CD,1,2) ='US' THEN 'PHXSA'" ).append("\n"); 
		query.append("                 WHEN SUBSTR(BKGM.DEL_CD,1,2) ='CA'" ).append("\n"); 
		query.append("               THEN DECODE( ( SELECT COUNT(1)" ).append("\n"); 
		query.append("	                           FROM BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("	                          WHERE CNTC.OFC_CD = MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	                            AND CNTC.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("	                            AND CNTC.CUST_SEQ = BCST.CUST_SEQ " ).append("\n"); 
		query.append("	                            AND ROWNUM = 1" ).append("\n"); 
		query.append("	                        )" ).append("\n"); 
		query.append("	                       , 1, MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	                       , @[val_ofc_cd]" ).append("\n"); 
		query.append("	                     ) " ).append("\n"); 
		query.append("	           ELSE " ).append("\n"); 
		query.append("	               DECODE( ( SELECT COUNT(1)" ).append("\n"); 
		query.append("	                           FROM BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("	                          WHERE CNTC.OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("	                            AND CNTC.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("	                            AND CNTC.CUST_SEQ = BCST.CUST_SEQ " ).append("\n"); 
		query.append("	                            AND ROWNUM = 1" ).append("\n"); 
		query.append("	                        )" ).append("\n"); 
		query.append("	                       , 1, @[ofc_cd]" ).append("\n"); 
		query.append("	                       , MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	                     ) " ).append("\n"); 
		query.append("	          END AS OFC_CD     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--            , SUBSTR((SELECT MAX(DECODE(CNTC.OFC_CD, MLOC.EQ_CTRL_OFC_CD, '3' || MLOC.EQ_CTRL_OFC_CD, STUP.HNDL_OFC_CD, '2' || STUP.HNDL_OFC_CD,  val_ofc_cd, 1 || val_ofc_cd, NULL))" ).append("\n"); 
		query.append("--                        FROM BKG_AN_DEST_OFC_STUP STUP" ).append("\n"); 
		query.append("--                           , BKG_IB_CUST_CNTC CNTC" ).append("\n"); 
		query.append("--                        WHERE STUP.EQ_CTRL_OFC_CD = MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("--                          AND STUP.DEST_OFC_CNTC_CD = 'I'" ).append("\n"); 
		query.append("--                          AND CNTC.OFC_CD IN (MLOC.EQ_CTRL_OFC_CD, STUP.HNDL_OFC_CD, val_ofc_cd)" ).append("\n"); 
		query.append("--                          AND CNTC.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("--                          AND CNTC.CUST_SEQ = BCST.CUST_SEQ )" ).append("\n"); 
		query.append("--                      , 2, 10) AS OFC_CD -- 다중일 경우 eq, handling, login user office 순으로 결정" ).append("\n"); 
		query.append("        FROM BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("            JOIN BKG_BOOKING BKGM ON" ).append("\n"); 
		query.append("               ( BKGM.BKG_NO =BCST.BKG_NO ) " ).append("\n"); 
		query.append("            JOIN MDM_LOCATION MLOC" ).append("\n"); 
		query.append("              ON (MLOC.LOC_CD = BKGM.DEL_CD) " ).append("\n"); 
		query.append("       WHERE BCST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND BCST.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("         AND BCST.AN_SND_FLG = 'Y'" ).append("\n"); 
		query.append("         AND BCST.VAL_CD IN ('M', 'W', 'O')  -- Validation이 Not Exists로 구하지 못했을 경우 Arrival Notice를 자동 생성하지 않는다." ).append("\n"); 
		query.append("         AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("         AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("      ) SUBQ" ).append("\n"); 
		query.append("    JOIN BKG_IB_CUST_CNTC CNTC ON" ).append("\n"); 
		query.append("         (CNTC.OFC_CD = SUBQ.OFC_CD" ).append("\n"); 
		query.append("          AND CNTC.CUST_CNT_CD = SUBQ.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CNTC.CUST_SEQ = SUBQ.CUST_SEQ " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(" WHERE NOT EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                      FROM BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("                     WHERE ADTL.BKG_NO = SUBQ.BKG_NO" ).append("\n"); 
		query.append("                       AND ADTL.BKG_CUST_TP_CD = SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                       AND ADTL.CUST_CNTC_TP_CD = CNTC.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}