/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCopyCntrByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCopyCntrByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCopyCntrByCntrCSQL(){
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
		params.put("tgt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tgt_cntr_vol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCopyCntrByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CONTAINER (" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append(",           CNTR_NO" ).append("\n"); 
		query.append(",           CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",           CNMV_YR" ).append("\n"); 
		query.append(",           CNMV_ID_NO" ).append("\n"); 
		query.append(",           CNMV_CYC_NO" ).append("\n"); 
		query.append(",           CNMV_STS_CD" ).append("\n"); 
		query.append(",           CNTR_DP_SEQ" ).append("\n"); 
		query.append(",           PCK_TP_CD" ).append("\n"); 
		query.append(",           PCK_QTY" ).append("\n"); 
		query.append(",           CNTR_WGT" ).append("\n"); 
		query.append(",           WGT_UT_CD" ).append("\n"); 
		query.append(",           MEAS_QTY" ).append("\n"); 
		query.append(",           MEAS_UT_CD" ).append("\n"); 
		query.append(",           RCV_TERM_CD" ).append("\n"); 
		query.append(",           DE_TERM_CD" ).append("\n"); 
		query.append(",           ORG_FM_LOC_CD" ).append("\n"); 
		query.append(",           ORG_TO_LOC_CD" ).append("\n"); 
		query.append(",           ORG_YD_CD" ).append("\n"); 
		query.append(",           DEST_FM_LOC_CD" ).append("\n"); 
		query.append(",           DEST_TO_YD_CD" ).append("\n"); 
		query.append(",           DEST_YD_CD" ).append("\n"); 
		query.append(",           POR_NOD_CD" ).append("\n"); 
		query.append(",           POL_YD_CD" ).append("\n"); 
		query.append(",           CNTR_PRT_FLG" ).append("\n"); 
		query.append(",           CNTR_PRT_SEQ" ).append("\n"); 
		query.append(",           CNTR_VOL_QTY" ).append("\n"); 
		query.append(",           ADV_SHTG_CD" ).append("\n"); 
		query.append(",           CNTR_WFG_EXPT_FLG" ).append("\n"); 
		query.append(",           CSTMS_PRN_FLG" ).append("\n"); 
		query.append(",           CSTMS_EXP_DT" ).append("\n"); 
		query.append(",           DCGO_FLG" ).append("\n"); 
		query.append(",           RC_FLG" ).append("\n"); 
		query.append(",           BB_CGO_FLG" ).append("\n"); 
		query.append(",           AWK_CGO_FLG" ).append("\n"); 
		query.append(",           RD_CGO_FLG" ).append("\n"); 
		query.append(",           HNGR_FLG" ).append("\n"); 
		query.append(",           SOC_FLG" ).append("\n"); 
		query.append(",           EQ_SUBST_FLG" ).append("\n"); 
		query.append(",           EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",           CGO_RCV_DT" ).append("\n"); 
		query.append(",           CGO_RCV_YD_CD" ).append("\n"); 
		query.append(",           OB_CY_GEN_DT" ).append("\n"); 
		query.append(",           OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(",           CNMV_FLG" ).append("\n"); 
		query.append(",           CNMV_EVNT_DT" ).append("\n"); 
		query.append(",           PO_NO" ).append("\n"); 
		query.append(",           DO_NO" ).append("\n"); 
		query.append(",           DO_NO_SPLIT" ).append("\n"); 
		query.append(",           DIFF_RMK" ).append("\n"); 
		query.append(",           CNTR_CFM_FLG" ).append("\n"); 
		query.append(",           MCNTR_BDL_NO" ).append("\n"); 
		query.append(",           MF_CFM_FLG" ).append("\n"); 
		query.append(",           CNTR_DELT_FLG" ).append("\n"); 
		query.append(",           CRE_USR_ID" ).append("\n"); 
		query.append(",           CRE_DT" ).append("\n"); 
		query.append(",           UPD_USR_ID" ).append("\n"); 
		query.append(",           UPD_DT" ).append("\n"); 
		query.append(",			VGM_WGT" ).append("\n"); 
		query.append(",			VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",			VGM_CLZ_FLG" ).append("\n"); 
		query.append(",			VGM_WGT_UPD_DT" ).append("\n"); 
		query.append(",			VGM_WGT_UPD_USR_ID" ).append("\n"); 
		query.append(",			WGT_TP_CD" ).append("\n"); 
		query.append(",			SND_VGM_WGT" ).append("\n"); 
		query.append(",			XTER_SNDR_ID" ).append("\n"); 
		query.append(",			XTER_VGM_DOC_ID" ).append("\n"); 
		query.append(",			XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append(",			XTER_VGM_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT      @[tgt_bkg_no]" ).append("\n"); 
		query.append(",           CNTR_NO" ).append("\n"); 
		query.append(",           CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",           CNMV_YR" ).append("\n"); 
		query.append(",           CNMV_ID_NO" ).append("\n"); 
		query.append(",           CNMV_CYC_NO" ).append("\n"); 
		query.append(",           CNMV_STS_CD" ).append("\n"); 
		query.append(",           CNTR_DP_SEQ" ).append("\n"); 
		query.append(",           PCK_TP_CD" ).append("\n"); 
		query.append(",           PCK_QTY" ).append("\n"); 
		query.append(",           CNTR_WGT" ).append("\n"); 
		query.append(",           WGT_UT_CD" ).append("\n"); 
		query.append(",           MEAS_QTY" ).append("\n"); 
		query.append(",           MEAS_UT_CD" ).append("\n"); 
		query.append(",           RCV_TERM_CD" ).append("\n"); 
		query.append(",           DE_TERM_CD" ).append("\n"); 
		query.append(",           ORG_FM_LOC_CD" ).append("\n"); 
		query.append(",           ORG_TO_LOC_CD" ).append("\n"); 
		query.append(",           ORG_YD_CD" ).append("\n"); 
		query.append(",           DEST_FM_LOC_CD" ).append("\n"); 
		query.append(",           DEST_TO_YD_CD" ).append("\n"); 
		query.append(",           DEST_YD_CD" ).append("\n"); 
		query.append(",           POR_NOD_CD" ).append("\n"); 
		query.append(",           POL_YD_CD" ).append("\n"); 
		query.append(",           DECODE(@[tgt_cntr_vol], '1', 'N', 'Y')" ).append("\n"); 
		query.append(",           CNTR_PRT_SEQ" ).append("\n"); 
		query.append(",           @[tgt_cntr_vol]" ).append("\n"); 
		query.append(",           ADV_SHTG_CD" ).append("\n"); 
		query.append(",           CNTR_WFG_EXPT_FLG" ).append("\n"); 
		query.append(",           CSTMS_PRN_FLG" ).append("\n"); 
		query.append(",           CSTMS_EXP_DT" ).append("\n"); 
		query.append(",           DCGO_FLG" ).append("\n"); 
		query.append(",           RC_FLG" ).append("\n"); 
		query.append(",           BB_CGO_FLG" ).append("\n"); 
		query.append(",           AWK_CGO_FLG" ).append("\n"); 
		query.append(",           RD_CGO_FLG" ).append("\n"); 
		query.append(",           HNGR_FLG" ).append("\n"); 
		query.append(",           SOC_FLG" ).append("\n"); 
		query.append(",           EQ_SUBST_FLG" ).append("\n"); 
		query.append(",           EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(",           CGO_RCV_DT" ).append("\n"); 
		query.append(",           CGO_RCV_YD_CD" ).append("\n"); 
		query.append(",           OB_CY_GEN_DT" ).append("\n"); 
		query.append(",           OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(",           CNMV_FLG" ).append("\n"); 
		query.append(",           CNMV_EVNT_DT" ).append("\n"); 
		query.append(",           PO_NO" ).append("\n"); 
		query.append(",           DO_NO" ).append("\n"); 
		query.append(",           DO_NO_SPLIT" ).append("\n"); 
		query.append(",           DIFF_RMK" ).append("\n"); 
		query.append(",           'N' CNTR_CFM_FLG" ).append("\n"); 
		query.append(",           MCNTR_BDL_NO" ).append("\n"); 
		query.append(",           MF_CFM_FLG" ).append("\n"); 
		query.append(",           CNTR_DELT_FLG" ).append("\n"); 
		query.append(",           @[cre_usr_id]" ).append("\n"); 
		query.append(",           SYSDATE" ).append("\n"); 
		query.append(",           @[cre_usr_id]" ).append("\n"); 
		query.append(",           SYSDATE" ).append("\n"); 
		query.append(",			VGM_WGT" ).append("\n"); 
		query.append(",			VGM_WGT_UT_CD" ).append("\n"); 
		query.append(",			VGM_CLZ_FLG" ).append("\n"); 
		query.append(",			VGM_WGT_UPD_DT" ).append("\n"); 
		query.append(",			VGM_WGT_UPD_USR_ID" ).append("\n"); 
		query.append(",			WGT_TP_CD" ).append("\n"); 
		query.append(",			SND_VGM_WGT" ).append("\n"); 
		query.append(",			XTER_SNDR_ID" ).append("\n"); 
		query.append(",			XTER_VGM_DOC_ID" ).append("\n"); 
		query.append(",			XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append(",			XTER_VGM_USR_ID" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("FROM        bkg_cntr_his" ).append("\n"); 
		query.append("WHERE       bkg_no = @[src_bkg_no]" ).append("\n"); 
		query.append("AND         corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("AND         CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM        bkg_container" ).append("\n"); 
		query.append("WHERE       bkg_no = @[src_bkg_no]" ).append("\n"); 
		query.append("AND         CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}