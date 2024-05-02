/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchEDIMovementListWithIndexRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchEDIMovementListWithIndexRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDIMovementListWithIndex
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchEDIMovementListWithIndexRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_row_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_row_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchEDIMovementListWithIndexRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       CALL_SGN_LLOYD," ).append("\n"); 
		query.append("       CALL_SGN_NO," ).append("\n"); 
		query.append("       LLOYD_NO," ).append("\n"); 
		query.append("       CHSS_NO," ).append("\n"); 
		query.append("       CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_SEAL_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CRE_LOCL_DT," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       CRNT_VSL_CD, " ).append("\n"); 
		query.append("       CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("       CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("       DEST_YD_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       EDI_BKG_NO," ).append("\n"); 
		query.append("       EDI_GATE_IO_CD," ).append("\n"); 
		query.append("       EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("       EVNT_DT," ).append("\n"); 
		query.append("       EVNT_YD_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("       MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("       MVMT_EDI_RMK," ).append("\n"); 
		query.append("       CNMV_RMK," ).append("\n"); 
		query.append("       MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("       MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("       MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       RTY_KNT," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       MGST_NO," ).append("\n"); 
		query.append("       WBL_NO," ).append("\n"); 
		query.append("       PKUP_NO," ).append("\n"); 
		query.append("       LCC_CD," ).append("\n"); 
		query.append("       WO_NO," ).append("\n"); 
		query.append("       EDI_VVD_CD," ).append("\n"); 
		query.append("       TIR_NO," ).append("\n"); 
		query.append("       MTY_PLN_NO," ).append("\n"); 
		query.append("       EDI_MTY_EQ_REPO_REF_NO," ).append("\n"); 
		query.append("       EDI_CRR_NO," ).append("\n"); 
		query.append("       TRSP_DOC_NO," ).append("\n"); 
		query.append("       FLT_FILE_REF_NO," ).append("\n"); 
		query.append("       CNTR_DMG_FLG," ).append("\n"); 
		query.append("       DMG_FLG_DT," ).append("\n"); 
		query.append("       DMG_UNFLG_DT," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("       , DEST_LOC_NM" ).append("\n"); 
		query.append("       , DEST_STE_NM" ).append("\n"); 
		query.append("       , VGM_DOC_ID_NO" ).append("\n"); 
		query.append("	   , VGM_WGT" ).append("\n"); 
		query.append("	   , VGM_EDI_WGT_UT_CD" ).append("\n"); 
		query.append("	   , VGM_DOC_TP_CD" ).append("\n"); 
		query.append("	   , VGM_DT_TP_CD" ).append("\n"); 
		query.append("	   , VGM_HNDL_DT" ).append("\n"); 
		query.append("	   , VGM_CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("	   , VGM_CUST_CNTC_NM" ).append("\n"); 
		query.append("	   , VGM_CUST_FAX_NO" ).append("\n"); 
		query.append("	   , VGM_CUST_EML" ).append("\n"); 
		query.append("	   , VGM_CUST_PHN_NO" ).append("\n"); 
		query.append("	   , VGM_CUST_ADDR" ).append("\n"); 
		query.append("	   , VSL_ENG_NM" ).append("\n"); 
		query.append("       , USA_EDI_CD" ).append("\n"); 
		query.append("       , CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT ROW_NUMBER() OVER (ORDER BY EVNT_DT_ORG, R_ID) AS ROWNO," ).append("\n"); 
		query.append("              BKG_NO," ).append("\n"); 
		query.append("              BL_NO," ).append("\n"); 
		query.append("              CALL_SGN_LLOYD," ).append("\n"); 
		query.append("              CALL_SGN_NO," ).append("\n"); 
		query.append("              LLOYD_NO," ).append("\n"); 
		query.append("              CHSS_NO," ).append("\n"); 
		query.append("              CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("              CNTR_NO," ).append("\n"); 
		query.append("              CNTR_SEAL_NO," ).append("\n"); 
		query.append("              CNTR_TPSZ_CD," ).append("\n"); 
		query.append("              CRE_LOCL_DT," ).append("\n"); 
		query.append("              VVD_CD," ).append("\n"); 
		query.append("              CRNT_VSL_CD," ).append("\n"); 
		query.append("              CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("              CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("              DEST_YD_CD," ).append("\n"); 
		query.append("              POL_CD," ).append("\n"); 
		query.append("              POD_CD," ).append("\n"); 
		query.append("              EDI_BKG_NO," ).append("\n"); 
		query.append("              EDI_GATE_IO_CD," ).append("\n"); 
		query.append("              EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("              EVNT_DT," ).append("\n"); 
		query.append("              EVNT_YD_CD," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("              MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("              MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("              MVMT_EDI_RMK," ).append("\n"); 
		query.append("              CNMV_RMK," ).append("\n"); 
		query.append("              MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("              MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("              MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("              RTY_KNT," ).append("\n"); 
		query.append("              VNDR_SEQ," ).append("\n"); 
		query.append("              MGST_NO," ).append("\n"); 
		query.append("              WBL_NO," ).append("\n"); 
		query.append("              PKUP_NO," ).append("\n"); 
		query.append("              LCC_CD," ).append("\n"); 
		query.append("              WO_NO," ).append("\n"); 
		query.append("              EDI_VVD_CD," ).append("\n"); 
		query.append("              TIR_NO," ).append("\n"); 
		query.append("              MTY_PLN_NO," ).append("\n"); 
		query.append("              EDI_MTY_EQ_REPO_REF_NO," ).append("\n"); 
		query.append("              EDI_CRR_NO," ).append("\n"); 
		query.append("              TRSP_DOC_NO," ).append("\n"); 
		query.append("	          FLT_FILE_REF_NO," ).append("\n"); 
		query.append("	          CNTR_DMG_FLG," ).append("\n"); 
		query.append("	          DMG_FLG_DT," ).append("\n"); 
		query.append("	          DMG_UNFLG_DT," ).append("\n"); 
		query.append("	          UPD_USR_ID" ).append("\n"); 
		query.append("              , DEST_LOC_NM" ).append("\n"); 
		query.append("              , DEST_STE_NM" ).append("\n"); 
		query.append("              , VGM_DOC_ID_NO" ).append("\n"); 
		query.append("	          , VGM_WGT" ).append("\n"); 
		query.append("	          , VGM_EDI_WGT_UT_CD" ).append("\n"); 
		query.append("	          , VGM_DOC_TP_CD" ).append("\n"); 
		query.append("	          , VGM_DT_TP_CD" ).append("\n"); 
		query.append("	          , VGM_HNDL_DT" ).append("\n"); 
		query.append("	          , VGM_CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("	          , VGM_CUST_CNTC_NM" ).append("\n"); 
		query.append("	          , VGM_CUST_FAX_NO" ).append("\n"); 
		query.append("	          , VGM_CUST_EML" ).append("\n"); 
		query.append("	          , VGM_CUST_PHN_NO" ).append("\n"); 
		query.append("	          , VGM_CUST_ADDR" ).append("\n"); 
		query.append("	          , VSL_ENG_NM" ).append("\n"); 
		query.append("              , USA_EDI_CD" ).append("\n"); 
		query.append("              , CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                 SELECT /*+ USE_NL(MSG D B A G) */" ).append("\n"); 
		query.append("                        D.BKG_NO," ).append("\n"); 
		query.append("                        D.EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("                        NVL(D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD," ).append("\n"); 
		query.append("                        D.CALL_SGN_NO AS CALL_SGN_NO," ).append("\n"); 
		query.append("                        D.LLOYD_NO AS LLOYD_NO," ).append("\n"); 
		query.append("                        D.CHSS_NO," ).append("\n"); 
		query.append("                        D.CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("                        D.CNTR_NO," ).append("\n"); 
		query.append("                        D.CNTR_SEAL_NO," ).append("\n"); 
		query.append("                        D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.CRE_LOCL_DT, 'YYYYMMDDHH24MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("                        D.CRNT_VSL_CD," ).append("\n"); 
		query.append("                        D.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("                        D.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("                        D.DEST_YD_CD," ).append("\n"); 
		query.append("                        D.BKG_POL_CD AS POL_CD," ).append("\n"); 
		query.append("                        D.BKG_POD_CD AS POD_CD," ).append("\n"); 
		query.append("                        D.EDI_BKG_NO," ).append("\n"); 
		query.append("                        D.EDI_GATE_IO_CD," ).append("\n"); 
		query.append("                        D.EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("                        TO_CHAR(D.EVNT_DT, 'YYYYMMDDHH24MI') AS EVNT_DT," ).append("\n"); 
		query.append("                        D.EVNT_YD_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("                        D.MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("                        D.MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_RMK," ).append("\n"); 
		query.append("                        D.CNMV_RMK," ).append("\n"); 
		query.append("                        D.MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("                        D.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("                        D.MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("                        D.RTY_KNT," ).append("\n"); 
		query.append("                        D.VNDR_SEQ," ).append("\n"); 
		query.append("                        D.MGST_NO," ).append("\n"); 
		query.append("                        D.WBL_NO," ).append("\n"); 
		query.append("                        D.PKUP_NO," ).append("\n"); 
		query.append("                        A.LCC_CD, --" ).append("\n"); 
		query.append("                        D.WO_NO," ).append("\n"); 
		query.append("                        D.EDI_VVD_CD," ).append("\n"); 
		query.append("                        D.TIR_NO," ).append("\n"); 
		query.append("                        NVL(D.MTY_PLN_NO, D.MTY_REPO_NO) AS MTY_PLN_NO," ).append("\n"); 
		query.append("                        D.EDI_MTY_EQ_REPO_REF_NO," ).append("\n"); 
		query.append("                        D.EDI_CRR_NO," ).append("\n"); 
		query.append("                        D.TRSP_DOC_NO," ).append("\n"); 
		query.append("		                D.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("		                D.CNTR_DMG_FLG," ).append("\n"); 
		query.append("		                D.DMG_FLG_DT," ).append("\n"); 
		query.append("		                D.DMG_UNFLG_DT," ).append("\n"); 
		query.append("		                D.UPD_USR_ID" ).append("\n"); 
		query.append("                        , D.DEST_LOC_NM" ).append("\n"); 
		query.append("                        , D.DEST_STE_NM" ).append("\n"); 
		query.append("                        , D.VGM_DOC_ID_NO" ).append("\n"); 
		query.append("	                    , D.VGM_WGT" ).append("\n"); 
		query.append("	                    , D.VGM_EDI_WGT_UT_CD" ).append("\n"); 
		query.append("	                    , D.VGM_DOC_TP_CD" ).append("\n"); 
		query.append("	                    , D.VGM_DT_TP_CD" ).append("\n"); 
		query.append("	                    , D.VGM_HNDL_DT" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_CNTC_NM" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_FAX_NO" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_EML" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_PHN_NO" ).append("\n"); 
		query.append("	                    , D.VGM_CUST_ADDR" ).append("\n"); 
		query.append("	                    , D.VSL_ENG_NM" ).append("\n"); 
		query.append("                        , D.USA_EDI_CD" ).append("\n"); 
		query.append("                        , D.CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("                        ,MSG.IDX_CRE_LOCL_DT" ).append("\n"); 
		query.append("                        ,MSG.EVNT_DT AS EVNT_DT_ORG" ).append("\n"); 
		query.append("                        ,MSG.R_ID" ).append("\n"); 
		query.append("                   FROM " ).append("\n"); 
		query.append("                       (SELECT MSG.ROWID AS R_ID, IDX_CRE_LOCL_DT, EVNT_DT" ).append("\n"); 
		query.append("--                              ,ROW_NUMBER() OVER (ORDER BY EVNT_DT) AS ROWNO" ).append("\n"); 
		query.append("                        FROM   CTM_MVMT_EDI_MSG MSG" ).append("\n"); 
		query.append("                        WHERE  1=1" ).append("\n"); 
		query.append("                     #if (${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("                        #if (${p_date3} != '')" ).append("\n"); 
		query.append("                           AND (MSG.IDX_CRE_LOCL_DT IN (${p_date3})" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           AND (MSG.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${null_flg} != '')" ).append("\n"); 
		query.append("                           OR MSG.IDX_CRE_LOCL_DT = '00000000'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                        #if (${p_date3} != '')" ).append("\n"); 
		query.append("                           AND (MSG.IDX_EVNT_DT IN (${p_date3})" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           AND (MSG.IDX_EVNT_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${null_flg} != '')" ).append("\n"); 
		query.append("                           OR MSG.IDX_EVNT_DT = '00000000'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                          AND MSG.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                     #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                        AND MSG.EVNT_YD_CD LIKE @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("                     #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                        AND MSG.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${mvmt_edi_rslt_cd} != '')" ).append("\n"); 
		query.append("                        #if (${mvmt_edi_rslt_cd} == 'ALL')" ).append("\n"); 
		query.append("                           AND MSG.MVMT_EDI_RSLT_CD NOT IN ('D')" ).append("\n"); 
		query.append("                        #elseif (${mvmt_edi_rslt_cd} == 'X')" ).append("\n"); 
		query.append("                           AND MSG.MVMT_EDI_RSLT_CD IN ('X', 'I')" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           AND MSG.MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${edi_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("                        AND MSG.EDI_MVMT_STS_CD IN (${edi_mvmt_sts_cd})" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${rty_knt} != '')" ).append("\n"); 
		query.append("                        #if (${rty_knt} == '0')" ).append("\n"); 
		query.append("                           AND MSG.RTY_KNT = 0" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           AND MSG.RTY_KNT > 0" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${edi_gate_io_cd} != '')" ).append("\n"); 
		query.append("                        AND TRIM (MSG.EDI_GATE_IO_CD) IN (${edi_gate_io_cd})" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                        ORDER BY MSG.EVNT_DT, MSG.ROWID) MSG," ).append("\n"); 
		query.append("                        CTM_MVMT_EDI_MSG D, MDM_YARD M, MDM_LOCATION B, MDM_EQ_ORZ_CHT A, COM_SYS_AREA_GRP_ID G" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND   D.ROWID = MSG.R_ID" ).append("\n"); 
		query.append("                  AND   D.EVNT_YD_CD          = M.YD_CD(+)" ).append("\n"); 
		query.append("                  AND   SUBSTR(M.YD_CD, 1, 2) = G.CNT_CD(+)" ).append("\n"); 
		query.append("             #if (${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("                #if (${p_date3} != '')" ).append("\n"); 
		query.append("                   AND (D.IDX_CRE_LOCL_DT IN (${p_date3})" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                   AND (D.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${null_flg} != '')" ).append("\n"); 
		query.append("                   OR D.IDX_CRE_LOCL_DT = '00000000'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("                #if (${p_date3} != '')" ).append("\n"); 
		query.append("                   AND (D.IDX_EVNT_DT IN (${p_date3})" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                   AND (D.IDX_EVNT_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${null_flg} != '')" ).append("\n"); 
		query.append("                   OR D.IDX_EVNT_DT = '00000000'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("                  AND D.MVMT_EDI_MSG_AREA_CD IN ('KOR', 'CHN', 'SWA', 'EUR', 'USA')" ).append("\n"); 
		query.append("                 #if (${p_yard2} != '')" ).append("\n"); 
		query.append("                    AND D.EVNT_YD_CD LIKE @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("                 #elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("                    AND D.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${mvmt_edi_rslt_cd} != '')" ).append("\n"); 
		query.append("                    #if (${mvmt_edi_rslt_cd} == 'ALL')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD NOT IN ('D')" ).append("\n"); 
		query.append("                    #elseif (${mvmt_edi_rslt_cd} == 'X')" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD IN ('X', 'I')" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${edi_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("                    AND D.EDI_MVMT_STS_CD IN (${edi_mvmt_sts_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${rty_knt} != '')" ).append("\n"); 
		query.append("                    #if (${rty_knt} == '0')" ).append("\n"); 
		query.append("                       AND D.RTY_KNT = 0" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                       AND D.RTY_KNT > 0" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${edi_gate_io_cd} != '')" ).append("\n"); 
		query.append("                    AND TRIM (D.EDI_GATE_IO_CD) IN (${edi_gate_io_cd})" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 AND A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("                 AND B.LOC_CD(+) = SUBSTR(D.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${start_row_no} != '' && ${start_row_no} != '')" ).append("\n"); 
		query.append("WHERE ROWNO BETWEEN @[start_row_no] AND @[end_row_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}