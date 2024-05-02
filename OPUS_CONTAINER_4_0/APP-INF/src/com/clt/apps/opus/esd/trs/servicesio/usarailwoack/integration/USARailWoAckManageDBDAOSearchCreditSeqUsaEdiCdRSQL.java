/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USARailWoAckManageDBDAOSearchCreditSeqUsaEdiCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOSearchCreditSeqUsaEdiCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCreditSeqUsaEdiCd
	  * </pre>
	  */
	public USARailWoAckManageDBDAOSearchCreditSeqUsaEdiCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration").append("\n"); 
		query.append("FileName : USARailWoAckManageDBDAOSearchCreditSeqUsaEdiCdRSQL").append("\n"); 
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
		query.append("SELECT BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("      ,USA_EDI_CD" ).append("\n"); 
		query.append("  FROM (SELECT A.BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("              ,B.USA_EDI_CD" ).append("\n"); 
		query.append("              ,RANK() OVER(PARTITION BY A.BKG_NO, A.EQ_NO, A.VNDR_SEQ ORDER BY A.BIL_EDI_CTRL_SEQ DESC) RK" ).append("\n"); 
		query.append("          FROM TRS_TRSP_EDI_RAIL_ORD A" ).append("\n"); 
		query.append("              ,MDM_VENDOR            B" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_BIL_ORD C" ).append("\n"); 
		query.append("         WHERE DECODE(NVL(A.BKG_CGO_TP_CD, 'M'), 'M', C.REF_ID, DECODE(LENGTH(@[bkg_no]), 10, A.BL_NO, A.BKG_NO)) = @[bkg_no]" ).append("\n"); 
		query.append("           AND A.EQ_NO LIKE (CASE WHEN LENGTH(@[eq_no]) >= 10 THEN SUBSTR(@[eq_no], 1, 10) ELSE '-' END) || '%'" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND B.USA_EDI_CD = @[usa_edi_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append(" WHERE RK = 1" ).append("\n"); 

	}
}