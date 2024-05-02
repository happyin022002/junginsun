/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL.java
*@FileTitle : COD Tariff Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CONTI_CD" ).append("\n"); 
		query.append(",	DVS_FEE_TP_CD" ).append("\n"); 
		query.append(",	DVS_FEE_AMT" ).append("\n"); 
		query.append("FROM OPF_COD_DVS_FEE" ).append("\n"); 
		query.append("ORDER BY CONTI_CD, DVS_FEE_TP_CD" ).append("\n"); 

	}
}