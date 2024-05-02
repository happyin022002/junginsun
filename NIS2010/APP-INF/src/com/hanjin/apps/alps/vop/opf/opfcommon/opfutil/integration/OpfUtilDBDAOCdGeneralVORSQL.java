/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilDBDAOCdGeneralVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.10.13 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOCdGeneralVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOCdGeneralVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration ").append("\n"); 
		query.append("FileName : OpfUtilDBDAOCdGeneralVORSQL").append("\n"); 
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
		query.append("SELECT   CODE, DESCRIPT" ).append("\n"); 
		query.append("FROM     CD_GENERAL" ).append("\n"); 
		query.append("where	CATEGORY = @[cm_code]" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 

	}
}