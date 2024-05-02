/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfExceptCmdtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfExceptCmdtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfExceptCmdtList
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfExceptCmdtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfExceptCmdtListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	PORT_CD" ).append("\n"); 
		query.append(",	CMDT_SEQ" ).append("\n"); 
		query.append(",	KW_NM1" ).append("\n"); 
		query.append(",	KW_NM2" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_EXPT_CMDT" ).append("\n"); 
		query.append("WHERE	IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND		CMDT_DESC LIKE '%' || @[cmdt_desc] || '%'" ).append("\n"); 
		query.append("ORDER BY PORT_CD, CMDT_SEQ" ).append("\n"); 

	}
}