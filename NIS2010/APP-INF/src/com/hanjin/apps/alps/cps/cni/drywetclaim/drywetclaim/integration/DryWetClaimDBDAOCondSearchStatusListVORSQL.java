/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOCondSearchStatusListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOCondSearchStatusListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim 및Incident Case 접수 및 처리 현황 조회 검색 조건
	  * </pre>
	  */
	public DryWetClaimDBDAOCondSearchStatusListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOCondSearchStatusListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  '' DW_CLM_NO" ).append("\n"); 
		query.append(", '' DW_CLM_TP_CD" ).append("\n"); 
		query.append(", '' DW_CO_CD" ).append("\n"); 
		query.append(", '' DW_CLM_REF_VVD_NO" ).append("\n"); 
		query.append(", '' VSL_ENG_NM" ).append("\n"); 
		query.append(", '' INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", '' CRE_OFC_CD" ).append("\n"); 
		query.append(", '' HDLR_OFC_CD" ).append("\n"); 
		query.append(", '' HDLR_USR_ID" ).append("\n"); 
		query.append(", '' DW_CLM_STS_CD" ).append("\n"); 
		query.append(", '' DW_CLM_ATT_DEF_TP_CD" ).append("\n"); 
		query.append(", '' CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' DEFT_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' LABL_PTY_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' DATE_TYPE" ).append("\n"); 
		query.append(", '' FROM_DT" ).append("\n"); 
		query.append(", '' TO_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}