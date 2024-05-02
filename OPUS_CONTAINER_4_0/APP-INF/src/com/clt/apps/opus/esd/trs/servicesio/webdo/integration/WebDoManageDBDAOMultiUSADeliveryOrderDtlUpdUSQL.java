/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAOMultiUSADeliveryOrderDtlUpdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.11.01 김종호
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

public class WebDoManageDBDAOMultiUSADeliveryOrderDtlUpdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delivery Order Detail Update
	  * </pre>
	  */
	public WebDoManageDBDAOMultiUSADeliveryOrderDtlUpdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("do_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.webdo.integration").append("\n"); 
		query.append("FileName : WebDoManageDBDAOMultiUSADeliveryOrderDtlUpdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_USA_DO_DTL" ).append("\n"); 
		query.append("   SET DO_RMK        = @[do_rmk]" ).append("\n"); 
		query.append("     , UPD_USR_ID    = @[cre_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT        = SYSDATE " ).append("\n"); 
		query.append("     , LOCL_UPD_DT   = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND EQ_NO = @[eq_no]" ).append("\n"); 

	}
}