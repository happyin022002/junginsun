/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EdiTransmitHistoryDBDAOSearchTrsmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiTransmitHistoryDBDAOSearchTrsmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EdiTransmitHistoryDBDAOSearchTrsmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration").append("\n"); 
		query.append("FileName : EdiTransmitHistoryDBDAOSearchTrsmListRSQL").append("\n"); 
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
		query.append("SELECT 		CASE 	WHEN EDI_MSG_STS_CD 	= 'R' 		THEN ''" ).append("\n"); 
		query.append("				 	ELSE NVL2(EDI_UNMAP_KND_CD,'1','0')" ).append("\n"); 
		query.append("			END		AS EDI_UNMAP_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,  	CASE 	WHEN EDI_MSG_STS_CD 	= 'R'		THEN ''" ).append("\n"); 
		query.append("					WHEN EDI_UNMAP_KND_CD 	IS NOT NULL AND EDI_UNMAP_CORR_KNT > 0 THEN 'Y'" ).append("\n"); 
		query.append("					ELSE ''" ).append("\n"); 
		query.append("		   	END		AS EDI_UNMAP_CORR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	EDI_UNMAP_KND_CD" ).append("\n"); 
		query.append("		,	CRR_CD" ).append("\n"); 
		query.append("		,	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("		, 	SLAN_CD" ).append("\n"); 
		query.append("		, 	BKG_REF_NO" ).append("\n"); 
		query.append("        ,   PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("		,	OUT_BND_CSSM_VOY_NO				AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("		,	CALL_SGN_NO" ).append("\n"); 
		query.append("		,	LLOYD_NO" ).append("\n"); 
		query.append("		,	CASE	WHEN CALL_SGN_NO IS NOT NULL AND LLOYD_NO IS NOT NULL THEN CALL_SGN_NO || '/' || LLOYD_NO" ).append("\n"); 
		query.append("					WHEN CALL_SGN_NO IS NULL     AND LLOYD_NO IS NULL     THEN ''" ).append("\n"); 
		query.append("					ELSE CALL_SGN_NO || LLOYD_NO" ).append("\n"); 
		query.append("			END		AS CALL_SIGN_LLOYD" ).append("\n"); 
		query.append("		, 	POL_CD" ).append("\n"); 
		query.append("		, 	ETA_DT" ).append("\n"); 
		query.append("		, 	POD_CD" ).append("\n"); 
		query.append("		, 	VSL_CD" ).append("\n"); 
		query.append("		, 	SKD_VOY_NO" ).append("\n"); 
		query.append("		, 	SKD_DIR_CD" ).append("\n"); 
		query.append("		, 	EDI_MSG_STS_CD" ).append("\n"); 
		query.append("		, 	ERR_KND_CD" ).append("\n"); 
		query.append("		, 	CGO_OPR_CD" ).append("\n"); 
		query.append("		, 	TRAN_IF_DATE" ).append("\n"); 
		query.append("		, 	METHOD" ).append("\n"); 
		query.append("		, 	MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("		, 	ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("		, 	ARK_IF_DATE" ).append("\n"); 
		query.append("		, 	MSG_RJCT_RSN" ).append("\n"); 
		query.append("		, 	TRSM_STS_CD" ).append("\n"); 
		query.append("		, 	ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,	CASE 	WHEN EDI_MSG_STS_CD = 'R' AND ERR_KND_CD   <> 'O'				THEN ''" ).append("\n"); 
		query.append("					WHEN EDI_MSG_STS_CD = 'R' AND RQST_CGO_KNT =  RQST_CXL_CGO_KNT  THEN 'Canceled'||' ['||RQST_CXL_CGO_KNT||']'" ).append("\n"); 
		query.append("    				WHEN EDI_MSG_STS_CD = 'R' AND RQST_CGO_KNT <> RQST_CXL_CGO_KNT  THEN 'Abnormal CXL'" ).append("\n"); 
		query.append("					WHEN RQST_CGO_KNT 	=  0			  							THEN 'Not Created'" ).append("\n"); 
		query.append("					WHEN RQST_CGO_KNT 	=  TRSM_DTL_CNT 							THEN 'Success'||' ['||RQST_CGO_KNT||']'" ).append("\n"); 
		query.append("			     	WHEN RQST_CGO_KNT 	<> TRSM_DTL_CNT 							THEN 'Diff CGO'||' ['||TRSM_DTL_CNT||' vs '||RQST_CGO_KNT||']'" ).append("\n"); 
		query.append("					ELSE ''" ).append("\n"); 
		query.append("			END		AS CGO_CREATE_STS_CD" ).append("\n"); 
		query.append("   FROM 	(" ).append("\n"); 
		query.append("			SELECT 		--A.EDI_UNMAP_KND_CD" ).append("\n"); 
		query.append("						CASE 		WHEN (T1.EDI_UNMAP_DTL_CD IS NOT NULL OR T2.EDI_UNMAP_DTL_CD IS NOT NULL OR T3.EDI_UNMAP_DTL_CD IS NOT NULL) AND A.ERR_KND_CD = 'O' THEN 'EDI_UNMAP'" ).append("\n"); 
		query.append("									ELSE ''" ).append("\n"); 
		query.append("						END			EDI_UNMAP_KND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    				, 	(SELECT   	COUNT(1)" ).append("\n"); 
		query.append("       					 FROM     	SCG_PRNR_APRO_RQST_CGO  Y" ).append("\n"); 
		query.append("       					 WHERE    	Y.CRR_CD                = RQ.CRR_CD" ).append("\n"); 
		query.append("       					 AND      	Y.BKG_REF_NO            = RQ.BKG_REF_NO" ).append("\n"); 
		query.append("       					 AND      	Y.PRNR_CGO_RQST_SEQ     = RQ.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("       					 AND      	Y.SPCL_CGO_RQST_SEQ     = RQ.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("       					 AND      	Y.AUTH_STS_CD           IS NOT NULL" ).append("\n"); 
		query.append("       					)        	AS EDI_UNMAP_CORR_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					--:2016-05-13:--,	C.CRR_CD" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					,	NVL(A.MAPG_CRR_CD,SUBSTR(A.EDI_RCVR_ID,1,3))	AS CRR_CD" ).append("\n"); 
		query.append("					,	A.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("		     		, 	A.SLAN_CD" ).append("\n"); 
		query.append("		     		, 	A.BKG_REF_NO" ).append("\n"); 
		query.append("                    ,   A.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("					,	A.OUT_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("					,	A.CALL_SGN_NO" ).append("\n"); 
		query.append("					,	A.LLOYD_NO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("		     		, 	A.POL_CD" ).append("\n"); 
		query.append("		     		, 	(	SELECT 	TO_CHAR(PS.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("		          			FROM 	VSK_VSL_PORT_SKD 	PS" ).append("\n"); 
		query.append("		         			WHERE 	PS.VSL_CD       	= A.VSL_CD" ).append("\n"); 
		query.append("		           			AND 	PS.SKD_VOY_NO   	= A.SKD_VOY_NO" ).append("\n"); 
		query.append("		           			AND 	PS.SKD_DIR_CD   	= A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    		AND 	PS.VPS_PORT_CD      = A.POL_CD" ).append("\n"); 
		query.append("		           			--:2015-07-20:--AND 	PS.CLPT_IND_SEQ 	= NVL(RQ.POL_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("							--:2015-07-22:--AND 	PS.CLPT_IND_SEQ 	= NVL(A.POL_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("							AND 	PS.CLPT_IND_SEQ 	= A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        		) ETA_DT" ).append("\n"); 
		query.append("		     		, 	A.POD_CD" ).append("\n"); 
		query.append("		     		, 	A.VSL_CD" ).append("\n"); 
		query.append("		     		, 	A.SKD_VOY_NO" ).append("\n"); 
		query.append("		     		, 	A.SKD_DIR_CD" ).append("\n"); 
		query.append("		     		, 	A.EDI_MSG_STS_CD" ).append("\n"); 
		query.append("		     		, 	A.ERR_KND_CD" ).append("\n"); 
		query.append("		     		, 	A.CGO_OPR_CD" ).append("\n"); 
		query.append("		     		, 	A.UPD_DT 					AS TRAN_IF_DATE" ).append("\n"); 
		query.append("		     		, 	'EDI' 						AS METHOD" ).append("\n"); 
		query.append("		     		, 	B.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("		     		, 	B.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("		     		, 	B.UPD_DT 					AS ARK_IF_DATE" ).append("\n"); 
		query.append("		     		, 	B.MSG_RJCT_RSN     " ).append("\n"); 
		query.append("		     		, 	B.TRSM_STS_CD" ).append("\n"); 
		query.append("		     		, 	DECODE(A.TRSM_BND_CD, 'I', B.ORG_MSG_KEY_NO, A.EDI_IF_ID) ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             		--, ROW_NUMBER() OVER(PARTITION BY ORG_MSG_KEY_NO ORDER BY B.UPD_DT DESC) NUM" ).append("\n"); 
		query.append("					,	ROW_NUMBER() OVER(PARTITION BY A.BKG_REF_NO,A.CGO_OPR_CD,A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.POL_CD /*,A.POD_CD*/ ORDER BY A.PRNR_SPCL_CGO_SEQ DESC) LATEST_ORDER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        			,	(SELECT COUNT(1) " ).append("\n"); 
		query.append("         				 FROM   SCG_PRNR_APRO_RQST_CGO YY " ).append("\n"); 
		query.append("         				 WHERE  YY.CRR_CD              = RQ.CRR_CD" ).append("\n"); 
		query.append("         				 AND    YY.BKG_REF_NO          = RQ.BKG_REF_NO" ).append("\n"); 
		query.append("         				 AND    YY.SPCL_CGO_RQST_SEQ   = RQ.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("         				 AND    YY.PRNR_CGO_RQST_SEQ   = RQ.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("        				)       AS RQST_CGO_KNT	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     				,  " ).append("\n"); 
		query.append("        				(SELECT COUNT(1)" ).append("\n"); 
		query.append("         				 FROM   SCG_PRNR_SPCL_CGO_TRSM_DTL  D" ).append("\n"); 
		query.append("         				 WHERE  D.TRSM_BND_CD               = RQ.MAPG_TRSM_BND_CD" ).append("\n"); 
		query.append("         				 AND    D.TRSM_DT                   = RQ.MAPG_TRSM_DT" ).append("\n"); 
		query.append("         				 AND    D.SPCL_CGO_CATE_CD          = RQ.MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("         				 AND    D.PRNR_SPCL_CGO_SEQ         = RQ.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("        				)		AS TRSM_DTL_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              		,  (	SELECT 	COUNT(1) " ).append("\n"); 
		query.append("                  			FROM   	SCG_PRNR_APRO_RQST_CGO YY " ).append("\n"); 
		query.append("                  			WHERE  	YY.CRR_CD              = RQ.CRR_CD" ).append("\n"); 
		query.append("                  			AND    	YY.BKG_REF_NO          = RQ.BKG_REF_NO" ).append("\n"); 
		query.append("                  			AND    	YY.SPCL_CGO_RQST_SEQ   = RQ.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  			AND    	YY.PRNR_CGO_RQST_SEQ   = RQ.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  			AND    	YY.AUTH_STS_CD         = 'C'" ).append("\n"); 
		query.append("                		)       	AS RQST_CXL_CGO_KNT " ).append("\n"); 
		query.append("		  	FROM 		SCG_PRNR_SPCL_CGO_TRSM_HDR 					A" ).append("\n"); 
		query.append("		     		----, 	SCG_PRNR_SPCL_CGO_TRSM_ACK 					B" ).append("\n"); 
		query.append("             			, (" ).append("\n"); 
		query.append("                			SELECT    AK.TRSM_BND_CD" ).append("\n"); 
		query.append("                        			, AK.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                        			, AK.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                        			, AK.ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("                        			, AK.TRSM_STS_CD" ).append("\n"); 
		query.append("                        			, AK.MSG_RJCT_RSN" ).append("\n"); 
		query.append("                        			, AK.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("                        			, AK.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("                        			, MAX(AK.UPD_DT)             AS UPD_DT" ).append("\n"); 
		query.append("                			FROM      SCG_PRNR_SPCL_CGO_TRSM_ACK AK" ).append("\n"); 
		query.append("                			GROUP BY  AK.TRSM_BND_CD" ).append("\n"); 
		query.append("                        			, AK.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                        			, AK.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                        			, AK.ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("                        			, AK.TRSM_STS_CD" ).append("\n"); 
		query.append("                        			, AK.MSG_RJCT_RSN" ).append("\n"); 
		query.append("                        			, AK.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("                        			, AK.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("               			)   " ).append("\n"); 
		query.append("										B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		     		--:2016-05-13:--, 	MDM_VSL_CNTR 				C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             		,   SCG_PRNR_APRO_RQST         					RQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 	-------------------------------------" ).append("\n"); 
		query.append("                 	,   (SELECT   	T1.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,  	T1.TRSM_DT" ).append("\n"); 
		query.append("                            	,  	T1.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,  	T1.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                            	,  	MIN(T1.EDI_UNMAP_DTL_CD) 		AS EDI_UNMAP_DTL_CD               " ).append("\n"); 
		query.append("                      	FROM     	SCG_PRNR_TRSM_HDR_UNMAP 		T1" ).append("\n"); 
		query.append("                      	GROUP BY 	T1.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,  	T1.TRSM_DT" ).append("\n"); 
		query.append("                            	,  	T1.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,  	T1.PRNR_SPCL_CGO_SEQ " ).append("\n"); 
		query.append("                      	)                         					T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 	,   (SELECT   	T2.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,  	T2.TRSM_DT" ).append("\n"); 
		query.append("                            	,  	T2.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,  	T2.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                            	,  	MIN(T2.EDI_UNMAP_DTL_CD) 		AS EDI_UNMAP_DTL_CD               " ).append("\n"); 
		query.append("                      	FROM     	SCG_PRNR_CNTR_LOG_UNMAP 		T2" ).append("\n"); 
		query.append("                      	GROUP BY 	T2.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,  	T2.TRSM_DT" ).append("\n"); 
		query.append("                            	,  	T2.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,  	T2.PRNR_SPCL_CGO_SEQ " ).append("\n"); 
		query.append("                      	)                         					T2" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 	,   (SELECT   	T3.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,  	T3.TRSM_DT" ).append("\n"); 
		query.append("                            	,  	T3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,  	T3.PRNR_SPCL_CGO_SEQ  " ).append("\n"); 
		query.append("                            	,  	MIN(T3.EDI_UNMAP_DTL_CD) 		AS EDI_UNMAP_DTL_CD                    " ).append("\n"); 
		query.append("                      	FROM		SCG_PRNR_CGO_DTL_LOG_UNMAP 		T3" ).append("\n"); 
		query.append("                      	GROUP BY 	T3.TRSM_BND_CD" ).append("\n"); 
		query.append("                            	,   T3.TRSM_DT" ).append("\n"); 
		query.append("                            	,   T3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                            	,   T3.PRNR_SPCL_CGO_SEQ " ).append("\n"); 
		query.append("                      	)                          					T3" ).append("\n"); 
		query.append("                 	-------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       		WHERE     	1 = 1" ).append("\n"); 
		query.append("			AND      	A.TRSM_MZD_CD              	= 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append("      		AND       	A.TRSM_BND_CD              	= RQ.MAPG_TRSM_BND_CD			(+)" ).append("\n"); 
		query.append("       		AND       	A.TRSM_DT                  	= RQ.MAPG_TRSM_DT				(+)" ).append("\n"); 
		query.append("       		AND       	A.SPCL_CGO_CATE_CD         	= RQ.MAPG_TRSM_SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("       		AND       	A.PRNR_SPCL_CGO_SEQ        	= RQ.MAPG_PRNR_SPCL_CGO_SEQ		(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND        	A.TRSM_BND_CD            	= T1.TRSM_BND_CD      			(+)" ).append("\n"); 
		query.append("            AND        	A.TRSM_DT                	= T1.TRSM_DT          			(+)" ).append("\n"); 
		query.append("            AND        	A.SPCL_CGO_CATE_CD       	= T1.SPCL_CGO_CATE_CD 			(+)" ).append("\n"); 
		query.append("            AND        	A.PRNR_SPCL_CGO_SEQ      	= T1.PRNR_SPCL_CGO_SEQ			(+)" ).append("\n"); 
		query.append("            AND        	A.TRSM_BND_CD            	= T2.TRSM_BND_CD      			(+)" ).append("\n"); 
		query.append("            AND        	A.TRSM_DT                	= T2.TRSM_DT          			(+)" ).append("\n"); 
		query.append("            AND        	A.SPCL_CGO_CATE_CD       	= T2.SPCL_CGO_CATE_CD 			(+)" ).append("\n"); 
		query.append("            AND        	A.PRNR_SPCL_CGO_SEQ      	= T2.PRNR_SPCL_CGO_SEQ			(+)" ).append("\n"); 
		query.append("            AND        	A.TRSM_BND_CD           	= T3.TRSM_BND_CD      			(+)" ).append("\n"); 
		query.append("            AND        	A.TRSM_DT                	= T3.TRSM_DT          			(+)" ).append("\n"); 
		query.append("            AND        	A.SPCL_CGO_CATE_CD       	= T3.SPCL_CGO_CATE_CD 			(+)" ).append("\n"); 
		query.append("            AND        	A.PRNR_SPCL_CGO_SEQ      	= T3.PRNR_SPCL_CGO_SEQ			(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	/*" ).append("\n"); 
		query.append("           	AND 		A.TRSM_DT           		= B.TRSM_DT						(+)" ).append("\n"); 
		query.append("		   	*/" ).append("\n"); 
		query.append("           	AND 		A.SPCL_CGO_CATE_CD  		= B.SPCL_CGO_CATE_CD			(+)" ).append("\n"); 
		query.append("		   	AND 		A.PRNR_SPCL_CGO_SEQ 		= B.PRNR_SPCL_CGO_SEQ			(+)" ).append("\n"); 
		query.append("		   	/*" ).append("\n"); 
		query.append("		   	AND 		A.PRNR_SPCL_CGO_SEQ 		= (	SELECT 	MAX(PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("		                                				FROM 	SCG_PRNR_SPCL_CGO_TRSM_HDR 	HDR" ).append("\n"); 
		query.append("		                               					WHERE 	A.TRSM_BND_CD       		= HDR.TRSM_BND_CD" ).append("\n"); 
		query.append("		   		                         				AND 	A.TRSM_DT           		= HDR.TRSM_DT" ).append("\n"); 
		query.append("		                                 				AND 	A.SPCL_CGO_CATE_CD  		= HDR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("		                                 				AND 	A.BKG_REF_NO        		= HDR.BKG_REF_NO" ).append("\n"); 
		query.append("														AND		A.CGO_OPR_CD				= HDR.CGO_OPR_CD" ).append("\n"); 
		query.append("														AND		A.VSL_CD					= HDR.VSL_CD" ).append("\n"); 
		query.append("														AND		A.SKD_VOY_NO				= HDR.SKD_VOY_NO" ).append("\n"); 
		query.append("														AND		A.SKD_DIR_CD				= HDR.SKD_DIR_CD" ).append("\n"); 
		query.append("														AND		A.POL_CD					= HDR.POL_CD" ).append("\n"); 
		query.append("														AND		A.POD_CD					= HDR.POD_CD" ).append("\n"); 
		query.append("		                             					)" ).append("\n"); 
		query.append("		  */" ).append("\n"); 
		query.append("		   #if (${trsm_bnd_cd} != '') " ).append("\n"); 
		query.append("		   	AND 		A.TRSM_BND_CD       = @[trsm_bnd_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${trsm_from_dt} != '')" ).append("\n"); 
		query.append("		   AND 			A.TRSM_DT BETWEEN TO_DATE(@[trsm_from_dt],'yyyy-MM-dd') AND TO_DATE(@[trsm_to_dt],'yyyy-MM-dd')+1" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   --:2016-05-13:--AND 			A.VSL_CD	= C.VSL_CD(+)" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   #if (${slan_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${pol_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${pod_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${bkg_ref_no} != '')" ).append("\n"); 
		query.append("		   AND 			A.BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("		   AND 			A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		   AND 			A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${edi_msg_sts_cd} != '')" ).append("\n"); 
		query.append("		   AND A.EDI_MSG_STS_CD = @[edi_msg_sts_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${err_knd_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if(${err_knd_cd} == 'U')	/* for Unmapping EDI */" ).append("\n"); 
		query.append("					AND				(T1.EDI_UNMAP_DTL_CD IS NOT NULL OR T2.EDI_UNMAP_DTL_CD IS NOT NULL OR T3.EDI_UNMAP_DTL_CD IS NOT NULL) AND A.ERR_KND_CD = 'O'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND 			A.ERR_KND_CD = @[err_knd_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("				#if (${rgn_shp_opr_cd} == 'RST')" ).append("\n"); 
		query.append("		   			AND 			A.RGN_SHP_OPR_CD IS NULL" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND 			A.RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${expand} == 'T')" ).append("\n"); 
		query.append("    ORDER BY 	A.PRNR_SPCL_CGO_SEQ 	DESC" ).append("\n"); 
		query.append("			, 	A.TRAN_IF_DATE 			DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    WHERE LATEST_ORDER 	= 1" ).append("\n"); 
		query.append("    ORDER BY 	A.PRNR_SPCL_CGO_SEQ 	DESC" ).append("\n"); 
		query.append("			,	A.TRAN_IF_DATE 			DESC" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}