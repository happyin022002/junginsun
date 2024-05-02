/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchApPayInvMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchApPayInvMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV csr insert
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchApPayInvMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchApPayInvMainRSQL").append("\n"); 
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
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("	    A.RGST_NO AS INV_RGST_NO" ).append("\n"); 
		query.append("	    ,'TRS' AS INV_SUB_SYS_CD" ).append("\n"); 
		query.append("	    ,A.CRE_OFC_CD AS INV_OFC_CD" ).append("\n"); 
		query.append("	    ,C.CRE_OFC_CD AS COST_OFC_CD " ).append("\n"); 
		query.append("	    ,A.INV_VNDR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append("	    ,A.INV_NO" ).append("\n"); 
		query.append("	    ,TO_CHAR(A.INV_ISS_DT,'YYYYMMDD') AS INV_ISS_DT" ).append("\n"); 
		query.append("	    ,TO_CHAR(A.INV_RCV_DT,'YYYYMMDD') AS INV_RCV_DT" ).append("\n"); 
		query.append("	    ,(SELECT GEN_PAY_TERM_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.INV_VNDR_SEQ) VNDR_TERM_NM" ).append("\n"); 
		query.append("	    ,A.INV_CURR_CD" ).append("\n"); 
		query.append("	    ,A.INV_TTL_AMT" ).append("\n"); 
		query.append("	    ,A.INV_VAT_AMT" ).append("\n"); 
		query.append("	    ,(A.INV_TTL_AMT - A.INV_VAT_AMT) INV_NET_AMT" ).append("\n"); 
		query.append("	    ,0 WHLD_TAX_AMT" ).append("\n"); 
		query.append("	    ,'' EQ_TP_CD -- TRS는 여러가지 EQ TYPE이 하나의 Invoice로 처리 될 수 있으므로 입력 불가능" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	    TRS_TRSP_RAIL_INV_WRK A," ).append("\n"); 
		query.append("	    TRS_TRSP_RAIL_INV_DTL B," ).append("\n"); 
		query.append("	    TRS_TRSP_RAIL_BIL_ORD C," ).append("\n"); 
		query.append("	    TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("	WHERE A.CRE_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	AND   A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("	AND   A.TRSP_INV_AUD_STS_CD = 'CF'" ).append("\n"); 
		query.append("	AND   NVL(A.INV_HLD_FLG , ' ') <> 'T'" ).append("\n"); 
		query.append("	AND   NVL(A.DELT_FLG , 'N') = 'N'" ).append("\n"); 
		query.append("	AND   NVL(C.DELT_FLG , 'N') = 'N'" ).append("\n"); 
		query.append("	AND   A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("	AND   A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("	AND   B.INV_NO = D.INV_NO(+)" ).append("\n"); 
		query.append("	AND   B.INV_VNDR_SEQ = D.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND   B.TRSP_SO_SEQ = D.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.TRSP_SO_SEQ = D.SUB_RAIL_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND   B.TRSP_SO_SEQ = C.TRSP_SO_SEQ(+)" ).append("\n"); 

	}
}