/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESCommonDBDAOCheckEDIOriginInvoiceMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.11 
* 1.0 Creation
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
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

public class TESCommonDBDAOCheckEDIOriginInvoiceMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 EDI invoice의 S/P+inv no.로 구성된 EDI invoice원본을 조회한다.
	  * </pre>
	  */
	public TESCommonDBDAOCheckEDIOriginInvoiceMappingRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOCheckEDIOriginInvoiceMappingRSQL").append("\n"); 
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
		query.append("NVL(COUNT(F.FILE_SEQ),0) FILE_DATA_KNT," ).append("\n"); 
		query.append("F.TML_EDI_SO_OFC_CTY_CD, F.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_FILE F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(F.DELT_FLG,'N')<>'Y'" ).append("\n"); 
		query.append("AND F.SAV_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("AND F.TML_EDI_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND F.TML_EDI_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND F.ORG_FILE_NM LIKE (" ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN H.VNDR_SEQ||'_'||H.INV_NO||'_'" ).append("\n"); 
		query.append("ELSE 'XXXXXXXXXXXXXXXXXXXX'" ).append("\n"); 
		query.append("END ORG_FILE_LIKE" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('R')" ).append("\n"); 
		query.append("AND NVL(H.TML_INV_RJCT_STS_CD,'N') = 'NL'" ).append("\n"); 
		query.append("AND NVL(H.VLD_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_RJCT_STS_CD <> 'AJ'" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1),'XXXXXXXXXXXXXXXXXXXX')" ).append("\n"); 
		query.append(")||'%'" ).append("\n"); 
		query.append("GROUP BY F.TML_EDI_SO_OFC_CTY_CD, F.TML_EDI_SO_SEQ" ).append("\n"); 

	}
}