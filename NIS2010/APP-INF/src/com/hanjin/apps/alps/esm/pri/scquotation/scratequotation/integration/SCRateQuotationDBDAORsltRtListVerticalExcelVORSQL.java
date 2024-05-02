/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltRtListVerticalExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltRtListVerticalExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vertical Excel
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltRtListVerticalExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltRtListVerticalExcelVORSQL").append("\n"); 
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
		query.append("SELECT A.CMDT_DP_SEQ" ).append("\n"); 
		query.append(",B.ROUT_DP_SEQ" ).append("\n"); 
		query.append(",B.DIR_CALL_FLG" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",B.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",B.ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",B.ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",B.ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",B.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",B.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",B.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",B.DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",B.DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",B.DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",B.RAT_UT_CD" ).append("\n"); 
		query.append(",B.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",B.CURR_CD" ).append("\n"); 
		query.append(",B.QTTN_RT_AMT" ).append("\n"); 
		query.append("FROM (SELECT S.CMDT_ROWKEY, A.CMDT_DP_SEQ, B.PRC_CMDT_DEF_CD, B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append(",(SELECT ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD ORDER BY T.CMDT_HDR_SEQ) AS CMDT_DP_SEQ" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || '00001' AS CMDT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT_HDR T" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(T.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_CMDT" ).append("\n"); 
		query.append("WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'R'" ).append("\n"); 
		query.append(",(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",T.CMDT_HDR_SEQ ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99)" ).append("\n"); 
		query.append(",T.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT T" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE S.CMDT_ROWKEY = A.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.CMDT_ROWKEY = B.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("ORDER BY S.CMDT_ROWKEY) A" ).append("\n"); 
		query.append("FULL OUTER JOIN (SELECT LPAD(S.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY S.CMDT_HDR_SEQ ORDER BY S.ROUT_ROWKEY), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append(",A.DIR_CALL_FLG" ).append("\n"); 
		query.append(",A.ROUT_DP_SEQ" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",B.RCV_DE_TERM_NM AS ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",B.PRC_TRSP_MOD_NM AS ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",E.RCV_DE_TERM_NM AS DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",E.PRC_TRSP_MOD_NM AS DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",F.RAT_UT_CD" ).append("\n"); 
		query.append(",F.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",F.CURR_CD" ).append("\n"); 
		query.append(",F.QTTN_RT_AMT" ).append("\n"); 
		query.append("FROM (SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append(",(SELECT DIR_CALL_FLG" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD, T.CMDT_HDR_SEQ ORDER BY T.ROUT_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT_ROUT T" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.ROUT_SEQ" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(T.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_LOC" ).append("\n"); 
		query.append("WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                 --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY  T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD,T.CMDT_HDR_SEQ,T.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT T" ).append("\n"); 
		query.append("WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.ROUT_SEQ" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD,T.CMDT_HDR_SEQ,T.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA T" ).append("\n"); 
		query.append("WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.ROUT_SEQ" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD,T.CMDT_HDR_SEQ,T.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_VIA_PORT_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append(",T.ROUT_VIA_PORT_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA T" ).append("\n"); 
		query.append("WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.ROUT_SEQ" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_LOC" ).append("\n"); 
		query.append("WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                 --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD,T.CMDT_HDR_SEQ,T.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append(",T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT T" ).append("\n"); 
		query.append("WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append(",(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",T.ROUT_SEQ" ).append("\n"); 
		query.append(",T.RAT_UT_CD" ).append("\n"); 
		query.append(",T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",T.CURR_CD" ).append("\n"); 
		query.append(",T.QTTN_RT_AMT" ).append("\n"); 
		query.append(",LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.GEN_SPCL_RT_TP_CD,T.CMDT_HDR_SEQ,T.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY T.PRC_CGO_TP_CD,T.RAT_UT_CD,T.CURR_CD)" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("FROM PRI_SQ_RT T" ).append("\n"); 
		query.append("WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND T.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append(") F" ).append("\n"); 
		query.append("WHERE S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = C.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = D.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("ORDER BY S.ROUT_ROWKEY) B ON A.CMDT_ROWKEY = B.CMDT_ROWKEY" ).append("\n"); 
		query.append("ORDER BY COALESCE(A.CMDT_ROWKEY, B.CMDT_ROWKEY)" ).append("\n"); 

	}
}