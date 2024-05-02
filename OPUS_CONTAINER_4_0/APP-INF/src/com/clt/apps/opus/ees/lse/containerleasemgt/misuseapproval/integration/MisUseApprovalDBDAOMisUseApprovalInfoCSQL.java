/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseApprovalInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseApprovalInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Miss Use Approval 승인내역을 등록한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseApprovalInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseApprovalInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_MSS_USD_APRO (" ).append("\n"); 
		query.append("APRO_NO, APRO_OFC_CD," ).append("\n"); 
		query.append("APRO_DT, APRO_USR_ID," ).append("\n"); 
		query.append("APRO_RMK, CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[apro_no], @[apro_ofc_cd]," ).append("\n"); 
		query.append("TO_DATE(@[apro_dt],'YYYYMMDD'), @[apro_usr_id]," ).append("\n"); 
		query.append("@[apro_rmk], @[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE, @[cre_usr_id], SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}