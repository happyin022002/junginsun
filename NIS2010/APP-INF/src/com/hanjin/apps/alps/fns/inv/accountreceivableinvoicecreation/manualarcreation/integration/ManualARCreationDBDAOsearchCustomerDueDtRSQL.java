/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchCustomerDueDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.22 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ManualARCreationDBDAOsearchCustomerDueDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustomerDueDt
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchCustomerDueDtRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  REP_CUST_CNT_CD ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(REP_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("REP_CUST_CNT_CD INV_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(REP_CUST_SEQ, 6, '0') INV_CUST_SEQ," ).append("\n"); 
		query.append("DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[sail_arr_dt], 'YYYY-MM-DD') + NVL(IB_CR_TERM_DYS,0), 'YYYY-MM-DD')," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[sail_arr_dt], 'YYYY-MM-DD') + NVL(OB_CR_TERM_DYS,0), 'YYYY-MM-DD')) DUE_DT" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DELT_FLG <> 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchCustomerDueDtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}