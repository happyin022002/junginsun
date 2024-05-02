/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchCntrSpecRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.23 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOSearchCntrSpecRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrSpec
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchCntrSpecRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchCntrSpecRSQL").append("\n"); 
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
		query.append("A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(",	A.OWN_CNTR_FLG" ).append("\n"); 
		query.append(",	A.SPEC_YR" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.CNTR_MTRL_CD" ).append("\n"); 
		query.append(",	A.LOD_CAPA" ).append("\n"); 
		query.append(",	A.CNTR_GRS_WGT" ).append("\n"); 
		query.append(",	A.TARE_WGT" ).append("\n"); 
		query.append(",	A.INTER_LEN" ).append("\n"); 
		query.append(",	A.INTER_WDT" ).append("\n"); 
		query.append(",	A.INTER_HGT" ).append("\n"); 
		query.append(",	A.XTER_LEN" ).append("\n"); 
		query.append(",	A.XTER_WDT" ).append("\n"); 
		query.append(",	A.XTER_HGT" ).append("\n"); 
		query.append(",	A.OPN_DOR_WDT" ).append("\n"); 
		query.append(",	A.OPN_DOR_HGT" ).append("\n"); 
		query.append(",	A.RC_LDB_CAPA" ).append("\n"); 
		query.append(",	A.RC_LDB_HGT" ).append("\n"); 
		query.append(",	A.TNK_CAPA" ).append("\n"); 
		query.append(",	A.DIFF_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",   LTRIM(TO_CHAR(A.VNDR_SEQ,'000000')) AS VNDR_SEQ2" ).append("\n"); 
		query.append(",   MDM.VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM MST_CNTR_SPEC A, MDM_VENDOR MDM" ).append("\n"); 
		query.append("WHERE	A.CNTR_SPEC_NO = @[cntr_spec_no]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = MDM.VNDR_SEQ(+)" ).append("\n"); 

	}
}