/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchRdApplCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchRdApplCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * India Digital Signing of Invoices : FTP 전송을 위한 RD 정보를 조회한다.
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchRdApplCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrd_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchRdApplCdRSQL").append("\n"); 
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
		query.append("SELECT  RD_APPL_CD" ).append("\n"); 
		query.append("      , RD_SUB_SYS_CD" ).append("\n"); 
		query.append("FROM    COM_RPT_DSGN_SND_APPL" ).append("\n"); 
		query.append("WHERE   RD_TMPLT_NM = @[mrd_nm]" ).append("\n"); 
		query.append("AND     FAX_EML_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}