/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgInfoAtLocalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.11.14 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgInfoAtLocalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주위험물 테이블들에서 데이타를 가져온다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgInfoAtLocalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgInfoAtLocalRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("         SUM(SUB1.SEQ) OVER (ORDER BY SUB1.BL_NO, SUB1.POL_CD, SUB1.POD_CD, SUB1.CNTR_NO, SUB1.CELL_PSN_NO) SEQ " ).append("\n"); 
		query.append("		,SUB1.CNTR_CNT			-- TOTAL CONTAINER COUNT" ).append("\n"); 
		query.append("        ,SUB1.BL_NO MERGE_BL_NO" ).append("\n"); 
		query.append("        ,SUB1.BL_NO              -- BL_NO" ).append("\n"); 
		query.append("		,SUB1.BKG_NO" ).append("\n"); 
		query.append("        ,SUB1.POL_CD             -- POL_CD" ).append("\n"); 
		query.append("        ,SUB1.POD_CD             -- POD_CD" ).append("\n"); 
		query.append("        ,SUB1.CNTR_NO            -- Container No" ).append("\n"); 
		query.append("        ,SUB1.CNTR_CGO_SEQ       -- Container Cargo Seq" ).append("\n"); 
		query.append("		,DECODE(NVL(SUB1.CELL_PSN_NO, ''), '', '', LPAD(SUB1.CELL_PSN_NO, 7,0 )) CELL_PSN_NO	-- Cell Position" ).append("\n"); 
		query.append("        ,SUB1.IMDG_CLSS_CD       -- Class" ).append("\n"); 
		query.append("        ,SUB1.IMDG_UN_NO         -- UN No." ).append("\n"); 
		query.append("        ,SUB1.IMDG_UN_NO_SEQ     -- UN No SEQ." ).append("\n"); 
		query.append("		,SUB1.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("        ,SUB1.ANR_SPCL_TP_ID AS DG_SHORT_NM     -- S.D/G" ).append("\n"); 
		query.append("        ,SUB1.FLSH_PNT_CDO_TEMP  				-- Flash Point" ).append("\n"); 
		query.append("        ,SUB1.ANR_ROLE_DIV_CD AS AGENT  		-- Agent" ).append("\n"); 
		query.append("        ,SUB1.ANR_CRR_TP_CD AS C_TYPE     		-- Carriage Type" ).append("\n"); 
		query.append("        ,SUB1.FDR_SVC_RQST_NO    -- SSR(Feeder)" ).append("\n"); 
		query.append("        ,SUB1.IMDG_PCK_GRP_CD    -- Package Group" ).append("\n"); 
		query.append("        ,SUB1.OUT_IMDG_PCK_QTY1  -- Outer Package QTY" ).append("\n"); 
		query.append("        ,SUB1.OUT_IMDG_PCK_CD1   -- Outer Package Code" ).append("\n"); 
		query.append("        ,SUB1.EMS_NO             -- EMS" ).append("\n"); 
		query.append("        ,SUB1.NET_WGT            -- Net Weight" ).append("\n"); 
		query.append("        ,SUB1.GRS_WGT            -- Gross Weight" ).append("\n"); 
		query.append("        ,SUB1.EUR_PCK_DESC AS PACKAGES 					-- Packages" ).append("\n"); 
		query.append("        ,SUB1.PRP_SHP_NM         						-- Substance" ).append("\n"); 
		query.append("        ,SUB1.HZD_DESC           						-- Hazardous Contents" ).append("\n"); 
		query.append("        ,SUB1.ANR_FWRD_ID AS FWRD_ID 					-- Forwarder Code" ).append("\n"); 
		query.append("        ,SUB1.FWRD_NM          							-- Forwarder Name" ).append("\n"); 
		query.append("	    ,SUB1.EUR_DCGO_MRN_POLUT_CD	DCGO_MRN_POLUT_CD	-- Marine Pollutant" ).append("\n"); 
		query.append("        ,SUB1.IMDG_LMT_QTY_FLG							-- Limited quantity" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       	,SUB1.FDR_VSL_NM           -- Feeder Name" ).append("\n"); 
		query.append("       	,SUB1.FDR_VSL_LLOYD_NO     -- Feeder Lloyd No" ).append("\n"); 
		query.append("       	,SUB1.FDR_VVD_ID           -- Feeder VVD" ).append("\n"); 
		query.append("		,TO_CHAR(SUB1.CRR_DT, 'YYYYMMDD')	CRR_DT	   -- on carriage date" ).append("\n"); 
		query.append("		,SUB1.IMDG_SUBS_RSK_LBL_CD1-- Sub Label 1" ).append("\n"); 
		query.append("		,SUB1.IMDG_SUBS_RSK_LBL_CD2-- Sub Label 2" ).append("\n"); 
		query.append("		,SUB1.IMDG_SUBS_RSK_LBL_CD3-- Sub Label 3" ).append("\n"); 
		query.append("		,SUB1.IMDG_SUBS_RSK_LBL_CD4-- Sub Label 4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   		,NVL(SUB1.MSG_FUNC_ID, '') SEND_TYPE" ).append("\n"); 
		query.append("        ,NVL(SUB1.SCR_FILE_NO, '') SCR_FILE_NO" ).append("\n"); 
		query.append("   		,SUB1.MSG_SND_NO MSG_SND_NO" ).append("\n"); 
		query.append("   		,SUB1.FIRST_MSG_SND_NO" ).append("\n"); 
		query.append(" 		,COUNT(DISTINCT SUB1.BL_NO) OVER(PARTITION BY SUB1.FIRST_MSG_SND_NO ) AS GROUP_CNT" ).append("\n"); 
		query.append("        ,SUB1.NET_EXPLO_WGT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("        	DECODE(LAG(A.BL_NO) OVER ( ORDER BY A.BL_NO, A.POL_CD, A.POD_CD, A.CNTR_NO, " ).append("\n"); 
		query.append("                                    DECODE(NVL(BAY.CELL_PSN_NO, ''), '', A.CELL_PSN_NO, BAY.CELL_PSN_NO) ) , A.BL_NO, 0, 1) SEQ  " ).append("\n"); 
		query.append("			,COUNT(DISTINCT A.CNTR_NO) OVER() CNTR_CNT" ).append("\n"); 
		query.append("        	,A.BL_NO              -- BL_NO" ).append("\n"); 
		query.append("			,C.BKG_NO" ).append("\n"); 
		query.append("		    ,A.POL_CD             -- POL_CD" ).append("\n"); 
		query.append("		    ,A.POD_CD             -- POD_CD" ).append("\n"); 
		query.append("		    ,A.CNTR_NO            -- Container No" ).append("\n"); 
		query.append("			,A.CNTR_CGO_SEQ		  -- Container Cargo Seq" ).append("\n"); 
		query.append("		    ,DECODE(NVL(BAY.CELL_PSN_NO, ''), '', A.CELL_PSN_NO, BAY.CELL_PSN_NO) AS CELL_PSN_NO -- Cell Position" ).append("\n"); 
		query.append("		    ,A.IMDG_CLSS_CD       -- Class" ).append("\n"); 
		query.append("		    ,A.IMDG_UN_NO         -- UN No." ).append("\n"); 
		query.append("		    ,A.IMDG_UN_NO_SEQ     -- UN No SEQ." ).append("\n"); 
		query.append("			,SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("		    ,A.ANR_SPCL_TP_ID     -- S.D/G" ).append("\n"); 
		query.append("		    ,A.FLSH_PNT_CDO_TEMP  -- Flash Point" ).append("\n"); 
		query.append("		    ,A.ANR_ROLE_DIV_CD    -- Agent" ).append("\n"); 
		query.append("		    ,A.ANR_CRR_TP_CD      -- Carriage Type" ).append("\n"); 
		query.append("		    ,A.FDR_SVC_RQST_NO    -- SSR(Feeder)" ).append("\n"); 
		query.append("		    ,A.IMDG_PCK_GRP_CD    -- Package Group" ).append("\n"); 
		query.append("		    ,A.OUT_IMDG_PCK_QTY1  -- Outer Package QTY" ).append("\n"); 
		query.append("		    ,A.OUT_IMDG_PCK_CD1   -- Outer Package Code" ).append("\n"); 
		query.append("		    ,A.EMS_NO             -- EMS" ).append("\n"); 
		query.append("		    ,A.NET_WGT            -- Net Weight" ).append("\n"); 
		query.append("		    ,A.GRS_WGT            -- Gross Weight" ).append("\n"); 
		query.append("		    ,A.EUR_PCK_DESC       -- Packages" ).append("\n"); 
		query.append("		    ,A.PRP_SHP_NM         -- Substance" ).append("\n"); 
		query.append("		    ,A.HZD_DESC           -- Hazardous Contents" ).append("\n"); 
		query.append("		    ,A.ANR_FWRD_ID" ).append("\n"); 
		query.append("		    ,B.FWRD_NM            -- Forwarder Name" ).append("\n"); 
		query.append("	        ,A.EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("        	,A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	,A.FDR_VSL_NM           -- Feeder Name" ).append("\n"); 
		query.append("        	,A.FDR_VSL_LLOYD_NO     -- Feeder Lloyd No" ).append("\n"); 
		query.append("        	,A.FDR_VVD_ID           -- Feeder VVD" ).append("\n"); 
		query.append("			,A.CRR_DT				-- on carriage date" ).append("\n"); 
		query.append("			,A.IMDG_SUBS_RSK_LBL_CD1-- Sub Label 1" ).append("\n"); 
		query.append("            ,A.IMDG_SUBS_RSK_LBL_CD2-- Sub Label 2" ).append("\n"); 
		query.append("            ,A.IMDG_SUBS_RSK_LBL_CD3-- Sub Label 3" ).append("\n"); 
		query.append("            ,A.IMDG_SUBS_RSK_LBL_CD4-- Sub Label 4" ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("            ,DECODE(LOG.MSG_FUNC_ID, 'O', DECODE(LOG.ACK_RCV_STS_CD, 'R', '', LOG.MSG_FUNC_ID), LOG.MSG_FUNC_ID) MSG_FUNC_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,LOG.MSG_SND_NO" ).append("\n"); 
		query.append("  			,F_LOG.SCR_FILE_NO" ).append("\n"); 
		query.append("            ,F_LOG.MSG_SND_NO   FIRST_MSG_SND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,A.NET_EXPLO_WGT" ).append("\n"); 
		query.append("        	" ).append("\n"); 
		query.append("		FROM BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("		     , BKG_CSTMS_EUR_DG_FWRD B" ).append("\n"); 
		query.append("			 ,SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("			 ,BKG_BOOKING C" ).append("\n"); 
		query.append("		     , (" ).append("\n"); 
		query.append("		            SELECT " ).append("\n"); 
		query.append("		                A.BAY_PLN_ID" ).append("\n"); 
		query.append("		                ,A.VSL_CD" ).append("\n"); 
		query.append("		                ,A.ETA_DT" ).append("\n"); 
		query.append("		                ,A.ETD_DT" ).append("\n"); 
		query.append("		                ,B.EUR_DG_CNTR_ID CNTR_NO" ).append("\n"); 
		query.append("		                ,B.CELL_PSN_NO" ).append("\n"); 
		query.append("		                ,B.POL_CD" ).append("\n"); 
		query.append("		                ,B.POD_CD" ).append("\n"); 
		query.append("		            FROM BKG_CSTMS_EUR_DG_BAY_PLN A" ).append("\n"); 
		query.append("		                 ,BKG_CSTMS_EUR_DG_BAY_DTL B" ).append("\n"); 
		query.append("		            WHERE A.BAY_PLN_ID = B.BAY_PLN_ID " ).append("\n"); 
		query.append("		            AND   A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		            AND   A.VSL_VOY_DIR_NO    = SUBSTR(@[vvd_cd], 5, 5)" ).append("\n"); 
		query.append("					AND   A.BAY_PLN_ID > ' '" ).append("\n"); 
		query.append("	            	AND   B.EUR_DG_CNTR_ID > ' '" ).append("\n"); 
		query.append("		            AND   B.BAY_PLN_ID  = @[bay_pln_id]" ).append("\n"); 
		query.append("		        ) BAY" ).append("\n"); 
		query.append("		     " ).append("\n"); 
		query.append("#if (${ui_type} == 'ESM_BKG_0965') " ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                    ,A.VSL_CD" ).append("\n"); 
		query.append("                    ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.PORT_CD" ).append("\n"); 
		query.append("                    ,B.BL_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                    ,B.EDI_RSPN_SEQ" ).append("\n"); 
		query.append("                    ,C.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("	                ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("					,BKG_CSTMS_EUR_DG_RCV C" ).append("\n"); 
		query.append("                WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("				AND   A.EUR_EDI_MSG_TP_ID= C.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = C.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                AND   (B.BL_NO, B.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                            ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                        	WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]                                                         " ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                            AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("											--AND '0' = INSTR(A.MSG_SND_NO, 'AC')" ).append("\n"); 
		query.append("                							GROUP BY A.EUR_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ) LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                    ,A.VSL_CD" ).append("\n"); 
		query.append("                    ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.PORT_CD" ).append("\n"); 
		query.append("                    ,B.BL_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_NO" ).append("\n"); 
		query.append("                    ,B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,B.MSG_SND_NO" ).append("\n"); 
		query.append("                    ,B.EDI_RSPN_SEQ" ).append("\n"); 
		query.append("                    ,(SELECT /*+ INDEX_DESC(BKG_CSTMS_EUR_DG_RCV XPKBKG_CSTMS_EUR_DG_RCV)*/ SCR_FILE_NO" ).append("\n"); 
		query.append("  						FROM BKG_CSTMS_EUR_DG_RCV" ).append("\n"); 
		query.append("  						WHERE EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("  						AND MSG_RCV_NO = A.MSG_SND_NO" ).append("\n"); 
		query.append(" 						AND ROWNUM = 1" ).append("\n"); 
		query.append("					) SCR_FILE_NO" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                	,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                AND   (B.BL_NO, B.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                 B.BL_NO, MAX(B.MSG_SND_NO)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                            ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                        	WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]                                                         " ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                            AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                                            AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("											GROUP BY A.EUR_EDI_MSG_TP_ID, B.BL_NO" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ) F_LOG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			-- 0966" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("					,A.VSL_CD" ).append("\n"); 
		query.append("                    ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.PORT_CD" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,A.MSG_SND_NO" ).append("\n"); 
		query.append("                    ,B.ACK_RCV_STS_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				FROM BKG_CSTMS_EUR_DG_SND A, BKG_CSTMS_EUR_DG_RCV B" ).append("\n"); 
		query.append("                WHERE A.EUR_EDI_MSG_TP_ID= B.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                AND   A.MSG_SND_NO = B.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND   A.EUR_DG_DECL_TP_CD = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.SND_DT = (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                MAX(A.SND_DT)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                            ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                                        	WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]                                                         " ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                							GROUP BY A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ) LOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                     A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("					,A.VSL_CD" ).append("\n"); 
		query.append("                    ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.PORT_CD" ).append("\n"); 
		query.append("                    ,A.MSG_FUNC_ID" ).append("\n"); 
		query.append("                    ,A.MSG_SND_NO" ).append("\n"); 
		query.append("                    ,(SELECT /*+ INDEX_DESC(BKG_CSTMS_EUR_DG_RCV XPKBKG_CSTMS_EUR_DG_RCV)*/ SCR_FILE_NO" ).append("\n"); 
		query.append("  						FROM BKG_CSTMS_EUR_DG_RCV" ).append("\n"); 
		query.append("  						WHERE EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("  						AND MSG_RCV_NO = A.MSG_SND_NO" ).append("\n"); 
		query.append(" 						AND ROWNUM = 1" ).append("\n"); 
		query.append("					) SCR_FILE_NO" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                                            " ).append("\n"); 
		query.append("                AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                                                    " ).append("\n"); 
		query.append("                AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                                                    " ).append("\n"); 
		query.append("                AND   A.PORT_CD     = @[port_cd]                                                                                 " ).append("\n"); 
		query.append("                AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("                AND   A.SND_DT = (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                 MAX(A.SND_DT)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                        	WHERE A.EUR_DG_DECL_TP_CD = @[d_type]                                                    " ).append("\n"); 
		query.append("                                        	AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)                                            " ).append("\n"); 
		query.append("                                        	AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)                                            " ).append("\n"); 
		query.append("                                       	 	AND   A.PORT_CD     = @[port_cd]                                                         " ).append("\n"); 
		query.append("                                            AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                            AND   A.MSG_FUNC_ID = 'O'" ).append("\n"); 
		query.append("											GROUP BY A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ) F_LOG" ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("		WHERE A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${d_type} != '') " ).append("\n"); 
		query.append("		AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   A.BL_NO 		= C.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   A.ANR_FWRD_ID = B.ANR_FWRD_ID(+)" ).append("\n"); 
		query.append("		AND   A.VSL_CD      = BAY.VSL_CD(+)" ).append("\n"); 
		query.append("		AND   A.POL_CD      = BAY.POL_CD(+)" ).append("\n"); 
		query.append("		AND   A.POD_CD      = BAY.POD_CD(+)" ).append("\n"); 
		query.append("		AND   A.CNTR_NO     = BAY.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   A.EUR_DG_DECL_TP_CD = LOG.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("        AND   A.VSL_CD      = LOG.VSL_CD(+)" ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO  = LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD  = LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND   A.PORT_CD     = LOG.PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   A.EUR_DG_DECL_TP_CD = F_LOG.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("        AND   A.VSL_CD      = F_LOG.VSL_CD(+)" ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO  = F_LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD  = F_LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND   A.PORT_CD     = F_LOG.PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   A.IMDG_UN_NO	= 	SIUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		AND   A.IMDG_UN_NO_SEQ = SIUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ui_type} == 'ESM_BKG_0965') " ).append("\n"); 
		query.append("        AND   A.BL_NO       = LOG.BL_NO(+)" ).append("\n"); 
		query.append("        AND   A.CNTR_NO     = LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND   A.CNTR_CGO_SEQ = LOG.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("        AND   A.BL_NO       = F_LOG.BL_NO(+)" ).append("\n"); 
		query.append("        AND   A.CNTR_NO     = F_LOG.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND   A.CNTR_CGO_SEQ = F_LOG.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("		) SUB1" ).append("\n"); 
		query.append("ORDER BY SEQ, BL_NO, POL_CD, POD_CD, CNTR_NO, CNTR_CGO_SEQ" ).append("\n"); 

	}
}