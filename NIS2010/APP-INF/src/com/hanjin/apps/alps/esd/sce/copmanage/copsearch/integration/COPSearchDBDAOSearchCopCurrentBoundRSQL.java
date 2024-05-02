/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOSearchCopCurrentBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.12.03 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchCopCurrentBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopCurrentBound
	  * </pre>
	  */
	public COPSearchDBDAOSearchCopCurrentBoundRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchCopCurrentBoundRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MAX(BND_SEQ),1,'O',2,'I','I') BND_CD FROM (" ).append("\n"); 
		query.append("--MVMT BOUND" ).append("\n"); 
		query.append("SELECT MIN (BND_SEQ)BND_SEQ FROM (" ).append("\n"); 
		query.append("SELECT CASE WHEN H.COP_SUB_STS_CD ='R'THEN 1" ).append("\n"); 
		query.append("WHEN D.COP_DTL_SEQ < 4000 THEN 1" ).append("\n"); 
		query.append("ELSE 2" ).append("\n"); 
		query.append("END BND_SEQ  --1 OB 2 IB" ).append("\n"); 
		query.append("FROM SCE_COP_DTL D , SCE_COP_HDR H" ).append("\n"); 
		query.append("WHERE D.COP_NO =  @[e_cop_no]" ).append("\n"); 
		query.append("AND D.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("and ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM sce_cop_hdr h" ).append("\n"); 
		query.append("WHERE H.COP_NO =  @[e_cop_no]" ).append("\n"); 
		query.append("AND H.COP_SUB_STS_CD = 'R'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--SO BOUND" ).append("\n"); 
		query.append("SELECT MAX(BND_SEQ)BND_SEQ FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT decode(TRSP_BND_CD,'O',1,2)BND_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD WHERE COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT decode(TRSP_BND_CD,'O',1,2)BND_SEQ" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord WHERE COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}