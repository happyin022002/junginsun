/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType003DBDAOCreateEDInvoicePSAHDRTmpDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType003DBDAOCreateEDInvoicePSAHDRTmpDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA HDR 밀어넣기 : DTL에서 (S/P + INV)별 HDR KEY값 추출 -> HDR저장 VNDR에 해당하는 MDM에서 OFC조회및UPDATE(OFC가 없을 경우 유효성 확인시 AJ처리됨)
	  * 	               기타 HDR 주요항목 저장 (INV TP/YD/CURR/COST OFC/TTL AMT.. 등)
	  * </pre>
	  */
	public TESeBillingManageBizType003DBDAOCreateEDInvoicePSAHDRTmpDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_edi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType003DBDAOCreateEDInvoicePSAHDRTmpDataCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_EDI_SO_HDR (" ).append("\n"); 
		query.append("TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_EDI_SO_SEQ," ).append("\n"); 
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
		query.append("DELT_FLG," ).append("\n"); 
		query.append("STO_DYS_IND_CD," ).append("\n"); 
		query.append("VLD_CHK_FLG," ).append("\n"); 
		query.append("FLT_FILE_MSG_ID," ).append("\n"); 
		query.append("TML_INV_EDI_SEQ," ).append("\n"); 
		query.append("EDI_SNDR_ID," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TES_EDI_SO_HDR_SEQ.NEXTVAL TML_EDI_SO_SEQ," ).append("\n"); 
		query.append("DECODE(X.TML_INV_TP_CD_KNT,1,X.TML_INV_TP_CD,'') TML_INV_TP_CD," ).append("\n"); 
		query.append("'R' TML_INV_STS_CD," ).append("\n"); 
		query.append("'AJ' TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append("X.INV_OFC_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN DECODE(X.YD_CD_KNT,1,X.YD_CD,'') IS NOT NULL" ).append("\n"); 
		query.append("THEN NVL((SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD=DECODE(X.YD_CD_KNT,1,X.YD_CD,'') AND Y.DELT_FLG='N' AND ROWNUM=1),'')" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END COST_OFC_CD," ).append("\n"); 
		query.append("@[psa_vndr_seq] VNDR_SEQ," ).append("\n"); 
		query.append("DECODE(X.YD_CD_KNT,1,X.YD_CD,'') YD_CD," ).append("\n"); 
		query.append("X.INV_NO," ).append("\n"); 
		query.append("DECODE(X.CURR_CD_KNT,1,X.CURR_CD,'') CURR_CD," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'YYYYMMDD') RCV_DT," ).append("\n"); 
		query.append("DECODE(X.ISS_DT_KNT,1,X.ISS_DT,'') ISS_DT," ).append("\n"); 
		query.append("X.TTL_INV_AMT," ).append("\n"); 
		query.append("'N' DELT_FLG," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN DECODE(X.TML_INV_TP_CD_KNT,1,X.TML_INV_TP_CD,'') IN ('ST','OF')" ).append("\n"); 
		query.append("THEN 'IO'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END STO_DYS_IND_CD," ).append("\n"); 
		query.append("'N' VLD_CHK_FLG," ).append("\n"); 
		query.append("X.FLT_FILE_MSG_ID," ).append("\n"); 
		query.append("X.TML_INV_EDI_SEQ," ).append("\n"); 
		query.append("X.EDI_SNDR_ID," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(X.INV_OFC_CD) LOCL_CRE_DT," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(X.INV_OFC_CD) LOCL_UPD_DT," ).append("\n"); 
		query.append("'ALPS_TES' CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("'ALPS_TES' UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (SELECT V.OFC_CD FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[psa_vndr_seq]) IS NOT NULL" ).append("\n"); 
		query.append("THEN SUBSTR((SELECT TRIM(V.OFC_CD) FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[psa_vndr_seq]),1,3)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("(SELECT TRIM(V.OFC_CD) FROM MDM_VENDOR V WHERE V.VNDR_SEQ = @[psa_vndr_seq]) INV_OFC_CD," ).append("\n"); 
		query.append("TRIM(INV_NO) INV_NO," ).append("\n"); 
		query.append("COUNT(DISTINCT TML_INV_TP_CD) TML_INV_TP_CD_KNT," ).append("\n"); 
		query.append("MAX(TML_INV_TP_CD) TML_INV_TP_CD," ).append("\n"); 
		query.append("COUNT(DISTINCT YD_CD) YD_CD_KNT," ).append("\n"); 
		query.append("MAX(YD_CD) YD_CD," ).append("\n"); 
		query.append("COUNT(DISTINCT ISS_DT) ISS_DT_KNT," ).append("\n"); 
		query.append("MAX(ISS_DT) ISS_DT," ).append("\n"); 
		query.append("COUNT(DISTINCT CURR_CD) CURR_CD_KNT," ).append("\n"); 
		query.append("MAX(CURR_CD) CURR_CD," ).append("\n"); 
		query.append("SUM(P.INV_AMT) TTL_INV_AMT," ).append("\n"); 
		query.append("MAX(P.FLT_FILE_MSG_ID) FLT_FILE_MSG_ID," ).append("\n"); 
		query.append("MAX(P.TML_INV_EDI_SEQ) TML_INV_EDI_SEQ," ).append("\n"); 
		query.append("MAX(P.EDI_SNDR_ID) EDI_SNDR_ID" ).append("\n"); 
		query.append("FROM TES_EDI_SO_PSA_DTL P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND P.TRF_DESC <> 'GST'" ).append("\n"); 
		query.append("GROUP BY P.INV_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.TML_EDI_SO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 

	}
}