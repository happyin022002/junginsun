/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSLostResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.22 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSLostResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lost Chassis Summary    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSLostResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_aset_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSLostResultDataRSQL").append("\n"); 
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
		query.append("#if ( ${eq_aset_sts_cd} == 'LST')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.STS_EVNT_LOC_CD || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(",A.STS_EVNT_LOC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",COUNT(A.EQ_TPSZ_CD)                  AS TOTAL" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SF2',1,0))  AS SF2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SL2',1,0))  AS SL2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'TA2',1,0))  AS TA2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SF4',1,0))  AS SF4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'GN4',1,0))  AS GN4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'CB4',1,0))  AS CB4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'GN5',1,0))  AS GN5" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'EG5',1,0))  AS EG5" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'EG8',1,0))  AS EG8" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'ZT4',1,0))  AS ZT4" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("BB.LCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", BB.LCC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("BB.SCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", BB.SCC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("B.STS_EVNT_YD_CD  || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", B.STS_EVNT_YD_CD                   AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD                  AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(", CASE WHEN LAG ( B.EQ_ASET_STS_CD ) OVER (PARTITION BY  B.EQ_NO ORDER BY B.EQ_NO,B.STS_EVNT_DT,B.EQ_STS_SEQ )  = 'LST' AND  B.EQ_ASET_STS_CD = 'FND' THEN NULL" ).append("\n"); 
		query.append("ELSE  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("END EVENT_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(",CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append(",MDM_VENDOR D" ).append("\n"); 
		query.append(",MDM_LOCATION AA" ).append("\n"); 
		query.append(",MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE  A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT >= TO_DATE(@[evnt_dt_str],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT <= TO_DATE(@[evnt_dt_end] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.STS_EVNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD IN  ('LST','FND' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.EVENT_KNT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  A.STS_EVNT_LOC_CD ,A.AGMT_LSTM_CD,A.VNDR_LGL_ENG_NM,A.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("BB.LCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", BB.LCC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("BB.SCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", BB.SCC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("B.STS_EVNT_YD_CD  || A.AGMT_LSTM_CD  AS AGREEMENT" ).append("\n"); 
		query.append(", B.STS_EVNT_YD_CD                   AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",COUNT(A.EQ_TPSZ_CD)                  AS TOTAL" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SF2',1,0))  AS SF2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SL2',1,0))  AS SL2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'TA2',1,0))  AS TA2" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'SF4',1,0))  AS SF4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'GN4',1,0))  AS GN4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'CB4',1,0))  AS CB4" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'GN5',1,0))  AS GN5" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'EG5',1,0))  AS EG5" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'EG8',1,0))  AS EG8" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'ZT4',1,0))  AS ZT4" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(",CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append(",MDM_VENDOR D" ).append("\n"); 
		query.append(",MDM_LOCATION AA" ).append("\n"); 
		query.append(",MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE  A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT >= TO_DATE(@[evnt_dt_str],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT <= TO_DATE(@[evnt_dt_end] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.STS_EVNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} == 'LST')" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD IN  ('LST','FND' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} == 'FND')" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD =  @[eq_aset_sts_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} == '')" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD =  'LST'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("GROUP BY  BB.LCC_CD ,A.AGMT_LSTM_CD,D.VNDR_LGL_ENG_NM,A.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY BB.LCC_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("GROUP BY  BB.SCC_CD ,A.AGMT_LSTM_CD,D.VNDR_LGL_ENG_NM,A.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY BB.SCC_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD,D.VNDR_LGL_ENG_NM,A.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}