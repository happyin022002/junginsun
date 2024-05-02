/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLHDRseqUSQL.java
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

public class TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLHDRseqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA DTL의 부모 찾아 이어주기
	  * </pre>
	  */
	public TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLHDRseqUSQL(){
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
		query.append("FileName : TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLHDRseqUSQL").append("\n"); 
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
		query.append("SET (P.TML_EDI_SO_OFC_CTY_CD, P.TML_EDI_SO_SEQ) = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.TML_EDI_SO_OFC_CTY_CD, H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE H.VNDR_SEQ        = @[psa_vndr_seq]" ).append("\n"); 
		query.append("AND P.INV_NO            = H.INV_NO" ).append("\n"); 
		query.append("AND H.TML_INV_EDI_SEQ   = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM   TES_EDI_SO_PSA_DTL B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = B.TML_INV_EDI_SEQ" ).append("\n"); 
		query.append("AND P.INV_NO          = B.INV_NO" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_PSA_DTL_SEQ > 0" ).append("\n"); 
		query.append("AND P.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND P.TML_EDI_SO_SEQ IS NULL" ).append("\n"); 

	}
}