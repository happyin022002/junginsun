/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCsInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.09 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchCsInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다중 Customer 네임을 구해온다.
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCsInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCsInfoListRSQL").append("\n"); 
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
		query.append("select cs_grp_id" ).append("\n"); 
		query.append(", tp_id" ).append("\n"); 
		query.append(", cs_desc" ).append("\n"); 
		query.append(", substr(MAX (SYS_CONNECT_BY_PATH (stnd_cd, ',')), 2) edi_sts" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.cs_grp_id, A.tp_id, A.cs_desc, A.stnd_cd, ROWNUM RNUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select  /*+ ordered use_nl( grp cgo STS) */" ).append("\n"); 
		query.append("DISTINCT grp.edi_grp_cd cs_grp_id" ).append("\n"); 
		query.append(", grp.cust_trd_prnr_id tp_id" ).append("\n"); 
		query.append(", grp.edi_grp_desc cs_desc" ).append("\n"); 
		query.append(", cgo.edi_stnd_sts_cd  stnd_cd" ).append("\n"); 
		query.append(", STS.EDI_STS_SEQ" ).append("\n"); 
		query.append("from edi_group grp, edi_grp_cgo cgo, EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where grp.edi_grp_cd IN (${convert_group_id})" ).append("\n"); 
		query.append("and grp.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("AND grp.co_div_cd = cgo.co_div_cd" ).append("\n"); 
		query.append("AND STS.EDI_STND_STS_CD = cgo.EDI_STND_STS_CD" ).append("\n"); 
		query.append("ORDER BY    STS.EDI_STS_SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH rnum = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR rnum = rnum - 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by cs_grp_id" ).append("\n"); 
		query.append(", tp_id" ).append("\n"); 
		query.append(", cs_desc" ).append("\n"); 

	}
}