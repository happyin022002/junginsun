/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL.java
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

public class PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이터에 해당하는 아이템 정보 조회
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    @[msg_snd_no]				  MSG_SND_NO" ).append("\n"); 
		query.append("	,BVD.CNTR_CGO_SEQ             ITEM_NBR    " ).append("\n"); 
		query.append("    ,BVD.OUT_IMDG_PCK_QTY1        PKG_QTY" ).append("\n"); 
		query.append("    ,BVD.OUT_IMDG_PCK_QTY1        OUTPKG_QTY" ).append("\n"); 
		query.append("    ,BVD.IN_IMDG_PCK_QTY1         INPKG_QTY" ).append("\n"); 
		query.append("    ,BVD.OUT_IMDG_PCK_CD1         PKG_TP" ).append("\n"); 
		query.append("    ,BVD.OUT_IMDG_PCK_CD1         OUTPKG_TP" ).append("\n"); 
		query.append("    ,BVD.IN_IMDG_PCK_CD1          INPKG_TP" ).append("\n"); 
		query.append("    --[OLD],BVD.TTL_PCK_DESC             PKG_DESC        --BVD.EUR_PCK_DESC             PKG_DESC" ).append("\n"); 
		query.append("    --[NEW] PKG_DESC" ).append("\n"); 
		query.append("    ,(SELECT IMDG_PCK_DESC" ).append("\n"); 
		query.append("        FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("        WHERE IMDG_PCK_CD = BVD.OUT_IMDG_PCK_CD1 " ).append("\n"); 
		query.append("        AND IMDG_PCK_TP_CD = 'O'" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N')       PKG_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --BVD.EUR_PCK_DESC             PKG_DESC" ).append("\n"); 
		query.append("    --[OLD],decode('SGSIN',null,BVD.TTL_PCK_DESC) OUTPKG_DESC    --BVD.EUR_OUTR_PCK_DESC        OUTPKG_DESC" ).append("\n"); 
		query.append("    --[NEW] OUTPKG_DESC" ).append("\n"); 
		query.append("    ,BVD.TTL_PCK_DESC             OUTPKG_DESC" ).append("\n"); 
		query.append("    ,decode(NULL,null,BVD.TTL_PCK_DESC) INPKG_DESC        --BVD.EUR_INR_PCK_DESC         INPKG_DESC" ).append("\n"); 
		query.append("    ,BVD.HZD_DESC                 HAZ_CONT" ).append("\n"); 
		query.append("    ,BVD.PRP_SHP_NM               PROP_SHIP_NM" ).append("\n"); 
		query.append("    ,BVD.IMDG_CLSS_CD 			  IMO_CLASS" ).append("\n"); 
		query.append("	,SIUN.IMDG_COMP_GRP_CD		  IMO_COMP" ).append("\n"); 
		query.append("    ,BVD.EMER_RSPN_GID_NO         IMO_PAGE" ).append("\n"); 
		query.append("    ,BVD.IMDG_UN_NO               UN_NBR" ).append("\n"); 
		query.append("    ,BVD.IMDG_UN_NO_SEQ           UN_NBR_SEQ" ).append("\n"); 
		query.append("    ,BVD.FLSH_PNT_CDO_TEMP        FLASH" ).append("\n"); 
		query.append("    ,'CEL'                        FLASH_UNIT" ).append("\n"); 
		query.append("    ,BVD.IMDG_PCK_GRP_CD          PKG_GROUP" ).append("\n"); 
		query.append("    ,BVD.EMS_NO                   EMS_NBR" ).append("\n"); 
		query.append("    , ''                          MFAG  --BVD.MFAG_NO                  MFAG  --위험물 긴급의료 조치표(MFAG:Medical First Aid Guide for Use in Accidents Involving Dangerous Goods)상의 식별 번호 " ).append("\n"); 
		query.append("    , ''                          ESPN  --BVD.XTD_STAY_PRMT_NO         ESPN :Antwerp세관에서 허가한 Cargo 신고 기간 연장 번호 예)080124-03-3101 " ).append("\n"); 
		query.append("    ,SIUN.IMDG_MRN_POLUT_CD       POLLUTANT" ).append("\n"); 
		query.append("    ,BVD.IMDG_LMT_QTY_FLG         IMO_LIMIT" ).append("\n"); 
		query.append("    ,BVD.HCDG_FLG                 HCDG" ).append("\n"); 
		query.append("    ,BVD.GRS_WGT                  GROSSWGT" ).append("\n"); 
		query.append("    ,'KGM'                        GROSSWGT_UNIT" ).append("\n"); 
		query.append("    ,BVD.NET_WGT                  NETWGT" ).append("\n"); 
		query.append("    ,'KGM'                        NETWGT_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,BVD.NET_EXPLO_WGT			  NW_EXPLOSIVE" ).append("\n"); 
		query.append("	,'KGM'						  NW_EXP_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,BVD.CNTR_NO                  CNTRNBR" ).append("\n"); 
		query.append("    ,'' STOWPOS" ).append("\n"); 
		query.append("	,BVD.IMDG_SUBS_RSK_LBL_CD1	SUB_CLASS1" ).append("\n"); 
		query.append("	,BVD.IMDG_SUBS_RSK_LBL_CD2	SUB_CLASS2" ).append("\n"); 
		query.append("	,BVD.IMDG_SUBS_RSK_LBL_CD3	SUB_CLASS3" ).append("\n"); 
		query.append("	,BVD.IMDG_SUBS_RSK_LBL_CD4	SUB_CLASS4" ).append("\n"); 
		query.append("	,BVD.BKG_NO     BKG_NO" ).append("\n"); 
		query.append("    ,BVD.BL_NO      BL_NO" ).append("\n"); 
		query.append("    ,BVD.POL_CD     POL_CD" ).append("\n"); 
		query.append("    ,BVD.POD_CD     POD_CD" ).append("\n"); 
		query.append("    ,BVD.VSL_CD||BVD.SKD_VOY_NO||BVD.SKD_DIR_CD  VVD_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("               DECODE(LAG(BK.BL_NO) OVER ( ORDER BY BK.BL_NO, BV.POL_CD, BV.POD_CD, BDC.CNTR_NO) , BK.BL_NO, 0, 1) SEQ " ).append("\n"); 
		query.append("			   ,COUNT(DISTINCT bdc.cntr_no) OVER() CNTR_CNT   " ).append("\n"); 
		query.append("			   ,BV.BKG_NO      BKG_NO" ).append("\n"); 
		query.append("			   ,BK.BL_NO      BL_NO" ).append("\n"); 
		query.append("               ,BV.POL_CD     POL_CD" ).append("\n"); 
		query.append("               ,BV.POD_CD     POD_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD     VSL_CD" ).append("\n"); 
		query.append("               ,BV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("               ,BV.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("               ,BDC.CNTR_NO   CNTR_NO" ).append("\n"); 
		query.append("			   ,BDC.CNTR_CGO_SEQ      CNTR_CGO_SEQ	" ).append("\n"); 
		query.append("			   ,BDC.CNTR_TPSZ_CD      CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	   		   ,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO        IMDG_UN_NO" ).append("\n"); 
		query.append("               ,BDC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("               ,BDC.IMDG_CLSS_CD" ).append("\n"); 
		query.append("			   ,'' AS DG_SHORT_NM" ).append("\n"); 
		query.append("               ,BDC.DG_CNTR_SEQ" ).append("\n"); 
		query.append("               ,BDC.FLSH_PNT_CDO_TEMP FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("               ,BDC.IMDG_PCK_GRP_CD   IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_QTY1  IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.IN_IMDG_PCK_CD1   IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_QTY1 OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("               ,BDC.OUT_IMDG_PCK_CD1  OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("               ,BDC.EMS_NO            EMS_NO" ).append("\n"); 
		query.append("               ,BDC.NET_WGT           NET_WGT" ).append("\n"); 
		query.append("               ,BDC.GRS_WGT           GRS_WGT" ).append("\n"); 
		query.append("               ,BDC.PRP_SHP_NM        PRP_SHP_NM" ).append("\n"); 
		query.append("               ,BDC.HZD_DESC          HZD_DESC" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD1	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD2	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD3	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("			   ,BDC.IMDG_SUBS_RSK_LBL_CD4	IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   ,BDC.MRN_POLUT_FLG	  MRN_POLUT_FLG" ).append("\n"); 
		query.append("			   ,BDC.IMDG_LMT_QTY_FLG  IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("			   ,BDC.HCDG_FLG        HCDG_FLG" ).append("\n"); 
		query.append("               ,BDC.NET_EXPLO_WGT   NET_EXPLO_WGT" ).append("\n"); 
		query.append("			   ,D.TTL_PCK_DESC" ).append("\n"); 
		query.append("			   ,BDC.EMER_RSPN_GID_NO	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("          FROM BKG_VVD BV" ).append("\n"); 
		query.append("               ,BKG_DG_CGO BDC" ).append("\n"); 
		query.append("               ,BKG_BOOKING BK" ).append("\n"); 
		query.append("			   ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("			   ,BKG_BL_DOC D" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BV.VSL_CD        =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO    =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD    =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND BV.POL_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ <= (     SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                              WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("															    AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           AND BV.POD_CD        IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ  >= (    SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                              WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("															    AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("										)" ).append("\n"); 
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
		query.append("		   AND D.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("		   AND BK.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("        ) BVD" ).append("\n"); 
		query.append(", SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  BVD.IMDG_UN_NO       = SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND  BVD.IMDG_UN_NO_SEQ   = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, CNTR_CGO_SEQ" ).append("\n"); 

	}
}