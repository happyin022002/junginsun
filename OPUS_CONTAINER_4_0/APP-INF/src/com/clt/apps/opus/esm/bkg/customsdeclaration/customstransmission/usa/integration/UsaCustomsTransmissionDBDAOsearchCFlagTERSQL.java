/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlagTERSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlagTERSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C-Flag : T , E
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlagTERSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_et_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("icr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlagTERSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN BL.PCK_QTY = TO_NUMBER(@[icr_qty]) OR BL.PCK_QTY = TO_NUMBER(@[icr_qty]) THEN" ).append("\n"); 
		query.append("         CASE WHEN IBD.IBD_TRSP_TP_CD = '62' AND BL.USA_LST_LOC_CD = @[cus_loc]" ).append("\n"); 
		query.append("                   AND SUBSTR(IBD.IBD_TRSP_NO, 1,3) = BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)" ).append("\n"); 
		query.append("                   AND SUBSTR(RS.ENTR_NO, 1,3) = BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)" ).append("\n"); 
		query.append("                   AND SUBSTR(@[icr_et_no], 1,3) = BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)" ).append("\n"); 
		query.append("                   THEN 'T'" ).append("\n"); 
		query.append("              WHEN IBD.IBD_TRSP_TP_CD = '63' AND BL.CSTMS_POD_CD = @[cus_loc]" ).append("\n"); 
		query.append("                   AND SUBSTR(IBD.IBD_TRSP_NO, 1,3) = BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)" ).append("\n"); 
		query.append("                   AND RS.CNT_CD IS NULL " ).append("\n"); 
		query.append("                   AND SUBSTR(@[icr_et_no], 1,3) = BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)" ).append("\n"); 
		query.append("                   THEN 'E'" ).append("\n"); 
		query.append("               ELSE 'N'" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END C_FLAG" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("      ,(SELECT /*+INDEX_DESC(R XPKBKG_CSTMS_ADV_RSLT)*/" ).append("\n"); 
		query.append("               CNT_CD" ).append("\n"); 
		query.append("              ,BL_NO" ).append("\n"); 
		query.append("              ,ENTR_TP_NO" ).append("\n"); 
		query.append("              ,ENTR_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT R" ).append("\n"); 
		query.append("         WHERE R.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND R.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND R.DSPO_CD IN ('12','13')" ).append("\n"); 
		query.append("           AND NVL(RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 --EXP만(ARRIVAL 제외)" ).append("\n"); 
		query.append("       ) RS" ).append("\n"); 
		query.append(" WHERE IBD.CNT_CD = BL.CNT_CD" ).append("\n"); 
		query.append("   AND IBD.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("   AND IBD.CNT_CD = RS.CNT_CD(+)" ).append("\n"); 
		query.append("   AND IBD.BL_NO = RS.BL_NO(+)" ).append("\n"); 
		query.append("   AND IBD.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND IBD.BL_NO = @[bl_no]" ).append("\n"); 

	}
}