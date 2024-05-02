/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchMinusInvAmtSvxxJoExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
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

public class TESInvoiceCommonDBDAOSearchMinusInvAmtSvxxJoExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가. Invoice office:CGPBO,JKTBB,LOSBA,NYCBB,SINBB,TEMBA
	  * 나. Yard code , S/P code, cost code(SVXXJO)가 동일
	  * 다. 현재 처리하려는 invoice 의 SVXXJO가  minus 값이고
	  * 라. 2013년 4/8일 기준 1년 전까지를 대상으로 하고 accout code는  954113를 가지고 있는 경우
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchMinusInvAmtSvxxJoExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchMinusInvAmtSvxxJoExistRSQL").append("\n"); 
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
		query.append("SELECT INV_NO, 'Y' JO_EXIST_FLG" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--AND H.INV_OFC_CD in ('CGPBO','JKTBB','LOSBA','NYCBB','SINBB','TEMBA') 2015-08-03 그룹사 조직 코드 변경 " ).append("\n"); 
		query.append("AND H.INV_OFC_CD in ('CGPKS','JKTSC','LOSBA','NYCSC','SINSC','TEMBA')" ).append("\n"); 
		query.append("AND D.LGS_COST_CD = 'SVXXJO'" ).append("\n"); 
		query.append("AND D.ACCT_CD = '954113'" ).append("\n"); 
		query.append("AND H.TTL_INV_AMT < 0" ).append("\n"); 
		query.append("AND H.AP_IF_DT BETWEEN TO_DATE('20130408','YYYYMMDD') - 365 AND TO_DATE('20130408','YYYYMMDD')" ).append("\n"); 

	}
}