/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ReceiveQueueDBDAOupdateApInvHdr4USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.erpcom.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueDBDAOupdateApInvHdr4USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateApInvHdr4
	  * </pre>
	  */
	public ReceiveQueueDBDAOupdateApInvHdr4USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cxl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.erpcom.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueDBDAOupdateApInvHdr4USQL").append("\n"); 
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
		query.append("   SET rcv_err_flg = @[if_flg]," ).append("\n"); 
		query.append("       rcv_err_rsn = @[if_err_rsn]," ).append("\n"); 
		query.append("       cxl_dt = SUBSTR(@[cxl_dt],1,8)" ).append("\n"); 
		query.append(" WHERE csr_no = @[csr_no]" ).append("\n"); 
		query.append(" AND NVL(rcv_err_flg,'N') <> 'E' -- Cancelled 처리 되지 않은 건만 업데이트" ).append("\n"); 

	}
}