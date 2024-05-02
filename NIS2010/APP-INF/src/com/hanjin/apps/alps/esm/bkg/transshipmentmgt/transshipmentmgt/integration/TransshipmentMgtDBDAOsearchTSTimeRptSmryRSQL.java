/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSTimeRptSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSTimeRptSmryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransshipmentMgtDBDAOsearchTSTimeRptSmryRSQL
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSTimeRptSmryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSTimeRptSmryRSQL").append("\n"); 
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
		query.append("SELECT DECODE(TRADE, 'ZZZZZZZZZZ',' ',NVL(TRADE,' ')) AS TRADE," ).append("\n"); 
		query.append("       DECODE(TRADE, 'ZZZZZZZZZZ',' ',NVL(SUB_TRADE,' ')) AS SUB_TRADE," ).append("\n"); 
		query.append("       DECODE(LANE, 'ZZZZZZZZZZ',' ',NVL(LANE,' ')) AS LANE," ).append("\n"); 
		query.append("       DECODE(TRADE, 'ZZZZZZZZZZ','Total',VVD) AS VVD," ).append("\n"); 
		query.append("       DECODE( YY.NO,  '1','CNTR','2','Days','3','T/Time') AS DIVISION,    " ).append("\n"); 
		query.append("       DECODE(YY.NO,'1',CNTR_TOTAL  ,'2',DAYS_TOTAL,'3',DECODE(CNTR_TOTAL,0,0,ROUND(DAYS_TOTAL / CNTR_TOTAL ,1 ))) AS TOTAL," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT01,'2',DAYS_COUNT01,'3',DECODE(CNTR_COUNT01,0,0,ROUND(DAYS_COUNT01/ CNTR_COUNT01,1 ))) AS COUNT01," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT02,'2',DAYS_COUNT02,'3',DECODE(CNTR_COUNT02,0,0,ROUND(DAYS_COUNT02/ CNTR_COUNT02,1 ))) AS COUNT02," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT03,'2',DAYS_COUNT03,'3',DECODE(CNTR_COUNT03,0,0,ROUND(DAYS_COUNT03/ CNTR_COUNT03,1 ))) AS COUNT03," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT04,'2',DAYS_COUNT04,'3',DECODE(CNTR_COUNT04,0,0,ROUND(DAYS_COUNT04/ CNTR_COUNT04,1 ))) AS COUNT04," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT05,'2',DAYS_COUNT05,'3',DECODE(CNTR_COUNT05,0,0,ROUND(DAYS_COUNT05/ CNTR_COUNT05,1 ))) AS COUNT05," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT06,'2',DAYS_COUNT06,'3',DECODE(CNTR_COUNT06,0,0,ROUND(DAYS_COUNT06/ CNTR_COUNT06,1 ))) AS COUNT06," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT07,'2',DAYS_COUNT07,'3',DECODE(CNTR_COUNT07,0,0,ROUND(DAYS_COUNT07/ CNTR_COUNT07,1 ))) AS COUNT07," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT08,'2',DAYS_COUNT08,'3',DECODE(CNTR_COUNT08,0,0,ROUND(DAYS_COUNT08/ CNTR_COUNT08,1 ))) AS COUNT08," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT09,'2',DAYS_COUNT09,'3',DECODE(CNTR_COUNT09,0,0,ROUND(DAYS_COUNT09/ CNTR_COUNT09,1 ))) AS COUNT09," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT10,'2',DAYS_COUNT10,'3',DECODE(CNTR_COUNT10,0,0,ROUND(DAYS_COUNT10/ CNTR_COUNT10,1 ))) AS COUNT10," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT11,'2',DAYS_COUNT11,'3',DECODE(CNTR_COUNT11,0,0,ROUND(DAYS_COUNT11/ CNTR_COUNT11,1 ))) AS COUNT11," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT12,'2',DAYS_COUNT12,'3',DECODE(CNTR_COUNT12,0,0,ROUND(DAYS_COUNT12/ CNTR_COUNT12,1 ))) AS COUNT12," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT13,'2',DAYS_COUNT13,'3',DECODE(CNTR_COUNT13,0,0,ROUND(DAYS_COUNT13/ CNTR_COUNT13,1 ))) AS COUNT13," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT14,'2',DAYS_COUNT14,'3',DECODE(CNTR_COUNT14,0,0,ROUND(DAYS_COUNT14/ CNTR_COUNT14,1 ))) AS COUNT14," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT15,'2',DAYS_COUNT15,'3',DECODE(CNTR_COUNT15,0,0,ROUND(DAYS_COUNT15/ CNTR_COUNT15,1 ))) AS COUNT15," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT16,'2',DAYS_COUNT16,'3',DECODE(CNTR_COUNT16,0,0,ROUND(DAYS_COUNT16/ CNTR_COUNT16,1 ))) AS COUNT16," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT17,'2',DAYS_COUNT17,'3',DECODE(CNTR_COUNT17,0,0,ROUND(DAYS_COUNT17/ CNTR_COUNT17,1 ))) AS COUNT17," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT18,'2',DAYS_COUNT18,'3',DECODE(CNTR_COUNT18,0,0,ROUND(DAYS_COUNT18/ CNTR_COUNT18,1 ))) AS COUNT18," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT19,'2',DAYS_COUNT19,'3',DECODE(CNTR_COUNT19,0,0,ROUND(DAYS_COUNT19/ CNTR_COUNT19,1 ))) AS COUNT19," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT20,'2',DAYS_COUNT20,'3',DECODE(CNTR_COUNT20,0,0,ROUND(DAYS_COUNT20/ CNTR_COUNT20,1 ))) AS COUNT20," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT21,'2',DAYS_COUNT21,'3',DECODE(CNTR_COUNT21,0,0,ROUND(DAYS_COUNT21/ CNTR_COUNT21,1 ))) AS COUNT21," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT22,'2',DAYS_COUNT22,'3',DECODE(CNTR_COUNT22,0,0,ROUND(DAYS_COUNT22/ CNTR_COUNT22,1 ))) AS COUNT22," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT23,'2',DAYS_COUNT23,'3',DECODE(CNTR_COUNT23,0,0,ROUND(DAYS_COUNT23/ CNTR_COUNT23,1 ))) AS COUNT23," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT24,'2',DAYS_COUNT24,'3',DECODE(CNTR_COUNT24,0,0,ROUND(DAYS_COUNT24/ CNTR_COUNT24,1 ))) AS COUNT24," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT25,'2',DAYS_COUNT25,'3',DECODE(CNTR_COUNT25,0,0,ROUND(DAYS_COUNT25/ CNTR_COUNT25,1 ))) AS COUNT25," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT26,'2',DAYS_COUNT26,'3',DECODE(CNTR_COUNT26,0,0,ROUND(DAYS_COUNT26/ CNTR_COUNT26,1 ))) AS COUNT26," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT27,'2',DAYS_COUNT27,'3',DECODE(CNTR_COUNT27,0,0,ROUND(DAYS_COUNT27/ CNTR_COUNT27,1 ))) AS COUNT27," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT28,'2',DAYS_COUNT28,'3',DECODE(CNTR_COUNT28,0,0,ROUND(DAYS_COUNT28/ CNTR_COUNT28,1 ))) AS COUNT28," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT29,'2',DAYS_COUNT29,'3',DECODE(CNTR_COUNT29,0,0,ROUND(DAYS_COUNT29/ CNTR_COUNT29,1 ))) AS COUNT29," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT30,'2',DAYS_COUNT30,'3',DECODE(CNTR_COUNT30,0,0,ROUND(DAYS_COUNT30/ CNTR_COUNT30,1 ))) AS COUNT30," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT31,'2',DAYS_COUNT31,'3',DECODE(CNTR_COUNT31,0,0,ROUND(DAYS_COUNT31/ CNTR_COUNT31,1 ))) AS COUNT31," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT32,'2',DAYS_COUNT32,'3',DECODE(CNTR_COUNT32,0,0,ROUND(DAYS_COUNT32/ CNTR_COUNT32,1 ))) AS COUNT32," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT33,'2',DAYS_COUNT33,'3',DECODE(CNTR_COUNT33,0,0,ROUND(DAYS_COUNT33/ CNTR_COUNT33,1 ))) AS COUNT33," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT34,'2',DAYS_COUNT34,'3',DECODE(CNTR_COUNT34,0,0,ROUND(DAYS_COUNT34/ CNTR_COUNT34,1 ))) AS COUNT34," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT35,'2',DAYS_COUNT35,'3',DECODE(CNTR_COUNT35,0,0,ROUND(DAYS_COUNT35/ CNTR_COUNT35,1 ))) AS COUNT35," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT36,'2',DAYS_COUNT36,'3',DECODE(CNTR_COUNT36,0,0,ROUND(DAYS_COUNT36/ CNTR_COUNT36,1 ))) AS COUNT36," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT37,'2',DAYS_COUNT37,'3',DECODE(CNTR_COUNT37,0,0,ROUND(DAYS_COUNT37/ CNTR_COUNT37,1 ))) AS COUNT37," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT38,'2',DAYS_COUNT38,'3',DECODE(CNTR_COUNT38,0,0,ROUND(DAYS_COUNT38/ CNTR_COUNT38,1 ))) AS COUNT38," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT39,'2',DAYS_COUNT39,'3',DECODE(CNTR_COUNT39,0,0,ROUND(DAYS_COUNT39/ CNTR_COUNT39,1 ))) AS COUNT39," ).append("\n"); 
		query.append("      DECODE(YY.NO,'1',CNTR_COUNT40,'2',DAYS_COUNT40,'3',DECODE(CNTR_COUNT40,0,0,ROUND(DAYS_COUNT40/ CNTR_COUNT40,1 ))) AS COUNT40 " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT DECODE(Y.NO,1,LANE, 'ZZZZZZZZZZ')      AS LANE," ).append("\n"); 
		query.append("           DECODE(Y.NO,1,TRADE, 'ZZZZZZZZZZ')     AS TRADE," ).append("\n"); 
		query.append("           DECODE(Y.NO,1,SUB_TRADE, 'ZZZZZZZZZZ') AS SUB_TRADE, " ).append("\n"); 
		query.append("           DECODE(Y.NO,1,VVD, 'ZZZZZZZZZZ')       AS VVD," ).append("\n"); 
		query.append("           SUM(CNTR_CNT)                          AS CNTR_TOTAL," ).append("\n"); 
		query.append("           SUM(TT_DAYS)                           AS DAYS_TOTAL," ).append("\n"); 
		query.append("           SUM( DECODE(DSP_SEQ,'01',CNTR_CNT,0)) AS CNTR_COUNT01," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'02',CNTR_CNT,0)) AS CNTR_COUNT02," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'03',CNTR_CNT,0)) AS CNTR_COUNT03," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'04',CNTR_CNT,0)) AS CNTR_COUNT04," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'05',CNTR_CNT,0)) AS CNTR_COUNT05," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'06',CNTR_CNT,0)) AS CNTR_COUNT06," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'07',CNTR_CNT,0)) AS CNTR_COUNT07," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'08',CNTR_CNT,0)) AS CNTR_COUNT08," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'09',CNTR_CNT,0)) AS CNTR_COUNT09," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'10',CNTR_CNT,0)) AS CNTR_COUNT10," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'11',CNTR_CNT,0)) AS CNTR_COUNT11," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'12',CNTR_CNT,0)) AS CNTR_COUNT12," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'13',CNTR_CNT,0)) AS CNTR_COUNT13," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'14',CNTR_CNT,0)) AS CNTR_COUNT14," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'15',CNTR_CNT,0)) AS CNTR_COUNT15," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'16',CNTR_CNT,0)) AS CNTR_COUNT16," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'17',CNTR_CNT,0)) AS CNTR_COUNT17," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'18',CNTR_CNT,0)) AS CNTR_COUNT18," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'19',CNTR_CNT,0)) AS CNTR_COUNT19," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'20',CNTR_CNT,0)) AS CNTR_COUNT20," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'21',CNTR_CNT,0)) AS CNTR_COUNT21," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'22',CNTR_CNT,0)) AS CNTR_COUNT22," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'23',CNTR_CNT,0)) AS CNTR_COUNT23," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'24',CNTR_CNT,0)) AS CNTR_COUNT24," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'25',CNTR_CNT,0)) AS CNTR_COUNT25," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'26',CNTR_CNT,0)) AS CNTR_COUNT26," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'27',CNTR_CNT,0)) AS CNTR_COUNT27," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'28',CNTR_CNT,0)) AS CNTR_COUNT28," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'29',CNTR_CNT,0)) AS CNTR_COUNT29," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'30',CNTR_CNT,0)) AS CNTR_COUNT30," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'31',CNTR_CNT,0)) AS CNTR_COUNT31," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'32',CNTR_CNT,0)) AS CNTR_COUNT32," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'33',CNTR_CNT,0)) AS CNTR_COUNT33," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'34',CNTR_CNT,0)) AS CNTR_COUNT34," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'35',CNTR_CNT,0)) AS CNTR_COUNT35," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'36',CNTR_CNT,0)) AS CNTR_COUNT36," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'37',CNTR_CNT,0)) AS CNTR_COUNT37," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'38',CNTR_CNT,0)) AS CNTR_COUNT38," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'39',CNTR_CNT,0)) AS CNTR_COUNT39," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'40',CNTR_CNT,0)) AS CNTR_COUNT40," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'01',TT_DAYS,0)) AS DAYS_COUNT01," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'02',TT_DAYS,0)) AS DAYS_COUNT02," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'03',TT_DAYS,0)) AS DAYS_COUNT03," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'04',TT_DAYS,0)) AS DAYS_COUNT04," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'05',TT_DAYS,0)) AS DAYS_COUNT05," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'06',TT_DAYS,0)) AS DAYS_COUNT06," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'07',TT_DAYS,0)) AS DAYS_COUNT07," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'08',TT_DAYS,0)) AS DAYS_COUNT08," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'09',TT_DAYS,0)) AS DAYS_COUNT09," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'10',TT_DAYS,0)) AS DAYS_COUNT10," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'11',TT_DAYS,0)) AS DAYS_COUNT11," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'12',TT_DAYS,0)) AS DAYS_COUNT12," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'13',TT_DAYS,0)) AS DAYS_COUNT13," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'14',TT_DAYS,0)) AS DAYS_COUNT14," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'15',TT_DAYS,0)) AS DAYS_COUNT15," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'16',TT_DAYS,0)) AS DAYS_COUNT16," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'17',TT_DAYS,0)) AS DAYS_COUNT17," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'18',TT_DAYS,0)) AS DAYS_COUNT18," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'19',TT_DAYS,0)) AS DAYS_COUNT19," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'20',TT_DAYS,0)) AS DAYS_COUNT20," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'21',TT_DAYS,0)) AS DAYS_COUNT21," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'22',TT_DAYS,0)) AS DAYS_COUNT22," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'23',TT_DAYS,0)) AS DAYS_COUNT23," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'24',TT_DAYS,0)) AS DAYS_COUNT24," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'25',TT_DAYS,0)) AS DAYS_COUNT25," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'26',TT_DAYS,0)) AS DAYS_COUNT26," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'27',TT_DAYS,0)) AS DAYS_COUNT27," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'28',TT_DAYS,0)) AS DAYS_COUNT28," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'29',TT_DAYS,0)) AS DAYS_COUNT29," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'30',TT_DAYS,0)) AS DAYS_COUNT30," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'31',TT_DAYS,0)) AS DAYS_COUNT31," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'32',TT_DAYS,0)) AS DAYS_COUNT32," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'33',TT_DAYS,0)) AS DAYS_COUNT33," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'34',TT_DAYS,0)) AS DAYS_COUNT34," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'35',TT_DAYS,0)) AS DAYS_COUNT35," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'36',TT_DAYS,0)) AS DAYS_COUNT36," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'37',TT_DAYS,0)) AS DAYS_COUNT37," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'38',TT_DAYS,0)) AS DAYS_COUNT38," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'39',TT_DAYS,0)) AS DAYS_COUNT39," ).append("\n"); 
		query.append("          SUM( DECODE(DSP_SEQ,'40',TT_DAYS,0)) AS DAYS_COUNT40" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            SELECT " ).append("\n"); 
		query.append("                                  MAX(CLR.SLAN_CD) AS LANE ," ).append("\n"); 
		query.append("                                  CLR.TRD_CD       AS TRADE, " ).append("\n"); 
		query.append("                                  SUB_TRD_CD       AS SUB_TRADE," ).append("\n"); 
		query.append("                                  DP_SEQ           AS DSP_SEQ," ).append("\n"); 
		query.append("                                  VVD              AS VVD, " ).append("\n"); 
		query.append("                                  A.CNTR_TPSZ_CD   AS TYPE_SIZE," ).append("\n"); 
		query.append("                                  COUNT(CNTR_NO)   AS CNTR_CNT," ).append("\n"); 
		query.append("                                  SUM(TT_DYS)      AS TT_DAYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            FROM MAS_LANE_RGST CLR, (   SELECT /*+ USE_NL(TT VVD)*/" ).append("\n"); 
		query.append("                                                       			 VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                                                       			 CNTR.CNTR_NO,TT.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                        		MAX(TT_DYS) TT_DYS," ).append("\n"); 
		query.append("                                                        		MAX(CASE WHEN C1.CONTI_CD = C2.CONTI_CD THEN 'I' ELSE 'O' END) IOC_CD," ).append("\n"); 
		query.append("                            --                            		MAX(CNTR.BKG_NO) BKG_NO," ).append("\n"); 
		query.append("                                                        		MAX(VVD.SLAN_CD) SLAN_CD," ).append("\n"); 
		query.append("                                                        		MAX(NISADM.MAS_SLANE_RLANE_CONV_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, TT.SLAN_CD, VVD.POL_CD, VVD.POD_CD) ) AS RLANE_CD," ).append("\n"); 
		query.append("                                                        		MAX(NISADM.MAS_RLANE_TRD_CONV_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, TT.SLAN_CD, VVD.POL_CD, VVD.POD_CD)   ) AS TRD_CD" ).append("\n"); 
		query.append("                                                        FROM CIM_PORT_TURN_TM TT, BKG_VVD VVD, BKG_CONTAINER CNTR, MDM_LOCATION C1, MDM_LOCATION C2, BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                        WHERE 1=1" ).append("\n"); 
		query.append("                                                        AND VVD.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                                                        AND TT.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                                        AND TT.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                                        AND TT.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                        AND TT.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("														#if (${period} == 'M') " ).append("\n"); 
		query.append("                                                                                                                      " ).append("\n"); 
		query.append("                                                          AND TT.TGT_MVMT_DT	BETWEEN  TO_CHAR(TO_DATE(@[from_dt],'YYYY-MM'),'YYYYMMDD')	AND TO_CHAR(LAST_DAY(TO_DATE(@[to_dt],'YYYY-MM')),'YYYYMMDD')" ).append("\n"); 
		query.append("														#else " ).append("\n"); 
		query.append("                                                            " ).append("\n"); 
		query.append("                                                          AND	TT.TGT_YRWK	BETWEEN  REPLACE(@[from_dt],'-','')	AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																												" ).append("\n"); 
		query.append("                                                        AND TT.VL_LOC_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                        AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                        AND NVL(BK.SPLIT_RSN_CD, 'X') <> 'M'" ).append("\n"); 
		query.append("                                                        AND BK.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("                                                        --AND ROWNUM <= 300" ).append("\n"); 
		query.append("													#if (${vvd} != '')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                                                      AND TT.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                      AND TT.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                      AND TT.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("													#end" ).append("\n"); 
		query.append("																												" ).append("\n"); 
		query.append("														#if (${location} != '')" ).append("\n"); 
		query.append("															AND  TT.VL_LOC_CD   =   @[location]" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("														#if (${soc} == 'E') " ).append("\n"); 
		query.append("                                                            AND  TT.SOC_FLG  = 'N' " ).append("\n"); 
		query.append("														#elseif (${soc} == 'O') " ).append("\n"); 
		query.append("                                                            AND  TT.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("                                                        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                        AND TT.TS_FLG = 'Y'" ).append("\n"); 
		query.append("                                                        AND VVD.POL_CD = C1.LOC_CD" ).append("\n"); 
		query.append("                                                        AND VVD.POD_CD = C2.LOC_CD" ).append("\n"); 
		query.append("                                                        GROUP BY  TGT_MVMT_DT,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD ,CNTR.CNTR_NO,TT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                        " ).append("\n"); 
		query.append("                                                        ) A,CIM_TP_SZ_DP_SEQ	S" ).append("\n"); 
		query.append("                            WHERE CLR.RLANE_CD(+) = A.RLANE_CD" ).append("\n"); 
		query.append("                            AND CLR.DIR_CD(+) = SUBSTR(A.VVD,9,1)" ).append("\n"); 
		query.append("                            AND CLR.TRD_CD(+) = A.TRD_CD" ).append("\n"); 
		query.append("                            AND CLR.IOC_CD(+) = A.IOC_CD" ).append("\n"); 
		query.append("                            AND S.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            --anD CLR.TRD_CD(+) = :trd_cd" ).append("\n"); 
		query.append("                            --AND CLR.SUB_TRD_cD IN (:sub_trd_cd)" ).append("\n"); 
		query.append("                            --AND CLR.RLANE_CD IN (:rlane)" ).append("\n"); 
		query.append("							#if (${trade} != '')" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("                                AND CLR.TRD_CD(+) = @[trade]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if (${sub_trade} != '')" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("                                AND CLR.SUB_TRD_CD     IN  (@[sub_trade])" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if (${p_lane} != '')" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("                                AND CLR.RLANE_CD      IN  (@[p_lane])" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${tpsz} != 'A')" ).append("\n"); 
		query.append("								AND S.CNTR_TPSZ_DIV_CD = @[tpsz]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                             GROUP BY VVD, CLR.TRD_CD, SUB_TRD_CD,A.CNTR_TPSZ_CD,DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) X ," ).append("\n"); 
		query.append("   (  SELECT '1' AS NO  FROM DUAL" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("      SELECT '2'  FROM DUAL" ).append("\n"); 
		query.append("   ) Y    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY DECODE(Y.NO,1,LANE, 'ZZZZZZZZZZ') ,DECODE(Y.NO,1,TRADE, 'ZZZZZZZZZZ') ,DECODE(Y.NO,1,SUB_TRADE, 'ZZZZZZZZZZ'), DECODE(Y.NO,1,VVD, 'ZZZZZZZZZZ') " ).append("\n"); 
		query.append("    ORDER BY LANE,TRADE,SUB_TRADE,VVD" ).append("\n"); 
		query.append(") XX," ).append("\n"); 
		query.append("   (  SELECT '1' AS NO  FROM DUAL" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("      SELECT '2'  FROM DUAL" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT '3'  FROM DUAL" ).append("\n"); 
		query.append("   ) YY" ).append("\n"); 
		query.append("ORDER BY NVL(XX.TRADE,1),NVL(XX.SUB_TRADE,1),NVL(XX.LANE,1),NVL(XX.VVD,1),YY.NO" ).append("\n"); 

	}
}