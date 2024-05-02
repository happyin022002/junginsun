/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DwellNotificationDBDAOAddDwllNtfcExptHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOAddDwllNtfcExptHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email  sending Exception History을 저장을 한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOAddDwllNtfcExptHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOAddDwllNtfcExptHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_DWLL_CUST_EXPT_HIS" ).append("\n"); 
		query.append("(SC_NO," ).append("\n"); 
		query.append("DWLL_CUST_CNT_CD," ).append("\n"); 
		query.append("DWLL_CUST_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("FM_EFF_DT," ).append("\n"); 
		query.append("TO_EFF_DT," ).append("\n"); 
		query.append("TML_DWLL_FLG," ).append("\n"); 
		query.append("ENR_DWLL_FLG," ).append("\n"); 
		query.append("DEST_DWLL_FLG," ).append("\n"); 
		query.append("VSL_DLAY_FLG," ).append("\n"); 
		query.append("DWLL_EXPT_RMK," ).append("\n"); 
		query.append("EXPT_SET_USR_ID," ).append("\n"); 
		query.append("EXPT_SET_DT," ).append("\n"); 
		query.append("HIS_CRE_DT," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("BKG_TML_DWLL_FLG," ).append("\n"); 
		query.append("BKG_ENR_DWLL_FLG," ).append("\n"); 
		query.append("BKG_DEST_DWLL_FLG," ).append("\n"); 
		query.append("BKG_VSL_DLAY_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SC_NO," ).append("\n"); 
		query.append("DWLL_CUST_CNT_CD," ).append("\n"); 
		query.append("DWLL_CUST_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("FM_EFF_DT," ).append("\n"); 
		query.append("TO_EFF_DT," ).append("\n"); 
		query.append("TML_DWLL_FLG," ).append("\n"); 
		query.append("ENR_DWLL_FLG," ).append("\n"); 
		query.append("DEST_DWLL_FLG," ).append("\n"); 
		query.append("VSL_DLAY_FLG," ).append("\n"); 
		query.append("DWLL_EXPT_RMK," ).append("\n"); 
		query.append("EXPT_SET_USR_ID," ).append("\n"); 
		query.append("EXPT_SET_DT," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("BKG_TML_DWLL_FLG," ).append("\n"); 
		query.append("BKG_ENR_DWLL_FLG," ).append("\n"); 
		query.append("BKG_DEST_DWLL_FLG," ).append("\n"); 
		query.append("BKG_VSL_DLAY_FLG" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_CUST_EXPT" ).append("\n"); 
		query.append("WHERE DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND   DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 

	}
}