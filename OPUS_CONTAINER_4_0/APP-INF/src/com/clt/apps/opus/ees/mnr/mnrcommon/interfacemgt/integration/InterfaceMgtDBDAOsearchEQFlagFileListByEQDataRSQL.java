/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEQFlagFileListByEQDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.04.08 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEQFlagFileListByEQDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEQFlagFileListByEQData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEQFlagFileListByEQDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEQFlagFileListByEQDataRSQL").append("\n"); 
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
		query.append("SELECT NVL(" ).append("\n"); 
		query.append("(SELECT 'SS' FROM MNR_EQ_STS_V B WHERE  EQ_NO = @[rqst_eq_no]), 'UE') AS EQ_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}