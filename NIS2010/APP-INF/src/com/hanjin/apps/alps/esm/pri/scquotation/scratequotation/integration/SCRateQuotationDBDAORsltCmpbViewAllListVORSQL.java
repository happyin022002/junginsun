/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltCmpbViewAllListVORSQL.java
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

public class SCRateQuotationDBDAORsltCmpbViewAllListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CmpbViewAll
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltCmpbViewAllListVORSQL(){
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
		query.append("FileName : SCRateQuotationDBDAORsltCmpbViewAllListVORSQL").append("\n"); 
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
		query.append("WITH VW_PRI_SQ_RT_CMDT  AS (" ).append("\n"); 
		query.append("SELECT 	 CMDT.QTTN_NO,CMDT.QTTN_VER_NO" ).append("\n"); 
		query.append(",CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD , '; ')),3) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY PRC_CMDT_TP_CD DESC,QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != 'B')" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") CMDT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR CMDT.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append("GROUP BY CMDT.QTTN_NO" ).append("\n"); 
		query.append(",CMDT.QTTN_VER_NO" ).append("\n"); 
		query.append(",CMDT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SQ_RT_ROUT_PNT_ORI AS (" ).append("\n"); 
		query.append("SELECT  ROUT_PNT.QTTN_NO,ROUT_PNT.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02138' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != 'B')" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ROUT_PNT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.GEN_SPCL_RT_TP_CD = ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_PNT.QTTN_NO" ).append("\n"); 
		query.append(",ROUT_PNT.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SQ_RT_ROUT_PNT_DEST AS (" ).append("\n"); 
		query.append("SELECT  ROUT_PNT.QTTN_NO,ROUT_PNT.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02138' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != 'B')" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ROUT_PNT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.GEN_SPCL_RT_TP_CD = ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_PNT.QTTN_NO" ).append("\n"); 
		query.append(",ROUT_PNT.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_PNT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SQ_RT_ROUT_VIA_ORI AS (" ).append("\n"); 
		query.append("SELECT 	 ROUT_VIA.QTTN_NO,ROUT_VIA.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != 'B')" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ROUT_VIA" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.GEN_SPCL_RT_TP_CD = ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_VIA.QTTN_NO" ).append("\n"); 
		query.append(",ROUT_VIA.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SQ_RT_ROUT_VIA_DEST AS (" ).append("\n"); 
		query.append("SELECT 	 ROUT_VIA.QTTN_NO,ROUT_VIA.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  QTTN_NO,QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY QTTN_NO" ).append("\n"); 
		query.append(",QTTN_VER_NO" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != 'B')" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ROUT_VIA" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.GEN_SPCL_RT_TP_CD = ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_VIA.QTTN_NO" ).append("\n"); 
		query.append(",ROUT_VIA.QTTN_VER_NO" ).append("\n"); 
		query.append(",ROUT_VIA.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("QTTN_NO,QTTN_VER_NO,GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ,ROUT_SEQ,RT_SEQ" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RAT_UT_CD, PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",DECODE(GEN_SPCL_RT_TP_CD,'G',1,0) G_RATE_TYPE" ).append("\n"); 
		query.append(",DECODE(GEN_SPCL_RT_TP_CD,'S',1,0) S_RATE_TYPE" ).append("\n"); 
		query.append(",PRS_SCG_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",QTTN_INIT_RT_AMT" ).append("\n"); 
		query.append(",QTTN_RT_AMT" ).append("\n"); 
		query.append(",N1ST_ORD_REF" ).append("\n"); 
		query.append(",N2ND_ORD_REF" ).append("\n"); 
		query.append(",DIFF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RT.QTTN_NO,RT.QTTN_VER_NO,RT.GEN_SPCL_RT_TP_CD,RT.CMDT_HDR_SEQ,RT.ROUT_SEQ,RT.RT_SEQ" ).append("\n"); 
		query.append(",C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",OP.ROUT_PNT_LOC_DEF_CD AS ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",OV.ROUT_VIA_PORT_DEF_CD AS ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DV.ROUT_VIA_PORT_DEF_CD AS DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DP.ROUT_PNT_LOC_DEF_CD AS DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RT.RAT_UT_CD" ).append("\n"); 
		query.append(",RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",RT.CURR_CD" ).append("\n"); 
		query.append(",RT.PRS_SCG_AMT" ).append("\n"); 
		query.append(",RT.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",RT.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",RT.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",RT.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",RT.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",RT.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",RT.PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",RT.QTTN_INIT_RT_AMT" ).append("\n"); 
		query.append(",RT.QTTN_RT_AMT" ).append("\n"); 
		query.append(",FIRST_VALUE(DECODE(RT.PRC_CGO_TP_CD, 'DR', 1, 'RF', 2, 'DG', 3, 'AK', 4, 99))" ).append("\n"); 
		query.append("OVER(PARTITION BY RT.QTTN_NO, RT.QTTN_VER_NO, RT.CMDT_HDR_SEQ, RT.ROUT_SEQ, RT.RT_SEQ) AS N1ST_ORD_REF" ).append("\n"); 
		query.append(",FIRST_VALUE(RT.RAT_UT_CD)" ).append("\n"); 
		query.append("OVER(PARTITION BY RT.QTTN_NO, RT.QTTN_VER_NO, RT.CMDT_HDR_SEQ, RT.ROUT_SEQ, RT.RT_SEQ) AS N2ND_ORD_REF" ).append("\n"); 
		query.append(",(CASE WHEN RT.PRS_RESPB_CMPB_AMT IS NOT NULL AND RT.PRS_GID_CMPB_AMT IS NOT NULL" ).append("\n"); 
		query.append("THEN RT.PRS_RESPB_CMPB_AMT - RT.PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END) AS DIFF" ).append("\n"); 
		query.append("FROM PRI_SQ_RT RT" ).append("\n"); 
		query.append(", VW_PRI_SQ_RT_CMDT C" ).append("\n"); 
		query.append(", VW_PRI_SQ_RT_ROUT_PNT_ORI OP" ).append("\n"); 
		query.append(", VW_PRI_SQ_RT_ROUT_PNT_DEST DP" ).append("\n"); 
		query.append(", VW_PRI_SQ_RT_ROUT_VIA_ORI OV" ).append("\n"); 
		query.append(", VW_PRI_SQ_RT_ROUT_VIA_DEST DV" ).append("\n"); 
		query.append(", PRI_SQ_RT_CMDT D" ).append("\n"); 
		query.append("WHERE RT.QTTN_NO = C.QTTN_NO" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = C.QTTN_VER_NO" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = OP.QTTN_NO" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = OP.QTTN_VER_NO" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = OP.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = OP.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND RT.ROUT_SEQ = OP.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = DP.QTTN_NO" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = DP.QTTN_VER_NO" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = DP.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = DP.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND RT.ROUT_SEQ = DP.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = OV.QTTN_NO(+)" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = OV.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = OV.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = OV.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND RT.ROUT_SEQ = OV.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = DV.QTTN_NO(+)" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = DV.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = DV.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = DV.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND RT.ROUT_SEQ = DV.ROUT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = D.QTTN_NO" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = D.QTTN_VER_NO" ).append("\n"); 
		query.append("AND RT.GEN_SPCL_RT_TP_CD = D.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RT.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND RT.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY GEN_SPCL_RT_TP_CD,RT_SEQ, N1ST_ORD_REF, N2ND_ORD_REF, RT_SEQ" ).append("\n"); 

	}
}