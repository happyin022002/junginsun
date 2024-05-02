/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchCountryCodeByOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
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

public class InvoiceManageDBDAOSearchCountryCodeByOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Cd 의 국가 구분코드 조회
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchCountryCodeByOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchCountryCodeByOfcCdRSQL").append("\n"); 
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
		query.append("SELECT ML.CNT_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("     , MDM_LOCATION ML" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MO.OFC_CD    = @[ofc_cd]" ).append("\n"); 
		query.append("   AND MO.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("   AND MO.LOC_CD    = ML.LOC_CD" ).append("\n"); 
		query.append("   AND ML.DELT_FLG  = 'N'" ).append("\n"); 

	}
}