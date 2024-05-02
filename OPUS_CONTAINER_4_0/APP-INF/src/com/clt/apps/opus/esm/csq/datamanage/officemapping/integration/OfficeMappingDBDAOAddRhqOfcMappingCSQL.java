/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingDBDAOAddRhqOfcMappingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.06.10 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOAddRhqOfcMappingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ별 산하의 판매목표 수립 대상인 Office 정보 추가
	  * </pre>
	  */
	public OfficeMappingDBDAOAddRhqOfcMappingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration ").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOAddRhqOfcMappingCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_QTA_OFC (  " ).append("\n"); 
		query.append("             RGN_OFC_CD" ).append("\n"); 
		query.append("            ,RHQ_CD" ).append("\n"); 
		query.append("            ,ADD_FLG " ).append("\n"); 
		query.append("            ,CRE_USR_ID          " ).append("\n"); 
		query.append("            ,CRE_DT              " ).append("\n"); 
		query.append("            ,UPD_USR_ID         " ).append("\n"); 
		query.append("            ,UPD_DT           )  " ).append("\n"); 
		query.append(" VALUES (                       " ).append("\n"); 
		query.append("             @[rgn_ofc_cd]" ).append("\n"); 
		query.append("            ,@[rhq_cd]" ).append("\n"); 
		query.append("            ,'Y'                 " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                   " ).append("\n"); 
		query.append("            ,SYSDATE             " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,SYSDATE          )" ).append("\n"); 

	}
}