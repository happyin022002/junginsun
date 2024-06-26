/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchPriScqBbNewCntrGrpVerNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.08.07 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchPriScqBbNewCntrGrpVerNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_BB_CNTR 에서 신규로 생성된 CNTR_GRP_VER_NO 생성
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchPriScqBbNewCntrGrpVerNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchPriScqBbNewCntrGrpVerNoRSQL").append("\n"); 
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
		query.append("SELECT (NVL((SELECT /*+INDEX_DESC(A XPKPRI_SCQ_BB_CNTR )*/ CNTR_GRP_VER_NO" ).append("\n"); 
		query.append("               FROM PRI_SCQ_BB_CNTR A" ).append("\n"); 
		query.append("              WHERE A.SCQ_RQST_NO     = @[scq_rqst_no]" ).append("\n"); 
		query.append("                AND A.SCQ_VER_NO      = @[scq_ver_no]" ).append("\n"); 
		query.append("                AND ROWNUM <= 1), 0 ) + 1) AS CNTR_GRP_VER_NO " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}