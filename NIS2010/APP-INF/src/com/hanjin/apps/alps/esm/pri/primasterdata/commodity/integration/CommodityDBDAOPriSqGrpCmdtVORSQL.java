/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommodityDBDAOPriSqGrpCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.13 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOPriSqGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SQ_GRP_CMDT 테이블 조회
	  * </pre>
	  */
	public CommodityDBDAOPriSqGrpCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOPriSqGrpCmdtVORSQL").append("\n"); 
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
		query.append("SELECT A.GRP_CMDT_SEQ AS SEQ" ).append("\n"); 
		query.append(", A.PRC_GRP_CMDT_CD AS CD" ).append("\n"); 
		query.append(", A.PRC_GRP_CMDT_DESC AS NM" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_CMDT A" ).append("\n"); 
		query.append(", (SELECT QTTN_NO, QTTN_VER_NO, GRP_CMDT_SEQ" ).append("\n"); 
		query.append("FROM PRI_SQ_GRP_CMDT_DTL" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("GROUP BY QTTN_NO, QTTN_VER_NO, GRP_CMDT_SEQ) B" ).append("\n"); 
		query.append("WHERE A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("AND A.GRP_CMDT_SEQ = B.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("ORDER BY A.PRC_GRP_CMDT_CD ASC" ).append("\n"); 

	}
}