/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCntr
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchCntrSealNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchCntrSealNoRSQL").append("\n"); 
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
		query.append("WITH SEAL_INFO AS (" ).append("\n"); 
		query.append("    SELECT UPPER(CSN.CNTR_SEAL_NO) AS SEAL_NO," ).append("\n"); 
		query.append("           RANK() OVER (PARTITION BY CSN.BKG_NO, CSN.CNTR_NO ORDER BY CSN.CNTR_SEAL_SEQ ASC) AS RNK_SEQ" ).append("\n"); 
		query.append("      FROM BKG_CNTR_SEAL_NO CSN," ).append("\n"); 
		query.append("           BKG_BOOKING BKG" ).append("\n"); 
		query.append("     WHERE CSN.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND CSN.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 1), 'UNKNOWN'), 15, ' ') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 2), ' '), 15, ' ') AS DATA2," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 3), ' '), 15, ' ') AS DATA3," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 4), ' '), 15, ' ') AS DATA4," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 5), ' '), 15, ' ') AS DATA5," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 6), ' '), 15, ' ') AS DATA6" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}