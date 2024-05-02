/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchScNoteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchScNoteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C 계약의 Note 정보를 조회함
	  * </pre>
	  */
	public BlRatingDBDAOSearchScNoteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchScNoteRSQL").append("\n"); 
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
		query.append("#if(${note_chg_tp_cd} =='O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/* OFT NOTE ROUTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Route Note' TYPE," ).append("\n"); 
		query.append("	A.CMDT_HDR_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	'' TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_CMDT_RNOTE A /* ROUTE NOTE 인데 CMDT 로 왜 시작하나(?) */" ).append("\n"); 
		query.append("	                                /* ROUTE에 대한 NOTE 관리 */" ).append("\n"); 
		query.append("	                                /* SPECIAL RATE 사용 */" ).append("\n"); 
		query.append("	                                /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                                /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='O'" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	#if(${rout_seq} !='')" ).append("\n"); 
		query.append("		AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	/* OFT CMDT NOTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Commodity Note' TYPE," ).append("\n"); 
		query.append("	A.CMDT_HDR_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	'' TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_CNOTE A      /* COMMODITY에 대한 NOTE 관리 */" ).append("\n"); 
		query.append("	                                /* SPECIAL RATE 사용 */" ).append("\n"); 
		query.append("	                                /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                                /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='O'" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/* OFT NOTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Special Note' TYPE," ).append("\n"); 
		query.append("	A.NOTE_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	C.NOTE_TIT_NM TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_NOTE C      /* 계약서에 출력하는 계약조항의 내용을 관리 */" ).append("\n"); 
		query.append("	                            /* PRI_SP_SCP_NOTE 가 MASTER, PRI_SP_SCP_NOTE_CTNT 가 DETAIL 관계 */" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_NOTE_CTNT A     /* STANDARD NOTE 와 SPECIAL NOTE 테이블 */" ).append("\n"); 
		query.append("	                            /* 1. SPECIAL NOTE 만 사용 함 */" ).append("\n"); 
		query.append("	                            /* 2. NOTE SEQ 와 ROWNUM 을 조합 하여 SEQ 생성 DP SEQ는 ORDER BY 용 */" ).append("\n"); 
		query.append("	                            /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                            /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	                            " ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("	AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("	AND C.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("	AND C.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.NOTE_TP_CD ='P' /* SPECIAL NOTE 사용 */" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='O' /* OFT FREIGHT */" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${note_chg_tp_cd} =='S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/* OFT NOTE ROUTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Route Note' TYPE," ).append("\n"); 
		query.append("	A.CMDT_HDR_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	'' TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_CMDT_RNOTE A /* ROUTE NOTE 인데 CMDT 로 왜 시작하나(?) */" ).append("\n"); 
		query.append("	                                /* ROUTE에 대한 NOTE 관리 */" ).append("\n"); 
		query.append("	                                /* SPECIAL RATE 사용 */" ).append("\n"); 
		query.append("	                                /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                                /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='S'" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	/* OFT CMDT NOTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Commodity Note' TYPE," ).append("\n"); 
		query.append("	A.CMDT_HDR_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	'' TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_RT_CNOTE A      /* COMMODITY에 대한 NOTE 관리 */" ).append("\n"); 
		query.append("	                                /* SPECIAL RATE 사용 */" ).append("\n"); 
		query.append("	                                /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                                /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='S'" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/* OFT NOTE */" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	'Special Note' TYPE," ).append("\n"); 
		query.append("	A.NOTE_SEQ||'.'||ROWNUM SEQ," ).append("\n"); 
		query.append("	C.NOTE_TIT_NM TITLE," ).append("\n"); 
		query.append("	REPLACE(A.NOTE_CTNT,CHR(10),' ') CONTENT," ).append("\n"); 
		query.append("	TO_CHAR(K.EFF_DT,'YYYY-MM-DD') EFFECT_DT, /* N1ST_CMNC_AMDT_SEQ 로 따로 구함 */" ).append("\n"); 
		query.append("	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("	FROM PRI_SP_SCP_NOTE C      /* 계약서에 출력하는 계약조항의 내용을 관리 */" ).append("\n"); 
		query.append("	                            /* PRI_SP_SCP_NOTE 가 MASTER, PRI_SP_SCP_NOTE_CTNT 가 DETAIL 관계 */" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,PRI_SP_SCP_NOTE_CTNT A     /* STANDARD NOTE 와 SPECIAL NOTE 테이블 */" ).append("\n"); 
		query.append("	                            /* 1. SPECIAL NOTE 만 사용 함 */" ).append("\n"); 
		query.append("	                            /* 2. NOTE SEQ 와 ROWNUM 을 조합 하여 SEQ 생성 DP SEQ는 ORDER BY 용 */" ).append("\n"); 
		query.append("	                            /* 3. NOTE_CHG_TP_CD 로 OFT,SURCHARGE 구분 */" ).append("\n"); 
		query.append("	                            /* JAVA 에서 NOTE_CHG_TP_CD 에 따라 쿼리 분기하여 데이터 가져오록 작성 함 */ " ).append("\n"); 
		query.append("	                            " ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN B            /* S/C 계약을 위한 PROPOSAL의 MAIN TABLE */                             " ).append("\n"); 
		query.append("	                            /* 1. PROP_NO, AMDT_SEQ, SVC_SCP_CD 조인 함 */" ).append("\n"); 
		query.append("	                            /* 2. EFF_DT 는 AMDT_SEQ 와  PRI_SP_SCP_NOTE_CTNT 에서 N1ST_CMNC_AMDT_SEQ 로 조인해서 가져옴 */" ).append("\n"); 
		query.append("	,PRI_SP_SCP_MN K   			/* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("	AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("	AND C.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("	AND C.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("	AND A.N1ST_CMNC_AMDT_SEQ = K.AMDT_SEQ /* EFFECT_DT 용 */ " ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = K.SVC_SCP_CD	AND A.NOTE_TP_CD ='P' /* SPECIAL NOTE 사용 */" ).append("\n"); 
		query.append("	AND A.NOTE_CHG_TP_CD ='S' /* SURCHARGE */" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}