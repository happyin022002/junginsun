/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchEASEdiHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : Jeong-Seon, AN
*@LastVersion : 1.0
* 2014.05.22 Jeong-Seon, AN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong-Seon, AN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchEASEdiHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEASEdiHeader
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchEASEdiHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchEASEdiHeaderRSQL").append("\n"); 
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
		query.append("SELECT '$$$MSGSTART:'||" ).append("\n"); 
		query.append("RPAD(NVL(TRIM(@[sndr_id]),' '),20,' ')||" ).append("\n"); 
		query.append("RPAD(NVL(TRIM(@[rcv_id]),' '),20,' ')||" ).append("\n"); 
		query.append("RPAD(NVL(TRIM(@[msg_id]),' '),10,' ')||" ).append("\n"); 
		query.append("RPAD(NVL(TRIM('EAS'),' '),3) ||" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'rrmmdd') ||" ).append("\n"); 
		query.append("LTRIM(TO_CHAR(EAS_EDI_SEQ.NEXTVAL, '000009')) STR_FLATFILE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}