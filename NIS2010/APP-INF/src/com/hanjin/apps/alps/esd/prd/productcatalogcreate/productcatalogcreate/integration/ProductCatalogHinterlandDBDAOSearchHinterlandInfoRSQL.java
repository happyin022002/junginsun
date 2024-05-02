/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOSearchHinterlandInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.06.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogHinterlandDBDAOSearchHinterlandInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHinterlandInfo
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOSearchHinterlandInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOSearchHinterlandInfoRSQL").append("\n"); 
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
		query.append("SELECT RUN_TM, PCTL_NO, TERM_CD--, IO_BND_CD" ).append("\n"); 
		query.append("     , REPLACE(SUBSTR(REGEXP_SUBSTR(ERR_VAL, '\\[P..-', 1), 2,3), 'P00', '') ERR_CD" ).append("\n"); 
		query.append("     , SUBSTR(REPLACE(REGEXP_REPLACE(ERR_VAL,'\\[P..-', ','), ']', ''),2) ERR_DESC" ).append("\n"); 
		query.append("--     , REPLACE ((SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD10101' " ).append("\n"); 
		query.append("--                   AND INTG_CD_VAL_CTNT = SUBSTR(REGEXP_SUBSTR(ERR_VAL, '\\[P..-', 1), 2,3)) -- ERR_CD" ).append("\n"); 
		query.append("--               , '%', SUBSTR(REPLACE(REGEXP_REPLACE(ERR_VAL,'\\[P..-', ','), ']', ''),2)" ).append("\n"); 
		query.append("--               ) ERR_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT RUN_TM, PCTL_NO, TERM_CD, IO_BND_CD" ).append("\n"); 
		query.append("         , CASE WHEN IO_BND_CD = 'T' THEN FDR_ROUT_ERR_CD" ).append("\n"); 
		query.append("                WHEN IO_BND_CD IN ('I','O') THEN" ).append("\n"); 
		query.append("                CASE WHEN INLND_OPTM_EXISTS = 'N' THEN '[P99-]' -- err_code에 정의되지 않은 코드" ).append("\n"); 
		query.append("                     WHEN TRANS_MODE_ERR IS NOT NULL THEN TRANS_MODE_ERR" ).append("\n"); 
		query.append("                     WHEN TERM_CD = 'D' AND MTY_YD_CD IS NULL THEN '[P36-' || DECODE(IO_BND_CD, 'O', @[fm_nod_cd], @[to_nod_cd])||']'" ).append("\n"); 
		query.append("                     ELSE NULLIF('[P01-' " ).append("\n"); 
		query.append("                                ||(SELECT BKG_JOIN_FNC( CURSOR(" ).append("\n"); 
		query.append("                                    SELECT M.NOD_CD" ).append("\n"); 
		query.append("                                    FROM (" ).append("\n"); 
		query.append("                                       SELECT (CASE WHEN @[io_bnd_cd] = 'I' THEN" ).append("\n"); 
		query.append("                                                 CASE WHEN (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[to_nod_cd] AND ROWNUM = 1) = 'Z' THEN" ).append("\n"); 
		query.append("                                                           (SELECT REP_YD_CD FROM MDM_ZONE WHERE NVL(DELT_FLG,'N') = 'N' AND ZN_CD = @[to_nod_cd])" ).append("\n"); 
		query.append("                                                      END" ).append("\n"); 
		query.append("                                            WHEN @[io_bnd_cd] = 'O' THEN" ).append("\n"); 
		query.append("                                                 CASE WHEN (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[fm_nod_cd] AND ROWNUM = 1) = 'Z' THEN" ).append("\n"); 
		query.append("                                                           (SELECT REP_YD_CD FROM MDM_ZONE WHERE NVL(DELT_FLG,'N') = 'N' AND ZN_CD = @[fm_nod_cd])" ).append("\n"); 
		query.append("                                                      END" ).append("\n"); 
		query.append("                                            END) AS NOD_CD" ).append("\n"); 
		query.append("                                       FROM DUAL" ).append("\n"); 
		query.append("                                       UNION " ).append("\n"); 
		query.append("                                       SELECT @[fm_nod_cd] FROM DUAL" ).append("\n"); 
		query.append("                                       UNION" ).append("\n"); 
		query.append("                                       SELECT B.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("                                       FROM PRD_INLND_ROUT_MST A" ).append("\n"); 
		query.append("                                          , PRD_INLND_ROUT_DTL B" ).append("\n"); 
		query.append("                                       WHERE A.ROUT_ORG_NOD_CD = @[fm_nod_cd] " ).append("\n"); 
		query.append("                                       AND A.ROUT_DEST_NOD_CD = @[to_nod_cd] " ).append("\n"); 
		query.append("                                       AND A.PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                       AND A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                       AND A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                       AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                                       AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                       AND A.INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("                                       ) M" ).append("\n"); 
		query.append("                                    WHERE NOT EXISTS (SELECT 1 FROM PRD_NODE N WHERE N.NOD_CD = M.NOD_CD AND NVL(DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append("                                    ), ',') ERR_NOD_CD" ).append("\n"); 
		query.append("                                FROM DUAL) ||']' " ).append("\n"); 
		query.append("                                , '[P01-]')" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("           END AS ERR_VAL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS') RUN_TM" ).append("\n"); 
		query.append("             , (SELECT DECODE(NOD_TP_CD, 'Z', 'D', 'Y') FROM PRD_NODE WHERE NOD_CD = DECODE(@[io_bnd_cd], 'O', @[fm_nod_cd], 'I', @[to_nod_cd]) ) TERM_CD" ).append("\n"); 
		query.append("             , NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                  FROM PRD_INLND_ROUT_MST " ).append("\n"); 
		query.append("                 WHERE @[io_bnd_cd] IN ('O','I')" ).append("\n"); 
		query.append("                   AND ROUT_ORG_NOD_CD = @[fm_nod_cd] " ).append("\n"); 
		query.append("                   AND ROUT_DEST_NOD_CD = @[to_nod_cd] " ).append("\n"); 
		query.append("                   AND PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   AND INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ), 'N') INLND_OPTM_EXISTS" ).append("\n"); 
		query.append("             , CASE WHEN @[io_bnd_cd] = 'I' THEN" ).append("\n"); 
		query.append("                         CASE WHEN (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[to_nod_cd] AND ROWNUM = 1) = 'Z' THEN" ).append("\n"); 
		query.append("                                   (SELECT REP_YD_CD FROM MDM_ZONE WHERE NVL(DELT_FLG,'N') = 'N' AND ZN_CD = @[to_nod_cd])" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                    WHEN @[io_bnd_cd] = 'O' THEN" ).append("\n"); 
		query.append("                         CASE WHEN (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = @[fm_nod_cd] AND ROWNUM = 1) = 'Z' THEN" ).append("\n"); 
		query.append("                                   (SELECT REP_YD_CD FROM MDM_ZONE WHERE NVL(DELT_FLG,'N') = 'N' AND ZN_CD = @[fm_nod_cd])" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                    END AS MTY_YD_CD" ).append("\n"); 
		query.append("             , (SELECT CASE WHEN COUNT(1) = 2 AND MAX(INLND_ROUT_CMB_FLG) = 'Y'  -- COMBINE MODE 이면서 OUTBOUND에서 TD가 뒤에 INBOUND에서 TD가 앖에 오는 것은 OPTIMUM으로 허용되지 않는다." ).append("\n"); 
		query.append("                                 AND DECODE(@[io_bnd_cd], 'O', MAX(DECODE(ROUT_DTL_SEQ, 2, TRSP_MOD_CD)), MAX(DECODE(ROUT_DTL_SEQ, 1, TRSP_MOD_CD))) = 'TD'" ).append("\n"); 
		query.append("                                THEN '[P37-' || DECODE(@[io_bnd_cd], 'O', 'Outbound {', 'Inbound {') || REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ), '-.-','-') || '}]'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                  FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("                 WHERE (ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ)" ).append("\n"); 
		query.append("                       IN (SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ" ).append("\n"); 
		query.append("                             FROM PRD_INLND_ROUT_MST A" ).append("\n"); 
		query.append("                            WHERE @[io_bnd_cd] IN ('O','I')" ).append("\n"); 
		query.append("                              AND ROUT_ORG_NOD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append("                              AND ROUT_DEST_NOD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                              AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                              AND INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("                              AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                GROUP BY ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ" ).append("\n"); 
		query.append("               ) TRANS_MODE_ERR" ).append("\n"); 
		query.append("             -- FEEDER LINK (여기서 ERRCODE VALUE 모두 찾음)" ).append("\n"); 
		query.append("             , NVL((SELECT CASE WHEN LENGTH(@[fm_nod_cd]) = 7 AND POLT.TML_CD <> @[fm_nod_cd] AND LENGTH(@[to_nod_cd]) = 7 AND PODT.TML_CD <> @[to_nod_cd] THEN '[P62-' || @[fm_nod_cd] || ',' || @[to_nod_cd] || ']'" ).append("\n"); 
		query.append("                                WHEN LENGTH(@[fm_nod_cd]) = 7 AND POLT.TML_CD <> @[fm_nod_cd] THEN '[P62-' || @[fm_nod_cd] || ']'" ).append("\n"); 
		query.append("                                WHEN LENGTH(@[to_nod_cd]) = 7 AND PODT.TML_CD <> @[to_nod_cd] THEN '[P62-' || @[to_nod_cd] || ']'" ).append("\n"); 
		query.append("                                WHEN POLT.TML_CD IS NULL AND PODT.TML_CD IS NULL AND FLNK.LNK_ORG_LOC_CD = FLNK.LNK_DEST_LOC_CD THEN '[P62-' || FLNK.LNK_ORG_LOC_CD || ']'  -- BOTH TERMINAL MATRIX DOES NOT EXISTS" ).append("\n"); 
		query.append("                                WHEN POLT.TML_CD IS NULL AND PODT.TML_CD IS NULL THEN '[P62-' || FLNK.LNK_ORG_LOC_CD || ',' || FLNK.LNK_DEST_LOC_CD || ']'  -- BOTH TERMINAL MATRIX DOES NOT EXISTS" ).append("\n"); 
		query.append("                                WHEN POLT.TML_CD IS NULL THEN '[P62-' || FLNK.LNK_ORG_LOC_CD || ']' -- POL PORT TERMINAL MATRIX DOES NOT EXISTS" ).append("\n"); 
		query.append("                                WHEN PODT.TML_CD IS NULL THEN '[P62-' || FLNK.LNK_DEST_LOC_CD || ']'-- POD PORT TERMINAL MATRIX DOES NOT EXISTS" ).append("\n"); 
		query.append("                                ELSE NVL(DECODE((SELECT 1 FROM MDM_YARD WHERE YD_CD = POLT.TML_CD AND NVL(DELT_FLG, 'N') = 'N'), NULL, '[P01-' || POLT.TML_CD || ']')" ).append("\n"); 
		query.append("                                     || DECODE((SELECT 1 FROM MDM_YARD WHERE YD_CD = PODT.TML_CD AND NVL(DELT_FLG, 'N') = 'N'), NULL, '[P01-' || PODT.TML_CD || ']')" ).append("\n"); 
		query.append("                                    , '[P00]')" ).append("\n"); 
		query.append("                                END " ).append("\n"); 
		query.append("                    FROM PRD_FDR_LNK FLNK" ).append("\n"); 
		query.append("                       , PRD_PORT_TML_MTX POLT" ).append("\n"); 
		query.append("                       , PRD_PORT_TML_MTX PODT" ).append("\n"); 
		query.append("                    WHERE @[io_bnd_cd] = 'T'" ).append("\n"); 
		query.append("                      AND FLNK.LNK_ORG_LOC_CD = SUBSTR(@[fm_nod_cd],1,5) " ).append("\n"); 
		query.append("                      AND FLNK.LNK_DEST_LOC_CD = SUBSTR(@[to_nod_cd],1,5) " ).append("\n"); 
		query.append("                      AND FLNK.VSL_SLAN_CD = 'FDR'" ).append("\n"); 
		query.append("                      AND NVL(FLNK.DELT_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("                      AND FLNK.LNK_ORG_LOC_CD = POLT.PORT_CD(+)" ).append("\n"); 
		query.append("                      AND FLNK.VSL_SLAN_CD = POLT.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                      AND FLNK.SKD_DIR_CD = POLT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                      AND FLNK.LNK_DEST_LOC_CD = PODT.PORT_CD(+)" ).append("\n"); 
		query.append("                      AND FLNK.VSL_SLAN_CD = PODT.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                      AND FLNK.SKD_DIR_CD = PODT.SKD_DIR_CD(+))" ).append("\n"); 
		query.append("                 , '[P99-]') FDR_ROUT_ERR_CD -- RHQ LINK DOES NOT EXISTS" ).append("\n"); 
		query.append("             , (SELECT PCTL_NO FROM PRD_PROD_CTL_MST WHERE ROWNUM = 1 ) PCTL_NO" ).append("\n"); 
		query.append("             , @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}