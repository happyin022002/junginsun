/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyWHFDeclNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.06
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.06 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyWHFDeclNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyWHFDeclNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyWHFDeclNoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("   SET WHF_DECL_NO  = ''," ).append("\n"); 
		query.append("       WHF_DECL_CFM_DT = ''," ).append("\n"); 
		query.append("       WHF_DECL_VSL_CD = ''," ).append("\n"); 
		query.append("       WHF_DECL_VOY_NO = ''," ).append("\n"); 
		query.append("       WHF_DECL_DIR_CD = '',       " ).append("\n"); 
		query.append("       WHF_DECL_OFC_CD = ''," ).append("\n"); 
		query.append("       WHF_MRN_NO = ''," ).append("\n"); 
		query.append("       WHF_NTC_NO = ''," ).append("\n"); 
		query.append("       CSR_NO = ''," ).append("\n"); 
		query.append("       WHF_FLG = 'N'," ).append("\n"); 
		query.append("       INV_RMK = @[whf_decl_no]||'-CANCEL'," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	   UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(" WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND WHF_DECL_NO = @[whf_decl_no]" ).append("\n"); 

	}
}