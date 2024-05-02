/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType000DBDAOupdateEDInvoiceDTLTmpLGSCostCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19 
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

public class TESeBillingManageBizType000DBDAOupdateEDInvoiceDTLTmpLGSCostCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNDR tariff로 Cost code를 참조하여 update
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOupdateEDInvoiceDTLTmpLGSCostCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TESeBillingManageBizType000DBDAOupdateEDInvoiceDTLTmpLGSCostCodeUSQL").append("\n"); 
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
		query.append("SET  D.LGS_COST_CD = (  SELECT DISTINCT C.LGS_COST_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_COST C" ).append("\n"); 
		query.append("WHERE C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND C.VNDR_TRF_DESC = D.TRF_DESC" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("WHERE D.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 

	}
}