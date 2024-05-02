/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.11.05 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement 정보 CHECK 2
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eEqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT)*/" ).append("\n"); 
		query.append("DECODE(MVMT_STS_CD, 'ID', 'Y', 'MT', 'Y', 'OP', 'Y', 'OC', 'Y', MVMT_STS_CD) IS_CORRECT_MVMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[eEqNo]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}