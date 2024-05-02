/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryDBDAOSearchSpSvcCateCfmChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.23 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPServiceCategoryDBDAOSearchSpSvcCateCfmChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 저장전 저장할수 있는 데이터 인지 확인한다
	  * </pre>
	  */
	public SPServiceCategoryDBDAOSearchSpSvcCateCfmChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration").append("\n"); 
		query.append("FileName : SPServiceCategoryDBDAOSearchSpSvcCateCfmChkRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS ISFLAG FROM SPE_SP WHERE SP_SEQ = @[sp_seq]" ).append("\n"); 

	}
}