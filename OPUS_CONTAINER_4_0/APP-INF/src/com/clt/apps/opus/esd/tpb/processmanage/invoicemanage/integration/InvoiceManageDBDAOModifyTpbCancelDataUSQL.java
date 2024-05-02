/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOModifyTpbCancelDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOModifyTpbCancelDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InvoiceManageDBDAOModifyTpbCancelDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOModifyTpbCancelDataUSQL").append("\n"); 
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
		query.append("UPDATE TPB_OTS_DTL" ).append("\n"); 
		query.append("   SET N3PTY_NO = '', " ).append("\n"); 
		query.append("       N3PTY_NO_DP_SEQ = '', " ).append("\n"); 
		query.append("       CFM_DT = '', " ).append("\n"); 
		query.append("       N3PTY_CFM_CD = 'I', " ).append("\n"); 
		query.append("       CFM_OFC_CD = '', " ).append("\n"); 
		query.append("       CFM_USR_ID = ''," ).append("\n"); 
		query.append("       UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE N3PTY_NO = @[n3pty_no]" ).append("\n"); 

	}
}