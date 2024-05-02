/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAORevYrmonSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.06.28 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAORevYrmonSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rev Yrmon Seq 조회
	  * </pre>
	  */
	public SettlementProcessDBDAORevYrmonSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revYrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAORevYrmonSeqRSQL").append("\n"); 
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
		query.append("MAX(A.REV_YRMON_SEQ)+1 AS REV_YRMON_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT NVL(MAX(REV_YRMON_SEQ),0) REV_YRMON_SEQ" ).append("\n"); 
		query.append("    FROM JOO_LODG_TGT X " ).append("\n"); 
		query.append("    WHERE X.REV_YRMON = @[revYrmon]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT NVL(MAX(REV_YRMON_SEQ),0) REV_YRMON_SEQ" ).append("\n"); 
		query.append("    FROM JOO_SLT_TGT X" ).append("\n"); 
		query.append("    WHERE X.REV_YRMON = @[revYrmon]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT NVL(MAX(REV_YRMON_SEQ),0) REV_YRMON_SEQ" ).append("\n"); 
		query.append("    FROM JOO_STL_TGT X " ).append("\n"); 
		query.append("    WHERE X.REV_YRMON = @[revYrmon]" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}