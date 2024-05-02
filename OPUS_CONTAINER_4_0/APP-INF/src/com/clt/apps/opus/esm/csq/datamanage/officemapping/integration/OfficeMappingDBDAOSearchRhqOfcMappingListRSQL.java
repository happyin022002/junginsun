/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchRhqOfcMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchRhqOfcMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchRhqOfcMappingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchRhqOfcMappingListRSQL").append("\n"); 
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
		query.append("SELECT RGN_OFC_CD " ).append("\n"); 
		query.append("      ,RHQ_CD " ).append("\n"); 
		query.append("      ,ADD_FLG " ).append("\n"); 
		query.append("	  ,DELT_FLG" ).append("\n"); 
		query.append("  FROM CSQ_QTA_OFC" ).append("\n"); 
		query.append(" WHERE RHQ_CD = DECODE(@[f_rhq_cd],'All',RHQ_CD,@[f_rhq_cd])" ).append("\n"); 
		query.append("#if (${f_deleted_flg} == 'N' || ${f_deleted_flg} == '')" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_deleted_flg} == 'Y')" ).append("\n"); 
		query.append("	AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 

	}
}