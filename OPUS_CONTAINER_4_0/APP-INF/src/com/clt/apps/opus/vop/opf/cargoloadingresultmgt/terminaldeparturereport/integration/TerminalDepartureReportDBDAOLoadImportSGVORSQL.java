/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOLoadImportSGVORSQL.java
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

public class TerminalDepartureReportDBDAOLoadImportSGVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOLoadImportSGVORSQL(){
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
		query.append("FileName : TerminalDepartureReportDBDAOLoadImportSGVORSQL").append("\n"); 
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
		query.append("	,		V.POD_CD AS POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0))             DG_20_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0))    DG_20_WGT" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))             DG_40_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0))    DG_40_WGT" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0))               RF_20_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0))      RF_20_WGT" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))               RF_40_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0))      RF_40_WGT" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0))          AK_20_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0)) AK_20_WGT" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))          AK_40_QTY" ).append("\n"); 
		query.append("	--,		SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0)) AK_40_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',1,0),0))           	,2)	DG_20_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',C.CNTR_WGT,0),0))  	,2)	DG_20_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))             " ).append("\n"); 
		query.append("				+ SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',1,0),0))			 	,2)	DG_40_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.DCGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',C.CNTR_WGT,0),0))  	,2)	DG_40_WGT	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',1,0),0))             	,2)	RF_20_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',C.CNTR_WGT,0),0))      	,2)	RF_20_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',1,0),0))               	,2)	RF_40_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.RC_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',C.CNTR_WGT,0),0))      	,2)	RF_40_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,1,0),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',1,0),0))          	,2)	AK_20_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,C.CNTR_WGT,0),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'A',C.CNTR_WGT,0),0)) 	,2)	AK_20_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,1),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',1,0),0))          	,2)	AK_40_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,		ROUND(SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),2,0,C.CNTR_WGT),0))" ).append("\n"); 
		query.append("				+ SUM(DECODE(C.AWK_CGO_FLG,'Y',DECODE(SUBSTR(C.CNTR_TPSZ_CD,2,1),'B',C.CNTR_WGT,0),0)) 	,2)	AK_40_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM		VSK_VSL_PORT_SKD 		S" ).append("\n"); 
		query.append("	,		BKG_VVD 				V" ).append("\n"); 
		query.append("	,		BKG_CONTAINER 			C" ).append("\n"); 
		query.append("	,		BKG_BOOKING 			B" ).append("\n"); 
		query.append("WHERE  		S.VSL_CD       			= @[vsl_cd]" ).append("\n"); 
		query.append("AND    		S.SKD_VOY_NO   			= @[voy_no]" ).append("\n"); 
		query.append("AND    		S.SKD_DIR_CD   			= @[dir_cd]" ).append("\n"); 
		query.append("AND    		S.YD_CD        			= @[yd_cd]" ).append("\n"); 
		query.append("AND    		S.CLPT_IND_SEQ 			= @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    		S.VSL_CD       			= V.VSL_CD" ).append("\n"); 
		query.append("AND    		S.SKD_VOY_NO   			= V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    		S.SKD_DIR_CD   			= V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    		S.VPS_PORT_CD  			= V.POL_CD" ).append("\n"); 
		query.append("AND    		S.CLPT_IND_SEQ 			= NVL(V.POL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("AND    		V.BKG_NO     			= C.BKG_NO" ).append("\n"); 
		query.append("AND    		V.BKG_NO     			= B.BKG_NO" ).append("\n"); 
		query.append("AND    		NVL(B.BKG_STS_CD,'N') 	NOT IN ('X','A')" ).append("\n"); 
		query.append("AND    		DECODE(C.DCGO_FLG,'Y','Y',DECODE(C.RC_FLG,'Y','Y',DECODE(C.AWK_CGO_FLG,'Y','Y','N'))) = 'Y'" ).append("\n"); 
		query.append("GROUP BY 	V.POD_CD" ).append("\n"); 
		query.append("ORDER BY 	V.POD_CD" ).append("\n"); 

	}
}