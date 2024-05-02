/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOPairPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOPairPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PairPort
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOPairPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOPairPortRSQL").append("\n"); 
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
		query.append("#if (${name} == 'C')" ).append("\n"); 
		query.append("--Cycle인 경우 Basic Port가 없을 수 있으므로 Basic Port는 걸지 않는다." ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       DISTINCT" ).append("\n"); 
		query.append("       B.VPS_PORT_CD AS CODE," ).append("\n"); 
		query.append("       TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MISS')||','||TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS NAME," ).append("\n"); 
		query.append("       B.CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE  B.SLAN_CD      = SUBSTR(@[super_cd1],1,3)" ).append("\n"); 
		query.append("AND    B.VSL_CD       = SUBSTR(@[super_cd2],1,4)" ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO   = SUBSTR(@[super_cd2],5,4)" ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD   = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("AND    B.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND    NVL(B.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("ORDER  BY B.CLPT_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       DISTINCT" ).append("\n"); 
		query.append("       A.PORT_CD AS CODE," ).append("\n"); 
		query.append("       TO_CHAR(B.VPS_ETA_DT,'YYYYMMDDHH24MISS')||','||TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS NAME," ).append("\n"); 
		query.append("       B.CLPT_SEQ" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		       N1ST_STL_PAIR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("		FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("		WHERE  A.JO_CRR_CD  = @[code]" ).append("\n"); 
		query.append("		AND    A.RLANE_CD   = @[super_cd1]" ).append("\n"); 
		query.append("#if (${name} == 'R')" ).append("\n"); 
		query.append("--2010.03.15 Round이면 basic port에 east bound밖에 없으므로..." ).append("\n"); 
		query.append("--2010.04.08 Round이면 한 건만 입력되므로 가져오게 한다. (EAST 만 넣는게 아니라 NEWS 한 건만 넣는다.)" ).append("\n"); 
		query.append("--		AND    A.SKD_DIR_CD = 'E'" ).append("\n"); 
		query.append("		AND    ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND    A.SKD_DIR_CD = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		       N2ND_STL_PAIR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("		FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("		WHERE  A.JO_CRR_CD  = @[code]" ).append("\n"); 
		query.append("		AND    A.RLANE_CD   = @[super_cd1]" ).append("\n"); 
		query.append("#if (${name} == 'R')" ).append("\n"); 
		query.append("--2010.03.15 Round이면 basic port에 east bound밖에 없으므로..." ).append("\n"); 
		query.append("--2010.04.08 Round이면 한 건만 입력되므로 가져오게 한다. (EAST 만 넣는게 아니라 NEWS 한 건만 넣는다.)" ).append("\n"); 
		query.append("--		AND    A.SKD_DIR_CD = 'E'" ).append("\n"); 
		query.append("		AND    ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND    A.SKD_DIR_CD = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND    A.N2ND_STL_PAIR_PORT_CD  IS NOT NULL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		       N3RD_STL_PAIR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("		FROM   JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("		WHERE  A.JO_CRR_CD  = @[code]" ).append("\n"); 
		query.append("		AND    A.RLANE_CD   = @[super_cd1]" ).append("\n"); 
		query.append("#if (${name} == 'R')" ).append("\n"); 
		query.append("--2010.03.15 Round이면 basic port에 east bound밖에 없으므로..." ).append("\n"); 
		query.append("--2010.04.08 Round이면 한 건만 입력되므로 가져오게 한다. (EAST 만 넣는게 아니라 NEWS 한 건만 넣는다.)" ).append("\n"); 
		query.append("--		AND    A.SKD_DIR_CD = 'E'" ).append("\n"); 
		query.append("		AND    ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND    A.SKD_DIR_CD = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND    A.N3RD_STL_PAIR_PORT_CD  IS NOT NULL" ).append("\n"); 
		query.append("		) A," ).append("\n"); 
		query.append("		VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE  A.PORT_CD         = B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND    B.SLAN_CD     (+) = SUBSTR(@[super_cd1],1,3)" ).append("\n"); 
		query.append("AND    B.VSL_CD      (+) = SUBSTR(@[super_cd2],1,4)" ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO  (+) = SUBSTR(@[super_cd2],5,4)" ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD  (+) = SUBSTR(@[super_cd2],9,1)" ).append("\n"); 
		query.append("AND    B.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND    NVL(B.SKD_CNG_STS_CD(+),'N') <> 'S'" ).append("\n"); 
		query.append("ORDER  BY B.CLPT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}