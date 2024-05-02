/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAOSearchAgmtChdVndrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.19 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOSearchAgmtChdVndrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Child S/P정보 조회
	  * </pre>
	  */
	public AgreementImportDBDAOSearchAgmtChdVndrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchAgmtChdVndrRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR VNR WHERE VNR.VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append(",A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("FROM TRS_AGMT_APLY_VNDR A" ).append("\n"); 
		query.append("WHERE NVL(A.AGMT_VNDR_PRMRY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ((SUBSTR(@[fm_agmtno], 0, 3), SUBSTR(@[fm_agmtno], 4, 6)))" ).append("\n"); 

	}
}