/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PoolChassisDBDAOConfirmCancelInvoicePoolChassisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOConfirmCancelInvoicePoolChassisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 상태를 Cancel 상태로 변경
	  * </pre>
	  */
	public PoolChassisDBDAOConfirmCancelInvoicePoolChassisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOConfirmCancelInvoicePoolChassisUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK SET  		 				      " ).append("\n"); 
		query.append("        TRSP_INV_AUD_STS_CD='SV'                        " ).append("\n"); 
		query.append(" 	   ,RGST_NO = ''" ).append("\n"); 
		query.append(" 	   ,UPD_USR_ID = @[usr_id]                                    " ).append("\n"); 
		query.append(" 	   ,INV_CFM_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) " ).append("\n"); 
		query.append(" 	   ,UPD_DT	= SYSDATE" ).append("\n"); 
		query.append("	   , LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])    " ).append("\n"); 
		query.append("  WHERE INV_NO	= @[inv_no]		                                  " ).append("\n"); 
		query.append("    AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 

	}
}