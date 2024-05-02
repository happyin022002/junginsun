/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchInvFACMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.05
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.02.05 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchInvFACMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice FAC Master 정보 조회 - INV 모듈 담당자 확인 받은 쿼리
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchInvFACMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchInvFACMasterRSQL").append("\n"); 
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
		query.append("SELECT ACM.FAC_STS_CD, NVL(DOC.BL_CVRD_TP_CD, 'N') COVERED_CHECK, NVL(DOC.MST_CVRD_BL_NO,'N')	BKG_NO" ).append("\n"); 
		query.append(",(  SELECT NVL(SUM(B.CHG_AMT),0) * -1" ).append("\n"); 
		query.append("    FROM   INV_AR_MN A, " ).append("\n"); 
		query.append("           INV_AR_CHG B" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("    AND   A.BL_SRC_NO = @[bkg_no]     --Sample'AAR300006100'" ).append("\n"); 
		query.append("    AND   A.AR_OFC_CD = ACM.AR_OFC_CD --Sample'AARBA'" ).append("\n"); 
		query.append("    AND   A.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("    AND   A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("    AND   B.CHG_CD = 'FAC'" ).append("\n"); 
		query.append(") AS CRNT_AMT" ).append("\n"); 
		query.append("FROM ACM_FAC_COMM ACM, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE ACM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ACM.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 

	}
}