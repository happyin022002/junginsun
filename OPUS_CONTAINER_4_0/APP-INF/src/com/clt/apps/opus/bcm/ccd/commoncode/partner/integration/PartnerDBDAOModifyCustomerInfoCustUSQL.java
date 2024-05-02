/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerDBDAOModifyCustomerInfoCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.14 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOModifyCustomerInfoCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCustomerInfoCust
	  * </pre>
	  */
	public PartnerDBDAOModifyCustomerInfoCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_trd_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("indiv_corp_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOModifyCustomerInfoCustUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("   SET CUST_STS_CD   = 'A'" ).append("\n"); 
		query.append("	,  CNTR_CUST_TP_CD = NVL(@[cntr_cust_tp_cd],CNTR_CUST_TP_CD)" ).append("\n"); 
		query.append("    ,  CUST_RGST_NO = NVL(@[cust_rgst_no], CUST_RGST_NO)" ).append("\n"); 
		query.append("    ,  KEY_ACCT_FLG = NVL(@[key_acct_flg], KEY_ACCT_FLG)" ).append("\n"); 
		query.append("    ,  CUST_GRP_ID  = NVL(@[cust_grp_id], CUST_GRP_ID)" ).append("\n"); 
		query.append("    ,  MLT_TRD_ACCT_FLG = NVL(@[mlt_trd_acct_flg], MLT_TRD_ACCT_FLG)" ).append("\n"); 
		query.append("    ,  INDIV_CORP_DIV_CD = @[indiv_corp_div_cd]" ).append("\n"); 
		query.append("    ,  UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,  UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND   CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 

	}
}