/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAOSearchAgmtDupChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.17
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.17 최종혁
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

public class AgreementImportDBDAOSearchAgmtDupChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement 중복 체크
	  * </pre>
	  */
	public AgreementImportDBDAOSearchAgmtDupChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_prmry_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchAgmtDupChkRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("FROM TRS_AGMT_HDR A," ).append("\n"); 
		query.append("TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("AND B.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_REF_NO = @[agmt_ref_no]" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = @[vndr_prmry_seq]" ).append("\n"); 

	}
}