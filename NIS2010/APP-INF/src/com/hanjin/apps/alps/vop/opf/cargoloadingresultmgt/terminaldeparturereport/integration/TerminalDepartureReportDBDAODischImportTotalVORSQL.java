/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TerminalDepartureReportDBDAODischImportTotalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.19 
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

public class TerminalDepartureReportDBDAODischImportTotalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Bkg Total
	  * 
	  * 1. 2012.12.03 CHM-201221299-01 이혜민 신규 장비 R8,R9 을 40’HC으로 분류하여 CBF 및 COD 메뉴에 반영
	  * 
	  * 2. 2012.12.10 [CHM-201221836] 이수진 TOR: Load/Discharge Vol 을 Bkg data에서 Import시 source 변경
	  *    1) Vol 산정 기준 : 기존 BKG 단위에서 CNTR 단위로 변경
	  *    2) Weight 산정 기준 : 기존 Cargo 무게에서 Cargo 무게 + CNTR 무게 합으로 변경
	  * </pre>
	  */
	public TerminalDepartureReportDBDAODischImportTotalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAODischImportTotalVORSQL").append("\n"); 
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
		query.append("SELECT 'SML' OPR_CD, " ).append("\n"); 
		query.append("       @[port_cd] AS POD_CD," ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL), NULL), NULL)) FULL_BO_20, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL), NULL), NULL)) FULL_BO_2H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL), NULL), NULL)) FULL_BO_40, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END), NULL), NULL)) FULL_BO_4H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL), NULL), NULL)) FULL_BO_45," ).append("\n"); 
		query.append("	   SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL), NULL), NULL)) FULL_BO_DX, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL),  NULL))) FULL_TS_20, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL),  NULL))) FULL_TS_2H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL),  NULL))) FULL_TS_40, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END),  NULL))) FULL_TS_4H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL),  NULL))) FULL_TS_45, " ).append("\n"); 
		query.append("	   SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL),  NULL))) FULL_TS_DX," ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL)), NULL)) ET_BO_20, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL)), NULL)) ET_BO_2H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL)), NULL)) ET_BO_40, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END)), NULL)) ET_BO_4H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL)), NULL)) ET_BO_45, " ).append("\n"); 
		query.append("	   SUM(DECODE(VVD_POD, BKG_POD, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL)), NULL)) ET_BO_DX," ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL)))) ET_TS_20, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL)))) ET_TS_2H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL)))) ET_TS_40, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END)))) ET_TS_4H, " ).append("\n"); 
		query.append("       SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL)))) ET_TS_45, " ).append("\n"); 
		query.append("	   SUM(DECODE(VVD_POD, BKG_POD, NULL, DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL)))) ET_TS_DX," ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', CNTR_WGT, NULL)) / 1000, 1)                                									WT_20, " ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', CNTR_WGT, NULL)) / 1000, 1)                               										WT_2H, " ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', CNTR_WGT, NULL)) / 1000, 1)                                									WT_40, " ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', CNTR_WGT, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN CNTR_WGT ELSE NULL END)) / 1000, 1)      WT_4H, " ).append("\n"); 
		query.append("       ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', CNTR_WGT, NULL)) / 1000, 1)                                									WT_45," ).append("\n"); 
		query.append("	   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', CNTR_WGT, NULL)) / 1000, 1)                                                                    WT_DX" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT  XX.VVD_POD" ).append("\n"); 
		query.append("	     ,  XX.BKG_POD" ).append("\n"); 
		query.append("	     ,  XX.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	     ,  XX.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	     ,  XX.CNTR_NO" ).append("\n"); 
		query.append("	     ,  CNTR_WGT + (SELECT C.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ C WHERE C.CNTR_TPSZ_CD = XX.CNTR_TPSZ_CD)  CNTR_WGT" ).append("\n"); 
		query.append("	FROM   (" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		 SELECT " ).append("\n"); 
		query.append("				    V.POD_CD VVD_POD" ).append("\n"); 
		query.append("	    		,  	B.POD_CD BKG_POD" ).append("\n"); 
		query.append("	    		,  	B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_NO" ).append("\n"); 
		query.append("	    		,  	SUM(DECODE(C.WGT_UT_CD,'KGS',C.CNTR_WGT,'LBS',C.CNTR_WGT*0.453599,C.CNTR_WGT)) CNTR_WGT   -- BKG_CONTAINER.CNTR_WGT <== CARGO WEIGHT, CNTR TARE WEIGHT 미적용상태임 --" ).append("\n"); 
		query.append("	         FROM   VSK_VSL_PORT_SKD 	S" ).append("\n"); 
		query.append("		      ,  	BKG_VVD 			V" ).append("\n"); 
		query.append("		      ,  	BKG_CONTAINER 		C" ).append("\n"); 
		query.append("		      ,  	BKG_BOOKING 		B" ).append("\n"); 
		query.append("	         WHERE  S.VSL_CD       		= @[vsl_cd] " ).append("\n"); 
		query.append("	         AND    S.SKD_VOY_NO   		= @[voy_no] " ).append("\n"); 
		query.append("	         AND    S.SKD_DIR_CD   		= @[dir_cd] " ).append("\n"); 
		query.append("	         AND    S.YD_CD        		= @[yd_cd] " ).append("\n"); 
		query.append("	         AND    S.CLPT_IND_SEQ 		= @[clpt_ind_seq]" ).append("\n"); 
		query.append("	         AND    S.VSL_CD       		= V.VSL_CD" ).append("\n"); 
		query.append("	         AND    S.SKD_VOY_NO   		= V.SKD_VOY_NO" ).append("\n"); 
		query.append("	         AND    S.SKD_DIR_CD   		= V.SKD_DIR_CD" ).append("\n"); 
		query.append("	         AND    S.VPS_PORT_CD  		= V.POD_CD" ).append("\n"); 
		query.append("	         AND    S.CLPT_IND_SEQ 		= NVL(V.POD_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("	         AND    V.BKG_NO       		= C.BKG_NO" ).append("\n"); 
		query.append("	         AND    V.BKG_NO       		= B.BKG_NO" ).append("\n"); 
		query.append("	         AND    NVL(B.BKG_STS_CD, 'N') NOT IN ('X', 'A')		" ).append("\n"); 
		query.append("		GROUP BY " ).append("\n"); 
		query.append("	       			V.POD_CD" ).append("\n"); 
		query.append("	    		,  	B.POD_CD" ).append("\n"); 
		query.append("	    		,  	B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	   		    ,  	C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	         UNION ALL" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		 SELECT " ).append("\n"); 
		query.append("				    V.POD_CD VVD_POD" ).append("\n"); 
		query.append("	    		,  	B.POD_CD BKG_POD" ).append("\n"); 
		query.append("	    		,  	B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_NO" ).append("\n"); 
		query.append("	    		,  	SUM(DECODE(C.WGT_UT_CD,'KGS',C.CNTR_WGT,'LBS',C.CNTR_WGT*0.453599,C.CNTR_WGT)) CNTR_WGT" ).append("\n"); 
		query.append("	         FROM   VSK_VSL_PORT_SKD 	S" ).append("\n"); 
		query.append("		      ,  	BKG_VVD 			V" ).append("\n"); 
		query.append("		      ,  	BKG_CONTAINER 		C" ).append("\n"); 
		query.append("		      ,  	BKG_BOOKING 		B" ).append("\n"); 
		query.append("	         WHERE  S.VSL_CD            = @[vsl_cd] " ).append("\n"); 
		query.append("	         AND    S.SKD_VOY_NO        = @[voy_no] " ).append("\n"); 
		query.append("	         AND    S.SKD_DIR_CD        = @[dir_cd] " ).append("\n"); 
		query.append("	         AND    S.YD_CD             = @[yd_cd] " ).append("\n"); 
		query.append("	         AND    S.CLPT_IND_SEQ 		= @[clpt_ind_seq]" ).append("\n"); 
		query.append("	         AND    S.TURN_PORT_FLG     = 'Y'" ).append("\n"); 
		query.append("	         AND    S.VSL_CD            = V.VSL_CD" ).append("\n"); 
		query.append("	         AND    S.TURN_SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("	         AND    S.TURN_SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("	         AND    S.VPS_PORT_CD       = V.POD_CD" ).append("\n"); 
		query.append("	         AND    S.TURN_CLPT_IND_SEQ = NVL(V.POD_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("	         AND    V.BKG_NO            = C.BKG_NO" ).append("\n"); 
		query.append("	         AND    V.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("	         AND    NVL(B.BKG_STS_CD, 'N') NOT IN ('X', 'A') 	" ).append("\n"); 
		query.append("		GROUP BY " ).append("\n"); 
		query.append("	       			V.POD_CD" ).append("\n"); 
		query.append("	    		,  	B.POD_CD" ).append("\n"); 
		query.append("	    		,  	B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	   		    ,  	C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	    		,  	C.CNTR_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	       ) XX   " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY OPR_CD, POD_CD" ).append("\n"); 

	}
}