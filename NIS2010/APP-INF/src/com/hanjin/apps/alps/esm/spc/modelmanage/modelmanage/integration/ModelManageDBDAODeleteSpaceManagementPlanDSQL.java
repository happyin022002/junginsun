/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAODeleteSpaceManagementPlanDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAODeleteSpaceManagementPlanDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미컨펌된 버전의 H/O data Save 시 존재하는 해당 버전의 정보를 삭제합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAODeleteSpaceManagementPlanDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAODeleteSpaceManagementPlanDSQL").append("\n"); 
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
		query.append("DELETE FROM SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("      WHERE COST_YRWK = @[season]" ).append("\n"); 
		query.append("        AND VER_SEQ = @[version]" ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("        AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_cd} != '') " ).append("\n"); 
		query.append("        AND CUST_CNT_CD = SUBSTR(@[acct_cd],1,2)" ).append("\n"); 
		query.append("        AND CUST_SEQ = SUBSTR(@[acct_cd],3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_clss} != '') " ).append("\n"); 
		query.append("        AND (CUST_CNT_CD, CUST_SEQ) IN " ).append("\n"); 
		query.append("                 (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                  #if (${acct_clss} == 'KA') " ).append("\n"); 
		query.append("                     AND NEW_KEY_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("                  #elseif (${acct_clss} == 'GA') " ).append("\n"); 
		query.append("                     AND GLO_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("                  #elseif (${acct_clss} == 'RA')" ).append("\n"); 
		query.append("                     AND RGN_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("                  #elseif (${acct_clss} == 'LA')" ).append("\n"); 
		query.append("                     AND 'Y' NOT IN (NVL(NEW_KEY_ACCT_FLG,' '), NVL(GLO_ACCT_FLG, ' '), NVL(RGN_ACCT_FLG, ' '))" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}