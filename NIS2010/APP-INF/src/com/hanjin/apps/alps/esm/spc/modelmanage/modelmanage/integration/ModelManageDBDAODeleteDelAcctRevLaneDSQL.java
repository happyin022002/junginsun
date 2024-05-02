/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAODeleteDelAcctRevLaneDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAODeleteDelAcctRevLaneDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 ver의 rev_lane data copy 후 신규 ver에 존재하지 않는 account 정보를 삭제합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAODeleteDelAcctRevLaneDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAODeleteDelAcctRevLaneDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append(" WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("   AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("   AND (CUST_CNT_CD, CUST_SEQ, NVL(RFA_NO, ' '), NVL(SC_NO, ' ')) NOT IN (SELECT CUST_CNT_CD, CUST_SEQ, NVL(RFA_NO, ' '), NVL(SC_NO, ' ')" ).append("\n"); 
		query.append("                                                                            FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("                                                                           WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("                                                                             AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                             AND VER_SEQ   = @[ver_seq]  )" ).append("\n"); 

	}
}