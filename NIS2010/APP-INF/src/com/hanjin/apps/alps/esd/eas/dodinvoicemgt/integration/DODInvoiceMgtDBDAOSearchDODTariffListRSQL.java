/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchDODTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchDODTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDODTariffList
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchDODTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchDODTariffListRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD, " ).append("\n"); 
		query.append("       A.POL_CONTI_CD, " ).append("\n"); 
		query.append("       A.POL_CNT_CD," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.DRP_OFF_CHG_TRF_AMT," ).append("\n"); 
		query.append("       A.DELT_FLG," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI:SS') AS CRE_DT,                 " ).append("\n"); 
		query.append("       A.UPD_USR_ID,             " ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("       B.USR_NM AS UPD_USR_NM                " ).append("\n"); 
		query.append("  FROM EAS_DOD_TRF A, COM_USER B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("   #if(${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${pol_conti_cd} != '')" ).append("\n"); 
		query.append("   AND A.POL_CONTI_CD = @[pol_conti_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${eff_dt} != '')" ).append("\n"); 
		query.append("   AND A.EFF_DT = @[eff_dt]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY A.OFC_CD, " ).append("\n"); 
		query.append("       A.POL_CONTI_CD, " ).append("\n"); 
		query.append("       A.POL_CNT_CD," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.EFF_DT DESC" ).append("\n"); 

	}
}