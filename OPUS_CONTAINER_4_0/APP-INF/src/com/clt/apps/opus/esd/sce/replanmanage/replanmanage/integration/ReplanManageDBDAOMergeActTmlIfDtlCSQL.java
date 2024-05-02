/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOMergeActTmlIfDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.01 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOMergeActTmlIfDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * terminal change 결과를 SCE_ACT_TML_IF_DTL 에 관리한다.
	  * </pre>
	  */
	public ReplanManageDBDAOMergeActTmlIfDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_dtl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOMergeActTmlIfDtlCSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO SCE_ACT_TML_IF_DTL S USING (" ).append("\n"); 
		query.append("SELECT @[act_rcv_dt] ACT_RCV_DT," ).append("\n"); 
		query.append("@[act_rcv_no] ACT_RCV_NO," ).append("\n"); 
		query.append("@[cop_no] COP_NO," ).append("\n"); 
		query.append("@[tml_if_dtl_sts_cd] TML_IF_DTL_STS_CD," ).append("\n"); 
		query.append("@[err_msg] ERR_MSG," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) A ON (S.ACT_RCV_DT = A.ACT_RCV_DT" ).append("\n"); 
		query.append("AND S.ACT_RCV_NO = A.ACT_RCV_NO" ).append("\n"); 
		query.append("AND S.COP_NO = A.COP_NO) WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET TML_IF_DTL_STS_CD = A.TML_IF_DTL_STS_CD," ).append("\n"); 
		query.append("ERR_MSG = A.ERR_MSG," ).append("\n"); 
		query.append("CRE_DT = SYSDATE," ).append("\n"); 
		query.append("UPD_DT = SYSDATE WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (S.ACT_RCV_DT," ).append("\n"); 
		query.append("S.ACT_RCV_NO," ).append("\n"); 
		query.append("S.COP_NO," ).append("\n"); 
		query.append("S.TML_IF_DTL_STS_CD," ).append("\n"); 
		query.append("S.ERR_MSG," ).append("\n"); 
		query.append("S.CRE_DT," ).append("\n"); 
		query.append("S.UPD_DT," ).append("\n"); 
		query.append("S.CRE_USR_ID," ).append("\n"); 
		query.append("S.UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES (A.ACT_RCV_DT," ).append("\n"); 
		query.append("A.ACT_RCV_NO," ).append("\n"); 
		query.append("A.COP_NO," ).append("\n"); 
		query.append("A.TML_IF_DTL_STS_CD," ).append("\n"); 
		query.append("A.ERR_MSG," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("'tmlChg'," ).append("\n"); 
		query.append("'tmlChg')" ).append("\n"); 

	}
}