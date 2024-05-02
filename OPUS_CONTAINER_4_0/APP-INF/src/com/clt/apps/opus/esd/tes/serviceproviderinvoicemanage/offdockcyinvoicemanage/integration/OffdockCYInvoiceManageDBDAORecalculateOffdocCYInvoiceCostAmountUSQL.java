/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAORecalculateOffdocCYInvoiceCostAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.09.02 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAORecalculateOffdocCYInvoiceCostAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RecalculateOffdocCYInvoiceCostAmount
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAORecalculateOffdocCYInvoiceCostAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_dcgo_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAORecalculateOffdocCYInvoiceCostAmountUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_DTL D" ).append("\n"); 
		query.append("SET D.INV_AMT = (TO_NUMBER(D.RVIS_VOL_QTY)*TO_NUMBER(D.CTRT_RT))" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND D.DCGO_IND_CD  = @[param_dcgo_clss_cd]" ).append("\n"); 
		query.append("AND DECODE(D.RC_FLG,'Y','Y','N') = DECODE(@[param_rc_flg],'Y','Y','N')" ).append("\n"); 
		query.append("AND D.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 

	}
}