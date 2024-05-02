/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmValidationDBDAOsearchCGMMasterDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.13 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOsearchCGMMasterDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOsearchCGMMasterDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOsearchCGMMasterDataRSQL").append("\n"); 
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
		query.append("SELECT  A.EQ_NO" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.CRNT_YD_CD" ).append("\n"); 
		query.append(",A.ACIAC_DIV_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.CHSS_MVMT_DT,'YYYY-MM-DD HH24:MI') CHSS_MVMT_DT" ).append("\n"); 
		query.append("FROM	CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE 	@[eq_no]     = A.EQ_NO" ).append("\n"); 
		query.append("AND   @[eq_knd_cd] = A.EQ_KND_CD" ).append("\n"); 

	}
}