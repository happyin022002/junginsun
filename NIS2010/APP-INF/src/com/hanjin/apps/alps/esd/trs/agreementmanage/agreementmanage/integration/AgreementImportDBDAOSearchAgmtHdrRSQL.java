/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAOSearchAgmtHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.05.13 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOSearchAgmtHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Header 정보 조회
	  * </pre>
	  */
	public AgreementImportDBDAOSearchAgmtHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchAgmtHdrRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",B.VNDR_SEQ AS VNDR_PRMRY_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR VNR WHERE VNR.VNDR_SEQ = B.VNDR_SEQ) AS VNDR_PRMRY_NM" ).append("\n"); 
		query.append(",A.CTRT_OFC_CD" ).append("\n"); 
		query.append(",A.AGMT_REF_NO" ).append("\n"); 
		query.append(",A.AGMT_PIC_NM" ).append("\n"); 
		query.append(",A.INTER_RMK" ).append("\n"); 
		query.append(",A.CRE_OFC_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM  TRS_AGMT_HDR A" ).append("\n"); 
		query.append(",TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("AND B.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ((SUBSTR(@[fm_agmtno], 0, 3), SUBSTR(@[fm_agmtno], 4, 6)))" ).append("\n"); 

	}
}