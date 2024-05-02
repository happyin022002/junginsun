/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestDetail2ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.20
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.20 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOSearchManifestDetail2ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해
	  * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOSearchManifestDetail2ListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestDetail2ListRSQL").append("\n"); 
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
		query.append("SELECT NVL(REPLACE(A.CUST_NM, CHR(13) || CHR(10), ' '), '-') AS SHPR_CUST_NM," ).append("\n"); 
		query.append("       NVL(REPLACE(A.CUST_ADDR, CHR(13) || CHR(10), ' '), '-') AS SHPR_CUST_ADDR," ).append("\n"); 
		query.append("       NVL(REPLACE(B.CUST_NM, CHR(13) || CHR(10), ' '), '-') AS CNEE_CUST_NM," ).append("\n"); 
		query.append("       NVL(REPLACE(B.CUST_ADDR, CHR(13) || CHR(10), ' '), '-') AS CNEE_CUST_ADDR," ).append("\n"); 
		query.append("       NVL(REPLACE(C.CUST_NM, CHR(13) || CHR(10), ' '), '-') AS NTFY_CUST_NM," ).append("\n"); 
		query.append("       NVL(REPLACE(C.CUST_ADDR, CHR(13) || CHR(10), ' '), '-') AS NTFY_CUST_ADDR," ).append("\n"); 
		query.append("       REPLACE(NVL(D.MK_DESC, '-'), CHR(13) || CHR(10), ' ') AS MK_DESC," ).append("\n"); 
		query.append("       REPLACE(REPLACE(REPLACE(E.PCK_CMDT_DESC || CHR(13) || CHR(10) || E.CNTR_CMDT_DESC || CHR(13) || CHR(10) || D.CMDT_DESC, CHR(13) || CHR(10), ' '), CHR(13), ' '), CHR(10), ' ') AS CMDT_DESC" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER A, BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_BL_MK_DESC D, BKG_BL_DOC E" ).append("\n"); 
		query.append(" WHERE A.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND (D.MK_SEQ = 1 OR D.MK_SEQ IS NULL)" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 

	}
}