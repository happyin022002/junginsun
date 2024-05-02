/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchIndiaCntrManifestListByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchIndiaCntrManifestListByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr정보를 조회 해 온다.
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchIndiaCntrManifestListByVvdPortRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchIndiaCntrManifestListByVvdPortRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    SUB1.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("    ,SUB1.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    --,DECODE(NVL(SUB1.STOWAGE,''),'',BCIC.IDA_STWG_NO, SUB1.STOWAGE) IDA_STWG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,DECODE(NVL(SUB1.STOWAGE,''),''," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT IDA_STWG_NO" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_IDA_CNTR" ).append("\n"); 
		query.append("        WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("        AND     POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("        AND     BL_NO           = SUB1.BL_NO" ).append("\n"); 
		query.append("        AND     CNTR_NO         = SUB1.CNTR_NO" ).append("\n"); 
		query.append("        )   ) IDA_STWG_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,SUB1.CNTR_WGT CNTR_WGT" ).append("\n"); 
		query.append("    ,SUB1.BL_NO" ).append("\n"); 
		query.append("    ,SUB1.POL_CD POL_CD" ).append("\n"); 
		query.append("    ,SUB1.POD_CD POD_CD" ).append("\n"); 
		query.append("    ,SUB1.DEL_CD DEL_CD" ).append("\n"); 
		query.append("    ,SUB1.TS TS_CNTR_FLG" ).append("\n"); 
		query.append("    ,SUB1.BKG_CGO_TP_CD BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,SUB1.DCGO_FLG  DCGO_FLG" ).append("\n"); 
		query.append("    ,SUB1.RC_FLG RC_FLG" ).append("\n"); 
		query.append("    ,SUB1.AWK_CGO_FLG AWK_CGO_FLG" ).append("\n"); 
		query.append("    ,SUB1.BB_CGO_FLG BB_CGO_FLG" ).append("\n"); 
		query.append("    ,SUB1.BKG_NO" ).append("\n"); 
		query.append("    ,@[vvd_cd] VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,DECODE(BCIC.VSL_CD||BCIC.SKD_VOY_NO||BCIC.SKD_DIR_CD||BCIC.POD_CD||BCIC.BL_NO||BCIC.CNTR_NO, '', 'N', 'Y') DOWN_CHECK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , DECODE(  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||POD_CD||BL_NO||CNTR_NO" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_IDA_CNTR" ).append("\n"); 
		query.append("            WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("            AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("            AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("            AND     POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("            AND     BL_NO           = SUB1.BL_NO" ).append("\n"); 
		query.append("            AND     CNTR_NO         = SUB1.CNTR_NO" ).append("\n"); 
		query.append("        ), '', 'N', 'Y') DOWN_CHECK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /*" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("    	CASE" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'Y' AND SUB1.RC_FLG = 'N') THEN 'CLASS: ' || SUB1.IMDG_CLSS_CD || '  UN: ' || SUB1.IMDG_UN_NO" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'N' AND SUB1.RC_FLG = 'Y') THEN DECODE(SUB1.CNTR_VENT_CD, 'F', SUB1.FDO_TEMP, SUB1.CDO_TEMP) || ''" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'Y' AND SUB1.RC_FLG = 'Y') THEN 'CLASS: ' || SUB1.IMDG_CLSS_CD || '  UN: ' || SUB1.IMDG_UN_NO || ' ' || DECODE(SUB1.CNTR_VENT_CD, 'F', SUB1.FDO_TEMP, SUB1.CDO_TEMP)" ).append("\n"); 
		query.append("    	END" ).append("\n"); 
		query.append("  	) SPCL_CGO_DESC" ).append("\n"); 
		query.append("  	*/" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("    	CASE" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'Y' AND SUB1.RC_FLG = 'N') THEN 'CLASS: ' || SUB1.IMDG_CLSS_CD || '  UN: ' || SUB1.IMDG_UN_NO" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'N' AND SUB1.RC_FLG = 'Y') THEN 'Temperature : ' ||  SUB1.FDO_TEMP || '˚F, ' || SUB1.CDO_TEMP || '˚C' || ''" ).append("\n"); 
		query.append("        	WHEN (SUB1.DCGO_FLG = 'Y' AND SUB1.RC_FLG = 'Y') THEN 'CLASS: ' || SUB1.IMDG_CLSS_CD || '  UN: ' || SUB1.IMDG_UN_NO || ' ' || 'Temperature : ' ||  SUB1.FDO_TEMP || '˚F, ' || SUB1.CDO_TEMP || '˚C'" ).append("\n"); 
		query.append("    	END" ).append("\n"); 
		query.append("  	) SPCL_CGO_DESC" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            BC.CNTR_NO" ).append("\n"); 
		query.append("            ,BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,'' STOWAGE" ).append("\n"); 
		query.append("            ,ROUND(BC.CNTR_WGT * 0.001, 2)	 CNTR_WGT" ).append("\n"); 
		query.append("            ,BB.BL_NO                              BL_NO" ).append("\n"); 
		query.append("            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("            ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("            ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("            ,'I'                                   TS" ).append("\n"); 
		query.append("            ,BB.BKG_CGO_TP_CD                      BKG_CGO_TP_CD" ).append("\n"); 
		query.append("            ,BB.DCGO_FLG                           DCGO_FLG" ).append("\n"); 
		query.append("            ,BB.RC_FLG                             RC_FLG" ).append("\n"); 
		query.append("            ,BB.AWK_CGO_FLG                        AWK_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BB_CGO_FLG                         BB_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BKG_NO                             BKG_NO" ).append("\n"); 
		query.append("            ,BB.VSL_CD                             VSL_CD" ).append("\n"); 
		query.append("            ,BB.SKD_VOY_NO                         SKD_VOY_NO" ).append("\n"); 
		query.append("            ,BB.SKD_DIR_CD                         SKD_DIR_CD" ).append("\n"); 
		query.append("	        ,BDG.IMDG_CLSS_CD, BDG.IMDG_UN_NO" ).append("\n"); 
		query.append("     	   --,BFG.CNTR_VENT_CD" ).append("\n"); 
		query.append("     	   , BFG.FDO_TEMP, BFG.CDO_TEMP" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("             ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("             ,(  SELECT  COUNT(A.CNTR_NO) CNT" ).append("\n"); 
		query.append("                         ,A.BKG_NO" ).append("\n"); 
		query.append("                         ,B.VSL_CD" ).append("\n"); 
		query.append("                 FROM    BKG_CONTAINER A" ).append("\n"); 
		query.append("                         ,BKG_VVD B" ).append("\n"); 
		query.append("                 WHERE   B.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                 AND     B.POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("                 AND     B.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                 GROUP BY A.BKG_NO, B.VSL_CD ) BKG_CNTR" ).append("\n"); 
		query.append("	        , BKG_DG_CGO BDG" ).append("\n"); 
		query.append("    	    , BKG_RF_CGO BFG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pod_cd} != '') " ).append("\n"); 
		query.append("        AND     BB.POD_CD                 = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND     BB.POL_CD                 LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("        AND     BB.BKG_CGO_TP_CD          <> 'P' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BC.BKG_NO" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BKG_CNTR.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG_CNTR.CNT               > 0" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BDG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BFG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BDG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BFG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BDG.DCGO_SEQ(+)            = '1'" ).append("\n"); 
		query.append("		AND     BFG.RC_SEQ(+)              = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            BC.CNTR_NO" ).append("\n"); 
		query.append("            ,BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,'' STOWAGE" ).append("\n"); 
		query.append("            ,ROUND(BC.CNTR_WGT * 0.001, 2)	 CNTR_WGT" ).append("\n"); 
		query.append("            ,BB.BL_NO                              BL_NO" ).append("\n"); 
		query.append("            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("            ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("            ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("            ,'R'                                   TS" ).append("\n"); 
		query.append("            ,BB.BKG_CGO_TP_CD                      BKG_CGO_TP_CD" ).append("\n"); 
		query.append("            ,BB.DCGO_FLG                           DCGO_FLG" ).append("\n"); 
		query.append("            ,BB.RC_FLG                             RC_FLG" ).append("\n"); 
		query.append("            ,BB.AWK_CGO_FLG                        AWK_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BB_CGO_FLG                         BB_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BKG_NO                             BKG_NO" ).append("\n"); 
		query.append("            ,BB.VSL_CD                             VSL_CD" ).append("\n"); 
		query.append("            ,BB.SKD_VOY_NO                         SKD_VOY_NO" ).append("\n"); 
		query.append("            ,BB.SKD_DIR_CD                         SKD_DIR_CD" ).append("\n"); 
		query.append("	        ,BDG.IMDG_CLSS_CD, BDG.IMDG_UN_NO" ).append("\n"); 
		query.append("     	   --,BFG.CNTR_VENT_CD" ).append("\n"); 
		query.append("     	   , BFG.FDO_TEMP, BFG.CDO_TEMP" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("             ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("             ,(  SELECT  COUNT(A.CNTR_NO) CNT" ).append("\n"); 
		query.append("                         ,A.BKG_NO" ).append("\n"); 
		query.append("                         ,B.VSL_CD" ).append("\n"); 
		query.append("                 FROM    BKG_CONTAINER A" ).append("\n"); 
		query.append("                         ,BKG_VVD B" ).append("\n"); 
		query.append("                 WHERE   B.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                 AND     B.POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("                 AND     B.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                 GROUP BY A.BKG_NO, B.VSL_CD ) BKG_CNTR" ).append("\n"); 
		query.append("	        , BKG_DG_CGO BDG" ).append("\n"); 
		query.append("    	    , BKG_RF_CGO BFG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("                    SELECT  DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("                    FROM    VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                            ,BKG_VVD B" ).append("\n"); 
		query.append("                            ,BKG_BOOKING C" ).append("\n"); 
		query.append("                    WHERE   B.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                    AND     B.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                    AND     B.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                    AND     B.VSL_CD          = A.VSL_CD" ).append("\n"); 
		query.append("                    AND     B.SKD_VOY_NO      = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     B.SKD_DIR_CD      = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     C.BKG_STS_CD     <> 'X'" ).append("\n"); 
		query.append("                    AND     C.POD_CD         <> @[pod_cd]" ).append("\n"); 
		query.append("                    AND     B.POD_CD         <> @[pod_cd]" ).append("\n"); 
		query.append("                    AND     C.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("                    AND     B.POL_CD    IN" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                   SELECT  VPS_PORT_CD" ).append("\n"); 
		query.append("                                   FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                   WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                   AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                   AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                   AND     CLPT_SEQ       < (" ).append("\n"); 
		query.append("                                                                   SELECT  CLPT_SEQ" ).append("\n"); 
		query.append("                                                                   FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                   WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                   AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                   AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                   AND     VPS_PORT_CD      = @[pod_cd]" ).append("\n"); 
		query.append("                                                                   AND     SKD_CNG_STS_CD <>'S'" ).append("\n"); 
		query.append("                                                                )" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                    AND     B.POD_CD  NOT  IN" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                   SELECT  VPS_PORT_CD" ).append("\n"); 
		query.append("                                   FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                   WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                   AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                   AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                   AND     CLPT_SEQ        < (" ).append("\n"); 
		query.append("                                                                   SELECT  CLPT_SEQ" ).append("\n"); 
		query.append("                                                                   FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                   WHERE   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                   AND     SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                   AND     SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                   AND     VPS_PORT_CD      = @[pod_cd]" ).append("\n"); 
		query.append("                                                                   AND     SKD_CNG_STS_CD <>'S'" ).append("\n"); 
		query.append("                                                                )" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                    AND     CLPT_SEQ    >" ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                          SELECT   MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                          FROM     VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                          WHERE    VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                          AND      SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                          AND      SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                          AND      VPS_PORT_CD      = @[pod_cd] )" ).append("\n"); 
		query.append("              ) LOC_SEQ     " ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND     BB.POD_CD                 = @[pod_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND     BB.POL_CD                 LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on')" ).append("\n"); 
		query.append("        AND     BB.BKG_CGO_TP_CD          <> 'P' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BC.BKG_NO" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BKG_CNTR.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG_CNTR.CNT               > 0" ).append("\n"); 
		query.append("        AND		BB.BKG_NO				= LOC_SEQ.BKG_NO" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BDG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BFG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BDG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BFG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BDG.DCGO_SEQ(+)            = '1'" ).append("\n"); 
		query.append("		AND     BFG.RC_SEQ(+)              = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            BC.CNTR_NO" ).append("\n"); 
		query.append("            ,BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,'' STOWAGE" ).append("\n"); 
		query.append("            ,ROUND(BC.CNTR_WGT * 0.001, 2)	 CNTR_WGT" ).append("\n"); 
		query.append("            ,BB.BL_NO                              BL_NO" ).append("\n"); 
		query.append("            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("            ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("            ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("            ,'T'                                   TS" ).append("\n"); 
		query.append("            ,BB.BKG_CGO_TP_CD                      BKG_CGO_TP_CD" ).append("\n"); 
		query.append("            ,BB.DCGO_FLG                           DCGO_FLG" ).append("\n"); 
		query.append("            ,BB.RC_FLG                             RC_FLG" ).append("\n"); 
		query.append("            ,BB.AWK_CGO_FLG                        AWK_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BB_CGO_FLG                         BB_CGO_FLG" ).append("\n"); 
		query.append("            ,BB.BKG_NO                             BKG_NO" ).append("\n"); 
		query.append("            ,BB.VSL_CD                             VSL_CD" ).append("\n"); 
		query.append("            ,BB.SKD_VOY_NO                         SKD_VOY_NO" ).append("\n"); 
		query.append("            ,BB.SKD_DIR_CD                         SKD_DIR_CD" ).append("\n"); 
		query.append("	        ,BDG.IMDG_CLSS_CD, BDG.IMDG_UN_NO" ).append("\n"); 
		query.append("     	   --,BFG.CNTR_VENT_CD" ).append("\n"); 
		query.append("     	   , BFG.FDO_TEMP, BFG.CDO_TEMP" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("             ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("             ,(  SELECT  COUNT(A.CNTR_NO) CNT" ).append("\n"); 
		query.append("                         ,A.BKG_NO" ).append("\n"); 
		query.append("                         ,B.VSL_CD" ).append("\n"); 
		query.append("                 FROM    BKG_CONTAINER A" ).append("\n"); 
		query.append("                         ,BKG_VVD B" ).append("\n"); 
		query.append("                 WHERE   B.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                 AND     B.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                 AND     B.POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("                 AND     B.BKG_NO          = A.BKG_NO" ).append("\n"); 
		query.append("                 GROUP BY A.BKG_NO, B.VSL_CD ) BKG_CNTR" ).append("\n"); 
		query.append("	        , BKG_DG_CGO BDG" ).append("\n"); 
		query.append("    	    , BKG_RF_CGO BFG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	  ,(" ).append("\n"); 
		query.append("        		SELECT	A.BKG_NO" ).append("\n"); 
		query.append("                	FROM" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT   BKG_BOOKING.BKG_NO" ).append("\n"); 
		query.append("                      FROM     BKG_BOOKING" ).append("\n"); 
		query.append("                               ,BKG_VVD" ).append("\n"); 
		query.append("                              ,(" ).append("\n"); 
		query.append("                                   SELECT  BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("                                           ,BKG_VVD.POL_CD" ).append("\n"); 
		query.append("                                           ,BKG_VVD.POD_CD" ).append("\n"); 
		query.append("                                   FROM    BKG_VVD" ).append("\n"); 
		query.append("                                   WHERE   BKG_VVD.VSL_CD          	 = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                    AND    BKG_VVD.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                    AND    BKG_VVD.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                              )    BKG_VVD2" ).append("\n"); 
		query.append("                      WHERE   BKG_BOOKING.BKG_NO        =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("                      AND     BKG_BOOKING.POD_CD       <>   @[pod_cd]" ).append("\n"); 
		query.append("                      AND     BKG_VVD.BKG_NO            =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("                      AND     BKG_VVD.POL_CD            =   @[pod_cd]" ).append("\n"); 
		query.append("                   )        A" ).append("\n"); 
		query.append("                   ,(" ).append("\n"); 
		query.append("                      SELECT   BKG_BOOKING.BKG_NO" ).append("\n"); 
		query.append("                      FROM     BKG_BOOKING" ).append("\n"); 
		query.append("                               ,BKG_VVD" ).append("\n"); 
		query.append("                               ,(" ).append("\n"); 
		query.append("                                   SELECT  BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("                                           ,BKG_VVD.POL_CD" ).append("\n"); 
		query.append("                                           ,BKG_VVD.POD_CD" ).append("\n"); 
		query.append("                                   FROM    BKG_VVD" ).append("\n"); 
		query.append("                                   WHERE   BKG_VVD.VSL_CD          	= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                    AND    BKG_VVD.SKD_VOY_NO       = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                    AND    BKG_VVD.SKD_DIR_CD       = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                )    BKG_VVD2" ).append("\n"); 
		query.append("                      WHERE   BKG_BOOKING.BKG_NO        =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("                      AND     BKG_BOOKING.POD_CD        <>  @[pod_cd]" ).append("\n"); 
		query.append("                      AND     BKG_VVD.BKG_NO            =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("                      AND     BKG_VVD.POD_CD            =   @[pod_cd]" ).append("\n"); 
		query.append("                   )        B" ).append("\n"); 
		query.append("                   WHERE   A.BKG_NO        =   B.BKG_NO" ).append("\n"); 
		query.append("        	  ) TS" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND     BB.POL_CD                 LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("        AND     BB.BKG_CGO_TP_CD          <> 'P'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BC.BKG_NO" ).append("\n"); 
		query.append("        AND     BB.BKG_NO                  = BKG_CNTR.BKG_NO" ).append("\n"); 
		query.append("        AND     BKG_CNTR.CNT               > 0" ).append("\n"); 
		query.append("        AND		BB.BKG_NO					= TS.BKG_NO" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BDG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.BKG_NO                  = BFG.BKG_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BDG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BC.CNTR_NO                 = BFG.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND     BDG.DCGO_SEQ(+)            = '1'" ).append("\n"); 
		query.append("		AND     BFG.RC_SEQ(+)              = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) SUB1" ).append("\n"); 
		query.append("    ,BKG_CSTMS_IDA_CNTR BCIC" ).append("\n"); 
		query.append("WHERE SUB1.VSL_CD       =  BCIC.VSL_CD(+)" ).append("\n"); 
		query.append("AND   SUB1.SKD_VOY_NO   =  BCIC.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   SUB1.SKD_DIR_CD   =  BCIC.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   SUB1.POD_CD       =  BCIC.POD_CD(+)" ).append("\n"); 
		query.append("AND   SUB1.BL_NO        =  BCIC.BL_NO(+) " ).append("\n"); 
		query.append("AND   SUB1.CNTR_NO      =  BCIC.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_NO, CNTR_TPSZ_CD" ).append("\n"); 

	}
}