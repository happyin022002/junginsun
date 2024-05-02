/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilDBDAOVskVslPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.10.20 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOVskVslPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOVskVslPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOVskVslPortVORSQL").append("\n"); 
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
		query.append("SELECT	DECODE(A.SKD_CNG_STS_CD, 'S', NULL, A.VPS_PORT_CD) AS VPS_PORT_CD," ).append("\n"); 
		query.append("DECODE(A.SKD_CNG_STS_CD, 'S', NULL, B.LOC_NM) AS LOC_NM," ).append("\n"); 
		query.append("A.CLPT_SEQ" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	A.VPS_PORT_CD, A.SKD_VOY_NO, A.CLPT_SEQ, A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("WHERE	A.VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("AND     A.SKD_VOY_NO    =   @[skd_voy_no]" ).append("\n"); 
		query.append("AND     A.SKD_DIR_CD    =   @[skd_dir_cd]" ).append("\n"); 
		query.append(")	A				," ).append("\n"); 
		query.append("MDM_LOCATION	B" ).append("\n"); 
		query.append("WHERE	A.VPS_PORT_CD		=	B.LOC_CD" ).append("\n"); 
		query.append("ORDER   BY  CLPT_SEQ" ).append("\n"); 

	}
}