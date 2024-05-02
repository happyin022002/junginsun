/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TestDAOsqlTestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.rdweb.usingdo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TestDAOsqlTestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 테스트
	  * </pre>
	  */
	public TestDAOsqlTestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aaa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ccc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bbb",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.sample.rdweb.usingdo.integration").append("\n"); 
		query.append("FileName : TestDAOsqlTestCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ddd} != '') " ).append("\n"); 
		query.append("insert into Test (" ).append("\n"); 
		query.append("aaa," ).append("\n"); 
		query.append("bbb," ).append("\n"); 
		query.append("ccc" ).append("\n"); 
		query.append(")values (" ).append("\n"); 
		query.append("@[aaa]," ).append("\n"); 
		query.append("@[bbb]," ).append("\n"); 
		query.append("@[ccc]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("insert into Test1 (" ).append("\n"); 
		query.append("aaa," ).append("\n"); 
		query.append("bbb," ).append("\n"); 
		query.append("ccc" ).append("\n"); 
		query.append(")values (" ).append("\n"); 
		query.append("@[aaa]," ).append("\n"); 
		query.append("@[bbb]," ).append("\n"); 
		query.append("@[ccc]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}