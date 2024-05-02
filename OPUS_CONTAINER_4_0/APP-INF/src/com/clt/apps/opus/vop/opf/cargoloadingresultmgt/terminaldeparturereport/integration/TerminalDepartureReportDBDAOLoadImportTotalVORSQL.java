/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOLoadImportTotalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOLoadImportTotalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOLoadImportTotalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOLoadImportTotalVORSQL").append("\n"); 
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
		query.append("SELECT 		COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() AS OPR_CD" ).append("\n"); 
		query.append("		,	V.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, NULL), NULL)) FULL_BO_20" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, NULL), NULL)) FULL_BO_2H" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, NULL), NULL)) FULL_BO_40" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, NULL), NULL)) FULL_BO_4H" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, NULL), NULL)) FULL_BO_45" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, NULL))) ET_BO_20" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, NULL))) ET_BO_2H" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, NULL))) ET_BO_40" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, NULL))) ET_BO_4H" ).append("\n"); 
		query.append("		--,	SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, NULL))) ET_BO_45" ).append("\n"); 
		query.append("		--,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', C.CNTR_WGT, NULL)) / 1000,  1)   WT_20" ).append("\n"); 
		query.append("		--,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '3', C.CNTR_WGT, NULL)) / 1000,  1)   WT_2H" ).append("\n"); 
		query.append("		--,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '4', C.CNTR_WGT, NULL)) / 1000,  1)   WT_40" ).append("\n"); 
		query.append("		--,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '5', C.CNTR_WGT, NULL)) / 1000,  1)   WT_4H" ).append("\n"); 
		query.append("		--,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '7', C.CNTR_WGT, NULL)) / 1000,  1)   WT_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, NULL), NULL))" ).append("\n"); 
		query.append("			  	+  SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'A', 1, NULL), NULL))),2) 	FULL_BO_20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, NULL), NULL)),2) 		FULL_BO_2H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, NULL), NULL))" ).append("\n"); 
		query.append("			  	+  SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'B', 1, NULL), NULL))),2) 	FULL_BO_40" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, NULL), NULL)),2) 		FULL_BO_4H" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, NULL), NULL)),2) 		FULL_BO_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 2, 1, NULL)))" ).append("\n"); 
		query.append("			  	+  SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'A', 1, NULL)))),2) 	ET_BO_20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 3, 1, NULL))),2) 		ET_BO_2H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 4, 1, NULL)))" ).append("\n"); 
		query.append("			  	+  SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'B', 1, NULL)))),2) 	ET_BO_40" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 5, 1, NULL))),2) 		ET_BO_4H" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(B.BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 7, 1, NULL))),2) 		ET_BO_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', C.CNTR_WGT, NULL))" ).append("\n"); 
		query.append("				+  SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'A', C.CNTR_WGT, NULL))) / 1000,  2)   					WT_20" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '3', C.CNTR_WGT, NULL)) / 1000,  2)   					WT_2H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND((SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '4', C.CNTR_WGT, NULL))" ).append("\n"); 
		query.append("				+  SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), 'B', C.CNTR_WGT, NULL))) / 1000,  2)   					WT_40" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '5', C.CNTR_WGT, NULL)) / 1000,  2)   					WT_4H" ).append("\n"); 
		query.append("		,	ROUND(SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '7', C.CNTR_WGT, NULL)) / 1000,  2)   					WT_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   		VSK_VSL_PORT_SKD 				S" ).append("\n"); 
		query.append("		,	BKG_VVD 						V" ).append("\n"); 
		query.append("		,	BKG_CONTAINER 					C" ).append("\n"); 
		query.append("		,	BKG_BOOKING						B" ).append("\n"); 
		query.append("		,	MDM_LOCATION					L" ).append("\n"); 
		query.append("		,	MDM_LOCATION 					D" ).append("\n"); 
		query.append("		,	MDM_CNTR_SZ						SZ" ).append("\n"); 
		query.append("WHERE  		1 = 1" ).append("\n"); 
		query.append("AND			S.VSL_CD       					= @[vsl_cd] " ).append("\n"); 
		query.append("AND    		S.SKD_VOY_NO   					= @[voy_no] " ).append("\n"); 
		query.append("AND    		S.SKD_DIR_CD   					= @[dir_cd] " ).append("\n"); 
		query.append("AND    		S.YD_CD        					= @[yd_cd]" ).append("\n"); 
		query.append("AND    		S.CLPT_IND_SEQ 					= @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    		S.VSL_CD       					= V.VSL_CD" ).append("\n"); 
		query.append("AND    		S.SKD_VOY_NO   					= V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    		S.SKD_DIR_CD   					= V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    		S.VPS_PORT_CD  					= V.POL_CD" ).append("\n"); 
		query.append("AND    		S.CLPT_IND_SEQ 					= NVL(V.POL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("AND    		V.BKG_NO     					= C.BKG_NO" ).append("\n"); 
		query.append("AND    		V.BKG_NO     					= B.BKG_NO" ).append("\n"); 
		query.append("AND    		NVL(B.BKG_STS_CD,'N') 			NOT IN ('X','A')" ).append("\n"); 
		query.append("AND    		V.POL_CD     					= L.LOC_CD" ).append("\n"); 
		query.append("AND    		V.POD_CD     					= D.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			SUBSTR(C.CNTR_TPSZ_CD,2,1)		= SZ.CNTR_SZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status1} == 'LM') " ).append("\n"); 
		query.append("AND    		L.CONTI_CD   					<> D.CONTI_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND    		L.CONTI_CD   					= D.CONTI_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY 	V.POD_CD" ).append("\n"); 

	}
}