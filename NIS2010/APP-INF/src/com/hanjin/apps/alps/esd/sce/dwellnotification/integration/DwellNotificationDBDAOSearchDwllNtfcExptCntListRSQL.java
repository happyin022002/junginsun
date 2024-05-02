/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllNtfcExptCntListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.11.23 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllNtfcExptCntListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Set up for Exception by Container
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllNtfcExptCntListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwell_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllNtfcExptCntListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_DWLL_EXPT_FLG" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNMV_YR" ).append("\n"); 
		query.append(", CNMV_ID_NO" ).append("\n"); 
		query.append(", CNMV_CYC_NO" ).append("\n"); 
		query.append(", MST_BKG_NO" ).append("\n"); 
		query.append(", CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(", CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(", CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(", CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(", EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(", EXPT_SET_USR_ID" ).append("\n"); 
		query.append(", EXPT_SET_DT" ).append("\n"); 
		query.append(", DWLL_EXPT_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM SCE_DWLL_CNTR_EXPT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_no1} != '')" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dwell_type} != '')" ).append("\n"); 
		query.append("AND DECODE(@[dwell_type], 'T96', CNTR_TML_DWLL_FLG, 'E48', CNTR_ENR_DWLL_FLG, 'D72', CNTR_DEST_DWLL_FLG, 'V24', CNTR_VSL_DLAY_FLG) = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}