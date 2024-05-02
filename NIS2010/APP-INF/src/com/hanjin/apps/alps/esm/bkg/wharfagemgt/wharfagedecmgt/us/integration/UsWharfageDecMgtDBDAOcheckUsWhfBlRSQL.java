/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOcheckUsWhfBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.01.07 김민정
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

public class UsWharfageDecMgtDBDAOcheckUsWhfBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkUsWhfBl
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOcheckUsWhfBlRSQL(){
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
		query.append("FileName : UsWharfageDecMgtDBDAOcheckUsWhfBlRSQL").append("\n"); 
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
		query.append("SELECT  B.BL_NO" ).append("\n"); 
		query.append("FROM  BKG_USA_WHF_BL B" ).append("\n"); 
		query.append(",BKG_USA_WHF_CNTR C" ).append("\n"); 
		query.append("WHERE  B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND  B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  B.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("AND  B.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("AND  B.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND  B.VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("AND  B.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND  B.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND  B.PORT_CD = @[port]" ).append("\n"); 
		query.append("AND  B.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND  B.BL_NO > ' '" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 

	}
}