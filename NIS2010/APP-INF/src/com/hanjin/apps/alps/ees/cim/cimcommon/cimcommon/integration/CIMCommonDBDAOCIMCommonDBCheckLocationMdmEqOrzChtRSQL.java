/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CIMCommonDBDAOCIMCommonDBCheckLocationMdmEqOrzChtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.02.01 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOCIMCommonDBCheckLocationMdmEqOrzChtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CIMCommonDBDAOCIMCommonDBCheckLocationMdmEqOrzChtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locCD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locLevel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOCIMCommonDBCheckLocationMdmEqOrzChtRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM    MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE  	DECODE ( @[locLevel] ,  'S',  SCC_CD	,  /* SCC */" ).append("\n"); 
		query.append("	                          'E',  ECC_CD	,  /* ECC */" ).append("\n"); 
		query.append("	                          'L',  LCC_CD	,  /* LCC */" ).append("\n"); 
		query.append(" 		                            RCC_CD   ) /* RCC */" ).append("\n"); 
		query.append("	       =	@[locCD]" ).append("\n"); 
		query.append("AND    ROWNUM =1" ).append("\n"); 

	}
}