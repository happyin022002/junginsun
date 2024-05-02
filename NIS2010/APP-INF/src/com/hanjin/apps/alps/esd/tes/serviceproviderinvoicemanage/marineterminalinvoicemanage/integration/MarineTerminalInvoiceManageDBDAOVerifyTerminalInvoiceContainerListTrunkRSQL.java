/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListTrunkRSQL.java
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

public class MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyTerminalInvoiceContainerListTrunk
	  * 2011.06.21 이일민 [CHM-201111697] TES INV 생성시 T/S 구분자 참조로직 변경 요청 (PRD IO BND 구분)
	  * 2011.06.21 이일민 [CHM-201111699] [TES] Auto-Calcualtion의 CNTR Verification 보완 (BB CGO / AWK CGO 기준 변경)
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListTrunkRSQL(){
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
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListTrunkRSQL").append("\n"); 
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
		query.append("#if (${vrfy_tml_cd} != '' and ${yd_cd} != '' and ${tml_port_cd} != '' and ${vrfy_tml_cd} != ${tml_port_cd})" ).append("\n"); 
		query.append("SELECT X.*  --// 구주 털보 아저씨 (2014-05-20)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   /*+ NO_QUERY_TRANSFORMATION */ A.CNTR_NO" ).append("\n"); 
		query.append("			,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,A.CNTR_STY_CD" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,1,4) VSL_CD" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,5,4) SKD_VOY_NO" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,9,1) SKD_DIR_CD" ).append("\n"); 
		query.append("			,A.VNDR_SEQ" ).append("\n"); 
		query.append("			,A.YD_CD" ).append("\n"); 
		query.append("			,A.RCV_DT" ).append("\n"); 
		query.append("			,A.WRK_DT" ).append("\n"); 
		query.append("			,A.CNTR_RMK" ).append("\n"); 
		query.append("			,@[atb_dt] ATB_DT" ).append("\n"); 
		query.append("--  데이타 정제 작업으로 인한 Logic 수정  - CNTR LIST DSCR_IND_CD에 CO값 코드 부정합 ( 2009-09-16 )" ).append("\n"); 
		query.append("--			,SUBSTR(A.DSCR_IND_CD,0,2)  DSCR_IND_CD" ).append("\n"); 
		query.append("			, DECODE( SUBSTR(A.DSCR_IND_CD,0,2), 'CO', '', SUBSTR(A.DSCR_IND_CD,0,2) )  DSCR_IND_CD" ).append("\n"); 
		query.append("			,DECODE(LENGTH(A.DSCR_IND_CD),3, SUBSTR(A.DSCR_IND_CD,3,1),'') DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("			,B.BKG_NO" ).append("\n"); 
		query.append("			--,B.BKG_NO_SPLIT" ).append("\n"); 
		query.append("			,B.BL_NO" ).append("\n"); 
		query.append("			--,B.BL_NO_CHK" ).append("\n"); 
		query.append("			,B.BL_NO_TP" ).append("\n"); 
		query.append("			,A.IO_BND_CD" ).append("\n"); 
		query.append("			,B.IPC          IOC_CD" ).append("\n"); 
		query.append("			,B.LANE         LANE_CD" ).append("\n"); 
		query.append("			,B.TS           LOCL_TS_IND_CD" ).append("\n"); 
		query.append("			,B.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("			,DECODE(B.DCGO_CLSS_CD,null,'N',B.DCGO_CLSS_CD) DCGO_CLSS_CD" ).append("\n"); 
		query.append("			,NVL(B.BB_CGO_FLG,'N')		BB_CGO_FLG" ).append("\n"); 
		query.append("			,NVL(B.AWK_CGO_FLG,'N')	AWK_CGO_FLG" ).append("\n"); 
		query.append("			,NVL(B.RC_FLG,'N')			RC_FLG" ).append("\n"); 
		query.append("			,B.REMARK" ).append("\n"); 
		query.append("			,B.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','DP','HO','PD','NH','DB','DF') THEN 'DC' ELSE 'CO' END VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','DP','HO','PD','NH','DB','DF') THEN ''   ELSE 'Y'  END CO_FLG" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','DP','HO','PD','NH','DB','DF') THEN 'Y'  ELSE  ''  END DC_FLG" ).append("\n"); 
		query.append("			,@[clpt_ind_seq] CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,@[call_yd_ind_seq] CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	FROM    ( SELECT P.CNTR_NO          CNTR_NO" ).append("\n"); 
		query.append("					,C.CNTR_TPSZ_CD     CNTR_TPSZ_CD" ).append("\n"); 
		query.append("					,P.CNTR_STY_CD      CNTR_STY_CD" ).append("\n"); 
		query.append("					,P.VVD_CD           VVD" ).append("\n"); 
		query.append("					,P.VNDR_SEQ         VNDR_SEQ" ).append("\n"); 
		query.append("					,P.YD_CD            YD_CD" ).append("\n"); 
		query.append("					,P.RCV_DT           RCV_DT" ).append("\n"); 
		query.append("					,P.WRK_DT           WRK_DT" ).append("\n"); 
		query.append("					,P.IO_BND_CD        IO_BND_CD" ).append("\n"); 
		query.append("					,P.TML_SO_TMP_SEQ   TMP_SEQ" ).append("\n"); 
		query.append("					,DB.CNTR_RMK" ).append("\n"); 
		query.append("					,CASE WHEN LENGTH(DB.CNTR_RMK) > 1   THEN 'DB'	   -- 'Double Bill' Check" ).append("\n"); 
		query.append("					 ELSE DECODE(( SELECT DECODE(MIN(NVL(H.COP_STS_CD,'N')),'X',0,COUNT(*)) CNT" ).append("\n"); 
		query.append("								   FROM   ( SELECT C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("												   V.BKG_NO BKG_NO --," ).append("\n"); 
		query.append("												   --V.BKG_NO_SPLIT BKG_NO_SPLIT" ).append("\n"); 
		query.append("											FROM   BKG_VVD V, BKG_CONTAINER C,BKG_BOOKING B,  BKG_DG_CGO D, MDM_LOCATION BR, MDM_LOCATION BD" ).append("\n"); 
		query.append("											WHERE  V.VSL_CD           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("											AND    V.SKD_VOY_NO       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("											AND    V.SKD_DIR_CD       = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("											AND    DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(@[yd_cd],1, 5)" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("											AND    DECODE(@[io_bnd_cd],'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ) = @[clpt_ind_seq] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 남중국 Barge 적용을 위해 BKG_BKG_VVD의 Yard 적용방법을 수정함... 아래는 수정전.   -- 2008.05.29" ).append("\n"); 
		query.append("--			                                        AND    ( V.POL_CD = SUBSTR(?,1,5) OR V.POD_CD = SUBSTR(?,1,5) )" ).append("\n"); 
		query.append("											AND    V.BKG_NO           = C.BKG_NO(+)" ).append("\n"); 
		query.append("											--AND    V.BKG_NO_SPLIT     = C.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("											AND    C.BKG_NO           = B.BKG_NO(+)" ).append("\n"); 
		query.append("											--AND    C.BKG_NO_SPLIT     = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("											AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("											AND    B.BKG_NO           = D.BKG_NO(+)" ).append("\n"); 
		query.append("											--AND    B.BKG_NO_SPLIT     = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("											AND    B.POR_CD           = BR.LOC_CD" ).append("\n"); 
		query.append("											AND    B.POD_CD           = BD.LOC_CD ) B," ).append("\n"); 
		query.append("										  SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("								   WHERE  P.CNTR_NO             = B.CNTR_NO(+)" ).append("\n"); 
		query.append("								   AND    B.CNTR_NO             = H.CNTR_NO(+)" ).append("\n"); 
		query.append("								   AND    B.BKG_NO              = H.BKG_NO(+)" ).append("\n"); 
		query.append("								   --AND    B.BKG_NO_SPLIT        = H.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("								   AND    H.COP_STS_CD(+) <> 'X'" ).append("\n"); 
		query.append("								   AND    H.PCTL_NO              = G.PCTL_NO(+)" ).append("\n"); 
		query.append("								   AND    G.NOD_LNK_DIV_CD(+)   = 'N'" ).append("\n"); 
		query.append("									--AND    G.ORG_NOD_CD(+)       = [yd_cd]  --vvd, sce, prd 에서 값을제대로 못가지고 와서 밑에쿼리로 변경" ).append("\n"); 
		query.append("									AND    SUBSTR(G.ORG_NOD_CD(+),1,5)       = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("								   AND    ROWNUM = 1 )," ).append("\n"); 
		query.append("								  0, 'NH',  -- 'Not in SML Souce' Check" ).append("\n"); 
		query.append("								 (SELECT DISTINCT DECODE(L.FM," ).append("\n"); 
		query.append("											P.CNTR_STY_CD,DECODE(DECODE(L.FM," ).append("\n"); 
		query.append("																'M',DECODE(SUBSTR(P.YD_CD,1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("																DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N')," ).append("\n"); 
		query.append("																	'WDTD','I',     'WDRD','I',     'VDTD','I'," ).append("\n"); 
		query.append("																	'VDRD','I',     'RDWD','O',     'RDVD','O'," ).append("\n"); 
		query.append("																	'TDWD','O',     'TDVD','O',     'WDN','I'," ).append("\n"); 
		query.append("																	'VDN','I',      'NVD','O',      'NWD','O'," ).append("\n"); 
		query.append("																	'WDVD',DECODE(P.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("																	'VDWD',DECODE(P.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("																	'WDWD',DECODE(P.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("																	'VDVD',DECODE(P.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')))," ).append("\n"); 
		query.append("											  P.IO_BND_CD,'CO', 'DDI'),'DDF') -- 'Discrepancy by Detail Data' Check" ).append("\n"); 
		query.append("								  FROM ( SELECT P.CNTR_NO       CNTR_NO," ).append("\n"); 
		query.append("												B.TPSZ          TPSZ," ).append("\n"); 
		query.append("												B.FM            FM," ).append("\n"); 
		query.append("												MIN(B.BKG_NO)   BKG_NO," ).append("\n"); 
		query.append("												--MIN(B.BKG_NO_SPLIT) BKG_NO_SPLIT," ).append("\n"); 
		query.append("												MAX(G.PCTL_NO)   COP_NO," ).append("\n"); 
		query.append("												MAX(B.POL)      POL," ).append("\n"); 
		query.append("												MIN(( SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("													  FROM   SCE_COP_HDR HD, PRD_PROD_CTL_ROUT_DTL GD" ).append("\n"); 
		query.append("													  WHERE  H.CNTR_NO         = HD.CNTR_NO" ).append("\n"); 
		query.append("													  AND    HD.PCTL_NO         = GD.PCTL_NO" ).append("\n"); 
		query.append("													  AND    H.BKG_NO          = HD.BKG_NO" ).append("\n"); 
		query.append("													  --AND    H.BKG_NO_SPLIT    = HD.BKG_NO_SPLIT" ).append("\n"); 
		query.append("													  AND    GD.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("													  AND    GD.PCTL_SEQ < G.PCTL_SEQ )) R_SEQ," ).append("\n"); 
		query.append("												MAX(( SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("													  FROM   SCE_COP_HDR OD, PRD_PROD_CTL_ROUT_DTL OG" ).append("\n"); 
		query.append("													  WHERE  OD.CNTR_NO        = H.CNTR_NO" ).append("\n"); 
		query.append("													  AND    OD.BKG_NO         = H.BKG_NO" ).append("\n"); 
		query.append("													  --AND    OD.BKG_NO_SPLIT   = H.BKG_NO_SPLIT" ).append("\n"); 
		query.append("													  AND    OD.PCTL_NO         = OG.PCTL_NO" ).append("\n"); 
		query.append("													  AND    OG.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("													  AND    OG.PCTL_SEQ > G.PCTL_SEQ )) O_SEQ" ).append("\n"); 
		query.append("										 FROM   ( SELECT C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("														 C.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("														 DECODE(B.BKG_CGO_TP_CD,'F','F','B','F','R','R','M') FM," ).append("\n"); 
		query.append("														 V.BKG_NO BKG_NO," ).append("\n"); 
		query.append("														 --V.BKG_NO_SPLIT BKG_NO_SPLIT," ).append("\n"); 
		query.append("														 B.POL_CD        POL" ).append("\n"); 
		query.append("												  FROM   BKG_VVD V, BKG_CONTAINER C,BKG_BOOKING B,  BKG_DG_CGO D, MDM_LOCATION BR, MDM_LOCATION BD" ).append("\n"); 
		query.append("												  WHERE  V.VSL_CD           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("												  AND    V.SKD_VOY_NO       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("												  AND    V.SKD_DIR_CD       = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("												  AND    DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(@[yd_cd],1, 5)" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("												  AND    DECODE(@[io_bnd_cd],'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ) = @[clpt_ind_seq] 		" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end										  " ).append("\n"); 
		query.append("-- 남중국 Barge 적용을 위해 BKG_BKG_VVD의 Yard 적용방법을 수정함... 아래는 수정전.   -- 2008.05.29" ).append("\n"); 
		query.append("--			                                              AND    ( V.POL_CD = SUBSTR(?,1,5) OR V.POD_CD = SUBSTR(?,1,5) )" ).append("\n"); 
		query.append("												  AND    V.BKG_NO           = C.BKG_NO(+)" ).append("\n"); 
		query.append("												  --AND    V.BKG_NO_SPLIT     = C.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("												  AND    C.BKG_NO           = B.BKG_NO(+)" ).append("\n"); 
		query.append("												  --AND    C.BKG_NO_SPLIT     = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("												  AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("												  AND    B.BKG_NO           = D.BKG_NO(+)" ).append("\n"); 
		query.append("												  --AND    B.BKG_NO_SPLIT     = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("												  AND    B.POR_CD           = BR.LOC_CD" ).append("\n"); 
		query.append("												  AND    B.POD_CD           = BD.LOC_CD ) B," ).append("\n"); 
		query.append("												  SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("										 WHERE  B.CNTR_NO             = H.CNTR_NO(+)" ).append("\n"); 
		query.append("										 AND    B.BKG_NO              = H.BKG_NO(+)" ).append("\n"); 
		query.append("										 --AND    B.BKG_NO_SPLIT        = H.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("										 AND    H.COP_STS_CD(+) <> 'X'" ).append("\n"); 
		query.append("										 AND    H.PCTL_NO              = G.PCTL_NO(+)" ).append("\n"); 
		query.append("										 AND    G.NOD_LNK_DIV_CD(+)   = 'N'" ).append("\n"); 
		query.append("										--AND    G.ORG_NOD_CD(+)       = [yd_cd]  --vvd, sce, prd 에서 값을제대로 못가지고 와서 밑에쿼리로 변경" ).append("\n"); 
		query.append("										AND    SUBSTR(G.ORG_NOD_CD(+),1,5)       = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("	-- 본래는 Booking 정보만을 기준으로 Verify 결과(DDI, DDF, CO)를 가져오게 되어 있었다. (TES_FILE_IMP_TMP Table은 Join 되어 있지 않았었음)" ).append("\n"); 
		query.append("	-- Full/MT 여부는 아래 구문에서 확인하게 되어 있었지만 (L, TES_FILE_IMP_TMP 의 Full/MT를 비교)" ).append("\n"); 
		query.append("	-- Empty Repo Booking을 가진 MT Container를 Full CNTR라고 입력 후 Verify시 Verify 결과값(DDF)를 정상적으로 가져오지 못함." ).append("\n"); 
		query.append("	-- (CO, DD도 아닌 공란이 결과로 나옴. Discrepancy Type 결정시 사용할 Subquery L 의 값이 F/M 값 때문에 걸러졌기 때문)" ).append("\n"); 
		query.append("	-- 원래보다 한 단계 전에 Full MT를 비교하도록 Logic 수정하여 반영함.                                          --- 2008.01.16" ).append("\n"); 
		query.append("	-- CNTR_NO도 조건절에 추가.                                                                                   --- 2008.01.29" ).append("\n"); 
		query.append("										 AND    P.TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("										 AND    P.TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append("										 AND    P.CNTR_NO             = B.CNTR_NO(+)" ).append("\n"); 
		query.append("										 AND    P.CNTR_STY_CD         = B.FM(+)" ).append("\n"); 
		query.append("                                         AND    G.PCTL_SEQ = ( SELECT --//2011-11-24 추가" ).append("\n"); 
		query.append("                                                                    CASE" ).append("\n"); 
		query.append("                                                                    WHEN ORG_NOD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                                                    THEN PCTL_SEQ-1" ).append("\n"); 
		query.append("                                                                    WHEN DEST_NOD_CD = @[yd_cd] " ).append("\n"); 
		query.append("                                                                    THEN PCTL_SEQ+1" ).append("\n"); 
		query.append("                                                                    END CUR_PCTL_SEQ" ).append("\n"); 
		query.append("                                                                FROM PRD_PROD_CTL_ROUT_DTL X" ).append("\n"); 
		query.append("                                                                WHERE 1=1" ).append("\n"); 
		query.append("                                                                AND X.PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("                                                                AND X.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                                AND X.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                                AND X.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                                AND ROWNUM = 1 )" ).append("\n"); 
		query.append("										 GROUP BY B.BKG_NO, P.CNTR_NO, B.TPSZ, B.FM ) L, PRD_PROD_CTL_ROUT_DTL R, PRD_PROD_CTL_ROUT_DTL O" ).append("\n"); 
		query.append("								 WHERE  L.CNTR_NO             = P.CNTR_NO" ).append("\n"); 
		query.append("-- 이미 L 부분의 SQL 안에서 Booking의 Full/MT 여부를 확인했기 때문에 아래의 Full/MT 비교구문은 사용하지 않도록 수정함.  --- 2008.01.16" ).append("\n"); 
		query.append("--			                             AND    L.FM(+)               = P.CNTR_STY_CD" ).append("\n"); 
		query.append("								 AND    L.COP_NO              = R.PCTL_NO(+)" ).append("\n"); 
		query.append("								 AND    R.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("								 AND    L.R_SEQ               = R.PCTL_SEQ(+)" ).append("\n"); 
		query.append("								 AND    L.COP_NO              = O.PCTL_NO(+)" ).append("\n"); 
		query.append("								 AND    O.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("								 AND    L.O_SEQ               = O.PCTL_SEQ(+)" ).append("\n"); 
		query.append("                                 AND    ROWNUM = 1 " ).append("\n"); 
		query.append("                                 ) )" ).append("\n"); 
		query.append("					 END  DSCR_IND_CD" ).append("\n"); 
		query.append("			 FROM  TES_FILE_IMP_TMP P, MST_CONTAINER C," ).append("\n"); 
		query.append("-- [CHM-201640867]EDI 전송건 인보이스 UPLOAD 시간 과다 발생 (SQL Tunning 받은 결과 반영) - 2016.03.28" ).append("\n"); 
		query.append("				   (SELECT /*+ LEADING(B) USE_NL(A) */ B.CNTR_NO, 'Double billing Inv : '||MAX(A.INV_NO) CNTR_RMK" ).append("\n"); 
		query.append("					FROM   TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("					WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					AND    A.TML_SO_SEQ         = B.TML_SO_SEQ" ).append("\n"); 
		query.append("-- [CHM-201539158]Invoice CNTR Verify로직 수정 요청(Double Billing비교 부분) 2015.12.10 속도개선을 위해 수정" ).append("\n"); 
		query.append("--					AND    ( A.VNDR_SEQ, A.YD_CD ) IN ( SELECT DISTINCT VNDR_SEQ, YD_CD" ).append("\n"); 
		query.append("--														FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("--														WHERE  TML_SO_OFC_CTY_CD  = [tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("--														AND    TML_SO_SEQ         = [tml_so_seq] )					" ).append("\n"); 
		query.append("					AND    A.VNDR_SEQ 			= @[vndr_seq]" ).append("\n"); 
		query.append("					AND	   A.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("					AND    B.VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("					AND    B.SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("					AND    B.SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("					AND    B.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("					AND	   NVL(B.CLPT_IND_SEQ,'1') = NVL(@[clpt_ind_seq],'1')" ).append("\n"); 
		query.append("					AND	   NVL(B.CALL_YD_IND_SEQ,'1') = NVL(@[call_yd_ind_seq],'1')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					AND    NVL(A.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("					AND    A.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append("-- 김기영 부장님 요청으로 double billing checking period를 현재 3개월에서 (+/-)7일로 수정 - 2007.07.16" ).append("\n"); 
		query.append("-- 김기영 부장님 요청으로 receive date 비교로직 삭제함. - 2008.04.17" ).append("\n"); 
		query.append("--			                AND    MONTHS_BETWEEN(TO_DATE(?,'YYYY/MM/DD'),A.RCV_DT ) <= 0.25" ).append("\n"); 
		query.append("					GROUP BY B.CNTR_NO" ).append("\n"); 
		query.append("					) DB" ).append("\n"); 
		query.append("			 WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("			 AND   P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("			 AND   P.CNTR_NO           = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("			 AND   P.CNTR_NO           = C.CNTR_NO(+) ) A," ).append("\n"); 
		query.append("		   ( SELECT L.CNTR_NO," ).append("\n"); 
		query.append("					L.TPSZ," ).append("\n"); 
		query.append("					L.FM," ).append("\n"); 
		query.append("					L.IPC," ).append("\n"); 
		query.append("					L.LANE," ).append("\n"); 
		query.append("					DECODE(L.SPCL_FDR_FLG,'N',DECODE(L.PCTL_IO_BND_CD,'T',DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD," ).append("\n"); 
		query.append("																	   'WDVD','T','VDWD','T','WDWD','T','VDVD','T',DECODE(L.FM,'M','L','L')),'L')," ).append("\n"); 
		query.append("											  DECODE(L.IO,'I',DECODE(L.VSL_POD_CD,L.POD_CD,DECODE(L.VSL_POL_CD,L.POL_CD,'L','T'),'T')," ).append("\n"); 
		query.append("														  'O',DECODE(L.VSL_POL_CD,L.POL_CD,DECODE(L.VSL_POD_CD,L.POD_CD,'L','T'),'T'))) TS," ).append("\n"); 
		query.append("--			                                          DECODE(L.IO,'I',DECODE(L.VSL_POD_CD, L.POD_CD,'L','T'),'O',DECODE(L.VSL_POL_CD, L.POL_CD,'L','T'))) TS," ).append("\n"); 
		query.append("--			                DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD,'WDVD','T','VDWD','T','WDWD','T','VDVD','T',DECODE(L.FM,'M','L','L')) TS," ).append("\n"); 
		query.append("					CASE WHEN L.SPCL_FDR_FLG = 'N'" ).append("\n"); 
		query.append("						 THEN DECODE(DECODE(L.PCTL_IO_BND_CD,'T',DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD," ).append("\n"); 
		query.append("											'WDVD','T', 'VDWD','T', 'WDWD','T','VDVD','T', DECODE(L.FM,'M','L','L')),'L')," ).append("\n"); 
		query.append("									 'L', DECODE(L.FM, 'F',DECODE(@[io_bnd_cd], 'O',DECODE(R.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')," ).append("\n"); 
		query.append("																		   DECODE(RL,0,DECODE(TR,'RD','R','WD','B','TD','T','T'),'R'))," ).append("\n"); 
		query.append("													   'M',DECODE(O.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O'))," ).append("\n"); 
		query.append("									 VSL_TP) --TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("						 ELSE DECODE(" ).append("\n"); 
		query.append("							  DECODE(L.VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("											DECODE(L.IO,'I',DECODE(VSL_TP,'F',DECODE(L.VSL_POL_CD,L.FDR_POL_CD,'B','F'),VSL_TP)," ).append("\n"); 
		query.append("															DECODE(VSL_TP,'F',DECODE(L.VSL_POD_CD,L.FDR_POD_CD,'B','F'),VSL_TP)))" ).append("\n"); 
		query.append("							  ||DECODE(L.BY_VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("											DECODE(L.IO,'I',DECODE(BY_VSL_TP,'F',DECODE(L.BY_VSL_POD_CD,L.BY_FDR_POD_CD,'B','F'),BY_VSL_TP)," ).append("\n"); 
		query.append("														   DECODE(BY_VSL_TP,'F',DECODE(L.BY_VSL_POL_CD,L.BY_FDR_POL_CD,'B','F'),BY_VSL_TP)))" ).append("\n"); 
		query.append("							  ,'VV','V',    'VB','B',   'VF','F',   'BV','B',   'FV','F',   VSL_TP)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 남중국 BARGE 재적용 전  -- 2008.05.29" ).append("\n"); 
		query.append("--			                     ELSE DECODE(L.VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("--			                                        DECODE(L.IO,'I',DECODE(VSL_TP,'F',DECODE(L.VSL_POL_CD,L.FDR_POL_CD,'B','F'),VSL_TP)," ).append("\n"); 
		query.append("--			                                                        DECODE(VSL_TP,'F',DECODE(L.VSL_POD_CD,L.FDR_POD_CD,'B','F'),VSL_TP)))" ).append("\n"); 
		query.append("					END TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("					L.RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("					L.BKG_NO," ).append("\n"); 
		query.append("					--L.BKG_NO_SPLIT ," ).append("\n"); 
		query.append("					L.BL_NO," ).append("\n"); 
		query.append("					--L.BL_NO_CHK," ).append("\n"); 
		query.append("					L.BL_NO_TP," ).append("\n"); 
		query.append("					DECODE(L.FM,'M',DECODE(SUBSTR(L.YD_CD,1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("									DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N')," ).append("\n"); 
		query.append("										'WDTD','I',       'WDRD','I',     'VDTD','I'," ).append("\n"); 
		query.append("										'VDRD','I',       'RDWD','O',     'RDVD','O'," ).append("\n"); 
		query.append("										'TDWD','O',       'TDVD','O',     'WDN','I'," ).append("\n"); 
		query.append("										'VDN','I',        'NVD','O',      'NWD','O'," ).append("\n"); 
		query.append("										'WDVD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("										'VDWD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("										'WDWD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("										'VDVD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O'))) IO," ).append("\n"); 
		query.append("					L.DCGO_CLSS_CD," ).append("\n"); 
		query.append("					L.BB_CGO_FLG," ).append("\n"); 
		query.append("					L.AWK_CGO_FLG," ).append("\n"); 
		query.append("					L.RC_FLG," ).append("\n"); 
		query.append("					L.REMARK," ).append("\n"); 
		query.append("--			                DECODE(DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD," ).append("\n"); 
		query.append("--			                                'WDVD','T',     'VDWD','T',     'WDWD','T'," ).append("\n"); 
		query.append("--			                                'VDVD','T',     DECODE(L.FM,'M','L','L')),'L'," ).append("\n"); 
		query.append("--			                                DECODE(L.FM," ).append("\n"); 
		query.append("--			                                        'F',DECODE(?," ).append("\n"); 
		query.append("--			                                                    'O',DECODE(R.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')," ).append("\n"); 
		query.append("--			                                                    DECODE(RL,0,DECODE(TR,'RD','R','WD','B','TD','T','T'),'R'))," ).append("\n"); 
		query.append("--			                                        'M',DECODE(O.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')),              VSL_TP) TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("					L.TMP_SEQ" ).append("\n"); 
		query.append("			 FROM (SELECT   B.CNTR_NO           CNTR_NO," ).append("\n"); 
		query.append("							B.TPSZ              TPSZ," ).append("\n"); 
		query.append("							B.FM                FM," ).append("\n"); 
		query.append("							B.IPC               IPC," ).append("\n"); 
		query.append("							B.LANE              LANE," ).append("\n"); 
		query.append("							MIN(B.RCVDE_TERM_IND_CD) RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("							MIN(B.BKG_NO)       BKG_NO," ).append("\n"); 
		query.append("							--MIN(B.BKG_NO_SPLIT) BKG_NO_SPLIT," ).append("\n"); 
		query.append("							MIN(B.BL_NO)        BL_NO," ).append("\n"); 
		query.append("							--MIN(B.BL_NO_CHK)    BL_NO_CHK," ).append("\n"); 
		query.append("							MIN(B.BL_NO_TP)     BL_NO_TP," ).append("\n"); 
		query.append("							MIN(G.PCTL_NO)       COP_NO," ).append("\n"); 
		query.append("							B.TP_CD             TP_CD," ).append("\n"); 
		query.append("							B.POL               POL," ).append("\n"); 
		query.append("							MIN(B.DCGO_CLSS_CD) DCGO_CLSS_CD," ).append("\n"); 
		query.append("							MIN(B.BB_CGO_FLG)   BB_CGO_FLG," ).append("\n"); 
		query.append("							MIN(B.AWK_CGO_FLG)  AWK_CGO_FLG," ).append("\n"); 
		query.append("							MIN(B.RC_FLG)       RC_FLG," ).append("\n"); 
		query.append("							B.RM                REMARK," ).append("\n"); 
		query.append("							B.VSL_TP            VSL_TP," ).append("\n"); 
		query.append("							B.BY_VSL_TP," ).append("\n"); 
		query.append("							B.TR                TR," ).append("\n"); 
		query.append("							B.RL                RL," ).append("\n"); 
		query.append("							B.YD_CD             YD_CD," ).append("\n"); 
		query.append("							B.TMP_SEQ           TMP_SEQ," ).append("\n"); 
		query.append("							B.VVD_CD            VVD_CD," ).append("\n"); 
		query.append("							B.IO                IO," ).append("\n"); 
		query.append("							B.SPCL_FDR_FLG," ).append("\n"); 
		query.append("							B.POL_CD AS VSL_POL_CD," ).append("\n"); 
		query.append("							B.POD_CD AS VSL_POD_CD," ).append("\n"); 
		query.append("							B.BY_VSL_POL_CD," ).append("\n"); 
		query.append("							B.BY_VSL_POD_CD," ).append("\n"); 
		query.append("							B.POL_CD," ).append("\n"); 
		query.append("							B.POD_CD," ).append("\n"); 
		query.append("							B.FDR_POL_CD," ).append("\n"); 
		query.append("							B.FDR_POD_CD," ).append("\n"); 
		query.append("							B.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("							B.BY_FDR_POL_CD," ).append("\n"); 
		query.append("							B.BY_FDR_POD_CD," ).append("\n"); 
		query.append("							B.BY_VSL_PRE_PST_CD," ).append("\n"); 
		query.append("							MIN(( SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("								  FROM    SCE_COP_HDR HD, PRD_PROD_CTL_ROUT_DTL GD" ).append("\n"); 
		query.append("								  WHERE   H.CNTR_NO         = HD.CNTR_NO" ).append("\n"); 
		query.append("								  AND     H.BKG_NO          = HD.BKG_NO" ).append("\n"); 
		query.append("								  --AND     H.BKG_NO_SPLIT    = HD.BKG_NO_SPLIT" ).append("\n"); 
		query.append("								  AND     HD.PCTL_NO         = GD.PCTL_NO" ).append("\n"); 
		query.append("								  AND     GD.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("								  AND     GD.PCTL_SEQ < G.PCTL_SEQ )) R_SEQ," ).append("\n"); 
		query.append("							MAX(( SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("								  FROM    SCE_COP_HDR OD, PRD_PROD_CTL_ROUT_DTL OG" ).append("\n"); 
		query.append("								  WHERE   OD.CNTR_NO        = H.CNTR_NO" ).append("\n"); 
		query.append("								  AND     OD.BKG_NO         = H.BKG_NO" ).append("\n"); 
		query.append("								  --AND     OD.BKG_NO_SPLIT   = H.BKG_NO_SPLIT" ).append("\n"); 
		query.append("								  AND     OD.PCTL_NO         = OG.PCTL_NO" ).append("\n"); 
		query.append("								  AND     OG.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("								  AND     OG.PCTL_SEQ > G.PCTL_SEQ )) O_SEQ" ).append("\n"); 
		query.append("                            --, G.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                              ,MAX((SELECT NVL(X.PCTL_IO_BND_CD,'') PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                FROM PRD_PROD_CTL_ROUT_DTL X" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND X.PCTL_NO = G.PCTL_NO" ).append("\n"); 
		query.append("                                AND X.PCTL_SEQ = ( SELECT " ).append("\n"); 
		query.append("                                                        CASE" ).append("\n"); 
		query.append("                                                        WHEN ORG_NOD_CD = @[yd_cd] " ).append("\n"); 
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
		query.append("                                                    AND ROWNUM = 1 ))) PCTL_IO_BND_CD" ).append("\n"); 
		query.append("				   FROM   ( SELECT X.* FROM ( SELECT  /*+ NO_EXPAND */  C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("									C.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("									DECODE(B.BKG_CGO_TP_CD,'F','F','B','F','R','R','M') FM," ).append("\n"); 
		query.append("									DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O') IPC," ).append("\n"); 
		query.append("									V.SLAN_CD LANE," ).append("\n"); 
		query.append("									B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("									V.BKG_NO        BKG_NO," ).append("\n"); 
		query.append("									--V.BKG_NO_SPLIT  BKG_NO_SPLIT," ).append("\n"); 
		query.append("									--V.EAI_EVNT_DT, " ).append("\n"); 
		query.append("									DENSE_RANK() OVER (PARTITION BY C.CNTR_NO ORDER BY V.CRE_DT DESC) BKG_RANK," ).append("\n"); 
		query.append("									--'' BKG_RANK," ).append("\n"); 
		query.append("									B.BL_NO 		BL_NO," ).append("\n"); 
		query.append("									--B.BL_NO_CHK 	BL_NO_CHK," ).append("\n"); 
		query.append("									B.BL_NO_TP 	BL_NO_TP," ).append("\n"); 
		query.append("									B.POL_CD       POL," ).append("\n"); 
		query.append("									B.BKG_CGO_TP_CD TP_CD," ).append("\n"); 
		query.append("									CASE WHEN D.CNTR_NO = C.CNTR_NO  THEN NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') ELSE 'N' END DCGO_CLSS_CD," ).append("\n"); 
		query.append("									NVL(C.BB_CGO_FLG,'N') BB_CGO_FLG," ).append("\n"); 
		query.append("									--DECODE(NVL(A.OVR_VOID_SLT_QTY,0),0,'N','Y') AWK_CGO_FLG," ).append("\n"); 
		query.append("									NVL(C.AWK_CGO_FLG,'N') AWK_CGO_FLG," ).append("\n"); 
		query.append("									NVL(C.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("									DECODE(NVL(C.BB_CGO_FLG,'N'),'Y','Break Bulk') RM," ).append("\n"); 
		query.append("									DECODE(L.VSL_SVC_TP_CD,'O',DECODE( (SELECT CRR_CD FROM MDM_VSL_CNTR  WHERE VSL_CD = S.VSL_CD),'SML','V','F'),'V') VSL_TP," ).append("\n"); 
		query.append("									DECODE(BL.VSL_SVC_TP_CD,'O',DECODE((SELECT CRR_CD FROM MDM_VSL_CNTR  WHERE VSL_CD = S.VSL_CD),'SML','V','F'),'V') BY_VSL_TP," ).append("\n"); 
		query.append("									CASE WHEN FDR.FDR_POL_CD is not null THEN 'Y' ELSE 'N' END SPCL_FDR_FLG," ).append("\n"); 
		query.append("									V.POL_CD VSL_POL_CD," ).append("\n"); 
		query.append("									V.POD_CD VSL_POD_CD," ).append("\n"); 
		query.append("									V.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("									BV.POL_CD  BY_VSL_POL_CD," ).append("\n"); 
		query.append("									BV.POD_CD  BY_VSL_POD_CD," ).append("\n"); 
		query.append("									BV.VSL_PRE_PST_CD  BY_VSL_PRE_PST_CD," ).append("\n"); 
		query.append("									B.POL_CD," ).append("\n"); 
		query.append("									B.POD_CD," ).append("\n"); 
		query.append("									F.FDR_POL_CD," ).append("\n"); 
		query.append("									F.FDR_POD_CD," ).append("\n"); 
		query.append("									BF.FDR_POL_CD  BY_FDR_POL_CD," ).append("\n"); 
		query.append("									BF.FDR_POD_CD  BY_FDR_POD_CD," ).append("\n"); 
		query.append("									P.YD_CD  YD_CD," ).append("\n"); 
		query.append("									P.VVD_CD VVD_CD," ).append("\n"); 
		query.append("									P.IO_BND_CD IO," ).append("\n"); 
		query.append("									P.TML_SO_TMP_SEQ TMP_SEQ," ).append("\n"); 
		query.append("								  ( SELECT MIN(TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("									FROM   TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("									WHERE  ( FM_NOD_CD = P.YD_CD OR TO_NOD_CD = P.YD_CD )" ).append("\n"); 
		query.append("									AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("									AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("									AND    CRE_DT < P.ATB_DT + 15 ) TR," ).append("\n"); 
		query.append("								  ( SELECT COUNT(*)" ).append("\n"); 
		query.append("									FROM   TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("									WHERE  ( FM_NOD_CD = P.YD_CD OR TO_NOD_CD = P.YD_CD )" ).append("\n"); 
		query.append("									AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("									AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("									AND    CRE_DT < P.ATB_DT + 15 ) RL" ).append("\n"); 
		query.append("							 FROM   TES_FILE_IMP_TMP P, BKG_VVD V,  (SELECT BV.*" ).append("\n"); 
		query.append("																		FROM BKG_VVD V, BKG_VVD BV" ).append("\n"); 
		query.append("																		WHERE V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("																		AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("																		AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("																		AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("																		AND DECODE(@[io_bnd_cd],'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ) = @[clpt_ind_seq] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("																		AND V.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("																		--AND V.BKG_NO_SPLIT = BV.BKG_NO_SPLIT" ).append("\n"); 
		query.append("																		AND DECODE(@[io_bnd_cd],'I',BV.POL_CD,BV.POD_CD) = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("																		AND DECODE(@[io_bnd_cd],'I',BV.POD_CLPT_IND_SEQ,BV.POL_CLPT_IND_SEQ) = @[clpt_ind_seq] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                        AND V.VSL_SEQ < BV.VSL_SEQ) BV," ).append("\n"); 
		query.append("									BKG_CONTAINER C, BKG_BOOKING B, BKG_DG_CGO D, BKG_AWK_CGO A," ).append("\n"); 
		query.append("									MDM_LOCATION BR, MDM_LOCATION BD, TES_TML_SPCL_FDR F, TES_TML_SPCL_FDR BF, TES_TML_SPCL_FDR FDR," ).append("\n"); 
		query.append("									VSK_VSL_SKD S, VSK_VSL_SKD BS, MDM_VSL_SVC_LANE L, MDM_VSL_SVC_LANE BL" ).append("\n"); 
		query.append("							 WHERE  P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("							 AND    P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("							 AND    V.VSL_CD           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("							 AND    V.SKD_VOY_NO       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("							 AND    V.SKD_DIR_CD       = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("							 AND    DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(P.YD_CD, 1, 5)" ).append("\n"); 
		query.append("-- [CHM-201640637]MR Invoice에 Calling Sequence추가하고 CNTR List가져올 때 Verify로직 추가 (2016.03.28)" ).append("\n"); 
		query.append("-- [CHM-201642766]INV Booking No.관련 yard calling Sequence검색로직 변경(2016.08.09)" ).append("\n"); 
		query.append("#if(${call_yd_seq_chk} == 'Y')" ).append("\n"); 
		query.append("							 AND    NVL(DECODE(@[io_bnd_cd],'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ),'1') = NVL(@[clpt_ind_seq],'1') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							 AND    V.BKG_NO           = BV.BKG_NO(+)" ).append("\n"); 
		query.append("							 --AND    V.BKG_NO_SPLIT     = BV.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							 AND    V.BKG_NO           = C.BKG_NO(+)" ).append("\n"); 
		query.append("							 --AND    V.BKG_NO_SPLIT     = C.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							 AND    C.CNTR_NO          = P.CNTR_NO" ).append("\n"); 
		query.append("							 AND    C.BKG_NO           = B.BKG_NO(+)" ).append("\n"); 
		query.append("							 --AND    C.BKG_NO_SPLIT     = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							 AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("							 AND    B.BKG_NO           = D.BKG_NO(+)" ).append("\n"); 
		query.append("							 --AND    B.BKG_NO_SPLIT     = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							 AND    C.CNTR_NO          = A.CNTR_NO(+)" ).append("\n"); 
		query.append("							 AND    C.BKG_NO           = A.BKG_NO(+)" ).append("\n"); 
		query.append("							 --AND    C.BKG_NO_SPLIT     = A.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							 AND    B.POR_CD           = BR.LOC_CD" ).append("\n"); 
		query.append("							 AND    B.POD_CD           = BD.LOC_CD" ).append("\n"); 
		query.append("							 AND    V.POD_CD       = F.FDR_POD_CD(+)" ).append("\n"); 
		query.append("							 AND    V.POL_CD       = F.FDR_POL_CD(+)" ).append("\n"); 
		query.append("							 AND    BV.POD_CD       = BF.FDR_POD_CD(+)" ).append("\n"); 
		query.append("							 AND    BV.POL_CD       = BF.FDR_POL_CD(+)" ).append("\n"); 
		query.append("							 AND    DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = DECODE(@[io_bnd_cd], 'I',FDR.FDR_POD_CD(+), FDR.FDR_POL_CD(+))" ).append("\n"); 
		query.append("							 AND    V.VSL_CD           = S.VSL_CD(+)" ).append("\n"); 
		query.append("							 AND    V.SKD_VOY_NO       = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("							 AND    V.SKD_DIR_CD       = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("							 AND    S.VSL_SLAN_CD          = L.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("							 AND    BV.VSL_CD          = BS.VSL_CD(+)" ).append("\n"); 
		query.append("							 AND    BV.SKD_VOY_NO      = BS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("							 AND    BV.SKD_DIR_CD      = BS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("							 AND    BS.VSL_SLAN_CD      = BL.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("--			                         ) B, SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("							 ) X WHERE BKG_RANK = 1 ) B, SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("					WHERE  B.CNTR_NO             = H.CNTR_NO(+)" ).append("\n"); 
		query.append("					AND    B.BKG_NO              = H.BKG_NO(+)" ).append("\n"); 
		query.append("					--AND    B.BKG_NO_SPLIT        = H.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("					AND    H.COP_STS_CD(+) <> 'X'" ).append("\n"); 
		query.append("					AND    H.PCTL_NO              = G.PCTL_NO(+)" ).append("\n"); 
		query.append("					AND    G.NOD_LNK_DIV_CD(+)   = 'N'" ).append("\n"); 
		query.append("					--AND    G.ORG_NOD_CD(+)       = [yd_cd]  --vvd, sce, prd 에서 값을제대로 못가지고 와서 밑에쿼리로 변경" ).append("\n"); 
		query.append("					AND    SUBSTR(G.ORG_NOD_CD(+),1,5)       = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("					GROUP BY B.CNTR_NO,B.TPSZ,B.FM,B.IPC,B.LANE,B.TP_CD,B.POL," ).append("\n"); 
		query.append("							 B.SPCL_FDR_FLG, B.VSL_POL_CD, B.VSL_POD_CD, B.POL_CD,B.POD_CD, B.FDR_POL_CD, B.FDR_POD_CD, B.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("							 B.BY_VSL_TP, B.BY_VSL_POL_CD, B.BY_VSL_POD_CD, B.BY_FDR_POL_CD, B.BY_FDR_POD_CD, B.BY_VSL_PRE_PST_CD," ).append("\n"); 
		query.append("							 B.RM,B.VSL_TP,B.TR,B.RL,B.YD_CD,B.TMP_SEQ,B.VVD_CD,B.IO--,G.PCTL_IO_BND_CD " ).append("\n"); 
		query.append("					) L, PRD_PROD_CTL_ROUT_DTL R, PRD_PROD_CTL_ROUT_DTL O" ).append("\n"); 
		query.append("			 WHERE  L.COP_NO              = R.PCTL_NO(+)" ).append("\n"); 
		query.append("			 AND    R.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("			 AND    L.R_SEQ               = R.PCTL_SEQ(+)" ).append("\n"); 
		query.append("			 AND    L.COP_NO              = O.PCTL_NO(+)" ).append("\n"); 
		query.append("			 AND    O.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("			 AND    L.O_SEQ               = O.PCTL_SEQ(+)" ).append("\n"); 
		query.append("	--2007.08.16" ).append("\n"); 
		query.append("	--Verify 결과가 DDI(Discrepancy By Detail Data + I/O BND)인경우 아래 조건에 걸려 BKG 관련 Data(BKG No, DG 등등)가 조회되지 않음" ).append("\n"); 
		query.append("	--COP 가 생성되지 않은 Data나 실제 I/O Bound가 다른 경우들이 아래에 해당함." ).append("\n"); 
		query.append("	--DDI 라도 BKG 관련 Data를 화면에 보여주기 위해 아래 조건을 삭제함" ).append("\n"); 
		query.append("--			         AND    DECODE(L.FM," ).append("\n"); 
		query.append("--			                        'M',DECODE(SUBSTR(L.YD_CD,1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("--			                        DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N')," ).append("\n"); 
		query.append("--			                                'WDTD','I',     'WDRD','I',     'VDTD','I'," ).append("\n"); 
		query.append("--			                                'VDRD','I',     'RDWD','O',     'RDVD','O'," ).append("\n"); 
		query.append("--			                                'TDWD','O',     'TDVD','O',     'WDN','I'," ).append("\n"); 
		query.append("--			                                'VDN','I',      'NVD','O',      'NWD','O'," ).append("\n"); 
		query.append("--			                                'WDVD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("--			                                'VDWD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("--			                                'WDWD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("--			                                'VDVD',DECODE(L.VVD_CD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O'))) = L.IO ) B" ).append("\n"); 
		query.append("			 ) B" ).append("\n"); 
		query.append("	WHERE   A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND     A.TMP_SEQ = B.TMP_SEQ(+)" ).append("\n"); 
		query.append("	-- Subquery B 부분에서는 Import한 File의 F/M값을 상관하지 않고 보여주게 되어 있었음." ).append("\n"); 
		query.append("	-- A와 B부분으니 F/M 이 같은값만 보여주도록 수정함" ).append("\n"); 
		query.append("	-- ( Booking 정보상의 F/M과 import 한 파일의 F/M 을  비교하는 구문 추가 )-- 2007.09.03" ).append("\n"); 
		query.append("	AND     A.CNTR_STY_CD = B.FM(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and ${fm_tp_length} == '1') " ).append("\n"); 
		query.append("	AND     A.CNTR_STY_CD = @[fm_tp]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and ${ts_tp_length} == '1') " ).append("\n"); 
		query.append("	AND     B.TS = @[ts_tp]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vrfy_tml_cd} != '' and ${yd_cd} != '' and ${tml_port_cd} != '' and ${vrfy_tml_cd} != ${tml_port_cd})" ).append("\n"); 
		query.append("--//invoice의 port(yard의 5자리)와 vrfy_tml_cd가 같다는것은 vrfy_tml_cd가 port라는 의미로 이전 CNTR verify와 동일하므로 yard별로 구별할 필요가 없다." ).append("\n"); 
		query.append(") X , CTM_MOVEMENT M --// 구주 털보 아찌 (2014-05-20)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     X.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND     M.ORG_YD_CD LIKE DECODE(@[vrfy_tml_cd],NULL,SUBSTR(@[yd_cd],1,5),'',SUBSTR(@[yd_cd],1,5),@[vrfy_tml_cd])||'%'" ).append("\n"); 
		query.append("AND     M.CRNT_VSL_CD           = X.VSL_CD" ).append("\n"); 
		query.append("AND     M.CRNT_SKD_VOY_NO       = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     M.CRNT_SKD_DIR_CD       = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     M.FCNTR_FLG             = DECODE(X.CNTR_STY_CD,'F','Y','N')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}