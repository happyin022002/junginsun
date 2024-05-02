/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOldCstmsClrCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.23 
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

public class UsaCustomsTransmissionDBDAOsearchOldCstmsClrCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOldCstmsClrCd
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOldCstmsClrCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOldCstmsClrCdRSQL").append("\n"); 
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
		query.append("SELECT NVL(C.CSTMS_CLR_CD,'N') AS LCL_CUSTC_IND_A" ).append("\n"); 
		query.append("      ,I.CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("      ,(SELECT OB_NTC_FLG" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_DSPO" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND CSTMS_DSPO_CD = @[icr_code]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS OB_NTC_FLG" ).append("\n"); 
		query.append("      ,'' AS Lcl_Bl_Nbr_A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT CSTMS_CLR_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(R XPKBKG_CSTMS_ADV_RSLT) */" ).append("\n"); 
		query.append("                       CSTMS_CLR_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RSLT R" ).append("\n"); 
		query.append("                 WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND CSTMS_CLR_CD <> 'N'" ).append("\n"); 
		query.append("                   AND NVL(RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS OLD_CSTMS_CLR_CD_JCD" ).append("\n"); 
		query.append("      ,'' AS Lcl_Bl_Nbr_A  " ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE C" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append(" WHERE I.CNT_CD = 'US' " ).append("\n"); 
		query.append("   AND I.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND I.BL_NO = C.BL_NO(+)" ).append("\n"); 

	}
}