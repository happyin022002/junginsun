/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgCustValInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgCustValInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_1054에서 Code Validation시 Bkg Customer를 Update하는 Logic
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgCustValInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_dtm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgCustValInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUSTOMER BC" ).append("\n"); 
		query.append("  SET BC.MTCH_FLG = NVL(( SELECT DECODE(BRAT.RT_BL_TP_CD, 'B', 'N', NULL)" ).append("\n"); 
		query.append("                            FROM BKG_RATE BRAT" ).append("\n"); 
		query.append("                           WHERE BRAT.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                             AND ROWNUM = 1 ), 'Y') -- Co-Biz일 경우에는 N을 아닐 경우 O를 기입" ).append("\n"); 
		query.append("    , BC.VAL_CD = ( SELECT DECODE(BRAT.RT_BL_TP_CD, 'B', 'C', NULL)" ).append("\n"); 
		query.append("                            FROM BKG_RATE BRAT" ).append("\n"); 
		query.append("                           WHERE BRAT.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                             AND ROWNUM = 1 )  -- Co-Biz일 경우에는 C를 아닐 경우 그냥 Automatch이므로 null을 기입" ).append("\n"); 
		query.append("    , BC.AN_SND_FLG = 'Y'" ).append("\n"); 
		query.append("    , BC.VAL_OFC_CD = @[val_ofc_cd]" ).append("\n"); 
		query.append("    , BC.VAL_USR_ID = @[val_usr_id]" ).append("\n"); 
		query.append("    , BC.VAL_DT = TO_DATE( @[val_dtm] , 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    , BC.CHG_DP_FLG = (SELECT NVL(MAX(AN_PRN_RT_FLG), 'N')" ).append("\n"); 
		query.append("                         FROM BKG_USR_DFLT_SET" ).append("\n"); 
		query.append("                        WHERE USR_ID = @[val_usr_id])" ).append("\n"); 
		query.append("    , BC.ORG_CUST_CNT_CD = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("    , BC.ORG_CUST_SEQ = BC.CUST_SEQ" ).append("\n"); 
		query.append("    , BC.UPD_USR_ID = @[val_usr_id]" ).append("\n"); 
		query.append("    , BC.UPD_DT  = SYSDATE" ).append("\n"); 
		query.append("WHERE (BC.BKG_NO, BC.BKG_CUST_TP_CD) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT SUBQ.BKG_NO" ).append("\n"); 
		query.append("         , SUBQ.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      FROM ( " ).append("\n"); 
		query.append("            SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("                 , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                 , NVL( ( SELECT DECODE(BRAT.RT_BL_TP_CD, 'B', 'B', NULL)" ).append("\n"); 
		query.append("                            FROM BKG_RATE BRAT" ).append("\n"); 
		query.append("                           WHERE BRAT.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                             AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       ,( SELECT 'Y' --decode(BKGM.RT_BL_TP_CD, 'B', 'COBIZ', 'AUTO')" ).append("\n"); 
		query.append("                            FROM BKG_CUST_CD_VAL BVAL -- MDM CUSTOMER VALIDATION TABLE (목적 - mdm_customer 와 동일한지  검사)" ).append("\n"); 
		query.append("                               , MDM_CUSTOMER MCST  -- 임시 고객코드는 매핑에서 제외 (20091230 - 윤윤한수석 요청에 의해)" ).append("\n"); 
		query.append("                           WHERE BKGM.CUST_SEQ > 0" ).append("\n"); 
		query.append("                             AND BVAL.CUST_CNT_CD = BKGM.CUST_CNT_CD -- PK -- Match Case" ).append("\n"); 
		query.append("                             AND BVAL.CUST_SEQ = BKGM.CUST_SEQ    -- PK" ).append("\n"); 
		query.append("                             AND MCST.CUST_CNT_CD = BKGM.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND MCST.CUST_SEQ = BKGM.CUST_SEQ" ).append("\n"); 
		query.append("                             AND NVL(MCST.NMD_CUST_FLG,'N')  <> 'Y'    -- 임시 고객코드는 매핑에서 제외 (20091230 - 윤윤한수석 요청에 의해)" ).append("\n"); 
		query.append("                             AND BVAL.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                            -- 미주에 대해서만 3 digit Address 체크 로직 추가" ).append("\n"); 
		query.append("                             AND 1 = CASE WHEN SUBSTR(BKGM.POD_CD,1,2) NOT IN ('US') THEN 1" ).append("\n"); 
		query.append("                                          WHEN SUBSTR(BKGM.POD_CD,1,2) IN ('US') AND UPPER(SUBSTR(BVAL.VAL_CUST_ADDR,1,3)) = UPPER(SUBSTR(BKGM.CUST_ADDR,1,3)) THEN 1" ).append("\n"); 
		query.append("                                          ELSE 0 END" ).append("\n"); 
		query.append("                                          " ).append("\n"); 
		query.append("                             AND 1 = CASE WHEN SUBSTR(BVAL.VAL_CUST_NM,1,10) = SUBSTR(BKGM.VAL_NM, 1,10) THEN 1  " ).append("\n"); 
		query.append("                                          WHEN LENGTH(BVAL.VAL_CUST_NM) > 2   -- 한쪽에 등록된 validation name이 3자이상이고 10자 미만일 경우, 10자리로 검사하면 안잡힐 내용을 잡아준다." ).append("\n"); 
		query.append("                                               AND LENGTH(BKGM.VAL_NM) > 2" ).append("\n"); 
		query.append("                                               AND  ((LENGTH(BVAL.VAL_CUST_NM) < 10 " ).append("\n"); 
		query.append("                                                    OR LENGTH(BKGM.VAL_NM) < 10))" ).append("\n"); 
		query.append("                                               AND  SUBSTR(BVAL.VAL_CUST_NM,1,DECODE(SIGN(LENGTH(BVAL.VAL_CUST_NM) - LENGTH(BKGM.VAL_NM)), -1, LENGTH(BVAL.VAL_CUST_NM), LENGTH(BKGM.VAL_NM)))" ).append("\n"); 
		query.append("                                                  = SUBSTR(BKGM.VAL_NM,1,DECODE(SIGN(LENGTH(BVAL.VAL_CUST_NM) - LENGTH(BKGM.VAL_NM)), -1, LENGTH(BVAL.VAL_CUST_NM), LENGTH(BKGM.VAL_NM)))" ).append("\n"); 
		query.append("                                               THEN 1 " ).append("\n"); 
		query.append("                                          ELSE 0 END" ).append("\n"); 
		query.append("                             AND rownum = 1" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                      ) AS RT_BL_TP_CD" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("                          , BKGM.SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("                          , BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                          , BKGM.POD_CD" ).append("\n"); 
		query.append("                          , BKGM.DEL_CD" ).append("\n"); 
		query.append("                          , BCST.VAL_NM" ).append("\n"); 
		query.append("                          , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("                          , BCST.CUST_SEQ" ).append("\n"); 
		query.append("                          , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                          , BCST.CUST_ADDR" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                         JOIN BKG_VVD BVVD ON" ).append("\n"); 
		query.append("                            ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("                              AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                              AND BVVD.POD_CD = BKGM.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                              AND BKGM.BKG_STS_CD <> 'X' -- 무효한 bkg제거" ).append("\n"); 
		query.append("                              AND BKGM.BKG_STS_CD <> 'S'  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("                              AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("                              AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("#if ( ${sch_tp} == 'D') " ).append("\n"); 
		query.append("                         JOIN VSK_VSL_PORT_SKD VSKD ON" ).append("\n"); 
		query.append("                            ( BVVD.VSL_PRE_PST_CD IN ('T', 'U') -- 입항 VVD (S는 제거)" ).append("\n"); 
		query.append("                              AND BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("                              AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                              AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          JOIN BKG_CUSTOMER BCST ON -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("                              ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                               AND BCST.BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 
		query.append("                               AND BCST.MTCH_FLG = 'N'    -- validation이 되지 않은 데이터에 한정하여 처리(Auto match 제거)" ).append("\n"); 
		query.append("                               AND BCST.VAL_CD IS NULL    -- validation이 되지 않은 데이터에 한정하여 처리(Manual Code Validation 제거) (X - Auto-Cancel로 들어오는 값은 처리안하므로 해당 logic에서는 변경없음 20100201)" ).append("\n"); 
		query.append("                               AND TRIM(REPLACE(BCST.CUST_NM, CHR(10) , '')) IS NOT NULL -- 고객명 없으면 처리안함 (20090716)" ).append("\n"); 
		query.append("                               AND (" ).append("\n"); 
		query.append("                                        (BKGM.SAM_CNEE_NTFY_FLG = 'N' " ).append("\n"); 
		query.append("                                         AND BKGM.CUST_TO_ORD_FLG = 'N' -- Consignee, Notify둘다 생성" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (BKGM.SAM_CNEE_NTFY_FLG = 'Y'  -- Notify는 Consignee와 같으므로 Consignee만 생성" ).append("\n"); 
		query.append("                                         AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                     OR (BKGM.CUST_TO_ORD_FLG = 'Y'    -- Notify에게 연락하므로 Notify만 생성" ).append("\n"); 
		query.append("                                         AND BCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          LEFT OUTER JOIN BKG_RATE BRAT ON   -- added 20090826" ).append("\n"); 
		query.append("                              (BRAT.BKG_NO = BKGM.BKG_NO )" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("                       AND BVVD.VSL_CD     = SUBSTR(@[vvd],1,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                       AND BVVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                       AND BVVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("                       AND BVVD.POD_CD     = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("                       AND VSKD.VPS_ETA_DT BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYYMMDD') AND (TO_DATE(@[vps_eta_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("                       AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("                       AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                       AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("                       AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("                       AND BKGM.POL_CD = @[pol_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   )BKGM" ).append("\n"); 
		query.append("           ) SUBQ " ).append("\n"); 
		query.append("     WHERE SUBQ.RT_BL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}