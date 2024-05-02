/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcNtfyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.28 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblAvcNtfyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcNtfyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcNtfyCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC_NTFY" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,EBL_BKG_CUST_TP_CD" ).append("\n"); 
		query.append("	,NTFY_ADDR1" ).append("\n"); 
		query.append("	,NTFY_ADDR2" ).append("\n"); 
		query.append("	,NTFY_FAX_NO1" ).append("\n"); 
		query.append("	,NTFY_PHN_NO1" ).append("\n"); 
		query.append("	,NTFY_EML1" ).append("\n"); 
		query.append("	,NTFY_ADDR3" ).append("\n"); 
		query.append("	,NTFY_ADDR4" ).append("\n"); 
		query.append("	,NTFY_ADDR5" ).append("\n"); 
		query.append("	,NTFY_ADDR6" ).append("\n"); 
		query.append("	,NTFY_ADDR7" ).append("\n"); 
		query.append("	,NTFY_FAX_NO2" ).append("\n"); 
		query.append("	,NTFY_PHN_NO2" ).append("\n"); 
		query.append("	,NTFY_EML2" ).append("\n"); 
		query.append("	,NTFY_CUST_NM" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT)" ).append("\n"); 
		query.append("SELECT	C.BKG_NO BKG_NO" ).append("\n"); 
		query.append("	,B.BL_NO BL_NO" ).append("\n"); 
		query.append("	,@[bkg_ebl_seq]" ).append("\n"); 
		query.append("	,ROW_NUMBER() OVER( ORDER BY DECODE(BKG_CUST_TP_CD ,'N',1,'A',2,3)) CNTR_SEQ" ).append("\n"); 
		query.append("	,C.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,C.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROW_NUMBER() OVER( ORDER BY DECODE(BKG_CUST_TP_CD ,'N',1,'A',2,3)), '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,'N'||ROW_NUMBER() OVER( ORDER BY DECODE(BKG_CUST_TP_CD ,'N',1,'A',2,3)) EBL_BKG_CUST_TP_CD" ).append("\n"); 
		query.append("	,SUBSTR(REPLACE(C.CUST_NM,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(C.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) NTFY_ADDR1" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_NM,CHR(13)||CHR(10),'^'),INSTR(REPLACE(C.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                   ,INSTR(REPLACE(C.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                    INSTR(REPLACE(C.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) NTFY_ADDR2" ).append("\n"); 
		query.append("	,C.CUST_FAX_NO NTFY_FAX_NO1" ).append("\n"); 
		query.append("	,'' NTFY_PHN_NO1" ).append("\n"); 
		query.append("	,C.CUST_EML NTFY_EML1" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) NTFY_ADDR3" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                     ,INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                      INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) NTFY_ADDR4" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) + 1" ).append("\n"); 
		query.append("                                                     ,INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - " ).append("\n"); 
		query.append("                                                      INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - 1) NTFY_ADDR5" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) + 1" ).append("\n"); 
		query.append("                                                     ,INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - " ).append("\n"); 
		query.append("                                                      INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - 1) NTFY_ADDR6" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) + 1" ).append("\n"); 
		query.append("                                                     ,INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,5) - " ).append("\n"); 
		query.append("                                                      INSTR(REPLACE(C.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - 1) NTFY_ADDR7" ).append("\n"); 
		query.append("	,'' NTFY_FAX_NO2" ).append("\n"); 
		query.append("	,'' NTFY_PHN_NO2" ).append("\n"); 
		query.append("	,'' NTFY_EML2" ).append("\n"); 
		query.append("	,SUBSTR(CNTC.CNTC_PSON_NM,1,25) NTFY_CUST_NM" ).append("\n"); 
		query.append("	,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM	BKG_CUSTOMER C" ).append("\n"); 
		query.append("        ,BKG_BOOKING B" ).append("\n"); 
		query.append("		,BKG_CNTC_PSON CNTC" ).append("\n"); 
		query.append("  WHERE C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND  B.BKG_NO = CNTC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  CNTC.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append("   AND  C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND  C.BKG_CUST_TP_CD IN('N','A')" ).append("\n"); 

	}
}