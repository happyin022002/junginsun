/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOMakeApEvidNo07RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.24 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOMakeApEvidNo07RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * APEVID NO 조회(07이전)
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOMakeApEvidNo07RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TAX_NO_02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TAX_NO_TOTAL",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOMakeApEvidNo07RSQL").append("\n"); 
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
		query.append("SELECT 		LPAD(NVL(MAX(SUBSTR(E.EVID_NO,12,4)),0)+1,4,'0')		TAX_SER_NO" ).append("\n"); 
		query.append("FROM   		AP_EVID_NO 							E" ).append("\n"); 
		query.append("WHERE  		SUBSTR(E.EVID_NO,1,LENGTH(@[TAX_NO_TOTAL])) 		= @[TAX_NO_TOTAL]" ).append("\n"); 
		query.append("AND    		SUBSTR(E.EVID_NO,LENGTH(@[TAX_NO_TOTAL])+1,4) 	<> SUBSTR(@[TAX_NO_02],1,4)" ).append("\n"); 

	}
}