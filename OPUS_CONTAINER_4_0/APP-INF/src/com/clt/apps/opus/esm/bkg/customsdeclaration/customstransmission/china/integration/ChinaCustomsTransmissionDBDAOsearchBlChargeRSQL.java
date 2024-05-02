/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchBlChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchBlChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchBlChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchBlChargeRSQL").append("\n"); 
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
		query.append("SELECT NVL(BCR.CHG_CD, ' ') AS FCCODE," ).append("\n"); 
		query.append("       NVL(BCR.RAT_AS_QTY, 0) AS QTY," ).append("\n"); 
		query.append("       NVL(BCR.CURR_CD, ' ') AS CURR_CD," ).append("\n"); 
		query.append("       NVL(BCR.CHG_UT_AMT, 0) AS RATE," ).append("\n"); 
		query.append("       NVL(BCR.CHG_AMT, 0) AS AMOUNT," ).append("\n"); 
		query.append("       NVL(BCR.FRT_TERM_CD, ' ') AS PRFLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CHG_RT BCR," ).append("\n"); 
		query.append("       BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BCR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BCR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 

	}
}