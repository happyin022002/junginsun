/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOCancelApPayInvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2011.03.08 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkChaeHeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOCancelApPayInvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CancelApPayInv
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOCancelApPayInvUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration ").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOCancelApPayInvUSQL").append("\n"); 
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
		query.append("UPDATE AP_PAY_INV" ).append("\n"); 
		query.append("   SET DELT_FLG = 'Y', INV_STS_CD = 'X' " ).append("\n"); 
		query.append(" WHERE INV_RGST_NO    = @[inv_rgst_no]" ).append("\n"); 

	}
}