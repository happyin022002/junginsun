/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IncomeMgtDBDAOcheckReceivableInvSumDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOcheckReceivableInvSumDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public IncomeMgtDBDAOcheckReceivableInvSumDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration ").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOcheckReceivableInvSumDataRSQL").append("\n"); 
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
		query.append("SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("FROM INV_AR_IF_CHG" ).append("\n"); 
		query.append("WHERE SRC_IF_SEQ IN ( SELECT SRC_IF_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_IF_MN" ).append("\n"); 
		query.append("WHERE INV_SRC_NO = @[input_inv_no] )" ).append("\n"); 

	}
}