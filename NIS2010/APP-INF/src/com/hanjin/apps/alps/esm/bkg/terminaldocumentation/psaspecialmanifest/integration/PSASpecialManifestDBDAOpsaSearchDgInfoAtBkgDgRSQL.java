/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG의 위험물 테이블에서 데이타를 조회해온다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL").append("\n"); 
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
		query.append("SELECT SUM(SEQ) OVER (ORDER BY T1.BL_NO, T1.POL_CD, T1.POD_CD, T1.CNTR_NO) SEQ" ).append("\n"); 
		query.append("       ,COUNT(DISTINCT T1.CNTR_NO) OVER() CNTR_CNT" ).append("\n"); 
		query.append("       ,T1.BL_NO MERGE_BL_NO" ).append("\n"); 
		query.append("       ,T1.BKG_NO" ).append("\n"); 
		query.append("       ,T1.BL_NO" ).append("\n"); 
		query.append("       ,T1.POL_CD" ).append("\n"); 
		query.append("       ,T1.POD_CD" ).append("\n"); 
		query.append("       ,T1.CNTR_NO" ).append("\n"); 
		query.append("	   ,T1.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("	   ,T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,T1.CNMV_STS_CD" ).append("\n"); 
		query.append("       ,T1.TNK_CNTR_FLG" ).append("\n"); 
		query.append("	   ,T1.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("       ,T1.IMDG_UN_NO" ).append("\n"); 
		query.append("	   ,T1.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ,T1.IMDG_CLSS_CD" ).append("\n"); 
		query.append("       ,T1.DG_CNTR_SEQ" ).append("\n"); 
		query.append("	   ,T1.DG_SHORT_NM 	" ).append("\n"); 
		query.append("	   ,T1.DG_SHORT_NM_CNT" ).append("\n"); 
		query.append("       ,T1.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("       ,T1.AGENT         " ).append("\n"); 
		query.append("       ,T1.FWRD_ID       " ).append("\n"); 
		query.append("       ,T1.C_TYPE        " ).append("\n"); 
		query.append("       ,T1.SVC_RQST_NO   " ).append("\n"); 
		query.append("       ,T1.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("       ,T1.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,T1.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("       ,T1.IN_PCK_DESC" ).append("\n"); 
		query.append("       ,T1.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,T1.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	   ,T1.OUT_PCK_DESC" ).append("\n"); 
		query.append("       ,T1.EMS_NO" ).append("\n"); 
		query.append("       ,T1.NET_WGT" ).append("\n"); 
		query.append("       ,T1.GRS_WGT" ).append("\n"); 
		query.append("	   ,T1.PACKAGES" ).append("\n"); 
		query.append("       ,T1.PRP_SHP_NM" ).append("\n"); 
		query.append("       ,T1.HZD_DESC" ).append("\n"); 
		query.append("	   ,T1.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("	   ,T1.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("	   ,T1.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("	   ,T1.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("	   ,T1.DCGO_MRN_POLUT_CD	" ).append("\n"); 
		query.append("       ,T1.IMDG_LMT_QTY_FLG	" ).append("\n"); 
		query.append("	   ,LOG.MSG_FUNC_ID AS SEND_TYPE" ).append("\n"); 
		query.append("	   ,LOG.MSG_SND_NO" ).append("\n"); 
		query.append("	   ,F_LOG.MSG_SND_NO AS FIRST_MSG_SND_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("		BVD.SEQ SEQ " ).append("\n"); 
		query.append("       ,BVD.CNTR_CNT" ).append("\n"); 
		query.append("       ,BVD.BL_NO MERGE_BL_NO" ).append("\n"); 
		query.append("       ,BVD.BKG_NO" ).append("\n"); 
		query.append("       ,BVD.BL_NO" ).append("\n"); 
		query.append("       ,BVD.POL_CD" ).append("\n"); 
		query.append("       ,BVD.POD_CD" ).append("\n"); 
		query.append("       ,BVD.CNTR_NO" ).append("\n"); 
		query.append("	   ,NVL(BVD.CNTR_CGO_SEQ, 1) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("	   ,BVD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,BVD.CNMV_STS_CD" ).append("\n"); 
		query.append("       ,BVD.TNK_CNTR_FLG" ).append("\n"); 
		query.append("	   ,BVD.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("       ,BVD.IMDG_UN_NO" ).append("\n"); 
		query.append("	   ,BVD.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ,BVD.IMDG_CLSS_CD" ).append("\n"); 
		query.append("       ,BVD.DG_CNTR_SEQ" ).append("\n"); 
		query.append("	   ,BVD.DG_SHORT_NM 	-- S.D/G" ).append("\n"); 
		query.append("	   ,COUNT(BVD.DG_SHORT_NM) OVER() AS DG_SHORT_NM_CNT" ).append("\n"); 
		query.append("	   ,BVD.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("       ,'' AS AGENT         --AGENT" ).append("\n"); 
		query.append("       ,'' AS FWRD_ID       --FOWDER CODE" ).append("\n"); 
		query.append("       ,'' AS C_TYPE        --CARRIAGE TYPE" ).append("\n"); 
		query.append("       ,'' AS SVC_RQST_NO   --SSR(FEEDER)" ).append("\n"); 
		query.append("       ,NVL(BVD.IMDG_PCK_GRP_CD,'N') IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("       ,BVD.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,BVD.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("    	,DECODE(NVL(BVD.IN_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.IN_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS IN_PCK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,BVD.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	   ,DECODE(NVL(BVD.OUT_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.OUT_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS OUT_PCK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.EMS_NO" ).append("\n"); 
		query.append("       ,BVD.NET_WGT" ).append("\n"); 
		query.append("       ,BVD.GRS_WGT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(BVD.OUT_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.OUT_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS PACKAGES" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.PRP_SHP_NM" ).append("\n"); 
		query.append("       ,BVD.HZD_DESC" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,BVD.MRN_POLUT_FLG 		DCGO_MRN_POLUT_CD	-- Marine Pollutant" ).append("\n"); 
		query.append("       ,BVD.IMDG_LMT_QTY_FLG 	IMDG_LMT_QTY_FLG	-- Limited quantity" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("				DECODE(LAG(BK.BL_NO) OVER ( ORDER BY BK.BL_NO, BV.POL_CD, BV.POD_CD, BDC.CNTR_NO) , BK.BL_NO, 0, 1) SEQ  " ).append("\n"); 
		query.append("				,COUNT(DISTINCT bdc.cntr_no) OVER() CNTR_CNT " ).append("\n"); 
		query.append("               ,BV.BKG_NO     BKG_NO" ).append("\n"); 
		query.append(" 			   ,BK.BL_NO	  BL_NO" ).append("\n"); 
		query.append("               ,BV.POL_CD     POL_CD" ).append("\n"); 
		query.append("               ,BV.POD_CD     POD_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD     VSL_CD" ).append("\n"); 
		query.append("               ,BV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("               ,BV.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("               ,BDC.CNTR_NO           CNTR_NO" ).append("\n"); 
		query.append("               ,BDC.CNTR_CGO_SEQ      CNTR_CGO_SEQ" ).append("\n"); 
		query.append("			   ,BDC.CNTR_TPSZ_CD      CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,(SELECT CNMV_STS_CD" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                    WHERE CNTR_NO= BDC.CNTR_NO AND BKG_NO= BV.BKG_NO) AS CNMV_STS_CD" ).append("\n"); 
		query.append("               ,(SELECT DECODE(SUBSTR(CNTR_TPSZ_CD,'1'),'T','Y','N') TNK_CNTR_FLG" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                    WHERE CNTR_NO= BDC.CNTR_NO AND BKG_NO= BV.BKG_NO) AS TNK_CNTR_FLG" ).append("\n"); 
		query.append("			   ,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO        IMDG_UN_NO" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("               ,BDC.IMDG_CLSS_CD" ).append("\n"); 
		query.append("			   ,(SELECT ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_EUR_DG_SPCL" ).append("\n"); 
		query.append("                  WHERE IMDG_UN_NO = BDC.IMDG_UN_NO) AS DG_SHORT_NM" ).append("\n"); 
		query.append("               ,BDC.DG_CNTR_SEQ" ).append("\n"); 
		query.append("               ,BDC.FLSH_PNT_CDO_TEMP FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("               ,BDC.IMDG_PCK_GRP_CD   IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_QTY1  IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_CD1   IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_QTY1 OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_CD1  OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("               ,BDC.EMS_NO            EMS_NO" ).append("\n"); 
		query.append("               ,BDC.NET_WGT           NET_WGT" ).append("\n"); 
		query.append("               ,BDC.GRS_WGT           GRS_WGT" ).append("\n"); 
		query.append("               ,BDC.PRP_SHP_NM        PRP_SHP_NM" ).append("\n"); 
		query.append("               ,BDC.HZD_DESC          HZD_DESC" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD1          IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD2          IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD3          IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD4          IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   ,BDC.MRN_POLUT_FLG	  MRN_POLUT_FLG" ).append("\n"); 
		query.append("			   ,BDC.IMDG_LMT_QTY_FLG  IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                    SELECT *" ).append("\n"); 
		query.append("                    FROM BKG_VVD BV" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND BV.VSL_CD        =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                    AND BV.SKD_VOY_NO    =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                    AND BV.SKD_DIR_CD    =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                    #if (${d_type} == 'D' || ${d_type} == 'DO' || ${d_type} == 'O') -- Discharging or Discharging + On-Carriage" ).append("\n"); 
		query.append("                            AND BV.POD_CD      = @[port_cd]" ).append("\n"); 
		query.append("                    #elseif (${d_type} == 'L' || ${d_type} == 'PL' || ${d_type} == 'P') -- Loading or Loading + Pre-Carriage" ).append("\n"); 
		query.append("                            AND BV.POL_CD      = @[port_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ) BV" ).append("\n"); 
		query.append("               ,BKG_DG_CGO BDC" ).append("\n"); 
		query.append("               ,BKG_BOOKING BK" ).append("\n"); 
		query.append("			   ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND BV.BKG_NO        =   BK.BKG_NO" ).append("\n"); 
		query.append("           AND BV.BKG_NO        =   BDC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND BDC.IMDG_UN_NO	= 	SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		   AND BDC.IMDG_UN_NO_SEQ = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND BK.DCGO_FLG      =   'Y'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD    <>  'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )BVD" ).append("\n"); 
		query.append("WHERE 1=1        " ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("	 AND   BVD.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("---------------------------------------------------------------" ).append("\n"); 
		query.append("AND 'T' <> @[d_type]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		BVD.SEQ SEQ " ).append("\n"); 
		query.append("       ,BVD.CNTR_CNT" ).append("\n"); 
		query.append("       ,BVD.BL_NO MERGE_BL_NO" ).append("\n"); 
		query.append("       ,BVD.BKG_NO" ).append("\n"); 
		query.append("       ,BVD.BL_NO" ).append("\n"); 
		query.append("       ,BVD.POL_CD" ).append("\n"); 
		query.append("       ,BVD.POD_CD" ).append("\n"); 
		query.append("       ,BVD.CNTR_NO" ).append("\n"); 
		query.append("	   ,NVL(BVD.CNTR_CGO_SEQ, 1) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("	   ,BVD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,BVD.CNMV_STS_CD" ).append("\n"); 
		query.append("       ,BVD.TNK_CNTR_FLG" ).append("\n"); 
		query.append("	   ,BVD.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("       ,BVD.IMDG_UN_NO" ).append("\n"); 
		query.append("	   ,BVD.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ,BVD.IMDG_CLSS_CD" ).append("\n"); 
		query.append("       ,BVD.DG_CNTR_SEQ" ).append("\n"); 
		query.append("	   ,BVD.DG_SHORT_NM 	-- S.D/G" ).append("\n"); 
		query.append("	   ,COUNT(BVD.DG_SHORT_NM) OVER() AS DG_SHORT_NM_CNT" ).append("\n"); 
		query.append("	   ,BVD.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("       ,'' AS AGENT         --AGENT" ).append("\n"); 
		query.append("       ,'' AS FWRD_ID       --FOWDER CODE" ).append("\n"); 
		query.append("       ,'' AS C_TYPE        --CARRIAGE TYPE" ).append("\n"); 
		query.append("       ,'' AS SVC_RQST_NO   --SSR(FEEDER)" ).append("\n"); 
		query.append("       ,NVL(BVD.IMDG_PCK_GRP_CD,'N') IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("       ,BVD.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,BVD.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("    	,DECODE(NVL(BVD.IN_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.IN_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS IN_PCK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("       ,BVD.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	   ,DECODE(NVL(BVD.OUT_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.OUT_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS OUT_PCK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.EMS_NO" ).append("\n"); 
		query.append("       ,BVD.NET_WGT" ).append("\n"); 
		query.append("       ,BVD.GRS_WGT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(BVD.OUT_IMDG_PCK_QTY1, '0'), '0', (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("                                               , BVD.OUT_IMDG_PCK_QTY1 || ' ' || (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1)" ).append("\n"); 
		query.append("           		)  AS PACKAGES" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,BVD.PRP_SHP_NM" ).append("\n"); 
		query.append("       ,BVD.HZD_DESC" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("	   ,BVD.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,BVD.MRN_POLUT_FLG 		DCGO_MRN_POLUT_CD	-- Marine Pollutant" ).append("\n"); 
		query.append("       ,BVD.IMDG_LMT_QTY_FLG 	IMDG_LMT_QTY_FLG	-- Limited quantity" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT " ).append("\n"); 
		query.append("				DECODE(LAG(BK.BL_NO) OVER ( ORDER BY BK.BL_NO, BV.POL_CD, BV.POD_CD, BDC.CNTR_NO) , BK.BL_NO, 0, 1) SEQ  " ).append("\n"); 
		query.append("				,COUNT(DISTINCT bdc.cntr_no) OVER() CNTR_CNT " ).append("\n"); 
		query.append("               ,BV.BKG_NO     BKG_NO" ).append("\n"); 
		query.append(" 			   ,BK.BL_NO	  BL_NO" ).append("\n"); 
		query.append("               ,BV.POL_CD     POL_CD" ).append("\n"); 
		query.append("               ,BV.POD_CD     POD_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD     VSL_CD" ).append("\n"); 
		query.append("               ,BV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("               ,BV.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("               ,BDC.CNTR_NO           CNTR_NO" ).append("\n"); 
		query.append("               ,BDC.CNTR_CGO_SEQ      CNTR_CGO_SEQ" ).append("\n"); 
		query.append("			   ,BDC.CNTR_TPSZ_CD      CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               ,(SELECT CNMV_STS_CD" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                    WHERE CNTR_NO= BDC.CNTR_NO AND BKG_NO= BV.BKG_NO) AS CNMV_STS_CD" ).append("\n"); 
		query.append("               ,(SELECT DECODE(SUBSTR(CNTR_TPSZ_CD,'1'),'T','Y','N') TNK_CNTR_FLG" ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER " ).append("\n"); 
		query.append("                    WHERE CNTR_NO= BDC.CNTR_NO AND BKG_NO= BV.BKG_NO) AS TNK_CNTR_FLG" ).append("\n"); 
		query.append("			   ,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO        IMDG_UN_NO" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("               ,BDC.IMDG_CLSS_CD" ).append("\n"); 
		query.append("			   ,(SELECT ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_EUR_DG_SPCL" ).append("\n"); 
		query.append("                  WHERE IMDG_UN_NO = BDC.IMDG_UN_NO) AS DG_SHORT_NM" ).append("\n"); 
		query.append("               ,BDC.DG_CNTR_SEQ" ).append("\n"); 
		query.append("               ,BDC.FLSH_PNT_CDO_TEMP FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("               ,BDC.IMDG_PCK_GRP_CD   IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_QTY1  IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_CD1   IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_QTY1 OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_CD1  OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("               ,BDC.EMS_NO            EMS_NO" ).append("\n"); 
		query.append("               ,BDC.NET_WGT           NET_WGT" ).append("\n"); 
		query.append("               ,BDC.GRS_WGT           GRS_WGT" ).append("\n"); 
		query.append("               ,BDC.PRP_SHP_NM        PRP_SHP_NM" ).append("\n"); 
		query.append("               ,BDC.HZD_DESC          HZD_DESC" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD1          IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD2          IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD3          IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD4          IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   ,BDC.MRN_POLUT_FLG	  MRN_POLUT_FLG" ).append("\n"); 
		query.append("			   ,BDC.IMDG_LMT_QTY_FLG  IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_VVD BV" ).append("\n"); 
		query.append("               ,BKG_DG_CGO BDC" ).append("\n"); 
		query.append("               ,BKG_BOOKING BK" ).append("\n"); 
		query.append("			   ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BV.VSL_CD        =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO    =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD    =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND BV.POL_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ < (     SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                              WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           AND BV.POD_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ  > (    SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                              WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                        AND  CLPT_SEQ  < (    SELECT NVL(MIN(V2.CLPT_SEQ),50)" ).append("\n"); 
		query.append("                                                                FROM VSK_VSL_PORT_SKD V1, VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                                                               WHERE 1=1" ).append("\n"); 
		query.append("                                                                 AND  V1.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                 AND V1.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                 AND V1.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                 AND V1.VSL_CD = V2.VSL_CD" ).append("\n"); 
		query.append("                                                                 AND V1.SKD_VOY_NO = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 AND V1.SKD_DIR_CD = V2.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                 AND NVL(V1.SKD_CNG_STS_CD,'X') = 'O'" ).append("\n"); 
		query.append("                                                                 AND NVL(V2.SKD_CNG_STS_CD,'X') = 'A'" ).append("\n"); 
		query.append("                                                                 AND V1.CLPT_SEQ < V2.CLPT_SEQ       " ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           AND BV.BKG_NO        =   BK.BKG_NO" ).append("\n"); 
		query.append("           AND BV.BKG_NO        =   BDC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND BDC.IMDG_UN_NO	= 	SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		   AND BDC.IMDG_UN_NO_SEQ = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND BK.DCGO_FLG      =   'Y'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD    <>  'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )BVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND   BVD.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND 'T' = @[d_type]" ).append("\n"); 
		query.append("---------------------------------------------------------------" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     B.BL_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_PSA_DG_SND A" ).append("\n"); 
		query.append("	                ,BKG_CSTMS_PSA_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                WHERE A.PSA_DG_DECL_TP_CD  = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.PSA_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.PSA_EDI_MSG_TP_ID = B.PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                AND   (B.BL_NO, B.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_PSA_DG_SND A" ).append("\n"); 
		query.append("                                            ,BKG_CSTMS_PSA_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                        	WHERE A.PSA_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]                                                         " ).append("\n"); 
		query.append("                                            AND   A.PSA_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                            AND   A.PSA_EDI_MSG_TP_ID = B.PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                            AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                							GROUP BY A.PSA_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append(") LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     B.BL_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_PSA_DG_SND A" ).append("\n"); 
		query.append("	                ,BKG_CSTMS_PSA_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                WHERE A.PSA_DG_DECL_TP_CD  = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.PSA_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.PSA_EDI_MSG_TP_ID = B.PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                AND   (B.BL_NO, B.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_PSA_DG_SND A" ).append("\n"); 
		query.append("                                            ,BKG_CSTMS_PSA_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                        	WHERE A.PSA_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                            AND   A.PSA_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                            AND   A.PSA_EDI_MSG_TP_ID = B.PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                            AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                                            AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                							GROUP BY A.PSA_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append(") F_LOG" ).append("\n"); 
		query.append("WHERE T1.BL_NO = LOG.BL_NO(+)" ).append("\n"); 
		query.append("  AND T1.CNTR_NO = LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND T1.CNTR_CGO_SEQ = LOG.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND T1.BL_NO = F_LOG.BL_NO(+)" ).append("\n"); 
		query.append("  AND T1.CNTR_NO = F_LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND T1.CNTR_CGO_SEQ = F_LOG.CNTR_CGO_SEQ(+)  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_type} == 'Y') " ).append("\n"); 
		query.append("  AND LOG.MSG_FUNC_ID IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${search_type} == 'N') " ).append("\n"); 
		query.append("  AND LOG.MSG_FUNC_ID IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}