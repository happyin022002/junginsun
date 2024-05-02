/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchClosingStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.03 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchClosingStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchClosingStatusRSQL(){
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
		params.put("pgm_gubn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchClosingStatusRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CLZ_STS_CD_1, 'O', CLZ_STS_CD_1, CLZ_STS_CD_2) CLZ_STS_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MAX(A.CLZ_STS_CD) CLZ_STS_CD_1," ).append("\n"); 
		query.append("MAX(B.CLZ_STS_CD) CLZ_STS_CD_2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CLZ_STS_CD" ).append("\n"); 
		query.append("FROM AP_PERIOD" ).append("\n"); 
		query.append("WHERE SYS_DIV_CD = DECODE(@[pgm_gubn], 'O', '11', 'M', '33')" ).append("\n"); 
		query.append("AND EFF_YRMON = SUBSTR(@[eff_dt], 1, 6)" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc] ) A FULL OUTER JOIN (" ).append("\n"); 
		query.append("SELECT CLZ_STS_CD" ).append("\n"); 
		query.append("FROM AP_PERIOD" ).append("\n"); 
		query.append("WHERE SYS_DIV_CD = DECODE(@[pgm_gubn], 'O', '11', 'M', '33')" ).append("\n"); 
		query.append("AND EFF_YRMON = SUBSTR(@[eff_dt], 1, 6)" ).append("\n"); 
		query.append("AND AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("AND OFC_CD = (" ).append("\n"); 
		query.append("select AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("from MDM_ORGANIZATION" ).append("\n"); 
		query.append("where ofc_cd = @[ofc]) ) B ON a.CLZ_STS_CD = b.CLZ_STS_CD )" ).append("\n"); 

	}
}