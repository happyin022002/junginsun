/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건 
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no_list",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL").append("\n"); 
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
		query.append("SELECT A.DISP_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${disp_no_list} != '')" ).append("\n"); 
		query.append("AND     A.DISP_NO = @[disp_no_list]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}