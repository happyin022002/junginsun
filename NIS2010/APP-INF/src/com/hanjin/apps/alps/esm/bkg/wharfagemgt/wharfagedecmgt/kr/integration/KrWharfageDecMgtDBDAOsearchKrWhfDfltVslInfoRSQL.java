/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDfltVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15 
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

public class KrWharfageDecMgtDBDAOsearchKrWhfDfltVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKrWhfDfltVslInfo
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDfltVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDfltVslInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.MRN_NO || A.MRN_CHK_NO AS MRN_NO," ).append("\n"); 
		query.append("    A.KR_VSL_CALL_SGN_CD AS VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("    A.DCHG_MZD_CD AS UNLD_TP_CD," ).append("\n"); 
		query.append("    TRIM(TO_CHAR(A.CALL_KNT,'000')) AS ARR_TMS_NO," ).append("\n"); 
		query.append("    TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'),'9999') AS ARR_YR," ).append("\n"); 
		query.append("    A.IO_TML_LOC_CD AS IO_PORT_CD," ).append("\n"); 
		query.append("    C.BRTH_KR_NM AS PORT_NM,A.VSL_NM" ).append("\n"); 
		query.append("    ,SUBSTR(D.ATTR_CTNT2,1,2) UNLD_AGN_CD1" ).append("\n"); 
		query.append("    ,SUBSTR(D.ATTR_CTNT2,3,1) UNLD_AGN_CD2" ).append("\n"); 
		query.append("    ,SUBSTR(D.ATTR_CTNT2,4,4) UNLD_AGN_CD3" ).append("\n"); 
		query.append("    ,DECODE(SUBSTR(@[io_bnd_cd], 1, 1), 'O', DECODE(A.PORT_CD, 'KRPUS', ATTR_CTNT3, ATTR_CTNT4), ATTR_CTNT3) AS WHF_RT" ).append("\n"); 
		query.append("    ,ATTR_CTNT5 AS TML_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY A, ( SELECT " ).append("\n"); 
		query.append("  MRN_NO, " ).append("\n"); 
		query.append("  MRN_CHK_NO,  " ).append("\n"); 
		query.append("  VSL_CD,   " ).append("\n"); 
		query.append("  SKD_VOY_NO, " ).append("\n"); 
		query.append("  SKD_DIR_CD, " ).append("\n"); 
		query.append("  IO_BND_CD, " ).append("\n"); 
		query.append("  PORT_CD, " ).append("\n"); 
		query.append("  OB_DECL_TP_CD," ).append("\n"); 
		query.append("  MAX(VVD_SEQ) AS SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND VSL_CD     = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("  AND SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("  AND IO_BND_CD  = SUBSTR( @[io_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("  AND PORT_CD    = @[vps_port_cd]" ).append("\n"); 
		query.append("  GROUP BY MRN_NO, MRN_CHK_NO, VSL_CD,SKD_VOY_NO," ).append("\n"); 
		query.append("         SKD_DIR_CD, IO_BND_CD, PORT_CD, OB_DECL_TP_CD )B, BKG_KR_WHF_BRTH C, BKG_HRD_CDG_CTNT D" ).append("\n"); 
		query.append("WHERE A.VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND A.IO_BND_CD     = SUBSTR( @[io_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')  " ).append("\n"); 
		query.append("AND A.PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.PORT_CD       = B.PORT_CD " ).append("\n"); 
		query.append("AND A.MRN_CHK_NO    = B.MRN_CHK_NO" ).append("\n"); 
		query.append("AND A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD     = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.OB_DECL_TP_CD = B.OB_DECL_TP_CD" ).append("\n"); 
		query.append("AND A.VVD_SEQ       = B.SEQ" ).append("\n"); 
		query.append("AND A.PORT_CD       = C.PORT_CD(+)" ).append("\n"); 
		query.append("AND A.IO_TML_LOC_CD = C.BRTH_CD" ).append("\n"); 
		query.append("AND D.HRD_CDG_ID(+)    = 'KR_WHF_VSL_INFO'" ).append("\n"); 
		query.append("AND D.ATTR_CTNT1(+)    = A.PORT_CD" ).append("\n"); 
		query.append("ORDER BY  A.MF_SND_DT DESC NULLS LAST" ).append("\n"); 

	}
}