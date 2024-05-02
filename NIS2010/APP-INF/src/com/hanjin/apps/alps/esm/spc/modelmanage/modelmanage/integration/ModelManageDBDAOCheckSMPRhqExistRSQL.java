/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOCheckSMPRhqExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOCheckSMPRhqExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LANE ADD한 데이터가 기존재하는지 확인합니다.
	  * </pre>
	  */
	public ModelManageDBDAOCheckSMPRhqExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration ").append("\n"); 
		query.append("FileName : ModelManageDBDAOCheckSMPRhqExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append(" WHERE COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND VER_SEQ          = @[ver_seq]" ).append("\n"); 
		query.append("   AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD			= @[rlane_cd]" ).append("\n"); 
		query.append("   AND SLS_RHQ_CD       = @[sls_rhq_cd]" ).append("\n"); 
		query.append("   AND SLS_RGN_OFC_CD   = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND CTRT_OFC_CD      = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("   AND NVL(SC_NO , 'X') = NVL(@[sc_no] , 'X')" ).append("\n"); 
		query.append("   AND NVL(RFA_NO, 'X') = NVL(@[rfa_no], 'X')" ).append("\n"); 

	}
}