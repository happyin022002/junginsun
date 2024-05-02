/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtDBDAOSearchTrsTrspOfcCdMdmOrganizationRSQL.java
*@FileTitle : TRS Invoice Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : YOO Sunoh
*@LastVersion : 1.0
* 2011.10.27 YOO Sunoh
* 1.0 Creation
-------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.0 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOO Sunoh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvOfcAtrtMgmtDBDAOSearchTrsTrspOfcCdMdmOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice office 코드조회 mdm organization의 ofc_eng_name 과 함께 코드와 영어이름 등등을 조회하게 테이블 조인을 하는 쿼리
	  * </pre>
	  */
	public InvOfcAtrtMgmtDBDAOSearchTrsTrspOfcCdMdmOrganizationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration").append("\n"); 
		query.append("FileName : InvOfcAtrtMgmtDBDAOSearchTrsTrspOfcCdMdmOrganizationRSQL").append("\n"); 
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
		query.append("SELECT A.INV_OFC_CD," ).append("\n"); 
		query.append("(SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = A.INV_OFC_CD) AS INV_OFC_ENG_NM," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("(SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = A.OFC_CD) AS OFC_ENG_NM," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYY.MM.DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT, 'YYYY.MM.DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_OFC A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.INV_OFC_CD IN (@[inv_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD IN (@[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}