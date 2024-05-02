/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchDoCheckReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
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

public class CargoReleaseOrderDBDAOsearchDoCheckReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Delivery - Cargo Release Order List Check Report(UI_BKG-0131)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchDoCheckReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evnt_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchDoCheckReportRSQL").append("\n"); 
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
		query.append("SELECT RST.VVD          " ).append("\n"); 
		query.append("      ,RST.POD_CD       " ).append("\n"); 
		query.append("      ,RST.DEL_CD       " ).append("\n"); 
		query.append("      ,RST.BL_NO        " ).append("\n"); 
		query.append("      ,RST.BKG_NO     " ).append("\n"); 
		query.append("      ,RST.DO_NO        " ).append("\n"); 
		query.append("      ,RST.EVNT_DT      " ).append("\n"); 
		query.append("      ,RST.EVNT_OFC_CD  " ).append("\n"); 
		query.append("      ,RST.EVNT_USR_ID  " ).append("\n"); 
		query.append("      ,RST.CN_NM        " ).append("\n"); 
		query.append("      ,RST.NF_NM        " ).append("\n"); 
		query.append("      ,RST.DO_PRN_RMK   " ).append("\n"); 
		query.append("      ,RST.CGOR_RMK  " ).append("\n"); 
		query.append("      ,DECODE( NVL(WH_CD,'N'),'N','',WH_CD||'('||WH_NM ||')' ) AS WH_NM" ).append("\n"); 
		query.append("      ,RST.ROW_COUNT   " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 /* 0131 DO List Check Report */" ).append("\n"); 
		query.append("	 SELECT SUB_RSLT.VVD          AS VVD                " ).append("\n"); 
		query.append("	      , SUB_RSLT.POD_CD       AS POD_CD       " ).append("\n"); 
		query.append("	      , SUB_RSLT.DEL_CD       AS DEL_CD       " ).append("\n"); 
		query.append("	      , SUB_RSLT.BL_NO        AS BL_NO      " ).append("\n"); 
		query.append("          , SUB_RSLT.BKG_NO       AS BKG_NO  " ).append("\n"); 
		query.append("	      , SUB_RSLT.DO_NO        AS DO_NO        " ).append("\n"); 
		query.append("	      , SUB_RSLT.EVNT_DT      AS EVNT_DT      " ).append("\n"); 
		query.append("	      , SUB_RSLT.EVNT_OFC_CD  AS EVNT_OFC_CD  " ).append("\n"); 
		query.append("	      , SUB_RSLT.EVNT_USR_ID  AS EVNT_USR_ID  " ).append("\n"); 
		query.append("	      , SUB_RSLT.CN_NM        AS CN_NM        " ).append("\n"); 
		query.append("	      , SUB_RSLT.NF_NM        AS NF_NM        " ).append("\n"); 
		query.append("	      , SUB_RSLT.DO_PRN_RMK   AS DO_PRN_RMK   " ).append("\n"); 
		query.append("	      , SUB_RSLT.CGOR_RMK     AS CGOR_RMK     " ).append("\n"); 
		query.append("	      , MSN.CSTMS_CLR_WH_CD   AS WH_CD " ).append("\n"); 
		query.append("          , NVL(WH.WH_NM,' ')     AS WH_NM   " ).append("\n"); 
		query.append("          , SUB_RSLT.ROW_NUM      AS ROW_NUM                   " ).append("\n"); 
		query.append("	      , SUB_RSLT.ROW_COUNT    AS ROW_COUNT    " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("	           /*+ ORDERED */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	           BKGM.BKG_NO" ).append("\n"); 
		query.append("	         , BKGM.BL_NO" ).append("\n"); 
		query.append("	         , BVVD.VSL_CD || BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("	         , BKGM.POD_CD" ).append("\n"); 
		query.append("	         , BKGM.DEL_CD" ).append("\n"); 
		query.append("	         , BKDO.DO_NO||DECODE(BKDO.DO_NO_SPLIT,'00','',BKDO.DO_NO_SPLIT) AS DO_NO" ).append("\n"); 
		query.append("	         , TO_CHAR(DOTL.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT" ).append("\n"); 
		query.append("	         , DOTL.EVNT_OFC_CD" ).append("\n"); 
		query.append("	         , DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append("	         , REPLACE(REPLACE(CCST.CUST_NM, CHR(13) || CHR(10), ' '), CHR(10), ' ')    AS CN_NM" ).append("\n"); 
		query.append("	         , REPLACE(REPLACE(NCST.CUST_NM, CHR(13) || CHR(10), ' '), CHR(10), ' ')    AS NF_NM" ).append("\n"); 
		query.append("	         , DOTL.RLSE_STS_CD" ).append("\n"); 
		query.append("	         , DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("	         , REPLACE(REPLACE(BKDO.DO_PRN_RMK, CHR(13) || CHR(10), ' '), CHR(10), ' ') AS DO_PRN_RMK" ).append("\n"); 
		query.append("	         , REPLACE(REPLACE(BKDO.CGOR_RMK, CHR(13) || CHR(10), ' '), CHR(10), ' ')   AS CGOR_RMK" ).append("\n"); 
		query.append("	         , ( SELECT MAX(SEQ.CFM_DT) " ).append("\n"); 
		query.append("                                   FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("                                   WHERE SEQ.BKG_NO       = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                   AND   SEQ.MF_CFM_FLG   = 'Y'" ).append("\n"); 
		query.append("                                   AND   SEQ.MRN_BL_TS_CD = 'I'  ) 			    AS CFM_DT                                   " ).append("\n"); 
		query.append("	         , ROW_NUMBER() OVER (ORDER BY DOTL.EVNT_DT DESC ) 			    AS ROW_NUM" ).append("\n"); 
		query.append("	         , COUNT(1) OVER () 				   			    AS ROW_COUNT" ).append("\n"); 
		query.append("	      FROM BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("	         , BKG_DO BKDO    " ).append("\n"); 
		query.append("	         , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("	         , BKG_VVD BVVD" ).append("\n"); 
		query.append("	         , BKG_CUSTOMER CCST" ).append("\n"); 
		query.append("	         , BKG_CUSTOMER NCST" ).append("\n"); 
		query.append("	     WHERE 1 = 1" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("	       AND DOTL.EVNT_DT BETWEEN TO_DATE (@[evnt_dt_fm], 'YYYYMMDD') AND TO_DATE (@[evnt_dt_to], 'YYYYMMDD') + 0.99999   ---  OPTIONAL 2 MANDATORY GROUP1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F' && ${evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("	       AND DOTL.EVNT_OFC_CD = @[evnt_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F' && ${evnt_usr_id} != '')" ).append("\n"); 
		query.append("	       AND DOTL.EVNT_USR_ID = @[evnt_usr_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'S')" ).append("\n"); 
		query.append("	       AND BKGM.BL_NO  = @[bl_no] -- OPTIONAL 5 MANDATORY GROUP3   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'T')" ).append("\n"); 
		query.append("	       AND BVVD.VSL_CD = @[vsl_cd]         -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	       AND BVVD.SKD_VOY_NO = @[skd_voy_no] -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	       AND BVVD.SKD_DIR_CD = @[skd_dir_cd] -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	       AND BKGM.POD_CD = @[pod_cd] -- OPTIONAL 4 MANDATORY GROUP2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'T' && ${del_cd} != '')" ).append("\n"); 
		query.append("	       AND BKGM.DEL_CD = @[del_cd] -- OPTIONAL 10" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	       AND BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("	       AND CCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	       AND NCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("	       AND DOTL.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND CCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	       AND NCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("	       AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("	       AND BKDO.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("	       AND BKDO.RLSE_SEQ = DOTL.RLSE_SEQ      " ).append("\n"); 
		query.append("	       AND DOTL.RLSE_STS_CD IN ('I', 'R')" ).append("\n"); 
		query.append("	    ORDER BY EVNT_DT DESC" ).append("\n"); 
		query.append("	) SUB_RSLT" ).append("\n"); 
		query.append("	 ,BKG_CSTMS_KR_MF_SEQ_NO MSN" ).append("\n"); 
		query.append("	 ,BKG_WAREHOUSE           WH" ).append("\n"); 
		query.append("       WHERE  MSN.BKG_NO(+)       =  SUB_RSLT.BKG_NO" ).append("\n"); 
		query.append("       AND    MSN.MF_CFM_FLG(+)   = 'Y'" ).append("\n"); 
		query.append("       AND    MSN.MRN_BL_TS_CD(+) = 'I'" ).append("\n"); 
		query.append("       AND    MSN.CFM_DT(+)       = SUB_RSLT.CFM_DT " ).append("\n"); 
		query.append("       AND    WH.CSTMS_CD(+)      = MSN.CSTMS_CLR_WH_CD  " ).append("\n"); 
		query.append("       AND    WH.CNT_CD(+)        = 'KR'  	    " ).append("\n"); 
		query.append(") RST   " ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y' )" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN (TO_NUMBER(NVL(@[page_no], '1')) -1) * TO_NUMBER(@[pagerows]) +1" ).append("\n"); 
		query.append("                   AND TO_NUMBER(NVL(@[page_no], '1')) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}