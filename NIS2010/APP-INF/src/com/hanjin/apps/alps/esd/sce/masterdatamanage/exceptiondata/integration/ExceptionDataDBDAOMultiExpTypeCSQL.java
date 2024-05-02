/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOMultiExpTypeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.09 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOMultiExpTypeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi expt
	  * </pre>
	  */
	public ExceptionDataDBDAOMultiExpTypeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cop_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cop_expt_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cop_expt_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOMultiExpTypeCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_EXPT_CD A" ).append("\n"); 
		query.append("USING ( SELECT  @[r_cop_expt_tp_cd] AS COP_EXPT_TP_CD, @[r_ibflag] AS IB_FLG," ).append("\n"); 
		query.append("(select MAX(SUBSTR(EXPT_CD,1,1))+1" ).append("\n"); 
		query.append("FROM SCE_EXPT_CD" ).append("\n"); 
		query.append("where not exists" ).append("\n"); 
		query.append("(select 'X'" ).append("\n"); 
		query.append("FROM SCE_EXPT_CD" ).append("\n"); 
		query.append("WHERE EXPT_CD_NM = @[r_cop_expt_tp_nm]" ).append("\n"); 
		query.append("OR   EXPT_CD_DESC = @[r_cop_expt_tp_desc]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") MAX_TP_CD" ).append("\n"); 
		query.append("FROM    DUAL ) B" ).append("\n"); 
		query.append("ON (SUBSTR(A.EXPT_CD,1,1) = B.COP_EXPT_TP_CD AND B.IB_FLG IN ('U','D'))" ).append("\n"); 
		query.append("WHEN	MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET   UPD_USR_ID   = @[r_usr_id] ," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("ACT_FLG      = DECODE(B.IB_FLG,'D','N', @[r_act_flg])" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( EXPT_CD," ).append("\n"); 
		query.append("EXPT_CD_NM," ).append("\n"); 
		query.append("EXPT_CD_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("ACT_FLG)" ).append("\n"); 
		query.append("VALUES (B.MAX_TP_CD||'0000000', @[r_cop_expt_tp_nm], @[r_cop_expt_tp_desc], @[r_usr_id], SYSDATE, @[r_usr_id], SYSDATE, @[r_act_flg])" ).append("\n"); 
		query.append("WHERE B.MAX_TP_CD IS NOT NULL" ).append("\n"); 

	}
}