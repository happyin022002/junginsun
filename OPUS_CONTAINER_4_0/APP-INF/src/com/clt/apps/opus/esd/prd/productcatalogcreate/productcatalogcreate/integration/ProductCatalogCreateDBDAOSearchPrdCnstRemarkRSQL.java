/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrdCnstRemark
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prdCtlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnstFlg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'Route : ' || POR_CD ||	 POL_CD|| " ).append("\n"); 
		query.append("		 DECODE(N1ST_LANE_CD, '()-', '', N1ST_LANE_CD)||" ).append("\n"); 
		query.append("		 DECODE(N1ST_TS_PORT_CD, '-', '', N1ST_TS_PORT_CD)||" ).append("\n"); 
		query.append("		 DECODE(N2ND_LANE_CD, '()-', '', N2ND_LANE_CD)||" ).append("\n"); 
		query.append("		 DECODE(N2ND_TS_PORT_CD, '-', '', N2ND_TS_PORT_CD)||" ).append("\n"); 
		query.append("		 DECODE(N3RD_LANE_CD, '()-', '', N3RD_LANE_CD)||" ).append("\n"); 
		query.append("		 POD_NOD_CD||" ).append("\n"); 
		query.append("		 DEL_CD ||" ).append("\n"); 
		query.append("		 ' : ' || " ).append("\n"); 
		query.append("		 ' Remark(' ||ROUT_CNST_RMK||') ' || DECODE( SVC_USE_FLG , '() - ' ,'', '- SVC' || SVC_USE_FLG)  	CNST_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("         SELECT POR_NOD_CD||'-' POR_CD, " ).append("\n"); 
		query.append("				POL_NOD_CD||'-' POL_CD, N1ST_TS_PORT_CD||'-' N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("        		N2ND_TS_PORT_CD||'-' N2ND_TS_PORT_CD, POD_NOD_CD||'-' POD_NOD_CD," ).append("\n"); 
		query.append("        		DEL_NOD_CD DEL_CD, ROUT_CNST_RMK, '('||SVC_USE_FLG||')  ' SVC_USE_FLG," ).append("\n"); 
		query.append("        		'('||N1ST_LANE_CD||')-' N1ST_LANE_CD," ).append("\n"); 
		query.append("        		'('||N2ND_LANE_CD||')-' N2ND_LANE_CD," ).append("\n"); 
		query.append("        		'('||N3RD_LANE_CD||')-' N3RD_LANE_CD" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("				SELECT MST.PCTL_NO, R.ROUT_CNST_SEQ ROUT_CNST_SEQ, DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'R')	ROUT_CNST_FLG" ).append("\n"); 
		query.append("				      , ROW_NUMBER() OVER (PARTITION BY MST.PCTL_NO" ).append("\n"); 
		query.append("				                           ORDER BY DECODE(R.TRNK_LANE_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                  , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                  , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("				                                 , R.ROUT_CNST_SEQ DESC ) RN" ).append("\n"); 
		query.append("				      , R.*" ).append("\n"); 
		query.append("				FROM PRD_ROUT_CNST R,PRD_PROD_CTL_QTY Q," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("								MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("								POD_CD, DEL_NOD_CD, POR_NOD_CD," ).append("\n"); 
		query.append("								(SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("								FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("								WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("								AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("								AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD ) TRNK_LANE," ).append("\n"); 
		query.append("								(SELECT /*+INDEX (D XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("					    				ORG_NOD_CD" ).append("\n"); 
		query.append("								FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("								WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("								AND PCTL_IO_BND_CD = 'I' AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   			AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                    			AND ROWNUM = 1" ).append("\n"); 
		query.append("								) POD_NOD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("               				,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("                            ,M.DG_SPCL_FLG, M.RF_SPCL_FLG, M.SPCL_AWK_CGO_FLG, M.BB_SPCL_FLG" ).append("\n"); 
		query.append("						FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("							 (SELECT PCTL_NO,ORG_NOD_CD,DEST_NOD_CD," ).append("\n"); 
		query.append("									 RANK () OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RK, VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("								FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("							   WHERE PCTL_NO = @[prdCtlNo] " ).append("\n"); 
		query.append("								AND  VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("								AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("								AND	 DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("								AND	 DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("							 ) TS" ).append("\n"); 
		query.append("						WHERE M.PCTL_NO = @[prdCtlNo]  AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("						GROUP BY M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("								 N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("								 N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("								 POD_CD," ).append("\n"); 
		query.append("								 DEL_NOD_CD," ).append("\n"); 
		query.append("                                 POR_NOD_CD," ).append("\n"); 
		query.append("								 TRNK_VSL_CD," ).append("\n"); 
		query.append("								 TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("								 TRNK_SKD_DIR_CD,M.DG_SPCL_FLG, M.RF_SPCL_FLG, M.SPCL_AWK_CGO_FLG, M.BB_SPCL_FLG" ).append("\n"); 
		query.append("					 ) MST" ).append("\n"); 
		query.append("				WHERE NVL(MST.TRNK_LANE, 'ALL') = DECODE(R.TRNK_LANE_CD, 'ALL', NVL(MST.TRNK_LANE, 'ALL'), R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("				AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("				AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("				AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("                AND NVL(MST.POR_NOD_CD, R.POR_NOD_CD) LIKE NVL(R.POR_NOD_CD, MST.POR_NOD_CD)||'%'" ).append("\n"); 
		query.append("		    	AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("	            AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N1ST_LANE_CD, ' ') = NVL(R.N1ST_LANE_CD, NVL(MST.N1ST_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N2ND_LANE_CD, ' ') = NVL(R.N2ND_LANE_CD, NVL(MST.N2ND_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(MST.N3RD_LANE_CD, ' ') = NVL(R.N3RD_LANE_CD, NVL(MST.N3RD_LANE_CD, ' '))" ).append("\n"); 
		query.append("				AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                AND Q.PCTL_NO = MST.PCTL_NO" ).append("\n"); 
		query.append("                AND Q.CNTR_TPSZ_CD LIKE NVL(R.CNTR_TP_CD,'%')||NVL(R.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("                AND NVL(R.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(R.SPCL_CGO_CNTR_TP_CD,'AL')  ='AL' THEN NVL(R.SPCL_CGO_CNTR_TP_CD,'AL') " ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' AND NVL(MST.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' AND NVL(MST.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                            WHEN NVL(MST.DG_SPCL_FLG,'N') ='N' AND NVL(MST.RF_SPCL_FLG,'N') ='N' AND NVL(MST.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(MST.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                                        END)" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	  WHERE RN = 1" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE @[cnstFlg] IN ('A','X','O','P','R',@[cnstFlg])" ).append("\n"); 
		query.append("AND NVL(@[org_nod_cd], 'X') = 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	DISTINCT 'Link : (' || " ).append("\n"); 
		query.append("    	LNK_ORG_NOD_CD || ' - ' ||	" ).append("\n"); 
		query.append("    	LNK_DEST_NOD_CD	|| ') : ' || " ).append("\n"); 
		query.append("    	' ITEM' ||PCTL_CNST_ITM_NM || " ).append("\n"); 
		query.append("    	DECODE( CNTR_TP_CD , '() - ' ,'', ' CNTR TYPE' || CNTR_TP_CD) || " ).append("\n"); 
		query.append("    	DECODE( CMDT_CD , '() - ' ,'', ' CMDT' || CMDT_CD) ||  " ).append("\n"); 
		query.append("    	DECODE( LNK_CNST_RMK , '() - ' ,'', ' Remark' || LNK_CNST_RMK) || " ).append("\n"); 
		query.append("    	DECODE( SVC_USE_FLG , '()  ' ,'', ' SVC' || SVC_USE_FLG)  CNST_RMK " ).append("\n"); 
		query.append("FROM 	( " ).append("\n"); 
		query.append("    	SELECT  C.LNK_ORG_NOD_CD LNK_ORG_NOD_CD ,   " ).append("\n"); 
		query.append("    			C.LNK_DEST_NOD_CD LNK_DEST_NOD_CD,	" ).append("\n"); 
		query.append("    			'('||PCTL_CNST_ITM_NM ||') - ' PCTL_CNST_ITM_NM, " ).append("\n"); 
		query.append("    			'(' ||	C.CNTR_TP_CD || ') - ' CNTR_TP_CD , " ).append("\n"); 
		query.append("    			'(' ||C.CMDT_CD||	') - ' CMDT_CD, " ).append("\n"); 
		query.append("    			'(' ||C.LNK_CNST_RMK||	') - ' LNK_CNST_RMK, " ).append("\n"); 
		query.append("    			'('||SVC_USE_FLG||')  ' SVC_USE_FLG	" ).append("\n"); 
		query.append("    	FROM 	PRD_LNK_CNST_MGMT 					C" ).append("\n"); 
		query.append("			, 	PRD_PROD_CTL_ROUT_DTL 				D" ).append("\n"); 
		query.append("			, 	PRD_PROD_CTL_QTY 					Q" ).append("\n"); 
		query.append("			,	PRD_PROD_CTL_MST 					M		" ).append("\n"); 
		query.append("    	WHERE 	D.PCTL_NO 							= @[prdCtlNo]	" ).append("\n"); 
		query.append("    	AND 	M.PCTL_NO 							= D.PCTL_NO													" ).append("\n"); 
		query.append("    	AND 	D.NOD_LNK_DIV_CD 					= 'L'	" ).append("\n"); 
		query.append("    	AND 	D.PCTL_NO 							= Q.PCTL_NO " ).append("\n"); 
		query.append("		AND 	D.ORG_NOD_CD 						LIKE @[org_nod_cd]||'%' " ).append("\n"); 
		query.append("		AND 	D.DEST_NOD_CD 						LIKE @[dest_nod_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 -- :2016-12-16-FRI: -------------------------------------------------------------------------------" ).append("\n"); 
		query.append("	     AND 	D.ORG_NOD_CD 						LIKE C.LNK_ORG_NOD_CD ||'%'" ).append("\n"); 
		query.append("	     AND 	D.DEST_NOD_CD 						LIKE C.LNK_DEST_NOD_CD||'%'	 " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		 ----AND		CASE 	WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("		----					WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') <>'ALL' THEN C.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("		----					ELSE '*'" ).append("\n"); 
		query.append("		----			END                 			= CASE	WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("	    ----     												WHEN NVL(C.LNK_ORG_NOD_CD,'ALL') <>'ALL' THEN SUBSTR(D.ORG_NOD_CD,1,LENGTH(C.LNK_ORG_NOD_CD))" ).append("\n"); 
		query.append("	    ----     												ELSE '**'" ).append("\n"); 
		query.append("	    ----											  END" ).append("\n"); 
		query.append("		---- AND		CASE 	WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("		----					WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') <>'ALL' THEN C.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("		----					ELSE '*'" ).append("\n"); 
		query.append("		----			END                 			= CASE 	WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') = 'ALL' THEN 'ALL'" ).append("\n"); 
		query.append("	    ----     												WHEN NVL(C.LNK_DEST_NOD_CD,'ALL') <>'ALL' THEN SUBSTR(D.DEST_NOD_CD,1,LENGTH(C.LNK_DEST_NOD_CD))" ).append("\n"); 
		query.append("	    ----     												ELSE '**'" ).append("\n"); 
		query.append("	    ----											  END   " ).append("\n"); 
		query.append("		 -----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	AND 	D.TRSP_MOD_CD 						= DECODE(C.TRSP_MOD_CD, 'AL' ,D.TRSP_MOD_CD, C.TRSP_MOD_CD ) 	" ).append("\n"); 
		query.append("		AND 	NVL(M.CMDT_CD	,'X')  				= NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X')) 	" ).append("\n"); 
		query.append("		AND 	NVL(C.DELT_FLG	,'N') 				= 'N'	" ).append("\n"); 
		query.append("    	AND 	NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') 	= (CASE WHEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                			WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                           			   END)" ).append("\n"); 
		query.append("    	AND 	Q.CNTR_TPSZ_CD 						LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("    	AND 	(	   " ).append("\n"); 
		query.append("            		(   " ).append("\n"); 
		query.append("                	TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.ARR_ST_DT " ).append("\n"); 
		query.append("					AND   " ).append("\n"); 
		query.append("                	D.ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)   " ).append("\n"); 
		query.append("            		) " ).append("\n"); 
		query.append("					OR   " ).append("\n"); 
		query.append("            		(   " ).append("\n"); 
		query.append("                	TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.DEP_FSH_DT " ).append("\n"); 
		query.append("					AND   " ).append("\n"); 
		query.append("                	D.DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)   " ).append("\n"); 
		query.append("            		)   " ).append("\n"); 
		query.append("         		)					" ).append("\n"); 
		query.append("    	AND 	NVL(D.CNST_FLG, 'Z') IN ('L', 'X')	" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("WHERE 	@[cnstFlg] IN ('A','X','O','I','L',@[cnstFlg]) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT 'Location (' ||	" ).append("\n"); 
		query.append("		NOD_CD || DECODE(PORT_PNT_CD, 'ALL', '', ' : '||DECODE(PORT_PNT_CD,'TS','T/S',PORT_PNT_CD)) || " ).append("\n"); 
		query.append("		') - ITEM' ||PCTL_CNST_ITM_NM || " ).append("\n"); 
		query.append("		DECODE( CNTR_TP_CD , '() - ' ,'', ' CNTR TYPE' || CNTR_TP_CD) || " ).append("\n"); 
		query.append("		DECODE( CMDT_CD , '() - ' ,'', ' CMDT' || CMDT_CD) || " ).append("\n"); 
		query.append("		DECODE( NOD_CNST_RMK , '() - ' ,'', ' Remark' || NOD_CNST_RMK) || " ).append("\n"); 
		query.append("		DECODE( SVC_USE_FLG , '()  ' ,'', ' SVC' || SVC_USE_FLG)   CNST_RMK " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT  C.NOD_CD NOD_CD , " ).append("\n"); 
		query.append("    		'('||C.PCTL_CNST_ITM_NM ||') - ' PCTL_CNST_ITM_NM, 	" ).append("\n"); 
		query.append("    		'(' ||	C.CNTR_TP_CD||C.CNTR_SZ_CD || ') - ' CNTR_TP_CD, " ).append("\n"); 
		query.append("    		'(' ||	C.CMDT_CD || ') - ' CMDT_CD, " ).append("\n"); 
		query.append("    		'(' ||	C.NOD_CNST_RMK || ') - ' NOD_CNST_RMK, " ).append("\n"); 
		query.append("    		'('||SVC_USE_FLG||')  ' SVC_USE_FLG	" ).append("\n"); 
		query.append("			,D.PCTL_NO " ).append("\n"); 
		query.append("			,C.PORT_PNT_CD, D.PCTL_SEQ " ).append("\n"); 
		query.append("    FROM PRD_NOD_CNST_MGMT C, PRD_PROD_CTL_QTY Q,PRD_PROD_CTL_MST M , PRD_PROD_CTL_ROUT_DTL D		" ).append("\n"); 
		query.append("    WHERE M.PCTL_NO = @[prdCtlNo]	" ).append("\n"); 
		query.append("     AND M.PCTL_NO = D.PCTL_NO  " ).append("\n"); 
		query.append("     AND D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("     AND D.ORG_NOD_CD LIKE @[nod_cd]||'%'" ).append("\n"); 
		query.append("     AND D.NOD_LNK_DIV_CD = 'N'	" ).append("\n"); 
		query.append("     AND D.ORG_NOD_CD LIKE DECODE(C.NOD_CD, 'ALL','%',C.NOD_CD||'%')" ).append("\n"); 
		query.append("     AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))																 " ).append("\n"); 
		query.append("     AND NVL(C.DELT_FLG, 'N') <> 'Y'															  		 " ).append("\n"); 
		query.append("     AND NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                 WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                             END)" ).append("\n"); 
		query.append("     AND Q.CNTR_TPSZ_CD LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("     AND NVL(C.VSL_SLAN_CD,'ALL') = (CASE WHEN NVL(C.VSL_SLAN_CD,'ALL') = 'ALL' THEN NVL(C.VSL_SLAN_CD,'ALL')" ).append("\n"); 
		query.append("                                          WHEN C.PORT_PNT_CD IN ('POR','POL') THEN (SELECT N1ST_LANE_CD" ).append("\n"); 
		query.append("                                                                                      FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                     WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                           = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                               WHERE DX.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                 AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                 AND ROWNUM =1) )" ).append("\n"); 
		query.append("                                          WHEN C.PORT_PNT_CD IN ('POD','DEL') THEN ( SELECT SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),-3)" ).append("\n"); 
		query.append("                                                                                       FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                      WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                           = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                               WHERE DX.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                 AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                 AND ROWNUM =1) )    " ).append("\n"); 
		query.append("                                          WHEN C.PORT_PNT_CD IN ('ALL','TS') THEN (SELECT C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                                                     FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                    WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                           = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                               WHERE DX.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                 AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                 AND ROWNUM =1) " ).append("\n"); 
		query.append("                                                                                      AND C.VSL_SLAN_CD IN ( N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD))" ).append("\n"); 
		query.append("                                      END)" ).append("\n"); 
		query.append("     AND (																								 " ).append("\n"); 
		query.append("            (																							 " ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.ARR_ST_DT AND	 " ).append("\n"); 
		query.append("                D.ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)		 " ).append("\n"); 
		query.append("            ) OR																						 " ).append("\n"); 
		query.append("            (																							 " ).append("\n"); 
		query.append("                TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.DEP_FSH_DT AND	 " ).append("\n"); 
		query.append("                D.DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)	 " ).append("\n"); 
		query.append("            )																							 " ).append("\n"); 
		query.append("        ) 	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ) CC " ).append("\n"); 
		query.append("WHERE NVL(CC.port_pnt_cd, 'ALL') = 'ALL' OR" ).append("\n"); 
		query.append("                                            CC.port_pnt_cd IN (" ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POR'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )," ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POL'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                ),                                             " ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'  ) THEN 'TS'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                ),                                                " ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POD'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )," ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'DEL'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("AND @[cnstFlg] IN ('A','X','P','I','N',@[cnstFlg])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Hub Loc :'||C.PORT_CD||'(PORT)-'||C.CNST_LANE_CD ||'(LANE)-'||C.HUB_LOC_CD||'(HUB)-'||C.NOD_CD||'(LOC) Remark('||HUB_LOC_CNST_RMK||')- SVC('||SVC_USE_FLG||')'" ).append("\n"); 
		query.append("FROM PRD_HUB_LOC_CNST_MGMT C, PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("WHERE C.PORT_CD  = DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_ORG_NOD_CD,1,5),'O',SUBSTR(D.ROUT_DEST_NOD_CD,1,5)) " ).append("\n"); 
		query.append("AND C.HUB_LOC_CD = NVL((SELECT HUB_LOC_CD " ).append("\n"); 
		query.append("                         FROM PRD_INLND_ROUT_MST H" ).append("\n"); 
		query.append("                        WHERE H.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                          AND H.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                          AND H.ROUT_SEQ = D.ROUT_SEQ),C.PORT_CD)" ).append("\n"); 
		query.append("AND C.HUB_LOC_CD = SUBSTR(D.ORG_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND C.NOD_CD=DECODE(C.NOD_CD,'ALL',C.NOD_CD,DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_DEST_NOD_CD,1,LENGTH(TRIM(C.NOD_CD))),'O',SUBSTR(D.ROUT_ORG_NOD_CD,1,LENGTH(TRIM(C.NOD_CD)))))" ).append("\n"); 
		query.append("AND C.IO_BND_CD= DECODE(C.IO_BND_CD,'B',C.IO_BND_CD,D.PCTL_IO_BND_CD)" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD <> 'T'" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND M.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("AND Q.CNTR_TPSZ_CD LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("AND D.ORG_NOD_CD LIKE @[nod_cd]||'%'" ).append("\n"); 
		query.append("AND C.CNST_LANE_CD = (CASE WHEN C.CNST_LANE_CD = 'ALL' THEN C.CNST_LANE_CD" ).append("\n"); 
		query.append("                            ELSE (SELECT DECODE(D.PCTL_IO_BND_CD,'O',SUBSTR(TRIM(O.N1ST_LANE_CD||O.N2ND_LANE_CD||O.N3RD_LANE_CD||O.N4TH_LANE_CD),1,3)" ).append("\n"); 
		query.append("                                                                  ,'I',SUBSTR(TRIM(O.N1ST_LANE_CD||O.N2ND_LANE_CD||O.N3RD_LANE_CD||O.N4TH_LANE_CD),-3)) " ).append("\n"); 
		query.append("                                    FROM PRD_OCN_ROUT O, PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                    WHERE O.ORG_LOC_CD = DX.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                    AND O.DEST_LOC_CD = DX.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                    AND O.ROUT_SEQ = DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                    AND DX.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                    AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("                      END)" ).append("\n"); 
		query.append("AND NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                            WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                            WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                        END)" ).append("\n"); 
		query.append("AND NVL(C.DIR_CD,'A') = (CASE WHEN NVL(C.DIR_CD,'A') = 'A' THEN NVL(C.DIR_CD,'A')" ).append("\n"); 
		query.append("                              WHEN C.IO_BND_CD ='O' THEN  ( SELECT /*+ INDEX_ASC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                              FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                             WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                               AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                               AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                              WHEN C.IO_BND_CD ='I' THEN  ( SELECT /*+ INDEX_DESC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                              FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                             WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                               AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                               AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                              WHEN C.IO_BND_CD ='B' AND ( M.POR_CD = SUBSTR(C.NOD_CD,1,5) OR M.POL_CD = C.PORT_CD )   " ).append("\n"); 
		query.append("                                                    THEN  ( SELECT /*+ INDEX_ASC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                              FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                             WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                               AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                               AND ROWNUM = 1 )                               " ).append("\n"); 
		query.append("                              WHEN C.IO_BND_CD ='B' AND ( M.DEL_CD = SUBSTR(C.NOD_CD,1,5) OR M.POD_CD = C.PORT_CD )   " ).append("\n"); 
		query.append("                                                    THEN  ( SELECT /*+ INDEX_DESC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                              FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                             WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                               AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                               AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                           END)" ).append("\n"); 
		query.append("AND DECODE(C.NOD_CD,'ALL',1000,0) + DECODE(C.IO_BND_CD,'B',100,0) + DECODE(C.CNST_LANE_CD,'ALL',10,0) + DECODE(C.SPCL_CGO_CNTR_TP_CD,'AL',1,0) " ).append("\n"); 
		query.append(" = (SELECT MIN(DECODE(C2.NOD_CD,'ALL',1000,0) + DECODE(C2.IO_BND_CD,'B',100,0) + DECODE(C2.CNST_LANE_CD,'ALL',10,0) + DECODE(C2.SPCL_CGO_CNTR_TP_CD,'AL',1,0) )" ).append("\n"); 
		query.append("     FROM PRD_HUB_LOC_CNST_MGMT C2" ).append("\n"); 
		query.append("    WHERE C2.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("      AND C2.HUB_LOC_CD = C.HUB_LOC_CD" ).append("\n"); 
		query.append("      AND C2.NOD_CD= DECODE(C2.NOD_CD,'ALL',C2.NOD_CD,DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_DEST_NOD_CD,1,LENGTH(TRIM(C2.NOD_CD))),'O',SUBSTR(D.ROUT_ORG_NOD_CD,1,LENGTH(TRIM(C2.NOD_CD))))) " ).append("\n"); 
		query.append("      AND C2.IO_BND_CD =DECODE(C2.IO_BND_CD,'B',C2.IO_BND_CD,'ALL',C2.IO_BND_CD,D.PCTL_IO_BND_CD)" ).append("\n"); 
		query.append("      AND C2.CNST_LANE_CD = (CASE WHEN C2.CNST_LANE_CD = 'ALL' THEN C2.CNST_LANE_CD" ).append("\n"); 
		query.append("                                    ELSE (SELECT DECODE(D.PCTL_IO_BND_CD,'O',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),1,3)" ).append("\n"); 
		query.append("                                                                        ,'I',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),-3)) " ).append("\n"); 
		query.append("                                    		FROM PRD_OCN_ROUT O, PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                    		WHERE O.ORG_LOC_CD = DX.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                    			AND O.DEST_LOC_CD = DX.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                    			AND O.ROUT_SEQ = DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                    			AND DX.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                    			AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                    			AND ROWNUM = 1" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("                                END)" ).append("\n"); 
		query.append("      AND NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                   WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                               END) " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("AND D.PCTL_NO= @[prdCtlNo]" ).append("\n"); 
		query.append("AND D.MTY_YD_FLG = 'N'" ).append("\n"); 

	}
}