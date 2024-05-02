/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOReVerifyTerminalInvoiceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOReVerifyTerminalInvoiceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReVerifyTerminalInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOReVerifyTerminalInvoiceContainerListRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOReVerifyTerminalInvoiceContainerListRSQL").append("\n"); 
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
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,A.CNTR_STY_CD" ).append("\n"); 
		query.append("		,SUBSTR(A.VVD,1,4) VSL_CD" ).append("\n"); 
		query.append("		,SUBSTR(A.VVD,5,4) SKD_VOY_NO" ).append("\n"); 
		query.append("		,SUBSTR(A.VVD,9,1) SKD_DIR_CD" ).append("\n"); 
		query.append("		,A.IO_BND_CD" ).append("\n"); 
		query.append("		,@[atb_dt] ATB_DT" ).append("\n"); 
		query.append("		,A.VNDR_SEQ" ).append("\n"); 
		query.append("		,A.YD_CD" ).append("\n"); 
		query.append("		,A.RCV_DT" ).append("\n"); 
		query.append("		,A.WRK_DT" ).append("\n"); 
		query.append("-- 데이타 정제 작업으로 인한 Logic 수정  - CNTR LIST DSCR_IND_CD에 CO값 코드 부정합 ( 2009-09-16 )" ).append("\n"); 
		query.append("--		,A.DSCR_IND_CD" ).append("\n"); 
		query.append("	    ,DECODE(A.DSCR_IND_CD, 'CO', '', A.DSCR_IND_CD ) DSCR_IND_CD" ).append("\n"); 
		query.append("		,DECODE(LENGTH(A.DSCR_IND_CD),3, SUBSTR(A.DSCR_IND_CD,3,1),'') DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("		,B.BKG_NO" ).append("\n"); 
		query.append("		--,B.BKG_NO_SPLIT" ).append("\n"); 
		query.append("		,NVL(B.BB_CGO_FLG,'N') BB_CGO_FLG" ).append("\n"); 
		query.append("		,B.IPC         IOC_CD" ).append("\n"); 
		query.append("		,B.LANE        LANE_CD" ).append("\n"); 
		query.append("        ,B.SUB_TRD_CD" ).append("\n"); 
		query.append("		,B.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("		,B.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("		,DECODE(B.DCGO_CLSS_CD,null,'N',B.DCGO_CLSS_CD) DCGO_CLSS_CD" ).append("\n"); 
		query.append("		,NVL(B.AWK_CGO_FLG,'N') AWK_CGO_FLG" ).append("\n"); 
		query.append("		,NVL(B.RC_FLG,'N') RC_FLG" ).append("\n"); 
		query.append("		,B.BL_NO" ).append("\n"); 
		query.append("		--,B.BL_NO_CHK" ).append("\n"); 
		query.append("		--,B.BL_NO_TP" ).append("\n"); 
		query.append("		--,DECODE(A.DSCR_IND_CD,'CO',B.RM,'DB',A.CNTR_RMK,'')      CNTR_RMK" ).append("\n"); 
		query.append("        ,DECODE(A.DSCR_IND_CD,'CO',B.RM,'DB',A.CNTR_RMK,'NH',DECODE(LENGTH(BKG_NO),10,'This is OSCAR BKG',''),'') CNTR_RMK" ).append("\n"); 
		query.append("		,B.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("		,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN 'DC' ELSE 'CO' END VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("		,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN ''   ELSE 'Y'  END CO_FLG" ).append("\n"); 
		query.append("		,CASE WHEN SUBSTR(A.DSCR_IND_CD,0,2) IN  ('DD','NH','DB') THEN 'Y'  ELSE  ''  END DC_FLG" ).append("\n"); 
		query.append("FROM  ( SELECT P.CNTR_NO       CNTR_NO" ).append("\n"); 
		query.append("			   ,C.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			   ,P.CNTR_STY_CD  CNTR_STY_CD" ).append("\n"); 
		query.append("			   ,P.VVD_CD       VVD" ).append("\n"); 
		query.append("			   ,P.VNDR_SEQ     VNDR_SEQ" ).append("\n"); 
		query.append("			   ,P.YD_CD        YD_CD" ).append("\n"); 
		query.append("			   ,P.RCV_DT       RCV_DT" ).append("\n"); 
		query.append("			   ,P.WRK_DT       WRK_DT" ).append("\n"); 
		query.append("			   ,P.IO_BND_CD    IO_BND_CD" ).append("\n"); 
		query.append("			   ,P.TML_SO_TMP_SEQ TMP_SEQ" ).append("\n"); 
		query.append("			   ,DB.CNTR_RMK" ).append("\n"); 
		query.append("			   ,CASE WHEN LENGTH(DB.CNTR_RMK) > 1 THEN 'DB'" ).append("\n"); 
		query.append("			   ELSE DECODE(( SELECT COUNT(*) -- 'Not in COM Souce' Check" ).append("\n"); 
		query.append("							  FROM   CTM_MOVEMENT M, BKG_BOOKING B, MDM_LOCATION BR, MDM_LOCATION BD" ).append("\n"); 
		query.append("							  WHERE   M.ORG_YD_CD  = P.YD_CD" ).append("\n"); 
		query.append("--		                              WHERE   SUBSTR(M.ORG_YD_CD,1,5)  = SUBSTR(P.YD_CD,1,5)" ).append("\n"); 
		query.append("							  AND    M.CNTR_NO        = P.CNTR_NO" ).append("\n"); 
		query.append("							  AND    M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("							  AND    M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("							  AND    M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("							  AND    M.BKG_NO       = B.BKG_NO(+)" ).append("\n"); 
		query.append("							  --AND    M.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("							  AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("							  AND    B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("							  AND    B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("							   ),0,'NH'," ).append("\n"); 
		query.append("							( SELECT DD FROM" ).append("\n"); 
		query.append("								( SELECT M.FCNTR_FLG, P.CNTR_STY_CD,  M.OB_CNTR_FLG, P.IO_BND_CD, M.ORG_YD_CD, P.YD_CD," ).append("\n"); 
		query.append("										   DECODE(P.CNTR_STY_CD,DECODE(M.FCNTR_FLG,'Y','F','N','M',''),'CO','DDF') DD, P.CNTR_NO, P.TML_SO_SEQ" ).append("\n"); 
		query.append("										   , P.TML_SO_TMP_SEQ, P.TML_SO_OFC_CTY_CD, MAX(B.BKG_NO)--, MAX(B.BKG_NO_SPLIT)" ).append("\n"); 
		query.append("									FROM   CTM_MOVEMENT M, BKG_BOOKING B, BKG_DG_CGO D, MDM_LOCATION BR," ).append("\n"); 
		query.append("										   MDM_LOCATION BD, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("									WHERE  M.ORG_YD_CD  = P.YD_CD" ).append("\n"); 
		query.append("--		                                  	WHERE  SUBSTR(M.ORG_YD_CD,1,5)  = SUBSTR(P.YD_CD,1,5)" ).append("\n"); 
		query.append("									AND M.CNTR_NO        = P.CNTR_NO" ).append("\n"); 
		query.append("									AND M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("									AND M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("									AND M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("									AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("									--AND M.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("									AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("									AND M.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("									--AND M.BKG_NO_SPLIT = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("									AND M.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("									AND M.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("									AND B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("									AND B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("									AND P.TML_SO_OFC_CTY_CD= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("									AND P.TML_SO_SEQ       = @[tml_so_seq]" ).append("\n"); 
		query.append("									GROUP BY M.FCNTR_FLG, P.CNTR_STY_CD,  M.OB_CNTR_FLG, P.IO_BND_CD, M.ORG_YD_CD," ).append("\n"); 
		query.append("										P.YD_CD, DECODE(P.CNTR_STY_CD,DECODE(M.FCNTR_FLG,'Y','F','N','M',''),'CO','DDF'), P.CNTR_NO," ).append("\n"); 
		query.append("										P.TML_SO_SEQ, P.TML_SO_TMP_SEQ, P.TML_SO_OFC_CTY_CD)" ).append("\n"); 
		query.append("							  WHERE TML_SO_OFC_CTY_CD = P.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("							  AND TML_SO_SEQ = P.TML_SO_SEQ" ).append("\n"); 
		query.append("							  AND TML_SO_TMP_SEQ = P.TML_SO_TMP_SEQ" ).append("\n"); 
		query.append("							  AND CNTR_NO = P.CNTR_NO ) )" ).append("\n"); 
		query.append("			   END DSCR_IND_CD" ).append("\n"); 
		query.append("		FROM  TES_FILE_IMP_TMP P,  MST_CONTAINER C," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("                        SELECT   BB.CNTR_NO, 'Double billing Inv : '||MAX(BB.INV_NO) CNTR_RMK" ).append("\n"); 
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
		query.append("                                    AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("                                    AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                         FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                         WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                                         AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                                         AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                         AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("                                         AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-')) -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                                    AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                                    GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("                                    T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("                                WHERE  C.COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("                                AND    C.TML_AGMT_MGMT_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND    C.MRN_TML_FLG = 'Y'  -- Marine Terminal Invoice" ).append("\n"); 
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
		query.append("                                 AND    VVD_CD             = @[vvd]" ).append("\n"); 
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
		query.append("                        SELECT DISTINCT H.INV_NO, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD, L.CNTR_NO" ).append("\n"); 
		query.append("                         FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("                         WHERE  H.YD_CD             = @[yd_cd]" ).append("\n"); 
		query.append("                         AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("                         AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("                         AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("                         AND    L.VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                         AND    L.SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                         AND    L.SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                         AND    L.IO_BND_CD          = @[io_bnd_cd] -- ? hdr정보있는 값" ).append("\n"); 
		query.append("                         AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("						 AND    H.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append("                         AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("                         AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("						 AND  (DECODE(L.RVIS_IND_FLG,'Y',0,1) + DECODE(L.TML_RVIS_IND_FLG,'Y',0,1) + DECODE(L.STV_RVIS_IND_FLG,'Y',0,1) + DECODE(L.CGO_RVIS_IND_FLG,'Y',0,1) = 4) " ).append("\n"); 
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
		query.append("                         AND    DECODE(H.TML_INV_TP_CD,'TM','Y',L.VSL_CD) <> DECODE(H.TML_INV_TP_CD,'TM','N','CNTC')" ).append("\n"); 
		query.append("                        ) BB" ).append("\n"); 
		query.append("                        WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("                        AND AA.COST_CODE = BB.LGS_COST_CD" ).append("\n"); 
		query.append("                        group by BB.CNTR_NO" ).append("\n"); 
		query.append("                    ) DB" ).append("\n"); 
		query.append("		WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		AND   P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("		AND   P.CNTR_NO           = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND   P.CNTR_NO        = C.CNTR_NO(+)) A," ).append("\n"); 
		query.append("		(SELECT M.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("			   M.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("			   M.FCNTR_FLG FM," ).append("\n"); 
		query.append("			   DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O') IPC," ).append("\n"); 
		query.append("			   VF.SLAN_CD LANE," ).append("\n"); 
		query.append("               O.SUB_TRD_CD," ).append("\n"); 
		query.append("			   B.BL_NO," ).append("\n"); 
		query.append("			   --B.BL_NO_TP," ).append("\n"); 
		query.append("			   --B.BL_NO_CHK," ).append("\n"); 
		query.append("--		               'L' TS," ).append("\n"); 
		query.append("			   B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("			   M.BKG_NO BKG_NO," ).append("\n"); 
		query.append("			   --M.BKG_NO_SPLIT BKG_NO_SPLIT," ).append("\n"); 
		query.append("			   NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') DCGO_CLSS_CD," ).append("\n"); 
		query.append("			   NVL(B.BB_CGO_FLG,'N') BB_CGO_FLG," ).append("\n"); 
		query.append("			   DECODE(NVL(A.OVR_VOID_SLT_QTY,0),0,'N','Y') AWK_CGO_FLG," ).append("\n"); 
		query.append("			   NVL(B.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("			   DECODE(NVL(B.BB_CGO_FLG,'N'),'Y','Break Bulk') RM," ).append("\n"); 
		query.append("			   CASE WHEN COUNT(VF.FDR_POD_CD_2) > 0" ).append("\n"); 
		query.append("					THEN DECODE(P.IO_BND_CD,'I',DECODE(VF.POD_CD,B.POD_CD,DECODE(VF.POL_CD,B.POL_CD,'L','T'),'T')," ).append("\n"); 
		query.append("											'O',DECODE(VF.POL_CD,B.POL_CD,DECODE(VF.POD_CD,B.POD_CD,'L','T'),'T'))" ).append("\n"); 
		query.append("					ELSE 'L'" ).append("\n"); 
		query.append("			   END LOCL_TS_IND_CD," ).append("\n"); 
		query.append("			   CASE WHEN COUNT(VF.FDR_POD_CD_2) > 0" ).append("\n"); 
		query.append("					THEN DECODE(VF.VSL_PRE_PST_CD,'T','V',NULL,'O','','O'," ).append("\n"); 
		query.append("											   DECODE(P.IO_BND_CD,'I',DECODE(VF.POL_CD,VF.FDR_POL_CD,'B','F')," ).append("\n"); 
		query.append("																	  DECODE(VF.POD_CD,VF.FDR_POD_CD,'B','F')))" ).append("\n"); 
		query.append("					ELSE  'B'" ).append("\n"); 
		query.append("			   END TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("			   P.TML_SO_TMP_SEQ TMP_SEQ" ).append("\n"); 
		query.append("		FROM TES_FILE_IMP_TMP P, CTM_MOVEMENT M, " ).append("\n"); 
		query.append("			(SELECT * " ).append("\n"); 
		query.append("				FROM BKG_BOOKING" ).append("\n"); 
		query.append("				WHERE 1=1 AND BKG_STS_CD IN ('F','W') " ).append("\n"); 
		query.append("			 )B," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT V.*,F.*, FDR.FDR_POD_CD AS FDR_POD_CD_2, FDR.FDR_POL_CD AS FDR_POL_CD_2" ).append("\n"); 
		query.append("				FROM BKG_VVD V,  TES_TML_SPCL_FDR F, TES_TML_SPCL_FDR FDR " ).append("\n"); 
		query.append("				WHERE DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = DECODE(@[io_bnd_cd], 'I',FDR.FDR_POD_CD(+), FDR.FDR_POL_CD(+))" ).append("\n"); 
		query.append("				AND V.POD_CD = F.FDR_POD_CD(+)" ).append("\n"); 
		query.append("				AND V.POL_CD = F.FDR_POL_CD(+)" ).append("\n"); 
		query.append("				AND SUBSTR(" ).append("\n"); 
		query.append("							(SELECT YD_CD FROM TES_FILE_IMP_TMP " ).append("\n"); 
		query.append("							 WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]                                                                                     " ).append("\n"); 
		query.append("							 AND TML_SO_SEQ = @[tml_so_seq]  " ).append("\n"); 
		query.append("							 AND ROWNUM=1), 1, 5) = DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD)                 " ).append("\n"); 
		query.append("			) VF," ).append("\n"); 
		query.append("			BKG_DG_CGO D," ).append("\n"); 
		query.append("			BKG_AWK_CGO A," ).append("\n"); 
		query.append("			MDM_LOCATION BR, MDM_LOCATION BD, COA_RGST_BKG O" ).append("\n"); 
		query.append("		WHERE P.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("		AND P.YD_CD = M.ORG_YD_CD" ).append("\n"); 
		query.append("		AND P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		AND P.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("		AND M.MVMT_STS_CD = DECODE(P.IO_BND_CD,'I','VD','VL')" ).append("\n"); 
		query.append("		AND M.CNMV_EVNT_DT > TO_DATE(P.WRK_DT,'YYYYMMDD') - 7" ).append("\n"); 
		query.append("		AND M.CNMV_EVNT_DT < TO_DATE(P.WRK_DT,'YYYYMMDD') + 7" ).append("\n"); 
		query.append("		AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("--		AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("		AND M.BKG_NO = VF.BKG_NO(+)" ).append("\n"); 
		query.append("		AND M.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("		AND M.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND M.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		AND M.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("		AND M.CNTR_NO = A.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND M.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        AND B.BKG_NO       = O.BKG_NO(+)" ).append("\n"); 
		query.append("        AND B.SLAN_CD      = O.SLAN_CD(+)" ).append("\n"); 
		query.append("        AND B.VSL_CD       = O.VSL_CD(+)" ).append("\n"); 
		query.append("     	AND B.SKD_VOY_NO   = O.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND B.SKD_DIR_CD   = O.DIR_CD(+)" ).append("\n"); 
		query.append("--		AND DECODE([io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(P.YD_CD, 1, 5)" ).append("\n"); 
		query.append("--		AND V.POD_CD = F.FDR_POD_CD(+)" ).append("\n"); 
		query.append("--		AND V.POL_CD = F.FDR_POL_CD(+)" ).append("\n"); 
		query.append("--		AND DECODE([io_bnd_cd],'I',V.POD_CD,V.POL_CD) = DECODE([io_bnd_cd], 'I',FDR.FDR_POD_CD(+), FDR.FDR_POL_CD(+))" ).append("\n"); 
		query.append("		AND B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("		AND B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 
		query.append("		GROUP BY M.CNTR_NO, VF.VSL_PRE_PST_CD, VF.VSL_SEQ, VF.POD_CD, VF.POL_CD, VF.FDR_POD_CD, VF.FDR_POL_CD," ).append("\n"); 
		query.append("				DECODE(P.IO_BND_CD,'I',DECODE(VF.POD_CD,B.POD_CD,'L','T'),'O',DECODE(VF.POL_CD,B.POL_CD,'L','T'))," ).append("\n"); 
		query.append("				P.IO_BND_CD, VF.VSL_PRE_PST_CD, M.CNTR_TPSZ_CD, M.FCNTR_FLG, DECODE(BR.CONTI_CD,BD.CONTI_CD,'I','O')," ).append("\n"); 
		query.append("				VF.SLAN_CD, O.SUB_TRD_CD, B.BL_NO, B.RCV_TERM_CD||'/'||B.DE_TERM_CD, M.BKG_NO ,--M.BKG_NO_SPLIT," ).append("\n"); 
		query.append("				D.IMDG_CLSS_CD, B.BB_CGO_FLG, A.OVR_VOID_SLT_QTY, B.RC_FLG, B.BB_CGO_FLG,B.POL_CD," ).append("\n"); 
		query.append("				B.POD_CD,P.TML_SO_TMP_SEQ  )B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   A.TMP_SEQ = B.TMP_SEQ(+)" ).append("\n"); 

	}
}