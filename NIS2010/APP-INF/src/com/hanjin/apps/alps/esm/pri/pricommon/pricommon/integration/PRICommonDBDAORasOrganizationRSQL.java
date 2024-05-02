/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORasOrganizationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORasOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조직도 조회( Ras 용 )
	  * </pre>
	  */
	public PRICommonDBDAORasOrganizationRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  OFC_CD AS CD" ).append("\n"); 
		query.append(",		PRNT_OFC_CD 	AS NM" ).append("\n"); 
		query.append("FROM  BKG_REV_ORZ_V" ).append("\n"); 
		query.append("WHERE  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${etc2} == '')" ).append("\n"); 
		query.append("AND   OFC_TP_CD   = 'HQ'" ).append("\n"); 
		query.append("ORDER BY    OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   OFC_TP_CD   <> 'AQ'" ).append("\n"); 
		query.append("START WITH PRNT_OFC_CD = @[etc2]" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("ORDER BY    OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORasOrganizationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}