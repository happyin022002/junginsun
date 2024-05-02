/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgApprovalAuthCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgApprovalAuthCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인결과 값을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgApprovalAuthCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgApprovalAuthCdVORSQL").append("\n"); 
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
		query.append("SELECT 	BKG_NO" ).append("\n"); 
		query.append("	,  	CGO_SEQ" ).append("\n"); 
		query.append("	,  	SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,  [spcl_cgo_apro_rqst_seq] AS SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("    --,  [vsl_pre_pst_cd] AS VSL_PRE_PST_CD" ).append("\n"); 
		query.append("    --,  [vsl_seq] AS VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	,	VSL_PRE_PST_CD" ).append("\n"); 
		query.append("	,	VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,  	DECODE(SPCL_CGO_APRO_RQST_SEQ,@[spcl_cgo_apro_rqst_seq],'Y','N')	AS UPD_FLG " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 	A.BKG_NO" ).append("\n"); 
		query.append("		,  	A.CGO_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		----,  DECODE(A.VSL_PRE_PST_CD,'U',DECODE(G.SPCL_CGO_AUTH_CD,'N','N','Y','Y','R'),NVL(G.SPCL_CGO_AUTH_CD,'R')) AS SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("		,  	DECODE(A.VSL_PRE_PST_CD,'U',DECODE(G.SPCL_CGO_AUTH_CD,'N','N','Y','Y','P','P','R'),NVL(G.SPCL_CGO_AUTH_CD,'R')) AS SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,  	A.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	A.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("		,	A.VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT 	B.BKG_NO" ).append("\n"); 
		query.append("			,  	B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("			,  	B.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("	        ,  	B.VSL_SEQ" ).append("\n"); 
		query.append("			,	A.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2') " ).append("\n"); 
		query.append("			, 	C.DCGO_SEQ 					AS CGO_SEQ" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'AWK' || ${scg_flg} == '45')" ).append("\n"); 
		query.append("			, 	C.AWK_CGO_SEQ 				AS CGO_SEQ" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'BB') " ).append("\n"); 
		query.append("			, 	C.BB_CGO_SEQ 				AS CGO_SEQ" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'RF') " ).append("\n"); 
		query.append("			, 	C.RC_SEQ 					AS CGO_SEQ" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${scg_flg} == 'SS') " ).append("\n"); 
		query.append("			, 	C.STWG_SEQ 					AS CGO_SEQ " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		FROM 	SCG_APRO_RQST 				A" ).append("\n"); 
		query.append("			,	SCG_VVD_APRO_RQST 			B" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2') " ).append("\n"); 
		query.append("			,	BKG_DG_CGO 					C" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'AWK' || ${scg_flg} == '45')" ).append("\n"); 
		query.append("			,	BKG_AWK_CGO 				C" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'BB') " ).append("\n"); 
		query.append("			,	BKG_BB_CGO 					C" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'RF') " ).append("\n"); 
		query.append("			,	BKG_RF_CGO 					C" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'SS')" ).append("\n"); 
		query.append("			,	BKG_STWG_CGO 				C" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		WHERE 	A.BKG_NO 					= B.BKG_NO" ).append("\n"); 
		query.append("		AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= B.SPCL_CGO_APRO_RQST_SEQ          " ).append("\n"); 
		query.append("		#if (${scg_flg} != '') " ).append("\n"); 
		query.append("		AND   	B.BKG_NO 					= C.BKG_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND   	A.LST_RQST_DAT_FLG 			= 'Y'" ).append("\n"); 
		query.append("		AND   	A.BKG_NO 					= @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2') " ).append("\n"); 
		query.append("		AND   	A.SPCL_CGO_CATE_CD 			= 'DG'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'AWK' || ${scg_flg} == '45')" ).append("\n"); 
		query.append("		AND	  	A.SPCL_CGO_CATE_CD 			= 'AK'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'BB') " ).append("\n"); 
		query.append("		AND	  	A.SPCL_CGO_CATE_CD 			= 'BB'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'RF') " ).append("\n"); 
		query.append("		AND	  	A.SPCL_CGO_CATE_CD 			= 'RF'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'SS') " ).append("\n"); 
		query.append("		AND	  	A.SPCL_CGO_CATE_CD 			= 'SS'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("		#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2') " ).append("\n"); 
		query.append("		AND   	C.DCGO_SEQ 					= @[dcgo_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'AWK' || ${scg_flg} == '45')" ).append("\n"); 
		query.append("		AND	  	C.AWK_CGO_SEQ 				= @[awk_cgo_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'BB') " ).append("\n"); 
		query.append("		AND	  	C.BB_CGO_SEQ 				= @[bb_cgo_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'RF') " ).append("\n"); 
		query.append("		AND	  	C.RC_SEQ 					= @[rc_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${scg_flg} == 'SS') " ).append("\n"); 
		query.append("		AND	  	C.STWG_SEQ 					= @[stwg_cgo_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) 									A" ).append("\n"); 
		query.append("		, SCG_AUTHORIZATION 				G" ).append("\n"); 
		query.append("	WHERE A.BKG_NO 							= G.BKG_NO					(+)" ).append("\n"); 
		query.append("	AND   A.SPCL_CGO_CATE_CD 				= G.SPCL_CGO_CATE_CD 		(+)" ).append("\n"); 
		query.append("	AND   A.SPCL_CGO_APRO_RQST_SEQ 			= G.SPCL_CGO_APRO_RQST_SEQ	(+)" ).append("\n"); 
		query.append("	AND   A.VSL_PRE_PST_CD 					= G.VSL_PRE_PST_CD			(+)" ).append("\n"); 
		query.append("	AND   A.VSL_SEQ 						= G.VSL_SEQ					(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2') " ).append("\n"); 
		query.append("	AND   A.CGO_SEQ 						= G.DCGO_SEQ				(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'AWK' || ${scg_flg} == '45')" ).append("\n"); 
		query.append("	AND	  A.CGO_SEQ 						= G.AWK_CGO_SEQ				(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'BB') " ).append("\n"); 
		query.append("	AND	  A.CGO_SEQ 						= G.BB_CGO_SEQ				(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'RF') " ).append("\n"); 
		query.append("	AND	  A.CGO_SEQ 						= G.RC_SEQ					(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${scg_flg} == 'SS') " ).append("\n"); 
		query.append("	AND	  A.CGO_SEQ 						= G.STWG_CGO_SEQ			(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-05-06::--ORDER BY DECODE(A.VSL_PRE_PST_CD,'U',DECODE(G.SPCL_CGO_AUTH_CD,'N','N','Y','Y','R'),NVL(G.SPCL_CGO_AUTH_CD,'R'))" ).append("\n"); 
		query.append("    --::2015-05-24::--ORDER BY DECODE(A.VSL_PRE_PST_CD,'U',DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',200,'N',1,'Y',200,'P',200),DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',120,'N',1,'Y',100,'P',110)) ASC" ).append("\n"); 
		query.append("	ORDER BY	CASE	WHEN A.SPCL_CGO_CATE_CD = 'SS' THEN 999" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							CASE WHEN A.VSL_PRE_PST_CD = 'U' THEN DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',200,'N',1,'Y',200,'P',200)" ).append("\n"); 
		query.append("--								 ELSE DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',99,'N',1,'Y',100,'P',110)" ).append("\n"); 
		query.append("								 ELSE DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',99,'P',2,'N',1,'Y',100)" ).append("\n"); 
		query.append("							END		" ).append("\n"); 
		query.append("			 	END		ASC" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE ROWNUM < 2" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}