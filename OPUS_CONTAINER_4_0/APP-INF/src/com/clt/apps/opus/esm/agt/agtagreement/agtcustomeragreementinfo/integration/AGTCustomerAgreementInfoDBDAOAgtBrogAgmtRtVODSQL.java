/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.16 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_AGT_0007]Brokerage Agreement Rate Creation
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM AGT_BROG_AGMT_RT" ).append("\n"); 
		query.append("WHERE BROG_CNT_CD   = @[brog_cnt_cd]" ).append("\n"); 
		query.append("AND BROG_CUST_SEQ = @[brog_cust_seq]" ).append("\n"); 
		query.append("AND BROG_RT_SEQ   = @[brog_rt_seq]" ).append("\n"); 

	}
}