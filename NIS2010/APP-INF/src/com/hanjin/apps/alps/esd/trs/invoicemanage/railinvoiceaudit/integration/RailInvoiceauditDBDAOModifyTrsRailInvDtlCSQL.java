/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice 내역을 입력
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL(){
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
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_INV_WRK (" ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("WO_VNDR_SEQ," ).append("\n"); 
		query.append("INV_RCV_DT," ).append("\n"); 
		query.append("INV_ISS_DT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("INV_BZC_AMT," ).append("\n"); 
		query.append("INV_VAT_AMT," ).append("\n"); 
		query.append("INV_TTL_AMT," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("GEN_PAY_TERM_CD," ).append("\n"); 
		query.append("INV_CFM_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[invNo]," ).append("\n"); 
		query.append("@[invVndrSeq]," ).append("\n"); 
		query.append("@[sStsCd]," ).append("\n"); 
		query.append("@[railRoadCode]," ).append("\n"); 
		query.append("TO_DATE(@[invRecDt] ,'YYYYMMDD')," ).append("\n"); 
		query.append("TO_DATE(@[invIssDt] ,'YYYYMMDD')," ).append("\n"); 
		query.append("@[invCurrCd]," ).append("\n"); 
		query.append("@[invBacAmt]," ).append("\n"); 
		query.append("@[invVatAmt]," ).append("\n"); 
		query.append("@[invTtlAmt]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[sOfcCd]," ).append("\n"); 
		query.append("@[sUsrId]," ).append("\n"); 
		query.append("@[sUsrId]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VNDR_SEQ = @[invVndrSeq]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("DECODE(@[sStsCd],'CF',SYSDATE,NULL)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}