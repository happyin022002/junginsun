/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecChkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.10.19 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecChkListRSQL(){
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
		params.put("e_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ixport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecChkListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("DECODE(SUBSTR(AA.WHF_BND_CD, 0, 1), 'O', '수출', 'I', '수입') GUBUN," ).append("\n"); 
		query.append("AA.VSL_CD || AA.SKD_VOY_NO || AA.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("AA.PORT_CD," ).append("\n"); 
		query.append("AA.MF_REF_NO," ).append("\n"); 
		query.append("AA.SAIL_DT," ).append("\n"); 
		query.append("AA.WHF_NTC_DT," ).append("\n"); 
		query.append("BB.WHF_NTC_NO," ).append("\n"); 
		query.append("BB.WHF_DECL_NO," ).append("\n"); 
		query.append("AA.NTC_AMT," ).append("\n"); 
		query.append("AA.WHF_USR_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.PORT_CD, A.MF_REF_NO, A.SAIL_DT, A.WHF_NTC_DT, A.NTC_AMT, A.WHF_USR_NM," ).append("\n"); 
		query.append("C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.WHF_BND_CD, C.BL_NO, MAX(C.CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_VOL A, BKG_KR_WHF_BL B, BKG_KR_WHF_RT C, VSK_VSL_SKD D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ixport} != '')" ).append("\n"); 
		query.append("AND A.WHF_BND_CD LIKE @[ixport] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.SAIL_DT >= REPLACE(@[s_date], '-', '')" ).append("\n"); 
		query.append("AND A.SAIL_DT <= REPLACE(@[e_date], '-', '')" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("AND C.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.WHF_BND_CD = B.WHF_BND_CD" ).append("\n"); 
		query.append("AND C.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND D.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.PORT_CD, A.MF_REF_NO, A.SAIL_DT, A.WHF_NTC_DT, A.NTC_AMT, A.WHF_USR_NM," ).append("\n"); 
		query.append("C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.WHF_BND_CD, C.BL_NO) AA," ).append("\n"); 
		query.append("BKG_KR_WHF_RT BB" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BB.WHF_BND_CD = AA.WHF_BND_CD" ).append("\n"); 
		query.append("AND BB.BL_NO = AA.BL_NO" ).append("\n"); 
		query.append("AND BB.CHG_RT_SEQ = AA.CHG_RT_SEQ" ).append("\n"); 

	}
}