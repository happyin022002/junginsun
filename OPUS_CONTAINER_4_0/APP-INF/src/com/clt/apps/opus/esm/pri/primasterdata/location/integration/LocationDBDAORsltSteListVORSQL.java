/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltSteListVORSQL.java
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

public class LocationDBDAORsltSteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
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
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
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
		query.append(", A.STE_CD" ).append("\n"); 
		query.append(", A.STE_NM" ).append("\n"); 
		query.append(", C.CONTI_CD" ).append("\n"); 
		query.append(", C.SCONTI_CD" ).append("\n"); 
		query.append("FROM MDM_STATE A, MDM_COUNTRY B, MDM_SUBCONTINENT C" ).append("\n"); 
		query.append("WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${combo_cnt_cd} != '')" ).append("\n"); 
		query.append("AND	A.CNT_CD = @[combo_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_cd} != '')" ).append("\n"); 
		query.append("AND	A.STE_CD LIKE UPPER(@[ste_cd] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_nm} != '')" ).append("\n"); 
		query.append("AND	UPPER(A.STE_NM) LIKE UPPER('%' || @[ste_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNT_CD, A.STE_CD" ).append("\n"); 

	}
}