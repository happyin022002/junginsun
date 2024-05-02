/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
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

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice 내역을 수정
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL(){
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
		params.put("invTtlAmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invVatAmt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("invRecDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sStsCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invIssDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invCurrCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invBacAmt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("SET TRSP_INV_AUD_STS_CD		= @[sStsCd]" ).append("\n"); 
		query.append(",	WO_VNDR_SEQ				= @[railRoadCode]" ).append("\n"); 
		query.append(",	INV_RCV_DT				= TO_DATE(@[invRecDt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	INV_ISS_DT				= TO_DATE(@[invIssDt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	INV_CURR_CD				= @[invCurrCd]" ).append("\n"); 
		query.append(",	INV_BZC_AMT				= @[invBacAmt]" ).append("\n"); 
		query.append(",	INV_VAT_AMT				= @[invVatAmt]" ).append("\n"); 
		query.append(",	INV_TTL_AMT				= @[invTtlAmt]" ).append("\n"); 
		query.append(",	INV_CFM_DT				= DECODE(@[sStsCd],'CF',SYSDATE,NULL)" ).append("\n"); 
		query.append(",	NON_BIL_INV_AMT			= CASE @[sStsCd] WHEN 'CF' THEN (SELECT SUM(INV_BZC_AMT) FROM TRS_TRSP_RAIL_INV_DTL WHERE INV_NO = @[invNo] AND INV_VNDR_SEQ = @[invVndrSeq] AND NON_BIL_INV_FLG = 'Y') END" ).append("\n"); 
		query.append(",	UPD_USR_ID				= @[sUsrId]" ).append("\n"); 
		query.append(",	LOCL_UPD_DT				= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(",   UPD_DT                  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("WHERE INV_NO			= @[invNo]" ).append("\n"); 
		query.append("AND	  INV_VNDR_SEQ		= @[invVndrSeq]" ).append("\n"); 

	}
}