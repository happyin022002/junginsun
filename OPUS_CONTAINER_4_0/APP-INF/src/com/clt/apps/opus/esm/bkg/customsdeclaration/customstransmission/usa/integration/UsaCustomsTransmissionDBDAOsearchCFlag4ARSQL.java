/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlag4ARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlag4ARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCFlag4A
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlag4ARSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlag4ARSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUM(DSPO_CD_1C) > 0 THEN 'N'" ).append("\n"); 
		query.append("            WHEN SUM(DSPO_CD_1A_QTY) > 0 AND SUM(DSPO_CD_1B_QTY) > 0 AND SUM(DSPO_CD_1A_QTY) = SUM(DSPO_CD_1B_QTY) THEN 'H'" ).append("\n"); 
		query.append("            WHEN SUM(DSPO_CD_1C) = 0 AND SUM(DSPO_CD_1B) = 0 THEN 'H'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END CFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(DSPO_CD, '1C', 1, 0) AS DSPO_CD_1C" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1B', 1, 0) AS DSPO_CD_1B" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1A', CNTR_QTY, 0) AS DSPO_CD_1A_QTY" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1B', CNTR_QTY, 0) AS DSPO_CD_1B_QTY" ).append("\n"); 
		query.append("         FROM BKG_CSTMS_ADV_RSLT " ).append("\n"); 
		query.append("        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("          AND BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("          AND NVL(RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          AND BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}