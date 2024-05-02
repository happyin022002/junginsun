/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCntrMfLineOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
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

public class UsaCustomsTransmissionDBDAOsearchCntrMfLineOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchCntrMfLineOBRSQL
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCntrMfLineOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCntrMfLineOBRSQL").append("\n"); 
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
		query.append("SELECT NVL(CMDT_GDS_SEQ,'00') cmd_seq, NVL(HAMO_CMDT_CD,' ') icm_ht_cd," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(GRS_WGT*20,'09999999'),2) icm_wgt_val," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(GRS_WGT,'0999999999'),2) icm_wgt_qty," ).append("\n"); 
		query.append("		NVL(SUBSTR(WGT_UT_CD, 1, 2),'KG') icm_wgt_tp," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(PCK_QTY,'0999999999'),2) icm_pkg_qty," ).append("\n"); 
		query.append("        DECODE(NVL(CGO_DESC,' '),' ',SUBSTR(BKG_SPCLCHAR_CONV_FNC(Translate(NVL(@[cmdt_desc],' '),CHR(13)||CHR(10),' '),'X'),1,45)" ).append("\n"); 
		query.append("       ,SUBSTR(BKG_SPCLCHAR_CONV_FNC(Translate(NVL(CGO_DESC,' '),CHR(13)||CHR(10),' '),'X'),1,45)) icm_desc" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT B.BKG_NO, " ).append("\n"); 
		query.append("           M.CNTR_NO,    " ).append("\n"); 
		query.append("           M.CNTR_MF_SEQ AS CMDT_GDS_SEQ," ).append("\n"); 
		query.append("           UPPER(decode(M.CNTR_MF_GDS_DESC,null,C.CMDT_NM,M.CNTR_MF_GDS_DESC)) AS CGO_DESC," ).append("\n"); 
		query.append("           M.PCK_QTY,  " ).append("\n"); 
		query.append("           M.CNTR_MF_WGT AS GRS_WGT," ).append("\n"); 
		query.append("           NVL(M.WGT_UT_CD,'KGS') AS WGT_UT_CD," ).append("\n"); 
		query.append("           SUBSTR(TRIM(M.HAMO_TRF_CD),1,10) AS HAMO_CMDT_CD" ).append("\n"); 
		query.append("    FROM    BKG_BOOKING B, " ).append("\n"); 
		query.append("            BKG_CONTAINER T," ).append("\n"); 
		query.append("            BKG_CNTR_MF_DESC M, " ).append("\n"); 
		query.append("            MDM_COMMODITY C" ).append("\n"); 
		query.append("    WHERE   B.BKG_NO  = T.BKG_NO" ).append("\n"); 
		query.append("    AND     T.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("    AND     T.BKG_NO  = M.BKG_NO" ).append("\n"); 
		query.append("    AND     B.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("    AND     B.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND     T.CNTR_NO = TRIM(@[cntr_no])" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}