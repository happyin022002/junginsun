/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLAtbDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLAtbDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA DTL ATB_DT 찾아 넣는 작업 : PSA HDR에 정품 YARD가  있어야  처리 가능하기에 PSA DTL에 부모까지 찾은 상태에서 실행한다.
	  * </pre>
	  */
	public TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLAtbDtUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLAtbDtUSQL").append("\n"); 
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
		query.append("UPDATE TES_EDI_SO_PSA_DTL P" ).append("\n"); 
		query.append("SET  P.ATB_DT = (" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN P.PSA_IO_BND_CD IS NOT NULL AND P.PSA_IO_BND_CD IN ('I','D') AND P.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR((SELECT H.YD_CD FROM TES_EDI_SO_HDR H WHERE H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq] AND H.TML_EDI_SO_OFC_CTY_CD = P.TML_EDI_SO_OFC_CTY_CD AND H.TML_EDI_SO_SEQ = P.TML_EDI_SO_SEQ),1,5)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(P.IB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(P.IB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(P.IB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(P.IB_VVD_CD,9)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LAST_DAY(TO_DATE(SUBSTR(P.IB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUBSTR(P.IB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN P.PSA_IO_BND_CD IS NOT NULL AND P.PSA_IO_BND_CD IN ('O','L') AND P.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR((SELECT H.YD_CD FROM TES_EDI_SO_HDR H WHERE H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq] AND H.TML_EDI_SO_OFC_CTY_CD = P.TML_EDI_SO_OFC_CTY_CD AND H.TML_EDI_SO_SEQ = P.TML_EDI_SO_SEQ),1,5)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(P.OB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(P.OB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(P.OB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(P.OB_VVD_CD,9)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LAST_DAY(TO_DATE(SUBSTR(P.OB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUBSTR(P.OB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END )" ).append("\n"); 
		query.append("WHERE P.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND P.TRF_DESC <> 'GST'" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = P.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = P.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("--    AND H.VNDR_SEQ = psa_vndr_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}