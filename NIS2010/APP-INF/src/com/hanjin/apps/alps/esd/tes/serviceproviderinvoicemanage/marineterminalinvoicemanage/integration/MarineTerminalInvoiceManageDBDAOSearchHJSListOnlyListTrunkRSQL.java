/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchHJSListOnlyListTrunkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchHJSListOnlyListTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHJSListOnlyListTrunk
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchHJSListOnlyListTrunkRSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfy_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchHJSListOnlyListTrunkRSQL").append("\n"); 
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
		query.append("#if (${vrfy_tml_cd} != '' and ${yd_cd} != '' and ${tml_port_cd} != '' and ${vrfy_tml_cd} != ${tml_port_cd}) " ).append("\n"); 
		query.append("SELECT X.*  --// 구주 털보 아저씨 (2014-05-20)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD, CNTR_STY_CD, IOC_CD, LANE_CD, LANE_CD2, LOCL_TS_IND_CD, RCVDE_TERM_IND_CD, BKG_NO, IO_BND_CD," ).append("\n"); 
		query.append("			 DCGO_CLSS_CD, BB_CGO_FLG, AWK_CGO_FLG, RC_FLG, CNTR_RMK, DSCR_IND_CD, VVD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, ATB_DT, VNDR_SEQ,TML_TRNS_MOD_CD, DSCR_DTL_IND_CD," ).append("\n"); 
		query.append("			 WRK_DT, BL_NO, BL_NO_TP, BL_NO_CHK,  DC_FLG, CLPT_IND_SEQ, CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("#if (${file_import_yn} == 'Y')" ).append("\n"); 
		query.append("	VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("#elseif (${file_import_yn} == 'N')" ).append("\n"); 
		query.append("	DECODE(IO_BND_CD, LOWER(@[io_bnd_cd]),'DC',DECODE(DSCR_IND_CD,'HD','DC','CO')) VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 FROM(" ).append("\n"); 
		query.append("	 SELECT L.CNTR_NO        										CNTR_NO," ).append("\n"); 
		query.append("			L.TPSZ                                                 CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			L.FM                                                   CNTR_STY_CD," ).append("\n"); 
		query.append("			L.IPC                                                  IOC_CD," ).append("\n"); 
		query.append("			L.LANE                                                 LANE_CD," ).append("\n"); 
		query.append("			L.LANE                                                 LANE_CD2," ).append("\n"); 
		query.append("            DECODE(L.PCTL_IO_BND_CD,'T'," ).append("\n"); 
		query.append("			DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD,'WDVD','T','VDWD','T','WDWD','T','VDVD','T',DECODE(L.FM,'M',NULL,'R',NULL,'L')),'L') LOCL_TS_IND_CD," ).append("\n"); 
		query.append("			L.RCVDE_TERM_IND_CD                                    RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("			L.BKG_NO                                               BKG_NO," ).append("\n"); 
		query.append("			--L.BKG_NO_SPLIT                                         BKG_NO_SPLIT," ).append("\n"); 
		query.append("			NVL(DECODE(L.FM,'M',DECODE(SUBSTR(@[yd_cd],1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("					DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N'),'WDTD','I','WDRD','I','VDTD','I','VDRD','I','RDWD','O','RDVD','O','TDWD','O','TDVD','O'," ).append("\n"); 
		query.append("														'WDN','I','VDN','I','NVD','O','NWD','O'," ).append("\n"); 
		query.append("													   'WDVD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'VDWD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'WDWD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'VDVD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O'))),LOWER(@[io_bnd_cd])) IO_BND_CD," ).append("\n"); 
		query.append("			 NVL(L.DCGO_CLSS_CD,'N')	DCGO_CLSS_CD," ).append("\n"); 
		query.append("			 NVL(L.BB_CGO_FLG,'N')		BB_CGO_FLG," ).append("\n"); 
		query.append("			 NVL(L.AWK_CGO_FLG,'N')		AWK_CGO_FLG," ).append("\n"); 
		query.append("			 NVL(L.RC_FLG,'N')			RC_FLG," ).append("\n"); 
		query.append("			 L.CNTR_RMK||DB.CNTR_RMK	CNTR_RMK," ).append("\n"); 
		query.append("			 DECODE(DECODE(L.PCTL_IO_BND_CD,'T'," ).append("\n"); 
		query.append("                    DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD,'WDVD','T','VDWD','T','WDWD','T','VDVD','T',DECODE(L.FM,'M',NULL,'R',NULL,'L')),'L'),'L'," ).append("\n"); 
		query.append("					DECODE(L.FM,'F',DECODE(@[io_bnd_cd],'O',DECODE(R.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')," ).append("\n"); 
		query.append("					  DECODE(RL,0,DECODE(TR,'RD','R','WD','B','TD','T','T'),'R')),'I'," ).append("\n"); 
		query.append("					DECODE(O.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')),VSL_TP) TML_TRNS_MOD_CD,                   -- 추가(20070404)" ).append("\n"); 
		query.append("			 CASE WHEN LENGTH(DB.CNTR_RMK) > 1   THEN 'HD' -- 'Double Bill' Check" ).append("\n"); 
		query.append("--			         CASE WHEN ( SELECT COUNT(*) -- 'Double Bill' Check" ).append("\n"); 
		query.append("--			                          FROM   TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    A.TML_SO_SEQ         = B.TML_SO_SEQ             -- 추가(20070404)" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--			                          AND    ( A.VNDR_SEQ, A.YD_CD ) IN ( SELECT DISTINCT VNDR_SEQ, YD_CD" ).append("\n"); 
		query.append("--			                                                              FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("--			                                                              WHERE  TML_SO_OFC_CTY_CD  = @[]" ).append("\n"); 
		query.append("--			                                                              AND    TML_SO_SEQ         = @[] )" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--			                          AND    B.CNTR_NO            = L.CNTR_NO             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    B.CNTR_STY_CD        = L.FM	             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    B.VSL_CD             = SUBSTR(@[],1,4)             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    B.SKD_VOY_NO         = SUBSTR(@[],5,4)             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    B.SKD_DIR_CD         = SUBSTR(@[],9,1)             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    NVL(A.DELT_FLG,'N')  <> 'Y'             -- 추가(20070404)" ).append("\n"); 
		query.append("--			                          AND    A.TML_INV_TP_CD      = 'TM') > 0 THEN 'HD'             -- 추가(20070404)" ).append("\n"); 
		query.append("	-- 김기영 부장님 요청으로 double billing checking period를 현재 3개월에서 (+/-)7일로 수정 - 2007.07.16" ).append("\n"); 
		query.append("	-- 김기영 부장님 요청으로 receive date 비교로직 삭제함. - 2008.04.17" ).append("\n"); 
		query.append("--			                          AND    MONTHS_BETWEEN(TO_DATE(REPLACE(@[],'-'),'YYYY-MM-DD'),A.RCV_DT ) <= 0.25 AND ROWNUM = 1) > 0 THEN 'HD'  -- 추가(20070404) => 변수 : ATB DATE" ).append("\n"); 
		query.append("					   ELSE 'HO'" ).append("\n"); 
		query.append("				  END                                                                                DSCR_IND_CD," ).append("\n"); 
		query.append("			 @[vvd]																					VVD," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],1,4)																		VSL_CD," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],5,4)																		SKD_VOY_NO," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],9,1)																		SKD_DIR_CD," ).append("\n"); 
		query.append("			 @[atb_dt]																					ATB_DT," ).append("\n"); 
		query.append("			 @[vndr_seq]																					VNDR_SEQ," ).append("\n"); 
		query.append("			 ''																				DSCR_DTL_IND_CD," ).append("\n"); 
		query.append("			 ''																				WRK_DT," ).append("\n"); 
		query.append("			 ''																				BL_NO," ).append("\n"); 
		query.append("			 ''																				BL_NO_TP," ).append("\n"); 
		query.append("			 ''																				BL_NO_CHK," ).append("\n"); 
		query.append("			 'DC'																				VRFY_RSLT_IND_CD," ).append("\n"); 
		query.append("			 'Y'																				DC_FLG," ).append("\n"); 
		query.append("             @[clpt_ind_seq] 																CLPT_IND_SEQ," ).append("\n"); 
		query.append("			 @[call_yd_ind_seq]																CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	 FROM ( SELECT B.CNTR_NO       CNTR_NO," ).append("\n"); 
		query.append("				   B.TPSZ          TPSZ," ).append("\n"); 
		query.append("				   B.FM            FM," ).append("\n"); 
		query.append("				   B.IPC           IPC," ).append("\n"); 
		query.append("				   B.LANE          LANE," ).append("\n"); 
		query.append("				   B.RCVDE_TERM_IND_CD       RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("				   MIN(B.BKG_NO)        BKG_NO," ).append("\n"); 
		query.append("				   --MIN(B.BKG_NO_SPLIT)  BKG_NO_SPLIT," ).append("\n"); 
		query.append("				   MAX(G.PCTL_NO)        COP_NO," ).append("\n"); 
		query.append("				   MAX(B.TP_CD)         TP_CD," ).append("\n"); 
		query.append("				   MAX(B.POL)           POL," ).append("\n"); 
		query.append("					MIN(B.DCGO_CLSS_CD)          DCGO_CLSS_CD," ).append("\n"); 
		query.append("					MIN(B.BB_CGO_FLG)            BB_CGO_FLG," ).append("\n"); 
		query.append("					B.RM            CNTR_RMK," ).append("\n"); 
		query.append("					MIN(B.AWK_CGO_FLG)   AWK_CGO_FLG," ).append("\n"); 
		query.append("					MIN(B.RC_FLG)        RC_FLG," ).append("\n"); 
		query.append("					B.VSL_TP        VSL_TP," ).append("\n"); 
		query.append("					B.TR            TR," ).append("\n"); 
		query.append("					B.RL            RL," ).append("\n"); 
		query.append("				   MIN(( SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("					 FROM   SCE_COP_HDR HD, PRD_PROD_CTL_ROUT_DTL GD" ).append("\n"); 
		query.append("					 WHERE  H.CNTR_NO         = HD.CNTR_NO" ).append("\n"); 
		query.append("					 AND    H.PCTL_NO          = HD.PCTL_NO" ).append("\n"); 
		query.append("					 AND    B.BKG_NO          = HD.BKG_NO" ).append("\n"); 
		query.append("					 --AND    B.BKG_NO_SPLIT    = HD.BKG_NO_SPLIT" ).append("\n"); 
		query.append("					 AND    HD.PCTL_NO         = GD.PCTL_NO" ).append("\n"); 
		query.append("					 AND    GD.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("					 AND    GD.PCTL_SEQ < G.PCTL_SEQ )) R_SEQ," ).append("\n"); 
		query.append("				   MAX(( SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("					 FROM   SCE_COP_HDR OD, PRD_PROD_CTL_ROUT_DTL OG" ).append("\n"); 
		query.append("					 WHERE  OD.CNTR_NO        = H.CNTR_NO" ).append("\n"); 
		query.append("					 AND    OD.PCTL_NO         = H.PCTL_NO" ).append("\n"); 
		query.append("					 AND    OD.BKG_NO         = H.BKG_NO" ).append("\n"); 
		query.append("					 --AND    OD.BKG_NO_SPLIT   = H.BKG_NO_SPLIT" ).append("\n"); 
		query.append("					 AND    OD.PCTL_NO         = OG.PCTL_NO" ).append("\n"); 
		query.append("					 AND    OG.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("					 AND    OG.PCTL_SEQ > G.PCTL_SEQ )) O_SEQ" ).append("\n"); 
		query.append("                    --, G.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                              ,(SELECT NVL(X.PCTL_IO_BND_CD,'') PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                FROM PRD_PROD_CTL_ROUT_DTL X" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND X.PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("                                AND X.PCTL_SEQ = ( SELECT " ).append("\n"); 
		query.append("                                                        CASE" ).append("\n"); 
		query.append("                                                        WHEN ORG_NOD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                                                        THEN PCTL_SEQ-1" ).append("\n"); 
		query.append("                                                        WHEN DEST_NOD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                                        THEN PCTL_SEQ+1" ).append("\n"); 
		query.append("                                                        END CUR_PCTL_SEQ" ).append("\n"); 
		query.append("                                                    FROM PRD_PROD_CTL_ROUT_DTL X" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND X.PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("                                                    AND X.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                    AND X.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                    AND X.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                    AND ROWNUM = 1 )) PCTL_IO_BND_CD" ).append("\n"); 
		query.append("	/** 2009-01-19: HJS Only의 Bkg정보를 물고오는 부분에 단순 min/max말고 rank를 주어 Bkg_no/Bkg_no_split을 제대로 물고오게 변경한다.  **/" ).append("\n"); 
		query.append("			FROM   ( SELECT X.* FROM ( SELECT /*+ NO_EXPAND */ C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("							C.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("							DENSE_RANK() OVER (PARTITION BY C.CNTR_NO ORDER BY V.CRE_DT DESC, V.BKG_NO DESC) BKG_RANK," ).append("\n"); 
		query.append("							DECODE(B.BKG_CGO_TP_CD,'F','F','B','F','R','R','M') FM," ).append("\n"); 
		query.append("							DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O') IPC," ).append("\n"); 
		query.append("							V.SLAN_CD LANE," ).append("\n"); 
		query.append("							B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("							V.BKG_NO BKG_NO," ).append("\n"); 
		query.append("							--V.BKG_NO_SPLIT BKG_NO_SPLIT," ).append("\n"); 
		query.append("							B.POL_CD        POL," ).append("\n"); 
		query.append("							B.BKG_CGO_TP_CD TP_CD," ).append("\n"); 
		query.append("							 CASE WHEN D.CNTR_NO = C.CNTR_NO  THEN NVL(SUBSTR(D.IMDG_CLSS_CD, 1, 1), 'N') ELSE 'N' END  DCGO_CLSS_CD," ).append("\n"); 
		query.append("							 NVL(C.BB_CGO_FLG,'N')							 BB_CGO_FLG," ).append("\n"); 
		query.append("							 --DECODE(NVL(A.OVR_VOID_SLT_QTY,0),0,'N','Y') AWK_CGO_FLG," ).append("\n"); 
		query.append("                             NVL(C.AWK_CGO_FLG,'N') AWK_CGO_FLG," ).append("\n"); 
		query.append("							 NVL(B.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("							 DECODE(NVL(C.BB_CGO_FLG,'N'),'Y','Break Bulk') RM," ).append("\n"); 
		query.append("							 DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT CRR_CD FROM MDM_VSL_CNTR  WHERE VSL_CD = S.VSL_CD),'SML','V','F'),'V') VSL_TP,  -- 추가(20070404)" ).append("\n"); 
		query.append("						   ( SELECT MAX(TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("							 FROM   TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("							 WHERE  ( FM_NOD_CD      = @[yd_cd] OR       TO_NOD_CD      = @[yd_cd] )" ).append("\n"); 
		query.append("							 AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("							 AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("							 AND    CRE_DT < TO_DATE(REPLACE(@[atb_dt],'-'),'YYYYMMDD') + 15 ) TR,    -- 추가(20070404)=>변수 : ATB DATE" ).append("\n"); 
		query.append("						   ( SELECT COUNT(*)" ).append("\n"); 
		query.append("							 FROM   TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("							 WHERE  ( FM_NOD_CD      = @[yd_cd] OR       TO_NOD_CD      = @[yd_cd] )" ).append("\n"); 
		query.append("							 AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("							 AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("							 AND    CRE_DT < TO_DATE(REPLACE(@[atb_dt],'-'),'YYYYMMDD') + 15 AND ROWNUM = 1 ) RL    -- 추가(20070404)=>ATB DATE" ).append("\n"); 
		query.append("					 FROM   BKG_VVD V, BKG_CONTAINER C, BKG_BOOKING B, BKG_DG_CGO D, BKG_AWK_CGO A," ).append("\n"); 
		query.append("							 MDM_LOCATION BR, MDM_LOCATION BD,VSK_VSL_SKD S, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("					 WHERE  V.VSL_CD           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("					 AND    V.SKD_VOY_NO       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("					 AND    V.SKD_DIR_CD       = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("					 AND    ( V.POL_CD     = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("					 OR     V.POD_CD       = SUBSTR(@[yd_cd],1,5) )" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("					 AND    DECODE(@[io_bnd_cd],'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ) = @[clpt_ind_seq] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					 AND    V.BKG_NO           = C.BKG_NO(+)" ).append("\n"); 
		query.append("					 --AND    V.BKG_NO_SPLIT     = C.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("					 AND    C.BKG_NO           = B.BKG_NO(+)" ).append("\n"); 
		query.append("					 --AND    C.BKG_NO_SPLIT     = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("					 AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("					 AND    B.BKG_NO           = D.BKG_NO(+)" ).append("\n"); 
		query.append("					 --AND    B.BKG_NO_SPLIT     = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("					 AND    C.BKG_NO           = A.BKG_NO(+)" ).append("\n"); 
		query.append("					 --AND    C.BKG_NO_SPLIT     = A.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("					 AND    C.CNTR_NO          = A.CNTR_NO(+)" ).append("\n"); 
		query.append("					 AND    B.POR_CD           = BR.LOC_CD" ).append("\n"); 
		query.append("					 AND    B.POD_CD           = BD.LOC_CD" ).append("\n"); 
		query.append("					 AND    V.VSL_CD           = S.VSL_CD(+)" ).append("\n"); 
		query.append("					 AND    V.SKD_VOY_NO       = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("					 AND    V.SKD_DIR_CD       = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("					 AND    S.VSL_SLAN_CD          = L.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("					 AND    L.DELT_FLG         = 'N' ) X WHERE BKG_RANK = 1 ) B, SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("			WHERE  B.CNTR_NO             = H.CNTR_NO(+)" ).append("\n"); 
		query.append("			AND    B.BKG_NO              = H.BKG_NO(+)" ).append("\n"); 
		query.append("			--AND    B.BKG_NO_SPLIT        = H.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("			AND    NVL(H.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("			AND    H.PCTL_NO              = G.PCTL_NO(+)" ).append("\n"); 
		query.append("			AND    G.NOD_LNK_DIV_CD(+)   = 'N'" ).append("\n"); 
		query.append("			--AND    G.ORG_NOD_CD(+)       = [yd_cd]  --vvd, sce, prd 에서 값을제대로 못가지고 와서 밑에쿼리로 변경" ).append("\n"); 
		query.append("			AND    SUBSTR(G.ORG_NOD_CD(+),1,5)       = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("			 GROUP BY B.CNTR_NO,B.TPSZ,B.FM,B.IPC,B.LANE,B.RCVDE_TERM_IND_CD,B.RM,B.VSL_TP,B.TR,B.RL, G.PCTL_NO--, G.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("			) L, PRD_PROD_CTL_ROUT_DTL R, PRD_PROD_CTL_ROUT_DTL O," ).append("\n"); 
		query.append("-- [CHM-201539158]Invoice CNTR Verify로직 수정 요청(Double Billing비교 부분) 2015.12.10 속도개선을 위해 수정" ).append("\n"); 
		query.append("-- [CHM-201640867]EDI 전송건 인보이스 UPLOAD 시간 과다 발생 (SQL Tunning 받은 결과 반영) - 2016.03.28" ).append("\n"); 
		query.append("							 (SELECT /*+ LEADING(B) USE_NL(A) */ B.CNTR_NO, 'Double billing Inv : '||MAX(A.INV_NO) CNTR_RMK" ).append("\n"); 
		query.append("							  FROM   TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("							  WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("							  AND    A.TML_SO_SEQ         = B.TML_SO_SEQ" ).append("\n"); 
		query.append("--							  AND    ( A.VNDR_SEQ, A.YD_CD ) IN ( SELECT DISTINCT VNDR_SEQ, YD_CD" ).append("\n"); 
		query.append("--																  FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("--																  WHERE  TML_SO_OFC_CTY_CD  = [tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("--																  AND    TML_SO_SEQ         = [tml_so_seq] )" ).append("\n"); 
		query.append("							  AND    A.VNDR_SEQ 		  = @[vndr_seq]" ).append("\n"); 
		query.append("							  AND	 A.YD_CD			  = @[yd_cd]" ).append("\n"); 
		query.append("							  AND    B.VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("							  AND    B.SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("							  AND    B.SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("							  AND    B.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("							  AND	 NVL(B.CLPT_IND_SEQ,'1') = NVL(@[clpt_ind_seq],'1')" ).append("\n"); 
		query.append("							  AND	 NVL(B.CALL_YD_IND_SEQ,'1') = NVL(@[call_yd_ind_seq],'1')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							  AND    NVL(A.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("							  AND    A.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append("							  GROUP BY B.CNTR_NO" ).append("\n"); 
		query.append("							  ) DB" ).append("\n"); 
		query.append("	 WHERE  L.COP_NO              = R.PCTL_NO(+)" ).append("\n"); 
		query.append("	 AND    R.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("	 AND    L.R_SEQ               = R.PCTL_SEQ(+)" ).append("\n"); 
		query.append("	 AND    L.COP_NO              = O.PCTL_NO(+)" ).append("\n"); 
		query.append("	 AND    O.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("	 AND    L.O_SEQ               = O.PCTL_SEQ(+)" ).append("\n"); 
		query.append("	 AND    L.CNTR_NO             = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${file_import_yn} == 'Y')" ).append("\n"); 
		query.append("		 AND L.CNTR_NO NOT IN (SELECT CNTR_NO" ).append("\n"); 
		query.append("							   FROM  TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("							   WHERE TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("							   AND   TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("							   AND   VSL_CD||SKD_VOY_NO||SKD_DIR_CD  = ( SELECT DISTINCT VVD_CD" ).append("\n"); 
		query.append("																		 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("																		 WHERE  TML_SO_OFC_CTY_CD  = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("																		 AND    TML_SO_SEQ         = @[tml_so_seq] ))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 )WHERE IO_BND_CD IN (@[io_bnd_cd],LOWER(@[io_bnd_cd]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and  ${fm_tp_length} == '1')" ).append("\n"); 
		query.append("	AND CNTR_STY_CD = @[fm_tp]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and  ${ts_tp_length} == '1')" ).append("\n"); 
		query.append("	AND LOCL_TS_IND_CD = @[ts_tp]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vrfy_tml_cd} != '' and ${yd_cd} != '' and ${tml_port_cd} != '' and ${vrfy_tml_cd} != ${tml_port_cd}) " ).append("\n"); 
		query.append("--//invoice의 port(yard의 5자리)와 vrfy_tml_cd가 같다는것은 vrfy_tml_cd가 port라는 의미로 이전 CNTR verify와 동일하므로 yard별로 구별할 필요가 없다." ).append("\n"); 
		query.append(") X , CTM_MOVEMENT M   --// 구주 털보 아찌 (2014-05-20)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     X.CNTR_NO = M.CNTR_NO " ).append("\n"); 
		query.append("AND     M.ORG_YD_CD LIKE DECODE(@[vrfy_tml_cd],NULL,SUBSTR(@[yd_cd],1,5),'',SUBSTR(@[yd_cd],1,5),@[vrfy_tml_cd])||'%'" ).append("\n"); 
		query.append("AND     M.CRNT_VSL_CD           = X.VSL_CD" ).append("\n"); 
		query.append("AND     M.CRNT_SKD_VOY_NO       = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     M.CRNT_SKD_DIR_CD       = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     M.FCNTR_FLG             = DECODE(X.CNTR_STY_CD,'F','Y','N')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}