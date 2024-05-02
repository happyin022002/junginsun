/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchChsMovemenDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.25 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchChsMovemenDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchChsMovemenDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchChsMovemenDateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("AB.EQ_NO, AB.EQ_TPSZ_CD," ).append("\n"); 
		query.append("AB.AGMT_LSTM_CD," ).append("\n"); 
		query.append("DECODE( AB.ACIAC_DIV_CD, 'A', 'Active', 'In-active' ) as ACIAC_DIV_CD," ).append("\n"); 
		query.append("AB.CRNT_YD_CD," ).append("\n"); 
		query.append("AB.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("TO_CHAR( AB.CHSS_MVMT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CHSS_MVMT_DT," ).append("\n"); 
		query.append("TRUNC( SYSDATE- AB.CHSS_MVMT_DT ) DAYS," ).append("\n"); 
		query.append("AB.CNTR_NO CHSS_NO," ).append("\n"); 
		query.append("J.EQ_NO MG_SET_NO," ).append("\n"); 
		query.append("DECODE( D.CNTR_NO, NULL, H.CHSS_USE_CO_NM, 'SMLINE' ) CNTR_OWNR_CO_CD," ).append("\n"); 
		query.append("C.Bl_NO," ).append("\n"); 
		query.append("( B.BKG_NO ) BOOKING," ).append("\n"); 
		query.append("E.VNDR_SEQ," ).append("\n"); 
		query.append("E.VNDR_ABBR_NM," ).append("\n"); 
		query.append("F.CUST_CNT_CD || F.CUST_SEQ AS CONIGNEE1," ).append("\n"); 
		query.append("F.CUST_NM," ).append("\n"); 
		query.append("G.CUST_CNT_CD || G.CUST_SEQ AS CONIGNEE," ).append("\n"); 
		query.append("G.CUST_NM CONSIGNE," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("AB.TTL_KNT" ).append("\n"); 
		query.append("FROM (   SELECT A.EQ_NO" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",AGMT_LSTM_CD" ).append("\n"); 
		query.append(",CHSS_MVMT_DT" ).append("\n"); 
		query.append(",CRNT_YD_CD" ).append("\n"); 
		query.append(",CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append(",ACIAC_DIV_CD" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",TTL_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ INDEX( A XAK2CGM_EQUIPMENT) USE_NL(AA I) */" ).append("\n"); 
		query.append("A.EQ_NO" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD" ).append("\n"); 
		query.append(", A.CRNT_LOC_CD" ).append("\n"); 
		query.append(",A.CRNT_YD_CD" ).append("\n"); 
		query.append(",A.CHSS_MVMT_DT" ).append("\n"); 
		query.append(",A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append(",A.ACIAC_DIV_CD" ).append("\n"); 
		query.append(", I.CNTR_NO" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (ORDER BY A.EQ_NO) AS ROWNO" ).append("\n"); 
		query.append(",COUNT(*) OVER () TTL_KNT" ).append("\n"); 
		query.append("FROM (SELECT /*+ USE_NL(AA BB) */" ).append("\n"); 
		query.append("AA.LOC_CD" ).append("\n"); 
		query.append("FROM   MDM_LOCATION AA," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("#if ( ${location} == 'L' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY AA.LOC_CD" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(",CGM_EQUIPMENT A" ).append("\n"); 
		query.append(",CGM_EQ_ATCH_DTCH_HIS I" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("AND A.EQ_NO = I.EQ_NO(+)" ).append("\n"); 
		query.append("AND I.DTCH_DT(+) = TO_DATE( '88881231', 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND I.EQ_KND_CD(+) = 'Z'" ).append("\n"); 
		query.append("#if(${np} != 'Y')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD <> 'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${aciac_div_cd} != '' )" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${agmt_lstm_cd} != 'ALL' )" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD = @[agmt_lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${eq_tpsz_cd} != 'ALL' )" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD IN  ( SELECT EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("WHERE EQ_TPSZ_REP_CD =  @[eq_tpsz_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${days} != '' )" ).append("\n"); 
		query.append("AND TRUNC(SYSDATE - A.CHSS_MVMT_DT) >= @[days]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${chss_pool_cd} == 'E' )" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD   IS NULL" ).append("\n"); 
		query.append("#elseif ( ${chss_pool_cd} == 'O' )" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD    IS NOT NULL" ).append("\n"); 
		query.append("#elseif ( ${chss_pool_cd} != 'I' )" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD    = @[chss_pool_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("AND A.CHSS_MVMT_STS_CD IN ($chss_mvmt_sts_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.ROWNO BETWEEN @[str_page] AND @[end_page]" ).append("\n"); 
		query.append(") AB," ).append("\n"); 
		query.append("CGM_CHSS_MVMT_HIS B," ).append("\n"); 
		query.append("MST_CONTAINER D," ).append("\n"); 
		query.append("BKG_BOOKING C," ).append("\n"); 
		query.append("MDM_VENDOR E," ).append("\n"); 
		query.append("BKG_CUSTOMER F," ).append("\n"); 
		query.append("BKG_CUSTOMER G," ).append("\n"); 
		query.append("CGM_POOL_MVMT_HIS H," ).append("\n"); 
		query.append("CGM_EQ_ATCH_DTCH_HIS J" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AB.EQ_NO = B.CHSS_NO(+)" ).append("\n"); 
		query.append("AND AB.CHSS_MVMT_DT = B.MVMT_DT(+)" ).append("\n"); 
		query.append("AND B.SYS_SEQ(+) = 1" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND F.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("AND G.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND B.CHSS_NO = H.CHSS_NO(+)" ).append("\n"); 
		query.append("AND B.MVMT_DT = H.MVMT_DT(+)" ).append("\n"); 
		query.append("AND B.YD_CD = H.YD_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND AB.EQ_NO = J.CHSS_NO(+)" ).append("\n"); 
		query.append("AND J.DTCH_DT(+) = TO_DATE( '88881231', 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND J.EQ_KND_CD(+) = 'G'" ).append("\n"); 

	}
}