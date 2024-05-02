/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSearchMdmLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSearchMdmLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmLocation
	  * 
	  * 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
	  *                                                           기존 변수 mapping 이 잘못된  java file 생성으로 수정
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSearchMdmLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSearchMdmLocationRSQL").append("\n"); 
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
		query.append("SELECT  EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD   = @[loc_cd]" ).append("\n"); 

	}
}