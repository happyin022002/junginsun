/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAOCreateNewAgmtTmpSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.05.07 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAOCreateNewAgmtTmpSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_AGMT_TMP_SEQ1 sequence조회
	  * </pre>
	  */
	public FuelScgManageDBDAOCreateNewAgmtTmpSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ").append("\n"); 
		query.append("FileName : FuelScgManageDBDAOCreateNewAgmtTmpSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_AGMT_TMP_SEQ1.NEXTVAL " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}