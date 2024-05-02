/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.25 
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

public class TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL(){
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
		params.put("sc_status2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_status1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL").append("\n"); 
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
		query.append("SELECT	OPR_CD" ).append("\n"); 
		query.append("	,	POD" ).append("\n"); 
		query.append("	,	DECODE(DG_20_QTY,0,NULL,DG_20_QTY)		AS DG_20_QTY " ).append("\n"); 
		query.append("	,	DECODE(DG_40_QTY,0,NULL,DG_40_QTY)		AS DG_40_QTY " ).append("\n"); 
		query.append("	,	DECODE(DG_20_WGT,0,NULL,DG_20_WGT)		AS DG_20_WGT " ).append("\n"); 
		query.append("	,	DECODE(DG_40_WGT,0,NULL,DG_40_WGT)		AS DG_40_WGT           " ).append("\n"); 
		query.append("	,	DECODE(RF_20_QTY,0,NULL,RF_20_QTY)		AS RF_20_QTY " ).append("\n"); 
		query.append("	,	DECODE(RF_40_QTY,0,NULL,RF_40_QTY)		AS RF_40_QTY " ).append("\n"); 
		query.append("	,	DECODE(RF_20_WGT,0,NULL,RF_20_WGT)		AS RF_20_WGT " ).append("\n"); 
		query.append("	,	DECODE(RF_40_WGT,0,NULL,RF_40_WGT)		AS RF_40_WGT " ).append("\n"); 
		query.append("	,	DECODE(AK_20_QTY,0,NULL,AK_20_QTY)		AS AK_20_QTY	" ).append("\n"); 
		query.append("	,	DECODE(AK_40_QTY,0,NULL,AK_40_QTY)		AS AK_40_QTY	" ).append("\n"); 
		query.append("	,	DECODE(AK_20_WGT,0,NULL,AK_20_WGT)		AS AK_20_WGT	" ).append("\n"); 
		query.append("	,	DECODE(AK_40_WGT,0,NULL,AK_40_WGT)		AS AK_40_WGT	" ).append("\n"); 
		query.append("	  	" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		--=================================================================================================================================================" ).append("\n"); 
		query.append("		SELECT	OPR_CD" ).append("\n"); 
		query.append("			,	POD" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'D', DECODE(CNTR_SIZE, '2', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL)) AS DG_20_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'D', DECODE(CNTR_SIZE, '4', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL)) AS DG_40_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'D', DECODE(CNTR_SIZE, '2', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL), NULL)) AS DG_20_WGT," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'D', DECODE(CNTR_SIZE, '4', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL), NULL)) AS DG_40_WGT," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'R', DECODE(CNTR_SIZE, '2', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL)) AS RF_20_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'R', DECODE(CNTR_SIZE, '4', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL)) AS RF_40_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'R', DECODE(CNTR_SIZE, '2', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL), NULL)) AS RF_20_WGT," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(CNTR_TYPE, 'R', DECODE(CNTR_SIZE, '4', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL), NULL)) AS RF_40_WGT," ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'D' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS DG_20_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'D' AND S.CNTR_SIZE NOT IN 	('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS DG_40_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'D' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS DG_20_WGT" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'D' AND S.CNTR_SIZE NOT IN	('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS DG_40_WGT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'R' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS RF_20_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'R' AND S.CNTR_SIZE NOT IN 	('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS RF_40_QTY " ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'R' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS RF_20_WGT" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'R' AND S.CNTR_SIZE NOT IN	('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS RF_40_WGT " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${sc_status2} != 'ST')" ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '2', DECODE(S.QTY, 0, NULL, S.QTY), NULL), NULL), NULL)) AS AK_20_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '4', DECODE(S.QTY, 0, NULL, S.QTY), NULL), NULL), NULL)) AS AK_40_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '2', DECODE(S.WEIGHT, 0, NULL, S.WEIGHT), NULL), NULL), NULL)) AS AK_20_WGT," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status1], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '4', DECODE(S.WEIGHT, 0, NULL, S.WEIGHT), NULL), NULL), NULL)) AS AK_40_WGT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS AK_20_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE NOT IN 	('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS AK_40_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS AK_20_WGT" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE NOT IN	('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS AK_40_WGT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status2], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '2', DECODE(S.QTY, 0, NULL, S.QTY), NULL), NULL), NULL)) AS AK_20_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status2], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '4', DECODE(S.QTY, 0, NULL, S.QTY), NULL), NULL), NULL)) AS AK_40_QTY," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status2], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '2', DECODE(S.WEIGHT, 0, NULL, S.WEIGHT), NULL), NULL), NULL)) AS AK_20_WGT," ).append("\n"); 
		query.append("		       	--SUM(DECODE(STATUS,[sc_status2], DECODE(S.CNTR_TYPE, 'A', DECODE(S.CNTR_SIZE, '4', DECODE(S.WEIGHT, 0, NULL, S.WEIGHT), NULL), NULL), NULL)) AS AK_40_WGT" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS AK_20_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE NOT IN 	('1','2','3') THEN S.QTY 		ELSE 0 END) 	AS AK_40_QTY" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE IN 		('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS AK_20_WGT" ).append("\n"); 
		query.append("			,	SUM(CASE WHEN S.CNTR_TYPE = 'A' AND S.CNTR_SIZE NOT IN	('1','2','3') THEN S.WEIGHT 	ELSE 0 END) 	AS AK_40_WGT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		FROM	VSK_VSL_PORT_SKD 	V" ).append("\n"); 
		query.append("			, 	TDR_HEADER 			H" ).append("\n"); 
		query.append("			, 	TDR_SUMMARY 		S " ).append("\n"); 
		query.append("		WHERE  	V.VSL_CD  			= @[vsl_cd] " ).append("\n"); 
		query.append("		AND    	V.SKD_VOY_NO  		= @[voy_no] " ).append("\n"); 
		query.append("		AND    	V.SKD_DIR_CD  		= @[dir_cd] " ).append("\n"); 
		query.append("		AND    	V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("		AND     V.CLPT_IND_SEQ   	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		--if ({sc_status2} != 'ST')" ).append("\n"); 
		query.append("		--AND     S.STATUS		= [sc_status1] " ).append("\n"); 
		query.append("		--else" ).append("\n"); 
		query.append("		AND     S.STATUS			IN (@[sc_status1], @[sc_status2])" ).append("\n"); 
		query.append("		--end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     S.CNTR_TYPE 		IN ('D', 'R', 'A') " ).append("\n"); 
		query.append("		AND    	V.VSL_CD       		= H.VSL_CD " ).append("\n"); 
		query.append("		AND    	V.SKD_VOY_NO   		= H.VOY_NO " ).append("\n"); 
		query.append("		AND    	V.SKD_DIR_CD   		= H.DIR_CD " ).append("\n"); 
		query.append("		AND    	V.VPS_PORT_CD  		= H.PORT_CD " ).append("\n"); 
		query.append("		AND    	V.CLPT_IND_SEQ 		= H.CALL_IND " ).append("\n"); 
		query.append("		AND    	H.VSL_CD       		= S.VSL_CD " ).append("\n"); 
		query.append("		AND    	H.VOY_NO       		= S.VOY_NO " ).append("\n"); 
		query.append("		AND    	H.DIR_CD       		= S.DIR_CD " ).append("\n"); 
		query.append("		AND    	H.PORT_CD      		= S.PORT_CD " ).append("\n"); 
		query.append("		AND    	H.CALL_IND     		= S.CALL_IND " ).append("\n"); 
		query.append("		GROUP BY OPR_CD, POD" ).append("\n"); 
		query.append("		ORDER BY OPR_CD, POD" ).append("\n"); 
		query.append("		--=================================================================================================================================================" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		" ).append("\n"); 

	}
}