/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListCNTCRSQL.java
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

public class MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListCNTCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyTerminalInvoiceContainerListCNTC
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListCNTCRSQL(){
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
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListCNTCRSQL").append("\n"); 
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
		query.append("SELECT  /*+ NO_QUERY_TRANSFORMATION */ A.CNTR_NO" ).append("\n"); 
		query.append("			,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,A.CNTR_STY_CD" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,1,4) VSL_CD" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,5,4) SKD_VOY_NO" ).append("\n"); 
		query.append("			,SUBSTR(A.VVD,9,1) SKD_DIR_CD" ).append("\n"); 
		query.append("			,A.IO_BND_CD" ).append("\n"); 
		query.append("			,@[atb_dt] ATB_DT" ).append("\n"); 
		query.append("			,A.VNDR_SEQ" ).append("\n"); 
		query.append("			,A.YD_CD" ).append("\n"); 
		query.append("			,A.RCV_DT" ).append("\n"); 
		query.append("			,A.WRK_DT" ).append("\n"); 
		query.append("-- 데이타 정제 작업으로 인한 Logic 수정  - CNTR LIST DSCR_IND_CD에 CO값 코드 부정합 ( 2009-09-16 )" ).append("\n"); 
		query.append("--			,A.DSCR_IND_CD" ).append("\n"); 
		query.append("			,DECODE(A.DSCR_IND_CD, 'CO', '', A.DSCR_IND_CD ) DSCR_IND_CD " ).append("\n"); 
		query.append("			,DECODE(LENGTH(A.DSCR_IND_CD),3, SUBSTR(A.DSCR_IND_CD,3,1),'') DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("			,B.BKG_NO" ).append("\n"); 
		query.append("			--,B.BKG_NO_SPLIT" ).append("\n"); 
		query.append("			,NVL(B.BB_CGO_FLG,'N') BB_CGO_FLG" ).append("\n"); 
		query.append("			,B.IPC         IOC_CD" ).append("\n"); 
		query.append("			,B.LANE        LANE_CD" ).append("\n"); 
		query.append("			,B.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("			,B.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("			,DECODE(B.DCGO_CLSS_CD,null,'N',B.DCGO_CLSS_CD) DCGO_CLSS_CD" ).append("\n"); 
		query.append("			,NVL(B.AWK_CGO_FLG,'N') AWK_CGO_FLG" ).append("\n"); 
		query.append("			,NVL(B.RC_FLG,'N') RC_FLG" ).append("\n"); 
		query.append("			,B.BL_NO" ).append("\n"); 
		query.append("			--,B.BL_NO_CHK" ).append("\n"); 
		query.append("			--,B.BL_NO_TP" ).append("\n"); 
		query.append("			,DECODE(A.DSCR_IND_CD,'CO',B.RM,'DB',A.CNTR_RMK,'')      CNTR_RMK" ).append("\n"); 
		query.append("			,B.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN 'DC' ELSE 'CO' END VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN ''   ELSE 'Y'  END CO_FLG" ).append("\n"); 
		query.append("			,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN 'Y'  ELSE  ''  END DC_FLG" ).append("\n"); 
		query.append("			,@[clpt_ind_seq] CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,@[call_yd_ind_seq] CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	FROM  ( SELECT P.CNTR_NO       CNTR_NO" ).append("\n"); 
		query.append("				   ,C.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				   ,P.CNTR_STY_CD  CNTR_STY_CD" ).append("\n"); 
		query.append("				   ,P.VVD_CD       VVD" ).append("\n"); 
		query.append("				   ,P.VNDR_SEQ     VNDR_SEQ" ).append("\n"); 
		query.append("				   ,P.YD_CD        YD_CD" ).append("\n"); 
		query.append("				   ,P.RCV_DT       RCV_DT" ).append("\n"); 
		query.append("				   ,P.WRK_DT       WRK_DT" ).append("\n"); 
		query.append("				   ,P.IO_BND_CD    IO_BND_CD" ).append("\n"); 
		query.append("				   ,P.TML_SO_TMP_SEQ TMP_SEQ" ).append("\n"); 
		query.append("				   ,DB.CNTR_RMK" ).append("\n"); 
		query.append("				   ,CASE WHEN LENGTH(DB.CNTR_RMK) > 1 THEN 'DB'" ).append("\n"); 
		query.append("				   ELSE DECODE(( SELECT COUNT(*) -- 'Not in SML Souce' Check" ).append("\n"); 
		query.append("								  FROM   CTM_MOVEMENT M, BKG_BOOKING B, MDM_LOCATION BR, MDM_LOCATION BD" ).append("\n"); 
		query.append("								  WHERE   M.ORG_YD_CD  = P.YD_CD" ).append("\n"); 
		query.append("								  AND    M.CNTR_NO        = P.CNTR_NO" ).append("\n"); 
		query.append("								  AND    M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("								  AND    M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("								  AND    M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("								  AND    M.BKG_NO       = B.BKG_NO(+)" ).append("\n"); 
		query.append("								  --AND    M.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("								  AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("								  AND    B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("								  AND    B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("								   ),0,'NH'," ).append("\n"); 
		query.append("								( SELECT DD FROM" ).append("\n"); 
		query.append("									( SELECT M.FCNTR_FLG, P.CNTR_STY_CD,  M.OB_CNTR_FLG, P.IO_BND_CD, M.ORG_YD_CD, P.YD_CD," ).append("\n"); 
		query.append("											   DECODE(P.CNTR_STY_CD,DECODE(M.FCNTR_FLG,'Y','F','N','M',''),'CO','DDF') DD, P.CNTR_NO, P.TML_SO_SEQ" ).append("\n"); 
		query.append("											   , P.TML_SO_TMP_SEQ, P.TML_SO_OFC_CTY_CD, MAX(B.BKG_NO)--, MAX(B.BKG_NO_SPLIT)" ).append("\n"); 
		query.append("										FROM   CTM_MOVEMENT M, BKG_BOOKING B, BKG_DG_CGO D, MDM_LOCATION BR," ).append("\n"); 
		query.append("											   MDM_LOCATION BD, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("										WHERE  M.ORG_YD_CD  = P.YD_CD" ).append("\n"); 
		query.append("										AND M.CNTR_NO        = P.CNTR_NO" ).append("\n"); 
		query.append("										AND M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("										AND M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("										AND M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("										AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("										--AND M.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("										AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("										AND M.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("										--AND M.BKG_NO_SPLIT = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("										AND M.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("										AND M.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("										AND B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("										AND B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("										AND P.TML_SO_OFC_CTY_CD= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("										AND P.TML_SO_SEQ       = @[tml_so_seq]" ).append("\n"); 
		query.append("										GROUP BY M.FCNTR_FLG, P.CNTR_STY_CD,  M.OB_CNTR_FLG, P.IO_BND_CD, M.ORG_YD_CD," ).append("\n"); 
		query.append("											   P.YD_CD, DECODE(P.CNTR_STY_CD,DECODE(M.FCNTR_FLG,'Y','F','N','M',''),'CO','DDF'), P.CNTR_NO," ).append("\n"); 
		query.append("											   P.TML_SO_SEQ, P.TML_SO_TMP_SEQ, P.TML_SO_OFC_CTY_CD )" ).append("\n"); 
		query.append("								  WHERE TML_SO_OFC_CTY_CD = P.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								  AND TML_SO_SEQ = P.TML_SO_SEQ" ).append("\n"); 
		query.append("								  AND TML_SO_TMP_SEQ = P.TML_SO_TMP_SEQ" ).append("\n"); 
		query.append("								  AND CNTR_NO = P.CNTR_NO ) )" ).append("\n"); 
		query.append("				   END DSCR_IND_CD" ).append("\n"); 
		query.append("			FROM  TES_FILE_IMP_TMP P,  MST_CONTAINER C," ).append("\n"); 
		query.append("				   (SELECT /*+ LEADING(B) USE_NL(A) */ B.CNTR_NO, 'Double billing Inv : '||MAX(A.INV_NO) CNTR_RMK" ).append("\n"); 
		query.append("					FROM   TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("					WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					AND    A.TML_SO_SEQ         = B.TML_SO_SEQ" ).append("\n"); 
		query.append("--					AND    ( A.VNDR_SEQ, A.YD_CD ) IN ( SELECT DISTINCT VNDR_SEQ, YD_CD" ).append("\n"); 
		query.append("--														FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("--														WHERE  TML_SO_OFC_CTY_CD  = [tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("--														AND    TML_SO_SEQ         = [tml_so_seq] )" ).append("\n"); 
		query.append("					AND    A.VNDR_SEQ 		  = @[vndr_seq]" ).append("\n"); 
		query.append("					AND	   A.YD_CD			  = @[yd_cd]" ).append("\n"); 
		query.append("					AND    B.VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("					AND    B.SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("					AND    B.SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("					AND    B.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("					AND    NVL(A.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("					AND    A.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append("-- 김기영 부장님 요청으로 receive date 비교로직 삭제함. - 2008.04.17" ).append("\n"); 
		query.append("--			                AND    MONTHS_BETWEEN(TO_DATE(?,'YYYY/MM/DD'),A.RCV_DT ) <= 0.25" ).append("\n"); 
		query.append("					GROUP BY B.CNTR_NO" ).append("\n"); 
		query.append("					) DB" ).append("\n"); 
		query.append("			WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("			AND   P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("			AND   P.CNTR_NO           = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("			AND   P.CNTR_NO        = C.CNTR_NO(+)) A," ).append("\n"); 
		query.append("			(SELECT M.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("				   M.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("				   M.FCNTR_FLG FM," ).append("\n"); 
		query.append("				   DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O') IPC," ).append("\n"); 
		query.append("				   V.SLAN_CD LANE," ).append("\n"); 
		query.append("				   B.BL_NO," ).append("\n"); 
		query.append("				   --B.BL_NO_TP," ).append("\n"); 
		query.append("				   --B.BL_NO_CHK," ).append("\n"); 
		query.append("				   B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("				   M.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				   --M.BKG_NO_SPLIT BKG_NO_SPLIT," ).append("\n"); 
		query.append("				   NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("				   NVL(B.BB_CGO_FLG,'N') BB_CGO_FLG," ).append("\n"); 
		query.append("				   DECODE(NVL(A.OVR_VOID_SLT_QTY,0),0,'N','Y') AWK_CGO_FLG," ).append("\n"); 
		query.append("				   NVL(B.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("				   DECODE(NVL(B.BB_CGO_FLG,'N'),'Y','Break Bulk') RM," ).append("\n"); 
		query.append("				   CASE WHEN COUNT(FDR.FDR_POD_CD) > 0" ).append("\n"); 
		query.append("						THEN DECODE(P.IO_BND_CD,'I',DECODE(V.POD_CD,B.POD_CD,DECODE(V.POL_CD,B.POL_CD,'L','T'),'T')," ).append("\n"); 
		query.append("												'O',DECODE(V.POL_CD,B.POL_CD,DECODE(V.POD_CD,B.POD_CD,'L','T'),'T'))" ).append("\n"); 
		query.append("						ELSE 'L'" ).append("\n"); 
		query.append("				   END LOCL_TS_IND_CD," ).append("\n"); 
		query.append("				   CASE WHEN COUNT(FDR.FDR_POD_CD) > 0" ).append("\n"); 
		query.append("						THEN DECODE(V.VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("												   DECODE(P.IO_BND_CD,'I',DECODE(V.POL_CD,F.FDR_POL_CD,'B','F')," ).append("\n"); 
		query.append("																		  DECODE(V.POD_CD,F.FDR_POD_CD,'B','F')))" ).append("\n"); 
		query.append("						ELSE  'B'" ).append("\n"); 
		query.append("				   END TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("				   P.TML_SO_TMP_SEQ TMP_SEQ" ).append("\n"); 
		query.append("			FROM TES_FILE_IMP_TMP P, CTM_MOVEMENT M, BKG_BOOKING B, BKG_VVD V, BKG_DG_CGO D," ).append("\n"); 
		query.append("				BKG_AWK_CGO A, TES_TML_SPCL_FDR F, TES_TML_SPCL_FDR FDR, MDM_LOCATION BR, MDM_LOCATION BD" ).append("\n"); 
		query.append("			WHERE P.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("			AND P.YD_CD = M.ORG_YD_CD" ).append("\n"); 
		query.append("			AND P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("			AND P.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("			AND M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("			AND M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("			AND M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("			AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("			--AND M.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("			AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("			AND M.BKG_NO = V.BKG_NO(+)" ).append("\n"); 
		query.append("			--AND M.BKG_NO_SPLIT = V.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("			AND M.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("			--AND M.BKG_NO_SPLIT = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("			AND M.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("			AND M.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("			AND M.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("			--AND M.BKG_NO_SPLIT = A.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("			AND M.CNTR_NO = A.CNTR_NO(+)" ).append("\n"); 
		query.append("			AND M.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("			AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(P.YD_CD,1, 5)" ).append("\n"); 
		query.append("			AND V.POD_CD = F.FDR_POD_CD(+)" ).append("\n"); 
		query.append("			AND V.POL_CD = F.FDR_POL_CD(+)" ).append("\n"); 
		query.append("			AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = DECODE(@[io_bnd_cd], 'I',FDR.FDR_POD_CD(+), FDR.FDR_POL_CD(+))" ).append("\n"); 
		query.append("			AND B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("			AND B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("			GROUP BY M.CNTR_NO,V.VSL_PRE_PST_CD,V.VSL_SEQ,V.POD_CD,V.POL_CD,F.FDR_POD_CD,F.FDR_POL_CD," ).append("\n"); 
		query.append("					DECODE(P.IO_BND_CD,'I',DECODE(V.POD_CD,B.POD_CD,'L','T'),'O',DECODE(V.POL_CD,B.POL_CD,'L','T'))," ).append("\n"); 
		query.append("					P.IO_BND_CD, V.VSL_PRE_PST_CD, M.CNTR_TPSZ_CD, M.FCNTR_FLG, DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O')," ).append("\n"); 
		query.append("					V.SLAN_CD, B.BL_NO, B.RCV_TERM_CD||'/'||B.DE_TERM_CD, M.BKG_NO ,--M.BKG_NO_SPLIT," ).append("\n"); 
		query.append("					D.IMDG_CLSS_CD, B.BB_CGO_FLG, A.OVR_VOID_SLT_QTY, B.RC_FLG, B.BB_CGO_FLG,B.POL_CD," ).append("\n"); 
		query.append("					B.POD_CD,P.TML_SO_TMP_SEQ )B" ).append("\n"); 
		query.append("	WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND   A.TMP_SEQ = B.TMP_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and ${fm_tp_length} == '1') " ).append("\n"); 
		query.append("	AND     A.CNTR_STY_CD = @[fm_tp]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and ${ts_tp_length} == '1') " ).append("\n"); 
		query.append("	AND     B.LOCL_TS_IND_CD = @[ts_tp]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}