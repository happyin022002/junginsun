/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfVerChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.03.30 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfVerChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfVerChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfVerChkRSQL").append("\n"); 
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
		query.append("X.DRFF_CHG_TRF_SEQ, X.DRFF_CHG_TRF_VER_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.DRFF_CHG_TRF_SEQ IS NOT NULL AND X.DRFF_CHG_TRF_VER_NO IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VER_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE CNT_CD = @[cnt_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE RFA_NO = @[rfa_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("THEN (SELECT DRFF_CHG_TRF_SEQ FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE CNT_CD = @[cnt_cd] AND ROWNUM = 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("THEN (SELECT DRFF_CHG_TRF_SEQ FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE RFA_NO = @[rfa_no] AND ROWNUM = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ELSE (SELECT NVL(MAX(DRFF_CHG_TRF_SEQ),0)+1 FROM EAS_DRFF_CHG_TRF_HDR H2)" ).append("\n"); 
		query.append("END DRFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE CNT_CD = @[cnt_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE RFA_NO = @[rfa_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("THEN (SELECT NVL(MAX(DRFF_CHG_TRF_VER_NO),0)+1 FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE H2.DRFF_CHG_TRF_SEQ=(SELECT DRFF_CHG_TRF_SEQ FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE CNT_CD = @[cnt_cd] AND ROWNUM = 1))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("THEN (SELECT NVL(MAX(DRFF_CHG_TRF_VER_NO),0)+1 FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE H2.DRFF_CHG_TRF_SEQ=(SELECT DRFF_CHG_TRF_SEQ FROM EAS_DRFF_CHG_TRF_HDR H2 WHERE RFA_NO = @[rfa_no] AND ROWNUM = 1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ELSE TO_NUMBER(1) -- 처음 VERSION은 1로 받아 무조건 넣는다." ).append("\n"); 
		query.append("END DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}