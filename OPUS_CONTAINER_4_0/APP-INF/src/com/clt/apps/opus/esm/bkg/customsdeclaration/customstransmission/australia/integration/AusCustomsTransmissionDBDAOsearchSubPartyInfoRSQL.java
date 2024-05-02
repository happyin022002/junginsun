/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchSubPartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchSubPartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchSubPartyInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchSubPartyInfoRSQL").append("\n"); 
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
		query.append("SELECT 'FU' AS SUB_PARTY_TYPE," ).append("\n"); 
		query.append("       '' AS SUB_PARTY_ID," ).append("\n"); 
		query.append("       '' AS SUB_AUTHORIZED," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS1," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS2," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS3," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS4," ).append("\n"); 
		query.append("       '' AS SUB_ADDRESS5," ).append("\n"); 
		query.append("       EMER_CNTC_PSON_NM AS SUB_CONTACT," ).append("\n"); 
		query.append("       EMER_CNTC_PHN_NO_CTNT AS SUB_PHONE," ).append("\n"); 
		query.append("       '' AS SUB_FAX," ).append("\n"); 
		query.append("       '' AS SUB_REF" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO CGO" ).append("\n"); 
		query.append(" WHERE CGO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CGO.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'CN' AS SUB_PARTY_TYPE," ).append("\n"); 
		query.append("       '' AS SUB_PARTY_ID," ).append("\n"); 
		query.append("       '' AS SUB_AUTHORIZED," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(CN.CUST_NM), 1, ''), 'X') AS SUB_ADDRESS1," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(CN.CUST_NM), 2, ''), 'X') AS SUB_ADDRESS2," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(CN.CUST_ADDR), 1, ''), 'X') AS SUB_ADDRESS3," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(CN.CUST_ADDR), 2, ''), 'X') AS SUB_ADDRESS4," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(CN.CUST_ADDR), 3, ''), 'X') AS SUB_ADDRESS5," ).append("\n"); 
		query.append("       '' AS SUB_CONTACT," ).append("\n"); 
		query.append("       '' AS SUB_PHONE," ).append("\n"); 
		query.append("       '' AS SUB_FAX," ).append("\n"); 
		query.append("       '' AS SUB_REF" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER CN" ).append("\n"); 
		query.append(" WHERE CN.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'CZ' AS SUB_PARTY_TYPE," ).append("\n"); 
		query.append("       '' AS SUB_PARTY_ID," ).append("\n"); 
		query.append("       '' AS SUB_AUTHORIZED," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(SH.CUST_NM), 1, ''), 'X') AS SUB_ADDRESS1," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(SH.CUST_NM), 2, ''), 'X') AS SUB_ADDRESS2," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(SH.CUST_ADDR), 1, ''), 'X') AS SUB_ADDRESS3," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(SH.CUST_ADDR), 2, ''), 'X') AS SUB_ADDRESS4," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(SH.CUST_ADDR), 3, ''), 'X') AS SUB_ADDRESS5," ).append("\n"); 
		query.append("       '' AS SUB_CONTACT," ).append("\n"); 
		query.append("       '' AS SUB_PHONE," ).append("\n"); 
		query.append("       '' AS SUB_FAX," ).append("\n"); 
		query.append("       '' AS SUB_REF" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER SH" ).append("\n"); 
		query.append(" WHERE SH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 

	}
}