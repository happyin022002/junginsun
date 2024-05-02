/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOVerifyOndockRailChargeContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOVerifyOndockRailChargeContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyOndockRailChargeContainerList
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOVerifyOndockRailChargeContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOVerifyOndockRailChargeContainerListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.CNTR_NO,NULL,B.EQ_NO,A.CNTR_NO) 										CNTR_NO" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,DECODE(A.CNTR_STY_CD,NULL ,B.MT,A.CNTR_STY_CD) 								CNTR_STY_CD" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(DECODE(A.CNTR_NO,NULL,'',A.WRK_DT),'YYYY-MM-DD'),'YYYY-MM-DD') WRK_DT" ).append("\n"); 
		query.append("		,A.VNDR_SEQ" ).append("\n"); 
		query.append("		,A.YD_CD" ).append("\n"); 
		query.append("		,A.RCV_DT" ).append("\n"); 
		query.append("		,A.CNTR_RMK" ).append("\n"); 
		query.append("		,DECODE(A.DSCR_IND_CD,NULL,'HO',A.DSCR_IND_CD)  				DSCR_IND_CD" ).append("\n"); 
		query.append("		,B.VSL_CD" ).append("\n"); 
		query.append("		,B.SKD_VOY_NO" ).append("\n"); 
		query.append("		,B.SKD_DIR_CD" ).append("\n"); 
		query.append("		,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD  							VVD_NO" ).append("\n"); 
		query.append("		,MAX(B.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("		--,MAX(B.BKG_NO_SPLIT) BKG_NO_SPLIT" ).append("\n"); 
		query.append("		,MAX(B.BL_NO) BL_NO" ).append("\n"); 
		query.append("		--,MAX(B.BL_NO_CHK) BL_NO_CHK" ).append("\n"); 
		query.append("		--,MAX(B.BL_NO_TP) BL_NO_TP" ).append("\n"); 
		query.append("		,B.FM_NOD_CD" ).append("\n"); 
		query.append("		,B.TO_NOD_CD" ).append("\n"); 
		query.append("		,B.RC_FLG" ).append("\n"); 
		query.append("		,DECODE(B.DCGO_CLSS_CD,NULL,'N',B.DCGO_CLSS_CD) DCGO_CLSS_CD" ).append("\n"); 
		query.append("		,MAX(TO_CHAR(B.CLM_DT,'YYYY-MM-DD'))                                 		CLM_DT" ).append("\n"); 
		query.append("		,B.RAIL_BIL_DT" ).append("\n"); 
		query.append("		,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','DP','HO','PD','NH','DB','DF') THEN 'DC' ELSE 'CO' END VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("FROM   ( SELECT P.CNTR_NO        CNTR_NO" ).append("\n"); 
		query.append("				,C.CNTR_TPSZ_CD  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,DB.CNTR_RMK" ).append("\n"); 
		query.append("				,P.CNTR_STY_CD   CNTR_STY_CD" ).append("\n"); 
		query.append("				,P.VNDR_SEQ      VNDR_SEQ" ).append("\n"); 
		query.append("				,P.YD_CD         YD_CD" ).append("\n"); 
		query.append("				,P.RCV_DT        RCV_DT" ).append("\n"); 
		query.append("				,P.WRK_DT        WRK_DT" ).append("\n"); 
		query.append("				,P.TML_SO_TMP_SEQ TML_SO_TMP_SEQ" ).append("\n"); 
		query.append("				,CASE WHEN LENGTH(DB.CNTR_RMK) > 1   THEN 'DB' -- 'Double Bill' Check" ).append("\n"); 
		query.append("--		                ,CASE WHEN (( SELECT COUNT(*) -- 'Double Bill' Check" ).append("\n"); 
		query.append("--		                                FROM    TES_TML_SO_HDR A," ).append("\n"); 
		query.append("--		                                        TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("--		                                WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("--		                                AND    A.TML_SO_SEQ         = B.TML_SO_SEQ" ).append("\n"); 
		query.append("--		                                AND    A.VNDR_SEQ           = P.VNDR_SEQ" ).append("\n"); 
		query.append("--		                                AND    A.YD_CD              = P.YD_CD" ).append("\n"); 
		query.append("--		                                AND    A.TML_INV_TP_CD      = 'ON'" ).append("\n"); 
		query.append("--		                                AND    NVL(A.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("--		                                AND    B.CNTR_NO            = P.CNTR_NO" ).append("\n"); 
		query.append("--		                                AND    B.CNTR_STY_CD        = P.CNTR_STY_CD" ).append("\n"); 
		query.append("--		-- 김기영 부장님 요청으로 double billing checking period를 현재 3개월에서 (+/-)7일로 수정 - 2007.07.16" ).append("\n"); 
		query.append("--		                                AND    ABS(MONTHS_BETWEEN(P.RCV_DT,A.RCV_DT )) <= 0.25) > 0 ) THEN 'DB'" ).append("\n"); 
		query.append("				 ELSE DECODE(( SELECT COUNT(*) -- 'Not in COM Souce' Check" ).append("\n"); 
		query.append("								FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D" ).append("\n"); 
		query.append("								WHERE  ( O.FM_NOD_CD = P.YD_CD  OR  O.TO_NOD_CD = P.YD_CD )" ).append("\n"); 
		query.append("								AND    O.CRE_DT >= ( SELECT TO_DATE(MIN(WRK_DT),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("													 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("													 WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("													 AND    TML_SO_SEQ        = @[tml_so_seq] )  -- FILE IMPORT한 WORKING DATE의 MIN 값" ).append("\n"); 
		query.append("								AND    O.CRE_DT <= ( SELECT TO_DATE(MAX(WRK_DT),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("													 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("													 WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("													 AND    TML_SO_SEQ        = @[tml_so_seq] )  -- FILE IMPORT한 WORKING DATE의 MAX 값" ).append("\n"); 
		query.append("								AND    NVL(O.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("								AND    O.EQ_NO             = P.CNTR_NO" ).append("\n"); 
		query.append("								AND    O.BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("								--AND    O.BKG_NO_SPLIT      = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("								AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("								AND    O.BKG_NO            = D.BKG_NO(+)" ).append("\n"); 
		query.append("								--AND    O.BKG_NO_SPLIT      = D.BKG_NO_SPLIT(+) " ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("								, 0, 'NH'," ).append("\n"); 
		query.append("							  (SELECT DECODE(CGO_TP_CD,'F','CO','DDF')" ).append("\n"); 
		query.append("							   FROM(" ).append("\n"); 
		query.append("									SELECT MAX(O.BKG_NO), --MAX(O.BKG_NO_SPLIT), " ).append("\n"); 
		query.append("											P.CNTR_NO, O.CGO_TP_CD -- 'Discrepancy by Detail Data' Check" ).append("\n"); 
		query.append("									FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("									WHERE  ( O.FM_NOD_CD = P.YD_CD   OR   O.TO_NOD_CD = P.YD_CD )" ).append("\n"); 
		query.append("									AND    O.CRE_DT >= ( SELECT TO_DATE(MIN(WRK_DT),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("														 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("														 WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("														 AND    TML_SO_SEQ        = @[tml_so_seq] )    -- FILE IMPORT한 WORKING DATE의 MIN 값" ).append("\n"); 
		query.append("									AND    O.CRE_DT <= ( SELECT TO_DATE(MAX(WRK_DT),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("														 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("														 WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("														 AND    TML_SO_SEQ        = @[tml_so_seq] )   -- FILE IMPORT한 WORKING DATE의 MAX 값" ).append("\n"); 
		query.append("									AND    NVL(O.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("									AND    O.EQ_NO             = P.CNTR_NO" ).append("\n"); 
		query.append("									AND    O.BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("									--AND    O.BKG_NO_SPLIT      = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("									AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("									AND    O.BKG_NO            = D.BKG_NO(+)" ).append("\n"); 
		query.append("									--AND    O.BKG_NO_SPLIT      = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("									AND    P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("									AND    P.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("									GROUP BY P.CNTR_NO, O.CGO_TP_CD )" ).append("\n"); 
		query.append("								WHERE P.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("								))" ).append("\n"); 
		query.append("				 END  DSCR_IND_CD" ).append("\n"); 
		query.append("		 FROM  TES_FILE_IMP_TMP P, MST_CONTAINER C," ).append("\n"); 
		query.append("			          (" ).append("\n"); 
		query.append("                        SELECT   BB.CNTR_NO, BB.CNTR_STY_CD, 'Double billing Inv : '||MAX(BB.INV_NO) CNTR_RMK" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT A.COST_CODE, C.CNTR_NO " ).append("\n"); 
		query.append("                            FROM(" ).append("\n"); 
		query.append("                                SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE" ).append("\n"); 
		query.append("                                FROM ( SELECT COUNT(T.LGS_COST_CD) CNT," ).append("\n"); 
		query.append("                                     T.LGS_COST_CD TP," ).append("\n"); 
		query.append("                                     T.THRP_LGS_COST_CD CD," ).append("\n"); 
		query.append("                                     H.TML_AGMT_OFC_CTY_CD CTY," ).append("\n"); 
		query.append("                                     H.TML_AGMT_SEQ SEQ," ).append("\n"); 
		query.append("                                     H.TML_AGMT_VER_NO NO" ).append("\n"); 
		query.append("                                    FROM   TES_TML_AGMT_HDR H, TES_TML_AGMT_THRP_COST T" ).append("\n"); 
		query.append("                                    WHERE  H.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("                                    AND    H.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("                                    AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    								AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("    								AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-') -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                         FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                         WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                                         AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                                         AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                         AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            							 AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("            							 AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-')) -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                                    GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("                                    T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("                                WHERE  C.COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("                                AND    C.TML_AGMT_MGMT_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								AND    C.ODCK_RAIL_CHG_FLG = 'Y' -- OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND    D.TML_AGMT_OFC_CTY_CD = A.CTY" ).append("\n"); 
		query.append("                                AND    D.TML_AGMT_SEQ = A.SEQ" ).append("\n"); 
		query.append("                                AND    D.TML_AGMT_VER_NO  = A.NO" ).append("\n"); 
		query.append("                                AND    C.LGS_COST_CD = D.LGS_COST_CD" ).append("\n"); 
		query.append("                                AND    DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("                                AND    D.THRP_COST_CD_FLG IS NULL" ).append("\n"); 
		query.append("                            ) A," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT ltrim(regexp_substr((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                              from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                             where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]), '[^|]+', 1, level ) ,'|') as COST_CODE" ).append("\n"); 
		query.append("                                 FROM dual" ).append("\n"); 
		query.append("                                 connect by level<= ( length((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                               where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]))+1 - length(replace((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                                                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                                                                               where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]), '|')) ) / length('|')" ).append("\n"); 
		query.append("                            )B," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT * FROM TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("                            ) C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_ftr_rmk} == '') " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE(+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE -- hdr정보에 데이터 있으면 inner 없음 outter" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                        ) AA," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT DISTINCT H.INV_NO, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD, L.CNTR_NO, L.CNTR_STY_CD" ).append("\n"); 
		query.append("                         FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("                         WHERE  H.YD_CD             = @[yd_cd]" ).append("\n"); 
		query.append("                         AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("                         AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("                         AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("						 AND    H.TML_INV_TP_CD      = 'ON'" ).append("\n"); 
		query.append("                         AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("                         AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("                         AND    NVL(L.CNTR_TPSZ_CD,'N')  = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("                            DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("                            'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("                            'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("                             = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("                         --AND    DECODE(H.TML_INV_TP_CD,'TM','Y',L.VSL_CD) <> DECODE(H.TML_INV_TP_CD,'TM','N','CNTC')" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("                        ) BB" ).append("\n"); 
		query.append("                        WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("                        AND AA.COST_CODE = BB.LGS_COST_CD" ).append("\n"); 
		query.append("                        group by BB.CNTR_NO, BB.CNTR_STY_CD" ).append("\n"); 
		query.append("                    ) DB" ).append("\n"); 
		query.append("		 WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		 AND   P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("		 AND   P.CNTR_NO = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("		 AND   P.CNTR_STY_CD = DB.CNTR_STY_CD(+)" ).append("\n"); 
		query.append("		 AND   P.CNTR_NO           = C.CNTR_NO(+) ) A," ).append("\n"); 
		query.append("	   ( SELECT  B.VSL_CD," ).append("\n"); 
		query.append("				 B.SKD_VOY_NO," ).append("\n"); 
		query.append("				 B.SKD_DIR_CD," ).append("\n"); 
		query.append("				 O.BKG_NO," ).append("\n"); 
		query.append("				 --O.BKG_NO_SPLIT," ).append("\n"); 
		query.append("				 B.BL_NO," ).append("\n"); 
		query.append("				 --B.BL_NO_CHK," ).append("\n"); 
		query.append("				 --B.BL_NO_TP," ).append("\n"); 
		query.append("				 O.EQ_NO," ).append("\n"); 
		query.append("				 O.EQ_TPSZ_CD," ).append("\n"); 
		query.append("				 O.CGO_TP_CD MT," ).append("\n"); 
		query.append("				 O.FM_NOD_CD," ).append("\n"); 
		query.append("				 O.TO_NOD_CD," ).append("\n"); 
		query.append("				 P.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("				 NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("				 NVL(B.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("				 TO_CHAR(TO_DATE(P.WRK_DT,'YYYYMMDD'),'YYYY-MM-DD') WK_DT," ).append("\n"); 
		query.append("				 DECODE(DECODE(SUBSTR(P.YD_CD,1,5),B.POL_CD,'O','I'),'O',MIN(U.ARR_DT),MAX(V.ARR_DT)) CLM_DT," ).append("\n"); 
		query.append("				 TO_CHAR(O.CRE_DT,'YYYY-MM-DD') RAIL_BIL_DT," ).append("\n"); 
		query.append("				 DECODE(TO_CHAR(TO_DATE(P.WRK_DT,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','WD') DY," ).append("\n"); 
		query.append("				( SELECT COUNT(*)" ).append("\n"); 
		query.append("				  FROM   DMT_HOLIDAY" ).append("\n"); 
		query.append("				  WHERE  TO_CHAR(HOL_DT,'YYYYMMDD') = TO_CHAR(P.WRK_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("				  AND    CNT_CD = P.YD_CD" ).append("\n"); 
		query.append("				   ) HO" ).append("\n"); 
		query.append("		 FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D, SCE_CLM U, SCE_CLM V, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("		 WHERE  P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		 AND    P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("		 AND    ( O.FM_NOD_CD = P.YD_CD  OR O.TO_NOD_CD = P.YD_CD )" ).append("\n"); 
		query.append("		 AND    O.CRE_DT >= ( SELECT TO_DATE(MIN(WRK_DT),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("							  FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("							  WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("							  AND    TML_SO_SEQ        = @[tml_so_seq] )   -- FILE IMPORT한 WORKING DATE의 MIN 값" ).append("\n"); 
		query.append("		 AND    O.CRE_DT <= ( SELECT TO_DATE(MAX(WRK_DT),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("							  FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("							  WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("							  AND    TML_SO_SEQ = @[tml_so_seq] )   -- FILE IMPORT한 WORKING DATE의 MAX 값" ).append("\n"); 
		query.append("		 AND    NVL(O.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("		 AND    O.EQ_NO              = P.CNTR_NO" ).append("\n"); 
		query.append("		 AND    O.BKG_NO             = B.BKG_NO(+)" ).append("\n"); 
		query.append("		 --AND    O.BKG_NO_SPLIT       = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("		 AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("		 AND    O.BKG_NO             = D.BKG_NO(+)" ).append("\n"); 
		query.append("		 --AND    O.BKG_NO_SPLIT       = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("		 AND    O.TRSP_SO_OFC_CTY_CD = U.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		 AND    O.TRSP_SO_SEQ        = U.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		 AND    O.EQ_NO              = U.CNTR_NO(+)" ).append("\n"); 
		query.append("		 AND    U.CLM_SGHT_CD(+)     = 'U'" ).append("\n"); 
		query.append("		 AND    O.TRSP_SO_OFC_CTY_CD = V.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		 AND    O.TRSP_SO_SEQ        = V.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		 AND    O.EQ_NO              = V.CNTR_NO(+)" ).append("\n"); 
		query.append("		 AND    V.CLM_SGHT_CD(+)     = 'V'" ).append("\n"); 
		query.append("		 GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, O.BKG_NO, --O.BKG_NO_SPLIT, " ).append("\n"); 
		query.append("				B.BL_NO, --B.BL_NO_CHK, B.BL_NO_TP," ).append("\n"); 
		query.append("				  O.EQ_NO, O.EQ_TPSZ_CD, O.CGO_TP_CD, O.FM_NOD_CD, O.TO_NOD_CD, P.TML_SO_TMP_SEQ, P.WRK_DT, P.YD_CD," ).append("\n"); 
		query.append("				  D.IMDG_CLSS_CD, B.POL_CD, O.CRE_DT, B.RC_FLG ) B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO        = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND   A.TML_SO_TMP_SEQ = B.TML_SO_TMP_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY DECODE(A.CNTR_NO,NULL,B.EQ_NO,A.CNTR_NO), A.CNTR_TPSZ_CD, DECODE(A.CNTR_STY_CD,NULL ,B.MT,A.CNTR_STY_CD)" ).append("\n"); 
		query.append("		,TO_CHAR(TO_DATE(DECODE(A.CNTR_NO,NULL,'',A.WRK_DT),'YYYY-MM-DD'),'YYYY-MM-DD'), A.VNDR_SEQ, A.YD_CD" ).append("\n"); 
		query.append("		,A.RCV_DT, DECODE(A.DSCR_IND_CD,NULL,'HO',A.DSCR_IND_CD), B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD" ).append("\n"); 
		query.append("		,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, B.FM_NOD_CD, B.TO_NOD_CD, B.RC_FLG" ).append("\n"); 
		query.append("		,DECODE(B.DCGO_CLSS_CD,NULL,'N',B.DCGO_CLSS_CD), B.RAIL_BIL_DT, A.DSCR_IND_CD, A.CNTR_RMK" ).append("\n"); 

	}
}