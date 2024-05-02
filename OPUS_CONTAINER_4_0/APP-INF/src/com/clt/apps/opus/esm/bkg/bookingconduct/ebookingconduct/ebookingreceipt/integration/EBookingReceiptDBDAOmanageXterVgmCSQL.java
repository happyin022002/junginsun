/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOmanageXterVgmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
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

public class EBookingReceiptDBDAOmanageXterVgmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOmanageXterVgmCSQL(){
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
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_cust_cntc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOmanageXterVgmCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_VGM (" ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	USR_ID," ).append("\n"); 
		query.append("	XTER_SNDR_ID," ).append("\n"); 
		query.append("  	XTER_RQST_NO," ).append("\n"); 
		query.append("	XTER_RQST_SEQ," ).append("\n"); 
		query.append("	VGM_SEQ," ).append("\n"); 
		query.append("	ACT_TP_CD," ).append("\n"); 
		query.append("	XTER_VGM_RQST_CD," ).append("\n"); 
		query.append("	VGM_WGT," ).append("\n"); 
		query.append("	WGT_UT_CD," ).append("\n"); 
		query.append("	ESIG_CO_NM," ).append("\n"); 
		query.append("	CUST_EML," ).append("\n"); 
		query.append("	VGM_CRE_GDT," ).append("\n"); 
		query.append("	VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	IF_FLG," ).append("\n"); 
		query.append("	UPLD_FLG," ).append("\n"); 
		query.append("	WGT_TP_CD," ).append("\n"); 
		query.append("	REF_ID," ).append("\n"); 
		query.append("	VGM_DT_TP_CD," ).append("\n"); 
		query.append("	VGM_DOC_TP_CD," ).append("\n"); 
		query.append("	VGM_CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("  	@[bkg_no]," ).append("\n"); 
		query.append("  	@[cntr_no]," ).append("\n"); 
		query.append("  	@[usr_id]," ).append("\n"); 
		query.append("	@[xter_sndr_id]," ).append("\n"); 
		query.append("	@[xter_rqst_no]," ).append("\n"); 
		query.append("  	@[xter_rqst_seq]," ).append("\n"); 
		query.append("  	@[xter_rqst_seq]," ).append("\n"); 
		query.append("  	'I'," ).append("\n"); 
		query.append("  	'EDI'," ).append("\n"); 
		query.append("  	@[vgm_wgt]," ).append("\n"); 
		query.append("  	@[vgm_wgt_ut_cd]," ).append("\n"); 
		query.append("  	DECODE(@[vgm_cust_cntc_tp_cd],'RP',@[vgm_cust_cntc_nm])," ).append("\n"); 
		query.append("  	@[vgm_cust_eml]," ).append("\n"); 
		query.append("  	GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE,'GMT')," ).append("\n"); 
		query.append("  	GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE,(SELECT POL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no] AND ROWNUM = 1))," ).append("\n"); 
		query.append("  	@[cre_usr_id]," ).append("\n"); 
		query.append("  	SYSDATE," ).append("\n"); 
		query.append("  	@[cre_usr_id]," ).append("\n"); 
		query.append("  	SYSDATE," ).append("\n"); 
		query.append("  	'N'," ).append("\n"); 
		query.append("  	'N'," ).append("\n"); 
		query.append("	'V',	" ).append("\n"); 
		query.append("  	@[vgm_doc_id_no]," ).append("\n"); 
		query.append("  	@[vgm_dt_tp_cd]," ).append("\n"); 
		query.append("#if (${vgm_doc_tp_cd} != '') " ).append("\n"); 
		query.append("	@[vgm_doc_tp_cd]," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	'SM2'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  	@[vgm_cust_cntc_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}