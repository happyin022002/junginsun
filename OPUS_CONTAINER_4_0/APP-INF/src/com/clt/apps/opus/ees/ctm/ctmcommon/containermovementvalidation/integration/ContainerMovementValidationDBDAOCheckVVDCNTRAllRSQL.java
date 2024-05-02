/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOCheckVVDCNTRAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOCheckVVDCNTRAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckVVDCNTRAll
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOCheckVVDCNTRAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvdcd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration ").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOCheckVVDCNTRAllRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("FROM CTM_BKG_VVD " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[p_vvdcd], 1 ,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[p_vvdcd], 5 ,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[p_vvdcd], 9 ,1)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("FROM BKG_VVD " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[p_vvdcd], 1 ,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[p_vvdcd], 5 ,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[p_vvdcd], 9 ,1)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}