/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESCommonDBDAOGetEDIOriginInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOGetEDIOriginInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Invoice 조회
	  * </pre>
	  */
	public TESCommonDBDAOGetEDIOriginInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOGetEDIOriginInvoiceRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("F.FILE_SEQ" ).append("\n"); 
		query.append(", F.ORG_FILE_NM" ).append("\n"); 
		query.append(", C.FILE_SAV_ID SAV_FILE_NM" ).append("\n"); 
		query.append(", C.FILE_PATH_URL SAV_PATH_NM" ).append("\n"); 
		query.append(", F.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", F.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(", F.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", F.TML_SO_SEQ" ).append("\n"); 
		query.append(", F.SAV_CFM_FLG" ).append("\n"); 
		query.append(", F.DELT_FLG" ).append("\n"); 
		query.append(", F.FILE_RMK" ).append("\n"); 
		query.append("FROM	TES_EDI_SO_HDR H, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if (${tml_so_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${tml_edi_so_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND H.TML_INV_RJCT_STS_CD <> 'AJ'" ).append("\n"); 
		query.append("AND	NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ((H.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND H.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(H.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND H.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("AND	NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND	NVL(F.SAV_CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY FILE_SEQ" ).append("\n"); 

	}
}