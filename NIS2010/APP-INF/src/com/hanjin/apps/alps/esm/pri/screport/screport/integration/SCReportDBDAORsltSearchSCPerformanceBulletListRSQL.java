/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceBulletListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.06 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerformanceBulletListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc performance bullet list
	  * * 2015.04.06 송호진 [CHM-201534007] Rate Search & PFMC Summary - Detail 의 Actual Customer ComboList 조회시 4000 Byte Over 문제 해결
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceBulletListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceBulletListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("CH AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	CH.PROP_NO			 ," ).append("\n"); 
		query.append("		CH.AMDT_SEQ			 ," ).append("\n"); 
		query.append("		CH.SVC_SCP_CD		 ," ).append("\n"); 
		query.append("		CH.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("		CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_SCP_MN			SS ," ).append("\n"); 
		query.append("		PRI_SP_SCP_RT_CMDT_HDR	CH" ).append("\n"); 
		query.append("WHERE	CH.PROP_NO		= SS.PROP_NO" ).append("\n"); 
		query.append("AND		CH.AMDT_SEQ		= SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CH.SVC_SCP_CD	= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		SS.PROP_NO		=	( SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = @[sc_no] )" ).append("\n"); 
		query.append("--AND		SS.AMDT_SEQ    	<=	(" ).append("\n"); 
		query.append("AND		SS.AMDT_SEQ    	=	(" ).append("\n"); 
		query.append("							SELECT	MAX(A.AMDT_SEQ)		-- 최신 AMDT_SEQ 이전의 모든 AMDT_SEQ 를 대상으로 함 " ).append("\n"); 
		query.append("							FROM		PRI_SP_MN	A" ).append("\n"); 
		query.append("							WHERE		A.PROP_NO	  = CH.PROP_NO" ).append("\n"); 
		query.append("							AND			A.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("AND		SS.SVC_SCP_CD		 = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND		CH.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("--AND		SS.EFF_DT <= TO_DATE('20091231', 'YYYYMMDD')	-- Effective Date(To)-- 이 부분은 UI_PRI_0060 번 에서 사용된다.  UI_PRI_0108_02 에서는 INPUT 없음" ).append("\n"); 
		query.append("--AND		SS.EXP_DT >= TO_DATE('20090101', 'YYYYMMDD')	-- Effective Date(From)-- 이 부분은 UI_PRI_0060 번 에서 사용된다.  UI_PRI_0108_02 에서는 INPUT 없음" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("BU AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	CH.PROP_NO			 ," ).append("\n"); 
		query.append("		CH.AMDT_SEQ			 ," ).append("\n"); 
		query.append("		CH.SVC_SCP_CD		 ," ).append("\n"); 
		query.append("		CH.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("		CH.CMDT_HDR_SEQ		 ," ).append("\n"); 
		query.append("		RC.CMDT_NM			 ," ).append("\n"); 
		query.append("		RC.PRC_CMDT_DEF_CD	 ," ).append("\n"); 
		query.append("		NVL(REPLACE(AC.ACT_CUST_NM, '@@@', ' / '), 'N/A')	ACT_CUST_NM	," ).append("\n"); 
		query.append("		NVL(AC.ACT_CUST_CD, 'N/A')	ACT_CUST_CD" ).append("\n"); 
		query.append("FROM	CH		," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT	PROP_NO				," ).append("\n"); 
		query.append("				AMDT_SEQ			," ).append("\n"); 
		query.append("				SVC_SCP_CD			," ).append("\n"); 
		query.append("				GEN_SPCL_RT_TP_CD	," ).append("\n"); 
		query.append("				CMDT_HDR_SEQ		," ).append("\n"); 
		query.append("				LTRIM(SYS_CONNECT_BY_PATH(CMDT_NM,' / '),' / ') AS CMDT_NM	," ).append("\n"); 
		query.append("				LTRIM(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD,' / '),' / ') AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	/*+ ORDERED */" ).append("\n"); 
		query.append("						CH.PROP_NO				," ).append("\n"); 
		query.append("						CH.AMDT_SEQ				," ).append("\n"); 
		query.append("						CH.SVC_SCP_CD			," ).append("\n"); 
		query.append("						CH.GEN_SPCL_RT_TP_CD	," ).append("\n"); 
		query.append("						CH.CMDT_HDR_SEQ			," ).append("\n"); 
		query.append("						ROW_NUMBER() OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ORDER BY RC.CMDT_SEQ ) ROW_NUMBER	," ).append("\n"); 
		query.append("						COUNT(1) OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ) CNT	," ).append("\n"); 
		query.append("						RC.PRC_CMDT_DEF_CD		," ).append("\n"); 
		query.append("						DECODE(RC.PRC_CMDT_TP_CD, 'C', MC.CMDT_NM, 'G', GC.PRC_GRP_CMDT_DESC) CMDT_NM" ).append("\n"); 
		query.append("				FROM	CH						," ).append("\n"); 
		query.append("						PRI_SP_SCP_RT_CMDT	RC	," ).append("\n"); 
		query.append("						MDM_COMMODITY		MC	," ).append("\n"); 
		query.append("						PRI_SP_SCP_GRP_CMDT	GC" ).append("\n"); 
		query.append("				WHERE	MC.CMDT_CD(+)		  = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("				AND		GC.PROP_NO(+)		  = RC.PROP_NO" ).append("\n"); 
		query.append("				AND		GC.AMDT_SEQ(+)		  = RC.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		GC.SVC_SCP_CD(+)	  = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		GC.PRC_GRP_CMDT_CD(+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("				AND		RC.PROP_NO			  = CH.PROP_NO" ).append("\n"); 
		query.append("				AND		RC.AMDT_SEQ			  = CH.AMDT_SEQ" ).append("\n"); 
		query.append("				AND		RC.SVC_SCP_CD		  = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		RC.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("				AND		RC.CMDT_HDR_SEQ		  = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		WHERE	LEVEL	              = CNT" ).append("\n"); 
		query.append("				START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("				CONNECT BY" ).append("\n"); 
		query.append("						PROP_NO 		  = PRIOR PROP_NO" ).append("\n"); 
		query.append("				AND		AMDT_SEQ	      = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("				AND		SVC_SCP_CD		  = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("				AND		CMDT_HDR_SEQ	  = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				AND		ROW_NUMBER		  = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("				)	RC	," ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT	PROP_NO			  ," ).append("\n"); 
		query.append("						AMDT_SEQ		  ," ).append("\n"); 
		query.append("						SVC_SCP_CD		  ," ).append("\n"); 
		query.append("						GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("						CMDT_HDR_SEQ	  ," ).append("\n"); 
		query.append("						ACT_CUST_CD		  ," ).append("\n"); 
		query.append("						REGEXP_REPLACE(LTRIM(SYS_CONNECT_BY_PATH(CASE WHEN TL < 4000 THEN ACT_CUST_NM ELSE '' END,'@@@'),'@@@'), '(@@@){2,}', '...' ) ACT_CUST_NM" ).append("\n"); 
		query.append("						-- LTRIM(SYS_CONNECT_BY_PATH(ACT_CUST_NM,'^|^'),'^|^') ACT_CUST_NM" ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						 SELECT	/*+ ORDERED */" ).append("\n"); 
		query.append("						 		CH.PROP_NO			 ," ).append("\n"); 
		query.append("						 		CH.AMDT_SEQ			 ," ).append("\n"); 
		query.append("						 		CH.SVC_SCP_CD		 ," ).append("\n"); 
		query.append("						 		CH.GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("						 		CH.CMDT_HDR_SEQ		 ," ).append("\n"); 
		query.append("						 		ROW_NUMBER() OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ORDER BY AC.ACT_CUST_SEQ ) ROW_NUMBER	," ).append("\n"); 
		query.append("						 		COUNT(1) OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ) CNT	," ).append("\n"); 
		query.append("						 		AC.CUST_CNT_CD||LPAD(AC.CUST_SEQ, 6, '0') ACT_CUST_CD	," ).append("\n"); 
		query.append("                        		SUM(LENGTH(MC.CUST_LGL_ENG_NM)+3) OVER (  PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ORDER BY AC.ACT_CUST_SEQ ) AS TL," ).append("\n"); 
		query.append("						 		MC.CUST_LGL_ENG_NM	ACT_CUST_NM" ).append("\n"); 
		query.append("						 FROM	CH						   ," ).append("\n"); 
		query.append("						 		PRI_SP_SCP_RT_ACT_CUST	AC ," ).append("\n"); 
		query.append("						 		MDM_CUSTOMER			MC" ).append("\n"); 
		query.append("						 WHERE	MC.CUST_CNT_CD(+)	 = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("						 AND	MC.CUST_SEQ(+)		 = AC.CUST_SEQ" ).append("\n"); 
		query.append("                         AND    MC.CNTR_DIV_FLG      = 'Y'" ).append("\n"); 
		query.append("						 AND	AC.PROP_NO			 = CH.PROP_NO" ).append("\n"); 
		query.append("						 AND	AC.AMDT_SEQ			 = CH.AMDT_SEQ" ).append("\n"); 
		query.append("						 AND	AC.SVC_SCP_CD		 = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("						 AND	AC.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("						 AND	AC.CMDT_HDR_SEQ		 = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				        )" ).append("\n"); 
		query.append("				WHERE LEVEL	  = CNT" ).append("\n"); 
		query.append("				START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("				CONNECT BY" ).append("\n"); 
		query.append("						PROP_NO 		  = PRIOR PROP_NO" ).append("\n"); 
		query.append("				AND		AMDT_SEQ		  = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("				AND		SVC_SCP_CD		  = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("				AND		GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("				AND		CMDT_HDR_SEQ	  = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("				AND		ROW_NUMBER		  = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("				)	AC" ).append("\n"); 
		query.append("WHERE	RC.PROP_NO(+)			= CH.PROP_NO" ).append("\n"); 
		query.append("AND		RC.AMDT_SEQ(+)			= CH.AMDT_SEQ" ).append("\n"); 
		query.append("AND		RC.SVC_SCP_CD(+)		= CH.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		RC.GEN_SPCL_RT_TP_CD(+)	= CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		RC.CMDT_HDR_SEQ(+)		= CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND		AC.PROP_NO(+)			= CH.PROP_NO" ).append("\n"); 
		query.append("AND		AC.AMDT_SEQ(+)			= CH.AMDT_SEQ" ).append("\n"); 
		query.append("AND		AC.SVC_SCP_CD(+)		= CH.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		AC.GEN_SPCL_RT_TP_CD(+)	= CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND		AC.CMDT_HDR_SEQ(+)		= CH.CMDT_HDR_SEQ				" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	CMDT_HDR_SEQ ," ).append("\n"); 
		query.append("		CMDT_NM		 ," ).append("\n"); 
		query.append("		ACT_CUST_NM  ," ).append("\n"); 
		query.append("	    '' AS SC_NO  , -- param" ).append("\n"); 
		query.append("		SVC_SCP_CD	 , -- param" ).append("\n"); 
		query.append("        GEN_SPCL_RT_TP_CD -- param" ).append("\n"); 
		query.append("FROM	BU	A" ).append("\n"); 
		query.append("WHERE	NOT EXISTS	(" ).append("\n"); 
		query.append("					SELECT	'X'" ).append("\n"); 
		query.append("					FROM	BU	B" ).append("\n"); 
		query.append("					WHERE	B.PROP_NO			= A.PROP_NO" ).append("\n"); 
		query.append("					AND		B.AMDT_SEQ			> A.AMDT_SEQ" ).append("\n"); 
		query.append("					AND		B.SVC_SCP_CD		= A.SVC_SCP_CD" ).append("\n"); 
		query.append("					AND		B.GEN_SPCL_RT_TP_CD	= A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("					AND		B.PRC_CMDT_DEF_CD	= A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					AND		B.ACT_CUST_CD		= A.ACT_CUST_CD" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		AMDT_SEQ DESC ," ).append("\n"); 
		query.append("		CMDT_HDR_SEQ" ).append("\n"); 

	}
}