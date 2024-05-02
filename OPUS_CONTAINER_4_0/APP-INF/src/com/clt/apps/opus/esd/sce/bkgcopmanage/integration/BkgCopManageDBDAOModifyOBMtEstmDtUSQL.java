/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyOBMtEstmDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.12 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyOBMtEstmDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * O/B TRO Confirm 시 dor_arr_dt 를 COP detail 에 반영한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyOBMtEstmDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyOBMtEstmDtUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_DTL A" ).append("\n"); 
		query.append("SET ESTM_DT =" ).append("\n"); 
		query.append("CASE WHEN act_cd = 'MOTYDO' AND ACT_STS_CD <> 'F' THEN to_date(@[dor_arr_dt], 'yyyymmddhh24miss') - (to_date(@[estm_dt], 'yyyymmddhh24miss') - ESTM_DT)" ).append("\n"); 
		query.append("WHEN act_cd = 'MOTZAD' THEN to_date(@[dor_arr_dt], 'yyyymmddhh24miss') ELSE ESTM_DT END," ).append("\n"); 
		query.append("ESTM_GDT =" ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("CASE WHEN act_cd = 'MOTYDO' AND ACT_STS_CD <> 'F' THEN to_date(@[dor_arr_dt], 'yyyymmddhh24miss') - (to_date(@[estm_dt], 'yyyymmddhh24miss') - ESTM_DT)" ).append("\n"); 
		query.append("WHEN act_cd = 'MOTZAD' THEN to_date(@[dor_arr_dt], 'yyyymmddhh24miss') ELSE ESTM_DT END," ).append("\n"); 
		query.append("'GMT')" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND ACT_CD IN ('MOTYDO'," ).append("\n"); 
		query.append("'MOTZAD')" ).append("\n"); 

	}
}