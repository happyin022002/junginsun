/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriSurchargeViewAllVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriSurchargeViewAllVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   RFA Quotation Surcharge View All
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriSurchargeViewAllVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriSurchargeViewAllVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("	A.QTTN_NO" ).append("\n"); 
		query.append("	,A.QTTN_VER_NO" ).append("\n"); 
		query.append("	,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,A.ROUT_SEQ" ).append("\n"); 
		query.append("	,RT.RT_SEQ" ).append("\n"); 
		query.append("	,I.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	,NVL(B.ROUT_PNT_LOC_DEF_CD ,' ') AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,NVL(C.ROUT_VIA_PORT_DEF_CD ,' ') AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,NVL(D.ROUT_VIA_PORT_DEF_CD ,' ') AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,NVL(E.ROUT_PNT_LOC_DEF_CD ,' ') AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,RT.RAT_UT_CD" ).append("\n"); 
		query.append("	,RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	,RT.CURR_CD AS RATE_CURR_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, RT.QTTN_RT_AMT AS  FRT_RT_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, NVL( SCG.POR_CD ,' ') AS POR_CD" ).append("\n"); 
		query.append("	, NVL( SCG.POL_CD ,' ') AS POL_CD" ).append("\n"); 
		query.append("	, NVL( SCG.POD_CD ,' ') AS POD_CD" ).append("\n"); 
		query.append("	, NVL( SCG.DEL_CD ,' ') AS DEL_CD" ).append("\n"); 
		query.append("	, SCG.TOT_SURCHARGE" ).append("\n"); 
		query.append("	, SCG.CRE_YMD " ).append("\n"); 
		query.append("	, SCG.CHG_CD " ).append("\n"); 
		query.append("	, SCG.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("	, SCG.CURR_CD AS SURCHARGE_CURR_CD" ).append("\n"); 
		query.append("	, SCG.TRF_SCG_AMT" ).append("\n"); 
		query.append("	, SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("	, SCG.ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("	,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,A.CRE_DT" ).append("\n"); 
		query.append("	,A.UPD_USR_ID" ).append("\n"); 
		query.append("	,A.UPD_DT" ).append("\n"); 
		query.append("	, DENSE_RANK() OVER (PARTITION BY A.QTTN_NO, A.QTTN_VER_NO ORDER BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ ) AS SEQ" ).append("\n"); 
		query.append("  FROM PRI_RQ_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT QTTN_NO" ).append("\n"); 
		query.append("		      ,QTTN_VER_NO" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD ||  DECODE(RCV_DE_TERM_CD, NULL,'', '(' || TERM_NM || ')' ), ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		  FROM (SELECT QTTN_NO" ).append("\n"); 
		query.append("			      ,QTTN_VER_NO" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("			      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("			  FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("			 WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			   AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY QTTN_NO" ).append("\n"); 
		query.append("			 ,QTTN_VER_NO" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) B" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT QTTN_NO" ).append("\n"); 
		query.append("		      ,QTTN_VER_NO" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		  FROM (SELECT QTTN_NO" ).append("\n"); 
		query.append("			      ,QTTN_VER_NO" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("			 WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			   AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY QTTN_NO" ).append("\n"); 
		query.append("			 ,QTTN_VER_NO" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD	" ).append("\n"); 
		query.append("	) C" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT QTTN_NO" ).append("\n"); 
		query.append("		      ,QTTN_VER_NO" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD  , ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		  FROM (SELECT QTTN_NO" ).append("\n"); 
		query.append("			      ,QTTN_VER_NO" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RQ_RT_ROUT_VIA" ).append("\n"); 
		query.append("			 WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			   AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY QTTN_NO" ).append("\n"); 
		query.append("			 ,QTTN_VER_NO" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) D" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("	      SELECT QTTN_NO" ).append("\n"); 
		query.append("		      ,QTTN_VER_NO" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD ||  DECODE(RCV_DE_TERM_CD, NULL,'', '(' || TERM_NM || ')' ) , ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		  FROM (SELECT QTTN_NO" ).append("\n"); 
		query.append("			      ,QTTN_VER_NO" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("			       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("			  FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("			 WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			   AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY QTTN_NO" ).append("\n"); 
		query.append("			 ,QTTN_VER_NO" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) E" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT QTTN_NO" ).append("\n"); 
		query.append("		      ,QTTN_VER_NO" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("		  FROM (SELECT QTTN_NO" ).append("\n"); 
		query.append("			      ,QTTN_VER_NO" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("				     ,'G'" ).append("\n"); 
		query.append("				     ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("					FROM PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("				       WHERE QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("					 AND QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("					 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)" ).append("\n"); 
		query.append("				     ,'R'" ).append("\n"); 
		query.append("				     ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("					FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("				       WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)" ).append("\n"); 
		query.append("				     ,'C'" ).append("\n"); 
		query.append("				     ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("					FROM MDM_COMMODITY" ).append("\n"); 
		query.append("				       WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ ORDER BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RQ_RT_CMDT A" ).append("\n"); 
		query.append("			 WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			   AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY QTTN_NO" ).append("\n"); 
		query.append("			 ,QTTN_VER_NO" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("		SELECT 	PRI_ROUT.QTTN_NO, PRI_ROUT.QTTN_VER_NO" ).append("\n"); 
		query.append("			, PRI_ROUT.CMDT_HDR_SEQ, PRI_ROUT.ROUT_SEQ, PRI_ROUT.RT_SEQ" ).append("\n"); 
		query.append("			, PRI_ROUT.POR_CD, PRI_ROUT.POL_CD, PRI_ROUT.POD_CD, PRI_ROUT.DEL_CD" ).append("\n"); 
		query.append("			, TO_CHAR(PRI_ROUT.CRE_DT,'YYYY-MM-DD') CRE_YMD " ).append("\n"); 
		query.append("			, PRI_SCG.CHG_CD " ).append("\n"); 
		query.append("			, PRI_SCG.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("			, PRI_SCG.CURR_CD" ).append("\n"); 
		query.append("			, PRI_SCG.TRF_SCG_AMT" ).append("\n"); 
		query.append("			, PRI_SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("			, PRI_SCG.ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("			, SUM( PRI_SCG.ADJ_SCG_USD_AMT ) OVER( PARTITION BY PRI_ROUT.QTTN_NO, PRI_ROUT.QTTN_VER_NO, PRI_ROUT.CMDT_HDR_SEQ, PRI_ROUT.ROUT_SEQ, PRI_ROUT.RT_SEQ ) AS TOT_SURCHARGE" ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_SCG_ROUT PRI_ROUT" ).append("\n"); 
		query.append("			, PRI_RQ_RT_SCG PRI_SCG" ).append("\n"); 
		query.append("		WHERE" ).append("\n"); 
		query.append("			PRI_ROUT.QTTN_NO = PRI_SCG.QTTN_NO" ).append("\n"); 
		query.append("			AND PRI_ROUT.QTTN_VER_NO = PRI_SCG.QTTN_VER_NO" ).append("\n"); 
		query.append("			AND PRI_ROUT.CMDT_HDR_SEQ = PRI_SCG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.ROUT_SEQ = PRI_SCG.ROUT_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.RT_SEQ = PRI_SCG.RT_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("			AND PRI_ROUT.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ) SCG" ).append("\n"); 
		query.append("      , PRI_RQ_RT RT" ).append("\n"); 
		query.append(" WHERE  I.QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("	AND I.QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("	AND I.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.QTTN_NO = RT.QTTN_NO" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = RT.QTTN_VER_NO" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = RT.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND RT.QTTN_NO = SCG.QTTN_NO(+)" ).append("\n"); 
		query.append("	AND RT.QTTN_VER_NO = SCG.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("	AND RT.CMDT_HDR_SEQ = SCG.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND RT.ROUT_SEQ = SCG.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND RT.RT_SEQ = SCG.RT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.QTTN_NO = C.QTTN_NO(+)" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = C.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.QTTN_NO = D.QTTN_NO(+)" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = D.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("	AND A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("	AND A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append(" ORDER BY  A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,I.PRC_CMDT_DEF_NM || A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,B.ROUT_PNT_LOC_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,C.ROUT_VIA_PORT_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,D.ROUT_VIA_PORT_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,E.ROUT_PNT_LOC_DEF_CD  || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,RT.RAT_UT_CD    || RT.RT_SEQ" ).append("\n"); 
		query.append("	,RT.PRC_CGO_TP_CD || RT.RT_SEQ" ).append("\n"); 
		query.append("	,RT.CURR_CD       || RT.RT_SEQ" ).append("\n"); 
		query.append("	, SCG.POR_CD" ).append("\n"); 
		query.append("	, SCG.POL_CD" ).append("\n"); 
		query.append("	, SCG.POD_CD" ).append("\n"); 
		query.append("	, SCG.DEL_CD" ).append("\n"); 
		query.append("	, SCG.CHG_CD" ).append("\n"); 

	}
}