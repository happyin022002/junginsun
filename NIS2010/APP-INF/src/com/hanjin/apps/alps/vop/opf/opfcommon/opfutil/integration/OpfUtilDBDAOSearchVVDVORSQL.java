/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpfUtilDBDAOSearchVVDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.21 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchVVDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Search
	  * </pre>
	  */
	public OpfUtilDBDAOSearchVVDVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchVVDVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VS.VSL_CD" ).append("\n"); 
		query.append(", VS.SKD_VOY_NO" ).append("\n"); 
		query.append(", VS.SKD_DIR_CD" ).append("\n"); 
		query.append(", MC.VSL_ENG_NM" ).append("\n"); 
		query.append(", VS.VSL_SLAN_CD" ).append("\n"); 
		query.append(", ML.VSL_SLAN_NM" ).append("\n"); 
		query.append(", MC.CRR_CD VSL_OPR_TP_CD" ).append("\n"); 
		query.append(", VC.CRR_NM VSL_OPR_TP_NM" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD VS" ).append("\n"); 
		query.append(", MDM_VSL_CNTR MC" ).append("\n"); 
		query.append(", MDM_CARRIER VC" ).append("\n"); 
		query.append(", MDM_VSL_SVC_LANE ML" ).append("\n"); 
		query.append("WHERE VS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	VS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	VS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VS.VSL_CD = MC.VSL_CD" ).append("\n"); 
		query.append("AND MC.CRR_CD = VC.CRR_CD" ).append("\n"); 
		query.append("AND	VS.VSL_SLAN_CD = ML.VSL_SLAN_CD" ).append("\n"); 

	}
}