/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyBlIssCAUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOModifyBlIssCAUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * c/a시 bkg_bl_iss 정보를 update한다.,
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyBlIssCAUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyBlIssCAUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS" ).append("\n"); 
		query.append("   SET ( BL_RDY_TP_CD" ).append("\n"); 
		query.append("    ,    BL_RDY_FLG" ).append("\n"); 
		query.append("    ,    BL_RDY_OFC_CD" ).append("\n"); 
		query.append("    ,    BL_RDY_USR_ID" ).append("\n"); 
		query.append("    ,    BL_RDY_DT" ).append("\n"); 
		query.append("    ,    RQST_BL_TP_CD" ).append("\n"); 
		query.append("    ,    OBL_RT_INCL_KNT" ).append("\n"); 
		query.append("    ,    OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append("    ,    OBL_TTL_KNT" ).append("\n"); 
		query.append("    ,    NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append("    ,    NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append("    ,    CPY_TTL_KNT" ).append("\n"); 
		query.append("    ,    RQST_ISS_PLC_NM" ).append("\n"); 
		query.append("    ,    RQST_ISS_DT" ).append("\n"); 
		query.append("    ,    BL_DE_TO_CD" ).append("\n"); 
		query.append("    ,    BL_DE_MZD_CD" ).append("\n"); 
		query.append("    ,    BL_DOC_RQST_RMK" ).append("\n"); 
		query.append("    ,    BL_ISS_KNT" ).append("\n"); 
		query.append("    ,    BL_CPY_KNT" ).append("\n"); 
		query.append("    ,    BL_PRN_VIA_CD" ).append("\n"); 
		query.append("    ,    OBL_INET_FLG" ).append("\n"); 
		query.append("    ,    OBL_INET_PRN_DT" ).append("\n"); 
		query.append("    ,    OBL_INET_PRN_GDT" ).append("\n"); 
		query.append("    ,    OBL_PRN_FLG" ).append("\n"); 
		query.append("    ,    CSTMS_CNTR_EXP_DT" ).append("\n"); 
		query.append("    ,    OBL_ISS_DT" ).append("\n"); 
		query.append("    ,    OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("    ,    OBL_ISS_USR_ID" ).append("\n"); 
		query.append("    ,    OBL_ISS_TP_CD" ).append("\n"); 
		query.append("    ,    OBL_ISS_KNT" ).append("\n"); 
		query.append("    ,    OBL_ISS_FLG" ).append("\n"); 
		query.append("    ,    OBL_RLSE_FLG" ).append("\n"); 
		query.append("    ,    OBL_SRND_FLG" ).append("\n"); 
		query.append("    ,    OBL_RDEM_FLG" ).append("\n"); 
		query.append("    ,    BL_PRF_SHPR_FLG" ).append("\n"); 
		query.append("    ,    BL_PRF_SHPR_USR_ID" ).append("\n"); 
		query.append("    ,    BL_PRF_SHPR_OFC_CD" ).append("\n"); 
		query.append("    ,    BL_PRF_SHPR_DT" ).append("\n"); 
		query.append("    ,    OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append("    ,    OBL_RDEM_USR_ID" ).append("\n"); 
		query.append("    ,    OBL_RDEM_UPD_USR_ID" ).append("\n"); 
		query.append("    ,    OBL_RDEM_DT" ).append("\n"); 
		query.append("    ,    OBL_RDEM_KNT" ).append("\n"); 
		query.append("    ,    BL_OTR_DOC_RCV_CD" ).append("\n"); 
		query.append("    ,    OTR_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("    ,    OTR_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("    ,    OTR_DOC_RCV_DT" ).append("\n"); 
		query.append("    ,    OTR_DOC_CGOR_FLG" ).append("\n"); 
		query.append("    ,    IBD_DOC_RCV_FLG" ).append("\n"); 
		query.append("    ,    IBD_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("    ,    IBD_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("    ,    IBD_DOC_RCV_DT" ).append("\n"); 
		query.append("    ,    CSTMS_ENTR_CD" ).append("\n"); 
		query.append("    ,    CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("    ,    CSTMS_CLR_WH_NM" ).append("\n"); 
		query.append("    ,    ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("    ,    ORG_PPD_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append("    ,    ORG_PPD_RCV_UPD_USR_ID" ).append("\n"); 
		query.append("    ,    ORG_PPD_RCV_UPD_DT" ).append("\n"); 
		query.append("    ,    DEST_CLT_RCV_CD" ).append("\n"); 
		query.append("    ,    DEST_CLT_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append("    ,    DEST_CLT_RCV_UPD_USR_ID" ).append("\n"); 
		query.append("    ,    DEST_CLT_RCV_UPD_DT" ).append("\n"); 
		query.append("    ,    ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("    ,    ORG_N3PTY_PPD_UPD_OFC_CD" ).append("\n"); 
		query.append("    ,    ORG_N3PTY_PPD_UPD_USR_ID" ).append("\n"); 
		query.append("    ,    ORG_N3PTY_PPD_UPD_DT" ).append("\n"); 
		query.append("    ,    DEST_N3PTY_CLT_CD" ).append("\n"); 
		query.append("    ,    DEST_N3PTY_CLT_UPD_OFC_CD" ).append("\n"); 
		query.append("    ,    DEST_N3PTY_CLT_UPD_USR_ID" ).append("\n"); 
		query.append("    ,    DEST_N3PTY_CLT_UPD_DT" ).append("\n"); 
		query.append("    ,    DIFF_RMK" ).append("\n"); 
		query.append("	,    upd_dt" ).append("\n"); 
		query.append("	,	 BL_ISS_TP_CD" ).append("\n"); 
		query.append("    ,    OBL_ISS_RMK" ).append("\n"); 
		query.append("    ,    INET_CTRL_PTY_NM" ).append("\n"); 
		query.append("    ,    INET_CTRL_PTY_NO" ).append("\n"); 
		query.append("    ,    WBL_PRN_FLG" ).append("\n"); 
		query.append("    ,    BL_CPY_NO" ).append("\n"); 
		query.append("    ,    EDW_UPD_DT" ).append("\n"); 
		query.append("    ,    OBL_PPD_KNT" ).append("\n"); 
		query.append("    ,    OBL_CLT_KNT" ).append("\n"); 
		query.append("    ,    NON_NEGO_PPD_KNT" ).append("\n"); 
		query.append("    ,    NON_NEGO_CLT_KNT" ).append("\n"); 
		query.append("    ,    SGN_CPY_SND_FLG" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("					) = (SELECT BL_RDY_TP_CD" ).append("\n"); 
		query.append("                    ,   nvl(BL_RDY_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   BL_RDY_OFC_CD" ).append("\n"); 
		query.append("                    ,   BL_RDY_USR_ID" ).append("\n"); 
		query.append("                    ,   BL_RDY_DT" ).append("\n"); 
		query.append("                    ,   RQST_BL_TP_CD" ).append("\n"); 
		query.append("                    ,   OBL_RT_INCL_KNT" ).append("\n"); 
		query.append("                    ,   OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append("                    ,   OBL_TTL_KNT" ).append("\n"); 
		query.append("                    ,   NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append("                    ,   NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append("                    ,   CPY_TTL_KNT" ).append("\n"); 
		query.append("                    ,   RQST_ISS_PLC_NM" ).append("\n"); 
		query.append("                    ,   RQST_ISS_DT" ).append("\n"); 
		query.append("                    ,   BL_DE_TO_CD" ).append("\n"); 
		query.append("                    ,   BL_DE_MZD_CD" ).append("\n"); 
		query.append("                    ,   BL_DOC_RQST_RMK" ).append("\n"); 
		query.append("                    ,   BL_ISS_KNT" ).append("\n"); 
		query.append("                    ,   BL_CPY_KNT" ).append("\n"); 
		query.append("                    ,   BL_PRN_VIA_CD" ).append("\n"); 
		query.append("                    ,   nvl(OBL_INET_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   OBL_INET_PRN_DT" ).append("\n"); 
		query.append("                    ,   OBL_INET_PRN_GDT" ).append("\n"); 
		query.append("                    ,   nvl(OBL_PRN_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   CSTMS_CNTR_EXP_DT" ).append("\n"); 
		query.append("                    ,   OBL_ISS_DT" ).append("\n"); 
		query.append("                    ,   OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("                    ,   OBL_ISS_USR_ID" ).append("\n"); 
		query.append("                    ,   OBL_ISS_TP_CD" ).append("\n"); 
		query.append("                    ,   OBL_ISS_KNT" ).append("\n"); 
		query.append("                    ,   nvl(OBL_ISS_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   nvl(OBL_RLSE_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   nvl(OBL_SRND_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   nvl(OBL_RDEM_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   nvl(BL_PRF_SHPR_FLG, 'N')" ).append("\n"); 
		query.append("                    ,   BL_PRF_SHPR_USR_ID" ).append("\n"); 
		query.append("                    ,   BL_PRF_SHPR_OFC_CD" ).append("\n"); 
		query.append("                    ,   BL_PRF_SHPR_DT" ).append("\n"); 
		query.append("                    ,   OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append("                    ,   OBL_RDEM_USR_ID" ).append("\n"); 
		query.append("                    ,   OBL_RDEM_UPD_USR_ID" ).append("\n"); 
		query.append("                    ,   OBL_RDEM_DT" ).append("\n"); 
		query.append("                    ,   OBL_RDEM_KNT" ).append("\n"); 
		query.append("                    ,   BL_OTR_DOC_RCV_CD" ).append("\n"); 
		query.append("                    ,   OTR_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("                    ,   OTR_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("                    ,   OTR_DOC_RCV_DT" ).append("\n"); 
		query.append("                    ,   OTR_DOC_CGOR_FLG" ).append("\n"); 
		query.append("                    ,   IBD_DOC_RCV_FLG" ).append("\n"); 
		query.append("                    ,   IBD_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append("                    ,   IBD_DOC_RCV_USR_ID" ).append("\n"); 
		query.append("                    ,   IBD_DOC_RCV_DT" ).append("\n"); 
		query.append("                    ,   CSTMS_ENTR_CD" ).append("\n"); 
		query.append("                    ,   CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("                    ,   CSTMS_CLR_WH_NM" ).append("\n"); 
		query.append("                    ,   ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("                    ,   ORG_PPD_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append("                    ,   ORG_PPD_RCV_UPD_USR_ID" ).append("\n"); 
		query.append("                    ,   ORG_PPD_RCV_UPD_DT" ).append("\n"); 
		query.append("                    ,   DEST_CLT_RCV_CD" ).append("\n"); 
		query.append("                    ,   DEST_CLT_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append("                    ,   DEST_CLT_RCV_UPD_USR_ID" ).append("\n"); 
		query.append("                    ,   DEST_CLT_RCV_UPD_DT" ).append("\n"); 
		query.append("                    ,   ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("                    ,   ORG_N3PTY_PPD_UPD_OFC_CD" ).append("\n"); 
		query.append("                    ,   ORG_N3PTY_PPD_UPD_USR_ID" ).append("\n"); 
		query.append("                    ,   ORG_N3PTY_PPD_UPD_DT" ).append("\n"); 
		query.append("                    ,   DEST_N3PTY_CLT_CD" ).append("\n"); 
		query.append("                    ,   DEST_N3PTY_CLT_UPD_OFC_CD" ).append("\n"); 
		query.append("                    ,   DEST_N3PTY_CLT_UPD_USR_ID" ).append("\n"); 
		query.append("                    ,   DEST_N3PTY_CLT_UPD_DT" ).append("\n"); 
		query.append("                    ,   DIFF_RMK" ).append("\n"); 
		query.append("					,	sysdate" ).append("\n"); 
		query.append("					,	BL_ISS_TP_CD" ).append("\n"); 
		query.append("                    ,   OBL_ISS_RMK" ).append("\n"); 
		query.append("                    ,   INET_CTRL_PTY_NM" ).append("\n"); 
		query.append("                    ,   INET_CTRL_PTY_NO" ).append("\n"); 
		query.append("                    ,   WBL_PRN_FLG" ).append("\n"); 
		query.append("                    ,   BL_CPY_NO" ).append("\n"); 
		query.append("                    ,   EDW_UPD_DT" ).append("\n"); 
		query.append("                    ,   OBL_PPD_KNT" ).append("\n"); 
		query.append("                    ,   OBL_CLT_KNT" ).append("\n"); 
		query.append("                    ,   NON_NEGO_PPD_KNT" ).append("\n"); 
		query.append("                    ,   NON_NEGO_CLT_KNT" ).append("\n"); 
		query.append("                    ,   SGN_CPY_SND_FLG" ).append("\n"); 
		query.append("                   FROM BKG_BL_ISS_HIS " ).append("\n"); 
		query.append("                  WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                    AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}