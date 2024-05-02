/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOLoadImportOceanVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOLoadImportOceanVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.12.03 CHM-201221299-01 이혜민 신규 장비 R8,R9 을 40’HC으로 분류하여 CBF 및 COD 메뉴에 반영
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOLoadImportOceanVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOLoadImportOceanVORSQL").append("\n"); 
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
		query.append("SELECT 'SML' OPR_CD,                                                                                                        " ).append("\n"); 
		query.append("       V.POD_CD,                                                                                                            " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, 0), 0), 0)) 	FULL_IN_20,  " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, 0), 0), 0)) 	FULL_IN_2H,  " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, 0), 0), 0)) 	FULL_IN_40,  " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END), 0), 0)) 	FULL_IN_4H,  " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, 0), 0), 0)) 	FULL_IN_45,  " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 2, 1, 0), 0)))  	FULL_TS_20,   " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 3, 1, 0), 0)))  	FULL_TS_2H,   " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 4, 1, 0), 0)))  	FULL_TS_40,   " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 5, 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END), 0)))  	FULL_TS_4H,   " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 7, 1, 0), 0)))  	FULL_TS_45,   " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 2, 1, 0)), 0))  	ET_IN_20,     " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 3, 1, 0)), 0))  	ET_IN_2H,     " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 4, 1, 0)), 0))  	ET_IN_40,     " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 5, 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END)), 0))  	ET_IN_4H,     " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(CCNTR_TPSZ_CD, 2, 1), 7, 1, 0)), 0))  	ET_IN_45,     " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, 0)))) 	ET_TS_20,    " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, 0)))) 	ET_TS_2H,    " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, 0)))) 	ET_TS_40,    " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END)))) 	ET_TS_4H,    " ).append("\n"); 
		query.append("       SUM(DECODE(V.POL_CD, B.POL_CD, 0, DECODE(B.BKG_CGO_TP_CD, 'F', 0, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, 0)))) 	ET_TS_45,    " ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', C.CNTR_WGT, 0))                                                					WT_20,       " ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '3', C.CNTR_WGT, 0))                                                					WT_2H,       " ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '4', C.CNTR_WGT, 0))                                                					WT_40,       " ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '5', C.CNTR_WGT, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN C.CNTR_WGT ELSE 0 END)) 	WT_4H,       " ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '7', C.CNTR_WGT, 0))                                                					WT_45       " ).append("\n"); 
		query.append("FROM   BKG_VVD V,  BKG_CONTAINER C,  BKG_BOOKING B,  MDM_LOCATION L,  MDM_LOCATION D" ).append("\n"); 
		query.append("WHERE  V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND    V.POL_YD_CD  = @[port_cd]" ).append("\n"); 
		query.append("AND    V.BKG_NO     = C.BKG_NO                                                                                             " ).append("\n"); 
		query.append("AND    V.BKG_NO     = B.BKG_NO                                                                                             " ).append("\n"); 
		query.append("AND    V.POL_CD     = L.LOC_CD                                                                                             " ).append("\n"); 
		query.append("AND    V.POD_CD     = D.LOC_CD                                                                                             " ).append("\n"); 
		query.append("AND    L.CONTI_CD   <> D.CONTI_CD                                                                                          " ).append("\n"); 
		query.append("GROUP BY V.POD_CD" ).append("\n"); 
		query.append("ORDER BY V.POD_CD" ).append("\n"); 

	}
}