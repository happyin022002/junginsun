/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetRailTermRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.08 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetRailTermRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetRailTerm
	  * </pre>
	  */
	public Edi315SendDBDAOGetRailTermRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetRailTermRSQL").append("\n"); 
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
		query.append("SELECT SUM(rail_cnt) AS rail_cnt, SUM(oan_term_seq) AS oan_term_seq" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT COUNT(*) rail_cnt, 0 as oan_term_seq" ).append("\n"); 
		query.append("FROM sce_cop_dtl a, sce_cop_hdr b" ).append("\n"); 
		query.append("WHERE a.cop_no = b.cop_no" ).append("\n"); 
		query.append("AND b.cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND cop_dtl_seq>6000" ).append("\n"); 
		query.append("AND act_cd LIKE '__R%'" ).append("\n"); 
		query.append("AND (pod_nod_cd LIKE 'US%' OR pod_nod_cd LIKE 'CA%')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 0 AS rail_cnt, COP_DTL_SEQ AS oan_term_seq" ).append("\n"); 
		query.append("FROM sce_cop_dtl" ).append("\n"); 
		query.append("WHERE cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND cop_dtl_seq>6000" ).append("\n"); 
		query.append("AND stnd_edi_sts_cd = 'OAN'" ).append("\n"); 
		query.append("AND ACT_STS_MAPG_CD = 'ID'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}