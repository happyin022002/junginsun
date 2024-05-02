/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceTotalAmount
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountRSQL").append("\n"); 
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
		query.append("SELECT V.TML_SO_VVD_LIST_SEQ," ).append("\n"); 
		query.append("       D.VSL_CD," ).append("\n"); 
		query.append("       D.SKD_VOY_NO," ).append("\n"); 
		query.append("       D.SKD_DIR_CD," ).append("\n"); 
		query.append("       D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       D.IO_BND_CD," ).append("\n"); 
		query.append("       SUM(D.INV_AMT) INV_AMT," ).append("\n"); 
		query.append("       NVL(SUM(D.IDA_CGST_AMT),0) IDA_CGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(D.IDA_SGST_AMT),0) IDA_SGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(D.IDA_IGST_AMT),0) IDA_IGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(D.IDA_UGST_AMT),0) IDA_UGST_AMT" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_VVD_LIST V" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND   H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND   H.TML_SO_OFC_CTY_CD = V.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   H.TML_SO_SEQ = V.TML_SO_SEQ" ).append("\n"); 
		query.append("AND   D.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND   D.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   D.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   D.IO_BND_CD = V.IO_BND_CD" ).append("\n"); 
		query.append("GROUP BY  V.TML_SO_VVD_LIST_SEQ," ).append("\n"); 
		query.append("       D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.IO_BND_CD" ).append("\n"); 
		query.append("ORDER BY V.TML_SO_VVD_LIST_SEQ" ).append("\n"); 

	}
}