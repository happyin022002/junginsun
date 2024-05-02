/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgDpcsSearchPointListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgDpcsSearchPointListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOBkgDpcsSearchPointListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgDpcsSearchPointListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("border",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgDpcsSearchPointListRSQL").append("\n"); 
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
		query.append("SELECT                                                   " ).append("\n"); 
		query.append("ATTR_CTNT1   as doc_group        " ).append("\n"); 
		query.append(",BKG_COM_INTG_CD_NM_FNC('CD02100',ATTR_CTNT1 ) AS doc_group_desc" ).append("\n"); 
		query.append(",ATTR_CTNT2  as sr_kind     " ).append("\n"); 
		query.append(",BKG_COM_INTG_CD_NM_FNC('CD01581',ATTR_CTNT2) AS sr_kind_desc  " ).append("\n"); 
		query.append(",ATTR_CTNT3  as src            " ).append("\n"); 
		query.append(",decode(BKG_COM_INTG_CD_NM_FNC('CD01577',ATTR_CTNT3),'',decode(ATTR_CTNT3, 'H','H/BL','R','Rider','M','C/M','N','CNTR','S','S/C','X','TAA','F','RFA','D','Self Audit','P','Pre Audit'), BKG_COM_INTG_CD_NM_FNC('CD01577',ATTR_CTNT3) ) AS src_desc                                " ).append("\n"); 
		query.append(",ATTR_CTNT4  as border                                          " ).append("\n"); 
		query.append(",ATTR_CTNT5  as point     " ).append("\n"); 
		query.append(",ATTR_CTNT6  as remark  " ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT        " ).append("\n"); 
		query.append(",hrd_cdg_id        " ).append("\n"); 
		query.append(",hrd_cdg_id_seq" ).append("\n"); 
		query.append("FROM  BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("where HRD_CDG_ID like 'DPCS_RPT_WGT'" ).append("\n"); 
		query.append("and ATTR_CTNT1 = decode(@[doc_group],'All',ATTR_CTNT1,@[doc_group])" ).append("\n"); 
		query.append("and ATTR_CTNT2 = decode(@[sr_kind],'All',ATTR_CTNT2,@[sr_kind])" ).append("\n"); 
		query.append("and ATTR_CTNT3 = decode(@[src],'L',ATTR_CTNT3,@[src])" ).append("\n"); 
		query.append("and ATTR_CTNT4 = nvl(@[border],ATTR_CTNT4)" ).append("\n"); 

	}
}