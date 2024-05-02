/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateDBDAOCheckExistVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jae Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VLVDDateUpdateDBDAOCheckExistVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL/VD DATE UPDATE 등록	
	  * UI_DMT_2012	
	  * VL/VD Date Update by VVD
	  * </pre>
	  */
	public VLVDDateUpdateDBDAOCheckExistVvdRSQL(){
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
		params.put("xMvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xPort",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration").append("\n"); 
		query.append("FileName : VLVDDateUpdateDBDAOCheckExistVvdRSQL").append("\n"); 
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
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_VSL_DT_UPD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     LOC_CD       = @[xPort]" ).append("\n"); 
		query.append("AND     VL_VD_DIV_CD = @[xMvmt]" ).append("\n"); 

	}
}