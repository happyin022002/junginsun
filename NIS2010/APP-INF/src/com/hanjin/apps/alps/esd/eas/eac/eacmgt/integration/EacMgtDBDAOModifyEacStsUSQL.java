/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOModifyEacStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.08 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOModifyEacStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 EAC 자료의 상태를 변경한다
	  * </pre>
	  */
	public EacMgtDBDAOModifyEacStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOModifyEacStsUSQL").append("\n"); 
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
		query.append("UPDATE EAS_EXPN_AUD_CS_MGMT" ).append("\n"); 
		query.append("SET    EAC_STS_CD = @[eac_sts_cd]" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${eac_sts_cd} == 'SC') " ).append("\n"); 
		query.append("     , DELT_FLG    = 'Y'" ).append("\n"); 
		query.append("#elseif (${eac_sts_cd} == 'RC') " ).append("\n"); 
		query.append("     , EAC_YRMON = CASE WHEN TO_CHAR(TPB_GET_LCL_DATE_FNC(SYSDATE,@[ofc_cd]), 'DD') <= '05' THEN TO_CHAR(ADD_MONTHS(TPB_GET_LCL_DATE_FNC(SYSDATE,@[ofc_cd]), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                        ELSE TO_CHAR(TPB_GET_LCL_DATE_FNC(SYSDATE,@[ofc_cd]), 'YYYYMM')" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eac_sts_cd} == 'SC' || ${eac_sts_cd} == 'RR' || ${eac_sts_cd} == 'HR')" ).append("\n"); 
		query.append("     , EAC_CMPL_CD = 'X'" ).append("\n"); 
		query.append("     , EAC_CMPL_USR_ID = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  EAC_NO = @[eac_no]" ).append("\n"); 

	}
}