/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GuaranteeManageDBDAOSearchUSGuaranteeHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOSearchUSGuaranteeHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Header정보 조회
	  * </pre>
	  */
	public GuaranteeManageDBDAOSearchUSGuaranteeHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOSearchUSGuaranteeHdrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		  GNTE_NO" ).append("\n"); 
		query.append("		, OFC_CD" ).append("\n"); 
		query.append("		, GNTE_TP_CD" ).append("\n"); 
		query.append("		, CURR_CD" ).append("\n"); 
		query.append("		, LPAD(VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("		, (	SELECT VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("			FROM MDM_VENDOR" ).append("\n"); 
		query.append("			WHERE VNDR_SEQ = GH.VNDR_SEQ) VNDR_SEQ_NAME" ).append("\n"); 
		query.append("		, GNTE_CUST_CD" ).append("\n"); 
		query.append("		, (	SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("			FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("			WHERE CUST_CNT_CD = SUBSTR(GH.GNTE_CUST_CD, 0, 2)" ).append("\n"); 
		query.append("			AND CUST_SEQ = SUBSTR(GH.GNTE_CUST_CD, 3, 6) ) GNTE_CUST_CD_NAME" ).append("\n"); 
		query.append("		, BKG_STS_CD" ).append("\n"); 
		query.append("		, TTL_AMT" ).append("\n"); 
		query.append("		, PIC_PHN_NO" ).append("\n"); 
		query.append("		, PIC_FAX_NO" ).append("\n"); 
		query.append("		, DEPT_NO" ).append("\n"); 
		query.append("		, GNTE_RMK" ).append("\n"); 
		query.append("		, NVL(DELT_FLG, 'N') DELT_FLG" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', CRE_DT, OFC_CD), 'YYYY-MM-DD') CRE_DT -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND		GH.GNTE_NO = @[gnte_no]" ).append("\n"); 

	}
}