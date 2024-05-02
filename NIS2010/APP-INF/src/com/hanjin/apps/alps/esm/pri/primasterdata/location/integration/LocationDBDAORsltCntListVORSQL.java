/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LocationDBDAORsltCntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2013.01.23 전윤주 [CHM-201322530] MDM 테이블 delete flag 체크 로직 추가
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.location.integration").append("\n"); 
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
		query.append("	 , A.CNT_NM" ).append("\n"); 
		query.append("	 , B.CONTI_CD" ).append("\n"); 
		query.append("	 , A.SCONTI_CD" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY A" ).append("\n"); 
		query.append("	 , MDM_SUBCONTINENT B" ).append("\n"); 
		query.append(" WHERE A.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.CNT_CD LIKE  UPPER(@[cnt_cd] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_nm} != '') " ).append("\n"); 
		query.append("   AND UPPER(A.CNT_NM) LIKE UPPER('%' || @[cnt_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.CNT_CD ASC" ).append("\n"); 

	}
}