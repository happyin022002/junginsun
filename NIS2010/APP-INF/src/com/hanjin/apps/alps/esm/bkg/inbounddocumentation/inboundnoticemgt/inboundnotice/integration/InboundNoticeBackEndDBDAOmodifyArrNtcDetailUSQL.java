/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InboundNoticeBackEndDBDAOmodifyArrNtcDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
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

public class InboundNoticeBackEndDBDAOmodifyArrNtcDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merge Arrival Notiec Detail By Background Customer Validation
	  * </pre>
	  */
	public InboundNoticeBackEndDBDAOmodifyArrNtcDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : InboundNoticeBackEndDBDAOmodifyArrNtcDetailUSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC_DTL " ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("      , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      , CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      , FAX_NO -- 5" ).append("\n"); 
		query.append("      , FAX_TP_CD" ).append("\n"); 
		query.append("      , FAX_SND_FLG" ).append("\n"); 
		query.append("      , NTC_EML" ).append("\n"); 
		query.append("      , EML_TP_CD -- 10" ).append("\n"); 
		query.append("      , EML_SND_FLG" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT  " ).append("\n"); 
		query.append("      , UPD_USR_ID -- 15" ).append("\n"); 
		query.append("      , UPD_DT " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO" ).append("\n"); 
		query.append("     , SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , CNTC.CUST_CNTC_TP_CD AS CUST_CNTC_TP_CD -- inbound contact정보가 없으면 bkg정보 이용 C1으로 하나 생성한다." ).append("\n"); 
		query.append("     , CNTC.FAX_NO AS  FAX_NO -- inbound contact가 없으면 default로 입력된 정보 사용" ).append("\n"); 
		query.append("        , 'A' -- by codevalidation auto code" ).append("\n"); 
		query.append("     , DECODE(SUBQ.AN_SND_FLG, 'Y', CNTC.FAX_SND_FLG, SUBQ.AN_SND_FLG) FAX_SND_FLG" ).append("\n"); 
		query.append("     , CNTC.CNTC_EML AS CNTC_EML" ).append("\n"); 
		query.append("        , 'A' -- by codevalidation auto code" ).append("\n"); 
		query.append("     , DECODE(SUBQ.AN_SND_FLG, 'Y', CNTC.EML_SND_FLG, SUBQ.AN_SND_FLG) EML_SND_FLG" ).append("\n"); 
		query.append("        , @[val_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[val_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
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
		query.append("            , ( SELECT COUNT(1)" ).append("\n"); 
		query.append("                  FROM BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("                 WHERE ADTL.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                   AND ADTL.BKG_CUST_TP_CD = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("              ) AS ADTL_EXISTS" ).append("\n"); 
		query.append("            , CASE WHEN SUBSTR(BKGM.DEL_CD,1,2) ='US' AND SUBSTR(BKGM.POD_CD,1,2) ='CA' THEN 'TORSC' " ).append("\n"); 
		query.append("                   WHEN SUBSTR(BKGM.DEL_CD,1,2) ='US' THEN 'PHXSA' " ).append("\n"); 
		query.append("                   WHEN SUBSTR(BKGM.DEL_CD,1,2) ='CA'" ).append("\n"); 
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
		query.append("	                          WHERE CNTC.OFC_CD = @[val_ofc_cd] " ).append("\n"); 
		query.append("	                            AND CNTC.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("	                            AND CNTC.CUST_SEQ = BCST.CUST_SEQ " ).append("\n"); 
		query.append("	                            AND ROWNUM = 1" ).append("\n"); 
		query.append("	                        )" ).append("\n"); 
		query.append("	                       , 1, @[val_ofc_cd]" ).append("\n"); 
		query.append("	                       , MLOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	                     ) " ).append("\n"); 
		query.append("	          END AS OFC_CD     " ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("            JOIN BKG_VVD BVVD ON" ).append("\n"); 
		query.append("            ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("            JOIN VSK_VSL_PORT_SKD VSKD ON" ).append("\n"); 
		query.append("            ( BVVD.VSL_PRE_PST_CD IN ('T', 'U') -- 입항 VVD (S는 제거)" ).append("\n"); 
		query.append("              AND BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("              AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            JOIN BKG_CUSTOMER BCST ON -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("                 ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD IN ( 'C', 'N' )" ).append("\n"); 
		query.append("                  AND BCST.AN_SND_FLG = 'Y' -- Arrival Notice를 보내는 경우에 대해서만 Arrival Notice Master를 생성한다." ).append("\n"); 
		query.append("                  AND BCST.MTCH_FLG = 'Y'  -- Back End Job에서는 Auto Match인 경우에 한하여 연락처 정보를 생성한다." ).append("\n"); 
		query.append("                 )   -- Match된 경우에만 처리한다." ).append("\n"); 
		query.append("            JOIN MDM_LOCATION MLOC" ).append("\n"); 
		query.append("              ON (MLOC.LOC_CD = BKGM.DEL_CD)" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("         AND BVVD.VSL_CD     = substr(@[vvd],1,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_VOY_NO = substr(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_DIR_CD = substr(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.POD_CD IN (${pod_cd}) -- CodeValidationBackEndJob IN 처리" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("         AND VSKD.VPS_ETA_DT BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYYMMDD') AND (TO_DATE(@[vps_eta_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("         AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("         AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.POL_CD = @[pol_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ) SUBQ" ).append("\n"); 
		query.append("     JOIN BKG_IB_CUST_CNTC CNTC ON  -- inbound 정보에 없는 것은 Arrival Notice Detail을 생성하지 않는다.(20090814 윤윤한)" ).append("\n"); 
		query.append("         (CNTC.OFC_CD = SUBQ.OFC_CD" ).append("\n"); 
		query.append("          AND CNTC.CUST_CNT_CD = SUBQ.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CNTC.CUST_SEQ = SUBQ.CUST_SEQ " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(" WHERE  ADTL_EXISTS = 0" ).append("\n"); 

	}
}