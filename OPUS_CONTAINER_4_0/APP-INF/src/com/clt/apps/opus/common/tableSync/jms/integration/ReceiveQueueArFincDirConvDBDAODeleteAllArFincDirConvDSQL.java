/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.22 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteAllArFinDirConv
	  * </pre>
	  */
	public ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});
		
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM AR_FINC_DIR_CONV" ).append("\n");
		query.append(" WHERE 'Y' = @[delt_flg]" ).append("\n");
	}
}