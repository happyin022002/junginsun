/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * 2012.06.01 : 김상근[CHM-201218057-01]
	  * Discription : Key 생성규칙변경(OFC+수입/비용 구분+TRADE+REV LANE+Direction(추가)+년월+일련번호(3자리)
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL").append("\n"); 
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
		query.append("SELECT JO_REF_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT JO_REF_NO, ROW_NUMBER() OVER (ORDER BY PRIORITY) RN" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT /*+INDEX_DESC(A XPKJOO_BZC_AGMT)*/" ).append("\n"); 
		query.append("                       1 AS PRIORITY," ).append("\n"); 
		query.append("                       @[ofc_cd]||'-'||@[re_divr_cd]||'-'||@[trd_cd]||'-'||@[rlane_cd]||'-'||@[skd_dir_cd]||'-'||TO_CHAR(SYSDATE,'RRMM')||'-'||LPAD(TO_NUMBER(SUBSTR(JO_REF_NO,-3))+1,3,'0') JO_REF_NO" ).append("\n"); 
		query.append("                  FROM JOO_BZC_AGMT A" ).append("\n"); 
		query.append("                 WHERE JO_REF_NO LIKE @[ofc_cd]||'-'||@[re_divr_cd]||'-'||@[trd_cd]||'-'||@[rlane_cd]||'-'||@[skd_dir_cd]||'-'||TO_CHAR(SYSDATE,'RRMM')||'-'||'%'" ).append("\n"); 
		query.append("                   AND ROWNUM    = 1" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                       2 AS PRIORITY," ).append("\n"); 
		query.append("                       @[ofc_cd]||'-'||@[re_divr_cd]||'-'||@[trd_cd]||'-'||@[rlane_cd]||'-'||@[skd_dir_cd]||'-'||TO_CHAR(SYSDATE,'RRMM')||'-'||'001' JO_REF_NO" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE  RN = 1" ).append("\n"); 

	}
}