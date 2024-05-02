/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExpMasterOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.07.28 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExpMasterOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select ofcList
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExpMasterOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExpMasterOfcListRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD, OFC_ENG_NM" ).append("\n"); 
		query.append(",DECODE( OFC_KND_CD" ).append("\n"); 
		query.append(", '1', 'SHQ'" ).append("\n"); 
		query.append(", '2', 'RHQ'" ).append("\n"); 
		query.append(", '3', 'GOF'" ).append("\n"); 
		query.append(", '4', 'SOF'" ).append("\n"); 
		query.append(", '5', 'LOF'" ).append("\n"); 
		query.append(", '6', 'AGT'" ).append("\n"); 
		query.append(", '' )	OFC_TYPE" ).append("\n"); 
		query.append(",LOC_CD	,decode(OFC_KND_CD,'','MSTOFCCD','MSTOFCCD') dist_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) no, OFC_CD, OFC_ENG_NM, OFC_KND_CD, LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mst_ofc_cd} != '')" ).append("\n"); 
		query.append("and OFC_CD in (@[mst_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 

	}
}