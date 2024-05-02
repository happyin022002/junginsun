/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSearchBkgHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSearchBkgHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flatFile  detail정보 조회 
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSearchBkgHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSearchBkgHdrRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append("     --, TO_CHAR(B.BKG_CRE_DT	, 'YYYYMMDDHH24MI')     AS BKG_DT" ).append("\n"); 
		query.append("	 , TO_CHAR(SYSDATE		,' YYYYMMDDHH24MI')     AS BKG_DT" ).append("\n"); 
		query.append("     , B.BL_NO" ).append("\n"); 
		query.append("     , B.BKG_STS_CD" ).append("\n"); 
		query.append("     , B.VVD" ).append("\n"); 
		query.append("     , B.VSL_CD" ).append("\n"); 
		query.append("     , B.SKD_VOY_NO" ).append("\n"); 
		query.append("     , B.SKD_DIR_CD" ).append("\n"); 
		query.append("     , C.VSL_ENG_NM                    AS VESSEL_NM" ).append("\n"); 
		query.append("     , B.RCV_TERM_CD" ).append("\n"); 
		query.append("     , B.DE_TERM_CD" ).append("\n"); 
		query.append("     , B.POL_CD" ).append("\n"); 
		query.append("     , VSK_COMMON_PKG.GET_LOC_NM_FNC(B.POL_CD)     AS POL_NM" ).append("\n"); 
		query.append("     , B.POL_YD_CD                   AS POL_NOD_CD" ).append("\n"); 
		query.append("   	 , B.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , B.POD_CD                   " ).append("\n"); 
		query.append("     , VSK_COMMON_PKG.GET_LOC_NM_FNC(B.POD_CD)     AS POD_NM" ).append("\n"); 
		query.append("     , B.POD_YD_CD                   " ).append("\n"); 
		query.append("   	 , B.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , B.BKG_POR_CD                 AS POR_CD" ).append("\n"); 
		query.append("     , VSK_COMMON_PKG.GET_LOC_NM_FNC(B.BKG_POR_CD)   AS POR_NM" ).append("\n"); 
		query.append("     , B.BKG_DEL_CD                 AS DEL_CD" ).append("\n"); 
		query.append("     , VSK_COMMON_PKG.GET_LOC_NM_FNC(B.BKG_DEL_CD)   AS DEL_NM" ).append("\n"); 
		query.append("     , B.BKG_CMDT_CD                 AS CMDT_CD" ).append("\n"); 
		query.append("     , (SELECT MC.CMDT_NM FROM MDM_COMMODITY MC WHERE MC.CMDT_CD = BKG_CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("     , B.BKG_FLEX_HGT_FLG               AS FLEX_HGT_FLG" ).append("\n"); 
		query.append("     , B.SLAN_CD " ).append("\n"); 
		query.append("     , C.CALL_SGN_NO" ).append("\n"); 
		query.append("     , C.LLOYD_NO" ).append("\n"); 
		query.append("     , C.VSL_ENG_NM" ).append("\n"); 
		query.append("     , VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD,B.POL_CD,'O') OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , ( SELECT CASE WHEN R.MAPG_EDI_TRSM_STS_CD IS NULL     THEN 'N'" ).append("\n"); 
		query.append("                     WHEN R.MAPG_EDI_TRSM_STS_CD IS NOT NULL   THEN 'U'" ).append("\n"); 
		query.append("                   ELSE 'N'" ).append("\n"); 
		query.append("              END EDI_MSG_STS_CD" ).append("\n"); 
		query.append("           FROM SCG_APRO_RQST       R" ).append("\n"); 
		query.append("          WHERE R.BKG_NO             = B.BKG_NO" ).append("\n"); 
		query.append("            AND LST_RQST_DAT_FLG     = 'N'" ).append("\n"); 
		query.append("            AND SPCL_CGO_APRO_RQST_SEQ   = (SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) " ).append("\n"); 
		query.append("                                            FROM  SCG_APRO_RQST S" ).append("\n"); 
		query.append("                                           WHERE  S.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                                             AND  S.LST_RQST_DAT_FLG = 'N')" ).append("\n"); 
		query.append("       )    EDI_MSG_STS_CD" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("		----------------------------------------------------------------- " ).append("\n"); 
		query.append("		SELECT YY.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("            , YY.BKG_NO" ).append("\n"); 
		query.append("            , CONCAT(CONCAT(YY.VSL_CD,YY.SKD_VOY_NO),YY.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("            , YY.VSL_CD" ).append("\n"); 
		query.append("            , YY.SKD_VOY_NO" ).append("\n"); 
		query.append("            , YY.SKD_DIR_CD            " ).append("\n"); 
		query.append("            , YY.SLAN_CD" ).append("\n"); 
		query.append("            , YY.POL_CD" ).append("\n"); 
		query.append("            , YY.POD_CD" ).append("\n"); 
		query.append("            , YY.POL_YD_CD" ).append("\n"); 
		query.append("            , YY.POD_YD_CD" ).append("\n"); 
		query.append("      		, YY.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      		, YY.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            -------------------------" ).append("\n"); 
		query.append("            , BK.BL_NO" ).append("\n"); 
		query.append("            , BK.BKG_STS_CD" ).append("\n"); 
		query.append("            , BK.BKG_CRE_DT" ).append("\n"); 
		query.append("            , BK.RCV_TERM_CD" ).append("\n"); 
		query.append("            , BK.DE_TERM_CD" ).append("\n"); 
		query.append("            , BK.CMDT_CD       				AS BKG_CMDT_CD" ).append("\n"); 
		query.append("            , BK.POR_CD        				AS BKG_POR_CD" ).append("\n"); 
		query.append("            , BK.POL_CD        				AS BKG_POL_CD" ).append("\n"); 
		query.append("            , BK.POD_CD        				AS BKG_POD_CD" ).append("\n"); 
		query.append("            , BK.DEL_CD        				AS BKG_DEL_CD" ).append("\n"); 
		query.append("            , BK.FLEX_HGT_FLG   			AS BKG_FLEX_HGT_FLG" ).append("\n"); 
		query.append("            -------------------------" ).append("\n"); 
		query.append("         FROM BKG_BOOKING       			BK" ).append("\n"); 
		query.append("            --, BKG_VVD BV" ).append("\n"); 
		query.append("			, SCG_APRO_RQST     			XX" ).append("\n"); 
		query.append("            , SCG_VVD_APRO_RQST 			YY" ).append("\n"); 
		query.append("            , MDM_VSL_SVC_LANE  			SL" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND   XX.BKG_NO         			= YY.BKG_NO" ).append("\n"); 
		query.append("        AND   XX.SPCL_CGO_APRO_RQST_SEQ 	= YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("        AND   XX.LST_RQST_DAT_FLG       	= 'Y' " ).append("\n"); 
		query.append("		AND	  BK.BKG_NO                     = @[bkg_no]" ).append("\n"); 
		query.append("        AND   BK.BKG_NO                     = YY.BKG_NO" ).append("\n"); 
		query.append("        AND   YY.SLAN_CD                    = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND   SL.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("        --::2015-06-25::--AND SL.VSL_SVC_TP_CD             <> 'O'" ).append("\n"); 
		query.append("        AND   YY.VSL_PRE_PST_CD             = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("        AND   YY.VSL_SEQ                    = @[vsl_seq]" ).append("\n"); 
		query.append("		-----------------------------------------------------------------" ).append("\n"); 
		query.append("		) 									B" ).append("\n"); 
		query.append("	,	MDM_VSL_CNTR 						C" ).append("\n"); 
		query.append("WHERE 	1 = 1" ).append("\n"); 
		query.append("AND		B.VSL_CD         					= C.VSL_CD (+)" ).append("\n"); 
		query.append("AND		C.DELT_FLG       					= 'N'" ).append("\n"); 

	}
}