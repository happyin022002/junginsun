/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgDBDAOSearchAgmtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.25
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.06.25 최종혁
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

public class AgreementRailScgDBDAOSearchAgmtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Popup에서 Agreement No 조회
	  * </pre>
	  */
	public AgreementRailScgDBDAOSearchAgmtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtRefNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrtOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comboSvcProvider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOSearchAgmtNoRSQL").append("\n"); 
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
		query.append("A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AS AGMT_NO," ).append("\n"); 
		query.append("B.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR VNR WHERE VNR.VNDR_SEQ = B.VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("A.AGMT_REF_NO AS AGMT_REF_NO," ).append("\n"); 
		query.append("A.CTRT_OFC_CD AS CTRT_OFC_CD," ).append("\n"); 
		query.append("A.INTER_RMK AS INTER_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_AGMT_HDR A," ).append("\n"); 
		query.append("TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("WHERE   A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND     A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("AND     B.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${comboSvcProvider} != \"\")" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = @[comboSvcProvider]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${agmtRefNo} != \"\")" ).append("\n"); 
		query.append("AND UPPER(A.AGMT_REF_NO) LIKE '%'||UPPER(@[agmtRefNo])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ctrtOfcCd} != \"\")" ).append("\n"); 
		query.append("AND A.CTRT_OFC_CD = @[ctrtOfcCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${agmt_no} != \"\")" ).append("\n"); 
		query.append("AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[agmt_no],1,3)" ).append("\n"); 
		query.append("AND A.TRSP_AGMT_SEQ        = SUBSTR(@[agmt_no],4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}