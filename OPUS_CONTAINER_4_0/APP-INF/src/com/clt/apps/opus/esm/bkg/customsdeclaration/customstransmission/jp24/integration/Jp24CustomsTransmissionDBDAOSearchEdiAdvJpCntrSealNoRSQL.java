/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCntrSealNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCntrSealNoRSQL").append("\n"); 
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
		query.append("    SELECT UPPER(BCS.CNTR_SEAL_NO) AS SEAL_NO," ).append("\n"); 
		query.append("           RANK() OVER (PARTITION BY BCS.BKG_NO, BCS.CNTR_NO ORDER BY BCS.CNTR_SEAL_SEQ ASC) AS RNK_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM BKG_CNTR_SEAL_NO BCS," ).append("\n"); 
		query.append("           BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BCS.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("       AND BCS.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 1), 'UNKNOWN'), 15, ' ') AS DATA01," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 2), ' '), 15, ' ') AS DATA02," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 3), ' '), 15, ' ') AS DATA03," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 4), ' '), 15, ' ') AS DATA04," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 5), ' '), 15, ' ') AS DATA05," ).append("\n"); 
		query.append("       RPAD(NVL((SELECT SEAL_NO" ).append("\n"); 
		query.append("                   FROM SEAL_INFO" ).append("\n"); 
		query.append("                  WHERE RNK_SEQ = 6), ' '), 15, ' ') AS DATA06" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}