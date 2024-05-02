/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountForPopupRSQL.java
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

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountForPopupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceTotalAmountForPopup
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountForPopupRSQL(){
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
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountForPopupRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD,									" ).append("\n"); 
		query.append("       IO_BND_CD,															" ).append("\n"); 
		query.append(" 		VSL_CD||SKD_VOY_NO||SKD_DIR_CD||IO_BND_CD SUM_BASIS,				" ).append("\n"); 
		query.append("       LGS_COST_CD,														" ).append("\n"); 
		query.append("       SUM(INV_AMT) INV_AMT," ).append("\n"); 
		query.append("       NVL(SUM(IDA_CGST_AMT),0) IDA_CGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(IDA_SGST_AMT),0) IDA_SGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(IDA_IGST_AMT),0) IDA_IGST_AMT," ).append("\n"); 
		query.append("       NVL(SUM(IDA_UGST_AMT),0) IDA_UGST_AMT										" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL														" ).append("\n"); 
		query.append("WHERE TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]												" ).append("\n"); 
		query.append("AND TML_SO_SEQ = @[tml_so_seq]															" ).append("\n"); 
		query.append("GROUP BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD, IO_BND_CD,						" ).append("\n"); 
		query.append("		VSL_CD||SKD_VOY_NO||SKD_DIR_CD||IO_BND_CD, LGS_COST_CD				" ).append("\n"); 
		query.append("ORDER BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD, IO_BND_CD	,LGS_COST_CD" ).append("\n"); 

	}
}