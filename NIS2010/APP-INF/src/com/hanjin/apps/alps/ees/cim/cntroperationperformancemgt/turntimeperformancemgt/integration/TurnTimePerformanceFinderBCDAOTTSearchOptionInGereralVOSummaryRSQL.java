/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.30 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TurnTimePerformanceFinderBCDAOTTSearchOptionInGereralVOSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TurnTimePerformanceFinderBCDAOTTSearchOptionInGereralVOSummaryRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flowpattern",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inquiryLevel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portcom",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdtype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});
	
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tscntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc",new String[]{arrTmp[0],arrTmp[1]});
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
		query.append("'11111' pol, " ).append("\n");
		query.append("'11111' etc, " ).append("\n");
		query.append("'9' XXX, " ).append("\n");
		query.append("0 total, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'01',XXX,0)) AS count01, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'02',XXX,0)) AS count02, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'03',XXX,0)) AS count03, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'04',XXX,0)) AS count04, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'05',XXX,0)) AS count05, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'06',XXX,0)) AS count06, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'07',XXX,0)) AS count07, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'08',XXX,0)) AS count08, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'09',XXX,0)) AS count09, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'10',XXX,0)) AS count10, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'11',XXX,0)) AS count11, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'12',XXX,0)) AS count12, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'13',XXX,0)) AS count13, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'14',XXX,0)) AS count14, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'15',XXX,0)) AS count15, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'16',XXX,0)) AS count16, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'17',XXX,0)) AS count17, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'18',XXX,0)) AS count18, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'19',XXX,0)) AS count19, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'20',XXX,0)) AS count20, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'21',XXX,0)) AS count21, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'22',XXX,0)) AS count22, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'23',XXX,0)) AS count23, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'24',XXX,0)) AS count24, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'25',XXX,0)) AS count25, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'26',XXX,0)) AS count26, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'27',XXX,0)) AS count27, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'28',XXX,0)) AS count28, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'29',XXX,0)) AS count29, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'30',XXX,0)) AS count30, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'31',XXX,0)) AS count31, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'32',XXX,0)) AS count32, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'33',XXX,0)) AS count33, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'34',XXX,0)) AS count34, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'35',XXX,0)) AS count35, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'36',XXX,0)) AS count36, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'37',XXX,0)) AS count37, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'38',XXX,0)) AS count38, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'39',XXX,0)) AS count39, " ).append("\n");
		query.append("SUM(DECODE(DSP_SEQ,'40',XXX,0)) AS count40  " ).append("\n");
		query.append("FROM " ).append("\n");
		query.append("( " ).append("\n");
		query.append("SELECT  DP_SEQ DSP_SEQ, " ).append("\n");
		query.append("DECODE( @[tpsz] , 'A' , 1 , DECODE( CNTR_TPSZ_DIV_CD , @[tpsz] , 1 , 0 ) ) XXX " ).append("\n");
		query.append("FROM    CIM_TP_SZ_DP_SEQ " ).append("\n");
		query.append("ORDER BY  DP_SEQ " ).append("\n");
		query.append(") Z " ).append("\n");
		query.append("UNION ALL " ).append("\n");
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD pol," ).append("\n"); 
		query.append("DECODE(MAX(Y.NO),'1','CNTR','2','Days','3','T/Time' ,1 ) AS etc,MAX(Y.NO) XXX," ).append("\n"); 
		query.append("DECODE(MAX(Y.NO),'1',SUM(X.T_CNT),'2',SUM(X.T_TIME),'3',ROUND(SUM(X.T_TIME) / SUM(X.T_CNT) ,1 )) AS total," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '01',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count01," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '02',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count02," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '03',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count03," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '04',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count04," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '05',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count05," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '06',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count06," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '07',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count07," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '08',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count08," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '09',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count09," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '10',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count10," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '11',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count11," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '12',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count12," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '13',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count13," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '14',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count14," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '15',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count15," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '16',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count16," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '17',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count17," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '18',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count18," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '19',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count19," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '20',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count20," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '21',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count21," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '22',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count22," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '23',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count23," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '24',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count24," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '25',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count25," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '26',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count26," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '27',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count27," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '28',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count28," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '29',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count29," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '30',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count30," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '31',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count31," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '32',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count32," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '33',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count33," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '34',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count34," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '35',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count35," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '36',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count36," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '37',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count37," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '38',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count38," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '39',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count39," ).append("\n"); 
		query.append("SUM( DECODE( DSP_SEQ,  '40',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)) AS count40" ).append("\n"); 
		query.append("FROM    (" ).append("\n");
		
		query.append("#if (${inquiryLevel} == 'A')" ).append("\n"); 
			query.append("SELECT  A.LOC_CD,T_TIME,T_CNT,S.DP_SEQ DSP_SEQ" ).append("\n"); 
			query.append("FROM    (" ).append("\n"); 
			query.append("SELECT	" ).append("\n");
			query.append("T.VL_LOC_CD		LOC_CD," ).append("\n"); 
			query.append("T.CNTR_TPSZ_CD	CNTR_TPSZ_CD," ).append("\n"); 
			query.append("SUM  (T.TT_DYS)		T_TIME," ).append("\n"); 
			query.append("SUM(T.CNTR_KNT)	T_CNT" ).append("\n"); 
			query.append("FROM	CIM_PORT_TURN_TM_SMRY	T" ).append("\n"); 
			query.append("#if (${period} == 'M')" ).append("\n"); 
			query.append("WHERE	T.TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${period} == 'W')" ).append("\n"); 
			query.append("WHERE	T.TGT_YRWK	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${portcom} == 'S')" ).append("\n"); 
			query.append("AND		T.VD_LOC_CD		=	T.VL_LOC_CD" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${portcom} == 'D')" ).append("\n"); 
			query.append("AND		T.VD_LOC_CD		!=	T.VL_LOC_CD" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${flowpattern} != '' && ${flowpattern} != 'A' && ${flowpattern} !='5')" ).append("\n"); 
			query.append("AND     T.TT_CGO_TP_CD	=	@[flowpattern]" ).append("\n"); 
			query.append("#elseif (${flowpattern} != '' && ${flowpattern} == '5')" ).append("\n"); 
			query.append("AND     T.TT_CGO_TP_CD	<>	'4' " ).append("\n"); 
			query.append("#end" ).append("\n"); 
	
			query.append("#if (${rdtype} == 'E')" ).append("\n"); 
			query.append("AND		T.RD_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${rdtype} == 'O')" ).append("\n"); 
			query.append("AND		T.RD_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${tscntr} == 'E')" ).append("\n"); 
			query.append("AND		T.TS_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${tscntr} == 'O')" ).append("\n"); 
			query.append("AND		T.TS_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${soc} == 'E')" ).append("\n"); 
			query.append("AND		T.SOC_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${soc} == 'O')" ).append("\n"); 
			query.append("AND		T.SOC_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("GROUP BY T.VL_LOC_CD," ).append("\n"); 
			query.append("T.CNTR_TPSZ_CD ) A,CIM_TP_SZ_DP_SEQ	S" ).append("\n"); 
			query.append("WHERE	A.CNTR_TPSZ_CD	=	S.CNTR_TPSZ_CD" ).append("\n"); 
			query.append("AND 	S.CNTR_TPSZ_DIV_CD = DECODE(@[tpsz],'A', S.CNTR_TPSZ_DIV_CD, @[tpsz] )" ).append("\n");
			query.append(") X," ).append("\n"); 		
		
		query.append("#else" ).append("\n"); 
			query.append("SELECT	/*+ ORDERED USE_NL ( O L T ) */ " ).append("\n");
			query.append("T.VL_LOC_CD		LOC_CD," ).append("\n"); 
			query.append("S.DP_SEQ		DSP_SEQ," ).append("\n"); 
			query.append("SUM  (T.TT_DYS)		T_TIME," ).append("\n"); 
			query.append("SUM(T.CNTR_KNT)	T_CNT" ).append("\n"); 
			query.append("FROM	MDM_EQ_ORZ_CHT	O," ).append("\n"); 
			query.append("MDM_LOCATION		L," ).append("\n"); 
			query.append("CIM_PORT_TURN_TM_SMRY	T," ).append("\n"); 
			query.append("CIM_TP_SZ_DP_SEQ	S" ).append("\n"); 
			query.append("#if (${period} == 'M')" ).append("\n"); 
			query.append("WHERE	T.TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${period} == 'W')" ).append("\n"); 
			query.append("WHERE	T.TGT_YRWK	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("AND		T.CNTR_TPSZ_CD	=	S.CNTR_TPSZ_CD" ).append("\n"); 
			query.append("AND		T.VL_LOC_CD		=	L.LOC_CD" ).append("\n"); 
			query.append("AND		L.SCC_CD		=	O.SCC_CD" ).append("\n"); 
			query.append("#if (${inquiryLevel} == 'R')" ).append("\n"); 
			query.append("AND		O.RCC_CD		=	@[location]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${inquiryLevel} == 'C')" ).append("\n"); 
			query.append("AND		SUBSTR(O.SCC_CD,0,2) =	@[location]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${inquiryLevel} == 'P')" ).append("\n"); 
			query.append("AND		L.LOC_CD		=	@[location]" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${portcom} == 'S')" ).append("\n"); 
			query.append("AND		T.VD_LOC_CD		=	T.VL_LOC_CD" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${portcom} == 'D')" ).append("\n"); 
			query.append("AND		T.VD_LOC_CD		!=	T.VL_LOC_CD" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${flowpattern} != '' && ${flowpattern} != 'A' && ${flowpattern} !='5')" ).append("\n"); 
			query.append("AND     T.TT_CGO_TP_CD	=	@[flowpattern]" ).append("\n"); 
			query.append("#elseif (${flowpattern} != '' && ${flowpattern} == '5')" ).append("\n"); 
			query.append("AND     T.TT_CGO_TP_CD	<>	'4' " ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("AND S.CNTR_TPSZ_DIV_CD = DECODE(@[tpsz],'A', S.CNTR_TPSZ_DIV_CD, @[tpsz] )" ).append("\n");
	
			query.append("#if (${rdtype} == 'E')" ).append("\n"); 
			query.append("AND		T.RD_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${rdtype} == 'O')" ).append("\n"); 
			query.append("AND		T.RD_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${tscntr} == 'E')" ).append("\n"); 
			query.append("AND		T.TS_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${tscntr} == 'O')" ).append("\n"); 
			query.append("AND		T.TS_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${soc} == 'E')" ).append("\n"); 
			query.append("AND		T.SOC_FLG		=	'N'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("#if (${soc} == 'O')" ).append("\n"); 
			query.append("AND		T.SOC_FLG		=	'Y'" ).append("\n"); 
			query.append("#end" ).append("\n"); 
			query.append("GROUP BY T.VL_LOC_CD," ).append("\n"); 
			query.append("S.DP_SEQ" ).append("\n"); 
			query.append(") X," ).append("\n"); 
		
		query.append("#end" ).append("\n"); 
		
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' AS NO FROM DUAL UNION SELECT '2' AS NO FROM DUAL UNION SELECT '3' AS NO FROM DUAL" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY ROLLUP(LOC_CD),DECODE(Y.NO,'1','XX','2','YY')" ).append("\n"); 
		query.append("ORDER BY pol,XXX" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceFinderBCDAOTTSearchOptionInGereralVOSummaryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}