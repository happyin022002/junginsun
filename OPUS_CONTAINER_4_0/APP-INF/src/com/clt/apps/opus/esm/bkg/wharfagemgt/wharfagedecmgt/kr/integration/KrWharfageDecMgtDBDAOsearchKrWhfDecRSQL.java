/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecRSQL").append("\n"); 
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
		query.append("SELECT BB.WHF_DECL_NO," ).append("\n"); 
		query.append("NVL(SUBSTR(BB.WHF_NTC_NO, 1, 4), TO_CHAR(SYSDATE, 'YYYY')) AS WHF_NTC_NO_YR," ).append("\n"); 
		query.append("SUBSTR(BB.WHF_NTC_NO, 5, 2) AS WHF_NTC_NO_MON," ).append("\n"); 
		query.append("SUBSTR(BB.WHF_NTC_NO, 7, 6) AS WHF_NTC_NO_SEQ," ).append("\n"); 
		query.append("BB.CSR_NO" ).append("\n"); 
		query.append("FROM (SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO, MAX(B.CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B, BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', A.WHF_POL_CD, A.WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND A.WHF_BL_STS_CD != 'D'" ).append("\n"); 
		query.append("AND A.WHF_BND_CD = DECODE(@[whf_bnd_cd], 'IN', 'II', @[whf_bnd_cd])" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("AND C.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("AND C.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD, B.BL_NO) AA, BKG_KR_WHF_RT BB" ).append("\n"); 
		query.append("WHERE BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BB.WHF_BND_CD = AA.WHF_BND_CD" ).append("\n"); 
		query.append("AND BB.BL_NO = AA.BL_NO" ).append("\n"); 
		query.append("AND BB.CHG_RT_SEQ = AA.CHG_RT_SEQ" ).append("\n"); 
		query.append("AND (BB.WHF_DECL_NO IS NOT NULL OR BB.WHF_NTC_NO IS NOT NULL)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}