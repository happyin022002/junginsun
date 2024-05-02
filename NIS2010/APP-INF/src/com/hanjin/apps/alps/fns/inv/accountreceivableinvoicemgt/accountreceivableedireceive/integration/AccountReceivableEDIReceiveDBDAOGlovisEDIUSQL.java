/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDIReceiveDBDAOGlovisEDIUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.14 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDIReceiveDBDAOGlovisEDIUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket ID CHM-201006884
	  * 설계자 : 임창빈
	  * 개발자 : 이석준
	  * 일정 : 2010.11.22 ~ 2010.11.26
	  * 내용 : Glovis EDI 수신하여INV_EDI_GLOVIS_HDR  table에 저장
	  * </pre>
	  */
	public AccountReceivableEDIReceiveDBDAOGlovisEDIUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_err_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glovis_edi_msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glovis_re_err_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDIReceiveDBDAOGlovisEDIUSQL").append("\n"); 
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
		query.append("UPDATE  INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("SET     INV_RMK       = @[inv_rmk]" ).append("\n"); 
		query.append("        , RE_TP_CD    = @[re_tp_cd]" ).append("\n"); 
		query.append("        , RE_RMK      = @[re_rmk]" ).append("\n"); 
		query.append("        , GLOVIS_RE_ERR_CD = @[glovis_re_err_cd]" ).append("\n"); 
		query.append("        , RE_ERR_RMK  = @[re_err_rmk]" ).append("\n"); 
		query.append("        , UPD_USR_ID  = 'GLOVIS'" ).append("\n"); 
		query.append("        , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE   GLOVIS_EDI_MSG_NO   = @[glovis_edi_msg_no]" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                    FROM INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("                   WHERE GLOVIS_EDI_MSG_NO   = @[glovis_edi_msg_no]" ).append("\n"); 
		query.append("                     AND RE_TP_CD = 'A'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}