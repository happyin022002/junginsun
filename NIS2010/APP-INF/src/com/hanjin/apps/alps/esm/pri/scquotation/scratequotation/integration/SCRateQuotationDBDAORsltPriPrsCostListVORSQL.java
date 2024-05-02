/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriPrsCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.06.24 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltPriPrsCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Detail 화면(  PRI_6016) 에서 Route Case를 추출하는 쿼리
	  * 2015.06.30 최성환 [CHM-201536493] Split03-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriPrsCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriPrsCostListVORSQL").append("\n"); 
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
		query.append("*/" ).append("\n"); 
		query.append("SELECT  B.POR_CD" ).append("\n"); 
		query.append("       ,B.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.POL_CD" ).append("\n"); 
		query.append("       , MAX(DECODE(B.COST_ROUT_NO, 1, REPLACE(SUBSTR(B.N1ST_RLANE_CD,1,3), '-(', '('))||  N1ST_TS_PORT_CD ) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 2, SUBSTR(B.N2ND_RLANE_CD,1,3))||  N2ND_TS_PORT_CD) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 3, SUBSTR(B.N3RD_RLANE_CD,1,3))||  N3RD_TS_PORT_CD ) " ).append("\n"); 
		query.append("         || MAX(DECODE(B.COST_ROUT_NO, 4, SUBSTR(B.N4TH_RLANE_CD,1,3)))" ).append("\n"); 
		query.append("         AS TS_ROUTE" ).append("\n"); 
		query.append("       --,'미개발' as TS_ROUTE --       ,TS_ROUTE /* COA */" ).append("\n"); 
		query.append("       ,B.POD_CD" ).append("\n"); 
		query.append("       ,B.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("       ,B.DEL_CD" ).append("\n"); 
		query.append("       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02138' AND INTG_CD_VAL_CTNT = B.BKG_RCV_TERM_CD )||'-'||" ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02139' AND INTG_CD_VAL_CTNT = B.BKG_DE_TERM_CD ) AS RDTERM" ).append("\n"); 
		query.append("       ,MAX(DECODE( B.COST_ROUT_NO, 1, SUBSTR(B.N1ST_RLANE_CD,1,3), " ).append("\n"); 
		query.append("                                2, SUBSTR(B.N2ND_RLANE_CD,1,3)," ).append("\n"); 
		query.append("                                3, SUBSTR(B.N3RD_RLANE_CD,1,3), " ).append("\n"); 
		query.append("                                4, SUBSTR(B.N4TH_RLANE_CD,1,3), NULL)) AS SVC_LANE" ).append("\n"); 
		query.append("       ,LPAD(FLOOR(B.TTL_TZTM_HRS / 24), 2, 0)||'D '|| LPAD(MOD(B.TTL_TZTM_HRS, 24), 2, 0)||'H' AS TTL_TZTM_HRS" ).append("\n"); 
		query.append("       ,SUM(C.RESPB_USD_TTL_AMT) AS RESPB_USD_TTL_AMT" ).append("\n"); 
		query.append("       ,B.ROUT_CS_NO" ).append("\n"); 
		query.append("       ,B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("       ,@[qttn_no] AS QTTN_NO" ).append("\n"); 
		query.append("       ,@[qttn_ver_no] AS QTTN_VER_NO" ).append("\n"); 
		query.append("       ,@[gen_spcl_rt_tp_cd] AS GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("       ,@[cmdt_hdr_seq] AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("       ,@[rout_seq] AS ROUT_SEQ" ).append("\n"); 
		query.append("       ,@[rt_seq] AS RT_SEQ" ).append("\n"); 
		query.append("       ,@[cost_tp] AS COST_TP" ).append("\n"); 
		query.append("	   , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("	   , A.USD_ROUT_CS_SEL_FLG " ).append("\n"); 
		query.append("  FROM  PRI_SQ_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("       ,PRI_PRS_USD_ROUT_CS_INFO B" ).append("\n"); 
		query.append("       ,PRI_PRS_USD_ROUT_ACT_COST C" ).append("\n"); 
		query.append("       ,MAS_STND_ACCT_V D" ).append("\n"); 
		query.append(" WHERE  A.QTTN_NO        = @[qttn_no]" ).append("\n"); 
		query.append("   AND  A.QTTN_VER_NO       = @[qttn_ver_no]" ).append("\n"); 
		query.append("   AND  A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND  A.CMDT_HDR_SEQ   = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND  A.ROUT_SEQ       = @[rout_seq]" ).append("\n"); 
		query.append("   AND  A.RT_SEQ         = @[rt_seq]" ).append("\n"); 
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
		query.append("ORDER BY  A.USD_ROUT_CS_SEL_FLG DESC" ).append("\n"); 
		query.append("	   ,B.POR_CD" ).append("\n"); 
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