/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAOTurnTimeByTypeSizeDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.04.13 박광석
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
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDAOTurnTimeByTypeSizeDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TurnTimeByTypeSize Detail Tab 조회
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAOTurnTimeByTypeSizeDetailVORSQL(){
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
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmtPair1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmtPair2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAOTurnTimeByTypeSizeDetailVORSQL").append("\n"); 
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
		query.append("#if (${mvmtPairDivision} == '1'	)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	'11111'	pol ," ).append("\n"); 
		query.append("	'11111'	etc," ).append("\n"); 
		query.append("	'11111'	division," ).append("\n"); 
		query.append("	'0' XXX," ).append("\n"); 
		query.append("	0 total," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'01',XXX,0))	AS count01," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'02',XXX,0))	AS count02," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'03',XXX,0))	AS count03," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'04',XXX,0))	AS count04," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'05',XXX,0))	AS count05," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'06',XXX,0))	AS count06," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'07',XXX,0))	AS count07," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'08',XXX,0))	AS count08," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'09',XXX,0))	AS count09," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'10',XXX,0))	AS count10," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'11',XXX,0))	AS count11," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'12',XXX,0))	AS count12," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'13',XXX,0))	AS count13," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'14',XXX,0))	AS count14," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'15',XXX,0))	AS count15," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'16',XXX,0))	AS count16," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'17',XXX,0))	AS count17," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'18',XXX,0))	AS count18," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'19',XXX,0))	AS count19," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'20',XXX,0))	AS count20," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'21',XXX,0))	AS count21," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'22',XXX,0))	AS count22," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'23',XXX,0))	AS count23," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'24',XXX,0))	AS count24," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'25',XXX,0))	AS count25," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'26',XXX,0))	AS count26," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'27',XXX,0))	AS count27," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'28',XXX,0))	AS count28," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'29',XXX,0))	AS count29," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'30',XXX,0))	AS count30," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'31',XXX,0))	AS count31," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'32',XXX,0))	AS count32," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'33',XXX,0))	AS count33," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'34',XXX,0))	AS count34," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'35',XXX,0))	AS count35," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'36',XXX,0))	AS count36," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'37',XXX,0))	AS count37," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'38',XXX,0))	AS count38," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'39',XXX,0))	AS count39," ).append("\n"); 
		query.append("	SUM(DECODE(DSP_SEQ,'40',XXX,0))	AS count40" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	DP_SEQ DSP_SEQ," ).append("\n"); 
		query.append("		DECODE(	@[tpsz]	, 'A' ,	1 , DECODE( CNTR_TPSZ_DIV_CD , @[tpsz] , 1 , 0 ) ) XXX" ).append("\n"); 
		query.append("FROM	CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY  DP_SEQ" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	NVL(LOC_CD,'') pol ," ).append("\n"); 
		query.append("	DECODE(" ).append("\n"); 
		query.append("		TYPE_CD," ).append("\n"); 
		query.append("		'FD' , 'IC-ID'," ).append("\n"); 
		query.append("		'MG' , 'ID-MT'," ).append("\n"); 
		query.append("		'MP' , 'MT-OP'," ).append("\n"); 
		query.append("		'MR' , 'MT-VL'," ).append("\n"); 
		query.append("		'FH' , 'MT-XX'," ).append("\n"); 
		query.append("		'OF' , 'OP-VL'," ).append("\n"); 
		query.append("		'IF' , 'VD-MT'," ).append("\n"); 
		query.append("		'TL' , 'VD-TS-VL','X') etc," ).append("\n"); 
		query.append("	DECODE(MAX(Y.NO),'1','CNTR','2','Days','3','T/Time' ,1 ) AS division,MAX(Y.NO) XXX," ).append("\n"); 
		query.append("	DECODE(MAX(Y.NO),'1',SUM(X.T_CNT),'2',SUM(X.T_TIME),'3',ROUND(SUM(X.T_TIME) / SUM(X.T_CNT) ,1 )) AS total," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '01',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'01',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '01',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '01',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'01',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '01',T_CNT,0))),1))) AS count01," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '02',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'02',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '02',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '02',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'02',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '02',T_CNT,0))),1))) AS count02," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '03',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'03',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '03',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '03',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'03',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '03',T_CNT,0))),1))) AS count03," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '04',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'04',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '04',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '04',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'04',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '04',T_CNT,0))),1))) AS count04," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '05',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'05',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '05',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '05',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'05',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '05',T_CNT,0))),1))) AS count05," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '06',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'06',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '06',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '06',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'06',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '06',T_CNT,0))),1))) AS count06," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '07',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'07',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '07',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '07',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'07',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '07',T_CNT,0))),1))) AS count07," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '08',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'08',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '08',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '08',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'08',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '08',T_CNT,0))),1))) AS count08," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '09',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'09',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '09',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '09',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'09',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '09',T_CNT,0))),1))) AS count09," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '10',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'10',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '10',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '10',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'10',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '10',T_CNT,0))),1))) AS count10," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '11',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'11',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '11',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '11',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'11',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '11',T_CNT,0))),1))) AS count11," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '12',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'12',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '12',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '12',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'12',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '12',T_CNT,0))),1))) AS count12," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '13',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'13',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '13',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '13',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'13',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '13',T_CNT,0))),1))) AS count13," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '14',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'14',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '14',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '14',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'14',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '14',T_CNT,0))),1))) AS count14," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '15',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'15',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '15',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '15',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'15',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '15',T_CNT,0))),1))) AS count15," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '16',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'16',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '16',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '16',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'16',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '16',T_CNT,0))),1))) AS count16," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '17',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'17',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '17',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '17',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'17',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '17',T_CNT,0))),1))) AS count17," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '18',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'18',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '18',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '18',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'18',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '18',T_CNT,0))),1))) AS count18," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '19',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'19',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '19',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '19',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'19',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '19',T_CNT,0))),1))) AS count19," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '20',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'20',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '20',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '20',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'20',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '20',T_CNT,0))),1))) AS count20," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '21',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'21',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '21',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '21',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'21',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '21',T_CNT,0))),1))) AS count21," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '22',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'22',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '22',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '22',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'22',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '22',T_CNT,0))),1))) AS count22," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '23',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'23',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '23',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '23',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'23',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '23',T_CNT,0))),1))) AS count23," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '24',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'24',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '24',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '24',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'24',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '24',T_CNT,0))),1))) AS count24," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '25',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'25',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '25',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '25',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'25',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '25',T_CNT,0))),1))) AS count25," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '26',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'26',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '26',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '26',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'26',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '26',T_CNT,0))),1))) AS count26," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '27',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'27',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '27',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '27',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'27',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '27',T_CNT,0))),1))) AS count27," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '28',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'28',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '28',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '28',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'28',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '28',T_CNT,0))),1))) AS count28," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '29',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'29',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '29',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '29',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'29',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '29',T_CNT,0))),1))) AS count29," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '30',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'30',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '30',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '30',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'30',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '30',T_CNT,0))),1))) AS count30," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '31',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'31',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '31',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '31',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'31',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '31',T_CNT,0))),1))) AS count31," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '32',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'32',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '32',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '32',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'32',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '32',T_CNT,0))),1))) AS count32," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '33',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'33',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '33',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '33',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'33',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '33',T_CNT,0))),1))) AS count33," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '34',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'34',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '34',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '34',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'34',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '34',T_CNT,0))),1))) AS count34," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '35',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'35',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '35',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '35',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'35',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '35',T_CNT,0))),1))) AS count35," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '36',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'36',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '36',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '36',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'36',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '36',T_CNT,0))),1))) AS count36," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '37',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'37',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '37',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '37',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'37',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '37',T_CNT,0))),1))) AS count37," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '38',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'38',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '38',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '38',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'38',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '38',T_CNT,0))),1))) AS count38," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '39',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'39',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '39',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '39',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'39',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '39',T_CNT,0))),1))) AS count39," ).append("\n"); 
		query.append("	DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '40',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'40',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '40',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '40',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'40',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '40',T_CNT,0))),1))) AS count40" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("            SELECT	" ).append("\n"); 
		query.append("			#if (${inquiryLevel} == 'AR' ) " ).append("\n"); 
		query.append("			--TG.RCC_CD LOC_CD," ).append("\n"); 
		query.append("			D.TO_RCC_CD LOC_CD, " ).append("\n"); 
		query.append("			#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("			--TG.LCC_CD LOC_CD, " ).append("\n"); 
		query.append("			D.TO_LCC_CD LOC_CD, " ).append("\n"); 
		query.append("			#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("			--TG.ECC_CD LOC_CD, " ).append("\n"); 
		query.append("			D.TO_ECC_CD LOC_CD, " ).append("\n"); 
		query.append("			#elseif (${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES' || ${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("			--TG.SCC_CD LOC_CD, " ).append("\n"); 
		query.append("			D.TO_SCC_CD LOC_CD, " ).append("\n"); 
		query.append("			#elseif (${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC') " ).append("\n"); 
		query.append("			--SUBSTR(TG.SCC_CD,1,2) LOC_CD, " ).append("\n"); 
		query.append("			SUBSTR(D.TO_SCC_CD,1,2) LOC_CD, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			D.TT_SHP_TP_CD				TYPE_CD," ).append("\n"); 
		query.append("			S.DP_SEQ					DSP_SEQ," ).append("\n"); 
		query.append("			SUM  (D.TT_DYS)				T_TIME," ).append("\n"); 
		query.append("			COUNT(DISTINCT M.CNTR_NO)	T_CNT" ).append("\n"); 
		query.append("	    FROM	CIM_SHP_TURN_TM			M," ).append("\n"); 
		query.append("				CIM_SHP_TURN_TM_DTL		D," ).append("\n"); 
		query.append("            		--MDM_LOCATION			FL,		/* From Loc Location */" ).append("\n"); 
		query.append("            		--MDM_EQ_ORZ_CHT		FG,		/* From Loc Orgnization */" ).append("\n"); 
		query.append("            		--MDM_LOCATION			TL,		/* To Loc Location */" ).append("\n"); 
		query.append("            		--MDM_EQ_ORZ_CHT		TG,		/* To Loc Organization */" ).append("\n"); 
		query.append("				CIM_TP_SZ_DP_SEQ		S" ).append("\n"); 
		query.append("		#if (${period} == 'M')" ).append("\n"); 
		query.append("		WHERE	D.TGT_MVMT_DT	BETWEEN	   @[from]	AND @[to]" ).append("\n"); 
		query.append("		#elseif	(${period} == 'W')" ).append("\n"); 
		query.append("		WHERE	M.TGT_YRWK	BETWEEN	   @[from]	AND @[to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		M.TGT_MVMT_DT		=	D.TGT_MVMT_DT" ).append("\n"); 
		query.append("	    AND		M.CNTR_NO			=	D.CNTR_NO" ).append("\n"); 
		query.append("	    AND		M.IB_PORT_CD		=	D.IB_PORT_CD" ).append("\n"); 
		query.append("	    AND		M.ID_LOC_CD			=	D.ID_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    AND	    M.CNTR_TPSZ_CD		=   S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   -- AND	    D.FM_LOC_CD			=   FL.LOC_CD" ).append("\n"); 
		query.append("	   -- AND	    FL.SCC_CD			=   FG.SCC_CD" ).append("\n"); 
		query.append("	   -- AND	    D.TO_LOC_CD			=   TL.LOC_CD" ).append("\n"); 
		query.append("	   -- AND	    TL.SCC_CD			=   TG.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inquiryLevel} !=	'AR' &&	${inquiryLevel}	!= 'AC')" ).append("\n"); 
		query.append("	#if (${inquiryLevel} ==	'RL' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("		AND	D.TO_RCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LE')" ).append("\n"); 
		query.append("		AND	D.TO_LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("		AND	D.TO_LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("		AND	D.TO_SCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("		AND	D.TO_ECC_CD = @[location]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				#if (${inquiryLevel} == 'AR') " ).append("\n"); 
		query.append("					D.FM_RCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'AC') " ).append("\n"); 
		query.append("					SUBSTR(D.FM_SCC_CD,1,2) " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("					D.FM_LCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("					D.FM_ECC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LS') " ).append("\n"); 
		query.append("					D.FM_SCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("					D.FM_SCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'ES') " ).append("\n"); 
		query.append("					D.FM_SCC_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				=" ).append("\n"); 
		query.append("				#if (${inquiryLevel} == 'AR') " ).append("\n"); 
		query.append("					D.TO_RCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'AC') " ).append("\n"); 
		query.append("					SUBSTR(D.TO_SCC_CD,1,2) " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("					D.TO_LCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("					D.TO_ECC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LS') " ).append("\n"); 
		query.append("					D.TO_SCC_CD  " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("					D.TO_SCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'ES') " ).append("\n"); 
		query.append("					D.TO_SCC_CD " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND		D.TT_SHP_TP_CD		IN	( 'MG','MP','MR','FH','FD','OF','IF','TL' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mvmtPair1} != 'AL')" ).append("\n"); 
		query.append("	AND		D.TT_SHP_TP_CD		=	@[mvmtPair1]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tpsz} !=	'A')" ).append("\n"); 
		query.append("	AND		S.CNTR_TPSZ_DIV_CD  =  @[tpsz]		/* CNTR	TPSZ */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${soc} == 'E')" ).append("\n"); 
		query.append("	AND		M.SOC_FLG			=	'N'					/* soc */" ).append("\n"); 
		query.append("	#elseif	(${soc}	== 'O')" ).append("\n"); 
		query.append("	AND		M.SOC_FLG			=	'Y'					/* soc */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND		D.TT_SHP_TP_SEQ	= (" ).append("\n"); 
		query.append("								SELECT	/*+ INDEX( DD XPKCIM_SHP_TURN_TM_DTL ) */" ).append("\n"); 
		query.append("										DD.TT_SHP_TP_SEQ" ).append("\n"); 
		query.append("								FROM	CIM_SHP_TURN_TM_DTL		DD" ).append("\n"); 
		query.append("								WHERE	DD.TGT_MVMT_DT		=	D.TGT_MVMT_DT" ).append("\n"); 
		query.append("								AND		DD.CNTR_NO			=	D.CNTR_NO" ).append("\n"); 
		query.append("								AND		DD.IB_PORT_CD		=	D.IB_PORT_CD" ).append("\n"); 
		query.append("								AND		DD.ID_LOC_CD		=	D.ID_LOC_CD" ).append("\n"); 
		query.append("								AND		DD.TT_SHP_TP_CD		=	D.TT_SHP_TP_CD" ).append("\n"); 
		query.append("								AND		(" ).append("\n"); 
		query.append("								#if (${inquiryLevel} ==	'AR')" ).append("\n"); 
		query.append("									DD.FM_RCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'AC')" ).append("\n"); 
		query.append("									SUBSTR(DD.FM_SCC_CD,1,2)" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("									DD.FM_LCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("									DD.FM_ECC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								=" ).append("\n"); 
		query.append("								#if (${inquiryLevel} ==	'AR')" ).append("\n"); 
		query.append("									DD.TO_RCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'AC')" ).append("\n"); 
		query.append("									SUBSTR(DD.TO_SCC_CD,1,2)" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("									DD.TO_LCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("									DD.TO_ECC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								AND		ROWNUM				=	1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("			#if (${inquiryLevel} ==	'AR' )" ).append("\n"); 
		query.append("			D.TO_RCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("			D.TO_LCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("			D.TO_ECC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES' || ${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("			D.TO_SCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC')" ).append("\n"); 
		query.append("			SUBSTR(D.TO_SCC_CD,1,2)," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			D.TT_SHP_TP_CD			," ).append("\n"); 
		query.append("			S.DP_SEQ" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' AS NO FROM DUAL UNION SELECT	'2' AS NO FROM DUAL UNION SELECT '3' AS	NO FROM	DUAL" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("	 ROLLUP(LOC_CD)	 ," ).append("\n"); 
		query.append("	 DECODE(" ).append("\n"); 
		query.append("			TYPE_CD," ).append("\n"); 
		query.append("			'FD' , 'IC-ID'," ).append("\n"); 
		query.append("			'MG' , 'ID-MT'," ).append("\n"); 
		query.append("			'MP' , 'MT-OP'," ).append("\n"); 
		query.append("			'MR' , 'MT-VL'," ).append("\n"); 
		query.append("			'FH' , 'MT-XX'," ).append("\n"); 
		query.append("			'OF' , 'OP-VL'," ).append("\n"); 
		query.append("			'IF' , 'VD-MT'," ).append("\n"); 
		query.append("			'TL' , 'VD-TS-VL','X'),DECODE(Y.NO,'1','XX','2','YY')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		pol," ).append("\n"); 
		query.append("		etc ," ).append("\n"); 
		query.append("		XXX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		'11111'	pol ," ).append("\n"); 
		query.append("		'11111'	etc," ).append("\n"); 
		query.append("		'11111'	division," ).append("\n"); 
		query.append("		'0' XXX," ).append("\n"); 
		query.append("		0 total," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'01',XXX,0))	AS count01," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'02',XXX,0))	AS count02," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'03',XXX,0))	AS count03," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'04',XXX,0))	AS count04," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'05',XXX,0))	AS count05," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'06',XXX,0))	AS count06," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'07',XXX,0))	AS count07," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'08',XXX,0))	AS count08," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'09',XXX,0))	AS count09," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'10',XXX,0))	AS count10," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'11',XXX,0))	AS count11," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'12',XXX,0))	AS count12," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'13',XXX,0))	AS count13," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'14',XXX,0))	AS count14," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'15',XXX,0))	AS count15," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'16',XXX,0))	AS count16," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'17',XXX,0))	AS count17," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'18',XXX,0))	AS count18," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'19',XXX,0))	AS count19," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'20',XXX,0))	AS count20," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'21',XXX,0))	AS count21," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'22',XXX,0))	AS count22," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'23',XXX,0))	AS count23," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'24',XXX,0))	AS count24," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'25',XXX,0))	AS count25," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'26',XXX,0))	AS count26," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'27',XXX,0))	AS count27," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'28',XXX,0))	AS count28," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'29',XXX,0))	AS count29," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'30',XXX,0))	AS count30," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'31',XXX,0))	AS count31," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'32',XXX,0))	AS count32," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'33',XXX,0))	AS count33," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'34',XXX,0))	AS count34," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'35',XXX,0))	AS count35," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'36',XXX,0))	AS count36," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'37',XXX,0))	AS count37," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'38',XXX,0))	AS count38," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'39',XXX,0))	AS count39," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'40',XXX,0))	AS count40" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	DP_SEQ DSP_SEQ," ).append("\n"); 
		query.append("					DECODE(	@[tpsz]	, 'A' ,	1 , DECODE( CNTR_TPSZ_DIV_CD , @[tpsz] , 1 , 0 ) ) XXX" ).append("\n"); 
		query.append("			FROM	CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("			ORDER BY" ).append("\n"); 
		query.append("					DP_SEQ" ).append("\n"); 
		query.append("		) Z" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		NVL(LOC_CD,'') pol ," ).append("\n"); 
		query.append("		DECODE	(" ).append("\n"); 
		query.append("				TYPE_CD," ).append("\n"); 
		query.append("				'A' , 'IC-EN'," ).append("\n"); 
		query.append("				'B' , 'EN-IC'," ).append("\n"); 
		query.append("				'C' , 'IC-ID'," ).append("\n"); 
		query.append("				'D' , 'ID-MT'," ).append("\n"); 
		query.append("				'E' , 'MT-EN'," ).append("\n"); 
		query.append("				'F' , 'MT-XX'," ).append("\n"); 
		query.append("				'G' , 'XX-MT'," ).append("\n"); 
		query.append("				'H' , 'MT-OP'," ).append("\n"); 
		query.append("				'I' , 'OP-OC'," ).append("\n"); 
		query.append("				'J' , 'OC-EN'," ).append("\n"); 
		query.append("				'K' , 'EN-OC'," ).append("\n"); 
		query.append("				'L' , 'OC-VL'," ).append("\n"); 
		query.append("				'M' , 'EN-MT'," ).append("\n"); 
		query.append("				'N' , 'MT-VL'," ).append("\n"); 
		query.append("				'O' , 'MT-TN','X' ) etc," ).append("\n"); 
		query.append("		DECODE(MAX(Y.NO),'1','CNTR','2','Days','3','T/Time' ,1 ) AS division,MAX(Y.NO) XXX," ).append("\n"); 
		query.append("		DECODE(MAX(Y.NO),'1',SUM(X.T_CNT),'2',SUM(X.T_TIME),'3',ROUND(SUM(X.T_TIME) / SUM(X.T_CNT) ,1 )) AS total," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '01',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'01',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '01',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '01',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'01',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '01',T_CNT,0))),1))) AS count01," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '02',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'02',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '02',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '02',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'02',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '02',T_CNT,0))),1))) AS count02," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '03',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'03',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '03',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '03',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'03',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '03',T_CNT,0))),1))) AS count03," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '04',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'04',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '04',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '04',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'04',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '04',T_CNT,0))),1))) AS count04," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '05',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'05',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '05',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '05',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'05',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '05',T_CNT,0))),1))) AS count05," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '06',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'06',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '06',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '06',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'06',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '06',T_CNT,0))),1))) AS count06," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '07',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'07',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '07',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '07',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'07',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '07',T_CNT,0))),1))) AS count07," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '08',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'08',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '08',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '08',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'08',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '08',T_CNT,0))),1))) AS count08," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '09',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'09',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '09',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '09',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'09',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '09',T_CNT,0))),1))) AS count09," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '10',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'10',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '10',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '10',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'10',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '10',T_CNT,0))),1))) AS count10," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '11',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'11',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '11',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '11',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'11',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '11',T_CNT,0))),1))) AS count11," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '12',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'12',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '12',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '12',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'12',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '12',T_CNT,0))),1))) AS count12," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '13',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'13',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '13',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '13',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'13',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '13',T_CNT,0))),1))) AS count13," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '14',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'14',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '14',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '14',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'14',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '14',T_CNT,0))),1))) AS count14," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '15',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'15',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '15',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '15',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'15',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '15',T_CNT,0))),1))) AS count15," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '16',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'16',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '16',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '16',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'16',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '16',T_CNT,0))),1))) AS count16," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '17',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'17',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '17',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '17',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'17',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '17',T_CNT,0))),1))) AS count17," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '18',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'18',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '18',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '18',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'18',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '18',T_CNT,0))),1))) AS count18," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '19',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'19',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '19',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '19',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'19',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '19',T_CNT,0))),1))) AS count19," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '20',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'20',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '20',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '20',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'20',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '20',T_CNT,0))),1))) AS count20," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '21',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'21',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '21',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '21',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'21',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '21',T_CNT,0))),1))) AS count21," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '22',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'22',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '22',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '22',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'22',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '22',T_CNT,0))),1))) AS count22," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '23',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'23',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '23',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '23',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'23',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '23',T_CNT,0))),1))) AS count23," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '24',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'24',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '24',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '24',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'24',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '24',T_CNT,0))),1))) AS count24," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '25',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'25',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '25',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '25',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'25',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '25',T_CNT,0))),1))) AS count25," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '26',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'26',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '26',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '26',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'26',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '26',T_CNT,0))),1))) AS count26," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '27',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'27',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '27',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '27',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'27',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '27',T_CNT,0))),1))) AS count27," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '28',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'28',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '28',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '28',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'28',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '28',T_CNT,0))),1))) AS count28," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '29',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'29',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '29',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '29',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'29',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '29',T_CNT,0))),1))) AS count29," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '30',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'30',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '30',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '30',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'30',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '30',T_CNT,0))),1))) AS count30," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '31',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'31',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '31',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '31',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'31',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '31',T_CNT,0))),1))) AS count31," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '32',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'32',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '32',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '32',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'32',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '32',T_CNT,0))),1))) AS count32," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '33',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'33',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '33',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '33',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'33',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '33',T_CNT,0))),1))) AS count33," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '34',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'34',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '34',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '34',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'34',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '34',T_CNT,0))),1))) AS count34," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '35',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'35',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '35',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '35',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'35',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '35',T_CNT,0))),1))) AS count35," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '36',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'36',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '36',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '36',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'36',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '36',T_CNT,0))),1))) AS count36," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '37',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'37',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '37',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '37',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'37',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '37',T_CNT,0))),1))) AS count37," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '38',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'38',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '38',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '38',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'38',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '38',T_CNT,0))),1))) AS count38," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '39',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'39',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '39',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '39',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'39',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '39',T_CNT,0))),1))) AS count39," ).append("\n"); 
		query.append("		DECODE(GROUPING_ID(LOC_CD),0,SUM( DECODE( DSP_SEQ,  '40',DECODE(Y.NO,'1',X.T_CNT,'2',X.T_TIME,'3',ROUND(X.T_TIME / X.T_CNT ,1 )),0)),DECODE(MAX(Y.NO),'1',SUM(DECODE( DSP_SEQ,	'40',X.T_CNT,0)),'2',SUM(DECODE( DSP_SEQ,  '40',T_TIME,0)),'3',ROUND(SUM(DECODE( DSP_SEQ,  '40',T_TIME,0))/DECODE(SUM(DECODE( DSP_SEQ,	'40',T_CNT,0)),0,1,SUM(DECODE( DSP_SEQ,	 '40',T_CNT,0))),1))) AS count40" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT /*+  LEADING ( FG FL M S	) USE_NL ( FG FL M S ) INDEX (M XAK1CIM_MVMT_STS_TURN_TM)	*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${inquiryLevel} ==	'AR' )" ).append("\n"); 
		query.append("				FG.RCC_CD LOC_CD," ).append("\n"); 
		query.append("				#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("				FG.LCC_CD LOC_CD," ).append("\n"); 
		query.append("				#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("				FG.ECC_CD LOC_CD," ).append("\n"); 
		query.append("				#elseif	(${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("				FG.SCC_CD LOC_CD," ).append("\n"); 
		query.append("				#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("				NVL(M.FM_YD_CD,FG.SCC_CD)	LOC_CD," ).append("\n"); 
		query.append("				#elseif	(${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC')" ).append("\n"); 
		query.append("				SUBSTR(FG.SCC_CD,1,2) LOC_CD," ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				M.TT_MVMT_TP_CD				TYPE_CD," ).append("\n"); 
		query.append("				S.DP_SEQ					DSP_SEQ," ).append("\n"); 
		query.append("				SUM  (M.TT_DYS)				T_TIME," ).append("\n"); 
		query.append("				SUM  (M.CNTR_KNT)			T_CNT" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("				CIM_MVMT_STS_TURN_TM_SMRY	M," ).append("\n"); 
		query.append("				MDM_LOCATION				FL,  /*	From Loc Location */" ).append("\n"); 
		query.append("				MDM_EQ_ORZ_CHT				FG,  /*	From Loc Orgnization */" ).append("\n"); 
		query.append("				CIM_TP_SZ_DP_SEQ			S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${period} == 'M')" ).append("\n"); 
		query.append("		WHERE M.TGT_MVMT_DT BETWEEN    @[from] AND @[to]" ).append("\n"); 
		query.append("		#elseif	(${period} == 'W')" ).append("\n"); 
		query.append("		WHERE M.TGT_YRWK BETWEEN    @[from] AND	@[to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND	M.CNTR_TPSZ_CD	=   S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		AND	M.FM_LOC_CD		=   FL.LOC_CD" ).append("\n"); 
		query.append("		AND	FL.SCC_CD		=   FG.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inquiryLevel} !=	'AR' &&	${inquiryLevel}	!= 'AC')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${inquiryLevel} ==	'RL' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("		AND  FG.RCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LE')" ).append("\n"); 
		query.append("		AND  FG.LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("		AND  FG.LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("		AND  FG.SCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("		AND  FG.ECC_CD = @[location]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mvmtPair2} != 'Z')" ).append("\n"); 
		query.append("		AND  M.TT_MVMT_TP_CD  =	@[mvmtPair2]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tpsz} !=	'A')" ).append("\n"); 
		query.append("		AND  S.CNTR_TPSZ_DIV_CD	 =  @[tpsz]  /*	CNTR TPSZ */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${soc} == 'E')" ).append("\n"); 
		query.append("		AND  M.SOC_FLG	 = 'N'	   /* soc */" ).append("\n"); 
		query.append("	#elseif	(${soc}	== 'O')" ).append("\n"); 
		query.append("		AND  M.SOC_FLG	 = 'Y'	   /* soc */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("			#if (${inquiryLevel} ==	'AR' )" ).append("\n"); 
		query.append("			FG.RCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("			FG.LCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("			FG.ECC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("			FG.SCC_CD," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("			NVL(M.FM_YD_CD,FG.SCC_CD)," ).append("\n"); 
		query.append("			#elseif	(${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC')" ).append("\n"); 
		query.append("			SUBSTR(FG.SCC_CD,1,2)," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			M.TT_MVMT_TP_CD	," ).append("\n"); 
		query.append("			S.DP_SEQ" ).append("\n"); 
		query.append(")X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' AS NO FROM DUAL UNION SELECT	'2' AS NO FROM DUAL UNION SELECT '3' AS	NO FROM	DUAL" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("		ROLLUP(LOC_CD)	," ).append("\n"); 
		query.append("		DECODE	(" ).append("\n"); 
		query.append("				TYPE_CD," ).append("\n"); 
		query.append("				'A' , 'IC-EN'," ).append("\n"); 
		query.append("				'B' , 'EN-IC'," ).append("\n"); 
		query.append("				'C' , 'IC-ID'," ).append("\n"); 
		query.append("				'D' , 'ID-MT'," ).append("\n"); 
		query.append("				'E' , 'MT-EN'," ).append("\n"); 
		query.append("				'F' , 'MT-XX'," ).append("\n"); 
		query.append("				'G' , 'XX-MT'," ).append("\n"); 
		query.append("				'H' , 'MT-OP'," ).append("\n"); 
		query.append("				'I' , 'OP-OC'," ).append("\n"); 
		query.append("				'J' , 'OC-EN'," ).append("\n"); 
		query.append("				'K' , 'EN-OC'," ).append("\n"); 
		query.append("				'L' , 'OC-VL'," ).append("\n"); 
		query.append("				'M' , 'EN-MT'," ).append("\n"); 
		query.append("				'N' , 'MT-VL'," ).append("\n"); 
		query.append("				'O' , 'MT-TN',	'X') ,DECODE(Y.NO,'1','XX','2','YY')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		pol," ).append("\n"); 
		query.append("		etc," ).append("\n"); 
		query.append("		XXX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}