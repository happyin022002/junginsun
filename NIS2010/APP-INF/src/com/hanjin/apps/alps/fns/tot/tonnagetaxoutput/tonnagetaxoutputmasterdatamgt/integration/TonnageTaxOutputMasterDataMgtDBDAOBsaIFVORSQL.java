/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA Creation by vessel voyage 인터페이스 데이터 조회
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOBsaIFVORSQL").append("\n"); 
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
		query.append("/*2009.11.05 by 박효숙 차장     charter BSA 로직삭제*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(F M) */ " ).append("\n"); 
		query.append("			F.STL_YRMON" ).append("\n"); 
		query.append("			, DECODE(F.TRD_CD,NULL, T.TRD_CD,F.TRD_CD)    TRD_CD" ).append("\n"); 
		query.append("			,F.SLAN_CD" ).append("\n"); 
		query.append("			,F.VSL_CD" ).append("\n"); 
		query.append("			,F.SKD_VOY_NO" ).append("\n"); 
		query.append("			,F.SKD_DIR_CD" ).append("\n"); 
		query.append("			,M.NET_RGST_TONG_WGT    NRT_WGT" ).append("\n"); 
		query.append("			,M.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append("			,CASE WHEN L.VSL_SVC_TP_CD = 'S' THEN" ).append("\n"); 
		query.append("              (SELECT DECODE(M.CNTR_DZN_CAPA,NULL,B.LDB_CAPA_QTY,0,B.LDB_CAPA_QTY,M.CNTR_DZN_CAPA) " ).append("\n"); 
		query.append("               FROM   MDM_VSL_CNTR M" ).append("\n"); 
		query.append("               WHERE  M.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("             ELSE DECODE(F.LDB_CAPA_QTY,NULL,B.LDB_CAPA_QTY,0,B.LDB_CAPA_QTY,F.LDB_CAPA_QTY)" ).append("\n"); 
		query.append("             END LDB_CAPA_QTY" ).append("\n"); 
		query.append("			,F.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("			,F.CRR_BSA_CAPA" ).append("\n"); 
		query.append("			,F.TONG_BSA_CAPA" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("			SELECT  /*+ ORDERED USE_NL(F C) */ @[stl_yrmon] STL_YRMON" ).append("\n"); 
		query.append("					, C.TRD_CD" ).append("\n"); 
		query.append("					, F.VSL_SLAN_CD          SLAN_CD" ).append("\n"); 
		query.append("					, F.VSL_CD" ).append("\n"); 
		query.append("					, F.SKD_VOY_NO" ).append("\n"); 
		query.append("					, F.SKD_DIR_CD" ).append("\n"); 
		query.append("					, C.VSL_CAPA            LDB_CAPA_QTY" ).append("\n"); 
		query.append("					, C.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("					, 0 CRR_BSA_CAPA" ).append("\n"); 
		query.append("					, C.FNL_HJS_BSA_CAPA  TONG_BSA_CAPA     " ).append("\n"); 
		query.append("			  FROM (" ).append("\n"); 
		query.append("			        SELECT /*+ ORDERED USE_NL(V L) */ V.VSL_SLAN_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD     " ).append("\n"); 
		query.append("			          FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("			             , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("			            " ).append("\n"); 
		query.append("			         WHERE (V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("			                                                        SELECT /*+ index(V1) */ VSL_CD,SKD_VOY_NO,SKD_DIR_CD " ).append("\n"); 
		query.append("			                                                        FROM VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("			        		                                            WHERE VPS_ETD_DT BETWEEN TO_DATE(@[stl_yrmon] ||'01','yyyymmdd') and last_day(to_date(@[stl_yrmon],'yyyymm'))+0.99999" ).append("\n"); 
		query.append("			        		                                              AND NVL(SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("			        		                                              AND TURN_PORT_IND_CD NOT IN ('V','D',DECODE(NVL(TURN_SKD_VOY_NO,''),'','V','F')) " ).append("\n"); 
		query.append("			        		                                              AND VPS_PORT_CD NOT IN ('PAPAC','EGSUZ')" ).append("\n"); 
		query.append("			           		                                         )                                      " ).append("\n"); 
		query.append("			           AND L.VSL_SVC_TP_CD IN ('J','S','I')      /* NON FEEDER 조건*/" ).append("\n"); 
		query.append("			           AND V.VSL_SLAN_CD = L.VSL_SLAN_CD	" ).append("\n"); 
		query.append("			           AND V.VSL_SLAN_CD IN ( SELECT  L.VSL_SLAN_CD" ).append("\n"); 
		query.append("			                                  FROM TOT_LANE L" ).append("\n"); 
		query.append("			                                       ,TOT_LANE_TRD T" ).append("\n"); 
		query.append("			                                  WHERE L.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("			                                    AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			                                    AND T.LANE_SEQ = '1'" ).append("\n"); 
		query.append("			                                    AND L.STL_YRMON = T.STL_YRMON" ).append("\n"); 
		query.append("			                                    AND L.VSL_SLAN_CD = T.VSL_SLAN_CD)" ).append("\n"); 
		query.append("			           AND NVL(L.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			     ) F LEFT OUTER JOIN BSA_VVD_MST C                                         " ).append("\n"); 
		query.append("			     ON EXISTS (    SELECT 'X' FROM MAS_MON_VVD D" ).append("\n"); 
		query.append("			                    WHERE  D.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("			                    AND D.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("			                    AND D.DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("			                    and D.TRD_CD = C.TRD_CD" ).append("\n"); 
		query.append("			                    and D.DELT_FLG = 'N' " ).append("\n"); 
		query.append("			                    and D.RLANE_CD = C.RLANE_CD )" ).append("\n"); 
		query.append("			     AND F.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("			     AND F.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("			     AND F.SKD_DIR_CD = C.SKD_DIR_CD " ).append("\n"); 
		query.append("			     AND SUBSTR(C.RLANE_CD,0,3) = F.VSL_SLAN_CD" ).append("\n"); 
		query.append("			     AND C.RLANE_CD IS NOT NULL" ).append("\n"); 
		query.append("			        " ).append("\n"); 
		query.append("			) F, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("			   , (SELECT  VSL_SLAN_CD , TRD_CD  FROM TOT_LANE_TRD WHERE STL_YRMON = @[stl_yrmon] AND LANE_SEQ = '1') T " ).append("\n"); 
		query.append("			   , (SELECT VSL_CD , SKD_VOY_NO, SKD_DIR_CD, SLAN_CD, TRD_CD , LDB_CAPA_QTY FROM TOT_BSA  WHERE STL_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[stl_yrmon],'YYYYMM'),-1),'YYYYMM')) B" ).append("\n"); 
		query.append("               , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("WHERE F.VSL_CD = M.VSL_CD(+)" ).append("\n"); 
		query.append("  AND F.SLAN_CD = T.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND F.VSL_CD = B.VSL_CD (+)" ).append("\n"); 
		query.append("  AND F.SKD_VOY_NO = B.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("  AND F.SKD_DIR_CD = B.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("  AND F.SLAN_CD = B.SLAN_CD (+)" ).append("\n"); 
		query.append("  AND F.TRD_CD = B.TRD_CD (+)" ).append("\n"); 
		query.append("  AND F.SLAN_CD = L.VSL_SLAN_CD(+)" ).append("\n"); 

	}
}