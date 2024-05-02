/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceVVD
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDRSQL").append("\n"); 
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
		query.append("SELECT V.TML_SO_OFC_CTY_CD VVD_TML_SO_OFC_CTY_CD,									                          " ).append("\n"); 
		query.append("	       V.TML_SO_SEQ VVD_TML_SO_SEQ,											                              " ).append("\n"); 
		query.append("	       V.TML_SO_VVD_LIST_SEQ VVD_TML_SO_VVD_LIST_SEQ,									                      " ).append("\n"); 
		query.append("	       V.VSL_CD VVD_VSL_CD,												                                  " ).append("\n"); 
		query.append("	       V.SKD_VOY_NO VVD_SKD_VOY_NO,											                              " ).append("\n"); 
		query.append("	       V.SKD_DIR_CD VVD_SKD_DIR_CD,											                              " ).append("\n"); 
		query.append("	       V.IO_BND_CD VVD_IO_BND_CD,											                                  " ).append("\n"); 
		query.append("	       V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD||V.IO_BND_CD VVD,	                                              " ).append("\n"); 
		query.append("	       TO_CHAR(V.ATB_DT,'YYYY-MM-DD') VVD_ATB_DT,					                                          " ).append("\n"); 
		query.append("	       TO_CHAR(V.CRE_DT,'YYYY-MM-DD') CRE_DT,                                                               " ).append("\n"); 
		query.append("	       (SELECT  DECODE(V.VSL_CD,'CNTC', 'B', A.TP)                                                            " ).append("\n"); 
		query.append("	        FROM   (SELECT COUNT(*), MAX(DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT CRR_CD FROM MDM_VSL_CNTR M WHERE S.VSL_CD=M.VSL_CD(+)),'TSG','H','C'),'H')) TP  " ).append("\n"); 
		query.append("                    FROM   TES_TML_SO_HDR H, TES_TML_SO_VVD_LIST V2, VSK_VSL_SKD S, MDM_VSL_SVC_LANE L           " ).append("\n"); 
		query.append("                    WHERE  H.INV_NO = @[inv_no]                                                                        " ).append("\n"); 
		query.append("                    AND    H.VNDR_SEQ = @[vndr_seq]                                                                      " ).append("\n"); 
		query.append("                    AND    NVL(H.DELT_FLG,'N') <> 'Y'                                                            " ).append("\n"); 
		query.append("                    AND    H.TML_SO_OFC_CTY_CD = V2.TML_SO_OFC_CTY_CD                                            " ).append("\n"); 
		query.append("                    AND    H.TML_SO_SEQ  = V2.TML_SO_SEQ                                                         " ).append("\n"); 
		query.append("                    AND    V2.VSL_CD     = S.VSL_CD                                                              " ).append("\n"); 
		query.append("                    AND    V2.SKD_VOY_NO = S.SKD_VOY_NO                                                          " ).append("\n"); 
		query.append("                    AND    V2.SKD_DIR_CD = S.SKD_DIR_CD                                                          " ).append("\n"); 
		query.append("                    AND    S.VSL_SLAN_CD = L.VSL_SLAN_CD(+) )A" ).append("\n"); 
		query.append("            ) VVD_TYPE,  " ).append("\n"); 
		query.append("            NVL(V.CALL_YD_IND_SEQ, NVL((SELECT MIN(CALL_YD_IND_SEQ) /*등록된 ATB가 동일할때.*/" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                                           AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD = SUBSTR(H.YD_CD,1,5)" ).append("\n"); 
		query.append("                                           AND TO_CHAR(VPS.VPS_ETB_DT,'YYYYMMDD') = TO_CHAR(V.ATB_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                                     ),(SELECT MIN(CALL_YD_IND_SEQ) /*등록된 ATB가 동일하지 않을때.*/" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                                           AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD = SUBSTR(H.YD_CD,1,5))" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("            ) AS VVD_CALL_YD_IND_SEQ /*2016.07.13 Add*/                                           " ).append("\n"); 
		query.append("    FROM TES_TML_SO_HDR H, TES_TML_SO_VVD_LIST V, VSK_VSL_SKD S, MDM_VSL_SVC_LANE L                              " ).append("\n"); 
		query.append("    WHERE H.INV_NO = @[inv_no]                                                                                                " ).append("\n"); 
		query.append("    AND   H.VNDR_SEQ = @[vndr_seq]                                                                                           " ).append("\n"); 
		query.append("    AND   NVL(H.DELT_FLG,'N') <> 'Y'                                                                             " ).append("\n"); 
		query.append("    AND   H.TML_SO_OFC_CTY_CD = V.TML_SO_OFC_CTY_CD                                                              " ).append("\n"); 
		query.append("    AND   H.TML_SO_SEQ = V.TML_SO_SEQ                                                                            " ).append("\n"); 
		query.append("    AND   V.VSL_CD = S.VSL_CD(+)                                                                                 " ).append("\n"); 
		query.append("    AND   V.SKD_VOY_NO = S.SKD_VOY_NO(+)                                                                         " ).append("\n"); 
		query.append("    AND   V.SKD_DIR_CD = S.SKD_DIR_CD(+)                                                                         " ).append("\n"); 
		query.append("    AND   S.VSL_SLAN_CD= L.VSL_SLAN_CD(+)                                                                        " ).append("\n"); 
		query.append("    ORDER BY V.TML_SO_VVD_LIST_SEQ" ).append("\n"); 

	}
}