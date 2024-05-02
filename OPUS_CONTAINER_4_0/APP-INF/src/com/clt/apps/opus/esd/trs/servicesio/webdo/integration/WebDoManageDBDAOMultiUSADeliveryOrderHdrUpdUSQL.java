/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAOMultiUSADeliveryOrderHdrUpdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.04
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.11.04 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebDoManageDBDAOMultiUSADeliveryOrderHdrUpdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delivery Order Header Update
	  * </pre>
	  */
	public WebDoManageDBDAOMultiUSADeliveryOrderHdrUpdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_n1st_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.webdo.integration").append("\n"); 
		query.append("FileName : WebDoManageDBDAOMultiUSADeliveryOrderHdrUpdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_USA_DO_HDR" ).append("\n"); 
		query.append("   SET FCTRY_NM              = @[fctry_nm]" ).append("\n"); 
		query.append("     , ACT_CUST_N1ST_ADDR    = @[act_cust_n1st_addr]" ).append("\n"); 
		query.append("     , ACT_CUST_ZIP_CD       = @[act_cust_zip_cd]" ).append("\n"); 
		query.append("     , CNTC_PSON_NM          = @[cntc_pson_nm]" ).append("\n"); 
		query.append("     , CNTC_PSON_PHN_NO      = @[cntc_pson_phn_no]" ).append("\n"); 
		query.append("     , CNTC_PSON_FAX_NO      = @[cntc_pson_fax_no]" ).append("\n"); 
		query.append("     , USR_EML               = @[usr_eml]" ).append("\n"); 
		query.append("     , USR_PHN_NO            = @[usr_phn_no]" ).append("\n"); 
		query.append("     , UPD_USR_ID            = @[cre_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("     , LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(" WHERE BL_NO       = @[bl_no]" ).append("\n"); 

	}
}