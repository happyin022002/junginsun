/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.02.01 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REPOResultInGeneralVO
	  * </pre>
	  */
	public MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd03",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd04",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port02",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration").append("\n"); 
		query.append("FileName : MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralRSQL").append("\n"); 
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
		query.append("	'11111' loccode01," ).append("\n"); 
		query.append("	'11111' loccode02," ).append("\n"); 
		query.append("	0 counttotal," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'01',XXX,0)) AS count01, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'02',XXX,0)) AS count02, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'03',XXX,0)) AS count03, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'04',XXX,0)) AS count04, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'05',XXX,0)) AS count05, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'06',XXX,0)) AS count06, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'07',XXX,0)) AS count07, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'08',XXX,0)) AS count08, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'09',XXX,0)) AS count09, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'10',XXX,0)) AS count10, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'11',XXX,0)) AS count11, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'12',XXX,0)) AS count12, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'13',XXX,0)) AS count13, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'14',XXX,0)) AS count14, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'15',XXX,0)) AS count15, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'16',XXX,0)) AS count16, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'17',XXX,0)) AS count17, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'18',XXX,0)) AS count18, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'19',XXX,0)) AS count19, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'20',XXX,0)) AS count20, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'21',XXX,0)) AS count21, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'22',XXX,0)) AS count22, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'23',XXX,0)) AS count23, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'24',XXX,0)) AS count24, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'25',XXX,0)) AS count25, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'26',XXX,0)) AS count26, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'27',XXX,0)) AS count27, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'28',XXX,0)) AS count28, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'29',XXX,0)) AS count29, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'30',XXX,0)) AS count30, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'31',XXX,0)) AS count31, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'32',XXX,0)) AS count32, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'33',XXX,0)) AS count33, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'34',XXX,0)) AS count34, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'35',XXX,0)) AS count35, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'36',XXX,0)) AS count36, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'37',XXX,0)) AS count37, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'38',XXX,0)) AS count38, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'39',XXX,0)) AS count39, " ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'40',XXX,0)) AS count40  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT  DP_SEQ DSP_SEQ, " ).append("\n"); 
		query.append("		DECODE( @[tpsz] , 'A' , 1 , DECODE( CNTR_TPSZ_DIV_CD , @[tpsz] , 1 , 0 ) ) XXX " ).append("\n"); 
		query.append("FROM    CIM_TP_SZ_DP_SEQ " ).append("\n"); 
		query.append("ORDER BY  DP_SEQ " ).append("\n"); 
		query.append(") Z " ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT	L.LOC_1 loccode01," ).append("\n"); 
		query.append("		L.LOC_2 loccode02," ).append("\n"); 
		query.append("		SUM(CNT) counttotal," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  1, CNT ,0) )   AS count01," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  2, CNT ,0) )   AS count02," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  3, CNT ,0) )   AS count03," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  4, CNT ,0) )   AS count04," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  5, CNT ,0) )   AS count05," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  6, CNT ,0) )   AS count06," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  7, CNT ,0) )   AS count07," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  8, CNT ,0) )   AS count08," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ,  9, CNT ,0) )   AS count09," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 10, CNT ,0) )   AS count10," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 11, CNT ,0) )   AS count11," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 12, CNT ,0) )   AS count12," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 13, CNT ,0) )   AS count13," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 14, CNT ,0) )   AS count14," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 15, CNT ,0) )   AS count15," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 16, CNT ,0) )   AS count16," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 17, CNT ,0) )   AS count17," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 18, CNT ,0) )   AS count18," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 18, CNT ,0) )   AS count19," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 20, CNT ,0) )   AS count20," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 21, CNT ,0) )   AS count21," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 22, CNT ,0) )   AS count22," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 23, CNT ,0) )   AS count23," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 24, CNT ,0) )   AS count24," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 25, CNT ,0) )   AS count25," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 26, CNT ,0) )   AS count26," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 27, CNT ,0) )   AS count27," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 28, CNT ,0) )   AS count28," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 29, CNT ,0) )   AS count29," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 30, CNT ,0) )   AS count30," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 31, CNT ,0) )   AS count31," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 32, CNT ,0) )   AS count32," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 33, CNT ,0) )   AS count33," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 34, CNT ,0) )   AS count34," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 35, CNT ,0) )   AS count35," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 36, CNT ,0) )   AS count36," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 37, CNT ,0) )   AS count37," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 38, CNT ,0) )   AS count38," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 39, CNT ,0) )   AS count39," ).append("\n"); 
		query.append("		SUM( DECODE( L.DSP_SEQ, 30, CNT ,0) )   AS count40" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	/*+ ORDERED USE_NL( T S ) */" ).append("\n"); 
		query.append("					#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("					VL_LOC_CD			LOC_1," ).append("\n"); 
		query.append("					VD_LOC_CD			LOC_2," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					VD_LOC_CD			LOC_1," ).append("\n"); 
		query.append("					VL_LOC_CD			LOC_2," ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					S.DP_SEQ			DSP_SEQ," ).append("\n"); 
		query.append("					SUM(T.REPO_QTY)		CNT" ).append("\n"); 
		query.append("			FROM	" ).append("\n"); 
		query.append("					CIM_PORT_REPO_SMRY	T," ).append("\n"); 
		query.append("					CIM_TP_SZ_DP_SEQ	S" ).append("\n"); 
		query.append("			#if (${option} == 'P') " ).append("\n"); 
		query.append("	    		#if (${period} == 'M') " ).append("\n"); 
		query.append("        		WHERE	T.TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append(" 	   	 		#elseif (${period} == 'W') " ).append("\n"); 
		query.append("        		WHERE	T.TGT_YRWK	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("  			#end" ).append("\n"); 
		query.append("			#if (${lane} != '') " ).append("\n"); 
		query.append("			AND		T.SLAN_CD		=	@[lane]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${option} == 'V') " ).append("\n"); 
		query.append("			WHERE	((  " ).append("\n"); 
		query.append("							T.VSL_CD		=	SUBSTR(@[vvd01],1,4)" ).append("\n"); 
		query.append("					AND		T.SKD_VOY_NO	=	SUBSTR(@[vvd01],5,4)" ).append("\n"); 
		query.append("					AND		T.SKD_DIR_CD	=	SUBSTR(@[vvd01],9,1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					#if (${vvd02} != '')" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					(  " ).append("\n"); 
		query.append("							T.VSL_CD		=	SUBSTR(@[vvd02],1,4)" ).append("\n"); 
		query.append("					AND		T.SKD_VOY_NO	=	SUBSTR(@[vvd02],5,4)" ).append("\n"); 
		query.append("					AND		T.SKD_DIR_CD	=	SUBSTR(@[vvd02],9,1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if (${vvd03} != '')" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					(  " ).append("\n"); 
		query.append("							T.VSL_CD		=	SUBSTR(@[vvd03],1,4)" ).append("\n"); 
		query.append("					AND		T.SKD_VOY_NO	=	SUBSTR(@[vvd03],5,4)" ).append("\n"); 
		query.append("					AND		T.SKD_DIR_CD	=	SUBSTR(@[vvd03],9,1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if (${vvd04} != '')" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					(  " ).append("\n"); 
		query.append("							T.VSL_CD		=	SUBSTR(@[vvd04],1,4)" ).append("\n"); 
		query.append("					AND		T.SKD_VOY_NO	=	SUBSTR(@[vvd04],5,4)" ).append("\n"); 
		query.append("					AND		T.SKD_DIR_CD	=	SUBSTR(@[vvd04],9,1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND     T.CNTR_TPSZ_CD  	=   S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			AND 	S.CNTR_TPSZ_DIV_CD 	= 	DECODE(@[tpsz],'A', S.CNTR_TPSZ_DIV_CD, @[tpsz] )" ).append("\n"); 
		query.append("			#if (${tpsz} == 'R' && ${rdtype} == 'E') /* rdType */" ).append("\n"); 
		query.append("			AND		T.RD_FLG		=	'N'" ).append("\n"); 
		query.append("			#elseif (${tpsz} == 'R' && ${rdtype} == 'O') " ).append("\n"); 
		query.append("			AND		T.RD_FLG		=	'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND		T.VL_LOC_CD	    <>   T.VD_LOC_CD" ).append("\n"); 
		query.append("			#if (${inquirywise} == 'R')" ).append("\n"); 
		query.append("				#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("				AND		VL_RCC_CD		=	@[rcc01]" ).append("\n"); 
		query.append("				#if (${rcc02} != '') " ).append("\n"); 
		query.append("				AND		VD_RCC_CD		=	@[rcc02]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#elseif (${directionwise} == 'T') 	" ).append("\n"); 
		query.append("				AND		VD_RCC_CD		=	@[rcc01]" ).append("\n"); 
		query.append("				#if (${rcc02} != '')" ).append("\n"); 
		query.append("				AND		VL_RCC_CD		=	@[rcc02]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("			#elseif (${inquirywise} == 'P')" ).append("\n"); 
		query.append("				#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("				AND		VL_LOC_CD		=	@[port01]" ).append("\n"); 
		query.append("				#if (${port02} != '')" ).append("\n"); 
		query.append("				AND		VD_LOC_CD		=	@[port02]	" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#elseif (${directionwise} == 'T') 	" ).append("\n"); 
		query.append("				AND		VD_LOC_CD		=	@[port01]" ).append("\n"); 
		query.append("				#if (${port02} != '')" ).append("\n"); 
		query.append("				AND		VL_LOC_CD		=	@[port02]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${cargotype} == 'F')" ).append("\n"); 
		query.append("			AND		T.FULL_MTY_CD		=	'F'  /* cargoType */" ).append("\n"); 
		query.append("			#elseif(${cargotype} == 'M')" ).append("\n"); 
		query.append("			AND		T.FULL_MTY_CD		=	'M'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			-- AND		T.CO_CD				=	'H'	*/ /* company */" ).append("\n"); 
		query.append("			#if (${soc} == 'E') " ).append("\n"); 
		query.append("			AND		T.SOC_FLG		=	'N' " ).append("\n"); 
		query.append("			#elseif (${soc} == 'O') " ).append("\n"); 
		query.append("			AND		T.SOC_FLG		=	'Y' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if (${tscntr} == 'O') " ).append("\n"); 
		query.append("				#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("				AND		VL_TS_DIV_CD	IN ( 'S','O' )" ).append("\n"); 
		query.append("				#elseif (${directionwise} == 'T') " ).append("\n"); 
		query.append("				AND		VD_TS_DIV_CD	IN ( 'S','O' )" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${tscntr} == 'T') " ).append("\n"); 
		query.append("				#if (${through} == 'I')" ).append("\n"); 
		query.append("					#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("					AND		VL_TS_DIV_CD	IN ( 'T','O','N' )" ).append("\n"); 
		query.append("					#elseif (${directionwise} == 'T') " ).append("\n"); 
		query.append("					AND		VD_TS_DIV_CD	IN ( 'T','O','N' )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#elseif (${through} == 'E')" ).append("\n"); 
		query.append("					#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("					AND		VL_TS_DIV_CD	IN ( 'O','N' )" ).append("\n"); 
		query.append("					#elseif (${directionwise} == 'T') " ).append("\n"); 
		query.append("					AND		VD_TS_DIV_CD	IN ( 'O','N' )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#elseif (${through} == 'O')	" ).append("\n"); 
		query.append("					#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("					AND		VL_TS_DIV_CD	IN ( 'T' )" ).append("\n"); 
		query.append("					#elseif (${directionwise} == 'T') " ).append("\n"); 
		query.append("					AND		VD_TS_DIV_CD	IN ( 'T' )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			GROUP BY" ).append("\n"); 
		query.append("					#if (${directionwise} == 'F') " ).append("\n"); 
		query.append("					ROLLUP(VL_LOC_CD			," ).append("\n"); 
		query.append("					VD_LOC_CD)			," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					ROLLUP(VD_LOC_CD			," ).append("\n"); 
		query.append("					VL_LOC_CD)			," ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					S.DP_SEQ				" ).append("\n"); 
		query.append("		)   L" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        LOC_1," ).append("\n"); 
		query.append("		LOC_2" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        loccode01," ).append("\n"); 
		query.append("		loccode02" ).append("\n"); 

	}
}