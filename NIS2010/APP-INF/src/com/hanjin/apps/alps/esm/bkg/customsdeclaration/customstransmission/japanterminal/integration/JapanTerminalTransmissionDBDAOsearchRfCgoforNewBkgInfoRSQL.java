/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRfCgoforNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgInfoRSQL(){
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
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchRfCgoforNewBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT RC.BKG_NO ," ).append("\n"); 
		query.append("  @[bkg_skd_seq] BKG_SKD_SEQ ," ).append("\n"); 
		query.append("  RC.RC_SEQ ," ).append("\n"); 
		query.append("  RC.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("  RC.CNTR_VOL_QTY ," ).append("\n"); 
		query.append("  RC.CNTR_NO ," ).append("\n"); 
		query.append("  RC.CLNG_TP_CD ," ).append("\n"); 
		query.append("  RC.FDO_TEMP ," ).append("\n"); 
		query.append("  RC.CDO_TEMP ," ).append("\n"); 
		query.append("  RC.CNTR_VENT_TP_CD ," ).append("\n"); 
		query.append("  RC.VENT_RTO ," ).append("\n"); 
		query.append("  RC.HUMID_NO ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("    WHERE COM.INTG_CD_ID = 'CD03004'" ).append("\n"); 
		query.append("      AND COM.INTG_CD_VAL_CTNT=RC.VENT_RTO) SNACCS_TML_EDI_VENT_RTO_CD" ).append("\n"); 
		query.append("FROM BKG_RF_CGO RC" ).append("\n"); 
		query.append("WHERE RC.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 

	}
}