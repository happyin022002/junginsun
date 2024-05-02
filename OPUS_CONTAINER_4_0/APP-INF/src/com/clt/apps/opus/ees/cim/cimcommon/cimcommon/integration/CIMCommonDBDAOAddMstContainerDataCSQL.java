/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOAddMstContainerDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOAddMstContainerDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST_CONTAINER 테이블에 저장
	  * CTM_MOVEMENT CM, 
	  * MDM_EQ_ORZ_CHT ME Join
	  * </pre>
	  */
	public CIMCommonDBDAOAddMstContainerDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOAddMstContainerDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CONTAINER MC ( " ).append("\n"); 
		query.append("      LOC_CD" ).append("\n"); 
		query.append("	, SCC_CD" ).append("\n"); 
		query.append("	, LCC_CD" ).append("\n"); 
		query.append("	, ECC_CD" ).append("\n"); 
		query.append("	, RCC_CD" ).append("\n"); 
		query.append("	, SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	, CNMV_YR" ).append("\n"); 
		query.append("	, CNMV_ID_NO" ).append("\n"); 
		query.append("	, CNMV_SEQ" ).append("\n"); 
		query.append("	, CNMV_CYC_NO" ).append("\n"); 
		query.append("	, CNMV_DT" ).append("\n"); 
		query.append("	, CNMV_GDT" ).append("\n"); 
		query.append("	, PRE_STS_FLG" ).append("\n"); 
		query.append("	, BKG_NO" ).append("\n"); 
		query.append("	, BKG_KNT" ).append("\n"); 
		query.append("	, FULL_FLG" ).append("\n"); 
		query.append("	, CRNT_YD_CD" ).append("\n"); 
		query.append("	, DEST_YD_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, CNMV_STS_CD" ).append("\n"); 
		query.append("	, IMDT_EXT_FLG" ).append("\n"); 
		query.append("	, CO_CRE_FLG" ).append("\n"); 
		query.append("	, UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("	, UCLM_DT" ).append("\n"); 
		query.append("	, UCLM_FREE_DYS" ).append("\n"); 
		query.append("	, UCLM_END_DT" ).append("\n"); 
		query.append("	, UCLM_RSN" ).append("\n"); 
		query.append("	, UCLM_PLN_RMK" ).append("\n"); 
		query.append("	, UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("			ML.LOC_CD, " ).append("\n"); 
		query.append("			ME.SCC_CD, " ).append("\n"); 
		query.append("			ME.LCC_CD, " ).append("\n"); 
		query.append("			ME.ECC_CD," ).append("\n"); 
		query.append("			ME.RCC_CD, " ).append("\n"); 
		query.append("			(SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				FROM   COM_SYS_AREA_GRP_ID B   " ).append("\n"); 
		query.append("				WHERE SUBSTR(CM.INP_YD_CD, 1, 2) = B.CNT_CD" ).append("\n"); 
		query.append("				AND   B.CO_IND_CD                = 'H'" ).append("\n"); 
		query.append("				AND   ROWNUM                     = 1)" ).append("\n"); 
		query.append("		   , CM.CNMV_YR       " ).append("\n"); 
		query.append("		  , CM.CNMV_ID_NO" ).append("\n"); 
		query.append("		  , CM.CNMV_SEQ" ).append("\n"); 
		query.append("		  , CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("		  , CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("		  , GLOBALDATE_PKG.TIME_CONV_FNC ( SUBSTR(CM.INP_YD_CD, 1, 5), CM.CNMV_EVNT_DT, 'GMT' )" ).append("\n"); 
		query.append("		  , NVL(CM.PRE_STS_FLG, 'N')" ).append("\n"); 
		query.append("		  , CM.BKG_NO" ).append("\n"); 
		query.append("		  , CM.BKG_KNT" ).append("\n"); 
		query.append("		  , NVL(CM.FCNTR_FLG, 'F')" ).append("\n"); 
		query.append("		  , CM.INP_YD_CD" ).append("\n"); 
		query.append("		  , CM.DEST_YD_CD" ).append("\n"); 
		query.append("		  , CM.TRNK_VSL_CD VSL_CD" ).append("\n"); 
		query.append("		  , CM.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("		  , CM.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("		  , CM.MVMT_STS_CD" ).append("\n"); 
		query.append("		  , @[imdt_ext_flg]" ).append("\n"); 
		query.append("		  , 'N'" ).append("\n"); 
		query.append("		  , '' AS UCLM_LS_DIV_CD " ).append("\n"); 
		query.append("          , '' AS UCLM_DT " ).append("\n"); 
		query.append("          , '' AS UCLM_FREE_DYS " ).append("\n"); 
		query.append("          , '' AS UCLM_END_DT " ).append("\n"); 
		query.append("          , '' AS UCLM_RSN " ).append("\n"); 
		query.append("          , '' AS UCLM_PLN_RMK " ).append("\n"); 
		query.append("          , '' AS UCLM_CNTC_PNT_NM           " ).append("\n"); 
		query.append("		  , CM.UPD_USR_ID" ).append("\n"); 
		query.append("		  , CM.UPD_DT             " ).append("\n"); 
		query.append("		FROM  CTM_MOVEMENT CM, " ).append("\n"); 
		query.append("			  MDM_EQ_ORZ_CHT ME, " ).append("\n"); 
		query.append("			  MDM_LOCATION ML" ).append("\n"); 
		query.append("			,  ( SELECT SB.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("					 , MAX(SB.CNMV_YR) AS CNMV_YR" ).append("\n"); 
		query.append("					 , SUBSTR(MAX(SB.CNMV_YR||TO_CHAR(SB.CNMV_ID_NO, '00000')) , - 5) AS CNMV_ID_NO" ).append("\n"); 
		query.append("					 , SUBSTR(MAX(SB.CNMV_YR||TO_CHAR(SB.CNMV_ID_NO, '00000')||TO_CHAR(SB.CNMV_SEQ, '0000')) , - 4) AS CNMV_SEQ" ).append("\n"); 
		query.append("				 FROM CTM_MOVEMENT SB" ).append("\n"); 
		query.append("				 WHERE SB.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("				 GROUP BY SB.CNTR_NO) SB                            " ).append("\n"); 
		query.append("		WHERE  SB.CNTR_NO         = 'CAIU5543281'" ).append("\n"); 
		query.append("			AND  SB.CNMV_YR       = CM.CNMV_YR" ).append("\n"); 
		query.append("			AND  SB.CNMV_ID_NO    = CM.CNMV_ID_NO" ).append("\n"); 
		query.append("			AND  SB.CNMV_SEQ      = CM.CNMV_SEQ" ).append("\n"); 
		query.append("			AND  ME.SCC_CD(+)     = ML.SCC_CD" ).append("\n"); 
		query.append("		    AND   ML.LOC_CD(+)    = SUBSTR(CM.INP_YD_CD,0,5)   " ).append("\n"); 
		query.append("		    AND  ROWNUM           = 1" ).append("\n"); 

	}
}