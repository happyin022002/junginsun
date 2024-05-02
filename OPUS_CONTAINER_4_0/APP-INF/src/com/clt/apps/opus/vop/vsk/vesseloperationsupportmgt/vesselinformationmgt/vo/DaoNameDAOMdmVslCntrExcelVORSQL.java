/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOMdmVslCntrExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.25 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOMdmVslCntrExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public DaoNameDAOMdmVslCntrExcelVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("CNTR_VSL_CLSS_CAPA as name1" ).append("\n"); 
		query.append(",	RF_RCPT_KNT        as val1" ).append("\n"); 
		query.append(",	RF_RCPT_MAX_KNT    as name2" ).append("\n"); 
		query.append(",	FBD_CAPA           as val2" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE	VSL_CD = 'HJPA'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.opf.vesseloperationsupportmgt.vesselinformationmgt.vo ").append("\n"); 
		query.append("FileName : DaoNameDAOMdmVslCntrExcelVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}