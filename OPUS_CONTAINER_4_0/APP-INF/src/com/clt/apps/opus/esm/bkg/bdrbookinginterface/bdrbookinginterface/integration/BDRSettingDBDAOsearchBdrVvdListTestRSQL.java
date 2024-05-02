/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRSettingDBDAOsearchBdrVvdListTestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.11 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRSettingDBDAOsearchBdrVvdListTestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBdrVvdListTest
	  * </pre>
	  */
	public BDRSettingDBDAOsearchBdrVvdListTestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration").append("\n"); 
		query.append("FileName : BDRSettingDBDAOsearchBdrVvdListTestRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",UPD_CD" ).append("\n"); 
		query.append("FROM   (SELECT   A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",'' AS UPD_CD" ).append("\n"); 
		query.append("FROM     BKG_BOOKING A" ).append("\n"); 
		query.append(",BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE    A.BKG_CRE_DT > TO_DATE ('20091201', 'rrrrmmdd')" ).append("\n"); 
		query.append("AND      A.BKG_CRE_DT < TO_DATE ('20091202', 'rrrrmmdd')" ).append("\n"); 
		query.append("AND      A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND      A.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND      A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append(",2)" ).append("\n"); 
		query.append("WHERE  ROWNUM < 11" ).append("\n"); 

	}
}