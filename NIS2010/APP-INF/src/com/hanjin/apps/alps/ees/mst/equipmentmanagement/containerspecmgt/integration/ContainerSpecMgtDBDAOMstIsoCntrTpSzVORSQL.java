/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstIsoCntrTpSzVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMstIsoCntrTpSzVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MstIsoCntrTpSzVO
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstIsoCntrTpSzVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstIsoCntrTpSzVORSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(MST_ISO_CNTR_TP_SZ XPKMST_ISO_CNTR_TP_SZ)*/ " ).append("\n"); 
		query.append("   ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ,ISO_CNTR_TPSZ_NM " ).append("\n"); 
		query.append("FROM MST_ISO_CNTR_TP_SZ" ).append("\n"); 

	}
}