/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.04.03 조원주
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

public class JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file  RF Cargo  정보를 조회한다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL").append("\n"); 
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
		query.append("--TEMP_MAX		C	5	설정온도(상한)		냉동CNTR precooling인 경우는, '1'을 입력		BKG_CNTR.bcntr_wgt_tp	BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("--TEMP            		C	5	설정온도				REEFER_CGO.rf_temp_f	BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("--TEMP_MIN		C	5	설정온도(하한)					BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("--TEMP_UNIT 		C	3	온도단위코드				'F'	BKG_TML_EDI_JP_RF_CGO    CEL：섭씨 / FAH：화씨" ).append("\n"); 
		query.append("--HUMID           		C	2	습도				REEFER_CGO.rf_venti	BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("--VENT            		C	15	통풍구  				REEFER_CGO.rf_humid	BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CDO_TEMP     TEMP_MAX" ).append("\n"); 
		query.append(",CDO_TEMP           TEMP" ).append("\n"); 
		query.append(",CDO_TEMP           TEMP_MIN" ).append("\n"); 
		query.append(",'CEL'              TEMP_UNIT   " ).append("\n"); 
		query.append(",HUMID_NO           HUMID" ).append("\n"); 
		query.append(",NVL(VENT_RTO, 0)    VENT_RTO" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_RF_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD, CDO_TEMP" ).append("\n"); 
		query.append(",HUMID_NO" ).append("\n"); 
		query.append(",VENT_RTO" ).append("\n"); 

	}
}