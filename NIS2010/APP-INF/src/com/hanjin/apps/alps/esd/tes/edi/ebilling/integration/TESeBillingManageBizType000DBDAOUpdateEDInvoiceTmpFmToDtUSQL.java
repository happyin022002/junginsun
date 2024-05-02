/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType000DBDAOUpdateEDInvoiceTmpFmToDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28 
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

public class TESeBillingManageBizType000DBDAOUpdateEDInvoiceTmpFmToDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI에 임시저장된 (Storage대상) FM ~ TO PERIOD DATE를 설정
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOUpdateEDInvoiceTmpFmToDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType000DBDAOUpdateEDInvoiceTmpFmToDtUSQL").append("\n"); 
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
		query.append("UPDATE TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("H.FM_PRD_DT = (" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND LENGTH(H.TML_INV_TP_CD) = 2 AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'S'" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("NVL(FM_PRD_DT," ).append("\n"); 
		query.append("(   SELECT" ).append("\n"); 
		query.append("SUBSTR(MIN(INV_GATE_IN_TM_MSG),1,8) FM_PRD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE L.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   L.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("GROUP BY L.TML_EDI_SO_OFC_CTY_CD, L.TML_EDI_SO_SEQ  ))" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END,''))" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("H.TO_PRD_DT =" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND LENGTH(H.TML_INV_TP_CD) = 2 AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'S'" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("NVL(TO_PRD_DT," ).append("\n"); 
		query.append("(   SELECT" ).append("\n"); 
		query.append("SUBSTR(DECODE(STO_DYS_IND_CD,'IO',NVL(MAX(INV_GATE_OUT_TM_MSG),MAX(INV_GATE_IN_TM_MSG)),MAX(INV_GATE_IN_TM_MSG)),1,8) TO_PRD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_CNTR_LIST L" ).append("\n"); 
		query.append("WHERE L.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   L.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("GROUP BY L.TML_EDI_SO_OFC_CTY_CD, L.TML_EDI_SO_SEQ  ))" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END,'')" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND   H.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND   H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND   NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}