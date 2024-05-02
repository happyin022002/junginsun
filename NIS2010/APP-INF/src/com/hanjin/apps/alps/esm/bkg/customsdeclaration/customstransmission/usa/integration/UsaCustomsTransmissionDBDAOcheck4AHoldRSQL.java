/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOcheck4AHoldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOcheck4AHoldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check4AHold
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOcheck4AHoldRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOcheck4AHoldRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUM(DSPO_CD_1A_QTY) > 0 AND SUM(DSPO_CD_1A_QTY) = SUM(DSPO_CD_1B_QTY) " ).append("\n"); 
		query.append("                 AND MAX(DSPO_CD_4A_QTY) > 0 AND MAX(DSPO_CD_4A_QTY) <> MAX(DSPO_CD_1B4C_QTY) THEN 'H'" ).append("\n"); 
		query.append("            WHEN NVL(SUM(DSPO_CD_1C),0) = 0 AND NVL(SUM(DSPO_CD_1B),0) = 0 " ).append("\n"); 
		query.append("                 AND MAX(DSPO_CD_4A_QTY) > 0 AND MAX(DSPO_CD_4A_QTY) <> MAX(DSPO_CD_1B4C_QTY) THEN 'H'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END CFLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(DSPO_CD, '1A', CNTR_QTY, 0) AS DSPO_CD_1A_QTY" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1B', CNTR_QTY, 0) AS DSPO_CD_1B_QTY" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1C', 1, 0) AS DSPO_CD_1C" ).append("\n"); 
		query.append("              ,DECODE(DSPO_CD, '1B', 1, 0) AS DSPO_CD_1B" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("           AND CSTMS_SEQ < @[cstms_seq]" ).append("\n"); 
		query.append("           AND NVL(RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 0,0,0,0 FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT NVL(SUM(DECODE(DSPO_CD, '4A', CNTR_QTY, 0)),0) AS DSPO_CD_4A_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(DSPO_CD, '1B', CNTR_QTY, DECODE(DSPO_CD, '4C', CNTR_QTY, 0))),0) AS DSPO_CD_1B4C_QTY" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("           AND CSTMS_SEQ >= @[cstms_seq]" ).append("\n"); 
		query.append("           AND NVL(RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}