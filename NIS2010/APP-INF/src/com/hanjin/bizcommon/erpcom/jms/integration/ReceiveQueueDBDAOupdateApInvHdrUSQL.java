/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReceiveQueueDBDAOupdateApInvHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.20 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.erpcom.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueDBDAOupdateApInvHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_HDR UPDATE
	  * </pre>
	  */
	public ReceiveQueueDBDAOupdateApInvHdrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.erpcom.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueDBDAOupdateApInvHdrUSQL").append("\n"); 
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
		query.append("UPDATE ap_inv_hdr" ).append("\n"); 
		query.append("SET if_flg = SUBSTR(@[if_flag],0,1)," ).append("\n"); 
		query.append("if_dt = TO_DATE(@[if_date],'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("if_err_rsn = HJSEAI_PKG.h_decode(@[if_err_rsn],'ERP','BMS')" ).append("\n"); 
		query.append("WHERE csr_no = @[csr_no]" ).append("\n"); 

	}
}