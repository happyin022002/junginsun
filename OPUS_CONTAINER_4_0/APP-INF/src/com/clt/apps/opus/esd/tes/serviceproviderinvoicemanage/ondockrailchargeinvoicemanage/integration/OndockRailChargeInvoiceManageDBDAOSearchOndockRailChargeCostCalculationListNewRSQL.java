/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.01 
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

public class OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOndockRailChargeCostCalculationListNew
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListNewRSQL").append("\n"); 
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
		query.append("#if (${agmt_cost_yn} == 'Y') " ).append("\n"); 
		query.append("WITH AGMTCOST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ltrim(regexp_substr((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                            from tes_tml_so_hdr" ).append("\n"); 
		query.append("                            where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]), '[^|]+', 1, level ) ,'|') as cost_cd" ).append("\n"); 
		query.append(" FROM dual" ).append("\n"); 
		query.append(" connect by level<= ( length((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                               where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]))+1 - length(replace((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                                from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                                               where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq]), '|')) ) / length('|')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT I.COST_CODE                                                          LGS_COST_CD," ).append("\n"); 
		query.append("		 I.TPSZ                                                               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		 I.COST_CODE                                                          LGS_COST_CD2," ).append("\n"); 
		query.append("		 I.TPSZ                                                               CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("		 I.IO                                                                 IO_BND_CD," ).append("\n"); 
		query.append("		 TO_CHAR(I.WRK_DT,'YYYYMMDD')                                         WRK_DT," ).append("\n"); 
		query.append("		 I.TML_WRK_DY_CD                                                      TML_WRK_DY_CD," ).append("\n"); 
		query.append("		 I.FM                                                                 CNTR_STY_CD," ).append("\n"); 
		query.append("		 I.DCGO_CLSS_CD                                                                 DCGO_IND_CD," ).append("\n"); 
		query.append("		 SUM(DECODE(SIGN(TO_TR_VOL_VAL-CAL_VOL),-1,CAL_VOL-TO_TR_VOL_VAL,CAL_VOL)) CALC_VOL_QTY," ).append("\n"); 
		query.append("		 SUM(DECODE(SIGN(TO_TR_VOL_VAL-CAL_VOL),-1,CAL_VOL-TO_TR_VOL_VAL,CAL_VOL)) RVIS_VOL_QTY," ).append("\n"); 
		query.append("		 D.TML_AGMT_VOL_UT_CD                                                 VOL_TR_UT_CD," ).append("\n"); 
		query.append("		 DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.AGMT_RT,D.AGMT_UT_RT)              CTRT_RT," ).append("\n"); 
		query.append("		 ROUND(SUM(DECODE(SIGN(TO_TR_VOL_VAL-CAL_VOL),-1,CAL_VOL-TO_TR_VOL_VAL,CAL_VOL)) *" ).append("\n"); 
		query.append("		   DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.AGMT_RT,D.AGMT_UT_RT)*ROUND((SELECT USD_LOCL_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) AND CURR_CD =@[curr_cd])/(select USD_LOCL_XCH_RT from GL_MON_XCH_RT where ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) and CURR_CD = D.CURR_CD),4),2) INV_AMT," ).append("\n"); 
		query.append("		 ROUND(SUM(DECODE(SIGN(TO_TR_VOL_VAL-CAL_VOL),-1,CAL_VOL-TO_TR_VOL_VAL,CAL_VOL)) *" ).append("\n"); 
		query.append("		   DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.AGMT_RT,D.AGMT_UT_RT)*ROUND((SELECT USD_LOCL_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) AND CURR_CD =@[curr_cd])/(select USD_LOCL_XCH_RT from GL_MON_XCH_RT where ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) and CURR_CD = D.CURR_CD),4),2) CALC_AMT," ).append("\n"); 
		query.append("		 D.FM_TR_VOL_VAL                                                      FM_TR_VOL_VAL," ).append("\n"); 
		query.append("		 D.TO_TR_VOL_VAL                                                      TO_TR_VOL_VAL," ).append("\n"); 
		query.append("		 D.FM_TR_VOL_VAL||' ~ '||D.TO_TR_VOL_VAL                              TIER," ).append("\n"); 
		query.append("--		20061208 삭제 On-Dock은 VVD별 data는 의미없음." ).append("\n"); 
		query.append("--		         I.VSL_CD                                                             VSL_CD," ).append("\n"); 
		query.append("--		         I.VOY_NO                                                             SKD_VOY_NO," ).append("\n"); 
		query.append("--		         I.DIR_CD                                                             SKD_DIR_CD," ).append("\n"); 
		query.append("--		         I.VSL_CD||I.VOY_NO||I.DIR_CD                                         VVD_NO," ).append("\n"); 
		query.append("		 'ON'                                                                 CALC_COST_GRP_CD," ).append("\n"); 
		query.append("		 'A'                                                                  CALC_TP_CD," ).append("\n"); 
		query.append("		 L.ACCT_CD                                                            ACCT_CD," ).append("\n"); 
		query.append("		 ''                                                                   CALC_RMK," ).append("\n"); 
		query.append("		 ''                                                                   TML_CRR_CD," ).append("\n"); 
		query.append("		 ''                                                                   N3PTY_FLG," ).append("\n"); 
		query.append("		 @[tml_so_ofc_cty_cd]                                                   			        TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("		 @[tml_so_seq]                                                          		    TML_SO_SEQ," ).append("\n"); 
		query.append("		 0                                                                    TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("		 CTY              													TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("		 SEQ              													TML_AGMT_SEQ," ).append("\n"); 
		query.append("		 NO               													TML_AGMT_VER_NO," ).append("\n"); 
		query.append("		 D.CURR_CD                                                            CURR_CD," ).append("\n"); 
		query.append("		 ROUND((SELECT USD_LOCL_XCH_RT FROM GL_MON_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) AND CURR_CD =@[curr_cd])/(select USD_LOCL_XCH_RT from GL_MON_XCH_RT where ACCT_XCH_RT_YRMON = SUBSTR(REPLACE(@[max_wrk_dt],'-'),1,6) and CURR_CD = D.CURR_CD),4) INV_XCH_RT," ).append("\n"); 
		query.append("		 DECODE(@[curr_cd],D.CURR_CD,'Y','N')                                  		CURR_CHK" ).append("\n"); 
		query.append("  FROM ( SELECT " ).append("\n"); 
		query.append("                --DECODE(L.CNTR_STY_CD,'F',DECODE(SUBSTR(C.COST_CODE,6,1),'F',C.COST_CODE)," ).append("\n"); 
		query.append("				--DECODE(SUBSTR(C.COST_CODE,6,1),'M',C.COST_CODE)) COST_CODE," ).append("\n"); 
		query.append("                C.COST_CODE COST_CODE," ).append("\n"); 
		query.append("				L.CNTR_TPSZ_CD   TPSZ," ).append("\n"); 
		query.append("				L.WRK_DT		   WRK_DT," ).append("\n"); 
		query.append("				DECODE(TO_CHAR(L.WRK_DT,'DY'),'SAT','SA','SUN','SU','HOL','HO','WD') TML_WRK_DY_CD," ).append("\n"); 
		query.append("				L.CNTR_STY_CD    FM," ).append("\n"); 
		query.append("				L.DCGO_CLSS_CD   DCGO_CLSS_CD," ).append("\n"); 
		query.append("				COUNT(CNTR_NO)   CAL_VOL," ).append("\n"); 
		query.append("				L.RC_FLG   	   RC_FLG," ).append("\n"); 
		query.append("				L.IO_BND_CD      IO," ).append("\n"); 
		query.append("				CTY              CTY," ).append("\n"); 
		query.append("				SEQ              SEQ," ).append("\n"); 
		query.append("				NO               NO --," ).append("\n"); 
		query.append("--		20061208 삭제 On-Dock은 VVD별 data는 의미없음." ).append("\n"); 
		query.append("--		                L.VSL_CD         VSL_CD," ).append("\n"); 
		query.append("--		                L.SKD_VOY_NO     VOY_NO," ).append("\n"); 
		query.append("--		                L.SKD_DIR_CD     DIR_CD" ).append("\n"); 
		query.append("		 FROM   TES_TML_SO_CNTR_LIST L," ).append("\n"); 
		query.append("				( SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE," ).append("\n"); 
		query.append("						 CTY," ).append("\n"); 
		query.append("						 SEQ," ).append("\n"); 
		query.append("						 NO" ).append("\n"); 
		query.append("				  FROM ( SELECT COUNT(T.LGS_COST_CD) CNT," ).append("\n"); 
		query.append("								T.LGS_COST_CD TP," ).append("\n"); 
		query.append("								T.THRP_LGS_COST_CD CD," ).append("\n"); 
		query.append("								H.TML_AGMT_OFC_CTY_CD CTY," ).append("\n"); 
		query.append("								H.TML_AGMT_SEQ SEQ," ).append("\n"); 
		query.append("								H.TML_AGMT_VER_NO NO" ).append("\n"); 
		query.append("						 FROM   TES_TML_AGMT_HDR H, TES_TML_AGMT_THRP_COST T" ).append("\n"); 
		query.append("						 WHERE  H.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("						 AND    H.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("						 AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("						 AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("						 AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-')" ).append("\n"); 
		query.append("						 AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[max_wrk_dt],'-')" ).append("\n"); 
		query.append("						 AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("													  FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("													  WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("													  AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("													  AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("													  AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("													  AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-')" ).append("\n"); 
		query.append("													  AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[max_wrk_dt],'-') )" ).append("\n"); 
		query.append("						 AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("						 AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("						 AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("						 GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("								  T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C" ).append("\n"); 
		query.append("				  WHERE  C.COST_CALC_MZD_CD  = 'A'" ).append("\n"); 
		query.append("				  AND    C.ODCK_RAIL_CHG_FLG = 'Y'" ).append("\n"); 
		query.append("				  AND    DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' ) C" ).append("\n"); 
		query.append("		 WHERE  VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("		 AND    L.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		 AND    L.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("		 AND    DECODE(L.CNTR_STY_CD,'F','F','M') IN (SUBSTR(C.COST_CODE,6,1),SUBSTR(C.COST_CODE,5,1))" ).append("\n"); 
		query.append("		 GROUP BY C.COST_CODE, CNTR_TPSZ_CD, L.WRK_DT, DECODE(TO_CHAR(L.WRK_DT,'DY'),'SAT','SA','SUN','SU','HOL','HO','WD')," ).append("\n"); 
		query.append("				  CNTR_STY_CD, L.DCGO_CLSS_CD, L.IO_BND_CD, L.RC_FLG, CTY, SEQ, NO ) I," ).append("\n"); 
		query.append("		 TES_TML_AGMT_DTL D, TES_TML_AGMT_TP_SZ C, TES_TML_AGMT_APLY_DY A, TES_LGS_COST L, TES_TML_AGMT_DG_CGO_CLSS G" ).append("\n"); 
		query.append("  WHERE  I.CTY       = D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND    I.SEQ       = D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("  AND    I.NO        = D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("  AND    I.COST_CODE = D.LGS_COST_CD" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_TP_CD     = 'T'" ).append("\n"); 
		query.append("  AND    D.AUTO_CALC_FLG      = 'Y'" ).append("\n"); 
		query.append("  AND    NVL(D.IO_BND_CD,'N')  = DECODE(NVL(D.IO_BND_CD,'N'),'N','N','S','S',I.IO)" ).append("\n"); 
		query.append("  AND    TO_NUMBER(NVL(D.FM_TR_VOL_VAL,'1')) 	    <= CAL_VOL" ).append("\n"); 
		query.append("  AND    TO_NUMBER(NVL(D.TO_TR_VOL_VAL,'9999999'))  >= CAL_VOL" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_SEQ        = C.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_VER_NO     = C.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_DTL_SEQ    = C.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("  AND    DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("            = DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(SUBSTR(I.TPSZ,1,1),'R',DECODE(I.RC_FLG,'Y',I.TPSZ,DECODE(I.FM,'M',I.TPSZ,'D'||SUBSTR(I.TPSZ,2,1))),'T',DECODE(I.RC_FLG,'Y','R'||SUBSTR(I.TPSZ,2,1),I.TPSZ),I.TPSZ),'N')" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_OFC_CTY_CD  = A.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_SEQ         = A.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_VER_NO      = A.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_DTL_SEQ     = A.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("  AND    ( DECODE(D.TML_DY_APLY_TP_CD,'P',I.TML_WRK_DY_CD,'S') = DECODE(D.TML_DY_APLY_TP_CD,'P',DECODE(A.WKDY_FLG,'Y','WD'),'S')" ).append("\n"); 
		query.append("  OR       DECODE(D.TML_DY_APLY_TP_CD,'P',I.TML_WRK_DY_CD,'S') = DECODE(D.TML_DY_APLY_TP_CD,'P',DECODE(A.SAT_FLG,'Y','SA'),'S')" ).append("\n"); 
		query.append("  OR       DECODE(D.TML_DY_APLY_TP_CD,'P',I.TML_WRK_DY_CD,'S') = DECODE(D.TML_DY_APLY_TP_CD,'P',DECODE(A.SUN_FLG,'Y','SU'),'S')" ).append("\n"); 
		query.append("  OR       DECODE(D.TML_DY_APLY_TP_CD,'P',I.TML_WRK_DY_CD,'S') = DECODE(D.TML_DY_APLY_TP_CD,'P',DECODE(A.HOL_FLG,'Y','HO'),'S') )" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_OFC_CTY_CD = G.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_SEQ        = G.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("  AND    D.TML_AGMT_VER_NO     = G.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("--		   -- 수정(20070109)" ).append("\n"); 
		query.append("   AND    D.TML_AGMT_DTL_SEQ   = G.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("   AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.DCGO_APLY_TP_CD) = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N','D')" ).append("\n"); 
		query.append("   AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE(I.DCGO_CLSS_CD,'N','N',G.DCGO_SAM_CLSS_FLG),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE(I.DCGO_CLSS_CD,'N','N','Y'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE(I.DCGO_CLSS_CD,'N',G.DCGO_NON_CLSS_FLG,'N'),'S',DECODE(I.DCGO_CLSS_CD,'N',G.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE(I.DCGO_CLSS_CD,'N','Y','N'),'S',DECODE(I.DCGO_CLSS_CD,'N','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'1',G.DCGO_N1ST_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'1','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'2',G.DCGO_N2ND_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'2','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'3',G.DCGO_N3RD_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'3','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'4',G.DCGO_N4TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'4','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'5',G.DCGO_N5TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'5','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'6',G.DCGO_N6TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'6','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'7',G.DCGO_N7TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'7','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'8',G.DCGO_N8TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'8','Y','N'),'N')" ).append("\n"); 
		query.append("   AND     DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'9',G.DCGO_N9TH_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("		  = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'S',DECODE(I.DCGO_CLSS_CD,'9','Y','N'),'N')" ).append("\n"); 
		query.append("--		   -- 수정(20070109)" ).append("\n"); 
		query.append("  AND    I.COST_CODE = L.LGS_COST_CD(+)" ).append("\n"); 
		query.append("  GROUP BY I.COST_CODE, I.TPSZ, I.IO, I.WRK_DT, I.TML_WRK_DY_CD, I.FM, I.DCGO_CLSS_CD, D.FM_TR_VOL_VAL, D.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("		   D.TML_AGMT_VOL_UT_CD, DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.AGMT_RT,D.AGMT_UT_RT)," ).append("\n"); 
		query.append("		   L.ACCT_CD, CTY, SEQ, NO, D.CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_cost_yn} == 'Y') " ).append("\n"); 
		query.append(") A, AGMTCOST B" ).append("\n"); 
		query.append("WHERE A.LGS_COST_CD = B.COST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}