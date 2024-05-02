/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : INVCommonDBDAOsearchMdmTpSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.13 이석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchMdmTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM container type size table에서 desc를 가져온다.
	  * Ticket ID ; CHM-201006884
	  * 설계자 : 임창빈
	  * 개발자 : 이석준
	  * </pre>
	  */
	public INVCommonDBDAOsearchMdmTpSzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchMdmTpSzRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_SZ_CD," ).append("\n"); 
		query.append("CNTR_TP_CD, " ).append("\n"); 
		query.append("CNTR_TPSZ_LODG_WGT," ).append("\n"); 
		query.append("CNTR_TPSZ_LODG_CAPA," ).append("\n"); 
		query.append("CNTR_TPSZ_TARE_WGT," ).append("\n"); 
		query.append("CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("CNTR_TPSZ_PSA_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("MODI_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("EAI_EVNT_DT," ).append("\n"); 
		query.append("CNTR_TPSZ_GRP_CD," ).append("\n"); 
		query.append("RPT_DP_SEQ," ).append("\n"); 
		query.append("ACIAC_DIV_CD," ).append("\n"); 
		query.append("EAI_IF_ID" ).append("\n"); 
		query.append("from MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("where cntr_tpsz_cd = @[code]" ).append("\n"); 

	}
}