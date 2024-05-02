/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOMultiExpTypeDetailForPstmtfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.14 이중환
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

public class ExceptionDataDBDAOMultiExpTypeDetailForPstmtfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi queryStrFAct
	  * </pre>
	  */
	public ExceptionDataDBDAOMultiExpTypeDetailForPstmtfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_act",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cop_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_expt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cop_expt_tp_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_act_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOMultiExpTypeDetailForPstmtfCSQL").append("\n"); 
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
		query.append("MERGE  INTO   SCE_EXPT_CD A" ).append("\n"); 
		query.append("USING  ( SELECT   @[f_cop_expt_tp_cd] AS EXPT_TP					--exception Type" ).append("\n"); 
		query.append(", @[f_fm_expt_cd] AS EXPT_CD         		--from Activity expt_cd" ).append("\n"); 
		query.append(", @[f_ibflag] AS IB_FLG  								--insert/update/delete IBSheet SCREEN flag" ).append("\n"); 
		query.append(", @[f_fm_act] AS EXPT_CD_NM      				--from Activity Code" ).append("\n"); 
		query.append(", @[f_fm_act_nm] AS EXPT_CD_DESC         --from Activity Name" ).append("\n"); 
		query.append(", @[f_cop_expt_tp_dtl_desc] AS COP_EXPT_TP_DTL_DESC    --from Activity Description" ).append("\n"); 
		query.append(", @[f_act_flg] AS ACT_FLG                --act_flg" ).append("\n"); 
		query.append(", @[f_usr_id] AS UPD_USR_ID              --login_user" ).append("\n"); 
		query.append("FROM    DUAL ) B" ).append("\n"); 
		query.append("ON     ( A.EXPT_CD = B.EXPT_CD  )" ).append("\n"); 
		query.append("WHEN   MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    EXPT_CD_NM           = B.EXPT_CD_NM," ).append("\n"); 
		query.append("EXPT_CD_DESC         = B.EXPT_CD_DESC," ).append("\n"); 
		query.append("COP_EXPT_TP_DTL_DESC = B.COP_EXPT_TP_DTL_DESC," ).append("\n"); 
		query.append("UPD_USR_ID           = B.UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT               = SYSDATE," ).append("\n"); 
		query.append("ACT_FLG              = DECODE(B.IB_FLG,'D','N', B.ACT_FLG)" ).append("\n"); 
		query.append("WHEN   NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( EXPT_CD," ).append("\n"); 
		query.append("EXPT_CD_NM," ).append("\n"); 
		query.append("EXPT_CD_DESC," ).append("\n"); 
		query.append("COP_EXPT_TP_DTL_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("ACT_FLG," ).append("\n"); 
		query.append("UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES (@[f_fm_expt_cd], @[f_fm_act], @[f_fm_act_nm], @[f_cop_expt_tp_dtl_desc], @[f_usr_id], SYSDATE, DECODE(@[f_ibflag],'D','N', @[f_act_flg]), @[f_usr_id])" ).append("\n"); 
		query.append("WHERE B.EXPT_CD IS NOT NULL" ).append("\n"); 

	}
}