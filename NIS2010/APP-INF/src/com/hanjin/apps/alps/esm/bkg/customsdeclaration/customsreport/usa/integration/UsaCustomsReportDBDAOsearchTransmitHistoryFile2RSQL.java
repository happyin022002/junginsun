/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchTransmitHistoryFile2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchTransmitHistoryFile2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTransmitHistoryFile2
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchTransmitHistoryFile2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchTransmitHistoryFile2RSQL").append("\n"); 
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
		query.append("SELECT MSG_DESC AS LOG_CTNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_STWG_SND_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${trsm_msg_tp_id} == 'BAPLIE')" ).append("\n"); 
		query.append("AND   SND_PROC_ID = 'STW'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   SND_PROC_ID = 'ISF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   STWG_SND_ID = @[stwg_snd_id]" ).append("\n"); 
		query.append("AND   SND_DT = TO_DATE(@[snd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}