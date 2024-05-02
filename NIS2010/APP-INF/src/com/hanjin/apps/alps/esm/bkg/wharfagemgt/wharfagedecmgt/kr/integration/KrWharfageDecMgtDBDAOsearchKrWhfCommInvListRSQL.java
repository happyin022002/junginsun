/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfCommInvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfCommInvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKrWhfCommInvList
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfCommInvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_ntc_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_ntc_dt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfCommInvListRSQL").append("\n"); 
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
		query.append("DISTINCT A.VSL_NM" ).append("\n"); 
		query.append(",A.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO||A.SKD_DIR_CD AS HCNT" ).append("\n"); 
		query.append(",A.CALL_SGN_NO" ).append("\n"); 
		query.append(",A.ARR_YR||'-'||A.ARR_TMS_NO AS ICHCNT" ).append("\n"); 
		query.append(",'1' AS ONGUBUN" ).append("\n"); 
		query.append(",DECODE(A.WHF_BND_CD,'II','1','2') AS WHF_BND_CD " ).append("\n"); 
		query.append(",A.SAIL_DT" ).append("\n"); 
		query.append(",'0' AS BKRCISNOT" ).append("\n"); 
		query.append(",SUBSTR(B.WHF_NTC_NO,7,6) AS WHF_NTC_NO" ).append("\n"); 
		query.append(",MAX(SUBSTR(B.WHF_DECL_NO,15)) AS WHF_DECL_NO" ).append("\n"); 
		query.append(",DECODE(A.WHF_CUST_KND_CD,'U','단수','C','복수') CUST_KIND_CD" ).append("\n"); 
		query.append(",MAX( NVL(A.NTC_AMT,0) )AS NTC_AMT " ).append("\n"); 
		query.append(",A.PAY_DT" ).append("\n"); 
		query.append(",MAX( A.COMM_AMT ) AS COMM_AMT " ).append("\n"); 
		query.append("FROM BKG_KR_WHF_RT B, BKG_KR_WHF_VOL A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${whf_ntc_flg} == 'Y')" ).append("\n"); 
		query.append("AND A.WHF_NTC_DT BETWEEN @[whf_ntc_dt1] AND @[whf_ntc_dt2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.WHF_PAY_DT BETWEEN @[whf_ntc_dt1] AND @[whf_ntc_dt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- AS-IS 최신 변경 사항 반영 - 20091014 - DJMIN" ).append("\n"); 
		query.append("-- 단수, 복수 상관없이 전체를 조회 - 20090910 - YCKIM" ).append("\n"); 
		query.append("--AND NVL(A.WHF_CUST_KND_CD,'C') = 'C'" ).append("\n"); 
		query.append("AND A.VSL_CD        = B.VSL_CD " ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = B.SKD_VOY_NO " ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_NM     LIKE  " ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("                            WHEN NVL(@[port_nm],'A') = '신항' OR NVL(@[port_nm],'A') = '북항' OR NVL(@[port_nm],'A') = '감천항' THEN @[port_nm]||'%'" ).append("\n"); 
		query.append("                            WHEN NVL(@[port_nm],'A') = 'A' THEN A.PORT_NM" ).append("\n"); 
		query.append("                            ELSE A.PORT_NM" ).append("\n"); 
		query.append("                        END                            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.PORT_CD     = DECODE(NVL(@[port_cd],'A') , 'A' ,A.PORT_CD ,@[port_cd] ) --'KRPUS'" ).append("\n"); 
		query.append("AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd],'O','OO','II'),DECODE(@[whf_bnd_cd],'I','II','OO'))" ).append("\n"); 
		query.append("AND B.PORT_CD     = DECODE(NVL(@[port_cd],'A') , 'A' ,A.PORT_CD ,@[port_cd] ) --'KRPUS'" ).append("\n"); 
		query.append("AND B.WHF_NTC_NO IS NOT NULL" ).append("\n"); 
		query.append("AND A.WHF_BND_CD  = B.WHF_BND_CD      " ).append("\n"); 
		query.append("AND (B.WHF_BND_CD, B.CHG_RT_SEQ)      = (" ).append("\n"); 
		query.append("          SELECT D.WHF_BND_CD, MAX(D.CHG_RT_SEQ)" ).append("\n"); 
		query.append("          FROM BKG_KR_WHF_RT D, BKG_KR_WHF_BL BL" ).append("\n"); 
		query.append("          WHERE D.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("          AND D.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("          AND D.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND D.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND D.BL_NO       = BL.BL_NO" ).append("\n"); 
		query.append("          AND D.VSL_CD      = BL.VSL_CD" ).append("\n"); 
		query.append("          AND D.SKD_VOY_NO  = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND D.SKD_DIR_CD  = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND D.WHF_BND_CD  = BL.WHF_BND_CD" ).append("\n"); 
		query.append("          AND D.PORT_CD     = DECODE(SUBSTR(BL.WHF_BND_CD,1,1),'I',BL.WHF_POD_CD,BL.WHF_POL_CD) " ).append("\n"); 
		query.append("          AND D.PORT_CD     = DECODE(NVL(@[port_cd],'A') , 'A' ,A.PORT_CD ,@[port_cd] )--'KRPUS'" ).append("\n"); 
		query.append("          AND D.WHF_BND_CD IN (DECODE(@[whf_bnd_cd],'O','OO','II'),DECODE(@[whf_bnd_cd],'I','II','OO'))" ).append("\n"); 
		query.append("          AND D.WHF_NTC_NO IS NOT NULL" ).append("\n"); 
		query.append("          AND BL.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("          GROUP BY D.WHF_BND_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("GROUP BY A.VSL_NM,A.VSL_CD,A.SKD_VOY_NO||A.SKD_DIR_CD, " ).append("\n"); 
		query.append("         A.CALL_SGN_NO, A.ARR_YR||'-'||A.ARR_TMS_NO, " ).append("\n"); 
		query.append("   DECODE(A.WHF_BND_CD,'II','1','2'), A.SAIL_DT," ).append("\n"); 
		query.append("   SUBSTR(B.WHF_NTC_NO,7,6),  A.WHF_CUST_KND_CD,A.PAY_DT" ).append("\n"); 
		query.append("-- AS-IS 최신 변경 사항 반영 - 20091014 - DJMIN" ).append("\n"); 
		query.append("-- 납부금액이 '0' 이상만 조회도록 함. - 20090910 - YCKIM" ).append("\n"); 
		query.append("HAVING MAX( NVL(A.NTC_AMT,0) ) > 0" ).append("\n"); 
		query.append("ORDER BY 1, 2" ).append("\n"); 

	}
}