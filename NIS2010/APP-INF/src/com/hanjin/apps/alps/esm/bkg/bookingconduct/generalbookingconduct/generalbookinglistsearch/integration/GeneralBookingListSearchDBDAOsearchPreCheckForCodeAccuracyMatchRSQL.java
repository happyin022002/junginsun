/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyMatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.04.04 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyMatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Consignee, Nofity의 code accuracy를 조회한다.
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyMatchRSQL(){
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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sheet_del_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchPreCheckForCodeAccuracyMatchRSQL").append("\n"); 
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
		query.append("SELECT RSLT.BKG_NO" ).append("\n"); 
		query.append("      , RSLT.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      , DECODE(RSLT.BKG_CUST_TP_CD, 'C', 'CNEE', 'NTFY') AS BKG_CUST_TP_CD_VIEW" ).append("\n"); 
		query.append("      , RSLT.BL_NO" ).append("\n"); 
		query.append("      , RSLT.MDM_CUST_CD" ).append("\n"); 
		query.append("      , RSLT.MDM_CUST_NM" ).append("\n"); 
		query.append("      , RSLT.MDM_CUST_ADDR" ).append("\n"); 
		query.append("      , RSLT.BKG_CUST_NM" ).append("\n"); 
		query.append("      , RSLT.BKG_CUST_ADDR" ).append("\n"); 
		query.append("      , RSLT.VAL_CD" ).append("\n"); 
		query.append("      , RSLT.VAL_USR_ID" ).append("\n"); 
		query.append("      , RSLT.VAL_CD_NM" ).append("\n"); 
		query.append("      , RSLT.VAL_USR_NM" ).append("\n"); 
		query.append("      , RSLT.VAL_OFC_CD" ).append("\n"); 
		query.append("      , RSLT.ORG_CUST_CD" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("      , DECODE(RSLT.VAL_CD, 'C', -1, 'A', 0, DECODE(RSLT.VAL_OFC_CD, @[ofc_cd],  0, -1)) VAL_CD_IMG_IDX -- cobiz만 back하지 않음" ).append("\n"); 
		query.append("      , RSLT.ROW_COUNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  , 0 ROW_COUNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("           , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           , BKGM.BL_NO" ).append("\n"); 
		query.append("           , BCST.CUST_CNT_CD || LPAD(DECODE(BCST.CUST_SEQ, 0, NULL,BCST.CUST_SEQ) , 6, '0') MDM_CUST_CD" ).append("\n"); 
		query.append("           , MCST.CUST_LGL_ENG_NM AS MDM_CUST_NM" ).append("\n"); 
		query.append("           , ADDR.BZET_ADDR AS MDM_CUST_ADDR" ).append("\n"); 
		query.append("           , BCST.CUST_NM AS BKG_CUST_NM" ).append("\n"); 
		query.append("           , BCST.CUST_ADDR AS BKG_CUST_ADDR" ).append("\n"); 
		query.append("           , DECODE(BCST.MTCH_FLG, 'Y', 'A', BCST.VAL_CD) AS VAL_CD" ).append("\n"); 
		query.append("           , DECODE(BCST.MTCH_FLG, 'Y', 'AUTO', DECODE(BCST.VAL_CD, 'C', 'AUTO', VACD.INTG_CD_VAL_DP_DESC)) AS VAL_CD_NM" ).append("\n"); 
		query.append("           , BCST.VAL_OFC_CD" ).append("\n"); 
		query.append("           , BCST.VAL_USR_ID" ).append("\n"); 
		query.append("           , DECODE(BCST.MTCH_FLG, 'Y', NULL, DECODE(BCST.VAL_CD, 'C', NULL, CUSR.USR_NM)) AS VAL_USR_NM" ).append("\n"); 
		query.append("           , BCST.VAL_DT" ).append("\n"); 
		query.append("           , BCST.ORG_CUST_CNT_CD || LPAD(DECODE(BCST.ORG_CUST_SEQ, 0, NULL,BCST.ORG_CUST_SEQ) , 6, '0') ORG_CUST_CD" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER (ORDER BY DECODE(BCST.MTCH_FLG, 'Y', 1, 0)" ).append("\n"); 
		query.append("                                        , BCST.VAL_DT DESC" ).append("\n"); 
		query.append("                                        , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                        , LPAD(DECODE(BCST.CUST_SEQ, 0, NULL,BCST.CUST_SEQ) , 6, '0')" ).append("\n"); 
		query.append("                                         ) " ).append("\n"); 
		query.append("              + nvl(to_number(@[sheet_del_cnt]), 0) ROW_NUM" ).append("\n"); 
		query.append("           , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("            JOIN BKG_VVD BVVD ON" ).append("\n"); 
		query.append("            ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("              AND BVVD.POL_CD = BKGM.POL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND BVVD.POL_CD = BKGM.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("#if (${sch_tp} == 'D') " ).append("\n"); 
		query.append("            JOIN VSK_VSL_PORT_SKD VSKD ON" ).append("\n"); 
		query.append("            ( BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("              AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND BVVD.POL_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND BVVD.POL_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            JOIN BKG_CUSTOMER BCST ON -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("            ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("               AND BCST.BKG_CUST_TP_CD IN ('C', 'N') " ).append("\n"); 
		query.append("               AND (BCST.MTCH_FLG = 'Y'" ).append("\n"); 
		query.append("                    OR BCST.VAL_CD <> 'X' -- is null or not Auto-Cancel 20100201" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            LEFT OUTER JOIN MDM_CUSTOMER MCST ON  -- 20090818 (customer와 join이 안되어도 데이터 나타나야 함" ).append("\n"); 
		query.append("            ( MCST.CUST_CNT_CD = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("                AND MCST.CUST_SEQ = BCST.CUST_SEQ)" ).append("\n"); 
		query.append("            LEFT OUTER JOIN COM_INTG_CD_DTL VACD ON" ).append("\n"); 
		query.append("            ( VACD.INTG_CD_ID = 'CD01655'" ).append("\n"); 
		query.append("                AND VACD.INTG_CD_VAL_CTNT = BCST.VAL_CD)" ).append("\n"); 
		query.append("            LEFT OUTER JOIN COM_USER CUSR ON " ).append("\n"); 
		query.append("            ( CUSR.USR_ID = BCST.VAL_USR_ID )" ).append("\n"); 
		query.append("            LEFT OUTER JOIN MDM_CUST_ADDR ADDR ON" ).append("\n"); 
		query.append("            (ADDR.CUST_CNT_CD = BCST.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND ADDR.CUST_SEQ = BCST.CUST_SEQ" ).append("\n"); 
		query.append("               AND ADDR.PRMRY_CHK_FLG ='Y'" ).append("\n"); 
		query.append("               AND ADDR.DELT_FLG = 'N')" ).append("\n"); 
		query.append("            LEFT OUTER JOIN BKG_CUST_CD_VAL CVAL ON" ).append("\n"); 
		query.append("            (CVAL.CUST_CNT_CD = BCST.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND CVAL.CUST_SEQ = BCST.CUST_SEQ)" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("         AND BVVD.VSL_CD     = substr(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_VOY_NO = substr(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_DIR_CD = substr(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.POL_CD     = @[pol_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("         AND VSKD.VPS_ETD_DT BETWEEN TO_DATE(@[vps_etd_dt_start], 'YYYYMMDD') " ).append("\n"); 
		query.append("								 AND (TO_DATE(@[vps_etd_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("         AND VSKD.VPS_PORT_CD = @[pol_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("         AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pod_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.POD_CD = @[pod_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ORDER BY DECODE(BCST.MTCH_FLG, 'Y', 1, 0)" ).append("\n"); 
		query.append("              , BCST.VAL_DT DESC" ).append("\n"); 
		query.append("              , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("              , LPAD(DECODE(BCST.CUST_SEQ, 0, NULL,BCST.CUST_SEQ) , 6, '0')" ).append("\n"); 
		query.append("     )RSLT" ).append("\n"); 

	}
}