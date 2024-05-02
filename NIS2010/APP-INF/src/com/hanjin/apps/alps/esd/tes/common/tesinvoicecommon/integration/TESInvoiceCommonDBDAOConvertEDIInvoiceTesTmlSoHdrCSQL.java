/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmlSoHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmlSoHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConvertEDIInvoiceTesTmlSoHdr
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmlSoHdrCSQL(){
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
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmlSoHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_HDR(" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_INV_TP_CD," ).append("\n"); 
		query.append("TML_INV_STS_CD," ).append("\n"); 
		query.append("TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append("INV_OFC_CD," ).append("\n"); 
		query.append("COST_OFC_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("RCV_DT," ).append("\n"); 
		query.append("ISS_DT," ).append("\n"); 
		query.append("TTL_INV_AMT," ).append("\n"); 
		query.append("VAT_AMT," ).append("\n"); 
		query.append("WHLD_TAX_AMT," ).append("\n"); 
		query.append("INV_RJCT_RMK," ).append("\n"); 
		query.append("EDI_FLG," ).append("\n"); 
		query.append("FM_PRD_DT," ).append("\n"); 
		query.append("TO_PRD_DT," ).append("\n"); 
		query.append("STO_DYS_IND_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT      TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq]," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN VNDR_SEQ IN ('158002','114776') AND TML_INV_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN DECODE(SUBSTR(TML_INV_TP_CD,1,1),'M','TM','S','ST',TML_INV_TP_CD)" ).append("\n"); 
		query.append("ELSE TML_INV_TP_CD" ).append("\n"); 
		query.append("END TML_INV_TP_CD," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append("INV_OFC_CD," ).append("\n"); 
		query.append("COST_OFC_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("TO_DATE(RCV_DT,'YYYYMMDD') RCV_DT," ).append("\n"); 
		query.append("TO_DATE(ISS_DT,'YYYYMMDD') ISS_DT," ).append("\n"); 
		query.append("--		/** HIT/YICT는 TTL AMT에 소수점 두자리로 취급하여 100으로 나눈다. **/" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN VNDR_SEQ IN ('158002','114776') AND TTL_INV_AMT IS NOT NULL AND TTL_INV_AMT <> 0" ).append("\n"); 
		query.append("THEN TTL_INV_AMT/100" ).append("\n"); 
		query.append("ELSE TTL_INV_AMT" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("0) TTL_INV_AMT," ).append("\n"); 
		query.append("VAT_AMT," ).append("\n"); 
		query.append("WHLD_TAX_AMT," ).append("\n"); 
		query.append("INV_RJCT_RMK," ).append("\n"); 
		query.append("'Y'," ).append("\n"); 
		query.append("NVL(CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND LENGTH(H.TML_INV_TP_CD) = 2 AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'S'" ).append("\n"); 
		query.append("THEN (SELECT" ).append("\n"); 
		query.append("SUBSTR(DECODE(STO_DYS_IND_CD,'IO',MIN(INV_GATE_OUT_TM_MSG),MIN(INV_GATE_IN_TM_MSG)),1,8) FM_PRD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE L.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   L.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("GROUP BY L.TML_EDI_SO_OFC_CTY_CD, L.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END,'') FM_PRD_DT," ).append("\n"); 
		query.append("NVL(CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND LENGTH(H.TML_INV_TP_CD) = 2 AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'S'" ).append("\n"); 
		query.append("THEN (SELECT" ).append("\n"); 
		query.append("SUBSTR(MAX(INV_GATE_OUT_TM_MSG),1,8) FM_PRD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE L.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   L.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("GROUP BY L.TML_EDI_SO_OFC_CTY_CD, L.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END,'') TO_PRD_DT," ).append("\n"); 
		query.append("CASE -- STORAGE만 대상" ).append("\n"); 
		query.append("WHEN TML_INV_TP_CD IS NOT NULL AND LENGTH(TML_INV_TP_CD)=2 AND SUBSTR(TML_INV_TP_CD,1,1)='S'" ).append("\n"); 
		query.append("THEN STO_DYS_IND_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END STO_DYS_IND_CD," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 

	}
}