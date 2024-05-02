/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadDBDAOPriCrmSlsLdRFAVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.14 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CRMSalesLeadDBDAOPriCrmSlsLdRFAVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRMSalesLeadDBDAOPriCrmSlsLdSCVOUSQL
	  * </pre>
	  */
	public CRMSalesLeadDBDAOPriCrmSlsLdRFAVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ld_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration ").append("\n"); 
		query.append("FileName : CRMSalesLeadDBDAOPriCrmSlsLdRFAVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_CRM_SLS_LD" ).append("\n"); 
		query.append("SET SLS_LD_STS_CD = @[sls_ld_sts_cd]" ).append("\n"); 
		query.append("#if (${sls_ld_no_up}==\"Y\")" ).append("\n"); 
		query.append("WHERE SLS_LD_NO = @[sls_ld_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE SLS_LD_NO = (SELECT SLS_LD_NO FROM PRI_RP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}