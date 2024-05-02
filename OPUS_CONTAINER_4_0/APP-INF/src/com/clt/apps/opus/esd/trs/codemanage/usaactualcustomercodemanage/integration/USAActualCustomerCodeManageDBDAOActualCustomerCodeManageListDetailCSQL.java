/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.09.02 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Code Detail정보 입력 및 수정
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_act_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_act_cust_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListDetailCSQL").append("\n"); 
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
		query.append("MERGE INTO    TRS_TRSP_USA_ACT_CUST_DTL" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON            (TRSP_ACT_CUST_NO         = @[trsp_act_cust_no] and             	        /* ACT_CUST_NO  - PK */" ).append("\n"); 
		query.append("TRSP_ACT_CUST_SEQ        = @[trsp_act_cust_seq])               		        /* ACT_CUST_SEQ - PK */" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( TRSP_ACT_CUST_NO" ).append("\n"); 
		query.append(", TRSP_ACT_CUST_SEQ" ).append("\n"); 
		query.append(", ACT_CUST_NM" ).append("\n"); 
		query.append(", ACT_CUST_ZIP_CD" ).append("\n"); 
		query.append(", ACT_CUST_ADDR" ).append("\n"); 
		query.append(", ACT_CUST_PHN_NO" ).append("\n"); 
		query.append(", ACT_CUST_FAX_NO" ).append("\n"); 
		query.append(", CNTC_PSON_NM" ).append("\n"); 
		query.append(", ACT_CUST_EML" ).append("\n"); 
		query.append(", ACT_CUST_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", DFLT_ACT_CUST_FLG" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES ( TO_NUMBER(@[trsp_act_cust_no])                           /* TRSP_ACT_CUST_NO */" ).append("\n"); 
		query.append(", TO_NUMBER(@[trsp_act_cust_seq])				              /* TRSP_ACT_CUST_SEQ */" ).append("\n"); 
		query.append(", @[act_cust_nm]                                      /* ACT_CUST_NM    	*/" ).append("\n"); 
		query.append(", @[act_cust_zip_cd]                                      /* ACT_CUST_ZIP_CD */" ).append("\n"); 
		query.append(", @[act_cust_addr]                                      /* ACT_CUST_ADDR    */" ).append("\n"); 
		query.append(", @[act_cust_phn_no]                                      /* ACT_CUST_PHN_NO  */" ).append("\n"); 
		query.append(", @[act_cust_fax_no]                                      /* ACT_CUST_FAX_NO  */" ).append("\n"); 
		query.append(", @[cntc_pson_nm]                                      /* CNTC_PSON_NM    */" ).append("\n"); 
		query.append(", @[act_cust_eml]                                      /* ACT_CUST_EML    */" ).append("\n"); 
		query.append(", @[act_cust_rmk]                                      /* ACT_CUST_RMK    */" ).append("\n"); 
		query.append(", @[cre_usr_id]                                      /* CRE_USR_ID    */" ).append("\n"); 
		query.append(", SYSDATE								  /* CRE_DT        */" ).append("\n"); 
		query.append(", @[cre_ofc_cd]                                      /* CRE_OFC_CD    */" ).append("\n"); 
		query.append(", @[delt_flg]                                      /* DELT_FLG    */" ).append("\n"); 
		query.append(", DECODE(@[dflt_act_cust_flg], '1','Y','N')                 /* DFLT_ACT_CUST_FLG  */" ).append("\n"); 
		query.append(", @[upd_usr_id]                                    	/* UPD_USR_ID    */" ).append("\n"); 
		query.append(", SYSDATE									/* UPD_DT        */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET  ACT_CUST_NM         = @[act_cust_nm]" ).append("\n"); 
		query.append(", ACT_CUST_ZIP_CD     = @[act_cust_zip_cd]" ).append("\n"); 
		query.append(", ACT_CUST_ADDR     	 = @[act_cust_addr]" ).append("\n"); 
		query.append(", ACT_CUST_PHN_NO     = @[act_cust_phn_no]" ).append("\n"); 
		query.append(", ACT_CUST_FAX_NO     = @[act_cust_fax_no]" ).append("\n"); 
		query.append(", CNTC_PSON_NM        = @[cntc_pson_nm]" ).append("\n"); 
		query.append(", ACT_CUST_EML        = @[act_cust_eml]" ).append("\n"); 
		query.append(", ACT_CUST_RMK        = @[act_cust_rmk]" ).append("\n"); 
		query.append(", DELT_USR_ID         = DECODE(@[delt_flg], 'Y', @[upd_usr_id],'')" ).append("\n"); 
		query.append(", DELT_DT          	 = DECODE(@[delt_flg], 'Y', SYSDATE, '')" ).append("\n"); 
		query.append(", DELT_OFC_CD         = DECODE(@[delt_flg], 'Y', @[delt_ofc_cd],'')" ).append("\n"); 
		query.append(", DELT_FLG		     = NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(", DFLT_ACT_CUST_FLG   = DECODE(@[dflt_act_cust_flg], '1','Y','N')" ).append("\n"); 
		query.append(", CRE_OFC_CD          = @[cre_ofc_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT              = SYSDATE" ).append("\n"); 

	}
}