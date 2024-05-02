/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchRelredMasterForEmptyReleaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchRelredMasterForEmptyReleaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COREOR 전송 시 RELRED도 보내기 위한 Master information
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchRelredMasterForEmptyReleaseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchRelredMasterForEmptyReleaseRSQL").append("\n"); 
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
		query.append("SELECT CHR(10)" ).append("\n"); 
		query.append("	|| 'STATUS:'		|| T.STATUS                                 || CHR(10)" ).append("\n"); 
		query.append("    || 'BOUND:'	        || T.BD									    || CHR(10)" ).append("\n"); 
		query.append("	|| 'MSG_ID:'		|| T.MSG_ID    						      	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'EQREL:'		    || T.EQREL          						|| CHR(10)" ).append("\n"); 
		query.append("    || 'EQREL_LOC:'		|| T.EQREL_LOC             					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'EQREL_NAME:'	|| T.EQREL_NAME              				|| CHR(10)	" ).append("\n"); 
		query.append("	|| 'EQRES:'		    || T.EQRES							        || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQRES_LOC:'		|| T.EQRES_LOC                              || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQRES_NAME:'	|| T.EQRES_NAME		         				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'MTY_CY:'		|| T.EMPTY_CY		                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'MTY_CY_DESC:'	|| T.MTY_CY_DESC							|| CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_NO:'		|| T.BKG_NO                           		|| CHR(10)" ).append("\n"); 
		query.append("    || 'BL_NO:'		    || T.BL_NO    				                || CHR(10)" ).append("\n"); 
		query.append("	|| 'WO_NO:'		    || T.WO_NO							        || CHR(10)" ).append("\n"); 
		query.append("	|| 'EPP_REF:'		|| T.EPP_REF				                || CHR(10)" ).append("\n"); 
		query.append("	|| 'VSL_CALL:'	    || T.VSL_CALL   							|| CHR(10)		" ).append("\n"); 
		query.append("    || 'VSL_LOYD:'	    || T.VSL_LOYD   							|| CHR(10)	" ).append("\n"); 
		query.append("	|| 'VSL_NAME:'	    || T.VSL_NAME							    || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD:'		    || T.VVD                                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'CONSORT_VOY:'	|| T.CONSORT_VOY		         			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL:'		    || T.POL		                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_DESC:'		|| T.POL_DESC							    || CHR(10)" ).append("\n"); 
		query.append("    || 'POD:'		    || T.POD                          			|| CHR(10)" ).append("\n"); 
		query.append("    || 'POD_DESC:'		|| T.POD_DESC    				            || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEST:'		    || T.DEST							        || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEST_DESC:'		|| T.DEST_DESC				                || CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD_ETD:'		|| T.VVD_ETD   							    || CHR(10)" ).append("\n"); 
		query.append("    || 'VVD_ETA:'	    ||  T.VVD_ETA             					|| CHR(10)	" ).append("\n"); 
		query.append("	|| 'SHPR:'		    || T.SHPR							        || CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE:'		    || T.CNEE                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY:'		    || T.NTFY		         					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HAUL_TYPE:'		|| T.HAUL_TYPE		                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'SHIP_OPR:'	    || T.SHIP_OPR							    || CHR(10)" ).append("\n"); 
		query.append("    || 'DR_IND:'	    || T.DR_IND                           		|| CHR(10)" ).append("\n"); 
		query.append("    || 'RF_IND:'	    || T.RF_IND    				                || CHR(10)" ).append("\n"); 
		query.append("    || 'AK_IND:'	    || T.AK_IND    				                || CHR(10)" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("       'N'   AS STATUS -- N(Original), U(Correction), C(Cancel)" ).append("\n"); 
		query.append("      ,DECODE(@[gubun],'BKG','I','O')  AS BD   --BKG이 아닌 CTM에서 부르면 OB, BKG COREOR시 부르면 IB" ).append("\n"); 
		query.append("	  ,DECODE(@[gubun],'BKG','MTRESORD','MTRELORD')  AS MSG_ID" ).append("\n"); 
		query.append("      ,DECODE(@[gubun],'BKG',@[yd_cd],BK.MTY_PKUP_YD_CD) AS EQREL " ).append("\n"); 
		query.append("      ,(SELECT LOC_CD " ).append("\n"); 
		query.append("         FROM MDM_LOCATION " ).append("\n"); 
		query.append("        WHERE LOC_CD = (SELECT LOC_CD " ).append("\n"); 
		query.append("                          FROM MDM_YARD " ).append("\n"); 
		query.append("                         WHERE YD_CD = DECODE(@[gubun],'BKG',@[yd_cd],BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("                        )) AS EQREL_LOC" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD =(SELECT LOC_CD " ).append("\n"); 
		query.append("                          FROM MDM_YARD " ).append("\n"); 
		query.append("                          WHERE YD_CD = DECODE(@[gubun],'BKG',@[yd_cd],BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("                        )) AS EQREL_NAME" ).append("\n"); 
		query.append("      ,NVL(DECODE(@[gubun],'BKG',@[mty_rtn_yd_cd],BUT.NOD_CD),BUT.NOD_CD) AS EQRES --EQRTN" ).append("\n"); 
		query.append("      ,(SELECT LOC_CD " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD =(SELECT LOC_CD " ).append("\n"); 
		query.append("                          FROM MDM_YARD " ).append("\n"); 
		query.append("                         WHERE YD_CD = NVL(DECODE(@[gubun],'BKG',@[mty_rtn_yd_cd],BUT.NOD_CD),BUT.NOD_CD)" ).append("\n"); 
		query.append("                        ))  AS EQRES_LOC" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD =(SELECT LOC_CD " ).append("\n"); 
		query.append("                          FROM MDM_YARD " ).append("\n"); 
		query.append("                         WHERE YD_CD = NVL(DECODE(@[gubun],'BKG',@[mty_rtn_yd_cd],BUT.NOD_CD),BUT.NOD_CD)" ).append("\n"); 
		query.append("                        ))  AS EQRES_NAME" ).append("\n"); 
		query.append("      ,DECODE(@[gubun],'BKG',@[yd_cd],BK.MTY_PKUP_YD_CD) EMPTY_CY" ).append("\n"); 
		query.append("      ,(SELECT YD_NM " ).append("\n"); 
		query.append("         FROM MDM_YARD " ).append("\n"); 
		query.append("        WHERE YD_CD =DECODE(@[gubun],'BKG',@[yd_cd],BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("        ) AS MTY_CY_DESC 	 " ).append("\n"); 
		query.append("      ,BK.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("	  ,BK.BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,'' AS WO_NO" ).append("\n"); 
		query.append("      ,'' AS EPP_REF" ).append("\n"); 
		query.append("      ,VSL.CALL_SGN_NO AS VSL_CALL" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO AS VSL_LOYD" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM AS VSL_NAME" ).append("\n"); 
		query.append("      ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,DECODE(@[gubun],'BKG',NVL(IBVSK.IB_CSSM_VOY_NO, ' '),NVL(OBVSK.OB_CSSM_VOY_NO, ' ')) AS CONSORT_VOY" ).append("\n"); 
		query.append("      ,BK.POL_CD AS POL" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POL_CD) AS POL_DESC" ).append("\n"); 
		query.append("      ,BK.POD_CD AS POD" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POD_CD) AS POD_DESC" ).append("\n"); 
		query.append("      ,BK.DEL_CD AS DEST" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) AS DEST_DESC  " ).append("\n"); 
		query.append("      ,TO_CHAR(ETD.VPS_ETD_DT, 'YYYYMMDDHH24MM') AS VVD_ETD" ).append("\n"); 
		query.append("      ,TO_CHAR(ETA.VPS_ETA_DT, 'YYYYMMDDHH24MM') AS VVD_ETA        " ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(S.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS SHPR" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(C.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS CNEE" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(N.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS NTFY" ).append("\n"); 
		query.append("      ,'M' AS HAUL_TYPE" ).append("\n"); 
		query.append("      ,'' AS SHIP_OPR" ).append("\n"); 
		query.append("      ,BK.DCGO_FLG AS DR_IND" ).append("\n"); 
		query.append("      ,BK.RC_FLG AS RF_IND" ).append("\n"); 
		query.append("      ,BK.AWK_CGO_FLG AS AK_IND	  " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       BKG_BOOKING      BK" ).append("\n"); 
		query.append("      ,BKG_CONTAINER    CNTR" ).append("\n"); 
		query.append("      ,BKG_VVD          BVVD" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     S" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     C" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     N" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     VSL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD IBVSK" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD OBVSK" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETA" ).append("\n"); 
		query.append("     , (SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/ D.NOD_CD, H.BKG_NO, H.CNTR_NO, NVL(D.ACT_DT, D.ESTM_DT) ACT_DT" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'MT'" ).append("\n"); 
		query.append("             AND D.ACT_CD ='MITYAD'" ).append("\n"); 
		query.append("             AND ROWNUM=1) BUT" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BVVD.BKG_NO(+)              = BK.BKG_NO  " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gubun} == 'BKG') " ).append("\n"); 
		query.append("   AND BVVD.POD_CD(+)              = BK.POD_CD " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND BVVD.POL_CD(+)              = BK.POL_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND BK.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S' = S.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'C' = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'N' = N.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BVVD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.VSL_CD = ETD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_VOY_NO = ETD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_DIR_CD = ETD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.POL_CD = ETD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.VSL_CD = ETA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_VOY_NO = ETA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_DIR_CD = ETA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.POD_CD = ETA.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.VSL_CD                 = IBVSK.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_VOY_NO             = IBVSK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_DIR_CD             = IBVSK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.POD_CD                 = IBVSK.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND IBVSK.CLPT_IND_SEQ(+)         = '1'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND BVVD.VSL_CD                 = OBVSK.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_VOY_NO             = OBVSK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND BVVD.SKD_DIR_CD             = OBVSK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND BVVD.POL_CD                 = OBVSK.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND OBVSK.CLPT_IND_SEQ(+)         = '1'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR.BKG_NO  = BUT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO = BUT.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}