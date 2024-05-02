/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESCommonDBDAOCheckInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOCheckInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 S/P와 invoice번호로 EDI invoice와 정규 invoice를 조회하여 중복 여부/invoice상태로 허용가능여부를 확인한다.
	  * </pre>
	  */
	public TESCommonDBDAOCheckInvoiceRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_file_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOCheckInvoiceRSQL").append("\n"); 
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
		query.append("X.VNDR_SEQ, X.INV_NO," ).append("\n"); 
		query.append("NVL(COUNT(X.INV_NO),0) INV_KNT," ).append("\n"); 
		query.append("NVL(SUM(DECODE(X.TML_INV_STS_CD,'R',0,1)),0) ACC_STS," ).append("\n"); 
		query.append("X.TML_SO_OFC_CTY_CD, X.TML_SO_SEQ, X.TML_EDI_SO_OFC_CTY_CD, X.TML_EDI_SO_SEQ," ).append("\n"); 
		query.append("SUM(CASE WHEN X.TML_SO_OFC_CTY_CD IS NOT NULL THEN 1 ELSE 0 END) REG_INV_KNT," ).append("\n"); 
		query.append("COUNT(X.FILE_SEQ) FILE_KNT, MAX(X.ORG_FILE_NM) ORG_FILE_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT H.VNDR_SEQ, H.INV_NO, H.TML_INV_STS_CD, H.TML_SO_OFC_CTY_CD, H.TML_SO_SEQ, NULL TML_EDI_SO_OFC_CTY_CD, NULL TML_EDI_SO_SEQ, F.FILE_SEQ, F.ORG_FILE_NM" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_EDI_SO_FILE F" ).append("\n"); 
		query.append("WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('R','C','A','P','D')" ).append("\n"); 
		query.append("AND H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = F.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("AND F.ORG_FILE_NM(+) = @[org_file_nm]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.VNDR_SEQ, H.INV_NO, H.TML_INV_STS_CD, NULL TML_SO_OFC_CTY_CD, NULL TML_SO_SEQ, H.TML_EDI_SO_OFC_CTY_CD, H.TML_EDI_SO_SEQ, F.FILE_SEQ, F.ORG_FILE_NM" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H, TES_EDI_SO_FILE F" ).append("\n"); 
		query.append("WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('R')" ).append("\n"); 
		query.append("AND NVL(H.TML_INV_RJCT_STS_CD,'N') = 'NL'" ).append("\n"); 
		query.append("AND NVL(H.VLD_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_RJCT_STS_CD <> 'AJ'" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND H.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ(+)" ).append("\n"); 
		query.append("AND F.ORG_FILE_NM(+) = @[org_file_nm]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.VNDR_SEQ, X.INV_NO, X.TML_SO_OFC_CTY_CD, X.TML_SO_SEQ, X.TML_EDI_SO_OFC_CTY_CD, X.TML_EDI_SO_SEQ" ).append("\n"); 

	}
}