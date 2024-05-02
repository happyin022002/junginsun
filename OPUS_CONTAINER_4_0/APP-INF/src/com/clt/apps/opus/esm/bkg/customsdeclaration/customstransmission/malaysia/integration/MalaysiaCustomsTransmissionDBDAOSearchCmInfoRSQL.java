/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL").append("\n"); 
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
		query.append("SELECT MD.CNTR_MF_SEQ AS CM_SEQ," ).append("\n"); 
		query.append("       MD.PCK_QTY AS CM_PKG," ).append("\n"); 
		query.append("       NVL(CNV.CSTMS_PCK_TP_CD, MD.PCK_TP_CD) AS CM_PKG_UNIT," ).append("\n"); 
		query.append("       MD.CNTR_MF_WGT AS CM_WGT," ).append("\n"); 
		query.append("       MD.WGT_UT_CD AS CM_WGT_UNIT," ).append("\n"); 
		query.append("       MD.MEAS_QTY AS CM_MEA," ).append("\n"); 
		query.append("       MD.MEAS_UT_CD AS CM_MEA_UNIT," ).append("\n"); 
		query.append("       MD.CMDT_HS_CD AS HS_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC MD," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE MD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND MD.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND MD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'MY'" ).append("\n"); 

	}
}