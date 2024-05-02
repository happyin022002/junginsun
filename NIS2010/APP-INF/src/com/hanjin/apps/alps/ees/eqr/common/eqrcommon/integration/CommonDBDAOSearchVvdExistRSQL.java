/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVvdExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.10 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVvdExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, lane 정보를 검색(execute plan INLAND WATER(080) 에서 사용)
	  * </pre>
	  */
	public CommonDBDAOSearchVvdExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVvdExistRSQL").append("\n"); 
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
		query.append("#if(${division} == 'etd')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VVD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",B.VSL_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--	    SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("--			          ,SLAN_CD" ).append("\n"); 
		query.append("--			          ,TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD', 'NLS_DATE_LANGUAGE=AMERICAN')  VSL_DT  --VSL_ETD_DT" ).append("\n"); 
		query.append("--			    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("--			    WHERE VSL_CD     = ?" ).append("\n"); 
		query.append("--			    AND   SKD_VOY_NO = ?" ).append("\n"); 
		query.append("--			    AND   SKD_DIR_CD = ?" ).append("\n"); 
		query.append("--			    AND   VPS_PORT_CD= ?" ).append("\n"); 
		query.append("--			    AND   TO_CHAR(VPS_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = ? )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.VPS_ETD_DT, 'YYYY-MM-DD')  VSL_DT  --VPS_ETD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",VPS_ETD_DT" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   VPS_PORT_CD= @[ecc_cd]" ).append("\n"); 
		query.append("-- modified by shin yongchan - 20080326" ).append("\n"); 
		query.append("-- plan year week 안에 들어오는 ETD만 검색하는 방식으로 변경" ).append("\n"); 
		query.append("-- CSR NO : N200803260007" ).append("\n"); 
		query.append("--	    AND   TO_CHAR(VPS_ETD_DT ,'YYYYMMDD') >= (SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = ? )" ).append("\n"); 
		query.append("AND   TO_CHAR(VPS_ETD_DT ,'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN (" ).append("\n"); 
		query.append("SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND 	(" ).append("\n"); 
		query.append("SELECT WK_END_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[pln_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ROWNUM=1" ).append("\n"); 
		query.append("ORDER BY A.CLPT_IND_SEQ DESC" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.VVD = B.VVD(+)" ).append("\n"); 
		query.append("AND   A.SLAN_CD = B.SLAN_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else  -- eta (단 1개만 조회되어야 함)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.VPS_ETA_DT, 'YYYY-MM-DD')  VSL_DT  --VSL_ETA_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",VPS_ETA_DT" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   VPS_PORT_CD= @[ecc_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(VPS_ETA_DT ,'YYYYMMDD') >= TO_CHAR(TO_DATE( @[pln_yrwk] , 'YYYY-MM-DD') ,'YYYYMMDD')" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 
		query.append("-- modified by shin yongchan - 20080327" ).append("\n"); 
		query.append("-- CLPT_IND_SEQ 가장 작은것 부터 ETA로 취급하는것으로 변경" ).append("\n"); 
		query.append("-- DESC ==>ASC" ).append("\n"); 
		query.append("-- CSR NO : N200803260007" ).append("\n"); 
		query.append("--ORDER BY A.CLPT_IND_SEQ DESC" ).append("\n"); 
		query.append("ORDER BY A.CLPT_IND_SEQ ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}