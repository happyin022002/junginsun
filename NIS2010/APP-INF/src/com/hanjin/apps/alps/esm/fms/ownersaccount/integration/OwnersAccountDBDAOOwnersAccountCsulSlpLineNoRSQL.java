/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountCsulSlpLineNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountCsulSlpLineNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountCsulSlpLineNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountCsulSlpLineNoRSQL").append("\n"); 
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
		query.append("SELECT FCS.SLP_SEQ_NO LINE_NO" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP FCS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND FCS.SLP_TP_CD||FCS.SLP_FUNC_CD||FCS.SLP_OFC_CD||FCS.SLP_ISS_DT||FCS.SLP_SER_NO||FCS.SLP_SEQ_NO = @[csr_no]" ).append("\n"); 

	}
}