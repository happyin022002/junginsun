/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.12.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP I/F Inquiry  조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX(A XPKTOT_ERP_IF)*/" ).append("\n"); 
		query.append("VSL_CD                     VSL_CD" ).append("\n"); 
		query.append(", MAX(NRT_WGT)               NRT_WGT" ).append("\n"); 
		query.append(", DECODE(MAX(PER_TON_REV)*SUM(VOY_DYS) ,0,0,TRUNC((SUM(TONG_TAX_AMT)/(MAX(PER_TON_REV)*SUM(VOY_DYS)))*100,2)) USE" ).append("\n"); 
		query.append(", SUM(VOY_DYS)               VOY_DYS" ).append("\n"); 
		query.append(", SUM(TONG_TAX_AMT)          TONG_TAX_AMT" ).append("\n"); 
		query.append(", MAX(TONG_FLET_TP_CD)       TONG_FLET_TP_CD" ).append("\n"); 
		query.append(", MAX(CTRT_DYS)              CTRT_DYS" ).append("\n"); 
		query.append("FROM TOT_ERP_IF A" ).append("\n"); 
		query.append("WHERE  A.STL_YRMON BETWEEN @[s_stl_yrmon] and @[e_stl_yrmon]" ).append("\n"); 
		query.append("AND    A.BAT_JB_SEQ = (" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(X XPKTOT_ERP_IF)*/" ).append("\n"); 
		query.append("X.BAT_JB_SEQ" ).append("\n"); 
		query.append("FROM TOT_ERP_IF X" ).append("\n"); 
		query.append("WHERE X.STL_YRMON = A.STL_YRMON" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VSL_CD,STL_YRMON, BAT_JB_SEQ" ).append("\n"); 

	}
}