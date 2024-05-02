/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CIMCommonDBDAOAddCtmMovementDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.05.23 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOAddCtmMovementDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM모듈에서 CTM Movement 데이타 insert
	  * </pre>
	  */
	public CIMCommonDBDAOAddCtmMovementDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tir_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_crr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_repo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("osca_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOAddCtmMovementDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MOVEMENT (" ).append("\n"); 
		query.append("        FCNTR_FLG,  " ).append("\n"); 
		query.append("        OB_CNTR_FLG," ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        SPCL_CGO_FLG," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        BKG_KNT," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        CNTR_DISP_FLG," ).append("\n"); 
		query.append("        IMDT_EXT_FLG," ).append("\n"); 
		query.append("        CNTR_XCH_CD," ).append("\n"); 
		query.append("        CNMV_CO_CD," ).append("\n"); 
		query.append("        GMT_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        USR_NM," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        CRE_LOCL_DT," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        UPD_LOCL_DT," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        CNMV_YR," ).append("\n"); 
		query.append("        CNMV_ID_NO," ).append("\n"); 
		query.append("        CNMV_SEQ," ).append("\n"); 
		query.append("        CNMV_SPLIT_NO," ).append("\n"); 
		query.append("        MVMT_STS_CD," ).append("\n"); 
		query.append("        BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        CNMV_CYC_NO," ).append("\n"); 
		query.append("        CNMV_EVNT_DT," ).append("\n"); 
		query.append("        DEST_YD_CD," ).append("\n"); 
		query.append("        INP_YD_CD," ).append("\n"); 
		query.append("        ORG_YD_CD," ).append("\n"); 
		query.append("        CHSS_NO," ).append("\n"); 
		query.append("        MGST_NO," ).append("\n"); 
		query.append("        CNTR_DMG_FLG," ).append("\n"); 
		query.append("        CRNT_VSL_CD," ).append("\n"); 
		query.append("        CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("        CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("        TRNK_VSL_CD," ).append("\n"); 
		query.append("        TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("        TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("        SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("        OFC_CD," ).append("\n"); 
		query.append("        CNTR_ACT_CD," ).append("\n"); 
		query.append("        CNMV_RMK," ).append("\n"); 
		query.append("        CNTR_SEAL_NO," ).append("\n"); 
		query.append("        CNMV_LVL_NO," ).append("\n"); 
		query.append("        BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("        MVMT_INP_TP_CD," ).append("\n"); 
		query.append("        CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("        CTRT_SEQ," ).append("\n"); 
		query.append("        MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("        MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("        MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("        MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("        MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("        MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("        PRE_STS_FLG," ).append("\n"); 
		query.append("        CALL_SGN_NO," ).append("\n"); 
		query.append("        LLOYD_NO," ).append("\n"); 
		query.append("        WO_NO," ).append("\n"); 
		query.append("        EDI_VVD_CD," ).append("\n"); 
		query.append("        TIR_NO," ).append("\n"); 
		query.append("        MTY_PLN_NO," ).append("\n"); 
		query.append("        MTY_REPO_NO," ).append("\n"); 
		query.append("        EDI_CRR_NO," ).append("\n"); 
		query.append("        TRSP_DOC_NO," ).append("\n"); 
		query.append("        OSCA_BKG_FLG," ).append("\n"); 
		query.append("        RSTR_USG_LBL_NM_DESC," ).append("\n"); 
		query.append("        RSTR_USG_LBL_VAL_DESC," ).append("\n"); 
		query.append("        CNMV_GDT," ).append("\n"); 
		query.append("        MTY_REPO_VL_RMK       " ).append("\n"); 
		query.append(")            " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("          DECODE(SUB.MVMT_STS_CD, 'OP', 'N', NVL(@[fcntr_flg], 'N')) AS FCNTR_FLG" ).append("\n"); 
		query.append("        , NVL(@[ob_cntr_flg], 'N') AS OB_CNTR_FLG  " ).append("\n"); 
		query.append("        , DECODE (EM.VNDR_SEQ, 'null', '', EM.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("        , NVL((SELECT BB.DCGO_FLG FROM CIM_BOOKING_V BB WHERE BB.BKG_NO = @[bkg_no] AND ROWNUM = 1), 'N') AS SPCL_CGO_FLG" ).append("\n"); 
		query.append("        , @[bkg_no]  AS BKG_NO                                                                                                 -- ''  AS BKG_NO" ).append("\n"); 
		query.append("        , DECODE(@[bkg_no], NULL, 0, 1) AS BKG_CNT" ).append("\n"); 
		query.append("        , @[bkg_no]  AS BL_NO" ).append("\n"); 
		query.append("        , 'N'  AS CNTR_DISP_FLG" ).append("\n"); 
		query.append("        , 'N'  AS IMDT_EXT_FLG" ).append("\n"); 
		query.append("        , ''  AS CNTR_XCH_CD" ).append("\n"); 
		query.append("        , COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()  AS  CNMV_CO_CD" ).append("\n"); 
		query.append("        , GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), SYSDATE, 'GMT' ) AS GMT_DT" ).append("\n"); 
		query.append("        , @[cre_usr_id] AS CRE_USR_ID                                                                                   -- '' AS CRE_USR_ID" ).append("\n"); 
		query.append("        , @[upd_usr_id] AS UPD_USR_ID                                                                                   -- '' AS UPD_USR_ID" ).append("\n"); 
		query.append("        , NVL(@[usr_nm],'') AS USR_NM" ).append("\n"); 
		query.append("        , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("        , GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 )) AS CRE_LOCL_DT" ).append("\n"); 
		query.append("        , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("        , GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 )) AS UPD_LOCL_DT" ).append("\n"); 
		query.append("        , SUB.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("        , SUB.CNMV_YR AS CNMV_YR" ).append("\n"); 
		query.append("        , SUB.CNMV_ID_NO AS CNMV_ID_NO" ).append("\n"); 
		query.append("        , SUB.CNMV_SEQ AS CNMV_SEQ" ).append("\n"); 
		query.append("        , SUB.CNMV_SPLIT_NO AS CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        , SUB.MVMT_STS_CD AS MVMT_STS_CD                                           --EM.EDI_MVMT_STS_CD AS MVMT_STS_CD" ).append("\n"); 
		query.append("        , NVL(@[bkg_cgo_tp_cd],'') AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        , CASE WHEN @[cnmv_cyc_no] in (NULL, 9999, 0, 9998) THEN" ).append("\n"); 
		query.append("           DECODE(@[bkg_no], NULL, NULL" ).append("\n"); 
		query.append("                      , NVL(  (SELECT MAX(SM.CNMV_CYC_NO)" ).append("\n"); 
		query.append("                                 FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("                                WHERE SM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                                  AND SM.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                             , (SELECT MAX(SM.CNMV_CYC_NO)+ 1" ).append("\n"); 
		query.append("                                  FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("                                         WHERE SM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                                   AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                                                  FROM CIM_BKG_CNTR_V SC" ).append("\n"); 
		query.append("                                                 WHERE NVL(SC.CNMV_CYC_NO, 0) IN (0, 9998, 9999)" ).append("\n"); 
		query.append("                                                   AND SM.CNTR_NO     = SC.CNTR_NO" ).append("\n"); 
		query.append("                                                               AND SC.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("                                                   AND ROWNUM         = 1)" ).append("\n"); 
		query.append("                                ) " ).append("\n"); 
		query.append("                             )                         " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             @[cnmv_cyc_no]" ).append("\n"); 
		query.append("          END AS CNMV_CYC_NO" ).append("\n"); 
		query.append("        , SUB.CNMV_EVNT_DT AS CNMV_EVNT_DT     -- TO_DATE (EM.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("        , @[dest_yd_cd] AS DEST_YD_CD                                                                           -- '' AS DEST_YD_CD " ).append("\n"); 
		query.append("        , @[org_yd_cd] AS INP_YD_CD                                                                            -- EM.EVNT_YD_CD AS INP_YD_CD " ).append("\n"); 
		query.append("        , @[org_yd_cd] AS ORG_YD_CD                                                                             -- EM.EVNT_YD_CD AS ORG_YD_CD" ).append("\n"); 
		query.append("        , @[chss_no]   AS CHSS_NO" ).append("\n"); 
		query.append("        , @[mgst_no]    AS MGST_NO" ).append("\n"); 
		query.append("        , NVL(SUB.CNTR_DMG_FLG, 'N') AS CNTR_DMG_FLG" ).append("\n"); 
		query.append("        , @[crnt_vsl_cd]    AS CRNT_VSL_CD                                                              -- EM.CRNT_VSL_CD    AS CRNT_VSL_CD  " ).append("\n"); 
		query.append("        , @[crnt_skd_voy_no]  AS CRNT_SKD_VOY_NO                                                        -- EM.CRNT_SKD_VOY_NO  AS CRNT_SKD_VOY_NO " ).append("\n"); 
		query.append("        , @[crnt_skd_dir_cd]    AS CRNT_SKD_DIR_CD                                              -- EM.CRNT_SKD_DIR_CD    AS CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        , (SELECT BB.VSL_CD FROM CIM_BOOKING_V BB WHERE BB.BKG_NO = @[bkg_no] AND ROWNUM = 1) AS TRNK_VSL_CD" ).append("\n"); 
		query.append("        , (SELECT BB.SKD_VOY_NO FROM CIM_BOOKING_V BB WHERE BB.BKG_NO = @[bkg_no] AND ROWNUM = 1) AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("        , (SELECT BB.SKD_DIR_CD FROM CIM_BOOKING_V BB WHERE BB.BKG_NO = @[bkg_no] AND ROWNUM = 1) AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("        , MC.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , NVL(@[mvmt_cre_tp_cd],'') AS MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("        ,(SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("           WHERE CNT_CD    = SUBSTR(@[org_yd_cd], 1, 2)" ).append("\n"); 
		query.append("             AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("            AND ROWNUM    = 1) AS CNTR_SVR_ID" ).append("\n"); 
		query.append("        , (SELECT MY.OFC_CD" ).append("\n"); 
		query.append("             FROM MDM_YARD MY" ).append("\n"); 
		query.append("            WHERE MY.YD_CD = @[org_yd_cd]" ).append("\n"); 
		query.append("              AND ROWNUM   = 1) AS OFC_CD                   -- '' AS OFC_CD" ).append("\n"); 
		query.append("        , DECODE (EM.EDI_MVMT_STS_CD, 'XX', 'I', 'A' )  AS CNTR_ACT_CD" ).append("\n"); 
		query.append("        , @[cnmv_rmk] AS CNMV_RMK                   -- '' AS CNMV_RMK" ).append("\n"); 
		query.append("        , @[cntr_seal_no] AS CNTR_SEAL_NO  -- '' AS CNTR_SEAL_NO 입력" ).append("\n"); 
		query.append("        , NVL((SELECT CNMV_LVL_NO" ).append("\n"); 
		query.append("                FROM CTM_MVMT_SEQ" ).append("\n"); 
		query.append("                WHERE BKG_CGO_TP_CD = @[bkg_cgo_tp_cd] " ).append("\n"); 
		query.append("                AND MVMT_STS_CD     = @[cnmv_evnt_cd]" ).append("\n"); 
		query.append("                AND ROWNUM          = 1)" ).append("\n"); 
		query.append("              , (SELECT MAX(SCM.CNMV_LVL_NO)+1" ).append("\n"); 
		query.append("                   FROM CTM_MOVEMENT SCM" ).append("\n"); 
		query.append("                  WHERE SCM.CNTR_NO     = SUB.CNTR_NO" ).append("\n"); 
		query.append("                    AND SCM.CNMV_CYC_NO = @[cnmv_cyc_no])  " ).append("\n"); 
		query.append("             ) AS CNMV_LVL_NO" ).append("\n"); 
		query.append("        , '' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        , DECODE(@[mvmt_edi_tp_cd], NULL, 'MAN', 'EDI') AS MVMT_INP_TP_CD" ).append("\n"); 
		query.append("        , (SELECT SMC.AGMT_CTY_CD FROM MST_CONTAINER SMC WHERE SMC.CNTR_NO = SUB.CNTR_NO AND ROWNUM = 1) CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append("        , (SELECT SMC.AGMT_SEQ FROM MST_CONTAINER SMC WHERE SMC.CNTR_NO = SUB.CNTR_NO AND ROWNUM = 1) AS CTRT_SEQ" ).append("\n"); 
		query.append("        , @[mvmt_trsp_mod_cd]       AS MVMT_TRSP_MOD_CD                       -- '' AS MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("        , SUB.MVMT_EDI_TP_CD        AS MVMT_EDI_TP_CD                           -- '' AS MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("        , SUB.MVMT_EDI_MSG_TP_ID    AS MVMT_EDI_MSG_TP_ID                   -- '' AS MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("        , SUB.MVMT_EDI_MSG_AREA_CD  AS MVMT_EDI_MSG_AREA_CD               -- '' AS MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("        , SUB.MVMT_EDI_MSG_YRMONDY  AS MVMT_EDI_MSG_YRMONDY               -- '' AS MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("        , SUB.MVMT_EDI_MSG_SEQ      AS MVMT_EDI_MSG_SEQ                               -- '' AS MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("        , 'N' AS PRE_STS_FLG" ).append("\n"); 
		query.append("        , @[call_sgn_no] AS CALL_SGN_NO                                                 -- '' AS CALL_SGN_NO" ).append("\n"); 
		query.append("        , @[lloyd_no] AS LLOYD_NO                                                               -- '' AS LLOYD_NO" ).append("\n"); 
		query.append("        , @[wo_no] AS WO_NO                                                                             -- '' AS WO_NO  -- 입력" ).append("\n"); 
		query.append("        , @[edi_vvd_cd] AS EDI_VVD_CD                                                   -- '' AS EDI_VVD_CD" ).append("\n"); 
		query.append("        , @[tir_no] AS TIR_NO                                                                   -- '' AS TIR_NO -- 입력" ).append("\n"); 
		query.append("        , @[mty_pln_no] AS MTY_PLN_NO                                                   -- '' AS MTY_PLN_NO -- 입력" ).append("\n"); 
		query.append("        , @[mty_repo_no] AS MTY_REPO_NO                                                 -- '' AS MTY_REPO_NO -- 입력" ).append("\n"); 
		query.append("        , @[edi_crr_no] AS EDI_CRR_NO                                                   -- '' AS EDI_CRR_NO -- 입력" ).append("\n"); 
		query.append("        , @[trsp_doc_no] AS TRSP_DOC_NO                                                 -- '' AS TRSP_DOC_NO -- 입력" ).append("\n"); 
		query.append("        , @[osca_bkg_flg] AS OSCA_BKG_FLG                                               -- '' AS OSCA_BKG_FLG" ).append("\n"); 
		query.append("        , MST_COMMON_PKG.MST_RU_TP_GET_FNC(EM.CNTR_NO) AS RSTR_USG_LBL_NM_DESC" ).append("\n"); 
		query.append("        , MST_COMMON_PKG.MST_RU_VAL_GET_FNC(EM.CNTR_NO) AS RSTR_USG_LBL_VAL_DESC" ).append("\n"); 
		query.append("        , GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), SUB.CNMV_EVNT_DT, 'GMT' )" ).append("\n"); 
		query.append("        , 'UPDATED BY SYSTEM('||TO_CHAR(SYSDATE, 'YYYY.MM.DD HH24:MI:SS')||')' AS MTY_REPO_VL_RMK" ).append("\n"); 
		query.append("FROM       CTM_MVMT_EDI_MSG EM" ).append("\n"); 
		query.append("        ,  MST_CONTAINER MC" ).append("\n"); 
		query.append("        , (SELECT   SUB.CNTR_NO" ).append("\n"); 
		query.append("                  , SUB.CNMV_YR" ).append("\n"); 
		query.append("                  , DECODE(LVL.LVL, 1, SUB.MVMT_STS_CD, DECODE(@[fcntr_flg], 'Y', 'IC', 'MT')) AS MVMT_STS_CD" ).append("\n"); 
		query.append("                  , DECODE(SUB.LST_FLG, 'Y', SUB.CNMV_SEQ + LVL.LVL, SUB.CNMV_SEQ) AS CNMV_SEQ" ).append("\n"); 
		query.append("                  , (SUB.CNMV_ID_NO + LVL.LVL ) AS CNMV_ID_NO" ).append("\n"); 
		query.append("                  , TO_CHAR(DECODE(SUB.LST_FLG, 'Y', ' '" ).append("\n"); 
		query.append("                                                   , NVL((SELECT MAX(TO_NUMBER(CHK.CNMV_SPLIT_NO))" ).append("\n"); 
		query.append("                                                            FROM CTM_MOVEMENT CHK" ).append("\n"); 
		query.append("                                                           WHERE REGEXP_INSTR(CHK.CNMV_SPLIT_NO,'[^0-9]') = 0" ).append("\n"); 
		query.append("                                                             AND SUB.CNTR_NO  = CHK.CNTR_NO" ).append("\n"); 
		query.append("                                                             AND SUB.CNMV_YR  = CHK.CNMV_YR" ).append("\n"); 
		query.append("                                                             AND SUB.CNMV_SEQ = CHK.CNMV_SEQ), 0) + LVL.LVL" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                           ) AS CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                  , DECODE(LVL.LVL, 1, TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                  , TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI') + 0.00009" ).append("\n"); 
		query.append("                           ) AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                  , @[mvmt_edi_tp_cd]         AS MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("                  , @[mvmt_edi_msg_tp_id]     AS MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                  , @[mvmt_edi_msg_area_cd]   AS MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("                  , @[mvmt_edi_msg_yrmondy]   AS MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("                  , @[mvmt_edi_msg_seq]       AS MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("                  , @[cntr_dmg_flg]           AS CNTR_DMG_FLG" ).append("\n"); 
		query.append("             FROM " ).append("\n"); 
		query.append("                     (SELECT CNTR_NO" ).append("\n"); 
		query.append("                           , CNMV_YR" ).append("\n"); 
		query.append("                           , CNMV_SEQ" ).append("\n"); 
		query.append("                           , CNMV_ID_NO" ).append("\n"); 
		query.append("                           , MVMT_STS_CD" ).append("\n"); 
		query.append("                           , LST_FLG" ).append("\n"); 
		query.append("                       FROM ( " ).append("\n"); 
		query.append("                            SELECT     P.CNTR_NO" ).append("\n"); 
		query.append("                                    ,  'N' AS LST_FLG" ).append("\n"); 
		query.append("                                    ,  P.MVMT_STS_CD AS MVMT_STS_CD" ).append("\n"); 
		query.append("                                    ,  TO_CHAR(P.CNMV_EVNT_DT, 'YYYY') AS CNMV_YR" ).append("\n"); 
		query.append("                                    ,  NVL(MAX(CM.CNMV_SEQ), 1)        AS CNMV_SEQ" ).append("\n"); 
		query.append("                                    ,  MAX(NVL((SELECT NVL(MAX(SCM.CNMV_ID_NO), 0)" ).append("\n"); 
		query.append("                                                  FROM CTM_MOVEMENT SCM" ).append("\n"); 
		query.append("                                                 WHERE SCM.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("                                                   AND SCM.CNMV_YR = TO_CHAR(P.CNMV_EVNT_DT, 'YYYY')" ).append("\n"); 
		query.append("                                                 GROUP BY SCM.CNTR_NO, SCM.CNMV_YR), NVL(CM.CNMV_ID_NO, 0) ))   AS CNMV_ID_NO" ).append("\n"); 
		query.append("                            FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                               , (SELECT @[cntr_no]                AS CNTR_NO" ).append("\n"); 
		query.append("                                       , TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI')  AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                       , @[mvmt_sts_cd] AS MVMT_STS_CD" ).append("\n"); 
		query.append("                                    FROM DUAL) P" ).append("\n"); 
		query.append("                            WHERE P.CNTR_NO                        = CM.CNTR_NO" ).append("\n"); 
		query.append("                            AND    TO_CHAR(P.CNMV_EVNT_DT, 'YYYY') = CM.CNMV_YR" ).append("\n"); 
		query.append("                            AND    P.CNMV_EVNT_DT > CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                            GROUP BY P.CNTR_NO, TO_CHAR(P.CNMV_EVNT_DT, 'YYYY')" ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("                            SELECT " ).append("\n"); 
		query.append("                                       P.CNTR_NO" ).append("\n"); 
		query.append("                                    ,  'Y' AS LST_FLG" ).append("\n"); 
		query.append("                                    ,  P.MVMT_STS_CD AS MVMT_STS_CD" ).append("\n"); 
		query.append("                                    ,  TO_CHAR(P.CNMV_EVNT_DT, 'YYYY') CNMV_YR" ).append("\n"); 
		query.append("                                    ,  NVL(MAX(CM.CNMV_SEQ), 0)       AS CNMV_SEQ" ).append("\n"); 
		query.append("                                    ,  NVL(MAX(CM.CNMV_ID_NO), 0)     AS CNMV_ID_NO" ).append("\n"); 
		query.append("                            FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                              , (SELECT @[cntr_no]                AS CNTR_NO" ).append("\n"); 
		query.append("                                      , TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI')  AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                      , @[mvmt_sts_cd] AS MVMT_STS_CD" ).append("\n"); 
		query.append("                                   FROM DUAL) P" ).append("\n"); 
		query.append("                            WHERE P.CNTR_NO                        = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("                            AND    TO_CHAR(P.CNMV_EVNT_DT, 'YYYY') = CM.CNMV_YR(+)" ).append("\n"); 
		query.append("                            GROUP BY P.CNTR_NO, TO_CHAR(P.CNMV_EVNT_DT, 'YYYY')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                    WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                    ORDER BY LST_FLG) SUB" ).append("\n"); 
		query.append("                    , (SELECT LEVEL LVL" ).append("\n"); 
		query.append("                        FROM DUAL" ).append("\n"); 
		query.append("                        CONNECT BY LEVEL < DECODE(@[mvmt_sts_cd], 'VD', 3, 2)" ).append("\n"); 
		query.append("                      ) LVL   " ).append("\n"); 
		query.append("      ) SUB" ).append("\n"); 
		query.append("WHERE SUB.CNTR_NO              = EM.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND SUB.MVMT_EDI_TP_CD       = EM.MVMT_EDI_TP_CD(+)" ).append("\n"); 
		query.append("  AND SUB.MVMT_EDI_MSG_TP_ID   = EM.MVMT_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("  AND SUB.MVMT_EDI_MSG_AREA_CD = EM.MVMT_EDI_MSG_AREA_CD(+)" ).append("\n"); 
		query.append("  AND SUB.MVMT_EDI_MSG_YRMONDY = EM.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("  AND SUB.MVMT_EDI_MSG_SEQ     = EM.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 
		query.append("  AND SUB.CNTR_NO              = MC.CNTR_NO" ).append("\n"); 

	}
}