/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNoteListParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.07 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNoteListParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNoteListParmVO
	  * </pre>
	  */
	public DaoNameDAODemandNoteListParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNoteListParmVORSQL").append("\n"); 
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
		query.append("'' OFC_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' GRP_TYPE" ).append("\n"); 
		query.append(",'' CHG_TYPE" ).append("\n"); 
		query.append(",'' DAY_TYPE" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' COND_TYPE" ).append("\n"); 
		query.append(",'' FM_DT" ).append("\n"); 
		query.append(",'' TO_DT" ).append("\n"); 
		query.append(",'' LOC_TYPE" ).append("\n"); 
		query.append(",'' LOC_CD" ).append("\n"); 
		query.append(",'' YD_CD" ).append("\n"); 
		query.append(",'' YD_CD1" ).append("\n"); 
		query.append(",'' VVD_CD" ).append("\n"); 
		query.append(",'' PORT_CD" ).append("\n"); 
		query.append(",'' CHK_ALL_OFFICE" ).append("\n"); 
		query.append(",'' ALL_OFFICE" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CUST_TYPE" ).append("\n"); 
		query.append(",'' CUST_CD" ).append("\n"); 
		query.append(",'' SVC_PROVDR" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' RFA_NO" ).append("\n"); 
		query.append(",'' CRE_OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}