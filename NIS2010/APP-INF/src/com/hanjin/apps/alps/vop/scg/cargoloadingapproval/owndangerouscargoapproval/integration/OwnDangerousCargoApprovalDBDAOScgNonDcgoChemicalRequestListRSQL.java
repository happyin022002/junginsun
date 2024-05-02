/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoChemicalRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgNonDcgoChemicalRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON-DG CHEMICAL
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgNonDcgoChemicalRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dg_cgo_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoChemicalRequestListRSQL").append("\n"); 
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
		query.append("	E.BKG_NO" ).append("\n"); 
		query.append("	, E.BKG_NO_POP" ).append("\n"); 
		query.append("	, E.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("	, E.CNTR_NO" ).append("\n"); 
		query.append("	, E.VSL_CD" ).append("\n"); 
		query.append("	, E.SKD_VOY_NO" ).append("\n"); 
		query.append("	, E.SKD_DIR_CD" ).append("\n"); 
		query.append("	, E.VVD" ).append("\n"); 
		query.append("	, E.SLAN_CD" ).append("\n"); 
		query.append("	, E.CSTMS_DESC" ).append("\n"); 
		query.append("	, E.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("	, E.CMDT_DESC" ).append("\n"); 
		query.append("	, E.XTER_RMK" ).append("\n"); 
		query.append("	, E.INTER_RMK" ).append("\n"); 
		query.append("	, E.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("	, E.ODEK_FLG" ).append("\n"); 
		query.append("	, E.EML_SND_NO" ).append("\n"); 
		query.append("	, E.EML_SND_NO_POP" ).append("\n"); 
		query.append("	, E.RQST_USR_ID" ).append("\n"); 
		query.append("	, E.RQST_OFC_CD" ).append("\n"); 
		query.append("	, E.RQST_DT" ).append("\n"); 
		query.append("	, E.RQST_GDT" ).append("\n"); 
		query.append("	, E.EML_CTNT" ).append("\n"); 
		query.append("	, E.CRE_USR_ID" ).append("\n"); 
		query.append("	, E.CRE_DT" ).append("\n"); 
		query.append("	, E.UPD_USR_ID" ).append("\n"); 
		query.append("	, E.UPD_DT" ).append("\n"); 
		query.append("	, E.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("	, E.NON_DCGO_KW_NM" ).append("\n"); 
		query.append("	, E.POL_CD" ).append("\n"); 
		query.append("	, E.USR_EML" ).append("\n"); 
		query.append("	, E.BKG_DCGO_FLG" ).append("\n"); 
		query.append("	, E.CNTR_DCGO_FLG" ).append("\n"); 
		query.append("	, E.STWG_CD" ).append("\n"); 
		query.append("	, E.POL_ETA_DT" ).append("\n"); 
		query.append("	, E.NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("	, E.NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("	, E.NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("    , E.CMDT_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(SELECT " ).append("\n"); 
		query.append("		A.BKG_NO" ).append("\n"); 
		query.append("		, A.BKG_NO AS BKG_NO_POP" ).append("\n"); 
		query.append("		, A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("		, A.CNTR_NO" ).append("\n"); 
		query.append("		, A.VSL_CD" ).append("\n"); 
		query.append("		, A.SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.VSL_CD|| A.SKD_VOY_NO|| A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		, A.SLAN_CD" ).append("\n"); 
		query.append("		, A.CSTMS_DESC" ).append("\n"); 
		query.append("		, A.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("		, A.CMDT_DESC" ).append("\n"); 
		query.append("		, A.XTER_RMK" ).append("\n"); 
		query.append("		, A.INTER_RMK" ).append("\n"); 
		query.append("		, DECODE(A.SPCL_CGO_APRO_CD,'P','Pass','H','Hold','X','Undeclared') AS SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("		, DECODE(A.ODEK_FLG,'O','ONDECK','N/A') AS ODEK_FLG" ).append("\n"); 
		query.append("		, DECODE(NVL(A.EML_SND_NO,'N'),'N','N','Y') AS EML_SND_NO" ).append("\n"); 
		query.append("		, 'Send' AS EML_SND_NO_POP" ).append("\n"); 
		query.append("		, A.RQST_USR_ID" ).append("\n"); 
		query.append("		, A.RQST_OFC_CD" ).append("\n"); 
		query.append("		, A.RQST_DT" ).append("\n"); 
		query.append("		, TO_CHAR(A.RQST_GDT,'YYYY-MM-DDHH24:MI:SS') AS RQST_GDT" ).append("\n"); 
		query.append("		, A.EML_CTNT" ).append("\n"); 
		query.append("		, A.CRE_USR_ID" ).append("\n"); 
		query.append("		, A.CRE_DT" ).append("\n"); 
		query.append("		, A.UPD_USR_ID" ).append("\n"); 
		query.append("		, A.UPD_DT" ).append("\n"); 
		query.append("		, '' AS NON_DCGO_KW_SEQ -- 의미 없음 삭제해도됨" ).append("\n"); 
		query.append("		, '' AS NON_DCGO_KW_NM -- 의미 없음" ).append("\n"); 
		query.append("		, B.POL_CD" ).append("\n"); 
		query.append("		, (SELECT USR_EML FROM COM_USER WHERE USR_ID = B.DOC_USR_ID) AS USR_EML" ).append("\n"); 
		query.append("		, B.DCGO_FLG AS BKG_DCGO_FLG" ).append("\n"); 
		query.append("		, NVL((SELECT DCGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = A.BKG_NO AND CNTR_NO = A.CNTR_NO),'N') AS CNTR_DCGO_FLG" ).append("\n"); 
		query.append("		, B.STWG_CD" ).append("\n"); 
		query.append("		,(SELECT TO_CHAR(C.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	FROM VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	    AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	    AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND C.VPS_PORT_CD = B.POL_CD" ).append("\n"); 
		query.append("	    AND C.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("	) AS POL_ETA_DT" ).append("\n"); 
		query.append("	, A.NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("	, A.NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("	, A.NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("    , NVL((SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE B.CMDT_CD = CMDT.CMDT_CD),'') AS CMDT_NM" ).append("\n"); 
		query.append("	FROM SCG_NON_DG_CGO_KW_RQST A LEFT JOIN BKG_BOOKING B" ).append("\n"); 
		query.append("	ON A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	WHERE A.NON_DG_CHEM_FLG = 'Y'" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("		-- non_dg_cgo_status START" ).append("\n"); 
		query.append("		#if (${non_dg_cgo_status} == 'R') " ).append("\n"); 
		query.append("		    AND A.SPCL_CGO_APRO_CD IS NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		    AND A.SPCL_CGO_APRO_CD = @[non_dg_cgo_status]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- non_dg_cgo_status END" ).append("\n"); 
		query.append("		-- SLAN_CD 조건 사용안함 - 로직유지" ).append("\n"); 
		query.append("		#if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("		    AND A.SLAN_CD IN ( " ).append("\n"); 
		query.append("		        #foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("		            #if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("		                '$key', " ).append("\n"); 
		query.append("		            #else " ).append("\n"); 
		query.append("		                '$key' " ).append("\n"); 
		query.append("		            #end " ).append("\n"); 
		query.append("		        #end " ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- RQST_OFC_CD 조건 사용" ).append("\n"); 
		query.append("	    #if ($rqst_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("			AND	A.RQST_OFC_CD IN ( " ).append("\n"); 
		query.append("		    	#foreach($key IN ${rqst_ofc_cd}) " ).append("\n"); 
		query.append("                    #if($velocityCount < $rqst_ofc_cd.size()) " ).append("\n"); 
		query.append("                        '$key', " ).append("\n"); 
		query.append("                    #else " ).append("\n"); 
		query.append("                        '$key' " ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- rgn_shp_opr_cd START" ).append("\n"); 
		query.append("		#if (${rgn_shp_opr_cd} != 'ALL') " ).append("\n"); 
		query.append("		    AND (" ).append("\n"); 
		query.append("		         @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD FROM SCG_RGN_SHP_OPR_PORT" ).append("\n"); 
		query.append("                WHERE   B.POL_CD = LOC_CD " ).append("\n"); 
		query.append("                AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND		RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("              @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD  FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                 WHERE  (  SELECT OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                             FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                            WHERE OFC_N8TH_LVL_CD = (SELECT  EQ_CTRL_OFC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                      WHERE  NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                                        AND  LOC_CD  =   B.POL_CD)" ).append("\n"); 
		query.append("                    )   IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                WHERE   (" ).append("\n"); 
		query.append("						SELECT	DECODE(SYS_AREA_GRP_ID, 'SWA', 'SINRS', 'EUR', 'HAMRU', 'USA', 'NYCRA', 'KOR', 'SHARC', 'CHN', 'SHARC')" ).append("\n"); 
		query.append("                        FROM	COM_SYS_AREA_GRP_ID C, MDM_LOCATION D" ).append("\n"); 
		query.append("                        WHERE	C.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                            AND C.CNT_CD = SUBSTR(D.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                            AND EQ_CTRL_OFC_CD IS NULL" ).append("\n"); 
		query.append("                        AND   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL(CALL_PORT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                        AND     D.LOC_CD  =   B.POL_CD)" ).append("\n"); 
		query.append("                IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- rgn_shp_opr_cd END" ).append("\n"); 
		query.append("		AND TO_CHAR(A.RQST_DT,'YYYY-MM-DD') BETWEEN @[rqst_fr_dt] AND @[rqst_to_dt]" ).append("\n"); 
		query.append("	) E" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	-- dg_flg START" ).append("\n"); 
		query.append("	#if (${dg_flg} == '') " ).append("\n"); 
		query.append("   		#if (${non_dg_cgo_status} != 'H' && ${non_dg_cgo_status} != 'X' )  -- 'U','X'인 경우는 BOOKING에 D/G여도 보여줌" ).append("\n"); 
		query.append("     		AND (E.BKG_DCGO_FLG <> 'Y'  OR (  E.BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("            									AND 'Y' = ( CASE WHEN ( SELECT COUNT(1) " ).append("\n"); 
		query.append("                                                        FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("                                                       WHERE X.NON_DCGO_KW_SEQ      = Y.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                                                         AND X.BKG_NO               = E.BKG_NO" ).append("\n"); 
		query.append("                                                         AND X.NON_DCGO_RQST_SEQ    = E.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                         AND Y.NON_DCGO_CATE_GRP_CD = 'A' ) = 0 THEN 'N' " ).append("\n"); 
		query.append("                                               ELSE 'Y'" ).append("\n"); 
		query.append("                                           END ) " ).append("\n"); 
		query.append("                ))" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#elseif(${dg_flg} == 'N') " ).append("\n"); 
		query.append("		AND E.BKG_DCGO_FLG <> 'Y'" ).append("\n"); 
		query.append("	#elseif(${dg_flg} == 'D') " ).append("\n"); 
		query.append("		#if (${non_dg_cgo_status} == 'H' || ${non_dg_cgo_status} == 'X')" ).append("\n"); 
		query.append("		    AND E.BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		    AND E.BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("		    AND 'Y' = ( CASE WHEN ( SELECT COUNT(1) " ).append("\n"); 
		query.append("                              FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("                             WHERE X.NON_DCGO_KW_SEQ      = Y.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                               AND X.BKG_NO               = E.BKG_NO" ).append("\n"); 
		query.append("                               AND X.NON_DCGO_RQST_SEQ    = E.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                               AND Y.NON_DCGO_CATE_GRP_CD = 'A' ) = 0 THEN 'N'" ).append("\n"); 
		query.append("                     ELSE 'Y'" ).append("\n"); 
		query.append("                 END )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- dg_flg END" ).append("\n"); 
		query.append("ORDER BY E.BKG_NO, E.NON_DCGO_RQST_SEQ" ).append("\n"); 

	}
}