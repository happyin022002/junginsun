/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOGetYdNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2015.01.02 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetYdNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getYdNm
	  * </pre>
	  */
	public Edi315SendDBDAOGetYdNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetYdNmRSQL").append("\n"); 
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
		query.append("SELECT YD_NM" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[pod_nod_cd] " ).append("\n"); 

	}
}