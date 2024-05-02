/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeDBDAOCheckCodeValueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.12 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicescope.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceScopeDBDAOCheckCodeValueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건 Code의 조회
	  * </pre>
	  */
	public ServiceScopeDBDAOCheckCodeValueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.servicescope.integration").append("\n"); 
		query.append("FileName : ServiceScopeDBDAOCheckCodeValueRSQL").append("\n"); 
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
		query.append("#if (${org_dest_cd} == 'O' && ${org_tp_cd} == 'C')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'O' && ${org_tp_cd} == 'S')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'O' && ${org_tp_cd} == 'R')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'O' && ${org_tp_cd} == 'L')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'D' && ${dest_tp_cd} == 'C')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'D' && ${dest_tp_cd} == 'S')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'D' && ${dest_tp_cd} == 'R')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'D' && ${dest_tp_cd} == 'L')" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}