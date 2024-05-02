/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanalTransitFeeEstimateDBDAOModifyCanalTzFeeRqstAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.02.01 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateDBDAOModifyCanalTzFeeRqstAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanalTzFeeDtl의 Rqst Amt, Rmk 정보를 갱신한다.
	  * 
	  * ===============================
	  * History
	  * 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
	  * </pre>
	  */
	public CanalTransitFeeEstimateDBDAOModifyCanalTzFeeRqstAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateDBDAOModifyCanalTzFeeRqstAmtUSQL").append("\n"); 
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
		query.append("UPDATE PSO_CNL_TZ_FEE_DTL" ).append("\n"); 
		query.append("SET RQST_AMT = @[rqst_amt]" ).append("\n"); 
		query.append(",   DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append("WHERE PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND CALL_SEQ = @[call_seq]" ).append("\n"); 
		query.append("AND LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 

	}
}