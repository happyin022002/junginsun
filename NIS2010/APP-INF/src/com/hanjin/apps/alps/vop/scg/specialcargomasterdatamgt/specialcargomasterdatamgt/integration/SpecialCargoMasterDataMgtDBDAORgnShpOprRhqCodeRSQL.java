/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAORgnShpOprRhqCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAORgnShpOprRhqCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO RSO - CREATION 에서 RgnShpOprRhqCode search
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAORgnShpOprRhqCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAORgnShpOprRhqCodeRSQL").append("\n"); 
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
		query.append("SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("FROM DMT_OFC_LVL_V " ).append("\n"); 
		query.append("WHERE OFC_KND_CD = 2 AND OFC_LVL = 3" ).append("\n"); 

	}
}