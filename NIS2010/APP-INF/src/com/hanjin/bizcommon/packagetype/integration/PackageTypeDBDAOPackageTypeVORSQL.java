/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PackageTypeDBDAOPackageTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.07.05 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.packagetype.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PackageTypeDBDAOPackageTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PackageTypeDAOPackageTypeVORSQL   
	  * </pre>
	  */
	public PackageTypeDBDAOPackageTypeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.packagetype.integration").append("\n"); 
		query.append("FileName : PackageTypeDBDAOPackageTypeVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("pck_cd," ).append("\n"); 
		query.append("pck_nm," ).append("\n"); 
		query.append("usa_cstms_pck_cd" ).append("\n"); 
		query.append("from mdm_pck_tp" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and   delt_flg <> 'Y' " ).append("\n"); 
		query.append("#if (${pck_cd} != '') " ).append("\n"); 
		query.append("and   pck_cd like @[pck_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pck_nm} != '') " ).append("\n"); 
		query.append("and   pck_nm like '%' || @[pck_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}