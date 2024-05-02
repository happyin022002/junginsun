/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtDBDAOsearchWarrantyAlertListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WarrantyMgtDBDAOsearchWarrantyAlertListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer Unit Warranty Period 의 조회 쿼리
	  * </pre>
	  */
	public WarrantyMgtDBDAOsearchWarrantyAlertListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.integration").append("\n"); 
		query.append("FileName : WarrantyMgtDBDAOsearchWarrantyAlertListDataRSQL").append("\n"); 
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
		query.append("SELECT A.LOT_EQ_PFX_CD," ).append("\n"); 
		query.append("SUBSTRB(A.FM_SER_NO,1,LENGTH(A.FM_SER_NO) -1) AS FM_SER_NO," ).append("\n"); 
		query.append("'-' AS SER_FREFIX," ).append("\n"); 
		query.append("SUBSTRB(A.TO_SER_NO,1,LENGTH(A.TO_SER_NO) -1) AS TO_SER_NO," ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.EQ_MKR_NM," ).append("\n"); 
		query.append("A.EQ_MDL_NM," ).append("\n"); 
		query.append("A.MNR_DISP_SEL_FLG," ).append("\n"); 
		query.append("TO_CHAR(A.FM_WARR_DT,'YYYY-MM-DD') AS FM_WARR_DT," ).append("\n"); 
		query.append("TO_CHAR(A.TO_WARR_DT,'YYYY-MM-DD') AS TO_WARR_DT," ).append("\n"); 
		query.append("A.WARR_RMK," ).append("\n"); 
		query.append("A.MFT_YR," ).append("\n"); 
		query.append("(A.FM_SER_NO - A.TO_SER_NO) AS EQ_QTY," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM MNR_EQ_RNG_STS A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("#if (${fm_lot_pln_yr} != '' && ${to_lot_pln_yr} != '')" ).append("\n"); 
		query.append("AND A.MFT_YR >= @[fm_lot_pln_yr] AND A.MFT_YR <= @[to_lot_pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}