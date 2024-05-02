/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailInvoice에 대한 Detail 정보 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railInvAudCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL").append("\n"); 
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
		query.append("SELECT  TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("      , TRSP_INV_TP_CD" ).append("\n"); 
		query.append("      , TO_CHAR(RAIL_BIL_DT, 'YYYYMMDD') RAIL_BIL_DT" ).append("\n"); 
		query.append("      , TO_CHAR(WBL_DT, 'YYYYMMDD') WBL_DT" ).append("\n"); 
		query.append("      , WBL_NO" ).append("\n"); 
		query.append("      , INV_RMK" ).append("\n"); 
		query.append("      , SUB_INV_SEQ" ).append("\n"); 
		query.append("      , TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      , TRSP_SO_SEQ" ).append("\n"); 
		query.append("      , SUB_RAIL_SEQ" ).append("\n"); 
		query.append("      , ORG_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      , CRNT_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      , PAY_FLG" ).append("\n"); 
		query.append("      , EQ_NO" ).append("\n"); 
		query.append("      , EQ_TPSZ_CD" ).append("\n"); 
		query.append("      , CGO_TP_CD" ).append("\n"); 
		query.append("      , DMST_REPO_FLG" ).append("\n"); 
		query.append("      , SUBSTR(FM_NOD_CD, 0, 5) FM_NOD_CD1" ).append("\n"); 
		query.append("      , SUBSTR(FM_NOD_CD, 6, 7) FM_NOD_CD2" ).append("\n"); 
		query.append("      , SUBSTR(TO_NOD_CD, 0, 5) TO_NOD_CD1" ).append("\n"); 
		query.append("      , SUBSTR(TO_NOD_CD, 6, 7) TO_NOD_CD2" ).append("\n"); 
		query.append("      , FM_NOD_CD" ).append("\n"); 
		query.append("      , TO_NOD_CD" ).append("\n"); 
		query.append("      , INV_ORG_NOD_NM" ).append("\n"); 
		query.append("      , INV_DEST_NOD_NM" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("      , BZC_AMT" ).append("\n"); 
		query.append("      , FUEL_SCG_AMT" ).append("\n"); 
		query.append("      , OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("      , NEGO_AMT" ).append("\n"); 
		query.append("      , INV_CURR_CD" ).append("\n"); 
		query.append("      , INV_BZC_AMT" ).append("\n"); 
		query.append("      , INV_BIL_AMT" ).append("\n"); 
		query.append("      , INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("      , TMP_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      , HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("      , ETC_ADD_AMT" ).append("\n"); 
		query.append("FROM    TRS_TRSP_RAIL_INV_DTL" ).append("\n"); 
		query.append("WHERE   INV_NO = @[invNo]" ).append("\n"); 
		query.append("AND     INV_VNDR_SEQ = @[invVndrSeq]" ).append("\n"); 
		query.append("AND     CRNT_TRSP_RAIL_INV_AUD_CD = @[railInvAudCd]" ).append("\n"); 

	}
}