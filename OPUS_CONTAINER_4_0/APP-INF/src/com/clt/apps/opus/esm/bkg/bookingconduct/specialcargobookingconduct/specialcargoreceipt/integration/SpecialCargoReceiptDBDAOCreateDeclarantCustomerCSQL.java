/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOCreateDeclarantCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOCreateDeclarantCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG Shipper , DG Consignee 정보를 저장한다.
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOCreateDeclarantCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("decl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOCreateDeclarantCustomerCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DG_DECL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	DCGO_SEQ," ).append("\n"); 
		query.append("	DG_DECL_SEQ," ).append("\n"); 
		query.append("	DG_CNTR_SEQ, " ).append("\n"); 
		query.append("	CNTR_CGO_SEQ," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	BKG_CUST_TP_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD," ).append("\n"); 
		query.append("	CUST_SEQ," ).append("\n"); 
		query.append("	CUST_NM," ).append("\n"); 
		query.append("	CUST_ADDR," ).append("\n"); 
		query.append("	CUST_CTY_NM," ).append("\n"); 
		query.append("	CUST_STE_CD," ).append("\n"); 
		query.append("	CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append("	CUST_ZIP_ID," ).append("\n"); 
		query.append("	PHN_NO," ).append("\n"); 
		query.append("	CUST_FAX_NO," ).append("\n"); 
		query.append("	CUST_EML," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	DECL_NM" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	1," ).append("\n"); 
		query.append("	(SELECT NVL(MAX(DG_DECL_SEQ),0)+1 FROM BKG_DG_DECL WHERE BKG_NO=@[bkg_no] AND DG_CNTR_SEQ=@[dg_cntr_seq])," ).append("\n"); 
		query.append("	@[dg_cntr_seq]," ).append("\n"); 
		query.append("	@[cntr_cgo_seq]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	(SELECT CNTR_NO FROM BKG_DG_CGO_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND DG_CNTR_SEQ = @[dg_cntr_seq] AND ROWNUM =1)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	(SELECT CNTR_NO FROM BKG_DG_CGO WHERE BKG_NO = @[bkg_no] AND DG_CNTR_SEQ = @[dg_cntr_seq] AND ROWNUM = 1)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	@[bkg_cust_tp_cd]," ).append("\n"); 
		query.append("	@[cust_cnt_cd]," ).append("\n"); 
		query.append("	@[cust_seq]," ).append("\n"); 
		query.append("	@[cust_nm]," ).append("\n"); 
		query.append("	@[cust_addr]," ).append("\n"); 
		query.append("	@[cust_cty_nm]," ).append("\n"); 
		query.append("	@[cust_ste_cd]," ).append("\n"); 
		query.append("	@[cstms_decl_cnt_cd]," ).append("\n"); 
		query.append("	@[cust_zip_id]," ).append("\n"); 
		query.append("	@[phn_no]," ).append("\n"); 
		query.append("	@[cust_fax_no]," ).append("\n"); 
		query.append("	@[cust_eml]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[decl_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}