/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCheckVVDRSQL.java
*@FileTitle : Carrier Merger
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.11 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JOOFindCodeAndCheckDBDAOCheckVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckVVD
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCheckVVDRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("vsl_cd" ).append("\n"); 
		query.append(",	skd_voy_no" ).append("\n"); 
		query.append(",	skd_dir_cd" ).append("\n"); 
		query.append("FROM vsk_vsl_skd" ).append("\n"); 
		query.append("WHERE	vsl_cd = substr(@[code],1,4)" ).append("\n"); 
		query.append("AND	skd_voy_no = substr(@[code],5,4)" ).append("\n"); 
		query.append("AND	skd_dir_cd = substr(@[code],9,1)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.common.joofindcodeandcheck.integration ").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCheckVVDRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}