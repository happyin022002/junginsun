/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TRIProposalDBDAORsltTriPrsCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltTriPrsCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Detail 화면(  PRI_6084) 에서 Route Case를 추출하는 쿼리
	  * 
	  * * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public TRIProposalDBDAORsltTriPrsCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltTriPrsCostListVORSQL").append("\n"); 
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
		query.append("/* ROUTE CASE NO 선택하기 위한 QUERY " ).append("\n"); 
		query.append("   tri_prop_no, amdt_seq,  cost_tp ,upd_usr_id변수를 추가해줘야한다." ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT  B.POR_CD" ).append("\n"); 
		query.append("       ,B.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.POL_CD" ).append("\n"); 
		query.append("       , MAX(DECODE(B.COST_ROUT_NO, 1, REPLACE(SUBSTR(B.N1ST_RLANE_CD,1,3), '-(', '('))||  N1ST_TS_PORT_CD ) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 2, SUBSTR(B.N2ND_RLANE_CD,1,3))||  N2ND_TS_PORT_CD) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 3, SUBSTR(B.N3RD_RLANE_CD,1,3))||  N3RD_TS_PORT_CD ) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 4, SUBSTR(B.N4TH_RLANE_CD,1,3)))" ).append("\n"); 
		query.append("         AS TS_ROUTE" ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = B.BKG_RCV_TERM_CD )||'-'||" ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02071' AND INTG_CD_VAL_CTNT = B.BKG_DE_TERM_CD ) AS RDTERM" ).append("\n"); 
		query.append("       ,MAX(DECODE( B.COST_ROUT_NO, 1, SUBSTR(B.N1ST_RLANE_CD,1,3), " ).append("\n"); 
		query.append("                                2, SUBSTR(B.N2ND_RLANE_CD,1,3)," ).append("\n"); 
		query.append("                                3, SUBSTR(B.N3RD_RLANE_CD,1,3), " ).append("\n"); 
		query.append("                                4, SUBSTR(B.N4TH_RLANE_CD,1,3), NULL)) AS SVC_LANE" ).append("\n"); 
		query.append("       ,LPAD(FLOOR(B.TTL_TZTM_HRS / 24), 2, 0)||'D '|| LPAD(MOD(B.TTL_TZTM_HRS, 24), 2, 0)||'H' AS TTL_TZTM_HRS" ).append("\n"); 
		query.append("       ,SUM(C.RESPB_USD_TTL_AMT) AS RESPB_USD_TTL_AMT" ).append("\n"); 
		query.append("       ,B.ROUT_CS_NO" ).append("\n"); 
		query.append("       ,B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("       ,@[tri_prop_no] TRI_PROP_NO" ).append("\n"); 
		query.append("       ,@[amdt_seq] AMDT_SEQ" ).append("\n"); 
		query.append("       ,@[cost_tp] AS COST_TP" ).append("\n"); 
		query.append("	   , '' as upd_usr_id" ).append("\n"); 
		query.append("	   , A.USD_ROUT_CS_SEL_FLG " ).append("\n"); 
		query.append("  FROM  PRI_TRI_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("       ,PRI_PRS_USD_ROUT_CS_INFO B" ).append("\n"); 
		query.append("       ,PRI_PRS_USD_ROUT_ACT_COST C" ).append("\n"); 
		query.append("       ,MAS_STND_ACCT_V D" ).append("\n"); 
		query.append(" WHERE  A.TRI_PROP_NO        = @[tri_prop_no]" ).append("\n"); 
		query.append("   AND  A.AMDT_SEQ       = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  A.ROUT_CS_NO     = B.ROUT_CS_NO" ).append("\n"); 
		query.append("   AND  A.ROUT_CS_SRC_DT = B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("   AND  B.ROUT_CS_NO     = C.ROUT_CS_NO" ).append("\n"); 
		query.append("   AND  B.ROUT_CS_SRC_DT = C.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("   AND  D.MAS_COST_SRC_PRT_CD IN( 'CO', 'RA') -- Office Profit " ).append("\n"); 
		query.append("   AND  D.STND_COST_TP_CD IN ('C', DECODE(@[cost_tp], 'C', 'C', 'O')) -- CM = 'C', OP = 'O' " ).append("\n"); 
		query.append("   AND  D.STND_COST_CD   = C.STND_COST_CD" ).append("\n"); 
		query.append("   AND  D.PA_VW = 'BKG'" ).append("\n"); 
		query.append("GROUP BY B.POR_CD" ).append("\n"); 
		query.append("       ,B.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.POL_CD" ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("       ,LPAD(FLOOR(B.TTL_TZTM_HRS / 24), 2, 0)" ).append("\n"); 
		query.append("       ,LPAD(MOD(B.TTL_TZTM_HRS, 24), 2, 0)" ).append("\n"); 
		query.append("       ,B.ROUT_CS_NO" ).append("\n"); 
		query.append("       ,B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("	   , A.USD_ROUT_CS_SEL_FLG" ).append("\n"); 
		query.append("ORDER BY A.USD_ROUT_CS_SEL_FLG DESC" ).append("\n"); 
		query.append("		,B.POR_CD" ).append("\n"); 
		query.append("       ,B.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.POL_CD" ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("       ,LPAD(FLOOR(B.TTL_TZTM_HRS / 24), 2, 0)" ).append("\n"); 
		query.append("       ,LPAD(MOD(B.TTL_TZTM_HRS, 24), 2, 0)" ).append("\n"); 
		query.append("       ,B.ROUT_CS_NO" ).append("\n"); 
		query.append("       ,B.ROUT_CS_SRC_DT" ).append("\n"); 

	}
}