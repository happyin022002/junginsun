/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationGuidelineDBDAORsltPriSgGrpLocDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.01 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationGuidelineDBDAORsltPriSgGrpLocDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GroupLocation Detail 조회
	  * </pre>
	  */
	public SCGroupLocationGuidelineDBDAORsltPriSgGrpLocDtlVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.GLINE_SEQ" ).append("\n"); 
		query.append(",A.GRP_LOC_SEQ" ).append("\n"); 
		query.append(",A.GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",B.LOC_NM" ).append("\n"); 
		query.append(",B.SCONTI_CD" ).append("\n"); 
		query.append(",(SELECT SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS SCONTI_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_LOC_DTL A, MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ = @[grp_loc_seq]" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.integration").append("\n"); 
		query.append("FileName : SCGroupLocationGuidelineDBDAORsltPriSgGrpLocDtlVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}