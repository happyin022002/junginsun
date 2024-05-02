/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_f",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL").append("\n"); 
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
		query.append("UPDATE 		PRD_PROD_CTL_ROUT_DTL D2   " ).append("\n"); 
		query.append("SET 		D2.CNST_FLG " ).append("\n"); 
		query.append("			= " ).append("\n"); 
		query.append("			(   " ).append("\n"); 
		query.append("            SELECT 	RD_SVC   " ).append("\n"); 
		query.append("            FROM 	(   " ).append("\n"); 
		query.append("                	SELECT		SVC" ).append("\n"); 
		query.append("							,	PCTL_NO " ).append("\n"); 
		query.append("							,	ORG_NOD_CD" ).append("\n"); 
		query.append("							,	DEST_NOD_CD" ).append("\n"); 
		query.append("							,	TRSP_MOD_CD" ).append("\n"); 
		query.append("							,	PRI  " ).append("\n"); 
		query.append("							,	DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'R',DECODE(@[rd_f],'Y',DECODE(SVC,'X',DECODE(CNTR_TPSZ_CD,CNTR_TP_CD,''),SVC),SVC),SVC) RD_SVC  " ).append("\n"); 
		query.append("                	FROM 		(	   " ).append("\n"); 
		query.append("                     			SELECT  	DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'L') SVC " ).append("\n"); 
		query.append("										,	PCTL_CNST_ITM_NM  " ).append("\n"); 
		query.append("										,	D.ORG_NOD_CD" ).append("\n"); 
		query.append("										, 	D.DEST_NOD_CD" ).append("\n"); 
		query.append("										,	C.CNTR_TP_CD" ).append("\n"); 
		query.append("										,	Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("										,	D.TRSP_MOD_CD   " ).append("\n"); 
		query.append("										,	D.PCTL_NO   " ).append("\n"); 
		query.append("										,	ROW_NUMBER() OVER(PARTITION BY D.PCTL_NO,D.ORG_NOD_CD,D.DEST_NOD_CD,D.TRSP_MOD_CD ORDER BY DECODE(LENGTH(C.LNK_ORG_NOD_CD),7,1,5,2,3),DECODE(LENGTH(C.LNK_DEST_NOD_CD),7,1,5,2,3),C.LNK_ORG_NOD_CD,C.LNK_DEST_NOD_CD,D.TRSP_MOD_CD,DECODE(NVL(SVC_USE_FLG,'Y'),'N','X','L') DESC) PRI   " ).append("\n"); 
		query.append("                     			FROM 		PRD_LNK_CNST_MGMT 				C" ).append("\n"); 
		query.append("										, 	PRD_PROD_CTL_QTY 				Q " ).append("\n"); 
		query.append("										, 	PRD_PROD_CTL_ROUT_DTL 			D   " ).append("\n"); 
		query.append("                     					,	PRD_PROD_CTL_MST 				M " ).append("\n"); 
		query.append("			                     WHERE 		1 = 1" ).append("\n"); 
		query.append("								 AND 		D.PCTL_NO   					LIKE @[hd_pctl_no]||'%'   " ).append("\n"); 
		query.append("			                     AND 		M.PCTL_NO 						= D.PCTL_NO    " ).append("\n"); 
		query.append("			                     AND 		D.NOD_LNK_DIV_CD 				= 'L'   " ).append("\n"); 
		query.append("			                     AND 		D.PCTL_NO 						= Q.PCTL_NO   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								 -- :2016-12-16-FRI: -------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			                     AND 		D.ORG_NOD_CD 					LIKE C.LNK_ORG_NOD_CD||'%'   " ).append("\n"); 
		query.append("			                     AND 		D.DEST_NOD_CD 					LIKE C.LNK_DEST_NOD_CD||'%'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								 ----AND		CASE 	WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("               					----					WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') <>'ALL' THEN C.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("               					----					ELSE '*'" ).append("\n"); 
		query.append("          						----			END                 			= CASE	WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("                                ----     												WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') <>'ALL' THEN SUBSTR(D.ORG_NOD_CD,1,LENGTH(C.LNK_ORG_NOD_CD))" ).append("\n"); 
		query.append("                                ----     												ELSE '**'" ).append("\n"); 
		query.append("                                ----											  END" ).append("\n"); 
		query.append("								---- AND		CASE 	WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("               					----					WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') <>'ALL' THEN C.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("               					----					ELSE '*'" ).append("\n"); 
		query.append("          						----			END                 			= CASE 	WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("                                ----     												WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') <>'ALL' THEN SUBSTR(D.DEST_NOD_CD,1,LENGTH(C.LNK_DEST_NOD_CD))" ).append("\n"); 
		query.append("                                ----     												ELSE '**'" ).append("\n"); 
		query.append("                                ----											  END   " ).append("\n"); 
		query.append("								 -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("			                     AND 		D.TRSP_MOD_CD 					= DECODE(C.TRSP_MOD_CD, 'AL' ,D.TRSP_MOD_CD, C.TRSP_MOD_CD )  " ).append("\n"); 
		query.append("			                     AND 		NVL(M.CMDT_CD	, '*')  		= NVL(C.CMDT_CD, NVL(M.CMDT_CD,'*'))    " ).append("\n"); 
		query.append("			                     AND 		NVL(C.DELT_FLG	, 'N') 			= 'N'   " ).append("\n"); 
		query.append("			                     AND 		NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') = (	CASE 	WHEN NVL(C.SPCL_CGO_CNTR_TP_CD	,'AL') 	= 'AL' 										THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.DG_SPCL_FLG			,'N') 	= 'Y' AND NVL(M.RF_SPCL_FLG		,'N') = 'Y' THEN 'RD'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.DG_SPCL_FLG			,'N') 	= 'Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') = 'Y' THEN 'AD'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.DG_SPCL_FLG			,'N') 	= 'Y' 										THEN 'DG'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.RF_SPCL_FLG			,'N') 	= 'Y' 										THEN 'RF'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.SPCL_AWK_CGO_FLG		,'N') 	= 'Y' 										THEN 'AK'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.BB_SPCL_FLG			,'N') 	= 'Y' 										THEN 'BB'" ).append("\n"); 
		query.append("			                                                                 			WHEN NVL(M.DG_SPCL_FLG			,'N') 	= 'N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') = 'N' AND NVL(M.BB_SPCL_FLG,'N') = 'N' THEN 'GP'" ).append("\n"); 
		query.append("			                                                             		END" ).append("\n"); 
		query.append("																				)" ).append("\n"); 
		query.append("			                     AND 		Q.CNTR_TPSZ_CD 					LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("			                     AND 		(   " ).append("\n"); 
		query.append("			                    				(   " ).append("\n"); 
		query.append("			                    				TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.ARR_ST_DT " ).append("\n"); 
		query.append("												AND   " ).append("\n"); 
		query.append("			                    				D.ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)   " ).append("\n"); 
		query.append("			                    				) " ).append("\n"); 
		query.append("												OR   " ).append("\n"); 
		query.append("			                    				(   " ).append("\n"); 
		query.append("			                    				TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.DEP_FSH_DT " ).append("\n"); 
		query.append("												AND   " ).append("\n"); 
		query.append("			                    				D.DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)   " ).append("\n"); 
		query.append("			                    				)   " ).append("\n"); 
		query.append("			                    			)   " ).append("\n"); 
		query.append("			                	)   " ).append("\n"); 
		query.append("					)   " ).append("\n"); 
		query.append("			        WHERE 		PRI 		= 1 " ).append("\n"); 
		query.append("					AND 		PCTL_NO 	= D2.PCTL_NO   " ).append("\n"); 
		query.append("			        AND 		ORG_NOD_CD 	= D2.ORG_NOD_CD   " ).append("\n"); 
		query.append("			        AND 		DEST_NOD_CD = D2.DEST_NOD_CD   " ).append("\n"); 
		query.append("			        AND 		TRSP_MOD_CD = D2.TRSP_MOD_CD   " ).append("\n"); 
		query.append("			        AND 		ROWNUM 		= 1    " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("	  		)   " ).append("\n"); 
		query.append("WHERE 		D2.PCTL_NO 			LIKE @[hd_pctl_no]||'%'   " ).append("\n"); 
		query.append("AND 		D2.NOD_LNK_DIV_CD 	= 'L'" ).append("\n"); 

	}
}