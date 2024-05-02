/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchTrsSvcOrdBkgChmHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchTrsSvcOrdBkgChmHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrsSvcOrdBkgChmHis
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchTrsSvcOrdBkgChmHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchTrsSvcOrdBkgChmHisRSQL").append("\n"); 
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
		query.append("SELECT T.*" ).append("\n"); 
		query.append("      ,PRE_VAL1 PRE_VAL" ).append("\n"); 
		query.append("  FROM (select K.TRSP_SO_OFC_CTY_CD_SEQ || K.CAT_CATE_SUB|| LPAD(K.TRSP_CNG_SUB_SEQ, 4, '0') AS BKG_CNG_GROUP" ).append("\n"); 
		query.append("			  ,K.*" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB IN ('VVSV', 'VVTV', 'SCAW') THEN REPLACE(K.COL_NM, ',', '|')" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCDG') THEN REPLACE(K.COL_NM, 'IMDG_UN_NO,IMDG_UN_NO_SEQ', 'IMDG_UN_NO|IMDG_UN_NO_SEQ')" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCRF') THEN REPLACE(COL_NM, 'CDO_TEMP,FDO_TEMP', 'CDO_TEMP|FDO_TEMP')" ).append("\n"); 
		query.append("                 ELSE COL_NM" ).append("\n"); 
		query.append("               END NEW_COLNM1" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB IN ('VVSV', 'VVTV', 'SCAW') THEN REPLACE(NEW_VALUE, '@#@', '|')" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCDG') THEN (SUBSTR(NEW_VALUE, 0, INSTR(NEW_VALUE, '@#@') - 1) || SUBSTR(NEW_VALUE, INSTR(NEW_VALUE, '@#@') + 3))" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCRF') THEN (SUBSTR(NEW_VALUE, 0, INSTR(NEW_VALUE, '@#@') - 1) || SUBSTR(NEW_VALUE, INSTR(NEW_VALUE, '@#@') + 3))" ).append("\n"); 
		query.append("                 ELSE NEW_VALUE" ).append("\n"); 
		query.append("               END NEW_VAL1" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB IN ('VVSV', 'VVTV', 'SCAW') THEN REPLACE(PREVIOUS_VALUE, '@#@', '|')" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCDG') THEN (SUBSTR(PREVIOUS_VALUE, 0, INSTR(PREVIOUS_VALUE, '@#@') - 1) || SUBSTR(PREVIOUS_VALUE, INSTR(PREVIOUS_VALUE, '@#@') + 3))" ).append("\n"); 
		query.append("                 WHEN CAT_CATE_SUB = ('SCRF') THEN (SUBSTR(PREVIOUS_VALUE, 0, INSTR(PREVIOUS_VALUE, '@#@') - 1) || SUBSTR(PREVIOUS_VALUE, INSTR(PREVIOUS_VALUE, '@#@') + 3))" ).append("\n"); 
		query.append("                 ELSE PREVIOUS_VALUE" ).append("\n"); 
		query.append("               END PRE_VAL1" ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                 WHEN K.CNG_CATE_CD = 'VV' THEN 'Vessel'" ).append("\n"); 
		query.append("                 WHEN K.CNG_CATE_CD = 'AT' THEN 'Appt'" ).append("\n"); 
		query.append("                 WHEN K.CNG_CATE_CD = 'CN' THEN 'Nature'" ).append("\n"); 
		query.append("                 WHEN K.CNG_CATE_CD = 'CR' THEN 'Release'" ).append("\n"); 
		query.append("                 WHEN K.CAT_CATE_SUB = 'SCRF' THEN 'RF'" ).append("\n"); 
		query.append("                 WHEN K.CAT_CATE_SUB = 'SCDG' THEN 'DG'" ).append("\n"); 
		query.append("                 WHEN K.CAT_CATE_SUB = 'SCAW' THEN 'AK'" ).append("\n"); 
		query.append("				 WHEN K.CNG_CATE_CD  = 'CT'   THEN 'Cut Off Time'" ).append("\n"); 
		query.append("               END CNG_CATE_CD_DESC" ).append("\n"); 
		query.append("              ,'' CNG_CATE_SUB_CD_DESC" ).append("\n"); 
		query.append("              ,'' NOW_READ_VAL" ).append("\n"); 
		query.append("              ,'' PREVIOUS_VAL" ).append("\n"); 
		query.append("              ,'' NEW_COLNM" ).append("\n"); 
		query.append("          FROM (SELECT H.BKG_NO" ).append("\n"); 
		query.append("                      ,C.EQ_NO" ).append("\n"); 
		query.append("                      ,D.CNTR_NO" ).append("\n"); 
		query.append("                      ,C.CNTR_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      ,D.CNTR_TPSZ_CD AS BKG_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_OFC_CTY_CD || H.TRSP_SO_SEQ AS TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_SUB_SEQ" ).append("\n"); 
		query.append("                      ,H.TRSP_CNG_SUB_SEQ" ).append("\n"); 
		query.append("                      ,H.CNG_CATE_CD" ).append("\n"); 
		query.append("                      ,H.CNG_CATE_CD || H.CNG_CATE_SUB_CD AS CAT_CATE_SUB" ).append("\n"); 
		query.append("                      ,H.CNG_CATE_SUB_CD" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_OFC_CTY_CD BKG_TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      ,H.TRSP_SO_SEQ AS BKG_TRSP_SO_SEQ" ).append("\n"); 
		query.append("                      ,H.CNG_IND_FLG" ).append("\n"); 
		query.append("                      ,DECODE(H.CNG_IND_FLG, 'N', 'N', H.CNG_IND_FLG) AS BKG_CNG_IND_FLG" ).append("\n"); 
		query.append("                      ,D.COL_NM" ).append("\n"); 
		query.append("                      ,(CASE" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'SC' AND H.CNG_CATE_SUB_CD = 'DG' THEN H.COL_N1ST_RMK || '@#@' || H.COL_N2ND_RMK" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'AT' AND H.CNG_CATE_SUB_CD = 'AU' THEN H.COL_N1ST_RMK || '@#@' || H.COL_N2ND_RMK" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'AT' AND H.CNG_CATE_SUB_CD = 'EU' THEN H.COL_N1ST_RMK || '@#@' || H.COL_N2ND_RMK" ).append("\n"); 
		query.append("                         ELSE H.COL_N1ST_RMK" ).append("\n"); 
		query.append("                       END) NEW_VALUE" ).append("\n"); 
		query.append("                      ,(CASE" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'SC' AND H.CNG_CATE_SUB_CD = 'DG' THEN H.PRE_COL_N1ST_RMK || '@#@' || H.PRE_COL_N2ND_RMK" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'AT' AND H.CNG_CATE_SUB_CD = 'AU' THEN H.PRE_COL_N1ST_RMK || '@#@' || H.PRE_COL_N2ND_RMK" ).append("\n"); 
		query.append("                         WHEN H.CNG_CATE_CD = 'AT' AND H.CNG_CATE_SUB_CD = 'EU' THEN H.PRE_COL_N1ST_RMK || '@#@' || H.PRE_COL_N2ND_RMK" ).append("\n"); 
		query.append("                         ELSE H.PRE_COL_N1ST_RMK" ).append("\n"); 
		query.append("                       END) AS PREVIOUS_VALUE" ).append("\n"); 
		query.append("                      ,U.USR_NM USR_NM" ).append("\n"); 
		query.append("                      ,C.CRE_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                      ,H.UPD_USR_ID" ).append("\n"); 
		query.append("                      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), H.UPD_DT, GLOBALDATE_PKG.GET_LOCCD_FNC(C.CRE_OFC_CD)) , 'YYYY-MM-DD HH24:MI:SS') LOCL_UPD_DT" ).append("\n"); 
		query.append("                      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), H.UPD_DT, 'GMT') , 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_SVC_ORD_BKG_CNG H" ).append("\n"); 
		query.append("                      ,TRS_TRSP_SVC_ORD_CNG     C" ).append("\n"); 
		query.append("                      ,TRS_TRSP_BKG_CNG         D" ).append("\n"); 
		query.append("                      ,COM_USER                 U" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND (H.TRSP_SO_OFC_CTY_CD, H.TRSP_SO_SEQ, H.BKG_NO) IN (" ).append("\n"); 
		query.append("                   #foreach($trsp_so_bkg_num IN ${trsp_so_bkg})" ).append("\n"); 
		query.append("                      $trsp_so_bkg_num " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   )    " ).append("\n"); 
		query.append("                   AND H.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND H.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND H.TRSP_SO_SUB_SEQ = C.TRSP_SO_SUB_SEQ" ).append("\n"); 
		query.append("                   AND H.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                   AND H.CNG_CATE_CD = D.CNG_CATE_CD" ).append("\n"); 
		query.append("                   AND H.CNG_CATE_SUB_CD = D.CNG_CATE_SUB_CD" ).append("\n"); 
		query.append("                   AND H.TRSP_CNG_SUB_SEQ = D.TRSP_CNG_SUB_SEQ" ).append("\n"); 
		query.append("                   AND H.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("                   AND H.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("		) K" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("ORDER BY BKG_CNG_GROUP" ).append("\n"); 

	}
}