/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzDBDAOSearchExptInqMapgOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.31 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqYardOrzDBDAOSearchExptInqMapgOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchExptInqMapgOfc
	  * </pre>
	  */
	public EqYardOrzDBDAOSearchExptInqMapgOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : EqYardOrzDBDAOSearchExptInqMapgOfcRSQL").append("\n"); 
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
		query.append("select OFC_CD, MAPG_OFC_CD, MAPG_OFC_ENG_NM, LOC_CD, CRE_USR_ID, TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') CRE_DT, DELT_FLG" ).append("\n"); 
		query.append(",    '' OFC_ENG_NM,  '' dist_cd, '' ofc_cd_name, '' dist, '' loc_txt, '' ofcnm_txt, '' ofc_txt, '' mst_ofc_cd, '' sel_ofc_cd" ).append("\n"); 
		query.append("FROM SCE_EXPT_OFC_MAPG_INFO" ).append("\n"); 
		query.append("WHERE DELT_FLG= UPPER('N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mst_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE UPPER(@[mst_ofc_cd])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY MAPG_OFC_CD" ).append("\n"); 

	}
}