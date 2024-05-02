/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmValidationDBDAOCheckYardDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.15 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOCheckYardDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOCheckYardDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOCheckYardDataRSQL").append("\n"); 
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
		query.append("SELECT  A.YD_CD" ).append("\n"); 
		query.append(",A.YD_NM" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_YARD A" ).append("\n"); 
		query.append("WHERE 	 A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}