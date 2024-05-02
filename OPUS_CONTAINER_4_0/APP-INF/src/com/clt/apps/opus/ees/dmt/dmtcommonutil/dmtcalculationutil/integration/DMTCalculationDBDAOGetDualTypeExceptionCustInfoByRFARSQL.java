/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOGetDualTypeExceptionCustInfoByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.28 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetDualTypeExceptionCustInfoByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getDualTypeExceptionCustInfoByRFA
	  * </pre>
	  */
	public DMTCalculationDBDAOGetDualTypeExceptionCustInfoByRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetDualTypeExceptionCustInfoByRFARSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC( PRM XPKPRI_RP_MN ) */" ).append("\n"); 
		query.append("CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(",CTRT_CUST_SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_MN PRM" ).append("\n"); 
		query.append(",PRI_RP_HDR PRH" ).append("\n"); 
		query.append("WHERE PRM.PROP_NO = PRH.PROP_NO" ).append("\n"); 
		query.append("AND PRH.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}