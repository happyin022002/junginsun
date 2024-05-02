/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAODualTypeCustomerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAODualTypeCustomerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역 Calculation Type과 무관하게 Combined Tariff 적용이 필요한 등록된 화주정보 수정
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAODualTypeCustomerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_expt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAODualTypeCustomerUSQL").append("\n"); 
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
		query.append("UPDATE DMT_DUL_TP_EXPT" ).append("\n"); 
		query.append("SET 	DUL_EXPT_EXP_DT = TO_DATE(@[dul_expt_exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	,	EXP_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	EXP_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	,	UPD_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("	AND CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("	AND CUST_EXPT_SEQ = @[cust_expt_seq]" ).append("\n"); 

	}
}