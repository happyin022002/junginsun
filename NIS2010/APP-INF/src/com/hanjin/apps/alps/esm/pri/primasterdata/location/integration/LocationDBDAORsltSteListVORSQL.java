/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LocationDBDAORsltSteListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11 
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

public class LocationDBDAORsltSteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.01.23 전윤주 [CHM-201322530] MDM 테이블 delete flag check 로직 추가
	  * 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가  (UI ID로 인한 로직 분기 위해 인자 추가)
	  * </pre>
	  */
	public LocationDBDAORsltSteListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltSteListVORSQL").append("\n"); 
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
		query.append("SELECT A.CNT_CD COMBO_CNT_CD" ).append("\n"); 
		query.append("	 , A.STE_CD" ).append("\n"); 
		query.append("	 , A.STE_NM" ).append("\n"); 
		query.append("	 , C.CONTI_CD" ).append("\n"); 
		query.append("	 , C.SCONTI_CD" ).append("\n"); 
		query.append("  FROM MDM_STATE A, MDM_COUNTRY B, MDM_SUBCONTINENT C " ).append("\n"); 
		query.append(" WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${combo_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND A.CNT_CD = @[combo_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ui_id} != '4003') " ).append("\n"); 
		query.append("   #if (${ste_cd} != '') " ).append("\n"); 
		query.append("   AND A.STE_CD LIKE UPPER(@[ste_cd] || '%')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${ste_cd} != '') " ).append("\n"); 
		query.append("   AND	A.STE_CD = UPPER(@[ste_cd])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_nm} != '') " ).append("\n"); 
		query.append("   AND	UPPER(A.STE_NM) LIKE UPPER('%' || @[ste_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.CNT_CD, A.STE_CD" ).append("\n"); 

	}
}