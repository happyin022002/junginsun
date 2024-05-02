/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCommonManageDBDAOServiceProviderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOServiceProviderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ServiceProvider
	  * </pre>
	  */
	public PrdCommonManageDBDAOServiceProviderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pts_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm_eng",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOServiceProviderRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("LPAD(M.vndr_seq, 6, '0') vndr_seq, M.VNDR_ABBR_NM , VNDR_LGL_ENG_NM ,M.ofc_cd , LPAD(PRNT_VNDR_SEQ, 6, '0') prnt_vndr_seq,  " ).append("\n"); 
		query.append("M.vndr_cnt_cd,VNDR_CNT_CD||LPAD(M.vndr_seq, 6, '0') org_vndr_seQ   " ).append("\n"); 
		query.append("FROM MDM_VENDOR M  " ).append("\n"); 
		query.append("WHERE 1 = 1		" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("		 AND VNDR_CNT_CD like '%' || @[cnt_cd] || '%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_nm_eng} != '')" ).append("\n"); 
		query.append("		 AND VNDR_LGL_ENG_NM like '%' || @[vndr_nm_eng] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pts_vndr_cd} !='')" ).append("\n"); 
		query.append("	    AND PRNT_CNT_CD||PRNT_VNDR_SEQ like '%' || @[pts_vndr_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND " ).append("\n"); 
		query.append("EXISTS ( " ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("             ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("        M.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("        AND  A.CTRT_OFC_CD like @[ofc_cd] ||'%'" ).append("\n"); 
		query.append("        AND  A.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND  A.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("        AND EXISTS" ).append("\n"); 
		query.append("        ( SELECT 'X'" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            TRS_AGMT_EQ_RT E" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND  A.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND  A.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            AND   (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("                   BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT+0.9999" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}