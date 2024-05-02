/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOaddDeclarantCustomerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOaddDeclarantCustomerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add DG Declarant information from BKG
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOaddDeclarantCustomerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOaddDeclarantCustomerCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_DG_CGO_DECL(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_DECL_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	CUST_ADDR" ).append("\n"); 
		query.append(",	CUST_CTY_NM" ).append("\n"); 
		query.append(",	CUST_STE_CD" ).append("\n"); 
		query.append(",	CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(",	CUST_ZIP_ID" ).append("\n"); 
		query.append(",	CUST_PHN_NO" ).append("\n"); 
		query.append(",	CUST_FAX_NO" ).append("\n"); 
		query.append(",	CUST_EML " ).append("\n"); 
		query.append(", 	CRE_USR_ID " ).append("\n"); 
		query.append(",	CRE_DT " ).append("\n"); 
		query.append(",	UPD_USR_ID " ).append("\n"); 
		query.append(",	UPD_DT " ).append("\n"); 
		query.append(",	EDW_UPD_DT " ).append("\n"); 
		query.append(",	DECL_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '') " ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	(	SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_CATE_CD = 'DG'	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_DECL_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	CUST_ADDR" ).append("\n"); 
		query.append(",	CUST_CTY_NM" ).append("\n"); 
		query.append(",	CUST_STE_CD" ).append("\n"); 
		query.append(",	CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(",	CUST_ZIP_ID" ).append("\n"); 
		query.append(",	PHN_NO" ).append("\n"); 
		query.append(",	CUST_FAX_NO" ).append("\n"); 
		query.append(",	CUST_EML " ).append("\n"); 
		query.append(", 	CRE_USR_ID " ).append("\n"); 
		query.append(",	CRE_DT " ).append("\n"); 
		query.append(",	UPD_USR_ID " ).append("\n"); 
		query.append(",	UPD_DT " ).append("\n"); 
		query.append(",	EDW_UPD_DT " ).append("\n"); 
		query.append(",	DECL_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_DG_DECL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '' || ${cgo_seq} == '') " ).append("\n"); 
		query.append("--AND SPCL_CGO_APRO_CD not in ('C','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_seq} != '') " ).append("\n"); 
		query.append("AND DCGO_SEQ = @[cgo_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}