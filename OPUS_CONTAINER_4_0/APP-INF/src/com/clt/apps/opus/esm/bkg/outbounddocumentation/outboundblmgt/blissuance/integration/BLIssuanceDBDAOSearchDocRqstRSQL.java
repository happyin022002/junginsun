/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchDocRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchDocRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDocRqst
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchDocRqstRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchDocRqstRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG.BKG_NO" ).append("\n"); 
		query.append(",RQST_BL_TP_CD" ).append("\n"); 
		query.append(",NVL(OBL_RT_INCL_KNT, 0) OBL_RT_INCL_KNT" ).append("\n"); 
		query.append(",NVL(OBL_RT_XCLD_KNT, 0) OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append(",NVL(OBL_PPD_KNT, 0) OBL_PPD_KNT" ).append("\n"); 
		query.append(",NVL(OBL_CLT_KNT, 0) OBL_CLT_KNT" ).append("\n"); 
		query.append(",NVL(OBL_TTL_KNT, 0) OBL_TTL_KNT" ).append("\n"); 
		query.append(",NVL(NON_NEGO_RT_INCL_KNT, 0) NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append(",NVL(NON_NEGO_RT_XCLD_KNT, 0) NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append(",NVL(NON_NEGO_PPD_KNT, 0) NON_NEGO_PPD_KNT" ).append("\n"); 
		query.append(",NVL(NON_NEGO_CLT_KNT, 0) NON_NEGO_CLT_KNT" ).append("\n"); 
		query.append(",NVL(CPY_TTL_KNT, 0) CPY_TTL_KNT" ).append("\n"); 
		query.append(",RQST_ISS_PLC_NM" ).append("\n"); 
		query.append(",TO_CHAR(RQST_ISS_DT, 'YYYY-MM-DD') RQST_ISS_DT" ).append("\n"); 
		query.append(",BL_DE_TO_CD" ).append("\n"); 
		query.append(",BL_DE_MZD_CD" ).append("\n"); 
		query.append(",BL_DOC_RQST_RMK" ).append("\n"); 
		query.append(",(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = NVL(@[ofc_cd], ' ') ) LOC_NM" ).append("\n"); 
		query.append(", NVL((SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("       FROM BKG_REFERENCE" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("       AND BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("       AND BKG_REF_TP_CD ='EBFF'" ).append("\n"); 
		query.append("       AND ROWNUM =1 )" ).append("\n"); 
		query.append("      , '1234567890123456') AS FFREFNO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BL_ISS ISS, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append(" BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 

	}
}