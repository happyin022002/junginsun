/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 두번째 VVD의 POL-POD(마지막 배 아님)
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondRSQL").append("\n"); 
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
		query.append("SELECT 'U' VSL_PRE_PST_CD  		-- 하드코딩" ).append("\n"); 
		query.append("      ,@[vsl_seq] VSL_SEQ  		-- 미리 조회됨(하드코딩 아님)" ).append("\n"); 
		query.append("      ,@[vsl_cd]  VSL_CD        -- 미리 조회됨(하드코딩 아님)" ).append("\n"); 
		query.append("      ,@[skd_voy_no] SKD_VOY_NO -- 미리 조회됨(하드코딩 아님)" ).append("\n"); 
		query.append("      ,@[skd_dir_cd] SKD_DIR_CD -- 미리 조회됨(하드코딩 아님)" ).append("\n"); 
		query.append("      ,A.YD_CD          POL_YD_CD" ).append("\n"); 
		query.append("      ,A.CLPT_IND_SEQ   POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("      ,B.YD_CD          POD_YD_CD" ).append("\n"); 
		query.append("      ,B.CLPT_IND_SEQ   POD_CLPT_IND_SEQ             " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        -- POL TURNING 구하기" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#if(${check_turn_port} == 'T') -- ORG BKG의 POD 가 TURNING인 경우" ).append("\n"); 
		query.append("        SELECT YD_CD" ).append("\n"); 
		query.append("              ,CLPT_IND_SEQ  " ).append("\n"); 
		query.append("              ,CLPT_SEQ" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("        WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("        AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND    SKD_DIR_CD = @[skd_dir_cd]     " ).append("\n"); 
		query.append("        AND    TURN_PORT_FLG = 'Y'               -- 앞배와 연결되는 조건건" ).append("\n"); 
		query.append("        AND    NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- SKIP 제외 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    CLPT_SEQ = (" ).append("\n"); 
		query.append("                              SELECT A.CLPT_SEQ" ).append("\n"); 
		query.append("                              FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                  ,( -- VL BKG의 POD TURNING PORT 를 다음배에서 찾기." ).append("\n"); 
		query.append("                                       SELECT A.VSL_CD" ).append("\n"); 
		query.append("                                             ,TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                             ,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                             ,YD_CD" ).append("\n"); 
		query.append("                                             ,TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                           ,EQR_CTRL_MTY_BKG_EXE B" ).append("\n"); 
		query.append("                                       WHERE B.MTY_BKG_NO = @[vl_bkg_no]   --VL BKG" ).append("\n"); 
		query.append("                                       AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("                                       AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND A.YD_CD        = B.POD_YD_CD" ).append("\n"); 
		query.append("                                       AND A.CLPT_IND_SEQ = B.POD_CLPT_IND_SEQ    " ).append("\n"); 
		query.append("                                       AND ROWNUM=1   " ).append("\n"); 
		query.append("                                   ) B" ).append("\n"); 
		query.append("                              WHERE A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("                              AND   A.SKD_VOY_NO   = B.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND   A.SKD_DIR_CD   = B.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND   A.YD_CD        = B.YD_CD" ).append("\n"); 
		query.append("                              AND   A.CLPT_IND_SEQ = B.TURN_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                              AND ROWNUM=1 " ).append("\n"); 
		query.append("                                                     " ).append("\n"); 
		query.append("                          ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else   -- ORG BKG의 POD 가 TURNING 아닌 경우            " ).append("\n"); 
		query.append("        SELECT YD_CD" ).append("\n"); 
		query.append("              ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("              ,CLPT_SEQ " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (       " ).append("\n"); 
		query.append("            SELECT YD_CD" ).append("\n"); 
		query.append("                  ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  ,CLPT_SEQ " ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("            WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("            AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND    SKD_DIR_CD = @[skd_dir_cd]   " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND    TURN_PORT_FLG = 'Y'                -- 앞배와 연결되는 조건" ).append("\n"); 
		query.append("            AND    NVL(SKD_CNG_STS_CD, '  ') <> 'S'  -- SKIP 제외              " ).append("\n"); 
		query.append("            ORDER BY CLPT_SEQ DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE ROWNUM=1 -- 가장마지막 PORT 선택" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("        -- POD TURNING 구하기            " ).append("\n"); 
		query.append("        SELECT YD_CD" ).append("\n"); 
		query.append("              ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("              ,CLPT_SEQ " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (       " ).append("\n"); 
		query.append("            SELECT YD_CD" ).append("\n"); 
		query.append("                  ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  ,CLPT_SEQ " ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("            WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("            AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND    SKD_DIR_CD = @[skd_dir_cd]    " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND    TURN_PORT_IND_CD IN ('D', 'V', 'F')-- 뒷배와 연결되는 조건" ).append("\n"); 
		query.append("            AND    NVL(SKD_CNG_STS_CD, '  ') <> 'S'   -- SKIP 제외              " ).append("\n"); 
		query.append("            ORDER BY CLPT_SEQ DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE ROWNUM=1 -- 가장마지막 PORT 선택   " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 

	}
}