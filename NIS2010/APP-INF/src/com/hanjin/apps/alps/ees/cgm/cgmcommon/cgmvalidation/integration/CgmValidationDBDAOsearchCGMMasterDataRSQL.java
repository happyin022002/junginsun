/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CgmValidationDBDAOsearchCGMMasterDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
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
		query.append("SELECT   Z.EQ_NO" ).append("\n"); 
		query.append("       , Z.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , Z.CRNT_YD_CD" ).append("\n"); 
		query.append("       , Z.ACIAC_DIV_CD" ).append("\n"); 
		query.append("       , TO_CHAR(Z.CHSS_MVMT_DT,'YYYY-MM-DD HH24:MI') CHSS_MVMT_DT" ).append("\n"); 
		query.append("FROM	 CGM_EQUIPMENT Z" ).append("\n"); 
		query.append("WHERE 	 1 = 1" ).append("\n"); 
		query.append("AND      Z.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND      Z.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   C.CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append("       , C.CNTR_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , C.CRNT_YD_CD" ).append("\n"); 
		query.append("       , C.ACIAC_DIV_CD" ).append("\n"); 
		query.append("       , TO_CHAR(C.CNMV_DT,'YYYY-MM-DD HH24:MI') AS CHSS_MVMT_DT" ).append("\n"); 
		query.append("FROM     MST_CONTAINER C" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      C.CNTR_NO = @[eq_no]" ).append("\n"); 

	}
}