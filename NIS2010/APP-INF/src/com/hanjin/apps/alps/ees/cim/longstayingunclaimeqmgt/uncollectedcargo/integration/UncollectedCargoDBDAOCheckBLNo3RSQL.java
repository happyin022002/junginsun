/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UncollectedCargoDBDAOCheckBLNo3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOCheckBLNo3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL 중복 체크
	  * </pre>
	  */
	public UncollectedCargoDBDAOCheckBLNo3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration ").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOCheckBLNo3RSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(*),0,'Y','N') FLAG" ).append("\n"); 
		query.append("FROM	CIM_UC_CGO u," ).append("\n"); 
		query.append("		CIM_UC_CGO_DTL d" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("		AND u.uc_cs_no = d.uc_cs_no" ).append("\n"); 
		query.append("        AND d.bl_no = @[bl_no]" ).append("\n"); 
		query.append("        AND u.hndl_rhq_cd = @[hndl_rhq_cd]" ).append("\n"); 

	}
}