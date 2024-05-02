/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchRHQGoodCntrMaxInterfaceKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.02.26 정휘택
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

public class ManualARCreationDBDAOsearchRHQGoodCntrMaxInterfaceKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRHQGoodCntrMaxInterfaceKor
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchRHQGoodCntrMaxInterfaceKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchRHQGoodCntrMaxInterfaceKorRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM INV_AR_CNTR" ).append("\n"); 
		query.append("WHERE AR_IF_NO = ( SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND B.LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}