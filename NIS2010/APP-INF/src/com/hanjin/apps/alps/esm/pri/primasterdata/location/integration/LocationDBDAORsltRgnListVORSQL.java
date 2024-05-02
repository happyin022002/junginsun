/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LocationDBDAORsltRgnListVORSQL.java
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

public class LocationDBDAORsltRgnListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.01.23 전윤주 [CHM-201322530] MDM 테이블 delete flag 체크 로직 추가
	  * </pre>
	  */
	public LocationDBDAORsltRgnListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo2_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltRgnListVORSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD COMBO2_CNT_CD" ).append("\n"); 
		query.append("	 , A.RGN_CD" ).append("\n"); 
		query.append("	 , A.RGN_NM" ).append("\n"); 
		query.append("	 , C.CONTI_CD" ).append("\n"); 
		query.append("	 , C.SCONTI_CD" ).append("\n"); 
		query.append("  FROM MDM_REGION A" ).append("\n"); 
		query.append("	 , MDM_COUNTRY B" ).append("\n"); 
		query.append("	 , MDM_SUBCONTINENT C " ).append("\n"); 
		query.append(" WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${combo2_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND	A.CNT_CD = @[combo2_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_cd} != '') " ).append("\n"); 
		query.append("   AND	A.RGN_CD LIKE  UPPER(@[rgn_cd] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_nm} != '') " ).append("\n"); 
		query.append("   AND	UPPER(A.RGN_NM) LIKE UPPER('%' || @[rgn_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.CNT_CD, A.RGN_CD ASC" ).append("\n"); 

	}
}