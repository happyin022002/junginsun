/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgInfoinquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.12.11 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgInfoinquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주위험물 테이블들에서 데이타를 가져온다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgInfoinquiryRSQL(){
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
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgInfoinquiryRSQL").append("\n"); 
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
		query.append("SELECT A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.PORT_CD" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.POL_CD" ).append("\n"); 
		query.append("      ,A.POD_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CELL_PSN_NO" ).append("\n"); 
		query.append("      ,A.ANR_ROLE_DIV_CD" ).append("\n"); 
		query.append("      ,A.ANR_FWRD_ID" ).append("\n"); 
		query.append("      ,A.ANR_FWRD_NM" ).append("\n"); 
		query.append("      ,A.ANR_CRR_TP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRR_DT, 'YYYY-MM-DD') AS CRR_DT" ).append("\n"); 
		query.append("      ,A.SVC_RQST_NO" ).append("\n"); 
		query.append("      ,A.FDR_SVC_RQST_NO" ).append("\n"); 
		query.append("      ,A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,A.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,A.ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("      ,A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("      ,A.NET_WGT" ).append("\n"); 
		query.append("      ,A.GRS_WGT" ).append("\n"); 
		query.append("      ,A.MFAG_NO" ).append("\n"); 
		query.append("      ,A.PRP_SHP_NM" ).append("\n"); 
		query.append("      ,A.HZD_DESC" ).append("\n"); 
		query.append("      ,A.BRTH_YD_CD" ).append("\n"); 
		query.append("      ,A.BRTH_YD_NM" ).append("\n"); 
		query.append("      ,A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("      ,A.PCK_QTY" ).append("\n"); 
		query.append("      ,A.PCK_TP_CD" ).append("\n"); 
		query.append("      ,A.EUR_PCK_DESC" ).append("\n"); 
		query.append("      ,A.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,A.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,A.EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("      ,A.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,A.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,A.EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("      ,A.EMS_NO" ).append("\n"); 
		query.append("      ,A.DCGO_PCK_GRP_CD1" ).append("\n"); 
		query.append("      ,A.EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("      ,A.DIFF_RMK" ).append("\n"); 
		query.append("      ,A.HCDG_FLG" ).append("\n"); 
		query.append("      ,A.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("      ,A.NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,A.FDR_VVD_ID" ).append("\n"); 
		query.append("      ,A.FDR_VSL_NM" ).append("\n"); 
		query.append("      ,A.FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append("      ,A.VSL_LODG_DT" ).append("\n"); 
		query.append("      ,A.XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("      ,A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("      ,A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("      ,A.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("      ,A.CGO_OPR_CD" ).append("\n"); 
		query.append("      ,A.APLY_NO" ).append("\n"); 
		query.append("      ,A.CRR_CD" ).append("\n"); 
		query.append("      ,A.EDW_UPD_DT" ).append("\n"); 
		query.append("      ,A.CNTR_REF_NO" ).append("\n"); 
		query.append("      ,A.DCGO_REF_NO" ).append("\n"); 
		query.append("      ,A.EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,(SELECT BB.BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("         WHERE BB.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("       ) AS BKG_NO" ).append("\n"); 
		query.append("      ,(SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("          FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("         WHERE CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ) CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("      ,(SELECT SIUN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("          FROM SCG_IMDG_UN_NO SIUN" ).append("\n"); 
		query.append("         WHERE A.IMDG_UN_NO       = SIUN.IMDG_UN_NO" ).append("\n"); 
		query.append("           AND A.IMDG_UN_NO_SEQ   = SIUN.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       ) AS IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("      ,(SELECT D.FWRD_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG_FWRD D" ).append("\n"); 
		query.append("         WHERE A.ANR_FWRD_ID = D.ANR_FWRD_ID" ).append("\n"); 
		query.append("       ) AS FWRD_NM" ).append("\n"); 
		query.append("      ,A.CNTR_NO AS CNTR_NO_OLD" ).append("\n"); 
		query.append("      ,'' AS SAVE_TYPE" ).append("\n"); 
		query.append("      ,(SELECT DD.CSTMS_ERR_MSG" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG_SND     AA" ).append("\n"); 
		query.append("              ,BKG_CSTMS_EUR_DG_RCV     CC" ).append("\n"); 
		query.append("              ,BKG_CSTMS_EUR_DG_RCV_ERR DD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND AA.EUR_EDI_MSG_TP_ID   = CC.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("          AND AA.MSG_SND_NO          = CC.MSG_RCV_NO" ).append("\n"); 
		query.append("          AND CC.EUR_EDI_MSG_TP_ID   = DD.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("          AND CC.MSG_RCV_NO          = DD.MSG_RCV_NO" ).append("\n"); 
		query.append("          AND CC.RCV_LOG_SEQ         = DD.RCV_LOG_SEQ" ).append("\n"); 
		query.append("          AND AA.EUR_DG_DECL_TP_CD   = A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("          AND AA.VSL_CD              = A.VSL_CD    " ).append("\n"); 
		query.append("          AND AA.SKD_VOY_NO          = A.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND AA.SKD_DIR_CD          = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND AA.PORT_CD             = A.PORT_CD" ).append("\n"); 
		query.append("          AND AA.EUR_EDI_MSG_TP_ID   = 'IFD'" ).append("\n"); 
		query.append("          AND AA.MSG_SND_NO          = (SELECT MAX(AA.MSG_SND_NO)" ).append("\n"); 
		query.append("                                          FROM BKG_CSTMS_EUR_DG_SND AA" ).append("\n"); 
		query.append("								         WHERE 1=1" ).append("\n"); 
		query.append("								           AND AA.EUR_EDI_MSG_TP_ID   = A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("                                           AND AA.VSL_CD              = A.VSL_CD    " ).append("\n"); 
		query.append("                                           AND AA.SKD_VOY_NO          = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND AA.SKD_DIR_CD          = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND AA.PORT_CD             = A.PORT_CD" ).append("\n"); 
		query.append("                                           AND AA.EUR_EDI_MSG_TP_ID   ='IFD'" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("       ) AS CSTMS_ERR_MSG" ).append("\n"); 
		query.append("      ,'' AS D_TYPE" ).append("\n"); 
		query.append("      ,'' AS VVD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("   AND A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND A.PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("   AND A.BL_NO             = @[bl_no]" ).append("\n"); 
		query.append("   AND A.CNTR_NO           = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNTR_CGO_SEQ      = @[cntr_cgo_seq]" ).append("\n"); 

	}
}