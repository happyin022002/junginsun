/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.05 조재성
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

public class ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDataRSQL(){
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
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDataRSQL").append("\n"); 
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
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("B.STS_EVNT_YD_CD                         AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${location} == 'S' )" ).append("\n"); 
		query.append("B.STS_EVNT_YD_CD                      AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("B.STS_EVNT_LOC_CD                    AS STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD" ).append("\n"); 
		query.append("#if (${kind} == 'L' )" ).append("\n"); 
		query.append(", C.VNDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD || A.AGMT_SEQ        AS VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",COUNT(A.EQ_TPSZ_CD)                  AS TOTAL" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'UMG',1,0))  AS UMG" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'CLG',1,0))  AS CLG" ).append("\n"); 
		query.append(",'' AS EQ_NO" ).append("\n"); 
		query.append(",'' AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("--     ,'' AS AGMT_LSTM_CD" ).append("\n"); 
		query.append("--     ,'' AS VNDR_SEQ" ).append("\n"); 
		query.append(",'' AS STS_EVNT_DT" ).append("\n"); 
		query.append(",'' AS LCC_CD" ).append("\n"); 
		query.append(",'' AS SCC_CD" ).append("\n"); 
		query.append(",'' AS STS_EVNT_YD_CD" ).append("\n"); 
		query.append(",'' AS EVNT_DT" ).append("\n"); 
		query.append(",'' AS UPD_DT" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(",CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append(",CGM_AGREEMENT C" ).append("\n"); 
		query.append("WHERE  A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND C.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT >= TO_DATE(@[evnt_dt_str],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT <  TO_DATE(@[evnt_dt_end],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("#if (  ${eq_aset_sts_cd} != '' )" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD = @[eq_aset_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.STS_EVNT_LOC_CD  IN" ).append("\n"); 
		query.append("( SELECT AA.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION AA" ).append("\n"); 
		query.append(", MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (  ${vndr_seq} != '' )" ).append("\n"); 
		query.append("#if (${kind} == 'L' )" ).append("\n"); 
		query.append("AND	C.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#elseif ( ${kind} == 'A' )" ).append("\n"); 
		query.append("AND  (C.AGMT_OFC_CTY_CD,C.AGMT_SEQ ) IN ($vndr_seq)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${kind} == 'L' )" ).append("\n"); 
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD,C.VNDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${location} == 'S' )" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD,C.VNDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_LOC_CD ,A.AGMT_LSTM_CD,C.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD,A.AGMT_OFC_CTY_CD || A.AGMT_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${location} == 'S' )" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD,A.AGMT_OFC_CTY_CD || A.AGMT_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY  B.STS_EVNT_LOC_CD ,A.AGMT_LSTM_CD,A.AGMT_OFC_CTY_CD || A.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("ORDER BY B.STS_EVNT_YD_CD  ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${location} == 'S' )" ).append("\n"); 
		query.append("ORDER BY B.STS_EVNT_YD_CD  ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY B.STS_EVNT_LOC_CD  ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}