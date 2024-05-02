/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOModifySamSungHeaderUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.04.07 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOModifySamSungHeaderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 문서번호 및 전송 BL의 내용에 send Flag='Y' 및 OBRD_DT를  update한다.
	  * GERP BL 테이블에 update.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOModifySamSungHeaderUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOModifySamSungHeaderUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_EDI_GERP_HDR" ).append("\n"); 
		query.append("SET SND_FLG = 'Y'," ).append("\n"); 
		query.append("  SND_DT = SYSDATE,	" ).append("\n"); 
		query.append("  UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("  UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND MSG_NO = @[msg_no]" ).append("\n"); 

	}
}