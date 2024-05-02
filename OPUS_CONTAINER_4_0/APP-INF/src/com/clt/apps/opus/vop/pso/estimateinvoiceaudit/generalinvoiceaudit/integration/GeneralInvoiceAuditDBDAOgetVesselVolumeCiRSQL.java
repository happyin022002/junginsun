/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetVesselVolumeCiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.02
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.09.02 이석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetVesselVolumeCiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel volume을 구하는 로직
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetVesselVolumeCiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetVesselVolumeCiRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(LOA_LEN*VSL_WDT*GREATEST(SMR_DRFT_HGT, 0.14*SQRT(LOA_LEN*VSL_WDT) ) ,0) , 0) " ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR " ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 

	}
}