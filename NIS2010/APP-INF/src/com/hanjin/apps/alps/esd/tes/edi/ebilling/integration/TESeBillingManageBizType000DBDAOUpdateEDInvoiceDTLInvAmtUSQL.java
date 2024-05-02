/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType000DBDAOUpdateEDInvoiceDTLInvAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.07 
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

public class TESeBillingManageBizType000DBDAOUpdateEDInvoiceDTLInvAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수동 비용의 경우 DTL별 INV AMT 누락시 RATE * VOL으로 넣어준다
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOUpdateEDInvoiceDTLInvAmtUSQL(){
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
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageBizType000DBDAOUpdateEDInvoiceDTLInvAmtUSQL").append("\n"); 
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
		query.append("UPDATE TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("SET D.INV_AMT =   NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN D.INV_AMT IS NULL OR D.INV_AMT = 0" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (SELECT H.TML_INV_TP_CD FROM TES_EDI_SO_HDR H WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ) = 'TM'" ).append("\n"); 
		query.append("THEN NVL(CTRT_RT,0) * NVL(CALC_VOL_QTY,0)" ).append("\n"); 
		query.append("WHEN (SELECT H.TML_INV_TP_CD FROM TES_EDI_SO_HDR H WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ) = 'ST'" ).append("\n"); 
		query.append("THEN NVL(CTRT_RT,0) * NVL(STAY_DYS,0)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE INV_AMT" ).append("\n"); 
		query.append("END,0)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND (D.INV_AMT IS NULL OR NVL(D.INV_AMT,0) = 0)" ).append("\n"); 
		query.append("AND NVL(D.CTRT_RT,0) <> 0" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}