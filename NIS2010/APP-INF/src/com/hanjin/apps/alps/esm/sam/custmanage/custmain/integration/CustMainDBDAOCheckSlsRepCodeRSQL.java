/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOCheckSlsRepCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOCheckSlsRepCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep check
	  * </pre>
	  */
	public CustMainDBDAOCheckSlsRepCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOCheckSlsRepCodeRSQL").append("\n"); 
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
		query.append("SELECT SREP_CD " ).append("\n"); 
		query.append("       ,MSR.SREP_NM" ).append("\n"); 
		query.append("       ,MSR.OFC_CD" ).append("\n"); 
		query.append("       ,MSR.MPHN_NO" ).append("\n"); 
		query.append("       ,MSR.SREP_EML" ).append("\n"); 
		query.append("FROM MDM_SLS_REP MSR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("AND SREP_STS_CD = 'N'" ).append("\n"); 

	}
}