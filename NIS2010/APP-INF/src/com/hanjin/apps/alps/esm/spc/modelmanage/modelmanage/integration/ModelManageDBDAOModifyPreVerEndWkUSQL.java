/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOModifyPreVerEndWkUSQL.java
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

public class ModelManageDBDAOModifyPreVerEndWkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 version의 적용 end 주차를 수정합니다.(현재 version start 주차의 1주 이전으로)
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOModifyPreVerEndWkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_st_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOModifyPreVerEndWkUSQL").append("\n"); 
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
		query.append("UPDATE SPC_MDL_VER_MST" ).append("\n"); 
		query.append("SET CFM_FLG = 'Y'" ).append("\n"); 
		query.append("  , VER_END_YRWK = (SELECT PRE_WK" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT COST_YR, COST_WK, LAG(COST_YR||COST_WK) OVER(ORDER BY COST_YR, COST_WK) PRE_WK" ).append("\n"); 
		query.append("                              FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                     WHERE COST_YR = SUBSTR(@[ver_st_yrwk],1,4)" ).append("\n"); 
		query.append("                       AND COST_WK = SUBSTR(@[ver_st_yrwk],5)" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("  , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("  AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("  AND VER_SEQ = TO_NUMBER(@[ver_seq])-1" ).append("\n"); 

	}
}
