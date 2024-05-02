/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchToDoMVMTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchToDoMVMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchToDoMVMT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchToDoMVMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inMvmtStsCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCnmvYr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCnmvIdNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCntrTpszCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inBkgCgoTpCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCntrNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchToDoMVMTRSQL").append("\n"); 
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
		query.append("SELECT bkg_no           bkg_no" ).append("\n"); 
		query.append(",sysdate                cre_dt" ).append("\n"); 
		query.append(",'1'                    act_rcv_tp_cd" ).append("\n"); 
		query.append(",MVMT_STS_CD            act_sts_mapg_cd" ).append("\n"); 
		query.append(",cntr_no                cntr_no           " ).append("\n"); 
		query.append(",org_yd_cd              nod_cd    " ).append("\n"); 
		query.append(",cnmv_evnt_dt           act_dt" ).append("\n"); 
		query.append(",'00'                   act_umch_tp_cd" ).append("\n"); 
		query.append(",CASE WHEN MVMT_EDI_MSG_TP_ID is null" ).append("\n"); 
		query.append("   THEN ( CASE WHEN MVMT_CRE_TP_CD in ('A', 'C', 'L')" ).append("\n"); 
		query.append("               THEN 'SYSTEM'" ).append("\n"); 
		query.append("               WHEN MVMT_CRE_TP_CD is null" ).append("\n"); 
		query.append("               THEN CRE_USR_ID" ).append("\n"); 
		query.append("          END" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   ELSE (MVMT_EDI_MSG_TP_ID)" ).append("\n"); 
		query.append("END                     edi_msg_tp_cd" ).append("\n"); 
		query.append(",VNDR_SEQ               vndr_seq" ).append("\n"); 
		query.append(",OB_CNTR_FLG            bnd_vskd_seq_cd" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(org_yd_cd,1,5) IS NOT NULL" ).append("\n"); 
		query.append("   THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(org_yd_cd,1,5), cnmv_evnt_dt, 'GMT')" ).append("\n"); 
		query.append("   WHEN (LOC_CD) IS NOT NULL" ).append("\n"); 
		query.append("   THEN GLOBALDATE_PKG.TIME_CONV_FNC(LOC_CD, cnmv_evnt_dt, 'GMT')" ).append("\n"); 
		query.append("END)                    act_gdt" ).append("\n"); 
		query.append(",MVMT_CRE_TP_CD         cre_tp_cd" ).append("\n"); 
		query.append(",CRNT_VSL_CD            vsl_cd" ).append("\n"); 
		query.append(",CRNT_SKD_VOY_NO        skd_voy_no" ).append("\n"); 
		query.append(",CRNT_SKD_DIR_CD        skd_dir_cd" ).append("\n"); 
		query.append("FROM (SELECT MVMT_CRE_TP_CD,CNTR_NO,CNMV_YR,CNMV_ID_NO,CNMV_SEQ,CNMV_SPLIT_NO,CNTR_TPSZ_CD,MVMT_STS_CD,BKG_CGO_TP_CD,CNMV_CYC_NO,CNMV_LVL_NO,CNMV_EVNT_DT" ).append("\n"); 
		query.append(",DEST_YD_CD,INP_YD_CD,ORG_YD_CD,CRNT_VSL_CD,CRNT_SKD_VOY_NO,CRNT_SKD_DIR_CD,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,CHSS_NO,MGST_NO" ).append("\n"); 
		query.append(",CNTR_SEAL_NO,CNTR_DMG_FLG,FCNTR_FLG,OB_CNTR_FLG,BKG_RCV_TERM_CD,VNDR_SEQ,MVMT_TRSP_MOD_CD,LOC_CD,CNMV_RMK,USR_NM" ).append("\n"); 
		query.append(",SUBST_RULE_CD,SPCL_CGO_FLG,BKG_NO,BKG_KNT,BL_NO,CNTR_HNGR_RCK_FLG,CNTR_HNGR_BAR_ATCH_KNT,CNTR_ACT_CD,CNTR_RFUB_FLG,CNTR_DISP_FLG" ).append("\n"); 
		query.append(",IMDT_EXT_FLG,CNTR_XCH_CD,INLND_TRSP_LIC_NO,CTRT_OFC_CTY_CD,CTRT_SEQ,MVMT_EDI_TP_CD,MVMT_EDI_MSG_TP_ID,MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append(",MVMT_EDI_MSG_YRMONDY,MVMT_EDI_MSG_SEQ,WBL_NO,PKUP_NO,CNTR_STS_SEQ,CALL_SGN_NO,LLOYD_NO,MTY_REPO_VL_RMK,MVMT_INP_TP_CD,CNMV_CO_CD" ).append("\n"); 
		query.append(",CNTR_SVR_ID,OFC_CD,PRE_STS_FLG,GMT_DT,CRE_LOCL_DT,UPD_LOCL_DT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO       = @[inCntrNo]" ).append("\n"); 
		query.append("AND   CNMV_YR       = @[inCnmvYr]" ).append("\n"); 
		query.append("AND   CNMV_ID_NO    = @[inCnmvIdNo]" ).append("\n"); 
		query.append("AND   MVMT_STS_CD   = @[inMvmtStsCd]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD  = @[inCntrTpszCd]" ).append("\n"); 
		query.append("AND   BKG_CGO_TP_CD = @[inBkgCgoTpCd]" ).append("\n"); 
		query.append("AND   CNMV_CO_CD     = 'SML'" ).append("\n"); 
		query.append("AND   BKG_NO         IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT MVMT_CRE_TP_CD,CNTR_NO,CNMV_YR,CNMV_ID_NO,CNMV_SEQ,CNMV_SPLIT_NO,CNTR_TPSZ_CD,MVMT_STS_CD,BKG_CGO_TP_CD,CNMV_CYC_NO,CNMV_LVL_NO,CNMV_EVNT_DT" ).append("\n"); 
		query.append(",DEST_YD_CD,INP_YD_CD,ORG_YD_CD,CRNT_VSL_CD,CRNT_SKD_VOY_NO,CRNT_SKD_DIR_CD,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,CHSS_NO,MGST_NO" ).append("\n"); 
		query.append(",CNTR_SEAL_NO,CNTR_DMG_FLG,FCNTR_FLG,OB_CNTR_FLG,BKG_RCV_TERM_CD,VNDR_SEQ,MVMT_TRSP_MOD_CD,LOC_CD,CNMV_RMK,USR_NM" ).append("\n"); 
		query.append(",SUBST_RULE_CD,SPCL_CGO_FLG,BKG_NO,BKG_KNT,BL_NO,CNTR_HNGR_RCK_FLG,CNTR_HNGR_BAR_ATCH_KNT,CNTR_ACT_CD,CNTR_RFUB_FLG,CNTR_DISP_FLG" ).append("\n"); 
		query.append(",IMDT_EXT_FLG,CNTR_XCH_CD,INLND_TRSP_LIC_NO,CTRT_OFC_CTY_CD,CTRT_SEQ,MVMT_EDI_TP_CD,MVMT_EDI_MSG_TP_ID,MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append(",MVMT_EDI_MSG_YRMONDY,MVMT_EDI_MSG_SEQ,WBL_NO,PKUP_NO,CNTR_STS_SEQ,CALL_SGN_NO,LLOYD_NO,MTY_REPO_VL_RMK,MVMT_INP_TP_CD,CNMV_CO_CD" ).append("\n"); 
		query.append(",CNTR_SVR_ID,OFC_CD,PRE_STS_FLG,GMT_DT,CRE_LOCL_DT,UPD_LOCL_DT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO        = @[inCntrNo]" ).append("\n"); 
		query.append("AND   CNMV_EVNT_DT   = TO_DATE(:in_cnmv_evnt_dt,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD   = @[inCntrTpszCd]" ).append("\n"); 
		query.append("AND   BKG_CGO_TP_CD  = @[inBkgCgoTpCd]" ).append("\n"); 
		query.append("AND   MVMT_CRE_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("AND   CNMV_CO_CD     = 'SML'" ).append("\n"); 
		query.append("AND   BKG_NO         IS NOT NULL) S" ).append("\n"); 

	}
}