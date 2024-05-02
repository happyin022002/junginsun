/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecIfArInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.24 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecIfArInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecIfArInvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecIfArInvRSQL").append("\n"); 
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
		query.append("SELECT AAA.VSL_CD, AAA.SKD_VOY_NO, AAA.SKD_DIR_CD, AAA.BL_NO, AAA.CHG_RT_SEQ, AAA.BKG_NO," ).append("\n"); 
		query.append("SUBSTR(MAX(LPAD(TO_CHAR(CORR_DT, 'YYYYMMDDHH24MISS'), 14, ' ') || CORR_NO), 15) AS CORR_NO," ).append("\n"); 
		query.append("MAX(CORR_DT) AS CORR_DT," ).append("\n"); 
		query.append("'B' AS MAN_DIV_IND," ).append("\n"); 
		query.append("AAA.WHF_BND_CD" ).append("\n"); 
		query.append("FROM (SELECT AA.VSL_CD, AA.SKD_VOY_NO, AA.SKD_DIR_CD, AA.BL_NO, AA.CHG_RT_SEQ, AA.WHF_BND_CD, BB.BKG_NO" ).append("\n"); 
		query.append("FROM (SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO, MAX(B.CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND A.WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', A.WHF_POL_CD, A.WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND NVL(A.WFG_EXPT_CD, ' ') != 'D'" ).append("\n"); 
		query.append("AND NVL(A.WHF_BL_STS_CD, ' ') != 'D'" ).append("\n"); 
		query.append("AND NVL(A.WHF_BL_THRU_TS_FLG, ' ') != 'Y'" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_cD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO) AA," ).append("\n"); 
		query.append("BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE BB.BL_NO = AA.BL_NO) AAA," ).append("\n"); 
		query.append("BKG_CORRECTION BBB" ).append("\n"); 
		query.append("WHERE BBB.BKG_NO(+) = AAA.BKG_NO" ).append("\n"); 
		query.append("GROUP BY AAA.VSL_CD, AAA.SKD_VOY_NO, AAA.SKD_DIR_CD, AAA.BL_NO, AAA.CHG_RT_SEQ, AAA.BKG_NO, AAA.WHF_BND_CD" ).append("\n"); 

	}
}