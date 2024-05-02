/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchPortListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.18 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOsearchPortListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] ARInvoiceExRateMgtDBDAO::searchPortList ( ofc )  
	  * LOCATION 테이블에서 Office 의 contry code에 해당하는 PORT를 조회하여 해당 List에 Setting한다.
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchPortListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchPortListVORSQL").append("\n"); 
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
		query.append("#if (${svr_id} == 'EUR')" ).append("\n"); 
		query.append("SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE CONTI_CD IN ( SELECT CONTI_CD" ).append("\n"); 
		query.append("FROM    MDM_LOCATION WHERE SUBSTR(LOC_CD,1,2)=( SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION WHERE OFC_CD=@[ofc_cd]))" ).append("\n"); 
		query.append("AND CALL_PORT_FLG='Y'" ).append("\n"); 
		query.append("AND DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT LOC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD IN ( SELECT LOC_CD" ).append("\n"); 
		query.append("FROM    MDM_LOCATION WHERE SUBSTR(LOC_CD,1,2)=( SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION WHERE OFC_CD=@[ofc_cd]))" ).append("\n"); 
		query.append("AND CALL_PORT_FLG='Y'" ).append("\n"); 
		query.append("AND DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}