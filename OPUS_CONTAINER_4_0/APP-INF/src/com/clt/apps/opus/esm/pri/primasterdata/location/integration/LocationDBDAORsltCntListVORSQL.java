/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltCntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.29 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltCntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LocationDBDAORsltCntListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltCntListVORSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD" ).append("\n"); 
		query.append(", A.CNT_NM" ).append("\n"); 
		query.append(", B.CONTI_CD" ).append("\n"); 
		query.append(", A.SCONTI_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY A" ).append("\n"); 
		query.append(", MDM_SUBCONTINENT B" ).append("\n"); 
		query.append("WHERE A.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.CNT_CD LIKE  UPPER(@[cnt_cd] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(A.CNT_NM) LIKE UPPER('%' || @[cnt_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNT_CD ASC" ).append("\n"); 

	}
}