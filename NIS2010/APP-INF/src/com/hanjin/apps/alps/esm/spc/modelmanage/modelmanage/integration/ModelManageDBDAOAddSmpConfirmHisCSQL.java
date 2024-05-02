/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOAddSmpConfirmHisCSQL.java
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

public class ModelManageDBDAOAddSmpConfirmHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Confirm시 smp history 입력
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOAddSmpConfirmHisCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSmpConfirmHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_REV_LANE_HIS (" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , COST_YRWK" ).append("\n"); 
		query.append("  , VER_SEQ" ).append("\n"); 
		query.append("  , MODI_SEQ" ).append("\n"); 
		query.append("  , CNG_ITM_NM" ).append("\n"); 
		query.append("  , MODI_USR_ID" ).append("\n"); 
		query.append("  , MODI_GDT" ).append("\n"); 
		query.append("  , DELT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[trd_cd]" ).append("\n"); 
		query.append("  , @[cost_yrwk]" ).append("\n"); 
		query.append("  , @[ver_seq]" ).append("\n"); 
		query.append("  , (SELECT NVL(MAX(MODI_SEQ)+1,1)" ).append("\n"); 
		query.append("       FROM SPC_MDL_CUST_REV_LANE_HIS" ).append("\n"); 
		query.append("      WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("        AND VER_SEQ = @[ver_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , 'Confirmed'" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), 'YYYY/MM/DD HH24:MI:SS')) AS DATE)" ).append("\n"); 
		query.append("  , 'N'" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}