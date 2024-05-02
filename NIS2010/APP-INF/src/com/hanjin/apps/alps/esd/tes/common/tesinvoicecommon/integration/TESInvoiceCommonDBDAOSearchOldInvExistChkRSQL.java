/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice가 처음 만들어진 후 2개월이 경과한 건이 있는지 check하는 조회
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL").append("\n"); 
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
		query.append("SELECT DECODE( SIGN(COUNT(0)), 1, 'Y', 'N') AS INV_EXIST_CHK" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("WHERE (H.DELT_FLG = 'N' OR DELT_FLG IS NULL)" ).append("\n"); 
		query.append("--2017년 1월 1일 이후 Creation Data로 제한을 둠" ).append("\n"); 
		query.append("  AND TO_CHAR(H.CRE_DT,'YYYYMMDD') >= '20170101' " ).append("\n"); 
		query.append("  AND H.CRE_DT < SYSDATE-60 " ).append("\n"); 
		query.append("  AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("  AND H.TML_INV_STS_CD IN ('R', 'C')" ).append("\n"); 

	}
}