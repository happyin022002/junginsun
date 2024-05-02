/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL").append("\n"); 
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
		query.append("#if (${flag} == 'Y')" ).append("\n"); 
		query.append("	SELECT  C.CNTR_NO, C.BL_NO," ).append("\n"); 
		query.append("            (SELECT G.HNDL_BRNC_CD" ).append("\n"); 
		query.append("              FROM CIM_UC_CGO G" ).append("\n"); 
		query.append("              WHERE C.UC_CS_NO = G.UC_CS_NO" ).append("\n"); 
		query.append("            ) HNDL_BRNC_CD," ).append("\n"); 
		query.append("            (SELECT G.HNDL_HDLR_USR_ID" ).append("\n"); 
		query.append("              FROM CIM_UC_CGO G" ).append("\n"); 
		query.append("              WHERE C.UC_CS_NO = G.UC_CS_NO" ).append("\n"); 
		query.append("             ) HNDL_HDLR_USR_ID	" ).append("\n"); 
		query.append("	FROM	CIM_UC_CGO_CNTR C" ).append("\n"); 
		query.append("	WHERE	1 = 1" ).append("\n"); 
		query.append("	AND C.UC_CS_NO = @[uc_cs_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT  CNTR_NO, C.BL_NO," ).append("\n"); 
		query.append("            (SELECT G.HNDL_BRNC_CD" ).append("\n"); 
		query.append("              FROM CIM_UC_CGO G" ).append("\n"); 
		query.append("              WHERE C.UC_CS_NO = G.UC_CS_NO" ).append("\n"); 
		query.append("            ) HNDL_BRNC_CD," ).append("\n"); 
		query.append("            (SELECT G.HNDL_HDLR_USR_ID" ).append("\n"); 
		query.append("              FROM CIM_UC_CGO G" ).append("\n"); 
		query.append("              WHERE C.UC_CS_NO = G.UC_CS_NO" ).append("\n"); 
		query.append("             ) HNDL_HDLR_USR_ID	" ).append("\n"); 
		query.append("	FROM	CIM_UC_CGO_CNTR C" ).append("\n"); 
		query.append("	WHERE	1 = 1" ).append("\n"); 
		query.append("	AND C.UC_CS_NO = @[uc_cs_no]" ).append("\n"); 
		query.append("	AND C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}