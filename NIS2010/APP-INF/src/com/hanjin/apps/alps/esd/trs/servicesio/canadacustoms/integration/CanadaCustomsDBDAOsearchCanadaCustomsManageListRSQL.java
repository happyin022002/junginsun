/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI_CND_CSTMS_IBD테이블에서 해당 blNo의 데이타가 있는지 여부를 조회한다.
	  * </pre>
	  */
	public CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration ").append("\n"); 
		query.append("FileName : CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(BL_NO) FROM EDI_CND_CSTMS_IBD" ).append("\n"); 
		query.append("WHERE 	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}