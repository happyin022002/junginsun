/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOCreateRateCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCreateRateCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOCreateRateCACSQL
	  * </pre>
	  */
	public BlRatingDBDAOCreateRateCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCreateRateCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_RATE (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_RT_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , RT_BL_TP_CD " ).append("\n"); 
		query.append("    , FRT_TERM_CD " ).append("\n"); 
		query.append("    , BKG_CTRT_TP_CD " ).append("\n"); 
		query.append("    , PPD_RCV_OFC_CD " ).append("\n"); 
		query.append("    , PPD_PAYR_CNT_CD " ).append("\n"); 
		query.append("    , PPD_PAYR_CUST_SEQ " ).append("\n"); 
		query.append("    , CLT_OFC_CD " ).append("\n"); 
		query.append("    , CLT_PAYR_CNT_CD " ).append("\n"); 
		query.append("    , CLT_PAYR_CUST_SEQ " ).append("\n"); 
		query.append("    , REV_DIV_CD " ).append("\n"); 
		query.append("    , BKG_RT_WHF_EXPT_CD " ).append("\n"); 
		query.append("    , WHF_SHPR_RGST_NO " ).append("\n"); 
		query.append("    , RT_APLY_DT " ).append("\n"); 
		query.append("    , CGO_RCV_DT " ).append("\n"); 
		query.append("    , DIFF_RMK " ).append("\n"); 
		query.append("    , RT_INTER_RMK" ).append("\n"); 
		query.append("    , DOC_INTER_RMK" ).append("\n"); 
		query.append("    , AUD_STS_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , PRC_RT_MTCH_PATT_CD " ).append("\n"); 
		query.append("    , PRC_GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("    , PRC_CMDT_HDR_SEQ " ).append("\n"); 
		query.append("    , PRC_ROUT_SEQ  " ).append("\n"); 
		query.append("    , N1ST_REV_AUD_DT" ).append("\n"); 
		query.append("    , LST_AUD_BAT_DT" ).append("\n"); 
		query.append("    , CALC_CTRT_TP_CD" ).append("\n"); 
		query.append("    , OFT_MSS_FLG" ).append("\n"); 
		query.append("    , OFT_CHK_USR_ID" ).append("\n"); 
		query.append("    , OFT_CHK_DT" ).append("\n"); 
		query.append("    , RT_CHK_RSLT_CD" ).append("\n"); 
		query.append("    , RT_CHK_DT" ).append("\n"); 
		query.append("    , DHF_LOC_CD" ).append("\n"); 
		query.append("    , DDC_CURR_CD" ).append("\n"); 
		query.append("    , DHF_CURR_CD" ).append("\n"); 
		query.append("    , GRP_RAT_RSLT_CD" ).append("\n"); 
		query.append("    , GRP_RAT_FAIL_RSN_CD" ).append("\n"); 
		query.append("    , GRP_RAT_CHK_FLG" ).append("\n"); 
		query.append("    , MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("    , IDA_IHC_AUD_STS_CD" ).append("\n"); 
		query.append("    , IDA_THC_AUD_STS_CD" ).append("\n"); 
		query.append("    , IDA_AUD_BAT_DT" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , 'TMP0000001' CORR_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , @[ca_no] CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , RT_BL_TP_CD " ).append("\n"); 
		query.append("        , FRT_TERM_CD " ).append("\n"); 
		query.append("        , BKG_CTRT_TP_CD " ).append("\n"); 
		query.append("        , PPD_RCV_OFC_CD " ).append("\n"); 
		query.append("        , PPD_PAYR_CNT_CD " ).append("\n"); 
		query.append("        , PPD_PAYR_CUST_SEQ " ).append("\n"); 
		query.append("        , CLT_OFC_CD " ).append("\n"); 
		query.append("        , CLT_PAYR_CNT_CD " ).append("\n"); 
		query.append("        , CLT_PAYR_CUST_SEQ " ).append("\n"); 
		query.append("        , REV_DIV_CD " ).append("\n"); 
		query.append("        , BKG_RT_WHF_EXPT_CD " ).append("\n"); 
		query.append("        , WHF_SHPR_RGST_NO " ).append("\n"); 
		query.append("        , RT_APLY_DT " ).append("\n"); 
		query.append("        , CGO_RCV_DT " ).append("\n"); 
		query.append("        , DIFF_RMK " ).append("\n"); 
		query.append("        , RT_INTER_RMK" ).append("\n"); 
		query.append("        , DOC_INTER_RMK" ).append("\n"); 
		query.append("        , AUD_STS_CD " ).append("\n"); 
		query.append("        , CRE_USR_ID " ).append("\n"); 
		query.append("        , CRE_DT " ).append("\n"); 
		query.append("        , UPD_USR_ID " ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , PRC_RT_MTCH_PATT_CD " ).append("\n"); 
		query.append("        , PRC_GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("        , PRC_CMDT_HDR_SEQ " ).append("\n"); 
		query.append("        , PRC_ROUT_SEQ " ).append("\n"); 
		query.append("        , N1ST_REV_AUD_DT" ).append("\n"); 
		query.append("        , LST_AUD_BAT_DT" ).append("\n"); 
		query.append("        , CALC_CTRT_TP_CD " ).append("\n"); 
		query.append("        , OFT_MSS_FLG" ).append("\n"); 
		query.append("        , OFT_CHK_USR_ID" ).append("\n"); 
		query.append("        , OFT_CHK_DT" ).append("\n"); 
		query.append("        , RT_CHK_RSLT_CD" ).append("\n"); 
		query.append("        , RT_CHK_DT" ).append("\n"); 
		query.append("        , DHF_LOC_CD" ).append("\n"); 
		query.append("        , DDC_CURR_CD" ).append("\n"); 
		query.append("        , DHF_CURR_CD" ).append("\n"); 
		query.append("        , GRP_RAT_RSLT_CD" ).append("\n"); 
		query.append("        , GRP_RAT_FAIL_RSN_CD" ).append("\n"); 
		query.append("        , GRP_RAT_CHK_FLG" ).append("\n"); 
		query.append("        , MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("        , IDA_IHC_AUD_STS_CD" ).append("\n"); 
		query.append("        , IDA_THC_AUD_STS_CD" ).append("\n"); 
		query.append("        , IDA_AUD_BAT_DT" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_RT_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_RATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}