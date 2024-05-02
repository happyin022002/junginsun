/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

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
	  * Invoice가 처음 만들어진 후 3개월이 경과한 건이 있는지 check하는 조회
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
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
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
		query.append("SELECT DISTINCT DECODE( SIGN(COUNT(0)), 1, 'Y', 'N') AS INV_EXIST_CHK" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("WHERE (H.DELT_FLG = 'N' OR DELT_FLG IS NULL)" ).append("\n"); 
		query.append("  AND H.CRE_DT < SYSDATE-90 " ).append("\n"); 
		query.append("  AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("  AND H.TML_INV_STS_CD IN ('R', 'C')" ).append("\n"); 

	}
}