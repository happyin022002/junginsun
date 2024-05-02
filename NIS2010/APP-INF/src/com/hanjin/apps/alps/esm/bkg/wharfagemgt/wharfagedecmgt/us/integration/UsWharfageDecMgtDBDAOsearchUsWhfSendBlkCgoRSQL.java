/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.01 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendBlkCgo
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.PORT_CD" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",A.BB_CGO_SEQ" ).append("\n"); 
		query.append(",A.CMDT_DESC" ).append("\n"); 
		query.append(",A.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",A.RAT_AS_QTY" ).append("\n"); 
		query.append(",A.WHF_UT_PRC" ).append("\n"); 
		query.append(",TRUNC(A.RAT_AS_QTY * A.WHF_UT_PRC, 3) AS MAX_ROWS" ).append("\n"); 
		query.append("FROM  BKG_USA_WHF_BLK_CGO A" ).append("\n"); 
		query.append("WHERE  VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND  SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND  SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND  PORT_CD = @[port]" ).append("\n"); 
		query.append("AND  IO_BND_CD = @[bound]" ).append("\n"); 

	}
}