/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorage3rdIFlistByPoolManual
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL").append("\n"); 
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
		query.append("SELECT  ROWNUM TMP_TPB_SEQ," ).append("\n"); 
		query.append("			C.CNTR_NO," ).append("\n"); 
		query.append("			C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	        T.TML_IF_OFC_CD,  	        " ).append("\n"); 
		query.append("            T.TML_IF_SEQ," ).append("\n"); 
		query.append("  			@[tml_so_dtl_seq] TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("	        @[param_lgs_cost_cd] LGS_COST_CD," ).append("\n"); 
		query.append("	        DECODE(T.CNTR_NO,'','0','1') CHK," ).append("\n"); 
		query.append("	        H.TML_INV_TP_CD," ).append("\n"); 
		query.append("	        H.INV_NO," ).append("\n"); 
		query.append("	        H.VNDR_SEQ," ).append("\n"); 
		query.append("	        H.YD_CD," ).append("\n"); 
		query.append("	        H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("	        H.TML_SO_SEQ," ).append("\n"); 
		query.append("	        C.BKG_NO," ).append("\n"); 
		query.append("	        C.BL_NO," ).append("\n"); 
		query.append("	        C.IO_BND_CD," ).append("\n"); 
		query.append("	        H.CURR_CD," ).append("\n"); 
		query.append("	        H.ERR_INV_NO," ).append("\n"); 
		query.append("	        T.IF_AMT," ).append("\n"); 
		query.append("	        T.IF_RMK," ).append("\n"); 
		query.append("	        T.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("	        T.VNDR_CNT_CD," ).append("\n"); 
		query.append("	        T.N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("	        T.CUST_CNT_CD," ).append("\n"); 
		query.append("	        T.CUST_SEQ," ).append("\n"); 
		query.append("	        T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("            T.TML_N3PTY_TP_CD," ).append("\n"); 
		query.append("            T.TML_N3PTY_IF_STS_CD," ).append("\n"); 
		query.append("            T.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("	        CASE" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'C' THEN ''||T.CUST_SEQ" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("	        WHEN T.VNDR_CUST_DIV_CD = 'V' THEN ''||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("	        END TRD_PARTY_VAL" ).append("\n"); 
		query.append("	FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST C, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("	AND H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND H.TML_SO_SEQ        = C.TML_SO_SEQ" ).append("\n"); 
		query.append("	AND C.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND C.TML_SO_SEQ        = T.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("    AND T.LGS_COST_CD(+) = @[param_lgs_cost_cd]  " ).append("\n"); 
		query.append("	AND C.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("	AND C.CNTR_NO = T.CNTR_NO(+)" ).append("\n"); 
		query.append("	AND NVL(T.CXL_FLG,'N') = 'N'" ).append("\n"); 

	}
}