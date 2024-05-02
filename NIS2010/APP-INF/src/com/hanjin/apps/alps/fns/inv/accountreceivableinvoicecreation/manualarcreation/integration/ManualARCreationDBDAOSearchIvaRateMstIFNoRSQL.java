/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.29 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL").append("\n"); 
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
		query.append("SELECT ROUND(IVA_AMT / CHG_AMT * 100,2) IVA_RATE " ).append("\n"); 
		query.append("  FROM (SELECT SUM(CHG_AMT) CHG_AMT " ).append("\n"); 
		query.append("          FROM INV_AR_CHG A," ).append("\n"); 
		query.append("               INV_AR_MN  B" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.AR_IF_NO = @[mst_if_no]" ).append("\n"); 
		query.append("           AND B.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND B.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND B.REV_SRC_CD = 'IV'" ).append("\n"); 
		query.append("           AND NVL(B.INV_DELT_DIV_CD ,'N') <>'Y'" ).append("\n"); 
		query.append("           AND B.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("           AND A.TVA_FLG = 'Y') A," ).append("\n"); 
		query.append("       (SELECT SUM(CHG_AMT) IVA_AMT " ).append("\n"); 
		query.append("          FROM INV_AR_CHG A," ).append("\n"); 
		query.append("               INV_AR_MN  B" ).append("\n"); 
		query.append("         WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("           AND B.AR_IF_NO = @[mst_if_no]" ).append("\n"); 
		query.append("           AND B.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND B.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND B.REV_SRC_CD = 'IV'" ).append("\n"); 
		query.append("           AND NVL(B.INV_DELT_DIV_CD ,'N') <>'Y'" ).append("\n"); 
		query.append("           AND B.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("           AND A.CHG_CD = 'IVA') B           " ).append("\n"); 

	}
}