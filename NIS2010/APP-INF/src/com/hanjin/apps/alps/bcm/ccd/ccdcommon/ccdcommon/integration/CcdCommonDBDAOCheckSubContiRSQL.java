/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : CcdCommonDBDAOCheckSubContiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CcdCommonDBDAOCheckSubContiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SUBCONTINENT 테이블에 scontiCd 에 
	  * 해당하는 정보가 있는지 유무를 리턴한다.
	  * </pre>
	  */
	public CcdCommonDBDAOCheckSubContiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.integration").append("\n"); 
		query.append("FileName : CcdCommonDBDAOCheckSubContiRSQL").append("\n"); 
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
		query.append("SELECT SCONTI_CD " ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT " ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND SCONTI_CD = @[sconti_cd]" ).append("\n"); 
		query.append("AND DELT_FLG ='N' " ).append("\n"); 

	}
}