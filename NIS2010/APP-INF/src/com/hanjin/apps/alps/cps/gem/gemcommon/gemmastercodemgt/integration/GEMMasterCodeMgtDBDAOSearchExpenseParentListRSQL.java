/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseParentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.22 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseParentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용코드의 Group Level[1st, 2nd, 3rd, Final]에 해당하는 Parent Code 리스트 조회
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseParentListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_grp_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT   GEN_EXPN_CD" ).append("\n"); 
		query.append(",ENG_ABBR_NM" ).append("\n"); 
		query.append(",KRN_ABBR_NM" ).append("\n"); 
		query.append("FROM     GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE    GEN_EXPN_GRP_LVL = @[gen_expn_grp_lvl]" ).append("\n"); 
		query.append("AND      DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY GEN_EXPN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseParentListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}