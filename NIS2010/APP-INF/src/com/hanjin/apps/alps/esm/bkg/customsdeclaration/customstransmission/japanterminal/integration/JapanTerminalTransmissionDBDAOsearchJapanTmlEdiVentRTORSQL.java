/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.04.10 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VentRTO 표준 코드를 가지고 온다
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vent_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanTmlEdiVentRTORSQL").append("\n"); 
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
		query.append("SELECT UPPER(replace(INTG_CD_VAL_DESC,'Ventilation ','')) VENT_CD" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD03004'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT=(CASE WHEN 0<=  @[vent_rto] AND @[vent_rto] < 10 THEN '0'" ).append("\n"); 
		query.append("                        WHEN 10 <= @[vent_rto] AND @[vent_rto] < 25 THEN '10'" ).append("\n"); 
		query.append("                         WHEN 25 <= @[vent_rto] AND @[vent_rto] < 30 THEN '25'" ).append("\n"); 
		query.append("                		 WHEN 30 <= @[vent_rto] AND @[vent_rto] < 50 THEN '30'" ).append("\n"); 
		query.append("                		 WHEN 50 <= @[vent_rto] AND @[vent_rto] < 70 THEN '50'" ).append("\n"); 
		query.append("               	         WHEN 70 <= @[vent_rto] AND @[vent_rto] < 75 THEN '70'" ).append("\n"); 
		query.append("                		 WHEN 75 <= @[vent_rto] AND @[vent_rto] < 100 THEN '75'" ).append("\n"); 
		query.append("                         WHEN @[vent_rto] >=100 THEN '100'" ).append("\n"); 
		query.append("                     END )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}