/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOFMCustLineInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.10 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchOFMCustLineInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim OFM Cust line info 쿼리
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOFMCustLineInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOFMCustLineInfoRSQL").append("\n"); 
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
		query.append("'SHPR_NM1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_NM),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'SHPR_NM2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_NM),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'SHPR_ADD1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'SHPR_ADD2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'SHPR_ADD3 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),3),35,' ')||NVL(RTRIM(A.PHN_NO),' ')||NVL(RTRIM(A.FAX_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("'CNEE_NM1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_NM),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'CNEE_NM2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_NM),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'CNEE_ADD1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'CNEE_ADD2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'CNEE_ADD3 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),3),35,' ')||NVL(RTRIM(B.PHN_NO),' ')||NVL(RTRIM(B.FAX_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("'NTFY_NM1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_NM),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'NTFY_NM2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_NM),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'NTFY_ADD1 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),1),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'NTFY_ADD2 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),2),35,' ')||CHR(10)||" ).append("\n"); 
		query.append("'NTFY_ADD3 | '||RPAD(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),3),35,' ')||NVL(RTRIM(C.PHN_NO),' ')||NVL(RTRIM(C.FAX_NO),' ')||CHR(10) buf21" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_CUST A, BKG_CSTMS_ADV_CUST B, BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("WHERE A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND A.BKG_CUST_TP_CD    = 'S'" ).append("\n"); 
		query.append("AND A.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("AND B.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("AND A.BL_NO     = C.BL_NO" ).append("\n"); 
		query.append("AND C.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD    = 'N'" ).append("\n"); 

	}
}