/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType003DBDAODeleteNonTESTariffInvoiceUSQL.java
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

public class TESeBillingManageBizType003DBDAODeleteNonTESTariffInvoiceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기본 수신단계에서 유효성 확인까지 마치고, NON-TES tariff로만 된 경우(cost code mapping이 하나도 안된 경우라 추정) invoice를 삭제처리한다.
	  * </pre>
	  */
	public TESeBillingManageBizType003DBDAODeleteNonTESTariffInvoiceUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TESeBillingManageBizType003DBDAODeleteNonTESTariffInvoiceUSQL").append("\n"); 
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
		query.append("SET DELT_FLG       = 'Y'" ).append("\n"); 
		query.append(", INV_RJCT_RMK = 'NON-TES DELT'||CASE WHEN INV_RJCT_RMK IS NOT NULL THEN ', '||INV_RJCT_RMK ELSE '' END" ).append("\n"); 
		query.append(", UPD_USR_ID   = NVL(@[upd_usr_id],'eNIS_TES')" ).append("\n"); 
		query.append(", UPD_DT	   = SYSDATE" ).append("\n"); 
		query.append(", LOCL_UPD_DT  = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(H.INV_OFC_CD),LOCL_CRE_DT)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[psa_vndr_seq]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND NVL((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN COUNT(P.TRF_DESC) > 0" ).append("\n"); 
		query.append("AND COUNT(P.LGS_COST_CD) > 0" ).append("\n"); 
		query.append("AND COUNT(P.TML_EDI_SO_PSA_DTL_SEQ) = COUNT(P.TRF_DESC)" ).append("\n"); 
		query.append("AND COUNT(P.LGS_COST_CD) = COUNT(P.TRF_DESC)" ).append("\n"); 
		query.append("AND COUNT(P.TML_EDI_SO_PSA_DTL_SEQ) = COUNT(C.LGS_COST_CD)" ).append("\n"); 
		query.append("AND COUNT(T.LGS_COST_CD) = 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END NON_TES_CHK" ).append("\n"); 
		query.append("FROM TES_EDI_SO_PSA_DTL P, TES_LGS_COST C, TES_TML_SO_COST T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND P.LGS_COST_CD = T.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = H.TML_INV_EDI_SEQ" ).append("\n"); 
		query.append("AND P.TRF_DESC <> 'GST'" ).append("\n"); 
		query.append("),'N') = 'Y'" ).append("\n"); 

	}
}