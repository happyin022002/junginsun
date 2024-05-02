/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCManageDBDAOSearchStepUpDownVvdMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2016.02.02 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchStepUpDownVvdMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0032 화면의 Master Data 조회 쿼리
	  * 2014.04.28 김시몬 [CHM-201429944] MONTH 조회시 SLS_YRMON으로 조회되도록
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOSearchStepUpDownVvdMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdocode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobcarrier",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchStepUpDownVvdMasterListRSQL").append("\n"); 
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
		query.append("nvl(B.MNL_FLG,'N') MNL_FLG ," ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  SUBSTR(A.SLS_YRMON, 1, 4) || A.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  SUBSTR(A.SLS_YRMON, 1, 4) || A.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("      A.SUB_TRD_CD," ).append("\n"); 
		query.append("      A.SLAN_CD ," ).append("\n"); 
		query.append("      B.TRD_CD," ).append("\n"); 
		query.append("      B.RLANE_CD," ).append("\n"); 
		query.append("      B.VSL_CD," ).append("\n"); 
		query.append("      B.SKD_VOY_NO," ).append("\n"); 
		query.append("      B.SKD_DIR_CD," ).append("\n"); 
		query.append("      B.BSA_OP_CD ," ).append("\n"); 
		query.append("      DECODE(B.BSA_OP_CD, 'J', 'J/O', 'S', 'S/C', B.BSA_OP_CD) AS BSA_OP_NM ," ).append("\n"); 
		query.append("      B.IOC_CD," ).append("\n"); 
		query.append("      B.VOP_CD," ).append("\n"); 
		query.append("      B.VSL_CAPA," ).append("\n"); 
		query.append("      B.BSA_CAPA," ).append("\n"); 
		query.append("      C.PORT_BSA_CAPA ," ).append("\n"); 
		query.append("      C.CRR_CD," ).append("\n"); 
		query.append("      C.BSA_OP_JB_CD," ).append("\n"); 
		query.append("      DECODE(D.STUP_FLG, 'Y', '1', '0') STUP_FLG," ).append("\n"); 
		query.append("      DECODE(B.PORT_BSA_CFM_FLG, 'Y', '1', '0') PORT_BSA_CFM_FLG" ).append("\n"); 
		query.append("FROM MAS_MON_VVD A ," ).append("\n"); 
		query.append("      BSA_VVD_MST B ," ).append("\n"); 
		query.append("      BSA_VVD_PORT_DWN C ," ).append("\n"); 
		query.append("      MAS_LANE_RGST D" ).append("\n"); 
		query.append("WHERE A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.DIR_CD      = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND B.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("  AND B.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("  AND B.VSL_CD      = C.VSL_CD" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO  = C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD  = C.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD      = D.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD    = D.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD      = D.DIR_CD" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND NVL(D.STUP_FLG, 'N') = 'Y' " ).append("\n"); 
		query.append("  AND NVL(D.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("  AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("  AND A.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("  AND A.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("  AND A.DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobioc} != '')" ).append("\n"); 
		query.append("  AND A.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  AND C.CRR_CD        = @[cobcarrier]" ).append("\n"); 
		query.append("  AND C.BSA_OP_JB_CD  = @[rdocode]" ).append("\n"); 
		query.append("  AND C.PORT_SEQ      = 999" ).append("\n"); 
		query.append("  AND C.PORT_CD       = 'XXXXX'" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  SUBSTR(A.SLS_YRMON, 1, 4) || A.COST_WK ," ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  SUBSTR(A.SLS_YRMON, 1, 4) || A.COST_WK ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("	  A.SUB_TRD_CD," ).append("\n"); 
		query.append("      A.SLAN_CD ," ).append("\n"); 
		query.append("      B.TRD_CD," ).append("\n"); 
		query.append("      B.RLANE_CD,     " ).append("\n"); 
		query.append("      B.SKD_DIR_CD," ).append("\n"); 
		query.append("      B.BSA_OP_CD" ).append("\n"); 

	}
}