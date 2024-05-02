/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOmanageVgmInfoFmCodecoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOmanageVgmInfoFmCodecoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Save VGM INFO from CODECO
	  * </pre>
	  */
	public EBookingReceiptDBDAOmanageVgmInfoFmCodecoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctm_edi_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_cust_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_cust_cntc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_doc_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_dt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOmanageVgmInfoFmCodecoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_VGM " ).append("\n"); 
		query.append("    (BKG_NO, " ).append("\n"); 
		query.append("     CNTR_NO, " ).append("\n"); 
		query.append("     USR_ID, " ).append("\n"); 
		query.append("     VGM_SEQ, " ).append("\n"); 
		query.append("     ACT_TP_CD, " ).append("\n"); 
		query.append("     XTER_VGM_RQST_CD, " ).append("\n"); 
		query.append("     VGM_WGT, " ).append("\n"); 
		query.append("     WGT_UT_CD, " ).append("\n"); 
		query.append("     ESIG_CO_NM, " ).append("\n"); 
		query.append("     CUST_EML, " ).append("\n"); 
		query.append("     VGM_CRE_GDT, " ).append("\n"); 
		query.append("     VGM_CRE_LOCL_DT, " ).append("\n"); 
		query.append("     CRE_USR_ID, " ).append("\n"); 
		query.append("     CRE_DT, " ).append("\n"); 
		query.append("     UPD_USR_ID, " ).append("\n"); 
		query.append("     UPD_DT, " ).append("\n"); 
		query.append("     IF_FLG, " ).append("\n"); 
		query.append("     UPLD_FLG, " ).append("\n"); 
		query.append("     WGT_TP_CD, " ).append("\n"); 
		query.append("     REF_ID," ).append("\n"); 
		query.append("	 VGM_DT_TP_CD," ).append("\n"); 
		query.append("	 VGM_DOC_TP_CD," ).append("\n"); 
		query.append("	 VGM_CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("     @[bkg_no]," ).append("\n"); 
		query.append("     @[cntr_no]," ).append("\n"); 
		query.append("     @[ctm_edi_tp]," ).append("\n"); 
		query.append("     NVL((SELECT MAX(VGM_SEQ)" ).append("\n"); 
		query.append("                  FROM BKG_XTER_VGM" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND USR_ID = @[ctm_edi_tp]), 0)+1," ).append("\n"); 
		query.append("	 'I'," ).append("\n"); 
		query.append("     'EDI'," ).append("\n"); 
		query.append("     @[vgm_wgt]," ).append("\n"); 
		query.append("     @[vgm_wgt_ut_cd]," ).append("\n"); 
		query.append("     DECODE(@[vgm_cust_cntc_tp_cd],'RP',@[vgm_cust_cntc_nm],'')," ).append("\n"); 
		query.append("     @[vgm_cust_eml]," ).append("\n"); 
		query.append("     GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),TO_DATE(@[vgm_rcv_dt],'YYYYMMDD HH24:MI:SS'),'GMT')," ).append("\n"); 
		query.append("     GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),TO_DATE(@[vgm_rcv_dt],'YYYYMMDD HH24:MI:SS'),(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))," ).append("\n"); 
		query.append("     @[ctm_edi_tp]," ).append("\n"); 
		query.append("     SYSDATE," ).append("\n"); 
		query.append("     @[ctm_edi_tp]," ).append("\n"); 
		query.append("     SYSDATE," ).append("\n"); 
		query.append("     'N'," ).append("\n"); 
		query.append("     'N'," ).append("\n"); 
		query.append("     'V'," ).append("\n"); 
		query.append("     @[vgm_doc_id_no]," ).append("\n"); 
		query.append("	 @[vgm_dt_tp_cd]," ).append("\n"); 
		query.append("	 @[vgm_doc_tp_cd]," ).append("\n"); 
		query.append("	 @[vgm_cust_cntc_tp_cd]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}