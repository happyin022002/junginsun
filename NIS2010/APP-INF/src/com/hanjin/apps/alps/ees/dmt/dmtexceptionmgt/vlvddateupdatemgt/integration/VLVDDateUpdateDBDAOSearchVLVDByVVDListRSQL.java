/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VLVDDateUpdateDBDAOSearchVLVDByVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VLVDDateUpdateDBDAOSearchVLVDByVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL/VD DATE UPDATE 등록	
	  * UI_DMT_2012	
	  * VL/VD Date Update by VVD
	  * </pre>
	  */
	public VLVDDateUpdateDBDAOSearchVLVDByVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvdc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration").append("\n"); 
		query.append("FileName : VLVDDateUpdateDBDAOSearchVLVDByVVDListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT LANE, VVD, ETA, ETD, FIRSTVL, LASTVL, VLDATEN, VLDATEB, UPDATED, UPDATEO, UPDATEI, UPDATEN," ).append("\n"); 
		query.append("       CLPT_IND_SEQ, PF_ETA, PF_ETB, PF_ETD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+ ORDERED */" ).append("\n"); 
		query.append("K.SLAN_CD                                           LANE    ," ).append("\n"); 
		query.append("K.VSL_CD||K.SKD_VOY_NO||K.SKD_DIR_CD                VVD     ," ).append("\n"); 
		query.append("TO_CHAR( MAX(VPS_ETA_DT)     , 'yyyy-mm-dd' )       ETA     ," ).append("\n"); 
		query.append("TO_CHAR( MAX(VPS_ETD_DT)     , 'yyyy-mm-dd' )       ETD     ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TO_CHAR( MIN(( SELECT  M.CNMV_EVNT_DT  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND CNMV_YR = M.CNMV_YR" ).append("\n"); 
		query.append("AND CNMV_ID_NO = M.CNMV_ID_NO" ).append("\n"); 
		query.append("AND CNMV_SEQ = M.CNMV_SEQ" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN VPS_ETA_DT AND VPS_ETD_DT" ).append("\n"); 
		query.append(")) , 'yyyy-mm-dd hh24:mi' ) FIRSTVL ," ).append("\n"); 
		query.append("TO_CHAR( MAX(( SELECT  M.CNMV_EVNT_DT  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND CNMV_YR = M.CNMV_YR" ).append("\n"); 
		query.append("AND CNMV_ID_NO = M.CNMV_ID_NO" ).append("\n"); 
		query.append("AND CNMV_SEQ = M.CNMV_SEQ" ).append("\n"); 
		query.append("AND M.CNMV_EVNT_DT BETWEEN VPS_ETA_DT AND VPS_ETD_DT" ).append("\n"); 
		query.append(")) , 'yyyy-mm-dd hh24:mi' ) LASTVL ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TO_CHAR( MAX(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE( @[mvmt] , 'VD' , C.FT_CMNC_DT ," ).append("\n"); 
		query.append("'VL' , C.TO_MVMT_DT )" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_CHG_BKG_CNTR    B," ).append("\n"); 
		query.append("DMT_CHG_CALC        C," ).append("\n"); 
		query.append("BKG_VVD				V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("V.VSL_CD            = K.VSL_CD" ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO        = K.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD        = K.SKD_DIR_CD" ).append("\n"); 
		query.append("AND		V.BKG_NO			= B.BKG_NO" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , V.POD_CD , 'VL' , V.POL_CD ) = DECODE( @[mvmt] , 'VD' , B.POD_CD , 'VL' , B.POL_CD )" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , B.POD_CD ," ).append("\n"); 
		query.append("'VL' , B.POL_CD ) = @[port]" ).append("\n"); 
		query.append("AND     B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND     B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${mvmt} == 'VD' )" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD       IN ('DMIF', 'CTIC')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD       IN ('DMOF', 'CTOC')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , SUBSTR(C.FM_MVMT_YD_CD,1,5)" ).append("\n"); 
		query.append(", 'VL' , SUBSTR(C.TO_MVMT_YD_CD,1,5) ) = @[port]" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , C.FT_CMNC_DT" ).append("\n"); 
		query.append(", 'VL' , C.TO_MVMT_DT ) IS NOT NULL" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , NVL( C.FM_MVMT_STS_CD , 'VD' )" ).append("\n"); 
		query.append(", 'VL' , NVL( C.TO_MVMT_STS_CD , 'VL' ) ) = @[mvmt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     DECODE( @[mvmt] , 'VD' , C.FM_MVMT_DT" ).append("\n"); 
		query.append(", 'VL' , NVL( C.TO_MVMT_DT , VPS_ETA_DT + 0.01 ) ) BETWEEN VPS_ETA_DT AND VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")                , 'yyyy-mm-dd' )       VLDATEN ," ).append("\n"); 
		query.append("TO_CHAR( MAX(U.FX_DT)        , 'yyyy-mm-dd' )       VLDATEB ," ).append("\n"); 
		query.append("TO_CHAR( MAX(U.UPD_DT)       , 'yyyy-mm-dd' )       UPDATED ," ).append("\n"); 
		query.append("MAX(U.UPD_OFC_CD)                                   UPDATEO ," ).append("\n"); 
		query.append("MAX(U.UPD_USR_ID)                                   UPDATEI ," ).append("\n"); 
		query.append("MAX((SELECT USR_NM FROM COM_USER WHERE U.UPD_USR_ID        = USR_ID )) UPDATEN," ).append("\n"); 
		query.append("K.CLPT_IND_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TO_CHAR(K.PF_ETA_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETA," ).append("\n"); 
		query.append("TO_CHAR(K.PF_ETB_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETB," ).append("\n"); 
		query.append("TO_CHAR(K.PF_ETD_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CTM_MOVEMENT     M," ).append("\n"); 
		query.append("BKG_BOOKING      B," ).append("\n"); 
		query.append("BKG_CONTAINER    BC," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD K," ).append("\n"); 
		query.append("DMT_VSL_DT_UPD   U" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("K.VSL_CD                        = M.CRNT_VSL_CD" ).append("\n"); 
		query.append("AND     K.SKD_VOY_NO                    = M.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("AND     K.SKD_DIR_CD                    = M.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("--AND     K.CLPT_IND_SEQ                  = '1'" ).append("\n"); 
		query.append("AND     M.BKG_NO                        = B.BKG_NO" ).append("\n"); 
		query.append("AND     B.BKG_STS_CD                    NOT IN ( 'S' , 'X' )" ).append("\n"); 
		query.append("AND     B.BKG_CGO_TP_CD                 = 'F'" ).append("\n"); 
		query.append("AND     M.BKG_NO                        = BC.BKG_NO" ).append("\n"); 
		query.append("AND     M.CNTR_NO                       = BC.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${vvdc} != '' )" ).append("\n"); 
		query.append("AND     K.VSL_CD                        = SUBSTR( @[vvdc] , 1 , 4 )" ).append("\n"); 
		query.append("AND     K.SKD_VOY_NO                    = SUBSTR( @[vvdc] , 5 , 4 )" ).append("\n"); 
		query.append("AND     K.SKD_DIR_CD                    = SUBSTR( @[vvdc] , 9 , 1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     K.VPS_PORT_CD                   = @[port]" ).append("\n"); 
		query.append("AND     M.MVMT_STS_CD                   = @[mvmt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${frdt} != '' && ${todt} != '' )" ).append("\n"); 
		query.append("AND     M.CNMV_EVNT_DT                  BETWEEN TO_DATE(@[frdt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("AND TO_DATE(@[todt],'yyyy-mm-dd') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.ORG_YD_CD         LIKE @[port]||'%'" ).append("\n"); 
		query.append("AND     SUBSTR( M.ORG_YD_CD , 1 , 5 )   = DECODE( @[mvmt] , 'VD' , B.POD_CD , B.POL_CD )" ).append("\n"); 
		query.append("AND     K.VSL_CD            = U.VSL_CD (+)" ).append("\n"); 
		query.append("AND     K.SKD_VOY_NO        = U.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND     K.SKD_DIR_CD        = U.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     K.VPS_PORT_CD       = U.LOC_CD(+)" ).append("\n"); 
		query.append("AND     K.CLPT_IND_SEQ      = U.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND     VL_VD_DIV_CD (+)    = @[mvmt]" ).append("\n"); 
		query.append("GROUP BY K.SLAN_CD , K.VSL_CD , K.SKD_VOY_NO , K.SKD_DIR_CD, K.CLPT_IND_SEQ, K.PF_ETA_DT, K.PF_ETB_DT,K.PF_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT LANE, VVD, ETA, ETD, FIRSTVL, LASTVL, VLDATEN, VLDATEB, UPDATED, UPDATEO, UPDATEI, UPDATEN, CLPT_IND_SEQ," ).append("\n"); 
		query.append("       PF_ETA, PF_ETB, PF_ETD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT LANE, " ).append("\n"); 
		query.append("    RANK() OVER (PARTITION BY VSL, ETA, ETD ORDER BY VSL, TURN_SEQ) RANK," ).append("\n"); 
		query.append("    TURN_IND, VVD, ETA, ETD, FIRSTVL, LASTVL, " ).append("\n"); 
		query.append("    VLDATEN ,    VLDATEB ,      UPDATED ,   UPDATEO ," ).append("\n"); 
		query.append("     UPDATEI ,    UPDATEN,            SEQ," ).append("\n"); 
		query.append("                PF_ETA,           PF_ETB,            PF_ETD , CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT  " ).append("\n"); 
		query.append("            		/*+ ORDERED */" ).append("\n"); 
		query.append("                    K.SLAN_CD                                           LANE    ," ).append("\n"); 
		query.append("                    K.VSL_CD||K.SKD_VOY_NO||K.SKD_DIR_CD                VVD     ," ).append("\n"); 
		query.append("                    TO_CHAR( MAX(VPS_ETA_DT)     , 'yyyy-mm-dd' )       ETA     ," ).append("\n"); 
		query.append("                    TO_CHAR( MAX(VPS_ETD_DT)     , 'yyyy-mm-dd' )       ETD     ," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    TO_CHAR( MIN(( " ).append("\n"); 
		query.append("                         SELECT MIN(M.CNMV_EVNT_DT)" ).append("\n"); 
		query.append("                           FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("                              , BKG_BOOKING B" ).append("\n"); 
		query.append("                              , BKG_CONTAINER    BC" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD        	= M.CRNT_VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO    	= M.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD    	= M.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.BKG_NO 	   	= M.BKG_NO" ).append("\n"); 
		query.append("						   AND B.BKG_CGO_TP_CD  = 'F'" ).append("\n"); 
		query.append("                           AND M.BKG_NO 		= BC.BKG_NO" ).append("\n"); 
		query.append("                           AND M.CNTR_NO 		= BC.CNTR_NO" ).append("\n"); 
		query.append("                           AND M.MVMT_STS_CD 	= @[mvmt]" ).append("\n"); 
		query.append("                           AND SUBSTR( M.ORG_YD_CD , 1 , 5 )   = DECODE( @[mvmt] , 'VD' , B.POD_CD , B.POL_CD )" ).append("\n"); 
		query.append("                           AND M.CNMV_EVNT_DT BETWEEN K.VPS_ETA_DT AND K.VPS_ETD_DT" ).append("\n"); 
		query.append("                      )) , 'yyyy-mm-dd hh24:mi' ) FIRSTVL ," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    TO_CHAR( MAX(( " ).append("\n"); 
		query.append("                         SELECT MAX(M.CNMV_EVNT_DT)" ).append("\n"); 
		query.append("                           FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("                              , BKG_BOOKING B" ).append("\n"); 
		query.append("                              , BKG_CONTAINER    BC" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD        	= M.CRNT_VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO    	= M.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD    	= M.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.BKG_NO 		= M.BKG_NO" ).append("\n"); 
		query.append("						   AND B.BKG_CGO_TP_CD  = 'F'" ).append("\n"); 
		query.append("                           AND M.BKG_NO 		= BC.BKG_NO" ).append("\n"); 
		query.append("                           AND M.CNTR_NO 		= BC.CNTR_NO" ).append("\n"); 
		query.append("                           AND M.MVMT_STS_CD 	= @[mvmt]" ).append("\n"); 
		query.append("                           AND SUBSTR( M.ORG_YD_CD , 1 , 5 )   = DECODE( @[mvmt] , 'VD' , B.POD_CD , B.POL_CD )" ).append("\n"); 
		query.append("                           AND M.CNMV_EVNT_DT BETWEEN K.VPS_ETA_DT AND K.VPS_ETD_DT" ).append("\n"); 
		query.append("                      )) , 'yyyy-mm-dd hh24:mi' ) LASTVL ," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    TO_CHAR( MAX( " ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                                DECODE( @[mvmt] , 'VD' , C.FT_CMNC_DT ," ).append("\n"); 
		query.append("                                                                  'VL' , C.TO_MVMT_DT )" ).append("\n"); 
		query.append("                                        FROM" ).append("\n"); 
		query.append("                                                DMT_CHG_BKG_CNTR    B," ).append("\n"); 
		query.append("                                                DMT_CHG_CALC        C," ).append("\n"); 
		query.append("            									BKG_VVD				V" ).append("\n"); 
		query.append("                                        WHERE" ).append("\n"); 
		query.append("                                                V.VSL_CD            = K.VSL_CD" ).append("\n"); 
		query.append("                                        AND     V.SKD_VOY_NO        = K.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND     V.SKD_DIR_CD        = K.SKD_DIR_CD" ).append("\n"); 
		query.append("            							AND		V.BKG_NO			= B.BKG_NO" ).append("\n"); 
		query.append("            							AND     DECODE( 'VD' , 'VD' , V.POD_CD , 'VL' , V.POL_CD ) = DECODE( 'VD' , 'VD' , B.POD_CD , 'VL' , B.POL_CD )" ).append("\n"); 
		query.append("                                        AND     DECODE( @[mvmt] , 'VD' , B.POD_CD ," ).append("\n"); 
		query.append("                                                                  'VL' , B.POL_CD ) = @[port]" ).append("\n"); 
		query.append("                                        AND     B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("                                        AND     B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${mvmt} == 'VD' )" ).append("\n"); 
		query.append("                                        AND     C.DMDT_TRF_CD       IN ('DMIF', 'CTIC')" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                                        AND     C.DMDT_TRF_CD       IN ('DMOF', 'CTOC')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                                        AND     DECODE( @[mvmt] , 'VD' , SUBSTR(C.FM_MVMT_YD_CD,1,5)" ).append("\n"); 
		query.append("                                                                , 'VL' , SUBSTR(C.TO_MVMT_YD_CD,1,5) ) = @[port]" ).append("\n"); 
		query.append("                                        AND     DECODE( @[mvmt] , 'VD' , C.FT_CMNC_DT                " ).append("\n"); 
		query.append("                                                                , 'VL' , C.TO_MVMT_DT ) IS NOT NULL" ).append("\n"); 
		query.append("                                        AND     DECODE( @[mvmt] , 'VD' , NVL( C.FM_MVMT_STS_CD , 'VD' )" ).append("\n"); 
		query.append("                                                                , 'VL' , NVL( C.TO_MVMT_STS_CD , 'VL' ) ) = @[mvmt]" ).append("\n"); 
		query.append("            							" ).append("\n"); 
		query.append("                                        AND     DECODE( @[mvmt] , 'VD' , C.FM_MVMT_DT" ).append("\n"); 
		query.append("                                                                , 'VL' , NVL( C.TO_MVMT_DT , VPS_ETA_DT + 0.01 ) ) BETWEEN VPS_ETA_DT AND VPS_ETD_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            							AND 	ROWNUM = 1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                )                , 'yyyy-mm-dd' )       VLDATEN ," ).append("\n"); 
		query.append("                    TO_CHAR( MAX(U.FX_DT)        , 'yyyy-mm-dd' )       VLDATEB ," ).append("\n"); 
		query.append("                    TO_CHAR( MAX(U.UPD_DT)       , 'yyyy-mm-dd' )       UPDATED ," ).append("\n"); 
		query.append("                    MAX(U.UPD_OFC_CD)                                   UPDATEO ," ).append("\n"); 
		query.append("                    MAX(U.UPD_USR_ID)                                   UPDATEI ," ).append("\n"); 
		query.append("                    MAX((SELECT USR_NM FROM COM_USER WHERE U.UPD_USR_ID        = USR_ID )) UPDATEN," ).append("\n"); 
		query.append("                    K.CLPT_IND_SEQ," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    TO_CHAR(K.PF_ETA_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETA," ).append("\n"); 
		query.append("                    TO_CHAR(K.PF_ETB_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETB," ).append("\n"); 
		query.append("                    TO_CHAR(K.PF_ETD_DT, 'yyyy-mm-dd hh24:mi') AS PF_ETD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 	K.VSL_CD VSL," ).append("\n"); 
		query.append("                	K.TURN_PORT_IND_CD   TURN_IND," ).append("\n"); 
		query.append("                	K.CLPT_IND_SEQ SEQ," ).append("\n"); 
		query.append("					/* D,V,F 는 VD 시점, Y,N 은 VL, VD 양쪽 다 가능하기 때문에 우선순위를 둠. */" ).append("\n"); 
		query.append("                    DECODE(K.TURN_PORT_IND_CD,'D','1','V','1','F','1','2')   TURN_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("               , DMT_VSL_DT_UPD U" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${frdt} != '' && ${todt} != '' )" ).append("\n"); 
		query.append("            AND     K.VPS_ETA_DT                  BETWEEN TO_DATE(@[frdt],'yyyy-mm-dd') " ).append("\n"); 
		query.append("                                                        AND TO_DATE(@[todt],'yyyy-mm-dd') + .99999" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${vvdc} != '' )" ).append("\n"); 
		query.append("            AND     K.VSL_CD                        = SUBSTR( @[vvdc] , 1 , 4 )" ).append("\n"); 
		query.append("            AND     K.SKD_VOY_NO                    = SUBSTR( @[vvdc] , 5 , 4 )" ).append("\n"); 
		query.append("            AND     K.SKD_DIR_CD                    = SUBSTR( @[vvdc] , 9 , 1 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND     K.VPS_PORT_CD                   = @[port]" ).append("\n"); 
		query.append("            AND     K.VSL_CD            = U.VSL_CD (+)" ).append("\n"); 
		query.append("            AND     K.SKD_VOY_NO        = U.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("            AND     K.SKD_DIR_CD        = U.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND     K.VPS_PORT_CD       = U.LOC_CD(+)" ).append("\n"); 
		query.append("            AND     K.CLPT_IND_SEQ      = U.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("            AND     VL_VD_DIV_CD (+)    = @[mvmt]" ).append("\n"); 
		query.append("            AND     NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${mvmt} == 'VL' )" ).append("\n"); 
		query.append("            AND EXISTS ( SELECT /*+ NO_UNNEST */  'X' FROM MDM_VSL_SVC_LANE WHERE K.SLAN_CD = VSL_SLAN_CD AND ((VSL_SVC_TP_CD <> 'O' AND K.TURN_PORT_IND_CD in ('Y', 'N')) or VSL_SVC_TP_CD = 'O') )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("            GROUP BY K.SLAN_CD, K.VSL_CD, K.SKD_VOY_NO, K.SKD_DIR_CD, K.CLPT_IND_SEQ, K.PF_ETA_DT, K.PF_ETB_DT,K.PF_ETD_DT, K.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RANK ='1'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY LANE, VVD, ETA, CLPT_IND_SEQ" ).append("\n"); 

	}
}