/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiUSADeliveryOrderHdr
	  * </pre>
	  */
	public USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL(){
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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_sys_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.integration").append("\n"); 
		query.append("FileName : USADeliveryOrderManageDBDAOMultiUSADeliveryOrderHdrUSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO TRS_TRSP_USA_DO_HDR TARGET" ).append("\n"); 
		query.append("USING DUAL SELT" ).append("\n"); 
		query.append("ON(TARGET.BL_NO = @[bl_no])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("FCTRY_NM                = @[fctry_nm]" ).append("\n"); 
		query.append(", ACT_CUST_N1ST_ADDR    = @[act_cust_n1st_addr]" ).append("\n"); 
		query.append(", ACT_CUST_ZIP_CD       = @[act_cust_zip_cd]" ).append("\n"); 
		query.append(", CNTC_PSON_NM          = @[cntc_pson_nm]" ).append("\n"); 
		query.append(", CNTC_PSON_PHN_NO      = @[cntc_pson_phn_no]" ).append("\n"); 
		query.append(", CNTC_PSON_FAX_NO      = @[cntc_pson_fax_no]" ).append("\n"); 
		query.append(", UPD_USR_ID            = @[cre_usr_id]" ).append("\n"); 
		query.append(", UPD_DT                = SYSDATE" ).append("\n"); 
		query.append(", LOCL_UPD_DT			= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("WHERE BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BL_NO" ).append("\n"); 
		query.append(", IF_SYS_KND_CD" ).append("\n"); 
		query.append(", FCTRY_NM" ).append("\n"); 
		query.append(", ACT_CUST_N1ST_ADDR" ).append("\n"); 
		query.append(", ACT_CUST_ZIP_CD" ).append("\n"); 
		query.append(", CNTC_PSON_NM" ).append("\n"); 
		query.append(", CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[bl_no]" ).append("\n"); 
		query.append(", @[if_sys_knd_cd]" ).append("\n"); 
		query.append(", @[fctry_nm]" ).append("\n"); 
		query.append(", @[act_cust_n1st_addr]" ).append("\n"); 
		query.append(", @[act_cust_zip_cd]" ).append("\n"); 
		query.append(", @[cntc_pson_nm]" ).append("\n"); 
		query.append(", @[cntc_pson_phn_no]" ).append("\n"); 
		query.append(", @[cntc_pson_fax_no]" ).append("\n"); 
		query.append(", @[usr_ofc_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}